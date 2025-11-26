package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.database.Cursor;
import android.view.View;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0934al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ long f3879a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f3880b;

    DialogInterfaceOnClickListenerC0934al(ChatFragment chatFragment, long j) {
        this.f3880b = chatFragment;
        this.f3879a = j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1454v.f5393a, null, "_id=?", new String[]{String.valueOf(this.f3879a)}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            this.f3880b.m4745a((View) null, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")), cursorQuery.getString(cursorQuery.getColumnIndex("message_content")), cursorQuery.getString(cursorQuery.getColumnIndex("message_inbox_no")), cursorQuery.getString(cursorQuery.getColumnIndex("message_download_uri")), EnumC1455w.m6358a(cursorQuery.getInt(cursorQuery.getColumnIndex("message_content_type"))), cursorQuery.getString(cursorQuery.getColumnIndex("message_formatted")), cursorQuery.getInt(cursorQuery.getColumnIndex("message_is_file_upload")));
        } else {
            C3250y.m11442a("showNonWebUserDetecedPopup - cursor is null", getClass().getSimpleName());
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }
}
