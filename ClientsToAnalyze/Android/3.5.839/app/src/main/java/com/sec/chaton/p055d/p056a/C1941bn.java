package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.LinkedHashMap;

/* compiled from: GetBuddyMappingInfoTask.java */
/* renamed from: com.sec.chaton.d.a.bn */
/* loaded from: classes.dex */
public class C1941bn extends AbstractC1900a {

    /* renamed from: b */
    private String f7236b;

    public C1941bn(C2454e c2454e, String str) {
        super(c2454e);
        this.f7236b = null;
    }

    public C1941bn(C2454e c2454e, String str, String str2) {
        super(c2454e);
        this.f7236b = null;
        this.f7236b = str2;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18646e("beforeRequest", "GetBuddyMappingInfoTask");
        if (this.f7236b == null) {
            return null;
        }
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("email", C4809aa.m18104a().m18121a("samsung_account_email", ""));
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
    }
}
