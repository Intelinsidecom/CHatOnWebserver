package com.sec.chaton.util;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import com.sec.chaton.global.GlobalApplication;
import java.io.File;

/* compiled from: StorageStateInfoUtil.java */
/* renamed from: com.sec.chaton.util.bw */
/* loaded from: classes.dex */
public class C1767bw {
    /* renamed from: a */
    public static boolean m6002a() {
        boolean z;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            z = true;
        } else {
            z = false;
        }
        C1786r.m6066e("isStorageAvailable: " + z, C1767bw.class.getSimpleName());
        return z;
    }

    /* renamed from: b */
    public static String m6003b() {
        if (m6002a()) {
            Application applicationM3256a = GlobalApplication.m3256a();
            if (applicationM3256a == null) {
                return "";
            }
            File externalFilesDir = applicationM3256a.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                externalFilesDir = applicationM3256a.getFilesDir();
            }
            return externalFilesDir.getAbsolutePath();
        }
        Context contextM3260b = GlobalApplication.m3260b();
        if (contextM3260b == null) {
            return "";
        }
        return contextM3260b.getFilesDir().getAbsolutePath();
    }
}
