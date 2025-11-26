package com.sec.vip.amschaton;

import android.app.ProgressDialog;
import java.io.IOException;

/* renamed from: com.sec.vip.amschaton.j */
/* loaded from: classes.dex */
class C0707j extends Thread {

    /* renamed from: a */
    final /* synthetic */ ProgressDialog f4336a;

    /* renamed from: b */
    final /* synthetic */ AMSActivity f4337b;

    C0707j(AMSActivity aMSActivity, ProgressDialog progressDialog) {
        this.f4337b = aMSActivity;
        this.f4336a = progressDialog;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws IOException {
        this.f4337b.m3714d();
        this.f4337b.m3715e();
        this.f4337b.f3816a = true;
        this.f4336a.dismiss();
    }
}
