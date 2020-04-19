package com.marcohc.robotocalendar;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

public class CalendarTouchListener implements View.OnTouchListener {

    static final int MIN_DISTANCE = 100;
    private float downX, downY, upX, upY;
    private int sLogicalDensity;

    public static void calculateLogicalDensity(Activity activity) {

    }

    public CalendarTouchListener(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        sLogicalDensity = Math.round(metrics.density / 1.5f);
    }

    public void onRightToLeftSwipe() {

    }

    public void onLeftToRightSwipe() {

    }

    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                downX = event.getX();
                downY = event.getY();
                return true;
            }
            case MotionEvent.ACTION_UP: {
                upX = event.getX();
                upY = event.getY();

                float deltaX = downX - upX;
                float deltaY = downY - upY;

                // swipe horizontal?
                if (Math.abs(deltaX) > MIN_DISTANCE * sLogicalDensity) {
                    // left or right
                    if (deltaX < 0) {
                        this.onLeftToRightSwipe();
                        return true;
                    }
                    if (deltaX > 0) {
                        this.onRightToLeftSwipe();
                        return true;
                    }
                } else {
                    // return false; // We don't consume the event
                }

                return false; // no swipe horizontally and no swipe vertically
            }// case MotionEvent.ACTION_UP:
        }
        return false;
    }

}