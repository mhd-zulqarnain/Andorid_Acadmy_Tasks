package chatkit.stfalcon.com.asyntaskapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import chatkit.stfalcon.com.asyntaskapp.model.Student;

/**
 * Created by Zul Qarnain on 12/26/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private ArrayList<Student> list = new ArrayList<>();
    private Context ctx;
    public StudentAdapter(Context ctx, ArrayList<Student> list){
        this.ctx=ctx;
        this.list=list;
    }
    @Override
    public StudentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_expandable_list_item_1,parent,false);
        MyViewHolder  holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(StudentAdapter.MyViewHolder holder, int position) {
        Student std= list.get(position);
        holder.tv.setText(std.getStName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView;
        }
    }
}
