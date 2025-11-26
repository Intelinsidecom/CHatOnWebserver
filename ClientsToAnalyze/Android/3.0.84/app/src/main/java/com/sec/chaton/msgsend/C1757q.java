package com.sec.chaton.msgsend;

import android.content.Context;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: MsgSendHelper.java */
/* renamed from: com.sec.chaton.msgsend.q */
/* loaded from: classes.dex */
public class C1757q {

    /* renamed from: c */
    private static final String f6477c = C1757q.class.getSimpleName();

    /* renamed from: a */
    static EnumC1758r f6475a = EnumC1758r.NOT_DETERMINED;

    /* renamed from: b */
    static EnumC1758r f6476b = EnumC1758r.NOT_DETERMINED;

    /* renamed from: a */
    public static void m7248a() {
        synchronized (f6476b) {
            f6475a = EnumC1758r.NOT_DETERMINED;
            f6476b = EnumC1758r.NOT_DETERMINED;
        }
    }

    /* renamed from: b */
    public static boolean m7251b() {
        synchronized (f6476b) {
            if (f6476b == EnumC1758r.NOT_DETERMINED) {
                EnumC1758r enumC1758rM7258a = EnumC1758r.m7258a(C3159aa.m10962a().m10978a("autoresend_enable", Integer.valueOf(EnumC1758r.NOT_DETERMINED.m7259a())).intValue());
                C1759s.m7260a(f6477c, "Read AUTO-RESEND preference, %s ", enumC1758rM7258a);
                if (enumC1758rM7258a == EnumC1758r.NOT_DETERMINED) {
                    enumC1758rM7258a = EnumC1758r.DISABLED;
                }
                C1759s.m7260a(f6477c, "Set AUTO-RESEND value in-memory, %s -> %s", f6476b, enumC1758rM7258a);
                f6476b = enumC1758rM7258a;
            }
            return f6476b == EnumC1758r.ENABLED;
        }
    }

    /* renamed from: c */
    public static boolean m7253c() {
        EnumC1758r enumC1758r;
        synchronized (f6476b) {
            enumC1758r = f6476b;
            C1759s.m7260a(f6477c, "turnOnAutoResend(), previous(%s)", enumC1758r);
            f6476b = EnumC1758r.ENABLED;
            C3159aa.m10962a().m10984b("autoresend_enable", Integer.valueOf(f6476b.m7259a()));
        }
        if (enumC1758r == EnumC1758r.DISABLED) {
            C1756p.m7244c();
            C1756p.m7225a();
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m7254d() {
        EnumC1758r enumC1758r;
        synchronized (f6476b) {
            enumC1758r = f6476b;
            C1759s.m7260a(f6477c, "turnOffAutoResend(), previous(%s)", enumC1758r);
            f6476b = EnumC1758r.DISABLED;
            C3159aa.m10962a().m10984b("autoresend_enable", Integer.valueOf(f6476b.m7259a()));
        }
        if (enumC1758r == EnumC1758r.ENABLED) {
            C1756p.m7244c();
            C1373q.m6186b(GlobalApplication.m11493l().getContentResolver());
            C1756p.m7242b();
        }
        return true;
    }

    /* renamed from: e */
    public static void m7255e() throws Throwable {
        boolean zM7252b = m7252b(true);
        C1759s.m7260a(f6477c, "checkAndSetUseAutoResend() - set : result (%s)", Boolean.valueOf(zM7252b));
        if (zM7252b) {
            m7253c();
        } else {
            m7254d();
        }
    }

    /* renamed from: b */
    private static boolean m7252b(boolean z) throws Throwable {
        ArrayList arrayList = new ArrayList(Arrays.asList("KR"));
        ArrayList arrayList2 = new ArrayList(Arrays.asList("450"));
        String str = String.format("[INFO] NOT USE AUTO RESEND COUNTRY IS : (ISO) %s", arrayList);
        String str2 = String.format("[INFO] NOT USE AUTO RESEND COUNTRY IS : (MCC) %s", arrayList2);
        C1759s.m7260a(f6477c, str, new Object[0]);
        C1759s.m7260a(f6477c, str2, new Object[0]);
        String strM10979a = C3159aa.m10962a().m10979a("account_country_code", "");
        String strM10979a2 = C3159aa.m10962a().m10979a("country_ISO", "");
        String strM10979a3 = C3159aa.m10962a().m10979a("country_letter", "");
        String strM11068h = C3171am.m11068h();
        String strM11064f = C3171am.m11064f();
        boolean z2 = (arrayList.contains(strM10979a) || arrayList.contains(strM10979a2) || arrayList.contains(strM10979a3) || arrayList2.contains(strM11068h) || arrayList2.contains(strM11064f)) ? false : true;
        String str3 = String.format("[RESULT] Check ISO Country [ENABLE ? : %s] : SA(%s), Phone(%s), skip(%s), SimMCC(%s), NetMCC(%s)", Boolean.valueOf(z2), strM10979a, strM10979a2, strM10979a3, strM11068h, strM11064f);
        C1759s.m7260a(f6477c, str3, new Object[0]);
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str).append("\n").append(str2).append("\n").append(str3).append("\n");
            m7249a(GlobalApplication.m11493l(), sb.toString());
        }
        return z2;
    }

    /* renamed from: a */
    public static File m7247a(Context context) {
        return new File(GlobalApplication.m8156h().getDir("trace", 0).getPath(), m7256f());
    }

