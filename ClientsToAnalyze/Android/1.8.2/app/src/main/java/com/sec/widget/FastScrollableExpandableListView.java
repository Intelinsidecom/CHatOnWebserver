package com.sec.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.ExpandableListView;

/* loaded from: classes.dex */
public class FastScrollableExpandableListView extends ExpandableListView {

    /* renamed from: a */
    private C2149u f7719a;

    /* renamed from: b */
    private AbsListView.OnScrollListener f7720b;

    public FastScrollableExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        super.setFastScrollEnabled(false);
        if (z) {
            if (this.f7719a == null) {
                this.f7719a = new C2149u(getContext(), this);
            }
        } else if (this.f7719a != null) {
            this.f7719a.m7530b();
            this.f7719a = null;
        }
        setOnScrollListener(this.f7720b);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f7719a != null) {
            this.f7719a.m7525a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.f7719a == null || !this.f7719a.m7531b(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f7719a != null) {
            this.f7719a.m7526a(canvas);
        }
        setVerticalScrollBarEnabled(this.f7719a == null || !this.f7719a.m7532c());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f7719a == null || !this.f7719a.m7529a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f7720b = onScrollListener;
        super.setOnScrollListener(new C2148t(this));
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f7719a != null) {
            this.f7719a.m7530b();
        }
    }
}
