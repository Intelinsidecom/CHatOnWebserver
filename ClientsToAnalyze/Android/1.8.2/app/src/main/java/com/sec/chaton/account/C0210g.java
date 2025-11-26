package com.sec.chaton.account;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.p018a.C0659c;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ContactManager.java */
/* renamed from: com.sec.chaton.account.g */
/* loaded from: classes.dex */
public class C0210g {
    /* renamed from: a */
    public static long m1807a(long j) {
        long j2;
        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, null, String.valueOf(j) + " = _id", null, null);
        if (cursorQuery == null) {
            return 0L;
        }
        if (!cursorQuery.moveToFirst()) {
            j2 = 0;
        } else {
            j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("contact_id"));
        }
        cursorQuery.close();
        return j2;
    }

    /* renamed from: a */
    public static void m1810a(Context context, ArrayList arrayList) {
        new Thread(new RunnableC0209f(context, arrayList)).start();
    }

    /* renamed from: b */
    static synchronized void m1814b(Context context, ArrayList arrayList) {
        C0204a c0204a = new C0204a(context, context.getContentResolver());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Buddy buddy = (Buddy) it.next();
            if (buddy.deleted.booleanValue()) {
                c0204a.m1803a(C0212i.m1819a(buddy.value));
            } else if (buddy.showphonenumber == null || !buddy.showphonenumber.booleanValue()) {
                C1786r.m6066e(buddy.value + " will not be synced because showphonenumber=" + buddy.showphonenumber, "ContactManager");
            } else {
                if (m1808a(buddy.value) > 0) {
                    C1786r.m6066e(buddy.value + ", Account Info Already Inserted", "ContactManager");
                } else {
                    long jM3002b = C0659c.m3002b(buddy.orgnum);
                    C1786r.m6066e(buddy.value + ", OrgNumber : " + buddy.orgnum + ", RawID : " + jM3002b, "ContactManager");
                    if (jM3002b > 0) {
                        String strM3001a = C0659c.m3001a(buddy.orgnum);
                        C1786r.m6066e("Name : " + strM3001a, C0210g.class.getSimpleName());
                        if (strM3001a != null) {
                            int iM1802a = c0204a.m1802a();
                            c0204a.m1803a(C0212i.m1817a(buddy));
                            c0204a.m1803a(C0212i.m1816a(iM1802a, strM3001a));
                            c0204a.m1803a(C0212i.m1818a(buddy, iM1802a));
                        }
                    }
                }
                if (c0204a.m1802a() > 300) {
                    c0204a.m1804b();
                }
            }
        }
        c0204a.m1804b();
    }

    /* renamed from: a */
    public static long m1808a(String str) {
        long j;
        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, InterfaceC0211h.f747a, "account_type='com.sec.chaton' AND sync1=? AND deleted=0", new String[]{str}, null);
        if (!cursorQuery.moveToFirst()) {
            j = 0;
        } else {
            j = cursorQuery.getLong(0);
        }
        cursorQuery.close();
        return j;
    }

    /* renamed from: b */
    public static void m1815b(String str) {
        m1812a(false, str);
    }

    /* renamed from: a */
    public static void m1809a() {
        m1812a(false, (String) null);
    }

    /* renamed from: a */
    public static void m1811a(boolean z) {
        m1812a(z, (String) null);
    }

    /* renamed from: a */
    private static void m1812a(boolean z, String str) {
        String string = C1789u.m6075a().getString("msisdn", "");
        if (string == null || string.trim().equals("")) {
            C1786r.m6061b("requestSync. msisdn is empty. ignore sync operation", "ContactManager");
            return;
        }
        Account account = new Account(string, "com.sec.chaton");
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putBoolean("force", z);
        }
        if (str != null) {
            bundle.putBoolean(str, true);
        }
        ContentResolver.requestSync(account, "com.android.contacts", bundle);
    }

    /* renamed from: b */
    public static int m1813b() {
        String string = C1789u.m6075a().getString("msisdn", null);
        C1786r.m6061b("RawContacts Upgrade ACCOUNT_NAME " + string, "ContactManager");
        if (string == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("account_name", string);
        int iUpdate = GlobalApplication.m3260b().getContentResolver().update(ContactsContract.RawContacts.CONTENT_URI, contentValues, "account_type=?", new String[]{"com.sec.chaton"});
        C1786r.m6061b("RawContacts Upgrade result=" + iUpdate, "ContactManager");
        return iUpdate;
    }
}
