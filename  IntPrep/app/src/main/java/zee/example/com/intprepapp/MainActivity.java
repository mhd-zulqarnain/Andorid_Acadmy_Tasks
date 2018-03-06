package zee.example.com.intprepapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Sqlitehelper sqlitehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlitehelper= new Sqlitehelper(this);

        /*util.getResponse(new ServiceListener() {
            @Override
            public void success(Object obj) {
                Toast.makeText(getApplicationContext(),obj.toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void error(ServiceError serviceError) {
                Toast.makeText(getApplicationContext(),serviceError.toString(),Toast.LENGTH_SHORT).show();

            }
        });*/
        Sqlitehelper sqlitehelper = new Sqlitehelper(this);

    }
    public void createDb(View v){
        long l= sqlitehelper.insertData("Test","Sd");
        Toast.makeText(getApplicationContext(),"response"+l,Toast.LENGTH_SHORT).show();
    }
}
