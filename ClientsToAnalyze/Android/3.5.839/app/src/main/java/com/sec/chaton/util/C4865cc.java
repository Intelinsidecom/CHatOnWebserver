package com.sec.chaton.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.qmlog.C3122d;
import com.sec.common.util.C5052r;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.cc */
/* loaded from: classes.dex */
public class C4865cc {

    /* renamed from: K */
    private static String f17710K;

    /* renamed from: L */
    private static String f17711L;

    /* renamed from: X */
    private static Integer f17723X;

    /* renamed from: Y */
    private static Integer f17724Y;

    /* renamed from: k */
    private static String f17738k;

    /* renamed from: l */
    private static String f17739l;

    /* renamed from: x */
    private static Integer f17751x;

    /* renamed from: y */
    private static Integer f17752y;

    /* renamed from: a */
    private static String f17726a = null;

    /* renamed from: b */
    private static String f17729b = null;

    /* renamed from: c */
    private static String f17730c = null;

    /* renamed from: d */
    private static String f17731d = null;

    /* renamed from: e */
    private static String f17732e = null;

    /* renamed from: f */
    private static String f17733f = null;

    /* renamed from: g */
    private static String f17734g = null;

    /* renamed from: h */
    private static String f17735h = null;

    /* renamed from: i */
    private static String f17736i = null;

    /* renamed from: j */
    private static String f17737j = null;

    /* renamed from: m */
    private static String f17740m = null;

    /* renamed from: n */
    private static Integer f17741n = null;

    /* renamed from: o */
    private static Integer f17742o = null;

    /* renamed from: p */
    private static Integer f17743p = null;

    /* renamed from: q */
    private static Integer f17744q = null;

    /* renamed from: r */
    private static Integer f17745r = null;

    /* renamed from: s */
    private static Integer f17746s = null;

    /* renamed from: t */
    private static Integer f17747t = null;

    /* renamed from: u */
    private static Integer f17748u = null;

    /* renamed from: v */
    private static Integer f17749v = null;

    /* renamed from: w */
    private static Integer f17750w = null;

    /* renamed from: z */
    private static Integer f17753z = null;

    /* renamed from: A */
    private static String f17700A = null;

    /* renamed from: B */
    private static String f17701B = null;

    /* renamed from: C */
    private static String f17702C = null;

    /* renamed from: D */
    private static String f17703D = null;

    /* renamed from: E */
    private static String f17704E = null;

    /* renamed from: F */
    private static String f17705F = null;

    /* renamed from: G */
    private static String f17706G = null;

    /* renamed from: H */
    private static String f17707H = null;

    /* renamed from: I */
    private static String f17708I = null;

    /* renamed from: J */
    private static String f17709J = null;

    /* renamed from: M */
    private static String f17712M = null;

    /* renamed from: N */
    private static Integer f17713N = null;

    /* renamed from: O */
    private static Integer f17714O = null;

    /* renamed from: P */
    private static Integer f17715P = null;

    /* renamed from: Q */
    private static Integer f17716Q = null;

    /* renamed from: R */
    private static Integer f17717R = null;

    /* renamed from: S */
    private static Integer f17718S = null;

    /* renamed from: T */
    private static Integer f17719T = null;

    /* renamed from: U */
    private static Integer f17720U = null;

    /* renamed from: V */
    private static Integer f17721V = null;

    /* renamed from: W */
    private static Integer f17722W = null;

    /* renamed from: Z */
    private static Integer f17725Z = null;

    /* renamed from: aa */
    private static long f17727aa = 0;

    /* renamed from: ab */
    private static Map<EnumC4868cf, EnumC4867ce> f17728ab = new HashMap();

