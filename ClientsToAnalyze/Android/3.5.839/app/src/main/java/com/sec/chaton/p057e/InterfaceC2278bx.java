package com.sec.chaton.p057e;

import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.common.util.C5052r;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bx */
/* loaded from: classes.dex */
public interface InterfaceC2278bx {

    /* renamed from: a */
    public static final String f8141a = C5052r.m19199a("CREATE TABLE ", "buddy", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "buddy_status_message", " VARCHAR(255),", "buddy_email", " VARCHAR(80),", "buddy_samsung_email", " VARCHAR(80),", "buddy_orginal_number", " VARCHAR(25),", "buddy_birthday", " VARCHAR(10) NOT NULL DEFAULT '',", "buddy_msg_send", " INTEGER DEFAULT 0,", "buddy_msg_received", " INTEGER DEFAULT 0,", "buddy_relation_hide", " CHAR(1) NOT NULL DEFAULT 'N',", "buddy_raw_contact_id", " NUMBER DEFAULT 0, ", "buddy_push_name", " VARCHAR(25),", "buddy_is_new", " CHAR(1) NOT NULL DEFAULT 'Y',", "buddy_profile_status", " INTEGER NOT NULL DEFAULT ", Integer.valueOf(Buddy.BuddyImageStatus.NONE_PROFILE.getCode()), ",", "UNIQUE (", "buddy_no", "))");

    /* renamed from: b */
    public static final String f8142b = C5052r.m19199a("CREATE TABLE ", "buddy_group", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "group_name", " VARCHAR(80) NOT NULL,", "group_type", " INTEGER NOT NULL DEFAULT 2,", "UNIQUE (", "_id", ") ON CONFLICT REPLACE);");

    /* renamed from: c */
    public static final String f8143c = C5052r.m19199a("CREATE TABLE ", "grouprelation", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "group_relation_buddy", " VARCHAR(25) NOT NULL REFERENCES ", "buddy", "(", "buddy_no", "),", "group_relation_group", " VARCHAR(25) NOT NULL REFERENCES ", "buddy_group", "(", "_id", "),", "UNIQUE (", "group_relation_group", ",", "group_relation_buddy", ") ON CONFLICT REPLACE);");

    /* renamed from: d */
    public static final String f8144d = C5052r.m19199a("CREATE TABLE ", "relation", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "relation_buddy_id", " TEXT NOT NULL,", "relation_date", " TEXT NOT NULL,", "relation_send", " INTEGER NOT NULL DEFAULT 0,", "relation_received", " INTEGER NOT NULL DEFAULT 0,", "relation_point", " INTEGER NOT NULL DEFAULT 0,", "relation_icon", " INTEGER NOT NULL DEFAULT 0,", "relation_increase", " INTEGER NOT NULL DEFAULT 0,", "relation_rank", " INTEGER NOT NULL DEFAULT 0,", "UNIQUE (", "relation_buddy_id", ",", "relation_date", ") ON CONFLICT REPLACE);");

    /* renamed from: e */
    public static final String f8145e = C5052r.m19199a("CREATE TABLE ", "contacts", " (", "contacts_id", " NUMBER,", "contact_raw_id", " NUMBER,", "conatct_number", " TEXT NOT NULL,", "contacts_name", " TEXT,", "UNIQUE (", "contacts_id", ",", "contact_raw_id", ") ON CONFLICT REPLACE);");

    /* renamed from: f */
    public static final String f8146f = C5052r.m19199a("CREATE TABLE ", "inbox", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "inbox_no", " TEXT,", "inbox_chat_type", " INTEGER NOT NULL,", "inbox_unread_count", " INTEGER NOT NULL DEFAULT 0,", "inbox_last_message", " TEXT,", "inbox_title", " TEXT,", "inbox_last_time", " NUMBER,", "inbox_lang_from", " TEXT,", "inbox_lang_to", " TEXT,", "inbox_translated", " TEXT NOT NULL DEFAULT 'N',", "inbox_server_ip", " TEXT,", "inbox_server_port", " NUMBER,", "inbox_participants", " TEXT,", "inbox_session_id", " TEXT,", "inbox_last_msg_no", " NUMBER,", "inbox_last_msg_sender", " TEXT,", "inbox_title_fixed", " TEXT NOT NULL DEFAULT 'N',", "inbox_last_chat_type", " NUMBER,", "inbox_last_temp_msg", " TEXT NOT NULL DEFAULT '',", "UNIQUE (", "inbox_no", ") ON CONFLICT REPLACE);");

