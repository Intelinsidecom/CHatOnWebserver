package com.sec.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.ListView;

/* loaded from: classes.dex */
public class FastScrollableListView extends ListView {

    /* renamed from: a */
    private C3639ag f13400a;

    /* renamed from: b */
    private AbsListView.OnScrollListener f13401b;

    public FastScrollableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        super.setFastScrollEnabled(false);
        if (z) {
            if (this.f13400a == null) {
                this.f13400a = new C3639ag(getContext(), this);
            }
        } else if (this.f13400a != null) {
            this.f13400a.m13205b();
            this.f13400a = null;
        }
        setOnScrollListener(this.f13401b);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f13400a != null) {
            this.f13400a.m13200a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.f13400a == null || !this.f13400a.m13206b(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f13400a != null) {
            this.f13400a.m13201a(canvas);
        }
        setVerticalScrollBarEnabled(this.f13400a == null || !this.f13400a.m13207c());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f13400a == null || !this.f13400a.m13204a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f13401b = onScrollListener;
        super.setOnScrollListener(new C3638af(this));
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f13400a != null) {
            this.f13400a.m13205b();
        }
    }
}
