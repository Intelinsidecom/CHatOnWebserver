package com.facebook.p032b;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.d */
/* loaded from: classes.dex */
class C0461d {

    /* renamed from: a */
    private static final FilenameFilter f1140a = new C0462e();

    /* renamed from: b */
    private static final FilenameFilter f1141b = new C0463f();

    /* renamed from: a */
    static void m1677a(File file) {
        for (File file2 : file.listFiles(m1679b())) {
            file2.delete();
        }
    }

    /* renamed from: a */
    static FilenameFilter m1676a() {
        return f1140a;
    }

    /* renamed from: b */
    static FilenameFilter m1679b() {
        return f1141b;
    }

    /* renamed from: b */
    static File m1678b(File file) {
        return new File(file, "buffer" + Long.valueOf(C0458a.f1130b.incrementAndGet()).toString());
    }
}
