package com.sec.chaton.p057e;

import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.common.util.C5052r;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bv */
/* loaded from: classes.dex */
public interface InterfaceC2276bv {

    /* renamed from: a */
    public static final String f8117a = C5052r.m19199a("INSERT ", "INTO ", "relation", " (", "relation_buddy_id", ",", "relation_date", ",", "relation_last_msg_time", ",", "relation_send", ",", "relation_received", ",", "relation_point", ") ", "SELECT ", "buddy_no", ",", "date('NOW', 'localtime', '0 DAY')", ",", "last_msg_time", ",", "ifnull(", "send", ",", Spam.ACTIVITY_CANCEL, ")", ",", "ifnull(", "recevied", ",", Spam.ACTIVITY_CANCEL, ")", ",", "CASE WHEN (", "send", ",", "recevied", ")", " IS NULL THEN ", Spam.ACTIVITY_CANCEL, " ELSE ", "(", "send", " , ", "recevied", ")", " END", " FROM ", "(", "SELECT ", "buddy_no", ",", "message_date", ",", "last_msg_time", ",", "IFNULL(", "MAX(", "send", "),", Spam.ACTIVITY_CANCEL, ")", " AS ", "send", ",", "IFNULL(", "MAX(", "recevied", "),", Spam.ACTIVITY_CANCEL, ")", " AS ", "recevied", " FROM ", "(", "SELECT ", "buddy_no", ",", "message_date", ",", "last_msg_time", ",", "message_type", ",", "(", "CASE WHEN ", "message_type", " = ", 1, " THEN ", "MAX(", "cnt", ")", " END) AS ", "send", ",", "(", "CASE WHEN ", "message_type", " IN (", 2, ",", 5, ",", 4, ",", 3, ") THEN ", "MAX(", "cnt", ")", " END) AS ", "recevied", " FROM ", "(", "SELECT ", "a.", "buddy_no", " AS ", "buddy_no", ",", "b.", "message_type", ",", "SUBSTR(", "b.", "message_time_text", ",", Spam.ACTIVITY_REPORT, ",", "10", ")", " AS ", "message_date", ",", "MAX(", "b.", "message_time_text", ")", " AS ", "last_msg_time", ",", "COUNT(", "b.", "message_inbox_no", ")", " AS ", "cnt", " FROM ", "inbox_buddy_relation", " a,", VKApiConst.MESSAGE, " b", " WHERE ", "a.", "inbox_no", " = ", "b.", "message_inbox_no", " AND ", "b.", "message_type", " IN ", "(", 1, ",", 2, ",", 5, ",", 4, ",", 3, ")", " AND ", "b.", "message_time_text", " BETWEEN ", "date('NOW', 'localtime', '-7 DAY') || '00:00:00'", " AND ", "date('NOW', 'localtime', '0 DAY') || '99:99:99'", " GROUP BY ", "message_inbox_no", ",", "message_type", ") a", " WHERE ", "buddy_no", " IN (", "SELECT ", "buddy_no", " FROM ", "buddy", ")", " GROUP BY ", "buddy_no", ",", "message_type", ")", " GROUP BY ", "buddy_no", ")");
}
