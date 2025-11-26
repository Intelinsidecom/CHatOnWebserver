package com.sec.chaton.trunk.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseOpenHelper;

/* loaded from: classes.dex */
public class TrunkContentProvider extends ContentProvider {
    private static final int TRUNK_CODE = 2;
    private static final int TRUNK_COMMENT_CODE = 21;
    private static final int TRUNK_COMMENT_LIST_BY_ITEM_CDOE = 22;
    private static final int TRUNK_COMMENT_LIST_CODE = 20;
    private static final int TRUNK_ITEM_CODE = 12;
    private static final int TRUNK_ITEM_LIST_CODE = 10;
    private static final int TRUNK_LIST_CODE = 1;
    private SQLiteDatabase database;
    private TrunkDatabaseOpenHelper databaseHelper;
    private UriMatcher uriMatcher;

    private void initUriMatcher() {
        this.uriMatcher = new UriMatcher(-1);
        this.uriMatcher.addURI(DatabaseConstant.CONTENT_AUTHORITY, "trunk", 1);
        this.uriMatcher.addURI(DatabaseConstant.CONTENT_AUTHORITY, "trunk/*", 2);
        this.uriMatcher.addURI(DatabaseConstant.CONTENT_AUTHORITY, "trunk_item", 10);
        this.uriMatcher.addURI(DatabaseConstant.CONTENT_AUTHORITY, "trunk_item/*", 12);
        this.uriMatcher.addURI(DatabaseConstant.CONTENT_AUTHORITY, "trunk_comment", TRUNK_COMMENT_LIST_CODE);
        this.uriMatcher.addURI(DatabaseConstant.CONTENT_AUTHORITY, "trunk_comment/item/*", TRUNK_COMMENT_LIST_BY_ITEM_CDOE);
        this.uriMatcher.addURI(DatabaseConstant.CONTENT_AUTHORITY, "trunk_comment/*", TRUNK_COMMENT_CODE);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int iDelete;
        switch (this.uriMatcher.match(uri)) {
            case 1:
                iDelete = new SQLBuilder().table("trunk").where(str, strArr).delete(this.database);
                break;
            case 2:
                iDelete = new SQLBuilder().table("trunk").where(str, strArr).where("session_id=?", uri.getPathSegments().get(1)).delete(this.database);
                break;
            case 10:
                iDelete = new SQLBuilder().table("trunk_item").where(str, strArr).delete(this.database);
                break;
            case 12:
                iDelete = new SQLBuilder().table("trunk_item").where(str, strArr).where("item_id=?", uri.getPathSegments().get(1)).delete(this.database);
                break;
            case TRUNK_COMMENT_LIST_CODE /* 20 */:
                iDelete = new SQLBuilder().table("trunk_comment").where(str, strArr).delete(this.database);
                break;
            case TRUNK_COMMENT_CODE /* 21 */:
                iDelete = new SQLBuilder().table("trunk_comment").where(str, strArr).where("comment_id=?", uri.getPathSegments().get(1)).delete(this.database);
                break;
            default:
                iDelete = 0;
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return iDelete;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (this.uriMatcher.match(uri)) {
            case 1:
                return DatabaseConstant.TrunkTable.CONTENT_TYPE;
            case 2:
                return DatabaseConstant.TrunkTable.CONTENT_ITEM_TYPE;
            case 10:
                return DatabaseConstant.TrunkItemTable.CONTENT_TYPE;
            case 12:
                return DatabaseConstant.TrunkItemTable.CONTENT_ITEM_TYPE;
            case TRUNK_COMMENT_LIST_CODE /* 20 */:
            case TRUNK_COMMENT_LIST_BY_ITEM_CDOE /* 22 */:
                return DatabaseConstant.TrunkCommentTable.CONTENT_TYPE;
            case TRUNK_COMMENT_CODE /* 21 */:
                return DatabaseConstant.TrunkCommentTable.CONTENT_ITEM_TYPE;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        switch (this.uriMatcher.match(uri)) {
            case 1:
                Uri uriWithAppendedId = ContentUris.withAppendedId(DatabaseConstant.TrunkTable.CONTENT_URI, new SQLBuilder().table("trunk").insert(this.database, contentValues));
                getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
                return uriWithAppendedId;
            case 10:
                Uri uriWithAppendedId2 = ContentUris.withAppendedId(DatabaseConstant.TrunkItemTable.CONTENT_URI, new SQLBuilder().table("trunk_item").insert(this.database, contentValues));
                getContext().getContentResolver().notifyChange(uriWithAppendedId2, null);
                return uriWithAppendedId2;
            case TRUNK_COMMENT_LIST_CODE /* 20 */:
                Uri uriWithAppendedId3 = ContentUris.withAppendedId(DatabaseConstant.TrunkCommentTable.CONTENT_URI, new SQLBuilder().table("trunk_comment").insert(this.database, contentValues));
                getContext().getContentResolver().notifyChange(uriWithAppendedId3, null);
                return uriWithAppendedId3;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        initUriMatcher();
        this.databaseHelper = new TrunkDatabaseOpenHelper(getContext());
        this.database = this.databaseHelper.getWritableDatabase();
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        switch (this.uriMatcher.match(uri)) {
            case 1:
                return new SQLBuilder().table("trunk").where(str, strArr2).query(this.database, null, null, str2);
            case 2:
                return new SQLBuilder().table("trunk").where(str, strArr2).where("session_id=?", uri.getPathSegments().get(1)).query(this.database, null, null, str2);
            case 10:
                return new SQLBuilder().table("trunk_item").where(str, strArr2).query(this.database, null, null, str2);
            case 12:
                return new SQLBuilder().table("trunk_item").where(str, strArr2).where("item_id=?", uri.getPathSegments().get(1)).query(this.database, null, null, str2);
            case TRUNK_COMMENT_LIST_CODE /* 20 */:
                return new SQLBuilder().table("trunk_comment").where(str, strArr2).query(this.database, null, null, str2);
            case TRUNK_COMMENT_CODE /* 21 */:
                return new SQLBuilder().table("trunk_comment").where(str, strArr2).where("comment_id=?", uri.getPathSegments().get(1)).query(this.database, null, null, str2);
            case TRUNK_COMMENT_LIST_BY_ITEM_CDOE /* 22 */:
                return new SQLBuilder().table("trunk_comment").where(str, strArr2).where("item_id=?", uri.getPathSegments().get(2)).query(this.database, null, null, str2);
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iUpdate;
        switch (this.uriMatcher.match(uri)) {
            case 1:
                iUpdate = new SQLBuilder().table("trunk").where(str, strArr).update(this.database, contentValues);
                break;
            case 2:
                iUpdate = new SQLBuilder().table("trunk").where(str, strArr).where("session_id=?", uri.getPathSegments().get(1)).update(this.database, contentValues);
                break;
            case 10:
                iUpdate = new SQLBuilder().table("trunk_item").where(str, strArr).update(this.database, contentValues);
                break;
            case 12:
                iUpdate = new SQLBuilder().table("trunk_item").where(str, strArr).where("item_id=?", uri.getPathSegments().get(1)).update(this.database, contentValues);
                break;
            case TRUNK_COMMENT_LIST_CODE /* 20 */:
                iUpdate = new SQLBuilder().table("trunk_comment").where(str, strArr).update(this.database, contentValues);
                break;
            case TRUNK_COMMENT_CODE /* 21 */:
                iUpdate = new SQLBuilder().table("trunk_comment").where(str, strArr).where("comment_id=?", uri.getPathSegments().get(1)).update(this.database, contentValues);
                break;
            default:
                iUpdate = 0;
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return iUpdate;
    }
}
