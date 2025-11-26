package com.sec.chaton.util;

import android.os.Environment;

/* loaded from: classes.dex */
public class StorageStateInfoUtil {
    /* renamed from: a */
    public static boolean m3677a() {
        boolean z = "mounted".equals(Environment.getExternalStorageState());
        ChatONLogWriter.m3505b("isStorageAvailable: " + z);
        return z;
    }
}
