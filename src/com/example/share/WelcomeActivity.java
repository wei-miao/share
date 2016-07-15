package com.example.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WelcomeActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(1500);
                    Intent intent=new Intent(getApplicationContext(), DengluActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }.start();

    }

}