    /* renamed from: g */
    public static final String f8147g = C5052r.m19199a("CREATE TABLE ", "inbox_buddy_relation", " (", "inbox_no", " TEXT,", "buddy_no", " TEXT,", "UNIQUE (", "inbox_no", ",", "buddy_no", ") ON CONFLICT REPLACE);");

    /* renamed from: h */
    public static final String f8148h = C5052r.m19199a("CREATE TABLE ", VKApiConst.MESSAGE, " (", "_id", " INTEGER PRIMARY KEY,", "message_sever_id", " INTEGER,", "message_inbox_no", " TEXT,", "message_session_id", " INTEGER,", "message_read_status", " INTEGER,", "message_content_type", " INTEGER DEFAULT 0,", "message_time", " NUMBER,", "message_content", " TEXT,", "message_translated", " TEXT,", "message_type", " INTEGER,", "message_sender", " TEXT,", "message_download_uri", " TEXT,", "message_formatted", " TEXT,", "message_tid", " TEXT,", "message_time_text", " TEXT,", "message_stored_ext", " INTEGER DEFAULT 1,", "message_need_update", " TEXT NOT NULL DEFAULT 'Y',", "message_is_failed", " INTEGER DEFAULT 0,", "UNIQUE (", "_id", ") ON CONFLICT REPLACE);");

    /* renamed from: i */
    public static final String f8149i = C5052r.m19199a("CREATE TABLE ", "participant", " (", "participants_buddy_no", " TEXT NOT NULL,", "participants_inbox_no", " TEXT NOT NULL,", "participants_buddy_name", " TEXT,", "UNIQUE (", "participants_buddy_no", ",", "participants_inbox_no", ") ON CONFLICT REPLACE);");

    /* renamed from: j */
    public static final String f8150j = C5052r.m19199a("CREATE TABLE ", "participant", " (", "participants_buddy_no", " TEXT NOT NULL,", "participants_inbox_no", " TEXT NOT NULL,", "participants_buddy_name", " TEXT,", "participants_country_code", " TEXT,", "participants_is_auth", " CHAR(1),", "participants_status", " INTEGER,", "UNIQUE (", "participants_buddy_no", ",", "participants_inbox_no", ") ON CONFLICT REPLACE);");

    /* renamed from: k */
    public static final String f8151k = C5052r.m19199a("participants_buddy_no", ", ", "participants_inbox_no", ", ", "participants_buddy_name", ", ", "participants_country_code", ", ", "participants_is_auth", ", ", "participants_status");

    /* renamed from: l */
    public static final String f8152l = C5052r.m19199a("CREATE TABLE ", "participant_mapping", " (", "participants_buddy_no", " TEXT NOT NULL,", "participants_old_buddy_no", " TEXT NOT NULL,", "UNIQUE (", "participants_buddy_no", ",", "participants_old_buddy_no", ") ON CONFLICT REPLACE);");

