package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1580h;

/* compiled from: CheckBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.ac */
/* loaded from: classes.dex */
public class C1148ac extends AbstractC1145a {

    /* renamed from: b */
    private int f4583b;

    public C1148ac(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n()) {
            this.f4583b = c0267d.m1355f();
        } else {
            this.f4583b = -1;
        }
    }

    /* renamed from: i */
    public int m5505i() {
        return this.f4583b;
    }
}
