package com.sec.chaton.p013a.p014a;

import com.sec.chaton.p015b.C0329co;
import java.util.Comparator;

/* compiled from: DeliveryChatTask.java */
/* renamed from: com.sec.chaton.a.a.y */
/* loaded from: classes.dex */
class C0186y implements Comparator {

    /* renamed from: a */
    final /* synthetic */ C0182u f462a;

    C0186y(C0182u c0182u) {
        this.f462a = c0182u;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0329co c0329co, C0329co c0329co2) {
        if (c0329co.m1826l() > c0329co2.m1826l()) {
            return 1;
        }
        if (c0329co.m1826l() < c0329co2.m1826l()) {
            return -1;
        }
        return 0;
    }
}
