package com.sec.chaton.p025d;

import android.os.Handler;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p025d.p026a.AbstractC1199c;
import com.sec.chaton.p037j.C1544ac;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: TaskContainer.java */
/* renamed from: com.sec.chaton.d.bd */
/* loaded from: classes.dex */
public class C1318bd {

    /* renamed from: a */
    private ArrayList<C1321bg> f4984a;

    /* renamed from: b */
    private Handler f4985b;

    /* renamed from: c */
    private Handler f4986c;

    /* renamed from: d */
    private int f4987d;

    /* renamed from: e */
    private C1544ac f4988e;

    /* renamed from: f */
    private long f4989f;

    /* renamed from: e */
    static /* synthetic */ int m5677e(C1318bd c1318bd) {
        int i = c1318bd.f4987d;
        c1318bd.f4987d = i + 1;
        return i;
    }

    public C1318bd(Handler handler, C1544ac c1544ac) {
        this.f4987d = 0;
        this.f4984a = new ArrayList<>();
        this.f4986c = handler;
        this.f4988e = c1544ac;
        this.f4989f = C3193bh.m11148a();
        m5679a(new HandlerC1320bf(this, handler.getLooper()));
    }

    public C1318bd(Handler handler, C1544ac c1544ac, long j) {
        this.f4987d = 0;
        this.f4984a = new ArrayList<>();
        this.f4986c = handler;
        this.f4988e = c1544ac;
        this.f4989f = j;
        m5679a(new HandlerC1320bf(this, handler.getLooper()));
    }

    /* renamed from: a */
    public long m5678a() {
        return this.f4989f;
    }

    /* renamed from: a */
    public void m5679a(Handler handler) {
        this.f4985b = handler;
    }

    /* renamed from: b */
    public Handler m5681b() {
        return this.f4985b;
    }

    /* renamed from: a */
    public boolean m5680a(EnumC1322bh enumC1322bh, Object obj) {
        C3250y.m11450b("AddTaskToList : " + String.valueOf(enumC1322bh.m5688a()), "TaskContainer");
        return this.f4984a.add(new C1321bg(this, enumC1322bh, obj));
    }

    /* renamed from: c */
    public Object m5682c() {
        C1321bg c1321bg = this.f4984a.get(this.f4987d);
        if (c1321bg == null) {
            return null;
        }
        return c1321bg.m5687b();
    }

    /* renamed from: d */
    public boolean m5683d() {
        if (this.f4984a.size() == 0 || this.f4987d >= this.f4984a.size()) {
            return false;
        }
        C1321bg c1321bg = this.f4984a.get(this.f4987d);
        switch (c1321bg.m5686a()) {
            case HttpTask:
                C1595w.m6742a().m6745b().m6723a((AbstractC1145a) c1321bg.m5687b());
                return true;
            case NetTask:
                ((AbstractC1199c) c1321bg.m5687b()).m5540a(this.f4988e);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: e */
    public boolean m5684e() {
        if (this.f4987d + 1 < this.f4984a.size()) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public void m5685f() {
        this.f4987d++;
    }
}
