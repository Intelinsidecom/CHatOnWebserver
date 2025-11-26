package com.sec.chaton.chat;

import java.io.File;
import java.util.Comparator;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.di */
/* loaded from: classes.dex */
class C1040di implements Comparator<File> {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1033db f4150a;

    C1040di(AsyncTaskC1033db asyncTaskC1033db) {
        this.f4150a = asyncTaskC1033db;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(File file, File file2) {
        if (file.lastModified() > file2.lastModified()) {
            return -1;
        }
        if (file.lastModified() == file2.lastModified()) {
            return 0;
        }
        return 1;
    }
}
