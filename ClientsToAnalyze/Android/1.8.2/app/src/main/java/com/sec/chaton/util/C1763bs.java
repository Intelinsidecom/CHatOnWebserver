package com.sec.chaton.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.sec.chaton.p012c.C0453b;
import com.sec.chaton.p015d.C0634f;

/* compiled from: ServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.bs */
/* loaded from: classes.dex */
public class C1763bs {

    /* renamed from: a */
    private static String f6401a = null;

    /* renamed from: b */
    private static String f6402b = null;

    /* renamed from: c */
    private static String f6403c = null;

    /* renamed from: d */
    private static String f6404d = null;

    /* renamed from: e */
    private static Integer f6405e = null;

    /* renamed from: f */
    private static Integer f6406f = null;

    /* renamed from: g */
    private static Integer f6407g = null;

    /* renamed from: h */
    private static Integer f6408h = null;

    /* renamed from: i */
    private static String f6409i = null;

    /* renamed from: j */
    private static String f6410j = null;

    /* renamed from: k */
    private static String f6411k = null;

    /* renamed from: l */
    private static String f6412l = null;

    /* renamed from: m */
    private static Integer f6413m = null;

    /* renamed from: n */
    private static Integer f6414n = null;

    /* renamed from: o */
    private static Integer f6415o = null;

    /* renamed from: p */
    private static Integer f6416p = null;

    /* renamed from: q */
    private static long f6417q = 0;

    /* renamed from: a */
    public static void m5970a() {
        f6401a = null;
        f6402b = null;
        f6403c = null;
        f6408h = null;
        f6405e = null;
        f6406f = null;
        f6407g = null;
        f6408h = null;
        C1789u.m6075a().edit().remove("is_file_server_primary ").commit();
    }

    /* renamed from: a */
    public static void m5971a(boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = f6417q == 0 ? 99999L : jElapsedRealtime - f6417q;
        if (j < 0) {
            j = -j;
        }
        C1786r.m6061b("checkExpireDate called time last=" + f6417q + " cur=" + jElapsedRealtime + ", force=" + z, null);
        if (z || j > 10000) {
            f6417q = jElapsedRealtime;
            if (C1789u.m6075a().contains("primary_contact_addrss")) {
                if (!C1789u.m6075a().contains("expdate")) {
                    C1786r.m6061b("checkExpireDate expdate is not available", null);
                    return;
                }
                long j2 = C1789u.m6075a().getLong("expdate", 0L);
                long jCurrentTimeMillis = System.currentTimeMillis();
                C1786r.m6061b("checkExpireDate expdate=" + j2 + ", cur=" + jCurrentTimeMillis, null);
                if (jCurrentTimeMillis > j2) {
                    new C0634f(new Handler(Looper.getMainLooper())).m2884a();
                    return;
                }
                return;
            }
            new C0634f(new Handler(Looper.getMainLooper())).m2884a();
        }
    }

    /* renamed from: a */
    public static String m5969a(EnumC1764bt enumC1764bt) {
        String string = C1789u.m6075a().getString("pref_choose_server_test", C0453b.f1739a[0]);
        if (enumC1764bt != EnumC1764bt.PRIMARY && string.equals("https://gld1.samsungchaton.com")) {
            return "https://gld2.samsungchaton.com";
        }
        return string;
    }

    /* renamed from: b */
    public static String m5973b(EnumC1764bt enumC1764bt) {
        return enumC1764bt == EnumC1764bt.PRIMARY ? m5987l() : m5988m();
    }

    /* renamed from: c */
    public static int m5974c(EnumC1764bt enumC1764bt) {
        return enumC1764bt == EnumC1764bt.PRIMARY ? m5972b().intValue() : m5975c().intValue();
    }

    /* renamed from: d */
    public static String m5977d(EnumC1764bt enumC1764bt) {
        return enumC1764bt == EnumC1764bt.PRIMARY ? m5989n() : m5990o();
    }

    /* renamed from: e */
    public static String m5979e(EnumC1764bt enumC1764bt) {
        return enumC1764bt == EnumC1764bt.PRIMARY ? m5991p() : m5992q();
    }

