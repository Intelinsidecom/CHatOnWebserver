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
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.p058a.C2192f;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: ContactManager.java */
/* renamed from: com.sec.chaton.account.i */
/* loaded from: classes.dex */
public class C1002i {

    /* renamed from: a */
    private static C0416a f3267a = new C0416a();

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long m6055a(long r9) throws java.lang.Throwable {
        /*
            r6 = 0
            r7 = 0
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r1 = android.provider.ContactsContract.RawContacts.CONTENT_URI     // Catch: java.lang.Throwable -> L4c
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c
            r3.<init>()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r4 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L4c
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r4 = " = "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r4 = "_id"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L4c
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L4c
            if (r1 == 0) goto L56
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L54
            if (r0 == 0) goto L56
            java.lang.String r0 = "contact_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L54
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L54
        L46:
            if (r1 == 0) goto L4b
            r1.close()
        L4b:
            return r2
        L4c:
            r0 = move-exception
            r1 = r6
        L4e:
            if (r1 == 0) goto L53
            r1.close()
        L53:
            throw r0
        L54:
            r0 = move-exception
            goto L4e
        L56:
            r2 = r7
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.account.C1002i.m6055a(long):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long m6054a() throws java.lang.Throwable {
        /*
            r3 = 0
            r6 = 0
            r7 = 0
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()
            android.content.ContentResolver r0 = r0.getContentResolver()
            r1 = 2
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.String r1 = "_id"
            r2[r3] = r1
            r1 = 1
            java.lang.String r3 = "display_name"
            r2[r1] = r3
            android.net.Uri r1 = android.provider.ContactsContract.Profile.CONTENT_URI     // Catch: java.lang.Throwable -> L36
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L40
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L40
            r0 = 0
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L3e
        L30:
            if (r1 == 0) goto L35
            r1.close()
        L35:
            return r2
        L36:
            r0 = move-exception
            r1 = r6
        L38:
            if (r1 == 0) goto L3d
            r1.close()
        L3d:
            throw r0
        L3e:
            r0 = move-exception
            goto L38
        L40:
            r2 = r7
            goto L30
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.account.C1002i.m6054a():long");
    }

    /* renamed from: a */
    public static void m6057a(Context context, ArrayList<Buddy> arrayList) {
        new Thread(RunnableC1001h.m6053a(context, arrayList)).start();
    }

    /* renamed from: b */
    static synchronized void m6067b(Context context, ArrayList<Buddy> arrayList) {
        Cursor cursor;
        boolean z;
        C0994a c0994a = new C0994a(context, context.getContentResolver());
        Account[] accountsByType = AccountManager.get(CommonApplication.m18732r()).getAccountsByType(Config.CHATON_PACKAGE_NAME);
        boolean zM6061a = m6061a(context);
        try {
            Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "raw_contact_id", "data1", "data4"}, "data2='ChatON' ", null, null);
            try {
                if (accountsByType.length > 0) {
                    String str = accountsByType[0].name;
                    C4904y.m18646e("SyncKey name = " + str, "ContactManager");
                    Iterator<Buddy> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Buddy next = it.next();
                        if (next.deleted.booleanValue() || next.blocked.booleanValue()) {
                            c0994a.m6042a(C1004k.m6078a(next.value));
                        } else {
                            long jM6066b = m6066b(next.value);
                            if (!C2923b.m12153h(context) || !zM6061a || next.sainfo == null || TextUtils.isEmpty(next.sainfo) || TextUtils.isEmpty(next.einfo) || !next.einfo.contains("voip=1")) {
                                z = false;
                            } else {
                                C4904y.m18646e("syncContacts() ChatON V available handset. isChatonV = true", "ContactManager");
                                z = true;
                            }
                            if (jM6066b > 0 && (next.orgnums == null || TextUtils.isEmpty(next.orgnums))) {
                                C4904y.m18646e("orgnums is : " + next.orgnums + " orgnum is " + next.orgnum, C1002i.class.getSimpleName());
                                if (next.orgnum == null || TextUtils.isEmpty(next.orgnum)) {
                                    C4904y.m18646e("orgnums is null : buddy.value : " + next.value + " deleted!!", C1002i.class.getSimpleName());
                                    c0994a.m6042a(C1004k.m6078a(next.value));
                                } else {
                                    if (next.value.equals(next.orgnum.replace("+", "")) && next.value.startsWith(Spam.ACTIVITY_CANCEL)) {
                                        C4904y.m18646e("orgnums is null : buddy.value : " + next.value + " deleted!!", C1002i.class.getSimpleName());
                                        c0994a.m6042a(C1004k.m6078a(next.value));
                                    }
                                    if (next.orgnum.contains("@")) {
                                        C4904y.m18646e("orgnum is email address : buddy.orgnum : " + next.orgnum + " deleted!!", C1002i.class.getSimpleName());
                                        c0994a.m6042a(C1004k.m6078a(next.value));
                                    }
                                }
                            }
                            if ((jM6066b <= 0 || m6063a(next) || z) && jM6066b != -1) {
                                if (next.orgnums != null && !TextUtils.isEmpty(next.orgnums)) {
                                    new ArrayList();
                                    List<String> listM6056a = m6056a(next.orgnums);
                                    ArrayList arrayList2 = new ArrayList();
                                    for (int i = 0; i < listM6056a.size(); i++) {
                                        if (listM6056a.get(i).length() < 19) {
                                            String strM9881e = C2192f.m9881e(listM6056a.get(i));
                                            if (!TextUtils.isEmpty(strM9881e)) {
                                                boolean zM6062a = m6062a(cursorQuery, strM9881e);
                                                boolean zM6064a = m6064a(next.value, next.sainfo);
                                                long jM9880d = C2192f.m9880d(listM6056a.get(i));
                                                if (zM6062a) {
                                                    arrayList2.add(Long.toString(jM9880d));
                                                    if (C4904y.f17872b) {
                                                        C4904y.m18639b("originalPhoneNumber = " + strM9881e + " is already exist with rawContactId : " + jM9880d, "ContactManager");
                                                    }
                                                }
                                                if ((z || !zM6062a) && (!z || !zM6064a)) {
                                                    if (zM6062a && z && !zM6064a) {
                                                        c0994a.m6042a(C1004k.m6078a(next.value));
                                                    }
                                                    if (m6070b(cursorQuery, Long.toString(jM9880d))) {
                                                        if (C4904y.f17872b) {
                                                            C4904y.m18639b("isAlreadyExistByRawId rawContactId : " + jM9880d, "ContactManager");
                                                        }
                                                    } else if (arrayList2.contains(Long.toString(jM9880d))) {
                                                        if (C4904y.f17872b) {
                                                            C4904y.m18639b("prevRawContactId.contains rawContactId : " + jM9880d, "ContactManager");
                                                        }
                                                    } else if (jM9880d > 0) {
                                                        String strM9879c = C2192f.m9879c(listM6056a.get(i));
                                                        String strM18121a = C4809aa.m18104a().m18121a("msisdn", "");
                                                        if (strM9879c != null) {
                                                            int iM6041a = c0994a.m6041a();
                                                            if (strM18121a != null && !TextUtils.isEmpty(strM18121a) && !strM18121a.trim().equals("")) {
                                                                c0994a.m6042a(C1004k.m6077a(next, str));
                                                                c0994a.m6042a(C1004k.m6075a(iM6041a, strM9879c));
                                                                c0994a.m6042a(C1004k.m6076a(next, iM6041a, strM9881e));
                                                                if (z) {
                                                                    c0994a.m6042a(C1004k.m6080b(next, iM6041a, strM9881e));
                                                                }
                                                                arrayList2.add(Long.toString(jM9880d));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (next.orgnum != null && !TextUtils.isEmpty(next.orgnum)) {
                                    if (next.orgnum.length() < 19) {
                                        String strM9881e2 = C2192f.m9881e(next.orgnum);
                                        boolean zM6062a2 = m6062a(cursorQuery, strM9881e2);
                                        boolean zM6064a2 = m6064a(next.value, next.sainfo);
                                        if (zM6062a2 && z && !zM6064a2) {
                                            c0994a.m6042a(C1004k.m6078a(next.value));
                                        } else if (zM6062a2) {
                                        }
                                        if (C2192f.m9880d(next.orgnum) > 0) {
                                            String strM9879c2 = C2192f.m9879c(next.orgnum);
                                            String strM18121a2 = C4809aa.m18104a().m18121a("msisdn", "");
                                            if (strM9879c2 != null) {
                                                int iM6041a2 = c0994a.m6041a();
                                                if (strM18121a2 != null && !TextUtils.isEmpty(strM18121a2) && !strM18121a2.trim().equals("")) {
                                                    if (!zM6062a2) {
                                                        c0994a.m6042a(C1004k.m6077a(next, str));
                                                        c0994a.m6042a(C1004k.m6075a(iM6041a2, strM9879c2));
                                                        c0994a.m6042a(C1004k.m6076a(next, iM6041a2, strM9881e2));
                                                    }
                                                    if (z) {
                                                        c0994a.m6042a(C1004k.m6080b(next, iM6041a2, strM9881e2));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (c0994a.m6041a() > 300) {
                                c0994a.m6043b();
                            }
                        }
                    }
                    if (c0994a.m6041a() > 0) {
                        c0994a.m6043b();
                    }
                    Iterator<Buddy> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Buddy next2 = it2.next();
                        if (next2.blocked.booleanValue() || next2.deleted.booleanValue()) {
                            if (next2.orgnum != null && !TextUtils.isEmpty(next2.orgnum)) {
                                m6072c(cursorQuery, C2192f.m9881e(next2.orgnum));
                            } else if (next2.orgnums != null && !TextUtils.isEmpty(next2.orgnums)) {
                                new ArrayList();
                                List<String> listM6056a2 = m6056a(next2.orgnums);
                                for (int i2 = 0; i2 < listM6056a2.size(); i2++) {
                                    m6072c(cursorQuery, C2192f.m9881e(listM6056a2.get(i2)));
                                }
                            }
                        } else if (next2.status != null && next2.value != null) {
                            if (next2.orgnums != null && !TextUtils.isEmpty(next2.orgnums)) {
                                new ArrayList();
                                List<String> listM6056a3 = m6056a(next2.orgnums);
                                for (int i3 = 0; i3 < listM6056a3.size(); i3++) {
                                    m6058a(cursorQuery, C2192f.m9881e(listM6056a3.get(i3)), next2.status);
                                }
                            } else if (next2.orgnum != null && !TextUtils.isEmpty(next2.orgnum)) {
                                m6058a(cursorQuery, C2192f.m9881e(next2.orgnum), next2.status);
                            }
                        }
                    }
                } else {
                    C4904y.m18646e("samsungAccount is not exist ", "ContactManager");
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: a */
    public static boolean m6063a(Buddy buddy) {
        if ((buddy.value.length() < 19 || !buddy.value.startsWith("10")) && (!buddy.value.startsWith(Spam.ACTIVITY_CANCEL) || TextUtils.isEmpty(buddy.msisdns))) {
            return false;
        }
        new ArrayList();
        if (buddy.orgnums == null || TextUtils.isEmpty(buddy.orgnums)) {
            return false;
        }
        Iterator<String> it = m6056a(buddy.orgnums).iterator();
        int i = 0;
        while (it.hasNext()) {
            i = it.next().length() < 19 ? i + 1 : i;
        }
        return i > 1;
    }

    /* renamed from: a */
    public static boolean m6062a(Cursor cursor, String str) {
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

    /* renamed from: b */
    public static boolean m6070b(Cursor cursor, String str) {
        boolean z = false;
        if (cursor != null) {
            try {
                if (cursor.getCount() != 0) {
                    cursor.moveToPosition(-1);
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("raw_contact_id"));
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m6064a(java.lang.String r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            r7 = 0
            r8 = 1
            r6 = 0
            boolean r0 = com.sec.chaton.util.C4904y.f17872b
            if (r0 == 0) goto L2c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isAlreadyExistChatONV chatonid = "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r1 = ", sainfo = "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ContactManager"
            com.sec.chaton.util.C4904y.m18639b(r0, r1)
        L2c:
            if (r10 == 0) goto L34
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != r8) goto L36
        L34:
            r0 = r6
        L35:
            return r0
        L36:
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L77
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L77
            android.net.Uri r1 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L77
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L77
            r3 = 0
            java.lang.String r4 = "data4"
            r2[r3] = r4     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L77
            java.lang.String r3 = "data1=? AND data2=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L77
            r5 = 0
            r4[r5] = r10     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L77
            r5 = 1
            r4[r5] = r9     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L77
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L77
            if (r1 == 0) goto L69
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            if (r0 <= 0) goto L69
            r0 = r8
        L63:
            if (r1 == 0) goto L35
            r1.close()
            goto L35
        L69:
            r0 = r6
            goto L63
        L6b:
            r0 = move-exception
            r1 = r7
        L6d:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L75
            r1.close()
        L75:
            r0 = r6
            goto L35
        L77:
            r0 = move-exception
        L78:
            if (r7 == 0) goto L7d
            r7.close()
        L7d:
            throw r0
        L7e:
            r0 = move-exception
            r7 = r1
            goto L78
        L81:
            r0 = move-exception
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.account.C1002i.m6064a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static List<String> m6056a(String str) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    /* renamed from: b */
    public static long m6066b(String str) throws Throwable {
        Cursor cursorQuery;
        long j;
        try {
            cursorQuery = CommonApplication.m18732r().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, InterfaceC1003j.f3268a, "account_type='com.sec.chaton' AND sync1=? AND deleted=0", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        j = 0;
                    } else {
                        j = cursorQuery.getLong(0);
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } else {
                j = -1;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: c */
    public static void m6073c(String str) {
        m6060a(false, str);
    }

    /* renamed from: a */
    public static void m6059a(boolean z) {
        m6060a(z, (String) null);
    }

    /* renamed from: a */
    private static void m6060a(boolean z, String str) {
        Account[] accountsByType = AccountManager.get(CommonApplication.m18732r()).getAccountsByType(Config.CHATON_PACKAGE_NAME);
        if (accountsByType.length > 0) {
            Account account = new Account(accountsByType[0].name, Config.CHATON_PACKAGE_NAME);
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
        if (C4904y.f17872b) {
            C4904y.m18639b("requestSync. ksy is empty. ignore sync operation", "ContactManager");
        }
        m6071c();
    }

    /* renamed from: c */
    private static void m6071c() {
        AccountManager.get(CommonApplication.m18732r());
        if (C4809aa.m18104a().m18129b("uid")) {
            String strM18121a = C4809aa.m18104a().m18121a("msisdn", "");
            String strM18121a2 = C4809aa.m18104a().m18121a("uid", "");
            if (strM18121a != null && !TextUtils.isEmpty(strM18121a) && strM18121a2 != null && !TextUtils.isEmpty(strM18121a2)) {
                m6068b(strM18121a, strM18121a2);
                m6069b(true);
            } else if (C4904y.f17872b) {
                C4904y.m18639b("runRegiAccount. mMSISDN or mUid is empty. ignore sync operation", "ContactManager");
            }
        }
    }

    /* renamed from: b */
    private static void m6068b(String str, String str2) {
        Account account = new Account("ChatON", Config.CHATON_PACKAGE_NAME);
        AccountManager.get(CommonApplication.m18732r()).addAccountExplicitly(account, str2, null);
        ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
    }

    /* renamed from: b */
    public static int m6065b() {
        String strM18121a = C4809aa.m18104a().m18121a("msisdn", (String) null);
        if (strM18121a == null) {
            return -1;
        }
        C4904y.m18639b("RawContacts Upgrade ACCOUNT_NAME " + strM18121a, "ContactManager");
        ContentValues contentValues = new ContentValues();
        contentValues.put("account_name", strM18121a);
        int iUpdate = CommonApplication.m18732r().getContentResolver().update(ContactsContract.RawContacts.CONTENT_URI, contentValues, "account_type=?", new String[]{Config.CHATON_PACKAGE_NAME});
        C4904y.m18639b("RawContacts Upgrade result=" + iUpdate, "ContactManager");
        return iUpdate;
    }

    /* renamed from: c */
    private static void m6072c(Cursor cursor, String str) {
        String string;
        C4904y.m18639b("CompareCursor_DeleteStatusMessage() orgNum =" + str, "ContactManager");
        if (cursor != null) {
            cursor.moveToFirst();
            try {
                if (cursor.getCount() > 0 && (string = cursor.getString(cursor.getColumnIndex("data4"))) != null && string.equals(str)) {
                    String string2 = cursor.getString(0);
                    ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("presence_data_id", string2);
                    contentValues.put("status", "");
                    contentResolver.insert(ContactsContract.StatusUpdates.CONTENT_URI, contentValues);
                    CommonApplication.m18732r().getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "_id=?", new String[]{cursor.getString(1)});
                }
            } catch (CursorIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m6058a(Cursor cursor, String str, String str2) {
        String string;
        C4904y.m18639b("CompareCursor_SyncStatusMessage() orgNum =" + str, "ContactManager");
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
                    ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("presence_data_id", string);
                    contentValues.put("status", str2);
                    contentValues.put("status_res_package", Config.CHATON_PACKAGE_NAME);
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
    public static void m6069b(boolean z) {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        Cursor cursorQuery = contentResolver.query(C2289i.f8196a, null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (z) {
            C4904y.m18641c("Resync contact to Buddy (delete all contact)", "ContactManager");
            contentResolver.delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build(), "account_type=?", new String[]{Config.CHATON_PACKAGE_NAME});
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
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        cursorQuery.close();
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        cursorQuery.close();
                        m6057a(CommonApplication.m18732r(), (ArrayList<Buddy>) arrayList);
                    }
                }
                try {
                    cursorQuery.close();
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    cursorQuery.close();
                    m6057a(CommonApplication.m18732r(), (ArrayList<Buddy>) arrayList);
                }
                cursorQuery.close();
            } catch (Throwable th) {
                try {
                    cursorQuery.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        m6057a(CommonApplication.m18732r(), (ArrayList<Buddy>) arrayList);
    }

    /* renamed from: a */
    private static boolean m6061a(Context context) {
        try {
            return f3267a.m1495d(context);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
