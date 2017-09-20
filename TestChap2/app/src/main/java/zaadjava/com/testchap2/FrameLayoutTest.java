package zaadjava.com.testchap2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class FrameLayoutTest extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView1,imageView2;
    Bundle testButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout_test);
        imageView1=(ImageView)findViewById(R.id.imageView1);
        imageView2=(ImageView)findViewById(R.id.imageView2);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);

    }
        public void onClick(View v){
            if(v.getId()==R.id.imageView1){
                imageView1.setVisibility(View.GONE);
                imageView2.setVisibility(View.VISIBLE);
            }
            else {
                imageView2 .setVisibility(View.GONE);
                imageView1.setVisibility(View.VISIBLE);
            }
        }
}
