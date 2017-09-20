package zaadjava.com.jsoncrud1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private String localjsonString = "{\"country\":[{\"country_name\":\"country1\",\"capital\":\"capital1\"},{\"country_name\":\"country2\",\"capital\":\"capital2\"},{\"country_name\":\"country3\",\"capital\":\"capital3\"},"+
            "{\"country_name\":\"country4\",\"capital\":\"capital4\"},{\"country_name\":\"country5\",\"capital\":\"capital5\"},{\"country_name\":\"country6\",\"capital\":\"capital6\"},"+
            "{\"country_name\":\"country7\",\"capital\":\"capital7\"},{\"country_name\":\"country8\",\"capital\":\"capital8\"},{\"country_name\":\"country9\",\"capital\":\"capital9\"},"+
            "{\"country_name\":\"country10\",\"capital\":\"capital10\"}]}";

    private ListView listView;
    private String name;
    private int count=0;
    private String capital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.list);
        CustomerAdapter adapter = new CustomerAdapter(this,R.layout.single_view);
        listView.setAdapter(adapter);

        try{
            JSONObject jsonObject= new JSONObject(localjsonString);
            JSONArray jsonArray= jsonObject.getJSONArray("country");
            while (count<jsonArray.length()){
                JSONObject jo = jsonArray.getJSONObject(count);
                name=jo.getString("country_name");
                capital=jo.getString("capital");
                Country country=new Country(name,capital);
                adapter.add(country);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
