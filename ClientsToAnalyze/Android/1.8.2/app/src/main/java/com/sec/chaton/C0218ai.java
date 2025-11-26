package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0688c;

/* compiled from: HomeTabFragment.java */
/* renamed from: com.sec.chaton.ai */
/* loaded from: classes.dex */
class C0218ai extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f753a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0218ai(HomeTabFragment homeTabFragment, Handler handler) {
        super(handler);
        this.f753a = homeTabFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f753a.f248l.startQuery(1, null, C0688c.f2606a, null, "buddy_is_new='Y'", null, null);
    }
}
