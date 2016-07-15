package com.example.share;

import android.app.Activity;
import android.content.Context;
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

public class MyTuiActivity extends Activity implements OnClickListener
{
    public ListView list;
    public Button topButton;
    public boolean scrollFlag=false;
    public int lastVisibleItemPosition=0;

    public ImageView imageView;
    public ImageButton zan;
    public ImageButton guanzhu;
    public ImageButton share;
    public ImageButton back;
    public TextView name;
    public TextView author;
    public TextView detail;
    public TextView time;
    public TextView zCount;
    public TextView gCount;
    public TextView sCount;

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tui_main);
        list=(ListView) findViewById(R.id.tui_list);
        back=(ImageButton) findViewById(R.id.tui_back);
        topButton=(Button) findViewById(R.id.tui_top_btn);
        back.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO 自动生成的方法存根
                finish();
            }
        });

        list.setAdapter(new myAdapter(getApplicationContext()));
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

    class myAdapter extends BaseAdapter
    {

        LayoutInflater ll;

        public myAdapter(Context context)
        {
            this.ll=LayoutInflater.from(context);
        }

        @Override
        public int getCount()
        {
            // TODO 自动生成的方法存根
            return str_name.length;
        }

        @Override
        public Object getItem(int position)
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
        public View getView(int arg0, View convertView, ViewGroup parent)
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

            imageView.setImageDrawable(getResources().getDrawable(img[arg0]));
            name.setText(str_name[arg0]);
            author.setText(str_author[arg0]);
            detail.setText(str_detail[arg0]);
            time.setText(str_time[arg0]);

            zan.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    // TODO Auto-generated method stub
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
                    // TODO Auto-generated method stub
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
                    // TODO Auto-generated method stub
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
        finish();
    }

}
