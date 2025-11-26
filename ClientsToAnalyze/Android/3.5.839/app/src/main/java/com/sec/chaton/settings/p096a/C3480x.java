package com.sec.chaton.settings.p096a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: SkinHelper.java */
/* renamed from: com.sec.chaton.settings.a.x */
/* loaded from: classes.dex */
final class C3480x implements FilenameFilter {
    C3480x() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (!str.endsWith("png")) {
            return false;
        }
        String[] strArrSplit = str.split("_");
        try {
            if (strArrSplit[1].equals("ch")) {
                if (strArrSplit[2].equals("se")) {
                    return true;
                }
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
