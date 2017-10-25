package com.example.zulqarnain.firebaseupload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Zul Qarnain on 10/22/2017.
 */

public class MyDialogFragment extends DialogFragment {

    private final static String VIEW_KEY="elementView";
    public static DialogFragment newIntance(int viewKey){
        Bundle args =  new Bundle();
        args.putInt(VIEW_KEY,viewKey);
        MyDialogFragment fragment = new MyDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        Bundle bundle = getArguments();
        int key = bundle.getInt(VIEW_KEY);
        Messege.messege(getContext(),key+" value key");
        view = inflater.inflate(R.layout.my_fragement_dialog,container);
        getDialog().setTitle("My fragment view");
        return view;

    }
}
