package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1390ah;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ay */
/* loaded from: classes.dex */
class C0450ay extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1518a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0450ay(TabActivity tabActivity, Handler handler) {
        super(handler);
        this.f1518a = tabActivity;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f1518a.f788l) {
            this.f1518a.f789m = true;
            this.f1518a.f791o = true;
        } else {
            this.f1518a.f800x.startQuery(3, null, C1390ah.f5188a, null, "isNew='Y'", null, null);
        }
    }
}