    /* renamed from: f */
    public static int m5980f(EnumC1764bt enumC1764bt) {
        return enumC1764bt == EnumC1764bt.PRIMARY ? m5983h().intValue() : m5984i().intValue();
    }

    /* renamed from: l */
    private static String m5987l() {
        if (f6401a == null) {
            f6401a = C1789u.m6075a().getString("primary_contact_addrss", "");
        }
        return m5972b().intValue() == 443 ? "https://" + f6401a : "http://" + f6401a;
    }

    /* renamed from: m */
    private static String m5988m() {
        if (f6409i == null) {
            f6409i = C1789u.m6075a().getString("secondary_contact_addrss", "");
        }
        return m5975c().intValue() == 443 ? "https://" + f6409i : "http://" + f6409i;
    }

    /* renamed from: n */
    private static String m5989n() {
        if (f6403c == null) {
            f6403c = C1789u.m6075a().getString("primary_file_addrss", "");
        }
        return m5983h().intValue() == 443 ? "https://" + f6403c : "http://" + f6403c;
    }

    /* renamed from: o */
    private static String m5990o() {
        if (f6411k == null) {
            f6411k = C1789u.m6075a().getString("secondary_file_addrss", "");
        }
        return m5983h().intValue() == 443 ? "https://" + f6411k : "http://" + f6411k;
    }

    /* renamed from: p */
    private static String m5991p() {
        if (f6404d == null) {
            f6404d = C1789u.m6075a().getString("primary_sms_address", "");
        }
        return m5985j().intValue() == 443 ? "https://" + f6404d : "http://" + f6404d;
    }

    /* renamed from: q */
    private static String m5992q() {
        if (f6412l == null) {
            f6412l = C1789u.m6075a().getString("secondary_sms_addrss", "");
        }
        return m5986k().intValue() == 443 ? "https://" + f6412l : "http://" + f6412l;
    }

    /* renamed from: b */
    public static Integer m5972b() {
        if (f6405e == null) {
            f6405e = Integer.valueOf(C1789u.m6075a().getInt("primary_contact_port", 0));
        }
        return f6405e;
    }

    /* renamed from: c */
    public static Integer m5975c() {
        if (f6413m == null) {
            f6413m = Integer.valueOf(C1789u.m6075a().getInt("secondary_contact_port", 0));
        }
        return f6413m;
    }

    /* renamed from: d */
    public static String m5976d() {
        if (f6402b == null) {
            f6402b = C1789u.m6075a().getString("primary_message_addrss", "");
        }
        return f6402b;
    }

    /* renamed from: e */
    public static String m5978e() {
        if (f6410j == null) {
            f6410j = C1789u.m6075a().getString("secondary_message_addrss", "");
        }
        return f6410j;
    }

    /* renamed from: f */
    public static Integer m5981f() {
        if (f6406f == null) {
            f6406f = Integer.valueOf(C1789u.m6075a().getInt("primary_message_port", 0));
        }
        return f6406f;
    }

    /* renamed from: g */
    public static Integer m5982g() {
        if (f6414n == null) {
            f6414n = Integer.valueOf(C1789u.m6075a().getInt("secondary_message_port", 0));
        }
        return f6414n;
    }

    /* renamed from: h */
    public static Integer m5983h() {
        if (f6407g == null) {
            f6407g = Integer.valueOf(C1789u.m6075a().getInt("primary_file_port", 0));
        }
        return f6407g;
    }

    /* renamed from: i */
    public static Integer m5984i() {
        if (f6415o == null) {
            f6415o = Integer.valueOf(C1789u.m6075a().getInt("secondary_file_port", 0));
        }
        return f6415o;
    }

    /* renamed from: j */
    public static Integer m5985j() {
        if (f6408h == null) {
            f6408h = Integer.valueOf(C1789u.m6075a().getInt("primary_sms_port", 0));
        }
        return f6408h;
    }

    /* renamed from: k */
    public static Integer m5986k() {
        if (f6416p == null) {
            f6416p = Integer.valueOf(C1789u.m6075a().getInt("secondary_sms_port", 0));
        }
        return f6416p;
    }
}
