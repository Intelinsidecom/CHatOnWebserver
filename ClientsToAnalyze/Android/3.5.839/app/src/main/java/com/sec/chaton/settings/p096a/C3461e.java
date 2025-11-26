package com.sec.chaton.settings.p096a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.a.e */
/* loaded from: classes.dex */
final class C3461e implements FilenameFilter {
    C3461e() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (!str.endsWith(".png")) {
            return false;
        }
        try {
            return !str.split("_")[1].equals("r");
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
