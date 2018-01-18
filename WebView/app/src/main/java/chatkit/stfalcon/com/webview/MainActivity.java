package chatkit.stfalcon.com.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import org.xwalk.core.XWalkView;

public class MainActivity extends AppCompatActivity {
    private WebView wv;
    private XWalkView mXWalkView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String url= "file:///android_asset/www1/index.html";

        mXWalkView = (XWalkView) findViewById(R.id.activity_main);
        mXWalkView.load("file:///android_asset/www/index.html", null);

        /*wv = (WebView) findViewById(R.id.web_view);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);*/

    }
}
