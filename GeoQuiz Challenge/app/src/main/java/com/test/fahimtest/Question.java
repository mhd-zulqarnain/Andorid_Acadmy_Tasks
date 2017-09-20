package com.test.fahimtest;

/**
 * Created by zulup on 3/20/2017.
 */

public class Question {


    private int mTextid;
    private boolean mAnswerTrue;

    public Question(int textId,boolean answerTrue){
        mTextid=textId;
        mAnswerTrue=answerTrue;

    }

    public void setmTextid(int mTextid) {
        this.mTextid = mTextid;
    }

    public int getmTextid() {

        return mTextid;
    }

    public boolean getmAnswerTrue() {

        return mAnswerTrue;
    }

}
