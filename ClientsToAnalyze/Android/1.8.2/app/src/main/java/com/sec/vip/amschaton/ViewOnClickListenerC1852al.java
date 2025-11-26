package com.sec.vip.amschaton;

import android.os.Handler;
import android.view.View;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.al */
/* loaded from: classes.dex */
class ViewOnClickListenerC1852al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1851ak f6803a;

    ViewOnClickListenerC1852al(C1851ak c1851ak) {
        this.f6803a = c1851ak;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new Handler().postDelayed(new RunnableC1853am(this), 100L);
    }
}
