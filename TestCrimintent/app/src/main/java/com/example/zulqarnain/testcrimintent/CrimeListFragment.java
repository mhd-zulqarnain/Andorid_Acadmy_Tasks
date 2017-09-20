package com.example.zulqarnain.testcrimintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zul Qarnain on 8/3/2017.
 */

public class CrimeListFragment extends Fragment {


    RecyclerView mCrimeRecyclerView ;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment,container,false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.list_fragement);
        mCrimeRecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    public void updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes= crimeLab.getmCrimes();
        CrimeAdapter adapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(adapter);
    }
    public class CrimeHolder extends RecyclerView.ViewHolder {
        TextView mTitleTextView;

        public CrimeHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView;
        }
    }

    public class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        List<Crime> crimes;

        CrimeAdapter(List<Crime> crimes) {
            this.crimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(android.R.layout.simple_list_item_1, parent, false);
            CrimeHolder holder = new CrimeHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = crimes.get(position);
            holder.mTitleTextView.setText(crime.getmTitle());
        }

        @Override
        public int getItemCount() {
            return crimes.size();
        }
    }
}
