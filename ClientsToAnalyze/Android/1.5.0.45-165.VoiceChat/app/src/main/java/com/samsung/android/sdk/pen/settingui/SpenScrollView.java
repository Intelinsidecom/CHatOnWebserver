package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* loaded from: classes.dex */
class SpenScrollView extends ScrollView {
    private boolean mScrollable;
    private scrollChangedListener onScrollChangedListener;

    interface scrollChangedListener {
        void scrollChanged(int i);
    }

    public SpenScrollView(Context mContext) {
        super(mContext);
        this.mScrollable = true;
    }

    @Override // android.widget.ScrollView, android.view.View
    public int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // android.view.View
    protected void onScrollChanged(int mScrollX, int mScrollY, int oldX, int oldY) {
        super.onScrollChanged(mScrollX, mScrollY, oldX, oldY);
        if (this.onScrollChangedListener != null) {
            this.onScrollChangedListener.scrollChanged(mScrollY);
        }
    }

    public void setOnScrollChangedListener(scrollChangedListener mScrollChangedListener) {
        this.onScrollChangedListener = mScrollChangedListener;
    }

    public void setScrollingEnabled(boolean enabled) {
        this.mScrollable = enabled;
    }

    public boolean isScrollable() {
        return this.mScrollable;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                if (!this.mScrollable) {
                    break;
                } else {
                    break;
                }
        }
        return super.onTouchEvent(ev);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.mScrollable) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }
}
