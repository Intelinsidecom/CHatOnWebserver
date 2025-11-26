package com.sec.chaton.p055d;

import android.os.Handler;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.p056a.C1956cb;
import com.sec.chaton.p055d.p056a.C1967cm;
import com.sec.chaton.p055d.p056a.C1969co;
import com.sec.chaton.p055d.p056a.C2016eh;
import com.sec.chaton.p055d.p056a.C2017ei;
import com.sec.chaton.p055d.p056a.C2018ej;
import com.sec.chaton.p065io.entry.GetNumberFreeSMS;
import com.sec.chaton.p065io.entry.GetSMSAuthToken;
import com.sec.chaton.p065io.entry.SendFreeSMSEntry;
import com.sec.chaton.p065io.entry.SendInvitationEntry;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Locale;

/* compiled from: SMSGatewayControl.java */
/* renamed from: com.sec.chaton.d.bc */
/* loaded from: classes.dex */
public class C2097bc {

    /* renamed from: a */
    private final Handler f7616a;

    public C2097bc(Handler handler) {
        this.f7616a = handler;
    }

    /* renamed from: a */
    public void m9370a(String str, String str2) {
        C2472w.m10687a().m10690b().m10662a(new C1967cm(new C2456g(EnumC4868cf.SMS_GATEWAY, "/sms/v2/authtoken").m10637a(EnumC2457h.GET).m10644b("sms-encryptedkey", "1b7ef4fe31b24450b47c7f0082f956f5").m10644b("sms-platform", "android").m10644b("sms-version", C1427a.f5063a).m10644b("Content-Type", "application/xml").m10641a("countrycallingcode", str).m10641a("phonenumber", str2).m10641a("did", C4822an.m18228d()).m10639a(GetSMSAuthToken.class).m10635a()), 1301, this.f7616a);
    }

    /* renamed from: a */
    public void m9371a(String str, String str2, String str3) {
        Locale locale = Locale.getDefault();
        if (C4904y.f17872b) {
            C4904y.m18639b("Language : " + locale.toString(), getClass().getSimpleName());
        }
        C2472w.m10687a().m10690b().m10662a(new C2018ej(new C2456g(EnumC4868cf.SMS_GATEWAY, "/sms/v4/send").m10637a(EnumC2457h.GET).m10644b("sms-token", str).m10644b("sms-platform", "android").m10644b("sms-version", C1427a.f5063a).m10644b("Content-Type", "application/xml").m10641a("countrycallingcode", str2).m10641a("phonenumber", str3).m10641a("did", C4822an.m18228d()).m10641a("imsi", C4822an.m18238h()).m10641a(VKApiConst.LANG, locale.toString()).m10635a(), "SMS"), 1302, this.f7616a);
    }

    /* renamed from: b */
    public void m9376b(String str, String str2) {
        C2472w.m10687a().m10690b().m10662a(new C1967cm(new C2456g(EnumC4868cf.SMS_GATEWAY, "/sms/acs/v2/authtoken").m10637a(EnumC2457h.GET).m10644b("sms-encryptedkey", "1b7ef4fe31b24450b47c7f0082f956f5").m10644b("sms-platform", "android").m10644b("sms-version", C1427a.f5063a).m10644b("Content-Type", "application/xml").m10641a("countrycallingcode", str).m10641a("phonenumber", str2).m10639a(GetSMSAuthToken.class).m10635a()), 1303, this.f7616a);
    }

    /* renamed from: a */
    public void m9372a(String str, String str2, String str3, String str4) {
        C2472w.m10687a().m10690b().m10662a(new C2018ej(new C2456g(EnumC4868cf.SMS_GATEWAY, "/sms/acs/v2/req").m10637a(EnumC2457h.GET).m10644b("sms-token", str).m10644b("sms-platform", "android").m10644b("sms-version", C1427a.f5063a).m10641a("countrycallingcode", str2).m10644b("Content-Type", "application/xml").m10641a("phonenumber", str3).m10641a("did", C4822an.m18228d()).m10641a(VKApiConst.LANG, str4).m10641a("imsi", C4822an.m18238h()).m10635a(), "ACS"), 1304, this.f7616a);
    }

