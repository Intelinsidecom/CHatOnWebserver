package com.sec.chaton.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sec.chaton.chat.p024b.C0952c;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.p025d.C1334l;
import com.sec.common.util.C3364o;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.cd */
/* loaded from: classes.dex */
public class C3216cd {

    /* renamed from: a */
    private static String f11613a = null;

    /* renamed from: b */
    private static String f11614b = null;

    /* renamed from: c */
    private static String f11615c = null;

    /* renamed from: d */
    private static String f11616d = null;

    /* renamed from: e */
    private static String f11617e = null;

    /* renamed from: f */
    private static String f11618f = null;

    /* renamed from: g */
    private static String f11619g = null;

    /* renamed from: h */
    private static String f11620h = null;

    /* renamed from: i */
    private static Integer f11621i = null;

    /* renamed from: j */
    private static Integer f11622j = null;

    /* renamed from: k */
    private static Integer f11623k = null;

    /* renamed from: l */
    private static Integer f11624l = null;

    /* renamed from: m */
    private static Integer f11625m = null;

    /* renamed from: n */
    private static Integer f11626n = null;

    /* renamed from: o */
    private static Integer f11627o = null;

    /* renamed from: p */
    private static Integer f11628p = null;

    /* renamed from: q */
    private static String f11629q = null;

    /* renamed from: r */
    private static String f11630r = null;

    /* renamed from: s */
    private static String f11631s = null;

    /* renamed from: t */
    private static String f11632t = null;

    /* renamed from: u */
    private static String f11633u = null;

    /* renamed from: v */
    private static String f11634v = null;

    /* renamed from: w */
    private static String f11635w = null;

    /* renamed from: x */
    private static String f11636x = null;

    /* renamed from: y */
    private static Integer f11637y = null;

    /* renamed from: z */
    private static Integer f11638z = null;

    /* renamed from: A */
    private static Integer f11605A = null;

    /* renamed from: B */
    private static Integer f11606B = null;

    /* renamed from: C */
    private static Integer f11607C = null;

    /* renamed from: D */
    private static Integer f11608D = null;

    /* renamed from: E */
    private static Integer f11609E = null;

    /* renamed from: F */
    private static Integer f11610F = null;

    /* renamed from: G */
    private static long f11611G = 0;

    /* renamed from: H */
    private static Map<EnumC3219cg, EnumC3218cf> f11612H = new HashMap();

    /* renamed from: a */
    public static void m11278a() {
        f11613a = null;
        f11614b = null;
        f11615c = null;
        f11624l = null;
        f11617e = null;
        f11618f = null;
        f11619g = null;
        f11621i = null;
        f11622j = null;
        f11623k = null;
        f11624l = null;
        f11625m = null;
        f11626n = null;
        f11627o = null;
        f11612H.clear();
        C3159aa.m10962a().m10981a("is_file_server_primary ");
    }

    /* renamed from: a */
    public static void m11280a(boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = f11611G == 0 ? 99999L : jElapsedRealtime - f11611G;
        if (j < 0) {
            j = -j;
        }
        C3250y.m11450b("checkExpireDate called time last=" + f11611G + " cur=" + jElapsedRealtime + ", force=" + z, null);
        if (z || j > 10000) {
            f11611G = jElapsedRealtime;
            if (C3159aa.m10962a().m10987b("primary_contact_addrss")) {
                if (!C3159aa.m10962a().m10987b("expdate")) {
                    C3250y.m11450b("checkExpireDate expdate is not available", null);
                    return;
                }
                long jM10976a = C3159aa.m10962a().m10976a("expdate", 0L);
                long jCurrentTimeMillis = System.currentTimeMillis();
                C3250y.m11450b("checkExpireDate expdate=" + jM10976a + ", cur=" + jCurrentTimeMillis, null);
                if (jCurrentTimeMillis > jM10976a) {
                    new C1334l(new Handler(Looper.getMainLooper())).m5775a();
                    return;
                }
                return;
            }
            new C1334l(new Handler(Looper.getMainLooper())).m5775a();
        }
    }

