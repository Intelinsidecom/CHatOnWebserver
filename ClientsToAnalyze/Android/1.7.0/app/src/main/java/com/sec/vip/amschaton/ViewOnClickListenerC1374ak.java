package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.ak */
/* loaded from: classes.dex */
class ViewOnClickListenerC1374ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1395be f4819a;

    ViewOnClickListenerC1374ak(C1395be c1395be) {
        this.f4819a = c1395be;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4819a.f4896m = new DialogC1363a(this.f4819a.m5646a());
        this.f4819a.f4896m.m4862a(this.f4819a.f4890g);
        this.f4819a.f4896m.m4863a(new C1381ar(this));
        this.f4819a.f4896m.show();
    }
}
