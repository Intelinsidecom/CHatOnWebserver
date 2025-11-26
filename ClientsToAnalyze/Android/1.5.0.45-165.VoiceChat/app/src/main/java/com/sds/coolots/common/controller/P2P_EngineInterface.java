package com.sds.coolots.common.controller;

import android.hardware.Camera;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.sds.coolots.call.model.C1189D;
import com.sds.coolots.common.controller.translation.TranslationNotificationCallbackInterface;
import java.util.List;

/* loaded from: classes.dex */
public interface P2P_EngineInterface {
    int changeAvatarGlasses(boolean z, int i);

    int changeAvatarHair(boolean z, int i);

    void changeToConference(int i, String str, String str2);

    void changeToP2P(int i, String str, int i2, String str2, Object[] objArr);

    void clearAllPeerChannel();

    int createCustomAvatar(boolean z, int i);

    void destrotyRenderer();

    long[] getCallDataTraffic();

    EngineCallBackInterface getEngineCallback();

    TranslationNotificationCallbackInterface getEngineTranslationCallback();

    int hangUpCall(int i, int i2, String str);

    int hangUpSIPCall(int i);

    int holdCall(int i, boolean z);

    int holdSIPCall(int i, boolean z);

    int holdVideoCall(int i, boolean z);

    int holdVideoSIPCall(int i, boolean z);

    void onRender();

    void pauseShareScreen(int i, boolean z);

    int placeCall(String str, boolean z, boolean z2, boolean z3, String str2);

    int placeP2PCall(List list, boolean z, boolean z2, List list2, String str, boolean z3);

    int placeSIPCall(String str, boolean z);

    int receiveCall(int i, boolean z, boolean z2);

    int receiveSIPCall(int i, boolean z);

    void releaseCamera(Camera camera);

    int removeP2PConfMember(int i, String str);

    int reqSendTranslateData(int i, String str, String str2, int i2);

    void resumeShareScreen(int i, boolean z);

    void sendCameraZoomInfo(int i, int i2);

    int sendDtmfTone(int i, int i2, int i3);

    void sendDummyPacket();

    int sendPushMessage(MsgHeader msgHeader, MsgBody msgBody);

    int sendPushMessageByP2P(int i, MsgHeader msgHeader, MsgBody msgBody);

    int sendPushMessageByP2P(int i, MsgHeader msgHeader, MsgBody msgBody, String str);

    void sendRXMute(int i, boolean z, boolean z2);

    void sendRotationInfo(int i, int i2, boolean z, boolean z2);

    void sendRotationInfoForConferenceCall(int i, int i2, boolean z, boolean z2);

    void setCamera(Camera camera);

    int setCameraZoomAction(int i, int i2);

    int setCartoonView(int i, boolean z, int i2);

    int setDualPosition(int i, int i2, int i3, int i4, int i5);

    int setEmotionalAnimation(int i, boolean z, int i2, boolean z2);

    int setEmotionalEyeContact(boolean z);

    int setEnablePreview(int i);

    void setEngineCallback(EngineCallBackInterface engineCallBackInterface);

    void setEngineChattingCallback(EngineChattingCallbackInterface engineChattingCallbackInterface);

    void setEngineContactCallback(EngineContactCallbackInterface engineContactCallbackInterface);

    void setEngineLoginCallback(EngineLoginCallbackInterface engineLoginCallbackInterface);

    void setEngineSettingCallback(EngineSettingCallbackInterface engineSettingCallbackInterface);

    void setEngineTranslationCallback(TranslationNotificationCallbackInterface translationNotificationCallbackInterface);

    int setFaceEmotion(int i, boolean z, int i2);

    void setMicMute(boolean z, boolean z2, int i);

    void setModeChangeDuringShareScreen(int i, boolean z, int i2);

    int setNoiseReduction(int i, boolean z, boolean z2);

    void setRenderer(int i, int i2);

    int setThemeShot(int i, boolean z, int i2, boolean z2);

    void setVideoFormat(int i, int i2, int i3);

    int speakerOn(boolean z);

    int startAvatar(boolean z, int i);

    void startCamera();

    int startConference(C1189D c1189d, String str, String str2, String str3, String str4, boolean z, String str5, int i, int i2, String str6, boolean z2);

    void startConferenceBilling(int i);

    void startConferenceShareCameraParticipant(int i);

    int startDualCamera(int i, int i2, int i3, int i4, int i5);

    void startRecordCall(int i, boolean z, boolean z2, String str);

    void startShareScreen(int i, int i2, int i3, boolean z);

    int stopAvatar(boolean z, int i);

    void stopCamera();

    void stopConferenceShareCameraParticipant(int i);

    int stopDualCamera(int i);

    void stopRecordCall(int i, boolean z);

    void stopShareScreen(int i, boolean z);

    int switchDualCamera(int i, int i2, int i3, int i4, int i5);
}
