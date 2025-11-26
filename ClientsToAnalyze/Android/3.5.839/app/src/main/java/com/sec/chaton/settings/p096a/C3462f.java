package com.sec.chaton.settings.p096a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.a.f */
/* loaded from: classes.dex */
final class C3462f implements FilenameFilter {
    C3462f() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(".hvf");
    }
}
