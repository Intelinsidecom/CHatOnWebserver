package com.sec.chaton.p025d;

import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1157al;
import com.sec.chaton.p025d.p026a.C1227da;
import com.sec.chaton.p025d.p026a.C1237dk;
import com.sec.chaton.p025d.p026a.C1238dl;
import com.sec.chaton.p025d.p026a.C1257ed;
import com.sec.chaton.p025d.p026a.C1281t;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p035io.entry.AutoRegisterAccounEntry;
import com.sec.chaton.p035io.entry.MappingAccountEntry;
import com.sec.chaton.p035io.entry.SSOAccessTokenEntry;
import com.sec.chaton.p035io.entry.SSOUserInformationEntry;
import com.sec.chaton.p035io.entry.SkipSMSVerifyServer;
import com.sec.chaton.p035io.entry.UpdateMSISDNEntry;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3247v;
import com.sec.chaton.util.EnumC3219cg;

/* compiled from: SamsungAccountControl.java */
/* renamed from: com.sec.chaton.d.at */
/* loaded from: classes.dex */
public class C1307at {

    /* renamed from: a */
    private Handler f4941a;

    public C1307at(Handler handler) {
        this.f4941a = handler;
    }

    /* renamed from: a */
    public void m5615a(String str) {
        C1595w.m6742a().m6745b().m6723a(new C1237dk(this.f4941a, new C1582j(EnumC3219cg.CONTACT, "/reg/ssa").m6710a(EnumC1583k.POST).m6709a(2001).m6712a(SkipSMSVerifyServer.class).m6708a(), str));
    }

    /* renamed from: a */
    public void m5616a(String str, String str2, String str3) {
        C1595w.m6742a().m6745b().m6723a(new C1238dl(this.f4941a, new C1582j(EnumC3219cg.SSO, "/auth/oauth2/token").m6710a(EnumC1583k.POST).m6712a(SSOAccessTokenEntry.class).m6709a(2002).m6718b("Content-Type", "application/json").m6717b(C3247v.class).m6714a("grant_type", "authorization_code").m6714a("code", str).m6714a("client_id", str2).m6714a("client_secret", str3).m6708a()));
    }

    /* renamed from: b */
    public void m5619b(String str, String str2, String str3) {
        C1595w.m6742a().m6745b().m6723a(new C1238dl(this.f4941a, new C1582j(EnumC3219cg.SSO_API, "/v2/profile/user/user/" + str3).m6710a(EnumC1583k.GET).m6712a(SSOUserInformationEntry.class).m6709a(2003).m6718b("authorization", "Bearer " + str).m6718b("x-osp-appId", str2).m6718b("x-osp-userId", str3).m6708a()));
    }

    /* renamed from: c */
    public void m5620c(String str, String str2, String str3) {
        C1595w.m6742a().m6745b().m6723a(new C1257ed(this.f4941a, new C1582j(EnumC3219cg.CONTACT, "/auth/msisdn/validate").m6710a(EnumC1583k.POST).m6712a(UpdateMSISDNEntry.class).m6709a(2004).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6708a(), str, str2, str3));
    }

    /* renamed from: a */
    public void m5614a() {
        C1595w.m6742a().m6745b().m6723a(new C1227da(this.f4941a, new C1582j(EnumC3219cg.CONTACT, "/mapping").m6710a(EnumC1583k.POST).m6712a(MappingAccountEntry.class).m6709a(2005).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6708a()));
    }

    /* renamed from: b */
    public void m5617b() {
        C1595w.m6742a().m6745b().m6723a(new C1281t(this.f4941a, new C1582j(EnumC3219cg.CONTACT, "/reg/auto").m6710a(EnumC1583k.POST).m6709a(2006).m6712a(AutoRegisterAccounEntry.class).m6708a()));
    }

    /* renamed from: b */
    public void m5618b(String str) {
        C1595w.m6742a().m6745b().m6723a(new C1157al(this.f4941a, new C1582j(EnumC3219cg.CONTACT, "/mapping/delete").m6710a(EnumC1583k.POST).m6709a(2007).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6708a(), str, EnumC1172b.UI));
    }
}
