package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2230ar;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.df */
/* loaded from: classes.dex */
class C2151df extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7780a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2151df(TabActivity tabActivity, Handler handler) {
        super(handler);
        this.f7780a = tabActivity;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f7780a.f2032A) {
            this.f7780a.f2033B = true;
            this.f7780a.f2035D = true;
        } else {
            this.f7780a.f2042K.startQuery(3, null, C2230ar.f7958a, null, "isNew='Y'", null, null);
        }
    }
}
