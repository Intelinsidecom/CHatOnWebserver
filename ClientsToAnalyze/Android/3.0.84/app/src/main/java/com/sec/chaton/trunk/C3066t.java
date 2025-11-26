package com.sec.chaton.trunk;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.t */
/* loaded from: classes.dex */
final class C3066t implements InterfaceC1378v {
    C3066t() {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == 99 && cursor != null && cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                String[] strArr = (String[]) obj;
                long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
                String string = cursor.getString(cursor.getColumnIndex("message_content"));
                if (string != null) {
                    String[] strArrSplit = string.split("\n");
                    if (strArrSplit.length > 0 && strArrSplit[3].equals(strArr[1])) {
                        C3250y.m11450b("[update video]", getClass().getName());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("message_download_uri", Uri.parse("file://" + strArr[0] + "/" + strArr[1]).toString());
                        contentValues.put("message_stored_ext", (Integer) 1);
                        if (Boolean.parseBoolean(strArr[2])) {
                            contentValues.put("message_type", (Integer) 2);
                        } else {
                            contentValues.put("message_type", (Integer) 4);
                        }
                        ViewOnClickListenerC3064r.f10963o.startUpdate(99, null, C1454v.f5393a, contentValues, "message_sever_id = ? ", new String[]{String.valueOf(j)});
                        cursor.close();
                        return;
                    }
                }
            }
            cursor.close();
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
