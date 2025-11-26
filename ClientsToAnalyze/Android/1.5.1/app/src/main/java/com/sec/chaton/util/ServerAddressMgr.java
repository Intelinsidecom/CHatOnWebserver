package com.sec.chaton.util;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.constant.NetworkConstant;
import com.sec.chaton.control.GLDControl;

/* loaded from: classes.dex */
public class ServerAddressMgr {

    /* renamed from: a */
    private static String f3713a = null;

    /* renamed from: b */
    private static String f3714b = null;

    /* renamed from: c */
    private static String f3715c = null;

    /* renamed from: d */
    private static String f3716d = null;

    /* renamed from: e */
    private static Integer f3717e = null;

    /* renamed from: f */
    private static Integer f3718f = null;

    /* renamed from: g */
    private static Integer f3719g = null;

    /* renamed from: h */
    private static Integer f3720h = null;

    /* renamed from: i */
    private static String f3721i = null;

    /* renamed from: j */
    private static String f3722j = null;

    /* renamed from: k */
    private static String f3723k = null;

    /* renamed from: l */
    private static String f3724l = null;

    /* renamed from: m */
    private static Integer f3725m = null;

    /* renamed from: n */
    private static Integer f3726n = null;

    /* renamed from: o */
    private static Integer f3727o = null;

    /* renamed from: p */
    private static Integer f3728p = null;

    public enum ServerType {
        PRIMARY,
        SECONDARY
    }

    public enum ServerWhat {
        GLD,
        CONTACT,
        FILE,
        SMS_GATEWAY
    }

    /* renamed from: a */
    public static String m3628a(ServerType serverType) {
        String string = ChatONPref.m3519a().getString("pref_choose_server_test", NetworkConstant.f1347a[0]);
        return (serverType != ServerType.PRIMARY && string.equals("https://gld1.samsungchaton.com")) ? "https://gld2.samsungchaton.com" : string;
    }

    /* renamed from: a */
    public static void m3629a() {
        f3713a = null;
        f3714b = null;
        f3715c = null;
        f3720h = null;
        f3717e = null;
        f3718f = null;
        f3719g = null;
        f3720h = null;
        ChatONPref.m3519a().edit().remove("is_file_server_primary ").commit();
    }

    /* renamed from: b */
    public static String m3630b(ServerType serverType) {
        return serverType == ServerType.PRIMARY ? m3646m() : m3647n();
    }

    /* renamed from: b */
    public static void m3631b() {
        GLDControl gLDControl = new GLDControl(new Handler(Looper.getMainLooper()));
        if (!ChatONPref.m3519a().contains("primary_contact_addrss")) {
            gLDControl.m2000a();
        } else if (ChatONPref.m3519a().contains("expdate")) {
            if (System.currentTimeMillis() > ChatONPref.m3519a().getLong("expdate", 0L)) {
                gLDControl.m2000a();
            }
        }
    }

    /* renamed from: c */
    public static int m3632c(ServerType serverType) {
        return serverType == ServerType.PRIMARY ? m3633c().intValue() : m3634d().intValue();
    }

    /* renamed from: c */
    public static Integer m3633c() {
        if (f3717e == null) {
            f3717e = Integer.valueOf(ChatONPref.m3519a().getInt("primary_contact_port", 0));
        }
        return f3717e;
    }

    /* renamed from: d */
    public static Integer m3634d() {
        if (f3725m == null) {
            f3725m = Integer.valueOf(ChatONPref.m3519a().getInt("secondary_contact_port", 0));
        }
        return f3725m;
    }

    /* renamed from: d */
    public static String m3635d(ServerType serverType) {
        return serverType == ServerType.PRIMARY ? m3648o() : m3649p();
    }

    /* renamed from: e */
    public static String m3636e() {
        if (f3714b == null) {
            f3714b = ChatONPref.m3519a().getString("primary_message_addrss", "");
        }
        return f3714b;
    }

    /* renamed from: e */
    public static String m3637e(ServerType serverType) {
        return serverType == ServerType.PRIMARY ? m3650q() : m3651r();
    }

    /* renamed from: f */
    public static int m3638f(ServerType serverType) {
        return serverType == ServerType.PRIMARY ? m3642i().intValue() : m3643j().intValue();
    }

    /* renamed from: f */
    public static String m3639f() {
        if (f3722j == null) {
            f3722j = ChatONPref.m3519a().getString("secondary_message_addrss", "");
        }
        return f3722j;
    }

    /* renamed from: g */
    public static Integer m3640g() {
        if (f3718f == null) {
            f3718f = Integer.valueOf(ChatONPref.m3519a().getInt("primary_message_port", 0));
        }
        return f3718f;
    }

    /* renamed from: h */
    public static Integer m3641h() {
        if (f3726n == null) {
            f3726n = Integer.valueOf(ChatONPref.m3519a().getInt("secondary_message_port", 0));
        }
        return f3726n;
    }

    /* renamed from: i */
    public static Integer m3642i() {
        if (f3719g == null) {
            f3719g = Integer.valueOf(ChatONPref.m3519a().getInt("primary_file_port", 0));
        }
        return f3719g;
    }

    /* renamed from: j */
    public static Integer m3643j() {
        if (f3727o == null) {
            f3727o = Integer.valueOf(ChatONPref.m3519a().getInt("secondary_file_port", 0));
        }
        return f3727o;
    }

    /* renamed from: k */
    public static Integer m3644k() {
        if (f3720h == null) {
            f3720h = Integer.valueOf(ChatONPref.m3519a().getInt("primary_sms_port", 0));
        }
        return f3720h;
    }

    /* renamed from: l */
    public static Integer m3645l() {
        if (f3728p == null) {
            f3728p = Integer.valueOf(ChatONPref.m3519a().getInt("secondary_sms_port", 0));
        }
        return f3728p;
    }

    /* renamed from: m */
    private static String m3646m() {
        if (f3713a == null) {
            f3713a = ChatONPref.m3519a().getString("primary_contact_addrss", "");
        }
        return m3633c().intValue() == 443 ? "https://" + f3713a : "http://" + f3713a;
    }

    /* renamed from: n */
    private static String m3647n() {
        if (f3721i == null) {
            f3721i = ChatONPref.m3519a().getString("secondary_contact_addrss", "");
        }
        return m3634d().intValue() == 443 ? "https://" + f3721i : "http://" + f3721i;
    }

    /* renamed from: o */
    private static String m3648o() {
        if (f3715c == null) {
            f3715c = ChatONPref.m3519a().getString("primary_file_addrss", "");
        }
        return m3642i().intValue() == 443 ? "https://" + f3715c : "http://" + f3715c;
    }

    /* renamed from: p */
    private static String m3649p() {
        if (f3723k == null) {
            f3723k = ChatONPref.m3519a().getString("secondary_file_addrss", "");
        }
        return m3642i().intValue() == 443 ? "https://" + f3723k : "http://" + f3723k;
    }

    /* renamed from: q */
    private static String m3650q() {
        if (f3716d == null) {
            f3716d = ChatONPref.m3519a().getString("primary_sms_address", "");
        }
        return m3644k().intValue() == 443 ? "https://" + f3716d : "http://" + f3716d;
    }

    /* renamed from: r */
    private static String m3651r() {
        if (f3724l == null) {
            f3724l = ChatONPref.m3519a().getString("secondary_sms_addrss", "");
        }
        return m3645l().intValue() == 443 ? "https://" + f3724l : "http://" + f3724l;
    }
}
