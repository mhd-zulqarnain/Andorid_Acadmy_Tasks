package zee.example.com.intprepapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        util.getResponse(new ServiceListener() {
            @Override
            public void success(Object obj) {
                Toast.makeText(getApplicationContext(),obj.toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void error(ServiceError serviceError) {
                Toast.makeText(getApplicationContext(),serviceError.toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
