package com.sec.chaton.p025d.p026a;

import com.sec.chaton.p016a.C0333cc;
import java.util.Comparator;

/* compiled from: DeliveryChatTask.java */
/* renamed from: com.sec.chaton.d.a.ar */
/* loaded from: classes.dex */
class C1163ar implements Comparator<C0333cc> {

    /* renamed from: a */
    final /* synthetic */ C1162aq f4615a;

    C1163ar(C1162aq c1162aq) {
        this.f4615a = c1162aq;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0333cc c0333cc, C0333cc c0333cc2) {
        if (c0333cc.m2051l() > c0333cc2.m2051l()) {
            return 1;
        }
        if (c0333cc.m2051l() < c0333cc2.m2051l()) {
            return -1;
        }
        return 0;
    }
}
