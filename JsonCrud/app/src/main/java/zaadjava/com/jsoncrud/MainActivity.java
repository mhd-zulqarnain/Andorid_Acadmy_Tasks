package zaadjava.com.jsoncrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        private String localjsonString = "{\"country\":[{\"country_name\":\"country1\",\"capital\":\"capital1\"},{\"country_name\":\"country2\",\"capital\":\"capital2\"},{\"country_name\":\"country3\",\"capital\":\"capital3\"},"+
                "{\"country_name\":\"country4\",\"capital\":\"capital4\"},{\"country_name\":\"country5\",\"capital\":\"capital5\"},{\"country_name\":\"country6\",\"capital\":\"capital6\"},"+
                "{\"country_name\":\"country7\",\"capital\":\"capital7\"},{\"country_name\":\"country8\",\"capital\":\"capital8\"},{\"country_name\":\"country9\",\"capital\":\"capital9\"},"+
                "{\"country_name\":\"country10\",\"capital\":\"capital10\"}]}";
    private ListView listView;
    String name,capital;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        CustomerAdapter adapter= new CustomerAdapter(this, R.layout.single_row_layout);
        listView.setAdapter(adapter);
        try {
            JSONObject jsonObject=new JSONObject(localjsonString);
            JSONArray jsonArray =jsonObject.getJSONArray("country");
            int count=0;
            while (count<jsonArray.length()){
                JSONObject jo= jsonArray.getJSONObject(count);
                name=jo.getString("country_name");
                capital=jo.getString("capital");
                Country country=new Country(name,capital);
                adapter.add(country);
                count++;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
