package com.sec.chaton.p057e;

import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.common.util.C5052r;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bs */
/* loaded from: classes.dex */
public interface InterfaceC2273bs {

    /* renamed from: a */
    public static final String f8092a = C5052r.m19199a("(", "SELECT ", "_id", ",", "inbox_no", ",", "inbox_chat_type", ",", "inbox_last_message", ",", "inbox_title", ",", "inbox_title_fixed", ",", "inbox_last_time", ",", "inbox_lang_from", ",", "inbox_unread_count", ",", "inbox_lang_to", ",", "inbox_translated", ",", "inbox_server_ip", ",", "inbox_server_port", ",", "inbox_participants", ",", "inbox_session_id", ",", "inbox_last_msg_no", ",", "inbox_last_msg_sender", ",", "inbox_last_temp_msg", ",", "inbox_last_chat_type", ",", "inbox_is_new", ",", "inbox_trunk_unread_count", ",", "inbox_valid", ",", "buddy_no", ",", "inbox_enable_noti", ",", "inbox_is_change_skin", ",", "inbox_background_style", ",", "inbox_send_bubble_style", ",", "inbox_receive_bubble_style", ",", "inbox_last_tid", ",", "inbox_enable_translate", ",", "translate_outgoing_message", ",", "inbox_translate_my_language", ",", "inbox_translate_buddy_language", ",", "inbox_is_entered", ",", "inbox_last_timestamp", ",", "inbox_web_url", ",", "buddy_status_message", ",", "weburl", ",", "usertype", ",", "lasst_session_merge_time", ",", "inbox_room_type", ",", "buddy_name", ",", "inbox_topic_type", " FROM ", "(", "SELECT ", "*", " FROM ", "inbox", " a", " LEFT OUTER JOIN ", "(", "SELECT ", "buddy_no", ",", "buddy_name", ",", "buddy_status_message", ",", "''", " AS ", "weburl", ",", "''", " AS ", "usertype", " FROM ", "buddy", " UNION ALL ", "SELECT ", "buddy_no", " AS ", "buddy_no", ",", "buddy_name", " AS ", "buddy_name", ",", "msgstatus", " AS ", "buddy_status_message", ",", "weburl", ",", "usertype", " FROM ", "specialbuddy", " UNION ALL ", "SELECT ", "participants_buddy_no", " AS ", "buddy_no", ",", "ifnull(", "MAX", "(", "participants_buddy_name", ")", ",", "participants_buddy_no", ")", " AS ", "buddy_name", ",", "''", " AS ", "buddy_status_message", ",", "''", " AS ", "weburl", ",", "participants_user_type", " AS ", "usertype", " FROM ", "participant", " WHERE ", "participants_buddy_no", " NOT IN ", "(SELECT ", "buddy_no", " FROM ", "buddy", " UNION ALL ", "SELECT ", "buddy_no", " AS ", "buddy_no", " FROM ", "specialbuddy", ")", " GROUP BY ", "participants_buddy_no", ")", " b", " ON ", "b.", "buddy_no", " = ( SELECT ", "buddy_no", " FROM ", "inbox_buddy_relation", " WHERE ", "inbox_no", " = ", "a.", "inbox_no", " ) ", ")", ")");

    /* renamed from: b */
    public static final String f8093b = "SELECT a.*, r.buddy_no AS relation_buddy_no\tFROM (  SELECT j.buddy_no, ifnull(j.participants_user_type, " + EnumC1109f.NONE.m7095a() + ") AS participants_user_type, j.buddy_name, j.buddy_show_phone_number, j.buddy_extra_info, j.buddy_sainfo, j.buddy_msisdns, j.buddy_status_message, j.weburl, j.is_buddy, ifnull(j.buddy_contact_buddy, '2') AS buddy_contact_buddy, j.participants_sms_address, i.* FROM ( SELECT x.*, s.sms_unread_count, s.inboxsms_mapping_sms_no FROM inbox x LEFT OUTER JOIN ( SELECT inboxsms_mapping_inbox_no AS inbox_no, inboxsms_mapping_sms_no, SUM(inboxsms_mapping_unread_count) AS sms_unread_count FROM inboxsms_mapping GROUP BY inboxsms_mapping_inbox_no ) s ON x.inbox_no = s.inbox_no ) i LEFT OUTER JOIN ( SELECT p.participants_buddy_no AS buddy_no, ifnull(b.buddy_name, p.participants_buddy_name) AS buddy_name,p.participants_inbox_no, p.participants_user_type, b.buddy_show_phone_number, b.buddy_extra_info, b.buddy_sainfo, b.buddy_msisdns, b.buddy_status_message, b.weburl, b.is_buddy, b.buddy_contact_buddy, p.participants_sms_address FROM participant p LEFT OUTER JOIN ( SELECT buddy_no,buddy_name, buddy_show_phone_number, buddy_extra_info, buddy_sainfo, buddy_msisdns, buddy_status_message, '' AS weburl, 'Y' AS is_buddy, buddy_contact_buddy FROM buddy UNION ALL SELECT buddy_no AS buddy_no, buddy_original_name AS buddy_name, '' AS buddy_show_phone_number, '' AS buddy_extra_info, '' AS buddy_sainfo, '' AS buddy_msisdns, '' AS buddy_status_message, '' AS weburl, 'N' AS is_buddy, '0' AS buddy_contact_buddy FROM unknownbuddy UNION ALL SELECT buddy_no AS buddy_no,buddy_name AS buddy_name,'' AS buddy_show_phone_number, '' AS buddy_extra_info, '' AS buddy_sainfo, '' AS buddy_msisdns, msgstatus AS buddy_status_message,weburl, 'Y' AS is_buddy, '0' AS buddy_contact_buddy FROM specialbuddy ) b  ON p.participants_buddy_no = b.buddy_no WHERE p.participants_inbox_no NOT null ) j  ON i.inbox_no = j.participants_inbox_no WHERE i.inbox_last_chat_type != 12 GROUP BY i.inbox_no ) a  LEFT OUTER JOIN inbox_buddy_relation r  ON a.inbox_no = r.inbox_no ORDER BY inbox_last_time DESC, a._id";

