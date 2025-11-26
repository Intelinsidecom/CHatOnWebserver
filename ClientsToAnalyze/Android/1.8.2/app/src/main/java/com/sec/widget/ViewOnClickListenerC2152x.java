package com.sec.widget;

import android.app.Activity;
import android.view.View;

/* compiled from: GeneralHeaderView.java */
/* renamed from: com.sec.widget.x */
/* loaded from: classes.dex */
class ViewOnClickListenerC2152x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeneralHeaderView f7845a;

    ViewOnClickListenerC2152x(GeneralHeaderView generalHeaderView) {
        this.f7845a = generalHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getContext() instanceof Activity) {
            ((Activity) view.getContext()).finish();
        }
    }
}
