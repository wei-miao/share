package com.example.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.share.R;

public class SerachFragment extends Fragment
{
    private View rootView;
    public EditText et_search;
    private ImageView search_bt;
    public LinearLayout search_result;
    public RelativeLayout search;
    private ProgressDialog progress;
    Handler handler=new Handler()
    {
        public void handleMessage(android.os.Message msg)
        {
            progress.dismiss();
            search.setVisibility(View.GONE);
            search_result.setVisibility(View.VISIBLE);
        };
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView=inflater.inflate(R.layout.search_fragment, container, false);
        et_search=(EditText) rootView.findViewById(R.id.search_et_search);
        search_bt=(ImageView) rootView.findViewById(R.id.search_bt);
        search=(RelativeLayout) rootView.findViewById(R.id.search);
        search_result=(LinearLayout) rootView.findViewById(R.id.search_result);

        search_bt.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                // TODO 自动生成的方法存根
                String searStr=et_search.getText().toString();
                if(searStr.equalsIgnoreCase("言希"))
                {
                    progress=new ProgressDialog(getActivity());
                    progress.setTitle("提示");
                    progress.setMessage("正在搜索中...");
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
                            catch(InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                        }

                    }.start();

                }
            }
        });
        et_search.setOnTouchListener(new OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                // TODO 自动生成的方法存根
                et_search.setText("");
                return false;
            }
        });
        return rootView;

    }

}
