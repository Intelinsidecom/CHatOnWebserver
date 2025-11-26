package com.sec.chaton.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class CustomViewPager extends ViewPager {

    /* renamed from: a */
    private boolean f17891a;

    public CustomViewPager(Context context) {
        super(context);
        this.f17891a = false;
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17891a = false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f17891a) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f17891a) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollDisable(boolean z) {
        this.f17891a = z;
    }
}
