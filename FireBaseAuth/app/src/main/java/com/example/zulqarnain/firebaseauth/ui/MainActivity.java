package com.example.zulqarnain.firebaseauth.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.zulqarnain.firebaseauth.Messege;
import com.example.zulqarnain.firebaseauth.R;
import com.example.zulqarnain.firebaseauth.ui.fragment.TaskFragent;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    final static String TAG = "log.tag.value";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_holder);


        if (fragment == null) {
            fragment = TaskFragent.newInstance();
            manager.beginTransaction()
                    .add(R.id.fragment_holder, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.logout_menu){
            Messege.messege(getBaseContext(),"Logout");
            if(FirebaseAuth.getInstance().getCurrentUser()!=null){
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
