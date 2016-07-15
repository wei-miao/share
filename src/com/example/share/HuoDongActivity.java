package com.example.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class HuoDongActivity extends Activity
{
    ImageView back;
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_main);

        Intent intent=getIntent();
        String str=intent.getStringExtra("huodong");
        wb=(WebView) findViewById(R.id.webview);
        back=(ImageView) findViewById(R.id.huodong_back);
        back.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                // TODO 自动生成的方法存根
                finish();
            }
        });
        wb.loadUrl(str);
        wb.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                // TODO 自动生成的方法存根
                view.loadUrl(url);
                return true;
            }
        });

        WebSettings settings=wb.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // TODO 自动生成的方法存根
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // TODO 自动生成的方法存根
        int id=item.getItemId();
        if(id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
