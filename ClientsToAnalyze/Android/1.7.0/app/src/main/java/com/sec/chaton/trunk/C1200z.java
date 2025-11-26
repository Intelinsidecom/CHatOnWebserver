package com.sec.chaton.trunk;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.z */
/* loaded from: classes.dex */
final class C1200z implements InterfaceC0626f {
    C1200z() {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
        if (i == 99 && cursor != null && cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                String[] strArr = (String[]) obj;
                long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
                String string = cursor.getString(cursor.getColumnIndex("message_content"));
                if (string != null) {
                    String[] strArrSplit = string.split("\n");
                    if (strArrSplit.length > 0 && strArrSplit[3].equals(strArr[1])) {
                        C1341p.m4658b("[update video]", getClass().getName());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("message_download_uri", Uri.parse("file://" + strArr[0] + "/" + strArr[1]).toString());
                        contentValues.put("message_stored_ext", (Integer) 1);
                        if (Boolean.parseBoolean(strArr[2])) {
                            contentValues.put("message_type", (Integer) 2);
                        } else {
                            contentValues.put("message_type", (Integer) 4);
                        }
                        C1109ag.f3907h.startUpdate(99, null, C0662o.f2289a, contentValues, "message_sever_id = ? ", new String[]{String.valueOf(j)});
                        cursor.close();
                        return;
                    }
                }
            }
            cursor.close();
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo881a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) {
    }
}
