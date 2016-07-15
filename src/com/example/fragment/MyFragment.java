package com.example.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.example.share.MainActivity;
import com.example.share.MyInfoActivity;
import com.example.share.MySheActivity;
import com.example.share.MyTuiActivity;
import com.example.share.MyUploadActivity;
import com.example.share.R;

public class MyFragment extends Fragment implements OnClickListener
{
    public View rootview;
    public RelativeLayout shangchuan;
    public RelativeLayout xinxi;
    public RelativeLayout tuijian;
    public RelativeLayout yuanxi;
    public RelativeLayout shezhi;
    public RelativeLayout tuichu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        MainActivity.rg_main.setVisibility(View.VISIBLE);
        rootview=inflater.inflate(R.layout.my_fragment, container, false);
        findViews();
        return rootview;
    }

    public void findViews()
    {
        shangchuan=(RelativeLayout) rootview.findViewById(R.id.my_shangchuan1);
        xinxi=(RelativeLayout) rootview.findViewById(R.id.my_info1);
        tuijian=(RelativeLayout) rootview.findViewById(R.id.my_tuijian1);
        yuanxi=(RelativeLayout) rootview.findViewById(R.id.my_yuanxi1);
        shezhi=(RelativeLayout) rootview.findViewById(R.id.my_shezhi1);
        tuichu=(RelativeLayout) rootview.findViewById(R.id.my_tuichu);
        shangchuan.setOnClickListener(this);
        xinxi.setOnClickListener(this);
        tuijian.setOnClickListener(this);
        yuanxi.setOnClickListener(this);
        shezhi.setOnClickListener(this);
        tuichu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        // TODO 自动生成的方法存根
        Intent intent=new Intent();
        switch(v.getId())
        {
            case R.id.my_shangchuan1:
                intent.setClass(getActivity(), MyUploadActivity.class);
                startActivity(intent);
                break;
            case R.id.my_info1:
                intent.setClass(getActivity(), MyInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.my_tuijian1:
                intent.setClass(getActivity(), MyTuiActivity.class);
                startActivity(intent);
                break;
            case R.id.my_yuanxi1:
                break;
            case R.id.my_shezhi1:
                intent.setClass(getActivity(), MySheActivity.class);
                startActivity(intent);
                break;
            case R.id.my_tuichu:
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity()).setTitle("提示").setMessage("确认退出？").setPositiveButton("确定", new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int arg0)
                    {
                        // TODO 自动生成的方法存根
                        getActivity().finish();
                        dialog.dismiss();
                    }
                })

                .setNegativeButton("取消", new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int arg1)
                    {
                        // TODO 自动生成的方法存根
                        dialog.dismiss();

                    }
                });
                builder.create().show();
                break;
        }
    }
}
