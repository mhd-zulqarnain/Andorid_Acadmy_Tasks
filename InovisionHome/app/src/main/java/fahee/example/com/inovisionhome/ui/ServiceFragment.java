package fahee.example.com.inovisionhome.ui;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import fahee.example.com.inovisionhome.R;
import fahee.example.com.inovisionhome.adapter.ServiceAdapter;
import fahee.example.com.inovisionhome.util.Messege;

/**
 * Created by Zul Qarnain on 2/9/2018.
 */

public class ServiceFragment extends Fragment {

    private RecyclerView recyclerView;
    private ServiceAdapter adapter;
    DrawerLayout parentDrawer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.service_fragment_view,container,false);
        recyclerView = view.findViewById(R.id.rcyc_veiw);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter =new ServiceAdapter(getActivity(),getData());
        parentDrawer = getActivity().findViewById(R.id.drawerLayout);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        for(int i= 0; i<10;i++){
            data.add("Service"+i);
        }
        return data;
    }
}