    /* renamed from: a */
    public static void m18445a() {
        f17726a = null;
        f17729b = null;
        f17730c = null;
        f17731d = null;
        f17732e = null;
        f17733f = null;
        f17734g = null;
        f17736i = null;
        f17737j = null;
        f17740m = null;
        f17741n = null;
        f17742o = null;
        f17743p = null;
        f17744q = null;
        f17745r = null;
        f17746s = null;
        f17747t = null;
        f17749v = null;
        f17750w = null;
        f17753z = null;
        f17728ab.clear();
        C4809aa.m18104a().m18123a("is_file_server_primary ");
    }

    /* renamed from: a */
    public static void m18447a(boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = f17727aa == 0 ? 99999L : jElapsedRealtime - f17727aa;
        if (j < 0) {
            j = -j;
        }
        C4904y.m18639b("checkExpireDate called time last=" + f17727aa + " cur=" + jElapsedRealtime + ", force=" + z, null);
        if (z || j > 10000) {
            f17727aa = jElapsedRealtime;
            if (C4809aa.m18104a().m18129b("primary_contact_addrss")) {
                if (!C4809aa.m18104a().m18129b("expdate")) {
                    C4904y.m18639b("checkExpireDate expdate is not available", null);
                    return;
                }
                long jM18118a = C4809aa.m18104a().m18118a("expdate", 0L);
                long jCurrentTimeMillis = System.currentTimeMillis();
                C4904y.m18639b("checkExpireDate expdate=" + jM18118a + ", cur=" + jCurrentTimeMillis, null);
                if (jCurrentTimeMillis > jM18118a) {
                    new C2132m(new Handler(Looper.getMainLooper())).m9552a();
                    return;
                }
                return;
            }
            new C2132m(new Handler(Looper.getMainLooper())).m9552a();
        }
    }

    /* renamed from: a */
    public static EnumC4867ce m18443a(EnumC4868cf enumC4868cf) {
        if (!enumC4868cf.f17778t) {
            throw new IllegalArgumentException(C5052r.m19199a(enumC4868cf.name(), " doesn't support server type."));
        }
        if (!f17728ab.containsKey(enumC4868cf)) {
            f17728ab.put(enumC4868cf, EnumC4867ce.PRIMARY);
        }
        return f17728ab.get(enumC4868cf);
    }

    /* renamed from: a */
    public static void m18446a(EnumC4868cf enumC4868cf, EnumC4867ce enumC4867ce) {
        if (!enumC4868cf.f17778t) {
            throw new IllegalArgumentException(C5052r.m19199a(enumC4868cf.name(), " doesn't support server type."));
        }
        if (!f17728ab.containsKey(enumC4868cf)) {
            f17728ab.put(enumC4868cf, EnumC4867ce.PRIMARY);
        }
        f17728ab.put(enumC4868cf, enumC4867ce);
    }

    /* renamed from: b */
    public static String m18450b(EnumC4868cf enumC4868cf) {
        EnumC4867ce enumC4867ce = EnumC4867ce.PRIMARY;
        if (enumC4868cf.f17778t) {
            if (!f17728ab.containsKey(enumC4868cf)) {
                f17728ab.put(enumC4868cf, EnumC4867ce.PRIMARY);
            }
            enumC4867ce = f17728ab.get(enumC4868cf);
        }
        switch (C4866cd.f17754a[enumC4868cf.ordinal()]) {
            case 1:
                return m18468k(enumC4867ce);
            case 2:
                return m18449b(enumC4867ce);
            case 3:
                return m18454d(enumC4867ce);
            case 4:
                return m18444a(enumC4867ce);
            case 5:
                return m18458f(enumC4867ce);
            case 6:
                return m18456e(enumC4867ce);
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
                return m18470l(enumC4867ce);
            case 11:
                return m18460g(enumC4867ce);
            case 12:
                return m18466j(enumC4867ce);
            case 13:
                return C1850c.m9024d().m9026a();
            case 14:
                return C3122d.m12734b();
            case 15:
                return m18462h(enumC4867ce);
            case 16:
                return m18464i(enumC4867ce);
            case 17:
                return m18472m(enumC4867ce);
            default:
                return "";
        }
    }

