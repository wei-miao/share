package com.example.util;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class ScreenUtil
{
    public static int getScreenWidth(Context context)
    {
        WindowManager manager=(WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display=manager.getDefaultDisplay();

        return display.getWidth();
    }

    public static int getScreenHeight(Context context)
    {
        WindowManager manager=(WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display=manager.getDefaultDisplay();

        return display.getHeight();
    }

    public static int getScreenViewTopHeight(View view)
    {
        return view.getTop();
    }

    public static int getScreenViewBottomHeight(View view)
    {
        return view.getBottom();
    }

    public static int getScreenViewLeftHeight(View view)
    {
        return view.getLeft();
    }

    public static int getScreenViewRightHeight(View view)
    {
        return view.getRight();
    }

}
