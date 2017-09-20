package com.test.fahimtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mtrueBtn;
    private  static final String TAG="QuizActivity";
    private static final String KEY_INDEX="index";
    private static final int REQUEST_CODE_CHEAT = 0;
  //Navigation Stuff
    private Button      mfalseBtn;
    private ImageButton mNextBtn;
    private ImageButton mPrevBtn;
    private Button      mCheatBtn;
    private TextView qView;

    //Bussiness layer stuff
    private boolean mIsCheater;

    private Question[] mQusestonBank= new Question[]{
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true),

    };
    private int mCurrentIndex = 0;

  //----------------On create------------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX,0);
        }
        mtrueBtn= (Button)findViewById(R.id.btntrue);
        mfalseBtn= (Button)findViewById(R.id.btnfalse);
        mNextBtn = (ImageButton)findViewById(R.id.btnNext);
        mPrevBtn=(ImageButton)findViewById(R.id.btnPrev);
        mCheatBtn=(Button)findViewById(R.id.btnCheat);

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
        qView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex=(mCurrentIndex+1)%mQusestonBank.length;
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
        mPrevBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mCurrentIndex>0)
                    mCurrentIndex=(mCurrentIndex-1)%mQusestonBank.length;
                updateQuestion();
            }
        });
        mCheatBtn.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
//               Intent i= new Intent(MainActivity.this,CheatActivity.class);
               boolean ansIsTrue=mQusestonBank[mCurrentIndex].getmAnswerTrue();
               Intent i= CheatActivity.newIntent(MainActivity.this,ansIsTrue);
               //startActivity(i);
               startActivityForResult(i,REQUEST_CODE_CHEAT);
           }
        });
        updateQuestion();

    }

//=----------------- ON saveInstance overload keep track if app destroy
    @Override
    public void onSaveInstanceState( Bundle savedInstance){
        super.onSaveInstanceState(savedInstance);
        Log.i(TAG,"saveInstance");
        savedInstance.putInt(KEY_INDEX,mCurrentIndex);

    }
    //-------------------Answer checking entered by user-------
    public void checkAnswer(boolean userInput){

        boolean answerIrue=mQusestonBank[mCurrentIndex].getmAnswerTrue();
        int messegeId=0;
        if(mIsCheater){
            messegeId=R.string.judgment_toast;
        }
        else{
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
//        Log.d(TAG,"updating the index for question no"+mCurrentIndex,new Exception());
    }

//it called when the user press the back button from one of its child
    @Override
    public void onActivityResult(int requestCode,int resultCode ,Intent data){
       if(resultCode != Activity.RESULT_OK){  //i.e it will be RESULT.CANCELED which means their is no rolling back or back button pressed
            return;
       }
        if(requestCode==REQUEST_CODE_CHEAT){

            if(data==null)
                return;
            mIsCheater=CheatActivity.wasAnswerShown(data);
        }
    }

//-------------------------------for debugging -------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume() called");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop() called");

    } @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "Start() called");

    } @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause() called");

    }
    @Override
    public void onDestroy(){
    super.onDestroy();
    Log.d(TAG, "onDestroy() called");

}

}
