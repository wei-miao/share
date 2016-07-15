package com.example.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MyInfoActivity extends Activity
{
    RelativeLayout sixin;
    RelativeLayout newguanzhu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_info);
        ImageButton back=(ImageButton) findViewById(R.id.info_back);
        sixin=(RelativeLayout) findViewById(R.id.info_sixin);
        newguanzhu=(RelativeLayout) findViewById(R.id.info_newguanzhu);

        newguanzhu.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                // TODO 自动生成的方法存根
                Intent intent=new Intent();
                intent.setClass(getApplicationContext(), NewGuanActivity.class);
                startActivity(intent);
            }
        });

        sixin.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                // TODO 自动生成的方法存根
                Intent intent=new Intent();
                intent.setClass(getApplicationContext(), SiXinActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                // TODO 自动生成的方法存根
                finish();
            }
        });
    }

}
