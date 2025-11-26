package com.sec.vip.amschaton;

import java.io.File;
import java.util.Comparator;

/* compiled from: AMSStampManager.java */
/* renamed from: com.sec.vip.amschaton.am */
/* loaded from: classes.dex */
class C3411am implements Comparator {

    /* renamed from: a */
    final /* synthetic */ C3410al f12499a;

    C3411am(C3410al c3410al) {
        this.f12499a = c3410al;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return new File(new StringBuilder().append(this.f12499a.f12485d).append((String) obj).toString()).lastModified() > new File(new StringBuilder().append(this.f12499a.f12485d).append((String) obj2).toString()).lastModified() ? -1 : 1;
    }
}
