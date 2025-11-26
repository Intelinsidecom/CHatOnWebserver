package com.sec.chaton.settings;

import com.sec.chaton.util.C4904y;
import java.io.File;
import java.io.FileFilter;

/* compiled from: SendEmailLog.java */
/* renamed from: com.sec.chaton.settings.fx */
/* loaded from: classes.dex */
final class C3641fx implements FileFilter {
    C3641fx() {
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        if (file.getName().endsWith(".txt")) {
            return true;
        }
        if (!file.getName().endsWith(".zip")) {
            return false;
        }
        file.delete();
        C4904y.m18639b("delete previous zip file", "SendEmailLog");
        return false;
    }
}
