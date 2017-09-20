package com.testtode.workoutdice;

/**
 * Created by zulup on 3/21/2017.
 */

public class Question {
    int questionId;
    boolean answerTrue;

    public Question(int questionId,boolean answerTrue){
        this.answerTrue=answerTrue;
        this.questionId=questionId;
    }


    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }
}
