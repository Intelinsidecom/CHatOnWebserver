package com.sec.chaton.account;

import android.content.ContentProviderOperation;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: ContactOperation.java */
/* renamed from: com.sec.chaton.account.k */
/* loaded from: classes.dex */
public class C0425k {
    /* renamed from: a */
    private static Uri m3057a(Uri uri) {
        return uri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3055a(Buddy buddy, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("insertContact() syncKey = " + str + ", buddy.value = " + buddy.value, "ContactOperation");
        }
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(m3057a(ContactsContract.RawContacts.CONTENT_URI));
        builderNewInsert.withValue("account_type", "com.sec.chaton");
        builderNewInsert.withValue("account_name", str);
        builderNewInsert.withValue("sync1", buddy.value);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3054a(Buddy buddy, int i, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("insertProfileAction() buddy.value = " + buddy.value + ", rawContactId = " + i + ", orgnum = " + str, "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m3057a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(false);
        builderWithYieldAllowed.withValue("data1", buddy.value);
        builderWithYieldAllowed.withValue("data2", "ChatON");
        builderWithYieldAllowed.withValue("data3", CommonApplication.m11493l().getResources().getString(R.string.menu_button_start_chat));
        builderWithYieldAllowed.withValue("data4", str);
        if (!TextUtils.isEmpty(buddy.samsungemail)) {
            builderWithYieldAllowed.withValue("data5", buddy.samsungemail);
        }
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        builderWithYieldAllowed.withValue("mimetype", "vnd.chaton.item/vnd.com.chaton.profile");
        return builderWithYieldAllowed.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m3058b(Buddy buddy, int i, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("insertProfileAction2() buddy.value = " + buddy.value + ", rawContactId = " + i + ", orgnum = " + str, "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m3057a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(false);
        builderWithYieldAllowed.withValue("data1", buddy.sainfo);
        builderWithYieldAllowed.withValue("data2", buddy.value);
        builderWithYieldAllowed.withValue("data3", CommonApplication.m11493l().getResources().getString(R.string.chaton_voice_video_chat));
        builderWithYieldAllowed.withValue("data4", str);
        if (!TextUtils.isEmpty(buddy.samsungemail)) {
            builderWithYieldAllowed.withValue("data5", buddy.samsungemail);
        }
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        builderWithYieldAllowed.withValue("mimetype", "vnd.vapp.item/vnd.com.app.account");
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3053a(int i, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("insertContactName() rawID = " + i + ", buddyName = " + str, "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m3057a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withValue("data2", str);
        builderWithYieldAllowed.withValue("mimetype", "vnd.android.cursor.item/name");
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3056a(String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("deleteContact() buddyNO = " + str, "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newDelete(m3057a(ContactsContract.RawContacts.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withSelection("account_type='com.sec.chaton' AND sync1=?", new String[]{str});
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3052a() {
        if (C3250y.f11734b) {
            C3250y.m11450b("deleteAllChatONIconInContact() with ChatONConst.ACCOUNT_TYPE = com.sec.chaton", "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newDelete(m3057a(ContactsContract.RawContacts.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withSelection("account_type=?", new String[]{"com.sec.chaton"});
        return builderWithYieldAllowed.build();
    }

    /* renamed from: b */
    public static void m3059b() {
        if (C3250y.f11734b) {
            C3250y.m11450b("deleteAllChatONIcon() with ChatONConst.ACCOUNT_TYPE = com.sec.chaton", "ContactOperation");
        }
        C0415a c0415a = new C0415a(CommonApplication.m11493l(), CommonApplication.m11493l().getContentResolver());
        c0415a.m3024a(m3052a());
        c0415a.m3025b();
    }

    /* renamed from: b */
    public static void m3060b(String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("deleteChatONIconByBuddyNo() with buddyNO = " + str, "ContactOperation");
        }
        C0415a c0415a = new C0415a(CommonApplication.m11493l(), CommonApplication.m11493l().getContentResolver());
        c0415a.m3024a(m3056a(str));
        c0415a.m3025b();
    }

    /* renamed from: c */
    public static ContentProviderOperation m3061c() {
        if (C3250y.f11734b) {
            C3250y.m11450b("deleteAllChatONVInfoInContact() with ChatONConst.ACCOUNT_TYPE = com.sec.chaton", "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newDelete(m3057a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withSelection("account_type='com.sec.chaton' AND mimetype='vnd.vapp.item/vnd.com.app.account'", null);
        return builderWithYieldAllowed.build();
    }

    /* renamed from: d */
    public static void m3062d() {
        if (C3250y.f11734b) {
            C3250y.m11450b("deleteAllChatONVInfo() with ChatONConst.ACCOUNT_TYPE = com.sec.chaton", "ContactOperation");
        }
        C0415a c0415a = new C0415a(CommonApplication.m11493l(), CommonApplication.m11493l().getContentResolver());
        c0415a.m3024a(m3061c());
        c0415a.m3025b();
    }
}