    /* renamed from: a */
    public static EnumC3218cf m11276a(EnumC3219cg enumC3219cg) {
        if (!enumC3219cg.f11658o) {
            throw new IllegalArgumentException(C3364o.m11849a(enumC3219cg.name(), " doesn't support server type."));
        }
        if (!f11612H.containsKey(enumC3219cg)) {
            f11612H.put(enumC3219cg, EnumC3218cf.PRIMARY);
        }
        return f11612H.get(enumC3219cg);
    }

    /* renamed from: a */
    public static void m11279a(EnumC3219cg enumC3219cg, EnumC3218cf enumC3218cf) {
        if (!enumC3219cg.f11658o) {
            throw new IllegalArgumentException(C3364o.m11849a(enumC3219cg.name(), " doesn't support server type."));
        }
        if (!f11612H.containsKey(enumC3219cg)) {
            f11612H.put(enumC3219cg, EnumC3218cf.PRIMARY);
        }
        f11612H.put(enumC3219cg, enumC3218cf);
    }

    /* renamed from: b */
    public static String m11283b(EnumC3219cg enumC3219cg) {
        EnumC3218cf enumC3218cf = EnumC3218cf.PRIMARY;
        if (enumC3219cg.f11658o) {
            if (!f11612H.containsKey(enumC3219cg)) {
                f11612H.put(enumC3219cg, EnumC3218cf.PRIMARY);
            }
            enumC3218cf = f11612H.get(enumC3219cg);
        }
        switch (C3217ce.f11639a[enumC3219cg.ordinal()]) {
            case 1:
                return m11293g(enumC3218cf);
            case 2:
                return m11282b(enumC3218cf);
            case 3:
                return m11287d(enumC3218cf);
            case 4:
                return m11277a(enumC3218cf);
            case 5:
                return m11291f(enumC3218cf);
            case 6:
                return m11289e(enumC3218cf);
            case 7:
                return "http://hub.samsungapps.com";
            case 8:
                if ("account.samsung.com".equals("account.samsung.com")) {
                    return "https://auth.samsungosp.com";
                }
                return "https://stg-auth.samsungosp.com";
            case 9:
                if ("account.samsung.com".equals("account.samsung.com")) {
                    return "https://api.samsungosp.com";
                }
                return "https://stg-api.samsungosp.com";
            case 10:
                return m11295h(enumC3218cf);
            case 11:
                return "https://global-auth.translation.samsungosp.com";
            case 12:
                return C0952c.m5143c().m5146a();
            default:
                return "";
        }
    }

    /* renamed from: a */
    public static String m11277a(EnumC3218cf enumC3218cf) {
        String str;
        if (C3159aa.m10962a().m10977a("admin_dev_gld", (Boolean) false).booleanValue()) {
            str = C0817b.f3129a[1];
        } else {
            str = C0817b.f3129a[0];
        }
        if (enumC3218cf != EnumC3218cf.PRIMARY && str.equals("https://gld1.samsungchaton.com")) {
            return "https://gld2.samsungchaton.com";
        }
        return str;
    }

    /* renamed from: b */
    public static String m11282b(EnumC3218cf enumC3218cf) {
        return enumC3218cf == EnumC3218cf.PRIMARY ? m11304q() : m11305r();
    }

    /* renamed from: c */
    public static int m11284c(EnumC3218cf enumC3218cf) {
        return enumC3218cf == EnumC3218cf.PRIMARY ? m11281b().intValue() : m11285c().intValue();
    }

    /* renamed from: d */
    public static String m11287d(EnumC3218cf enumC3218cf) {
        return enumC3218cf == EnumC3218cf.PRIMARY ? m11306s() : m11307t();
    }

    /* renamed from: e */
    public static String m11289e(EnumC3218cf enumC3218cf) {
        return enumC3218cf == EnumC3218cf.PRIMARY ? m11308u() : m11309v();
    }

    /* renamed from: f */
    public static String m11291f(EnumC3218cf enumC3218cf) {
        return enumC3218cf == EnumC3218cf.PRIMARY ? m11310w() : m11311x();
    }

