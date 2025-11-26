package com.sec.chaton.p055d.p056a;

import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import java.util.LinkedHashMap;

/* compiled from: AcceptDisclaimerTask.java */
/* renamed from: com.sec.chaton.d.a.e */
/* loaded from: classes.dex */
public class C2008e extends AbstractC1900a {

    /* renamed from: b */
    private String f7378b;

    public C2008e(C2454e c2454e, String str) {
        super(c2454e);
        this.f7378b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("imei", C4822an.m18228d());
        if (C4822an.m18218a()) {
            linkedHashMap.put("iso", TextUtils.isEmpty(C4822an.m18257y()) ? "GB" : C4822an.m18257y());
        } else {
            linkedHashMap.put("iso", TextUtils.isEmpty(C4822an.m18253u()) ? "GB" : C4822an.m18253u());
        }
        if (this.f7378b != null && !this.f7378b.equals("FIRST")) {
            linkedHashMap.put("disclaimerUID", this.f7378b);
        }
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            C4904y.m18639b("Success to accept disclaimer", getClass().getSimpleName());
        } else {
            C2404a.m10430a("01000002", "0301", c0778b);
        }
    }
}
