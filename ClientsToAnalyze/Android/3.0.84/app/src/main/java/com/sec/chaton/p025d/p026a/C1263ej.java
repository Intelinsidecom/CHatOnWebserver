package com.sec.chaton.p025d.p026a;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.LinkedHashMap;

/* compiled from: VerifySMSTask.java */
/* renamed from: com.sec.chaton.d.a.ej */
/* loaded from: classes.dex */
public class C1263ej extends AbstractC1145a {

    /* renamed from: b */
    private String f4853b;

    /* renamed from: c */
    private String f4854c;

    /* renamed from: e */
    private String f4855e;

    /* renamed from: f */
    private Context f4856f;

    public C1263ej(Handler handler, C1580h c1580h, String str, String str2, String str3) {
        super(handler, c1580h);
        this.f4853b = str;
        this.f4854c = str2;
        this.f4855e = str3;
        this.f4856f = CommonApplication.m11493l();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap(3);
        linkedHashMap.put("msisdn", this.f4853b);
        linkedHashMap.put("token", this.f4854c);
        linkedHashMap.put("authnum", this.f4855e);
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            C3250y.m11453c("Success, verifySMS task", getClass().getSimpleName());
        }
    }
}