    /* renamed from: g */
    public static String m11293g(EnumC3218cf enumC3218cf) {
        return enumC3218cf == EnumC3218cf.PRIMARY ? m11312y() : m11313z();
    }

    /* renamed from: h */
    public static String m11295h(EnumC3218cf enumC3218cf) {
        return enumC3218cf == EnumC3218cf.PRIMARY ? m11274A() : m11275B();
    }

    /* renamed from: q */
    private static String m11304q() {
        if (f11613a == null) {
            f11613a = C3159aa.m10962a().m10979a("primary_contact_addrss", (String) null);
        }
        return m11281b().intValue() == 443 ? "https://" + f11613a : "http://" + f11613a;
    }

    /* renamed from: r */
    private static String m11305r() {
        if (f11629q == null) {
            f11629q = C3159aa.m10962a().m10979a("secondary_contact_addrss", (String) null);
        }
        return m11285c().intValue() == 443 ? "https://" + f11629q : "http://" + f11629q;
    }

    /* renamed from: s */
    private static String m11306s() {
        if (f11615c == null) {
            f11615c = C3159aa.m10962a().m10979a("primary_file_addrss", (String) null);
        }
        return m11294h().intValue() == 443 ? "https://" + f11615c : "http://" + f11615c;
    }

    /* renamed from: t */
    private static String m11307t() {
        if (f11631s == null) {
            f11631s = C3159aa.m10962a().m10979a("secondary_file_addrss", (String) null);
        }
        return m11294h().intValue() == 443 ? "https://" + f11631s : "http://" + f11631s;
    }

    /* renamed from: u */
    private static String m11308u() {
        if (f11616d == null) {
            f11616d = C3159aa.m10962a().m10979a("primary_sms_address", (String) null);
        }
        return m11296i().intValue() == 443 ? "https://" + f11616d : "http://" + f11616d;
    }

    /* renamed from: v */
    private static String m11309v() {
        if (f11632t == null) {
            f11632t = C3159aa.m10962a().m10979a("secondary_sms_addrss", (String) null);
        }
        return m11297j().intValue() == 443 ? "https://" + f11632t : "http://" + f11632t;
    }

    /* renamed from: b */
    public static Integer m11281b() {
        if (f11621i == null) {
            f11621i = C3159aa.m10962a().m10978a("primary_contact_port", (Integer) 0);
        }
        return f11621i;
    }

    /* renamed from: c */
    public static Integer m11285c() {
        if (f11637y == null) {
            f11637y = C3159aa.m10962a().m10978a("secondary_contact_port", (Integer) 0);
        }
        return f11637y;
    }

    /* renamed from: d */
    public static String m11286d() {
        if (f11614b == null) {
            f11614b = C3159aa.m10962a().m10979a("primary_message_addrss", "");
        }
        return f11614b;
    }

    /* renamed from: e */
    public static String m11288e() {
        if (f11630r == null) {
            f11630r = C3159aa.m10962a().m10979a("secondary_message_addrss", "");
        }
        return f11630r;
    }

    /* renamed from: f */
    public static Integer m11290f() {
        if (f11622j == null) {
            f11622j = C3159aa.m10962a().m10978a("primary_message_port", (Integer) 0);
        }
        return f11622j;
    }

    /* renamed from: g */
    public static Integer m11292g() {
        if (f11638z == null) {
            f11638z = C3159aa.m10962a().m10978a("secondary_message_port", (Integer) 0);
        }
        return f11638z;
    }

    /* renamed from: h */
    public static Integer m11294h() {
        if (f11623k == null) {
            f11623k = C3159aa.m10962a().m10978a("primary_file_port", (Integer) 0);
        }
        return f11623k;
    }

    /* renamed from: i */
    public static Integer m11296i() {
        if (f11624l == null) {
            f11624l = C3159aa.m10962a().m10978a("primary_sms_port", (Integer) 0);
        }
        return f11624l;
    }

