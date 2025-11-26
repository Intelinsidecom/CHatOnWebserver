package com.sec.chaton.smsplugin.p112ui;

import java.util.Comparator;

/* compiled from: SlideView.java */
/* renamed from: com.sec.chaton.smsplugin.ui.if */
/* loaded from: classes.dex */
class C4313if implements Comparator<C4314ig> {

    /* renamed from: a */
    final /* synthetic */ SlideView f15707a;

    C4313if(SlideView slideView) {
        this.f15707a = slideView;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C4314ig c4314ig, C4314ig c4314ig2) {
        int i = c4314ig.f15709b;
        int i2 = c4314ig.f15708a;
        int i3 = c4314ig2.f15709b;
        int i4 = i2 - c4314ig2.f15708a;
        if (i4 == 0) {
            i4 = i - i3;
        }
        if (i4 == 0) {
            return -1;
        }
        return i4;
    }
}
