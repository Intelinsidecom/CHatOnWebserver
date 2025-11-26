package com.sec.common.util.log.collector;

import com.sec.common.C4996f;
import com.sec.common.util.C5052r;

/* compiled from: LogWriter.java */
/* renamed from: com.sec.common.util.log.collector.j */
/* loaded from: classes.dex */
class C5045j extends Thread {

    /* renamed from: a */
    public C5037b f18379a;

    /* renamed from: b */
    public boolean f18380b;

    /* renamed from: c */
    public boolean f18381c;

    /* renamed from: d */
    public boolean f18382d;

    /* renamed from: e */
    public int f18383e;

    /* renamed from: f */
    final /* synthetic */ C5043h f18384f;

    private C5045j(C5043h c5043h) {
        this.f18384f = c5043h;
    }

    /* synthetic */ C5045j(C5043h c5043h, ThreadFactoryC5044i threadFactoryC5044i) {
        this(c5043h);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        super.run();
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(C5043h.f18374a, C5052r.m19199a("Save log to database. (" + this.f18379a.f18358b, ",", this.f18379a.f18359c + ")"));
        }
        if (C5036a.m19132e()) {
            if (this.f18380b) {
                C5036a.m19121a(this.f18379a);
            } else if (this.f18381c) {
                C5036a.m19126b(this.f18379a);
            } else if (this.f18382d) {
                C5036a.m19129c(this.f18379a);
            } else if (this.f18383e != 0) {
                C5036a.m19122a(this.f18379a, this.f18383e);
            } else {
                C5036a.m19131d(this.f18379a);
            }
            try {
                this.f18384f.f18377d.mo19897a(this);
                if (this.f18379a.getClass().equals(C5037b.class)) {
                    C5040e.m19174a(this.f18379a);
                }
            } catch (Exception e) {
                if (C4996f.f18229a.f18174f) {
                    C4996f.f18229a.mo18649a(C5043h.f18374a, e.getMessage(), e);
                }
            }
        }
    }
}
