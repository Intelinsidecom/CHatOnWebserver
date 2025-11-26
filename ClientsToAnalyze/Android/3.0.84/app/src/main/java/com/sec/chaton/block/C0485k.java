package com.sec.chaton.block;

import java.util.Comparator;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.k */
/* loaded from: classes.dex */
class C0485k implements Comparator<C0475ac> {

    /* renamed from: a */
    final /* synthetic */ HandlerC0484j f1597a;

    C0485k(HandlerC0484j handlerC0484j) {
        this.f1597a = handlerC0484j;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0475ac c0475ac, C0475ac c0475ac2) {
        return c0475ac.f1585b.toLowerCase().compareTo(c0475ac2.f1585b.toLowerCase());
    }
}
