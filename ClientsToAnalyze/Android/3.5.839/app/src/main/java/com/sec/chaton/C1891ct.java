package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2289i;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ct */
/* loaded from: classes.dex */
class C1891ct extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7108a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1891ct(TabActivity tabActivity, Handler handler) {
        super(handler);
        this.f7108a = tabActivity;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f7108a.f2032A) {
            this.f7108a.f2033B = true;
            this.f7108a.f2034C = true;
        } else {
            this.f7108a.f2042K.startQuery(1, null, C2289i.f8196a, null, "buddy_is_new='Y' AND buddy_is_hide='N'", null, null);
        }
    }
}
