package zaadjava.com.flexiblelayout;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by zulup on 7/6/2017.
 */

public class FragmentB extends Fragment  {
    ListView listView;
    TextView text_desciption;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_b,container,false);
        text_desciption= (TextView) getActivity().findViewById(R.id.textDescription);
        return view;
    }

    public void change(int index){
        Resources rsc=getResources();
        String[] des=rsc.getStringArray(R.array.topic_description);
        text_desciption.setText(des[index]);
    }


}