    /* renamed from: f */
    public static String m7256f() {
        return "auto_resend_activation_trace.txt";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.FileOutputStream] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m7249a(android.content.Context r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            java.io.File r0 = m7247a(r5)
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy-MM-dd HH:mm:ss.SSS (Z)"
            r1.<init>(r2)
            java.util.Date r2 = new java.util.Date
            long r3 = java.lang.System.currentTimeMillis()
            r2.<init>(r3)
            java.lang.String r1 = r1.format(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = " : "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r2 = "\r\n"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r3 = r1.toString()
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.io.FileNotFoundException -> L4c java.io.IOException -> L6b java.lang.Throwable -> L87
            r4 = 1
            r1.<init>(r0, r4)     // Catch: java.io.FileNotFoundException -> L4c java.io.IOException -> L6b java.lang.Throwable -> L87
            byte[] r0 = r3.getBytes()     // Catch: java.lang.Throwable -> La5 java.io.IOException -> La7 java.io.FileNotFoundException -> La9
            r1.write(r0)     // Catch: java.lang.Throwable -> La5 java.io.IOException -> La7 java.io.FileNotFoundException -> La9
            if (r1 == 0) goto L4b
            r1.flush()     // Catch: java.io.IOException -> L9d
            r1.close()     // Catch: java.io.IOException -> L9d
        L4b:
            return
        L4c:
            r0 = move-exception
            r1 = r2
        L4e:
            boolean r2 = com.sec.chaton.util.C3250y.f11737e     // Catch: java.lang.Throwable -> La5
            if (r2 == 0) goto L57
            java.lang.String r2 = com.sec.chaton.msgsend.C1757q.f6477c     // Catch: java.lang.Throwable -> La5
            com.sec.chaton.util.C3250y.m11443a(r0, r2)     // Catch: java.lang.Throwable -> La5
        L57:
            if (r1 == 0) goto L4b
            r1.flush()     // Catch: java.io.IOException -> L60
            r1.close()     // Catch: java.io.IOException -> L60
            goto L4b
        L60:
            r0 = move-exception
            boolean r1 = com.sec.chaton.util.C3250y.f11737e
            if (r1 == 0) goto L4b
            java.lang.String r1 = com.sec.chaton.msgsend.C1757q.f6477c
        L67:
            com.sec.chaton.util.C3250y.m11443a(r0, r1)
            goto L4b
        L6b:
            r0 = move-exception
            r1 = r2
        L6d:
            boolean r2 = com.sec.chaton.util.C3250y.f11737e     // Catch: java.lang.Throwable -> La5
            if (r2 == 0) goto L76
            java.lang.String r2 = com.sec.chaton.msgsend.C1757q.f6477c     // Catch: java.lang.Throwable -> La5
            com.sec.chaton.util.C3250y.m11443a(r0, r2)     // Catch: java.lang.Throwable -> La5
        L76:
            if (r1 == 0) goto L4b
            r1.flush()     // Catch: java.io.IOException -> L7f
            r1.close()     // Catch: java.io.IOException -> L7f
            goto L4b
        L7f:
            r0 = move-exception
            boolean r1 = com.sec.chaton.util.C3250y.f11737e
            if (r1 == 0) goto L4b
            java.lang.String r1 = com.sec.chaton.msgsend.C1757q.f6477c
            goto L67
        L87:
            r0 = move-exception
            r1 = r2
        L89:
            if (r1 == 0) goto L91
            r1.flush()     // Catch: java.io.IOException -> L92
            r1.close()     // Catch: java.io.IOException -> L92
        L91:
            throw r0
        L92:
            r1 = move-exception
            boolean r2 = com.sec.chaton.util.C3250y.f11737e
            if (r2 == 0) goto L91
            java.lang.String r2 = com.sec.chaton.msgsend.C1757q.f6477c
            com.sec.chaton.util.C3250y.m11443a(r1, r2)
            goto L91
        L9d:
            r0 = move-exception
            boolean r1 = com.sec.chaton.util.C3250y.f11737e
            if (r1 == 0) goto L4b
            java.lang.String r1 = com.sec.chaton.msgsend.C1757q.f6477c
            goto L67
        La5:
            r0 = move-exception
            goto L89
        La7:
            r0 = move-exception
            goto L6d
        La9:
            r0 = move-exception
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.msgsend.C1757q.m7249a(android.content.Context, java.lang.String):void");
    }

    /* renamed from: g */
    public static boolean m7257g() {
        if (f6475a == EnumC1758r.NOT_DETERMINED) {
            EnumC1758r enumC1758rM7258a = EnumC1758r.m7258a(C3159aa.m10962a().m10978a("noti_for_autoresend", Integer.valueOf(EnumC1758r.NOT_DETERMINED.m7259a())).intValue());
            C1759s.m7260a(f6477c, "Read NOTI-AUTO-RESEND preference, %s ", enumC1758rM7258a);
            if (enumC1758rM7258a == EnumC1758r.NOT_DETERMINED) {
                enumC1758rM7258a = EnumC1758r.DISABLED;
            }
            C1759s.m7260a(f6477c, "Set NOTI-AUTO-RESEND value in-memory, %s -> %s", f6475a, enumC1758rM7258a);
            f6475a = enumC1758rM7258a;
        }
        return f6475a == EnumC1758r.ENABLED;
    }

    /* renamed from: a */
    public static void m7250a(boolean z) {
        C1759s.m7260a(f6477c, "setNotiEnable? -> (%s)", Boolean.valueOf(z));
        if (z) {
            f6475a = EnumC1758r.ENABLED;
        } else {
            f6475a = EnumC1758r.DISABLED;
            C1760t.m7261a();
        }
        C3159aa.m10962a().m10984b("noti_for_autoresend", Integer.valueOf(f6475a.m7259a()));
    }
}
