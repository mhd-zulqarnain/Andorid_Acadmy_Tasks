package zaadjava.com.flexiblelayout;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentA.Communicator{
    FragmentManager manager;
    FragmentA fragmentA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getFragmentManager();
        fragmentA=(FragmentA)manager.findFragmentById(R.id.fragment1);
        fragmentA.setCommnnicator(this);

    }

    @Override
    public void respond(int index) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentById(R.id.fragment2);
        if(fragmentB!=null && fragmentB.isVisible()){
            fragmentB.change(index);
        }
        else {
            Intent intent = new Intent( this , AnotherActivity.class);
            intent.putExtra("KEY",index);
            startActivity(intent);
        }
    }
}
