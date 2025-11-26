package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.database.Cursor;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1597be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ long f6102a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f6103b;

    DialogInterfaceOnClickListenerC1597be(ChatFragment chatFragment, long j) {
        this.f6103b = chatFragment;
        this.f6102a = j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2306z.f8229a, null, "_id=?", new String[]{String.valueOf(this.f6102a)}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("message_content"));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("message_inbox_no"));
            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("message_formatted"));
            this.f6103b.m7903a(null, j, string, string2, cursorQuery.getString(cursorQuery.getColumnIndex("message_download_uri")), EnumC2214ab.m10070a(cursorQuery.getInt(cursorQuery.getColumnIndex("message_content_type"))), string3, cursorQuery.getInt(cursorQuery.getColumnIndex("message_is_file_upload")));
        } else {
            C4904y.m18634a("showNonWebUserDetecedPopup - cursor is null", getClass().getSimpleName());
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }
}
