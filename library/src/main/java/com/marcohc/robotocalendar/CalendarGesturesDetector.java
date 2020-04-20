package com.marcohc.robotocalendar;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class CalendarGesturesDetector implements GestureDetector.OnGestureListener {
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    public void onRightToLeftSwipe() {

    }

    public void onLeftToRightSwipe() {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float v1) {
        if (e1.getX() < e2.getX()) {
            Log.d("ActivitySwipeDetector", "Left to Right swipe: "+ e1.getX() + " - " + e2.getX());
            onLeftToRightSwipe();
        }
        if (e1.getX() > e2.getX()) {
            Log.d("ActivitySwipeDetector", "Right to Left swipe: "+ e1.getX() + " - " + e2.getX());
            onRightToLeftSwipe();
        }
        return true;
    }

}
