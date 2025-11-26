package com.sec.common.util.log.collector;

import android.database.SQLException;
import com.sec.common.C3330f;
import com.sec.common.util.C3364o;

/* compiled from: LogWriter.java */
/* renamed from: com.sec.common.util.log.collector.j */
/* loaded from: classes.dex */
class C3360j extends Thread {

    /* renamed from: a */
    public C3352b f12108a;

    /* renamed from: b */
    final /* synthetic */ C3358h f12109b;

    private C3360j(C3358h c3358h) {
        this.f12109b = c3358h;
    }

    /* synthetic */ C3360j(C3358h c3358h, ThreadFactoryC3359i threadFactoryC3359i) {
        this(c3358h);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws SQLException {
        super.run();
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(C3358h.f12103a, C3364o.m11849a("Save log to database. (" + this.f12108a.f12095b, ",", this.f12108a.f12096c + ")"));
        }
        C3351a.m11819a(this.f12108a);
        try {
            this.f12109b.f12106d.mo13369a(this);
            if (this.f12108a.getClass().equals(C3352b.class)) {
                C3355e.m11837a(this.f12108a);
            }
        } catch (Exception e) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(C3358h.f12103a, e.getMessage(), e);
            }
        }
    }
}
