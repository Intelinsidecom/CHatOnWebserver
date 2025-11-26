package com.sec.chaton.localbackup.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.common.util.C3364o;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BackupContentProvider extends ContentProvider {

    /* renamed from: b */
    private static final String f6099b = "SELECT * FROM(SELECT ifnull(c.buddy_name,'') AS buddy_name,ifnull(c.buddy_no,a.message_sender) AS buddy_no,a.message_content,a.message_content_type,a.message_download_uri,a.message_formatted,a._id,a.message_inbox_no,a.message_sender,a.message_sever_id,a.message_session_id,a.message_time,a.message_is_failed,a.message_is_file_upload,a.message_type FROM ( SELECT * FROM message WHERE message_inbox_no = ? AND (message_is_truncated = 'N' OR message_content_type = " + String.valueOf(EnumC1455w.TEXT.m6364a()) + ") AND message_content_type != " + EnumC1455w.SYSTEM.m6364a() + " ORDER BY message_is_failed DESC , message_time DESC , _id DESC LIMIT ? ) a LEFT OUTER JOIN (SELECT p.participants_buddy_no AS buddy_no, ifnull(b.buddy_name, p.participants_buddy_name) AS buddy_name FROM participant p LEFT OUTER JOIN buddy b ON p.participants_buddy_no = b.buddy_no WHERE p.participants_inbox_no = ? OR p.participants_inbox_no = '' GROUP BY buddy_no) c ON a.message_sender = c.buddy_no) d ORDER BY message_is_failed , message_time , _id";

    /* renamed from: c */
    private static final String f6100c = C3364o.m11849a("SELECT ", "a.*, ", "r.", "buddy_no", " AS ", "relation_buddy_no", "\tFROM ( ", " SELECT ", "j.", "buddy_no", ", ", "j.", "buddy_name", ", ", "i.*", " FROM ", "inbox", " i", " LEFT OUTER JOIN ", "( ", "SELECT ", "p.", "participants_buddy_no", " AS ", "buddy_no", ", ", "ifnull(", "b.", "buddy_name", ", ", "p.", "participants_buddy_name", ")", " AS ", "buddy_name", ",", "p.", "participants_inbox_no", " FROM ", "participant", " p", " LEFT OUTER JOIN ", "buddy", " b ", " ON ", "p.", "participants_buddy_no", " = ", "b.", "buddy_no", " WHERE ", "p.", "participants_inbox_no", " NOT null", " ) j ", " ON ", "i.", "inbox_no", " = ", "j.", "participants_inbox_no", " WHERE ", "i.", "inbox_last_chat_type", " != ", 12, " AND ", "i.", "inbox_valid", " = '", "Y", "' ", " AND ", "i.", "inbox_no", " != ?", " AND ", "i.", "inbox_web_url", " IS null", " GROUP BY ", "i.", "inbox_no", " ) a ", " LEFT OUTER JOIN ", "inbox_buddy_relation", " r ", " ON ", "a.", "inbox_no", " = ", "r.", "inbox_no", " ORDER BY ", "inbox_last_time", " DESC, a._id");

    /* renamed from: a */
    private UriMatcher f6101a;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m6915a();
        return true;
    }

    /* renamed from: a */
    private void m6915a() {
        this.f6101a = new UriMatcher(-1);
        this.f6101a.addURI("com.sec.chaton.localbackup", "inbox/path_inbox", 1);
        this.f6101a.addURI("com.sec.chaton.localbackup", "message/path_message/*", 3);
        this.f6101a.addURI("com.sec.chaton.localbackup", "message/path_update_media", 4);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase = C1642b.m6919a().getReadableDatabase();
        switch (this.f6101a.match(uri)) {
            case 1:
                return readableDatabase.rawQuery(f6100c, strArr2);
            case 2:
            default:
                return readableDatabase.query("message", strArr, str, strArr2, null, null, str2);
            case 3:
                String strM6353c = C1454v.m6353c(uri);
                if (TextUtils.isEmpty(strM6353c)) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (String str3 : strArr2) {
                    arrayList.add(str3);
                }
                arrayList.add(strM6353c);
                arrayList.add(arrayList.get(0));
                return readableDatabase.rawQuery(f6099b, (String[]) arrayList.toArray(new String[0]));
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f6101a.match(uri)) {
            case 1:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 2:
            default:
                return null;
            case 3:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 4:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = C1642b.m6919a().getWritableDatabase();
        switch (this.f6101a.match(uri)) {
            case 4:
                int iUpdate = writableDatabase.update("message", contentValues, str, strArr);
                getContext().getContentResolver().notifyChange(uri, null);
                return iUpdate;
            default:
                return -1;
        }
    }
}
