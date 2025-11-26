package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ce */
/* loaded from: classes.dex */
class C0574ce extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2536a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0574ce(BuddyFragment buddyFragment, Handler handler) {
        super(handler);
        this.f2536a = buddyFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C3250y.m11458g("ContentObserver.isShow() = " + this.f2536a.f1809au + ", selfChange = " + z, BuddyFragment.f1724a);
        if (!C3197bl.m11159a()) {
            if (this.f2536a.f1805aq != null) {
                try {
                    this.f2536a.f1805aq.m13053a();
                } catch (Exception e) {
                    C3250y.m11450b("choice panel invalidate exception : " + e.getMessage(), getClass().getSimpleName());
                }
            }
            C3250y.m11458g("ContentObserver.isShow() = " + this.f2536a.f1809au + ", Entered Observer", BuddyFragment.f1724a);
            this.f2536a.f1883h = true;
            if (this.f2536a.f1809au) {
                if (this.f2536a.f1804ap != null) {
                    this.f2536a.f1804ap.m4057c();
                    this.f2536a.f1804ap.m4054b();
                    this.f2536a.f1804ap.m4059d();
                    if (this.f2536a.f1791ac == 1) {
                        this.f2536a.f1804ap.m4061e();
                    }
                }
                if (this.f2536a.f1803ao != null) {
                    this.f2536a.m3228H();
                }
            } else {
                this.f2536a.f1810av = true;
                C3250y.m11458g("isChanged : " + this.f2536a.f1810av, BuddyFragment.f1724a);
            }
            if (this.f2536a.f1804ap != null) {
                this.f2536a.f1804ap.m4061e();
                this.f2536a.m3434b(this.f2536a.f1766aD);
            }
        }
    }
}
