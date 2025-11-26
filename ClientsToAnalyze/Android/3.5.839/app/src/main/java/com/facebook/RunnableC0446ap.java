package com.facebook;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Request.java */
/* renamed from: com.facebook.ap */
/* loaded from: classes.dex */
final class RunnableC0446ap implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f1095a;

    /* renamed from: b */
    final /* synthetic */ C0454ax f1096b;

    RunnableC0446ap(ArrayList arrayList, C0454ax c0454ax) {
        this.f1095a = arrayList;
        this.f1096b = c0454ax;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f1095a.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((InterfaceC0448ar) pair.first).mo1620a((C0456az) pair.second);
        }
        Iterator<InterfaceC0455ay> it2 = this.f1096b.m1647e().iterator();
        while (it2.hasNext()) {
            it2.next().mo1653a(this.f1096b);
        }
    }
}
