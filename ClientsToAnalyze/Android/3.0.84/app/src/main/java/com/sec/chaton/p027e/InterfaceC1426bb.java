package com.sec.chaton.p027e;

import com.sec.common.util.C3364o;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bb */
/* loaded from: classes.dex */
public interface InterfaceC1426bb {

    /* renamed from: a */
    public static final String f5296a = C3364o.m11849a("CREATE INDEX ", "msg_server_no_index", " ON ", "message", " (", "message_sever_id", ",", "message_inbox_no", ",", "message_sender", ");");

    /* renamed from: b */
    public static final String f5297b = C3364o.m11849a("CREATE INDEX ", "msg_inbox_no_index_1", " ON ", "message", " (", "message_inbox_no", ",", "message_is_truncated", ");");

    /* renamed from: c */
    public static final String f5298c = C3364o.m11849a("CREATE INDEX ", "msg_inbox_no_index_2", " ON ", "message", " (", "message_inbox_no", ",", "message_content_type", ");");

    /* renamed from: d */
    public static final String f5299d = C3364o.m11849a("CREATE INDEX ", "participants_inbox_no_index", " ON ", "participant", " (", "participants_inbox_no", ");");
}
