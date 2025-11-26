package com.sec.chaton.account;

import android.content.ContentProviderOperation;
import android.net.Uri;
import android.provider.ContactsContract;
import com.sec.chaton.p000io.entry.inner.Buddy;

/* loaded from: classes.dex */
public class ContactOperation {
    /* renamed from: a */
    public static ContentProviderOperation m407a(int i, String str) {
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m411a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withValue("data2", str);
        builderWithYieldAllowed.withValue("mimetype", "vnd.android.cursor.item/name");
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m408a(Buddy buddy, int i) {
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m411a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(false);
        builderWithYieldAllowed.withValue("data1", buddy.value);
        builderWithYieldAllowed.withValue("data2", "ChatON");
        builderWithYieldAllowed.withValue("data3", buddy.value);
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        builderWithYieldAllowed.withValue("mimetype", "vnd.chaton.item/vnd.com.chaton.profile");
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m409a(Buddy buddy, String str) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(m411a(ContactsContract.RawContacts.CONTENT_URI));
        builderNewInsert.withValue("account_type", "com.sec.chaton");
        builderNewInsert.withValue("account_name", str);
        builderNewInsert.withValue("sync1", str);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m410a(String str) {
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newDelete(m411a(ContactsContract.RawContacts.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withSelection("account_type='com.sec.chaton' AND account_name=?", new String[]{str});
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    private static Uri m411a(Uri uri) {
        return uri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
    }
}
