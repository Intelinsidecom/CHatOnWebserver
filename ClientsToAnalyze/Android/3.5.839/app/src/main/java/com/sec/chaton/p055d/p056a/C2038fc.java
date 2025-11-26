package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.LinkedHashMap;

/* compiled from: UpdateMSISDNTask.java */
/* renamed from: com.sec.chaton.d.a.fc */
/* loaded from: classes.dex */
public class C2038fc extends AbstractC1900a {

    /* renamed from: b */
    private String f7444b;

    /* renamed from: c */
    private String f7445c;

    /* renamed from: d */
    private String f7446d;

    public C2038fc(C2454e c2454e, String str, String str2, String str3) {
        super(c2454e);
        this.f7444b = str;
        this.f7445c = str2;
        this.f7446d = str3;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("msisdn", this.f7444b);
        linkedHashMap.put("token", this.f7445c);
        linkedHashMap.put("authnum", this.f7446d);
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (!c0778b.m18954n() || c0778b.m3110e() == null || c0778b.m3107b() == EnumC2464o.ERROR) {
            C2404a.m10430a("01000002", "0105", c0778b);
        }
    }
}
