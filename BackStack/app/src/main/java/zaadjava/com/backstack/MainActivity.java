package zaadjava.com.backstack;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    FragmentManager manager;
    TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        status = (TextView) findViewById(R.id.textStatus);
        manager.addOnBackStackChangedListener(this);

    }
    public void addB(View v){
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.add(R.id.group, fragmentB, "B");
        transaction.addToBackStack( "addB");
        transaction.commit();

    }
    public void addA(View v){
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.add(R.id.group, fragmentA, "A");
        transaction.addToBackStack( "addA");
        transaction.commit();
    }

    public void removeA(View v){
        FragmentA fragmentA= (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction  = manager.beginTransaction();
        if(fragmentA!=null){
            transaction.remove(fragmentA);
            transaction.addToBackStack("removeA");
            transaction.commit();
        }
        else {
            Toast.makeText(this,"Make sure fragemnt A is inserted",Toast.LENGTH_LONG).show();
        }

    }
    public void removeB(View v){
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("B");
        FragmentTransaction transaction = manager.beginTransaction();
        if(transaction != null){
            transaction.remove(fragmentB);
            transaction.addToBackStack("removeB");
            transaction.commit();
        }else
            Toast.makeText(this,"Make sure the fragnent is added ",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackStackChanged() {

        status.setText(status.getText()+"\n");
        status.setText(status.getText()+"The current status of back stack");
        int size = manager.getBackStackEntryCount();
        for(int i=size-1 ; i>=0;i--){
            FragmentManager.BackStackEntry entry=manager.getBackStackEntryAt(i);

            status.setText(status.getText()+" "+ entry.getName()+"\n");
        }
        status.setText(status.getText()+"\n");


    }
}
