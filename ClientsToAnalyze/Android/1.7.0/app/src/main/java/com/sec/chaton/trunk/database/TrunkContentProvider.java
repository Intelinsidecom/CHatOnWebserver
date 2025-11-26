package com.sec.chaton.trunk.database;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.motion.MREvent;
import android.net.Uri;
import com.sec.chaton.trunk.database.p046a.C1172a;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class TrunkContentProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f4022a = TrunkContentProvider.class.getSimpleName();

    /* renamed from: b */
    private UriMatcher f4023b;

    /* renamed from: a */
    private void m4224a() {
        this.f4023b = new UriMatcher(-1);
        this.f4023b.addURI("com.develop.sec.chaton.provider", "trunk", 1);
        this.f4023b.addURI("com.develop.sec.chaton.provider", "trunk/*", 2);
        this.f4023b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment", 20);
        this.f4023b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment/item/*", 22);
        this.f4023b.addURI("com.develop.sec.chaton.provider", "trunk_item/trunk_comment/*", 21);
        this.f4023b.addURI("com.develop.sec.chaton.provider", "trunk_item", 10);
        this.f4023b.addURI("com.develop.sec.chaton.provider", "trunk_item/markAsRead/*", 13);
        this.f4023b.addURI("com.develop.sec.chaton.provider", "trunk_item/*", 12);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m4224a();
        return true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.f4023b.match(uri)) {
            case 1:
                return "vnd.chaton.cursor.dir/vnd.chaton.trunk";
            case 2:
                return "vnd.chaton.cursor.item/vnd.chaton.trunk";
            case 10:
                return "vnd.chaton.cursor.dir/vnd.chaton.trunk.item";
            case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                return "vnd.chaton.cursor.item/vnd.chaton.trunk.item";
            case MREvent.TILT_LANDSCAPE_RIGHT_LEVEL_2 /* 20 */:
            case MREvent.TILT_FRONT /* 22 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.trunk.comment";
            case MREvent.TILT_LANDSCAPE_LEFT_RIGHT_STOP /* 21 */:
                return "vnd.chaton.cursor.item/vnd.chaton.trunk.comment";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorM4246a;
        SQLiteDatabase readableDatabase = C1172a.m4229a().getReadableDatabase();
        switch (this.f4023b.match(uri)) {
            case 1:
                Cursor cursorM4246a2 = new C1174b().m4247a("trunk").m4248a(str, strArr2).m4246a(readableDatabase, null, null, str2);
                if (cursorM4246a2 != null) {
                    cursorM4246a2.setNotificationUri(getContext().getContentResolver(), C1178f.f4044a);
                    return cursorM4246a2;
                }
                return cursorM4246a2;
            case 2:
                String str3 = uri.getPathSegments().get(1);
                cursorM4246a = new C1174b().m4247a("trunk").m4248a(str, strArr2).m4248a("session_id=?", str3).m4246a(readableDatabase, null, null, str2);
                if (cursorM4246a != null) {
                    cursorM4246a.setNotificationUri(getContext().getContentResolver(), C1178f.f4044a.buildUpon().appendPath(str3).build());
                    return cursorM4246a;
                }
                break;
            case 10:
                Cursor cursorM4246a3 = new C1174b().m4247a("trunk_item").m4248a(str, strArr2).m4246a(readableDatabase, null, null, str2);
                if (cursorM4246a3 != null) {
                    cursorM4246a3.setNotificationUri(getContext().getContentResolver(), C1175c.f4038a);
                    return cursorM4246a3;
                }
                return cursorM4246a3;
            case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                String str4 = uri.getPathSegments().get(1);
                cursorM4246a = new C1174b().m4247a("trunk_item").m4248a(str, strArr2).m4248a("item_id=?", str4).m4246a(readableDatabase, null, null, str2);
                if (cursorM4246a != null) {
                    cursorM4246a.setNotificationUri(getContext().getContentResolver(), C1175c.f4038a.buildUpon().appendPath(str4).build());
                    return cursorM4246a;
                }
                break;
            case MREvent.TILT_LANDSCAPE_RIGHT_LEVEL_2 /* 20 */:
                Cursor cursorM4246a4 = new C1174b().m4247a("trunk_comment").m4248a(str, strArr2).m4246a(readableDatabase, null, null, str2);
                if (cursorM4246a4 != null) {
                    cursorM4246a4.setNotificationUri(getContext().getContentResolver(), C1176d.f4039a);
                    return cursorM4246a4;
                }
                return cursorM4246a4;
            case MREvent.TILT_LANDSCAPE_LEFT_RIGHT_STOP /* 21 */:
                String str5 = uri.getPathSegments().get(2);
                cursorM4246a = new C1174b().m4247a("trunk_comment").m4248a(str, strArr2).m4248a("comment_id=?", str5).m4246a(readableDatabase, null, null, str2);
                if (cursorM4246a != null) {
                    cursorM4246a.setNotificationUri(getContext().getContentResolver(), C1176d.f4039a.buildUpon().appendPath(str5).build());
                    return cursorM4246a;
                }
                break;
            case MREvent.TILT_FRONT /* 22 */:
                Cursor cursorM4246a5 = new C1174b().m4247a("trunk_comment").m4248a(str, strArr2).m4248a("item_id=?", uri.getPathSegments().get(3)).m4246a(readableDatabase, null, null, str2);
                if (cursorM4246a5 != null) {
                    cursorM4246a5.setNotificationUri(getContext().getContentResolver(), C1176d.f4039a);
                    return cursorM4246a5;
                }
                return cursorM4246a5;
            default:
                throw new IllegalArgumentException("URI isn't valid.");
        }
        return cursorM4246a;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM4223a = null;
        SQLiteDatabase writableDatabase = C1172a.m4229a().getWritableDatabase();
        int iMatch = this.f4023b.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    uriM4223a = m4223a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM4223a, null);
                    break;
                case 10:
                    uriM4223a = m4223a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM4223a, null);
                    break;
                case MREvent.TILT_LANDSCAPE_RIGHT_LEVEL_2 /* 20 */:
                    uriM4223a = m4223a(writableDatabase, uri, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    getContext().getContentResolver().notifyChange(uriM4223a, null);
                    break;
                default:
                    return uriM4223a;
            }
            return uriM4223a;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int iM4227b = 0;
        SQLiteDatabase writableDatabase = C1172a.m4229a().getWritableDatabase();
        int iMatch = this.f4023b.match(uri);
        writableDatabase.beginTransaction();
        try {
            switch (iMatch) {
                case 1:
                    iM4227b = new C1174b().m4247a("trunk").m4248a(str, strArr).m4244a(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 2:
                    iM4227b = new C1174b().m4247a("trunk").m4248a(str, strArr).m4248a("session_id=?", uri.getPathSegments().get(1)).m4244a(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 10:
                case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                    iM4227b = m4222a(writableDatabase, uri, str, strArr);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case MREvent.TILT_LANDSCAPE_RIGHT_LEVEL_2 /* 20 */:
                case MREvent.TILT_LANDSCAPE_LEFT_RIGHT_STOP /* 21 */:
                    iM4227b = m4227b(writableDatabase, uri, str, strArr);
                    writableDatabase.setTransactionSuccessful();
                    break;
            }
            getContext().getContentResolver().notifyChange(uri, null);
            return iM4227b;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iM4250b = 0;
        SQLiteDatabase writableDatabase = C1172a.m4229a().getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            switch (this.f4023b.match(uri)) {
                case 1:
                    iM4250b = new C1174b().m4247a("trunk").m4248a(str, strArr).m4250b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 2:
                    iM4250b = new C1174b().m4247a("trunk").m4248a(str, strArr).m4248a("session_id=?", uri.getPathSegments().get(1)).m4250b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case 10:
                    iM4250b = new C1174b().m4247a("trunk_item").m4248a(str, strArr).m4250b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                    iM4250b = new C1174b().m4247a("trunk_item").m4248a(str, strArr).m4248a("item_id=?", uri.getPathSegments().get(1)).m4250b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case MREvent.TILT_PORTRAIT_FRONT_BACK_STOP /* 13 */:
                    iM4250b = m4221a(writableDatabase, uri);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case MREvent.TILT_LANDSCAPE_RIGHT_LEVEL_2 /* 20 */:
                    iM4250b = new C1174b().m4247a("trunk_comment").m4248a(str, strArr).m4250b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_RIGHT_STOP /* 21 */:
                    iM4250b = new C1174b().m4247a("trunk_comment").m4248a(str, strArr).m4248a("comment_id=?", uri.getPathSegments().get(2)).m4250b(writableDatabase, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    break;
            }
            getContext().getContentResolver().notifyChange(uri, null);
            return iM4250b;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList arrayList) {
        SQLiteDatabase writableDatabase = C1172a.m4229a().getWritableDatabase();
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
    private Uri m4223a(SQLiteDatabase sQLiteDatabase, Uri uri, ContentValues contentValues) {
        Uri uri2;
        String str;
        String asString;
        if (uri.getPath().equals(C1178f.f4044a.getPath())) {
            uri2 = C1178f.f4044a;
            str = "trunk";
            asString = contentValues.getAsString("session_id");
        } else if (uri.getPath().equals(C1175c.f4038a.getPath())) {
            uri2 = C1175c.f4038a;
            str = "trunk_item";
            asString = contentValues.getAsString("item_id");
        } else {
            if (!uri.getPath().equals(C1176d.f4039a.getPath())) {
                return null;
            }
            uri2 = C1176d.f4039a;
            str = "trunk_comment";
            asString = contentValues.getAsString("comment_id");
        }
        boolean zM4225a = m4225a(uri, "replace", false);
        Uri uriBuild = uri2.buildUpon().appendPath(asString).build();
        if (!zM4225a) {
            new C1174b().m4247a(str).m4245a(sQLiteDatabase, contentValues);
            getContext().getContentResolver().notifyChange(uriBuild, null);
            return uriBuild;
        }
        if (update(uriBuild, contentValues, null, null) == 0) {
            new C1174b().m4247a(str).m4245a(sQLiteDatabase, contentValues);
            getContext().getContentResolver().notifyChange(uriBuild, null);
            if (uri.getPath().equals(C1175c.f4038a.getPath())) {
                boolean zM4225a2 = m4225a(uri, "withLoadMoreItem", false);
                C1341p.m4658b("Is with load more item: " + zM4225a2, f4022a);
                if (zM4225a2) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("item_type", Integer.valueOf(EnumC1177e.LoadMore.m4254a()));
                    new C1174b().m4247a(str).m4248a("item_id=?", contentValues.getAsString("item_id")).m4250b(sQLiteDatabase, contentValues2);
                    return uriBuild;
                }
                return uriBuild;
            }
            return uriBuild;
        }
        if (uri.getPath().equals(C1175c.f4038a.getPath())) {
            boolean zM4225a3 = m4225a(uri, "withLoadMoreItem", false);
            C1341p.m4658b("Is with load more item: " + zM4225a3, f4022a);
            if (zM4225a3) {
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("item_type", Integer.valueOf(EnumC1177e.LoadMore.m4254a()));
                new C1174b().m4247a(str).m4248a("item_id=?", contentValues.getAsString("item_id")).m4250b(sQLiteDatabase, contentValues3);
                return uriBuild;
            }
            return uriBuild;
        }
        return uriBuild;
    }

    /* renamed from: a */
    private int m4221a(SQLiteDatabase sQLiteDatabase, Uri uri) throws Throwable {
        Cursor cursor;
        Cursor cursorRawQuery;
        C1341p.m4658b("TrunkContentProvider.onTrunkItemMarkAsRead", f4022a);
        String str = uri.getPathSegments().get(2);
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(String.format("SELECT %s FROM %s WHERE %s = ?", "session_id", "trunk_item", "item_id"), new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (!cursorRawQuery.moveToNext()) {
                C1341p.m4658b("Can't find trunk item", f4022a);
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
            int iUpdate = update(C1175c.f4038a.buildUpon().appendPath(str).build(), contentValues, "unread_comment_count > ?", new String[]{"0"});
            if (iUpdate <= 0) {
                return iUpdate;
            }
            String str2 = String.format("UPDATE %s \tSET \t\t%s = %s - 1 \tWHERE \t\t%s = ?", "trunk", "unread_item_count", "unread_item_count", "session_id");
            C1341p.m4658b(new StringBuilder().append("SQL: ").append(str2).toString(), f4022a);
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
    private int m4222a(SQLiteDatabase sQLiteDatabase, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        int i;
        int i2;
        C1341p.m4658b("TrunkContentProvider.onTrunkItemDeleted", f4022a);
        int i3 = 0;
        HashMap map = new HashMap();
        boolean zM4225a = m4225a(uri, "effect", false);
        boolean zM4225a2 = m4225a(uri, "rearrangeLoadMoreItem", true);
        String str2 = null;
        if (uri.getPathSegments().size() > 1) {
            str2 = uri.getPathSegments().get(1);
        }
        C1174b c1174bM4248a = new C1174b().m4247a("trunk_item").m4248a(str, strArr);
        if (str2 != null && !str2.trim().equals("")) {
            c1174bM4248a.m4248a("item_id=?", str2);
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
                        EnumC1177e enumC1177eM4253a = EnumC1177e.m4253a(cursorQuery.getInt(cursorQuery.getColumnIndex("item_type")));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("unread_comment_count"));
                        if (zM4225a) {
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
                        sQLiteDatabase.execSQL(String.format("DELETE FROM %s WHERE %s=? AND %s=?", "trunk_item", "item_id", "item_type"), new Object[]{string, Integer.valueOf(enumC1177eM4253a.m4254a())});
                        if (zM4225a2) {
                            C1341p.m4658b("Rearrange load more item: " + string, f4022a);
                            if (enumC1177eM4253a == EnumC1177e.Item) {
                                if (m4226a(string)) {
                                    m4228b(string);
                                } else {
                                    C1341p.m4658b("This item hasn't more item. skip rearrange logic.", f4022a);
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
            if (zM4225a) {
                for (String str3 : map.keySet()) {
                    Integer[] numArr2 = (Integer[]) map.get(str3);
                    C1341p.m4658b("Effect other table. Total item count: " + numArr2[0] + ", Unread item count: " + numArr2[1], f4022a);
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
    private int m4227b(SQLiteDatabase sQLiteDatabase, Uri uri, String str, String[] strArr) throws SQLException {
        C1341p.m4658b("TrunkContentProvider.onTrunkCommentDeleted", f4022a);
        HashMap map = new HashMap();
        boolean zM4225a = m4225a(uri, "effect", false);
        String str2 = uri.getPathSegments().size() > 2 ? uri.getPathSegments().get(2) : null;
        C1174b c1174bM4248a = new C1174b().m4248a(str, strArr);
        if (str2 != null && !str2.trim().equals("")) {
            c1174bM4248a.m4248a("comment_id=?", str2);
        }
        if (zM4225a) {
            Cursor cursor = null;
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(String.format("SELECT %s, COUNT(*) FROM %s WHERE %s GROUP BY %s ", "item_id", "trunk_comment", c1174bM4248a.m4249a(), "item_id"), c1174bM4248a.m4251b());
                if (!cursorRawQuery.moveToNext()) {
                    C1341p.m4658b("Can't find trunk comment", f4022a);
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
        c1174bM4248a.m4247a("trunk_comment");
        int iM4244a = c1174bM4248a.m4244a(sQLiteDatabase);
        if (zM4225a) {
            C1341p.m4658b("Effect other table", f4022a);
            StringBuilder sb = new StringBuilder();
            for (String str3 : map.keySet()) {
                int iIntValue = ((Integer) map.get(str3)).intValue();
                C1341p.m4658b("TrunkItemId: " + str3 + ", DeletingRowCount: " + iIntValue, f4022a);
                sb.setLength(0);
                sb.append("UPDATE %s ");
                sb.append("\tSET ");
                sb.append("\t\t%s=%s-%d ");
                sb.append("\tWHERE ");
                sb.append("\t\t%s=?");
                String str4 = String.format(sb.toString(), "trunk_item", "total_comment_count", "total_comment_count", Integer.valueOf(iIntValue), "item_id");
                C1341p.m4658b("SQL: " + str4, f4022a);
                sQLiteDatabase.execSQL(str4, new Object[]{str3});
            }
        }
        return iM4244a;
    }

    /* renamed from: a */
    private boolean m4226a(String str) {
        Cursor cursorQuery = query(C1175c.f4038a.buildUpon().appendPath(str).build(), null, "item_type=?", new String[]{String.valueOf(EnumC1177e.LoadMore.m4254a())}, null);
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
    private void m4228b(String str) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = query(C1175c.f4038a, null, "item_id > ?", new String[]{str}, "item_id ASC");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                        if (EnumC1177e.m4253a(cursorQuery.getInt(cursorQuery.getColumnIndex("item_type"))) == EnumC1177e.Item) {
                            C1341p.m4658b("Move load more trunk item to previous item. Item id: " + string, f4022a);
                            Uri uriBuild = C1175c.f4038a.buildUpon().appendPath(str).build();
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
    private boolean m4225a(Uri uri, String str, boolean z) {
        String queryParameter;
        return (uri == null || (queryParameter = uri.getQueryParameter(str)) == null) ? z : Boolean.parseBoolean(queryParameter);
    }
}
