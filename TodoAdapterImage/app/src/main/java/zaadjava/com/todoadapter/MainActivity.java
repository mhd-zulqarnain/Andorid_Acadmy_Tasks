package zaadjava.com.todoadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<SingleRow> list;
    EditText editText;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<SingleRow>();
        list.add(new SingleRow("Title 1","Description 1",R.drawable.meme3));

        listView =(ListView)findViewById(R.id.list_item);
        editText= (EditText) findViewById(R.id.newEntry);
        adapter = new CustomAdapter(this,list);
        listView.setAdapter(adapter);


/*        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    if(!editText.getText().equals(null)){
                        adapter.addItems(editText.getText().toString());
                        handled = true;
                    }
                    handled = true;
                }
                return handled;
            }
        })*/;

    }

    void submitData(View view){
        String sSubmit = editText.getText().toString();
        if(!sSubmit.matches("")) {
           adapter.addItems(editText.getText().toString());
            editText.setText("");
        }else
            Toast.makeText(this, "You entered nothing", Toast.LENGTH_SHORT).show();
    }


}
