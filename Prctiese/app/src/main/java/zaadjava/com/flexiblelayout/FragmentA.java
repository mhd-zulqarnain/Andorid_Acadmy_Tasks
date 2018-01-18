package zaadjava.com.flexiblelayout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by zulup on 7/6/2017.
 */

public class FragmentA extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;
    Communicator commnnicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_a,container,false);

        return view;
    }

    public void setCommnnicator(Communicator commnnicator) {
        this.commnnicator = commnnicator;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) getActivity().findViewById(R.id.list);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),R.array.topic_heading,android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                commnnicator.respond(i);
    }
    interface Communicator{
        void respond(int index);
    }
}
