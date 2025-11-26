package com.sec.chaton.block;

import java.util.Comparator;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.j */
/* loaded from: classes.dex */
class C1082j implements Comparator<C1093u> {

    /* renamed from: a */
    final /* synthetic */ HandlerC1081i f3462a;

    C1082j(HandlerC1081i handlerC1081i) {
        this.f3462a = handlerC1081i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C1093u c1093u, C1093u c1093u2) {
        return c1093u.f3485b.toLowerCase().compareTo(c1093u2.f3485b.toLowerCase());
    }
}
