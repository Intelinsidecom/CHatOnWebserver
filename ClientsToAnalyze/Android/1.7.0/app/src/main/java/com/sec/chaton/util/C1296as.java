package com.sec.chaton.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.sec.chaton.p013a.C0225x;
import com.sec.chaton.p029f.C0685b;

/* compiled from: ServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.as */
/* loaded from: classes.dex */
public class C1296as {

    /* renamed from: a */
    private static String f4484a = null;

    /* renamed from: b */
    private static String f4485b = null;

    /* renamed from: c */
    private static String f4486c = null;

    /* renamed from: d */
    private static String f4487d = null;

    /* renamed from: e */
    private static Integer f4488e = null;

    /* renamed from: f */
    private static Integer f4489f = null;

    /* renamed from: g */
    private static Integer f4490g = null;

    /* renamed from: h */
    private static Integer f4491h = null;

    /* renamed from: i */
    private static String f4492i = null;

    /* renamed from: j */
    private static String f4493j = null;

    /* renamed from: k */
    private static String f4494k = null;

    /* renamed from: l */
    private static String f4495l = null;

    /* renamed from: m */
    private static Integer f4496m = null;

    /* renamed from: n */
    private static Integer f4497n = null;

    /* renamed from: o */
    private static Integer f4498o = null;

    /* renamed from: p */
    private static Integer f4499p = null;

    /* renamed from: q */
    private static long f4500q = 0;

    /* renamed from: a */
    public static void m4518a() {
        f4484a = null;
        f4485b = null;
        f4486c = null;
        f4491h = null;
        f4488e = null;
        f4489f = null;
        f4490g = null;
        f4491h = null;
        C1323bs.m4575a().edit().remove("is_file_server_primary ").commit();
    }

    /* renamed from: a */
    public static void m4519a(boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = f4500q == 0 ? 99999L : jElapsedRealtime - f4500q;
        if (j < 0) {
            j = -j;
        }
        C1341p.m4658b("checkExpireDate called time last=" + f4500q + " cur=" + jElapsedRealtime + ", force=" + z, null);
        if (z || j > 10000) {
            f4500q = jElapsedRealtime;
            if (C1323bs.m4575a().contains("primary_contact_addrss")) {
                if (!C1323bs.m4575a().contains("expdate")) {
                    C1341p.m4658b("checkExpireDate expdate is not available", null);
                    return;
                }
                long j2 = C1323bs.m4575a().getLong("expdate", 0L);
                long jCurrentTimeMillis = System.currentTimeMillis();
                C1341p.m4658b("checkExpireDate expdate=" + j2 + ", cur=" + jCurrentTimeMillis, null);
                if (jCurrentTimeMillis > j2) {
                    new C0225x(new Handler(Looper.getMainLooper())).m869a();
                    return;
                }
                return;
            }
            new C0225x(new Handler(Looper.getMainLooper())).m869a();
        }
    }

    /* renamed from: a */
    public static String m4517a(EnumC1289al enumC1289al) {
        String string = C1323bs.m4575a().getString("pref_choose_server_test", C0685b.f2343a[0]);
        if (enumC1289al != EnumC1289al.PRIMARY && string.equals("https://gld1.samsungchaton.com")) {
            return "https://gld2.samsungchaton.com";
        }
        return string;
    }

    /* renamed from: b */
    public static String m4521b(EnumC1289al enumC1289al) {
        return enumC1289al == EnumC1289al.PRIMARY ? m4535l() : m4536m();
    }

    /* renamed from: c */
    public static int m4522c(EnumC1289al enumC1289al) {
        return enumC1289al == EnumC1289al.PRIMARY ? m4520b().intValue() : m4523c().intValue();
    }

    /* renamed from: d */
    public static String m4525d(EnumC1289al enumC1289al) {
        return enumC1289al == EnumC1289al.PRIMARY ? m4537n() : m4538o();
    }

    /* renamed from: e */
    public static String m4527e(EnumC1289al enumC1289al) {
        return enumC1289al == EnumC1289al.PRIMARY ? m4539p() : m4540q();
    }

