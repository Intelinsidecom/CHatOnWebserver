package com.sec.chaton.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.multimedia.emoticon.p032b.C0948c;
import com.sec.chaton.multimedia.emoticon.p032b.C0950e;
import com.sec.chaton.multimedia.emoticon.p032b.C0952g;
import com.sec.chaton.multimedia.skin.p037b.C1002c;
import com.sec.chaton.p017e.C0706u;
import com.sec.chaton.p017e.C0711z;
import com.sec.common.p056b.C1816b;
import com.sec.common.p056b.p060d.C1828c;
import twitter4j.MediaEntity;

/* loaded from: classes.dex */
public class ChatONProvider2 extends BaseContentProvider {

    /* renamed from: a */
    private static final String f3967a = ChatONProvider2.class.getSimpleName();

    /* renamed from: b */
    private UriMatcher f3968b;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m4110b();
        return true;
    }

    /* renamed from: b */
    private void m4110b() {
        this.f3968b = new UriMatcher(-1);
        this.f3968b.addURI("com.sec.chaton.provider2", "anicon_category", 1);
        this.f3968b.addURI("com.sec.chaton.provider2", C1828c.m6207a("anicon_category", "/*"), 2);
        this.f3968b.addURI("com.sec.chaton.provider2", "anicon_package", 3);
        this.f3968b.addURI("com.sec.chaton.provider2", C1828c.m6207a("anicon_package", "/", "install"), 4);
        this.f3968b.addURI("com.sec.chaton.provider2", C1828c.m6207a("anicon_package", "/*"), 5);
        this.f3968b.addURI("com.sec.chaton.provider2", "anicon_item", 6);
        this.f3968b.addURI("com.sec.chaton.provider2", C1828c.m6207a("anicon_item", "/", "recentused"), 8);
        this.f3968b.addURI("com.sec.chaton.provider2", C1828c.m6207a("anicon_item", "/*"), 9);
        this.f3968b.addURI("com.sec.chaton.provider2", "skin", 6);
        this.f3968b.addURI("com.sec.chaton.provider2", C1828c.m6207a("skin"), 100);
        this.f3968b.addURI("com.sec.chaton.provider2", C1828c.m6207a("skin", "/", "install"), MediaEntity.Size.CROP);
        this.f3968b.addURI("com.sec.chaton.provider2", C1828c.m6207a("skin", "/*"), 102);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f3968b.match(uri)) {
            case 1:
                return "vnd.chaton.cursor.dir/vnd.chaton.emoticon.category";
            case 2:
                return "vnd.chaton.cursor.item/vnd.chaton.emoticon.category";
            case 3:
                return "vnd.chaton.cursor.dir/vnd.chaton.emoticon.package";
            case 5:
                return "vnd.chaton.cursor.item/vnd.chaton.emoticon.package";
            case 6:
                return "vnd.chaton.cursor.dir/vnd.chaton.emoticon.item";
            case 9:
                return "vnd.chaton.cursor.item/vnd.chaton.emoticon.item";
            case MediaEntity.Size.FIT /* 100 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.skin.item";
            case 102:
                return "vnd.chaton.cursor.item/vnd.chaton.skin.item";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        String strM6207a;
        String[] strArr3;
        Uri uriBuild;
        SQLiteDatabase readableDatabase = C0706u.m3172a(getContext()).getReadableDatabase();
        switch (this.f3968b.match(uri)) {
            case 1:
                uriBuild = C0948c.f3513a;
                strM6207a = null;
                str3 = "anicon_category";
                strArr3 = null;
                break;
            case 2:
                String str4 = uri.getPathSegments().get(1);
                str3 = "anicon_category";
                strM6207a = C1828c.m6207a("category_id", "=?");
                strArr3 = new String[]{str4};
                uriBuild = C0948c.f3513a.buildUpon().appendPath(str4).build();
                break;
            case 3:
                uriBuild = C0952g.f3515a;
                strM6207a = null;
                str3 = "anicon_package";
                strArr3 = null;
                break;
            case 4:
                str3 = "anicon_package";
                strM6207a = C1828c.m6207a("install", "!=? AND ", "expiration_time", " >= ?");
                strArr3 = new String[]{"0", String.valueOf(C1816b.m6156a())};
                uriBuild = C0952g.f3515a;
                break;
            case 5:
                String str5 = uri.getPathSegments().get(1);
                str3 = "anicon_package";
                strM6207a = C1828c.m6207a("package_id", "=?");
                strArr3 = new String[]{str5};
                uriBuild = C0952g.f3515a.buildUpon().appendPath(str5).build();
                break;
            case 6:
                uriBuild = C0950e.f3514a;
                strM6207a = null;
                str3 = "anicon_item";
                strArr3 = null;
                break;
            case 7:
                String str6 = uri.getPathSegments().get(2);
                str3 = "anicon_item";
                strM6207a = C1828c.m6207a("package_id", "=?");
                strArr3 = new String[]{str6};
                uriBuild = C0950e.f3514a;
                break;
            case 8:
                Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM anicon_item WHERE sent_time IS NOT NULL AND package_id IN (SELECT package_id FROM anicon_package WHERE install!= 0 AND expiration_time >= " + C1816b.m6156a() + ") ORDER BY sent_time DESC  LIMIT 50", null);
                cursorRawQuery.setNotificationUri(getContext().getContentResolver(), C0950e.f3514a);
                return cursorRawQuery;
            case 9:
                String str7 = uri.getPathSegments().get(1);
                str3 = "anicon_item";
                strM6207a = C1828c.m6207a("anicon_id", "=?");
                strArr3 = new String[]{str7};
                uriBuild = C0950e.f3514a.buildUpon().appendPath(str7).build();
                break;
            case MediaEntity.Size.FIT /* 100 */:
                uriBuild = C1002c.f3694a;
                strM6207a = null;
                str3 = "skin";
                strArr3 = null;
                break;
            case MediaEntity.Size.CROP /* 101 */:
                str3 = "skin";
                strM6207a = C1828c.m6207a("install", "!=?");
                strArr3 = new String[]{"0"};
                uriBuild = C1002c.f3694a;
                break;
            case 102:
                String str8 = uri.getPathSegments().get(1);
                str3 = "skin";
                strM6207a = C1828c.m6207a("skin_id", "=?");
                strArr3 = new String[]{str8};
                uriBuild = C1002c.f3694a.buildUpon().appendPath(str8).build();
                break;
            default:
                uriBuild = null;
                strArr3 = null;
                strM6207a = null;
                str3 = null;
                break;
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        C0711z c0711zM3184a = new C0711z().m3183a(str3).m3184a(str, strArr2);
        if (!TextUtils.isEmpty(strM6207a)) {
            c0711zM3184a.m3184a(strM6207a, strArr3);
        }
        Cursor cursorM3181a = c0711zM3184a.m3181a(readableDatabase, strArr, str2);
        if (cursorM3181a != null && uriBuild != null) {
            cursorM3181a.setNotificationUri(getContext().getContentResolver(), uriBuild);
            return cursorM3181a;
        }
        return cursorM3181a;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM4108a = null;
        SQLiteDatabase writableDatabase = C0706u.m3172a(getContext()).getWritableDatabase();
        int iMatch = this.f3968b.match(uri);
        writableDatabase.beginTransaction();
        switch (iMatch) {
            case 1:
            case 3:
            case 6:
            case MediaEntity.Size.FIT /* 100 */:
                try {
                    uriM4108a = m4108a(writableDatabase, iMatch, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    if (!m4094a() && uriM4108a != null) {
                        getContext().getContentResolver().notifyChange(uriM4108a, null);
                        break;
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
                break;
        }
        return uriM4108a;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2;
        String str3;
        int iM3180a;
        String[] strArr2 = null;
        SQLiteDatabase writableDatabase = C0706u.m3172a(getContext()).getWritableDatabase();
        int iMatch = this.f3968b.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    str2 = null;
                    str3 = "anicon_category";
                    break;
                case 2:
                    String strM6207a = C1828c.m6207a("category_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    str2 = strM6207a;
                    str3 = "anicon_category";
                    break;
                case 3:
                    str2 = null;
                    str3 = "anicon_package";
                    break;
                case 5:
                    String strM6207a2 = C1828c.m6207a("package_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    str2 = strM6207a2;
                    str3 = "anicon_package";
                    break;
                case 6:
                    str2 = null;
                    str3 = "anicon_item";
                    break;
                case 9:
                    String strM6207a3 = C1828c.m6207a("anicon_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    str2 = strM6207a3;
                    str3 = "anicon_item";
                    break;
                case MediaEntity.Size.FIT /* 100 */:
                    str2 = null;
                    str3 = "skin";
                    break;
                case 102:
                    String strM6207a4 = C1828c.m6207a("skin_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    str2 = strM6207a4;
                    str3 = "skin";
                    break;
                default:
                    str2 = null;
                    str3 = null;
                    break;
            }
            if (TextUtils.isEmpty(str3)) {
                iM3180a = 0;
            } else {
                C0711z c0711zM3184a = new C0711z().m3183a(str3).m3184a(str, strArr);
                if (!TextUtils.isEmpty(str2)) {
                    c0711zM3184a.m3184a(str2, strArr2);
                }
                iM3180a = c0711zM3184a.m3180a(writableDatabase, contentValues);
                writableDatabase.setTransactionSuccessful();
                if (!m4094a() && uri != null) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
            }
            return iM3180a;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        String str2;
        String str3;
        int iM3179a;
        String[] strArr2 = null;
        SQLiteDatabase writableDatabase = C0706u.m3172a(getContext()).getWritableDatabase();
        int iMatch = this.f3968b.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    str2 = null;
                    str3 = "anicon_category";
                    break;
                case 2:
                    String strM6207a = C1828c.m6207a("category_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    str2 = strM6207a;
                    str3 = "anicon_category";
                    break;
                case 3:
                    str2 = null;
                    str3 = "anicon_package";
                    break;
                case 5:
                    String strM6207a2 = C1828c.m6207a("package_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    str2 = strM6207a2;
                    str3 = "anicon_package";
                    break;
                case 6:
                    str2 = null;
                    str3 = "anicon_item";
                    break;
                case 9:
                    String strM6207a3 = C1828c.m6207a("anicon_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    str2 = strM6207a3;
                    str3 = "anicon_item";
                    break;
                case MediaEntity.Size.FIT /* 100 */:
                    str2 = null;
                    str3 = "skin";
                    break;
                case 102:
                    String strM6207a4 = C1828c.m6207a("skin_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    str2 = strM6207a4;
                    str3 = "skin";
                    break;
                default:
                    str2 = null;
                    str3 = null;
                    break;
            }
            if (TextUtils.isEmpty(str3)) {
                iM3179a = 0;
            } else {
                C0711z c0711zM3184a = new C0711z().m3183a(str3).m3184a(str, strArr);
                if (!TextUtils.isEmpty(str2)) {
                    c0711zM3184a.m3184a(str2, strArr2);
                }
                iM3179a = c0711zM3184a.m3179a(writableDatabase);
                writableDatabase.setTransactionSuccessful();
                if (!m4094a() && uri != null) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
            }
            return iM3179a;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    /* renamed from: a */
    private Uri m4108a(SQLiteDatabase sQLiteDatabase, int i, Uri uri, ContentValues contentValues) {
        Uri uriBuild;
        Uri uri2;
        String str;
        String str2;
        String[] strArr;
        boolean zM4109a = m4109a(uri, "replace", false);
        switch (i) {
            case 1:
                Uri uri3 = C0948c.f3513a;
                String strM6207a = C1828c.m6207a("category_id", "=?");
                String[] strArr2 = {contentValues.getAsString("category_id")};
                uriBuild = uri3.buildUpon().appendPath(contentValues.getAsString("category_id")).build();
                uri2 = uri3;
                str = "anicon_category";
                str2 = strM6207a;
                strArr = strArr2;
                break;
            case 3:
                Uri uri4 = C0952g.f3515a;
                String strM6207a2 = C1828c.m6207a("package_id", "=?");
                String[] strArr3 = {contentValues.getAsString("package_id")};
                uriBuild = uri4.buildUpon().appendPath(contentValues.getAsString("package_id")).build();
                uri2 = uri4;
                str = "anicon_package";
                str2 = strM6207a2;
                strArr = strArr3;
                break;
            case 6:
                Uri uri5 = C0950e.f3514a;
                String strM6207a3 = C1828c.m6207a("anicon_id", "=?");
                String[] strArr4 = {contentValues.getAsString("anicon_id")};
                uriBuild = uri5.buildUpon().appendPath(contentValues.getAsString("anicon_id")).build();
                uri2 = uri5;
                str = "anicon_item";
                str2 = strM6207a3;
                strArr = strArr4;
                break;
            case MediaEntity.Size.FIT /* 100 */:
                Uri uri6 = C1002c.f3694a;
                String strM6207a4 = C1828c.m6207a("skin_id", "=?");
                String[] strArr5 = {contentValues.getAsString("skin_id")};
                uriBuild = uri6.buildUpon().appendPath(contentValues.getAsString("skin_id")).build();
                uri2 = uri6;
                str = "skin";
                str2 = strM6207a4;
                strArr = strArr5;
                break;
            default:
                return null;
        }
        if (!zM4109a || update(uri2, contentValues, str2, strArr) == 0) {
            sQLiteDatabase.insert(str, null, contentValues);
        }
        return uriBuild;
    }

    /* renamed from: a */
    private boolean m4109a(Uri uri, String str, boolean z) {
        String queryParameter;
        return (uri == null || (queryParameter = uri.getQueryParameter(str)) == null) ? z : Boolean.parseBoolean(queryParameter);
    }
}
