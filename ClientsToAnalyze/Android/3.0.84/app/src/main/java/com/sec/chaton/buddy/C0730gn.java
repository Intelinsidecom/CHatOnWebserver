package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C3250y;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.gn */
/* loaded from: classes.dex */
class C0730gn extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListFragment f2984a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0730gn(BuddyRecommendListFragment buddyRecommendListFragment, Handler handler) {
        super(handler);
        this.f2984a = buddyRecommendListFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C3250y.m11459h("normalBuddyContentObserver onChange", getClass().getSimpleName());
        this.f2984a.f2230p = this.f2984a.m3818c();
        if (this.f2984a.f2217c != null) {
            this.f2984a.f2217c.notifyDataSetChanged();
        }
    }
}
