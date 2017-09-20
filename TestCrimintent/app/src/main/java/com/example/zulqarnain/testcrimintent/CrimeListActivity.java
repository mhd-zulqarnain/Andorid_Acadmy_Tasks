package com.example.zulqarnain.testcrimintent;

import android.support.v4.app.Fragment;

/**
 * Created by Zul Qarnain on 8/3/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new CrimeListFragment();
    }
}
