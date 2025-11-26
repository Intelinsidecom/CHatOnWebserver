package com.sds.coolots.calllog;

import com.sds.coolots.calllog.model.CallDataUsage;

/* loaded from: classes.dex */
public interface DataUsageManagerInterface {
    public static final int TO_VIDEO_CALL = 2;
    public static final int TO_VOICE_CALL = 1;

    long get3GTotalDU();

    CallDataUsage getCallDataUsageByPeriod(long j, long j2, boolean z);

    long getTotalDU();

    long getWifiTotalDU();

    void initDataUsageManager();

    boolean isProcessingDataReset();

    void notifyChangeDay();

    void notifyEndCall(boolean z, boolean z2, boolean z3);

    void notifyStartCall(int i);

    void notifySwitchCall(int i);

    void resetDU();

    void saveTotalDU(long j, boolean z, boolean z2);

    void setProcessingDataReset(boolean z);
}
