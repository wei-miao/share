package com.example.share;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter
{

    private List<String> mTitleArray;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<String> titleArray)
    {
        this.mTitleArray=titleArray;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        if(mTitleArray != null)
            return mTitleArray.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position)
    {
        if(mTitleArray != null)
            return mTitleArray.get(position);
        else
            return null;
    }

    @Override
    public long getItemId(int position)
    {
        // TODO 自动生成的方法存根
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO 自动生成的方法存根
        ViewHolder holder=null;
        if(convertView == null)
        {
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.home_list_item, null);
            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder) convertView.getTag();
        }
        holder.mTitleTv.setText(mTitleArray.get(position));
        return convertView;
    }

    private class ViewHolder
    {
        private TextView mTitleTv;
    }

}
