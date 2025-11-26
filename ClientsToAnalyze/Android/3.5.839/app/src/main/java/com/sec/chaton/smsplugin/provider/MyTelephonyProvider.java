package com.sec.chaton.smsplugin.provider;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.spp.push.Config;
import java.io.File;

@TargetApi(14)
/* loaded from: classes.dex */
public class MyTelephonyProvider extends ContentProvider {

    /* renamed from: a */
    private static final UriMatcher f14203a = new UriMatcher(-1);

    /* renamed from: b */
    private static final ContentValues f14204b;

    /* renamed from: c */
    private static final ContentValues f14205c;

    /* renamed from: d */
    private C3955m f14206d;

    static {
        f14203a.addURI("chaton-telephony", "carriers", 1);
        f14203a.addURI("chaton-telephony", "carriers/current", 2);
        f14203a.addURI("chaton-telephony", "carriers/#", 3);
        f14203a.addURI("chaton-telephony", "carriers/restore", 4);
        f14203a.addURI("chaton-telephony", "carriers/preferapn", 5);
        f14204b = new ContentValues(1);
        f14204b.put("current", (Long) null);
        f14205c = new ContentValues(1);
        f14205c.put("current", Spam.ACTIVITY_REPORT);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Log.w("TelephonyProvider", "onCreate: confFile=" + new File(Environment.getRootDirectory(), "etc/apns-conf.xml").getAbsolutePath() + " oldCheckSum=" + m15219b());
        this.f14206d = new C3955m(getContext());
        return true;
    }

    /* renamed from: a */
    private void m15218a(Long l) {
        SharedPreferences.Editor editorEdit = getContext().getSharedPreferences("preferred-apn", 0).edit();
        editorEdit.putLong("apn_id", l != null ? l.longValue() : -1L);
        editorEdit.apply();
    }

    /* renamed from: a */
    private long m15217a() {
        return getContext().getSharedPreferences("preferred-apn", 0).getLong("apn_id", -1L);
    }

