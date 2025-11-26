package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.util.C3250y;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gh */
/* loaded from: classes.dex */
class C0724gh extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2968a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0724gh(BuddyRecommendFragment buddyRecommendFragment, Handler handler) {
        super(handler);
        this.f2968a = buddyRecommendFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C3250y.m11459h("normalBuddyContentObserver onChange", getClass().getSimpleName());
        if (this.f2968a.f2190c != null) {
            this.f2968a.f2204q.startQuery(1, null, C1388af.f5186a, null, "type='200'", null, null);
            this.f2968a.f2204q.startQuery(2, null, C1388af.f5186a, null, "type='100' AND rank > 0", null, "rank COLLATE LOCALIZED ASC");
            this.f2968a.f2190c.notifyDataSetChanged();
        }
    }
}
