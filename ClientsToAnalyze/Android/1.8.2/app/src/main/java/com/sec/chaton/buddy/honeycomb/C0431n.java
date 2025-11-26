package com.sec.chaton.buddy.honeycomb;

import com.sec.chaton.buddy.p010a.C0257c;
import java.util.Comparator;

/* compiled from: BuddySelectFragment.java */
/* renamed from: com.sec.chaton.buddy.honeycomb.n */
/* loaded from: classes.dex */
class C0431n implements Comparator {

    /* renamed from: a */
    final /* synthetic */ BuddySelectFragment f1648a;

    C0431n(BuddySelectFragment buddySelectFragment) {
        this.f1648a = buddySelectFragment;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0257c c0257c, C0257c c0257c2) {
        String strM2324b = c0257c.m2324b();
        String strM2324b2 = c0257c2.m2324b();
        if (strM2324b.charAt(0) >= 44032 && strM2324b.charAt(0) <= 55203) {
            if (strM2324b2.charAt(0) >= 44032 && strM2324b2.charAt(0) <= 55203) {
                return strM2324b.compareTo(strM2324b2);
            }
            return -1;
        }
        if (strM2324b2.charAt(0) >= 44032 && strM2324b2.charAt(0) <= 55203) {
            if (strM2324b.charAt(0) >= 44032 && strM2324b.charAt(0) <= 55203) {
                return strM2324b.compareTo(strM2324b2);
            }
            return 1;
        }
        return strM2324b.compareTo(strM2324b2);
    }
}
