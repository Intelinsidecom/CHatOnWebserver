package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.SnsId;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: SetSNSIdTask.java */
/* renamed from: com.sec.chaton.d.a.er */
/* loaded from: classes.dex */
public class C2026er extends AbstractC1900a {

    /* renamed from: b */
    private String f7425b;

    /* renamed from: c */
    private String f7426c;

    public C2026er(C2454e c2454e, String str, String str2) {
        super(c2454e);
        this.f7425b = str;
        this.f7426c = str2;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        ArrayList arrayList = new ArrayList();
        SnsId snsId = new SnsId();
        if (this.f7425b != null) {
            snsId.f8581sp = this.f7425b;
        }
        if (this.f7426c != null) {
            snsId.value = this.f7426c;
        }
        arrayList.add(snsId);
        String strM18172a = new C4815ag().m18172a(arrayList);
        C4904y.m18639b(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        C4904y.m18639b("in SetSNSIdTask.afterRequest()", getClass().getSimpleName());
    }
}
