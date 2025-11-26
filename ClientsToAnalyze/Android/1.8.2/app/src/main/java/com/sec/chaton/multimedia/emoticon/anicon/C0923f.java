package com.sec.chaton.multimedia.emoticon.anicon;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.f */
/* loaded from: classes.dex */
final class C0923f implements FilenameFilter {
    C0923f() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (!str.endsWith(".png")) {
            return false;
        }
        try {
            return str.split("_")[1].equals("0");
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
