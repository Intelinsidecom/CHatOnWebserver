package com.sds.coolots.common.coolotsinterface;

import com.sds.coolots.calllog.NativeCallLogInterface;
import com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface;
import com.sds.coolots.common.controller.audiopath.DrivingModeControllerInterface;

/* loaded from: classes.dex */
public interface NativeInterfaceCreator {
    BlueToothControllerInterface createBlueToothController();

    DrivingModeControllerInterface createDrivingModeController();

    MobilePhoneStateInterface createMobilePhoneState();

    MotionListener createMotionListener();

    NativeCallInterface createNativeCallInterface();

    NativeCallLogInterface createNativeCallLogInterface();

    NativeWindowControllerInterface createNativeWindowController();

    VoipStateController createVoipStateController();
}
