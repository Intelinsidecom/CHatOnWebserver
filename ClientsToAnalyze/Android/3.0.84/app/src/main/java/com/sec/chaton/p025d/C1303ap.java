package com.sec.chaton.p025d;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p025d.p026a.C1149ad;
import com.sec.chaton.p025d.p026a.C1156ak;
import com.sec.chaton.p025d.p026a.C1236dj;
import com.sec.chaton.p025d.p026a.C1247du;
import com.sec.chaton.p025d.p026a.C1263ej;
import com.sec.chaton.p035io.entry.CheckInRegisterParamEntry;
import com.sec.chaton.p035io.entry.SkipSMSVerifyServer;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;

/* compiled from: RegistrationControl.java */
/* renamed from: com.sec.chaton.d.ap */
/* loaded from: classes.dex */
public class C1303ap {

    /* renamed from: a */
    private Handler f4933a;

    public C1303ap(Handler handler) {
        this.f4933a = handler;
    }

    /* renamed from: a */
    public void m5601a(String str, String str2, String str3, String str4) {
        C1595w.m6742a().m6745b().m6723a(new C1236dj(this.f4933a, new C1582j(EnumC3219cg.CONTACT, "/v3/reg").m6710a(EnumC1583k.POST).m6712a(SkipSMSVerifyServer.class).m6709a(201).m6708a(), str, str2, str3, str4));
    }

    /* renamed from: a */
    public C1156ak m5596a() {
        C1156ak c1156ak = new C1156ak(this.f4933a, new C1582j(EnumC3219cg.CONTACT, "/dereg").m6710a(EnumC1583k.GET).m6714a("imei", C3171am.m11045a()).m6714a("uid", C3159aa.m10962a().m10979a("uid", (String) null)).m6709a(202).m6708a());
        C1595w.m6742a().m6745b().m6723a(c1156ak);
        return c1156ak;
    }

    /* renamed from: a */
    public C1156ak m5597a(Context context) {
        C1156ak c1156ak = new C1156ak(this.f4933a, new C1582j(EnumC3219cg.CONTACT, "/dereg").m6710a(EnumC1583k.GET).m6714a("imei", C3171am.m11045a()).m6714a("uid", C3159aa.m10962a().m10979a("uid", (String) null)).m6709a(202).m6708a());
        C1595w.m6742a().m6745b().m6723a(c1156ak);
        return c1156ak;
    }

    /* renamed from: a */
    public void m5600a(String str, String str2, String str3) {
        C1595w.m6742a().m6745b().m6723a(new C1263ej(this.f4933a, new C1582j(EnumC3219cg.CONTACT, "/v2/reg/smsv").m6710a(EnumC1583k.POST).m6709a(203).m6708a(), str, str2, str3));
    }

    /* renamed from: a */
    public void m5598a(String str) {
        C1595w.m6742a().m6745b().m6723a(new C1247du(this.f4933a, new C1582j(EnumC3219cg.CONTACT, "/auth/join").m6710a(EnumC1583k.POST).m6712a(SkipSMSVerifyServer.class).m6709a(204).m6708a(), str));
    }

    /* renamed from: a */
    public void m5602a(String str, boolean z) {
        String strM11045a = C3171am.m11045a();
        String strM10979a = C3159aa.m10962a().m10979a("uid", (String) null);
        C1582j c1582jM6709a = new C1582j(EnumC3219cg.CONTACT, "/reg/checkin").m6710a(EnumC1583k.POST).m6712a(CheckInRegisterParamEntry.class).m6709a(205);
        if (!TextUtils.isEmpty(strM10979a)) {
            c1582jM6709a.m6714a("uid", strM10979a).m6714a("imei", strM11045a);
        }
        C1595w.m6742a().m6745b().m6723a(new C1149ad(this.f4933a, c1582jM6709a.m6708a(), str, z));
    }

    /* renamed from: a */
    public void m5599a(String str, String str2) {
        String strM11045a = C3171am.m11045a();
        String strM10979a = C3159aa.m10962a().m10979a("uid", (String) null);
        C1582j c1582jM6709a = new C1582j(EnumC3219cg.CONTACT, "/reg/checkin").m6710a(EnumC1583k.POST).m6712a(CheckInRegisterParamEntry.class).m6709a(206);
        if (!TextUtils.isEmpty(strM10979a)) {
            c1582jM6709a.m6714a("uid", strM10979a).m6714a("imei", strM11045a);
        }
        C1595w.m6742a().m6745b().m6723a(new C1149ad(this.f4933a, c1582jM6709a.m6708a(), str, str2));
    }

    /* renamed from: b */
    public void m5603b(String str, String str2) {
        String strM11045a = C3171am.m11045a();
        String strM10979a = C3159aa.m10962a().m10979a("uid", (String) null);
        C1582j c1582jM6709a = new C1582j(EnumC3219cg.CONTACT, "/reg/checkin").m6710a(EnumC1583k.POST).m6712a(CheckInRegisterParamEntry.class).m6709a(207);
        if (!TextUtils.isEmpty(strM10979a)) {
            c1582jM6709a.m6714a("uid", strM10979a).m6714a("imei", strM11045a);
        }
        C1595w.m6742a().m6745b().m6723a(new C1149ad(this.f4933a, c1582jM6709a.m6708a(), str, str2));
    }
}
