package com.sec.chaton.util;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3364o;
import java.io.File;

/* compiled from: StorageStateInfoUtil.java */
/* renamed from: com.sec.chaton.util.ck */
/* loaded from: classes.dex */
public class C3223ck {
    /* renamed from: a */
    public static boolean m11327a() {
        boolean z;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            z = true;
        } else {
            z = false;
        }
        C3250y.m11456e("isStorageAvailable: " + z, C3223ck.class.getSimpleName());
        return z;
    }

    /* renamed from: b */
    public static String m11328b() {
        if (m11327a()) {
            Application applicationM6447a = GlobalApplication.m6447a();
            if (applicationM6447a == null) {
                return "";
            }
            File externalFilesDir = applicationM6447a.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                externalFilesDir = applicationM6447a.getFilesDir();
            }
            return externalFilesDir.getAbsolutePath();
        }
        Context contextM11493l = CommonApplication.m11493l();
        if (contextM11493l == null) {
            return "";
        }
        return contextM11493l.getFilesDir().getAbsolutePath();
    }

    /* renamed from: c */
    public static String m11329c() {
        if (m11327a()) {
            Application applicationM6447a = GlobalApplication.m6447a();
            if (applicationM6447a == null) {
                return "";
            }
            File externalCacheDir = applicationM6447a.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = applicationM6447a.getCacheDir();
            }
            return externalCacheDir.getAbsolutePath();
        }
        Context contextM11493l = CommonApplication.m11493l();
        if (contextM11493l == null) {
            return "";
        }
        return contextM11493l.getCacheDir().getAbsolutePath();
    }

    /* renamed from: d */
    public static boolean m11330d() {
        return C3347i.m11785h() > 10485760;
    }

    /* renamed from: e */
    public static boolean m11331e() {
        long jM11786i = C3347i.m11786i();
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("external : ", C3347i.m11776a(jM11786i)), C3223ck.class.getSimpleName());
        }
        return jM11786i > 10485760;
    }
}
