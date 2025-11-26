package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;

/* compiled from: SetChatProfileTitleTask.java */
/* renamed from: com.sec.chaton.d.a.eo */
/* loaded from: classes.dex */
public class C2023eo extends AbstractC1900a {
    public C2023eo(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18639b("[Before request]", getClass().getSimpleName());
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        C4904y.m18639b("[After request]", getClass().getSimpleName());
        if (c0778b.m3107b() != EnumC2464o.SUCCESS) {
            C2404a.m10430a("01000006", "1007", c0778b);
        }
    }
}
