package com.sec.chaton.buddy;

import com.sec.chaton.buddy.p050a.C1104a;
import java.util.Comparator;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bn */
/* loaded from: classes.dex */
class C1150bn implements Comparator<C1104a> {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4369a;

    C1150bn(BuddyFragment buddyFragment) {
        this.f4369a = buddyFragment;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C1104a c1104a, C1104a c1104a2) {
        if (c1104a.m7028b().compareTo("#") == 0) {
            return -1;
        }
        if (c1104a2.m7028b().compareTo("#") == 0) {
            return 1;
        }
        return c1104a.m7028b().compareTo(c1104a2.m7028b());
    }
}
