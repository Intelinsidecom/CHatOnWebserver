package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2433c;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: SendSMSTask.java */
/* renamed from: com.sec.chaton.d.a.ej */
/* loaded from: classes.dex */
public class C2018ej extends AbstractC1900a {

    /* renamed from: b */
    private String f7403b;

    public C2018ej(C2454e c2454e, String str) {
        super(c2454e);
        this.f7403b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.ERROR) {
            String str = c0778b.m18952l().get("exptime");
            if (str != null && str != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Response exptime : " + str + " Method : " + this.f7403b, C2433c.class.getSimpleName());
                }
                if (this.f7403b.equals("SMS")) {
                    C4809aa.m18108a("sms_expire_time", str);
                    return;
                } else {
                    if (this.f7403b.equals("ACS")) {
                        C4809aa.m18108a("acs_expire_time", str);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        C2404a.m10430a("01000002", "0402", c0778b);
    }
}
