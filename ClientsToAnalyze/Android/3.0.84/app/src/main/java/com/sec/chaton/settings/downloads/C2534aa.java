package com.sec.chaton.settings.downloads;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.aa */
/* loaded from: classes.dex */
class C2534aa implements FilenameFilter {

    /* renamed from: a */
    private String f9668a;

    public C2534aa(String str) {
        this.f9668a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (!str.endsWith(".png")) {
            return false;
        }
        try {
            return str.split("_")[1].equals(this.f9668a);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
