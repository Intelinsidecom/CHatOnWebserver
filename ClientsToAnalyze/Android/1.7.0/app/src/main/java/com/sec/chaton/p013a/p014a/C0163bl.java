package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;

/* compiled from: UnBlockTask.java */
/* renamed from: com.sec.chaton.a.a.bl */
/* loaded from: classes.dex */
public class C0163bl extends AbstractRunnableC0153bb {
    public C0163bl(Handler handler, C0503j c0503j, String str) {
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
        if (c0259g.m927a() && c0259g.m928b() == EnumC0518y.SUCCESS) {
            new C0202ao(null).m762a(true);
        }
    }
}
