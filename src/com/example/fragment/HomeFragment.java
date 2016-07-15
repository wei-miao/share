package com.example.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.share.MainActivity;
import com.example.share.R;
import com.example.share.WorkActivity;
import com.example.util.ScreenUtil;

public class HomeFragment extends Fragment implements OnClickListener
{

    public ViewPager home_vp_main=null;
    public List<View> adList;
    public ImageView img1, img2, img3, img4;
    public ImageView[] home_circles;
    public ImageView home_point;
    public ViewGroup viewGroup;

    public View rootView;
    public ListView list;
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
    public Button home_top_bt;
    public MyAdapter home_adapter;
    public AtomicInteger ai=new AtomicInteger(0);
    public boolean coutinue=true;
    public boolean scrollFlag=false;
    public int lastVisibleItemPosition=0;

    public String[] str_name=new String[]
    { "tear", "lose", "winter", "important", "loving", "choose" };
    public String[] str_author=new String[]
    { "��ϣ", "����", "˼ݸ", "˼��", "����", "Mary" };
    public String[] str_detail=new String[]
    { "лл������", "���ѼҴ�����", "��׷���˷���", "����������", "�Ǹ�����������", "��ѡ������һ��" };
    public String[] str_time=new String[]
    { "��ʱ", "��ʱ", "��ʱ", "îʱ", "����", "��ʳ" };
    public int[] img=new int[]
    { R.drawable.yan_list_1, R.drawable.yan_list_2, R.drawable.yan_list_3, R.drawable.yan_list_4, R.drawable.yan_list_5, R.drawable.yan_list_6 };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // TODO �Զ����ɵķ������
        rootView=inflater.inflate(R.layout.home_fragment, null);
        list=(ListView) rootView.findViewById(R.id.home_list);
        adList=new ArrayList<View>();
        home_vp_main=(ViewPager) rootView.findViewById(R.id.home_vp_main);
        viewGroup=(ViewGroup) rootView.findViewById(R.id.home_ad_main_group);
        home_top_bt=(Button) rootView.findViewById(R.id.home_top_bt);
        home_adapter=new MyAdapter(getActivity());
        list.setAdapter(home_adapter);
        list.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                // TODO �Զ����ɵķ������
                Intent intent=new Intent(getActivity().getApplicationContext(), WorkActivity.class);
                startActivity(intent);
            }
        });

        initView();
        initImageList();
        initPoint();

        return rootView;
    }

    public void initView()
    {
        home_top_bt.setOnClickListener(this);
        list.setOnScrollListener(new OnScrollListener()
        {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState)
            {
                // TODO �Զ����ɵķ������
                switch(scrollState)
                {
                    case OnScrollListener.SCROLL_STATE_IDLE:
                        scrollFlag=false;
                        if(list.getLastVisiblePosition() == (list.getCount() - 1))
                        {
                            home_top_bt.setVisibility(View.VISIBLE);
                        }
                        if(list.getFirstVisiblePosition() == 0)
                        {
                            home_top_bt.setVisibility(View.GONE);
                            MainActivity.rg_main.setVisibility(View.VISIBLE);
                        }

                        break;

                    case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        MainActivity.rg_main.setVisibility(View.GONE);
                        scrollFlag=true;
                        break;

                    case OnScrollListener.SCROLL_STATE_FLING:// �ǵ��û�����֮ǰ������Ļ��̧����ָ����Ļ�������Ի���ʱ
                        scrollFlag=false;
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
            {
                // TODO �Զ����ɵķ������
                if(scrollFlag && ScreenUtil.getScreenViewBottomHeight(list) >= ScreenUtil.getScreenHeight(getActivity()))
                {
                    if(firstVisibleItem > lastVisibleItemPosition)
                    {
                        home_top_bt.setVisibility(View.VISIBLE);
                    }
                    else
                        if(firstVisibleItem < lastVisibleItemPosition)
                        {
                            home_top_bt.setVisibility(View.GONE);
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

    @Override
    public void onClick(View v)
    {
        // TODO �Զ����ɵķ������
        switch(v.getId())
        {
            case R.id.home_top_bt:
                setListViewPos(0);
                break;
        }
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
            // TODO �Զ����ɵķ������
            return str_name.length;
        }

        @Override
        public Object getItem(int arg0)
        {
            // TODO �Զ����ɵķ������
            return null;
        }

        @Override
        public long getItemId(int arg0)
        {
            // TODO �Զ����ɵķ������
            return arg0;
        }

        @Override
        public View getView(int arg0, View convertView, ViewGroup arg2)
        {
            // TODO �Զ����ɵķ������
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

    private void atomicOption()
    {
        ai.incrementAndGet();
        if(ai.get() > home_circles.length - 1)
        {
            ai.getAndAdd(-4);
        }
        try
        {
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            // TODO: handle exception
        }
    }

    public class imageListOnClicker implements OnPageChangeListener
    {

        @Override
        public void onPageScrollStateChanged(int arg0)
        {
            // TODO �Զ����ɵķ������

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
        {
            // TODO �Զ����ɵķ������

        }

        @Override
        public void onPageSelected(int position)
        {
            // TODO �Զ����ɵķ������
            ai.getAndSet(position);
            for(int i=0; i < home_circles.length; i++)
            {
                home_circles[position].setBackgroundResource(R.drawable.point_pressed);
                if(position != i)
                {
                    home_circles[i].setBackgroundResource(R.drawable.point_unpressed);
                }
            }
        }

    }

    public void initImageList()
    {
        img1=new ImageView(getActivity());
        img1.setBackgroundResource(R.drawable.home1);
        adList.add(img1);

        img2=new ImageView(getActivity());
        img2.setBackgroundResource(R.drawable.home2);
        adList.add(img2);

        img3=new ImageView(getActivity());
        img3.setBackgroundResource(R.drawable.home3);
        adList.add(img3);

        img4=new ImageView(getActivity());
        img4.setBackgroundResource(R.drawable.home4);
        adList.add(img4);
        home_vp_main.setAdapter(new pagerAdapter());
        home_vp_main.setOnPageChangeListener(new imageListOnClicker());
    }

    public void initPoint()
    {
        android.widget.LinearLayout.LayoutParams params;
        home_circles=new ImageView[adList.size()];
        for(int i=0; i < home_circles.length; i++)
        {
            home_point=new ImageView(getActivity());
            home_point.setLayoutParams(new LayoutParams(30, 30));
            home_circles[i]=home_point;
            if(i == 0)
            {
                home_circles[i].setBackgroundResource(R.drawable.point_pressed);
            }
            else
            {
                home_circles[i].setBackgroundResource(R.drawable.point_unpressed);
            }
            viewGroup.addView(home_circles[i]);
            params=(android.widget.LinearLayout.LayoutParams) home_circles[i].getLayoutParams();
            params.leftMargin=20;
            params.bottomMargin=10;
            home_circles[i].setLayoutParams(params);
        }
        new Thread(new RefreshAdCirleTask()).start();
    }

    public class RefreshAdCirleTask implements Runnable
    {

        @Override
        public void run()
        {
            // TODO �Զ����ɵķ������
            while(true)
            {
                if(coutinue)
                {
                    handler.sendEmptyMessage(ai.get());
                    atomicOption();
                }
            }
        }

    }

    public class pagerAdapter extends android.support.v4.view.PagerAdapter
    {

        @Override
        public int getCount()
        {
            // TODO �Զ����ɵķ������
            return 4;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1)
        {
            // TODO �Զ����ɵķ������
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            // TODO �Զ����ɵķ������
            container.addView(adList.get(position));
            return adList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            // TODO �Զ����ɵķ������
            container.removeView(adList.get(position));
        }
    }

    public android.os.Handler handler=new android.os.Handler()
    {
        public void handleMessage(Message msg)
        {
            if(coutinue)
            {
                home_vp_main.setCurrentItem(msg.what);
            }
        };

    };

}
