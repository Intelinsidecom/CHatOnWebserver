package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.widget.ScrollView;

/* compiled from: SlideView.java */
/* renamed from: com.sec.chaton.smsplugin.ui.id */
/* loaded from: classes.dex */
class C4311id extends ScrollView {

    /* renamed from: a */
    final /* synthetic */ SlideView f15704a;

    /* renamed from: b */
    private int f15705b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4311id(SlideView slideView, Context context) {
        super(context);
        this.f15704a = slideView;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getChildCount() > 0) {
            int height = getChildAt(0).getHeight();
            int height2 = getHeight();
            this.f15705b = height2 < height ? height - height2 : 0;
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        if ((i2 == 0 || i2 >= this.f15705b) && this.f15704a.f15146p != null) {
            this.f15704a.f15146p.show();
        }
    }
}
