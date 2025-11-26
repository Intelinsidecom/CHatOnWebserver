package com.sec.chaton.settings.p096a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.a.g */
/* loaded from: classes.dex */
final class C3463g implements FilenameFilter {
    C3463g() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(".mp3");
    }
}
