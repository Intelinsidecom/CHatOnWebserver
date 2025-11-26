package com.sec.chaton.hide;

import java.util.Comparator;

/* compiled from: HideImpl.java */
/* renamed from: com.sec.chaton.hide.m */
/* loaded from: classes.dex */
class C1522m implements Comparator<C1515f> {

    /* renamed from: a */
    final /* synthetic */ C1521l f5601a;

    C1522m(C1521l c1521l) {
        this.f5601a = c1521l;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C1515f c1515f, C1515f c1515f2) {
        return c1515f.f5573b.toLowerCase().compareTo(c1515f2.f5573b.toLowerCase());
    }
}
