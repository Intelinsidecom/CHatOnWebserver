package com.sec.vip.amschaton;

import java.util.Comparator;

/* renamed from: com.sec.vip.amschaton.x */
/* loaded from: classes.dex */
class C0721x implements Comparator {

    /* renamed from: a */
    final /* synthetic */ AMSStampManager f4355a;

    C0721x(AMSStampManager aMSStampManager) {
        this.f4355a = aMSStampManager;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((String) obj).compareTo((String) obj2);
    }
}
