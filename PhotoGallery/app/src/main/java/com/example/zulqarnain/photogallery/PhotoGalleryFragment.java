package com.example.zulqarnain.photogallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Zul Qarnain on 12/21/2017.
 */

public class PhotoGalleryFragment extends Fragment {

    private RecyclerView recyclerView;

    public static PhotoGalleryFragment newInstance() {
        return new PhotoGalleryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.photo_gallery_fragment, container, false);
        recyclerView = v.findViewById(R.id.framgent_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        return v;
    }
}
