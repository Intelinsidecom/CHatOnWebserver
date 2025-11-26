package com.sec.chaton.p025d.p026a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: EndChatTask.java */
/* renamed from: com.sec.chaton.d.a.ax */
/* loaded from: classes.dex */
class C1169ax implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f4633a;

    /* renamed from: b */
    final /* synthetic */ C1168aw f4634b;

    C1169ax(C1168aw c1168aw, String str) {
        this.f4634b = c1168aw;
        this.f4633a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f4633a);
    }
}
