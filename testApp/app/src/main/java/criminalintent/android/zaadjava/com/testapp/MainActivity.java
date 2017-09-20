package criminalintent.android.zaadjava.com.testapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    Button iButton;
    int counter = 0;
    private final String TAG = "Zee";
    private String KEY = "counter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.mbtn);
        iButton = (Button) findViewById(R.id.btnNextIntent);
        //mButton.setOnClickListener(new eventHandle()); //using inner class

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button clicked");
            }
        });

    }

    //using inner class
    /*class eventHandle implements View.OnClickListener {
        @Override
        public void onClick(View v){
            Log.d(TAG,"the button clicked!!!!");
        }
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        counter++;

    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt(KEY, counter);
        Log.d(TAG, counter + " was counter");
    }

    @Override
    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        counter = state.getInt(KEY);
        Log.d(TAG, counter + " counter was restore");
    }

    public void viewNextIntent(View v) {
       /* Intent i= new Intent(this,ActivityB.class);
        startActivity(i)*/
        //or can call intent this way
        Intent i = new Intent();
        i.setClassName("criminalintent.android.zaadjava.com.testapp", "criminalintent.android.zaadjava.com.testapp.ActivityB");
        startActivity(i);
    }


    ///----------intent tasks

    public void process(View v) {
        Intent intent = null, choser = null;
        if (v.getId() == R.id.lanchMap) {
            intent = new Intent(Intent.ACTION_VIEW);   //for viewing any contnent we use action view.
            intent.setData(Uri.parse("geo:19.076,72.8777"));    //setting up data for intent
            choser = Intent.createChooser(intent, "Lanch Map");   //to avoid error if the application is not found to view or multiple application can view it
            startActivity(choser);
            //startActivity(intent);
        }
        if (v.getId() == R.id.launchMarket) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=dophin.developers.com"));
            choser = Intent.createChooser(intent, "Lanch Market");
            startActivity(choser);
        }
        if (v.getId() == R.id.sendEmail) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String to[] = {"xlualy@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "this is test mail");
            intent.putExtra(Intent.EXTRA_TEXT, "this is test mail send by the android app");
            intent.setType("message/rfc822");
            choser = Intent.createChooser(intent, "Send Email");
            startActivity(choser);
        }
        if (v.getId() == R.id.sendImage) {
            Uri imageUri = Uri.parse("android.resource://criminalintent.android.zaadjava.com.testapp/mipmap-hdpi/" + R.mipmap.ic_launcher);
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            intent.putExtra(Intent.EXTRA_TEXT, "Image Attached");
            choser = Intent.createChooser(intent, "Send Image");
            startActivity(choser);

        }

    }

    public void showToast(View v) {
        L.showToast(this, "this is toast message");
    }
}
