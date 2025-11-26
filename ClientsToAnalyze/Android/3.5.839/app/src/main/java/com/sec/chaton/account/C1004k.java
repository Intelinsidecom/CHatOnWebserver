package com.sec.chaton.account;

import android.content.ContentProviderOperation;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;

/* compiled from: ContactOperation.java */
/* renamed from: com.sec.chaton.account.k */
/* loaded from: classes.dex */
public class C1004k {
    /* renamed from: a */
    private static Uri m6079a(Uri uri) {
        return uri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6077a(Buddy buddy, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("insertContact() syncKey = " + str + ", buddy.value = " + buddy.value, "ContactOperation");
        }
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(m6079a(ContactsContract.RawContacts.CONTENT_URI));
        builderNewInsert.withValue("account_type", Config.CHATON_PACKAGE_NAME);
        builderNewInsert.withValue("account_name", str);
        builderNewInsert.withValue("sync1", buddy.value);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6076a(Buddy buddy, int i, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("insertProfileAction() buddy.value = " + buddy.value + ", rawContactId = " + i + ", orgnum = " + str, "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m6079a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(false);
        builderWithYieldAllowed.withValue("data1", buddy.value);
        builderWithYieldAllowed.withValue("data2", "ChatON");
        builderWithYieldAllowed.withValue("data3", CommonApplication.m18732r().getResources().getString(R.string.menu_button_start_chat));
        builderWithYieldAllowed.withValue("data4", str);
        if (!TextUtils.isEmpty(buddy.samsungemail)) {
            builderWithYieldAllowed.withValue("data5", buddy.samsungemail);
        }
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        builderWithYieldAllowed.withValue("mimetype", "vnd.chaton.item/vnd.com.chaton.profile");
        return builderWithYieldAllowed.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m6080b(Buddy buddy, int i, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("insertProfileAction2() buddy.value = " + buddy.value + ", rawContactId = " + i + ", orgnum = " + str, "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m6079a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(false);
        builderWithYieldAllowed.withValue("data1", buddy.sainfo);
        builderWithYieldAllowed.withValue("data2", buddy.value);
        builderWithYieldAllowed.withValue("data3", CommonApplication.m18732r().getResources().getString(R.string.chaton_voice_video_chat));
        builderWithYieldAllowed.withValue("data4", str);
        if (!TextUtils.isEmpty(buddy.samsungemail)) {
            builderWithYieldAllowed.withValue("data5", buddy.samsungemail);
        }
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        builderWithYieldAllowed.withValue("mimetype", "vnd.vapp.item/vnd.com.app.account");
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6075a(int i, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("insertContactName() rawID = " + i + ", buddyName = " + str, "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newInsert(m6079a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withValue("data2", str);
        builderWithYieldAllowed.withValue("mimetype", "vnd.android.cursor.item/name");
        builderWithYieldAllowed.withValueBackReference("raw_contact_id", i);
        return builderWithYieldAllowed.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6078a(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("deleteContact() buddyNO = " + str, "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newDelete(m6079a(ContactsContract.RawContacts.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withSelection("account_type='com.sec.chaton' AND sync1=?", new String[]{str});
        return builderWithYieldAllowed.build();
    }

    /* renamed from: b */
    public static void m6082b(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("deleteChatONIconByBuddyNo() with buddyNO = " + str, "ContactOperation");
        }
        C0994a c0994a = new C0994a(CommonApplication.m18732r(), CommonApplication.m18732r().getContentResolver());
        c0994a.m6042a(m6078a(str));
        c0994a.m6043b();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6074a() {
        if (C4904y.f17872b) {
            C4904y.m18639b("deleteAllChatONVInfoInContact() with ChatONConst.ACCOUNT_TYPE = com.sec.chaton", "ContactOperation");
        }
        ContentProviderOperation.Builder builderWithYieldAllowed = ContentProviderOperation.newDelete(m6079a(ContactsContract.Data.CONTENT_URI)).withYieldAllowed(true);
        builderWithYieldAllowed.withSelection("account_type='com.sec.chaton' AND mimetype='vnd.vapp.item/vnd.com.app.account'", null);
        return builderWithYieldAllowed.build();
    }

    /* renamed from: b */
    public static void m6081b() {
        if (C4904y.f17872b) {
            C4904y.m18639b("deleteAllChatONVInfo() with ChatONConst.ACCOUNT_TYPE = com.sec.chaton", "ContactOperation");
        }
        C0994a c0994a = new C0994a(CommonApplication.m18732r(), CommonApplication.m18732r().getContentResolver());
        c0994a.m6042a(m6074a());
        c0994a.m6043b();
    }
}
