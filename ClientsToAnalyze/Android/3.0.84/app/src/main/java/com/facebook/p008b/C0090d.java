package com.facebook.p008b;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.d */
/* loaded from: classes.dex */
class C0090d {

    /* renamed from: a */
    private static final FilenameFilter f171a = new C0091e();

    /* renamed from: b */
    private static final FilenameFilter f172b = new C0092f();

    /* renamed from: a */
    static void m233a(File file) {
        for (File file2 : file.listFiles(m235b())) {
            file2.delete();
        }
    }

    /* renamed from: a */
    static FilenameFilter m232a() {
        return f171a;
    }

    /* renamed from: b */
    static FilenameFilter m235b() {
        return f172b;
    }

    /* renamed from: b */
    static File m234b(File file) {
        return new File(file, "buffer" + Long.valueOf(C0087a.f161b.incrementAndGet()).toString());
    }
}