    /* renamed from: m */
    @Deprecated
    public static final String f8153m = C5052r.m19199a("CREATE TABLE ", "memo", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25),", "buddy_name", " VARCHAR(80),", "memo", " VARCHAR(255),", "timestamp", " VARCHAR(80)", ", UNIQUE (", "timestamp", "))");

    /* renamed from: n */
    @Deprecated
    public static final String f8154n = C5052r.m19199a("CREATE TABLE ", "memo_sessions", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25),", "buddy_name", " VARCHAR(80),", "starttime", " VARCHAR(80),", "endtime", " VARCHAR(80),", "isblind", " VARCHAR(80)", ", UNIQUE (", "buddy_no", "))");

    /* renamed from: o */
    public static final String f8155o = C5052r.m19199a("CREATE TABLE ", "poston", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "poston", " VARCHAR(255) NOT NULL,", "isread", " VARCHAR(80) NOT NULL,", "unread_comment_count", " VARCHAR(25) NOT NULL,", "read_comment_count", " VARCHAR(25) NOT NULL,", "timestamp", " VARCHAR(80) NOT NULL", ", UNIQUE (", "timestamp", "))");

    /* renamed from: p */
    public static final String f8156p = C5052r.m19199a("CREATE TABLE ", "my_poston", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "image_status", " VARCHAR(80) NOT NULL,", "poston_id", " VARCHAR(80) NOT NULL,", "isread", " VARCHAR(80) NOT NULL,", "read_comment_count", " VARCHAR(25) NOT NULL,", "unread_comment_count", " VARCHAR(25) NOT NULL,", "timestamp", " VARCHAR(80) NOT NULL,", "unread_mood_count", " VARCHAR(25) NOT NULL,", "total_mood_count", " VARCHAR(25) NOT NULL,", "poston", " VARCHAR(255) NOT NULL,", "multimedia_list", " TEXT", ", UNIQUE (", "timestamp", "))");

    /* renamed from: q */
    public static final String f8157q = C5052r.m19199a("CREATE TABLE ", "buddy_poston", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "image_status", " VARCHAR(80) NOT NULL,", "poston_id", " VARCHAR(80) NOT NULL,", "isread", " VARCHAR(80) NOT NULL,", "read_comment_count", " VARCHAR(25) NOT NULL,", "unread_comment_count", " VARCHAR(25) NOT NULL,", "timestamp", " VARCHAR(80) NOT NULL,", "unread_mood_count", " VARCHAR(25) NOT NULL,", "total_mood_count", " VARCHAR(25) NOT NULL,", "poston", " VARCHAR(255) NOT NULL,", "multimedia_list", " TEXT", ", UNIQUE (", "timestamp", "))");

    /* renamed from: r */
    public static final String f8158r = C5052r.m19199a("CREATE TABLE ", "poston_comments", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "comment", " VARCHAR(255) NOT NULL,", "isread", " VARCHAR(80) NOT NULL,", "timestamp", " VARCHAR(80) NOT NULL", ", UNIQUE (", "timestamp", "))");

    /* renamed from: s */
    public static final String f8159s = C5052r.m19199a("CREATE TABLE ", "my_multimedia_poston", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "poston_no", " TEXT NOT NULL,", "poston_metaid", " TEXT NOT NULL,", "poston_metatype", " TEXT NOT NULL,", "poston_url", " TEXT NOT NULL,", "poston_seq", " TEXT NOT NULL", ", UNIQUE (", "poston_url", "))");

    /* renamed from: t */
    public static final String f8160t = C5052r.m19199a("CREATE TABLE ", "buddy_multimedia_poston", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "poston_no", " TEXT NOT NULL,", "poston_metaid", " TEXT NOT NULL,", "poston_metatype", " TEXT NOT NULL,", "poston_url", " TEXT NOT NULL,", "poston_seq", " TEXT NOT NULL", ", UNIQUE (", "poston_url", "))");

    /* renamed from: u */
    public static final String f8161u = C5052r.m19199a("CREATE TABLE ", "profile_image", "(", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "profile_image_id", " TEXT NOT NULL,", "profile_image_url", " TEXT NOT NULL,", "represent", " TEXT,", "regdttm", " TEXT", ", UNIQUE (", "profile_image_id", "))");

    /* renamed from: v */
    public static final String f8162v = C5052r.m19199a("CREATE TABLE ", "cover_story_sample", "(", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "coverstory_id", " TEXT NOT NULL,", "coverstory_thumb_url", " TEXT NOT NULL,", "coverstory_filename", " TEXT", ", UNIQUE (", "coverstory_id", "))");

    /* renamed from: w */
    public static final String f8163w = C5052r.m19199a("CREATE TABLE ", "recommendee", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "type", " INTEGER DEFAULT ", 200, ",", "ignore", " INTEGER DEFAULT 0,", " UNIQUE (", "buddy_no", "))");

    /* renamed from: x */
    @Deprecated
    public static final String f8164x = C5052r.m19199a("CREATE TABLE ", "anicon_category", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "category_id", " VARCHAR(255) NOT NULL,", "name", " VARCHAR(255) NOT NULL,", "thumbnail_url", " TEXT NOT NULL,", " UNIQUE (", "category_id", "))");

    /* renamed from: y */
    public static final String f8165y = C5052r.m19199a("CREATE TABLE ", "anicon_category", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "category_id", " INTEGER NOT NULL,", "name", " VARCHAR(255) NOT NULL,", "thumbnail_url", " TEXT NOT NULL,", " UNIQUE (", "category_id", "))");

    /* renamed from: z */
    @Deprecated
    public static final String f8166z = C5052r.m19199a("CREATE TABLE ", "anicon_package", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "package_id", " VARCHAR(255) NOT NULL,", "category_id", " VARCHAR(255) NOT NULL,", "name", " VARCHAR(255) NOT NULL,", "preview_url", " TEXT NOT NULL,", "thumbnail_url", " TEXT NOT NULL,", "package_zip_url", " TEXT,", "anicon_count", " INTEGER NOT NULL DEFAULT(0),", "volume", " INTEGER NOT NULL DEFAULT(0),", "install", " INTEGER NOT NULL DEFAULT(0),", "expiration_time", " INTEGER NOT NULL DEFAULT(0),", " UNIQUE (", "package_id", "))");

    /* renamed from: A */
    @Deprecated
    public static final String f8119A = C5052r.m19199a("CREATE TABLE ", "anicon_package", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "package_id", " INTEGER NOT NULL,", "category_id", " INTEGER NOT NULL,", "name", " VARCHAR(255) NOT NULL,", "preview_url", " TEXT NOT NULL,", "thumbnail_url", " TEXT NOT NULL,", "package_zip_url", " TEXT,", "anicon_count", " INTEGER NOT NULL DEFAULT(0),", "volume", " INTEGER NOT NULL DEFAULT(0),", "install", " INTEGER NOT NULL DEFAULT(0),", "expiration_time", " INTEGER NOT NULL DEFAULT(0),", "special", " INTEGER NOT NULL DEFAULT(0),", " UNIQUE (", "package_id", "))");

    /* renamed from: B */
    @Deprecated
    public static final String f8120B = C5052r.m19199a("CREATE TABLE ", "anicon_item", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "anicon_id", " VARCHAR(255) NOT NULL,", "package_id", " VARCHAR(255),", "delegate_url", " TEXT,", "cd_proxy_url", " TEXT,", "zip_url", " TEXT,", "sent_time", " TEXT,", " UNIQUE (", "anicon_id", "))");

    /* renamed from: C */
    public static final String f8121C = C5052r.m19199a("CREATE TABLE ", "anicon_item", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "anicon_id", " INTEGER NOT NULL,", "package_id", " INTEGER,", "delegate_url", " TEXT,", "cd_proxy_url", " TEXT,", "zip_url", " TEXT,", "sent_time", " TEXT,", " UNIQUE (", "anicon_id", "))");

    /* renamed from: D */
    @Deprecated
    public static final String f8122D = C5052r.m19199a("CREATE TABLE ", "skin", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "skin_id", " INTEGER NOT NULL,", "special", " INTEGER NOT NULL DEFAULT(0),", "thumbnail_url", " TEXT,", "bg_type", " VARCHAR(255) NOT NULL,", "expiration_date", " INTEGER NOT NULL,", "install", " INTEGER NOT NULL DEFAULT(0),", "new", " INTEGER NOT NULL DEFAULT(0),", " UNIQUE (", "skin_id", "))");

    /* renamed from: E */
    public static final String f8123E = C5052r.m19199a("CREATE TABLE ", "specialbuddy", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "description", " TEXT,", "followcount", " VARCHAR(80),", "likecount", " VARCHAR(80),", "msgstatus", " VARCHAR(256),", "photoloaded", " VARCHAR(25),", "status", " VARCHAR(25),", "url", " VARCHAR(80),", " UNIQUE (", "buddy_no", "))");

    /* renamed from: F */
    @Deprecated
    public static final String f8124F = C5052r.m19199a("CREATE TABLE ", "ams_item", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "item_id", " INTEGER NOT NULL,", "item_type", " VARCHAR(255) NOT NULL,", "thumbnail_url", " TEXT,", "expiration_time", " INTEGER NOT NULL,", "new", " INTEGER NOT NULL DEFAULT(0),", "special", " INTEGER NOT NULL DEFAULT(0),", "install", " INTEGER NOT NULL DEFAULT(0),", " UNIQUE (", "item_id", "))");

    /* renamed from: G */
    public static final String f8125G = C5052r.m19199a("CREATE TABLE ", "download_item", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "reference_id", " INTEGER NOT NULL DEFAULT(0),", "item_id", " INTEGER NOT NULL,", "item_type", " VARCHAR(255) NOT NULL,", "name", " VARCHAR(255),", "install", " INTEGER NOT NULL DEFAULT(0),", "expiration_time", " INTEGER NOT NULL DEFAULT(0),", "new", " INTEGER NOT NULL DEFAULT(0),", "special", " INTEGER NOT NULL DEFAULT(0),", "extras", " TEXT,", " UNIQUE (", "item_id", ", ", "item_type", "))");

    /* renamed from: H */
    public static final String f8126H = C5052r.m19199a("CREATE TABLE ", "poll", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "poll_id", " INTEGER NOT NULL,", "poll_inbox_no", " TEXT,", "poll_chat_type", " INTEGER NOT NULL,", "poll_creator_no", " VARCHAR(25) NOT NULL,", "poll_creator_name", " VARCHAR(80) NOT NULL,", "poll_status", " INTEGER NOT NULL DEFAULT(1),", "poll_question_type", " INTEGER NOT NULL,", "poll_question_text", " TEXT,", "poll_question_image", " TEXT,", "poll_answer_list", " TEXT,", "poll_is_private_result", " CHAR(1) DEFAULT 'N',", "poll_create_time", " TEXT,", "poll_expected_end_time", " TEXT,", "poll_end_time", " TEXT,", "poll_voter_total_count", " INTEGER NOT NULL,", "poll_voter_answer_count", " INTEGER NOT NULL DEFAULT(0),", " UNIQUE (", "poll_id", "))");

    /* renamed from: I */
    public static final String f8127I = C5052r.m19199a("CREATE TABLE ", "poll_voter", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "voter_name", " VARCHAR(80) NOT NULL,", "voter_id", " VARCHAR(25) NOT NULL,", " UNIQUE (", "voter_id", "))");

    /* renamed from: J */
    public static final String f8128J = C5052r.m19199a("CREATE TABLE ", "poll_relation_voter", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "poll_id", " INTEGER NOT NULL,", "voter_id", " VARCHAR(25) NOT NULL,", " UNIQUE (", "poll_id", ",", "voter_id", "))");

    /* renamed from: K */
    public static final String f8129K = C5052r.m19199a("CREATE TABLE ", "answer_relation_voter", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "answer_id", " INTEGER NOT NULL,", "voter_id", " VARCHAR(25) NOT NULL,", " UNIQUE (", "answer_id", ",", "voter_id", "))");

    /* renamed from: L */
    public static final String f8130L = C5052r.m19199a("CREATE TABLE ", "poll_inbox", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "poll_id", " INTEGER NOT NULL,", "poll_inbox_no", " TEXT,", " UNIQUE (", "poll_id", "))");

    /* renamed from: M */
    public static final String f8131M = C5052r.m19199a("CREATE TABLE ", "font_filter", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "filter_id", " INTEGER NOT NULL,", "filter_title", " VARCHAR(255) NOT NULL,", " UNIQUE (", "filter_id", "))");

    /* renamed from: N */
    public static final String f8132N = C5052r.m19199a("CREATE TABLE ", "appmanage", " (", "packageName TEXT, UNIQUE(packageName))");

    /* renamed from: O */
    public static final String f8133O = C5052r.m19199a("CREATE TABLE ", "more_apps", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "id", " INTEGER NOT NULL,", "title", " TEXT NOT NULL,", "priority", " INTEGER NOT NULL,", "type", " INTEGER NOT NULL,", "contenturl", " TEXT NOT NULL,", "appid", " TEXT,", "linkurl", " TEXT,", "samsungappsurl", " TEXT,", "downloadurl", " TEXT", ")");

    /* renamed from: P */
    public static final String f8134P = C5052r.m19199a("CREATE TABLE ", "pluslist", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "id", " TEXT NOT NULL,", "title", " TEXT ,", "rank", " TEXT ,", VKApiConst.COUNTRY, " TEXT ,", "itemtype", " TEXT ,", "thumbnailurl", " TEXT ,", "pricetype", " TEXT,", "price", " TEXT,", "currency", " TEXT", ")");

    /* renamed from: Q */
    public static final String f8135Q = C5052r.m19199a("CREATE TABLE ", "ams_stamp_item", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "item_id", " INTEGER NOT NULL,", "stamp_id", " INTEGER NOT NULL,", "file_name", " TEXT", ")");

    /* renamed from: R */
    public static final String f8136R = C5052r.m19199a("CREATE TABLE ", "shop_item", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT, ", "item_type", " TEXT, ", "item_id", " INTEGER NOT NULL, ", "marketcode", " TEXT,", "consume", " CHAR(1) NOT NULL DEFAULT 'N', ", "payload", " TEXT, ", "signature", " TEXT,", "purchase_json", " TEXT", ")");

    /* renamed from: S */
    public static final String f8137S = C5052r.m19199a("CREATE TABLE ", "inboxsms_mapping", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "inboxsms_mapping_inbox_no", " TEXT,", "inboxsms_mapping_sms_no", " TEXT,", "inboxsms_mapping_unread_count", " INTEGER NOT NULL DEFAULT 0,", "UNIQUE (", "inboxsms_mapping_inbox_no", ",", "inboxsms_mapping_sms_no", ") ON CONFLICT REPLACE);");

    /* renamed from: T */
    public static final String f8138T = C5052r.m19199a("CREATE TABLE ", "unknownbuddy", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_original_name", " TEXT, ", "blocked", " INTEGER NOT NULL DEFAULT(0),", "hided", " INTEGER NOT NULL DEFAULT(0),", "UNIQUE (", "buddy_no", "))");

    /* renamed from: U */
    public static final String f8139U = C5052r.m19199a("CREATE TABLE ", "multichannel_upload", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT, ", "upload_id", " NUMBER NOT NULL, ", "file_uri", " VARCHAR(256) NOT NULL, ", "chunk_count", " INTEGER DEFAULT(0), ", "status", " INTEGER DEFAULT(0), ", "expiration_time", " NUMBER DEFAULT (0), ", "upload_key", " VARCHAR(256), ", "download_url", " VARCHAR(256), ", "auth_code", " INTEGER DEFAULT(0), ", "last_chunk_no", " VARCHAR(50), ", "extra_json", " VARCHAR(256) )");

    /* renamed from: V */
    public static final String f8140V = C5052r.m19199a("CREATE TABLE ", "huge_file_upload_mapping", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT, ", "upload_id", " NUMBER NOT NULL, ", "request_id", " NUMBER NOT NULL, ", "request_type", " INTEGER NOT NULL) ");
}
