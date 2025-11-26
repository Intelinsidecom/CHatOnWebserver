package com.sec.vip.amschaton;

import java.io.File;
import java.util.Comparator;

/* compiled from: AMSFileManager.java */
/* renamed from: com.sec.vip.amschaton.ab */
/* loaded from: classes.dex */
class C1365ab implements Comparator {

    /* renamed from: a */
    final /* synthetic */ C1364aa f4788a;

    C1365ab(C1364aa c1364aa) {
        this.f4788a = c1364aa;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return new File(new StringBuilder().append(this.f4788a.f4783a).append((String) obj).toString()).lastModified() > new File(new StringBuilder().append(this.f4788a.f4783a).append((String) obj2).toString()).lastModified() ? -1 : 1;
    }
}
