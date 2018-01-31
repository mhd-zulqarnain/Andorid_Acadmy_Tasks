package fahee.example.com.visionapi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Uri uriFilePath;
    private TextView tv;
    private ProgressBar progressBar;
    private final int CAMREQ = 100;
    private final String API_BASE_URL = "https://vision.googleapis.com/v1/images:annotate?key=AIzaSyCjccL_7ff4DX6leI7cRC2c6fkzZcuaItg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.take_pic);
        tv = findViewById(R.id.txt_response);
        progressBar = findViewById(R.id.progress_bar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePic();
                progressBar.setVisibility(View.VISIBLE);
                tv.setVisibility(View.GONE);
            }
        });
    }

    public void postVision(String base64) {
        JSONObject rootObject = new JSONObject();

        JSONArray reqArray = new JSONArray();
        JSONObject reqObject = new JSONObject();
        try {
            JSONObject imageContentObject = new JSONObject();
            imageContentObject.put("content", base64);

            JSONArray featureArray = new JSONArray();
            JSONObject feature = new JSONObject();
            feature.put("type", "TEXT_DETECTION");
            featureArray.put(feature);

            reqObject.put("image", imageContentObject);
            reqObject.put("features", featureArray);

            reqArray.put(reqObject);
            rootObject.put("requests", reqArray);
            Log.d("", "postVision: " + rootObject);
            PostTask task = new PostTask();
            task.execute(rootObject);

        } catch (Exception e) {
            Log.d("", "postVision: exception" + e);
        }

    }


    private void takePic() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File mainDir = new File(Environment.getExternalStorageDirectory(), "Visionapp/temp");
        if (!mainDir.exists()) {
            mainDir.mkdir();
        }

        Calendar calendar = Calendar.getInstance();
        uriFilePath = Uri.fromFile(new File(mainDir, "IMG_" + calendar.getTimeInMillis()));
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriFilePath);
        startActivityForResult(intent, CAMREQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == CAMREQ) {
                String filePath = uriFilePath.getPath();
                try {
                    postVision(encodeToBase64(filePath));
                } catch (Exception e) {
                    Log.d("", "onActivityResult: " + e);
                }

            }
        }
    }

    public String encodeToBase64(String uri) {
        Bitmap bitmap = BitmapFactory.decodeFile(uri);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

    public class PostTask extends AsyncTask<JSONObject, Void, JSONObject> {


        @Override
        protected JSONObject doInBackground(JSONObject... jsonObjects) {
            JSONObject response = post(API_BASE_URL, jsonObjects[0]);
            try {
                return response;
            } catch (Exception e) {
                Log.d("", "doInBackground: exception" + e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            tv.setVisibility(View.VISIBLE);
            try {
                progressBar.setVisibility(View.GONE);

                Log.d("", "onPostExecute: " + jsonObject);
                JSONArray responses = jsonObject.getJSONArray("responses");
                JSONObject firstObject = responses.getJSONObject(0);

                JSONArray textAnnotationsArray = firstObject.getJSONArray("textAnnotations");
                JSONObject secondObject = textAnnotationsArray.getJSONObject(0);

                String responseText = secondObject.getString("description");
                tv.setText(responseText);
            } catch (Exception e) {
                tv.setText(e.getMessage());
            }

        }

        public JSONObject post(String url, JSONObject jsonObjects) {
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            OkHttpClient client = new OkHttpClient();

            try {
                RequestBody body = RequestBody.create(JSON, jsonObjects.toString());
                okhttp3.Request request = new okhttp3.Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                okhttp3.Response response = client.newCall(request).execute();
                JSONObject json = new JSONObject(response.body().string());
                return json;
            } catch (JSONException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }
    }

}
