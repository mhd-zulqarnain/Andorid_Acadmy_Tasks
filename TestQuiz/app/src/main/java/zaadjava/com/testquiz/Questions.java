package zaadjava.com.testquiz;

/**
 * Created by zulup on 7/24/2017.
 */

public class Questions {
    int mQuestion;
    boolean mAns;

    public Questions(int mQuestion, boolean mAns) {
        this.mQuestion = mQuestion;
        this.mAns = mAns;
    }

    public int getmQuestion() {
        return mQuestion;
    }

    public boolean ismAns() {
        return mAns;
    }
}
