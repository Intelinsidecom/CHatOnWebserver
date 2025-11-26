package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.SendFreeSMSEntry;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;

/* compiled from: SendFreeSMSMSGTask.java */
/* renamed from: com.sec.chaton.d.a.eh */
/* loaded from: classes.dex */
public class C2016eh extends AbstractC1900a {
    public C2016eh(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
            SendFreeSMSEntry sendFreeSMSEntry = (SendFreeSMSEntry) c0778b.m3110e();
            if (C4904y.f17872b) {
                C4904y.m18639b("Request was success, result : " + sendFreeSMSEntry, getClass().getSimpleName());
            }
        }
    }
}
