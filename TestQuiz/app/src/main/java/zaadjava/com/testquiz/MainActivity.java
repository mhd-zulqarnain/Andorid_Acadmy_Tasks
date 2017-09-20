package zaadjava.com.testquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView mQuestion;
    Button mTrue, mFalse, mCheat;
    ImageButton mNext, mPrev;
    Boolean doCheat = false;
    final String EXTRA_ANSWER_SHOWN = "com.vivz.show_answer";
    final String KEY_SAVEDINSTANCE = "savedistance";

    final int TRACK_CHEAT_CODE = 1;
    Questions[] questionBank = new Questions[]{
            new Questions(R.string.question_africa, true),
            new Questions(R.string.question_americas, false),
            new Questions(R.string.question_asia, true),
            new Questions(R.string.question_mideast, true),
            new Questions(R.string.question_oceans, false),

    };

    int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt(KEY_SAVEDINSTANCE, 0);
        }
        mQuestion = (TextView) findViewById(R.id.tQuestion);
        mTrue = (Button) findViewById(R.id.bTrue);
        mFalse = (Button) findViewById(R.id.bFalse);
        mCheat = (Button) findViewById(R.id.bCheat);

        mPrev = (ImageButton) findViewById(R.id.bPrevious);
        mNext = (ImageButton) findViewById(R.id.bNext);

        mTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        mFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = (mIndex + 1) % questionBank.length;
                update();

            }
        });
        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIndex > 0)
                    mIndex = (mIndex - 1) % questionBank.length;
                update();
            }
        });

        mCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CheatActivity.class);
                intent.putExtra("Key_Ans", questionBank[mIndex].ismAns());
                startActivityForResult(intent, TRACK_CHEAT_CODE);

            }
        });
    }

    public void update() {
        mQuestion.setText(questionBank[mIndex].getmQuestion());
        doCheat=false;
    }

    public void checkAnswer(boolean mIsTrue) {
        Boolean nAnswer = questionBank[mIndex].ismAns();
        String message=null;

        if (doCheat) {
            message = "Cheating is wrong";

        } else {

            if (nAnswer == mIsTrue) {

            } else
                message = "Wrong Answer";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSaveInstanceState(Bundle saved) {
        super.onSaveInstanceState(saved);
        saved.putInt(KEY_SAVEDINSTANCE, mIndex);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {  //i.e it will be RESULT.CANCELED which means their is no rolling back or back button pressed
            return;
        }

        if (requestCode == TRACK_CHEAT_CODE) {

            if (resultCode == RESULT_OK) {
                if (data == null) return;
                doCheat = data.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
            }
        }

    }
}
