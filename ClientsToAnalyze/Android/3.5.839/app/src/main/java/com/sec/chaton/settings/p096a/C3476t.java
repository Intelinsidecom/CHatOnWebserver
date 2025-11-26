package com.sec.chaton.settings.p096a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: SkinHelper.java */
/* renamed from: com.sec.chaton.settings.a.t */
/* loaded from: classes.dex */
final class C3476t implements FilenameFilter {
    C3476t() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (!str.endsWith("png")) {
            return false;
        }
        String[] strArrSplit = str.split("_");
        try {
            if (strArrSplit[1].equals("st")) {
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
