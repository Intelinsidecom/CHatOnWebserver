package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1441i;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.am */
/* loaded from: classes.dex */
class C0435am extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1497a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0435am(TabActivity tabActivity, Handler handler) {
        super(handler);
        this.f1497a = tabActivity;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f1497a.f788l) {
            this.f1497a.f789m = true;
            this.f1497a.f790n = true;
        } else {
            this.f1497a.f800x.startQuery(1, null, C1441i.f5369a, null, "buddy_is_new='Y' AND buddy_is_hide='N'", null, null);
        }
    }
}
