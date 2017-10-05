package com.example.zulqarnain.multiselectdemo;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener,ActionMode.Callback {

    RecyclerView recyclerView;
    ArrayList<Student> list;
    android.view.ActionMode actionMode;
    StudentAdapter adapter;
    GestureDetectorCompat gestureDetector;
    private final static String TAG="testing multiselect";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
//        list= new ArrayList<>();
        dataInsertion();
        gestureDetector =
                new GestureDetectorCompat(this, new RecyclerViewDemoOnGestureListener());



    }

    private void dataInsertion() {
       list =new RecyclerViewDemoApp().getDemoData();
        adapter = new StudentAdapter(list);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.d(TAG, "onItemClick position: " + position);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Log.d(TAG, "onItemLongClick pos = " +position);
                if (actionMode != null) {
                    return;
                }
                // Start the CAB using the ActionMode.Callback defined above
                actionMode = startActionMode((android.view.ActionMode.Callback) MainActivity.this);
                myToggleSelection(position);

                Log.d("tesr", "onLongPress: pressed");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_item,menu);
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
        String title = getString(0, adapter.getSelectedItemCount());
        actionMode.setTitle(title);
    }

    /*----------------------OnItemTouchListener--------------------------*/

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        gestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    /*----------------------Action back--------------------------*/

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = actionMode.getMenuInflater();
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
    }



    /*------------Gesture----------------*/
private class RecyclerViewDemoOnGestureListener extends GestureDetector.SimpleOnGestureListener {
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
        return super.onSingleTapConfirmed(e);
    }

    public void onLongPress(MotionEvent e) {
        View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (actionMode != null) {
            return;
        }
        // Start the CAB using the ActionMode.Callback defined above
        actionMode = startActionMode((android.view.ActionMode.Callback) getApplicationContext());
        int idx = recyclerView.getChildPosition(view);
        myToggleSelection(idx);
        Log.d("tesr", "onLongPress: pressed");
        super.onLongPress(e);
    }
}
}
