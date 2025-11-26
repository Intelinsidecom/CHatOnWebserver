package com.sec.chaton.settings.downloads;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.v */
/* loaded from: classes.dex */
final class C2647v implements FilenameFilter {
    C2647v() {
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
