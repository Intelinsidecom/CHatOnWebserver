package com.sec.chaton.msgsend;

/* compiled from: MsgContract.java */
/* renamed from: com.sec.chaton.msgsend.r */
/* loaded from: classes.dex */
public enum EnumC2710r {
    CMD_UNKNOWN(-1),
    CMD_ADD_MSG(0),
    CMD_TRY_TO_SEND_MSG(2),
    CMD_LOAD_MSG(3),
    CMD_UPDATE_MSG(5),
    CMD_REMOVE_MSG(10),
    CMD_REMOVE_INBOX(11),
    CMD_REMOVE_ALL_MSG(12),
    CMD_PRINT_DEBUG(9999);


    /* renamed from: j */
    int f9716j;

    EnumC2710r(int i) {
        this.f9716j = i;
    }

    /* renamed from: a */
    int m11351a() {
        return this.f9716j;
    }

    /* renamed from: a */
    public static EnumC2710r m11350a(int i) {
        switch (i) {
            case 0:
                return CMD_ADD_MSG;
            case 2:
                return CMD_TRY_TO_SEND_MSG;
            case 3:
                return CMD_LOAD_MSG;
            case 5:
                return CMD_UPDATE_MSG;
            case 10:
                return CMD_REMOVE_MSG;
            case 11:
                return CMD_REMOVE_INBOX;
            case 12:
                return CMD_REMOVE_ALL_MSG;
            case 9999:
                return CMD_PRINT_DEBUG;
            default:
                return CMD_UNKNOWN;
        }
    }
}
