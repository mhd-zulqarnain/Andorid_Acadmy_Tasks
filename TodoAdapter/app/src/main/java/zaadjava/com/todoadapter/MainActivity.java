package zaadjava.com.todoadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> list;
    EditText editText;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<String>();
        list.add("first item");
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.list_item);
        editText= (EditText) findViewById(R.id.newEntry);
        adapter = new CustomAdapter(this,list);
        listView.setAdapter(adapter);

    }

    void submitData(View view){
        if(!editText.getText().equals(null)){
           adapter.addItems(editText.getText().toString());
        }
    }


}
