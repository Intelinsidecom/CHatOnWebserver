package com.sds.coolots.common.controller.audiopath;

import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public interface BlueToothControllerInterface {
    void addAction(IntentFilter intentFilter);

    int checkBRAction(Intent intent);

    void findBlueToothState();

    boolean isBlueToothAudioStateConnected();

    boolean isBlueToothAudioStateDisconnected();

    boolean isBlueToothStateConnected();

    boolean isBlueToothStateDisconnected();

    boolean isConnectBlueTooth();

    boolean isInstalledWatchApp();

    boolean isUseBlueTooth();

    boolean isWatch();

    void setBlueToothState(boolean z);
}
