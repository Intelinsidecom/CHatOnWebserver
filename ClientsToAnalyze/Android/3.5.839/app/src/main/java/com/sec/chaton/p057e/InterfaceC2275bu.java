package com.sec.chaton.p057e;

import com.sec.common.util.C5052r;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bu */
/* loaded from: classes.dex */
public interface InterfaceC2275bu {

    /* renamed from: a */
    public static final String f8111a = C5052r.m19199a("(SELECT ", "p.", "buddy_no", ", CASE WHEN (b.", "buddy_name", " IS NOT NULL ) THEN b.", "buddy_name", " ELSE p.", "buddy_name", " END AS joined_name, p.", "poston", ", p.", "isread", ", p.", "unread_comment_count", ", p.", "read_comment_count", ", p.", "timestamp", " FROM ", "poston", " p LEFT OUTER JOIN ", "buddy", " b ON p.", "buddy_no", " = b.", "buddy_no", ")");

    /* renamed from: b */
    public static final String f8112b = C5052r.m19199a("(SELECT ", "p.", "buddy_no", ", CASE WHEN (b.", "buddy_name", " IS NOT NULL ) THEN b.", "buddy_name", " ELSE p.", "buddy_name", " END AS joined_name, p.", "buddy_no", " AS joined_no, p.", "poston", ", p.", "isread", ", p.", "poston_id", ", p.", "unread_comment_count", ", p.", "read_comment_count", ", p.", "timestamp", ",p.", "order_msec", ", p.", "multimedia_list", " FROM ", "my_poston", " p LEFT OUTER JOIN ", "buddy", " b ON p.", "buddy_no", " = b.", "buddy_no", ")");

    /* renamed from: c */
    public static final String f8113c = C5052r.m19199a("(SELECT ", "p.", "buddy_no", ", CASE WHEN (b.", "buddy_name", " IS NOT NULL ) THEN b.", "buddy_name", " ELSE p.", "buddy_name", " END AS joined_name, p.", "buddy_no", " AS joined_no, p.", "poston", ", p.", "isread", ", p.", "poston_id", ", p.", "unread_comment_count", ", p.", "read_comment_count", ", p.", "timestamp", ", p.", "multimedia_list", " FROM ", "buddy_poston", " p LEFT OUTER JOIN ", "buddy", " b ON p.", "buddy_no", " = b.", "buddy_no", ")");

    /* renamed from: d */
    public static final String f8114d = C5052r.m19199a("(SELECT ", "c.", "buddy_no", ", CASE WHEN (b.", "buddy_name", " IS NOT NULL ) THEN b.", "buddy_name", " ELSE c.", "buddy_name", " END AS joined_name, c.", "comment", ", c.", "isread", ", c.", "timestamp", ", c.", "commentid", " FROM ", "poston_comments", " c LEFT OUTER JOIN ", "buddy", " b ON c.", "buddy_no", " = b.", "buddy_no", ")");

    /* renamed from: e */
    public static final String f8115e = C5052r.m19199a("(SELECT ", "p.", "poston_no", ",", "poston", " AS joined_my_poston", ",", "buddy_no", " AS joined_buddy_no", ",", "buddy_name", " AS joined_buddy_name", ",", "timestamp", " AS joined_my_poston_time", ",", "read_comment_count", " AS joined_my_poston_comment_read", ",", "unread_comment_count", " AS joined_my_poston_comment_unread", ", p.", "poston_metaid", ", p.", "poston_metatype", ", p.", "poston_url", ", p.", "poston_seq", " FROM ", "my_multimedia_poston", " p LEFT OUTER JOIN ", "my_poston", " b ON p.", "poston_no", " = b.", "poston_id", ")");

    /* renamed from: f */
    public static final String f8116f = C5052r.m19199a("(SELECT ", "p.", "poston_no", ",", "poston", " AS joined_buddy_poston", ",", "buddy_no", " AS joined_buddy_no", ",", "buddy_name", " AS joined_buddy_name", ",", "timestamp", " AS joined_buddy_poston_time", ",", "read_comment_count", " AS joined_buddy_poston_comment_read", ",", "unread_comment_count", " AS joined_buddy_poston_comment_unread", ", p.", "poston_metaid", ", p.", "poston_metatype", ", p.", "poston_url", ", p.", "poston_seq", " FROM ", "buddy_multimedia_poston", " p LEFT OUTER JOIN ", "buddy_poston", " b ON p.", "poston_no", " = b.", "poston_id", ")");
}
