package com.sec.chaton.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.ContactsContract;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.DatabaseHelper;
import com.sec.chaton.database.SQLBuilder;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChatONProvider extends ContentProvider {

    /* renamed from: a */
    private static final UriMatcher f2586a = m2844a();

    /* renamed from: a */
    private long m2843a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        try {
            return sQLiteDatabase.insertOrThrow("buddy", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (contentValues.containsKey("buddy_no")) {
                return sQLiteDatabase.update("buddy", contentValues, "buddy_no=?", new String[]{contentValues.getAsString("buddy_no")});
            }
            return 0L;
        }
    }

    /* renamed from: a */
    private static UriMatcher m2844a() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddy_no/*", 102);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/participants_no_same", 108);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/participants", 107);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/profile", 106);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/group", 103);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical", 104);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical2", 109);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/relation", 105);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy", 100);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/group_info", 203);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/*", 201);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group", 200);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts/conatct_number/*", 302);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts/*", 301);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts", 300);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group_relation_group/*", 711);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group_relation_buddy/*", 712);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/buddy_in", 701);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/buddy_not_in", 702);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation", 700);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/group_title_update", 404);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join", 403);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_no", 402);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/*", 401);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox", AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE);
        uriMatcher.addURI("com.sec.chaton.provider", "message/read_ack/*", 504);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_sever_id/*", 502);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy", 505);
        uriMatcher.addURI("com.sec.chaton.provider", "message/*", 501);
        uriMatcher.addURI("com.sec.chaton.provider", "message", 500);
        uriMatcher.addURI("com.sec.chaton.provider", "relation/insert", 604);
        uriMatcher.addURI("com.sec.chaton.provider", "relation/day", 603);
        uriMatcher.addURI("com.sec.chaton.provider", "relation", 600);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/*", 801);
        uriMatcher.addURI("com.sec.chaton.provider", "participant", 800);
        uriMatcher.addURI("com.sec.chaton.provider", "memo", TrunkMessageControl.METHOD_GET_TRUNK_LIST);
        uriMatcher.addURI("com.sec.chaton.provider", "memo_sessions", TrunkMessageControl.METHOD_GET_TRUNK_ITEM);
        return uriMatcher;
    }

    /* renamed from: a */
    private SQLBuilder m2845a(Uri uri, int i) {
        SQLBuilder sQLBuilder = new SQLBuilder();
        switch (i) {
            case 100:
                return sQLBuilder.m2214a("buddy");
            case 102:
                return sQLBuilder.m2214a("buddy").m2215a("buddy_no=?", ChatONContract.BuddyTable.m2170a(uri));
            case 103:
                return sQLBuilder.m2214a(DatabaseHelper.Buddy_Query.f1745a);
            case 104:
                return sQLBuilder.m2214a("(SELECT a.*,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank FROM (SELECT 1 AS group_relation_group,'Favorites' AS group_name,1 AS group_type,b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated FROM ( SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1 ) a JOIN buddy b ON a.group_relation_buddy = b.buddy_no UNION ALL SELECT null AS group_relation_group,null AS group_name,2 AS group_type,buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_is_status_updated FROM buddy) a LEFT OUTER JOIN (SELECT * FROM relation WHERE relation_date = date('now','localtime','0 day')) b ON a.buddy_no = b.relation_buddy_id)");
            case 105:
                return sQLBuilder.m2214a("(SELECT b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_birthday,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_msg_send,b.buddy_msg_received,b.buddy_relation_hide,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated,CASE WHEN c.relation_send IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_send END AS relation_send,CASE WHEN c.relation_received IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_received END AS relation_received,CASE WHEN c.relation_point IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_point END AS relation_point,CASE WHEN c.relation_icon IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_icon END AS relation_icon,CASE WHEN c.relation_increase IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_increase END AS relation_increase,CASE WHEN c.relation_rank IS NULL THEN 9999999 WHEN b.buddy_relation_hide = 'Y' THEN 9999999 ELSE c.relation_rank END AS relation_rank,1 AS group_type FROM (SELECT * FROM grouprelation WHERE group_relation_group = 1) a JOIN buddy b ON a.group_relation_buddy = b.buddy_no LEFT OUTER JOIN relation c ON a.group_relation_buddy = c.relation_buddy_id WHERE c.relation_date = DATE('NOW', 'localtime', '0 DAY') OR c.relation_date is null) d UNION ALL SELECT * FROM (SELECT a.buddy_no,a.buddy_name,a.buddy_status_message,a.buddy_birthday,a.buddy_email,a.buddy_samsung_email,a.buddy_orginal_number,a.buddy_msg_send,a.buddy_msg_received,a.buddy_relation_hide,a.buddy_raw_contact_id,a.buddy_push_name,a.buddy_is_new,a.buddy_profile_status,a.buddy_is_profile_updated,a.buddy_is_status_updated,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank,2 AS group_type FROM buddy a LEFT OUTER JOIN relation b ON a.buddy_no = b.relation_buddy_id WHERE b.relation_date = DATE('NOW', 'localtime', '0 DAY') OR b.relation_date is null)");
            case 106:
                return sQLBuilder.m2214a("(SELECT a.*,CASE WHEN b.group_relation_buddy IS NULL THEN 'N' ELSE 'Y' END AS is_favorite FROM (SELECT b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_birthday,b.buddy_relation_hide,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated,b.buddy_show_phone_number,CASE WHEN c.relation_send IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_send END AS relation_send,CASE WHEN c.relation_received IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_received END AS relation_received,CASE WHEN c.relation_point IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_point END AS relation_point,CASE WHEN c.relation_icon IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_icon END AS relation_icon,CASE WHEN c.relation_increase IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_increase END AS relation_increase,CASE WHEN c.relation_rank IS NULL THEN 0 WHEN b.buddy_relation_hide = 'Y' THEN 0 ELSE c.relation_rank END AS relation_rank FROM buddy b LEFT OUTER JOIN ( SELECT * FROM relation WHERE relation_date = DATE('now', 'localtime', '0 day') ) c ON b.buddy_no = c.relation_buddy_id) a LEFT OUTER JOIN (SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1) b ON a.buddy_no = b.group_relation_buddy)");
            case 107:
                return sQLBuilder.m2214a(DatabaseHelper.Buddy_Query.f1746b);
            case 108:
                return sQLBuilder.m2214a("(SELECT buddy_no,buddy_name,buddy_status_message,buddy_profile_status FROM buddy UNION ALL SELECT participants_buddy_no AS buddy_no,MAX(participants_buddy_name) AS buddy_name,'' AS buddy_status_message,'' AS buddy_profile_status FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy) GROUP BY participants_buddy_no)");
            case 109:
                return sQLBuilder.m2214a("(SELECT a.*,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank FROM (SELECT b.buddyno_list AS group_relation_group,group_name,group_type,_id AS buddy_no,group_name AS buddy_name,null AS buddy_status_message,b.buddyno_list AS buddy_email,b.buddyname_list AS buddy_samsung_email,null AS buddy_orginal_number,null AS buddy_relation_hide,null AS buddy_birthday,null AS buddy_raw_contact_id,null AS buddy_push_name,null AS buddy_is_new,null AS buddy_profile_status,null AS buddy_is_profile_updated,null AS buddy_is_status_updated FROM buddy_group a LEFT OUTER JOIN(SELECT group_relation_group,group_concat(group_relation_buddy, '%%' || group_relation_group || '%%') AS buddyno_list,group_concat(buddy_name, '%%' || group_relation_group || '%%') AS buddyname_list FROM (SELECT a.group_relation_group,a.group_relation_buddy,TRIM(b.buddy_name) AS buddy_name FROM grouprelation a,buddy b WHERE a.group_relation_buddy = b.buddy_no AND group_relation_group != 1) GROUP BY group_relation_group) b ON a._id = b.group_relation_group WHERE a.group_type != 1 UNION ALL SELECT 1 AS group_relation_group,'Favorites' AS group_name,1 AS group_type,b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated FROM ( SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1 ) a JOIN buddy b ON a.group_relation_buddy = b.buddy_no UNION ALL SELECT null AS group_relation_group,null AS group_name,2 AS group_type,buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_is_status_updated FROM buddy) a LEFT OUTER JOIN (SELECT * FROM relation WHERE relation_date = date('now','localtime','0 day')) b ON a.buddy_no = b.relation_buddy_id)");
            case 200:
                return sQLBuilder.m2214a("buddy_group");
            case 201:
                return sQLBuilder.m2214a("buddy_group").m2215a("_id=?", ChatONContract.GroupTable.m2183a(uri));
            case 203:
                return sQLBuilder.m2214a("(SELECT a._id,a.group_name,a.group_type,ifnull(b.cnt,0) AS cnt FROM buddy_group a LEFT OUTER JOIN (SELECT group_relation_group,COUNT(*) AS cnt FROM grouprelation GROUP BY group_relation_group HAVING group_relation_group > 1) b ON a._id=b.group_relation_group WHERE a._id != 1)f");
            case 300:
                return sQLBuilder.m2214a("contacts");
            case 301:
                return sQLBuilder.m2214a("contacts").m2215a("_id=?", ChatONContract.ContactsTable.m2177a(uri));
            case 302:
                return sQLBuilder.m2214a("contacts").m2215a("conatct_number=?", ChatONContract.ContactsTable.m2178b(uri));
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                return sQLBuilder.m2214a("inbox");
            case 401:
                return sQLBuilder.m2214a("inbox").m2215a("_id=?", ChatONContract.InBoxTable.m2185a(uri));
            case 402:
                return sQLBuilder.m2214a("inbox").m2215a("inbox_no=?", ChatONContract.InBoxTable.m2187b(uri));
            case 403:
                return sQLBuilder.m2214a("(SELECT _id,inbox_no,inbox_chat_type,inbox_last_message,inbox_title,inbox_title_fixed,inbox_last_time,inbox_lang_from,inbox_unread_count,inbox_lang_to,inbox_translated,inbox_server_ip,inbox_server_port,inbox_participants,inbox_session_id,inbox_last_msg_no,inbox_last_msg_sender,inbox_last_temp_msg,inbox_is_new,inbox_trunk_unread_count,buddy_status_message,buddy_name FROM (SELECT * FROM inbox a LEFT OUTER JOIN (SELECT buddy_no,buddy_name,buddy_status_message FROM buddy UNION ALL SELECT participants_buddy_no AS buddy_no,ifnull(MAX(participants_buddy_name),participants_buddy_no) AS buddy_name,'' AS buddy_status_message FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy) GROUP BY participants_buddy_no) b ON a.inbox_no = b.buddy_no LEFT OUTER JOIN (SELECT COUNT (*) AS cnt,participants_inbox_no FROM participant GROUP BY participants_inbox_no) c ON a.inbox_no = c.participants_inbox_no))");
            case 404:
                return sQLBuilder.m2214a(DatabaseHelper.Inbox_Query.f1747a);
            case 500:
                return sQLBuilder.m2214a("message");
            case 501:
                String strM2192a = ChatONContract.MessageTable.m2192a(uri);
                return sQLBuilder.m2214a("message").m2215a(strM2192a + "=?", strM2192a);
            case 502:
                String strM2193b = ChatONContract.MessageTable.m2193b(uri);
                return sQLBuilder.m2214a("message").m2215a(strM2193b + "=?", strM2193b);
            case 505:
                return sQLBuilder.m2214a(DatabaseHelper.Tables_Join.f1750a);
            case 600:
                return sQLBuilder.m2214a("relation");
            case 603:
                return sQLBuilder.m2214a("(SELECT b.relation_date,a.buddy_no,a.buddy_name,a.buddy_status_message,a.buddy_email,a.buddy_samsung_email,a.buddy_orginal_number,a.buddy_msg_send,a.buddy_msg_received,a.buddy_relation_hide,IFNULL(b.relation_send,0) AS relation_send,IFNULL(b.relation_received,0) AS relation_received,IFNULL(b.relation_point,0) AS relation_point,IFNULL(b.relation_icon,6) AS relation_icon,IFNULL(b.relation_increase,0) AS relation_increase,IFNULL(b.relation_rank,9999999) AS relation_rank,IFNULL(a.buddy_profile_status,0) AS buddy_profile_status,IFNULL(b.relation_last_msg_time,DATETIME('NOW', 'localtime')) AS relation_last_msg_time,2 AS group_type FROM buddy a JOIN relation b ON a.buddy_no = b.relation_buddy_id)");
            case 700:
                return sQLBuilder.m2214a("grouprelation");
            case 701:
                return sQLBuilder.m2214a("(SELECT b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_msg_send,b.buddy_msg_received,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated,a.group_relation_group FROM grouprelation a JOIN buddy b ON a.group_relation_buddy = b.buddy_no)");
            case 702:
                return sQLBuilder.m2214a("(SELECT * FROM (SELECT * FROM (SELECT buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_is_status_updated,ifnull(b.group_relation_group,9999) AS group_relation_group,ifnull(c.group_type,3) AS group_type FROM buddy a LEFT OUTER JOIN grouprelation b ON a.buddy_no=b.group_relation_buddy LEFT OUTER JOIN buddy_group c ON b.group_relation_group=c._id) GROUP BY buddy_no))");
            case 711:
                return sQLBuilder.m2214a("grouprelation").m2215a("group_relation_group=?", ChatONContract.GroupRelationTable.m2182b(uri));
            case 712:
                return sQLBuilder.m2214a("grouprelation").m2215a("group_relation_buddy=?", ChatONContract.GroupRelationTable.m2181a(uri));
            case 800:
                return sQLBuilder.m2214a("participant");
            case 801:
                return sQLBuilder.m2214a("(SELECT ifnull(b.buddy_no,c.participants_buddy_no) AS buddy_no,ifnull(b.buddy_status_message,'') AS buddy_status_message,ifnull(b.buddy_name,c.participants_buddy_name) AS buddy_name,c.participants_inbox_no AS participants_inbox_no,c.participants_buddy_no AS participants_buddy_no FROM (SELECT ifnull(participants_buddy_name,participants_buddy_no) AS participants_buddy_name,participants_buddy_no,participants_inbox_no FROM participant) c LEFT OUTER JOIN buddy b ON c.participants_buddy_no = b.buddy_no)").m2215a("participants_inbox_no=?", ChatONContract.ParticipantTable.m2200a(uri));
            case TrunkMessageControl.METHOD_GET_TRUNK_LIST /* 900 */:
                return sQLBuilder.m2214a("memo");
            case TrunkMessageControl.METHOD_GET_TRUNK_ITEM /* 901 */:
                return sQLBuilder.m2214a("memo_sessions");
            default:
                return null;
        }
    }

    /* renamed from: b */
    private long m2846b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        ChatONLogWriter.m3511e("memoSessionInsertOrUpdatert", "ChatONProvider");
        String[] strArr = {contentValues.getAsString("buddy_no")};
        try {
            return sQLiteDatabase.insertOrThrow("memo_sessions", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (contentValues.containsKey("buddy_no")) {
                return sQLiteDatabase.update("memo_sessions", contentValues, "buddy_no=?", strArr);
            }
            return 0L;
        }
    }

    /* renamed from: b */
    private SQLBuilder m2847b(Uri uri, int i) {
        SQLBuilder sQLBuilder = new SQLBuilder();
        switch (i) {
            case 100:
                return sQLBuilder.m2214a("buddy");
            case 102:
                return sQLBuilder.m2214a("buddy").m2215a("buddy_no=?", ChatONContract.BuddyTable.m2170a(uri));
            case 200:
                return sQLBuilder.m2214a("buddy_group");
            case 201:
                return sQLBuilder.m2214a("buddy_group").m2215a("_id=?", ChatONContract.GroupTable.m2183a(uri));
            case 300:
                return sQLBuilder.m2214a("contacts");
            case 301:
                return sQLBuilder.m2214a("contacts").m2215a("_id=?", ChatONContract.ContactsTable.m2177a(uri));
            case 302:
                return sQLBuilder.m2214a("contacts").m2215a("conatct_number=?", ChatONContract.ContactsTable.m2178b(uri));
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                return sQLBuilder.m2214a("inbox");
            case 401:
                return sQLBuilder.m2214a("inbox").m2215a("_id=?", ChatONContract.InBoxTable.m2185a(uri));
            case 402:
                return sQLBuilder.m2214a("inbox").m2215a("inbox_no=?", ChatONContract.InBoxTable.m2187b(uri));
            case 500:
                return sQLBuilder.m2214a("message");
            case 501:
                String strM2192a = ChatONContract.MessageTable.m2192a(uri);
                return sQLBuilder.m2214a("message").m2215a(strM2192a + "=?", strM2192a);
            case 502:
                String strM2193b = ChatONContract.MessageTable.m2193b(uri);
                return sQLBuilder.m2214a("message").m2215a(strM2193b + "=?", strM2193b);
            case 600:
                return sQLBuilder.m2214a("relation");
            case 700:
                return sQLBuilder.m2214a("grouprelation");
            case 711:
                return sQLBuilder.m2214a("grouprelation").m2215a("group_relation_group=?", ChatONContract.GroupRelationTable.m2182b(uri));
            case 712:
                return sQLBuilder.m2214a("grouprelation").m2215a("group_relation_buddy=?", ChatONContract.GroupRelationTable.m2181a(uri));
            case 800:
                return sQLBuilder.m2214a("participant");
            case 801:
                String strM2200a = ChatONContract.ParticipantTable.m2200a(uri);
                return sQLBuilder.m2214a("participant").m2215a(strM2200a + "=?", strM2200a);
            case TrunkMessageControl.METHOD_GET_TRUNK_LIST /* 900 */:
                return sQLBuilder.m2214a("memo");
            case TrunkMessageControl.METHOD_GET_TRUNK_ITEM /* 901 */:
                return sQLBuilder.m2214a("memo_sessions");
            default:
                return sQLBuilder;
        }
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList arrayList) {
        SQLiteDatabase writableDatabase = DatabaseHelper.m2204a(getContext()).getWritableDatabase();
        HashSet hashSet = new HashSet();
        writableDatabase.beginTransaction();
        int size = arrayList.size();
        try {
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            for (int i = 0; i < size; i++) {
                contentProviderResultArr[i] = ((ContentProviderOperation) arrayList.get(i)).apply(this, contentProviderResultArr, i);
                hashSet.add(((ContentProviderOperation) arrayList.get(i)).getUri());
            }
            writableDatabase.setTransactionSuccessful();
            return contentProviderResultArr;
        } finally {
            writableDatabase.endTransaction();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                getContext().getContentResolver().notifyChange((Uri) it.next(), null);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int iM2210a = m2847b(uri, f2586a.match(uri)).m2215a(str, strArr).m2210a(DatabaseHelper.m2204a(getContext()).getWritableDatabase());
        if (iM2210a > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return iM2210a;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f2586a.match(uri)) {
            case 100:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 102:
                return "vnd.chaton.cursor.item/vnd.chaton.buddy";
            case 103:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 104:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 105:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 106:
                return "vnd.chaton.cursor.item/vnd.chaton.buddy";
            case 107:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 108:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 109:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 200:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case 201:
                return "vnd.chaton.cursor.item/vnd.chaton.group";
            case 203:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case 300:
                return "vnd.chaton.cursor.dir/vnd.chaton.contacts";
            case 301:
                return "vnd.chaton.cursor.item/vnd.chaton.contacts";
            case 302:
                return "vnd.chaton.cursor.dir/vnd.chaton.contacts";
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 401:
                return "vnd.chaton.cursor.item/vnd.chaton.inbox";
            case 402:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 404:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 500:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 501:
                return "vnd.chaton.cursor.item/vnd.chaton.message";
            case 502:
                return "vnd.chaton.cursor.item/vnd.chaton.message";
            case 505:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 600:
                return "vnd.chaton.cursor.dir/vnd.chaton.relation";
            case 603:
                return "vnd.chaton.cursor.dir/vnd.chaton.relation";
            case 700:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 701:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 702:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case 711:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 712:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case TrunkMessageControl.METHOD_GET_TRUNK_LIST /* 900 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.memo";
            default:
                throw new UnsupportedOperationException("UnKonwn Uri : " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) throws SQLException {
        Uri uriM2202a;
        SQLiteDatabase writableDatabase = DatabaseHelper.m2204a(getContext()).getWritableDatabase();
        int iMatch = f2586a.match(uri);
        Uri uri2 = ContactsContract.AUTHORITY_URI;
        switch (iMatch) {
            case 100:
                m2843a(writableDatabase, contentValues);
                uriM2202a = ChatONContract.BuddyTable.f1713a;
                break;
            case 200:
                writableDatabase.insertOrThrow("buddy_group", null, contentValues);
                uriM2202a = ChatONContract.GroupTable.f1716a;
                break;
            case 300:
                uriM2202a = ChatONContract.ContactsTable.m2176a(String.valueOf(writableDatabase.insertOrThrow("contacts", null, contentValues)));
                break;
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                writableDatabase.insertOrThrow("inbox", null, contentValues);
                uriM2202a = ChatONContract.InBoxTable.f1717a;
                break;
            case 500:
                try {
                    if (writableDatabase.insertOrThrow("message", null, contentValues) <= 0) {
                        uriM2202a = uri2;
                        break;
                    } else {
                        contentValues.getAsLong("_id").longValue();
                        uriM2202a = ChatONContract.MessageTable.f1726a;
                        break;
                    }
                } catch (SQLiteConstraintException e) {
                    ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                    uriM2202a = uri2;
                    break;
                }
            case 600:
                uriM2202a = ChatONContract.RelationTable.m2202a(String.valueOf(writableDatabase.insertOrThrow("relation", null, contentValues)));
                break;
            case 604:
                ChatONLogWriter.m3506b("QUERY : " + DatabaseHelper.RELATION_INSERT.f1748a, null);
                writableDatabase.execSQL(DatabaseHelper.RELATION_INSERT.f1748a);
                uriM2202a = uri2;
                break;
            case 700:
                uriM2202a = ChatONContract.GroupRelationTable.m2180a(String.valueOf(writableDatabase.insertOrThrow("grouprelation", null, contentValues)));
                break;
            case 800:
                writableDatabase.insertOrThrow("participant", null, contentValues);
                uriM2202a = ChatONContract.ParticipantTable.f1741a;
                break;
            case TrunkMessageControl.METHOD_GET_TRUNK_LIST /* 900 */:
                writableDatabase.insertOrThrow("memo", null, contentValues);
                uriM2202a = ChatONContract.MemoTable.f1725a;
                break;
            case TrunkMessageControl.METHOD_GET_TRUNK_ITEM /* 901 */:
                m2846b(writableDatabase, contentValues);
                uriM2202a = ChatONContract.MemoSessionsTable.f1724a;
                break;
            default:
                ChatONLogWriter.m3510d("Unknown Uri : " + uri.toString(), "ChatONProvider");
                uriM2202a = uri2;
                break;
        }
        if (uriM2202a != null) {
            getContext().getContentResolver().notifyChange(uriM2202a, null);
        }
        return uriM2202a;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        DatabaseHelper.m2204a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase = DatabaseHelper.m2204a(getContext()).getReadableDatabase();
        SQLBuilder sQLBuilderM2845a = m2845a(uri, f2586a.match(uri));
        if (sQLBuilderM2845a != null) {
            return sQLBuilderM2845a.m2215a(str, strArr2).m2212a(readableDatabase, strArr, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws SQLException {
        int iM2211a;
        SQLiteDatabase writableDatabase = DatabaseHelper.m2204a(getContext()).getWritableDatabase();
        int iMatch = f2586a.match(uri);
        switch (iMatch) {
            case 504:
                writableDatabase.execSQL("UPDATE message SET message_read_status= CASE WHEN message_read_status IS 0 THEN 0  ELSE (message_read_status-1) END WHERE message_sever_id=?", new String[]{ChatONContract.MessageTable.m2194c(uri)});
                iM2211a = 1;
                break;
            default:
                iM2211a = m2847b(uri, iMatch).m2215a(str, strArr).m2211a(writableDatabase, contentValues);
                break;
        }
        if (iM2211a > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return iM2211a;
    }
}
