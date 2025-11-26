package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p018b.C0454b;
import com.sec.chaton.p035io.entry.CheckInRegisterParamEntry;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import java.util.LinkedHashMap;

/* compiled from: CheckInRegisterParamTask.java */
/* renamed from: com.sec.chaton.d.a.ad */
/* loaded from: classes.dex */
public class C1149ad extends AbstractC1145a {

    /* renamed from: b */
    private String f4584b;

    /* renamed from: c */
    private String f4585c;

    /* renamed from: e */
    private boolean f4586e;

    public C1149ad(Handler handler, C1580h c1580h, String str, boolean z) {
        super(handler, c1580h);
        this.f4584b = str;
        this.f4585c = null;
        this.f4586e = z;
    }

    public C1149ad(Handler handler, C1580h c1580h, String str, String str2) {
        super(handler, c1580h);
        this.f4584b = str;
        this.f4585c = str2;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        String strM10979a = C3159aa.m10962a().m10979a("uid", (String) null);
        if (!TextUtils.isEmpty(this.f4584b)) {
            linkedHashMap.put("msisdn", this.f4584b);
        }
        linkedHashMap.put("imei", C3171am.m11045a());
        if (!TextUtils.isEmpty(strM10979a) && this.f4586e) {
            linkedHashMap.put("update_msisdn", "true");
        }
        if (C1493a.m6463a("mum_enable_feature")) {
            long jM3079a = C0454b.m3079a();
            C3250y.m11453c("MUMID : " + jM3079a, getClass().getSimpleName());
            if (jM3079a >= 0) {
                linkedHashMap.put("mumid", Long.toString(jM3079a));
            }
        }
        if (!TextUtils.isEmpty(this.f4585c)) {
            linkedHashMap.put("emailsamsung", this.f4585c);
        }
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        if (C3250y.f11733a) {
            C3250y.m11456e(strM11026a, getClass().getSimpleName());
        }
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && C3250y.f11734b) {
            C3250y.m11450b("afterRequest : success, " + ((CheckInRegisterParamEntry) c0267d.m1354e()).toString(), getClass().getSimpleName());
        }
    }
}
