package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C1341p;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.o */
/* loaded from: classes.dex */
class C0450o extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1443a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0450o(BuddyFragment buddyFragment, Handler handler) {
        super(handler);
        this.f1443a = buddyFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C1341p.m4663f("ContentObserver.onChange() : " + this.f1443a.f1120ac, BuddyFragment.f1090a);
        if (this.f1443a.f1120ac) {
            if (this.f1443a.f1114X != null) {
                this.f1443a.f1114X.m2351a();
            }
            if (this.f1443a.f1113W != null) {
                this.f1443a.m2174r();
                return;
            }
            return;
        }
        this.f1443a.f1121ad = true;
        C1341p.m4663f("isChanged : " + this.f1443a.f1121ad, BuddyFragment.f1090a);
    }
}
