package com.sec.chaton.p027e;

import com.sec.common.util.C3364o;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bd */
/* loaded from: classes.dex */
public interface InterfaceC1428bd {

    /* renamed from: a */
    public static final String f5306a = C3364o.m11849a("INSERT ", "INTO ", "relation", " (", "relation_buddy_id", ",", "relation_date", ",", "relation_last_msg_time", ",", "relation_send", ",", "relation_received", ",", "relation_point", ") ", "SELECT ", "buddy_no", ",", "date('NOW', 'localtime', '0 DAY')", ",", "last_msg_time", ",", "ifnull(", "send", ",", "0", ")", ",", "ifnull(", "recevied", ",", "0", ")", ",", "CASE WHEN (", "send", ",", "recevied", ")", " IS NULL THEN ", "0", " ELSE ", "(", "send", " , ", "recevied", ")", " END", " FROM ", "(", "SELECT ", "buddy_no", ",", "message_date", ",", "last_msg_time", ",", "IFNULL(", "MAX(", "send", "),", "0", ")", " AS ", "send", ",", "IFNULL(", "MAX(", "recevied", "),", "0", ")", " AS ", "recevied", " FROM ", "(", "SELECT ", "buddy_no", ",", "message_date", ",", "last_msg_time", ",", "message_type", ",", "(", "CASE WHEN ", "message_type", " = ", 1, " THEN ", "MAX(", "cnt", ")", " END) AS ", "send", ",", "(", "CASE WHEN ", "message_type", " IN (", 2, ",", 5, ",", 4, ",", 3, ") THEN ", "MAX(", "cnt", ")", " END) AS ", "recevied", " FROM ", "(", "SELECT ", "a.", "buddy_no", " AS ", "buddy_no", ",", "b.", "message_type", ",", "SUBSTR(", "b.", "message_time_text", ",", "1", ",", "10", ")", " AS ", "message_date", ",", "MAX(", "b.", "message_time_text", ")", " AS ", "last_msg_time", ",", "COUNT(", "b.", "message_inbox_no", ")", " AS ", "cnt", " FROM ", "inbox_buddy_relation", " a,", "message", " b", " WHERE ", "a.", "inbox_no", " = ", "b.", "message_inbox_no", " AND ", "b.", "message_type", " IN ", "(", 1, ",", 2, ",", 5, ",", 4, ",", 3, ")", " AND ", "b.", "message_time_text", " BETWEEN ", "date('NOW', 'localtime', '-7 DAY') || '00:00:00'", " AND ", "date('NOW', 'localtime', '0 DAY') || '99:99:99'", " GROUP BY ", "message_inbox_no", ",", "message_type", ") a", " WHERE ", "buddy_no", " IN (", "SELECT ", "buddy_no", " FROM ", "buddy", ")", " GROUP BY ", "buddy_no", ",", "message_type", ")", " GROUP BY ", "buddy_no", ")");
}
