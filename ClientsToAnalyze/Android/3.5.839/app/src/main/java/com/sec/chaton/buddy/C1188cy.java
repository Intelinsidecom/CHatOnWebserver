package com.sec.chaton.buddy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.p057e.C2264bj;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.util.C4904y;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cy */
/* loaded from: classes.dex */
class C1188cy extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4416a;

    C1188cy(BuddyFragment buddyFragment) {
        this.f4416a = buddyFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("[EventBanner] receive ACTION_PROMOTION_EVENT_UPDATE", getClass().getSimpleName());
        if (this.f4416a.f3598E == null) {
            this.f4416a.f3598E = new C2210x(this.f4416a.getActivity().getContentResolver(), this.f4416a.f3767t);
        }
        this.f4416a.f3598E.startQuery(1002, null, C2264bj.f8054a, null, null, null, "start_time DESC");
    }
}
