package com.sec.chaton.trunk.database.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class TrunkDatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = TrunkDatabaseOpenHelper.class.getSimpleName();
    private final String CREATE_TRUNK_COMMENT_TABLE_SQL;
    private final String CREATE_TRUNK_COMMENT_TRIGGER_SQL;
    private final String CREATE_TRUNK_ITEM_TABLE_SQL;
    private final String CREATE_TRUNK_ITEM_TRIGGER_SQL;
    private final String CREATE_TRUNK_TABLE_SQL;

    public TrunkDatabaseOpenHelper(Context context) {
        super(context, DatabaseConstant.TRUNK_DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 3);
        this.CREATE_TRUNK_TABLE_SQL = String.format("CREATE TABLE %s(\t%s INTEGER PRIMARY KEY AUTOINCREMENT, \t%s VARCHAR(200) NOT NULL UNIQUE, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0)", "trunk", "_id", "session_id", DatabaseConstant.TrunkColumns.KEY_LAST_UPDATE_TIME, "last_comment_time", DatabaseConstant.TrunkColumns.KEY_TOTAL_ITEM_COUNT, DatabaseConstant.TrunkColumns.KEY_UNREAD_ITEM_COUNT, "unread_comment_count");
        this.CREATE_TRUNK_ITEM_TABLE_SQL = String.format("CREATE TABLE %s(\t%s INTEGER PRIMARY KEY AUTOINCREMENT, \t%s VARCHAR(200) NOT NULL, \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s INTEGER DEFAULT 0)", "trunk_item", "_id", "item_id", "session_id", DatabaseConstant.TrunkItemColumns.KEY_SENDER_UID, DatabaseConstant.TrunkItemColumns.KEY_SENDER_NAME, DatabaseConstant.TrunkItemColumns.KEY_SENDER_NUMBER, "registration_time", "last_comment_time", DatabaseConstant.TrunkItemColumns.KEY_TOTAL_COMMENT_COUNT, "unread_comment_count", DatabaseConstant.TrunkItemColumns.KEY_THUMBNAIL, DatabaseConstant.TrunkItemColumns.KEY_DOWN_URL, DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, DatabaseConstant.TrunkItemColumns.KEY_ITEM_TYPE);
        StringBuilder sb = new StringBuilder("");
        sb.append("CREATE TABLE %s(");
        sb.append("\t%s INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("\t%s VARCHAR(200), ");
        sb.append("\t%s VARCHAR(200) NOT NULL UNIQUE, ");
        sb.append("\t%s INTENGER, ");
        sb.append("\t%s VARCHAR(200), ");
        sb.append("\t%s VARCHAR(200), ");
        sb.append("\t%s VARCHAR(200), ");
        sb.append("\t%s VARCHAR(1000)");
        sb.append(")");
        this.CREATE_TRUNK_COMMENT_TABLE_SQL = String.format(sb.toString(), "trunk_comment", "_id", "item_id", DatabaseConstant.TrunkCommentColumns.KEY_COMMENT_ID, "registration_time", DatabaseConstant.TrunkCommentColumns.KEY_WRITER_ID, DatabaseConstant.TrunkCommentColumns.KEY_WRITER_NAME, DatabaseConstant.TrunkCommentColumns.KEY_WRITER_NUMBER, DatabaseConstant.TrunkCommentColumns.KEY_CONTENT);
        this.CREATE_TRUNK_ITEM_TRIGGER_SQL = String.format("CREATE TRIGGER %s DELETE ON %s BEGIN  DELETE FROM %s WHERE %s=OLD.%s; END;", DatabaseConstant.TrunkItemTrigger.TRIGGER_NAME_TRUNK_ITEM, "trunk", "trunk_item", "session_id", "session_id");
        this.CREATE_TRUNK_COMMENT_TRIGGER_SQL = String.format("CREATE TRIGGER %s DELETE ON %s BEGIN   DELETE FROM %s WHERE %s=OLD.%s;  END;", DatabaseConstant.TrunkCommentTrigger.TRIGGER_NAME_TRUNK_COMMENT, "trunk_item", "trunk_comment", "item_id", "item_id");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(this.CREATE_TRUNK_TABLE_SQL);
        sQLiteDatabase.execSQL(this.CREATE_TRUNK_ITEM_TABLE_SQL);
        sQLiteDatabase.execSQL(this.CREATE_TRUNK_COMMENT_TABLE_SQL);
        sQLiteDatabase.execSQL(this.CREATE_TRUNK_ITEM_TRIGGER_SQL);
        sQLiteDatabase.execSQL(this.CREATE_TRUNK_COMMENT_TRIGGER_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        int i3;
        if (i == 1) {
            ChatONLogWriter.m3508c("Upgrading from : " + i + " to : " + i2, TAG);
            sQLiteDatabase.execSQL("DROP TABLE trunk_comment");
            sQLiteDatabase.execSQL("DROP TABLE trunk_item");
            sQLiteDatabase.execSQL("DROP TABLE trunk");
            sQLiteDatabase.execSQL(this.CREATE_TRUNK_TABLE_SQL);
            sQLiteDatabase.execSQL(this.CREATE_TRUNK_ITEM_TABLE_SQL);
            sQLiteDatabase.execSQL(this.CREATE_TRUNK_COMMENT_TABLE_SQL);
            i3 = i + 1;
        } else {
            i3 = i;
        }
        if (i3 == 2) {
            sQLiteDatabase.execSQL(this.CREATE_TRUNK_ITEM_TRIGGER_SQL);
            sQLiteDatabase.execSQL(this.CREATE_TRUNK_COMMENT_TRIGGER_SQL);
            int i4 = i3 + 1;
        }
    }
}
