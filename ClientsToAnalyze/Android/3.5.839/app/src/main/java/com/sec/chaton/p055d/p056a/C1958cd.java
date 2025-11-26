package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;

/* compiled from: GetPostONBlindListTask.java */
/* renamed from: com.sec.chaton.d.a.cd */
/* loaded from: classes.dex */
public class C1958cd extends AbstractC1900a {
    public C1958cd(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18646e("beforeRequest", "GetPostONBlindListTask");
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        C4904y.m18646e("afterRequest", "GetPostONBlindListTask");
        if (!c0778b.m18954n() || c0778b.m3110e() == null || c0778b.m3107b() == EnumC2464o.ERROR) {
            C2404a.m10430a("01000004", "1201", c0778b);
        }
    }
}
