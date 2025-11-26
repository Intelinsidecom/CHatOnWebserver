package com.sec.vip.amschaton;

import java.io.File;
import java.util.Comparator;

/* compiled from: AMSFileManager.java */
/* renamed from: com.sec.vip.amschaton.o */
/* loaded from: classes.dex */
class C2065o implements Comparator {

    /* renamed from: a */
    final /* synthetic */ C2064n f7364a;

    C2065o(C2064n c2064n) {
        this.f7364a = c2064n;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return new File(new StringBuilder().append(this.f7364a.f7359a).append((String) obj).toString()).lastModified() > new File(new StringBuilder().append(this.f7364a.f7359a).append((String) obj2).toString()).lastModified() ? -1 : 1;
    }
}
