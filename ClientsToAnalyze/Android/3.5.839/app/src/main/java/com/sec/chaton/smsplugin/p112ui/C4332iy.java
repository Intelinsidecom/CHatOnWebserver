package com.sec.chaton.smsplugin.p112ui;

import android.database.Cursor;
import android.sec.multiwindow.MWOnDragListener;
import android.view.DragEvent;

/* compiled from: ThreadListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.iy */
/* loaded from: classes.dex */
class C4332iy extends MWOnDragListener {

    /* renamed from: a */
    final /* synthetic */ int f15751a;

    /* renamed from: b */
    final /* synthetic */ C4331ix f15752b;

    C4332iy(C4331ix c4331ix, int i) {
        this.f15752b = c4331ix;
        this.f15751a = i;
    }

    @Override // android.sec.multiwindow.MWOnDragListener
    public void onDrop(DragEvent dragEvent) throws Throwable {
        Cursor cursor = (Cursor) this.f15752b.getItem(this.f15751a);
        String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
        String string2 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        int i = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        this.f15752b.m16506a(dragEvent.getClipData(), this.f15752b.f580d, string, "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid"))), i, string2);
    }
}
