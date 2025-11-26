package com.sec.chaton.settings.downloads;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.x */
/* loaded from: classes.dex */
final class C2649x implements FilenameFilter {
    C2649x() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(".mp3");
    }
}
