package com.sec.chaton.p027e;

import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.common.util.C3364o;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bf */
/* loaded from: classes.dex */
public interface InterfaceC1430bf {

    /* renamed from: a */
    public static final String f5322a = C3364o.m11849a("CREATE TABLE ", "buddy", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "buddy_status_message", " VARCHAR(255),", "buddy_email", " VARCHAR(80),", "buddy_samsung_email", " VARCHAR(80),", "buddy_orginal_number", " VARCHAR(25),", "buddy_birthday", " VARCHAR(10) NOT NULL DEFAULT '',", "buddy_msg_send", " INTEGER DEFAULT 0,", "buddy_msg_received", " INTEGER DEFAULT 0,", "buddy_relation_hide", " CHAR(1) NOT NULL DEFAULT 'N',", "buddy_raw_contact_id", " NUMBER DEFAULT 0, ", "buddy_push_name", " VARCHAR(25),", "buddy_is_new", " CHAR(1) NOT NULL DEFAULT 'Y',", "buddy_profile_status", " INTEGER NOT NULL DEFAULT ", Integer.valueOf(Buddy.BuddyImageStatus.NONE_PROFILE.getCode()), ",", "UNIQUE (", "buddy_no", "))");

    /* renamed from: b */
    public static final String f5323b = C3364o.m11849a("CREATE TABLE ", "buddy_group", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "group_name", " VARCHAR(80) NOT NULL,", "group_type", " INTEGER NOT NULL DEFAULT 2,", "UNIQUE (", "_id", ") ON CONFLICT REPLACE);");

    /* renamed from: c */
    public static final String f5324c = C3364o.m11849a("CREATE TABLE ", "grouprelation", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "group_relation_buddy", " VARCHAR(25) NOT NULL REFERENCES ", "buddy", "(", "buddy_no", "),", "group_relation_group", " VARCHAR(25) NOT NULL REFERENCES ", "buddy_group", "(", "_id", "),", "UNIQUE (", "group_relation_group", ",", "group_relation_buddy", ") ON CONFLICT REPLACE);");

    /* renamed from: d */
    public static final String f5325d = C3364o.m11849a("CREATE TABLE ", "relation", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "relation_buddy_id", " TEXT NOT NULL,", "relation_date", " TEXT NOT NULL,", "relation_send", " INTEGER NOT NULL DEFAULT 0,", "relation_received", " INTEGER NOT NULL DEFAULT 0,", "relation_point", " INTEGER NOT NULL DEFAULT 0,", "relation_icon", " INTEGER NOT NULL DEFAULT 0,", "relation_increase", " INTEGER NOT NULL DEFAULT 0,", "relation_rank", " INTEGER NOT NULL DEFAULT 0,", "UNIQUE (", "relation_buddy_id", ",", "relation_date", ") ON CONFLICT REPLACE);");

    /* renamed from: e */
    public static final String f5326e = C3364o.m11849a("CREATE TABLE ", "contacts", " (", "contacts_id", " NUMBER,", "contact_raw_id", " NUMBER,", "conatct_number", " TEXT NOT NULL,", "contacts_name", " TEXT,", "UNIQUE (", "contacts_id", ",", "contact_raw_id", ") ON CONFLICT REPLACE);");

    /* renamed from: f */
    public static final String f5327f = C3364o.m11849a("CREATE TABLE ", "inbox", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "inbox_no", " TEXT,", "inbox_chat_type", " INTEGER NOT NULL,", "inbox_unread_count", " INTEGER NOT NULL DEFAULT 0,", "inbox_last_message", " TEXT,", "inbox_title", " TEXT,", "inbox_last_time", " NUMBER,", "inbox_lang_from", " TEXT,", "inbox_lang_to", " TEXT,", "inbox_translated", " TEXT NOT NULL DEFAULT 'N',", "inbox_server_ip", " TEXT,", "inbox_server_port", " NUMBER,", "inbox_participants", " TEXT,", "inbox_session_id", " TEXT,", "inbox_last_msg_no", " NUMBER,", "inbox_last_msg_sender", " TEXT,", "inbox_title_fixed", " TEXT NOT NULL DEFAULT 'N',", "inbox_last_chat_type", " NUMBER,", "inbox_last_temp_msg", " TEXT NOT NULL DEFAULT '',", "UNIQUE (", "inbox_no", ") ON CONFLICT REPLACE);");

