package com.sec.chaton.p057e.p058a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: InBoxDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.m */
/* loaded from: classes.dex */
final class C2199m implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f7836a;

    C2199m(String str) {
        this.f7836a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f7836a);
    }
}
