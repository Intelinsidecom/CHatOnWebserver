package com.sds.coolots.common.controller;

import com.sds.coolots.common.framework.AirGestureSettingDataInterface;
import com.sds.coolots.common.framework.AlertWhenRingingSettingDataInterface;
import com.sds.coolots.common.framework.BTAudioStreamSettingDataInterface;
import com.sds.coolots.common.framework.BTConnectivitySettingDataInterface;
import com.sds.coolots.common.framework.BargeInSettingDataInterface;
import com.sds.coolots.common.framework.BlockingModeSettingDataInterface;
import com.sds.coolots.common.framework.CPUBoostSettingDataInterface;
import com.sds.coolots.common.framework.CallAnswerHomeKeySettingDataInterface;
import com.sds.coolots.common.framework.CallEndPowerKeySettingDataInterface;
import com.sds.coolots.common.framework.ClearCoverSettingDataInterface;
import com.sds.coolots.common.framework.DrivingModeSettingDataInterface;
import com.sds.coolots.common.framework.DualCameraSettingDataInterface;
import com.sds.coolots.common.framework.FixedLCDFrameSettingDataInterface;
import com.sds.coolots.common.framework.ScreenShareSettingDataInterface;
import com.sds.coolots.common.framework.TTSAudioStreamSettingDataInterface;

/* loaded from: classes.dex */
public interface FrameworkConfigInterface {
    public static final int HONEYCOMB = 13;
    public static final int ICS = 15;

    /* renamed from: JB */
    public static final int f2918JB = 16;
    public static final int JBP = 17;

    AirGestureSettingDataInterface createAirGestureSettingDataInterface();

    AlertWhenRingingSettingDataInterface createAlertWhenRingingSettingDataInterface();

    BTAudioStreamSettingDataInterface createBTAudioStreamSettingDataInterface();

    BTConnectivitySettingDataInterface createBTConnectivitySettingDataInterface();

    BargeInSettingDataInterface createBargeInSettingDataInterface();

    BlockingModeSettingDataInterface createBlockingModeSettingDataInterface();

    CPUBoostSettingDataInterface createCPUBoostSettingDataInterface();

    CallAnswerHomeKeySettingDataInterface createCallAnswerHomeKeySettingDataInterface();

    CallEndPowerKeySettingDataInterface createCallEndPowerKeySettingDataInterface();

    ClearCoverSettingDataInterface createClearCoverSettingDataInterface();

    DrivingModeSettingDataInterface createDrivingModeSettingDataInterface();

    DualCameraSettingDataInterface createDualCameraSettingDataInterface();

    FixedLCDFrameSettingDataInterface createFixedLCDFrameSettingDataInterface();

    ScreenShareSettingDataInterface createScreenShareSettingDataInterface();

    TTSAudioStreamSettingDataInterface createTTSAudioStreamSettingDataInterface();
}
