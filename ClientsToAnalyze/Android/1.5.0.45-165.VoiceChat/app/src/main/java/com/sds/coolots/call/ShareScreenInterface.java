package com.sds.coolots.call;

import android.graphics.Point;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.ShareScreenCallback;

/* loaded from: classes.dex */
public interface ShareScreenInterface {
    int captureShareScreenImage(Destination destination, String str);

    int captureShareScreenOtherIamge(Destination destination, String str);

    Destination getCurrentCallDestination();

    String getOtherPartyName(Destination destination);

    String getRequesterID();

    void onShareScreenCaptureError(int i, boolean z);

    int pauseShareScreen(Destination destination, int i);

    int resumeShareScreen(Destination destination, Point point, boolean z);

    int sendBoardData(Destination destination, int i, byte[] bArr);

    int setModeChangeDuringShareScreen(Destination destination, int i);

    void setRequesterID(String str);

    int setShareScreenCallback(Destination destination, ShareScreenCallback shareScreenCallback);

    int startShareScreen(Destination destination, int i, int i2, String str);

    int stopShareScreen(Destination destination);
}
