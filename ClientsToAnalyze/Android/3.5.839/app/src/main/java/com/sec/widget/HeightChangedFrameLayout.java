package com.sec.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class HeightChangedFrameLayout extends ScrollView {

    /* renamed from: a */
    private InterfaceC5180w f18769a;

    public HeightChangedFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnHeightChangedScrollListener(InterfaceC5180w interfaceC5180w) {
        this.f18769a = interfaceC5180w;
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        C4904y.m18641c("onSizeChanged " + i3 + " x " + i4 + " -> " + i + " x " + i2, getClass().getSimpleName());
        if (i == i3 && i2 != 0 && i4 != 0 && this.f18769a != null && i2 != i4) {
            this.f18769a.m19812a(this, ((double) i2) > ((double) i4) * 1.4d);
        }
    }
}
