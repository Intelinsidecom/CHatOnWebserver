package com.sec.chaton.p055d.p056a;

import android.text.TextUtils;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.p065io.entry.CheckInRegisterParamEntry;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import java.util.LinkedHashMap;

/* compiled from: CheckInRegisterParamTask.java */
/* renamed from: com.sec.chaton.d.a.z */
/* loaded from: classes.dex */
public class C2067z extends AbstractC1900a {

    /* renamed from: b */
    private String f7543b;

    /* renamed from: c */
    private String f7544c;

    /* renamed from: d */
    private String f7545d;

    /* renamed from: e */
    private String f7546e;

    /* renamed from: g */
    private boolean f7547g;

    public C2067z(C2454e c2454e, String str, boolean z) {
        super(c2454e);
        this.f7543b = str;
        this.f7544c = null;
        this.f7547g = z;
    }

    public C2067z(C2454e c2454e, String str, String str2) {
        super(c2454e);
        this.f7543b = str;
        this.f7544c = str2;
    }

    public C2067z(C2454e c2454e, C2105bk c2105bk) {
        super(c2454e);
        this.f7545d = c2105bk.m9427b();
        this.f7546e = c2105bk.m9424a();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        String strM18121a = C4809aa.m18104a().m18121a("uid", (String) null);
        if (!TextUtils.isEmpty(this.f7543b)) {
            linkedHashMap.put("msisdn", this.f7543b);
        }
        linkedHashMap.put("imei", C4822an.m18228d());
        if (!TextUtils.isEmpty(strM18121a) && this.f7547g) {
            linkedHashMap.put("update_msisdn", "true");
        }
        if (C2349a.m10301a("mum_enable_feature")) {
            long jM6155a = C1057b.m6155a();
            C4904y.m18641c("MUMID : " + jM6155a, getClass().getSimpleName());
            if (jM6155a >= 0) {
                linkedHashMap.put("mumid", Long.toString(jM6155a));
            }
        }
        if (!TextUtils.isEmpty(this.f7544c)) {
            linkedHashMap.put("emailsamsung", this.f7544c);
        }
        if (!TextUtils.isEmpty(this.f7545d) && !TextUtils.isEmpty(this.f7546e)) {
            linkedHashMap.put("snsid", this.f7545d);
            linkedHashMap.put("sns_sp", this.f7546e);
        }
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        if (C4904y.f17871a) {
            C4904y.m18646e(strM18172a, getClass().getSimpleName());
        }
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && C4904y.f17872b) {
            C4904y.m18639b("afterRequest : success, " + ((CheckInRegisterParamEntry) c0778b.m3110e()).toString(), getClass().getSimpleName());
        }
    }
}
