package com.sec.chaton.p013a;

import android.os.Handler;
import com.sec.chaton.p013a.p014a.C0138an;
import com.sec.chaton.p013a.p014a.C0152ba;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.p033io.entry.GetSMSAuthToken;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.EnumC1333h;

/* compiled from: SMSGatewayControl.java */
/* renamed from: com.sec.chaton.a.o */
/* loaded from: classes.dex */
public class C0216o {

    /* renamed from: a */
    private Handler f527a;

    public C0216o(Handler handler) {
        this.f527a = handler;
    }

    /* renamed from: a */
    public void m792a(String str, String str2) {
        C0512s.m2577a().offer(new C0152ba(this.f527a, new C0519z(EnumC1333h.SMS_GATEWAY, "/sms/v2/authtoken").m2581a(EnumC0511r.GET).m2580a(1301).m2587b("sms-encryptedkey", "1b7ef4fe31b24450b47c7f0082f956f5").m2587b("sms-platform", "android").m2587b("sms-version", C0684a.f2331b).m2584a("countrycallingcode", str).m2584a("phonenumber", str2).m2584a("did", C1336k.m4621a()).m2582a(GetSMSAuthToken.class).m2579a()));
    }

    /* renamed from: a */
    public void m793a(String str, String str2, String str3) {
        C0512s.m2577a().offer(new C0138an(this.f527a, new C0519z(EnumC1333h.SMS_GATEWAY, "/sms/v3/send").m2581a(EnumC0511r.GET).m2580a(1302).m2587b("sms-token", str).m2587b("sms-platform", "android").m2587b("sms-version", C0684a.f2331b).m2584a("countrycallingcode", str2).m2584a("phonenumber", str3).m2584a("did", C1336k.m4621a()).m2584a("imsi", C1336k.m4629f()).m2579a()));
    }

    /* renamed from: b */
    public void m795b(String str, String str2) {
        C0512s.m2577a().offer(new C0152ba(this.f527a, new C0519z(EnumC1333h.SMS_GATEWAY, "/sms/acs/authtoken").m2581a(EnumC0511r.GET).m2580a(1303).m2587b("sms-encryptedkey", "1b7ef4fe31b24450b47c7f0082f956f5").m2587b("sms-platform", "android").m2587b("sms-version", C0684a.f2331b).m2584a("countrycallingcode", str).m2584a("phonenumber", str2).m2582a(GetSMSAuthToken.class).m2579a()));
    }

    /* renamed from: a */
    public void m794a(String str, String str2, String str3, String str4) {
        C0512s.m2577a().offer(new C0138an(this.f527a, new C0519z(EnumC1333h.SMS_GATEWAY, "/sms/acs/req").m2581a(EnumC0511r.GET).m2580a(1304).m2587b("sms-token", str).m2587b("sms-platform", "android").m2587b("sms-version", C0684a.f2331b).m2584a("countrycallingcode", str2).m2584a("phonenumber", str3).m2584a("did", C1336k.m4621a()).m2584a("lang", str4).m2584a("imsi", C1336k.m4629f()).m2579a()));
    }
}
