package zaadjava.com.jsoncrud;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by zulup on 6/23/2017.
 */

public class CustomerAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public CustomerAdapter(Context context, int resource) {
        super(context, resource);

    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        Contactholder contactholder ;
        Country country = (Country) list.get(i);
        if(row == null){
            LayoutInflater inflater= (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.single_row_layout,viewGroup,false);
           contactholder = new Contactholder();
            contactholder.tx_capital= (TextView)row.findViewById(R.id.countryCapital);
            contactholder.tx_name=(TextView)row.findViewById(R.id.countryName);
            row.setTag(contactholder);
        }
        else {
            contactholder = (Contactholder) row.getTag();
        }

        contactholder.tx_name.setText(country.getCountryName());
        contactholder.tx_capital.setText(country.getCountryCapital());

        return row;
    }
    static class Contactholder{
        TextView tx_capital,tx_name;
    }
}
