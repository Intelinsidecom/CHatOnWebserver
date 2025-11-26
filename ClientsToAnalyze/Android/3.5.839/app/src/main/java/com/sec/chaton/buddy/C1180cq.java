package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cq */
/* loaded from: classes.dex */
class C1180cq extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4408a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1180cq(BuddyFragment buddyFragment, Handler handler) {
        super(handler);
        this.f4408a = buddyFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C4904y.m18639b("ContentObserver.isShow() = " + this.f4408a.f3627aH + ", selfChange = " + z, BuddyFragment.f3576a);
        if (this.f4408a.f3707bl && this.f4408a.f3602I != null && !C4847bl.m18333a()) {
            if (this.f4408a.f3622aC != null) {
                try {
                    this.f4408a.f3622aC.m19613a();
                } catch (Exception e) {
                    C4904y.m18639b("choice panel invalidate exception : " + e.getMessage(), getClass().getSimpleName());
                }
            }
            C4904y.m18639b("ContentObserver.isShow() = " + this.f4408a.f3627aH + ", Entered Observer", BuddyFragment.f3576a);
            this.f4408a.m6574x();
            this.f4408a.f3765h = true;
            if (this.f4408a.f3627aH) {
                if (this.f4408a.f3621aB != null) {
                    this.f4408a.f3621aB.m7408d();
                    this.f4408a.f3621aB.m7406c();
                    this.f4408a.f3621aB.m7403b();
                    if (this.f4408a.f3660ao == 1) {
                        this.f4408a.f3621aB.m7410e();
                    }
                }
                if (this.f4408a.f3620aA != null) {
                    this.f4408a.m6289D();
                }
            } else {
                this.f4408a.f3628aI = true;
                C4904y.m18639b("isChanged : " + this.f4408a.f3628aI, BuddyFragment.f3576a);
            }
            if (this.f4408a.f3621aB != null) {
                this.f4408a.f3621aB.m7410e();
                this.f4408a.m6594b(this.f4408a.f3636aQ);
            }
        }
    }
}
