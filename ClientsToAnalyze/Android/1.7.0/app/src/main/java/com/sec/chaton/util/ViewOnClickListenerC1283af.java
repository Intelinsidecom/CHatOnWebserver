package com.sec.chaton.util;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC1283af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f4464a;

    ViewOnClickListenerC1283af(BlackScreenNotification blackScreenNotification) {
        this.f4464a = blackScreenNotification;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GlobalApplication.f2413g = true;
    }
}
