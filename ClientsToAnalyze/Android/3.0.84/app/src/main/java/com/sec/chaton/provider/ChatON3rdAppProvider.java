package com.sec.chaton.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Binder;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.api.access_token.C0440a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.C1434bj;
import com.sec.chaton.p027e.C1435c;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.InterfaceC1406ax;
import com.sec.chaton.util.C3158a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import twitter4j.Query;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class ChatON3rdAppProvider extends BaseContentProvider {

    /* renamed from: b */
    public static String[] f7827b = {"inbox_no", "message_id", "message_type", "message", "sender_id", "sender_name", "chatroom_title", "sender_phoneNumber", "chat_type", "received_time", "sender_chatonv_available"};

    /* renamed from: a */
    String[] f7828a = {"inbox_no", "message_id", "message_type", "message", "sender_id", "sender_name", "chatroom_title", "participant_count", "chat_type", "received_time", "sender_phoneNumber", "sender_chatonv_available"};

    /* renamed from: c */
    private UriMatcher f7829c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015e  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int delete(android.net.Uri r7, java.lang.String r8, java.lang.String[] r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatON3rdAppProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f7829c.match(uri)) {
            case HttpResponseCode.f13733OK /* 200 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.appmanage";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM8117a;
        String str;
        String str2;
        long jInsertOrThrow;
        if (!C0440a.m3070a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        Uri uri2 = ContactsContract.AUTHORITY_URI;
        try {
            try {
                try {
                    try {
                        SQLiteDatabase writableDatabase = C1404av.m6253a(getContext()).getWritableDatabase();
                        int iMatch = this.f7829c.match(uri);
                        ArrayList arrayList = new ArrayList();
                        if (C3250y.f11734b) {
                            C3250y.m11450b("DB insert start: " + uri.toString(), getClass().getSimpleName());
                        }
                        switch (iMatch) {
                            case HttpResponseCode.f13733OK /* 200 */:
                                jInsertOrThrow = writableDatabase.insertOrThrow("appmanage", null, contentValues);
                                uri2 = C1435c.f5363a;
                                arrayList.add(uri2);
                                break;
                            default:
                                arrayList.add(ContactsContract.AUTHORITY_URI);
                                C3250y.m11455d("Unknown Uri : " + uri.toString(), "ChatON3rdAppProvider");
                                jInsertOrThrow = -1;
                                break;
                        }
                        if (C3250y.f11734b) {
                            C3250y.m11450b("DB insert end: " + uri.toString(), getClass().getSimpleName());
                        }
                        if (!m8070a() && jInsertOrThrow > -1 && arrayList != null && arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                            }
                        }
                        arrayList.clear();
                        return uri2;
                    } catch (SQLiteDiskIOException e) {
                        C3250y.m11443a(e, "ChatON3rdAppProvider");
                        uriM8117a = C2036a.m8117a(EnumC2039b.DISK_IO);
                        if (!C3250y.f11734b) {
                            return uriM8117a;
                        }
                        str = "returnUri : " + uriM8117a.toString();
                        str2 = "ChatON3rdAppProvider";
                        C3250y.m11450b(str, str2);
                        return uriM8117a;
                    } catch (SQLiteFullException e2) {
                        C3250y.m11443a(e2, "ChatON3rdAppProvider");
                        uriM8117a = C2036a.m8117a(EnumC2039b.FULL);
                        if (!C3250y.f11734b) {
                            return uriM8117a;
                        }
                        str = "returnUri : " + uriM8117a.toString();
                        str2 = "ChatON3rdAppProvider";
                        C3250y.m11450b(str, str2);
                        return uriM8117a;
                    }
                } catch (SQLiteConstraintException e3) {
                    C3250y.m11443a(e3, "ChatON3rdAppProvider");
                    uriM8117a = C2036a.m8117a(EnumC2039b.CONSTRAINT);
                    if (!C3250y.f11734b) {
                        return uriM8117a;
                    }
                    str = "returnUri : " + uriM8117a.toString();
                    str2 = "ChatON3rdAppProvider";
                    C3250y.m11450b(str, str2);
                    return uriM8117a;
                } catch (SQLiteException e4) {
                    C3250y.m11443a(e4, "ChatON3rdAppProvider");
                    uriM8117a = C2036a.m8117a(EnumC2039b.NORMAL);
                    if (!C3250y.f11734b) {
                        return uriM8117a;
                    }
                    str = "returnUri : " + uriM8117a.toString();
                    str2 = "ChatON3rdAppProvider";
                    C3250y.m11450b(str, str2);
                    return uriM8117a;
                }
            } catch (Exception e5) {
                C3250y.m11443a(e5, "ChatON3rdAppProvider");
                uriM8117a = C2036a.m8117a(EnumC2039b.UNKNOWN);
                if (!C3250y.f11734b) {
                    return uriM8117a;
                }
                str = "returnUri : " + uriM8117a.toString();
                str2 = "ChatON3rdAppProvider";
                C3250y.m11450b(str, str2);
                return uriM8117a;
            }
        } finally {
            if (C3250y.f11734b) {
                C3250y.m11450b("returnUri : " + uri2.toString(), "ChatON3rdAppProvider");
            }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m8078b();
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws Resources.NotFoundException {
        Cursor cursorM8080c;
        if (!C0440a.m3070a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        try {
            SQLiteDatabase readableDatabase = C1404av.m6253a(getContext()).getReadableDatabase();
            int iMatch = this.f7829c.match(uri);
            C1434bj c1434bjM6288a = new C1434bj().m6288a("appmanage");
            if (C3250y.f11734b) {
                C3250y.m11450b("DB query : " + uri.toString(), getClass().getSimpleName());
            }
            switch (iMatch) {
                case 201:
                    String str3 = strArr2[0];
                    String str4 = strArr2[1];
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str4);
                    arrayList.add(str3);
                    arrayList.add(str3);
                    arrayList.add(str3);
                    Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM  (SELECT a.message_inbox_no AS message_inbox_no, a.message_sever_id AS message_sever_id, a.message_content_type AS message_content_type, a.message_content AS message_content, a.message_sender AS message_sender, a.message_time AS message_time, a.message_is_truncated AS message_is_truncated, ifnull(c.buddy_name, '') AS buddy_name, ifnull(c.buddy_extra_info, '') AS buddy_extra_info, ifnull(c.buddy_sainfo, '') AS buddy_sainfo, ifnull(c.buddy_phonenumber_external_use, '') AS buddy_phonenumber_external_use FROM ( (SELECT message_sender, message_content, message_content_type, message_inbox_no, message_sever_id, message_time, message_is_truncated FROM message WHERE message_sever_id=? AND message_inbox_no=?) a LEFT OUTER JOIN (SELECT ifnull(b.buddy_name, p.participants_buddy_name) AS buddy_name,  p.participants_buddy_no AS buddy_no, b.buddy_extra_info AS buddy_extra_info, b.buddy_sainfo AS buddy_sainfo, b.buddy_phonenumber_external_use AS buddy_phonenumber_external_use FROM participant p LEFT OUTER JOIN ( SELECT buddy_name, buddy_no, buddy_extra_info, buddy_sainfo, buddy_phonenumber_external_use FROM buddy UNION ALL  SELECT s.buddy_name AS buddy_name, s.buddy_no AS buddy_no, '' AS buddy_extra_info, '' AS buddy_sainfo, ''  AS buddy_phonenumber_external_use FROM specialbuddy s) b ON p.participants_buddy_no= b.buddy_no WHERE p.participants_inbox_no=? GROUP BY buddy_no) c ON a.message_sender=c.buddy_no) ) LEFT OUTER JOIN (SELECT inbox_chat_type, inbox_participants, inbox_title FROM inbox WHERE inbox_no=?)", (String[]) arrayList.toArray(new String[0]));
                    if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                        if (C3250y.f11735c) {
                            C3250y.m11453c("Query message table completed. with message ID:" + str4, "ChatON3rdAppProvider");
                        }
                        cursorM8080c = m8082a(cursorRawQuery);
                        cursorRawQuery.close();
                        break;
                    } else {
                        if (C3250y.f11735c) {
                            C3250y.m11453c("Can not query message table with message ID:" + str4, "ChatON3rdAppProvider");
                        }
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        cursorM8080c = null;
                        break;
                    }
                    break;
                case 202:
                    String str5 = strArr2[0];
                    String str6 = strArr2[1];
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str6);
                    arrayList2.add(str5);
                    arrayList2.add(str5);
                    arrayList2.add(str5);
                    Cursor cursorRawQuery2 = readableDatabase.rawQuery("SELECT * FROM  (SELECT a.message_inbox_no AS message_inbox_no, a.message_sever_id AS message_sever_id, a.message_content_type AS message_content_type, a.message_content AS message_content, a.message_sender AS message_sender, a.message_time AS message_time, a.message_is_truncated AS message_is_truncated, ifnull(c.buddy_name, '') AS buddy_name, ifnull(c.buddy_extra_info, '') AS buddy_extra_info, ifnull(c.buddy_sainfo, '') AS buddy_sainfo, ifnull(c.buddy_phonenumber_external_use, '') AS buddy_phonenumber_external_use FROM ( (SELECT message_sender, message_content, message_content_type, message_inbox_no, message_sever_id, message_time, message_is_truncated FROM message WHERE message_sever_id=? AND message_inbox_no=?) a LEFT OUTER JOIN (SELECT ifnull(b.buddy_name, p.participants_buddy_name) AS buddy_name,  p.participants_buddy_no AS buddy_no, b.buddy_extra_info AS buddy_extra_info, b.buddy_sainfo AS buddy_sainfo, b.buddy_phonenumber_external_use AS buddy_phonenumber_external_use FROM participant p LEFT OUTER JOIN ( SELECT buddy_name, buddy_no, buddy_extra_info, buddy_sainfo, buddy_phonenumber_external_use FROM buddy UNION ALL  SELECT s.buddy_name AS buddy_name, s.buddy_no AS buddy_no, '' AS buddy_extra_info, '' AS buddy_sainfo, ''  AS buddy_phonenumber_external_use FROM specialbuddy s) b ON p.participants_buddy_no= b.buddy_no WHERE p.participants_inbox_no=? GROUP BY buddy_no) c ON a.message_sender=c.buddy_no) ) LEFT OUTER JOIN (SELECT inbox_chat_type, inbox_participants, inbox_title FROM inbox WHERE inbox_no=?)", (String[]) arrayList2.toArray(new String[0]));
                    if (cursorRawQuery2 != null && cursorRawQuery2.getCount() > 0) {
                        cursorM8080c = m8083b(cursorRawQuery2);
                        cursorRawQuery2.close();
                        break;
                    } else {
                        if (C3250y.f11735c) {
                            C3250y.m11453c("Can not query message table with message ID:" + str6, "ChatON3rdAppProvider");
                        }
                        if (cursorRawQuery2 != null) {
                            cursorRawQuery2.close();
                        }
                        cursorM8080c = null;
                        break;
                    }
                    break;
                case 203:
                    Cursor cursorRawQuery3 = readableDatabase.rawQuery(" SELECT ifnull(b.buddy_name, p.participants_buddy_name) AS buddy_name,  p.participants_buddy_no AS buddy_no FROM participant p LEFT OUTER JOIN ( SELECT buddy_name, buddy_no FROM buddy UNION ALL  SELECT s.buddy_name AS buddy_name,  s.buddy_no AS buddy_no FROM specialbuddy s) b ON p.participants_buddy_no= b.buddy_no WHERE p.participants_inbox_no=? GROUP BY buddy_no", strArr2);
                    if (cursorRawQuery3 != null && cursorRawQuery3.getCount() > 0) {
                        cursorM8080c = m8080c(cursorRawQuery3);
                        cursorRawQuery3.close();
                        break;
                    } else {
                        if (C3250y.f11735c) {
                            C3250y.m11453c("Can not query participant with inbox NO:" + strArr2[0], "ChatON3rdAppProvider");
                        }
                        if (cursorRawQuery3 != null) {
                            cursorRawQuery3.close();
                        }
                        cursorM8080c = null;
                        break;
                    }
                case 204:
                    MatrixCursor matrixCursor = new MatrixCursor(this.f7828a);
                    Cursor cursorQuery = readableDatabase.query("inbox", new String[]{"inbox_no", "inbox_unread_count", "inbox_title", "inbox_participants", "inbox_chat_type"}, "inbox_unread_count > 0", null, null, null, null);
                    if (cursorQuery == null || cursorQuery.getCount() == 0) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } else {
                        while (cursorQuery.moveToNext()) {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no")));
                            arrayList3.add(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_unread_count")));
                            arrayList3.add(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no")));
                            Cursor cursorRawQuery4 = readableDatabase.rawQuery(InterfaceC1406ax.f5236a, (String[]) arrayList3.toArray(new String[0]));
                            if (cursorRawQuery4 == null || cursorRawQuery4.getCount() == 0) {
                                if (cursorRawQuery4 != null) {
                                    cursorRawQuery4.close();
                                }
                            } else {
                                while (cursorRawQuery4.moveToNext()) {
                                    int i = cursorRawQuery4.getInt(cursorRawQuery4.getColumnIndex("message_content_type"));
                                    String string = cursorRawQuery4.getString(cursorRawQuery4.getColumnIndex("message_content"));
                                    String string2 = cursorRawQuery4.getString(cursorRawQuery4.getColumnIndex("buddy_name"));
                                    String string3 = cursorRawQuery4.getString(cursorRawQuery4.getColumnIndex("message_sender"));
                                    MatrixCursor.RowBuilder rowBuilderAdd = matrixCursor.newRow().add(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"))).add(Long.valueOf(cursorRawQuery4.getLong(cursorRawQuery4.getColumnIndex("message_sever_id")))).add(Integer.valueOf(i));
                                    if (EnumC1455w.m6358a(i) != EnumC1455w.TEXT) {
                                        string = m8074a(string, i, string2, true);
                                    }
                                    rowBuilderAdd.add(string).add(string3).add(string2).add(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"))).add(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_participants")))).add(Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type")))).add(Long.valueOf(cursorRawQuery4.getLong(cursorRawQuery4.getColumnIndex("message_time")))).add(m8073a(string3));
                                }
                            }
                        }
                    }
                    cursorM8080c = matrixCursor;
                    break;
                default:
                    if (c1434bjM6288a == null) {
                        cursorM8080c = null;
                        break;
                    } else {
                        cursorM8080c = c1434bjM6288a.m6289a(str, strArr2).m6286a(readableDatabase, strArr, str2);
                        break;
                    }
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("DB query end: " + uri.toString(), "ChatON3rdAppProvider");
                return cursorM8080c;
            }
            return cursorM8080c;
        } catch (SQLiteConstraintException e) {
            C3250y.m11443a(e, "ChatON3rdAppProvider");
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: b */
    private void m8078b() {
        this.f7829c = new UriMatcher(-1);
        this.f7829c.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage/simple_push_message", 201);
        this.f7829c.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage/full_message", 202);
        this.f7829c.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage/participant_list", 203);
        this.f7829c.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage/all_unread_message_list", 204);
        this.f7829c.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage", HttpResponseCode.f13733OK);
    }

    /* renamed from: a */
    private C1434bj m8072a(Uri uri, int i) {
        C1434bj c1434bj = new C1434bj();
        switch (i) {
            case HttpResponseCode.f13733OK /* 200 */:
                return c1434bj.m6288a("appmanage");
            default:
                return c1434bj;
        }
    }

    /* renamed from: a */
    public Cursor m8082a(Cursor cursor) throws Resources.NotFoundException {
        cursor.moveToFirst();
        String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
        long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
        int i = cursor.getInt(cursor.getColumnIndex("message_content_type"));
        String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_sender"));
        String string4 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        if (string4.isEmpty()) {
            string4 = CommonApplication.m11493l().getResources().getString(R.string.unknown);
        }
        String string5 = cursor.getString(cursor.getColumnIndex("inbox_title"));
        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
        int i3 = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        long j2 = cursor.getLong(cursor.getColumnIndex("message_time"));
        String string6 = cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use"));
        boolean zM8081c = m8081c(cursor.getString(cursor.getColumnIndex("buddy_extra_info")), cursor.getString(cursor.getColumnIndex("buddy_sainfo")));
        String strM8074a = m8074a(string2, i, string4, false);
        MatrixCursor matrixCursor = new MatrixCursor(this.f7828a);
        matrixCursor.newRow().add(string).add(Long.valueOf(j)).add(Integer.valueOf(i)).add(strM8074a).add(string3).add(string4).add(string5).add(Integer.valueOf(i2)).add(Integer.valueOf(i3)).add(Long.valueOf(j2)).add(string6).add(Boolean.valueOf(zM8081c));
        return matrixCursor;
    }

    /* renamed from: b */
    public Cursor m8083b(Cursor cursor) throws Resources.NotFoundException {
        cursor.moveToFirst();
        if ("Y".equals(cursor.getString(cursor.getColumnIndex("message_is_truncated")))) {
            return null;
        }
        String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
        long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
        int i = cursor.getInt(cursor.getColumnIndex("message_content_type"));
        String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_sender"));
        String string4 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        String string5 = cursor.getString(cursor.getColumnIndex("inbox_title"));
        if (string4.isEmpty()) {
            string4 = CommonApplication.m11493l().getResources().getString(R.string.unknown);
        }
        String string6 = cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use"));
        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        long j2 = cursor.getLong(cursor.getColumnIndex("message_time"));
        boolean zM8081c = m8081c(cursor.getString(cursor.getColumnIndex("buddy_extra_info")), cursor.getString(cursor.getColumnIndex("buddy_sainfo")));
        MatrixCursor matrixCursor = new MatrixCursor(f7827b);
        MatrixCursor.RowBuilder rowBuilderAdd = matrixCursor.newRow().add(string).add(Long.valueOf(j)).add(Integer.valueOf(i));
        if (EnumC1455w.m6358a(i) != EnumC1455w.TEXT) {
            string2 = m8074a(string2, i, string4, true);
        }
        rowBuilderAdd.add(string2).add(string3).add(string4).add(string5).add(string6).add(Integer.valueOf(i2)).add(Long.valueOf(j2)).add(Boolean.valueOf(zM8081c));
        return matrixCursor;
    }

    /* renamed from: c */
    private Cursor m8080c(Cursor cursor) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"participantId", "participantName"});
        while (cursor.moveToNext()) {
            matrixCursor.newRow().add(cursor.getString(cursor.getColumnIndex("buddy_no"))).add(cursor.getString(cursor.getColumnIndex("buddy_name")));
        }
        return matrixCursor;
    }

    /* renamed from: a */
    public static String m8074a(String str, int i, String str2, boolean z) {
        String str3;
        if (EnumC1455w.m6358a(i) != EnumC1455w.TEXT) {
            String[] strArrSplit = str.split("\n");
            String strM6361a = EnumC1455w.m6361a(EnumC1455w.m6358a(i), str, str2, Query.MIXED.equals(strArrSplit[0]));
            if (EnumC1455w.m6358a(i) == EnumC1455w.AUDIO && strArrSplit.length >= 5 && z) {
                String str4 = strArrSplit[2];
                String str5 = "imei=" + C3171am.m11045a() + "&buddyid=" + strArrSplit[4] + "&filename=" + strArrSplit[3];
                C3250y.m11453c("Audio, urlString : " + str5, "ChatON3rdAppProvider");
                String strM10954a = null;
                try {
                    String strM11411a = GlobalApplication.m6453c().m11411a();
                    if (!TextUtils.isEmpty(strM11411a)) {
                        strM10954a = C3158a.m10954a(new C3158a(C3158a.m10958b(strM11411a), C3158a.m10959c(strM11411a)).m10960b(str5.getBytes()));
                    }
                    str3 = str4 + "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&param=" + strM10954a;
                    C3250y.m11453c("Audio, download Url : " + str3, "ChatON3rdAppProvider");
                } catch (Exception e) {
                    C3250y.m11443a(e, "ChatON3rdAppProvider");
                    return strM6361a;
                }
            } else {
                str3 = strM6361a;
            }
            return str3;
        }
        return str;
    }

    /* renamed from: a */
    private static String m8073a(String str) {
        int i;
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1441i.f5369a, null, "buddy_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return "";
        }
        if (cursorQuery.getCount() == 0) {
            cursorQuery.close();
            return "";
        }
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_msisdns"));
        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_orginal_number"));
        if (m8076a(string, str)) {
            i = m8077b(string).size() == 0 ? 0 : 1;
        } else {
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("buddy_show_phone_number"));
        }
        if (i >= 1) {
            String strM8075a = m8075a(string2, string, str);
            if (C3250y.f11735c) {
                C3250y.m11453c("phone number : " + strM8075a, "ChatON3rdAppProvider");
                return strM8075a;
            }
            return strM8075a;
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("buddy hide phone number", "ChatON3rdAppProvider");
        }
        return "";
    }

    /* renamed from: a */
    private static boolean m8076a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return ((str2.length() >= 19 && str2.startsWith("10")) || str2.startsWith("0")) && !TextUtils.isEmpty(str);
    }

    /* renamed from: b */
    private static List<String> m8077b(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C3250y.m11450b("chaton id : " + strNextToken, "ChatON3rdAppProvider");
                } else if (strNextToken.startsWith("0")) {
                    C3250y.m11450b("pin number : " + strNextToken, "ChatON3rdAppProvider");
                } else {
                    C3250y.m11450b("msisdn: " + strNextToken, "ChatON3rdAppProvider");
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m8075a(String str, String str2, String str3) {
        if (!m8076a(str2, str3)) {
            if (!m8079b(str, str3)) {
                return "+" + str3;
            }
            return str;
        }
        List<String> listM8077b = m8077b(str2);
        if (listM8077b.size() > 0) {
            return "+" + listM8077b.get(0);
        }
        return null;
    }

    /* renamed from: b */
    private static boolean m8079b(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.length() < 19 || !str2.startsWith("10") || TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m8081c(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.contains("voip=1")) {
            return false;
        }
        return true;
    }
}
