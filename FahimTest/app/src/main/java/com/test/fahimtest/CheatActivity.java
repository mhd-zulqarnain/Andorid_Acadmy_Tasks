package com.test.fahimtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANS="com.quizcheat.isAnswerTrue";
    private static final String EXTRA_ANSWER_SHOWN="com.example.answer_is_shown";
    private static final String TAG="Cheat Activity";
    private boolean mAnswerIsTrue;
    private Button mShowAnswer;
    private TextView mAnswerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue=getIntent().getBooleanExtra(EXTRA_ANS,false);
        mAnswerView=(TextView)findViewById(R.id.answer_text_view);
        mShowAnswer=(Button)findViewById(R.id.show_ans_btn);
        mShowAnswer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mAnswerIsTrue){
                    mAnswerView.setText(R.string.true_btn);
                }else
                    mAnswerView.setText(R.string.false_btn);
                setExtraAnswerShown(true);
            }
        });

    }
    public static Intent newIntent(Context pkgContent,boolean answerTrue){
        Intent i= new Intent(pkgContent,CheatActivity.class);
        i.putExtra(EXTRA_ANS,answerTrue);
        return i;
    }
    public void setExtraAnswerShown( boolean isAnswerShown){ //////perdefined function
        Intent data= new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }
    public static boolean wasAnswerShown(Intent res){
        return res.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG," onPause() called");
    }

}
