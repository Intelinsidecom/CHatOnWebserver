package com.sec.chaton.msgbox;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.msgbox.m */
/* loaded from: classes.dex */
class C0263m extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2004a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0263m(MsgboxFragment msgboxFragment, Handler handler) {
        super(handler);
        this.f2004a = msgboxFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f2004a.f1962D) {
            this.f2004a.f1979r.startQuery(1, null, ChatONContract.InBoxTable.m2184a(), null, "inbox_no!='" + this.f2004a.f1966H + "'", null, "inbox_last_time DESC");
        } else {
            this.f2004a.f1979r.startQuery(1, null, ChatONContract.InBoxTable.m2184a(), null, null, null, "inbox_last_time DESC");
        }
    }
}
