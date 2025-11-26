package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.inner.MsgTid;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnXmlParser;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SetReadMessage extends AbstractHttpTask2 {

    /* renamed from: c */
    private static String[] f1670c = {"_id", "message_tid", "message_inbox_no"};

    /* renamed from: d */
    private static String f1671d = "message_inbox_no=? AND message_tid IS NOT NULL";

    /* renamed from: a */
    private String f1672a;

    /* renamed from: b */
    private ContentResolver f1673b;

    public SetReadMessage(Handler handler, HttpEnvelope httpEnvelope, String str) {
        super(handler, httpEnvelope);
        this.f1672a = str;
        this.f1673b = GlobalApplication.m2387e().getContentResolver();
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.putNull("message_tid");
        this.f1673b.update(ChatONContract.MessageTable.f1726a, contentValues, "message_inbox_no=?", new String[]{this.f1672a});
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = this.f1673b.query(ChatONContract.MessageTable.f1726a, f1670c, f1671d, new String[]{this.f1672a}, null);
        while (cursorQuery.moveToNext()) {
            MsgTid msgTid = new MsgTid();
            msgTid.value = cursorQuery.getString(1);
            arrayList.add(msgTid);
        }
        cursorQuery.close();
        if (arrayList.size() == 0) {
            interrupt();
        }
        String strM3552a = new ChatOnXmlParser().m3552a(arrayList);
        ChatONLogWriter.m3511e(strM3552a, getClass().getSimpleName());
        return strM3552a;
    }
}
