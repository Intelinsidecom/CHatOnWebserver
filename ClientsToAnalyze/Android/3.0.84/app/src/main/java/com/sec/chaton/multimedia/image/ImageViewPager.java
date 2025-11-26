package com.sec.chaton.multimedia.image;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class ImageViewPager extends ViewPager {

    /* renamed from: a */
    private boolean f6961a;

    public ImageViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6961a = true;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f6961a) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
            }
        }
        return false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f6961a) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
            }
        }
        return false;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.f6961a = z;
    }
}
