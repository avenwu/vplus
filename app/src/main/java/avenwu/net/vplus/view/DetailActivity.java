package avenwu.net.vplus.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import avenwu.net.vplus.R;
import avenwu.net.vplus.utils.ToolKit;

public class DetailActivity extends AppCompatActivity {
    public static final String VIDEO_TITLE = "video_title";
    public static final String VIDEO_ID = "video_id";
    WebView mWebView;
    String videoId;
    String videoTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        videoTitle = getIntent().getStringExtra(VIDEO_TITLE);
        videoId = getIntent().getStringExtra(VIDEO_ID);
        setTitle(videoTitle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mWebView = (WebView) findViewById(R.id.webview);
        if (!TextUtils.isEmpty(videoId)) {
            mWebView.loadUrl(getVideoUrl(videoId));
        }
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {

                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && url.startsWith(ToolKit.CUSTOM_SCHEME)) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    private String getVideoUrl(String id) {
        return String.format("http://www.vmovier.com/%s?qingapp=app_h5", id);
    }

    public static void launch(Context context, String title, String id) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(VIDEO_TITLE, title);
        intent.putExtra(VIDEO_ID, id);
        context.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
