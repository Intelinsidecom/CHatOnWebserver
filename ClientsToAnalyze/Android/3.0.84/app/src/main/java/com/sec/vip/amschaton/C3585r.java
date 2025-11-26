package com.sec.vip.amschaton;

import java.io.File;
import java.util.Comparator;

/* compiled from: AMSFileManager.java */
/* renamed from: com.sec.vip.amschaton.r */
/* loaded from: classes.dex */
class C3585r implements Comparator {

    /* renamed from: a */
    final /* synthetic */ C3584q f13053a;

    C3585r(C3584q c3584q) {
        this.f13053a = c3584q;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return new File(new StringBuilder().append(this.f13053a.f13042b).append((String) obj).toString()).lastModified() > new File(new StringBuilder().append(this.f13053a.f13042b).append((String) obj2).toString()).lastModified() ? -1 : 1;
    }
}
