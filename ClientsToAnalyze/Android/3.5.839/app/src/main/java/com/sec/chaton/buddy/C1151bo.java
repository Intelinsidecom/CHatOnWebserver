package com.sec.chaton.buddy;

import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.util.C4828at;
import com.sec.chaton.util.C4842bg;
import java.util.ArrayList;
import java.util.Comparator;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bo */
/* loaded from: classes.dex */
class C1151bo implements Comparator<ArrayList<C1106c>> {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4370a;

    C1151bo(BuddyFragment buddyFragment) {
        this.f4370a = buddyFragment;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ArrayList<C1106c> arrayList, ArrayList<C1106c> arrayList2) {
        if (C4842bg.m18321c(C4828at.m18276a().m18292d(Character.toString(arrayList.get(0).m7051b().charAt(0))).charAt(0))) {
            return -1;
        }
        if (C4842bg.m18321c(C4828at.m18276a().m18292d(Character.toString(arrayList2.get(0).m7051b().charAt(0))).charAt(0))) {
            return 1;
        }
        return arrayList.get(0).m7051b().toUpperCase().compareTo(arrayList2.get(0).m7051b().toUpperCase());
    }
}