    /* renamed from: c */
    public static final String f8094c = C5052r.m19199a("SELECT ", "a.*, ", "r.", "buddy_no", " AS ", "relation_buddy_no", "\tFROM ( ", " SELECT ", "j.", "buddy_no", ", ", "j.", "buddy_name", ", ", "ifnull(j.", "buddy_contact_buddy", ", '2') AS ", "buddy_contact_buddy", ", ", "j.", "participants_sms_address", ", ", "ifnull(j.", "participants_user_type", ", ", EnumC1109f.NONE.m7095a(), ") AS ", "participants_user_type", ", ", "i.*", " FROM ", "( SELECT x.*, s.", "sms_unread_count", " FROM ", "inbox", " x LEFT OUTER JOIN (", " SELECT ", "inboxsms_mapping_inbox_no", " AS ", "inbox_no", ", SUM(", "inboxsms_mapping_unread_count", ") AS ", "sms_unread_count", " FROM ", "inboxsms_mapping", " GROUP BY ", "inboxsms_mapping_inbox_no", " ) s ON x.", "inbox_no", " = s.", "inbox_no", " )", " i", " LEFT OUTER JOIN ", "( ", "SELECT ", "p.", "participants_buddy_no", " AS ", "buddy_no", ", ", "ifnull(", "b.", "buddy_name", ", ", "p.", "participants_buddy_name", ")", " AS ", "buddy_name", ",", "p.", "participants_inbox_no", ", ", "p.", "participants_user_type", ", ", "b.", "buddy_contact_buddy", ", ", "p.", "participants_sms_address", " FROM ", "participant", " p", " LEFT OUTER JOIN ", "buddy", " b ", " ON ", "p.", "participants_buddy_no", " = ", "b.", "buddy_no", " WHERE ", "p.", "participants_inbox_no", " NOT null", " ) j ", " ON ", "i.", "inbox_no", " = ", "j.", "participants_inbox_no", " WHERE ", "i.", "inbox_last_chat_type", " != ", 12, " AND ", "i.", "inbox_valid", " = '", "Y", "' ", " AND ", "i.", "inbox_no", " != ?", " AND ", "i.", "inbox_room_type", " != ", Integer.valueOf(EnumC2301u.LIVE.m10212a()), " GROUP BY ", "i.", "inbox_no", " ) a ", " LEFT OUTER JOIN ", "inbox_buddy_relation", " r ", " ON ", "a.", "inbox_no", " = ", "r.", "inbox_no", " ORDER BY ", "inbox_last_time", " DESC, a._id");

    /* renamed from: d */
    public static final String f8095d = "SELECT * FROM (" + f8094c + ") WHERE inbox_room_type = " + EnumC2301u.SMS.m10212a();

    /* renamed from: e */
    public static final String f8096e = f8095d + " AND inbox_title LIKE ?";

    /* renamed from: f */
    public static final String f8097f = "SELECT * FROM (" + f8094c + ") WHERE inbox_room_type = " + EnumC2301u.SMS.m10212a() + " AND inbox_chat_type !=" + EnumC2300t.BROADCAST2.m10210a();

    /* renamed from: g */
    public static final String f8098g = "SELECT * FROM (" + f8094c + ") WHERE inbox_room_type != " + EnumC2301u.SMS.m10212a();

