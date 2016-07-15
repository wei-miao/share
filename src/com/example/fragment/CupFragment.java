package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.share.HuoDongActivity;
import com.example.share.MainActivity;
import com.example.share.R;

public class CupFragment extends Fragment implements OnClickListener
{

    private View rootView;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        MainActivity.rg_main.setVisibility(View.VISIBLE);
        rootView=inflater.inflate(R.layout.huodong_activity, container, false);
        iv1=(ImageView) rootView.findViewById(R.id.huodong1);
        iv2=(ImageView) rootView.findViewById(R.id.huodong2);
        iv3=(ImageView) rootView.findViewById(R.id.huodong3);
        iv4=(ImageView) rootView.findViewById(R.id.huodong1);
        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        // TODO 自动生成的方法存根
        Intent intent=new Intent(getActivity(), HuoDongActivity.class);
        switch(v.getId())
        {
            case R.id.huodong1:
                intent.putExtra("huodong", "http://www.zcool.com.cn/event/shinho/");
                startActivity(intent);
                break;
            case R.id.huodong2:
                intent.putExtra("huodong", "http://mi.ui.cn/miui/");
                startActivity(intent);
                break;
            case R.id.huodong3:
                intent.putExtra("huodong", "http://www.zcool.com.cn/event/huafans/");
                startActivity(intent);
                break;

            default:
                break;
        }
    }

}
