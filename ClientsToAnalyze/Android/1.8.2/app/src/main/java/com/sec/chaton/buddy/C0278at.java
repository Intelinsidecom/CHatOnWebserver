package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.at */
/* loaded from: classes.dex */
class C0278at extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1373a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0278at(BuddyFragment buddyFragment, Handler handler) {
        super(handler);
        this.f1373a = buddyFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C1786r.m6067f("ContentObserver.onChange(selfChange) : " + z, BuddyFragment.f908a);
        C1786r.m6067f("isShow : " + this.f1373a.f940aB, BuddyFragment.f908a);
        C1786r.m6067f("isChanged : " + this.f1373a.f941aC, BuddyFragment.f908a);
        if (this.f1373a.f940aB) {
            if (this.f1373a.f981ar != null) {
                this.f1373a.f981ar.m2370a();
                this.f1373a.f981ar.m2374b();
                if (this.f1373a.f969af == 1) {
                    this.f1373a.f981ar.m2377c();
                }
            }
            if (this.f1373a.f980aq != null) {
                this.f1373a.m1911G();
            }
        } else {
            this.f1373a.f941aC = true;
            C1786r.m6067f("isChanged : " + this.f1373a.f941aC, BuddyFragment.f908a);
        }
        if (this.f1373a.f981ar != null) {
            this.f1373a.f981ar.m2377c();
            this.f1373a.m2040b(this.f1373a.f957aS);
        }
    }
}
