package com.sec.chaton.trunk;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.t */
/* loaded from: classes.dex */
final class C4686t implements InterfaceC2211y {
    C4686t() {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (i == 99 && cursor != null && cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                String[] strArr = (String[]) obj;
                long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
                String string = cursor.getString(cursor.getColumnIndex("message_content"));
                if (string != null) {
                    String[] strArrSplit = string.split("\n");
                    if (strArrSplit.length > 0 && strArrSplit[3].equals(strArr[1])) {
                        C4904y.m18639b("[update video]", getClass().getName());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("message_download_uri", Uri.parse("file://" + strArr[0] + "/" + strArr[1]).toString());
                        contentValues.put("message_stored_ext", (Integer) 1);
                        if (Boolean.parseBoolean(strArr[2])) {
                            contentValues.put("message_type", (Integer) 2);
                        } else {
                            contentValues.put("message_type", (Integer) 4);
                        }
                        ViewOnClickListenerC4684r.f16912o.startUpdate(99, null, C2306z.f8229a, contentValues, "message_sever_id = ? ", new String[]{String.valueOf(j)});
                        cursor.close();
                        return;
                    }
                }
            }
            cursor.close();
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
