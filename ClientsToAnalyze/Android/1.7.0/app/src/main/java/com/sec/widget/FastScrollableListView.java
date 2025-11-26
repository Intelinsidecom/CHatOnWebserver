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
    private C1636x f5664a;

    /* renamed from: b */
    private AbsListView.OnScrollListener f5665b;

    public FastScrollableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        super.setFastScrollEnabled(false);
        if (z) {
            if (this.f5664a == null) {
                this.f5664a = new C1636x(getContext(), this);
            }
        } else if (this.f5664a != null) {
            this.f5664a.m5938b();
            this.f5664a = null;
        }
        setOnScrollListener(this.f5665b);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f5664a != null) {
            this.f5664a.m5933a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.f5664a == null || !this.f5664a.m5939b(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f5664a != null) {
            this.f5664a.m5934a(canvas);
        }
        setVerticalScrollBarEnabled(this.f5664a == null || !this.f5664a.m5940c());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f5664a == null || !this.f5664a.m5937a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f5665b = onScrollListener;
        super.setOnScrollListener(new C1615c(this));
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f5664a != null) {
            this.f5664a.m5938b();
        }
    }
}
