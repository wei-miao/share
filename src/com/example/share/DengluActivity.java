package com.example.share;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DengluActivity extends Activity
{
    public static String name="share";
    public static String pass="123456";
    private EditText edit_user;
    private EditText edit_password;
    private Button zhuce_button;
    private Button denglu_button;
    ProgressDialog pro;

    Handler handler=new Handler()
    {
        public void handleMessage(android.os.Message msg)
        {
            if(msg.what == 100)
            {
                pro.dismiss();
                Toast.makeText(DengluActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(DengluActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);

        edit_user=(EditText) findViewById(R.id.edit_user);
        edit_password=(EditText) findViewById(R.id.edit_password);
        zhuce_button=(Button) findViewById(R.id.zhuce_button);
        denglu_button=(Button) findViewById(R.id.denglu_button);
        denglu_button.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                if(edit_user.getText().toString().equals(""))
                {
                    Toast.makeText(DengluActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                }
                else
                    if(edit_password.getText().toString().equals(""))
                    {
                        Toast.makeText(DengluActivity.this, "密码不能为空", Toast.LENGTH_SHORT);
                    }
                    else
                        if(edit_user.getText().toString().equals(name) && edit_password.getText().toString().equals(pass))
                        {
                            pro=new ProgressDialog(DengluActivity.this);
                            pro.setTitle("Tip");
                            pro.setMessage("正在登录中...");
                            pro.show();
                            new Thread()
                            {
                                @Override
                                public void run()
                                {
                                    try
                                    {
                                        Thread.sleep(1500);
                                        handler.sendEmptyMessage(100);
                                    }
                                    catch(InterruptedException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                            }.start();
                        }
                        else
                        {
                            Toast.makeText(DengluActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                        }
            }
        });
        zhuce_button.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                Intent ient=new Intent(DengluActivity.this, RegisterActivity.class);
                startActivity(ient);
            }
        });
    }
}