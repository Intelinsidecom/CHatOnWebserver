package com.sec.vip.amschaton;

import android.os.Handler;
import android.view.View;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.aj */
/* loaded from: classes.dex */
class ViewOnClickListenerC1373aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1395be f4818a;

    ViewOnClickListenerC1373aj(C1395be c1395be) {
        this.f4818a = c1395be;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new Handler().postDelayed(new RunnableC1546k(this), 100L);
    }
}
