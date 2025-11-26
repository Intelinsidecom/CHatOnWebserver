package com.sec.chaton.trunk.database;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.sec.chaton.trunk.database.p062a.C3045b;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TrunkContentProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f10938a = TrunkContentProvider.class.getSimpleName();

    /* renamed from: b */
    private UriMatcher f10939b;

    /* renamed from: a */
    private void m10550a() {
        this.f10939b = new UriMatcher(-1);
        this.f10939b.addURI("com.develop.sec.chaton.provider", "trunk", 1);
        this.f10939b.addURI("com.develop.sec.chaton.provider", "trunk/*", 2);
        this.f10939b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment", 20);
        this.f10939b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment/item/*", 22);
        this.f10939b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment/*", 21);
        this.f10939b.addURI("com.develop.sec.chaton.provider", "trunk_item", 10);
        this.f10939b.addURI("com.develop.sec.chaton.provider", "trunk_item/markAsRead/*", 13);
        this.f10939b.addURI("com.develop.sec.chaton.provider", "trunk_item/*", 12);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m10550a();
        return true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f10939b.match(uri)) {
            case 1:
                return "vnd.chaton.cursor.dir/vnd.chaton.trunk";
            case 2:
                return "vnd.chaton.cursor.item/vnd.chaton.trunk";
            case 10:
                return "vnd.chaton.cursor.dir/vnd.chaton.trunk.item";
            case 12:
                return "vnd.chaton.cursor.item/vnd.chaton.trunk.item";
            case 20:
            case 22:
                return "vnd.chaton.cursor.dir/vnd.chaton.trunk.comment";
            case 21:
                return "vnd.chaton.cursor.item/vnd.chaton.trunk.comment";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorM10576a;
        SQLiteDatabase readableDatabase = C3045b.m10571a().getReadableDatabase();
        switch (this.f10939b.match(uri)) {
            case 1:
                Cursor cursorM10576a2 = new C3050f().m10577a("trunk").m10578a(str, strArr2).m10576a(readableDatabase, null, null, str2);
                if (cursorM10576a2 != null) {
                    cursorM10576a2.setNotificationUri(getContext().getContentResolver(), C3049e.f10957a);
                    return cursorM10576a2;
                }
                return cursorM10576a2;
            case 2:
                String str3 = uri.getPathSegments().get(1);
                cursorM10576a = new C3050f().m10577a("trunk").m10578a(str, strArr2).m10578a("session_id=?", str3).m10576a(readableDatabase, null, null, str2);
                if (cursorM10576a != null) {
                    cursorM10576a.setNotificationUri(getContext().getContentResolver(), C3049e.f10957a.buildUpon().appendPath(str3).build());
                    return cursorM10576a;
                }
                break;
            case 10:
                Cursor cursorM10576a3 = new C3050f().m10577a("trunk_item").m10578a(str, strArr2).m10576a(readableDatabase, null, null, str2);
                if (cursorM10576a3 != null) {
                    cursorM10576a3.setNotificationUri(getContext().getContentResolver(), C3047c.f10952a);
                    return cursorM10576a3;
                }
                return cursorM10576a3;
            case 12:
                String str4 = uri.getPathSegments().get(1);
                cursorM10576a = new C3050f().m10577a("trunk_item").m10578a(str, strArr2).m10578a("item_id=?", str4).m10576a(readableDatabase, null, null, str2);
                if (cursorM10576a != null) {
                    cursorM10576a.setNotificationUri(getContext().getContentResolver(), C3047c.f10952a.buildUpon().appendPath(str4).build());
                    return cursorM10576a;
                }
                break;
            case 20:
                Cursor cursorM10576a4 = new C3050f().m10577a("trunk_comment").m10578a(str, strArr2).m10576a(readableDatabase, null, null, str2);
                if (cursorM10576a4 != null) {
                    cursorM10576a4.setNotificationUri(getContext().getContentResolver(), C3046b.f10951a);
                    return cursorM10576a4;
                }
                return cursorM10576a4;
            case 21:
                String str5 = uri.getPathSegments().get(2);
                cursorM10576a = new C3050f().m10577a("trunk_comment").m10578a(str, strArr2).m10578a("comment_id=?", str5).m10576a(readableDatabase, null, null, str2);
                if (cursorM10576a != null) {
                    cursorM10576a.setNotificationUri(getContext().getContentResolver(), C3046b.f10951a.buildUpon().appendPath(str5).build());
                    return cursorM10576a;
                }
                break;
            case 22:
                Cursor cursorM10576a5 = new C3050f().m10577a("trunk_comment").m10578a(str, strArr2).m10578a("item_id=?", uri.getPathSegments().get(3)).m10576a(readableDatabase, null, null, str2);
                if (cursorM10576a5 != null) {
                    cursorM10576a5.setNotificationUri(getContext().getContentResolver(), C3046b.f10951a);
                    return cursorM10576a5;
                }
                return cursorM10576a5;
            default:
                throw new IllegalArgumentException("URI isn't valid.");
        }
        return cursorM10576a;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM10549a = null;
        SQLiteDatabase writableDatabase = C3045b.m10571a().getWritableDatabase();
        int iMatch = this.f10939b.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    uriM10549a = m10549a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM10549a, null);
                    break;
                case 10:
                    uriM10549a = m10549a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM10549a, null);
                    break;
                case 20:
                    uriM10549a = m10549a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM10549a, null);
                    break;
                default:
                    return uriM10549a;
            }
            return uriM10549a;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int iM10553b = 0;
        SQLiteDatabase writableDatabase = C3045b.m10571a().getWritableDatabase();
        int iMatch = this.f10939b.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    iM10553b = new C3050f().m10577a("trunk").m10578a(str, strArr).m10574a(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 2:
                    iM10553b = new C3050f().m10577a("trunk").m10578a(str, strArr).m10578a("session_id=?", uri.getPathSegments().get(1)).m10574a(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 10:
                case 12:
                    iM10553b = m10548a(writableDatabase, uri, str, strArr);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 20:
                case 21:
                    iM10553b = m10553b(writableDatabase, uri, str, strArr);
                    writableDatabase.setTransactionSuccessful();
                    break;
            }
            getContext().getContentResolver().notifyChange(uri, null);
            return iM10553b;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iM10580b = 0;
        SQLiteDatabase writableDatabase = C3045b.m10571a().getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            switch (this.f10939b.match(uri)) {
                case 1:
                    iM10580b = new C3050f().m10577a("trunk").m10578a(str, strArr).m10580b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 2:
                    iM10580b = new C3050f().m10577a("trunk").m10578a(str, strArr).m10578a("session_id=?", uri.getPathSegments().get(1)).m10580b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 10:
                    iM10580b = new C3050f().m10577a("trunk_item").m10578a(str, strArr).m10580b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 12:
                    iM10580b = new C3050f().m10577a("trunk_item").m10578a(str, strArr).m10578a("item_id=?", uri.getPathSegments().get(1)).m10580b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 13:
                    iM10580b = m10547a(writableDatabase, uri);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 20:
                    iM10580b = new C3050f().m10577a("trunk_comment").m10578a(str, strArr).m10580b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 21:
                    iM10580b = new C3050f().m10577a("trunk_comment").m10578a(str, strArr).m10578a("comment_id=?", uri.getPathSegments().get(2)).m10580b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
            }
            getContext().getContentResolver().notifyChange(uri, null);
            return iM10580b;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase writableDatabase = C3045b.m10571a().getWritableDatabase();
        writableDatabase.beginTransaction();
        int size = arrayList.size();
        try {
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            for (int i = 0; i < size; i++) {
                contentProviderResultArr[i] = arrayList.get(i).apply(this, contentProviderResultArr, i);
            }
            writableDatabase.setTransactionSuccessful();
            return contentProviderResultArr;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    /* renamed from: a */
    private Uri m10549a(SQLiteDatabase sQLiteDatabase, Uri uri, ContentValues contentValues) {
        Uri uri2;
        String str;
        String asString;
        if (uri.getPath().equals(C3049e.f10957a.getPath())) {
            uri2 = C3049e.f10957a;
            str = "trunk";
            asString = contentValues.getAsString("session_id");
        } else if (uri.getPath().equals(C3047c.f10952a.getPath())) {
            uri2 = C3047c.f10952a;
            str = "trunk_item";
            asString = contentValues.getAsString("item_id");
        } else {
            if (!uri.getPath().equals(C3046b.f10951a.getPath())) {
                return null;
            }
            uri2 = C3046b.f10951a;
            str = "trunk_comment";
            asString = contentValues.getAsString("comment_id");
        }
        boolean zM10551a = m10551a(uri, "replace", false);
        Uri uriBuild = uri2.buildUpon().appendPath(asString).build();
        if (!zM10551a) {
            new C3050f().m10577a(str).m10575a(sQLiteDatabase, contentValues);
            getContext().getContentResolver().notifyChange(uriBuild, null);
            return uriBuild;
        }
        if (update(uriBuild, contentValues, null, null) == 0) {
            new C3050f().m10577a(str).m10575a(sQLiteDatabase, contentValues);
            getContext().getContentResolver().notifyChange(uriBuild, null);
            if (uri.getPath().equals(C3047c.f10952a.getPath())) {
                boolean zM10551a2 = m10551a(uri, "withLoadMoreItem", false);
                C3250y.m11450b("Is with load more item: " + zM10551a2, f10938a);
                if (zM10551a2) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("item_type", Integer.valueOf(EnumC3048d.LoadMore.m10573a()));
                    new C3050f().m10577a(str).m10578a("item_id=?", contentValues.getAsString("item_id")).m10580b(sQLiteDatabase, contentValues2);
                    return uriBuild;
                }
                return uriBuild;
            }
            return uriBuild;
        }
        if (uri.getPath().equals(C3047c.f10952a.getPath())) {
            boolean zM10551a3 = m10551a(uri, "withLoadMoreItem", false);
            C3250y.m11450b("Is with load more item: " + zM10551a3, f10938a);
            if (zM10551a3) {
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("item_type", Integer.valueOf(EnumC3048d.LoadMore.m10573a()));
                new C3050f().m10577a(str).m10578a("item_id=?", contentValues.getAsString("item_id")).m10580b(sQLiteDatabase, contentValues3);
                return uriBuild;
            }
            return uriBuild;
        }
        return uriBuild;
    }

    /* renamed from: a */
    private int m10547a(SQLiteDatabase sQLiteDatabase, Uri uri) throws Throwable {
        Cursor cursor;
        Cursor cursorRawQuery;
        C3250y.m11450b("TrunkContentProvider.onTrunkItemMarkAsRead", f10938a);
        String str = uri.getPathSegments().get(2);
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(String.format("SELECT %s FROM %s WHERE %s = ?", "session_id", "trunk_item", "item_id"), new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (!cursorRawQuery.moveToNext()) {
                C3250y.m11450b("Can't find trunk item", f10938a);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return 0;
            }
            String string = cursorRawQuery.getString(0);
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("unread_comment_count", (Integer) 0);
            int iUpdate = update(C3047c.f10952a.buildUpon().appendPath(str).build(), contentValues, "unread_comment_count > ?", new String[]{"0"});
            if (iUpdate <= 0) {
                return iUpdate;
            }
            String str2 = String.format("UPDATE %s \tSET \t\t%s = %s - 1 \tWHERE \t\t%s = ?", "trunk", "unread_item_count", "unread_item_count", "session_id");
            C3250y.m11450b(new StringBuilder().append("SQL: ").append(str2).toString(), f10938a);
            sQLiteDatabase.execSQL(str2, new Object[]{string});
            return iUpdate;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorRawQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private int m10548a(SQLiteDatabase sQLiteDatabase, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        int i;
        int i2;
        C3250y.m11450b("TrunkContentProvider.onTrunkItemDeleted", f10938a);
        int i3 = 0;
        HashMap map = new HashMap();
        boolean zM10551a = m10551a(uri, "effect", false);
        boolean zM10551a2 = m10551a(uri, "rearrangeLoadMoreItem", true);
        String str2 = null;
        if (uri != null && uri.getPathSegments().size() > 1) {
            str2 = uri.getPathSegments().get(1);
        }
        C3050f c3050fM10578a = new C3050f().m10577a("trunk_item").m10578a(str, strArr);
        if (str2 != null && !str2.trim().equals("")) {
            c3050fM10578a.m10578a("item_id=?", str2);
        }
        try {
            cursorQuery = query(uri, null, str, strArr, null);
            if (cursorQuery != null) {
                while (true) {
                    try {
                        i = i3;
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        i3 = i + 1;
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("session_id"));
                        EnumC3048d enumC3048dM10572a = EnumC3048d.m10572a(cursorQuery.getInt(cursorQuery.getColumnIndex("item_type")));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("unread_comment_count"));
                        if (zM10551a) {
                            Integer[] numArr = (Integer[]) map.get(string2);
                            if (numArr == null) {
                                numArr = new Integer[]{0, 0};
                            }
                            numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                            if (i4 > 0) {
                                numArr[1] = Integer.valueOf(numArr[1].intValue() + 1);
                            }
                            map.put(string2, numArr);
                        }
                        sQLiteDatabase.execSQL(String.format("DELETE FROM %s WHERE %s=? AND %s=?", "trunk_item", "item_id", "item_type"), new Object[]{string, Integer.valueOf(enumC3048dM10572a.m10573a())});
                        if (zM10551a2) {
                            C3250y.m11450b("Rearrange load more item: " + string, f10938a);
                            if (enumC3048dM10572a == EnumC3048d.Item) {
                                if (m10552a(string)) {
                                    m10554b(string);
                                } else {
                                    C3250y.m11450b("This item hasn't more item. skip rearrange logic.", f10938a);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                i2 = i;
            } else {
                i2 = 0;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (zM10551a) {
                for (Map.Entry entry : map.entrySet()) {
                    Integer[] numArr2 = (Integer[]) entry.getValue();
                    C3250y.m11450b("Effect other table. Total item count: " + numArr2[0] + ", Unread item count: " + numArr2[1], f10938a);
                    sQLiteDatabase.execSQL(String.format("UPDATE %s \tSET \t\t%s = %s - ?, \t\t%s = %s - ? \tWHERE %s = ?", "trunk", "total_item_count", "total_item_count", "unread_item_count", "unread_item_count", "session_id"), new String[]{String.valueOf(numArr2[0]), String.valueOf(numArr2[1]), (String) entry.getKey()});
                }
            }
            return i2;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: b */
    private int m10553b(SQLiteDatabase sQLiteDatabase, Uri uri, String str, String[] strArr) throws SQLException {
        C3250y.m11450b("TrunkContentProvider.onTrunkCommentDeleted", f10938a);
        HashMap map = new HashMap();
        boolean zM10551a = m10551a(uri, "effect", false);
        String str2 = null;
        if (uri != null && uri.getPathSegments().size() > 2) {
            str2 = uri.getPathSegments().get(2);
        }
        C3050f c3050fM10578a = new C3050f().m10578a(str, strArr);
        if (str2 != null && !str2.trim().equals("")) {
            c3050fM10578a.m10578a("comment_id=?", str2);
        }
        if (zM10551a) {
            Cursor cursor = null;
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(String.format("SELECT %s, COUNT(*) FROM %s WHERE %s GROUP BY %s ", "item_id", "trunk_comment", c3050fM10578a.m10579a(), "item_id"), c3050fM10578a.m10581b());
                if (!cursorRawQuery.moveToNext()) {
                    C3250y.m11450b("Can't find trunk comment", f10938a);
                    if (cursorRawQuery == null) {
                        return 0;
                    }
                    cursorRawQuery.close();
                    return 0;
                }
                map.put(cursorRawQuery.getString(0), Integer.valueOf(cursorRawQuery.getInt(1)));
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
        c3050fM10578a.m10577a("trunk_comment");
        int iM10574a = c3050fM10578a.m10574a(sQLiteDatabase);
        if (zM10551a) {
            C3250y.m11450b("Effect other table", f10938a);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue = ((Integer) entry.getValue()).intValue();
                C3250y.m11450b("TrunkItemId: " + ((String) entry.getKey()) + ", DeletingRowCount: " + iIntValue, f10938a);
                sb.setLength(0);
                sb.append("UPDATE %s ");
                sb.append("\tSET ");
                sb.append("\t\t%s=%s-%d ");
                sb.append("\tWHERE ");
                sb.append("\t\t%s=?");
                String str3 = String.format(sb.toString(), "trunk_item", "total_comment_count", "total_comment_count", Integer.valueOf(iIntValue), "item_id");
                C3250y.m11450b("SQL: " + str3, f10938a);
                sQLiteDatabase.execSQL(str3, new Object[]{entry.getKey()});
            }
        }
        return iM10574a;
    }

    /* renamed from: a */
    private boolean m10552a(String str) {
        Cursor cursorQuery = query(C3047c.f10952a.buildUpon().appendPath(str).build(), null, "item_type=?", new String[]{String.valueOf(EnumC3048d.LoadMore.m10573a())}, null);
        if (cursorQuery == null) {
            return false;
        }
        try {
            return cursorQuery.getCount() != 0;
        } finally {
            cursorQuery.close();
        }
    }

    /* renamed from: b */
    private void m10554b(String str) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = query(C3047c.f10952a, null, "item_id > ?", new String[]{str}, "item_id ASC");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                        if (EnumC3048d.m10572a(cursorQuery.getInt(cursorQuery.getColumnIndex("item_type"))) == EnumC3048d.Item) {
                            C3250y.m11450b("Move load more trunk item to previous item. Item id: " + string, f10938a);
                            Uri uriBuild = C3047c.f10952a.buildUpon().appendPath(str).build();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("item_id", string);
                            update(uriBuild, contentValues, null, null);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: a */
    private boolean m10551a(Uri uri, String str, boolean z) {
        String queryParameter;
        return (uri == null || (queryParameter = uri.getQueryParameter(str)) == null) ? z : Boolean.parseBoolean(queryParameter);
    }
}
