package com.sec.chaton.account;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.p026a.C0621a;
import com.sec.chaton.p033io.entry.inner.Buddy;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ContactManager.java */
/* renamed from: com.sec.chaton.account.h */
/* loaded from: classes.dex */
public class C0239h {
    /* renamed from: a */
    public static long m905a(long j) {
        long j2;
        Cursor cursorQuery = GlobalApplication.m3100a().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, null, String.valueOf(j) + " = _id", null, null);
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
    public static void m907a(Context context, ArrayList arrayList) {
        new Thread(new RunnableC0238g(context, arrayList)).start();
    }

    /* renamed from: b */
    static synchronized void m910b(Context context, ArrayList arrayList) {
        C0232a c0232a = new C0232a(context, context.getContentResolver());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Buddy buddy = (Buddy) it.next();
            if (buddy.deleted.booleanValue()) {
                c0232a.m895a(C0233b.m900a(buddy.value));
            } else if (buddy.showphonenumber == null || !buddy.showphonenumber.booleanValue()) {
                C1341p.m4662e(buddy.value + " will not be synced because showphonenumber=" + buddy.showphonenumber, "ContactManager");
            } else {
                if (m906a(buddy.value) > 0) {
                    C1341p.m4662e(buddy.value + ", Account Info Already Inserted", "ContactManager");
                } else {
                    long jM2839b = C0621a.m2839b(buddy.orgnum);
                    C1341p.m4662e(buddy.value + ", OrgNumber : " + buddy.orgnum + ", RawID : " + jM2839b, "ContactManager");
                    if (jM2839b > 0) {
                        String strM2838a = C0621a.m2838a(buddy.orgnum);
                        C1341p.m4662e("Name : " + strM2838a, C0239h.class.getSimpleName());
                        if (strM2838a != null) {
                            int iM894a = c0232a.m894a();
                            c0232a.m895a(C0233b.m898a(buddy));
                            c0232a.m895a(C0233b.m897a(iM894a, strM2838a));
                            c0232a.m895a(C0233b.m899a(buddy, iM894a));
                        }
                    }
                }
                if (c0232a.m894a() > 300) {
                    c0232a.m896b();
                }
            }
        }
        c0232a.m896b();
    }

    /* renamed from: a */
    public static long m906a(String str) {
        long j;
        Cursor cursorQuery = GlobalApplication.m3100a().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, InterfaceC0240i.f584a, "account_type='com.sec.chaton' AND sync1=? AND deleted=0", new String[]{str}, null);
        if (!cursorQuery.moveToFirst()) {
            j = 0;
        } else {
            j = cursorQuery.getLong(0);
        }
        cursorQuery.close();
        return j;
    }

    /* renamed from: b */
    public static void m911b(String str) {
        m909a(false, str);
    }

    /* renamed from: a */
    public static void m908a(boolean z) {
        m909a(z, (String) null);
    }

    /* renamed from: a */
    private static void m909a(boolean z, String str) {
        String string = C1323bs.m4575a().getString("msisdn", "");
        if (string == null || string.trim().equals("")) {
            C1341p.m4658b("requestSync. msisdn is empty. ignore sync operation", "ContactManager");
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

    /* renamed from: a */
    public static int m904a() {
        String string = C1323bs.m4575a().getString("msisdn", null);
        C1341p.m4658b("RawContacts Upgrade ACCOUNT_NAME " + string, "ContactManager");
        if (string == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("account_name", string);
        int iUpdate = GlobalApplication.m3100a().getContentResolver().update(ContactsContract.RawContacts.CONTENT_URI, contentValues, "account_type=?", new String[]{"com.sec.chaton"});
        C1341p.m4658b("RawContacts Upgrade result=" + iUpdate, "ContactManager");
        return iUpdate;
    }
}
