package com.sec.vip.amschaton;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.sec.vip.amschaton.ae */
/* loaded from: classes.dex */
class C0631ae implements Comparator {

    /* renamed from: a */
    final /* synthetic */ AMSFileManager f4240a;

    C0631ae(AMSFileManager aMSFileManager) {
        this.f4240a = aMSFileManager;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return new File(new StringBuilder().append(this.f4240a.f3953a).append((String) obj).toString()).lastModified() > new File(new StringBuilder().append(this.f4240a.f3953a).append((String) obj2).toString()).lastModified() ? -1 : 1;
    }
}
