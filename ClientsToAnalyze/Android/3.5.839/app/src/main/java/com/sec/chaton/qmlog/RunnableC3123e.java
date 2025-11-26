package com.sec.chaton.qmlog;

import android.os.SystemClock;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5052r;

/* compiled from: QMLogManager.java */
/* renamed from: com.sec.chaton.qmlog.e */
/* loaded from: classes.dex */
class RunnableC3123e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3122d f11486a;

    RunnableC3123e(C3122d c3122d) {
        this.f11486a = c3122d;
    }

    @Override // java.lang.Runnable
    public void run() {
        C3128j c3128j = new C3128j();
        if (c3128j.m12757a("ntp.ubuntu.com", 30000)) {
            long jM12756a = c3128j.m12756a();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jCurrentTimeMillis = System.currentTimeMillis() - ((jM12756a + jElapsedRealtime) - c3128j.m12758b());
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("The old value to revice the time of device : ", String.valueOf(C4809aa.m18104a().m18118a("qmlog_revice_time", 0L))), C3122d.f11476a);
                C4904y.m18639b(C5052r.m19199a("The new value to revice the time of device : ", String.valueOf(jCurrentTimeMillis)), C3122d.f11476a);
            }
            C4809aa.m18104a().m18124a("qmlog_revice_time", Long.valueOf(jCurrentTimeMillis));
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("Fail to retrieve the value to revice the time of device"), C3122d.f11476a);
        }
    }
}
