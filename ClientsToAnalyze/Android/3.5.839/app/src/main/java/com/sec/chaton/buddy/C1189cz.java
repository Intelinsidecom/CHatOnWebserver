package com.sec.chaton.buddy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cz */
/* loaded from: classes.dex */
class C1189cz extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4417a;

    C1189cz(BuddyFragment buddyFragment) {
        this.f4417a = buddyFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("mPasswordLockReceiver", getClass().getSimpleName());
        BuddyFragment.f3593s = true;
    }
}
