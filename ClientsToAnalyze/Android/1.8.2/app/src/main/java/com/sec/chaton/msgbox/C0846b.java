package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.b */
/* loaded from: classes.dex */
class C0846b implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ C0845a f3144a;

    C0846b(C0845a c0845a) {
        this.f3144a = c0845a;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == 1) {
            if (cursor == null || cursor.getCount() == 0) {
                if (cursor != null) {
                    cursor.close();
                }
            } else {
                cursor.moveToFirst();
                String string = cursor.getString(cursor.getColumnIndex("buddy_name"));
                this.f3144a.m3543a(cursor.getString(cursor.getColumnIndex("buddy_no")), string);
                cursor.close();
            }
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
