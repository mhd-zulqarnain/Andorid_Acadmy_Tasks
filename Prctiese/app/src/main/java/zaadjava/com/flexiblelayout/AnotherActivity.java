package zaadjava.com.flexiblelayout;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends Activity {
    private static final String keyIndex="KEY";
    int index=0;
    TextView textDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);
        Intent intent = getIntent();
        if(intent != null){
            index=intent.getIntExtra(keyIndex,0);
        }
        Resources rsc = getResources();
        String[] descripion = rsc.getStringArray(R.array.topic_description);
        textDescription= (TextView) findViewById(R.id.textDescription);
        textDescription.setText(descripion[index]);
    }
}
