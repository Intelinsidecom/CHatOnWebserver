package com.sec.chaton.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: ChatONCheckLock.java */
/* renamed from: com.sec.chaton.util.m */
/* loaded from: classes.dex */
public class C4892m {

    /* renamed from: n */
    private static boolean f17847n;

    /* renamed from: p */
    private static boolean f17849p;

    /* renamed from: a */
    public static String f17834a = "itself";

    /* renamed from: b */
    private static boolean f17835b = false;

    /* renamed from: c */
    private static boolean f17836c = false;

    /* renamed from: d */
    private static boolean f17837d = false;

    /* renamed from: e */
    private static String f17838e = m18567a("ON");

    /* renamed from: f */
    private static String f17839f = m18567a("OFF");

    /* renamed from: g */
    private static String f17840g = m18567a("ON" + C4822an.m18228d());

    /* renamed from: h */
    private static String f17841h = m18567a("OFF" + C4822an.m18228d());

    /* renamed from: i */
    private static boolean f17842i = false;

    /* renamed from: j */
    private static boolean f17843j = false;

    /* renamed from: k */
    private static boolean f17844k = false;

    /* renamed from: l */
    private static String f17845l = null;

    /* renamed from: m */
    private static String f17846m = null;

    /* renamed from: o */
    private static String[] f17848o = {"com.sec.chaton.HomeActivity", "com.sec.chaton.registration.RegisterSMSActivity", "com.sec.chaton.SplashActivity", "com.sec.chaton.BootstrapActivity", "com.sec.chaton.IntentControllerActivity"};

