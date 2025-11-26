package com.sec.chaton.settings.downloads;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.w */
/* loaded from: classes.dex */
final class C2648w implements FilenameFilter {
    C2648w() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(".hvf");
    }
}
