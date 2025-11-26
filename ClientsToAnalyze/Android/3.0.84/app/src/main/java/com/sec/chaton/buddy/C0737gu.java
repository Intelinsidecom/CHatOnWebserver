package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C3250y;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.gu */
/* loaded from: classes.dex */
class C0737gu extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListFragment f2991a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0737gu(BuddyRecommendListFragment buddyRecommendListFragment, Handler handler) {
        super(handler);
        this.f2991a = buddyRecommendListFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C3250y.m11459h("normalBuddyContentObserver onChange", getClass().getSimpleName());
        this.f2991a.f2230p = this.f2991a.m3821d();
        if (this.f2991a.f2217c != null) {
            this.f2991a.f2217c.notifyDataSetChanged();
        }
    }
}