    /* renamed from: a */
    public static void m18570a(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("setGoBackGround : " + z, "ChatONCheckLock");
        }
        f17849p = z;
    }

    /* renamed from: a */
    public static boolean m18571a() {
        if (C4904y.f17872b) {
            C4904y.m18639b("getGoBackGround : " + f17849p, "ChatONCheckLock");
        }
        return f17849p;
    }

    /* renamed from: b */
    public static void m18573b(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("setfinishPasswordLock : " + z, "ChatONCheckLock");
        }
        f17842i = z;
    }

    /* renamed from: b */
    public static boolean m18574b() {
        if (C4904y.f17872b) {
            C4904y.m18639b("getfinishPasswordLock : " + f17842i, "ChatONCheckLock");
        }
        return f17842i;
    }

    /* renamed from: c */
    public static void m18577c(boolean z) {
        C4904y.m18639b("setShowPasswordLock : value=" + z, "ChatONCheckLock");
        f17836c = z;
    }

    /* renamed from: c */
    public static boolean m18578c() {
        C4904y.m18639b("getShowPasswordLock : isShowPasswordLock=" + f17836c, "ChatONCheckLock");
        return f17836c;
    }

    /* renamed from: d */
    public static void m18580d(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("setScreenOnForLock : value=" + z, "ChatONCheckLock");
        }
        f17835b = z;
    }

    /* renamed from: d */
    public static boolean m18581d() {
        C4904y.m18639b("getScreenOnForLock : isShowPasswordLock=" + f17835b, "ChatONCheckLock");
        return f17835b;
    }

    /* renamed from: e */
    public static void m18582e(boolean z) {
        C4904y.m18639b("setKeepPasswordLock : value=" + z, "ChatONCheckLock");
        f17837d = z;
    }

    /* renamed from: e */
    public static boolean m18583e() {
        C4904y.m18639b("getKeepPasswordLock : isKeepPasswordLock=" + f17837d, "ChatONCheckLock");
        return f17837d;
    }

    /* renamed from: f */
    public static void m18584f(boolean z) {
        C4904y.m18639b("setExceptCase : value=" + z, "ChatONCheckLock");
        f17843j = z;
    }

    /* renamed from: g */
    public static void m18587g(boolean z) {
        C4904y.m18639b("setForceShow : value=" + z, "ChatONCheckLock");
        f17844k = z;
    }

    /* renamed from: f */
    public static boolean m18585f() {
        C4904y.m18639b("getForceShow : " + f17844k, "ChatONCheckLock");
        return f17844k;
    }

    /* renamed from: g */
    public static String m18586g() {
        return C1427a.f5065c > 303017000 ? f17840g : f17838e;
    }

    /* renamed from: h */
    public static String m18588h() {
        return C1427a.f5065c > 303017000 ? f17841h : f17839f;
    }

    /* renamed from: i */
    public static String m18590i() {
        return f17838e;
    }

    /* renamed from: j */
    public static String m18591j() {
        return f17839f;
    }

    /* renamed from: h */
    public static void m18589h(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[OnUserLeaveHint] setNeedPasswordLock : " + z, "ChatONCheckLock");
        }
        f17847n = z;
    }

    /* renamed from: a */
    public static void m18568a(Activity activity) {
        f17845l = activity.getClass().getName();
        if (C4904y.f17872b) {
            C4904y.m18639b("setStopClass : " + f17845l, "ChatONCheckLock");
        }
    }

    /* renamed from: k */
    public static String m18592k() {
        if (C4904y.f17872b) {
            C4904y.m18639b("getStopClass : " + f17845l, "ChatONCheckLock");
        }
        return f17845l;
    }

    /* renamed from: a */
    public static void m18569a(Context context, boolean z) {
        f17846m = context.getClass().getName();
        if (C4904y.f17872b) {
            C4904y.m18639b("[OnPause] saveCurrentActivity, isFinish : " + z + " currentClassName : " + f17846m, "ChatONCheckLock");
        }
        if (m18576b(f17846m)) {
            m18593l();
        } else if (z) {
            f17847n = false;
        }
    }

    /* renamed from: b */
    private static boolean m18576b(String str) {
        boolean z = false;
        String[] strArr = f17848o;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (!strArr[i].equals(str)) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(" isExceptActivity : " + str + " , " + z, "ChatONCheckLock");
        }
        return z;
    }

    /* renamed from: l */
    public static void m18593l() {
        if (C4904y.f17872b) {
            C4904y.m18639b(" clearSaveClass ", "ChatONCheckLock");
        }
        f17846m = null;
    }

    /* renamed from: b */
    public static void m18572b(Context context, boolean z) {
        String name = context.getClass().getName();
        if (C4904y.f17872b) {
            C4904y.m18639b("[OnStart] current class name : " + name + " saveClassName : " + f17846m + " calledActivityResult : " + z, "ChatONCheckLock");
        }
        if (!TextUtils.isEmpty(name) && !m18576b(name)) {
            if (m18585f()) {
                m18577c(true);
                m18587g(false);
            }
            if (name.equals(f17846m) && f17847n) {
                m18570a(true);
            }
            if (f17843j || z) {
                return;
            }
            if ((name.equals(f17846m) && name.equals(m18592k()) && f17847n) || f17846m == null) {
                m18577c(true);
            }
        }
    }

    /* renamed from: a */
    public static Intent m18566a(Context context) {
        if (context == null) {
            return null;
        }
        String name = context.getClass().getName();
        if (C4904y.f17872b) {
            C4904y.m18639b("makeIntentLock : " + name, "ChatONCheckLock");
        }
        if ("com.sec.chaton.settings.ActivityPasswordLockSet".equals(name) || m18576b(name)) {
            return null;
        }
        Intent intent = new Intent(context, (Class<?>) ActivityPasswordLockSet.class);
        intent.setFlags(537001984);
        intent.putExtra("MODE", "HOME");
        return intent;
    }

    /* renamed from: a */
    public static String m18567a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(), 0, str.length());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m18575b(Context context) {
        C4904y.m18639b("isShowPasswordLockActivity function start : context=" + context, "ChatONCheckLock");
        if (context != null) {
            C4904y.m18639b("isShowPasswordLockActivity : check getShowPasswordLock()value", "ChatONCheckLock");
            if (m18578c() || m18581d()) {
                m18577c(false);
                m18580d(false);
                if (!context.getSharedPreferences("PASSWORD_LOCK", 0).getString("LOCK_STATE", m18588h()).equals(m18588h())) {
                    C4904y.m18639b("isShowPasswordLockActivity : return value is true", "ChatONCheckLock");
                    return true;
                }
            }
        }
        C4904y.m18639b("isShowPasswordLockActivity : return value is false", "ChatONCheckLock");
        return false;
    }

    /* renamed from: c */
    public static boolean m18579c(Context context) {
        C4904y.m18639b("isScreenOnLockActivity function start : context=" + context, "ChatONCheckLock");
        if (context != null) {
            C4904y.m18639b("isScreenOnLockActivity : check getShowPasswordLock()value", "ChatONCheckLock");
            if (m18581d()) {
                m18580d(false);
                if (!context.getSharedPreferences("PASSWORD_LOCK", 0).getString("LOCK_STATE", m18588h()).equals(m18588h())) {
                    C4904y.m18639b("isShowPasswordLockActivity : return value is true", "ChatONCheckLock");
                    return true;
                }
            }
        }
        C4904y.m18639b("isScreenOnLockActivity : return value is false", "ChatONCheckLock");
        return false;
    }
}
