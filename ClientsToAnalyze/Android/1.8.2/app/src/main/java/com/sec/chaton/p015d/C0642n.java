package com.sec.chaton.p015d;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1786r;

/* compiled from: MessageControl.java */
/* renamed from: com.sec.chaton.d.n */
/* loaded from: classes.dex */
class C0642n implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ C0639k f2506a;

    C0642n(C0639k c0639k) {
        this.f2506a = c0639k;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == 99 && cursor != null && cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                String[] strArr = (String[]) obj;
                long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
                String string = cursor.getString(cursor.getColumnIndex("message_content"));
                if (string != null) {
                    String[] strArrSplit = string.split("\n");
                    if (strArrSplit.length > 0 && strArrSplit[3].equals(strArr[1])) {
                        C1786r.m6061b("[update video]", getClass().getName());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("message_download_uri", Uri.parse("file://" + strArr[0] + "/" + strArr[1]).toString());
                        contentValues.put("message_stored_ext", (Integer) 1);
                        this.f2506a.f2500s.startUpdate(99, null, C0698m.f2626a, contentValues, "message_sever_id = ? ", new String[]{String.valueOf(j)});
                        cursor.close();
                        return;
                    }
                }
            }
            cursor.close();
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
