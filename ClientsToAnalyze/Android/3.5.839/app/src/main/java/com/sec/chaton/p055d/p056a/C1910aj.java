package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.LinkedHashMap;

/* compiled from: DeleteMappingAccountTask.java */
/* renamed from: com.sec.chaton.d.a.aj */
/* loaded from: classes.dex */
public class C1910aj extends AbstractC1900a {

    /* renamed from: b */
    String f7130b;

    public C1910aj(C2454e c2454e, String str) {
        super(c2454e);
        this.f7130b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("email", C4809aa.m18104a().m18121a("samsung_account_email", ""));
        linkedHashMap.put("chatonid", this.f7130b);
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Success, Device ID : " + this.f7130b, getClass().getSimpleName());
            }
        } else if (C4904y.f17873c) {
            C4904y.m18641c("Fail, Device ID : " + this.f7130b, getClass().getSimpleName());
        }
    }
}
