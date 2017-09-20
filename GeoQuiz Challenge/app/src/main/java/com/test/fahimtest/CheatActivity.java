package com.test.fahimtest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.*;
import android.os.Build;
import android.support.annotation.BoolRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE="com.example.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN="com.example.answer_is_shown";
    private static final String CHEAT_TRACK="index";
    private boolean mAnswerIsTrue;
    private Button mShowAnswer;
    private TextView mAnswerView;
    private TextView mVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue=getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        mAnswerView=(TextView)findViewById(R.id.answer_text_view);

        mShowAnswer=(Button)findViewById(R.id.show_ans_btn);
        mVersion=(TextView)findViewById(R.id.mVersion);
        mVersion.setText("API level "+Build.VERSION.SDK_INT);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if(mAnswerIsTrue){
                    mAnswerView.setText(R.string.true_btn);
                }else
                    mAnswerView.setText(R.string.false_btn);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP )
        {
                int cx=mShowAnswer.getWidth();
                int cy=mShowAnswer.getHeight();
                float radius=mShowAnswer.getWidth();
                setAnswerShownResult(true);
            final Animator anim= ViewAnimationUtils.createCircularReveal(mShowAnswer,cx,cy,radius,0);
                anim.addListener(new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        mAnswerView.setVisibility(View.VISIBLE);
                        mShowAnswer.setVisibility(View.VISIBLE);

                    }
                });
                anim.start();
        }else {
            mAnswerView.setVisibility(View.VISIBLE);
            mShowAnswer.setVisibility(View.VISIBLE);
        }

            }
        });


    }
    public static Intent newIntent(Context pkgContent, boolean answerIsTrue){
        Intent i= new Intent(pkgContent,CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return i;
    }
    public void setAnswerShownResult(Boolean isAnswerShown){
        Intent data= new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown); /////Setting the response for parent if the user press back button
        setResult(RESULT_OK,data);
    }
    ////--------------DECODING THE CHLID COLD IF USER PRESSED BACK FORM THE CHILD
    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);

    }
    ///---------------CODE TO AVOID LOST OF ANSWER WHEN SCREEN ROTATES--------
    @Override
    public void onSaveInstanceState( Bundle saveInstance){
        super.onSaveInstanceState(saveInstance);
        Log.i("Messege","SaveInstance called of cheat activity");
        saveInstance.putBoolean(CHEAT_TRACK,mAnswerIsTrue);
    }
}
