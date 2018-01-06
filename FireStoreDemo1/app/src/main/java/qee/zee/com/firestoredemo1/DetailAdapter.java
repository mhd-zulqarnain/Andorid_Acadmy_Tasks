package qee.zee.com.firestoredemo1;

import android.content.Context;
import android.icu.lang.UScript;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import qee.zee.com.firestoredemo1.model.Users;

/**
 * Created by Zul Qarnain on 1/3/2018.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder> {
    private Context ctx;
    private ArrayList<Users> list;
    public DetailAdapter(Context ctx, ArrayList<Users> list){
        this.ctx=ctx;
        this.list=list;
    }
    @Override
    public DetailAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        MyViewHolder holder   = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(DetailAdapter.MyViewHolder holder, int position) {
        Users users = list.get(position);
        holder.bindView(users);
        holder.tv.setText(users.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv;
        private Users user;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView;
            tv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(ctx,"id is"+user.userId,Toast.LENGTH_SHORT).show();
        }

        public void bindView(Users users) {
            this.user=users;
        }
    }
}
