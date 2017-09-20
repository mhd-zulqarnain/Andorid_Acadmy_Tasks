package com.testtode.workoutdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView question_view;
    private Button mtrue,mfalse,mNxt;
    Question[] mQuestionBank= new Question[]{
            new Question(R.string.qestion_war,false),
            new Question(R.string.qestion_capital,true)
    };
    int mCuurent=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfalse=(Button)findViewById(R.id.btnFalse);
        mtrue=(Button)findViewById(R.id.btnTrue);
        mNxt=(Button)findViewById(R.id.btnnxt);
        question_view=(TextView)findViewById(R.id.question_view);

        mNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCuurent=(mCuurent+1)%mQuestionBank.length;
               update();
            }
        });
        mfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickChecker(false);
            }
        });
        mtrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickChecker(true);
            }
        });
        update();
    }

    public void clickChecker(boolean userInput){

        boolean answerTrue=mQuestionBank[mCuurent].isAnswerTrue();
        if(userInput==answerTrue){
            Toast.makeText(this,R.string.toast_true,Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this,R.string.toast_false,Toast.LENGTH_SHORT).show();

    }

    public void update(){
        int question=mQuestionBank[mCuurent].getQuestionId();
        question_view.setText(question);
    }
}
