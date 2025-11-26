package com.sec.chaton.p018c.p019a;

import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1341p;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.c.a.i */
/* loaded from: classes.dex */
class RunnableC0472i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC0466c f1506a;

    RunnableC0472i(AsyncTaskC0466c asyncTaskC0466c) {
        this.f1506a = asyncTaskC0466c;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1506a.f1472j != null) {
            this.f1506a.f1472j.setVisibility(4);
        }
        if (this.f1506a.f1473k != null) {
            this.f1506a.f1473k.setVisibility(4);
        }
        if (this.f1506a.f1474l != null) {
            this.f1506a.f1474l.setVisibility(4);
        }
        C0635o.m2942b(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(this.f1506a.f1468f));
        if (C0473j.m2410a().m2416d(this.f1506a.f1468f)) {
            C1341p.m4658b("Successfully removed from hashmap", getClass().getName());
        }
        this.f1506a.f1483u.show();
    }
}
