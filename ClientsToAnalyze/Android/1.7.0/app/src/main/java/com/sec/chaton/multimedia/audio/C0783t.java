package com.sec.chaton.multimedia.audio;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: InsertSound.java */
/* renamed from: com.sec.chaton.multimedia.audio.t */
/* loaded from: classes.dex */
class C0783t implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ InsertSound f2680a;

    C0783t(InsertSound insertSound) {
        this.f2680a = insertSound;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(".3gp");
    }
}
