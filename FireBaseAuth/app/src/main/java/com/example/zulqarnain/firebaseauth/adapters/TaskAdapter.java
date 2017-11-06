package com.example.zulqarnain.firebaseauth.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.zulqarnain.firebaseauth.R;
import com.example.zulqarnain.firebaseauth.model.Task;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/26/2017.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private ArrayList<Task> list;
    private Context context;
    private DatabaseReference mDatabase;

    public TaskAdapter(Context context, ArrayList<Task> list,DatabaseReference mDatabase) {
        this.mDatabase=mDatabase;
        this.list = list;
        this.context = context;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.single_row_view, parent, false);
        TaskViewHolder holder = new TaskViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task std = list.get(position);
        holder.bindView(std);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private ImageButton rButton;
        private ImageView tImage;
        private Task mTsk;

        public TaskViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.std_name);
            rButton = itemView.findViewById(R.id.btn_dlt);
            rButton.setOnClickListener(this);
            tImage = itemView.findViewById(R.id.row_task_image);
        }

        public void bindView(Task tsk) {
            this.mTsk = tsk;
            name.setText(mTsk.getmTask());
            if(!mTsk.getImageUrl().equals("null")){
                Picasso.with(context).load(mTsk.getImageUrl()).fit().into(tImage);
            }
        }

        @Override
        public void onClick(View view) {
            String key = mTsk.getKey();
            mDatabase.child(key).removeValue();
        }
    }

}
