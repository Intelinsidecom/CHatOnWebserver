package com.facebook.p008b;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.f */
/* loaded from: classes.dex */
final class C0092f implements FilenameFilter {
    C0092f() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith("buffer");
    }
}
