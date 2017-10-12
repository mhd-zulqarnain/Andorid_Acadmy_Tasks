package com.test.fahimtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="QUIZ_ACTIVITY";
    private static final String KEY_INDEX="index";
    private Button mtrueBtn;
    private Button mCheatbtn;
    private Button mfalseBtn;
    private ImageButton mNextBtn;
    private ImageButton mPrevBtn;
    private TextView qView;
    private Question[] mQusestonBank= new Question[]{
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true),

    };
    private int mCurrentIndex = 0;
    private static final int REQUEST_CODE_CHAT=0;
    private static final String CHEAT_STATUS="index";
    private boolean isCheater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main);
        if(savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX,0);
           isCheater=savedInstanceState.getBoolean(CHEAT_STATUS,false);

        }

        mtrueBtn= (Button)findViewById(R.id.btntrue);
        mfalseBtn= (Button)findViewById(R.id.btnfalse);
        mNextBtn = (ImageButton)findViewById(R.id.btnNext);
        mPrevBtn = (ImageButton)findViewById(R.id.btnPrev);
        mCheatbtn=(Button)findViewById(R.id.btnCheat);

        qView=(TextView)findViewById(R.id.tv);


        mtrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mfalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mPrevBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mCurrentIndex>0)
                    mCurrentIndex=(mCurrentIndex-1)%mQusestonBank.length;
                updateQuestion();
            }
        });
        mNextBtn.setOnClickListener( new View.OnClickListener(){
           @Override
            public void onClick(View v){
               mCurrentIndex=(mCurrentIndex+1)%mQusestonBank.length;
               updateQuestion();
           }
        });

        ///---new Intent call------------------///
        mCheatbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    boolean answerIsTrue=mQusestonBank[mCurrentIndex].getmAnswerTrue();
                    Intent i=CheatActivity.newIntent(MainActivity.this,answerIsTrue);
//                    startActivity(i);
                    startActivityForResult(i,REQUEST_CODE_CHAT);
            }
        });

        updateQuestion();

    }
   //Answer checking entered by user-------
    public void checkAnswer(boolean userInput){

        boolean answerIrue=mQusestonBank[mCurrentIndex].getmAnswerTrue();
        int messegeId=0;
        if(isCheater){
            messegeId=R.string.judgment_toast;
        }
        else {
            if(userInput==answerIrue){
                messegeId=R.string.toast_true;
            }
            else {
                messegeId=R.string.toast_false;
            }
           }
        Toast.makeText(this,messegeId,Toast.LENGTH_SHORT).show();


    }
    public void updateQuestion(){
        int question=mQusestonBank[mCurrentIndex].getmTextid();
        qView.setText(question);
    }

    @Override
    public void onSaveInstanceState( Bundle saveInstance){
        super.onSaveInstanceState(saveInstance);
        Log.i(TAG,"saveInstance");

        saveInstance.putInt(KEY_INDEX,mCurrentIndex);
        saveInstance.putBoolean(KEY_INDEX,isCheater);  //to save cheat status if user rotate screen
    }


//    -----------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(TAG,"On create called");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onActivityResult(int requestcode,int resultCode,Intent data){
        if(resultCode!= Activity.RESULT_OK){
            return;
        }
        if(resultCode==Activity.RESULT_OK){
            if(data==null)
                return;
            isCheater= CheatActivity.wasAnswerShown(data);
        }
    }
}
