package com.sec.chaton.util;

import android.app.Application;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.util.logcollector.LogCollectService;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

/* compiled from: ChatONLogWriter.java */
/* renamed from: com.sec.chaton.util.y */
/* loaded from: classes.dex */
public class C4904y {

    /* renamed from: a */
    public static boolean f17871a = false;

    /* renamed from: b */
    public static boolean f17872b = false;

    /* renamed from: c */
    public static boolean f17873c = false;

    /* renamed from: d */
    public static boolean f17874d = false;

    /* renamed from: e */
    public static boolean f17875e = false;

    /* renamed from: f */
    public static boolean f17876f = true;

    private C4904y() {
    }

    /* renamed from: a */
    public static boolean m18637a(String str) throws NoSuchAlgorithmException {
        String string = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            string = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "48889278013a56902cd33955d709136f".equals(string);
    }

    /* renamed from: b */
    public static boolean m18640b(String str) throws NoSuchAlgorithmException {
        String string = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            string = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "c9264bad9829907391e3625068ce9d9b".equals(string);
    }

    /* renamed from: c */
    public static boolean m18643c(String str) throws NoSuchAlgorithmException {
        String string = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            string = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "F7235A61FDC3ADC78D866FD8085D44DB".equalsIgnoreCase(string);
    }

    /* renamed from: a */
    public static int m18630a() {
        return C4809aa.m18104a().m18120a("pref_log_on_off", (Integer) 0).intValue();
    }

    /* renamed from: b */
    public static void m18638b() {
        m18632a(-1);
    }

    /* renamed from: a */
    public static void m18632a(int i) {
        if (i == -1) {
            i = C4809aa.m18104a().m18120a("pref_log_on_off", (Integer) 0).intValue();
        } else {
            C4809aa.m18106a("pref_log_on_off", Integer.valueOf(i));
        }
        if (i == 2) {
            LogCollectService.m18548a(GlobalApplication.m18732r());
        }
        String strM18121a = C4809aa.m18104a().m18121a("primary_contact_addrss", "");
        if (C4809aa.m18104a().m18120a("pref_log_on_off", (Integer) 0).intValue() > 0) {
            C3115g.m12703a(true, true, true, true);
            C4996f.f18229a.mo18650a(true, true, true, true, true);
            m18636a(true);
            return;
        }
        if (C2349a.m10301a("log_by_shipbuild")) {
            try {
                if (C5034k.m19102g()) {
                    m18636a(false);
                    C3115g.m12703a(false, false, false, true);
                    C4996f.f18229a.mo18650a(false, false, false, false, true);
                } else {
                    C3115g.m12703a(true, true, true, true);
                    C4996f.f18229a.mo18650a(true, true, true, true, true);
                    m18636a(true);
                }
                return;
            } catch (Throwable th) {
                m18636a(false);
                C3115g.m12703a(false, false, false, true);
                C4996f.f18229a.mo18650a(false, false, false, false, true);
                return;
            }
        }
        if ("stg.contact.samsungchaton.com".equalsIgnoreCase(strM18121a)) {
            C4809aa.m18104a().m18125b("is_stg_chaton", (Boolean) true);
            C3115g.m12703a(true, true, true, true);
            C4996f.f18229a.mo18650a(true, true, true, true, true);
            m18636a(true);
            return;
        }
        if ("dev.contact.samsungchaton.com".equalsIgnoreCase(strM18121a)) {
            C3115g.m12703a(true, true, true, true);
            C4996f.f18229a.mo18650a(true, true, true, true, true);
            m18636a(true);
        } else if (!m18642c()) {
            C3115g.m12703a(true, true, true, true);
            C4996f.f18229a.mo18650a(true, true, true, true, true);
            m18636a(true);
        } else {
            if (((Application) CommonApplication.m18732r().getApplicationContext()).getApplicationInfo().icon == R.drawable.icon_black) {
                LogCollectService.m18548a(GlobalApplication.m18732r());
                C3115g.m12703a(true, true, true, true);
                C4996f.f18229a.mo18650a(true, true, true, true, true);
                m18636a(true);
                return;
            }
            m18636a(false);
            C3115g.m12703a(false, false, false, true);
            C4996f.f18229a.mo18650a(false, false, false, false, true);
        }
    }

    /* renamed from: c */
    private static boolean m18642c() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 1, 10);
        return Calendar.getInstance().compareTo(calendar) >= 0;
    }

    /* renamed from: a */
    public static void m18635a(Throwable th, String str) {
        if (f17875e) {
            C4996f.f18229a.mo18649a(str, th.getMessage(), th);
        }
    }

    /* renamed from: a */
    public static void m18634a(String str, String str2) {
        if (f17875e) {
            C4996f.f18229a.m18895i(str2, str);
        }
    }

    /* renamed from: b */
    public static void m18639b(String str, String str2) {
        if (f17872b) {
            C4996f.f18229a.m18892f(str2, str);
        }
    }

    /* renamed from: c */
    public static void m18641c(String str, String str2) {
        if (f17873c) {
            C4996f.f18229a.m18893g(str2, str);
        }
    }

    /* renamed from: d */
    public static void m18645d(String str, String str2) {
        if (f17874d) {
            C4996f.f18229a.m18894h(str2, str);
        }
    }

    /* renamed from: e */
    public static void m18646e(String str, String str2) {
        if (f17871a) {
            C4996f.f18229a.m18891e(str2, str);
        }
    }

    /* renamed from: d */
    public static void m18644d(String str) {
        m18639b(str, "System_out");
    }

    /* renamed from: a */
    public static void m18633a(Object obj) {
        m18639b(obj != null ? obj.toString() : "null", "System_out");
    }

    /* renamed from: f */
    public static void m18647f(String str, String str2) {
        if (f17876f) {
            C4996f.f18229a.m18892f(str2 + "_MESSAGE_FLOW", str);
        }
    }

    /* renamed from: a */
    public static String m18631a(Throwable th) throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        try {
            stringWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    /* renamed from: a */
    private static void m18636a(boolean z) {
        if (C2349a.m10301a("chatonv_feature") && C2948h.m12190a().m12192a(GlobalApplication.m18732r(), EnumC2949i.ChatONV)) {
            if (z) {
                C0416a.m1469a(GlobalApplication.m18732r(), true);
                if (f17872b) {
                    m18639b("enableChatONVLog : success to ON", C4904y.class.getSimpleName());
                    return;
                }
                return;
            }
            C0416a.m1469a(GlobalApplication.m18732r(), false);
            if (f17872b) {
                m18639b("enableChatONVLog : success to OFF", C4904y.class.getSimpleName());
                return;
            }
            return;
        }
        if (f17872b) {
            m18639b("enableChatONVLog : fail", C4904y.class.getSimpleName());
        }
    }
}
