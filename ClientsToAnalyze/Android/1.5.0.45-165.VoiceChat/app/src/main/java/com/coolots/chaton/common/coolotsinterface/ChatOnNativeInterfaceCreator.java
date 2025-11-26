package com.coolots.chaton.common.coolotsinterface;

import com.coolots.chaton.call.controller.ChatONBlueTooth;
import com.coolots.chaton.call.controller.ChatONDrivingMode;
import com.sds.coolots.calllog.NativeCallLogInterface;
import com.sds.coolots.common.controller.audiopath.BlueToothControllerInterface;
import com.sds.coolots.common.controller.audiopath.DrivingModeControllerInterface;
import com.sds.coolots.common.coolotsinterface.MobilePhoneStateInterface;
import com.sds.coolots.common.coolotsinterface.MotionListener;
import com.sds.coolots.common.coolotsinterface.NativeCallInterface;
import com.sds.coolots.common.coolotsinterface.NativeInterfaceCreator;
import com.sds.coolots.common.coolotsinterface.NativeWindowControllerInterface;
import com.sds.coolots.common.coolotsinterface.VoipStateController;

/* loaded from: classes.dex */
public class ChatOnNativeInterfaceCreator implements NativeInterfaceCreator {
    @Override // com.sds.coolots.common.coolotsinterface.NativeInterfaceCreator
    public VoipStateController createVoipStateController() {
        return new ChatOnVoipStateController();
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeInterfaceCreator
    public MotionListener createMotionListener() {
        return new ChatOnMotionListener();
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeInterfaceCreator
    public NativeCallInterface createNativeCallInterface() {
        return new ChatOnNativeCallController();
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeInterfaceCreator
    public MobilePhoneStateInterface createMobilePhoneState() {
        return new MobilePhoneState();
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeInterfaceCreator
    public NativeWindowControllerInterface createNativeWindowController() {
        return new NativeWindowController();
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeInterfaceCreator
    public BlueToothControllerInterface createBlueToothController() {
        return new ChatONBlueTooth();
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeInterfaceCreator
    public NativeCallLogInterface createNativeCallLogInterface() {
        return new ChatONNativeCallLog();
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeInterfaceCreator
    public DrivingModeControllerInterface createDrivingModeController() {
        return new ChatONDrivingMode();
    }
}
