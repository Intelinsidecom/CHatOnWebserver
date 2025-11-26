package com.sec.chaton.util;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.bu */
/* loaded from: classes.dex */
final class C3206bu implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f11573a;

    C3206bu(String str) {
        this.f11573a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f11573a);
    }
}
