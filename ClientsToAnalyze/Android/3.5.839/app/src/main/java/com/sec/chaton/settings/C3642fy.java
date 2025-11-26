package com.sec.chaton.settings;

import java.io.File;
import java.io.FileFilter;

/* compiled from: SendEmailLog.java */
/* renamed from: com.sec.chaton.settings.fy */
/* loaded from: classes.dex */
final class C3642fy implements FileFilter {
    C3642fy() {
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.getName().endsWith(".txt");
    }
}
