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
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.api.access_token.C1041a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.C2281c;
import com.sec.chaton.p057e.C2283cb;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class ChatON3rdAppProvider extends BaseContentProvider {

    /* renamed from: b */
    public static String[] f11232b = {"inbox_no", "message_id", "message_type", VKApiConst.MESSAGE, "sender_id", "sender_name", "chatroom_title", "sender_phoneNumber", "chat_type", "received_time", "sender_chatonv_available", "message_category", "is_enable_noti", "room_type"};

    /* renamed from: d */
    private UriMatcher f11235d;

    /* renamed from: e */
    private final String[] f11236e = {"transport_type", "_id", "thread_id", "address", "body", "date", "type", "status", "sub", "sub_cs", "date", "m_type", "msg_box"};

    /* renamed from: a */
    String[] f11233a = {"inbox_no", "message_id", "message_type", VKApiConst.MESSAGE, "sender_id", "sender_name", "chatroom_title", "participant_count", "chat_type", "received_time", "sender_phoneNumber", "sender_chatonv_available", "message_category", "is_enable_noti", "room_type"};

    /* renamed from: c */
    String[] f11234c = {"message_id", "sender_name", "received_time"};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0172  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int delete(android.net.Uri r7, java.lang.String r8, java.lang.String[] r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatON3rdAppProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f11235d.match(uri)) {
            case 200:
                return "vnd.chaton.cursor.dir/vnd.chaton.appmanage";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM12495a;
        String str;
        String str2;
        long jInsertOrThrow;
        if (!C1041a.m6138a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        Uri uri2 = ContactsContract.AUTHORITY_URI;
        try {
            try {
                try {
                    try {
                        try {
                            SQLiteDatabase writableDatabase = C2268bn.m10126a(getContext()).getWritableDatabase();
                            int iMatch = this.f11235d.match(uri);
                            ArrayList arrayList = new ArrayList();
                            if (C4904y.f17872b) {
                                C4904y.m18639b("DB insert start: " + uri.toString(), getClass().getSimpleName());
                            }
                            switch (iMatch) {
                                case 200:
                                    jInsertOrThrow = writableDatabase.insertOrThrow("appmanage", null, contentValues);
                                    uri2 = C2281c.f8184a;
                                    arrayList.add(uri2);
                                    break;
                                default:
                                    arrayList.add(ContactsContract.AUTHORITY_URI);
                                    C4904y.m18645d("Unknown Uri : " + uri.toString(), "ChatON3rdAppProvider");
                                    jInsertOrThrow = -1;
                                    break;
                            }
                            if (C4904y.f17872b) {
                                C4904y.m18639b("DB insert end: " + uri.toString(), getClass().getSimpleName());
                            }
                            if (!m12391a() && jInsertOrThrow > -1 && arrayList != null && arrayList.size() > 0) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                                }
                            }
                            arrayList.clear();
                            return uri2;
                        } catch (SQLiteDiskIOException e) {
                            C4904y.m18641c(C4904y.m18631a((Throwable) e), "ChatON3rdAppProvider");
                            uriM12495a = C3037b.m12495a(EnumC3038c.DISK_IO);
                            if (!C4904y.f17872b) {
                                return uriM12495a;
                            }
                            str = "returnUri : " + uriM12495a.toString();
                            str2 = "ChatON3rdAppProvider";
                            C4904y.m18639b(str, str2);
                            return uriM12495a;
                        } catch (SQLiteException e2) {
                            C4904y.m18641c(C4904y.m18631a((Throwable) e2), "ChatON3rdAppProvider");
                            uriM12495a = C3037b.m12495a(EnumC3038c.NORMAL);
                            if (!C4904y.f17872b) {
                                return uriM12495a;
                            }
                            str = "returnUri : " + uriM12495a.toString();
                            str2 = "ChatON3rdAppProvider";
                            C4904y.m18639b(str, str2);
                            return uriM12495a;
                        }
                    } catch (SQLiteConstraintException e3) {
                        C4904y.m18641c(C4904y.m18631a((Throwable) e3), "ChatON3rdAppProvider");
                        uriM12495a = C3037b.m12495a(EnumC3038c.CONSTRAINT);
                        if (!C4904y.f17872b) {
                            return uriM12495a;
                        }
                        str = "returnUri : " + uriM12495a.toString();
                        str2 = "ChatON3rdAppProvider";
                        C4904y.m18639b(str, str2);
                        return uriM12495a;
                    }
                } catch (SQLiteFullException e4) {
                    C4904y.m18641c(C4904y.m18631a((Throwable) e4), "ChatON3rdAppProvider");
                    uriM12495a = C3037b.m12495a(EnumC3038c.FULL);
                    if (!C4904y.f17872b) {
                        return uriM12495a;
                    }
                    str = "returnUri : " + uriM12495a.toString();
                    str2 = "ChatON3rdAppProvider";
                    C4904y.m18639b(str, str2);
                    return uriM12495a;
                }
            } catch (Exception e5) {
                C4904y.m18641c(C4904y.m18631a((Throwable) e5), "ChatON3rdAppProvider");
                uriM12495a = C3037b.m12495a(EnumC3038c.UNKNOWN);
                if (!C4904y.f17872b) {
                    return uriM12495a;
                }
                str = "returnUri : " + uriM12495a.toString();
                str2 = "ChatON3rdAppProvider";
                C4904y.m18639b(str, str2);
                return uriM12495a;
            }
        } finally {
            if (C4904y.f17872b) {
                C4904y.m18639b("returnUri : " + uri2.toString(), "ChatON3rdAppProvider");
            }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m12400b();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x024d A[Catch: SQLiteConstraintException -> 0x00e8, TryCatch #0 {SQLiteConstraintException -> 0x00e8, blocks: (B:6:0x0017, B:8:0x0040, B:9:0x0063, B:11:0x0068, B:12:0x0070, B:14:0x0074, B:16:0x0093, B:18:0x00bc, B:20:0x00c2, B:22:0x00c6, B:23:0x00e0, B:27:0x00f1, B:29:0x00f5, B:31:0x0111, B:33:0x0117, B:35:0x011b, B:36:0x0124, B:38:0x0133, B:40:0x0148, B:42:0x014e, B:44:0x0157, B:45:0x0168, B:47:0x019a, B:48:0x01a5, B:53:0x0255, B:54:0x0267, B:56:0x026b, B:50:0x024d, B:59:0x027a, B:61:0x02a3, B:63:0x02a9, B:64:0x02b2, B:66:0x02b6, B:68:0x02d2, B:70:0x02d8, B:72:0x02e1, B:74:0x02e7, B:75:0x02f0, B:77:0x02f4, B:79:0x0313, B:81:0x0319, B:83:0x032a, B:84:0x032e, B:86:0x0334, B:88:0x0342, B:89:0x0351, B:92:0x0367, B:95:0x03e6, B:96:0x03f1, B:98:0x03f6, B:99:0x0408, B:101:0x0412, B:103:0x0417, B:106:0x042a, B:108:0x0434, B:110:0x043a, B:111:0x0443, B:113:0x0447, B:115:0x0452), top: B:117:0x0017 }] */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.Cursor query(android.net.Uri r10, java.lang.String[] r11, java.lang.String r12, java.lang.String[] r13, java.lang.String r14) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatON3rdAppProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: b */
    private void m12400b() {
        this.f11235d = new UriMatcher(-1);
        this.f11235d.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage/simple_push_message", 201);
        this.f11235d.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage/simple_push_native_message", 206);
        this.f11235d.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage/full_message", 202);
        this.f11235d.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage/participant_list", 203);
        this.f11235d.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage/all_unread_message_list", 204);
        this.f11235d.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage/missed_call_log", 205);
        this.f11235d.addURI("com.sec.chaton.provider.chaton3rdApp", "appmanage", 200);
    }

    /* renamed from: a */
    private C2283cb m12394a(Uri uri, int i) {
        C2283cb c2283cb = new C2283cb();
        switch (i) {
            case 200:
                return c2283cb.m10145a("appmanage");
            default:
                return c2283cb;
        }
    }

    /* renamed from: a */
    public Cursor m12406a(Cursor cursor) throws Resources.NotFoundException {
        cursor.moveToFirst();
        String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
        long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
        int i = cursor.getInt(cursor.getColumnIndex("message_content_type"));
        String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_sender"));
        String string4 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        if (TextUtils.isEmpty(string4)) {
            string4 = CommonApplication.m18732r().getResources().getString(R.string.unknown);
        }
        String string5 = cursor.getString(cursor.getColumnIndex("inbox_title"));
        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
        int i3 = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        long j2 = cursor.getLong(cursor.getColumnIndex("message_time"));
        String string6 = cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use"));
        boolean zM12404c = m12404c(cursor.getString(cursor.getColumnIndex("buddy_extra_info")), cursor.getString(cursor.getColumnIndex("buddy_sainfo")));
        String strM12396a = m12396a(string2, i, string4, false);
        MatrixCursor matrixCursor = new MatrixCursor(this.f11233a);
        matrixCursor.newRow().add(string).add(Long.valueOf(j)).add(Integer.valueOf(i)).add(strM12396a).add(string3).add(string4).add(string5).add(Integer.valueOf(i2)).add(Integer.valueOf(i3)).add(Long.valueOf(j2)).add(string6).add(Boolean.valueOf(zM12404c)).add(0).add(cursor.getString(cursor.getColumnIndex("inbox_enable_noti"))).add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("inbox_room_type"))));
        return matrixCursor;
    }

    /* renamed from: b */
    public Cursor m12407b(Cursor cursor) throws Resources.NotFoundException {
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
        if (TextUtils.isEmpty(string4)) {
            string4 = CommonApplication.m18732r().getResources().getString(R.string.unknown);
        }
        String string6 = cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use"));
        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        long j2 = cursor.getLong(cursor.getColumnIndex("message_time"));
        boolean zM12404c = m12404c(cursor.getString(cursor.getColumnIndex("buddy_extra_info")), cursor.getString(cursor.getColumnIndex("buddy_sainfo")));
        MatrixCursor matrixCursor = new MatrixCursor(f11232b);
        MatrixCursor.RowBuilder rowBuilderAdd = matrixCursor.newRow().add(string).add(Long.valueOf(j)).add(Integer.valueOf(i));
        if (EnumC2214ab.m10070a(i) != EnumC2214ab.TEXT) {
            string2 = m12396a(string2, i, string4, true);
        }
        rowBuilderAdd.add(string2).add(string3).add(string4).add(string5).add(string6).add(Integer.valueOf(i2)).add(Long.valueOf(j2)).add(Boolean.valueOf(zM12404c)).add(0).add(cursor.getString(cursor.getColumnIndex("inbox_enable_noti"))).add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("inbox_room_type"))));
        return matrixCursor;
    }

    /* renamed from: c */
    private Cursor m12402c(Cursor cursor) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"participantId", "participantName"});
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
            String string2 = cursor.getString(cursor.getColumnIndex("buddy_name"));
            if (TextUtils.isEmpty(string2)) {
                string2 = string;
            }
            matrixCursor.newRow().add(string).add(string2);
        }
        return matrixCursor;
    }

    /* renamed from: d */
    private Cursor m12405d(Cursor cursor) {
        MatrixCursor matrixCursor = new MatrixCursor(this.f11234c);
        if (cursor.moveToFirst()) {
            String string = cursor.getString(cursor.getColumnIndex("_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("userid"));
            if (C4809aa.m18104a().m18121a("chaton_id", "").equals(string2)) {
            }
            String string3 = cursor.getString(cursor.getColumnIndex("username"));
            String string4 = cursor.getString(cursor.getColumnIndex("buddy_name"));
            if (!TextUtils.isEmpty(string4)) {
                string2 = string4;
            } else if (!TextUtils.isEmpty(string3)) {
                string2 = string3;
            }
            matrixCursor.newRow().add(string).add(string2).add(cursor.getString(cursor.getColumnIndex("calldate")));
        }
        return matrixCursor;
    }

    /* renamed from: a */
    public static String m12396a(String str, int i, String str2, boolean z) {
        String str3;
        if (EnumC2214ab.m10070a(i) != EnumC2214ab.TEXT) {
            String[] strArrSplit = str.split("\n");
            String strM10073a = EnumC2214ab.m10073a(EnumC2214ab.m10070a(i), str, str2, "mixed".equals(strArrSplit[0]));
            if (EnumC2214ab.m10070a(i) == EnumC2214ab.AUDIO && strArrSplit.length >= 5 && z) {
                String str4 = strArrSplit[2];
                String str5 = "imei=" + C4822an.m18228d() + "&buddyid=" + strArrSplit[4] + "&filename=" + strArrSplit[3];
                C4904y.m18641c("Audio, urlString : " + str5, "ChatON3rdAppProvider");
                String strM18098a = null;
                try {
                    String strM18595a = GlobalApplication.m10284c().m18595a();
                    if (!TextUtils.isEmpty(strM18595a)) {
                        strM18098a = C4808a.m18098a(new C4808a(C4808a.m18100b(strM18595a), C4808a.m18101c(strM18595a)).m18102b(str5.getBytes()));
                    }
                    str3 = str4 + "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&param=" + strM18098a;
                    C4904y.m18641c("Audio, download Url : " + str3, "ChatON3rdAppProvider");
                } catch (Exception e) {
                    C4904y.m18635a(e, "ChatON3rdAppProvider");
                    return strM10073a;
                }
            } else {
                str3 = strM10073a;
            }
            return str3;
        }
        return str;
    }

    /* renamed from: a */
    private static String m12395a(String str) {
        int i;
        Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2289i.f8196a, null, "buddy_no=?", new String[]{str}, null);
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
        if (m12398a(string, str)) {
            i = m12399b(string).size() == 0 ? 0 : 1;
        } else {
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("buddy_show_phone_number"));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (i >= 1) {
            String strM12397a = m12397a(string2, string, str);
            if (C4904y.f17873c) {
                C4904y.m18641c("phone number : " + strM12397a, "ChatON3rdAppProvider");
                return strM12397a;
            }
            return strM12397a;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("buddy hide phone number", "ChatON3rdAppProvider");
        }
        return "";
    }

    /* renamed from: a */
    private static boolean m12398a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return ((str2.length() >= 19 && str2.startsWith("10")) || str2.startsWith(Spam.ACTIVITY_CANCEL)) && !TextUtils.isEmpty(str);
    }

    /* renamed from: b */
    private static List<String> m12399b(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C4904y.m18639b("chaton id : " + strNextToken, "ChatON3rdAppProvider");
                } else if (strNextToken.startsWith(Spam.ACTIVITY_CANCEL)) {
                    C4904y.m18639b("pin number : " + strNextToken, "ChatON3rdAppProvider");
                } else {
                    C4904y.m18639b("msisdn: " + strNextToken, "ChatON3rdAppProvider");
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m12397a(String str, String str2, String str3) {
        if (!m12398a(str2, str3)) {
            if (!m12401b(str, str3)) {
                return "+" + str3;
            }
            return str;
        }
        List<String> listM12399b = m12399b(str2);
        if (listM12399b.size() > 0) {
            return "+" + listM12399b.get(0);
        }
        return null;
    }

    /* renamed from: b */
    private static boolean m12401b(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.length() < 19 || !str2.startsWith("10") || TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m12404c(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.contains("voip=1")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x03e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0047 A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.ArrayList<com.sec.chaton.chat.notification.C1830s> m12403c() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatON3rdAppProvider.m12403c():java.util.ArrayList");
    }
}
