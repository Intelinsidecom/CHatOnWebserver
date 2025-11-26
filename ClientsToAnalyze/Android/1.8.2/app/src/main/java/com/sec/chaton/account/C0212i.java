package com.sec.chaton.account;

import android.content.ContentProviderOperation;
import android.net.Uri;
import android.provider.ContactsContract;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.util.C1789u;

/* compiled from: ContactOperation.java */
/* renamed from: com.sec.chaton.account.i */
/* loaded from: classes.dex */
public class C0212i {
    /* renamed from: a */
    private static Uri m1820a(Uri uri) {
        return uri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m1817a(Buddy buddy) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(m1820a(ContactsContract.RawContacts.CONTENT_URI));
        builderNewInsert.withValue("account_type", "com.sec.chaton");
        builderNewInsert.withValue("account_name", C1789u.m6075a().getString("msisdn", ""));
        builderNewInsert.withValue("sync1", buddy.value);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m1818a(Buddy buddy, int i) {
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m1820a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(false);
        builderWithYieldAllowed.withValue("data1", buddy.value);
        builderWithYieldAllowed.withValue("data2", "ChatON");
        builderWithYieldAllowed.withValue("data3", buddy.value);
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        builderWithYieldAllowed.withValue("mimetype", "vnd.chaton.item/vnd.com.chaton.profile");
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m1816a(int i, String str) {
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m1820a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withValue("data2", str);
        builderWithYieldAllowed.withValue("mimetype", "vnd.android.cursor.item/name");
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m1819a(String str) {
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newDelete(m1820a(ContactsContract.RawContacts.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withSelection("account_type='com.sec.chaton' AND sync1=?", new String[]{str});
        return builderWithYieldAllowed.build();
    }
}
