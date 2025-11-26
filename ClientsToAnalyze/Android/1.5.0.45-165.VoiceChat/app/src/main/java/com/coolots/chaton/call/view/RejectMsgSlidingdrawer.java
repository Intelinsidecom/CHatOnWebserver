package com.coolots.chaton.call.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SlidingDrawer;
import com.coolots.chaton.C0000R;

/* loaded from: classes.dex */
public class RejectMsgSlidingdrawer extends SlidingDrawer {
    private boolean mIsOpened;

    public RejectMsgSlidingdrawer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RejectMsgSlidingdrawer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.widget.SlidingDrawer, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        Rect frame = new Rect();
        View handle = findViewById(C0000R.id.reject_call_with_msg_handle);
        handle.getHitRect(frame);
        frame.left += 330;
        frame.right -= 330;
        if (this.mIsOpened || frame.contains((int) x, (int) y)) {
            return super.onInterceptTouchEvent(event);
        }
        return true;
    }

    public void setIsOpened(boolean isOpened) {
        this.mIsOpened = isOpened;
    }
}
