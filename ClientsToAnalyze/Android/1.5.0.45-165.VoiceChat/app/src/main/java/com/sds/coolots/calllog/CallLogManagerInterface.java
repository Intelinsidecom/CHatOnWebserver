package com.sds.coolots.calllog;

import com.sds.coolots.calllog.model.ConfUser;

/* loaded from: classes.dex */
public interface CallLogManagerInterface {
    public static final int DONT_CARE = -1;
    public static final int METHOD_CONFERENCE_VIDEO = 11;
    public static final int METHOD_CONFERENCE_VOICE = 10;
    public static final int METHOD_P2P_VIDEO = 7;
    public static final int METHOD_P2P_VOICE = 6;
    public static final int METHOD_SIP_VIDEO = 9;
    public static final int METHOD_SIP_VOICE = 8;
    public static final int REJECT_MESSAGE = 12;
    public static final int TYPE_BLOCKED = 4;
    public static final int TYPE_INCOMING = 0;
    public static final int TYPE_MISSED = 2;
    public static final int TYPE_OUTGOING = 1;
    public static final int TYPE_PARTICIPANT = 5;
    public static final int TYPE_REJECTED = 3;

    int addCallLogCONFERENCE(int i, boolean z, String str, int i2, ConfUser confUser, int i3, long j, boolean z2, boolean z3, int i4);

    boolean addCallLogP2P(int i, boolean z, String str, int i2, String str2, String str3, String str4, String str5, int i3, String str6, boolean z2, boolean z3);

    boolean addCallLogSIP(int i, boolean z, String str, int i2, String str2, String str3, String str4, String str5, int i3, boolean z2);

    boolean addRejectMessage(String str, String str2, boolean z, String str3);

    void sendCallLogData(boolean z, int i);

    boolean updateCallLog(String str, String str2, int i);
}
