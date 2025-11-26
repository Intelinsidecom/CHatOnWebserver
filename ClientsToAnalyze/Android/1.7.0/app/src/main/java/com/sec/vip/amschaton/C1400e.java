package com.sec.vip.amschaton;

import android.app.ProgressDialog;

/* compiled from: AMSActivity.java */
/* renamed from: com.sec.vip.amschaton.e */
/* loaded from: classes.dex */
class C1400e extends Thread {

    /* renamed from: a */
    final /* synthetic */ ProgressDialog f4921a;

    /* renamed from: b */
    final /* synthetic */ AMSActivity f4922b;

    C1400e(AMSActivity aMSActivity, ProgressDialog progressDialog) {
        this.f4922b = aMSActivity;
        this.f4921a = progressDialog;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f4922b.m4741d();
        this.f4922b.f4632a = true;
        this.f4921a.dismiss();
    }
}
