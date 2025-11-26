package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.database.Cursor;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.p057e.C2306z;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1595bc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1581ba f6100a;

    DialogInterfaceOnClickListenerC1595bc(MenuItemOnMenuItemClickListenerC1581ba menuItemOnMenuItemClickListenerC1581ba) {
        this.f6100a = menuItemOnMenuItemClickListenerC1581ba;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Cursor cursor = (Cursor) this.f6100a.f6017c.f5527aT.getAdapter().getItem(this.f6100a.f6015a);
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        this.f6100a.f6016b.mo8400h_();
        C2716x.m11378a(this.f6100a.f6017c.f5750v, j);
        this.f6100a.f6017c.f5546ao.startDelete(3, null, C2306z.m10224d(), "_id='" + j + "'", null);
    }
}
