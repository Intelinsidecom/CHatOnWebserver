package com.sec.chaton.multimedia.audio;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.sec.chaton.multimedia.audio.n */
/* loaded from: classes.dex */
class C0283n implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ InsertSound f2092a;

    C0283n(InsertSound insertSound) {
        this.f2092a = insertSound;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(".3gp");
    }
}
