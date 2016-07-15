package com.example.share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NewGuanActivity extends Activity
{
    public ImageView new_photo;
    public ImageButton new_back;
    public TextView new_name;
    public Button new_is;
    ListView listView;

    String[] name=new String[]
    { "言希", "孙鹏", "阿衡" };
    int[] img=new int[]
    { R.drawable.guanzhu1, R.drawable.guanzhu2, R.drawable.guanzhu3 };
    int[] isguanzhu=new int[]
    { R.drawable.guanzhu_pressed, R.drawable.guanzhu_pressed, R.drawable.guanzhu_normal };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newguanzhu_activity);
        new_back=(ImageButton) findViewById(R.id.newguanzhu_back);

        new_back.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO 自动生成的方法存根
                finish();
            }
        });

        listView=(ListView) findViewById(R.id.newguanzhu_list);
        listView.setAdapter(new MyAdapter(getApplicationContext()));
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
            return name.length;
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
        public View getView(int position, View convertView, ViewGroup parent)
        {
            // TODO 自动生成的方法存根
            convertView=(RelativeLayout) ll.inflate(R.layout.newguanzhu_list, null);
            new_photo=(ImageView) convertView.findViewById(R.id.newguanzhu_img);
            new_name=(TextView) convertView.findViewById(R.id.newguanzhu_name);
            new_is=(Button) convertView.findViewById(R.id.is_guanzhu);
            new_photo.setImageDrawable(getResources().getDrawable(img[position]));
            new_name.setText(name[position]);
            new_is.setBackground(getResources().getDrawable(isguanzhu[position]));
            if(position > 2)
            {
                new_is.setTag(0);
            }
            else
            {
                new_is.setTag(1);
            }
            new_is.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View v)
                {
                    // TODO 自动生成的方法存根
                    if(Integer.parseInt(v.getTag().toString()) == 1)
                    {
                        v.setBackground(getResources().getDrawable(R.drawable.guanzhu_normal));
                        v.setTag(0);
                    }
                    else
                    {
                        v.setBackground(getResources().getDrawable(R.drawable.guanzhu_pressed));
                        v.setTag(1);
                    }
                }
            });

            return convertView;
        }
    }
}