    /* renamed from: g */
    public static final String f5328g = C3364o.m11849a("CREATE TABLE ", "inbox_buddy_relation", " (", "inbox_no", " TEXT,", "buddy_no", " TEXT,", "UNIQUE (", "inbox_no", ",", "buddy_no", ") ON CONFLICT REPLACE);");

    /* renamed from: h */
    public static final String f5329h = C3364o.m11849a("CREATE TABLE ", "message", " (", "_id", " INTEGER PRIMARY KEY,", "message_sever_id", " INTEGER,", "message_inbox_no", " TEXT,", "message_session_id", " INTEGER,", "message_read_status", " INTEGER,", "message_content_type", " INTEGER DEFAULT 0,", "message_time", " NUMBER,", "message_content", " TEXT,", "message_translated", " TEXT,", "message_type", " INTEGER,", "message_sender", " TEXT,", "message_download_uri", " TEXT,", "message_formatted", " TEXT,", "message_tid", " TEXT,", "message_time_text", " TEXT,", "message_stored_ext", " INTEGER DEFAULT 1,", "message_need_update", " TEXT NOT NULL DEFAULT 'Y',", "message_is_failed", " INTEGER DEFAULT 0,", "UNIQUE (", "_id", ") ON CONFLICT REPLACE);");

    /* renamed from: i */
    public static final String f5330i = C3364o.m11849a("CREATE TABLE ", "participant", " (", "participants_buddy_no", " TEXT NOT NULL,", "participants_inbox_no", " TEXT NOT NULL,", "participants_buddy_name", " TEXT,", "UNIQUE (", "participants_buddy_no", ",", "participants_inbox_no", ") ON CONFLICT REPLACE);");

    /* renamed from: j */
    public static final String f5331j = C3364o.m11849a("CREATE TABLE ", "participant", " (", "participants_buddy_no", " TEXT NOT NULL,", "participants_inbox_no", " TEXT NOT NULL,", "participants_buddy_name", " TEXT,", "participants_country_code", " TEXT,", "participants_is_auth", " CHAR(1),", "participants_status", " INTEGER,", "UNIQUE (", "participants_buddy_no", ",", "participants_inbox_no", ") ON CONFLICT REPLACE);");

    /* renamed from: k */
    public static final String f5332k = C3364o.m11849a("participants_buddy_no", ", ", "participants_inbox_no", ", ", "participants_buddy_name", ", ", "participants_country_code", ", ", "participants_is_auth", ", ", "participants_status");

    /* renamed from: l */
    public static final String f5333l = C3364o.m11849a("CREATE TABLE ", "participant_mapping", " (", "participants_buddy_no", " TEXT NOT NULL,", "participants_old_buddy_no", " TEXT NOT NULL,", "UNIQUE (", "participants_buddy_no", ",", "participants_old_buddy_no", ") ON CONFLICT REPLACE);");

