package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.LinkedHashMap;

/* compiled from: UnFollowSpecialBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.fa */
/* loaded from: classes.dex */
public class C2036fa extends AbstractC1900a {

    /* renamed from: b */
    private String f7441b;

    public C2036fa(C2454e c2454e, String str) {
        super(c2454e);
        this.f7441b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("specialuserid", this.f7441b);
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            new C2128i(null).m9515c();
            C4904y.m18639b("success - LIVEpatner unfollow, id = " + this.f7441b, getClass().getSimpleName());
        } else {
            C4904y.m18639b("fail - LIVEpatner unfollow, id = " + this.f7441b, getClass().getSimpleName());
        }
    }
}
