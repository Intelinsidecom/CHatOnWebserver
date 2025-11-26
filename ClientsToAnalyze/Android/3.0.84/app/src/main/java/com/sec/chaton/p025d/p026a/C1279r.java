package com.sec.chaton.p025d.p026a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AsyncEndChatTask.java */
/* renamed from: com.sec.chaton.d.a.r */
/* loaded from: classes.dex */
class C1279r implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f4891a;

    /* renamed from: b */
    final /* synthetic */ C1278q f4892b;

    C1279r(C1278q c1278q, String str) {
        this.f4892b = c1278q;
        this.f4891a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.f4891a);
    }
}
