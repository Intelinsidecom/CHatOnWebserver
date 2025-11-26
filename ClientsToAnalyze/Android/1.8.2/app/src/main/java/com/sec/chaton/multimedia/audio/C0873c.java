package com.sec.chaton.multimedia.audio;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: InsertSound.java */
/* renamed from: com.sec.chaton.multimedia.audio.c */
/* loaded from: classes.dex */
class C0873c implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ InsertSound f3263a;

    C0873c(InsertSound insertSound) {
        this.f3263a = insertSound;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(".3gp");
    }
}
