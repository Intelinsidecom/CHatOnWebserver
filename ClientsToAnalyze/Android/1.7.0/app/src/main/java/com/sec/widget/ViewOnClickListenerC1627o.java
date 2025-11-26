package com.sec.widget;

import android.app.Activity;
import android.view.View;
import com.sec.chaton.util.C1346u;

/* compiled from: GeneralHeaderView.java */
/* renamed from: com.sec.widget.o */
/* loaded from: classes.dex */
class ViewOnClickListenerC1627o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeneralHeaderView f5746a;

    ViewOnClickListenerC1627o(GeneralHeaderView generalHeaderView) {
        this.f5746a = generalHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a() && (view.getContext() instanceof Activity)) {
            ((Activity) view.getContext()).finish();
        }
    }
}
