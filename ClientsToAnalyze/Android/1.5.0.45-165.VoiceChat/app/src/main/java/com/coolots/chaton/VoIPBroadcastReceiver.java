package com.coolots.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class VoIPBroadcastReceiver extends BroadcastReceiver {
    private static final String CLASSNAME = "[VoIPBroadcastReceiver]";

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String actionType = intent.getStringExtra("VOIP_ACTION");
        logE("VOIP_INTERFACE actionType" + actionType);
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        CallActivity callActivity = (CallActivity) MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity();
        if (callActivity != null && callActivity.isChangeToConference()) {
            Toast.makeText(MainApplication.mContext, MainApplication.mContext.getString(((ChatOnResourceInterface) MainApplication.mResources).getStringChangeToConferenceWait()), 0).show();
            logE("haeri=WAIT: change to conference");
            return;
        }
        if ("hangup_voip".equals(actionType)) {
            logE("VOIP_INTERFACE We've Got Broadcast Intent hangup_voip");
            handleHangUp(callInfo);
            return;
        }
        if ("movetotop_voip".equals(actionType)) {
            logE("VOIP_INTERFACE We've Got Broadcast Intent movetotop_voip");
            handleMoveToTop(callInfo);
            return;
        }
        if ("answer_voip".equals(actionType)) {
            logE("VOIP_INTERFACE We've Got Broadcast Intent answer_voip");
            handleAnswer(callActivity);
            return;
        }
        if ("switchHoldingAndActive_voip".equals(actionType)) {
            logE("VOIP_INTERFACE We've Got Broadcast Intent switchHoldingAndActive_voip");
            handleHold(callInfo);
            return;
        }
        if ("setMute_voip".equals(actionType)) {
            logE("VOIP_INTERFACE We've Got Broadcast Intent setMute_voip");
            handleMute(callInfo);
        } else if ("turnOnSpeaker_voip".equals(actionType)) {
            logE("VOIP_INTERFACE We've Got Broadcast Intent turnOnSpeaker_voip");
            handleTurnOnSpeaker(callInfo);
        } else if ("unHold_voip".equals(actionType)) {
            logE("VOIP_INTERFACE We've Got Broadcast Intent unHold_voip");
            handleHold(callInfo);
        } else {
            logE("VOIP_INTERFACE We've Got Broadcast Intent - Unknown : " + actionType);
        }
    }

    private void handleHangUp(CallStatusData callInfo) {
        if (callInfo.isValidity()) {
            logE("VOIP_INTERFACE handleHangUp");
            if (CallState.isNotConnected(callInfo.getCallState())) {
                logE("VOIP_INTERFACE HANGUP_REASON_DENY");
                MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(callInfo.getDestination(), 100);
            } else if (CallState.isConnected(callInfo.getCallState())) {
                logE("VOIP_INTERFACE HANGUP_REASON_NORMAL");
                MainApplication.mPhoneManager.getPhoneStateMachine().setShowCallActivity(true);
                MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(callInfo.getDestination(), 10);
            }
        }
    }

    private void handleMoveToTop(CallStatusData callInfo) {
        logE("VOIP_INTERFACE QUICKPANNELRECEIVER handleMoveToTop");
        Intent callIntent = MainApplication.mCallIntentGenerator.getCallIntent(callInfo.isUseVideo(), callInfo.isLiveShare(), callInfo.getDestination().getDestinationType() == 3);
        if (callIntent != null) {
            callIntent.putExtra(EventCode.EVENT_IDENTIFIER, EventCode.EVENT_CALL_ACTION);
            callIntent.setAction(CallActivity.getStringForEvent(EventCode.EVENT_CALL_ACTION));
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                callIntent.setFlags(65536);
            }
            callIntent.addFlags(268435456);
            callIntent.addFlags(536870912);
            callIntent.addFlags(8388608);
            MainApplication.mContext.startActivity(callIntent);
        }
    }

    private void handleAnswer(CallActivity callActivity) {
        if (callActivity != null) {
            callActivity.receiveCall();
        } else {
            logE("VOIP_INTERFACE We have no CallActivity");
        }
    }

    private void handleMute(CallStatusData callInfo) {
        logI("<<KEONLEE>> showCallButtonNotification()VoIPBroadCastReceiver!!handleMute()");
        CallActivity callActivity = (CallActivity) MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity();
        if (callInfo.getCallState() == 5) {
            MainApplication.mPhoneManager.getPhoneStateMachine().unMuteCall(callInfo.getDestination());
            callActivity.setMuteState(false);
        } else {
            MainApplication.mPhoneManager.getPhoneStateMachine().muteCall(callInfo.getDestination());
        }
        MainApplication.mCallNotification.showCallButtonNotification();
    }

    private void handleHold(CallStatusData callInfo) {
        logI("<<handleHold>> showCallButtonNotification()VoIPBroadCastReceiver!!handleHold()");
        CallActivity callActivity = (CallActivity) MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity();
        if (callInfo.getCallState() == 4) {
            callInfo.setCallState(2);
            MainApplication.mPhoneManager.getPhoneStateMachine().unHoldCall(callInfo.getDestination());
            if (callActivity.mMuteOnBeforeHold) {
                logI("previous MUTE true!!!!!!!!!!");
                MainApplication.mPhoneManager.getPhoneStateMachine().muteCall(callInfo.getDestination());
            }
        } else {
            callInfo.setCallState(4);
            MainApplication.mPhoneManager.getPhoneStateMachine().holdCall(callInfo.getDestination());
        }
        MainApplication.mCallNotification.showCallButtonNotification();
    }

    private void handleTurnOnSpeaker(CallStatusData callInfo) {
        logI("<<KEONLEE>> showCallButtonNotification()VoIPBroadCastReceiver!!handleTurnOnSpeaker()");
        if (callInfo.getAudioPathController() != null) {
            callInfo.getAudioPathController().onClickSpeakerButton();
        }
        MainApplication.mCallNotification.showCallButtonNotification();
    }
}
