package com.sec.chaton.chat;

import java.io.File;
import java.util.Comparator;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ar */
/* loaded from: classes.dex */
class C0476ar implements Comparator {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC0473ao f1959a;

    C0476ar(AsyncTaskC0473ao asyncTaskC0473ao) {
        this.f1959a = asyncTaskC0473ao;
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
