package com.sds.coolots.call.model;

import android.graphics.Point;
import java.util.List;

/* loaded from: classes.dex */
public interface ShareScreenCallback {
    public static final int PAUSE_REASON_COMMAND = 0;
    public static final int PAUSE_REASON_EXTERNAL = 2;
    public static final int PAUSE_REASON_HOLD = 1;
    public static final int STOP_REASON_CALLEND = 1;
    public static final int STOP_REASON_COMMAND = 0;

    void onCallHoldState(boolean z);

    void onCallNotifyNetworkWeakReceive(int i);

    void onCallState(int i);

    void onConferenceMemberUpdate(List list);

    void onPauseShareScreen(int i);

    void onReceiveBoardData(String str, int i, byte[] bArr);

    void onResultCaptureImage(int i);

    void onResumeShareScreen(Point point, boolean z);

    void onSecureErrorForShareScreen();

    void onSecureModeEndForShareScreen();

    void onStartShareScreen(int i, int i2, String str, boolean z);

    void onStopShareScreen(int i);
}
