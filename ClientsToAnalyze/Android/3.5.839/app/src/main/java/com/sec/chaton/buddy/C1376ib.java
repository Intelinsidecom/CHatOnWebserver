package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p057e.C2230ar;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ib */
/* loaded from: classes.dex */
class C1376ib extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4976a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1376ib(SpecialBuddyFragment specialBuddyFragment, Handler handler) {
        super(handler);
        this.f4976a = specialBuddyFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f4976a.f4136O) {
            this.f4976a.f4146e.startQuery(501, null, C2230ar.f7958a, null, "buddy_no = ? ", new String[]{this.f4976a.f4130I}, null);
        } else {
            this.f4976a.f4146e.startQuery(504, null, C2228ap.f7956a, null, "buddy_no = ? ", new String[]{this.f4976a.f4130I}, null);
        }
    }
}