    /* renamed from: a */
    public static String m18444a(EnumC4867ce enumC4867ce) {
        String str;
        String str2;
        if (C1427a.f5063a.split("[.]").length == 3) {
            str = "https://gld1.samsungchaton.com";
            str2 = "https://gld2.samsungchaton.com";
        } else {
            str = "http://ec2-54-196-232-191.compute-1.amazonaws.com";
            str2 = "http://ec2-54-196-232-191.compute-1.amazonaws.com";
        }
        if (C4809aa.m18104a().m18119a("admin_dev_gld", (Boolean) false).booleanValue()) {
            str = "http://lb-due1wg1gd-1821392689.us-east-1.elb.amazonaws.com";
            str2 = "http://lb-due1wg1gd-1821392689.us-east-1.elb.amazonaws.com";
        }
        return enumC4867ce == EnumC4867ce.PRIMARY ? str : str2;
    }

    /* renamed from: b */
    public static String m18449b(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18421A() : m18422B();
    }

    /* renamed from: c */
    public static int m18451c(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18448b().intValue() : m18452c().intValue();
    }

    /* renamed from: d */
    public static String m18454d(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18423C() : m18424D();
    }

    /* renamed from: e */
    public static String m18456e(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18425E() : m18426F();
    }

    /* renamed from: f */
    public static String m18458f(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18427G() : m18428H();
    }

    /* renamed from: g */
    public static String m18460g(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18429I() : m18430J();
    }

    /* renamed from: h */
    public static String m18462h(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18431K() : m18432L();
    }

    /* renamed from: i */
    public static String m18464i(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18433M() : m18434N();
    }

    /* renamed from: j */
    public static String m18466j(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18435O() : m18436P();
    }

    /* renamed from: k */
    public static String m18468k(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18437Q() : m18438R();
    }

    /* renamed from: l */
    public static String m18470l(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18439S() : m18440T();
    }

    /* renamed from: m */
    public static String m18472m(EnumC4867ce enumC4867ce) {
        return enumC4867ce == EnumC4867ce.PRIMARY ? m18441U() : m18442V();
    }

    /* renamed from: A */
    private static String m18421A() {
        if (f17726a == null) {
            f17726a = C4809aa.m18104a().m18121a("primary_contact_addrss", (String) null);
        }
        return m18448b().intValue() == 443 ? "https://" + f17726a : "http://" + f17726a;
    }

    /* renamed from: B */
    private static String m18422B() {
        if (f17700A == null) {
            f17700A = C4809aa.m18104a().m18121a("secondary_contact_addrss", (String) null);
        }
        return m18452c().intValue() == 443 ? "https://" + f17700A : "http://" + f17700A;
    }

    /* renamed from: C */
    private static String m18423C() {
        if (f17730c == null) {
            f17730c = C4809aa.m18104a().m18121a("primary_file_addrss", (String) null);
        }
        return m18461h().intValue() == 443 ? "https://" + f17730c : "http://" + f17730c;
    }

    /* renamed from: D */
    private static String m18424D() {
        if (f17702C == null) {
            f17702C = C4809aa.m18104a().m18121a("secondary_file_addrss", (String) null);
        }
        return m18461h().intValue() == 443 ? "https://" + f17702C : "http://" + f17702C;
    }

    /* renamed from: E */
    private static String m18425E() {
        if (f17731d == null) {
            f17731d = C4809aa.m18104a().m18121a("primary_sms_address", (String) null);
        }
        return m18463i().intValue() == 443 ? "https://" + f17731d : "http://" + f17731d;
    }

    /* renamed from: F */
    private static String m18426F() {
        if (f17703D == null) {
            f17703D = C4809aa.m18104a().m18121a("secondary_sms_addrss", (String) null);
        }
        return m18465j().intValue() == 443 ? "https://" + f17703D : "http://" + f17703D;
    }

    /* renamed from: b */
    public static Integer m18448b() {
        if (f17741n == null) {
            f17741n = C4809aa.m18104a().m18120a("primary_contact_port", (Integer) 0);
        }
        return f17741n;
    }

