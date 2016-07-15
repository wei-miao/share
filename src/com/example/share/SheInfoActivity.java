package com.example.share;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class SheInfoActivity extends Activity
{
    public ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO �Զ����ɵķ������
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.she_info);
        back=(ImageButton) findViewById(R.id.info1_back);
        back.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO �Զ����ɵķ������
                finish();
            }
        });
    }

    public void imgonClick(View v)
    {
        // TODO �Զ����ɵķ������
        int tag=Integer.parseInt(v.getTag().toString());
        if(tag == 0)
        {
            v.setBackgroundResource(R.drawable.xiaoxi_pressed);
            v.setTag("1");
        }
        else
            if(tag == 1)
            {
                v.setBackgroundResource(R.drawable.xiaoxi_normal);
                v.setTag("0");
            }
    }

}
