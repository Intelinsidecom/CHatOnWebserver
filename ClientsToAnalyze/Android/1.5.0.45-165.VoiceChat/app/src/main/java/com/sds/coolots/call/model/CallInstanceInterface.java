package com.sds.coolots.call.model;

import com.coolots.p2pmsg.model.JoinConferenceRep;
import com.sds.coolots.call.CallingInterface;
import com.sds.coolots.common.controller.EngineCallBackInterface;
import com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface;
import com.sds.coolots.common.coolotsinterface.ISSOCallCallBack;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public interface CallInstanceInterface {
    void chageAudioModeForScreenShare();

    AudioPathControllerInterface getAudioPathController();

    Object getCallActivityMutex();

    Date getCallConnectedTime();

    int getCallDuration();

    int getCallInstanceID();

    C1208j getCallLogData();

    C1209k getCallOptionData();

    CallingInterface getCallingActivity();

    EngineCallBackInterface getEngineInterface();

    int getInitiateCallType();

    C1192G getMyConnectionInfo();

    ISSOCallCallBack getSSOCallCallback();

    boolean isOutGoingCallInit();

    boolean isSIPCall();

    boolean isUseVideo();

    void notiRejectMsg(String str, String str2);

    int onChangeToP2P(String str, String str2, String str3, List list);

    void onFinishChangeToConference(JoinConferenceRep joinConferenceRep, List list, String str, String str2);

    void onReceiveFeatureInfo(List list);

    boolean registVoipCallState();

    void removeRejectMsgHandlerMessage();

    void returnAudioModeForShareScreen();

    void setActivityStatus(int i, int i2);

    void setActivityStatus(int i, int i2, int i3, Object obj);

    void setActivityStatus(int i, Object obj);

    void setCallConnectedTime(Date date);

    void setCallingActivity(CallingInterface callingInterface);

    void setConferenceCallID(int i);

    void setMyStartTime(Date date, boolean z);

    void setPlayHoldTone(boolean z);

    void setUseVideo(boolean z);

    void showToastForShareView(int i);

    void startShareView(boolean z);

    void stopShareView();

    void turnOnSpeaker();

    void unregistVoipCallState();

    void updateVoipCallState();
}
