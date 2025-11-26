package com.sec.chaton.util;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: ChatONCheckLock.java */
/* renamed from: com.sec.chaton.util.m */
/* loaded from: classes.dex */
public class C1781m {

    /* renamed from: a */
    public static boolean f6440a = false;

    /* renamed from: b */
    public static boolean f6441b = false;

    /* renamed from: c */
    public static String f6442c = "";

    /* renamed from: d */
    public static String f6443d = m6021b("ON");

    /* renamed from: e */
    public static String f6444e = m6021b("OFF");

    /* renamed from: a */
    public static void m6018a(boolean z) {
        C1786r.m6061b("setShowPasswordLock : value=" + z, "ChatONCheckLock");
        f6440a = z;
    }

    /* renamed from: a */
    public static boolean m6019a() {
        C1786r.m6061b("getShowPasswordLock : isShowPasswordLock=" + f6440a, "ChatONCheckLock");
        return f6440a;
    }

    /* renamed from: b */
    public static void m6023b(boolean z) {
        C1786r.m6061b("setKeepPasswordLock : value=" + z, "ChatONCheckLock");
        f6441b = z;
    }

    /* renamed from: b */
    public static boolean m6024b() {
        C1786r.m6061b("getKeepPasswordLock : isKeepPasswordLock=" + f6441b, "ChatONCheckLock");
        return f6441b;
    }

    /* renamed from: c */
    public static String m6025c() {
        return f6443d;
    }

    /* renamed from: d */
    public static String m6027d() {
        return f6444e;
    }

    /* renamed from: a */
    public static String m6017a(Context context) {
        String className = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
        C1786r.m6061b("getClassName : className=" + className, "ChatONCheckLock");
        return className;
    }

    /* renamed from: b */
    public static void m6022b(Context context) {
        C1786r.m6061b("setCurrentClassName function start : context=" + context, "ChatONCheckLock");
        if (context != null) {
            f6442c = m6017a(context);
            C1786r.m6061b("setCurrentClassName : currentClassName=" + f6442c, "ChatONCheckLock");
            if (!TextUtils.isEmpty(f6442c)) {
                String[] strArr = {"com.sec.chaton", "com.sec.vip.amschaton"};
                C1786r.m6061b("setCurrentClassName : check on ActivityPasswordLockSet", "ChatONCheckLock");
                if (f6442c.equals("com.sec.chaton.settings.ActivityPasswordLockSet")) {
                    m6018a(true);
                    return;
                }
                boolean zM6020a = false;
                for (int i = 0; i < 2; i++) {
                    zM6020a = m6020a(strArr[i]);
                    C1786r.m6061b("setCurrentClassName : isNotShowPasswordLock=" + zM6020a + "index=" + i, "ChatONCheckLock");
                    if (zM6020a) {
                        return;
                    }
                }
                C1786r.m6061b("setCurrentClassName : check isNotShowPasswordLock value", "ChatONCheckLock");
                if (!zM6020a) {
                    m6018a(true);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m6020a(String str) {
        int length = f6442c.length();
        int length2 = str.length();
        C1786r.m6061b("checkCurrentChatOnClass : currentClassName=" + f6442c, "ChatONCheckLock");
        C1786r.m6061b("checkCurrentChatOnClass : currChatOnClassName=" + str, "ChatONCheckLock");
        return length >= length2 && f6442c.substring(0, length2).equals(str);
    }

    /* renamed from: c */
    public static boolean m6026c(Context context) {
        C1786r.m6061b("isShowPasswordLockActivity function start : context=" + context, "ChatONCheckLock");
        if (context != null) {
            C1786r.m6061b("isShowPasswordLockActivity : check getShowPasswordLock()value", "ChatONCheckLock");
            if (m6019a() && context.getSharedPreferences("password_lock", 0).getString("app_lock_state", m6027d()).equals(m6025c())) {
                C1786r.m6061b("isShowPasswordLockActivity : return value is true", "ChatONCheckLock");
                return true;
            }
        }
        C1786r.m6061b("isShowPasswordLockActivity : return value is false", "ChatONCheckLock");
        return false;
    }

    /* renamed from: b */
    public static String m6021b(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(), 0, str.length());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
