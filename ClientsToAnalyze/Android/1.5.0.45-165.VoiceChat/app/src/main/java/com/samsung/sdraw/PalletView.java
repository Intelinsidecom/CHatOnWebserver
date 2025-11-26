package com.samsung.sdraw;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class PalletView extends LinearLayout {
    public static final int CONTENT_HEIGHT = 594;
    public static final int CONTENT_HEIGHT_MARKER = 677;

    /* renamed from: a */
    private InterfaceC0975a f1096a;

    /* renamed from: com.samsung.sdraw.PalletView$a */
    interface InterfaceC0975a {
        /* renamed from: a */
        void mo802a(boolean z, int i, int i2, int i3, int i4);
    }

    public PalletView(Context context) {
        super(context);
    }

    public PalletView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PalletView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.f1096a != null) {
            this.f1096a.mo802a(changed, left, top, right, bottom);
        }
    }

    public void setOnLayoutListener(InterfaceC0975a l) {
        this.f1096a = l;
    }
}
