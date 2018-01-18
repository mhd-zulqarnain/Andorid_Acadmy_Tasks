package com.example.zulqarnain.todo.adapters;

import com.example.zulqarnain.todo.R;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zulqarnain.todo.model.Task;
import com.example.zulqarnain.todo.ui.TaskFragent;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        private View itemView;
        private Task mTsk;

        public TaskViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.std_name);
            rButton = itemView.findViewById(R.id.btn_dlt);
            rButton.setOnClickListener(this);
        }

        public void bindView(Task tsk) {
            this.mTsk = tsk;
            name.setText(mTsk.getmTask());
        }

        @Override
        public void onClick(View view) {
            String key = mTsk.getKey();
            mDatabase.child(key).removeValue();
        }
    }

}
