package com.sec.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class HeightChangedListView extends ListView {

    /* renamed from: a */
    private InterfaceC5181x f18770a;

    public HeightChangedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnHeightChangedListener(InterfaceC5181x interfaceC5181x) {
        this.f18770a = interfaceC5181x;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        C4904y.m18641c("onSizeChanged " + i3 + " x " + i4 + " -> " + i + " x " + i2, getClass().getSimpleName());
        super.onSizeChanged(i, i2, i3, i4);
        if (getTranscriptMode() == 2) {
            setSelectionFromTop(getCount(), 0);
        }
        if (i == i3 && i2 != 0 && i4 != 0 && this.f18770a != null && i2 != i4) {
            this.f18770a.mo8227a(this, ((double) i2) > ((double) i4) * 1.4d);
        }
    }
}
