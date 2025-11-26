package com.sec.vip.amschaton;

import android.os.Handler;
import android.view.View;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.ay */
/* loaded from: classes.dex */
class ViewOnClickListenerC1388ay implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1369af f4880a;

    ViewOnClickListenerC1388ay(C1369af c1369af) {
        this.f4880a = c1369af;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new Handler().postDelayed(new RunnableC1559x(this), 100L);
    }
}
