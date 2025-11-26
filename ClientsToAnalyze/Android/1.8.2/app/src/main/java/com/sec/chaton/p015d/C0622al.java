package com.sec.chaton.p015d;

import android.os.Handler;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p015d.p016a.C0556ax;
import com.sec.chaton.p015d.p016a.C0575bp;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.GetSMSAuthToken;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.EnumC1765bu;

/* compiled from: SMSGatewayControl.java */
/* renamed from: com.sec.chaton.d.al */
/* loaded from: classes.dex */
public class C0622al {

    /* renamed from: a */
    private Handler f2441a;

    public C0622al(Handler handler) {
        this.f2441a = handler;
    }

    /* renamed from: a */
    public void m2810a(String str, String str2) {
        C0802l.m3412a().offer(new C0556ax(this.f2441a, new C0800j(EnumC1765bu.SMS_GATEWAY, "/sms/v2/authtoken").m3406a(EnumC0801k.GET).m3405a(1301).m3411b("sms-encryptedkey", "1b7ef4fe31b24450b47c7f0082f956f5").m3411b("sms-platform", "android").m3411b("sms-version", C0452a.f1723b).m3409a("countrycallingcode", str).m3409a("phonenumber", str2).m3409a("did", C1721ad.m5873a()).m3407a(GetSMSAuthToken.class).m3404a()));
    }

    /* renamed from: a */
    public void m2811a(String str, String str2, String str3) {
        C0802l.m3412a().offer(new C0575bp(this.f2441a, new C0800j(EnumC1765bu.SMS_GATEWAY, "/sms/v3/send").m3406a(EnumC0801k.GET).m3405a(1302).m3411b("sms-token", str).m3411b("sms-platform", "android").m3411b("sms-version", C0452a.f1723b).m3409a("countrycallingcode", str2).m3409a("phonenumber", str3).m3409a("did", C1721ad.m5873a()).m3409a("imsi", C1721ad.m5880g()).m3404a(), "SMS"));
    }

    /* renamed from: b */
    public void m2813b(String str, String str2) {
        C0802l.m3412a().offer(new C0556ax(this.f2441a, new C0800j(EnumC1765bu.SMS_GATEWAY, "/sms/acs/v2/authtoken").m3406a(EnumC0801k.GET).m3405a(1303).m3411b("sms-encryptedkey", "1b7ef4fe31b24450b47c7f0082f956f5").m3411b("sms-platform", "android").m3411b("sms-version", C0452a.f1723b).m3409a("countrycallingcode", str).m3409a("phonenumber", str2).m3407a(GetSMSAuthToken.class).m3404a()));
    }

    /* renamed from: a */
    public void m2812a(String str, String str2, String str3, String str4) {
        C0802l.m3412a().offer(new C0575bp(this.f2441a, new C0800j(EnumC1765bu.SMS_GATEWAY, "/sms/acs/v2/req").m3406a(EnumC0801k.GET).m3405a(1304).m3411b("sms-token", str).m3411b("sms-platform", "android").m3411b("sms-version", C0452a.f1723b).m3409a("countrycallingcode", str2).m3409a("phonenumber", str3).m3409a("did", C1721ad.m5873a()).m3409a("lang", str4).m3409a("imsi", C1721ad.m5880g()).m3404a(), "ACS"));
    }
}
