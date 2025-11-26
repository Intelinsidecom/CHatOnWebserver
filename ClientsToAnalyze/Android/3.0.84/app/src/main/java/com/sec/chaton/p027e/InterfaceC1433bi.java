package com.sec.chaton.p027e;

import com.sec.common.util.C3364o;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bi */
/* loaded from: classes.dex */
public interface InterfaceC1433bi {

    /* renamed from: a */
    public static final String f5357a = C3364o.m11849a("UPDATE ", "message", " SET ", "message_read_status", "=", " CASE WHEN ", "message_read_status", " < ? THEN 0 ", " ELSE (", "message_read_status", "-?)", " END WHERE ", "message_sever_id", "=?");

    /* renamed from: b */
    public static final String f5358b = C3364o.m11849a("UPDATE ", "message", " SET ", "message_read_status", " = 0 WHERE ", "message_inbox_no", " = ? AND ", "message_sender", " = ? AND ", "message_type", " = ", 1, " AND ", "message_time", " <= (SELECT ", "message_time", " FROM ", "message", " WHERE ", "message_sever_id", " = ?)");
}