    /* renamed from: a */
    public void m9369a() {
        C2472w.m10687a().m10690b().m10662a(new C1956cb(m9366a(new C2456g(EnumC4868cf.SMS_GATEWAY, "/sms/free/remain").m10637a(EnumC2457h.GET).m10639a(GetNumberFreeSMS.class)).m10635a()), 1305, this.f7616a);
    }

    /* renamed from: b */
    public void m9375b() {
        C2472w.m10687a().m10690b().m10662a(new C1969co(m9366a(new C2456g(EnumC4868cf.SMS_GATEWAY, "/sms/free/authtoken").m10637a(EnumC2457h.GET).m10639a(GetSMSAuthToken.class)).m10635a()), 1306, this.f7616a);
    }

    /* renamed from: a */
    public void m9374a(String str, String[] strArr, String[] strArr2, String str2, String[] strArr3) {
        try {
            C2472w.m10687a().m10690b().m10662a(new C2016eh(m9367a(str, new C2456g(EnumC4868cf.SMS_GATEWAY, "/sms/free/send").m10644b("sms-join", m9368a(strArr3)).m10641a("msgBody", URLEncoder.encode(str2, Charset.forName("UTF-8").name())).m10639a(SendFreeSMSEntry.class), strArr, strArr2).m10635a()), 1307, this.f7616a);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m9373a(String str, String[] strArr, String[] strArr2) {
        C2472w.m10687a().m10690b().m10662a(new C2017ei(m9367a(str, new C2456g(EnumC4868cf.SMS_GATEWAY, "/sms/free/invitation").m10639a(SendInvitationEntry.class), strArr, strArr2).m10635a()), 1308, this.f7616a);
    }

    /* renamed from: a */
    private C2456g m9366a(C2456g c2456g) {
        c2456g.m10644b("sms-encryptedkey", "1b7ef4fe31b24450b47c7f0082f956f5").m10644b("sms-platform", "android").m10644b("sms-version", C1427a.f5063a).m10644b("Content-Type", "application/xml").m10641a("msisdn", C4809aa.m18104a().m18121a("msisdn", "")).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("did", C4809aa.m18104a().m18121a("imei", "")).m10641a("time", C4822an.m18202L());
        return c2456g;
    }

    /* renamed from: a */
    private C2456g m9367a(String str, C2456g c2456g, String[] strArr, String[] strArr2) {
        try {
            c2456g.m10644b("sms-token", str).m10644b("sms-platform", "android").m10644b("sms-version", C1427a.f5063a).m10644b("sms-prefix", "ChatON").m10644b("service-division", "chatonfree").m10644b("sms-countrycallingcode", m9368a(strArr)).m10644b("sms-phonenumber", m9368a(strArr2)).m10644b("sms-uid", C4809aa.m18104a().m18121a("uid", "")).m10644b("sms-did", C4809aa.m18104a().m18121a("imei", "")).m10644b("Content-Type", "application/xml").m10641a("smsisdn", C4809aa.m18104a().m18121a("msisdn", "")).m10641a("sname", URLEncoder.encode(C4809aa.m18104a().m18121a("Push Name", ""), Charset.forName("UTF-8").name())).m10641a("time", C4822an.m18202L()).m10637a(EnumC2457h.GET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        c2456g.m10636a(60000);
        return c2456g;
    }

    /* renamed from: a */
    private String m9368a(String[] strArr) {
        String str = "";
        for (int i = 0; i < strArr.length; i++) {
            if (i < strArr.length - 1) {
                str = str + strArr[i] + ",";
            } else {
                str = str + strArr[i];
            }
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("result : " + str, "getParameterMultipleString");
        }
        return str;
    }
}
