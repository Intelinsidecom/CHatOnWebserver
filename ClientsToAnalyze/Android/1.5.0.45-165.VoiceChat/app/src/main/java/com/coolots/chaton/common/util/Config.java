package com.coolots.chaton.common.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IVoIPInterface;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.PhoneNumberUtils;
import com.coolots.chaton.SECConfig;
import com.coolots.chaton.call.controller.ChatONBlueTooth;
import com.coolots.chaton.common.coolotsinterface.DormantMode;
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
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.chaton.common.view.EngineeringConfigActivity;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.view.layout.ListPreferenceMultiSelect;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.FrameworkConfigInterface;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.model.NationalCode;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.List;

/* loaded from: classes.dex */
public class Config implements ChatOnConfigInterface {
    private static final String CLASSNAME = "[ChatOnConfigInterface]";
    public FrameworkConfig mFrameworkConfig = null;
    public IVoIPInterface iVoIPInterface = null;
    private ConnectivityManager connectivityManager = null;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfilePasswd(String strValue) {
        ConfigActivity.setProfilePasswd(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setCallState(boolean isCalling) {
        ConfigActivity.setCallState(isCalling);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean getCallState() {
        return ConfigActivity.getCallState();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getSipIdSendOnly() {
        return ConfigActivity.getSipIdSendOnly();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getProfileUserID() {
        return ConfigActivity.getProfileUserID();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public long getProfileUserNo() {
        return ConfigActivity.getUserNo();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getProfileUserName() {
        return ConfigActivity.getProfileUserName();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getProfileRawPwd() {
        return ConfigActivity.getProfileRawPwd();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface, com.sds.coolots.common.controller.ConfigInterface
    public boolean getSDCardWritable(boolean bUpdate) {
        return ConfigActivity.getSDCardWritable(bUpdate);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileCountryCode(Integer strValue) {
        ConfigActivity.setProfileCountryCode(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfilePhoneNo(String strValue) {
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getProfilePhoneNo() {
        return "";
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileUserName(String strValue) {
        ConfigActivity.setProfileUserName(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getProfileImageUrl() {
        return ConfigActivity.getProfileImageUrl();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileImageUrl(String strValue) {
        ConfigActivity.setProfileImageUrl(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileUserID(String strValue) {
        ConfigActivity.setProfileUserID(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileSerialNo(String strValue) {
        ConfigActivity.setProfileSerialNo(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileDeviceID(Short shortValue) {
        ConfigActivity.setProfileDeviceID(shortValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileRawPwd(String strValue) {
        ConfigActivity.setProfileRawPwd(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileRawPwdCheck(boolean strValue) {
        ConfigActivity.setProfileRawPwdCheck(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isProfileRawPwdCheck() {
        return ConfigActivity.isProfileRawPwdCheck();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setUserNo(long nUserNo) {
        ConfigActivity.setUserNo(nUserNo);
    }

    public void setProfileUserNumber(String strValue) {
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileUserEmail(String strValue) {
        ConfigActivity.setProfileUserEmail(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileNickName(String strValue) {
        ConfigActivity.setProfileNickName(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setProfileNationalCode(String strValue) {
        ConfigActivity.setProfileNationalCode(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public Integer getProfileCountryCode() {
        return Integer.valueOf("82");
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void cleanSharedPreference(boolean bDeleteLoginInfo) {
        ConfigActivity.cleanSharedPreference(bDeleteLoginInfo);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getProfilePasswd() {
        return ConfigActivity.getProfilePasswd();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getProfileSerialNo() {
        return ConfigActivity.getProfileSerialNo();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public long getUserNo() {
        return ConfigActivity.getUserNo();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public Short getProfileDeviceID() {
        return ConfigActivity.getProfileDeviceID();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void deleteAllImg() {
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getModelName() {
        return "ChatON V";
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getFirmwareVersion() {
        return "ChatON V";
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getAppVersion() {
        return MainApplication.mPhoneManager.getAppVersion();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setAppVersion(String version) {
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setCallFwdCountryCode(String countryCode) {
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setCoolotsInNumber(String number) {
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setCallFwdOnOff(boolean setCallFwdWorking) {
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getCenterDomain() {
        return EngineeringConfigActivity.getCenterDomain();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getCenterDomainIP() {
        return EngineeringConfigActivity.getCenterDomainIP();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setCenterDomainIP(String strValue) {
        EngineeringConfigActivity.setCenterDomainIP(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getCenterPath() {
        return EngineeringConfigActivity.getCenterPath();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getFrameHeight(int framesize) {
        return EngineeringConfigActivity.getFrameHeight(framesize);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getFrameWidth(int framesize) {
        return EngineeringConfigActivity.getFrameWidth(framesize);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getQFactor() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setSipIdSendOnly(String strValue) {
        ConfigActivity.setSipIdSendOnly(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setSearchable(boolean searchable) {
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isUseFrontCameraForOutGoingCall() {
        return true;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isUseFrontCameraForReceiveCall() {
        return true;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getCallFrameSize(boolean isFrontCamera) {
        return EngineeringConfigActivity.getCallFrameSize(isFrontCamera);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getCallFrameRate() {
        return EngineeringConfigActivity.getCallFrameRate();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getCallBandWidth() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getVoiceCodec() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getNS() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getAEC() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getVAD() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getFEC() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getAudioRecordBufferSize() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getAudioTrackBufferSize() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getAudioSampleRate() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getAudioDelay() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public float getSpeakerModeMicGain() {
        return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getSpeakerModeAgcValue() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public float getNormalModeMicGain() {
        return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getNormalModeAgcValue() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getMicVolume() {
        return 0;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getSipDestPort() {
        return SECConfig.getSipDestPort();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public float getAudioVolume() {
        return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public float getNormalModeMicGainAfterAEC() {
        return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public float getSpeakerModeMicGainAfterAEC() {
        return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getEventTraceDatabaseName() {
        return "data/data/com.sds.coolots/databases/evtTrace.db";
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isUseFrontCameraForOutGoingCallNow() {
        return true;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isUseFrontCameraForReceiveCallNow() {
        return true;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setAuthID(String strValue) {
        ConfigActivity.setAuthID(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getAuthID() {
        return ConfigActivity.getAuthID();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getNationalCodeVersion() {
        return ConfigActivity.getNationalCodeVersion();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setNationalCodeVersion(String strValue) {
        ConfigActivity.setNationalCodeVersion(strValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int setSAESVEConfigData(int mode) {
        return SECConfig.setSAESVEConfigData(mode);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setBackupJoinUserID(String userID) {
        EngineeringConfigActivity.setBackupJoinUserID(userID);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setBackupJoinCountryCode(String countryCode) {
        EngineeringConfigActivity.setBackupJoinCountryCode(countryCode);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getBackupJoinUserID() {
        return EngineeringConfigActivity.getBackupJoinUserID();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getBackupJoinCountryCode() {
        return EngineeringConfigActivity.getBackupJoinCountryCode();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getChatonSerialNumber() {
        return EngineeringConfigActivity.getChatonSerialNumber();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public boolean isAlwaysStartService() {
        return false;
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public boolean isAbsentcallNoti() {
        return true;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isSecureCommunication() {
        return false;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isEmotionalEyeContact() {
        return false;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void notifyNewAppVersion() {
        Log.m2958e("<<CONFIG>> notifyNewAppVersion IS CALLED!!!!!!!");
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setBackupLinkAccount(String account) {
        EngineeringConfigActivity.setBackupLinkUserID(account);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setBackupLinkCountryCode(String countryCode) {
        EngineeringConfigActivity.setBackupLinkCountry(countryCode);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setBackupLinkPhoneNo(String phoneNo) {
        EngineeringConfigActivity.setBackupLinkPhoneNo(phoneNo);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setBackupLinkUserName(String userName) {
        EngineeringConfigActivity.setBackupLinkUserName(userName);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setBackupLinkEmail(String email) {
        EngineeringConfigActivity.setBackupLinkEmail(email);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getBackupLinkAccount() {
        return EngineeringConfigActivity.getBackupLinkUserID();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getBackupLinkCountryCode() {
        return EngineeringConfigActivity.getBackupJoinCountryCode();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getBackupLinkPhoneNo() {
        return EngineeringConfigActivity.getBackupLinkPhoneNo();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getBackupLinkUserName() {
        return EngineeringConfigActivity.getBackupLinkUserName();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getBackupLinkEmail() {
        return EngineeringConfigActivity.getBackupLinkEmail();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setSamsungAccount(String account) {
        ConfigActivity.setSamsungAccountID(account);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getSamsungAccount() {
        return ConfigActivity.getSamsungAccountID();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setSamsungAccountUserNo(Long userNo) {
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public Long getSamsungAccountUserNo() {
        return 0L;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setConferenceCallMaxPeopleNum(boolean isVideo, int maxNum) {
        if (isVideo) {
            ConfigActivity.setVideoConferenceCallMaxPeopleNum(maxNum);
        } else {
            ConfigActivity.setVoiceConferenceCallMaxPeopleNum(maxNum);
        }
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getConferenceCallMaxPeopleNum(boolean isVideo) {
        int maxNum;
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            maxNum = isVideo ? ConfigActivity.getVideoConferenceCallMaxPeopleNum() : ConfigActivity.getVoiceConferenceCallMaxPeopleNum();
        } else if (MainApplication.mPhoneManager.isConfTest()) {
            maxNum = isVideo ? 10 : 10;
        } else {
            maxNum = (!EngineeringConfigActivity.isDemoVersion() || isVideo) ? 3 : 10;
        }
        logI("getConferenceCallMaxPeopleNum(" + isVideo + "): " + maxNum);
        return maxNum;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getConferenceCallMaxPeopleNum() {
        return 3;
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public int getConferenceCallMaxPeopleNumP2PConf(boolean isVideo) {
        return isVideo ? 4 : 10;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int jniReplaceImage(int session_id, int is_replace, Object byteBuffer, int width, int height, int orientation, int hideMeModeType, int isAutoRotate) {
        return SECConfig.jniReplaceImage(session_id, is_replace, byteBuffer, width, height, orientation, hideMeModeType, isAutoRotate);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getE164PhoneNumber(String phoneNumber) {
        logE("<<YHT43>> profile national code:" + ConfigActivity.getSamsungAccountCountryCode());
        NationalCode code = MainApplication.mPhoneManager.getConfigManager().getNationaCodeFromIso2(ConfigActivity.getSamsungAccountCountryCode());
        String countryCode = "KR";
        if (code != null) {
            countryCode = code.getIso2();
        }
        return PhoneNumberUtils.formatNumberToE164(phoneNumber, countryCode);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getNormalizedPhoneNumber(String phoneNumber) {
        return PhoneNumberUtils.normalizeNumber(phoneNumber);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getCipherKey() {
        return EngineeringConfigActivity.getCipherKey();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public byte[] getDecodedCipherKey() {
        return EngineeringConfigActivity.getDecodedCipherKey();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getSessionID() {
        return EngineeringConfigActivity.getSessionID();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setCipherKey(String cipherKey) {
        EngineeringConfigActivity.setCipherKey(cipherKey);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setSessionID(String sessionID) {
        EngineeringConfigActivity.setSessionID(sessionID);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getBTAudioPathActionName() {
        return ChatONBlueTooth.BR_ACTION_AUDIO_STATE;
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getBTConnectActionName() {
        return ChatONBlueTooth.BR_ACTION_CONNECTION;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getMasterCenterDomain() {
        return EngineeringConfigActivity.getMasterCenterDomain();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setLocalCenterDomain(String centerDomain) {
        EngineeringConfigActivity.setLocalCenterDomain(centerDomain);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setVoIPInCallAlert(boolean value) {
        logE("setVoIPInCallAlert(" + value + ")");
        if (this.iVoIPInterface == null) {
            this.iVoIPInterface = IVoIPInterface.Stub.asInterface(ServiceManager.checkService("voip"));
        }
        if (this.iVoIPInterface == null) {
            logE("mIVoIPInterface == null");
            return;
        }
        try {
            this.iVoIPInterface.setVoIPInCallAlert(value);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setServicePolicyInfoEnableVoice(boolean enable) {
        EngineeringConfigActivity.setServicePolicyInfoEnableVoice(enable);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setServicePolicyInfoEnableVideo(boolean enable) {
        EngineeringConfigActivity.setServicePolicyInfoEnableVideo(enable);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean getServicePolicyInfoEnableVoice() {
        return EngineeringConfigActivity.getServicePolicyInfoEnableVoice();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean getServicePolicyInfoEnableVideo() {
        return EngineeringConfigActivity.getServicePolicyInfoEnableVideo();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isUseProximity() {
        return ChatONSettingData.getInstance().isUseProximity();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isUseWifiOnly() {
        return ChatONSettingData.getInstance().isUseWifiOnly();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isDormantMode() {
        return DormantMode.isDormantMode(MainApplication.mContext);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isPlayRingTone() {
        return true;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isPlayRingBackTone() {
        return true;
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public int getInitBitrate(boolean isConference) {
        return SECConfig.getInitVideoBirtate(isConference);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isUseBuddySuggestion() {
        return ChatONSettingData.getInstance().isUseBuddySuggestion();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isUseExcludeMe() {
        return ChatONSettingData.getInstance().isUseExcludeMe();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isBTTethering() {
        if (this.connectivityManager == null) {
            this.connectivityManager = (ConnectivityManager) MainApplication.mContext.getSystemService("connectivity");
        }
        NetworkInfo activeNetworkInfo = this.connectivityManager.getNetworkInfo(7);
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getCallHangupType() {
        return (!MainApplication.mPhoneManager.IsLinkagewithChatON() && EngineeringConfigActivity.isDemoVersion()) ? 1 : 2;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isHostInviteOnly() {
        return MainApplication.mPhoneManager.IsLinkagewithChatON() || EngineeringConfigActivity.isDemoVersion() || MainApplication.mPhoneManager.isConfTest();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setSMSAuthNumber(String authNo) {
        ConfigActivity.setSMSAuthNumber(authNo);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getSMSAuthNumber() {
        return ConfigActivity.getSMSAuthNumber();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setSMSAuthCountryCode(String authCountry) {
        ConfigActivity.setSMSAuthCountryCode(authCountry);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getSMSAuthCountryCode() {
        return ConfigActivity.getSMSAuthCountryCode();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public List<Boolean> parseStoredValueMultiSelectPopup(String rawval, List<Boolean> defaultValue) {
        return ListPreferenceMultiSelect.parsePreferenceValue(rawval, defaultValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isChangeToP2PCall() {
        return !MainApplication.mPhoneManager.isConfTest();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getSamsungAccountID() {
        return ConfigActivity.getSamsungAccountID();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void clearCoolotsPref() {
        ConfigActivity.clearCoolotsPref();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void resetPrefValues() {
        ConfigActivity.resetPrefValues();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getDeviceMACAddress() {
        return EngineeringConfigActivity.getDeviceMACAddress();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getDeviceUniqueKey() {
        return String.valueOf(getProfileSerialNo()) + getDeviceMACAddress();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setSamsungAccountGUID(String SAGUID) {
        ConfigActivity.setSamsungAccountGUID(SAGUID);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getSamsungAccountGUID() {
        return ConfigActivity.getSamsungAccountGUID();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setSamsungAccountCountryCode(String ISO2Code) {
        ConfigActivity.setSamsungAccountCountryCode(ISO2Code);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getSamsugnAccoutCountryCode() {
        return ConfigActivity.getSamsungAccountCountryCode();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setSamsungAccountBirthday(String birthday) {
        ConfigActivity.setSamsungAccountBirthDay(birthday);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getSamsungAccountBirthday() {
        return ConfigActivity.getSamsungAccountBirthDay();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setChatONUserNO(String chatONNO) {
        ConfigActivity.setChatONNo(chatONNO);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public String getChatONUserNO() {
        return ConfigActivity.getChatONNo();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setChatONUID(String chatONUID) {
        ConfigActivity.setChatONUID(chatONUID);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getChatONUID() {
        return ConfigActivity.getChatONUID();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public boolean isCheckShareScreenChangeVoice() {
        logI("Config isCheckShareScreenChangeVoice(): " + ConfigActivity.isCheckShareScreenChangeVoice());
        return ConfigActivity.isCheckShareScreenChangeVoice();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public boolean isShareScreenCopyRight() {
        logI("Config isShareScreenCopyRight(): " + ConfigActivity.isShareScreenCopyRight());
        return ConfigActivity.isShareScreenCopyRight();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setCheckShareScreenChangeVoice(boolean value) {
        ConfigActivity.setCheckShareScreenChangeVoice(value);
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public void setShareScreenCopyRight(boolean value) {
        ConfigActivity.setShareScreenCopyRight(value);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setCallDataSendInterval(int intValue) {
        ConfigActivity.setCallDataSendInterval(intValue);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public int getCallDataSendInterval() {
        return ConfigActivity.getCallDataSendInterval();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isApplyEntitlement() {
        return true;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isApplyATNTWifiOnly() {
        return false;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setFrameworkConfig(FrameworkConfigInterface frameworkConfig) {
        this.mFrameworkConfig = (FrameworkConfig) frameworkConfig;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isAirGesture() {
        ChatOnAirGestureSettingData instance = (ChatOnAirGestureSettingData) this.mFrameworkConfig.createAirGestureSettingDataInterface();
        return instance.isAirGesture();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isBargeIn() {
        ChatOnBargeInSettingData instance = (ChatOnBargeInSettingData) this.mFrameworkConfig.createBargeInSettingDataInterface();
        return instance.isBargeIn();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isDrivingMode() {
        ChatOnDrivingModeSettingData instance = (ChatOnDrivingModeSettingData) this.mFrameworkConfig.createDrivingModeSettingDataInterface();
        return instance.isDrivingMode();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isDualCamera() {
        ChatOnDualCameraSettingData instance = (ChatOnDualCameraSettingData) this.mFrameworkConfig.createDualCameraSettingDataInterface();
        return instance.isDualCamera();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isBTAudioStream() {
        ChatOnBTAudioStreamSettingData instance = (ChatOnBTAudioStreamSettingData) this.mFrameworkConfig.createBTAudioStreamSettingDataInterface();
        return instance.isBTAudioStream();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isBTConnectivity() {
        ChatOnBTConnectivitySettingData instance = (ChatOnBTConnectivitySettingData) this.mFrameworkConfig.createBTConnectivitySettingDataInterface();
        return instance.isBTConnectivity();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isBlockingMode() {
        ChatOnBlockingModeSettingData instance = (ChatOnBlockingModeSettingData) this.mFrameworkConfig.createBlockingModeSettingDataInterface();
        return instance.isBlockingMode();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isCPUBoost() {
        ChatOnCPUBoostSettingData instance = (ChatOnCPUBoostSettingData) this.mFrameworkConfig.createCPUBoostSettingDataInterface();
        return instance.isCPUBoost();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isClearCover() {
        ChatOnClearCoverSettingData instance = (ChatOnClearCoverSettingData) this.mFrameworkConfig.createClearCoverSettingDataInterface();
        return instance.isClearCover();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isFixedLCDFrame() {
        ChatOnFixedLCDFrameSettingData instance = (ChatOnFixedLCDFrameSettingData) this.mFrameworkConfig.createFixedLCDFrameSettingDataInterface();
        return instance.isFixedLCDFrame();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isScreenShare() {
        ChatOnScreenShareSettingData instance = (ChatOnScreenShareSettingData) this.mFrameworkConfig.createScreenShareSettingDataInterface();
        return instance.isScreenShare();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isTTSAudioStream() {
        ChatOnTTSAudioStreamSettingData instance = (ChatOnTTSAudioStreamSettingData) this.mFrameworkConfig.createTTSAudioStreamSettingDataInterface();
        return instance.isTTSAudioStream();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isAlertWhenRinging() {
        ChatOnAlertWhenRingingSettingData instance = (ChatOnAlertWhenRingingSettingData) this.mFrameworkConfig.createAlertWhenRingingSettingDataInterface();
        return instance.isAlertWhenRinging();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isCallAnswerHomeKey() {
        ChatOnCallAnswerHomeKeySettingData instance = (ChatOnCallAnswerHomeKeySettingData) this.mFrameworkConfig.createCallAnswerHomeKeySettingDataInterface();
        return instance.isCallAnswerHomeKey();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean isCallEndPowerKey() {
        ChatOnCallEndPowerKeySettingData instance = (ChatOnCallEndPowerKeySettingData) this.mFrameworkConfig.createCallEndPowerKeySettingDataInterface();
        return instance.isCallEndPowerKey();
    }

    @Override // com.coolots.chaton.common.util.ChatOnConfigInterface
    public boolean isSkipRestrictAccessCheck() {
        return false;
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getGCMPushRegID() {
        return EngineeringConfigActivity.getGCMPushRegID();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public boolean getLoginSuccess() {
        return EngineeringConfigActivity.getLoginSuccess();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getNonce() {
        return EngineeringConfigActivity.getNonce();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public long getNonceExpiredTime() {
        return EngineeringConfigActivity.getNonceExpiredTime();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public String getSPPPushRegID() {
        return EngineeringConfigActivity.getSPPPushRegID();
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setGCMPUSHRegID(String regID) {
        EngineeringConfigActivity.setGCMPUSHRegID(regID);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setLoginSuccess(boolean success) {
        EngineeringConfigActivity.setLoginSuccess(success);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setNoce(String nonce) {
        EngineeringConfigActivity.setNonce(nonce);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setNonceExpiredTime(long time) {
        EngineeringConfigActivity.setNonceExpiredTime(time);
    }

    @Override // com.sds.coolots.common.controller.ConfigInterface
    public void setSPPPUSHRegID(String regID) {
        EngineeringConfigActivity.setSPPPUSHRegID(regID);
    }
}
