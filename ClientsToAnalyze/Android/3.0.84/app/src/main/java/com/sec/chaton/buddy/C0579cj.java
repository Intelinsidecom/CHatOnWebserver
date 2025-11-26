package com.sec.chaton.buddy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cj */
/* loaded from: classes.dex */
class C0579cj extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2541a;

    C0579cj(BuddyFragment buddyFragment) {
        this.f2541a = buddyFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("receive ACTION_BUDDY_TAB_BADGE_UPDATE", getClass().getSimpleName());
        this.f2541a.m3225G();
        this.f2541a.f1810av = true;
    }
}
