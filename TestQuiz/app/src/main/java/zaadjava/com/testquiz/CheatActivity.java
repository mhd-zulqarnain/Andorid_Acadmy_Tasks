package zaadjava.com.testquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    boolean mAnwser;
    TextView mCheat;
    Button bShow;

    private static final String EXTRA_ANSWER_SHOWN = "com.vivz.show_answer";
    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.answer_is_true";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnwser = this.getIntent().getBooleanExtra("Key_Ans", false);
        bShow = (Button) findViewById(R.id.bShowAnswer);
        mCheat = (TextView) findViewById(R.id.tCheat);


        bShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnwser) {
                    mCheat.setText("Anwer is true");
                } else
                    mCheat.setText("Answer is false");

                setExtraAnswerShown(true);
            }

        });
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);

    }

    public void setExtraAnswerShown(Boolean isShow) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isShow);
        setResult(RESULT_OK, data);
    }


}
