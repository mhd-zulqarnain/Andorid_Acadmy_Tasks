package zaadjava.com.todoadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zulup on 7/23/2017.
 */

class CustomAdapter extends ArrayAdapter {
    Context context;
    List<SingleRow> items;

    public CustomAdapter(Context context, List list) {
        super(context,0, list);
        this.context=context;
        this.items = list;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        view=inflater.inflate(R.layout.single_view,parent,false);

        TextView textView= (TextView) view.findViewById(R.id.textView);
        TextView description= (TextView) view.findViewById(R.id.textDescrption);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);

       SingleRow singleRow = items.get(position);
        textView.setText(singleRow.title);
        description.setText(singleRow.description);
        imageView.setImageResource(singleRow.imgID);

        return view;
    }

    public void addItems(String string){
        items.add(new SingleRow(string,"Default",R.drawable.meme3));
        notifyDataSetChanged();
    }
}