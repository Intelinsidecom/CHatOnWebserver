package com.sec.chaton.p027e;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.ax */
/* loaded from: classes.dex */
public interface InterfaceC1406ax {

    /* renamed from: a */
    public static final String f5236a = " SELECT a.message_inbox_no AS message_inbox_no, a.message_sever_id AS message_sever_id, a.message_content_type AS message_content_type, a.message_content AS message_content, a.message_sender AS message_sender, a.message_time AS message_time, ifnull(c.buddy_name, '') AS buddy_name FROM ( SELECT * FROM message WHERE message_inbox_no = ? AND message_type = '" + Integer.toString(2) + "' ORDER BY message_is_failed DESC , message_time DESC , _id DESC LIMIT ? ) a LEFT OUTER JOIN (SELECT p.participants_buddy_no AS buddy_no, ifnull(b.buddy_name, p.participants_buddy_name) AS buddy_name FROM participant p LEFT OUTER JOIN ( SELECT buddy_no, buddy_name FROM buddy UNION ALL SELECT buddy_no AS buddy_no, buddy_name AS buddy_name FROM specialbuddy ) b ON p.participants_buddy_no = b.buddy_no WHERE p.participants_inbox_no = ? OR p.participants_inbox_no = '' GROUP BY buddy_no) c ON a.message_sender = c.buddy_no";
}
