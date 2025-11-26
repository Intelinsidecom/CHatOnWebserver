package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p025d.C0667t;

/* compiled from: HomeTabFragment.java */
/* renamed from: com.sec.chaton.y */
/* loaded from: classes.dex */
class C1361y extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f4620a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1361y(HomeTabFragment homeTabFragment, Handler handler) {
        super(handler);
        this.f4620a = homeTabFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f4620a.f274g.startQuery(1, null, C0667t.f2310a, null, "buddy_is_new='Y'", null, null);
    }
}
