package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.b */
/* loaded from: classes.dex */
class C1715b implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ C1696a f6359a;

    C1715b(C1696a c1696a) {
        this.f6359a = c1696a;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        switch (i) {
            case 1:
                if (cursor == null || cursor.getCount() == 0) {
                    if (cursor != null) {
                        cursor.close();
                        break;
                    }
                } else {
                    cursor.moveToFirst();
                    String string = cursor.getString(cursor.getColumnIndex("buddy_name"));
                    this.f6359a.m7121a(cursor.getString(cursor.getColumnIndex("buddy_no")), string);
                    cursor.close();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
