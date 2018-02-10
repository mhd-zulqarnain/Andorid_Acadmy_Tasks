package fahee.example.com.inovisionhome.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fahee.example.com.inovisionhome.R;
import fahee.example.com.inovisionhome.ServiceFragment;

public class HomeActivity extends AppCompatActivity {
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fm = getSupportFragmentManager();
        ServiceFragment fragment = new ServiceFragment();
        fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
    }

}
