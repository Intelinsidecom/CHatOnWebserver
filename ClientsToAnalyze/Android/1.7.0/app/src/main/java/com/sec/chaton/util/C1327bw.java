package com.sec.chaton.util;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.p007b.p008a.C0115c;
import java.io.File;

/* compiled from: StorageStateInfoUtil.java */
/* renamed from: com.sec.chaton.util.bw */
/* loaded from: classes.dex */
public class C1327bw {

    /* renamed from: a */
    private static long f4550a = 10485760;

    /* renamed from: a */
    public static boolean m4595a() {
        boolean z;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            z = true;
        } else {
            z = false;
        }
        C1341p.m4662e("isStorageAvailable: " + z, C1327bw.class.getSimpleName());
        return z;
    }

    /* renamed from: b */
    public static String m4596b() {
        if (m4595a()) {
            Application applicationM3105f = GlobalApplication.m3105f();
            if (applicationM3105f == null) {
                return "";
            }
            File externalFilesDir = applicationM3105f.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                externalFilesDir = applicationM3105f.getFilesDir();
            }
            return externalFilesDir.getAbsolutePath();
        }
        Context contextM3100a = GlobalApplication.m3100a();
        if (contextM3100a == null) {
            return "";
        }
        return contextM3100a.getFilesDir().getAbsolutePath();
    }

    /* renamed from: c */
    public static boolean m4597c() {
        return C0115c.m588a() > f4550a;
    }
}
