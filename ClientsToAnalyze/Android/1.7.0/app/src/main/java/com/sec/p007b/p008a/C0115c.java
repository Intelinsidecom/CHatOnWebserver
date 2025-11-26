package com.sec.p007b.p008a;

import android.os.Environment;
import android.os.StatFs;

/* compiled from: MemoryStatus.java */
/* renamed from: com.sec.b.a.c */
/* loaded from: classes.dex */
public class C0115c {
    /* renamed from: a */
    public static long m588a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }
}
