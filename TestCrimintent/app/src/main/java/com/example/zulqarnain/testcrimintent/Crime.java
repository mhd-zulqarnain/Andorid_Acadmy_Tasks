package com.example.zulqarnain.testcrimintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Zul Qarnain on 8/3/2017.
 */

public class Crime {
    private UUID mCid;
    private Date mDate;
    private String mTitle;
    private Boolean mSolved;

    public Crime(){
        mDate = new Date();
        mCid = UUID.randomUUID();
    }

    public UUID getmCid() {
        return mCid;
    }

    public Date getDate() {
        return mDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Boolean getmSolved() {
        return mSolved;
    }

    public void setSolved(Boolean mSolved) {
        this.mSolved = mSolved;
    }
}
