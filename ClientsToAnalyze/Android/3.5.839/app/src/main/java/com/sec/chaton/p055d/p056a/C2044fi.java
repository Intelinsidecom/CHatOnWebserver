package com.sec.chaton.p055d.p056a;

import android.content.Context;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.LinkedHashMap;

/* compiled from: VerifySMSTask.java */
/* renamed from: com.sec.chaton.d.a.fi */
/* loaded from: classes.dex */
public class C2044fi extends AbstractC1900a {

    /* renamed from: b */
    private String f7480b;

    /* renamed from: c */
    private String f7481c;

    /* renamed from: d */
    private String f7482d;

    /* renamed from: e */
    private Context f7483e;

    public C2044fi(C2454e c2454e, String str, String str2, String str3) {
        super(c2454e);
        this.f7480b = str;
        this.f7481c = str2;
        this.f7482d = str3;
        this.f7483e = CommonApplication.m18732r();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap(3);
        linkedHashMap.put("msisdn", this.f7480b);
        linkedHashMap.put("token", this.f7481c);
        linkedHashMap.put("authnum", this.f7482d);
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            C4904y.m18641c("Success, verifySMS task", getClass().getSimpleName());
        }
    }
}
