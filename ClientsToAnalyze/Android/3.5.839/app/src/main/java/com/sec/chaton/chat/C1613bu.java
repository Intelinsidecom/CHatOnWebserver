package com.sec.chaton.chat;

import com.sec.chaton.p046a.p047a.C0777a;
import java.util.Comparator;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bu */
/* loaded from: classes.dex */
class C1613bu implements Comparator<C0777a> {

    /* renamed from: a */
    final /* synthetic */ C1612bt f6130a;

    C1613bu(C1612bt c1612bt) {
        this.f6130a = c1612bt;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0777a c0777a, C0777a c0777a2) {
        if (c0777a.m3096a().compareTo(c0777a2.m3096a()) > 0) {
            return 1;
        }
        if (c0777a.m3096a().compareTo(c0777a2.m3096a()) < 0) {
            return -1;
        }
        return 0;
    }
}
