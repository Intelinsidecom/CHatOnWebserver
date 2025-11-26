package com.sec.chaton.p057e;

import com.p137vk.sdk.api.VKApiConst;
import com.sec.common.util.C5052r;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.ca */
/* loaded from: classes.dex */
public interface InterfaceC2282ca {

    /* renamed from: a */
    public static final String f8185a = C5052r.m19199a("UPDATE ", VKApiConst.MESSAGE, " SET ", "message_read_status", " = ? WHERE ", "message_inbox_no", " = ? AND ", "message_sender", " = ? AND ", "message_type", " = ", 1, " AND ", "message_time", " <= ? AND ", "message_read_status", " < ?");

    /* renamed from: b */
    public static final String f8186b = C5052r.m19199a("UPDATE ", VKApiConst.MESSAGE, " SET ", "message_read_status", " = 0 WHERE ", "message_inbox_no", " = ? AND ", "message_sender", " = ? AND ", "message_type", " = ", 1, " AND ", "message_time", " <= (SELECT ", "message_time", " FROM ", VKApiConst.MESSAGE, " WHERE ", "message_sever_id", " = ?)");
}
