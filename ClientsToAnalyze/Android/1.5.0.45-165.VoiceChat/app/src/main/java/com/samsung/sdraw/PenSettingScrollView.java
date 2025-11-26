package com.samsung.sdraw;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes.dex */
public class PenSettingScrollView extends ScrollView {

    /* renamed from: a */
    private InterfaceC0978a f1129a;

    /* renamed from: com.samsung.sdraw.PenSettingScrollView$a */
    interface InterfaceC0978a {
        /* renamed from: a */
        void mo801a(int i);
    }

    public PenSettingScrollView(Context context) {
        super(context);
    }

    public PenSettingScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PenSettingScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOnScrollChangedListener(InterfaceC0978a l) {
        this.f1129a = l;
    }

    @Override // android.view.View
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (this.f1129a != null) {
            this.f1129a.mo801a(t);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
}
