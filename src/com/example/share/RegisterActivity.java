package com.example.share;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity
{
    private Button register;
    private EditText edit_email;
    private EditText edit_zhuceuser;
    private EditText edit_zhucepasseord;
    private String name;
    private String pass;
    private String email;

    Handler handler=new Handler()
    {
        public void handleMessage(android.os.Message msg)
        {
            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            DengluActivity.name=name;
            DengluActivity.pass=pass;
            finish();
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zhuce);
        edit_email=(EditText) findViewById(R.id.edit_email);
        edit_zhuceuser=(EditText) findViewById(R.id.edit_zhuceuser);
        edit_zhucepasseord=(EditText) findViewById(R.id.edit_zhucepassword);
        register=(Button) findViewById(R.id.register);
        register.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                email=edit_email.getText().toString();
                name=edit_zhuceuser.getText().toString();
                pass=edit_zhucepasseord.getText().toString();
                if(email.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                }
                else
                    if(name.equals(""))
                    {
                        Toast.makeText(RegisterActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    }
                    else
                        if(pass.equals(""))
                        {
                            Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            ProgressDialog progress=new ProgressDialog(RegisterActivity.this);
                            progress.setTitle("Share");
                            progress.setMessage("正在注册中...");
                            progress.show();
                            new Thread()
                            {
                                public void run()
                                {
                                    try
                                    {
                                        Thread.sleep(2000);
                                        handler.sendEmptyMessage(1001);
                                    }
                                    catch(InterruptedException e)
                                    {
                                        e.printStackTrace();
                                    }
                                    ;
                                }
                            }.start();
                        }

            }
        });

    }

}
