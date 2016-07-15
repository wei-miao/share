package com.example.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.share.R;

public class RemenFragment extends Fragment implements OnClickListener
{
    public View rootView;
    private ListView list;
    public ImageView imageView;
    public ImageButton zan;
    public ImageButton guanzhu;
    public ImageButton share;
    public TextView name;
    public TextView author;
    public TextView detail;
    public TextView time;
    public TextView zCount;
    public TextView gCount;
    public TextView sCount;
    public TextView jingxuan;
    public TextView remen;
    public TextView quanbu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        rootView=inflater.inflate(R.layout.note_fragment, null);
        list=(ListView) rootView.findViewById(R.id.note_list);
        jingxuan=(TextView) rootView.findViewById(R.id.note_jingxuan);
        remen=(TextView) rootView.findViewById(R.id.note_remen);
        quanbu=(TextView) rootView.findViewById(R.id.note_quanbu);
        jingxuan.setTextColor(Color.GREEN);
        remen.setOnClickListener(this);
        jingxuan.setOnClickListener(this);
        quanbu.setOnClickListener(this);
        list.setAdapter(new MyAdapter(getActivity()));
        return rootView;
    }

    class MyAdapter extends BaseAdapter
    {

        LayoutInflater ll;

        public MyAdapter(Context context)
        {
            this.ll=LayoutInflater.from(context);
        }

        @Override
        public int getCount()
        {
            // TODO 自动生成的方法存根
            return 4;
        }

        @Override
        public Object getItem(int arg0)
        {
            // TODO 自动生成的方法存根
            return null;
        }

        @Override
        public long getItemId(int arg0)
        {
            // TODO 自动生成的方法存根
            return arg0;
        }

        @Override
        public View getView(int arg0, View convertView, ViewGroup arg1)
        {
            // TODO 自动生成的方法存根
            convertView=(LinearLayout) ll.inflate(R.layout.note_fragment, null);
            imageView=(ImageView) convertView.findViewById(R.id.item_image);
            name=(TextView) convertView.findViewById(R.id.item_name);
            author=(TextView) convertView.findViewById(R.id.item_auther);
            detail=(TextView) convertView.findViewById(R.id.item_detail);
            time=(TextView) convertView.findViewById(R.id.item_time);
            zCount=(TextView) convertView.findViewById(R.id.item_zanCount);
            gCount=(TextView) convertView.findViewById(R.id.item_guanzhuCount);
            sCount=(TextView) convertView.findViewById(R.id.item_shareCount);
            zan=(ImageButton) convertView.findViewById(R.id.item_zan);
            guanzhu=(ImageButton) convertView.findViewById(R.id.item_guanzhu);
            share=(ImageButton) convertView.findViewById(R.id.item_share);

            // //////////////////////

            zan.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View v)
                {
                    // TODO 自动生成的方法存根
                    View view=(View) v.getParent();
                    zCount=(TextView) view.findViewById(R.id.item_zanCount);
                    String str=zCount.getText().toString();
                    int i=Integer.parseInt(str);
                    String s=Integer.toString(i + 1);
                    zCount.setText(s);
                }
            });
            guanzhu.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View v)
                {
                    // TODO 自动生成的方法存根
                    View view=(View) v.getParent();
                    gCount=(TextView) view.findViewById(R.id.item_guanzhuCount);
                    String str=gCount.getText().toString();
                    int i=Integer.parseInt(str);
                    String s=Integer.toString(i + 1);
                    gCount.setText(s);
                }
            });
            share.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View v)
                {
                    View view=(View) v.getParent();
                    sCount=(TextView) view.findViewById(R.id.item_shareCount);
                    String str=sCount.getText().toString();
                    int i=Integer.parseInt(str);
                    String s=Integer.toString(i + 1);
                    sCount.setText(s);
                }
            });
            return convertView;
        }

    }

    @Override
    public void onClick(View v)
    {
        // TODO 自动生成的方法存根
        switch(v.getId())
        {
            case R.id.note_jingxuan:
                jingxuan.setTextColor(Color.GREEN);
                remen.setTextColor(Color.WHITE);
                quanbu.setTextColor(Color.WHITE);
                break;
            case R.id.note_remen:
                remen.setTextColor(Color.GREEN);
                jingxuan.setTextColor(Color.WHITE);
                quanbu.setTextColor(Color.WHITE);
            case R.id.note_quanbu:
                quanbu.setTextColor(Color.GREEN);
                jingxuan.setTextColor(Color.WHITE);
                remen.setTextColor(Color.WHITE);
        }
    }

}
