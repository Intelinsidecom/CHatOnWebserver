package com.sds.coolots.call;

/* loaded from: classes.dex */
public interface CallFunctionControllerInterface {
    public static final int TO_VIDEO_CALL = 2;
    public static final int TO_VOICE_CALL = 1;

    int getCallSwitchingProcessing();

    boolean isEnableConsentProcessing();

    boolean isEnableInviteProcessing();

    boolean isInviteProcessing();

    boolean isPrepareChageToConf();

    boolean isRecordingProcessing();

    boolean isShareCameraProcessing();

    boolean isShareScreenProcessing();

    void setCallSwitchingProcessing(int i);

    void setInviteProcessing(boolean z);

    void setPrepareChageToConf(boolean z);

    void setRecordingProcessing(boolean z);

    void setShareCameraProcessing(boolean z);

    void setShareScreenProcessing(boolean z);
}