    /* renamed from: c */
    public static Integer m18452c() {
        if (f17713N == null) {
            f17713N = C4809aa.m18104a().m18120a("secondary_contact_port", (Integer) 0);
        }
        return f17713N;
    }

    /* renamed from: d */
    public static String m18453d() {
        if (f17729b == null) {
            f17729b = C4809aa.m18104a().m18121a("primary_message_addrss", "");
        }
        return f17729b;
    }

    /* renamed from: e */
    public static String m18455e() {
        if (f17701B == null) {
            f17701B = C4809aa.m18104a().m18121a("secondary_message_addrss", "");
        }
        return f17701B;
    }

    /* renamed from: f */
    public static Integer m18457f() {
        if (f17742o == null) {
            f17742o = C4809aa.m18104a().m18120a("primary_message_port", (Integer) 0);
        }
        return f17742o;
    }

    /* renamed from: g */
    public static Integer m18459g() {
        if (f17714O == null) {
            f17714O = C4809aa.m18104a().m18120a("secondary_message_port", (Integer) 0);
        }
        return f17714O;
    }

    /* renamed from: h */
    public static Integer m18461h() {
        if (f17743p == null) {
            f17743p = C4809aa.m18104a().m18120a("primary_file_port", (Integer) 0);
        }
        return f17743p;
    }

    /* renamed from: i */
    public static Integer m18463i() {
        if (f17744q == null) {
            f17744q = C4809aa.m18104a().m18120a("primary_sms_port", (Integer) 0);
        }
        return f17744q;
    }

    /* renamed from: j */
    public static Integer m18465j() {
        if (f17716Q == null) {
            f17716Q = C4809aa.m18104a().m18120a("secondary_sms_port", (Integer) 0);
        }
        return f17716Q;
    }

    /* renamed from: G */
    private static String m18427G() {
        if (f17732e == null) {
            f17732e = C4809aa.m18104a().m18121a("primary_live_mobileweb_address", (String) null);
        }
        if (TextUtils.isEmpty(f17732e)) {
            return null;
        }
        if (m18467k().intValue() == 443) {
            return "https://" + f17732e;
        }
        return "http://" + f17732e;
    }

    /* renamed from: H */
    private static String m18428H() {
        if (f17704E == null) {
            f17704E = C4809aa.m18104a().m18121a("secondary_live_mobileweb_addrss", (String) null);
        }
        if (TextUtils.isEmpty(f17704E)) {
            return null;
        }
        if (m18469l().intValue() == 443) {
            return "https://" + f17704E;
        }
        return "http://" + f17704E;
    }

    /* renamed from: k */
    public static Integer m18467k() {
        if (f17745r == null) {
            f17745r = C4809aa.m18104a().m18120a("primary_live_mobileweb_port", (Integer) 0);
        }
        return f17745r;
    }

    /* renamed from: l */
    public static Integer m18469l() {
        if (f17717R == null) {
            f17717R = C4809aa.m18104a().m18120a("secondary_live_mobileweb_port", (Integer) 0);
        }
        return f17717R;
    }

    /* renamed from: I */
    private static String m18429I() {
        if (f17736i == null) {
            f17736i = C4809aa.m18104a().m18121a("primary_shop_address", (String) null);
        }
        if (TextUtils.isEmpty(f17736i)) {
            return null;
        }
        if (m18471m().intValue() == 443) {
            return "https://" + f17736i;
        }
        return "http://" + f17736i;
    }

    /* renamed from: J */
    private static String m18430J() {
        if (f17708I == null) {
            f17708I = C4809aa.m18104a().m18121a("secondary_shop_addrss", (String) null);
        }
        if (TextUtils.isEmpty(f17708I)) {
            return null;
        }
        if (m18473n().intValue() == 443) {
            return "https://" + f17708I;
        }
        return "http://" + f17708I;
    }

