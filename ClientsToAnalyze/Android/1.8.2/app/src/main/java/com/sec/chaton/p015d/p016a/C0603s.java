package com.sec.chaton.p015d.p016a;

import com.sec.chaton.p007a.C0144bj;
import java.util.Comparator;

/* compiled from: DeliveryChatTask.java */
/* renamed from: com.sec.chaton.d.a.s */
/* loaded from: classes.dex */
class C0603s implements Comparator {

    /* renamed from: a */
    final /* synthetic */ C0602r f2375a;

    C0603s(C0602r c0602r) {
        this.f2375a = c0602r;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0144bj c0144bj, C0144bj c0144bj2) {
        if (c0144bj.m1120l() > c0144bj2.m1120l()) {
            return 1;
        }
        if (c0144bj.m1120l() < c0144bj2.m1120l()) {
            return -1;
        }
        return 0;
    }
}
