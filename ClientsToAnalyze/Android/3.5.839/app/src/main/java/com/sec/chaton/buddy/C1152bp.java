package com.sec.chaton.buddy;

import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.util.C4828at;
import java.util.Comparator;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bp */
/* loaded from: classes.dex */
class C1152bp implements Comparator<C1106c> {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4371a;

    C1152bp(BuddyFragment buddyFragment) {
        this.f4371a = buddyFragment;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C1106c c1106c, C1106c c1106c2) {
        return C4828at.m18276a().m18292d(c1106c.m7051b()).compareTo(C4828at.m18276a().m18292d(c1106c2.m7051b()));
    }
}
