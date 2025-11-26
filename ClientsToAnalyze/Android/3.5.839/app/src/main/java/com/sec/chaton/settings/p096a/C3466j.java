package com.sec.chaton.settings.p096a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.a.j */
/* loaded from: classes.dex */
class C3466j implements FilenameFilter {

    /* renamed from: a */
    private String f12934a;

    /* synthetic */ C3466j(String str, C3461e c3461e) {
        this(str);
    }

    private C3466j(String str) {
        this.f12934a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (!str.endsWith(".png")) {
            return false;
        }
        try {
            return str.split("_")[1].equals(this.f12934a);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
