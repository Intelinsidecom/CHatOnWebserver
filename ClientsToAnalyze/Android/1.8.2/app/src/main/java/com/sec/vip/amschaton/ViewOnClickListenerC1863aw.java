package com.sec.vip.amschaton;

import android.os.Handler;
import android.view.View;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.aw */
/* loaded from: classes.dex */
class ViewOnClickListenerC1863aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1862av f6834a;

    ViewOnClickListenerC1863aw(C1862av c1862av) {
        this.f6834a = c1862av;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new Handler().postDelayed(new RunnableC1864ax(this), 100L);
    }
}
