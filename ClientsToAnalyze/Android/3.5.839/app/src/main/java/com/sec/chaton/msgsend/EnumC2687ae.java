package com.sec.chaton.msgsend;

import com.p137vk.sdk.api.VKError;

/* compiled from: MsgSendResultCode.java */
/* renamed from: com.sec.chaton.msgsend.ae */
/* loaded from: classes.dex */
public enum EnumC2687ae {
    NOTHING_TODO(0),
    EMPTY_ROOM(1),
    REQ_PREVIOUS_IN_PROGRESS(20),
    REQ_INIT_CHAT(10),
    REQ_ALLOW_CHAT(11),
    REQ_SERIAL_CHAT_WAIT(12),
    REQ_SEND_SUCCESS_ALL(100),
    UNDETERMINED_STATUS(-99),
    DOES_NOT_EXIST_ROOM(-100),
    IS_NOT_VALID_ROOM(VKError.VK_API_ERROR);


    /* renamed from: k */
    private int f9643k;

    EnumC2687ae(int i) {
        this.f9643k = i;
    }
}
