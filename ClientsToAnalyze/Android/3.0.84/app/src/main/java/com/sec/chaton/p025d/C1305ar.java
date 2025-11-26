package com.sec.chaton.p025d;

import android.os.Handler;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.p026a.C1207ch;
import com.sec.chaton.p025d.p026a.C1239dm;
import com.sec.chaton.p035io.entry.GetSMSAuthToken;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;

/* compiled from: SMSGatewayControl.java */
/* renamed from: com.sec.chaton.d.ar */
/* loaded from: classes.dex */
public class C1305ar {

    /* renamed from: a */
    private Handler f4936a;

    public C1305ar(Handler handler) {
        this.f4936a = handler;
    }

    /* renamed from: a */
    public void m5609a(String str, String str2) {
        C1595w.m6742a().m6745b().m6723a(new C1207ch(this.f4936a, new C1582j(EnumC3219cg.SMS_GATEWAY, "/sms/v2/authtoken").m6710a(EnumC1583k.GET).m6709a(1301).m6718b("sms-encryptedkey", "1b7ef4fe31b24450b47c7f0082f956f5").m6718b("sms-platform", "android").m6718b("sms-version", C0816a.f3112a).m6714a("countrycallingcode", str).m6714a("phonenumber", str2).m6714a("did", C3171am.m11045a()).m6712a(GetSMSAuthToken.class).m6708a()));
    }

    /* renamed from: a */
    public void m5610a(String str, String str2, String str3) {
        C1595w.m6742a().m6745b().m6723a(new C1239dm(this.f4936a, new C1582j(EnumC3219cg.SMS_GATEWAY, "/sms/v3/send").m6710a(EnumC1583k.GET).m6709a(1302).m6718b("sms-token", str).m6718b("sms-platform", "android").m6718b("sms-version", C0816a.f3112a).m6714a("countrycallingcode", str2).m6714a("phonenumber", str3).m6714a("did", C3171am.m11045a()).m6714a("imsi", C3171am.m11062e()).m6708a(), "SMS"));
    }

    /* renamed from: b */
    public void m5612b(String str, String str2) {
        C1595w.m6742a().m6745b().m6723a(new C1207ch(this.f4936a, new C1582j(EnumC3219cg.SMS_GATEWAY, "/sms/acs/v2/authtoken").m6710a(EnumC1583k.GET).m6709a(1303).m6718b("sms-encryptedkey", "1b7ef4fe31b24450b47c7f0082f956f5").m6718b("sms-platform", "android").m6718b("sms-version", C0816a.f3112a).m6714a("countrycallingcode", str).m6714a("phonenumber", str2).m6712a(GetSMSAuthToken.class).m6708a()));
    }

    /* renamed from: a */
    public void m5611a(String str, String str2, String str3, String str4) {
        C1595w.m6742a().m6745b().m6723a(new C1239dm(this.f4936a, new C1582j(EnumC3219cg.SMS_GATEWAY, "/sms/acs/v2/req").m6710a(EnumC1583k.GET).m6709a(1304).m6718b("sms-token", str).m6718b("sms-platform", "android").m6718b("sms-version", C0816a.f3112a).m6714a("countrycallingcode", str2).m6714a("phonenumber", str3).m6714a("did", C3171am.m11045a()).m6714a("lang", str4).m6714a("imsi", C3171am.m11062e()).m6708a(), "ACS"));
    }
}
