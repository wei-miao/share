package com.example.share;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import com.example.fragment.CupFragment;
import com.example.fragment.HomeFragment;
import com.example.fragment.MyFragment;
import com.example.fragment.NoteFragment;
import com.example.fragment.SerachFragment;
import com.example.util.ActionBarUtil;

public class MainActivity extends FragmentActivity
{

    private long mExitTime;

    private ViewPager vp_main=null;
    private FragmentPagerAdapter mAapter=null;
    private List<Fragment> mFragments=new ArrayList<Fragment>();

    private RadioButton rb1_main=null;
    private RadioButton rb2_main=null;
    private RadioButton rb3_main=null;
    private RadioButton rb4_main=null;
    private RadioButton rb5_main=null;

    public static RadioGroup rg_main=null;

    private HomeFragment homeFragment;
    private MyFragment myFragment;
    private NoteFragment noteFragment;
    private CupFragment cupFragment;
    private SerachFragment searchFragment;
    public static Map<String, Object> data=new HashMap<String, Object>();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ActionBarUtil.initMainActionBar(MainActivity.this, getActionBar(), "SHARE", 0);
        findViews();
        initAdapter();
        initViewPager();

    }

    private void findViews()
    {
        rb1_main=(RadioButton) findViewById(R.id.rb1_main);
        rb2_main=(RadioButton) findViewById(R.id.rb2_main);
        rb3_main=(RadioButton) findViewById(R.id.rb3_main);
        rb4_main=(RadioButton) findViewById(R.id.rb4_main);
        rb5_main=(RadioButton) findViewById(R.id.rb5_main);
        rg_main=(RadioGroup) findViewById(R.id.rg_main);
        vp_main=(ViewPager) findViewById(R.id.vp_main);

        homeFragment=new HomeFragment();
        myFragment=new MyFragment();
        noteFragment=new NoteFragment();
        cupFragment=new CupFragment();
        searchFragment=new SerachFragment();

        mFragments.add(homeFragment);
        mFragments.add(searchFragment);
        mFragments.add(noteFragment);
        mFragments.add(cupFragment);
        mFragments.add(myFragment);

    }

    private void initAdapter()
    {
        FragmentManager fm=getSupportFragmentManager();
        mAapter=new FragmentPagerAdapter(fm)
        {

            @Override
            public int getCount()
            {
                // TODO 自动生成的方法存根
                return mFragments.size();
            }

            @Override
            public android.support.v4.app.Fragment getItem(int arg0)
            {
                // TODO 自动生成的方法存根
                return mFragments.get(arg0);
            }

            @Override
            public Object instantiateItem(ViewGroup arg0, int arg1)
            {
                // TODO 自动生成的方法存根
                return super.instantiateItem(arg0, arg1);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                // TODO 自动生成的方法存根
                super.destroyItem(container, position, object);
            }
        };
    }

    private void initViewPager()
    {
        vp_main.setAdapter(mAapter);
        vp_main.setOnPageChangeListener(new OnPageChangeListener()
        {

            @Override
            public void onPageScrollStateChanged(int arg0)
            {
                // TODO 自动生成的方法存根

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2)
            {
                // TODO 自动生成的方法存根

            }

            @Override
            public void onPageSelected(int position)
            {
                switch(position)
                {
                    case 0:
                        rb1_main.setChecked(true);
                        break;
                    case 1:
                        rb2_main.setChecked(true);
                        break;
                    case 2:
                        rb3_main.setChecked(true);
                        break;
                    case 3:
                        rb4_main.setChecked(true);
                        break;
                    case 4:
                        rb5_main.setChecked(true);
                        break;
                    default:
                        break;
                }

            }

        });

        rg_main.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup rg, int id)
            {
                switch(id)
                {
                    case R.id.rb1_main:
                        vp_main.setCurrentItem(0);
                        ActionBarUtil.initMainActionBar(MainActivity.this, getActionBar(), "SHARE", 0);
                        break;
                    case R.id.rb2_main:
                        vp_main.setCurrentItem(1);
                        ActionBarUtil.initMainActionBar(MainActivity.this, getActionBar(), "搜索", 1);
                        ImageView shang=(ImageView) getActionBar().getCustomView().findViewById(R.id.action_shuangchuan);
                        shang.setOnClickListener(new OnClickListener()
                        {

                            @Override
                            public void onClick(View arg0)
                            {
                                // TODO 自动生成的方法存根
                                Intent intent=new Intent(MainActivity.this, ShangChuanActivity.class);
                                startActivity(intent);
                            }
                        });
                        ImageView search_back=(ImageView) getActionBar().getCustomView().findViewById(R.id.action_back);
                        search_back.setOnClickListener(new OnClickListener()
                        {

                            @Override
                            public void onClick(View arg0)
                            {
                                // TODO 自动生成的方法存根
                                searchFragment.search_result.setVisibility(View.GONE);
                                searchFragment.search.setVisibility(View.VISIBLE);
                            }
                        });
                        break;
                    case R.id.rb3_main:
                        vp_main.setCurrentItem(2);
                        ActionBarUtil.initMainActionBar(MainActivity.this, getActionBar(), "文章", 2);
                        break;
                    case R.id.rb4_main:
                        vp_main.setCurrentItem(3);
                        ActionBarUtil.initMainActionBar(MainActivity.this, getActionBar(), "活动", 3);
                        break;
                    case R.id.rb5_main:
                        vp_main.setCurrentItem(4);
                        ActionBarUtil.initMainActionBar(MainActivity.this, getActionBar(), "个人信息", 4);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // TODO 自动生成的方法存根
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            if((System.currentTimeMillis() - mExitTime) > 2000)
            {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime=System.currentTimeMillis();
            }
            else
            {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void searchOnClick(View v)
    {
        if(Integer.parseInt(v.getTag().toString()) == 0)
        {
            searchFragment.et_search.setText(((Button) v).getText());
            v.setBackgroundResource(R.drawable.yinying2);
            v.setTag("1");
            ((Button) v).setTextColor(Color.WHITE);
        }
        else
        {
            searchFragment.et_search.setText(((Button) v).getText());
            v.setBackgroundResource(R.drawable.yinying);
            v.setTag("0");
            ((Button) v).setTextColor(Color.BLACK);

        }
    }

}
