package com.sec.chaton.p027e;

import com.sec.common.util.C3364o;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.ay */
/* loaded from: classes.dex */
public interface InterfaceC1407ay {

    /* renamed from: a */
    public static final String f5237a = C3364o.m11849a("(", "SELECT ", "a.", "_id", ",", "a.", "group_name", ",", "a.", "group_type", ",", "ifnull(", "b.", "cnt", ",", "0) AS ", "cnt", " FROM ", "buddy_group", " a", " LEFT OUTER JOIN (", "SELECT ", "group_relation_group", ",", "COUNT(*) AS ", "cnt", " FROM ", "grouprelation", " GROUP BY ", "group_relation_group", " HAVING ", "group_relation_group", " > 1", ") b", " ON ", "a.", "_id", "=", "b.", "group_relation_group", " WHERE ", "a.", "_id", " != 1", ")f");
}
