package com.sec.chaton.p055d;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p055d.p056a.C1907ag;
import com.sec.chaton.p055d.p056a.C1908ah;
import com.sec.chaton.p055d.p056a.C2011ec;
import com.sec.chaton.p055d.p056a.C2012ed;
import com.sec.chaton.p055d.p056a.C2013ee;
import com.sec.chaton.p055d.p056a.C2027es;
import com.sec.chaton.p055d.p056a.C2044fi;
import com.sec.chaton.p055d.p056a.C2067z;
import com.sec.chaton.p065io.entry.CheckInRegisterParamEntry;
import com.sec.chaton.p065io.entry.SkipSMSVerifyServer;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.EnumC4868cf;

/* compiled from: RegistrationControl.java */
/* renamed from: com.sec.chaton.d.ba */
/* loaded from: classes.dex */
public class C2095ba {

    /* renamed from: a */
    private Handler f7613a;

    public C2095ba(Handler handler) {
        this.f7613a = handler;
    }

    /* renamed from: a */
    public void m9354a(String str, String str2, String str3, String str4) {
        C2472w.m10687a().m10690b().m10662a(new C2012ed(new C2456g(EnumC4868cf.CONTACT, "/v3/reg").m10637a(EnumC2457h.POST).m10639a(SkipSMSVerifyServer.class).m10635a(), str, str2, str3, str4), 201, this.f7613a);
    }

    /* renamed from: a */
    public C1907ag m9348a() {
        C1907ag c1907ag = new C1907ag(new C2456g(EnumC4868cf.CONTACT, "/dereg").m10637a(EnumC2457h.GET).m10641a("imei", C4822an.m18228d()).m10641a("uid", C4809aa.m18104a().m18121a("uid", (String) null)).m10635a());
        C2472w.m10687a().m10690b().m10662a(c1907ag, 202, this.f7613a);
        return c1907ag;
    }

    /* renamed from: a */
    public C1907ag m9349a(Context context) {
        C1907ag c1907ag = new C1907ag(new C2456g(EnumC4868cf.CONTACT, "/dereg").m10637a(EnumC2457h.GET).m10641a("imei", C4822an.m18228d()).m10641a("uid", C4809aa.m18104a().m18121a("uid", (String) null)).m10635a());
        C2472w.m10687a().m10690b().m10662a(c1907ag, 202, this.f7613a);
        return c1907ag;
    }

    /* renamed from: a */
    public void m9353a(String str, String str2, String str3) {
        C2472w.m10687a().m10690b().m10662a(new C2044fi(new C2456g(EnumC4868cf.CONTACT, "/v2/reg/smsv").m10637a(EnumC2457h.POST).m10635a(), str, str2, str3), 203, this.f7613a);
    }

    /* renamed from: a */
    public void m9351a(String str) {
        C2472w.m10687a().m10690b().m10662a(new C2027es(new C2456g(EnumC4868cf.CONTACT, "/auth/join").m10637a(EnumC2457h.POST).m10639a(SkipSMSVerifyServer.class).m10635a(), str), 204, this.f7613a);
    }

    /* renamed from: a */
    public void m9355a(String str, boolean z) {
        String strM18228d = C4822an.m18228d();
        String strM18121a = C4809aa.m18104a().m18121a("uid", (String) null);
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/reg/checkin").m10637a(EnumC2457h.POST).m10639a(CheckInRegisterParamEntry.class);
        if (!TextUtils.isEmpty(strM18121a)) {
            c2456gM10639a.m10641a("uid", strM18121a).m10641a("imei", strM18228d);
        }
        C2472w.m10687a().m10690b().m10662a(new C2067z(c2456gM10639a.m10635a(), str, z), 205, this.f7613a);
    }

    /* renamed from: a */
    public void m9352a(String str, String str2) {
        String strM18228d = C4822an.m18228d();
        String strM18121a = C4809aa.m18104a().m18121a("uid", (String) null);
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/reg/checkin").m10637a(EnumC2457h.POST).m10639a(CheckInRegisterParamEntry.class);
        if (!TextUtils.isEmpty(strM18121a)) {
            c2456gM10639a.m10641a("uid", strM18121a).m10641a("imei", strM18228d);
        }
        C2472w.m10687a().m10690b().m10662a(new C2067z(c2456gM10639a.m10635a(), str, str2), 206, this.f7613a);
    }

    /* renamed from: b */
    public void m9358b(String str, String str2) {
        String strM18228d = C4822an.m18228d();
        String strM18121a = C4809aa.m18104a().m18121a("uid", (String) null);
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/reg/checkin").m10637a(EnumC2457h.POST).m10639a(CheckInRegisterParamEntry.class);
        if (!TextUtils.isEmpty(strM18121a)) {
            c2456gM10639a.m10641a("uid", strM18121a).m10641a("imei", strM18228d);
        }
        C2472w.m10687a().m10690b().m10662a(new C2067z(c2456gM10639a.m10635a(), str, str2), 207, this.f7613a);
    }

    /* renamed from: a */
    public void m9350a(C2105bk c2105bk) {
        String strM18228d = C4822an.m18228d();
        String strM18121a = C4809aa.m18104a().m18121a("uid", (String) null);
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/reg/checkin").m10637a(EnumC2457h.POST).m10639a(CheckInRegisterParamEntry.class);
        if (!TextUtils.isEmpty(strM18121a)) {
            c2456gM10639a.m10641a("uid", strM18121a).m10641a("imei", strM18228d);
        }
        C2472w.m10687a().m10690b().m10662a(new C2067z(c2456gM10639a.m10635a(), c2105bk), 210, this.f7613a);
    }

    /* renamed from: b */
    public void m9357b(C2105bk c2105bk) {
        C2472w.m10687a().m10690b().m10662a(new C2013ee(new C2456g(EnumC4868cf.CONTACT, "/reg/sns").m10637a(EnumC2457h.POST).m10639a(SkipSMSVerifyServer.class).m10635a(), c2105bk), 208, this.f7613a);
    }

    /* renamed from: b */
    public void m9356b() {
        C2472w.m10687a().m10690b().m10662a(new C1908ah(new C2456g(EnumC4868cf.CONTACT, "/dereg/sns").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", (String) null)).m10641a("imei", C4822an.m18228d()).m10635a()), 209, this.f7613a);
    }

    /* renamed from: b */
    public void m9359b(String str, String str2, String str3) {
        C2472w.m10687a().m10690b().m10662a(new C2011ec(new C2456g(EnumC4868cf.CONTACT, "/reg/invite").m10637a(EnumC2457h.POST).m10639a(SkipSMSVerifyServer.class).m10635a(), str, str2, str3), 211, this.f7613a);
    }
}
