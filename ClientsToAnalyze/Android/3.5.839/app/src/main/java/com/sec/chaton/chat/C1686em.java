package com.sec.chaton.chat;

import java.io.File;
import java.util.Comparator;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.em */
/* loaded from: classes.dex */
class C1686em implements Comparator<File> {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1677ed f6268a;

    C1686em(AsyncTaskC1677ed asyncTaskC1677ed) {
        this.f6268a = asyncTaskC1677ed;
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
