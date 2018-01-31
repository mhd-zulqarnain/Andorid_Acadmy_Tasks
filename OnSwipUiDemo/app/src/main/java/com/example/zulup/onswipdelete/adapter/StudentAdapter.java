package com.example.zulup.onswipdelete.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.example.zulup.onswipdelete.R;
import com.example.zulup.onswipdelete.model.Student;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by Zul Qarnain on 1/31/2018.
 */

public class StudentAdapter extends RecyclerSwipeAdapter<StudentAdapter.SwipViewHolder> {


    private ArrayList<Student> stuList;
    public Context mContext;
    final android.os.Handler handler = new android.os.Handler();

    public StudentAdapter(ArrayList<Student> stuList, Context mContext) {
        this.stuList = stuList;
        this.mContext = mContext;
    }


    @Override
    public SwipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_row_item, parent, false);
        return new SwipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SwipViewHolder viewHolder, final int position) {
        Student student = stuList.get(position);
        viewHolder.mstd.setText(student.getName());

        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
        //left
//        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Left,viewHolder.swipeLayout.findViewById(R.id.view_right_left));
        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Right, viewHolder.swipeLayout.findViewById(R.id.view_left_right));

        viewHolder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mContext, "post deleted ", Toast.LENGTH_SHORT).show();
                    removeRow(position);
                    }
                };
                handler.postDelayed(runnable, 3000);


            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });


        viewHolder.mdlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked on Delete ", Toast.LENGTH_SHORT).show();
                viewHolder.swipeLayout.close();

            }
        });
      /*  viewHolder.mUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked on undo " , Toast.LENGTH_SHORT).show();

            }
        });
        viewHolder.mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked on edit ", Toast.LENGTH_SHORT).show();

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return stuList.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swip_view;
    }

    public void removeRow(int position) {
        stuList.remove(position);
        notifyItemRemoved(position+1);
    }

    public class SwipViewHolder extends RecyclerView.ViewHolder {
        TextView mdlt, mUndo, mEdit, mstd;
        SwipeLayout swipeLayout;

        public SwipViewHolder(View itemView) {
            super(itemView);
            mdlt = itemView.findViewById(R.id.t_dlt);
           /* mUndo = itemView.findViewById(R.id.t_undo);
            mEdit = itemView.findViewById(R.id.t_edit);*/
            mstd = itemView.findViewById(R.id.std_name);
            swipeLayout = itemView.findViewById(R.id.swip_view);

        }
    }
}