    /* renamed from: b */
    private long m15219b() {
        return getContext().getSharedPreferences("preferred-apn", 0).getLong("apn_conf_checksum", -1L);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("carriers");
        switch (f14203a.match(uri)) {
            case 1:
                break;
            case 2:
                sQLiteQueryBuilder.appendWhere("current IS NOT NULL");
                break;
            case 3:
                sQLiteQueryBuilder.appendWhere("_id = " + uri.getPathSegments().get(1));
                break;
            case 4:
            default:
                return null;
            case 5:
                sQLiteQueryBuilder.appendWhere("_id = " + m15217a());
                break;
        }
        Cursor cursorQuery = sQLiteQueryBuilder.query(this.f14206d.getReadableDatabase(), strArr, str, strArr2, null, null, str2);
        cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f14203a.match(uri)) {
            case 1:
                return "vnd.android.cursor.dir/telephony-carrier";
            case 2:
            case 4:
            default:
                throw new IllegalArgumentException("Unknown URL " + uri);
            case 3:
                return "vnd.android.cursor.item/telephony-carrier";
            case 5:
                return "vnd.android.cursor.item/telephony-carrier";
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uri2;
        ContentValues contentValues2;
        Uri uriWithAppendedId;
        boolean z = true;
        boolean z2 = false;
        m15220c();
        SQLiteDatabase writableDatabase = this.f14206d.getWritableDatabase();
        switch (f14203a.match(uri)) {
            case 1:
                if (contentValues != null) {
                    contentValues2 = new ContentValues(contentValues);
                } else {
                    contentValues2 = new ContentValues();
                }
                if (!contentValues2.containsKey("name")) {
                    contentValues2.put("name", "");
                }
                if (!contentValues2.containsKey("apn")) {
                    contentValues2.put("apn", "");
                }
                if (!contentValues2.containsKey(Config.COLUMN_PORT)) {
                    contentValues2.put(Config.COLUMN_PORT, "");
                }
                if (!contentValues2.containsKey("proxy")) {
                    contentValues2.put("proxy", "");
                }
                if (!contentValues2.containsKey("user")) {
                    contentValues2.put("user", "");
                }
                if (!contentValues2.containsKey("server")) {
                    contentValues2.put("server", "");
                }
                if (!contentValues2.containsKey("password")) {
                    contentValues2.put("password", "");
                }
                if (!contentValues2.containsKey("mmsport")) {
                    contentValues2.put("mmsport", "");
                }
                if (!contentValues2.containsKey("mmsproxy")) {
                    contentValues2.put("mmsproxy", "");
                }
                if (!contentValues2.containsKey("authtype")) {
                    contentValues2.put("authtype", (Integer) (-1));
                }
                if (!contentValues2.containsKey("protocol")) {
                    contentValues2.put("protocol", "IP");
                }
                if (!contentValues2.containsKey("roaming_protocol")) {
                    contentValues2.put("roaming_protocol", "IP");
                }
                if (!contentValues2.containsKey("carrier_enabled")) {
                    contentValues2.put("carrier_enabled", (Boolean) true);
                }
                if (!contentValues2.containsKey("bearer")) {
                    contentValues2.put("bearer", (Integer) 0);
                }
                long jInsert = writableDatabase.insert("carriers", null, contentValues2);
                if (jInsert > 0) {
                    uriWithAppendedId = ContentUris.withAppendedId(C3958p.f14246a, jInsert);
                } else {
                    z = false;
                    uriWithAppendedId = null;
                }
                Log.d("TelephonyProvider", "inserted " + contentValues2.toString() + " rowID = " + jInsert);
                uri2 = uriWithAppendedId;
                z2 = z;
                break;
            case 2:
                writableDatabase.update("carriers", f14204b, "current IS NOT NULL", null);
                String asString = contentValues.getAsString("numeric");
                if (writableDatabase.update("carriers", f14205c, "numeric = '" + asString + "'", null) > 0) {
                    Log.d("TelephonyProvider", "Setting numeric '" + asString + "' to be the current operator");
                    uri2 = null;
                    break;
                } else {
                    Log.e("TelephonyProvider", "Failed setting numeric '" + asString + "' to the current operator");
                    uri2 = null;
                    break;
                }
            case 5:
                if (contentValues != null && contentValues.containsKey("apn_id")) {
                    m15218a(contentValues.getAsLong("apn_id"));
                }
                break;
            case 3:
            case 4:
            default:
                uri2 = null;
                break;
        }
        if (z2) {
            getContext().getContentResolver().notifyChange(C3958p.f14246a, null);
        }
        return uri2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) throws Resources.NotFoundException {
        int iDelete = 1;
        m15220c();
        SQLiteDatabase writableDatabase = this.f14206d.getWritableDatabase();
        switch (f14203a.match(uri)) {
            case 1:
                iDelete = writableDatabase.delete("carriers", str, strArr);
                break;
            case 2:
                iDelete = writableDatabase.delete("carriers", str, strArr);
                break;
            case 3:
                iDelete = writableDatabase.delete("carriers", "_id=?", new String[]{uri.getLastPathSegment()});
                break;
            case 4:
                m15221d();
                break;
            case 5:
                m15218a(-1L);
                break;
            default:
                throw new UnsupportedOperationException("Cannot delete that URL: " + uri);
        }
        if (iDelete > 0) {
            getContext().getContentResolver().notifyChange(C3958p.f14246a, null);
        }
        return iDelete;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iUpdate = 1;
        m15220c();
        SQLiteDatabase writableDatabase = this.f14206d.getWritableDatabase();
        switch (f14203a.match(uri)) {
            case 1:
                iUpdate = writableDatabase.update("carriers", contentValues, str, strArr);
                break;
            case 2:
                iUpdate = writableDatabase.update("carriers", contentValues, str, strArr);
                break;
            case 3:
                if (str != null || strArr != null) {
                    throw new UnsupportedOperationException("Cannot update URL " + uri + " with a where clause");
                }
                iUpdate = writableDatabase.update("carriers", contentValues, "_id=?", new String[]{uri.getLastPathSegment()});
                break;
            case 4:
            default:
                throw new UnsupportedOperationException("Cannot update that URL: " + uri);
            case 5:
                if (contentValues != null && contentValues.containsKey("apn_id")) {
                    m15218a(contentValues.getAsLong("apn_id"));
                    break;
                } else {
                    iUpdate = 0;
                    break;
                }
                break;
        }
        if (iUpdate > 0) {
            getContext().getContentResolver().notifyChange(C3958p.f14246a, null);
        }
        return iUpdate;
    }

    /* renamed from: c */
    private void m15220c() {
        getContext().enforceCallingOrSelfPermission("android.permission.WRITE_APN_SETTINGS", "No permission to write APN settings");
    }

    /* renamed from: d */
    private void m15221d() throws Resources.NotFoundException {
        SQLiteDatabase writableDatabase = this.f14206d.getWritableDatabase();
        writableDatabase.delete("carriers", null, null);
        m15218a(-1L);
        this.f14206d.m15273a(writableDatabase);
    }
}
