package com.facebook.p032b;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.f */
/* loaded from: classes.dex */
final class C0463f implements FilenameFilter {
    C0463f() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith("buffer");
    }
}
