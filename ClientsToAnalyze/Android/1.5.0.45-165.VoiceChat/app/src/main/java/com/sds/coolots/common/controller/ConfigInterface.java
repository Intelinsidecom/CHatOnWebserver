package com.sds.coolots.common.controller;

/* loaded from: classes.dex */
public interface ConfigInterface {
    public static final int CALL_HANGUP_SINARIO_1 = 1;
    public static final int CALL_HANGUP_SINARIO_2 = 2;
    public static final int CALL_HANGUP_SINARIO_3 = 3;

    void cleanSharedPreference(boolean z);

    void clearCoolotsPref();

    void deleteAllImg();

    int getAEC();

    String getAppVersion();

    int getAudioDelay();

    int getAudioRecordBufferSize();

    int getAudioSampleRate();

    int getAudioTrackBufferSize();

    float getAudioVolume();

    String getAuthID();

    int getCallBandWidth();

    int getCallDataSendInterval();

    int getCallFrameRate();

    int getCallFrameSize(boolean z);

    int getCallHangupType();

    boolean getCallState();

    String getCenterDomain();

    String getCenterDomainIP();

    String getCenterPath();

    String getChatONUID();

    String getCipherKey();

    int getConferenceCallMaxPeopleNum();

    int getConferenceCallMaxPeopleNum(boolean z);

    byte[] getDecodedCipherKey();

    String getDeviceUniqueKey();

    String getE164PhoneNumber(String str);

    String getEventTraceDatabaseName();

    int getFEC();

    String getFirmwareVersion();

    int getFrameHeight(int i);

    int getFrameWidth(int i);

    String getGCMPushRegID();

    boolean getLoginSuccess();

    String getMasterCenterDomain();

    int getMicVolume();

    String getModelName();

    int getNS();

    String getNationalCodeVersion();

    String getNonce();

    long getNonceExpiredTime();

    int getNormalModeAgcValue();

    float getNormalModeMicGain();

    float getNormalModeMicGainAfterAEC();

    String getNormalizedPhoneNumber(String str);

    Integer getProfileCountryCode();

    Short getProfileDeviceID();

    String getProfileImageUrl();

    String getProfilePasswd();

    String getProfilePhoneNo();

    String getProfileRawPwd();

    String getProfileSerialNo();

    String getProfileUserID();

    String getProfileUserName();

    long getProfileUserNo();

    int getQFactor();

    boolean getSDCardWritable(boolean z);

    String getSPPPushRegID();

    String getSamsungAccountID();

    boolean getServicePolicyInfoEnableVideo();

    boolean getServicePolicyInfoEnableVoice();

    String getSessionID();

    int getSipDestPort();

    String getSipIdSendOnly();

    int getSpeakerModeAgcValue();

    float getSpeakerModeMicGain();

    float getSpeakerModeMicGainAfterAEC();

    long getUserNo();

    int getVAD();

    int getVoiceCodec();

    boolean isAirGesture();

    boolean isAlertWhenRinging();

    boolean isApplyATNTWifiOnly();

    boolean isApplyEntitlement();

    boolean isBTAudioStream();

    boolean isBTConnectivity();

    boolean isBTTethering();

    boolean isBargeIn();

    boolean isBlockingMode();

    boolean isCPUBoost();

    boolean isCallAnswerHomeKey();

    boolean isCallEndPowerKey();

    boolean isChangeToP2PCall();

    boolean isClearCover();

    boolean isDormantMode();

    boolean isDrivingMode();

    boolean isDualCamera();

    boolean isEmotionalEyeContact();

    boolean isFixedLCDFrame();

    boolean isHostInviteOnly();

    boolean isPlayRingBackTone();

    boolean isPlayRingTone();

    boolean isProfileRawPwdCheck();

    boolean isScreenShare();

    boolean isSecureCommunication();

    boolean isTTSAudioStream();

    boolean isUseBuddySuggestion();

    boolean isUseExcludeMe();

    boolean isUseFrontCameraForOutGoingCall();

    boolean isUseFrontCameraForOutGoingCallNow();

    boolean isUseFrontCameraForReceiveCall();

    boolean isUseFrontCameraForReceiveCallNow();

    boolean isUseProximity();

    boolean isUseWifiOnly();

    int jniReplaceImage(int i, int i2, Object obj, int i3, int i4, int i5, int i6, int i7);

    void notifyNewAppVersion();

    void resetPrefValues();

    void setAppVersion(String str);

    void setAuthID(String str);

    void setCallDataSendInterval(int i);

    void setCallFwdCountryCode(String str);

    void setCallFwdOnOff(boolean z);

    void setCallState(boolean z);

    void setCenterDomainIP(String str);

    void setCipherKey(String str);

    void setConferenceCallMaxPeopleNum(boolean z, int i);

    void setCoolotsInNumber(String str);

    void setFrameworkConfig(FrameworkConfigInterface frameworkConfigInterface);

    void setGCMPUSHRegID(String str);

    void setLocalCenterDomain(String str);

    void setLoginSuccess(boolean z);

    void setNationalCodeVersion(String str);

    void setNoce(String str);

    void setNonceExpiredTime(long j);

    void setProfileCountryCode(Integer num);

    void setProfileDeviceID(Short sh);

    void setProfileImageUrl(String str);

    void setProfileNationalCode(String str);

    void setProfileNickName(String str);

    void setProfilePasswd(String str);

    void setProfilePhoneNo(String str);

    void setProfileRawPwd(String str);

    void setProfileRawPwdCheck(boolean z);

    void setProfileSerialNo(String str);

    void setProfileUserEmail(String str);

    void setProfileUserID(String str);

    void setProfileUserName(String str);

    int setSAESVEConfigData(int i);

    void setSPPPUSHRegID(String str);

    void setSearchable(boolean z);

    void setServicePolicyInfoEnableVideo(boolean z);

    void setServicePolicyInfoEnableVoice(boolean z);

    void setSessionID(String str);

    void setSipIdSendOnly(String str);

    void setUserNo(long j);
}
