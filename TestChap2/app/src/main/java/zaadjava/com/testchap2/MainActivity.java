package zaadjava.com.testchap2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher{
    Button nxtActivity;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nxtActivity=(Button)findViewById(R.id.nxtActivity);
        editText=(EditText)findViewById(R.id.editText);
        editText.addTextChangedListener(this);
        /*nxtActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent();
                i.setClassName("zaadjava.com.testchap2.MainActivity","zaadjava.com.testchap2.FrameTest");  //***it breaks  the app
                startActivity(i);

            }
        });*/
    }
    public void viewNxt(View v){
        Intent i= new Intent(this,FrameLayoutTest.class);
        startActivity(i);
    }
//**********for validating edit text*********
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Toast.makeText(this,"Before text change",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Toast.makeText(this,"On change text",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable editable) {
        try {

            int no = Integer.parseInt(editable.toString());
            if (no > 100) {
                editable.replace(0, editable.length(), "100");
            }
        }catch (NumberFormatException e)
        {}
    }
}
