package com.example.share;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.util.ScreenUtil;

public class MyUploadActivity extends Activity implements OnClickListener
{
    public ListView list;
    public Button topButton;
    public boolean scrollFlag=false;
    public int lastVisibleItemPosition=0;

    public ImageView imageView;
    public ImageButton zan;
    public ImageButton guanzhu;
    public ImageButton share;
    public ImageButton back1;
    public TextView name;
    public TextView author;
    public TextView detail;
    public TextView time;
    public TextView zCount;
    public TextView gCount;
    public TextView sCount;
    public TextView loadtime;
    public TextView tuijian;
    public TextView sharemax;

    public String[] str_name=new String[]
    { "tear", "lose", "winter", "important", "loving", "choose" };
    public String[] str_author=new String[]
    { "言希", "阿衡", "思莞", "思尔", "达夷", "Mary" };
    public String[] str_detail=new String[]
    { "谢谢你姓温", "他把家带走了", "他追到了法国", "救赎与宿命", "那个曾经温如言", "你选择做哪一个" };
    public String[] str_time=new String[]
    { "子时", "丑时", "寅时", "卯时", "新月", "月食" };
    public int[] img=new int[]
    { R.drawable.yan_list_1, R.drawable.yan_list_2, R.drawable.yan_list_3, R.drawable.yan_list_4, R.drawable.yan_list_5, R.drawable.yan_list_6 };

    public String[] str_name1=new String[]
    { "important", "loving", "choose", "tear", "lose", "winter" };
    public String[] str_author1=new String[]
    { "思尔", "达夷", "Mary", "言希", "阿衡", "思莞" };
    public String[] str_detail1=new String[]
    { "救赎与宿命", "那个曾经温如言", "你选择做哪一个", "谢谢你姓温", "他把家带走了", "他追到了法国" };
    public String[] str_time1=new String[]
    { "卯时", "新月", "月食", "子时", "丑时", "寅时" };
    public int[] img1=new int[]
    { R.drawable.yan_list_4, R.drawable.yan_list_5, R.drawable.yan_list_6, R.drawable.yan_list_1, R.drawable.yan_list_2, R.drawable.yan_list_3 };

    public String[] str_name2=new String[]
    { "winter", "important", "loving", "choose", "tear", "lose" };
    public String[] str_author2=new String[]
    { "思莞", "思尔", "达夷", "Mary", "言希", "阿衡" };
    public String[] str_detail2=new String[]
    { "他追到了法国", "救赎与宿命", "那个曾经温如言", "你选择做哪一个", "谢谢你姓温", "他把家带走了" };
    public String[] str_time2=new String[]
    { "寅时", "卯时", "新月", "月食", "子时", "丑时" };
    public int[] img2=new int[]
    { R.drawable.yan_list_3, R.drawable.yan_list_4, R.drawable.yan_list_5, R.drawable.yan_list_6, R.drawable.yan_list_1, R.drawable.yan_list_2 };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_upload);
        loadtime=(TextView) findViewById(R.id.upload_shangchuan);
        tuijian=(TextView) findViewById(R.id.upload_tuijian);
        sharemax=(TextView) findViewById(R.id.upload_share);
        back1=(ImageButton) findViewById(R.id.load_back);
        topButton=(Button) findViewById(R.id.upload_top_button);

        loadtime.setTextColor(Color.GREEN);
        loadtime.setOnClickListener(this);
        tuijian.setOnClickListener(this);
        sharemax.setOnClickListener(this);
        back1.setOnClickListener(this);
        list=(ListView) findViewById(R.id.upload_list);
        list.setAdapter(new MyAdapter(this, str_name, str_author, str_detail, str_time, img));
        initView();
    }

    public void initView()
    {

        topButton.setOnClickListener(this);
        list.setOnScrollListener(new OnScrollListener()
        {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState)
            {
                // TODO 自动生成的方法存根
                switch(scrollState)
                {
                    case OnScrollListener.SCROLL_STATE_IDLE:
                        scrollFlag=false;
                        if(list.getLastVisiblePosition() == (list.getCount() - 1))
                        {
                            topButton.setVisibility(View.VISIBLE);
                        }
                        if(list.getFirstVisiblePosition() == 0)
                        {
                            topButton.setVisibility(View.GONE);
                        }
                        break;
                    case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        scrollFlag=true;
                        break;
                    case OnScrollListener.SCROLL_STATE_FLING:
                        scrollFlag=false;
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
            {
                // TODO 自动生成的方法存根
                if(scrollFlag && ScreenUtil.getScreenViewBottomHeight(list) >= ScreenUtil.getScreenHeight(getApplicationContext()))
                {
                    if(firstVisibleItem > lastVisibleItemPosition)
                    {
                        topButton.setVisibility(View.VISIBLE);
                    }
                    else
                        if(firstVisibleItem < lastVisibleItemPosition)
                        {
                            topButton.setVisibility(View.GONE);
                        }
                        else
                        {
                            return;
                        }
                    lastVisibleItemPosition=firstVisibleItem;

                }
            }
        });

    }

    public void setListViewPos(int pos)
    {
        if(android.os.Build.VERSION.SDK_INT >= 8)
        {
            list.smoothScrollToPosition(pos);
        }
        else
        {
            list.setSelection(pos);
        }

    }

    class MyAdapter extends BaseAdapter
    {

        String[] name1;
        String[] author1;
        String[] detail1;
        String[] time1;
        int[] img1;
        LayoutInflater ll;

        public MyAdapter(Context context, String[] name, String[] author, String[] detail, String[] time, int[] img)
        {
            this.ll=LayoutInflater.from(context);
            this.name1=name;
            this.author1=author;
            this.detail1=detail;
            this.time1=time;
            this.img1=img;
        }

        @Override
        public int getCount()
        {
            // TODO 自动生成的方法存根
            return str_name.length;
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
            return 0;
        }

        @Override
        public View getView(int arg0, View convertView, ViewGroup arg2)
        {
            // TODO 自动生成的方法存根
            convertView=(LinearLayout) ll.inflate(R.layout.home_list_item, null);
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

            imageView.setImageDrawable(getResources().getDrawable(img1[arg0]));
            name.setText(name1[arg0]);
            author.setText(author1[arg0]);
            detail.setText(detail1[arg0]);
            time.setText(time1[arg0]);

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

        // TODO 自动生成的方法存根
        switch(v.getId())
        {
            case R.id.upload_shangchuan:
                loadtime.setTextColor(Color.GREEN);
                tuijian.setTextColor(Color.WHITE);
                sharemax.setTextColor(Color.WHITE);
                list.setAdapter(new MyAdapter(this, str_name, str_author, str_detail, str_time, img));
                break;
            case R.id.upload_tuijian:
                loadtime.setTextColor(Color.WHITE);
                tuijian.setTextColor(Color.GREEN);
                sharemax.setTextColor(Color.WHITE);
                list.setAdapter(new MyAdapter(this, str_name1, str_author1, str_detail1, str_time1, img1));
                break;
            case R.id.upload_share:
                loadtime.setTextColor(Color.WHITE);
                tuijian.setTextColor(Color.WHITE);
                sharemax.setTextColor(Color.GREEN);
                list.setAdapter(new MyAdapter(this, str_name2, str_author2, str_detail2, str_time2, img2));
                break;
            case R.id.upload_top_button:
                setListViewPos(0);
                break;
            case R.id.load_back:
                finish();
                break;
        }

    }

}
