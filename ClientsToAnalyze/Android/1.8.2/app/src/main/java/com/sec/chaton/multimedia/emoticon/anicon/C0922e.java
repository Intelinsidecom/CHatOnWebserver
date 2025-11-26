package com.sec.chaton.multimedia.emoticon.anicon;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.e */
/* loaded from: classes.dex */
final class C0922e implements FilenameFilter {
    C0922e() {
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
