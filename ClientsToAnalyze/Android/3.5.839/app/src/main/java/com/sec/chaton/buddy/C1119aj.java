package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2230ar;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.aj */
/* loaded from: classes.dex */
class C1119aj extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ C1113ad f4327a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1119aj(C1113ad c1113ad, Handler handler) {
        super(handler);
        this.f4327a = c1113ad;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f4327a.f4291G != null) {
            this.f4327a.f4291G.startQuery(1000, null, C2230ar.f7958a, null, "islike = 'Y'", null, null);
        }
    }
}
