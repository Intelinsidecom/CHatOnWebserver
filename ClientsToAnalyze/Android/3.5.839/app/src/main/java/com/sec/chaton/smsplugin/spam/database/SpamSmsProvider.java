package com.sec.chaton.smsplugin.spam.database;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.spam.C4012bp;
import java.util.HashMap;

@TargetApi(14)
/* loaded from: classes.dex */
public class SpamSmsProvider extends ContentProvider {

    /* renamed from: a */
    private static final Uri f14520a = Uri.parse("content://sms/icc");

    /* renamed from: b */
    private static final Uri f14521b = Uri.parse("content://sms/smsc");

    /* renamed from: c */
    private static final Integer f14522c = 1;

    /* renamed from: e */
    private static final HashMap<String, String> f14523e = new HashMap<>();

    /* renamed from: f */
    private static final UriMatcher f14524f;

    /* renamed from: d */
    private SQLiteOpenHelper f14525d;

    static {
        f14523e.put("snippet", "sms.body AS snippet");
        f14523e.put("thread_id", "sms.thread_id AS thread_id");
        f14523e.put("msg_count", "groups.msg_count AS msg_count");
        f14523e.put("delta", null);
        f14524f = m15494a();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f14525d = C4025a.m15497a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        Cursor cursorQuery = null;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        int iMatch = f14524f.match(uri);
        switch (iMatch) {
            case 42:
                sQLiteQueryBuilder.setTables("spam_sms");
                sQLiteQueryBuilder.appendWhere("(_id = " + uri.getPathSegments().get(0) + ")");
                if (TextUtils.isEmpty(str2)) {
                    str3 = sQLiteQueryBuilder.getTables().equals("spam_sms") ? "date DESC" : null;
                } else {
                    str3 = str2;
                }
                cursorQuery = sQLiteQueryBuilder.query(this.f14525d.getReadableDatabase(), strArr, str, strArr2, null, null, str3);
                if (iMatch == 42) {
                    cursorQuery.setNotificationUri(getContext().getContentResolver(), C4012bp.f14470f);
                }
                return cursorQuery;
            default:
                C3890m.m14999e("SpamSmsProvider", "Invalid request: " + uri);
                return cursorQuery;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) throws NumberFormatException {
        switch (uri.getPathSegments().size()) {
            case 0:
                return "vnd.android.cursor.dir/sms";
            case 1:
                try {
                    Integer.parseInt(uri.getPathSegments().get(0));
                    return "vnd.android.cursor.item/sms";
                } catch (NumberFormatException e) {
                    return "vnd.android.cursor.dir/sms";
                }
            case 2:
                if (uri.getPathSegments().get(0).equals("conversations")) {
                    return "vnd.android.cursor.item/sms-chat";
                }
                return "vnd.android.cursor.item/sms";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        switch (f14524f.match(uri)) {
            case 41:
                return m15495a(contentValues);
            default:
                C3890m.m14999e("SpamSmsProvider", "Invalid request: " + uri);
                return null;
        }
    }

    /* renamed from: a */
    private Uri m15495a(ContentValues contentValues) {
        C3890m.m14996b("SpamSmsProvider", "insertSpamSms Start ");
        ContentValues contentValues2 = new ContentValues(contentValues);
        contentValues2.put("type", (Integer) 1);
        if (contentValues2 != null) {
            long jInsert = this.f14525d.getWritableDatabase().insert("spam_sms", "body", contentValues2);
            if (jInsert > 0) {
                Uri uri = Uri.parse("content://" + C4012bp.f14466b + "/" + jInsert);
                C3890m.m14996b("SpamSmsProvider", "insert " + uri + " succeeded");
                m15496a(uri);
                return uri;
            }
            C3890m.m14999e("SpamSmsProvider", "insertSpamSms: failed! " + contentValues2.toString());
        }
        return null;
    }

    /* renamed from: a */
    private void m15496a(Uri uri) {
        ContentResolver contentResolver = getContext().getContentResolver();
        contentResolver.notifyChange(uri, null);
        contentResolver.notifyChange(C4012bp.f14469e, null);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) throws NumberFormatException {
        int iMatch = f14524f.match(uri);
        SQLiteDatabase writableDatabase = this.f14525d.getWritableDatabase();
        C3890m.m14994a("SpamSmsProvider", "Delete uri=" + uri + ", match=" + iMatch);
        switch (iMatch) {
            case 42:
                try {
                    int iDelete = writableDatabase.delete("spam_sms", "_id=" + Integer.parseInt(uri.getPathSegments().get(0)), null);
                    C3890m.m14996b("SpamSmsProvider", "delete deletedRows=" + iDelete);
                    if (iDelete > 0 && iMatch == 42) {
                        m15496a(uri);
                    }
                    if (iMatch != 15) {
                        SpamMmsSmsProvider.m15489a(iDelete, getContext());
                    }
                    return iDelete;
                } catch (Exception e) {
                    C3890m.m14996b("SpamSmsProvider", "Exception:" + e.getMessage());
                    throw new IllegalArgumentException("Bad message id: " + uri.getPathSegments().get(0));
                }
            default:
                throw new IllegalArgumentException("Unknown URL");
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2;
        String str3 = null;
        SQLiteDatabase writableDatabase = this.f14525d.getWritableDatabase();
        int iMatch = f14524f.match(uri);
        C3890m.m14994a("SpamSmsProvider", "Update uri=" + uri + ", match=" + iMatch);
        switch (iMatch) {
            case 40:
            case 41:
                str2 = "spam_sms";
                break;
            case 42:
                str2 = "spam_sms";
                str3 = "_id=" + uri.getPathSegments().get(0);
                break;
            default:
                throw new UnsupportedOperationException("URI " + uri + " not supported");
        }
        int iUpdate = writableDatabase.update(str2, contentValues, DatabaseUtils.concatenateWhere(str, str3), strArr);
        if (iUpdate > 0) {
            C3890m.m14996b("SpamSmsProvider", "update " + uri + " succeeded");
            if (str2.equals("spam_sms")) {
                m15496a(uri);
            }
        }
        return iUpdate;
    }

    /* renamed from: a */
    private static UriMatcher m15494a() {
        String str;
        UriMatcher uriMatcher = new UriMatcher(-1);
        if (C3847e.m14629M()) {
            str = "spamsms";
        } else {
            str = "chaton-spamsms";
        }
        if (uriMatcher != null) {
            uriMatcher.addURI(str, null, 40);
            uriMatcher.addURI(str, "inbox", 41);
            uriMatcher.addURI(str, "#", 42);
        }
        return uriMatcher;
    }
}