    /* renamed from: h */
    public static final String f8099h = f8098g + " AND inbox_title LIKE ?";

    /* renamed from: i */
    public static final String f8100i = "SELECT * FROM (" + f8094c + ") WHERE inbox_room_type != " + EnumC2301u.SMS.m10212a() + " AND inbox_chat_type != " + EnumC2300t.TOPIC.m10210a();

    /* renamed from: j */
    public static final String f8101j = f8100i + " AND inbox_title LIKE ?";

    /* renamed from: k */
    public static final String f8102k = C5052r.m19199a("SELECT ", "a.*, ", "r.", "buddy_no", " AS ", "relation_buddy_no", "\tFROM ( ", " SELECT ", "j.", "buddy_no", ", ", "j.", "buddy_name", ", ", "i.*", " FROM ", "inbox", " i", " LEFT OUTER JOIN ", "( ", "SELECT ", "p.", "participants_buddy_no", " AS ", "buddy_no", ", ", "ifnull(", "b.", "buddy_name", ", ", "p.", "participants_buddy_name", ")", " AS ", "buddy_name", ",", "p.", "participants_inbox_no", " FROM ", "participant", " p", " LEFT OUTER JOIN ", "buddy", " b ", " ON ", "p.", "participants_buddy_no", " = ", "b.", "buddy_no", " WHERE ", "p.", "participants_inbox_no", " NOT null", " ) j ", " ON ", "i.", "inbox_no", " = ", "j.", "participants_inbox_no", " WHERE ", "i.", "inbox_last_chat_type", " != ", 12, " AND ", "i.", "inbox_valid", " = '", "Y", "' ", " AND ", "i.", "inbox_web_url", " IS null", " AND ", "i.", "inbox_chat_type", " != ", Integer.valueOf(EnumC2300t.BROADCAST.m10210a()), " GROUP BY ", "i.", "inbox_no", " ) a ", " LEFT OUTER JOIN ", "inbox_buddy_relation", " r ", " ON ", "a.", "inbox_no", " = ", "r.", "inbox_no", " ORDER BY ", "inbox_last_time", " DESC, a._id DESC");

    /* renamed from: l */
    public static final String f8103l = C5052r.m19199a("(", "SELECT ", "c.", "participants_buddy_name", " AS ", "inbox_title", ",", "a.", "inbox_no", " FROM ", "inbox", " a,", "(", "SELECT ", "participants_inbox_no", ",", "group_concat(", "participants_buddy_name", ", \", \") AS ", "participants_buddy_name", " FROM ", "(", "SELECT ", "ifnull(", "b.", "buddy_name", ",", "MAX(", "p.", "participants_buddy_name", ")) AS ", "participants_buddy_name", ",", "p.", "participants_buddy_no", ",", "p.", "participants_inbox_no", ",", "p.", "rowid", " FROM ", "participant", " p", " LEFT OUTER JOIN ", "( ", "SELECT ", "buddy_no", ", ", "buddy_name", " FROM ", "buddy", " UNION ALL ", "SELECT ", "buddy_no", " AS ", "buddy_no", ", ", "buddy_name", " AS ", "buddy_name", " FROM ", "specialbuddy", " )", " b", " ON ", "p.", "participants_buddy_no", "=", "b.", "buddy_no", " GROUP BY ", "p.", "participants_buddy_no", ",", "p.", "participants_inbox_no", " ORDER BY ", "p.", "rowid", " DESC", ") ", " GROUP BY ", "participants_inbox_no", ") c", " WHERE ", "a.", "inbox_no", "=", "c.", "participants_inbox_no", " AND (", "a.", "inbox_chat_type", "=", Integer.valueOf(EnumC2300t.GROUPCHAT.m10210a()), " OR ", "a.", "inbox_chat_type", "=", Integer.valueOf(EnumC2300t.ONETOONE.m10210a()), ") AND ", "a.", "inbox_title_fixed", "=", "'", "N", "'", ")");

    /* renamed from: m */
    public static final String f8104m = "SELECT p.participants_buddy_no AS buddy_no, p.participants_inbox_no AS inbox_no, b.inbox_last_message FROM participant p LEFT OUTER JOIN inbox b WHERE p.participants_inbox_no = b.inbox_no AND b.inbox_chat_type = " + EnumC2300t.ONETOONE.m10210a();

    /* renamed from: n */
    public static final String f8105n = "UPDATE participant SET participants_user_type=" + Integer.valueOf(EnumC1109f.CONTENTS.m7095a()) + " WHERE participants_inbox_no IN (SELECT inbox_no FROM inbox WHERE inbox_room_type=" + EnumC2301u.LIVE.m10212a() + ")";

    /* renamed from: o */
    public static final String f8106o = "(" + f8093b + ")";
}
