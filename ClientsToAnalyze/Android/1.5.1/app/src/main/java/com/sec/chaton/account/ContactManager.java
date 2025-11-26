package com.sec.chaton.account;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.sec.chaton.database.helper.ContactDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p000io.entry.inner.Buddy;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ContactManager {
    /* renamed from: a */
    public static long m402a(String str) {
        Cursor cursorQuery = GlobalApplication.m2387e().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, InterfaceC0069f.f339a, "account_type='com.sec.chaton' AND sync1=? AND deleted=0", new String[]{str}, null);
        long j = cursorQuery.moveToFirst() ? cursorQuery.getLong(0) : 0L;
        cursorQuery.close();
        return j;
    }

    /* renamed from: a */
    public static void m403a() {
        m405a(false);
    }

    /* renamed from: a */
    public static void m404a(Context context, ArrayList arrayList) {
        new Thread(new ContactAccountTask(context, arrayList)).start();
    }

    /* renamed from: a */
    public static void m405a(boolean z) {
        Account account = new Account(ChatONPref.m3519a().getString("msisdn", ""), "com.sec.chaton");
        Bundle bundle = new Bundle();
        bundle.putBoolean("force", z);
        ContentResolver.requestSync(account, "com.android.contacts", bundle);
    }

    /* renamed from: b */
    static synchronized void m406b(Context context, ArrayList arrayList) {
        BatchOperation batchOperation = new BatchOperation(context, context.getContentResolver());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Buddy buddy = (Buddy) it.next();
            if (buddy.deleted.booleanValue()) {
                batchOperation.m397a(ContactOperation.m410a(buddy.value));
            } else if (buddy.showphonenumber == null || buddy.showphonenumber.booleanValue()) {
                if (m402a(buddy.value) > 0) {
                    ChatONLogWriter.m3511e(buddy.value + ", Account Info Already Inserted", "ContactManager");
                } else {
                    long jM2237b = ContactDatabaseHelper.m2237b(buddy.orgnum);
                    ChatONLogWriter.m3511e(buddy.value + ", OrgNumber : " + buddy.orgnum + ", RawID : " + jM2237b, "ContactManager");
                    if (jM2237b > 0) {
                        String strM2236a = ContactDatabaseHelper.m2236a(buddy.orgnum);
                        ChatONLogWriter.m3511e("Name : " + strM2236a, ContactManager.class.getSimpleName());
                        if (strM2236a != null) {
                            int iM396a = batchOperation.m396a();
                            batchOperation.m397a(ContactOperation.m409a(buddy, buddy.value));
                            batchOperation.m397a(ContactOperation.m407a(iM396a, strM2236a));
                            batchOperation.m397a(ContactOperation.m408a(buddy, iM396a));
                        }
                    }
                }
                if (batchOperation.m396a() > 50) {
                    batchOperation.m398b();
                }
            } else {
                ChatONLogWriter.m3511e(buddy.value + " will not be synced because showphonenumber=" + buddy.showphonenumber, "ContactManager");
            }
        }
        batchOperation.m398b();
    }
}
