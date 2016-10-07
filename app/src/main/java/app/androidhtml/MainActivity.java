package app.androidhtml;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends JavascriptActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/index.html");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

            }

            @Override
            public void onPageFinished(WebView view, String url) {

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
        WebSettings settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(context, "android");
    }

    @Override
    public void onBackPressed() {
        /*if (webView.canGoBack()) {
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }*/

        String function = "window.onBackPressed";
        webView.loadUrl("javascript:" + function + " && " + function + "();");
    }
}
