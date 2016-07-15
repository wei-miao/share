package com.example.share;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SheChangeActivity extends Activity implements OnClickListener
{

    public ImageButton back;
    public Button tijiao;
    public EditText oldmm;
    public EditText newmm;
    public EditText newmm1;
    public ProgressDialog pro;
    public String oldStr;
    public String newStr;
    public String new1Str;

    Handler handler=new Handler()
    {
        public void handleMessage(android.os.Message msg)
        {
            pro.dismiss();
            Toast.makeText(SheChangeActivity.this, "�����޸ĳɹ�", Toast.LENGTH_SHORT).show();
            finish();
        };
    };

    protected void onCreate(android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.she_changemm);
        pro=new ProgressDialog(SheChangeActivity.this);
        pro.setTitle("SHARE");
        pro.setMessage("�����޸���...");
        findViews();
    };

    public void findViews()
    {
        back=(ImageButton) findViewById(R.id.gai_back);
        oldmm=(EditText) findViewById(R.id.gai_oldmm);
        newmm=(EditText) findViewById(R.id.gai_newmm);
        newmm1=(EditText) findViewById(R.id.gai_okmm);
        tijiao=(Button) findViewById(R.id.gai_tijiao_bt);
        back.setOnClickListener(this);
        tijiao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        // TODO �Զ����ɵķ������
        switch(v.getId())
        {
            case R.id.gai_back:
                finish();
                break;
            case R.id.gai_tijiao_bt:
                if(!check())
                {
                    return;
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(SheChangeActivity.this).setTitle("Tip").setMessage("ȷ���޸�?").setPositiveButton("ȷ��", new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int arg0)
                    {
                        // TODO �Զ����ɵķ������
                        pro.show();
                        new Thread()
                        {
                            public void run()
                            {
                                try
                                {
                                    Thread.sleep(2000);
                                    handler.sendEmptyMessage(100);
                                }
                                catch(Exception e)
                                {
                                    // TODO: handle exception
                                    e.printStackTrace();
                                }
                            };
                        }.start();
                        dialog.dismiss();
                    }

                }).setNegativeButton("ȡ��", new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int arg1)
                    {
                        // TODO �Զ����ɵķ������
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                break;
        }
    }

    public boolean check()
    {
        oldStr=oldmm.getText().toString();
        newStr=newmm.getText().toString();
        new1Str=newmm1.getText().toString();
        if(oldStr.equals("") || oldStr == null)
        {
            Toast.makeText(SheChangeActivity.this, "�����벻��Ϊ��", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            if(newStr.equals("") || newStr == null)
            {
                Toast.makeText(SheChangeActivity.this, "�����벻��Ϊ��", Toast.LENGTH_SHORT).show();
                return false;
            }
            else
                if(new1Str.equals("") || new1Str == null)
                {
                    Toast.makeText(SheChangeActivity.this, "���ٴ���������", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else
                    if(!oldStr.equals(DengluActivity.pass))
                    {
                        Toast.makeText(SheChangeActivity.this, "�����벻��ȷ", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                    else
                        if(!newStr.equals(new1Str))
                        {
                            Toast.makeText(SheChangeActivity.this, "���������벻һ��", Toast.LENGTH_SHORT).show();
                            return false;
                        }
        return true;

    }
}
