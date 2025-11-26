package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.C1390ah;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hv */
/* loaded from: classes.dex */
class C0765hv extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3032a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0765hv(SpecialBuddyFragment specialBuddyFragment, Handler handler) {
        super(handler);
        this.f3032a = specialBuddyFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f3032a.f2311p) {
            this.f3032a.f2301f.startQuery(1, null, C1390ah.f5188a, null, "buddy_no = ? ", new String[]{this.f3032a.f2306k}, null);
        } else {
            this.f3032a.f2301f.startQuery(4, null, C1388af.f5186a, null, "buddy_no = ? ", new String[]{this.f3032a.f2306k}, null);
        }
    }
}
