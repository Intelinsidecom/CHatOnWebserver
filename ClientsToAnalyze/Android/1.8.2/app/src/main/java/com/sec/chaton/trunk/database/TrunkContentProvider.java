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
import com.sec.chaton.C0229at;
import com.sec.chaton.trunk.database.p052a.C1585b;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class TrunkContentProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f5684a = TrunkContentProvider.class.getSimpleName();

    /* renamed from: b */
    private UriMatcher f5685b;

    /* renamed from: a */
    private void m5459a() {
        this.f5685b = new UriMatcher(-1);
        this.f5685b.addURI("com.develop.sec.chaton.provider", "trunk", 1);
        this.f5685b.addURI("com.develop.sec.chaton.provider", "trunk/*", 2);
        this.f5685b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment", 20);
        this.f5685b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment/item/*", 22);
        this.f5685b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment/*", 21);
        this.f5685b.addURI("com.develop.sec.chaton.provider", "trunk_item", 10);
        this.f5685b.addURI("com.develop.sec.chaton.provider", "trunk_item/markAsRead/*", 13);
        this.f5685b.addURI("com.develop.sec.chaton.provider", "trunk_item/*", 12);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m5459a();
        return true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f5685b.match(uri)) {
            case 1:
                return "vnd.chaton.cursor.dir/vnd.chaton.trunk";
            case 2:
                return "vnd.chaton.cursor.item/vnd.chaton.trunk";
            case 10:
                return "vnd.chaton.cursor.dir/vnd.chaton.trunk.item";
            case C0229at.HorizontalSrollView_android_background /* 12 */:
                return "vnd.chaton.cursor.item/vnd.chaton.trunk.item";
            case C0229at.HorizontalSrollView_android_visibility /* 20 */:
            case C0229at.HorizontalSrollView_android_scrollbars /* 22 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.trunk.comment";
            case C0229at.HorizontalSrollView_android_fitsSystemWindows /* 21 */:
                return "vnd.chaton.cursor.item/vnd.chaton.trunk.comment";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorM5484a;
        SQLiteDatabase readableDatabase = C1585b.m5479a().getReadableDatabase();
        switch (this.f5685b.match(uri)) {
            case 1:
                Cursor cursorM5484a2 = new C1590f().m5485a("trunk").m5486a(str, strArr2).m5484a(readableDatabase, null, null, str2);
                if (cursorM5484a2 != null) {
                    cursorM5484a2.setNotificationUri(getContext().getContentResolver(), C1589e.f5703a);
                    return cursorM5484a2;
                }
                return cursorM5484a2;
            case 2:
                String str3 = uri.getPathSegments().get(1);
                cursorM5484a = new C1590f().m5485a("trunk").m5486a(str, strArr2).m5486a("session_id=?", str3).m5484a(readableDatabase, null, null, str2);
                if (cursorM5484a != null) {
                    cursorM5484a.setNotificationUri(getContext().getContentResolver(), C1589e.f5703a.buildUpon().appendPath(str3).build());
                    return cursorM5484a;
                }
                break;
            case 10:
                Cursor cursorM5484a3 = new C1590f().m5485a("trunk_item").m5486a(str, strArr2).m5484a(readableDatabase, null, null, str2);
                if (cursorM5484a3 != null) {
                    cursorM5484a3.setNotificationUri(getContext().getContentResolver(), C1587c.f5698a);
                    return cursorM5484a3;
                }
                return cursorM5484a3;
            case C0229at.HorizontalSrollView_android_background /* 12 */:
                String str4 = uri.getPathSegments().get(1);
                cursorM5484a = new C1590f().m5485a("trunk_item").m5486a(str, strArr2).m5486a("item_id=?", str4).m5484a(readableDatabase, null, null, str2);
                if (cursorM5484a != null) {
                    cursorM5484a.setNotificationUri(getContext().getContentResolver(), C1587c.f5698a.buildUpon().appendPath(str4).build());
                    return cursorM5484a;
                }
                break;
            case C0229at.HorizontalSrollView_android_visibility /* 20 */:
                Cursor cursorM5484a4 = new C1590f().m5485a("trunk_comment").m5486a(str, strArr2).m5484a(readableDatabase, null, null, str2);
                if (cursorM5484a4 != null) {
                    cursorM5484a4.setNotificationUri(getContext().getContentResolver(), C1586b.f5697a);
                    return cursorM5484a4;
                }
                return cursorM5484a4;
            case C0229at.HorizontalSrollView_android_fitsSystemWindows /* 21 */:
                String str5 = uri.getPathSegments().get(2);
                cursorM5484a = new C1590f().m5485a("trunk_comment").m5486a(str, strArr2).m5486a("comment_id=?", str5).m5484a(readableDatabase, null, null, str2);
                if (cursorM5484a != null) {
                    cursorM5484a.setNotificationUri(getContext().getContentResolver(), C1586b.f5697a.buildUpon().appendPath(str5).build());
                    return cursorM5484a;
                }
                break;
            case C0229at.HorizontalSrollView_android_scrollbars /* 22 */:
                Cursor cursorM5484a5 = new C1590f().m5485a("trunk_comment").m5486a(str, strArr2).m5486a("item_id=?", uri.getPathSegments().get(3)).m5484a(readableDatabase, null, null, str2);
                if (cursorM5484a5 != null) {
                    cursorM5484a5.setNotificationUri(getContext().getContentResolver(), C1586b.f5697a);
                    return cursorM5484a5;
                }
                return cursorM5484a5;
            default:
                throw new IllegalArgumentException("URI isn't valid.");
        }
        return cursorM5484a;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM5458a = null;
        SQLiteDatabase writableDatabase = C1585b.m5479a().getWritableDatabase();
        int iMatch = this.f5685b.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    uriM5458a = m5458a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM5458a, null);
                    break;
                case 10:
                    uriM5458a = m5458a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM5458a, null);
                    break;
                case C0229at.HorizontalSrollView_android_visibility /* 20 */:
                    uriM5458a = m5458a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM5458a, null);
                    break;
                default:
                    return uriM5458a;
            }
            return uriM5458a;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int iM5462b = 0;
        SQLiteDatabase writableDatabase = C1585b.m5479a().getWritableDatabase();
        int iMatch = this.f5685b.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    iM5462b = new C1590f().m5485a("trunk").m5486a(str, strArr).m5482a(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 2:
                    iM5462b = new C1590f().m5485a("trunk").m5486a(str, strArr).m5486a("session_id=?", uri.getPathSegments().get(1)).m5482a(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 10:
                case C0229at.HorizontalSrollView_android_background /* 12 */:
                    iM5462b = m5457a(writableDatabase, uri, str, strArr);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case C0229at.HorizontalSrollView_android_visibility /* 20 */:
                case C0229at.HorizontalSrollView_android_fitsSystemWindows /* 21 */:
                    iM5462b = m5462b(writableDatabase, uri, str, strArr);
                    writableDatabase.setTransactionSuccessful();
                    break;
            }
            getContext().getContentResolver().notifyChange(uri, null);
            return iM5462b;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iM5488b = 0;
        SQLiteDatabase writableDatabase = C1585b.m5479a().getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            switch (this.f5685b.match(uri)) {
                case 1:
                    iM5488b = new C1590f().m5485a("trunk").m5486a(str, strArr).m5488b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 2:
                    iM5488b = new C1590f().m5485a("trunk").m5486a(str, strArr).m5486a("session_id=?", uri.getPathSegments().get(1)).m5488b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 10:
                    iM5488b = new C1590f().m5485a("trunk_item").m5486a(str, strArr).m5488b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case C0229at.HorizontalSrollView_android_background /* 12 */:
                    iM5488b = new C1590f().m5485a("trunk_item").m5486a(str, strArr).m5486a("item_id=?", uri.getPathSegments().get(1)).m5488b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case C0229at.HorizontalSrollView_android_padding /* 13 */:
                    iM5488b = m5456a(writableDatabase, uri);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case C0229at.HorizontalSrollView_android_visibility /* 20 */:
                    iM5488b = new C1590f().m5485a("trunk_comment").m5486a(str, strArr).m5488b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case C0229at.HorizontalSrollView_android_fitsSystemWindows /* 21 */:
                    iM5488b = new C1590f().m5485a("trunk_comment").m5486a(str, strArr).m5486a("comment_id=?", uri.getPathSegments().get(2)).m5488b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
            }
            getContext().getContentResolver().notifyChange(uri, null);
            return iM5488b;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList arrayList) {
        SQLiteDatabase writableDatabase = C1585b.m5479a().getWritableDatabase();
        writableDatabase.beginTransaction();
        int size = arrayList.size();
        try {
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            for (int i = 0; i < size; i++) {
                contentProviderResultArr[i] = ((ContentProviderOperation) arrayList.get(i)).apply(this, contentProviderResultArr, i);
            }
            writableDatabase.setTransactionSuccessful();
            return contentProviderResultArr;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    /* renamed from: a */
    private Uri m5458a(SQLiteDatabase sQLiteDatabase, Uri uri, ContentValues contentValues) {
        String str;
        Uri uri2;
        String asString;
        String str2;
        String[] strArr;
        if (uri.getPath().equals(C1589e.f5703a.getPath())) {
            str = "trunk";
            uri2 = C1589e.f5703a;
            asString = contentValues.getAsString("session_id");
            str2 = null;
            strArr = null;
        } else if (uri.getPath().equals(C1587c.f5698a.getPath())) {
            uri2 = C1587c.f5698a;
            str = "trunk_item";
            asString = contentValues.getAsString("item_id");
            str2 = String.format("%s = ?", "item_type");
            strArr = new String[]{contentValues.getAsString("item_type")};
        } else {
            if (!uri.getPath().equals(C1586b.f5697a.getPath())) {
                return null;
            }
            str = "trunk_comment";
            uri2 = C1586b.f5697a;
            asString = contentValues.getAsString("comment_id");
            str2 = null;
            strArr = null;
        }
        boolean zM5460a = m5460a(uri, "replace", false);
        Uri uriBuild = uri2.buildUpon().appendPath(asString).build();
        if (!zM5460a) {
            new C1590f().m5485a(str).m5483a(sQLiteDatabase, contentValues);
            getContext().getContentResolver().notifyChange(uriBuild, null);
        } else if (update(uriBuild, contentValues, str2, strArr) == 0) {
            new C1590f().m5485a(str).m5483a(sQLiteDatabase, contentValues);
            getContext().getContentResolver().notifyChange(uriBuild, null);
            if (uri.getPath().equals(C1587c.f5698a.getPath())) {
                boolean zM5460a2 = m5460a(uri, "withLoadMoreItem", false);
                C1786r.m6061b("Is with load more item: " + zM5460a2, f5684a);
                if (zM5460a2) {
                    String asString2 = contentValues.getAsString("item_id");
                    String asString3 = contentValues.getAsString("session_id");
                    long jLongValue = contentValues.getAsLong("registration_time").longValue();
                    Uri uriBuild2 = C1587c.f5698a.buildUpon().appendPath(asString2).build();
                    C1786r.m6061b("Attach load more item to " + asString2, f5684a);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("item_id", asString2);
                    contentValues2.put("session_id", asString3);
                    contentValues2.put("registration_time", Long.valueOf(jLongValue));
                    contentValues2.put("item_type", String.valueOf(EnumC1588d.LoadMore.m5481a()));
                    new C1590f().m5485a("trunk_item").m5483a(sQLiteDatabase, contentValues2);
                    getContext().getContentResolver().notifyChange(uriBuild2, null);
                }
            }
        }
        return uriBuild;
    }

    /* renamed from: a */
    private int m5456a(SQLiteDatabase sQLiteDatabase, Uri uri) throws Throwable {
        Cursor cursor;
        Cursor cursorRawQuery;
        C1786r.m6061b("TrunkContentProvider.onTrunkItemMarkAsRead", f5684a);
        String str = uri.getPathSegments().get(2);
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(String.format("SELECT %s FROM %s WHERE %s = ?", "session_id", "trunk_item", "item_id"), new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (!cursorRawQuery.moveToNext()) {
                C1786r.m6061b("Can't find trunk item", f5684a);
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
            int iUpdate = update(C1587c.f5698a.buildUpon().appendPath(str).build(), contentValues, "unread_comment_count > ?", new String[]{"0"});
            if (iUpdate <= 0) {
                return iUpdate;
            }
            String str2 = String.format("UPDATE %s \tSET \t\t%s = %s - 1 \tWHERE \t\t%s = ?", "trunk", "unread_item_count", "unread_item_count", "session_id");
            C1786r.m6061b(new StringBuilder().append("SQL: ").append(str2).toString(), f5684a);
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
    private int m5457a(SQLiteDatabase sQLiteDatabase, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        int i;
        int i2;
        C1786r.m6061b("TrunkContentProvider.onTrunkItemDeleted", f5684a);
        int i3 = 0;
        HashMap map = new HashMap();
        boolean zM5460a = m5460a(uri, "effect", false);
        boolean zM5460a2 = m5460a(uri, "rearrangeLoadMoreItem", true);
        String str2 = null;
        if (uri.getPathSegments().size() > 1) {
            str2 = uri.getPathSegments().get(1);
        }
        C1590f c1590fM5486a = new C1590f().m5485a("trunk_item").m5486a(str, strArr);
        if (str2 != null && !str2.trim().equals("")) {
            c1590fM5486a.m5486a("item_id=?", str2);
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
                        EnumC1588d enumC1588dM5480a = EnumC1588d.m5480a(cursorQuery.getInt(cursorQuery.getColumnIndex("item_type")));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("unread_comment_count"));
                        if (zM5460a) {
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
                        sQLiteDatabase.execSQL(String.format("DELETE FROM %s WHERE %s=? AND %s=?", "trunk_item", "item_id", "item_type"), new Object[]{string, Integer.valueOf(enumC1588dM5480a.m5481a())});
                        if (zM5460a2) {
                            C1786r.m6061b("Rearrange load more item: " + string, f5684a);
                            if (enumC1588dM5480a == EnumC1588d.Item) {
                                if (m5461a(string)) {
                                    m5463b(string);
                                } else {
                                    C1786r.m6061b("This item hasn't more item. skip rearrange logic.", f5684a);
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
            if (zM5460a) {
                for (String str3 : map.keySet()) {
                    Integer[] numArr2 = (Integer[]) map.get(str3);
                    C1786r.m6061b("Effect other table. Total item count: " + numArr2[0] + ", Unread item count: " + numArr2[1], f5684a);
                    sQLiteDatabase.execSQL(String.format("UPDATE %s \tSET \t\t%s = %s - ?, \t\t%s = %s - ? \tWHERE %s = ?", "trunk", "total_item_count", "total_item_count", "unread_item_count", "unread_item_count", "session_id"), new String[]{String.valueOf(numArr2[0]), String.valueOf(numArr2[1]), str3});
                }
            }
            return i2;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: b */
    private int m5462b(SQLiteDatabase sQLiteDatabase, Uri uri, String str, String[] strArr) throws SQLException {
        C1786r.m6061b("TrunkContentProvider.onTrunkCommentDeleted", f5684a);
        HashMap map = new HashMap();
        boolean zM5460a = m5460a(uri, "effect", false);
        String str2 = uri.getPathSegments().size() > 2 ? uri.getPathSegments().get(2) : null;
        C1590f c1590fM5486a = new C1590f().m5486a(str, strArr);
        if (str2 != null && !str2.trim().equals("")) {
            c1590fM5486a.m5486a("comment_id=?", str2);
        }
        if (zM5460a) {
            Cursor cursor = null;
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(String.format("SELECT %s, COUNT(*) FROM %s WHERE %s GROUP BY %s ", "item_id", "trunk_comment", c1590fM5486a.m5487a(), "item_id"), c1590fM5486a.m5489b());
                if (!cursorRawQuery.moveToNext()) {
                    C1786r.m6061b("Can't find trunk comment", f5684a);
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
        c1590fM5486a.m5485a("trunk_comment");
        int iM5482a = c1590fM5486a.m5482a(sQLiteDatabase);
        if (zM5460a) {
            C1786r.m6061b("Effect other table", f5684a);
            StringBuilder sb = new StringBuilder();
            for (String str3 : map.keySet()) {
                int iIntValue = ((Integer) map.get(str3)).intValue();
                C1786r.m6061b("TrunkItemId: " + str3 + ", DeletingRowCount: " + iIntValue, f5684a);
                sb.setLength(0);
                sb.append("UPDATE %s ");
                sb.append("\tSET ");
                sb.append("\t\t%s=%s-%d ");
                sb.append("\tWHERE ");
                sb.append("\t\t%s=?");
                String str4 = String.format(sb.toString(), "trunk_item", "total_comment_count", "total_comment_count", Integer.valueOf(iIntValue), "item_id");
                C1786r.m6061b("SQL: " + str4, f5684a);
                sQLiteDatabase.execSQL(str4, new Object[]{str3});
            }
        }
        return iM5482a;
    }

    /* renamed from: a */
    private boolean m5461a(String str) {
        Cursor cursorQuery = query(C1587c.f5698a.buildUpon().appendPath(str).build(), null, "item_type=?", new String[]{String.valueOf(EnumC1588d.LoadMore.m5481a())}, null);
        if (cursorQuery == null) {
            return false;
        }
        try {
            if (cursorQuery.getCount() == 0) {
                return false;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return true;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: b */
    private void m5463b(String str) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = query(C1587c.f5698a, null, "item_id > ?", new String[]{str}, "item_id ASC");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                        if (EnumC1588d.m5480a(cursorQuery.getInt(cursorQuery.getColumnIndex("item_type"))) == EnumC1588d.Item) {
                            C1786r.m6061b("Move load more trunk item to previous item. Item id: " + string, f5684a);
                            Uri uriBuild = C1587c.f5698a.buildUpon().appendPath(str).build();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("item_id", string);
                            update(uriBuild, contentValues, null, null);
                        } else {
                            delete(C1587c.f5698a.buildUpon().appendPath(str).build(), "item_type = ?", new String[]{String.valueOf(EnumC1588d.LoadMore.m5481a())});
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
    private boolean m5460a(Uri uri, String str, boolean z) {
        String queryParameter;
        return (uri == null || (queryParameter = uri.getQueryParameter(str)) == null) ? z : Boolean.parseBoolean(queryParameter);
    }
}
