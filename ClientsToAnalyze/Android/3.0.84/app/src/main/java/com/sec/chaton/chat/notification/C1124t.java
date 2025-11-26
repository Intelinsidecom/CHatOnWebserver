package com.sec.chaton.chat.notification;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.t */
/* loaded from: classes.dex */
class C1124t implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f4534a;

    C1124t(ScreenNotification2 screenNotification2) {
        this.f4534a = screenNotification2;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) throws Throwable {
        if (i == 0) {
            C1103a.m5432a(this.f4534a.f4409j).m5454a(this.f4534a.f4386E.f4502e, C1103a.f4445g);
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
