package fahee.example.com.inovisionhome.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import fahee.example.com.inovisionhome.R;
import fahee.example.com.inovisionhome.ServiceFragment;

public class HomeActivity extends AppCompatActivity {
    FragmentManager fm;
    DrawerLayout drawerLayout;
    ListView listView;
    String days[];
    Button btnHideDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        days = getResources().getStringArray(R.array.items);
        listView = (ListView) findViewById(R.id.list);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        btnHideDrawer  =findViewById(R.id.btn_close);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        listView.setAdapter(adapter);

        fm = getSupportFragmentManager();
        ServiceFragment fragment = new ServiceFragment();
        fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        btnHideDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
    }

}