    /* renamed from: m */
    public static Integer m18471m() {
        return 80;
    }

    /* renamed from: n */
    public static Integer m18473n() {
        if (f17721V == null) {
            f17721V = C4809aa.m18104a().m18120a("secondary_shop_port", (Integer) 0);
        }
        return f17721V;
    }

    /* renamed from: K */
    private static String m18431K() {
        if (f17738k == null) {
            f17738k = C4809aa.m18104a().m18121a("primary_game_address", (String) null);
        }
        if (TextUtils.isEmpty(f17738k)) {
            return null;
        }
        if (m18474o().intValue() == 443) {
            return "https://" + f17738k;
        }
        return "http://" + f17738k;
    }

    /* renamed from: L */
    private static String m18432L() {
        if (f17710K == null) {
            f17710K = C4809aa.m18104a().m18121a("secondary_game_addrss", (String) null);
        }
        if (TextUtils.isEmpty(f17710K)) {
            return null;
        }
        if (m18475p().intValue() == 443) {
            return "https://" + f17710K;
        }
        return "http://" + f17710K;
    }

    /* renamed from: o */
    public static Integer m18474o() {
        if (f17751x == null) {
            f17751x = C4809aa.m18104a().m18120a("primary_game_port", (Integer) 0);
        }
        return f17751x;
    }

    /* renamed from: p */
    public static Integer m18475p() {
        if (f17723X == null) {
            f17723X = C4809aa.m18104a().m18120a("secondary_game_port", (Integer) 0);
        }
        return f17723X;
    }

    /* renamed from: M */
    private static String m18433M() {
        if (f17739l == null) {
            f17739l = C4809aa.m18104a().m18121a("primary_huge_file_address", (String) null);
        }
        if (TextUtils.isEmpty(f17739l)) {
            return null;
        }
        if (m18476q().intValue() == 443) {
            return "https://" + f17739l;
        }
        return "http://" + f17739l;
    }

    /* renamed from: N */
    private static String m18434N() {
        if (f17711L == null) {
            f17711L = C4809aa.m18104a().m18121a("secondary_huge_file_addrss", (String) null);
        }
        if (TextUtils.isEmpty(f17711L)) {
            return null;
        }
        if (m18477r().intValue() == 443) {
            return "https://" + f17711L;
        }
        return "http://" + f17711L;
    }

    /* renamed from: q */
    public static Integer m18476q() {
        if (f17752y == null) {
            f17752y = C4809aa.m18104a().m18120a("primary_huge_file_port", (Integer) 0);
        }
        return f17752y;
    }

    /* renamed from: r */
    public static Integer m18477r() {
        if (f17724Y == null) {
            f17724Y = C4809aa.m18104a().m18120a("secondary_huge_file_port", (Integer) 0);
        }
        return f17724Y;
    }

    /* renamed from: O */
    private static String m18435O() {
        if (f17737j == null) {
            f17737j = C4809aa.m18104a().m18121a("primary_translation_auth_address", (String) null);
        }
        if (TextUtils.isEmpty(f17737j)) {
            return null;
        }
        if (m18478s().intValue() == 443) {
            return "https://" + f17737j;
        }
        return "http://" + f17737j;
    }

    /* renamed from: P */
    private static String m18436P() {
        if (f17709J == null) {
            f17709J = C4809aa.m18104a().m18121a("secondary_translation_auth_addrss", (String) null);
        }
        if (TextUtils.isEmpty(f17709J)) {
            return null;
        }
        if (m18479t().intValue() == 443) {
            return "https://" + f17709J;
        }
        return "http://" + f17709J;
    }

    /* renamed from: s */
    public static Integer m18478s() {
        if (f17750w == null) {
            f17750w = C4809aa.m18104a().m18120a("primary_translation_auth_port", (Integer) 0);
        }
        return f17750w;
    }

