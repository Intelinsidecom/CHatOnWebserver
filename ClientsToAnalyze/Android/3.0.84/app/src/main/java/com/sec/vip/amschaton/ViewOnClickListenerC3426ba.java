package com.sec.vip.amschaton;

import android.os.Handler;
import android.view.View;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.ba */
/* loaded from: classes.dex */
class ViewOnClickListenerC3426ba implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3424az f12558a;

    ViewOnClickListenerC3426ba(C3424az c3424az) {
        this.f12558a = c3424az;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new Handler().postDelayed(new RunnableC3427bb(this), 100L);
    }
}
