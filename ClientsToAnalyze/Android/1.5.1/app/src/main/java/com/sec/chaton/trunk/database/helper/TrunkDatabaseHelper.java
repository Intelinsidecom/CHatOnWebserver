package com.sec.chaton.trunk.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class TrunkDatabaseHelper {
    private static final String TAG = TrunkDatabaseHelper.class.getSimpleName();
    private Context context;

    public TrunkDatabaseHelper(Context context) {
        this.context = context;
    }

    private void rearrangeLoadMoreTrunkItem(String str) {
        if (!hasLoadMoreTrunkItem(str)) {
            ChatONLogWriter.m3506b("This item hasn't more item. skip rearrange logic.", TAG);
            return;
        }
        Cursor cursorQuery = this.context.getContentResolver().query(DatabaseConstant.TrunkItemTable.CONTENT_URI, null, "item_id > ?", new String[]{str}, "item_id ASC");
        try {
            if (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                if (DatabaseConstant.TrunkItemTable.ItemType.Convert(cursorQuery.getInt(cursorQuery.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_ITEM_TYPE))) == DatabaseConstant.TrunkItemTable.ItemType.Item) {
                    ChatONLogWriter.m3506b("Move load more trunk item to previous item.", TAG);
                    Uri uriBuild = DatabaseConstant.TrunkItemTable.CONTENT_URI.buildUpon().appendPath(str).build();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("item_id", string);
                    this.context.getContentResolver().update(uriBuild, contentValues, null, null);
                } else {
                    removeLoadMoreTrunkItem(str);
                }
            } else {
                removeLoadMoreTrunkItem(str);
            }
        } catch (Exception e) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private void removeTrunkItem(String str, DatabaseConstant.TrunkItemTable.ItemType itemType) {
        this.context.getContentResolver().delete(DatabaseConstant.TrunkItemTable.CONTENT_URI.buildUpon().appendPath(str).build(), "item_type=?", new String[]{String.valueOf(itemType.getValue())});
        rearrangeLoadMoreTrunkItem(str);
    }

    private boolean saveTrunkItem(TrunkItem trunkItem, DatabaseConstant.TrunkItemTable.ItemType itemType) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", trunkItem.sessionid);
        contentValues.put("item_id", trunkItem.itemid);
        contentValues.put(DatabaseConstant.TrunkItemColumns.KEY_TOTAL_COMMENT_COUNT, Integer.valueOf(trunkItem.totcmtcnt));
        contentValues.put("unread_comment_count", Integer.valueOf(trunkItem.unreadcmtcnt));
        contentValues.put("last_comment_time", Long.valueOf(trunkItem.lastcmtdttm));
        contentValues.put("registration_time", Long.valueOf(trunkItem.regdttm));
        contentValues.put(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, trunkItem.file.contenttype);
        contentValues.put(DatabaseConstant.TrunkItemColumns.KEY_THUMBNAIL, trunkItem.file.thumburl);
        contentValues.put(DatabaseConstant.TrunkItemColumns.KEY_DOWN_URL, trunkItem.file.downurl);
        contentValues.put(DatabaseConstant.TrunkItemColumns.KEY_ITEM_TYPE, Integer.valueOf(itemType.getValue()));
        contentValues.put(DatabaseConstant.TrunkItemColumns.KEY_SENDER_UID, trunkItem.user.f3313id);
        contentValues.put(DatabaseConstant.TrunkItemColumns.KEY_SENDER_NAME, trunkItem.user.orgname);
        contentValues.put(DatabaseConstant.TrunkItemColumns.KEY_SENDER_NUMBER, trunkItem.user.orgnum);
        Uri uriBuild = DatabaseConstant.TrunkItemTable.CONTENT_URI.buildUpon().appendPath(trunkItem.itemid).build();
        String[] strArr = {String.valueOf(itemType.getValue())};
        Cursor cursorQuery = this.context.getContentResolver().query(uriBuild, null, "item_type=?", strArr, null);
        try {
            if (cursorQuery.getCount() == 0) {
                this.context.getContentResolver().insert(DatabaseConstant.TrunkItemTable.CONTENT_URI, contentValues);
                return true;
            }
            this.context.getContentResolver().update(uriBuild, contentValues, "item_type=?", strArr);
            return false;
        } finally {
            cursorQuery.close();
        }
    }

    public void decreaseTotalCommentCountOfTrunkItem(String str) {
        Uri uriBuild = DatabaseConstant.TrunkItemTable.CONTENT_URI.buildUpon().appendPath(str).build();
        Cursor cursorQuery = this.context.getContentResolver().query(uriBuild, null, null, null, null);
        try {
            if (cursorQuery.moveToNext()) {
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_TOTAL_COMMENT_COUNT)) - 1;
                if (i < 0) {
                    i = 0;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseConstant.TrunkItemColumns.KEY_TOTAL_COMMENT_COUNT, Integer.valueOf(i));
                this.context.getContentResolver().update(uriBuild, contentValues, null, null);
            }
        } finally {
            cursorQuery.close();
        }
    }

    public boolean hasLoadMoreTrunkItem(String str) {
        Uri uriBuild = DatabaseConstant.TrunkItemTable.CONTENT_URI.buildUpon().appendPath(str).build();
        String[] strArr = {String.valueOf(DatabaseConstant.TrunkItemTable.ItemType.LoadMore.getValue())};
        Cursor cursorQuery = this.context.getContentResolver().query(uriBuild, null, "item_type=?", strArr, null);
        ChatONLogWriter.m3506b("QueryUri: " + uriBuild + ", where: item_type=?, selectionArgs: " + strArr[0], TAG);
        try {
            return cursorQuery.getCount() != 0;
        } finally {
            cursorQuery.close();
        }
    }

    public void markAsReadTrunkItem(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread_comment_count", (Integer) 0);
        this.context.getContentResolver().update(DatabaseConstant.TrunkItemTable.CONTENT_URI.buildUpon().appendPath(str).build(), contentValues, null, null);
    }

    public void removeLoadMoreTrunkItem(String str) {
        removeTrunkItem(str, DatabaseConstant.TrunkItemTable.ItemType.LoadMore);
    }

    public void removeTrunk(String str) {
        new ContentValues().put("session_id", str);
        this.context.getContentResolver().delete(DatabaseConstant.TrunkTable.CONTENT_URI.buildUpon().appendPath(str).build(), null, null);
    }

    public void removeTrunkComment(String str) {
        this.context.getContentResolver().delete(DatabaseConstant.TrunkCommentTable.CONTENT_URI.buildUpon().appendPath(str).build(), null, null);
    }

    public void removeTrunkCommentsByItemId(String str) {
        this.context.getContentResolver().delete(DatabaseConstant.TrunkCommentTable.CONTENT_URI, "item_id=?", new String[]{str});
    }

    public void removeTrunkItem(String str) {
        removeTrunkItem(str, DatabaseConstant.TrunkItemTable.ItemType.Item);
    }

    public void removeTrunkItems(String str) {
        this.context.getContentResolver().delete(DatabaseConstant.TrunkItemTable.CONTENT_URI, "session_id=?", new String[]{str});
    }

    public boolean saveLoadMoreTrunkItem(TrunkItem trunkItem) {
        return saveTrunkItem(trunkItem, DatabaseConstant.TrunkItemTable.ItemType.LoadMore);
    }

    public boolean saveTrunk(Trunk trunk) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", trunk.sessionid);
        contentValues.put(DatabaseConstant.TrunkColumns.KEY_LAST_UPDATE_TIME, Long.valueOf(trunk.lastupdttm));
        contentValues.put("last_comment_time", Long.valueOf(trunk.lastcmtdttm));
        contentValues.put(DatabaseConstant.TrunkColumns.KEY_TOTAL_ITEM_COUNT, Integer.valueOf(trunk.totitemcnt));
        contentValues.put(DatabaseConstant.TrunkColumns.KEY_UNREAD_ITEM_COUNT, Integer.valueOf(trunk.unreadcmtcnt));
        contentValues.put(DatabaseConstant.TrunkColumns.KEY_UNREAD_ITEM_COUNT, Integer.valueOf(trunk.unreaditemcnt));
        Uri uriBuild = DatabaseConstant.TrunkTable.CONTENT_URI.buildUpon().appendPath(trunk.sessionid).build();
        if (this.context.getContentResolver().query(uriBuild, null, null, null, null).getCount() == 0) {
            this.context.getContentResolver().insert(DatabaseConstant.TrunkTable.CONTENT_URI, contentValues);
            return true;
        }
        this.context.getContentResolver().update(uriBuild, contentValues, null, null);
        return false;
    }

    public boolean saveTrunkComment(Comment comment) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseConstant.TrunkCommentColumns.KEY_COMMENT_ID, comment.cid);
        contentValues.put("item_id", comment.itemid);
        contentValues.put("registration_time", Long.valueOf(comment.regdttm));
        contentValues.put(DatabaseConstant.TrunkCommentColumns.KEY_WRITER_ID, comment.user.f3313id);
        contentValues.put(DatabaseConstant.TrunkCommentColumns.KEY_WRITER_NAME, comment.user.orgname);
        contentValues.put(DatabaseConstant.TrunkCommentColumns.KEY_WRITER_NUMBER, comment.user.orgnum);
        contentValues.put(DatabaseConstant.TrunkCommentColumns.KEY_CONTENT, comment.content);
        Uri uriBuild = DatabaseConstant.TrunkCommentTable.CONTENT_URI.buildUpon().appendPath(comment.cid).build();
        if (this.context.getContentResolver().query(uriBuild, null, null, null, null).getCount() == 0) {
            this.context.getContentResolver().insert(DatabaseConstant.TrunkCommentTable.CONTENT_URI, contentValues);
            return true;
        }
        this.context.getContentResolver().update(uriBuild, contentValues, null, null);
        return false;
    }

    public boolean saveTrunkItem(TrunkItem trunkItem) {
        return saveTrunkItem(trunkItem, DatabaseConstant.TrunkItemTable.ItemType.Item);
    }
}
