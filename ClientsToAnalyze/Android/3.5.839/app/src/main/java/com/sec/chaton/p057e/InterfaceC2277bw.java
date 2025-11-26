package com.sec.chaton.p057e;

import com.sec.chaton.privateplugin.data.Spam;
import com.sec.common.util.C5052r;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bw */
/* loaded from: classes.dex */
public interface InterfaceC2277bw {

    /* renamed from: a */
    public static final String f8118a = C5052r.m19199a("(", "SELECT ", "b.", "relation_date", ",", "a.", "buddy_no", ",", "a.", "buddy_name", ",", "a.", "buddy_status_message", ",", "a.", "buddy_email", ",", "a.", "buddy_samsung_email", ",", "a.", "buddy_orginal_number", ",", "a.", "buddy_msg_send", ",", "a.", "buddy_msg_received", ",", "a.", "buddy_relation_hide", ",", "IFNULL(", "b.", "relation_send", ",", Spam.ACTIVITY_CANCEL, ")", " AS ", "relation_send", ",", "IFNULL(", "b.", "relation_received", ",", Spam.ACTIVITY_CANCEL, ")", " AS ", "relation_received", ",", "IFNULL(", "b.", "relation_point", ",", Spam.ACTIVITY_CANCEL, ")", " AS ", "relation_point", ",", "IFNULL(", "b.", "relation_icon", ",", "6", ")", " AS ", "relation_icon", ",", "IFNULL(", "b.", "relation_increase", ",", Spam.ACTIVITY_CANCEL, ")", " AS ", "relation_increase", ",", "IFNULL(", "b.", "relation_rank", ",", "9999999", ")", " AS ", "relation_rank", ",", "IFNULL(", "a.", "buddy_profile_status", ",", Spam.ACTIVITY_CANCEL, ")", " AS ", "buddy_profile_status", ",", "IFNULL(", "b.", "relation_last_msg_time", ",", "DATETIME('NOW', 'localtime')) AS ", "relation_last_msg_time", ",", 2, " AS ", "group_type", " FROM ", "buddy", " a", " JOIN ", "relation", " b", " ON ", "a.", "buddy_no", " = ", "b.", "relation_buddy_id", ")");
}
