package zaadjava.com.jsoncrud1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zulup on 6/24/2017.
 */

public class CustomerAdapter extends ArrayAdapter{
    List list = new ArrayList();
    public CustomerAdapter(Context c,int resources) {
    super(c,resources);
    }

    @Override
    public void add(Object o){
        list.add(o);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View ConvertView, ViewGroup viewGroup) {
        View row=ConvertView;
        Viewholder viewholder;
        if(row==null){
            LayoutInflater inflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_view,viewGroup);
            viewholder = new Viewholder();
            viewholder.tx_capital.setText();
            row.setTag("country");

        }
        else {
            Viewholder viewholder = (Viewholder) row.getTag();

        }
        return null;
    }
    static class Viewholder{
        TextView tx_capital,tx_name;
    }
}
