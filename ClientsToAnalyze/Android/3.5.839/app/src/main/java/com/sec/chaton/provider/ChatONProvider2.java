package com.sec.chaton.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.sec.chaton.p055d.EnumC2125f;
import com.sec.chaton.p057e.C2235aw;
import com.sec.chaton.p057e.C2237ay;
import com.sec.chaton.p057e.C2255ba;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.C2260bf;
import com.sec.chaton.p057e.C2262bh;
import com.sec.chaton.p057e.C2264bj;
import com.sec.chaton.p057e.C2267bm;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.C2283cb;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.settings.p096a.C3433a;
import com.sec.chaton.util.C4894o;
import com.sec.common.util.C5052r;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class ChatONProvider2 extends BaseContentProvider {

    /* renamed from: a */
    private UriMatcher f11239a;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m12447b();
        return true;
    }

    /* renamed from: b */
    private void m12447b() {
        this.f11239a = new UriMatcher(-1);
        this.f11239a.addURI("com.sec.chaton.provider2", "anicon_category", 1);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("anicon_category", "/*"), 2);
        this.f11239a.addURI("com.sec.chaton.provider2", "anicon_item", 3);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("anicon_item", "/", "recentused"), 5);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("anicon_item", "/", "group", "/*"), 7);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("anicon_item", "/*"), 6);
        this.f11239a.addURI("com.sec.chaton.provider2", "ams_stamp_item", 36);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("ams_stamp_item", "/", "path_stamp_item"), 37);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/", "anicon_install", "/*"), 38);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/", "ams_invalid"), 39);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/", "downloaded_item"), 35);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/", "delete_not_installed_item"), 18);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/", "init_newly_installed"), 33);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/*/", "join_font_filter", "/*"), 29);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/*"), 15);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/*/", "install"), 16);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/*/", "newly_installed"), 32);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/*/", "anicon_group"), 8);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/*/", "anicon_group_sort"), 9);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("download_item", "/*/*"), 17);
        this.f11239a.addURI("com.sec.chaton.provider2", "download_item", 42);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("shop_item"), 40);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("shop_item", "/*/*"), 41);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("font_filter"), 25);
        this.f11239a.addURI("com.sec.chaton.provider2", C5052r.m19199a("font_filter", "/*"), 26);
        this.f11239a.addURI("com.sec.chaton.provider2", "more_apps", 34);
        this.f11239a.addURI("com.sec.chaton.provider2", "pluslist", 43);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f11239a.match(uri)) {
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
            case 9:
                return "vnd.chaton.cursor.dir/vnd.chaton.download.item";
            case 15:
                return "vnd.chaton.cursor.dir/vnd.chaton.download.item";
            case 17:
                return "vnd.chaton.cursor.item/vnd.chaton.download.item";
            case 34:
                return "vnd.chaton.cursor.dir/vnd.chaton.moreapps.item";
            case 35:
                return "vnd.chaton.cursor.dir/vnd.chaton.download.item";
            case 36:
                return "vnd.chaton.cursor.dir/vnd.chaton.ams.stamp.item";
            case 37:
                return "vnd.chaton.cursor.dir/vnd.chaton.ams.stamp.item";
            case 38:
                return "vnd.chaton.cursor.item/vnd.chaton.download.item";
            case 40:
                return "vnd.chaton.cursor.dir/vnd.chaton.shop.item";
            case 41:
                return "vnd.chaton.cursor.item/vnd.chaton.shop.item";
            case 43:
                return "vnd.chaton.cursor.dir/vnd.chaton.pluslist.item";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws Throwable {
        SQLiteDatabase readableDatabase = C2268bn.m10126a(getContext()).getReadableDatabase();
        int iMatch = this.f11239a.match(uri);
        String str3 = null;
        String strM19199a = null;
        String[] strArr3 = null;
        Uri uriBuild = null;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        switch (iMatch) {
            case 1:
                str3 = "anicon_category";
                uriBuild = C2237ay.f7980a;
                break;
            case 2:
                String str4 = uri.getPathSegments().get(1);
                str3 = "anicon_category";
                strM19199a = C5052r.m19199a("category_id", "=?");
                strArr3 = new String[]{str4};
                uriBuild = C2237ay.f7980a.buildUpon().appendPath(str4).build();
                break;
            case 3:
                str3 = "anicon_item";
                uriBuild = C2255ba.f8038a;
                break;
            case 4:
                String str5 = uri.getPathSegments().get(2);
                str3 = "anicon_item";
                strM19199a = C5052r.m19199a("package_id", "=?");
                strArr3 = new String[]{str5};
                uriBuild = C2255ba.f8038a;
                break;
            case 5:
                Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM anicon_item WHERE sent_time IS NOT NULL AND package_id IN (SELECT item_id FROM download_item WHERE install != 0 AND item_type == '" + EnumC2258bd.Anicon.m10123a() + "'  AND expiration_time > " + calendar.getTimeInMillis() + ") ORDER BY sent_time DESC  LIMIT 50", null);
                cursorRawQuery.setNotificationUri(getContext().getContentResolver(), C2255ba.f8038a);
                return cursorRawQuery;
            case 6:
                String str6 = uri.getPathSegments().get(1);
                str3 = "anicon_item";
                strM19199a = C5052r.m19199a("anicon_id", "=?");
                strArr3 = new String[]{str6};
                uriBuild = C2255ba.f8038a.buildUpon().appendPath(str6).build();
                break;
            case 7:
                Cursor cursorRawQuery2 = readableDatabase.rawQuery(C5052r.m19199a("SELECT * FROM ", "anicon_item", " D3 ", "\tINNER JOIN (", "\t\tSELECT D1.", "item_id", " AS ", "package_id", " \t\t\tFROM ", "download_item", " D1 ", " \t\t\tINNER JOIN ", "\t\t\t(SELECT ", "_id", ", ", "data1", ", ", "data2", ", ", "install", "\t\t\t\tFROM ", "download_item", " WHERE ", "item_id", "='", uri.getPathSegments().get(2), "' AND ", " ( ", "item_type", "='", EnumC2258bd.Anicon.m10123a(), "' ) ", ") AS D2", "\t\t\tON D1.", "data1", "=D2.", "data1", " AND ", "\t\t\t   D1.", "data2", "=D2.", "data2", " AND ", "\t\t\t   D1.", "install", "!=0 OR ", "\t\t\t   D1.", "_id", "=D2.", "_id", "\t\t\t   ORDER BY D1.", "install", " DESC", "\t\t) D4", "\tWHERE D3.", "package_id", "=D4.", "package_id", " ORDER BY ", "anicon_id"), null);
                cursorRawQuery2.setNotificationUri(getContext().getContentResolver(), C2255ba.f8038a);
                return cursorRawQuery2;
            case 8:
                Cursor cursorRawQuery3 = readableDatabase.rawQuery(C5052r.m19199a("SELECT * FROM ( ", "\tSELECT ", "\t\tD1.", "_id", ", D2.", "newly_installed", ", D1.", "item_id", ", D1.", "install", ", ", "\t\tD1.", "extras", ", D2.max_install", ", D1.", "data1", ", D1.", "data2", "\tFROM ", "download_item", " D1", "\tINNER JOIN ", "\t(SELECT ", "\t\tMAX(", "install", ") AS max_install,", "\t\tMAX(", "newly_installed", ") AS ", "newly_installed", ",", "\t\tMIN(", "install", ") AS ", "install", "\tFROM ", "download_item", "\tWHERE ", "( ", "item_type", "='", EnumC2258bd.Anicon.m10123a(), "' )", " AND ", "install", " != 0 AND ", "expiration_time", "> ", Long.valueOf(calendar.getTimeInMillis()), " AND ", "data1", " IS NOT NULL AND ", "data2", " IS NOT NULL", "\tGROUP BY ", "data1", ", ", "data2", ") D2 ", "\tON D1.", "install", " = D2.", "install", " UNION ", "\tSELECT ", "_id", ", ", "newly_installed", ", ", "item_id", ", ", "install", ", ", "extras", ", ", "install", " AS max_install, ", "data1", ", ", "data2", "\tFROM ", "download_item", "\tWHERE ", "( ", "item_type", "='", EnumC2258bd.Anicon.m10123a(), "' )", " AND ", "install", " != 0 AND ", "expiration_time", "> ", Long.valueOf(calendar.getTimeInMillis()), " AND ", "data1", " IS NULL AND ", "data2", " IS NULL ", ") ORDER BY max_install DESC"), null);
                cursorRawQuery3.setNotificationUri(getContext().getContentResolver(), C2255ba.f8038a);
                return cursorRawQuery3;
            case 9:
                Cursor cursorRawQuery4 = readableDatabase.rawQuery(C5052r.m19199a("SELECT * FROM ( ", "\tSELECT ", "\t\tD1.", "_id", ", D2.", "newly_installed", ", D1.", "item_id", ", D1.", "install", ", ", "\t\tD1.", "extras", ", D2.max_install", ", D1.", "data1", ", D1.", "data2", ", D1.", "name", "\tFROM ", "download_item", " D1", "\tINNER JOIN ", "\t(SELECT ", "\t\tMAX(", "install", ") AS max_install,", "\t\tMAX(", "newly_installed", ") AS ", "newly_installed", ",", "\t\tMIN(", "install", ") AS ", "install", "\tFROM ", "download_item", "\tWHERE ", "( ", "item_type", "='", EnumC2258bd.Anicon.m10123a(), "' )", " AND ", "install", " != 0 AND ", "expiration_time", "> ", Long.valueOf(calendar.getTimeInMillis()), " AND ", "data1", " IS NOT NULL AND ", "data2", " IS NOT NULL", "\tGROUP BY ", "data1", ", ", "data2", ") D2 ", "\tON D1.", "install", " = D2.", "install", " UNION ", "\tSELECT ", "_id", ", ", "newly_installed", ", ", "item_id", ", ", "install", ", ", "extras", ", ", "install", " AS max_install, ", "data1", ", ", "data2", ", ", "name", "\tFROM ", "download_item", "\tWHERE ", "( ", "item_type", "='", EnumC2258bd.Anicon.m10123a(), "' )", " AND ", "install", " != 0 AND ", "expiration_time", "> ", Long.valueOf(calendar.getTimeInMillis()), " AND ", "data1", " IS NULL AND ", "data2", " IS NULL ", ") ORDER BY ", "install DESC"), null);
                cursorRawQuery4.setNotificationUri(getContext().getContentResolver(), C2255ba.f8038a);
                return cursorRawQuery4;
            case 15:
                str3 = "download_item";
                EnumC2258bd enumC2258bdM10122a = EnumC2258bd.m10122a(uri.getPathSegments().get(1));
                strM19199a = C5052r.m19199a("item_type", "=? AND ", "expiration_time", "> ?");
                strArr3 = new String[]{enumC2258bdM10122a.m10123a(), String.valueOf(calendar.getTimeInMillis())};
                uriBuild = C2257bc.m10121a(enumC2258bdM10122a);
                break;
            case 16:
                str3 = "download_item";
                EnumC2258bd enumC2258bdM10122a2 = EnumC2258bd.m10122a(uri.getPathSegments().get(1));
                if (enumC2258bdM10122a2 == EnumC2258bd.AmsUserTemplate) {
                    ArrayList<String> arrayListM18618d = C4894o.m18618d();
                    if (arrayListM18618d != null) {
                        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"_id", "item_id"});
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= arrayListM18618d.size()) {
                                return matrixCursor;
                            }
                            matrixCursor.addRow(new Object[]{Integer.valueOf(i2), new File(arrayListM18618d.get(i2)).getName()});
                            i = i2 + 1;
                        }
                    } else {
                        return null;
                    }
                } else {
                    strM19199a = C5052r.m19199a("item_type", "=? AND ", "install", "!=? AND ", "expiration_time", "> ?");
                    strArr3 = new String[]{enumC2258bdM10122a2.m10123a(), Spam.ACTIVITY_CANCEL, String.valueOf(calendar.getTimeInMillis())};
                    uriBuild = C2257bc.m10121a(enumC2258bdM10122a2);
                    break;
                }
            case 17:
                str3 = "download_item";
                EnumC2258bd enumC2258bdM10122a3 = EnumC2258bd.m10122a(uri.getPathSegments().get(1));
                String str7 = uri.getPathSegments().get(2);
                strM19199a = C5052r.m19199a("item_type", "=? AND ", "item_id", "=?");
                strArr3 = new String[]{enumC2258bdM10122a3.m10123a(), str7};
                uriBuild = C2257bc.m10121a(enumC2258bdM10122a3).buildUpon().appendPath(str7).build();
                break;
            case 25:
                str3 = "font_filter";
                uriBuild = C2260bf.f8052a;
                break;
            case 26:
                String str8 = uri.getPathSegments().get(1);
                str3 = "font_filter";
                strM19199a = C5052r.m19199a("filter_id", "=?");
                strArr3 = new String[]{str8};
                uriBuild = C2260bf.f8052a.buildUpon().appendPath(str8).build();
                break;
            case 29:
                Cursor cursorRawQuery5 = readableDatabase.rawQuery("SELECT * FROM download_item, font_filter WHERE reference_id == filter_id AND item_id == " + uri.getPathSegments().get(3).toString() + " AND item_type == \"" + EnumC2258bd.Font.m10123a() + "\"", null);
                cursorRawQuery5.setNotificationUri(getContext().getContentResolver(), uri);
                return cursorRawQuery5;
            case 32:
                str3 = "download_item";
                EnumC2258bd enumC2258bdM10122a4 = EnumC2258bd.m10122a(uri.getPathSegments().get(1));
                strM19199a = C5052r.m19199a("item_type", "=? AND ", "newly_installed", "!=?");
                strArr3 = new String[]{enumC2258bdM10122a4.m10123a(), Spam.ACTIVITY_CANCEL};
                uriBuild = C2257bc.m10121a(enumC2258bdM10122a4);
                break;
            case 34:
                str3 = "more_apps";
                uriBuild = C2262bh.f8053a;
                break;
            case 35:
                str3 = "download_item";
                uriBuild = C2257bc.f8039a;
                break;
            case 36:
                str3 = "ams_stamp_item";
                uriBuild = C2235aw.f7979a;
                break;
            case 37:
                Cursor cursorRawQuery6 = readableDatabase.rawQuery(C5052r.m19199a("SELECT * FROM ", "download_item", " a, ", "ams_stamp_item", " b ON a.", "item_id", "= b.", "item_id", " WHERE a.", "install", " != 0 AND a.", "expiration_time", " > ", Long.valueOf(calendar.getTimeInMillis()), " ORDER BY a.", "install", " DESC"), null);
                cursorRawQuery6.setNotificationUri(getContext().getContentResolver(), C2235aw.f7979a);
                return cursorRawQuery6;
            case 38:
                Cursor cursorRawQuery7 = readableDatabase.rawQuery(C5052r.m19199a("SELECT * FROM ", "download_item", " a, ", "anicon_item", " b ON a.", "item_id", "= b.", "package_id", " WHERE b.", "anicon_id", "=", uri.getPathSegments().get(2)), null);
                cursorRawQuery7.setNotificationUri(getContext().getContentResolver(), C2257bc.f8039a);
                return cursorRawQuery7;
            case 39:
                Cursor cursorRawQuery8 = readableDatabase.rawQuery(C5052r.m19199a("SELECT * FROM ", "download_item", " WHERE ( ", "item_type", "=? OR ", "item_type", "=? OR ", "item_type", "=? ) AND ( ", "install", " =? OR ", "expiration_time", " < ? )"), new String[]{EnumC2258bd.AmsTemplate.m10123a(), EnumC2258bd.AmsBackground.m10123a(), EnumC2258bd.AmsStamp.m10123a(), Spam.ACTIVITY_CANCEL, String.valueOf(calendar.getTimeInMillis())});
                cursorRawQuery8.setNotificationUri(getContext().getContentResolver(), C2257bc.f8039a);
                return cursorRawQuery8;
            case 40:
                str3 = "shop_item";
                uriBuild = C2267bm.f8062a;
                break;
            case 41:
                String str9 = uri.getPathSegments().get(1);
                String str10 = uri.getPathSegments().get(2);
                String strM19199a2 = C5052r.m19199a("item_id", "=?", " AND ", "item_type", "=?");
                String[] strArr4 = {str9, str10};
                uriBuild = C2267bm.f8062a.buildUpon().appendPath(str9).build();
                strArr3 = strArr4;
                strM19199a = strM19199a2;
                str3 = "shop_item";
                break;
            case 42:
                str3 = "download_item";
                uriBuild = C2257bc.f8039a;
                break;
            case 43:
                str3 = "pluslist";
                uriBuild = C2264bj.f8054a;
                break;
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        C2283cb c2283cbM10146a = new C2283cb().m10145a(str3).m10146a(str, strArr2);
        if (!TextUtils.isEmpty(strM19199a)) {
            c2283cbM10146a.m10146a(strM19199a, strArr3);
        }
        Cursor cursorM10143a = c2283cbM10146a.m10143a(readableDatabase, strArr, str2);
        if (cursorM10143a != null && uriBuild != null) {
            cursorM10143a.setNotificationUri(getContext().getContentResolver(), uriBuild);
        }
        return cursorM10143a;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM12445a = null;
        SQLiteDatabase writableDatabase = C2268bn.m10126a(getContext()).getWritableDatabase();
        int iMatch = this.f11239a.match(uri);
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
            case 36:
            case 37:
            case 41:
            case 43:
                try {
                    uriM12445a = m12445a(writableDatabase, iMatch, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    if (!m12391a() && uriM12445a != null) {
                        getContext().getContentResolver().notifyChange(uriM12445a, null);
                        break;
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
                break;
        }
        return uriM12445a;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String strM19199a;
        String str2;
        int iM10142a;
        String[] strArr2 = null;
        SQLiteDatabase writableDatabase = C2268bn.m10126a(getContext()).getWritableDatabase();
        int iMatch = this.f11239a.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    strM19199a = null;
                    str2 = "anicon_category";
                    break;
                case 2:
                    String strM19199a2 = C5052r.m19199a("category_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM19199a = strM19199a2;
                    str2 = "anicon_category";
                    break;
                case 3:
                    strM19199a = null;
                    str2 = "anicon_item";
                    break;
                case 6:
                    String strM19199a3 = C5052r.m19199a("anicon_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM19199a = strM19199a3;
                    str2 = "anicon_item";
                    break;
                case 15:
                    strM19199a = C5052r.m19199a("item_type", "=?");
                    str2 = "download_item";
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    break;
                case 17:
                    strM19199a = C5052r.m19199a("item_type", "=? AND ", "item_id", "=?");
                    str2 = "download_item";
                    strArr2 = new String[]{uri.getPathSegments().get(1), uri.getPathSegments().get(2)};
                    break;
                case 25:
                    strM19199a = null;
                    str2 = "font_filter";
                    break;
                case 26:
                    String strM19199a4 = C5052r.m19199a("filter_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM19199a = strM19199a4;
                    str2 = "font_filter";
                    break;
                case 33:
                    str2 = "download_item";
                    strM19199a = null;
                    break;
                case 34:
                    str2 = "more_apps";
                    strM19199a = null;
                    break;
                case 36:
                    str2 = "ams_stamp_item";
                    strM19199a = null;
                    break;
                case 37:
                    String strM19199a5 = C5052r.m19199a("stamp_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM19199a = strM19199a5;
                    str2 = "ams_stamp_item";
                    break;
                case 41:
                    strM19199a = C5052r.m19199a("item_id", "=?", " AND ", "item_type", "=?");
                    str2 = "shop_item";
                    strArr2 = new String[]{uri.getPathSegments().get(1), uri.getPathSegments().get(2)};
                    break;
                case 43:
                    str2 = "pluslist";
                    strM19199a = null;
                    break;
                default:
                    strM19199a = null;
                    str2 = null;
                    break;
            }
            if (TextUtils.isEmpty(str2)) {
                iM10142a = 0;
            } else {
                C2283cb c2283cbM10146a = new C2283cb().m10145a(str2).m10146a(str, strArr);
                if (!TextUtils.isEmpty(strM19199a)) {
                    c2283cbM10146a.m10146a(strM19199a, strArr2);
                }
                iM10142a = c2283cbM10146a.m10142a(writableDatabase, contentValues);
                writableDatabase.setTransactionSuccessful();
                if (!m12391a() && uri != null) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
            }
            return iM10142a;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        String strM19199a;
        String str2;
        int iM10141a;
        String[] strArr2 = null;
        SQLiteDatabase writableDatabase = C2268bn.m10126a(getContext()).getWritableDatabase();
        int iMatch = this.f11239a.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    strM19199a = null;
                    str2 = "anicon_category";
                    break;
                case 2:
                    String strM19199a2 = C5052r.m19199a("category_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM19199a = strM19199a2;
                    str2 = "anicon_category";
                    break;
                case 3:
                    strM19199a = null;
                    str2 = "anicon_item";
                    break;
                case 6:
                    String strM19199a3 = C5052r.m19199a("anicon_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM19199a = strM19199a3;
                    str2 = "anicon_item";
                    break;
                case 15:
                    strM19199a = C5052r.m19199a("item_type", "=?");
                    str2 = "download_item";
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    break;
                case 17:
                    strM19199a = C5052r.m19199a("item_type", "=? AND ", "item_id", "=?");
                    str2 = "download_item";
                    strArr2 = new String[]{uri.getPathSegments().get(1), uri.getPathSegments().get(2)};
                    break;
                case 18:
                    strM19199a = C5052r.m19199a("install", "=? OR ", "expiration_time", "<=?");
                    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                    if (calendar != null) {
                        strArr2 = new String[]{Spam.ACTIVITY_CANCEL, String.valueOf(calendar.getTimeInMillis())};
                    } else {
                        strArr2 = new String[0];
                    }
                    str2 = "download_item";
                    break;
                case 25:
                    strM19199a = null;
                    str2 = "font_filter";
                    break;
                case 26:
                    String strM19199a4 = C5052r.m19199a("filter_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM19199a = strM19199a4;
                    str2 = "font_filter";
                    break;
                case 34:
                    str2 = "more_apps";
                    strM19199a = null;
                    break;
                case 36:
                    str2 = "ams_stamp_item";
                    strM19199a = null;
                    break;
                case 37:
                    String strM19199a5 = C5052r.m19199a("stamp_id", "=?");
                    strArr2 = new String[]{uri.getPathSegments().get(1)};
                    strM19199a = strM19199a5;
                    str2 = "ams_stamp_item";
                    break;
                case 41:
                    strM19199a = C5052r.m19199a("item_id", "=?", " AND ", "item_type", "=?");
                    str2 = "shop_item";
                    strArr2 = new String[]{uri.getPathSegments().get(1), uri.getPathSegments().get(2)};
                    break;
                case 43:
                    str2 = "pluslist";
                    strM19199a = null;
                    break;
                default:
                    strM19199a = null;
                    str2 = null;
                    break;
            }
            if (TextUtils.isEmpty(str2)) {
                iM10141a = 0;
            } else {
                C2283cb c2283cbM10146a = new C2283cb().m10145a(str2).m10146a(str, strArr);
                if (!TextUtils.isEmpty(strM19199a)) {
                    c2283cbM10146a.m10146a(strM19199a, strArr2);
                }
                iM10141a = c2283cbM10146a.m10141a(writableDatabase);
                writableDatabase.setTransactionSuccessful();
                if (!m12391a() && uri != null) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
            }
            return iM10141a;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        switch (this.f11239a.match(uri)) {
            case 17:
                EnumC2258bd enumC2258bdM10122a = EnumC2258bd.m10122a(uri.getPathSegments().get(1));
                String str2 = uri.getPathSegments().get(2);
                if (enumC2258bdM10122a == EnumC2258bd.AmsBackground || enumC2258bdM10122a == EnumC2258bd.AmsStamp || enumC2258bdM10122a == EnumC2258bd.AmsTemplate) {
                    return ParcelFileDescriptor.open(C3433a.m13699a(getContext(), EnumC2125f.m9473a(enumC2258bdM10122a), str2), 268435456);
                }
                if (enumC2258bdM10122a == EnumC2258bd.AmsUserTemplate) {
                    return ParcelFileDescriptor.open(C4894o.m18617d(str2), 268435456);
                }
                break;
        }
        return super.openFile(uri, str);
    }

    /* renamed from: a */
    private Uri m12445a(SQLiteDatabase sQLiteDatabase, int i, Uri uri, ContentValues contentValues) throws Throwable {
        Uri uriBuild;
        String str;
        String str2;
        String[] strArr;
        boolean zM12446a = m12446a(uri, "replace", false);
        switch (i) {
            case 1:
                uri = C2237ay.f7980a;
                String strM19199a = C5052r.m19199a("category_id", "=?");
                String[] strArr2 = {contentValues.getAsString("category_id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("category_id")).build();
                str = "anicon_category";
                str2 = strM19199a;
                strArr = strArr2;
                break;
            case 3:
                uri = C2255ba.f8038a;
                String strM19199a2 = C5052r.m19199a("anicon_id", "=?");
                String[] strArr3 = {contentValues.getAsString("anicon_id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("anicon_id")).build();
                str = "anicon_item";
                str2 = strM19199a2;
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
                    String strM19199a3 = C5052r.m19199a("item_id", "=?");
                    String[] strArr4 = {contentValues.getAsString("item_id")};
                    uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("item_id")).build();
                    str = "download_item";
                    str2 = strM19199a3;
                    strArr = strArr4;
                    break;
                }
            case 25:
                uri = C2260bf.f8052a;
                String strM19199a4 = C5052r.m19199a("filter_id", "=?");
                String[] strArr5 = {contentValues.getAsString("filter_id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("filter_id")).build();
                str = "font_filter";
                str2 = strM19199a4;
                strArr = strArr5;
                break;
            case 34:
                uri = C2262bh.f8053a;
                String strM19199a5 = C5052r.m19199a("id", "=?");
                String[] strArr6 = {contentValues.getAsString("id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("id")).build();
                str = "more_apps";
                str2 = strM19199a5;
                strArr = strArr6;
                break;
            case 36:
                uri = C2235aw.f7979a;
                String strM19199a6 = C5052r.m19199a("stamp_id", "=?");
                String[] strArr7 = {contentValues.getAsString("stamp_id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("stamp_id")).build();
                str = "ams_stamp_item";
                str2 = strM19199a6;
                strArr = strArr7;
                break;
            case 37:
                uri = C2235aw.f7979a;
                String strM19199a7 = C5052r.m19199a("stamp_id", "=?");
                String[] strArr8 = {contentValues.getAsString("stamp_id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("stamp_id")).build();
                str = "ams_stamp_item";
                str2 = strM19199a7;
                strArr = strArr8;
                break;
            case 41:
                String strM19199a8 = C5052r.m19199a("item_id", "=?", " AND ", "item_type", "=?");
                String[] strArr9 = {contentValues.getAsString("item_id"), contentValues.getAsString("item_type")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("item_id")).appendPath(contentValues.getAsString("item_type")).build();
                str = "shop_item";
                str2 = strM19199a8;
                strArr = strArr9;
                break;
            case 43:
                uri = C2264bj.f8054a;
                String strM19199a9 = C5052r.m19199a("id", "=?");
                String[] strArr10 = {contentValues.getAsString("id")};
                uriBuild = uri.buildUpon().appendPath(contentValues.getAsString("id")).build();
                str = "pluslist";
                str2 = strM19199a9;
                strArr = strArr10;
                break;
            default:
                return null;
        }
        if (!zM12446a || update(uri, contentValues, str2, strArr) == 0) {
            sQLiteDatabase.insert(str, null, contentValues);
        }
        return uriBuild;
    }

    /* renamed from: a */
    private boolean m12446a(Uri uri, String str, boolean z) {
        String queryParameter;
        return (uri == null || (queryParameter = uri.getQueryParameter(str)) == null) ? z : Boolean.parseBoolean(queryParameter);
    }
}
