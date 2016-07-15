package com.example.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class ChatActivity extends Activity
{
    public ImageButton back;
    public Button chat_sub;
    public EditText chat_edit;
    public ScrollView scroll;
    public TextView chat_tittle;
    public LinearLayout ll_1;
    public LinearLayout ll_2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO 自动生成的方法存根
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.chat_main);
        back=(ImageButton) findViewById(R.id.chat_back);
        chat_sub=(Button) findViewById(R.id.chat_fabu);
        chat_tittle=(TextView) findViewById(R.id.chat_title);
        ll_1=(LinearLayout) findViewById(R.id.chat_ll_message1);
        ll_2=(LinearLayout) findViewById(R.id.chat_ll_message2);
        chat_edit=(EditText) findViewById(R.id.chat_li);
        chat_edit.clearFocus();
        scroll=(ScrollView) findViewById(R.id.chat_scroll);
        Intent intent=getIntent();
        if(!intent.getStringExtra("name").equals("言希"))
        {
            ll_1.setVisibility(View.GONE);
            chat_tittle.setText("与" + intent.getStringExtra("name") + "对话");
        }
        back.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO 自动生成的方法存根
                finish();
            }
        });

        chat_sub.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO 自动生成的方法存根
                if(!chat_edit.getText().toString().equals(""))
                {
                    sendContent(chat_edit.getText().toString());
                    chat_edit.setText("");
                }
            }
        });

        chat_edit.setOnTouchListener(new OnTouchListener()
        {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                // TODO 自动生成的方法存根
                chat_edit.setFocusable(true);
                chat_edit.requestFocus();
                scroll.post(new Runnable()
                {

                    @Override
                    public void run()
                    {
                        // TODO 自动生成的方法存根
                        scroll.scrollTo(0, 1000);
                    }
                });
                return false;
            }
        });
    }

    protected void sendContent(String message)
    {
        RelativeLayout re=new RelativeLayout(ChatActivity.this);
        @SuppressWarnings("deprecation")
        RelativeLayout.LayoutParams rp=new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, dipToPx(70));
        re.setLayoutParams(rp);

        ImageView photo=new ImageView(ChatActivity.this);
        photo.setId(1000);
        photo.setBackgroundResource(R.drawable.home1);
        RelativeLayout.LayoutParams param=new RelativeLayout.LayoutParams(dipToPx(50), dipToPx(50));
        param.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        param.addRule(RelativeLayout.CENTER_VERTICAL);
        param.rightMargin=dipToPx(10);
        photo.setLayoutParams(param);

        TextView content=new TextView(ChatActivity.this);
        content.setBackgroundResource(R.drawable.chat_img1);
        content.setText(message);
        content.setTextSize(18);
        content.setPadding(dipToPx(10), 0, dipToPx(10), 0);
        content.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        RelativeLayout.LayoutParams param2=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, dipToPx(50));
        param2.leftMargin=dipToPx(10);
        param2.addRule(RelativeLayout.CENTER_VERTICAL);
        param2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        param2.rightMargin=dipToPx(70);
        content.setLayoutParams(param2);

        re.addView(photo, param);
        re.addView(content, param2);
        ll_2.addView(re);
    }

    public int dipToPx(float dp)
    {
        float px=getResources().getDisplayMetrics().density;
        return (int) (dp * px + 0.5f);
    }

}