    /* renamed from: m */
    @Deprecated
    public static final String f5334m = C3364o.m11849a("CREATE TABLE ", "memo", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25),", "buddy_name", " VARCHAR(80),", "memo", " VARCHAR(255),", "timestamp", " VARCHAR(80)", ", UNIQUE (", "timestamp", "))");

    /* renamed from: n */
    @Deprecated
    public static final String f5335n = C3364o.m11849a("CREATE TABLE ", "memo_sessions", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25),", "buddy_name", " VARCHAR(80),", "starttime", " VARCHAR(80),", "endtime", " VARCHAR(80),", "isblind", " VARCHAR(80)", ", UNIQUE (", "buddy_no", "))");

    /* renamed from: o */
    public static final String f5336o = C3364o.m11849a("CREATE TABLE ", "poston", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "poston", " VARCHAR(255) NOT NULL,", "isread", " VARCHAR(80) NOT NULL,", "unread_comment_count", " VARCHAR(25) NOT NULL,", "read_comment_count", " VARCHAR(25) NOT NULL,", "timestamp", " VARCHAR(80) NOT NULL", ", UNIQUE (", "timestamp", "))");

    /* renamed from: p */
    public static final String f5337p = C3364o.m11849a("CREATE TABLE ", "my_poston", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "image_status", " VARCHAR(80) NOT NULL,", "poston_id", " VARCHAR(80) NOT NULL,", "isread", " VARCHAR(80) NOT NULL,", "read_comment_count", " VARCHAR(25) NOT NULL,", "unread_comment_count", " VARCHAR(25) NOT NULL,", "timestamp", " VARCHAR(80) NOT NULL,", "unread_mood_count", " VARCHAR(25) NOT NULL,", "total_mood_count", " VARCHAR(25) NOT NULL,", "poston", " VARCHAR(255) NOT NULL,", "multimedia_list", " TEXT", ", UNIQUE (", "timestamp", "))");

    /* renamed from: q */
    public static final String f5338q = C3364o.m11849a("CREATE TABLE ", "buddy_poston", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "image_status", " VARCHAR(80) NOT NULL,", "poston_id", " VARCHAR(80) NOT NULL,", "isread", " VARCHAR(80) NOT NULL,", "read_comment_count", " VARCHAR(25) NOT NULL,", "unread_comment_count", " VARCHAR(25) NOT NULL,", "timestamp", " VARCHAR(80) NOT NULL,", "unread_mood_count", " VARCHAR(25) NOT NULL,", "total_mood_count", " VARCHAR(25) NOT NULL,", "poston", " VARCHAR(255) NOT NULL,", "multimedia_list", " TEXT", ", UNIQUE (", "timestamp", "))");

    /* renamed from: r */
    public static final String f5339r = C3364o.m11849a("CREATE TABLE ", "poston_comments", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "comment", " VARCHAR(255) NOT NULL,", "isread", " VARCHAR(80) NOT NULL,", "timestamp", " VARCHAR(80) NOT NULL", ", UNIQUE (", "timestamp", "))");

    /* renamed from: s */
    public static final String f5340s = C3364o.m11849a("CREATE TABLE ", "my_multimedia_poston", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "poston_no", " TEXT NOT NULL,", "poston_metaid", " TEXT NOT NULL,", "poston_metatype", " TEXT NOT NULL,", "poston_url", " TEXT NOT NULL,", "poston_seq", " TEXT NOT NULL", ", UNIQUE (", "poston_url", "))");

    /* renamed from: t */
    public static final String f5341t = C3364o.m11849a("CREATE TABLE ", "buddy_multimedia_poston", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "poston_no", " TEXT NOT NULL,", "poston_metaid", " TEXT NOT NULL,", "poston_metatype", " TEXT NOT NULL,", "poston_url", " TEXT NOT NULL,", "poston_seq", " TEXT NOT NULL", ", UNIQUE (", "poston_url", "))");

    /* renamed from: u */
    public static final String f5342u = C3364o.m11849a("CREATE TABLE ", "cover_story_sample", "(", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "coverstory_id", " TEXT NOT NULL,", "coverstory_thumb_url", " TEXT NOT NULL,", "coverstory_filename", " TEXT", ", UNIQUE (", "coverstory_id", "))");

    /* renamed from: v */
    public static final String f5343v = C3364o.m11849a("CREATE TABLE ", "recommendee", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", PrefFragmentChats.TYPE, " INTEGER DEFAULT ", Integer.valueOf(HttpResponseCode.f13733OK), ",", "ignore", " INTEGER DEFAULT 0,", " UNIQUE (", "buddy_no", "))");

    /* renamed from: w */
    @Deprecated
    public static final String f5344w = C3364o.m11849a("CREATE TABLE ", "anicon_category", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "category_id", " VARCHAR(255) NOT NULL,", "name", " VARCHAR(255) NOT NULL,", "thumbnail_url", " TEXT NOT NULL,", " UNIQUE (", "category_id", "))");

    /* renamed from: x */
    public static final String f5345x = C3364o.m11849a("CREATE TABLE ", "anicon_category", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "category_id", " INTEGER NOT NULL,", "name", " VARCHAR(255) NOT NULL,", "thumbnail_url", " TEXT NOT NULL,", " UNIQUE (", "category_id", "))");

    /* renamed from: y */
    @Deprecated
    public static final String f5346y = C3364o.m11849a("CREATE TABLE ", "anicon_package", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "package_id", " VARCHAR(255) NOT NULL,", "category_id", " VARCHAR(255) NOT NULL,", "name", " VARCHAR(255) NOT NULL,", "preview_url", " TEXT NOT NULL,", "thumbnail_url", " TEXT NOT NULL,", "package_zip_url", " TEXT,", "anicon_count", " INTEGER NOT NULL DEFAULT(0),", "volume", " INTEGER NOT NULL DEFAULT(0),", "install", " INTEGER NOT NULL DEFAULT(0),", "expiration_time", " INTEGER NOT NULL DEFAULT(0),", " UNIQUE (", "package_id", "))");

    /* renamed from: z */
    @Deprecated
    public static final String f5347z = C3364o.m11849a("CREATE TABLE ", "anicon_package", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "package_id", " INTEGER NOT NULL,", "category_id", " INTEGER NOT NULL,", "name", " VARCHAR(255) NOT NULL,", "preview_url", " TEXT NOT NULL,", "thumbnail_url", " TEXT NOT NULL,", "package_zip_url", " TEXT,", "anicon_count", " INTEGER NOT NULL DEFAULT(0),", "volume", " INTEGER NOT NULL DEFAULT(0),", "install", " INTEGER NOT NULL DEFAULT(0),", "expiration_time", " INTEGER NOT NULL DEFAULT(0),", "special", " INTEGER NOT NULL DEFAULT(0),", " UNIQUE (", "package_id", "))");

    /* renamed from: A */
    @Deprecated
    public static final String f5308A = C3364o.m11849a("CREATE TABLE ", "anicon_item", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "anicon_id", " VARCHAR(255) NOT NULL,", "package_id", " VARCHAR(255),", "delegate_url", " TEXT,", "cd_proxy_url", " TEXT,", "zip_url", " TEXT,", "sent_time", " TEXT,", " UNIQUE (", "anicon_id", "))");

    /* renamed from: B */
    public static final String f5309B = C3364o.m11849a("CREATE TABLE ", "anicon_item", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "anicon_id", " INTEGER NOT NULL,", "package_id", " INTEGER,", "delegate_url", " TEXT,", "cd_proxy_url", " TEXT,", "zip_url", " TEXT,", "sent_time", " TEXT,", " UNIQUE (", "anicon_id", "))");

    /* renamed from: C */
    @Deprecated
    public static final String f5310C = C3364o.m11849a("CREATE TABLE ", "skin", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "skin_id", " INTEGER NOT NULL,", "special", " INTEGER NOT NULL DEFAULT(0),", "thumbnail_url", " TEXT,", "bg_type", " VARCHAR(255) NOT NULL,", "expiration_date", " INTEGER NOT NULL,", "install", " INTEGER NOT NULL DEFAULT(0),", "new", " INTEGER NOT NULL DEFAULT(0),", " UNIQUE (", "skin_id", "))");

    /* renamed from: D */
    public static final String f5311D = C3364o.m11849a("CREATE TABLE ", "specialbuddy", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "buddy_no", " VARCHAR(25) NOT NULL,", "buddy_name", " VARCHAR(80) NOT NULL,", "description", " TEXT,", "followcount", " VARCHAR(80),", "likecount", " VARCHAR(80),", "msgstatus", " VARCHAR(256),", "photoloaded", " VARCHAR(25),", "status", " VARCHAR(25),", "url", " VARCHAR(80),", " UNIQUE (", "buddy_no", "))");

    /* renamed from: E */
    @Deprecated
    public static final String f5312E = C3364o.m11849a("CREATE TABLE ", "ams_item", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "item_id", " INTEGER NOT NULL,", "item_type", " VARCHAR(255) NOT NULL,", "thumbnail_url", " TEXT,", "expiration_time", " INTEGER NOT NULL,", "new", " INTEGER NOT NULL DEFAULT(0),", "special", " INTEGER NOT NULL DEFAULT(0),", "install", " INTEGER NOT NULL DEFAULT(0),", " UNIQUE (", "item_id", "))");

    /* renamed from: F */
    public static final String f5313F = C3364o.m11849a("CREATE TABLE ", "download_item", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "reference_id", " INTEGER NOT NULL DEFAULT(0),", "item_id", " INTEGER NOT NULL,", "item_type", " VARCHAR(255) NOT NULL,", "name", " VARCHAR(255),", "install", " INTEGER NOT NULL DEFAULT(0),", "expiration_time", " INTEGER NOT NULL DEFAULT(0),", "new", " INTEGER NOT NULL DEFAULT(0),", "special", " INTEGER NOT NULL DEFAULT(0),", "extras", " TEXT,", " UNIQUE (", "item_id", ", ", "item_type", "))");

    /* renamed from: G */
    public static final String f5314G = C3364o.m11849a("CREATE TABLE ", "poll", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "poll_id", " INTEGER NOT NULL,", "poll_inbox_no", " TEXT,", "poll_chat_type", " INTEGER NOT NULL,", "poll_creator_no", " VARCHAR(25) NOT NULL,", "poll_creator_name", " VARCHAR(80) NOT NULL,", "poll_status", " INTEGER NOT NULL DEFAULT(1),", "poll_question_type", " INTEGER NOT NULL,", "poll_question_text", " TEXT,", "poll_question_image", " TEXT,", "poll_answer_list", " TEXT,", "poll_is_private_result", " CHAR(1) DEFAULT 'N',", "poll_create_time", " TEXT,", "poll_expected_end_time", " TEXT,", "poll_end_time", " TEXT,", "poll_voter_total_count", " INTEGER NOT NULL,", "poll_voter_answer_count", " INTEGER NOT NULL DEFAULT(0),", " UNIQUE (", "poll_id", "))");

    /* renamed from: H */
    public static final String f5315H = C3364o.m11849a("CREATE TABLE ", "poll_voter", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "voter_name", " VARCHAR(80) NOT NULL,", "voter_id", " VARCHAR(25) NOT NULL,", " UNIQUE (", "voter_id", "))");

    /* renamed from: I */
    public static final String f5316I = C3364o.m11849a("CREATE TABLE ", "poll_relation_voter", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "poll_id", " INTEGER NOT NULL,", "voter_id", " VARCHAR(25) NOT NULL,", " UNIQUE (", "poll_id", ",", "voter_id", "))");

    /* renamed from: J */
    public static final String f5317J = C3364o.m11849a("CREATE TABLE ", "answer_relation_voter", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "answer_id", " INTEGER NOT NULL,", "voter_id", " VARCHAR(25) NOT NULL,", " UNIQUE (", "answer_id", ",", "voter_id", "))");

    /* renamed from: K */
    public static final String f5318K = C3364o.m11849a("CREATE TABLE ", "poll_inbox", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "poll_id", " INTEGER NOT NULL,", "poll_inbox_no", " TEXT,", " UNIQUE (", "poll_id", "))");

    /* renamed from: L */
    public static final String f5319L = C3364o.m11849a("CREATE TABLE ", "font_filter", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "filter_id", " INTEGER NOT NULL,", "filter_title", " VARCHAR(255) NOT NULL,", " UNIQUE (", "filter_id", "))");

    /* renamed from: M */
    public static final String f5320M = C3364o.m11849a("CREATE TABLE ", "appmanage", " (", "packageName TEXT, UNIQUE(packageName))");

    /* renamed from: N */
    public static final String f5321N = C3364o.m11849a("CREATE TABLE ", "more_apps", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "id", " INTEGER NOT NULL,", "title", " TEXT NOT NULL,", "priority", " INTEGER NOT NULL,", PrefFragmentChats.TYPE, " INTEGER NOT NULL,", "contenturl", " TEXT NOT NULL,", "appid", " TEXT,", "linkurl", " TEXT,", "samsungappsurl", " TEXT,", "downloadurl", " TEXT", ")");
}
