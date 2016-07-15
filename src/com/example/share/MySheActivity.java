package com.example.share;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MySheActivity extends Activity implements OnClickListener
{
    public RelativeLayout jibenziliao;
    public RelativeLayout xiugaimima;
    public RelativeLayout xiaoxishezhi;
    public RelativeLayout guanyu;
    public RelativeLayout huancun;
    public ImageButton back;
    ProgressDialog pro;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shezhi_main);

        findViews();
    };

    public void findViews()
    {
        jibenziliao=(RelativeLayout) findViewById(R.id.shezhi_jibenzl);
        xiugaimima=(RelativeLayout) findViewById(R.id.shezhi_xiugaimm);
        xiaoxishezhi=(RelativeLayout) findViewById(R.id.shezhi_infoshezhi);
        guanyu=(RelativeLayout) findViewById(R.id.shezhi_guanyu);
        huancun=(RelativeLayout) findViewById(R.id.shezhi_qingchu);
        back=(ImageButton) findViewById(R.id.shezhi_back);

        back.setOnClickListener(this);
        jibenziliao.setOnClickListener(this);
        xiugaimima.setOnClickListener(this);
        xiaoxishezhi.setOnClickListener(this);
        guanyu.setOnClickListener(this);
        huancun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        // TODO 自动生成的方法存根
        Intent intent=new Intent();
        switch(v.getId())
        {
            case R.id.shezhi_jibenzl:
                intent.setClass(MySheActivity.this, SheJbzlActivity.class);
                startActivity(intent);
                break;
            case R.id.shezhi_xiugaimm:
                intent.setClass(MySheActivity.this, SheChangeActivity.class);
                startActivity(intent);
                break;
            case R.id.shezhi_infoshezhi:
                intent.setClass(MySheActivity.this, SheInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.shezhi_guanyu:
                break;
            case R.id.shezhi_qingchu:

                pro=new ProgressDialog(MySheActivity.this);
                pro.setTitle("SHARE");
                pro.setMessage("清除缓存中...");
                pro.show();
                new Handler().postDelayed(new Runnable()
                {

                    @Override
                    public void run()
                    {
                        // TODO 自动生成的方法存根
                        pro.dismiss();
                        Toast.makeText(MySheActivity.this, "缓存已清除", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
                break;
            case R.id.shezhi_back:
                finish();
                break;

        }
    }

}
