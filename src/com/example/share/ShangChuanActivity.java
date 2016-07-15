package com.example.share;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class ShangChuanActivity extends Activity implements OnClickListener
{
    public ImageView sc_photo;
    public Button bt_choose;
    public ImageButton back;
    public Button bt_location;
    public Button bt_fabu;
    public PopupMenu pm_xuanze=null;
    public ProgressDialog progress;
    Handler handler=new Handler()
    {
        public void handleMessage(android.os.Message msg)
        {
            if(msg.what == 100)
            {
                progress.dismiss();
                Toast.makeText(ShangChuanActivity.this, "上传成功", Toast.LENGTH_SHORT).show();
                finish();
            }
            if(msg.what == 200)
            {
                bt_location.setText("陕西 西安");
            }
        };
    };

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shangchuan);

        sc_photo=(ImageView) findViewById(R.id.shang_photo);
        back=(ImageButton) findViewById(R.id.upload_back);
        bt_choose=(Button) findViewById(R.id.shang_xuanze);
        bt_fabu=(Button) findViewById(R.id.shang_fabubt);
        bt_location=(Button) findViewById(R.id.shang_location);

        initPopupMenu();

        sc_photo.setOnClickListener(this);
        back.setOnClickListener(this);
        bt_choose.setOnClickListener(this);
        bt_location.setOnClickListener(this);
        bt_fabu.setOnClickListener(this);

        handler.sendEmptyMessageDelayed(200, 2000);
    };

    public void shangOnclick(View v)
    {
        // TODO 自动生成的方法存根
        if(Integer.parseInt(v.getTag().toString()) == 0)
        {
            v.setBackgroundResource(R.drawable.yinying);
            v.setTag("1");
            ((Button) v).setTextColor(Color.WHITE);
        }
        else
        {
            v.setBackgroundResource(R.drawable.yinying);
            v.setTag("0");
            ((Button) v).setTextColor(Color.BLACK);
        }
    }

    public void searchOnClick(View v)
    {
        if(Integer.parseInt(v.getTag().toString()) == 0)
        {
            v.setBackgroundResource(R.drawable.yinying2);
            v.setTag("1");
            ((Button) v).setTextColor(Color.WHITE);
        }
        else
        {
            v.setBackgroundResource(R.drawable.yinying);
            v.setTag("0");
            ((Button) v).setTextColor(Color.BLACK);
        }
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.shang_photo:
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 11111);
                break;
            case R.id.upload_back:
                finish();
                break;
            case R.id.shang_xuanze:
                bt_choose.setBackgroundResource(R.drawable.shang_xuanze_press);
                pm_xuanze.show();
                break;
            case R.id.shang_fabubt:
                AlertDialog.Builder builder=new AlertDialog.Builder(ShangChuanActivity.this).setTitle("提示").setMessage("是否确认发布？").setPositiveButton("确认", new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1)
                    {
                        // TODO 自动生成的方法存根
                        arg0.dismiss();
                        progress=new ProgressDialog(ShangChuanActivity.this);
                        progress.setTitle("提示");
                        progress.setMessage("正在发布中...");
                        progress.show();
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

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1)
                    {
                        // TODO 自动生成的方法存根
                        arg0.dismiss();

                    }
                });
                builder.create().show();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode)
        {
            case 11111:
                if(resultCode == RESULT_OK)
                {
                    ContentResolver resolver=getContentResolver();
                    Uri uri=data.getData();
                    Bitmap bm;
                    try
                    {
                        bm=MediaStore.Images.Media.getBitmap(resolver, uri);
                        Bitmap bitmap=Bitmap.createScaledBitmap(bm, 200, 100, true);
                        sc_photo.setImageBitmap(bitmap);
                    }
                    catch(Exception e)
                    {
                        // TODO: handle exception
                        Toast.makeText(ShangChuanActivity.this, "选择图片失败", Toast.LENGTH_SHORT).show();
                    }
                }

                break;

        }
    }

    public void initPopupMenu()
    {
        pm_xuanze=new PopupMenu(ShangChuanActivity.this, bt_choose);
        pm_xuanze.inflate(R.menu.sc_xuanze);
        pm_xuanze.setOnMenuItemClickListener(new OnMenuItemClickListener()
        {

            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                bt_choose.setText(item.getTitle());
                bt_choose.setBackgroundResource(R.drawable.shang_xuanzen_normal);
                return false;
            }
        });

    }
}