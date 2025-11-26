package com.samsung.sdraw;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.samsung.sdraw.PalletView;

/* loaded from: classes.dex */
public class PenSettingRootView extends LinearLayout {

    /* renamed from: a */
    private PalletView.InterfaceC0975a f1128a;

    public PenSettingRootView(Context context) {
        super(context);
    }

    public PenSettingRootView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PenSettingRootView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.f1128a != null) {
            this.f1128a.mo802a(changed, left, top, right, bottom);
        }
    }

    public void setOnLayoutListener(PalletView.InterfaceC0975a l) {
        this.f1128a = l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            requestDisallowInterceptTouchEvent(true);
        } else if (action == 3 || action == 1) {
            requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallow) {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }
}
