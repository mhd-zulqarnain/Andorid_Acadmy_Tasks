package criminalintent.android.zaadjava.com.testapp;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by zulup on 6/1/2017.
 */

public class CustomCodedLayout extends Activity {
    Button btnClick;
    TextView textView;
    LinearLayout ll;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ll= new LinearLayout(this);
        btnClick= new Button(this);
        textView= new TextView(this);

        LinearLayout.LayoutParams dimensions= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(dimensions);

        LinearLayout.LayoutParams viewDimensions= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(viewDimensions);
        btnClick.setLayoutParams(viewDimensions);

        textView.setText("Hello!");
        btnClick.setText("Click");

        ll.addView(textView);
        ll.addView(btnClick);
        setContentView(ll);



//        setContentView();
    }
}
