package com.sec.chaton.account;

import android.content.ContentProviderOperation;
import android.net.Uri;
import android.provider.ContactsContract;
import com.sec.chaton.p033io.entry.inner.Buddy;
import com.sec.chaton.util.C1323bs;

/* compiled from: ContactOperation.java */
/* renamed from: com.sec.chaton.account.b */
/* loaded from: classes.dex */
public class C0233b {
    /* renamed from: a */
    private static Uri m901a(Uri uri) {
        return uri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m898a(Buddy buddy) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(m901a(ContactsContract.RawContacts.CONTENT_URI));
        builderNewInsert.withValue("account_type", "com.sec.chaton");
        builderNewInsert.withValue("account_name", C1323bs.m4575a().getString("msisdn", ""));
        builderNewInsert.withValue("sync1", buddy.value);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m899a(Buddy buddy, int i) {
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m901a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(false);
        builderWithYieldAllowed.withValue("data1", buddy.value);
        builderWithYieldAllowed.withValue("data2", "ChatON");
        builderWithYieldAllowed.withValue("data3", buddy.value);
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        builderWithYieldAllowed.withValue("mimetype", "vnd.chaton.item/vnd.com.chaton.profile");
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m897a(int i, String str) {
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m901a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withValue("data2", str);
        builderWithYieldAllowed.withValue("mimetype", "vnd.android.cursor.item/name");
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m900a(String str) {
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newDelete(m901a(ContactsContract.RawContacts.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withSelection("account_type='com.sec.chaton' AND sync1=?", new String[]{str});
        return builderWithYieldAllowed.build();
    }
}
