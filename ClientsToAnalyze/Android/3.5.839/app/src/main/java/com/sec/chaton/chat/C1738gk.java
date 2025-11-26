package com.sec.chaton.chat;

import com.sec.chaton.p046a.C0864cr;
import java.util.Comparator;

/* compiled from: ChatUtil.java */
/* renamed from: com.sec.chaton.chat.gk */
/* loaded from: classes.dex */
final class C1738gk implements Comparator<C0864cr> {
    C1738gk() {
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
