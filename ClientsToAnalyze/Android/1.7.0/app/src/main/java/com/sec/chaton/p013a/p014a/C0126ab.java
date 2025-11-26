package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;

/* compiled from: CheckBuddyTask.java */
/* renamed from: com.sec.chaton.a.a.ab */
/* loaded from: classes.dex */
public class C0126ab extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private int f300a;

    public C0126ab(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a()) {
            this.f300a = c0259g.m934f();
        } else {
            this.f300a = -1;
        }
    }

    /* renamed from: b */
    public int m672b() {
        return this.f300a;
    }
}
