package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2299s;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dq */
/* loaded from: classes.dex */
class C2162dq extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7791a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2162dq(TabActivity tabActivity, Handler handler) {
        super(handler);
        this.f7791a = tabActivity;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f7791a.f2032A) {
            this.f7791a.f2033B = true;
            this.f7791a.f2036E = true;
        } else {
            this.f7791a.f2042K.startQuery(2, null, C2299s.m10205r(), null, "inbox_unread_count > 0 OR sms_unread_count > 0", null, null);
        }
    }
}
