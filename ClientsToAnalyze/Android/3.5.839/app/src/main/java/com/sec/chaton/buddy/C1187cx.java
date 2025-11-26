package com.sec.chaton.buddy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cx */
/* loaded from: classes.dex */
class C1187cx extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4415a;

    C1187cx(BuddyFragment buddyFragment) {
        this.f4415a = buddyFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("receive ACTION_BUDDY_TAB_BADGE_UPDATE", getClass().getSimpleName());
        this.f4415a.f3628aI = true;
    }
}
