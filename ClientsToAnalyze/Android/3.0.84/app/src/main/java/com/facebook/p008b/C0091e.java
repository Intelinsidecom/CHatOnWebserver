package com.facebook.p008b;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.e */
/* loaded from: classes.dex */
final class C0091e implements FilenameFilter {
    C0091e() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return !str.startsWith("buffer");
    }
}
