package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import org.apache.http.NameValuePair;

/* compiled from: GetVersionTask.java */
/* renamed from: com.sec.chaton.d.a.cw */
/* loaded from: classes.dex */
public class C1977cw extends AbstractC1900a {
    public C1977cw(C2454e c2454e) {
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
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            for (NameValuePair nameValuePair : c0778b.m3109d().m10633d()) {
                if (nameValuePair.getName().equals("regid")) {
                    String value = nameValuePair.getValue();
                    C4904y.m18639b("Save get version push registration id to pref: " + value, C1977cw.class.getSimpleName());
                    C4809aa.m18104a().m18128b("get_version_push_reg_id", value);
                }
            }
            return;
        }
        C2404a.m10430a("01000002", "0001", c0778b);
    }
}
