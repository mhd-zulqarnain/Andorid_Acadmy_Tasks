package com.example.zulqarnain.todo.adapters;

import com.example.zulqarnain.todo.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.zulqarnain.todo.model.Student;
import com.example.zulqarnain.todo.ui.StudentFragent;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/26/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StdViewHolder>{
    private ArrayList<Student> list;
    private Context context;
    private AdapterCallBack callback;
    private DatabaseReference mDatabase;

    public StudentAdapter(Context context, ArrayList<Student> list){

        this.list=list;
        this.context=context;
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }
    @Override
    public StdViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).
               inflate(R.layout.single_row_view,parent,false);
        StdViewHolder holder = new StdViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(StdViewHolder holder, int position) {
        Student std = list.get(position);
        holder.bindView(std);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setAdapterCallback(StudentFragent callback){
        this.callback=callback;
    }

    public class StdViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private Button rButton;
        private View itemView;
        private Student mStd;

        public StdViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.std_name);
            rButton=itemView.findViewById(R.id.btn_dlt);
            rButton.setOnClickListener(this);
        }

        public void bindView(Student std) {
            this.mStd=std;
            name.setText(mStd.getStdname());
        }

        @Override
        public void onClick(View view) {
            String key= mStd.getKey();
            callback.methodcallback(key);

        /*    FirebaseDatabase.getInstance().getReference("student")
                    .child(key)
                    .removeValue();
            Log.d("holder", "onClicked: "+mStd.getKey());*/
//            mDatabase.getParent().child(key).removeValue();
//            mDatabase.child(mStd.getKey()).setValue("");
        }
    }

}
