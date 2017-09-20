package com.example.zulqarnain.testcrimintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Zul Qarnain on 8/3/2017.
 */

public class CrimeLab {
    private List<Crime> mCrimes;

    public static CrimeLab mCrimeLab;

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<Crime>();
        for (int i=0 ; i<100; i++){
            Crime crime= new Crime();
            crime.setmTitle("Crime "+ i);
            crime.setSolved(i%2==0);
            mCrimes.add(crime);
        }
    }

    public static CrimeLab get(Context context) {
        if (mCrimeLab == null) {
            return mCrimeLab = new CrimeLab(context);
        }
        else
            return mCrimeLab;
    }

    public List<Crime> getmCrimes(){

        return mCrimes;
    }
    public Crime getCrime(UUID index){
        for(Crime crime : mCrimes){
            if(crime.getmCid()==index)
                return crime;
        }
        return null;
    }

}
