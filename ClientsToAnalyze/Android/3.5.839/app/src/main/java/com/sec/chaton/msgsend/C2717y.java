package com.sec.chaton.msgsend;

import android.content.Context;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.util.C4809aa;
import java.io.File;

/* compiled from: MsgSendHelper.java */
/* renamed from: com.sec.chaton.msgsend.y */
/* loaded from: classes.dex */
public class C2717y {

    /* renamed from: d */
    private static final String f9741d = C2717y.class.getSimpleName();

    /* renamed from: a */
    static EnumC2683aa f9738a = EnumC2683aa.NOT_DETERMINED;

    /* renamed from: b */
    static EnumC2683aa f9739b = EnumC2683aa.NOT_DETERMINED;

    /* renamed from: c */
    static final Object f9740c = new Object();

    /* renamed from: a */
    public static void m11393a() {
        synchronized (f9740c) {
            f9738a = EnumC2683aa.NOT_DETERMINED;
            f9739b = EnumC2683aa.NOT_DETERMINED;
        }
    }

    /* renamed from: a */
    public static boolean m11395a(EnumC2301u enumC2301u) {
        if (enumC2301u == EnumC2301u.LIVE) {
            return false;
        }
        return m11398b();
    }

    /* renamed from: b */
    public static boolean m11398b() {
        boolean z;
        synchronized (f9740c) {
            if (f9739b == EnumC2683aa.NOT_DETERMINED) {
                EnumC2683aa enumC2683aaM11288a = EnumC2683aa.m11288a(C4809aa.m18104a().m18120a("autoresend_enable", Integer.valueOf(EnumC2683aa.NOT_DETERMINED.m11289a())).intValue());
                C2684ab.m11290a(f9741d, "Read AUTO-RESEND preference, %s ", enumC2683aaM11288a);
                if (enumC2683aaM11288a == EnumC2683aa.NOT_DETERMINED) {
                    enumC2683aaM11288a = EnumC2683aa.ENABLED;
                }
                C2684ab.m11290a(f9741d, "Set AUTO-RESEND value in-memory, %s -> %s", f9739b, enumC2683aaM11288a);
                f9739b = enumC2683aaM11288a;
            }
            z = f9739b == EnumC2683aa.ENABLED;
        }
        return z;
    }

    /* renamed from: c */
    public static boolean m11399c() {
        return m11396a(false);
    }

    /* renamed from: a */
    public static boolean m11396a(boolean z) {
        EnumC2683aa enumC2683aa;
        synchronized (f9740c) {
            enumC2683aa = f9739b;
            C2684ab.m11290a(f9741d, "turnOnAutoResend(), previous(%s)", enumC2683aa);
            f9739b = EnumC2683aa.ENABLED;
            C4809aa.m18104a().m18126b("autoresend_enable", Integer.valueOf(f9739b.m11289a()));
        }
        if (!z && enumC2683aa == EnumC2683aa.DISABLED) {
            C2716x.m11389c();
            C2716x.m11369a();
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m11401d() {
        EnumC2683aa enumC2683aa;
        synchronized (f9740c) {
            enumC2683aa = f9739b;
            C2684ab.m11290a(f9741d, "turnOffAutoResend(), previous(%s)", enumC2683aa);
            f9739b = EnumC2683aa.DISABLED;
            C4809aa.m18104a().m18126b("autoresend_enable", Integer.valueOf(f9739b.m11289a()));
        }
        if (enumC2683aa == EnumC2683aa.ENABLED) {
            C2716x.m11389c();
            C2204r.m10040b(GlobalApplication.m18732r().getContentResolver());
            C2716x.m11387b();
        }
        return true;
    }

    /* renamed from: e */
    public static void m11402e() {
    }

    /* renamed from: f */
    public static void m11403f() {
        if (m11400c(true)) {
            m11396a(true);
        }
    }

    /* renamed from: g */
    public static EnumC2683aa m11404g() {
        return EnumC2683aa.m11288a(C4809aa.m18104a().m18120a("autoresend_enable", Integer.valueOf(EnumC2683aa.NOT_DETERMINED.m11289a())).intValue());
    }

    /* renamed from: c */
    private static boolean m11400c(boolean z) throws Throwable {
        EnumC2683aa enumC2683aaM11404g = m11404g();
        String str = String.format("[INFO] (forced to turn on) needToSetAutoResend_3_2, existPrefAutoResend? (%s)", enumC2683aaM11404g);
        if (z) {
            m11394a(GlobalApplication.m18732r(), str + "\n");
        }
        switch (C2718z.f9742a[enumC2683aaM11404g.ordinal()]) {
            case 1:
            case 3:
            default:
                return true;
            case 2:
                return false;
        }
    }

    /* renamed from: a */
    public static File m11392a(Context context) {
        return new File(GlobalApplication.m12499n().getDir("trace", 0).getPath(), m11405h());
    }

    /* renamed from: h */
    public static String m11405h() {
        return "auto_resend_activation_trace.txt";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.FileOutputStream] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m11394a(android.content.Context r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.msgsend.C2717y.m11394a(android.content.Context, java.lang.String):void");
    }

    /* renamed from: i */
    public static boolean m11406i() {
        if (f9738a == EnumC2683aa.NOT_DETERMINED) {
            EnumC2683aa enumC2683aaM11288a = EnumC2683aa.m11288a(C4809aa.m18104a().m18120a("noti_for_autoresend", Integer.valueOf(EnumC2683aa.NOT_DETERMINED.m11289a())).intValue());
            C2684ab.m11290a(f9741d, "Read NOTI-AUTO-RESEND preference, %s ", enumC2683aaM11288a);
            if (enumC2683aaM11288a == EnumC2683aa.NOT_DETERMINED) {
                enumC2683aaM11288a = EnumC2683aa.DISABLED;
            }
            C2684ab.m11290a(f9741d, "Set NOTI-AUTO-RESEND value in-memory, %s -> %s", f9738a, enumC2683aaM11288a);
            f9738a = enumC2683aaM11288a;
        }
        return f9738a == EnumC2683aa.ENABLED;
    }

    /* renamed from: b */
    public static void m11397b(boolean z) {
        C2684ab.m11290a(f9741d, "setNotiEnable? -> (%s)", Boolean.valueOf(z));
        if (z) {
            f9738a = EnumC2683aa.ENABLED;
        } else {
            f9738a = EnumC2683aa.DISABLED;
            C2685ac.m11291a();
        }
        C4809aa.m18104a().m18126b("noti_for_autoresend", Integer.valueOf(f9738a.m11289a()));
    }
}
