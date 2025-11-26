package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.C0864cr;
import java.util.Comparator;

/* compiled from: DeliveryChatTask.java */
/* renamed from: com.sec.chaton.d.a.ar */
/* loaded from: classes.dex */
class C1918ar implements Comparator<C0864cr> {

    /* renamed from: a */
    final /* synthetic */ C1917aq f7155a;

    C1918ar(C1917aq c1917aq) {
        this.f7155a = c1917aq;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0864cr c0864cr, C0864cr c0864cr2) {
        if (c0864cr.m4158l() > c0864cr2.m4158l()) {
            return 1;
        }
        if (c0864cr.m4158l() < c0864cr2.m4158l()) {
            return -1;
        }
        return 0;
    }
}
