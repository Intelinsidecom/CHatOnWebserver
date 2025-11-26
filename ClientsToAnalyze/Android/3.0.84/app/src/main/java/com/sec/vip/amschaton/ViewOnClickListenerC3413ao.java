package com.sec.vip.amschaton;

import android.os.Handler;
import android.view.View;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.ao */
/* loaded from: classes.dex */
class ViewOnClickListenerC3413ao implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3412an f12514a;

    ViewOnClickListenerC3413ao(C3412an c3412an) {
        this.f12514a = c3412an;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new Handler().postDelayed(new RunnableC3414ap(this), 100L);
    }
}
