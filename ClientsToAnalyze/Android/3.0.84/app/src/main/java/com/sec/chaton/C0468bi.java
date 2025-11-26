package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1449q;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bi */
/* loaded from: classes.dex */
class C0468bi extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1536a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0468bi(TabActivity tabActivity, Handler handler) {
        super(handler);
        this.f1536a = tabActivity;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f1536a.f788l) {
            this.f1536a.f789m = true;
            this.f1536a.f792p = true;
        } else {
            this.f1536a.f800x.startQuery(2, null, C1449q.f5381a, null, "inbox_unread_count > 0", null, null);
        }
    }
}
