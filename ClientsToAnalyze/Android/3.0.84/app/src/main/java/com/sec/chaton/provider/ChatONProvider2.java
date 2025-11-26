package com.sec.chaton.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.p027e.C1394al;
import com.sec.chaton.p027e.C1396an;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.C1401as;
import com.sec.chaton.p027e.C1403au;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.C1434bj;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.common.util.C3364o;

/* loaded from: classes.dex */
public class ChatONProvider2 extends BaseContentProvider {

    /* renamed from: a */
    private UriMatcher f7832a;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m8110b();
        return true;
    }

    /* renamed from: b */
    private void m8110b() {
        this.f7832a = new UriMatcher(-1);
        this.f7832a.addURI("com.sec.chaton.provider2", "anicon_category", 1);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("anicon_category", "/*"), 2);
        this.f7832a.addURI("com.sec.chaton.provider2", "anicon_item", 3);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("anicon_item", "/", "recentused"), 5);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("anicon_item", "/", "group", "/*"), 7);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("anicon_item", "/*"), 6);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("download_item", "/", "delete_not_installed_item"), 18);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("download_item", "/", "init_newly_installed"), 33);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("download_item", "/*/", "join_font_filter", "/*"), 29);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("download_item", "/*"), 15);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("download_item", "/*/", "install"), 16);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("download_item", "/*/", "newly_installed"), 32);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("download_item", "/*/", "anicon_group"), 8);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("download_item", "/*/*"), 17);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("font_filter"), 25);
        this.f7832a.addURI("com.sec.chaton.provider2", C3364o.m11849a("font_filter", "/*"), 26);
        this.f7832a.addURI("com.sec.chaton.provider2", "more_apps", 34);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f7832a.match(uri)) {
            case 1:
                return "vnd.chaton.cursor.dir/vnd.chaton.emoticon.category";
            case 2:
                return "vnd.chaton.cursor.item/vnd.chaton.emoticon.category";
            case 3:
                return "vnd.chaton.cursor.dir/vnd.chaton.emoticon.item";
            case 6:
                return "vnd.chaton.cursor.item/vnd.chaton.emoticon.item";
            case 7:
                return "vnd.chaton.cursor.item/vnd.chaton.emoticon.item";
            case 8:
                return "vnd.chaton.cursor.dir/vnd.chaton.download.item";
            case 15:
                return "vnd.chaton.cursor.dir/vnd.chaton.download.item";
            case 17:
                return "vnd.chaton.cursor.item/vnd.chaton.download.item";
            case 34:
                return "vnd.chaton.cursor.dir/vnd.chaton.moreapps.item";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws Throwable {
        SQLiteDatabase readableDatabase = C1404av.m6253a(getContext()).getReadableDatabase();
        String str3 = null;
        String strM11849a = null;
        String[] strArr3 = null;
        Uri uriBuild = null;
        switch (this.f7832a.match(uri)) {
            case 1:
                str3 = "anicon_category";
                uriBuild = C1394al.f5202a;
                break;
            case 2:
                String str4 = uri.getPathSegments().get(1);
                str3 = "anicon_category";
                strM11849a = C3364o.m11849a("category_id", "=?");
                strArr3 = new String[]{str4};
                uriBuild = C1394al.f5202a.buildUpon().appendPath(str4).build();
                break;
            case 3:
                str3 = "anicon_item";
                uriBuild = C1396an.f5203a;
                break;
            case 4:
                String str5 = uri.getPathSegments().get(2);
                str3 = "anicon_item";
                strM11849a = C3364o.m11849a("package_id", "=?");
                strArr3 = new String[]{str5};
                uriBuild = C1396an.f5203a;
                break;
            case 5:
                Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM anicon_item WHERE sent_time IS NOT NULL AND package_id IN (SELECT item_id FROM download_item WHERE install != 0 AND item_type == '" + EnumC1399aq.Anicon.m6252a() + "') ORDER BY sent_time DESC  LIMIT 50", null);
                cursorRawQuery.setNotificationUri(getContext().getContentResolver(), C1396an.f5203a);
                return cursorRawQuery;
            case 6:
                String str6 = uri.getPathSegments().get(1);
                str3 = "anicon_item";
                strM11849a = C3364o.m11849a("anicon_id", "=?");
                strArr3 = new String[]{str6};
                uriBuild = C1396an.f5203a.buildUpon().appendPath(str6).build();
                break;
            case 7:
                Cursor cursorRawQuery2 = readableDatabase.rawQuery(C3364o.m11849a("SELECT * FROM ", "anicon_item", " D3 ", "\tINNER JOIN (", "\t\tSELECT D1.", "item_id", " AS ", "package_id", " \t\t\tFROM ", "download_item", " D1 ", " \t\t\tINNER JOIN ", "\t\t\t(SELECT ", "_id", ", ", "data1", ", ", "data2", ", ", "install", "\t\t\t\tFROM ", "download_item", " WHERE ", "item_id", "='", uri.getPathSegments().get(2), "' AND ", "item_type", "='", EnumC1399aq.Anicon.m6252a(), "') AS D2", "\t\t\tON D1.", "data1", "=D2.", "data1", " AND ", "\t\t\t   D1.", "data2", "=D2.", "data2", " AND ", "\t\t\t   D1.", "install", "!=0 OR ", "\t\t\t   D1.", "_id", "=D2.", "_id", "\t\t\t   ORDER BY D1.", "install", " DESC", "\t\t) D4", "\tWHERE D3.", "package_id", "=D4.", "package_id", " ORDER BY ", "anicon_id"), null);
                cursorRawQuery2.setNotificationUri(getContext().getContentResolver(), C1396an.f5203a);
                return cursorRawQuery2;
            case 8:
                Cursor cursorRawQuery3 = readableDatabase.rawQuery(C3364o.m11849a("SELECT * FROM ( ", "\tSELECT ", "\t\tD1.", "_id", ", D2.", "newly_installed", ", D1.", "item_id", ", D1.", "install", ", ", "\t\tD1.", "extras", ", D2.max_install", ", D1.", "data1", ", D1.", "data2", "\tFROM ", "download_item", " D1", "\tINNER JOIN ", "\t(SELECT ", "\t\tMAX(", "install", ") AS max_install,", "\t\tMAX(", "newly_installed", ") AS ", "newly_installed", ",", "\t\tMIN(", "install", ") AS ", "install", "\tFROM ", "download_item", "\tWHERE ", "item_type", "='", EnumC1399aq.Anicon.m6252a(), "' AND ", "install", " != 0 AND ", "data1", " IS NOT NULL AND ", "data2", " IS NOT NULL", "\tGROUP BY ", "data1", ", ", "data2", ") D2 ", "\tON D1.", "install", " = D2.", "install", " UNION ", "\tSELECT ", "_id", ", ", "newly_installed", ", ", "item_id", ", ", "install", ", ", "extras", ", ", "install", " AS max_install, ", "data1", ", ", "data2", "\tFROM ", "download_item", "\tWHERE ", "item_type", "='", EnumC1399aq.Anicon.m6252a(), "' AND ", "install", " != 0 AND ", "data1", " IS NULL AND ", "data2", " IS NULL ", ") ORDER BY max_install DESC"), null);
                cursorRawQuery3.setNotificationUri(getContext().getContentResolver(), C1396an.f5203a);
                return cursorRawQuery3;
            case 15:
                str3 = "download_item";
                EnumC1399aq enumC1399aqM6251a = EnumC1399aq.m6251a(uri.getPathSegments().get(1));
                strM11849a = C3364o.m11849a("item_type", "=?");
                strArr3 = new String[]{enumC1399aqM6251a.m6252a()};
                uriBuild = C1398ap.m6249a(enumC1399aqM6251a);
                break;
            case 16:
                str3 = "download_item";
                EnumC1399aq enumC1399aqM6251a2 = EnumC1399aq.m6251a(uri.getPathSegments().get(1));
                strM11849a = C3364o.m11849a("item_type", "=? AND ", "install", "!=?");
                strArr3 = new String[]{enumC1399aqM6251a2.m6252a(), "0"};
                uriBuild = C1398ap.m6249a(enumC1399aqM6251a2);
                break;
            case 17:
                str3 = "download_item";
                EnumC1399aq enumC1399aqM6251a3 = EnumC1399aq.m6251a(uri.getPathSegments().get(1));
                String str7 = uri.getPathSegments().get(2);
                strM11849a = C3364o.m11849a("item_type", "=? AND ", "item_id", "=?");
                strArr3 = new String[]{enumC1399aqM6251a3.m6252a(), str7};
                uriBuild = C1398ap.m6249a(enumC1399aqM6251a3).buildUpon().appendPath(str7).build();
                break;
            case 25:
                str3 = "font_filter";
                uriBuild = C1401as.f5214a;
                break;
            case 26:
                String str8 = uri.getPathSegments().get(1);
                str3 = "font_filter";
                strM11849a = C3364o.m11849a("filter_id", "=?");
                strArr3 = new String[]{str8};
                uriBuild = C1401as.f5214a.buildUpon().appendPath(str8).build();
                break;
            case 29:
                Cursor cursorRawQuery4 = readableDatabase.rawQuery("SELECT * FROM download_item, font_filter WHERE reference_id == filter_id AND item_id == " + uri.getPathSegments().get(3).toString() + " AND item_type == \"" + EnumC1399aq.Font.m6252a() + "\"", null);
                cursorRawQuery4.setNotificationUri(getContext().getContentResolver(), uri);
                return cursorRawQuery4;
            case 32:
                str3 = "download_item";
                EnumC1399aq enumC1399aqM6251a4 = EnumC1399aq.m6251a(uri.getPathSegments().get(1));
                strM11849a = C3364o.m11849a("item_type", "=? AND ", "newly_installed", "!=?");
                strArr3 = new String[]{enumC1399aqM6251a4.m6252a(), "0"};
                uriBuild = C1398ap.m6249a(enumC1399aqM6251a4);
                break;
            case 34:
                str3 = "more_apps";
                uriBuild = C1403au.f5215a;
                break;
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        C1434bj c1434bjM6289a = new C1434bj().m6288a(str3).m6289a(str, strArr2);
        if (!TextUtils.isEmpty(strM11849a)) {
            c1434bjM6289a.m6289a(strM11849a, strArr3);
        }
        Cursor cursorM6286a = c1434bjM6289a.m6286a(readableDatabase, strArr, str2);
        if (cursorM6286a != null && uriBuild != null) {
            cursorM6286a.setNotificationUri(getContext().getContentResolver(), uriBuild);
        }
        return cursorM6286a;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM8108a = null;
        SQLiteDatabase writableDatabase = C1404av.m6253a(getContext()).getWritableDatabase();
        int iMatch = this.f7832a.match(uri);
        writableDatabase.beginTransaction();
        switch (iMatch) {
            case 1:
            case 3:
            case 12:
            case 15:
            case 19:
            case 21:
            case 23:
            case 24:
            case 25:
            case 27:
            case 34:
                try {
                    uriM8108a = m8108a(writableDatabase, iMatch, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    if (!m8070a() && uriM8108a != null) {
                        getContext().getContentResolver().notifyChange(uriM8108a, null);
                        break;
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
                break;
        }
        return uriM8108a;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String strM11849a;
        String str2;
        int iM6285a;
        String[] strArr2 = null;
        SQLiteDatabase writableDatabase = C1404av.m6253a(getContext()).getWritableDatabase();
        int iMatch = this.f7832a.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    strM11849a = null;
                    str2 = "anicon_category";
                    break;
                case 2:
                    String strM11849a2 = C3364o.m11849a("category_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM11849a = strM11849a2;
                    str2 = "anicon_category";
                    break;
                case 3:
                    strM11849a = null;
                    str2 = "anicon_item";
                    break;
                case 6:
                    String strM11849a3 = C3364o.m11849a("anicon_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM11849a = strM11849a3;
                    str2 = "anicon_item";
                    break;
                case 15:
                    strM11849a = C3364o.m11849a("item_type", "=?");
                    str2 = "download_item";
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    break;
                case 17:
                    strM11849a = C3364o.m11849a("item_type", "=? AND ", "item_id", "=?");
                    str2 = "download_item";
                    strArr2 = new String[]{uri.getPathSegments().get(1), uri.getPathSegments().get(2)};
                    break;
                case 25:
                    strM11849a = null;
                    str2 = "font_filter";
                    break;
                case 26:
                    String strM11849a4 = C3364o.m11849a("filter_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM11849a = strM11849a4;
                    str2 = "font_filter";
                    break;
                case 33:
                    str2 = "download_item";
                    strM11849a = null;
                    break;
                case 34:
                    str2 = "more_apps";
                    strM11849a = null;
                    break;
                default:
                    strM11849a = null;
                    str2 = null;
                    break;
            }
            if (TextUtils.isEmpty(str2)) {
                iM6285a = 0;
            } else {
                C1434bj c1434bjM6289a = new C1434bj().m6288a(str2).m6289a(str, strArr);
                if (!TextUtils.isEmpty(strM11849a)) {
                    c1434bjM6289a.m6289a(strM11849a, strArr2);
                }
                iM6285a = c1434bjM6289a.m6285a(writableDatabase, contentValues);
                writableDatabase.setTransactionSuccessful();
                if (!m8070a() && uri != null) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
            }
            return iM6285a;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        String strM11849a;
        String str2;
        int iM6284a;
        String[] strArr2 = null;
        SQLiteDatabase writableDatabase = C1404av.m6253a(getContext()).getWritableDatabase();
        int iMatch = this.f7832a.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    strM11849a = null;
                    str2 = "anicon_category";
                    break;
                case 2:
                    String strM11849a2 = C3364o.m11849a("category_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM11849a = strM11849a2;
                    str2 = "anicon_category";
                    break;
                case 3:
                    strM11849a = null;
                    str2 = "anicon_item";
                    break;
                case 6:
                    String strM11849a3 = C3364o.m11849a("anicon_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM11849a = strM11849a3;
                    str2 = "anicon_item";
                    break;
                case 15:
                    strM11849a = C3364o.m11849a("item_type", "=?");
                    str2 = "download_item";
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    break;
                case 17:
                    strM11849a = C3364o.m11849a("item_type", "=? AND ", "item_id", "=?");
                    str2 = "download_item";
                    strArr2 = new String[]{uri.getPathSegments().get(1), uri.getPathSegments().get(2)};
                    break;
                case 18:
                    strM11849a = C3364o.m11849a("install", "=?");
                    strArr2 = new String[]{"0"};
                    str2 = "download_item";
                    break;
                case 25:
                    strM11849a = null;
                    str2 = "font_filter";
                    break;
                case 26:
                    String strM11849a4 = C3364o.m11849a("filter_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM11849a = strM11849a4;
                    str2 = "font_filter";
                    break;
                case 34:
                    str2 = "more_apps";
                    strM11849a = null;
                    break;
                default:
                    strM11849a = null;
                    str2 = null;
                    break;
            }
            if (TextUtils.isEmpty(str2)) {
                iM6284a = 0;
            } else {
                C1434bj c1434bjM6289a = new C1434bj().m6288a(str2).m6289a(str, strArr);
                if (!TextUtils.isEmpty(strM11849a)) {
                    c1434bjM6289a.m6289a(strM11849a, strArr2);
                }
                iM6284a = c1434bjM6289a.m6284a(writableDatabase);
                writableDatabase.setTransactionSuccessful();
                if (!m8070a() && uri != null) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
            }
            return iM6284a;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    /* renamed from: a */
    private Uri m8108a(SQLiteDatabase sQLiteDatabase, int i, Uri uri, ContentValues contentValues) throws Throwable {
        Uri uriBuild;
        String str;
        String str2;
        String[] strArr;
        boolean zM8109a = m8109a(uri, "replace", false);
        switch (i) {
            case 1:
                uri = C1394al.f5202a;
                String strM11849a = C3364o.m11849a("category_id", "=?");
                String[] strArr2 = {contentValues.getAsString("category_id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("category_id")).build();
                str = "anicon_category";
                str2 = strM11849a;
                strArr = strArr2;
                break;
            case 3:
                uri = C1396an.f5203a;
                String strM11849a2 = C3364o.m11849a("anicon_id", "=?");
                String[] strArr3 = {contentValues.getAsString("anicon_id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("anicon_id")).build();
                str = "anicon_item";
                str2 = strM11849a2;
                strArr = strArr3;
                break;
            case 15:
                if (uri == null) {
                    strArr = null;
                    str2 = null;
                    str = null;
                    uri = null;
                    uriBuild = null;
                    break;
                } else {
                    String strM11849a3 = C3364o.m11849a("item_id", "=?");
                    String[] strArr4 = {contentValues.getAsString("item_id")};
                    uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("item_id")).build();
                    str = "download_item";
                    str2 = strM11849a3;
                    strArr = strArr4;
                    break;
                }
            case 25:
                uri = C1401as.f5214a;
                String strM11849a4 = C3364o.m11849a("filter_id", "=?");
                String[] strArr5 = {contentValues.getAsString("filter_id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("filter_id")).build();
                str = "font_filter";
                str2 = strM11849a4;
                strArr = strArr5;
                break;
            case 34:
                uri = C1403au.f5215a;
                String strM11849a5 = C3364o.m11849a("id", "=?");
                String[] strArr6 = {contentValues.getAsString("id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("id")).build();
                str = "more_apps";
                str2 = strM11849a5;
                strArr = strArr6;
                break;
            default:
                return null;
        }
        if (!zM8109a || update(uri, contentValues, str2, strArr) == 0) {
            sQLiteDatabase.insert(str, null, contentValues);
        }
        return uriBuild;
    }

    /* renamed from: a */
    private boolean m8109a(Uri uri, String str, boolean z) {
        String queryParameter;
        return (uri == null || (queryParameter = uri.getQueryParameter(str)) == null) ? z : Boolean.parseBoolean(queryParameter);
    }
}
