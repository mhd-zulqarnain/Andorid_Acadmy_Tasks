package fahee.example.com.inovisionhome.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import fahee.example.com.inovisionhome.model.Contacts;
import fahee.example.com.inovisionhome.R;
import fahee.example.com.inovisionhome.adapter.ContactAdapter;

/**
 * Created by Zul Qarnain on 2/9/2018.
 */

public class ContactsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ContactAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.contacts_fragment_view, container, false);
        recyclerView = view.findViewById(R.id.rcyc_veiw);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ContactAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
//        recyclerView.addItemDecoration(new RecyclerDivider(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    }

    public ArrayList<Contacts> getData() {
        ArrayList<Contacts> data = new ArrayList<>();
        data.add(new Contacts("Giavani", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTgLImOojp-9Kmvz5MayQCFsZVH28KSHN71TS-qrUGpt4IvhNySg"));
        data.add(new Contacts("Noell", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTMpDT9G95muc3DnPjE3vTPpQvuZMypduGstKF_hOCmzR4W66ZdQ"));
        data.add(new Contacts("Bhaskar", "https://s3.amazonaws.com/typekit-production-public-assets/designers/profile_images/000/000/772/original/Octavio_Pardo_square.jpg?1507308137"));
        data.add(new Contacts("Dasard", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyKQkRReFVqahk6mrgKTGC8--6wHnpRVx72XjjtNTH0p_-xBeD"));
        data.add(new Contacts("VaDas", "https://i1.wp.com/centreforheritagestudies.com/wp-content/uploads/2015/02/formal-hairstyles-for-men.jpg?fit=473%2C700"));
        data.add(new Contacts("Vohitk", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLELhy05CQlu7lOk4IBeYxQh7j8Zbq-Iz0F3E5bTL2y_uW9e48"));

        return data;
    }
}