    /* renamed from: j */
    public static Integer m11297j() {
        if (f11606B == null) {
            f11606B = C3159aa.m10962a().m10978a("secondary_sms_port", (Integer) 0);
        }
        return f11606B;
    }

    /* renamed from: w */
    private static String m11310w() {
        if (f11617e == null) {
            f11617e = C3159aa.m10962a().m10979a("primary_live_mobileweb_address", (String) null);
        }
        if (TextUtils.isEmpty(f11617e)) {
            return null;
        }
        if (m11298k().intValue() == 443) {
            return "https://" + f11617e;
        }
        return "http://" + f11617e;
    }

    /* renamed from: x */
    private static String m11311x() {
        if (f11633u == null) {
            f11633u = C3159aa.m10962a().m10979a("secondary_live_mobileweb_addrss", (String) null);
        }
        if (TextUtils.isEmpty(f11633u)) {
            return null;
        }
        if (m11299l().intValue() == 443) {
            return "https://" + f11633u;
        }
        return "http://" + f11633u;
    }

    /* renamed from: k */
    public static Integer m11298k() {
        if (f11625m == null) {
            f11625m = C3159aa.m10962a().m10978a("primary_live_mobileweb_port", (Integer) 0);
        }
        return f11625m;
    }

    /* renamed from: l */
    public static Integer m11299l() {
        if (f11607C == null) {
            f11607C = C3159aa.m10962a().m10978a("secondary_live_mobileweb_port", (Integer) 0);
        }
        return f11607C;
    }

    /* renamed from: y */
    private static String m11312y() {
        if (f11618f == null) {
            f11618f = C3159aa.m10962a().m10979a("primary_admin_mobileweb_address", (String) null);
        }
        if (TextUtils.isEmpty(f11618f)) {
            return null;
        }
        if (m11300m().intValue() == 443) {
            return "https://" + f11618f;
        }
        return "http://" + f11618f;
    }

    /* renamed from: z */
    private static String m11313z() {
        if (f11634v == null) {
            f11634v = C3159aa.m10962a().m10979a("secondary_admin_mobileweb_addrss", (String) null);
        }
        if (TextUtils.isEmpty(f11634v)) {
            return null;
        }
        if (m11301n().intValue() == 443) {
            return "https://" + f11634v;
        }
        return "http://" + f11634v;
    }

    /* renamed from: m */
    public static Integer m11300m() {
        if (f11626n == null) {
            f11626n = C3159aa.m10962a().m10978a("primary_admin_mobileweb_port", (Integer) 0);
        }
        return f11626n;
    }

    /* renamed from: n */
    public static Integer m11301n() {
        if (f11608D == null) {
            f11608D = C3159aa.m10962a().m10978a("secondary_admin_mobileweb_port", (Integer) 0);
        }
        return f11608D;
    }

    /* renamed from: A */
    private static String m11274A() {
        if (f11620h == null) {
            f11620h = C3159aa.m10962a().m10979a("primary_chaton_v_address", (String) null);
        }
        if (TextUtils.isEmpty(f11620h)) {
            return null;
        }
        if (m11302o().intValue() == 443) {
            return "https://" + f11620h;
        }
        return "http://" + f11620h;
    }

    /* renamed from: B */
    private static String m11275B() {
        if (f11636x == null) {
            f11636x = C3159aa.m10962a().m10979a("secondary_chaton_v_address", (String) null);
        }
        if (TextUtils.isEmpty(f11636x)) {
            return null;
        }
        if (m11303p().intValue() == 443) {
            return "https://" + f11636x;
        }
        return "http://" + f11636x;
    }

    /* renamed from: o */
    public static Integer m11302o() {
        if (f11628p == null) {
            f11628p = C3159aa.m10962a().m10978a("primary_chaton_v_port", (Integer) 0);
        }
        return f11628p;
    }

    /* renamed from: p */
    public static Integer m11303p() {
        if (f11610F == null) {
            f11610F = C3159aa.m10962a().m10978a("secondary_chaton_v_port", (Integer) 0);
        }
        return f11610F;
    }
}
