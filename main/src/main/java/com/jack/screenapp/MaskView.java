package com.jack.screenapp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class MaskView extends View {
    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;

    public MaskView(Context context) {
        super(context);

        DisplayMetrics displayMetrics = new DisplayMetrics();

        windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);

        int size = (int)(displayMetrics.heightPixels * 1.5);

        layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = size;
        layoutParams.height = size;
        layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
        layoutParams.flags =
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        layoutParams.format = PixelFormat.TRANSLUCENT;

        windowManager.addView(this, layoutParams);
    }

    public void onDestroy() {
        windowManager.removeView(this);
    }
}
