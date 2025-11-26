package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p028io.entry.inner.SnsId;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.ArrayList;

/* compiled from: SetSNSIdTask.java */
/* renamed from: com.sec.chaton.d.a.bt */
/* loaded from: classes.dex */
public class C0579bt extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2307d;

    /* renamed from: e */
    private String f2308e;

    public C0579bt(Handler handler, C0798h c0798h, String str, String str2) {
        super(handler, c0798h);
        this.f2307d = str;
        this.f2308e = str2;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        ArrayList arrayList = new ArrayList();
        SnsId snsId = new SnsId();
        if (this.f2307d != null) {
            snsId.f3052sp = this.f2307d;
        }
        if (this.f2308e != null) {
            snsId.value = this.f2308e;
        }
        arrayList.add(snsId);
        String strM6112a = new C1793y().m6112a(arrayList);
        C1786r.m6061b(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        C1786r.m6061b("in SetSNSIdTask.afterRequest()", getClass().getSimpleName());
    }
}
