package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.sec.multiwindow.MWOnDragListener;
import android.view.DragEvent;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.c */
/* loaded from: classes.dex */
class C2658c extends MWOnDragListener {

    /* renamed from: a */
    final /* synthetic */ int f9524a;

    /* renamed from: b */
    final /* synthetic */ C2608a f9525b;

    C2658c(C2608a c2608a, int i) {
        this.f9525b = c2608a;
        this.f9524a = i;
    }

    @Override // android.sec.multiwindow.MWOnDragListener
    public void onDrop(DragEvent dragEvent) throws Throwable {
        Cursor cursor = (Cursor) this.f9525b.getItem(this.f9524a);
        String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
        String string2 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        int i = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        this.f9525b.m11148a(dragEvent.getClipData(), this.f9525b.f580d, string, "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid"))), i, string2);
    }
}
