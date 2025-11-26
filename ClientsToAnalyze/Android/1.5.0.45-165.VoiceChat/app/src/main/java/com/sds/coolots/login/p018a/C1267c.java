package com.sds.coolots.login.p018a;

import com.sds.coolots.MainApplication;
import java.util.ArrayList;

/* renamed from: com.sds.coolots.login.a.c */
/* loaded from: classes.dex */
class C1267c extends Thread {

    /* renamed from: a */
    final /* synthetic */ C1266b f3190a;

    private C1267c(C1266b c1266b) {
        this.f3190a = c1266b;
    }

    /* synthetic */ C1267c(C1266b c1266b, C1267c c1267c) {
        this(c1266b);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f3190a.m3054e("Begin ##############################################");
        this.f3190a.f3189f.m3050c();
        ArrayList arrayListM3043a = this.f3190a.f3189f.m3043a(C1268d.f3191a);
        if (arrayListM3043a != null && !arrayListM3043a.isEmpty()) {
            this.f3190a.m3058a(arrayListM3043a);
        }
        MainApplication.mConfig.setNationalCodeVersion("20120829");
        this.f3190a.m3054e("End ##############################################");
    }
}
