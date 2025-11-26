package com.sec.chaton.util;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: ChatONCheckLock.java */
/* renamed from: com.sec.chaton.util.p */
/* loaded from: classes.dex */
public class C3241p {

    /* renamed from: a */
    public static boolean f11713a = false;

    /* renamed from: b */
    public static boolean f11714b = false;

    /* renamed from: c */
    public static String f11715c = "";

    /* renamed from: d */
    public static String f11716d = m11401b("ON");

    /* renamed from: e */
    public static String f11717e = m11401b("OFF");

    /* renamed from: f */
    public static boolean f11718f = false;

    /* renamed from: a */
    public static void m11398a(boolean z) {
        if (C3250y.f11734b) {
            C3250y.m11450b("setfinishPasswordLock : " + z, "ChatONCheckLock");
        }
        f11718f = z;
    }

    /* renamed from: a */
    public static boolean m11399a() {
        if (C3250y.f11734b) {
            C3250y.m11450b("getfinishPasswordLock : " + f11718f, "ChatONCheckLock");
        }
        return f11718f;
    }

    /* renamed from: b */
    public static void m11403b(boolean z) {
        C3250y.m11450b("setShowPasswordLock : value=" + z, "ChatONCheckLock");
        f11713a = z;
    }

    /* renamed from: b */
    public static boolean m11404b() {
        C3250y.m11450b("getShowPasswordLock : isShowPasswordLock=" + f11713a, "ChatONCheckLock");
        return f11713a;
    }

    /* renamed from: c */
    public static void m11405c(boolean z) {
        C3250y.m11450b("setKeepPasswordLock : value=" + z, "ChatONCheckLock");
        f11714b = z;
    }

    /* renamed from: c */
    public static boolean m11406c() {
        C3250y.m11450b("getKeepPasswordLock : isKeepPasswordLock=" + f11714b, "ChatONCheckLock");
        return f11714b;
    }

    /* renamed from: d */
    public static String m11408d() {
        return f11716d;
    }

    /* renamed from: e */
    public static String m11409e() {
        return f11717e;
    }

    /* renamed from: a */
    public static String m11397a(Context context) {
        String className = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
        C3250y.m11450b("getClassName : className=" + className, "ChatONCheckLock");
        return className;
    }

    /* renamed from: b */
    public static void m11402b(Context context) {
        C3250y.m11450b("setCurrentClassName function start : context=" + context, "ChatONCheckLock");
        if (context != null) {
            f11715c = m11397a(context);
            C3250y.m11450b("setCurrentClassName : currentClassName=" + f11715c, "ChatONCheckLock");
            if (!TextUtils.isEmpty(f11715c)) {
                String[] strArr = {"com.sec.chaton", "com.sec.vip.amschaton", "com.sec.chatonforcanada", "com.ruimaninfo.approtect.ui.ScreenLocker", "com.sec.vip.cropimage"};
                C3250y.m11450b("setCurrentClassName : check on ActivityPasswordLockSet", "ChatONCheckLock");
                if (f11715c.equals("com.sec.chaton.settings.ActivityPasswordLockSet")) {
                    m11403b(true);
                    return;
                }
                boolean zM11400a = false;
                for (int i = 0; i < 5; i++) {
                    zM11400a = m11400a(strArr[i]);
                    C3250y.m11450b("setCurrentClassName : isNotShowPasswordLock=" + zM11400a + "index=" + i, "ChatONCheckLock");
                    if (zM11400a) {
                        return;
                    }
                }
                C3250y.m11450b("setCurrentClassName : check isNotShowPasswordLock value", "ChatONCheckLock");
                if (!zM11400a) {
                    m11403b(true);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m11400a(String str) {
        int length = f11715c.length();
        int length2 = str.length();
        C3250y.m11450b("checkCurrentChatOnClass : currentClassName=" + f11715c, "ChatONCheckLock");
        C3250y.m11450b("checkCurrentChatOnClass : currChatOnClassName=" + str, "ChatONCheckLock");
        return length >= length2 && f11715c.substring(0, length2).equals(str);
    }

    /* renamed from: c */
    public static boolean m11407c(Context context) {
        C3250y.m11450b("isShowPasswordLockActivity function start : context=" + context, "ChatONCheckLock");
        if (context != null) {
            C3250y.m11450b("isShowPasswordLockActivity : check getShowPasswordLock()value", "ChatONCheckLock");
            if (m11404b()) {
                m11403b(false);
                if (context.getSharedPreferences("PASSWORD_LOCK", 0).getString("LOCK_STATE", m11409e()).equals(m11408d())) {
                    C3250y.m11450b("isShowPasswordLockActivity : return value is true", "ChatONCheckLock");
                    return true;
                }
            }
        }
        C3250y.m11450b("isShowPasswordLockActivity : return value is false", "ChatONCheckLock");
        return false;
    }

    /* renamed from: b */
    public static String m11401b(String str) {
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
