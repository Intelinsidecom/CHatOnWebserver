package com.sec.chaton.util;

import android.view.View;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC1773e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f6432a;

    ViewOnClickListenerC1773e(BlackScreenNotification blackScreenNotification) {
        this.f6432a = blackScreenNotification;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6432a.f6238D = true;
    }
}
