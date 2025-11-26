package com.sec.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class HeightChangedListView extends ListView {

    /* renamed from: a */
    private InterfaceC2154z f7727a;

    public HeightChangedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnHeightChangedListener(InterfaceC2154z interfaceC2154z) {
        this.f7727a = interfaceC2154z;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        C1786r.m6063c("onSizeChanged " + i3 + " x " + i4 + " -> " + i + " x " + i2, getClass().getSimpleName());
        if (i == i3 && i2 != 0 && i4 != 0 && this.f7727a != null && i2 != i4) {
            this.f7727a.mo2677a(this, ((double) i2) > ((double) i4) * 1.4d);
        }
    }
}
