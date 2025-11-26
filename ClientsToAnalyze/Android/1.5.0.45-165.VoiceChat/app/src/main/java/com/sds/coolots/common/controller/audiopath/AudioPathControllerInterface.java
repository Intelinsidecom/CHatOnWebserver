package com.sds.coolots.common.controller.audiopath;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: classes.dex */
public interface AudioPathControllerInterface {
    public static final int ACTION_BLUETOOTH_AUDIO_STATE_CHANGE_CONNECTED = 3;
    public static final int ACTION_BLUETOOTH_AUDIO_STATE_CHANGE_DISCONNECTED = 4;
    public static final int ACTION_BLUETOOTH_STATE_CHANGE_CONNECTED = 1;
    public static final int ACTION_BLUETOOTH_STATE_CHANGE_DISCONNECTED = 2;
    public static final int ACTION_CRADLE_PLUG = 7;
    public static final int ACTION_CRADLE_UNPLUG = 8;
    public static final int ACTION_EARPHONE_PLUG = 5;
    public static final int ACTION_EARPHONE_UNPLUG = 6;
    public static final int ACTION_NONE = 0;

    void addAction(IntentFilter intentFilter);

    int checkBRAction(Intent intent);

    void description(String str);

    void dispose();

    boolean getUIHandler();

    void handleShareScreen(boolean z);

    void initCallConnectedByBargeIn(boolean z);

    void initCallConnectedForWatch(boolean z, boolean z2);

    void initCallSwitching(boolean z);

    void initUIComponents(boolean z);

    boolean isBlueToothConnected();

    boolean isBlueToothOn();

    boolean isCarCradleConnected();

    boolean isDeskCradleConnected();

    boolean isEarPhonePlugged();

    boolean isInstalledWatchApp();

    boolean isSpeakerON();

    boolean isWatch();

    boolean onClickBlueToothButton();

    void onClickSpeakerButton();

    void setUIHandler(Handler handler);

    void updateSpeakerMode();
}