    /* renamed from: t */
    public static Integer m18479t() {
        if (f17722W == null) {
            f17722W = C4809aa.m18104a().m18120a("secondary_translation_auth_port", (Integer) 0);
        }
        return f17722W;
    }

    /* renamed from: Q */
    private static String m18437Q() {
        if (f17733f == null) {
            f17733f = C4809aa.m18104a().m18121a("primary_admin_mobileweb_address", (String) null);
        }
        if (TextUtils.isEmpty(f17733f)) {
            return null;
        }
        if (m18480u().intValue() == 443) {
            return "https://" + f17733f;
        }
        return "http://" + f17733f;
    }

    /* renamed from: R */
    private static String m18438R() {
        if (f17705F == null) {
            f17705F = C4809aa.m18104a().m18121a("secondary_admin_mobileweb_addrss", (String) null);
        }
        if (TextUtils.isEmpty(f17705F)) {
            return null;
        }
        if (m18481v().intValue() == 443) {
            return "https://" + f17705F;
        }
        return "http://" + f17705F;
    }

    /* renamed from: u */
    public static Integer m18480u() {
        if (f17746s == null) {
            f17746s = C4809aa.m18104a().m18120a("primary_admin_mobileweb_port", (Integer) 0);
        }
        return f17746s;
    }

    /* renamed from: v */
    public static Integer m18481v() {
        if (f17718S == null) {
            f17718S = C4809aa.m18104a().m18120a("secondary_admin_mobileweb_port", (Integer) 0);
        }
        return f17718S;
    }

    /* renamed from: S */
    private static String m18439S() {
        if (f17735h == null) {
            f17735h = C4809aa.m18104a().m18121a("primary_chaton_v_address", (String) null);
        }
        if (TextUtils.isEmpty(f17735h)) {
            return null;
        }
        if (m18482w().intValue() == 443) {
            return "https://" + f17735h;
        }
        return "http://" + f17735h;
    }

    /* renamed from: T */
    private static String m18440T() {
        if (f17707H == null) {
            f17707H = C4809aa.m18104a().m18121a("secondary_chaton_v_address", (String) null);
        }
        if (TextUtils.isEmpty(f17707H)) {
            return null;
        }
        if (m18483x().intValue() == 443) {
            return "https://" + f17707H;
        }
        return "http://" + f17707H;
    }

    /* renamed from: w */
    public static Integer m18482w() {
        if (f17748u == null) {
            f17748u = C4809aa.m18104a().m18120a("primary_chaton_v_port", (Integer) 0);
        }
        return f17748u;
    }

    /* renamed from: x */
    public static Integer m18483x() {
        if (f17720U == null) {
            f17720U = C4809aa.m18104a().m18120a("secondary_chaton_v_port", (Integer) 0);
        }
        return f17720U;
    }

    /* renamed from: U */
    private static String m18441U() {
        if (f17740m == null) {
            f17740m = C4809aa.m18104a().m18121a("primary_auth_address", (String) null);
        }
        if (TextUtils.isEmpty(f17740m)) {
            return null;
        }
        if (m18484y().intValue() == 443) {
            return "https://" + f17740m;
        }
        return "http://" + f17740m;
    }

    /* renamed from: V */
    private static String m18442V() {
        if (f17712M == null) {
            f17712M = C4809aa.m18104a().m18121a("secondary_auth_addrss", (String) null);
        }
        if (TextUtils.isEmpty(f17712M)) {
            return null;
        }
        if (m18485z().intValue() == 443) {
            return "https://" + f17712M;
        }
        return "http://" + f17712M;
    }

    /* renamed from: y */
    public static Integer m18484y() {
        if (f17753z == null) {
            f17753z = C4809aa.m18104a().m18120a("primary_auth_port", (Integer) 0);
        }
        return f17753z;
    }

    /* renamed from: z */
    public static Integer m18485z() {
        if (f17725Z == null) {
            f17725Z = C4809aa.m18104a().m18120a("secondary_auth_port", (Integer) 0);
        }
        return f17725Z;
    }
}
