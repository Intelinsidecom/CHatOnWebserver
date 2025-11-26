package com.sec.chaton.p027e;

import com.sec.common.util.C3364o;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.az */
/* loaded from: classes.dex */
public interface InterfaceC1408az {

    /* renamed from: a */
    public static final String f5238a = C3364o.m11849a("(", "SELECT ", "b.", "buddy_no", ",", "b.", "buddy_name", ",", "b.", "buddy_status_message", ",", "b.", "buddy_email", ",", "b.", "buddy_samsung_email", ",", "b.", "buddy_orginal_number", ",", "b.", "buddy_msg_send", ",", "b.", "buddy_msg_received", ",", "b.", "buddy_relation_hide", ",", "b.", "buddy_birthday", ",", "b.", "buddy_raw_contact_id", ",", "b.", "buddy_push_name", ",", "b.", "buddy_is_new", ",", "b.", "buddy_profile_status", ",", "b.", "buddy_is_profile_updated", ",", "b.", "buddy_is_status_updated", ",", "b.", "buddy_show_phone_number", ",", "b.", "buddy_extra_info", ",", "b.", "buddy_account_info", ",", "b.", "buddy_hanzitopinyin", ",", "b.", "buddy_sainfo", ",", "a.", "group_relation_group", " FROM ", "grouprelation", " a", " JOIN ", "buddy", " b", " ON ", "a.", "group_relation_buddy", " = ", "b.", "buddy_no", ")");

    /* renamed from: b */
    public static final String f5239b = C3364o.m11849a("(", "SELECT ", "*", " FROM ", "(", "SELECT ", "*", " FROM ", "(", "SELECT ", "buddy_no", ",", "buddy_name", ",", "buddy_status_message", ",", "buddy_email", ",", "buddy_samsung_email", ",", "buddy_orginal_number", ",", "buddy_relation_hide", ",", "buddy_birthday", ",", "buddy_raw_contact_id", ",", "buddy_push_name", ",", "buddy_is_new", ",", "buddy_profile_status", ",", "buddy_is_profile_updated", ",", "buddy_is_status_updated", ",", "ifnull(", "b.", "group_relation_group", ",", "9999", ") AS ", "group_relation_group", ",", "ifnull(", "c.", "group_type", ",", 3, ") AS ", "group_type", " FROM ", "buddy", " a", " LEFT OUTER JOIN ", "grouprelation", " b", " ON ", "a.", "buddy_no", "=", "b.", "group_relation_buddy", " LEFT OUTER JOIN ", "buddy_group", " c", " ON ", "b.", "group_relation_group", "=", "c.", "_id", ")", " GROUP BY ", "buddy_no", ")", ")");

    /* renamed from: c */
    public static final String f5240c = C3364o.m11849a("(", "SELECT ", "a.", "_id", ",", "a.", "group_name", ",", "c.", "*", " FROM ", "buddy_group", " a", " LEFT OUTER JOIN ", "grouprelation", " b", " ON ", "a.", "_id", " = ", "b.", "group_relation_group", " LEFT OUTER JOIN ", "buddy", " c", " ON ", "b.", "group_relation_buddy", " = ", "c.", "buddy_no", ")");
}
