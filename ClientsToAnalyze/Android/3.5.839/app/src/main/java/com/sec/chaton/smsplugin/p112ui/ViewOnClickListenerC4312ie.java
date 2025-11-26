package com.sec.chaton.smsplugin.p112ui;

import android.view.View;

/* compiled from: SlideView.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ie */
/* loaded from: classes.dex */
class ViewOnClickListenerC4312ie implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SlideView f15706a;

    ViewOnClickListenerC4312ie(SlideView slideView) {
        this.f15706a = slideView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f15706a.f15146p != null) {
            this.f15706a.f15146p.show();
        }
    }
}
