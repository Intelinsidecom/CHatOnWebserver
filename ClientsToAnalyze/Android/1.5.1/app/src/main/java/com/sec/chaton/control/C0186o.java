package com.sec.chaton.control;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.o */
/* loaded from: classes.dex */
class C0186o implements NotifyingAsyncQueryHandler.AsyncQueryListener {

    /* renamed from: a */
    final /* synthetic */ MessageControl f1435a;

    C0186o(MessageControl messageControl) {
        this.f1435a = messageControl;
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo529a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo530a(int i, Object obj, Cursor cursor) {
        if (i != 99 || cursor == null || cursor.getCount() == 0) {
            return;
        }
        while (cursor.moveToNext()) {
            String[] strArr = (String[]) obj;
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            String string = cursor.getString(cursor.getColumnIndex("message_content"));
            if (string != null) {
                String[] strArrSplit = string.split("\n");
                if (strArrSplit.length > 0 && strArrSplit[3].equals(strArr[1])) {
                    ChatONLogWriter.m3506b("[update video]", getClass().getName());
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("message_download_uri", Uri.parse("file://" + strArr[0] + "/" + strArr[1]).toString());
                    contentValues.put("message_stored_ext", (Integer) 1);
                    MessageControl.f1363q.startUpdate(99, null, ChatONContract.MessageTable.f1726a, contentValues, "message_sever_id = ? ", new String[]{String.valueOf(j)});
                    cursor.close();
                    return;
                }
            }
        }
        cursor.close();
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo531a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: b */
    public void mo534b(int i, Object obj, int i2) {
    }
}
