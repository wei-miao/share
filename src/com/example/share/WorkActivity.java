package com.example.share;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class WorkActivity extends Activity
{
    ListView list;
    public TextView zCount;
    public TextView gCount;
    public TextView sCount;
    public ImageButton zan;
    public ImageButton guanzhu;
    public ImageButton share;
    public ImageButton back;
    List<Map<String, Object>> ls;
    int[] img=new int[]
    { R.drawable.work_1, R.drawable.work_2, R.drawable.work_3, R.drawable.work_4, R.drawable.work_5, R.drawable.work_6 };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.work_main);
        list=(ListView) findViewById(R.id.work_list);
        zan=(ImageButton) findViewById(R.id.work_zan);
        guanzhu=(ImageButton) findViewById(R.id.work_guanzhu);
        share=(ImageButton) findViewById(R.id.work_share);
        back=(ImageButton) findViewById(R.id.work_back);
        zCount=(TextView) findViewById(R.id.work_zanCount);
        gCount=(TextView) findViewById(R.id.work_guanzhuCount);
        sCount=(TextView) findViewById(R.id.work_shareCount);

        back.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO 自动生成的方法存根
                finish();
            }
        });

        zan.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO 自动生成的方法存根
                View view=(View) v.getParent();
                zCount=(TextView) view.findViewById(R.id.work_zanCount);
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
                // TODO Auto-generated method stub
                View view=(View) v.getParent();
                gCount=(TextView) view.findViewById(R.id.work_guanzhuCount);
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
                // TODO Auto-generated method stub
                View view=(View) v.getParent();
                sCount=(TextView) view.findViewById(R.id.work_shareCount);
                String str=sCount.getText().toString();
                int i=Integer.parseInt(str);
                String s=Integer.toString(i + 1);
                sCount.setText(s);
            }
        });

        ls=new ArrayList<Map<String, Object>>();
        for(int i=0; i < img.length; i++)
        {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("imageview", img[i]);
            ls.add(map);
        }

        list.setAdapter(new SimpleAdapter(getApplicationContext(), ls, com.example.share.R.layout.work_list_item, new String[]
        { "imageview" }, new int[]
        { com.example.share.R.id.work_img }));
    }

}
