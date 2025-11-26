package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.hc */
/* loaded from: classes.dex */
class C1350hc extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f4929a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1350hc(BuddyRecommendFragment buddyRecommendFragment, Handler handler) {
        super(handler);
        this.f4929a = buddyRecommendFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("normalBuddyContentObserver onChange", BuddyRecommendFragment.f4065a);
        }
        if (this.f4929a.f4077e != null) {
            this.f4929a.f4091s.startQuery(3, null, C2228ap.m10094a(), null, null, new String[]{String.valueOf(C4809aa.m18104a().m18118a("recommend_timestamp", 0L))}, null);
            this.f4929a.f4091s.startQuery(1, null, C2228ap.f7956a, null, null, null, null);
            this.f4929a.f4077e.notifyDataSetChanged();
        }
    }
}
