package com.example.zulqarnain.multiselectdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ActionMode.Callback {

    RecyclerView recyclerView;
    ArrayList<Student> list;
    ActionMode actionMode;
    StudentAdapter adapter;
    private final static String TAG="testing multiselect";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        dataInsertion();


    }
    private void dataInsertion() {
       list =new RecyclerViewDemoApp().getDemoData();
        adapter = new StudentAdapter(list);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.d(TAG, "onItemClick position: " + position);
                myToggleSelection(position);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Log.d(TAG, "onItemLongClick pos = " +position);

                myToggleSelection(position);
                Toast.makeText(v.getContext(),"long pressed",Toast.LENGTH_LONG).show();
                Log.d("tesr", "onLongPress: pressed");
                if (actionMode != null) {
                    return;
                }
                // Start the CAB using the ActionMode.Callback defined above
                actionMode = startSupportActionMode(MainActivity.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.menu.menu_item){
            removeItemFromList();
        }
        return true;
    }
    public void removeItemFromList(){
        int position=((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        RecyclerViewDemoApp.removeItemFromList(position);
        adapter.removeData(position);

    }

    private void myToggleSelection(int idx) {
        adapter.toggleSelection(idx);
        /*String title = getString(0, adapter.getSelectedItemCount());
        actionMode.setTitle(title);*/
    }


    /*----------------------Action back--------------------------*/

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        Log.d("tesr", "action mode: pressed");

        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.acton_delete:
                ArrayList<Integer> selectedItemPositions = adapter.getSelectedItem();
                Log.d(TAG, "onActionItemClicked: delete option "+selectedItemPositions.size());
                int currPos;
                for (int i = selectedItemPositions.size() - 1; i >= 0; i--) {
                    currPos = selectedItemPositions.get(i);
                    RecyclerViewDemoApp.removeItemFromList(currPos);
                    adapter.removeData(currPos);
                }
                actionMode.finish();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

        invalidateOptionsMenu();
        adapter.clearSelections();
    }




}
