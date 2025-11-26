package com.coolots.chaton.common.controller;

import com.sds.coolots.common.controller.ResourceInterface;
import java.util.List;

/* loaded from: classes.dex */
public interface ChatOnResourceInterface extends ResourceInterface {
    int getCallLogTodaySeperator();

    int getCallLogTypeReject();

    int getCallLogTypeVideoCall();

    int getCallLogTypeVoiceCall();

    int getCallLogYesterdatSeperator();

    int getCallTypeCancelled();

    int getCallTypeMissed();

    int getCallTypeRejected();

    List<String> getDefaultRejectMsg();

    int getDrawableSPPAlert();

    String getExtraVoipCallstate();

    int getFavoriteTitle();

    int getGroupTitle();

    int getHideMeDefaultLandscapeImage();

    int getHideMeDefaultPortraitImage();

    int getJoinServerAccessErrorString();

    int getMeTitle();

    int getMissedCallIcon();

    @Override // com.sds.coolots.common.controller.ResourceInterface
    int getMissedCallTicker();

    @Override // com.sds.coolots.common.controller.ResourceInterface
    int getMissedCallTitle();

    @Override // com.sds.coolots.common.controller.ResourceInterface
    int getMissedCallsMsg();

    @Override // com.sds.coolots.common.controller.ResourceInterface
    int getMissedCallsTitle();

    int getNewTitle();

    @Override // com.sds.coolots.common.controller.ResourceInterface
    int getRawConnected();

    @Override // com.sds.coolots.common.controller.ResourceInterface
    int getRawDisconnected();

    @Override // com.sds.coolots.common.controller.ResourceInterface
    int getRawRingtone();

    @Override // com.sds.coolots.common.controller.ResourceInterface
    int getStatNotifyMissedCall();

    int getStringChangeToConferenceWait();

    int getStringChangeToP2PWait();

    int getStringLoginToServer();

    int getStringLowBattery();

    int getStringRecordStopPopup();

    int getUnknownUserString();
}
