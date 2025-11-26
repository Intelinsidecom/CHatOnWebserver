package com.sec.chaton;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.p016a.C0598n;

/* compiled from: ExitAppDialogActivity.java */
/* renamed from: com.sec.chaton.k */
/* loaded from: classes.dex */
class ViewOnClickListenerC0834k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExitAppDialogActivity f3054a;

    ViewOnClickListenerC0834k(ExitAppDialogActivity exitAppDialogActivity) {
        this.f3054a = exitAppDialogActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0598n.m2784f();
        this.f3054a.finish();
        GlobalApplication.m3261b(this.f3054a);
    }
}
