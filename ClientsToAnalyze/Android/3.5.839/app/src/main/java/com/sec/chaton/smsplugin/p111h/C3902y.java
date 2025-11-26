package com.sec.chaton.smsplugin.p111h;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p112ui.C4149cd;

/* compiled from: Recycler.java */
/* renamed from: com.sec.chaton.smsplugin.h.y */
/* loaded from: classes.dex */
public class C3902y extends AbstractC3900w {

    /* renamed from: a */
    private static final String[] f14018a = {"thread_id", "msg_count"};

    /* renamed from: b */
    private static final String[] f14019b = {"_id", "thread_id", "address", "body", "date", "read", "type", "status"};

    /* renamed from: c */
    private static final String[] f14020c = {"_id", "'sms' as type", "date", "locked", VKApiConst.GROUP_ID};

    @Override // com.sec.chaton.smsplugin.p111h.AbstractC3900w
    /* renamed from: b */
    public int mo15070b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("MaxSmsMessagesPerThread", C3847e.m14710p());
    }

    @Override // com.sec.chaton.smsplugin.p111h.AbstractC3900w
    /* renamed from: a */
    protected void mo15069a(Context context, long j, int i) throws Throwable {
        Cursor cursor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Cursor cursorQuery = C3847e.m14679ak() ? SqliteWrapper.query(context, contentResolver, ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, j), f14020c, "locked=0 AND hidden=0) UNION  select DISTINCT _id,'mms' as type, date * 1000 AS date , locked, 'group_id' from pdu where _id not in ( SELECT mid FROM part WHERE ct != 'application/smil' AND ct != 'text/plain' )  AND thread_id= " + j + " AND (locked = 0 ", (String[]) null, "date DESC") : SqliteWrapper.query(context, contentResolver, ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, j), f14019b, "locked=0 AND hidden=0", (String[]) null, "date DESC");
            try {
                if (cursorQuery == null) {
                    C3890m.m14999e("Recycler", "SMS: deleteMessagesForThread got back null cursor");
                    if (cursorQuery == null) {
                        return;
                    }
                } else {
                    if (C3847e.m14679ak()) {
                        cursorQuery.moveToFirst();
                    }
                    int count = cursorQuery.getCount() - i;
                    if (count > 0) {
                        cursorQuery.move(i);
                        if (C3847e.m14679ak()) {
                            long jDelete = 0;
                            while (true) {
                                if (!cursorQuery.isAfterLast()) {
                                    String string = cursorQuery.getString(1);
                                    if (string.equals("mms")) {
                                        jDelete += SqliteWrapper.delete(context, contentResolver, Telephony.Mms.CONTENT_URI, "locked=0 AND _id =" + cursorQuery.getString(0), (String[]) null);
                                    } else if (string.equals("sms")) {
                                        jDelete += SqliteWrapper.delete(context, contentResolver, new Long(cursorQuery.getString(0)).longValue() == cursorQuery.getLong(cursorQuery.getColumnIndex(VKApiConst.GROUP_ID)) ? ContentUris.withAppendedId(C4149cd.f15441b, cursorQuery.getLong(cursorQuery.getColumnIndex(VKApiConst.GROUP_ID))) : ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, new Long(cursorQuery.getString(0)).longValue()), "locked=0", (String[]) null);
                                    }
                                    if (jDelete > 0 && jDelete >= count) {
                                        C3890m.m14994a("Recycler", "break");
                                        break;
                                    }
                                    cursorQuery.moveToNext();
                                } else {
                                    break;
                                }
                            }
                        } else {
                            SqliteWrapper.delete(context, contentResolver, ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, j), "locked=0 AND date<" + cursorQuery.getLong(4), (String[]) null);
                        }
                        if (cursorQuery == null) {
                            return;
                        }
                    } else if (cursorQuery == null) {
                        return;
                    }
                }
                cursorQuery.close();
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }
}
