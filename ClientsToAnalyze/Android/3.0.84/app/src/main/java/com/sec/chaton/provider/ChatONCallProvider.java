package com.sec.chaton.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.provider.ContactsContract;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.C1434bj;
import com.sec.chaton.p027e.C1438f;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChatONCallProvider extends BaseContentProvider {

    /* renamed from: a */
    private UriMatcher f7830a;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m8086b();
        return true;
    }

    /* renamed from: b */
    private void m8086b() {
        this.f7830a = new UriMatcher(-1);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/search_rejected_call_log", 114);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/search_received_call_log", 113);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/search_dialed_call_log", 112);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/search_missed_call_log", 111);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/get_index_call_log", 110);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/search_all_call_log", 109);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/call_log_by_user_no", 108);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/rejected_call_log", 107);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/missed_call_log", 106);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/lastest_call_log_by_user_no", 105);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/lastest_call_log_by_user_id", 104);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/oldest_group_call_key", 103);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/delete_oldest_group_calllog", 102);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog/delete_oldest_calllog", 101);
        this.f7830a.addURI("com.sec.chaton.provider.call", "calllog", 100);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f7830a.match(uri)) {
            case 100:
            case 109:
                return "vnd.chaton.cursor.dir/vnd.chaton.call.log";
            default:
                return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x025f: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:61:0x025f */
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) throws Throwable {
        int i;
        int i2;
        String str2;
        String str3;
        int i3 = -1;
        try {
        } catch (Throwable th) {
            th = th;
            i3 = i;
        }
        try {
            try {
                SQLiteDatabase writableDatabase = C1404av.m6253a(getContext()).getWritableDatabase();
                C3250y.m11450b("DB delete: " + uri.toString(), getClass().getSimpleName());
                int iMatch = this.f7830a.match(uri);
                ArrayList arrayList = new ArrayList();
                switch (iMatch) {
                    case 101:
                        StringBuilder sb = new StringBuilder();
                        sb.append("_id").append(" = ").append("( ").append("SELECT ").append("MIN(").append("_id").append(" FROM ").append("calllog").append(" )");
                        str = sb.toString();
                        strArr = null;
                        break;
                    case 102:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("_id").append(" IN ").append("( ").append("SELECT ").append("_id").append(" FROM ").append("calllog").append(" WHERE ").append("groupcallkey").append(" = ").append("( ").append("SELECT ").append("MAX(").append("groupcallkey").append(" FROM ").append("calllog").append(" )").append(" )");
                        str = sb2.toString();
                        strArr = null;
                        break;
                }
                int iM6284a = m8084a(uri, iMatch).m6289a(str, strArr).m6284a(writableDatabase);
                try {
                    arrayList.add(uri);
                    if (!m8070a() && iM6284a > -1 && arrayList != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                        }
                    }
                    C3250y.m11450b("DB delete end : " + uri.toString(), getClass().getSimpleName());
                    if (C3250y.f11734b) {
                        C3250y.m11450b("returnInteger : " + String.valueOf(iM6284a), "ChatONCallProvider");
                    }
                    return iM6284a;
                } catch (SQLiteConstraintException e) {
                    e = e;
                    C3250y.m11443a(e, "ChatONCallProvider");
                    i2 = -3;
                    if (!C3250y.f11734b) {
                        return -3;
                    }
                    str2 = "returnInteger : " + String.valueOf(-3);
                    str3 = "ChatONCallProvider";
                    C3250y.m11450b(str2, str3);
                    return i2;
                } catch (SQLiteDiskIOException e2) {
                    e = e2;
                    C3250y.m11443a(e, "ChatONCallProvider");
                    i2 = -5;
                    if (!C3250y.f11734b) {
                        return -5;
                    }
                    str2 = "returnInteger : " + String.valueOf(-5);
                    str3 = "ChatONCallProvider";
                    C3250y.m11450b(str2, str3);
                    return i2;
                } catch (SQLiteFullException e3) {
                    e = e3;
                    C3250y.m11443a(e, "ChatONCallProvider");
                    i2 = -4;
                    if (!C3250y.f11734b) {
                        return -4;
                    }
                    str2 = "returnInteger : " + String.valueOf(-4);
                    str3 = "ChatONCallProvider";
                    C3250y.m11450b(str2, str3);
                    return i2;
                } catch (SQLiteException e4) {
                    e = e4;
                    C3250y.m11443a(e, "ChatONCallProvider");
                    i2 = -2;
                    if (!C3250y.f11734b) {
                        return -2;
                    }
                    str2 = "returnInteger : " + String.valueOf(-2);
                    str3 = "ChatONCallProvider";
                    C3250y.m11450b(str2, str3);
                    return i2;
                } catch (Exception e5) {
                    e = e5;
                    C3250y.m11443a(e, "ChatONCallProvider");
                    if (C3250y.f11734b) {
                        C3250y.m11450b("returnInteger : " + String.valueOf(-1), "ChatONCallProvider");
                    }
                    return -1;
                }
            } catch (SQLiteConstraintException e6) {
                e = e6;
            } catch (SQLiteDiskIOException e7) {
                e = e7;
            } catch (SQLiteFullException e8) {
                e = e8;
            } catch (SQLiteException e9) {
                e = e9;
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
            if (C3250y.f11734b) {
                C3250y.m11450b("returnInteger : " + String.valueOf(i3), "ChatONCallProvider");
            }
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM8117a;
        String str;
        String str2;
        long jInsertOrThrow;
        Uri uri2 = ContactsContract.AUTHORITY_URI;
        try {
            try {
                try {
                    try {
                        try {
                            SQLiteDatabase writableDatabase = C1404av.m6253a(getContext()).getWritableDatabase();
                            int iMatch = this.f7830a.match(uri);
                            ArrayList arrayList = new ArrayList();
                            if (C3250y.f11734b) {
                                C3250y.m11450b("DB insert start: " + uri.toString(), getClass().getSimpleName());
                            }
                            switch (iMatch) {
                                case 100:
                                    jInsertOrThrow = writableDatabase.insertOrThrow("calllog", null, contentValues);
                                    uri2 = C1438f.f5365a;
                                    arrayList.add(uri2);
                                    break;
                                default:
                                    arrayList.add(ContactsContract.AUTHORITY_URI);
                                    C3250y.m11455d("Unknown Uri : " + uri.toString(), "ChatONCallProvider");
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
                            C3250y.m11443a(e, "ChatONCallProvider");
                            uriM8117a = C2036a.m8117a(EnumC2039b.DISK_IO);
                            if (!C3250y.f11734b) {
                                return uriM8117a;
                            }
                            str = "returnUri : " + uriM8117a.toString();
                            str2 = "ChatONCallProvider";
                            C3250y.m11450b(str, str2);
                            return uriM8117a;
                        } catch (Exception e2) {
                            C3250y.m11443a(e2, "ChatONCallProvider");
                            uriM8117a = C2036a.m8117a(EnumC2039b.UNKNOWN);
                            if (!C3250y.f11734b) {
                                return uriM8117a;
                            }
                            str = "returnUri : " + uriM8117a.toString();
                            str2 = "ChatONCallProvider";
                            C3250y.m11450b(str, str2);
                            return uriM8117a;
                        }
                    } catch (SQLiteConstraintException e3) {
                        C3250y.m11443a(e3, "ChatONCallProvider");
                        uriM8117a = C2036a.m8117a(EnumC2039b.CONSTRAINT);
                        if (!C3250y.f11734b) {
                            return uriM8117a;
                        }
                        str = "returnUri : " + uriM8117a.toString();
                        str2 = "ChatONCallProvider";
                        C3250y.m11450b(str, str2);
                        return uriM8117a;
                    }
                } catch (SQLiteFullException e4) {
                    C3250y.m11443a(e4, "ChatONCallProvider");
                    uriM8117a = C2036a.m8117a(EnumC2039b.FULL);
                    if (!C3250y.f11734b) {
                        return uriM8117a;
                    }
                    str = "returnUri : " + uriM8117a.toString();
                    str2 = "ChatONCallProvider";
                    C3250y.m11450b(str, str2);
                    return uriM8117a;
                }
            } catch (SQLiteException e5) {
                C3250y.m11443a(e5, "ChatONCallProvider");
                uriM8117a = C2036a.m8117a(EnumC2039b.NORMAL);
                if (!C3250y.f11734b) {
                    return uriM8117a;
                }
                str = "returnUri : " + uriM8117a.toString();
                str2 = "ChatONCallProvider";
                C3250y.m11450b(str, str2);
                return uriM8117a;
            }
        } finally {
            if (C3250y.f11734b) {
                C3250y.m11450b("returnUri : " + uri2.toString(), "ChatONCallProvider");
            }
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorRawQuery;
        try {
            try {
                try {
                    try {
                        try {
                            SQLiteDatabase readableDatabase = C1404av.m6253a(getContext()).getReadableDatabase();
                            int iMatch = this.f7830a.match(uri);
                            C1434bj c1434bjM8085b = m8085b(uri, iMatch);
                            if (C3250y.f11734b) {
                                C3250y.m11450b("DB query : " + uri.toString(), getClass().getSimpleName());
                            }
                            switch (iMatch) {
                                case 103:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT groupcallkey FROM calllog WHERE _id = (SELECT MIN(_id) FROM calllog)", null);
                                    break;
                                case 104:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM calllog WHERE _id = (SELECT max(_id) FROM calllog WHERE userid = ? AND groupid = ? AND rejectmsg IS NULL)", strArr2);
                                    break;
                                case 105:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM calllog WHERE _id = (SELECT max(_id) FROM calllog WHERE userno = ? AND groupid = ? AND rejectmsg IS NULL)", strArr2);
                                    break;
                                case 106:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT c.*, b.buddy_name buddy_name FROM (SELECT * FROM calllog where (CASE (SELECT groupcallkey FROM calllog WHERE _id = ( SELECT MAX(_id) FROM calllog WHERE calllogtype =2 ORDER BY _id DESC)) WHEN 0 THEN _id = (SELECT MAX(_id) FROM calllog WHERE calllogtype = 2 ORDER BY _id DESC) ELSE groupcallkey = (SELECT MAX(groupcallkey) FROM calllog WHERE calllogtype = 2 ORDER BY _id DESC)END)) c LEFT OUTER JOIN buddy b  ON c.userid = b.buddy_no", strArr2);
                                    break;
                                case 107:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT *, MAX(_id) FROM calllog WHERE rejectmsg IS NOT NULL AND groupcallkey = 0 ORDER BY _id DESC", strArr2);
                                    break;
                                case 108:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT _id, calldate, userid, username, duration, calllogtype, callmethod, countrycode, rejectmsg, groupcallkey FROM calllog WHERE userno= ? OR groupcallkey IN  (SELECT _id FROM calllog WHERE groupcallkey IN  (SELECT groupcallkey FROM calllog WHERE userno= ?)) ORDER BY _id DESC", strArr2);
                                    break;
                                case 109:
                                default:
                                    if (c1434bjM8085b == null) {
                                        cursorRawQuery = null;
                                        break;
                                    } else {
                                        cursorRawQuery = c1434bjM8085b.m6289a(str, strArr2).m6286a(readableDatabase, strArr, str2);
                                        break;
                                    }
                                case 110:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT SEQ FROM SQLITE_SEQUENCE WHERE NAME = 'calllog'", null);
                                    break;
                                case 111:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT c._id _id, c.calldate calldate, c.userid userid, c.username username, b.buddy_name buddy_name, b.buddy_status_message buddy_status_message, b.buddy_orginal_number buddy_orginal_number, b.buddy_raw_contact_id buddy_raw_contact_id, b.buddy_show_phone_number buddy_show_phone_number, b.buddy_extra_info buddy_extra_info, b.buddy_msisdns buddy_msisdns, c.duration duration, c.calllogtype calllogtype, c.callmethod callmethod, c.rejectmsg rejectmsg, c.groupcallkey groupcallkey FROM calllog c LEFT OUTER JOIN buddy b  ON c.userid = b.buddy_no WHERE c.calllogtype=2 OR groupcallkey IN  (SELECT _id FROM calllog WHERE groupcallkey IN  (SELECT groupcallkey FROM calllog WHERE calllogtype=2))", null);
                                    break;
                                case 112:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT c._id _id, c.calldate calldate, c.userid userid, c.username username, b.buddy_name buddy_name, b.buddy_status_message buddy_status_message, b.buddy_orginal_number buddy_orginal_number, b.buddy_raw_contact_id buddy_raw_contact_id, b.buddy_show_phone_number buddy_show_phone_number, b.buddy_extra_info buddy_extra_info, b.buddy_msisdns buddy_msisdns, c.duration duration, c.calllogtype calllogtype, c.callmethod callmethod, c.rejectmsg rejectmsg, c.groupcallkey groupcallkey FROM calllog c LEFT OUTER JOIN buddy b  ON c.userid = b.buddy_no WHERE c.calllogtype=1 OR groupcallkey IN  (SELECT _id FROM calllog WHERE groupcallkey IN  (SELECT groupcallkey FROM calllog WHERE calllogtype=1)) AND c.callmethod<>12", null);
                                    break;
                                case 113:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT c._id _id, c.calldate calldate, c.userid userid, c.username username, b.buddy_name buddy_name, b.buddy_status_message buddy_status_message, b.buddy_orginal_number buddy_orginal_number, b.buddy_raw_contact_id buddy_raw_contact_id, b.buddy_show_phone_number buddy_show_phone_number, b.buddy_extra_info buddy_extra_info, b.buddy_msisdns buddy_msisdns, c.duration duration, c.calllogtype calllogtype, c.callmethod callmethod, c.rejectmsg rejectmsg, c.groupcallkey groupcallkey FROM calllog c LEFT OUTER JOIN buddy b  ON c.userid = b.buddy_no WHERE c.calllogtype=0 OR groupcallkey IN  (SELECT _id FROM calllog WHERE groupcallkey IN  (SELECT groupcallkey FROM calllog WHERE calllogtype=0)) AND c.callmethod<>12", null);
                                    break;
                                case 114:
                                    cursorRawQuery = readableDatabase.rawQuery("SELECT c._id _id, c.calldate calldate, c.userid userid, c.username username, b.buddy_name buddy_name, b.buddy_status_message buddy_status_message, b.buddy_orginal_number buddy_orginal_number, b.buddy_raw_contact_id buddy_raw_contact_id, b.buddy_show_phone_number buddy_show_phone_number, b.buddy_extra_info buddy_extra_info, b.buddy_msisdns buddy_msisdns, c.duration duration, c.calllogtype calllogtype, c.callmethod callmethod, c.rejectmsg rejectmsg, c.groupcallkey groupcallkey FROM calllog c LEFT OUTER JOIN buddy b  ON c.userid = b.buddy_no WHERE c.calllogtype=3 OR groupcallkey IN  (SELECT _id FROM calllog WHERE groupcallkey IN  (SELECT groupcallkey FROM calllog WHERE calllogtype=3)) OR c.callmethod=12", null);
                                    break;
                            }
                            if (C3250y.f11734b) {
                                C3250y.m11450b("DB query end: " + uri.toString(), getClass().getSimpleName());
                                return cursorRawQuery;
                            }
                            return cursorRawQuery;
                        } catch (Exception e) {
                            C3250y.m11443a(e, "ChatONCallProvider");
                            return null;
                        }
                    } catch (SQLiteException e2) {
                        C3250y.m11443a(e2, "ChatONCallProvider");
                        return null;
                    }
                } catch (SQLiteFullException e3) {
                    C3250y.m11443a(e3, "ChatONCallProvider");
                    return null;
                }
            } catch (SQLiteDiskIOException e4) {
                C3250y.m11443a(e4, "ChatONCallProvider");
                return null;
            }
        } catch (SQLiteConstraintException e5) {
            C3250y.m11443a(e5, "ChatONCallProvider");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0190  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int update(android.net.Uri r8, android.content.ContentValues r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONCallProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* renamed from: a */
    private C1434bj m8084a(Uri uri, int i) {
        C1434bj c1434bj = new C1434bj();
        switch (i) {
            case 100:
            case 101:
            case 102:
                return c1434bj.m6288a("calllog");
            default:
                return c1434bj;
        }
    }

    /* renamed from: b */
    private C1434bj m8085b(Uri uri, int i) {
        C1434bj c1434bj = new C1434bj();
        switch (i) {
            case 100:
                return c1434bj.m6288a("calllog");
            case 109:
                return c1434bj.m6288a("( SELECT c._id _id, c.calldate calldate, c.userid userid, c.username username, b.buddy_name buddy_name, b.buddy_status_message buddy_status_message, b.buddy_orginal_number buddy_orginal_number, b.buddy_raw_contact_id buddy_raw_contact_id, b.buddy_show_phone_number buddy_show_phone_number, b.buddy_extra_info buddy_extra_info, b.buddy_msisdns buddy_msisdns, c.duration duration, c.calllogtype calllogtype, c.callmethod callmethod, c.rejectmsg rejectmsg, c.groupcallkey groupcallkey FROM calllog c LEFT OUTER JOIN buddy b  ON c.userid = b.buddy_no)");
            default:
                return null;
        }
    }
}
