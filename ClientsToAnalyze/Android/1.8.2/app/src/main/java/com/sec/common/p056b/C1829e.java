package com.sec.common.p056b;

import android.content.Context;
import java.io.File;

/* compiled from: StorageUtils.java */
/* renamed from: com.sec.common.b.e */
/* loaded from: classes.dex */
public class C1829e {

    /* renamed from: a */
    private static final String f6545a = C1829e.class.getSimpleName();

    /* renamed from: a */
    public static File m6208a(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir;
    }

    /* renamed from: b */
    public static File m6210b(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (!externalCacheDir.exists()) {
            externalCacheDir.mkdirs();
        }
        return externalCacheDir;
    }

    /* renamed from: a */
    public static void m6209a(File file) {
        int length;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && (length = fileArrListFiles.length) > 0) {
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isFile()) {
                    C1825d.f6539a.m6200a(f6545a, "???: " + fileArrListFiles[i].delete());
                } else {
                    m6209a(fileArrListFiles[i]);
                    if (!fileArrListFiles[i].delete()) {
                        fileArrListFiles[i].delete();
                    }
                }
            }
        }
        file.delete();
    }
}
