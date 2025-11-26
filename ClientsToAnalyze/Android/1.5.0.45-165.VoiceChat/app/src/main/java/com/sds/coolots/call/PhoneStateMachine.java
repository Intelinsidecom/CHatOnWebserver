package com.sds.coolots.call;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Handler;
import com.sds.coolots.call.entitlement.IEntitlementResultListener;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.nego.NegoFeatureControllerInterface;
import com.sds.coolots.common.controller.translation.TranslationListManagerInterface;
import com.sds.coolots.common.controller.translation.TranslationManagerInterface;
import com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface;
import com.sds.coolots.common.controller.translation.data.C1250a;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.controller.translation.engine.ITTSController;
import com.sds.coolots.common.controller.translation.engine.RecognitionEngine;
import com.sds.coolots.common.controller.translation.engine.TranslatorEngine;
import com.sds.coolots.common.coolotsinterface.ISSOCallCallBack;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/* loaded from: classes.dex */
public interface PhoneStateMachine {
    public static final int COOLOTS_AUDIO_CALL = 3;
    public static final int COOLOTS_IDLE = 0;
    public static final int COOLOTS_VIDEO_CALL = 4;
    public static final int ERROR_ALREADY_RECORDING = -1015;
    public static final int ERROR_BUSY = -1011;
    public static final int ERROR_CANT_FIND_CALL_INSTANCE = -1024;
    public static final int ERROR_CANT_FIND_DESTINATION = -1012;
    public static final int ERROR_INVALID_CALLID = -1014;
    public static final int ERROR_INVALID_CALL_SATATE_FOR_END_CALL = -1106;
    public static final int ERROR_INVALID_CALL_SWITCH_STATE = -1018;
    public static final int ERROR_INVALID_CALL_TYPE = -1017;
    public static final int ERROR_INVALID_CHANGE_TO_CONFERENCE_ENGINE_RESPONSE = -1110;
    public static final int ERROR_INVALID_CHANGE_TO_CONFERENCE_STATE = -1021;
    public static final int ERROR_INVALID_CHANGE_TO_P2P = -1100;
    public static final int ERROR_INVALID_CHANGE_TO_P2P_DUPLICATED_REQUEST = -1105;
    public static final int ERROR_INVALID_CHANGE_TO_P2P_ENGINE_A_FAIL = -1103;
    public static final int ERROR_INVALID_CHANGE_TO_P2P_ENGINE_B_FAIL = -1102;
    public static final int ERROR_INVALID_CHANGE_TO_P2P_NOT_CONDITION = -1104;
    public static final int ERROR_INVALID_CHANGE_TO_P2P_UNKNOWN = -1101;
    public static final int ERROR_INVALID_CONSENT_STATE = -1026;
    public static final int ERROR_INVALID_P2PUSERINFO = -1107;
    public static final int ERROR_INVALID_PARAMETER = -1022;
    public static final int ERROR_INVALID_SHARE_SCREEN_STATE = -1023;
    public static final int ERROR_INVALID_SHARE_VIEW_STATE = -1019;
    public static final int ERROR_INVALID_STATE = -1013;
    public static final int ERROR_INVITE_BUDDY_CALL_CONSEND = -1031;
    public static final int ERROR_INVITE_BUDDY_CALL_SWITCHING = -1030;
    public static final int ERROR_INVITE_BUDDY_HOLD = -1032;
    public static final int ERROR_NOT_AVATAR_MODE = -1027;
    public static final int ERROR_NOT_DUAL_CAMERA_MODE = -1028;
    public static final int ERROR_NOT_INITIALIZED_ENGINE = -1001;
    public static final int ERROR_NOT_RECORDING = -1016;
    public static final int ERROR_NOT_SUPPORTED_NETWORK = -1020;
    public static final int ERROR_SUCCESS = 0;
    public static final int ERROR_UNKNOWN = -1002;
    public static final int MSG_PLAY_RING_BACK = 1;
    public static final int MSG_STOP_RING_BACK = 0;
    public static final int TELEPHONY_STATE_CALLING = 2;
    public static final int TELEPHONY_STATE_IDLE = 0;
    public static final int TELEPHONY_STATE_RINGING = 1;
    public static final int TELEPHONY_TYPE_UNKNOWN = 0;
    public static final int TELEPHONY_TYPE_VIDEO = 2;
    public static final int TELEPHONY_TYPE_VOICE = 1;

    int acceptConsent(Destination destination, boolean z);

    void addCallBack(CallStateCallBack callStateCallBack);

    void addCallTypeChangeCallback(CallTypeChangeCallback callTypeChangeCallback);

    int addConferenceMember(Destination destination, ArrayList arrayList, ArrayList arrayList2);

    void backupCallStateBeforNative(boolean z, boolean z2, boolean z3);

    void broadcastToCallStateCallBack(int i);

    int captureImage(Destination destination, String str);

    int captureMyImage(Destination destination, String str);

    int changeAvatarGlasses(Destination destination);

    int changeAvatarHair(Destination destination);

    void changeConferenceLayout(Destination destination, int i);

    boolean checkCellPhoneNumber(String str);

    void checkEntitlement(IEntitlementResultListener iEntitlementResultListener);

    void closeSTTTranslationTTS(boolean z);

    int connectCall(Destination destination, int i, boolean z, int i2, boolean z2, String str);

    int createCustomAvatar(Destination destination);

    void finishShareView(Destination destination, int i);

    Date getCallConnectedTime();

    Date getCallFirstStartTime();

    int getCallType();

    CallingInterface getCallingActivity();

