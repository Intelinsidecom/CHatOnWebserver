package com.sec.chaton.trunk.database;

import android.net.Uri;
import android.provider.BaseColumns;

/* loaded from: classes.dex */
public class DatabaseConstant {
    public static final Uri BASE_URI = Uri.parse("content://com.develop.sec.chaton.provider");
    public static final String CONTENT_AUTHORITY = "com.develop.sec.chaton.provider";
    public static final String TRUNK_COMMENT_TABLE_NAME = "trunk_comment";
    public static final String TRUNK_DATABASE_NAME = "trunk.db";
    public static final int TRUNK_DATABASE_VERSION = 3;
    public static final String TRUNK_ITEM_TABLE_NAME = "trunk_item";
    public static final String TRUNK_TABLE_NAME = "trunk";

    public interface TrunkColumns {
        public static final String KEY_LAST_COMMENT_TIME = "last_comment_time";
        public static final String KEY_LAST_UPDATE_TIME = "last_update_time";
        public static final String KEY_SESSION_ID = "session_id";
        public static final String KEY_TOTAL_ITEM_COUNT = "total_item_count";
        public static final String KEY_UNREAD_COMMENT_COUNT = "unread_comment_count";
        public static final String KEY_UNREAD_ITEM_COUNT = "unread_item_count";
    }

    public interface TrunkCommentColumns {
        public static final String KEY_COMMENT_ID = "comment_id";
        public static final String KEY_CONTENT = "content";
        public static final String KEY_ITEM_ID = "item_id";
        public static final String KEY_REGISTRATION_TIME = "registration_time";
        public static final String KEY_WRITER_ID = "writer_uid";
        public static final String KEY_WRITER_NAME = "writer_name";
        public static final String KEY_WRITER_NUMBER = "writer_number";
    }

    public class TrunkCommentTable implements BaseColumns, TrunkCommentColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.chaton.cursor.item/vnd.chaton.trunk.comment";
        public static final String CONTENT_TYPE = "vnd.chaton.cursor.dir/vnd.chaton.trunk.comment";
        public static final Uri CONTENT_URI = DatabaseConstant.BASE_URI.buildUpon().appendPath("trunk_comment").build();
        public static final String PATH_ITEM = "item";
        public static final String TABLE_NAME_TRUNK_COMMENT = "trunk_comment";
    }

    public class TrunkCommentTrigger {
        public static final String TRIGGER_NAME_TRUNK_COMMENT = "trigger_trunk_comment";
    }

    public interface TrunkItemColumns {
        public static final String KEY_CONTENT_TYPE = "content_type";
        public static final String KEY_DOWN_URL = "down_url";
        public static final String KEY_ITEM_ID = "item_id";
        public static final String KEY_ITEM_TYPE = "item_type";
        public static final String KEY_LAST_COMMENT_TIME = "last_comment_time";
        public static final String KEY_REGISTRATION_TIME = "registration_time";
        public static final String KEY_SENDER_NAME = "sender_name";
        public static final String KEY_SENDER_NUMBER = "sender_number";
        public static final String KEY_SENDER_UID = "sender_uid";
        public static final String KEY_SESSION_ID = "session_id";
        public static final String KEY_THUMBNAIL = "thumbnail";
        public static final String KEY_TOTAL_COMMENT_COUNT = "total_comment_count";
        public static final String KEY_UNREAD_COMMENT_COUNT = "unread_comment_count";
    }

    public class TrunkItemTable implements BaseColumns, TrunkItemColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.chaton.cursor.item/vnd.chaton.trunk.item";
        public static final String CONTENT_TYPE = "vnd.chaton.cursor.dir/vnd.chaton.trunk.item";
        public static final Uri CONTENT_URI = DatabaseConstant.BASE_URI.buildUpon().appendPath("trunk_item").build();
        public static final String PATH_LIMIT = "limit";
        public static final String TABLE_NAME_TRUNK_ITEM = "trunk_item";

        public enum ItemType {
            Item(1),
            LoadMore(2);

            private int value;

            ItemType(int i) {
                this.value = i;
            }

            public static ItemType Convert(int i) {
                switch (i) {
                    case 1:
                        return Item;
                    case 2:
                        return LoadMore;
                    default:
                        return null;
                }
            }

            public int getValue() {
                return this.value;
            }
        }
    }

    public class TrunkItemTrigger {
        public static final String TRIGGER_NAME_TRUNK_ITEM = "trigger_trunk_item";
    }

    public class TrunkTable implements BaseColumns, TrunkColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.chaton.cursor.item/vnd.chaton.trunk";
        public static final String CONTENT_TYPE = "vnd.chaton.cursor.dir/vnd.chaton.trunk";
        public static final Uri CONTENT_URI = DatabaseConstant.BASE_URI.buildUpon().appendPath("trunk").build();
        public static final String TABLE_NAME_TRUNK = "trunk";
    }
}
