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
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.trunk.database.p122a.C4665b;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class TrunkContentProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f16887a = TrunkContentProvider.class.getSimpleName();

    /* renamed from: b */
    private UriMatcher f16888b;

    /* renamed from: a */
    private void m17644a() {
        this.f16888b = new UriMatcher(-1);
        this.f16888b.addURI("com.develop.sec.chaton.provider", "trunk", 1);
        this.f16888b.addURI("com.develop.sec.chaton.provider", "trunk/*", 2);
        this.f16888b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment", 20);
        this.f16888b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment/item/*", 22);
        this.f16888b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment/*", 21);
        this.f16888b.addURI("com.develop.sec.chaton.provider", "trunk_item", 10);
        this.f16888b.addURI("com.develop.sec.chaton.provider", "trunk_item/markAsRead/*", 13);
        this.f16888b.addURI("com.develop.sec.chaton.provider", "trunk_item/*", 12);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m17644a();
        return true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f16888b.match(uri)) {
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
        Cursor cursorM17670a;
        SQLiteDatabase readableDatabase = C4665b.m17665a().getReadableDatabase();
        switch (this.f16888b.match(uri)) {
            case 1:
                Cursor cursorM17670a2 = new C4670f().m17671a("trunk").m17672a(str, strArr2).m17670a(readableDatabase, null, null, str2);
                if (cursorM17670a2 != null) {
                    cursorM17670a2.setNotificationUri(getContext().getContentResolver(), C4669e.f16906a);
                    return cursorM17670a2;
                }
                return cursorM17670a2;
            case 2:
                String str3 = uri.getPathSegments().get(1);
                cursorM17670a = new C4670f().m17671a("trunk").m17672a(str, strArr2).m17672a("session_id=?", str3).m17670a(readableDatabase, null, null, str2);
                if (cursorM17670a != null) {
                    cursorM17670a.setNotificationUri(getContext().getContentResolver(), C4669e.f16906a.buildUpon().appendPath(str3).build());
                    return cursorM17670a;
                }
                break;
            case 10:
                Cursor cursorM17670a3 = new C4670f().m17671a("trunk_item").m17672a(str, strArr2).m17670a(readableDatabase, null, null, str2);
                if (cursorM17670a3 != null) {
                    cursorM17670a3.setNotificationUri(getContext().getContentResolver(), C4667c.f16901a);
                    return cursorM17670a3;
                }
                return cursorM17670a3;
            case 12:
                String str4 = uri.getPathSegments().get(1);
                cursorM17670a = new C4670f().m17671a("trunk_item").m17672a(str, strArr2).m17672a("item_id=?", str4).m17670a(readableDatabase, null, null, str2);
                if (cursorM17670a != null) {
                    cursorM17670a.setNotificationUri(getContext().getContentResolver(), C4667c.f16901a.buildUpon().appendPath(str4).build());
                    return cursorM17670a;
                }
                break;
            case 20:
                Cursor cursorM17670a4 = new C4670f().m17671a("trunk_comment").m17672a(str, strArr2).m17670a(readableDatabase, null, null, str2);
                if (cursorM17670a4 != null) {
                    cursorM17670a4.setNotificationUri(getContext().getContentResolver(), C4666b.f16900a);
                    return cursorM17670a4;
                }
                return cursorM17670a4;
            case 21:
                String str5 = uri.getPathSegments().get(2);
                cursorM17670a = new C4670f().m17671a("trunk_comment").m17672a(str, strArr2).m17672a("comment_id=?", str5).m17670a(readableDatabase, null, null, str2);
                if (cursorM17670a != null) {
                    cursorM17670a.setNotificationUri(getContext().getContentResolver(), C4666b.f16900a.buildUpon().appendPath(str5).build());
                    return cursorM17670a;
                }
                break;
            case 22:
                Cursor cursorM17670a5 = new C4670f().m17671a("trunk_comment").m17672a(str, strArr2).m17672a("item_id=?", uri.getPathSegments().get(3)).m17670a(readableDatabase, null, null, str2);
                if (cursorM17670a5 != null) {
                    cursorM17670a5.setNotificationUri(getContext().getContentResolver(), C4666b.f16900a);
                    return cursorM17670a5;
                }
                return cursorM17670a5;
            default:
                throw new IllegalArgumentException("URI isn't valid.");
        }
        return cursorM17670a;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM17643a = null;
        SQLiteDatabase writableDatabase = C4665b.m17665a().getWritableDatabase();
        int iMatch = this.f16888b.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    uriM17643a = m17643a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM17643a, null);
                    break;
                case 10:
                    uriM17643a = m17643a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM17643a, null);
                    break;
                case 20:
                    uriM17643a = m17643a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM17643a, null);
                    break;
                default:
                    return uriM17643a;
            }
            return uriM17643a;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int iM17647b = 0;
        SQLiteDatabase writableDatabase = C4665b.m17665a().getWritableDatabase();
        int iMatch = this.f16888b.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    iM17647b = new C4670f().m17671a("trunk").m17672a(str, strArr).m17668a(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 2:
                    iM17647b = new C4670f().m17671a("trunk").m17672a(str, strArr).m17672a("session_id=?", uri.getPathSegments().get(1)).m17668a(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 10:
                case 12:
                    iM17647b = m17642a(writableDatabase, uri, str, strArr);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 20:
                case 21:
                    iM17647b = m17647b(writableDatabase, uri, str, strArr);
                    writableDatabase.setTransactionSuccessful();
                    break;
            }
            getContext().getContentResolver().notifyChange(uri, null);
            return iM17647b;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iM17674b = 0;
        SQLiteDatabase writableDatabase = C4665b.m17665a().getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            switch (this.f16888b.match(uri)) {
                case 1:
                    iM17674b = new C4670f().m17671a("trunk").m17672a(str, strArr).m17674b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 2:
                    iM17674b = new C4670f().m17671a("trunk").m17672a(str, strArr).m17672a("session_id=?", uri.getPathSegments().get(1)).m17674b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 10:
                    iM17674b = new C4670f().m17671a("trunk_item").m17672a(str, strArr).m17674b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 12:
                    iM17674b = new C4670f().m17671a("trunk_item").m17672a(str, strArr).m17672a("item_id=?", uri.getPathSegments().get(1)).m17674b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 13:
                    iM17674b = m17641a(writableDatabase, uri);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 20:
                    iM17674b = new C4670f().m17671a("trunk_comment").m17672a(str, strArr).m17674b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 21:
                    iM17674b = new C4670f().m17671a("trunk_comment").m17672a(str, strArr).m17672a("comment_id=?", uri.getPathSegments().get(2)).m17674b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
            }
            getContext().getContentResolver().notifyChange(uri, null);
            return iM17674b;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase writableDatabase = C4665b.m17665a().getWritableDatabase();
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
    private Uri m17643a(SQLiteDatabase sQLiteDatabase, Uri uri, ContentValues contentValues) {
        Uri uri2;
        String str;
        String asString;
        if (uri.getPath().equals(C4669e.f16906a.getPath())) {
            uri2 = C4669e.f16906a;
            str = "trunk";
            asString = contentValues.getAsString("session_id");
        } else if (uri.getPath().equals(C4667c.f16901a.getPath())) {
            uri2 = C4667c.f16901a;
            str = "trunk_item";
            asString = contentValues.getAsString("item_id");
        } else {
            if (!uri.getPath().equals(C4666b.f16900a.getPath())) {
                return null;
            }
            uri2 = C4666b.f16900a;
            str = "trunk_comment";
            asString = contentValues.getAsString("comment_id");
        }
        boolean zM17645a = m17645a(uri, "replace", false);
        Uri uriBuild = uri2.buildUpon().appendPath(asString).build();
        if (!zM17645a) {
            new C4670f().m17671a(str).m17669a(sQLiteDatabase, contentValues);
            getContext().getContentResolver().notifyChange(uriBuild, null);
            return uriBuild;
        }
        if (update(uriBuild, contentValues, null, null) == 0) {
            new C4670f().m17671a(str).m17669a(sQLiteDatabase, contentValues);
            getContext().getContentResolver().notifyChange(uriBuild, null);
        }
        if (uri.getPath().equals(C4667c.f16901a.getPath())) {
            boolean zM17645a2 = m17645a(uri, "withLoadMoreItem", false);
            C4904y.m18639b("Is with load more item: " + zM17645a2, f16887a);
            if (zM17645a2) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("item_type", Integer.valueOf(EnumC4668d.LoadMore.m17667a()));
                new C4670f().m17671a(str).m17672a("item_id=?", contentValues.getAsString("item_id")).m17674b(sQLiteDatabase, contentValues2);
                return uriBuild;
            }
            return uriBuild;
        }
        return uriBuild;
    }

    /* renamed from: a */
    private int m17641a(SQLiteDatabase sQLiteDatabase, Uri uri) throws Throwable {
        Cursor cursor;
        Cursor cursorRawQuery;
        C4904y.m18639b("TrunkContentProvider.onTrunkItemMarkAsRead", f16887a);
        String str = uri.getPathSegments().get(2);
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(String.format("SELECT %s FROM %s WHERE %s = ?", "session_id", "trunk_item", "item_id"), new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (!cursorRawQuery.moveToNext()) {
                C4904y.m18639b("Can't find trunk item", f16887a);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return 0;
            }
            String string = cursorRawQuery.getString(0);
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            String[] strArr = {Spam.ACTIVITY_CANCEL};
            ContentValues contentValues = new ContentValues();
            contentValues.put("unread_comment_count", (Integer) 0);
            int iUpdate = update(C4667c.f16901a.buildUpon().appendPath(str).build(), contentValues, "unread_comment_count > ?", strArr);
            if (iUpdate <= 0) {
                return iUpdate;
            }
            String str2 = String.format("UPDATE %s \tSET \t\t%s = %s - 1 \tWHERE \t\t%s = ?", "trunk", "unread_item_count", "unread_item_count", "session_id");
            C4904y.m18639b(new StringBuilder().append("SQL: ").append(str2).toString(), f16887a);
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
    private int m17642a(SQLiteDatabase sQLiteDatabase, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        int i;
        int i2;
        C4904y.m18639b("TrunkContentProvider.onTrunkItemDeleted", f16887a);
        int i3 = 0;
        HashMap map = new HashMap();
        boolean zM17645a = m17645a(uri, "effect", false);
        boolean zM17645a2 = m17645a(uri, "rearrangeLoadMoreItem", true);
        String str2 = null;
        if (uri != null && uri.getPathSegments().size() > 1) {
            str2 = uri.getPathSegments().get(1);
        }
        C4670f c4670fM17672a = new C4670f().m17671a("trunk_item").m17672a(str, strArr);
        if (str2 != null && !str2.trim().equals("")) {
            c4670fM17672a.m17672a("item_id=?", str2);
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
                        EnumC4668d enumC4668dM17666a = EnumC4668d.m17666a(cursorQuery.getInt(cursorQuery.getColumnIndex("item_type")));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("unread_comment_count"));
                        if (zM17645a) {
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
                        sQLiteDatabase.execSQL(String.format("DELETE FROM %s WHERE %s=? AND %s=?", "trunk_item", "item_id", "item_type"), new Object[]{string, Integer.valueOf(enumC4668dM17666a.m17667a())});
                        if (zM17645a2) {
                            C4904y.m18639b("Rearrange load more item: " + string, f16887a);
                            if (enumC4668dM17666a == EnumC4668d.Item) {
                                if (m17646a(string)) {
                                    m17648b(string);
                                } else {
                                    C4904y.m18639b("This item hasn't more item. skip rearrange logic.", f16887a);
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
            if (zM17645a) {
                for (Map.Entry entry : map.entrySet()) {
                    Integer[] numArr2 = (Integer[]) entry.getValue();
                    C4904y.m18639b("Effect other table. Total item count: " + numArr2[0] + ", Unread item count: " + numArr2[1], f16887a);
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
    private int m17647b(SQLiteDatabase sQLiteDatabase, Uri uri, String str, String[] strArr) throws SQLException {
        C4904y.m18639b("TrunkContentProvider.onTrunkCommentDeleted", f16887a);
        HashMap map = new HashMap();
        boolean zM17645a = m17645a(uri, "effect", false);
        String str2 = null;
        if (uri != null && uri.getPathSegments().size() > 2) {
            str2 = uri.getPathSegments().get(2);
        }
        C4670f c4670fM17672a = new C4670f().m17672a(str, strArr);
        if (str2 != null && !str2.trim().equals("")) {
            c4670fM17672a.m17672a("comment_id=?", str2);
        }
        if (zM17645a) {
            Cursor cursor = null;
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(String.format("SELECT %s, COUNT(*) FROM %s WHERE %s GROUP BY %s ", "item_id", "trunk_comment", c4670fM17672a.m17673a(), "item_id"), c4670fM17672a.m17675b());
                if (!cursorRawQuery.moveToNext()) {
                    C4904y.m18639b("Can't find trunk comment", f16887a);
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
        c4670fM17672a.m17671a("trunk_comment");
        int iM17668a = c4670fM17672a.m17668a(sQLiteDatabase);
        if (zM17645a) {
            C4904y.m18639b("Effect other table", f16887a);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue = ((Integer) entry.getValue()).intValue();
                C4904y.m18639b("TrunkItemId: " + ((String) entry.getKey()) + ", DeletingRowCount: " + iIntValue, f16887a);
                sb.setLength(0);
                sb.append("UPDATE %s ");
                sb.append("\tSET ");
                sb.append("\t\t%s=%s-%d ");
                sb.append("\tWHERE ");
                sb.append("\t\t%s=?");
                String str3 = String.format(Locale.UK, sb.toString(), "trunk_item", "total_comment_count", "total_comment_count", Integer.valueOf(iIntValue), "item_id");
                C4904y.m18639b("SQL: " + str3, f16887a);
                sQLiteDatabase.execSQL(str3, new Object[]{entry.getKey()});
            }
        }
        return iM17668a;
    }

    /* renamed from: a */
    private boolean m17646a(String str) {
        Cursor cursorQuery = query(C4667c.f16901a.buildUpon().appendPath(str).build(), null, "item_type=?", new String[]{String.valueOf(EnumC4668d.LoadMore.m17667a())}, null);
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
    private void m17648b(String str) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = query(C4667c.f16901a, null, "item_id > ?", new String[]{str}, "item_id ASC");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                        if (EnumC4668d.m17666a(cursorQuery.getInt(cursorQuery.getColumnIndex("item_type"))) == EnumC4668d.Item) {
                            C4904y.m18639b("Move load more trunk item to previous item. Item id: " + string, f16887a);
                            Uri uriBuild = C4667c.f16901a.buildUpon().appendPath(str).build();
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
    private boolean m17645a(Uri uri, String str, boolean z) {
        String queryParameter;
        return (uri == null || (queryParameter = uri.getQueryParameter(str)) == null) ? z : Boolean.parseBoolean(queryParameter);
    }
}
