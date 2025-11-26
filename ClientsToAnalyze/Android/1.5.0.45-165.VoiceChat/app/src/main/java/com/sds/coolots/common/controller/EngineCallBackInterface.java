package com.sds.coolots.common.controller;

import com.coolots.p2pmsg.model.NotifyBoardDataAsk;
import com.coolots.p2pmsg.model.NotifyCloseCallAsk;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.NotifyFinishShareCameraAsk;
import com.coolots.p2pmsg.model.NotifyStartShareScreenAsk;
import com.coolots.p2pmsg.model.NotifyStopShareScreenAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.RejectMessageAsk;
import com.coolots.p2pmsg.model.ReqAddConferenceMemberAsk;
import com.coolots.p2pmsg.model.ReqAddConferenceMemberRep;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public interface EngineCallBackInterface {
    public static final int ERROR_NOT_ENOUGH_MEMORY_TO_WRITE = 4;
    public static final int ERROR_P2P_DISCONNECTED = 1;
    public static final int ERROR_REQ_CALL_FAIL = 0;
    public static final int P2P_CONNECTED = 1;
    public static final int P2P_NOT_CONNECTED = 0;
    public static final int RECORDING_FAIL = 6;
    public static final int SIP_RINGTONE_CUSTOM = 183;
    public static final int SIP_RINGTONE_NONE = 180;
    public static final int START_RECORDING = 5;

    boolean isMuteCall(int i);

    void onCallNotifyNetworkWeakReceive(int i);

    int onCameraError(int i);

    void onCameraStartErrorReceived();

    int onConferenceCloseAsk(String str);

    void onConferenceDenyEvent(String str);

    int onConferenceEnterAsk(String str, String str2);

    int onConferenceStatusAsk(String str);

    int onEngineDebugMsg(String str);

    int onError(int i, int i2);

    int onError(String str);

    int onHangUpCall(int i, int i2, String str);

    int onIncomingCall(int i, String str, short s, boolean z, boolean z2, boolean z3, boolean z4, String str2, Date date);

    int onIncomingP2PConfCall(int i, boolean z, boolean z2, ArrayList arrayList, ArrayList arrayList2, Date date);

    void onNotifyBoardDataAsk(NotifyBoardDataAsk notifyBoardDataAsk);

    void onNotifyCloseCallAsk(NotifyCloseCallAsk notifyCloseCallAsk);

    void onNotifyConfLayoutUserInformation(int i, int i2, int i3, String str, String str2, String str3);

    void onNotifyConsentAsk(NotifyConsentAsk notifyConsentAsk);

    void onNotifyFinishShareCameraAsk(NotifyFinishShareCameraAsk notifyFinishShareCameraAsk);

    void onNotifyMuteReceive(int i, int i2, int i3);

    void onNotifyStartShareScreenAsk(NotifyStartShareScreenAsk notifyStartShareScreenAsk);

    void onNotifyStopShareScreenAsk(NotifyStopShareScreenAsk notifyStopShareScreenAsk);

    int onP2PConferenceStatus(int i, ArrayList arrayList);

    int onP2PConferenceVoiceActivity(int i, int i2);

    int onP2pHoldReceived(int i, boolean z);

    void onPreviewCaptureError(int i, boolean z);

    void onPreviewCaptureImage(int i, boolean z);

    void onProposeConsentAsk(ProposeConsentAsk proposeConsentAsk);

    void onProposeConsentRep(ProposeConsentRep proposeConsentRep);

    int onReceiveCall(int i, short s, boolean z, boolean z2);

    void onReceiveCallTime(int i, Date date);

    int onReceiveChangeToConference(int i, String str, String str2);

    void onReceiveFeatureInfo(List list);

    int onReceiveMuteState(int i);

    int onReceiveP2PHandshaking(int i, boolean z);

    int onReceiveSipRingToneType(int i, int i2);

    int onRecvFileDone(int i, ArrayList arrayList);

    int onRecvFileStart(int i, int i2);

    void onRejectMessage(RejectMessageAsk rejectMessageAsk);

    int onRemoteRotationInfo(int i, int i2, int i3);

    void onRemoteVideoCaptureImage(int i);

    void onRemoteVideoRecrodInfo(int i, boolean z);

    void onReqAddConferenceMemberAsk(ReqAddConferenceMemberAsk reqAddConferenceMemberAsk);

    void onReqAddConferenceMemberRep(ReqAddConferenceMemberRep reqAddConferenceMemberRep);

    void onRequestConsentAsk(RequestConsentAsk requestConsentAsk);

    void onRequestConsentRep(RequestConsentRep requestConsentRep);

    void onRequestHipri(ArrayList arrayList);

    int onSendChangeToConference(int i, boolean z);

    int onSendChangeToP2P(int i, int i2, Date date);

    int onSendFileDone(int i);

    int onSendFileStart(int i);

    void onShareScreenCaptureError(int i, boolean z);

    void onShareViewEndNotifyReceive(int i);

    int onTranslateDataReceive(int i, String str, String str2, int i2);

    void onTryCallPush(int i);
}
