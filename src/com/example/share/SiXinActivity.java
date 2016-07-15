package com.example.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SiXinActivity extends Activity
{
    public ListView list;
    public ImageButton back;
    public ImageView sixin_img;
    public TextView sixin_name;
    public TextView sixin_time;
    public TextView sixin_message;

    String[] str_name=new String[]
    { "��ϣ", "����", "½��", "����" };
    String[] str_time=new String[]
    { "11-23 01:11", "12-22 03:43", "10-23 10:23", "02-23 09:55" };
    String[] str_message=new String[]
    { "�ҵ���������ͭȸ¥��", "����ס���ҵ���С�ǡ�", "����ʱ�⡣", "��ϣ���Һ����㡣" };
    int[] str_img=new int[]
    { R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.home4 };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO �Զ����ɵķ������
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sixin_main);
        list=(ListView) findViewById(R.id.sixin_list);
        back=(ImageButton) findViewById(R.id.sixin_back);

        back.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO �Զ����ɵķ������
                finish();
            }
        });

        list.setAdapter(new MyAdapter(this));
        list.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                // TODO �Զ����ɵķ������
                TextView sixin_name=(TextView) findViewById(R.id.sixin_name);
                Intent intent=new Intent(SiXinActivity.this, ChatActivity.class);
                System.out.println("name-->" + sixin_name.getText().toString());
                intent.putExtra("name", sixin_name.getText().toString());
                startActivity(intent);
            }
        });
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
        public long getItemId(int position)
        {
            // TODO �Զ����ɵķ������
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            convertView=(RelativeLayout) ll.inflate(R.layout.sixin_list_item, null);
            sixin_img=(ImageView) convertView.findViewById(R.id.sixin_img);
            sixin_name=(TextView) convertView.findViewById(R.id.sixin_name);
            sixin_time=(TextView) convertView.findViewById(R.id.sixin_time);
            sixin_message=(TextView) convertView.findViewById(R.id.sixin_message);
            sixin_img.setImageDrawable(getResources().getDrawable(str_img[position]));
            sixin_name.setText(str_name[position]);
            sixin_time.setText(str_time[position]);
            sixin_message.setText(str_message[position]);
            return convertView;
        }

    }
}
