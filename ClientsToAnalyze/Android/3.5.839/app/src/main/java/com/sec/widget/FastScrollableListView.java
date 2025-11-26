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
    private C5177t f18767a;

    /* renamed from: b */
    private AbsListView.OnScrollListener f18768b;

    public FastScrollableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        super.setFastScrollEnabled(false);
        if (z) {
            if (this.f18767a == null) {
                this.f18767a = new C5177t(getContext(), this);
            }
        } else if (this.f18767a != null) {
            this.f18767a.m19805b();
            this.f18767a = null;
        }
        setOnScrollListener(this.f18768b);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f18767a != null) {
            this.f18767a.m19800a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.f18767a == null || !this.f18767a.m19806b(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f18767a != null) {
            this.f18767a.m19801a(canvas);
        }
        setVerticalScrollBarEnabled(this.f18767a == null || !this.f18767a.m19807c());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f18767a == null || !this.f18767a.m19804a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f18768b = onScrollListener;
        super.setOnScrollListener(new C5176s(this));
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f18767a != null) {
            this.f18767a.m19805b();
        }
    }
}
