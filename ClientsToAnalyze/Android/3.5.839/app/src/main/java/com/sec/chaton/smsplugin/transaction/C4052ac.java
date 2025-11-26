package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Messenger;
import android.provider.Telephony;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.util.C4822an;
import com.sec.google.android.p134a.C5111c;

/* compiled from: SmsMessageSender.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.transaction.ac */
/* loaded from: classes.dex */
public class C4052ac implements InterfaceC4075k {

    /* renamed from: l */
    private static final String[] f14611l = {"reply_path_present", "service_center"};

    /* renamed from: a */
    private final String[] f14612a;

    /* renamed from: b */
    private long f14613b;

    /* renamed from: c */
    protected final Context f14614c;

    /* renamed from: d */
    protected final int f14615d;

    /* renamed from: e */
    protected final String f14616e;

    /* renamed from: f */
    protected final String f14617f;

    /* renamed from: g */
    protected final long f14618g;

    /* renamed from: h */
    protected long f14619h;

    /* renamed from: i */
    private long f14620i;

    /* renamed from: j */
    private boolean f14621j;

    /* renamed from: k */
    private int f14622k;

    /* renamed from: m */
    private Messenger f14623m;

    public C4052ac(Context context, String[] strArr, String str, long j, int i, Messenger messenger) {
        this(context, strArr, str, j);
        this.f14622k = i;
        this.f14623m = messenger;
    }

    public C4052ac(Context context, String[] strArr, String str, long j, long j2) {
        this(context, strArr, str, j);
        this.f14613b = j2;
        this.f14622k = -1;
        this.f14623m = null;
    }

    public C4052ac(Context context, String[] strArr, String str, long j) {
        this.f14613b = 0L;
        this.f14620i = 0L;
        this.f14621j = false;
        this.f14614c = context;
        this.f14616e = str;
        this.f14622k = -1;
        this.f14623m = null;
        if (strArr != null) {
            this.f14615d = strArr.length;
            this.f14612a = new String[this.f14615d];
            System.arraycopy(strArr, 0, this.f14612a, 0, this.f14615d);
        } else {
            this.f14615d = 0;
            this.f14612a = null;
        }
        this.f14619h = System.currentTimeMillis();
        this.f14618g = j;
        this.f14617f = m15604c(this.f14618g);
    }

    /* renamed from: a */
    public void m15605a(boolean z) {
        this.f14621j = z;
    }

    @Override // com.sec.chaton.smsplugin.transaction.InterfaceC4075k
    /* renamed from: a */
    public boolean mo15606a(long j) {
        return m15603b(j);
    }

    /* renamed from: a */
    private void m15600a(long j, long j2) {
        ContentValues contentValues = new ContentValues(2);
        contentValues.put(VKApiConst.GROUP_ID, Long.valueOf(j));
        contentValues.put("group_type", (Integer) 6);
        this.f14614c.getContentResolver().update(Telephony.Sms.CONTENT_URI, contentValues, "_id=" + j, null);
        if (j2 > 0) {
            contentValues.remove("group_type");
            contentValues.put("hidden", (Integer) 1);
            this.f14614c.getContentResolver().update(Telephony.Sms.CONTENT_URI, contentValues, "(group_id=" + j2 + " AND type!=5)", null);
        }
    }

    /* renamed from: b */
    private boolean m15603b(long j) throws Throwable {
        if (this.f14616e == null || this.f14615d == 0) {
            throw new C5111c("Null message body or dest.");
        }
        int i = 0;
        ContentResolver contentResolver = this.f14614c.getContentResolver();
        ContentValues contentValues = new ContentValues();
        if (C3847e.m14679ak()) {
            contentValues.putAll(m15602b(this.f14621j));
            try {
                Uri uriM15599a = m15599a(this.f14614c.getContentResolver(), Uri.parse("content://sms/queued"), this.f14612a[0], this.f14616e, null, Long.valueOf(this.f14619h), true, false, this.f14618g, contentValues);
                if (uriM15599a != null) {
                    this.f14620i = Long.parseLong(uriM15599a.getLastPathSegment());
                }
                contentValues.putAll(m15601b(this.f14620i, 1L));
            } catch (SQLiteException e) {
                SqliteWrapper.checkSQLiteException(this.f14614c, e);
            }
            if (this.f14615d > 1 || this.f14613b > 0) {
                m15600a(this.f14620i, this.f14613b);
            }
            i = 1;
        }
        while (true) {
            int i2 = i;
            if (i2 >= this.f14615d) {
                break;
            }
            try {
                if (C3847e.m14679ak()) {
                    m15599a(this.f14614c.getContentResolver(), Uri.parse("content://sms/queued"), this.f14612a[i2], this.f14616e, null, Long.valueOf(this.f14619h), true, false, this.f14618g, contentValues);
                } else {
                    Telephony.Sms.addMessageToUri(contentResolver, Uri.parse("content://sms/queued"), this.f14612a[i2], this.f14616e, null, Long.valueOf(this.f14619h), true, false, this.f14618g);
                }
            } catch (SQLiteException e2) {
                SqliteWrapper.checkSQLiteException(this.f14614c, e2);
            }
            i = i2 + 1;
        }
        if (C4822an.m18203M()) {
            C3947e.m15254a(this.f14614c, contentResolver, this.f14618g, false, false);
        }
        Intent intent = new Intent("com.sec.chaton.smsplugin.transaction.SEND_MESSAGE", null, this.f14614c, SmsReceiver.class);
        intent.putExtra("extra_bg_token", this.f14622k);
        intent.putExtra("extra_bg_cb_messenger", this.f14623m);
        this.f14614c.sendBroadcast(intent);
        return false;
    }

    /* renamed from: b */
    private static ContentValues m15601b(long j, long j2) {
        ContentValues contentValues = new ContentValues(3);
        contentValues.put(VKApiConst.GROUP_ID, Long.valueOf(j));
        contentValues.put("hidden", Long.valueOf(j2));
        return contentValues;
    }

    /* renamed from: b */
    private static ContentValues m15602b(boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("locked", Boolean.valueOf(z));
        return contentValues;
    }

    /* renamed from: a */
    private static Uri m15599a(ContentResolver contentResolver, Uri uri, String str, String str2, String str3, Long l, boolean z, boolean z2, long j, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues(7);
        contentValues2.put("address", str);
        contentValues2.put("body", str2);
        contentValues2.put("subject", str3);
        if (l != null) {
            contentValues2.put("date", l);
        }
        contentValues2.put("read", z ? 1 : 0);
        if (z2) {
            contentValues2.put("status", (Integer) 32);
        }
        if (j != -1) {
            contentValues2.put("thread_id", Long.valueOf(j));
        }
        if (contentValues != null) {
            contentValues2.putAll(contentValues);
        }
        return contentResolver.insert(uri, contentValues2);
    }

    /* renamed from: c */
    private String m15604c(long j) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = SqliteWrapper.query(this.f14614c, this.f14614c.getContentResolver(), Telephony.Sms.CONTENT_URI, f14611l, "thread_id = " + j, (String[]) null, "date DESC");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = 1 == cursorQuery.getInt(0) ? cursorQuery.getString(1) : null;
                        if (cursorQuery == null) {
                            return string;
                        }
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
