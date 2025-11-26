package com.coolots.p000fs.common.controller;

import com.sds.coolots.common.controller.ResourceInterface;

/* loaded from: classes.dex */
public interface ChatOnResourceInterface extends ResourceInterface {
    int getCallLogTypeReject();

    int getCallLogTypeVideoCall();

    int getCallLogTypeVoiceCall();

    int getDrawableSPPAlert();

    String getExtraVoipCallstate();

    int getHideMeDefaultLandscapeImage();

    int getHideMeDefaultPortraitImage();

    @Override // com.sds.coolots.common.controller.ResourceInterface
    int getRawConnected();

    @Override // com.sds.coolots.common.controller.ResourceInterface
    int getRawDisconnected();

    int getStringChangeToConferenceWait();

    int getStringChangeToP2PWait();

    int getStringLoginToServer();

    int getStringLowBattery();

    int getStringRecordStopPopup();

    int getUnknownUserString();
}
