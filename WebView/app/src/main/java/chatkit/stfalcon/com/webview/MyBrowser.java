package chatkit.stfalcon.com.webview;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Zul Qarnain on 12/28/2017.
 */

public class MyBrowser extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//        view.loadUrl();
        return super.shouldOverrideUrlLoading(view, request);

    }
}
