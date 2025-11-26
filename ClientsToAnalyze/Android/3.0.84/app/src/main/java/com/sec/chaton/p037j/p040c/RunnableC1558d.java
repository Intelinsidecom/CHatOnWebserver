package com.sec.chaton.p037j.p040c;

import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.j.c.d */
/* loaded from: classes.dex */
class RunnableC1558d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1557c f5770a;

    RunnableC1558d(AsyncTaskC1557c asyncTaskC1557c) {
        this.f5770a = asyncTaskC1557c;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5770a.f5754j != null) {
            this.f5770a.f5754j.setVisibility(4);
        }
        if (this.f5770a.f5755k != null) {
            this.f5770a.f5755k.setVisibility(4);
        }
        if (this.f5770a.f5756l != null) {
            this.f5770a.f5756l.setVisibility(4);
        }
        C1373q.m6193c(CommonApplication.m11493l().getContentResolver(), Long.valueOf(this.f5770a.f5750f));
        if (C1555a.m6596a().m6603d(this.f5770a.f5750f)) {
            C3250y.m11450b("Successfully removed from hashmap", getClass().getName());
        }
        if (!this.f5770a.f5748d) {
            this.f5770a.f5765u.show();
        }
    }
}
