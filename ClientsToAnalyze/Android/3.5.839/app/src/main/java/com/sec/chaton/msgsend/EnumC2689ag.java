package com.sec.chaton.msgsend;

/* compiled from: MsgSendRetryReason.java */
/* renamed from: com.sec.chaton.msgsend.ag */
/* loaded from: classes.dex */
public enum EnumC2689ag {
    UNDETERMINED(-1),
    REASON_NEW_MSG_REQUESTED(0),
    REASON_LATEST_SENT_MSG_SUCCESS(1),
    REASON_LATEST_SENT_MSG_FAIL(2),
    REASON_LATEST_ALLOW_CHAT_SUCCESS(3),
    REASON_LATEST_ALLOW_CHAT_FAIL(4),
    REASON_LATEST_INIT_CHAT_SUCCESS(5),
    REASON_LATEST_INIT_CHAT_FAIL(6),
    REASON_LOADED_MSG_FROM_DB(100),
    REASON_NETWORK_CHANGED_ON(200),
    REASON_CHATON_STARTED(1000),
    REASON_MANUAL_REQUESTED(9999);


    /* renamed from: m */
    private int f9660m;

    EnumC2689ag(int i) {
        this.f9660m = i;
    }

    /* renamed from: a */
    public int m11295a() {
        return this.f9660m;
    }

    /* renamed from: a */
    public static EnumC2689ag m11294a(int i) {
        switch (i) {
            case 0:
                return REASON_NEW_MSG_REQUESTED;
            case 1:
                return REASON_LATEST_SENT_MSG_SUCCESS;
            case 2:
                return REASON_LATEST_SENT_MSG_FAIL;
            case 3:
                return REASON_LATEST_ALLOW_CHAT_SUCCESS;
            case 4:
                return REASON_LATEST_ALLOW_CHAT_FAIL;
            case 5:
                return REASON_LATEST_INIT_CHAT_SUCCESS;
            case 6:
                return REASON_LATEST_INIT_CHAT_FAIL;
            case 100:
                return REASON_LOADED_MSG_FROM_DB;
            case 200:
                return REASON_NETWORK_CHANGED_ON;
            case 1000:
                return REASON_CHATON_STARTED;
            case 9999:
                return REASON_MANUAL_REQUESTED;
            default:
                return UNDETERMINED;
        }
    }

    /* renamed from: b */
    public long m11296b() {
        switch (C2690ah.f9661a[m11294a(this.f9660m).ordinal()]) {
            case 1:
            case 2:
            case 4:
            case 6:
                return 50L;
            case 3:
                return 5000L;
            case 5:
                return 5000L;
            case 7:
                return 5000L;
            case 8:
                return 5000L;
            case 9:
                return 500L;
            case 10:
                return 3000L;
            case 11:
                return 300L;
            default:
                return 10000L;
        }
    }
}
