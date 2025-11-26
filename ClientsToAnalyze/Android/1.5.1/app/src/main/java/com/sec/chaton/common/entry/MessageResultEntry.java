package com.sec.chaton.common.entry;

import com.sec.chaton.common.entry.ResultEntry;

/* loaded from: classes.dex */
public class MessageResultEntry extends ResultEntry {

    /* renamed from: d */
    private int f1313d;

    public enum errorCode {
        SUCCESS_RECEIVER_ERROR,
        RETRY,
        CHANGE_SERVER,
        FAIL,
        REGARD_SUCCEESS,
        NEED_HANDLE,
        BLOCK_RECEIVER,
        INVALID_USER,
        END_APP,
        RESTART_APP
    }

    public MessageResultEntry(boolean z, int i) {
        super(z);
        this.f1313d = i;
        this.f1326b = ResultEntry.Result.SUCCESS;
    }

    public MessageResultEntry(boolean z, int i, String str) {
        super(z, str);
        this.f1313d = i;
        this.f1326b = ResultEntry.Result.SUCCESS;
    }

    public MessageResultEntry(boolean z, ResultEntry.Result result) {
        super(z, result);
        this.f1313d = -1;
    }

    public MessageResultEntry(boolean z, ResultEntry.Result result, String str) {
        super(z, result, str);
        this.f1313d = -1;
    }

    /* renamed from: a */
    public int m1963a() {
        return this.f1313d;
    }
}
