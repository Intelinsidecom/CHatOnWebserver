package com.sec.chaton.p027e;

import com.sec.common.util.C3364o;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.be */
/* loaded from: classes.dex */
public interface InterfaceC1429be {

    /* renamed from: a */
    public static final String f5307a = C3364o.m11849a("(", "SELECT ", "b.", "relation_date", ",", "a.", "buddy_no", ",", "a.", "buddy_name", ",", "a.", "buddy_status_message", ",", "a.", "buddy_email", ",", "a.", "buddy_samsung_email", ",", "a.", "buddy_orginal_number", ",", "a.", "buddy_msg_send", ",", "a.", "buddy_msg_received", ",", "a.", "buddy_relation_hide", ",", "IFNULL(", "b.", "relation_send", ",", "0", ")", " AS ", "relation_send", ",", "IFNULL(", "b.", "relation_received", ",", "0", ")", " AS ", "relation_received", ",", "IFNULL(", "b.", "relation_point", ",", "0", ")", " AS ", "relation_point", ",", "IFNULL(", "b.", "relation_icon", ",", "6", ")", " AS ", "relation_icon", ",", "IFNULL(", "b.", "relation_increase", ",", "0", ")", " AS ", "relation_increase", ",", "IFNULL(", "b.", "relation_rank", ",", "9999999", ")", " AS ", "relation_rank", ",", "IFNULL(", "a.", "buddy_profile_status", ",", "0", ")", " AS ", "buddy_profile_status", ",", "IFNULL(", "b.", "relation_last_msg_time", ",", "DATETIME('NOW', 'localtime')) AS ", "relation_last_msg_time", ",", 2, " AS ", "group_type", " FROM ", "buddy", " a", " JOIN ", "relation", " b", " ON ", "a.", "buddy_no", " = ", "b.", "relation_buddy_id", ")");
}