    int getCurrentCoolotsPhoneState();

    int getCurrentMobileCallType();

    int getCurrentMobilePhoneState();

    int getDualCameraONCnt();

    Date getDualCameraStartedTime();

    int getHangupCode();

    boolean getHideState();

    NegoFeatureControllerInterface getNegoFeatureController();

    Set getRecognitionSupportedVoiceLanguage();

    ArrayList getRemoteInfoData(Destination destination);

    C1250a getTranslationList();

    TranslationListManagerInterface getTranslationListManager();

    TranslationManagerInterface getTranslationManager();

    TranslationNotificationManagerInterface getTranslationNotificationManager();

    Set getTranslationSupportedOutLanguage(int i);

    void hangUpCurrentCoolotsCall(int i);

    int holdCall(Destination destination);

    int initSTTTranslationTTS(RecognitionEngine recognitionEngine, TranslatorEngine translatorEngine, ITTSController iTTSController, Handler handler, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    int initSTTTranslationTTSLanguage(int i, int i2);

    boolean isActiveSTTTranslationTTS();

    int isActiveShareScreen();

    boolean isCallReceiveFromWatch();

    boolean isClearCoverOpen();

    boolean isCurrentCallOccupied();

    boolean isCurrentMobileCall();

    boolean isEarPhone();

    boolean isEntitlementWifiOnlyMode();

    boolean isHidemeBeforeNative();

    boolean isHoldBeforeNative();

    boolean isLiveShareCall();

    boolean isOutGoingCall();

    boolean isPlayHoldTone();

    boolean isRecording();

    boolean isThemeShotActive(int i, int i2);

    boolean isUseSpeakerBeforeNative();

    int localHangupCall(Destination destination, int i);

    void logout();

    void moveToTopForDelayAfter3G(CallStatusData callStatusData, boolean z);

    int muteCall(Destination destination);

    void notiToUserDisconnect();

    void notifyChangeCallType(boolean z);

    void notifyStopRingtone();

    void playTTS(TranslationDisplayData translationDisplayData);

    void registCallOutNumber(String str);

    void removeCallBack(CallStateCallBack callStateCallBack);

    void removeCallTypeChangeCallback(CallTypeChangeCallback callTypeChangeCallback);

    int removeConferenceMember(Destination destination, String str);

    void removeEveryCallBack();

    int requestConsent(Destination destination, int i, int i2);

    void resetBackupCallState();

    void sendCameraZoomInfo(int i);

    void sendDtmfTone(int i);

    void sendNotifyStartVideoRecord();

    void sendRejectMessage(String str, short s, String str2, String str3);

    void sendRotationInfo(Destination destination, int i, boolean z, boolean z2);

    void sendShareViewNotifyEnd(int i);

    void sendTranslateData(String str, String str2, int i);

    void setAudioPathInfo(Intent intent);

    void setCallingActivity(CallingInterface callingInterface);

    int setCameraZoomAction(Destination destination, int i);

    int setCartoonView(Destination destination, int i);

    void setClearCoverScreenLock(boolean z);

    void setDualCameraStartedTime(Date date);

    int setDualPosition(Destination destination, int i, int i2, int i3, int i4);

    void setEarPhone(boolean z);

    int setEmotionalAnimation(Destination destination, int i, boolean z);

    int setEmotionalEyeContact(boolean z);

    int setEnablePreview(Destination destination, int i);

    int setFaceEmotion(Destination destination, int i);

    int setOtherPartyName(Destination destination, String str);

    void setP2PTestInfo(String str, int i, int i2, boolean z);

    int setPreviewOutLineStatus(Destination destination, int i, int i2, int i3);

    int setRecognitionVoiceLanguage(int i);

    int setRender(Destination destination, int i, int i2);

    boolean setSSOCallCallback(ISSOCallCallBack iSSOCallCallBack);

    void setShowCallActivity(boolean z);

    int setThemeShot(Destination destination, int i, int i2, boolean z);

    void setUnHoldFor3GIdle(Destination destination, int i);

    int setUseNoiseReduction(Destination destination, boolean z);

    void showCallActivity(boolean z, boolean z2, boolean z3);

    int startAvatar(Destination destination);

    int startDualCamera(Destination destination, int i, int i2, int i3, int i4);

    int startFileTransfer(Destination destination, ArrayList arrayList);

    int startHideMeVideoCall(Destination destination, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z, boolean z2);

    int startOutGoingCall(Destination destination, boolean z, boolean z2, String str);

    void startOutgoingCallForEngine();

    void startPhoneStressTest(String str);

    void startPreventUMTSAlarm();

    int startRecognition();

    int startRecordCall(Destination destination, boolean z, String str);

    void startShareView(Destination destination);

    void startStressTest();

    boolean startTTSMode();

    int startTranslation(TranslationDisplayData translationDisplayData);

    int startVideoCall(Destination destination, Camera camera, int i, int i2);

    int stopAvatar(Destination destination);

    int stopDualCamera(Destination destination);

    int stopFileTransfer(Destination destination);

    int stopHideMeVideoCall(Destination destination);

    void stopPhoneStressTest();

    int stopRecognition();

    int stopRecordCall(Destination destination);

    void stopStressTest();

    boolean stopTTSMode();

    int stopVideoCall(Destination destination, Camera camera);

    int switchDualCameraMode(Destination destination, int i, int i2, int i3, int i4);

    int unHoldCall(Destination destination);

    int unMuteCall(Destination destination);

    void unregistCallOutNumber(String str);

    void updateCallInfo(CallStatusData callStatusData);

    void updateMobilePhoneState();
}
