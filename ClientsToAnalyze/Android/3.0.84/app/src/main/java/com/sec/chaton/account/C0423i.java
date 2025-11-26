package com.sec.chaton.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.p028a.C1363g;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: ContactManager.java */
/* renamed from: com.sec.chaton.account.i */
/* loaded from: classes.dex */
public class C0423i {

    /* renamed from: a */
    private static C0045a f1477a = new C0045a();

    /* renamed from: a */
    public static long m3035a(long j) {
        long j2;
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, null, String.valueOf(j) + " = _id", null, null);
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
    public static void m3037a(Context context, ArrayList<Buddy> arrayList) {
        new Thread(new RunnableC0422h(context, arrayList)).start();
    }

    /* renamed from: b */
    static synchronized void m3047b(Context context, ArrayList<Buddy> arrayList) {
        boolean z;
        C0415a c0415a = new C0415a(context, context.getContentResolver());
        Account[] accountsByType = AccountManager.get(CommonApplication.m11493l()).getAccountsByType("com.sec.chaton");
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "raw_contact_id", "data1", "data4"}, "data2='ChatON' ", null, null);
        if (accountsByType.length > 0) {
            String str = accountsByType[0].name;
            C3250y.m11456e("SyncKey name = " + str, "ContactManager");
            Iterator<Buddy> it = arrayList.iterator();
            while (it.hasNext()) {
                Buddy next = it.next();
                if (next.deleted.booleanValue() || next.blocked.booleanValue()) {
                    c0415a.m3024a(C0425k.m3056a(next.value));
                } else {
                    long jM3045b = m3045b(next.value);
                    boolean zM3041a = m3041a(context);
                    if (C1948a.m7903a(context) && zM3041a && next.sainfo != null && !TextUtils.isEmpty(next.sainfo) && !TextUtils.isEmpty(next.einfo) && next.einfo.contains("voip=1")) {
                        C3250y.m11456e("syncContacts() ChatON V available handset. isChatonV = true", "ContactManager");
                        z = true;
                    } else {
                        z = false;
                    }
                    if (jM3045b > 0 && (next.orgnums == null || TextUtils.isEmpty(next.orgnums))) {
                        C3250y.m11456e("orgnums is : " + next.orgnums + " orgnum is " + next.orgnum, C0423i.class.getSimpleName());
                        if (next.orgnum == null || TextUtils.isEmpty(next.orgnum)) {
                            C3250y.m11456e("orgnums is null : buddy.value : " + next.value + " deleted!!", C0423i.class.getSimpleName());
                            c0415a.m3024a(C0425k.m3056a(next.value));
                        } else {
                            if (next.value.equals(next.orgnum.replace("+", "")) && next.value.startsWith("0")) {
                                C3250y.m11456e("orgnums is null : buddy.value : " + next.value + " deleted!!", C0423i.class.getSimpleName());
                                c0415a.m3024a(C0425k.m3056a(next.value));
                            }
                            if (next.orgnum.contains("@")) {
                                C3250y.m11456e("orgnum is email address : buddy.orgnum : " + next.orgnum + " deleted!!", C0423i.class.getSimpleName());
                                c0415a.m3024a(C0425k.m3056a(next.value));
                            }
                        }
                    }
                    if ((jM3045b <= 0 || m3043a(next) || z) && jM3045b != -1) {
                        if (next.orgnums != null && !TextUtils.isEmpty(next.orgnums)) {
                            new ArrayList();
                            List<String> listM3036a = m3036a(next.orgnums);
                            for (int i = 0; i < listM3036a.size(); i++) {
                                if (listM3036a.get(i).length() < 19) {
                                    String strM6083d = C1363g.m6083d(listM3036a.get(i));
                                    if (!TextUtils.isEmpty(strM6083d)) {
                                        boolean zM3042a = m3042a(cursorQuery, strM6083d, next.value);
                                        boolean zM3044a = m3044a(next.value, next.sainfo);
                                        if ((z || !zM3042a) && (!z || !zM3044a)) {
                                            if (zM3042a && z && !zM3044a) {
                                                c0415a.m3024a(C0425k.m3056a(next.value));
                                            }
                                            if (C1363g.m6082c(listM3036a.get(i)) > 0) {
                                                String strM6081b = C1363g.m6081b(listM3036a.get(i));
                                                String strM10979a = C3159aa.m10962a().m10979a("msisdn", "");
                                                if (strM6081b != null) {
                                                    int iM3023a = c0415a.m3023a();
                                                    if (strM10979a != null && !TextUtils.isEmpty(strM10979a) && !strM10979a.trim().equals("")) {
                                                        c0415a.m3024a(C0425k.m3055a(next, str));
                                                        c0415a.m3024a(C0425k.m3053a(iM3023a, strM6081b));
                                                        c0415a.m3024a(C0425k.m3054a(next, iM3023a, strM6083d));
                                                        if (z) {
                                                            c0415a.m3024a(C0425k.m3058b(next, iM3023a, strM6083d));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (next.orgnum != null && !TextUtils.isEmpty(next.orgnum)) {
                            if (next.orgnum.length() < 19) {
                                String strM6083d2 = C1363g.m6083d(next.orgnum);
                                boolean zM3042a2 = m3042a(cursorQuery, strM6083d2, next.value);
                                boolean zM3044a2 = m3044a(next.value, next.sainfo);
                                if (zM3042a2 && z && !zM3044a2) {
                                    c0415a.m3024a(C0425k.m3056a(next.value));
                                } else if (zM3042a2) {
                                }
                                if (C1363g.m6082c(next.orgnum) > 0) {
                                    String strM6081b2 = C1363g.m6081b(next.orgnum);
                                    String strM10979a2 = C3159aa.m10962a().m10979a("msisdn", "");
                                    if (strM6081b2 != null) {
                                        int iM3023a2 = c0415a.m3023a();
                                        if (strM10979a2 != null && !TextUtils.isEmpty(strM10979a2) && !strM10979a2.trim().equals("")) {
                                            if (!zM3042a2) {
                                                c0415a.m3024a(C0425k.m3055a(next, str));
                                                c0415a.m3024a(C0425k.m3053a(iM3023a2, strM6081b2));
                                                c0415a.m3024a(C0425k.m3054a(next, iM3023a2, strM6083d2));
                                            }
                                            if (z) {
                                                c0415a.m3024a(C0425k.m3058b(next, iM3023a2, strM6083d2));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (c0415a.m3023a() > 300) {
                        c0415a.m3025b();
                    }
                }
            }
            if (c0415a.m3023a() > 0) {
                c0415a.m3025b();
            }
            Iterator<Buddy> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Buddy next2 = it2.next();
                if (next2.blocked.booleanValue() || next2.deleted.booleanValue()) {
                    if (next2.orgnum != null && !TextUtils.isEmpty(next2.orgnum)) {
                        m3038a(cursorQuery, C1363g.m6083d(next2.orgnum));
                    } else if (next2.orgnums != null && !TextUtils.isEmpty(next2.orgnums)) {
                        new ArrayList();
                        List<String> listM3036a2 = m3036a(next2.orgnums);
                        for (int i2 = 0; i2 < listM3036a2.size(); i2++) {
                            m3038a(cursorQuery, C1363g.m6083d(listM3036a2.get(i2)));
                        }
                    }
                } else if (next2.status != null && next2.value != null) {
                    if (next2.orgnums != null && !TextUtils.isEmpty(next2.orgnums)) {
                        new ArrayList();
                        List<String> listM3036a3 = m3036a(next2.orgnums);
                        for (int i3 = 0; i3 < listM3036a3.size(); i3++) {
                            m3048b(cursorQuery, C1363g.m6083d(listM3036a3.get(i3)), next2.status);
                        }
                    } else if (next2.orgnum != null && !TextUtils.isEmpty(next2.orgnum)) {
                        m3048b(cursorQuery, C1363g.m6083d(next2.orgnum), next2.status);
                    }
                }
            }
        } else {
            C3250y.m11456e("samsungAccount is not exist ", "ContactManager");
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    /* renamed from: a */
    public static boolean m3043a(Buddy buddy) {
        if ((buddy.value.length() < 19 || !buddy.value.startsWith("10")) && (!buddy.value.startsWith("0") || TextUtils.isEmpty(buddy.msisdns))) {
            return false;
        }
        new ArrayList();
        if (buddy.orgnums == null || TextUtils.isEmpty(buddy.orgnums)) {
            return false;
        }
        Iterator<String> it = m3036a(buddy.orgnums).iterator();
        int i = 0;
        while (it.hasNext()) {
            i = it.next().length() < 19 ? i + 1 : i;
        }
        return i > 1;
    }

    /* renamed from: a */
    public static boolean m3042a(Cursor cursor, String str, String str2) {
        boolean z = false;
        if (cursor != null) {
            try {
                if (cursor.getCount() != 0) {
                    cursor.moveToPosition(-1);
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("data4"));
                        if (string != null && string.equals(str)) {
                            z = true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m3044a(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = 1
            r6 = 0
            boolean r0 = com.sec.chaton.util.C3250y.f11734b
            if (r0 == 0) goto L28
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isAlreadyExistChatONV chatonid = "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r1 = ", sainfo = "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ContactManager"
            com.sec.chaton.util.C3250y.m11450b(r0, r1)
        L28:
            if (r9 == 0) goto L30
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != r7) goto L32
        L30:
            r0 = r6
        L31:
            return r0
        L32:
            android.content.Context r0 = com.sec.common.CommonApplication.m11493l()
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r1 = android.provider.ContactsContract.Data.CONTENT_URI
            java.lang.String[] r2 = new java.lang.String[r7]
            java.lang.String r3 = "data4"
            r2[r6] = r3
            java.lang.String r3 = "data1=? AND data2=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]
            r4[r6] = r9
            r4[r7] = r8
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L5f
            int r0 = r1.getCount()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6c
            if (r0 <= 0) goto L5f
            r0 = r7
        L59:
            if (r1 == 0) goto L31
            r1.close()
            goto L31
        L5f:
            r0 = r6
            goto L59
        L61:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L6a
            r1.close()
        L6a:
            r0 = r6
            goto L31
        L6c:
            r0 = move-exception
            if (r1 == 0) goto L72
            r1.close()
        L72:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.account.C0423i.m3044a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static List<String> m3036a(String str) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    /* renamed from: b */
    public static long m3045b(String str) {
        long j;
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, InterfaceC0424j.f1478a, "account_type='com.sec.chaton' AND sync1=? AND deleted=0", new String[]{str}, null);
        if (cursorQuery != null) {
            if (!cursorQuery.moveToFirst()) {
                j = 0;
            } else {
                j = cursorQuery.getLong(0);
            }
            cursorQuery.close();
            return j;
        }
        return -1L;
    }

    /* renamed from: c */
    public static void m3051c(String str) {
        m3040a(false, str);
    }

    /* renamed from: a */
    public static void m3039a(boolean z) {
        m3040a(z, (String) null);
    }

    /* renamed from: a */
    private static void m3040a(boolean z, String str) {
        Account[] accountsByType = AccountManager.get(CommonApplication.m11493l()).getAccountsByType("com.sec.chaton");
        if (accountsByType.length > 0) {
            Account account = new Account(accountsByType[0].name, "com.sec.chaton");
            Bundle bundle = new Bundle();
            if (z) {
                bundle.putBoolean("force", z);
            }
            if (str != null) {
                bundle.putBoolean(str, true);
            }
            ContentResolver.requestSync(account, "com.android.contacts", bundle);
            return;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("requestSync. ksy is empty. ignore sync operation", "ContactManager");
        }
        m3046b();
    }

    /* renamed from: b */
    private static void m3046b() {
        AccountManager.get(CommonApplication.m11493l());
        if (C3159aa.m10962a().m10987b("uid")) {
            String strM10979a = C3159aa.m10962a().m10979a("msisdn", "");
            String strM10979a2 = C3159aa.m10962a().m10979a("uid", "");
            if (strM10979a != null && !TextUtils.isEmpty(strM10979a) && strM10979a2 != null && !TextUtils.isEmpty(strM10979a2)) {
                m3049b(strM10979a, strM10979a2);
                m3050b(true);
            } else if (C3250y.f11734b) {
                C3250y.m11450b("runRegiAccount. mMSISDN or mUid is empty. ignore sync operation", "ContactManager");
            }
        }
    }

    /* renamed from: b */
    private static void m3049b(String str, String str2) {
        Account account = new Account(str, "com.sec.chaton");
        AccountManager.get(CommonApplication.m11493l()).addAccountExplicitly(account, str2, null);
        ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
    }

    /* renamed from: a */
    public static int m3034a() {
        String strM10979a = C3159aa.m10962a().m10979a("msisdn", (String) null);
        if (strM10979a == null) {
            return -1;
        }
        C3250y.m11450b("RawContacts Upgrade ACCOUNT_NAME " + strM10979a, "ContactManager");
        ContentValues contentValues = new ContentValues();
        contentValues.put("account_name", strM10979a);
        int iUpdate = CommonApplication.m11493l().getContentResolver().update(ContactsContract.RawContacts.CONTENT_URI, contentValues, "account_type=?", new String[]{"com.sec.chaton"});
        C3250y.m11450b("RawContacts Upgrade result=" + iUpdate, "ContactManager");
        return iUpdate;
    }

    /* renamed from: a */
    private static void m3038a(Cursor cursor, String str) {
        C3250y.m11450b("CompareCursor_DeleteStatusMessage() orgNum =" + str, "ContactManager");
        if (cursor != null) {
            cursor.moveToFirst();
            try {
                if (cursor.getCount() > 0 && cursor.getString(cursor.getColumnIndex("data4")).equals(str)) {
                    String string = cursor.getString(0);
                    ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("presence_data_id", string);
                    contentValues.put("status", "");
                    contentResolver.insert(ContactsContract.StatusUpdates.CONTENT_URI, contentValues);
                    CommonApplication.m11493l().getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "_id=?", new String[]{cursor.getString(1)});
                }
            } catch (CursorIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private static void m3048b(Cursor cursor, String str, String str2) {
        String string;
        C3250y.m11450b("CompareCursor_SyncStatusMessage() orgNum =" + str, "ContactManager");
        if (cursor != null && cursor.getCount() > 0) {
            try {
                cursor.moveToPosition(-1);
                while (true) {
                    if (!cursor.moveToNext()) {
                        string = null;
                        break;
                    }
                    string = cursor.getString(0);
                    cursor.getString(1);
                    cursor.getString(2);
                    String string2 = cursor.getString(3);
                    if (string2 != null && string2.equals(str)) {
                        break;
                    }
                }
                if (string != null && !TextUtils.isEmpty(str2)) {
                    ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("presence_data_id", string);
                    contentValues.put("status", str2);
                    contentValues.put("status_res_package", "com.sec.chaton");
                    contentValues.put("status_label", Integer.valueOf(R.string.app_name));
                    contentValues.put("status_icon", Integer.valueOf(R.drawable.chaton_shortcut));
                    contentValues.put("status_ts", Long.valueOf(System.currentTimeMillis()));
                    contentResolver.insert(ContactsContract.StatusUpdates.CONTENT_URI, contentValues);
                }
            } catch (CursorIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static void m3050b(boolean z) {
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        Cursor cursorQuery = contentResolver.query(C1441i.f5369a, null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (z) {
            C3250y.m11453c("Resync contact to Buddy (delete all contact)", "ContactManager");
            contentResolver.delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build(), "account_type=?", new String[]{"com.sec.chaton"});
        }
        if (cursorQuery != null) {
            try {
                try {
                    cursorQuery.moveToPosition(-1);
                    while (cursorQuery.moveToNext()) {
                        Buddy buddy = new Buddy();
                        buddy.value = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
                        buddy.orgnum = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_orginal_number"));
                        buddy.orgnums = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_orginal_numbers"));
                        buddy.einfo = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_extra_info"));
                        buddy.status = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_status_message"));
                        buddy.sainfo = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_sainfo"));
                        arrayList.add(buddy);
                    }
                    try {
                        cursorQuery.close();
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        cursorQuery.close();
                        m3037a(CommonApplication.m11493l(), (ArrayList<Buddy>) arrayList);
                    }
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                try {
                    cursorQuery.close();
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    cursorQuery.close();
                    m3037a(CommonApplication.m11493l(), (ArrayList<Buddy>) arrayList);
                }
            }
            cursorQuery.close();
        }
        m3037a(CommonApplication.m11493l(), (ArrayList<Buddy>) arrayList);
    }

    /* renamed from: a */
    private static boolean m3041a(Context context) {
        try {
            return f1477a.m55d(context);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
