package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.database.Cursor;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.p027e.C1454v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0932aj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0930ah f3877a;

    DialogInterfaceOnClickListenerC0932aj(MenuItemOnMenuItemClickListenerC0930ah menuItemOnMenuItemClickListenerC0930ah) {
        this.f3877a = menuItemOnMenuItemClickListenerC0930ah;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Cursor cursor = (Cursor) this.f3877a.f3875c.f3526aB.getAdapter().getItem(this.f3877a.f3873a);
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        this.f3877a.f3874b.mo5106c_();
        C1756p.m7231a(this.f3877a.f3875c.f3703r, j);
        this.f3877a.f3875c.f3551aa.startDelete(3, null, C1454v.m6354d(), "_id='" + j + "'", null);
    }
}
