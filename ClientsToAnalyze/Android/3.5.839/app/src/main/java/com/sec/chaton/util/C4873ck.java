package com.sec.chaton.util;

import android.content.Context;
import android.os.Environment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import java.io.File;

/* compiled from: StorageStateInfoUtil.java */
/* renamed from: com.sec.chaton.util.ck */
/* loaded from: classes.dex */
public class C4873ck {
    /* renamed from: a */
    public static boolean m18500a() {
        boolean z;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            z = true;
        } else {
            z = false;
        }
        C4904y.m18646e("isStorageAvailable: " + z, C4873ck.class.getSimpleName());
        return z;
    }

    /* renamed from: b */
    public static String m18501b() {
        if (m18500a()) {
            GlobalApplication globalApplicationM10279a = GlobalApplication.m10279a();
            if (globalApplicationM10279a == null) {
                return "";
            }
            File externalFilesDir = globalApplicationM10279a.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                externalFilesDir = globalApplicationM10279a.getFilesDir();
            }
            return externalFilesDir.getAbsolutePath();
        }
        Context contextM18732r = CommonApplication.m18732r();
        if (contextM18732r == null) {
            return "";
        }
        return contextM18732r.getFilesDir().getAbsolutePath();
    }

    /* renamed from: c */
    public static String m18502c() {
        if (m18500a()) {
            GlobalApplication globalApplicationM10279a = GlobalApplication.m10279a();
            if (globalApplicationM10279a == null) {
                return "";
            }
            File externalCacheDir = globalApplicationM10279a.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = globalApplicationM10279a.getCacheDir();
            }
            if (externalCacheDir == null) {
                return "";
            }
            return externalCacheDir.getAbsolutePath();
        }
        Context contextM18732r = CommonApplication.m18732r();
        if (contextM18732r == null) {
            return "";
        }
        return contextM18732r.getCacheDir().getAbsolutePath();
    }

    /* renamed from: d */
    public static boolean m18503d() {
        return C5034k.m19103h() > 10485760;
    }

    /* renamed from: e */
    public static boolean m18504e() {
        long jM19104i = C5034k.m19104i();
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("external : ", C5034k.m19092a(jM19104i)), C4873ck.class.getSimpleName());
        }
        return jM19104i > 10485760;
    }
}
