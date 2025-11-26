package com.coolots.chaton.common.util;

import com.coolots.chaton.common.framework.ChatOnAirGestureSettingData;
import com.coolots.chaton.common.framework.ChatOnAlertWhenRingingSettingData;
import com.coolots.chaton.common.framework.ChatOnBTAudioStreamSettingData;
import com.coolots.chaton.common.framework.ChatOnBTConnectivitySettingData;
import com.coolots.chaton.common.framework.ChatOnBargeInSettingData;
import com.coolots.chaton.common.framework.ChatOnBlockingModeSettingData;
import com.coolots.chaton.common.framework.ChatOnCPUBoostSettingData;
import com.coolots.chaton.common.framework.ChatOnCallAnswerHomeKeySettingData;
import com.coolots.chaton.common.framework.ChatOnCallEndPowerKeySettingData;
import com.coolots.chaton.common.framework.ChatOnClearCoverSettingData;
import com.coolots.chaton.common.framework.ChatOnDrivingModeSettingData;
import com.coolots.chaton.common.framework.ChatOnDualCameraSettingData;
import com.coolots.chaton.common.framework.ChatOnFixedLCDFrameSettingData;
import com.coolots.chaton.common.framework.ChatOnScreenShareSettingData;
import com.coolots.chaton.common.framework.ChatOnTTSAudioStreamSettingData;
import com.sds.coolots.common.controller.FrameworkConfigInterface;
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
public class FrameworkConfig implements FrameworkConfigInterface {
    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public AirGestureSettingDataInterface createAirGestureSettingDataInterface() {
        return new ChatOnAirGestureSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public BargeInSettingDataInterface createBargeInSettingDataInterface() {
        return new ChatOnBargeInSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public DrivingModeSettingDataInterface createDrivingModeSettingDataInterface() {
        return new ChatOnDrivingModeSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public DualCameraSettingDataInterface createDualCameraSettingDataInterface() {
        return new ChatOnDualCameraSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public BTAudioStreamSettingDataInterface createBTAudioStreamSettingDataInterface() {
        return new ChatOnBTAudioStreamSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public BTConnectivitySettingDataInterface createBTConnectivitySettingDataInterface() {
        return new ChatOnBTConnectivitySettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public BlockingModeSettingDataInterface createBlockingModeSettingDataInterface() {
        return new ChatOnBlockingModeSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public CPUBoostSettingDataInterface createCPUBoostSettingDataInterface() {
        return new ChatOnCPUBoostSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public ClearCoverSettingDataInterface createClearCoverSettingDataInterface() {
        return new ChatOnClearCoverSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public FixedLCDFrameSettingDataInterface createFixedLCDFrameSettingDataInterface() {
        return new ChatOnFixedLCDFrameSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public ScreenShareSettingDataInterface createScreenShareSettingDataInterface() {
        return new ChatOnScreenShareSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public TTSAudioStreamSettingDataInterface createTTSAudioStreamSettingDataInterface() {
        return new ChatOnTTSAudioStreamSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public AlertWhenRingingSettingDataInterface createAlertWhenRingingSettingDataInterface() {
        return new ChatOnAlertWhenRingingSettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public CallAnswerHomeKeySettingDataInterface createCallAnswerHomeKeySettingDataInterface() {
        return new ChatOnCallAnswerHomeKeySettingData();
    }

    @Override // com.sds.coolots.common.controller.FrameworkConfigInterface
    public CallEndPowerKeySettingDataInterface createCallEndPowerKeySettingDataInterface() {
        return new ChatOnCallEndPowerKeySettingData();
    }
}
