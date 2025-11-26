package com.sec.chaton.smsplugin.spam;

import android.database.Cursor;
import android.os.Message;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: ManageSpamMessages.java */
/* renamed from: com.sec.chaton.smsplugin.spam.j */
/* loaded from: classes.dex */
class RunnableC4032j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f14537a;

    /* renamed from: b */
    final /* synthetic */ Cursor f14538b;

    /* renamed from: c */
    final /* synthetic */ ManageSpamMessages f14539c;

    RunnableC4032j(ManageSpamMessages manageSpamMessages, ArrayList arrayList, Cursor cursor) {
        this.f14539c = manageSpamMessages;
        this.f14537a = arrayList;
        this.f14538b = cursor;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f14537a.size(); i++) {
            if (this.f14538b.moveToPosition(((Integer) this.f14537a.get(i)).intValue())) {
                arrayList.add(new C4034l(this.f14539c, this.f14538b.getLong(this.f14538b.getColumnIndexOrThrow("_id")), this.f14538b.getString(this.f14538b.getColumnIndexOrThrow("transport_type")), this.f14538b));
            }
        }
        for (int i2 = 0; i2 < this.f14537a.size(); i2++) {
            this.f14539c.m15293a((C4034l) arrayList.get(i2));
        }
        this.f14539c.m15296b();
        this.f14539c.f14294l.setText(R.string.spam_restore_complete);
        this.f14539c.f14294l.show();
        Message.obtain(this.f14539c.f14298p, 0).sendToTarget();
    }
}
