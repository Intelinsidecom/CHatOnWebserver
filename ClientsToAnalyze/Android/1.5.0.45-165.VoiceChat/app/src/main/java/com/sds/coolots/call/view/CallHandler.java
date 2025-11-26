package com.sds.coolots.call.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sds.coolots.call.model.ConsentDisplayInfo;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class CallHandler extends Handler implements DisposeInterface {

    /* renamed from: a */
    private boolean f2877a = false;
    protected final CallActivity mParent;

    public CallHandler(CallActivity callActivity) {
        this.mParent = callActivity;
    }

    public void dispose() {
        this.f2877a = true;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Log.m2958e("<<ROTATION>> [CallHandler] handleMessage!!!!! msg.whar:" + message.what);
        if (this.f2877a) {
            Log.m2958e("<<ROTATION>> [CallHandler] handleMessage!!!!! handler is disposed!!!! msg.whar:" + message.what);
        }
        this.mParent.checkCallInstanceNRefresh();
        if (message.what == 7300) {
            this.mParent.handleCallEvent(message.arg2);
        }
        switch (message.what) {
            case 10:
                this.mParent.handleDelayedQuit();
                break;
            case 11:
                this.mParent.hangupCall();
                break;
            case 12:
                this.mParent.receiveCall();
                break;
            case 13:
                this.mParent.hangupLowBattery();
                break;
            case 15:
                this.mParent.enableSpeakerCall();
                break;
            case 16:
                this.mParent.disableSpeakerCall();
                break;
            case 17:
                this.mParent.enableSpeakerButton();
                break;
            case 18:
                this.mParent.disableSpeakerButton();
                break;
            case 19:
                this.mParent.onBTButton();
                break;
            case 20:
                this.mParent.offBTButton();
                break;
            case 21:
                this.mParent.disableBTButton();
                break;
            case 22:
                this.mParent.clickableHoldButton();
                break;
            case 23:
                this.mParent.setMuteState(true);
                break;
            case 24:
                this.mParent.setMuteState(false);
                break;
            case 25:
                this.mParent.handleEarphonePlugged(true);
                break;
            case 26:
                this.mParent.handleEarphonePlugged(false);
                break;
            case 27:
                this.mParent.hangupEntitlement();
                break;
            case 28:
                this.mParent.hangupNetworkErrorEntitlement();
                break;
            case 29:
                this.mParent.notifyHangupSoonCausedByTimeConstraint();
                break;
            case 30:
                this.mParent.hangupCausedByTimeConstraint();
                break;
            case 31:
                this.mParent.addFlagKeyGuardLock();
                break;
            case 32:
                this.mParent.clearFlagKeyGuarLock();
                break;
            case 100:
                this.mParent.receiveCall();
                break;
            case CallActivity.MSG_ENTERING_PICK_BUDDY_ACTIVITY /* 6421 */:
                this.mParent.getCallFunctionController().setInviteProcessing(false);
                break;
            case EventCode.EVENT_CALL_CLOSE_ACTIVITY_IMMEDIATELY /* 7114 */:
                this.mParent.handleImmediatelyQuit();
                break;
            case CallActivity.MSG_REQUESTING_SWITCH_TO_VIDEO_CALL /* 7421 */:
                this.mParent.getCallFunctionController().setCallSwitchingProcessing(0);
                break;
            case EventCode.EVENT_CALL_ON_HOLD /* 7902 */:
                this.mParent.showCallHoldOnStateToast();
                break;
            case EventCode.EVENT_CALL_RETRIEVED /* 7903 */:
                this.mParent.showCallHoldRetrievedStateToast();
                break;
            case EventCode.EVENT_CALL_RECEIVE_FOR_CALLBACK /* 7904 */:
                this.mParent.receiveCall();
                break;
            case EventCode.EVENT_CALL_SWITCH_PROCESS_ACTIVITY /* 7913 */:
                this.mParent.stopRecordingForCallSwitching();
                this.mParent.handleActivityForCallSwitch((Intent) message.obj);
                break;
            case EventCode.EVENT_CALL_SWITCH_PROCESS_CLOSE_POPUP /* 7914 */:
                this.mParent.handlePopupCloseForCallSwitch();
                break;
            case EventCode.EVENT_CALL_PROPOSE_REP_RECEIVED /* 7923 */:
                this.mParent.handleReceiveCallProposeRep(message.arg1, message.arg2);
                break;
            case EventCode.EVENT_CALL_NETWORK_WEAK_DURING_VIDEO_CALL /* 7925 */:
                this.mParent.handleReceiveCallNetworkWeak(message.arg1);
                break;
            case EventCode.EVENT_SHARE_VIEW_SHOW_TOAST /* 7931 */:
                this.mParent.showToastForShareView(message.arg1, (String) message.obj);
                break;
            case EventCode.EVENT_SHARE_VIEW_START /* 7932 */:
                this.mParent.startShareView(message.arg1 == 1);
                break;
            case EventCode.EVENT_SHARE_VIEW_END /* 7933 */:
                this.mParent.stopShareView();
                break;
            case EventCode.EVENT_SHARE_VIEW_END_FAIL /* 7936 */:
                this.mParent.notifyStopShareViewFailed();
                break;
            case EventCode.EVENT_SHARE_SCREEN_START /* 8112 */:
                Log.m2963i("<<YHT223>> EVENT_SHARE_SCREEN_START!!");
                this.mParent.handleStartShareScreen();
                break;
            case EventCode.EVENT_CONSENT_REJECT /* 8201 */:
                this.mParent.notifyConsentReject(message.arg1, message.arg2, (ConsentDisplayInfo) message.obj);
                break;
            case EventCode.EVENT_CONSENT_ACCEPT /* 8202 */:
                this.mParent.notifyConsentAccept(message.arg1, message.arg2, (ConsentDisplayInfo) message.obj);
                break;
            case EventCode.EVENT_REQUEST_CONSENT_ASK_RECEIVE /* 8203 */:
                this.mParent.notifyConsentRequestAskReceive(message.arg1, message.arg2, (String) message.obj);
                break;
            case EventCode.EVENT_DISMISS_CONSENT_DIALOG /* 8204 */:
                this.mParent.dismissConsentDialog();
                break;
            case EventCode.EVENT_DISMISS_CONSENT_USER_ACTION_DIALOG /* 8206 */:
                this.mParent.dismissCallConsentUserActionDialog();
                break;
            case EventCode.EVENT_RECOGNITION_START /* 95008 */:
                this.mParent.handleRecognitionStart((TranslationDisplayData) message.obj);
                break;
            case EventCode.EVENT_RECOGNITION_END /* 95009 */:
                this.mParent.handleRecognitionEnd((TranslationDisplayData) message.obj);
                break;
            case EventCode.EVENT_RECOGNITION_STOP /* 95010 */:
                this.mParent.handleRecognitionStop();
                break;
            case EventCode.EVENT_TRANSLATION_START /* 95011 */:
                this.mParent.handleTranslationStart((TranslationDisplayData) message.obj);
                break;
            case EventCode.EVENT_TRANSLATION_END /* 95012 */:
                this.mParent.handleTranslationEnd((TranslationDisplayData) message.obj);
                break;
            case EventCode.EVENT_TTS_START /* 95013 */:
                this.mParent.handleTTSStart(((TranslationDisplayData) message.obj).getID());
                break;
            case EventCode.EVENT_TTS_STOP /* 95014 */:
                this.mParent.handleTTSEnd(((TranslationDisplayData) message.obj).getID());
                break;
            case EventCode.EVENT_DUAL_CAMERA_START /* 95015 */:
            case EventCode.EVENT_DUAL_CAMERA_STOP /* 95016 */:
                Log.m2963i("Dual Camera Event!! event = " + message.what);
                break;
        }
    }
}
