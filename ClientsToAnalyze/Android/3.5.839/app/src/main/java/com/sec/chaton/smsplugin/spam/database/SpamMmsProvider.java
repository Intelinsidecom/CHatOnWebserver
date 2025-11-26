package com.sec.chaton.smsplugin.spam.database;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.Telephony;
import android.text.TextUtils;
import com.google.android.mms.ContentType;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.spam.C4012bp;
import java.io.File;
import java.io.IOException;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SpamMmsProvider extends ContentProvider {

    /* renamed from: a */
    static boolean f14504a = true;

    /* renamed from: b */
    private static final UriMatcher f14505b = new UriMatcher(-1);

    /* renamed from: c */
    private SQLiteOpenHelper f14506c;

    static {
        f14505b.addURI(C4012bp.f14467c, null, 40);
        f14505b.addURI(C4012bp.f14467c, "#", 41);
        f14505b.addURI(C4012bp.f14467c, "inbox", 42);
        f14505b.addURI(C4012bp.f14467c, "inbox/#", 43);
        f14505b.addURI(C4012bp.f14467c, "#/spamaddr", 44);
        f14505b.addURI(C4012bp.f14467c, "#/spampart", 45);
        f14505b.addURI(C4012bp.f14467c, "spampart/#", 46);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f14506c = C4025a.m15497a(getContext());
        C3890m.m14994a("SpamProvider", "onCreate EnableMmsServerTime = " + f14504a);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        int iMatch = f14505b.match(uri);
        C3890m.m14994a("SpamProvider", "Query uri=" + uri + ", match=" + iMatch);
        switch (iMatch) {
            case 41:
                sQLiteQueryBuilder.setTables("spam_pdu");
                sQLiteQueryBuilder.appendWhere("_id=" + uri.getPathSegments().get(0));
                break;
            case 42:
            default:
                C3890m.m14999e("SpamProvider", "query: invalid request: " + uri);
                return null;
            case 43:
                sQLiteQueryBuilder.setTables("spam_pdu");
                sQLiteQueryBuilder.appendWhere("_id=" + uri.getPathSegments().get(1));
                sQLiteQueryBuilder.appendWhere(" AND msg_box=1");
                break;
            case 44:
                sQLiteQueryBuilder.setTables("spam_addr");
                sQLiteQueryBuilder.appendWhere("msg_id=" + uri.getPathSegments().get(0));
                break;
            case 45:
                sQLiteQueryBuilder.setTables("spam_part");
                sQLiteQueryBuilder.appendWhere("mid=" + uri.getPathSegments().get(0));
                break;
            case 46:
                sQLiteQueryBuilder.setTables("spam_part");
                sQLiteQueryBuilder.appendWhere("_id=" + uri.getPathSegments().get(1));
                break;
        }
        String str3 = TextUtils.isEmpty(str2) ? str2 : null;
        m15484a(strArr);
        Cursor cursorQuery = sQLiteQueryBuilder.query(this.f14506c.getReadableDatabase(), strArr, str, strArr2, null, null, str3);
        cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        return cursorQuery;
    }

    /* renamed from: a */
    private void m15484a(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (strArr[i].equals("_display_name")) {
                    strArr[i] = "cl as _display_name";
                    return;
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        int iMatch = f14505b.match(uri);
        C3890m.m14994a("SpamProvider", "Insert uri=" + uri + ", match=" + iMatch);
        switch (iMatch) {
            case 42:
                return m15479a(contentValues, 1);
            case 43:
            default:
                C3890m.m14999e("SpamProvider", "insert: invalid request: " + uri);
                return null;
            case 44:
                return m15480a(contentValues, uri);
            case 45:
                return m15485b(contentValues, uri);
        }
    }

    /* renamed from: a */
    private Uri m15479a(ContentValues contentValues, int i) {
        SQLiteDatabase writableDatabase = this.f14506c.getWritableDatabase();
        boolean z = (contentValues.containsKey("date") && f14504a) ? false : true;
        boolean z2 = contentValues.containsKey("msg_box") ? false : true;
        m15483a(contentValues);
        ContentValues contentValues2 = new ContentValues(contentValues);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z) {
            C3890m.m14994a("SpamProvider", "insertSpamMms() Mms.Date = " + contentValues.containsKey("date") + " EnableMmsServerTime = " + f14504a);
            contentValues2.put("date", Long.valueOf(jCurrentTimeMillis / 1000));
        }
        if (z2 && i != 0) {
            contentValues2.put("msg_box", Integer.valueOf(i));
        }
        if (i != 1) {
            contentValues2.put("read", (Integer) 1);
        }
        long jInsert = writableDatabase.insert("spam_pdu", null, contentValues2);
        if (jInsert <= 0) {
            C3890m.m14999e("SpamProvider", "MmsProvider.insert: failed! " + contentValues2);
            return null;
        }
        m15482a();
        return Uri.parse(C4012bp.f14473i + "/" + jInsert);
    }

    /* renamed from: a */
    private Uri m15480a(ContentValues contentValues, Uri uri) {
        SQLiteDatabase writableDatabase = this.f14506c.getWritableDatabase();
        ContentValues contentValues2 = new ContentValues(contentValues);
        contentValues2.put("msg_id", uri.getPathSegments().get(0));
        long jInsert = writableDatabase.insert("spam_addr", null, contentValues2);
        if (jInsert > 0) {
            return Uri.parse(C4012bp.f14473i + "/spamaddr/" + jInsert);
        }
        C3890m.m14999e("SpamProvider", "Failed to insert address: " + contentValues2);
        return null;
    }

    /* renamed from: b */
    private Uri m15485b(ContentValues contentValues, Uri uri) throws IOException {
        SQLiteDatabase writableDatabase = this.f14506c.getWritableDatabase();
        ContentValues contentValues2 = new ContentValues(contentValues);
        contentValues2.put("mid", uri.getPathSegments().get(0));
        String asString = contentValues.getAsString("ct");
        boolean zEquals = "text/plain".equals(asString);
        boolean zEquals2 = "application/smil".equals(asString);
        if (!zEquals && !zEquals2) {
            String str = getContext().getDir("parts", 0).getPath() + "/PART_" + System.currentTimeMillis();
            if (ContentType.isDrmType(asString)) {
                C3890m.m14994a("SpamProvider", "Original path =" + str);
                String asString2 = contentValues.getAsString("cl");
                int iLastIndexOf = asString2.lastIndexOf(".");
                if (iLastIndexOf != -1) {
                    String strSubstring = asString2.substring(iLastIndexOf + 1, asString2.length());
                    C3890m.m14994a("SpamProvider", "extension=" + strSubstring);
                    str = str + "." + strSubstring;
                    C3890m.m14994a("SpamProvider", "Final path=" + str);
                }
            }
            contentValues2.put("_data", str);
            File file = new File(str);
            if (!file.exists()) {
                try {
                    if (!file.createNewFile()) {
                        throw new IllegalStateException("Unable to create new partFile: " + str);
                    }
                } catch (IOException e) {
                    C3890m.m14995a("SpamProvider", "createNewFile", e);
                    throw new IllegalStateException("Unable to create new partFile: " + str);
                }
            }
            if (ContentType.isDrmType(asString)) {
                try {
                    Runtime.getRuntime().exec("chmod 664 " + str);
                } catch (IOException e2) {
                    C3890m.m14999e("SpamProvider", "MmsProvider : drm media file permission change failed " + str);
                }
            }
        }
        long jInsert = writableDatabase.insert("spam_part", null, contentValues2);
        if (jInsert <= 0) {
            C3890m.m14999e("SpamProvider", "MmsProvider.insert: failed! " + contentValues2);
            return null;
        }
        return Uri.parse(C4012bp.f14473i + "/spampart/" + jInsert);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int iM15476a = 0;
        int iMatch = f14505b.match(uri);
        C3890m.m14994a("SpamProvider", "Delete uri=" + uri + ", match=" + iMatch);
        switch (iMatch) {
            case 41:
            case 43:
                String strM15481a = m15481a(str, "_id=" + uri.getLastPathSegment());
                SQLiteDatabase writableDatabase = this.f14506c.getWritableDatabase();
                if ("spam_pdu".equals("spam_pdu")) {
                    iM15476a = m15476a(getContext(), writableDatabase, strM15481a, strArr, uri);
                    SpamMmsSmsProvider.m15489a(iM15476a, getContext());
                }
                C3890m.m14996b("SpamProvider", "delete table=spam_pdu, deletedRows=" + iM15476a);
                if (iM15476a > 0) {
                    m15482a();
                }
                return iM15476a;
            case 42:
            default:
                C3890m.m14998d("SpamProvider", "No match for URI '" + uri + "'");
                return iM15476a;
        }
    }

    /* renamed from: a */
    static int m15476a(Context context, SQLiteDatabase sQLiteDatabase, String str, String[] strArr, Uri uri) {
        Cursor cursorQuery = sQLiteDatabase.query("spam_pdu", new String[]{"_id"}, str, strArr, null, null, null);
        if (cursorQuery == null) {
            return 0;
        }
        try {
            if (cursorQuery.getCount() == 0) {
                return 0;
            }
            while (cursorQuery.moveToNext()) {
                m15478a(sQLiteDatabase, "mid = ?", new String[]{String.valueOf(cursorQuery.getLong(0))});
            }
            cursorQuery.close();
            return sQLiteDatabase.delete("spam_pdu", str, strArr);
        } finally {
            cursorQuery.close();
        }
    }

    /* renamed from: a */
    private static int m15478a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return m15477a(sQLiteDatabase, "spam_part", str, strArr);
    }

    /* renamed from: a */
    private static int m15477a(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        Cursor cursorQuery = sQLiteDatabase.query(str, new String[]{"_data"}, str2, strArr, null, null, null);
        if (cursorQuery == null) {
            return 0;
        }
        try {
            if (cursorQuery.getCount() == 0) {
                return 0;
            }
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(0);
                    if (string != null) {
                        int iLastIndexOf = string.lastIndexOf(46);
                        if (iLastIndexOf >= 0) {
                            String strSubstring = string.substring(iLastIndexOf + 1);
                            if ("dm".equals(strSubstring) || "dcf".equals(strSubstring)) {
                                if ("dcf".equals(strSubstring)) {
                                    C3890m.m14997c("SpamProvider", "unregister dcf file" + string);
                                }
                                if ("dm".equals(strSubstring)) {
                                    String str3 = string.substring(0, iLastIndexOf) + ".dcf";
                                    File file = new File(str3);
                                    if (file.exists()) {
                                        C3890m.m14997c("SpamProvider", "unregister dm file" + string);
                                        C3890m.m14997c("SpamProvider", "delete converted dm file" + str3);
                                        if (!file.delete()) {
                                            C3890m.m14999e("SpamProvider", "Failed to delete converted dm file");
                                        }
                                    }
                                }
                            }
                        }
                        new File(string).delete();
                    }
                } catch (Throwable th) {
                    C3890m.m14995a("SpamProvider", th.getMessage(), th);
                }
            }
            cursorQuery.close();
            return sQLiteDatabase.delete(str, str2, strArr);
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0096 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0067  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int update(android.net.Uri r10, android.content.ContentValues r11, java.lang.String r12, java.lang.String[] r13) {
        /*
            r9 = this;
            r2 = 0
            r5 = 1
            r4 = 0
            android.content.UriMatcher r0 = com.sec.chaton.smsplugin.spam.database.SpamMmsProvider.f14505b
            int r7 = r0.match(r10)
            java.lang.String r0 = "SpamProvider"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Update uri="
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.String r3 = ", match="
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r1 = r1.toString()
            com.sec.chaton.smsplugin.p111h.C3890m.m14994a(r0, r1)
            switch(r7) {
                case 40: goto L9c;
                case 41: goto L53;
                case 42: goto L9c;
                case 43: goto L53;
                case 44: goto L31;
                case 45: goto La3;
                case 46: goto La3;
                default: goto L31;
            }
        L31:
            java.lang.String r0 = "SpamProvider"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Update operation for '"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.String r2 = "' not implemented."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.sec.chaton.smsplugin.p111h.C3890m.m14998d(r0, r1)
        L52:
            return r4
        L53:
            java.lang.String r1 = r10.getLastPathSegment()
            java.lang.String r0 = "spam_pdu"
            r3 = r4
            r8 = r1
            r1 = r0
            r0 = r8
        L5e:
            java.lang.String r6 = "spam_pdu"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto Laa
            r9.m15483a(r11)
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>(r11)
            if (r0 == 0) goto Lfd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "_id="
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = r0.toString()
            r0 = r4
        L86:
            java.lang.String r2 = m15481a(r12, r2)
            android.database.sqlite.SQLiteOpenHelper r4 = r9.f14506c
            android.database.sqlite.SQLiteDatabase r4 = r4.getWritableDatabase()
            int r4 = r4.update(r1, r0, r2, r13)
            if (r3 == 0) goto L52
            if (r4 <= 0) goto L52
            r9.m15482a()
            goto L52
        L9c:
            java.lang.String r0 = "spam_pdu"
            r1 = r0
            r3 = r5
            r0 = r2
            goto L5e
        La3:
            java.lang.String r0 = "spam_part"
            r1 = r0
            r3 = r4
            r0 = r2
            goto L5e
        Laa:
            java.lang.String r0 = "spam_part"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L52
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>(r11)
            switch(r7) {
                case 45: goto Lbd;
                case 46: goto Ldd;
                default: goto Lbb;
            }
        Lbb:
            r0 = r6
            goto L86
        Lbd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "mid="
            java.lang.StringBuilder r2 = r0.append(r2)
            java.util.List r0 = r10.getPathSegments()
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = r0.toString()
            r0 = r6
            goto L86
        Ldd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "_id="
            java.lang.StringBuilder r2 = r0.append(r2)
            java.util.List r0 = r10.getPathSegments()
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = r0.toString()
            r0 = r6
            goto L86
        Lfd:
            r0 = r4
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.spam.database.SpamMmsProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        f14505b.match(uri);
        C3890m.m14996b("SpamProvider", "openFile: uri=" + uri + ", mode=" + str);
        return openFileHelper(uri, str);
    }

    /* renamed from: a */
    private void m15483a(ContentValues contentValues) {
        contentValues.remove("d_tm_tok");
        contentValues.remove("s_vis");
        contentValues.remove("r_chg");
        contentValues.remove("r_chg_dl_tok");
        contentValues.remove("r_chg_dl");
        contentValues.remove("r_chg_id");
        contentValues.remove("r_chg_sz");
        contentValues.remove("p_s_by");
        contentValues.remove("p_s_d");
        contentValues.remove("store");
        contentValues.remove("mm_st");
        contentValues.remove("mm_flg_tok");
        contentValues.remove("mm_flg");
        contentValues.remove("store_st");
        contentValues.remove("store_st_txt");
        contentValues.remove("stored");
        contentValues.remove("totals");
        contentValues.remove("mb_t");
        contentValues.remove("mb_t_tok");
        contentValues.remove("qt");
        contentValues.remove("mb_qt");
        contentValues.remove("mb_qt_tok");
        contentValues.remove("m_cnt");
        contentValues.remove("start");
        contentValues.remove("d_ind");
        contentValues.remove("e_des");
        contentValues.remove("limit");
        contentValues.remove("r_r_mod");
        contentValues.remove("r_r_mod_txt");
        contentValues.remove("st_txt");
        contentValues.remove("apl_id");
        contentValues.remove("r_apl_id");
        contentValues.remove("aux_apl_id");
        contentValues.remove("drm_c");
        contentValues.remove("adp_a");
        contentValues.remove("repl_id");
        contentValues.remove("cl_id");
        contentValues.remove("cl_st");
        contentValues.remove("_id");
    }

    /* renamed from: a */
    private void m15482a() {
        getContext().getContentResolver().notifyChange(Telephony.MmsSms.CONTENT_URI, null);
    }

    /* renamed from: a */
    private static String m15481a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return TextUtils.isEmpty(str2) ? str : str + " AND " + str2;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f14505b.match(uri)) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 8:
                return "vnd.android-dir/mms";
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                return "vnd.android/mms";
            default:
                return "*/*";
        }
    }
}
