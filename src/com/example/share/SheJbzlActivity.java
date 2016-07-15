package com.example.share;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SheJbzlActivity extends Activity
{
    public ImageButton back;
    public ImageView nan;
    public ImageView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.she_jbzl);
        back=(ImageButton) findViewById(R.id.jbzl_back);
        nan=(ImageView) findViewById(R.id.jbzl_nan_img);
        nv=(ImageView) findViewById(R.id.jbzl_nv_img);

        back.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO 自动生成的方法存根
                finish();
            }
        });
        nan.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO 自动生成的方法存根
                int i=Integer.parseInt(v.getTag().toString());
                if(i == 1)
                {
                    nan.setBackgroundResource(R.drawable.nan1);
                    nan.setTag(0);
                    nv.setBackgroundResource(R.drawable.nv1);
                    nv.setTag(1);
                }
                if(i == 0)
                {
                    nan.setBackgroundResource(R.drawable.nan);
                    nan.setTag(1);
                    nv.setBackgroundResource(R.drawable.nv);
                    nv.setTag(0);
                }
            }
        });
        nv.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO 自动生成的方法存根
                int i=Integer.parseInt(v.getTag().toString());
                if(i == 1)
                {
                    nan.setBackgroundResource(R.drawable.nan);
                    nan.setTag(1);
                    nv.setBackgroundResource(R.drawable.nv);
                    nv.setTag(0);
                }
                if(i == 0)
                {
                    nan.setBackgroundResource(R.drawable.nan1);
                    nan.setTag(0);
                    nv.setBackgroundResource(R.drawable.nv1);
                    nv.setTag(1);
                }
            }
        });
    }

}
