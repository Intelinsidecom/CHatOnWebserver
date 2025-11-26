package com.facebook;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Request.java */
/* renamed from: com.facebook.ap */
/* loaded from: classes.dex */
final class RunnableC0075ap implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f126a;

    /* renamed from: b */
    final /* synthetic */ C0083ax f127b;

    RunnableC0075ap(ArrayList arrayList, C0083ax c0083ax) {
        this.f126a = arrayList;
        this.f127b = c0083ax;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f126a.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((InterfaceC0077ar) pair.first).mo176a((C0085az) pair.second);
        }
        Iterator<InterfaceC0084ay> it2 = this.f127b.m203e().iterator();
        while (it2.hasNext()) {
            it2.next().mo209a(this.f127b);
        }
    }
}
