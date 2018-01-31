package com.example.zulup.onswipdelete.swip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.example.zulup.onswipdelete.R;
import com.example.zulup.onswipdelete.adapter.MovieAdapter;

/**
 * Created by zulup on 1/27/2018.
 */

public class SwipHelper extends ItemTouchHelper.SimpleCallback {
    MovieAdapter adapter;
    Context mContext;
    Bitmap icon ;
    public SwipHelper(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public SwipHelper(MovieAdapter adapter, Context mContext){
        super(ItemTouchHelper.UP |ItemTouchHelper.DOWN , ItemTouchHelper.RIGHT);
        this.adapter=adapter;
        this.mContext =mContext;
    }
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if(direction==ItemTouchHelper.LEFT)
        adapter.removeItem(viewHolder.getAdapterPosition());
        else{
            Toast.makeText(mContext,"Edit option not implemented yet",Toast.LENGTH_SHORT).show();
//            adapter.notifyItemChanged(viewHolder.getAdapterPosition());
        }
    }
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Paint p= new Paint();
      /*  View itemView  =viewHolder.itemView;
        float height = (float) itemView.getBottom() - (float) itemView.getTop();
        float width =height/3;

        if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
            if(dX > 0){
               p.setColor(Color.parseColor("#388E3C"));
                RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX,(float) itemView.getBottom());
                c.drawRect(background,p);
              icon = BitmapFactory.decodeResource(drawable);
                RectF icon_dest = new RectF((float) itemView.getLeft() + width ,(float) itemView.getTop() + width,(float) itemView.getLeft()+ 2*width,(float)itemView.getBottom() - width);
                c.drawBitmap(icon,null,icon_dest,p);

            }*/
        View itemView = viewHolder.itemView;
        float height = (float) itemView.getBottom() - (float) itemView.getTop();
        float width = height / 3;

        if(dX > 0){
            p.setColor(Color.parseColor("#388E3C"));
            RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX,(float) itemView.getBottom());
            c.drawRect(background,p);
            icon = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_delete_white);
            RectF icon_dest = new RectF((float) itemView.getLeft() + width ,(float) itemView.getTop() + width,(float) itemView.getLeft()+ 2*width,(float)itemView.getBottom() - width);
            c.drawBitmap(icon,null,icon_dest,p);
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }


}
