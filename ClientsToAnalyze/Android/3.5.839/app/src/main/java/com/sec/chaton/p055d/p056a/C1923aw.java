package com.sec.chaton.p055d.p056a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: EndChatTask.java */
/* renamed from: com.sec.chaton.d.a.aw */
/* loaded from: classes.dex */
class C1923aw implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f7172a;

    /* renamed from: b */
    final /* synthetic */ C1922av f7173b;

    C1923aw(C1922av c1922av, String str) {
        this.f7173b = c1922av;
        this.f7172a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f7172a);
    }
}
