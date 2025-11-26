package com.sec.chaton.p057e;

import com.p137vk.sdk.api.VKApiConst;
import com.sec.common.util.C5052r;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bt */
/* loaded from: classes.dex */
public interface InterfaceC2274bt {

    /* renamed from: a */
    public static final String f8107a = C5052r.m19199a("CREATE INDEX ", "msg_server_no_index", " ON ", VKApiConst.MESSAGE, " (", "message_sever_id", ",", "message_inbox_no", ",", "message_sender", ");");

    /* renamed from: b */
    public static final String f8108b = C5052r.m19199a("CREATE INDEX ", "msg_inbox_no_index_1", " ON ", VKApiConst.MESSAGE, " (", "message_inbox_no", ",", "message_is_truncated", ");");

    /* renamed from: c */
    public static final String f8109c = C5052r.m19199a("CREATE INDEX ", "msg_inbox_no_index_2", " ON ", VKApiConst.MESSAGE, " (", "message_inbox_no", ",", "message_content_type", ");");

    /* renamed from: d */
    public static final String f8110d = C5052r.m19199a("CREATE INDEX ", "participants_inbox_no_index", " ON ", "participant", " (", "participants_inbox_no", ");");
}