    /* renamed from: f */
    public static int m4528f(EnumC1289al enumC1289al) {
        return enumC1289al == EnumC1289al.PRIMARY ? m4531h().intValue() : m4532i().intValue();
    }

    /* renamed from: l */
    private static String m4535l() {
        if (f4484a == null) {
            f4484a = C1323bs.m4575a().getString("primary_contact_addrss", "");
        }
        return m4520b().intValue() == 443 ? "https://" + f4484a : "http://" + f4484a;
    }

    /* renamed from: m */
    private static String m4536m() {
        if (f4492i == null) {
            f4492i = C1323bs.m4575a().getString("secondary_contact_addrss", "");
        }
        return m4523c().intValue() == 443 ? "https://" + f4492i : "http://" + f4492i;
    }

    /* renamed from: n */
    private static String m4537n() {
        if (f4486c == null) {
            f4486c = C1323bs.m4575a().getString("primary_file_addrss", "");
        }
        return m4531h().intValue() == 443 ? "https://" + f4486c : "http://" + f4486c;
    }

    /* renamed from: o */
    private static String m4538o() {
        if (f4494k == null) {
            f4494k = C1323bs.m4575a().getString("secondary_file_addrss", "");
        }
        return m4531h().intValue() == 443 ? "https://" + f4494k : "http://" + f4494k;
    }

    /* renamed from: p */
    private static String m4539p() {
        if (f4487d == null) {
            f4487d = C1323bs.m4575a().getString("primary_sms_address", "");
        }
        return m4533j().intValue() == 443 ? "https://" + f4487d : "http://" + f4487d;
    }

    /* renamed from: q */
    private static String m4540q() {
        if (f4495l == null) {
            f4495l = C1323bs.m4575a().getString("secondary_sms_addrss", "");
        }
        return m4534k().intValue() == 443 ? "https://" + f4495l : "http://" + f4495l;
    }

    /* renamed from: b */
    public static Integer m4520b() {
        if (f4488e == null) {
            f4488e = Integer.valueOf(C1323bs.m4575a().getInt("primary_contact_port", 0));
        }
        return f4488e;
    }

    /* renamed from: c */
    public static Integer m4523c() {
        if (f4496m == null) {
            f4496m = Integer.valueOf(C1323bs.m4575a().getInt("secondary_contact_port", 0));
        }
        return f4496m;
    }

    /* renamed from: d */
    public static String m4524d() {
        if (f4485b == null) {
            f4485b = C1323bs.m4575a().getString("primary_message_addrss", "");
        }
        return f4485b;
    }

    /* renamed from: e */
    public static String m4526e() {
        if (f4493j == null) {
            f4493j = C1323bs.m4575a().getString("secondary_message_addrss", "");
        }
        return f4493j;
    }

    /* renamed from: f */
    public static Integer m4529f() {
        if (f4489f == null) {
            f4489f = Integer.valueOf(C1323bs.m4575a().getInt("primary_message_port", 0));
        }
        return f4489f;
    }

    /* renamed from: g */
    public static Integer m4530g() {
        if (f4497n == null) {
            f4497n = Integer.valueOf(C1323bs.m4575a().getInt("secondary_message_port", 0));
        }
        return f4497n;
    }

    /* renamed from: h */
    public static Integer m4531h() {
        if (f4490g == null) {
            f4490g = Integer.valueOf(C1323bs.m4575a().getInt("primary_file_port", 0));
        }
        return f4490g;
    }

    /* renamed from: i */
    public static Integer m4532i() {
        if (f4498o == null) {
            f4498o = Integer.valueOf(C1323bs.m4575a().getInt("secondary_file_port", 0));
        }
        return f4498o;
    }

    /* renamed from: j */
    public static Integer m4533j() {
        if (f4491h == null) {
            f4491h = Integer.valueOf(C1323bs.m4575a().getInt("primary_sms_port", 0));
        }
        return f4491h;
    }

    /* renamed from: k */
    public static Integer m4534k() {
        if (f4499p == null) {
            f4499p = Integer.valueOf(C1323bs.m4575a().getInt("secondary_sms_port", 0));
        }
        return f4499p;
    }
}
