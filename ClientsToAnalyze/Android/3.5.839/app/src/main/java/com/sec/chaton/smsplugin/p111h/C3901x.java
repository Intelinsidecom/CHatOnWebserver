package com.sec.chaton.smsplugin.p111h;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import com.sec.chaton.smsplugin.C3847e;

/* compiled from: Recycler.java */
/* renamed from: com.sec.chaton.smsplugin.h.x */
/* loaded from: classes.dex */
public class C3901x extends AbstractC3900w {

    /* renamed from: a */
    private static final String[] f14016a = {"thread_id", "count(*) as msg_count"};

    /* renamed from: b */
    private static final String[] f14017b = {"_id", "thread_id", "date"};

    @Override // com.sec.chaton.smsplugin.p111h.AbstractC3900w
    /* renamed from: b */
    public int mo15070b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("MaxMmsMessagesPerThread", C3847e.m14711q());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m15072a(Context context, Uri uri) throws Throwable {
        Cursor cursorQuery;
        if (!m15066a(context)) {
            return;
        }
        try {
            cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, f14017b, "thread_id in (select thread_id from pdu where _id=" + uri.getLastPathSegment() + ") AND locked=0", (String[]) null, "date DESC");
            try {
                if (cursorQuery == 0) {
                    C3890m.m14999e("Recycler", "MMS: deleteOldMessagesInSameThreadAsMessage got back null cursor");
                    cursorQuery = cursorQuery;
                    if (cursorQuery != 0) {
                        cursorQuery.close();
                        cursorQuery = cursorQuery;
                    }
                } else {
                    int count = cursorQuery.getCount();
                    int iMo15070b = mo15070b(context);
                    cursorQuery = cursorQuery;
                    if (count - iMo15070b > 0) {
                        cursorQuery.move(iMo15070b);
                        long j = cursorQuery.getLong(2);
                        long j2 = cursorQuery.getLong(1);
                        if (cursorQuery != 0) {
                            cursorQuery.close();
                        }
                        cursorQuery = cursorQuery;
                        if (j2 != 0) {
                            Context context2 = context;
                            m15071a(context2, j2, j);
                            cursorQuery = context2;
                        }
                    } else if (cursorQuery != 0) {
                        cursorQuery.close();
                        cursorQuery = cursorQuery;
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != 0) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.smsplugin.p111h.AbstractC3900w
    /* renamed from: a */
    protected void mo15069a(Context context, long j, int i) throws Throwable {
        Cursor cursorQuery;
        if (j == 0) {
            return;
        }
        try {
            cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, f14017b, "thread_id=" + j + " AND locked=0", (String[]) null, "date DESC");
            try {
                if (cursorQuery == 0) {
                    C3890m.m14999e("Recycler", "MMS: deleteMessagesForThread got back null cursor");
                    cursorQuery = cursorQuery;
                    if (cursorQuery != 0) {
                        cursorQuery.close();
                        cursorQuery = cursorQuery;
                    }
                } else {
                    int count = cursorQuery.getCount() - i;
                    cursorQuery = cursorQuery;
                    if (count > 0) {
                        cursorQuery.move(i);
                        long j2 = cursorQuery.getLong(2);
                        if (cursorQuery != 0) {
                            cursorQuery.close();
                        }
                        Context context2 = context;
                        m15071a(context2, j, j2);
                        cursorQuery = context2;
                    } else if (cursorQuery != 0) {
                        cursorQuery.close();
                        cursorQuery = cursorQuery;
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != 0) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = 0;
        }
    }

    /* renamed from: a */
    private void m15071a(Context context, long j, long j2) {
        SqliteWrapper.delete(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, "thread_id=" + j + " AND locked=0 AND date<" + j2, (String[]) null);
    }
}
