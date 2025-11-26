package com.coolots.chaton.common.coolotsinterface;

import android.app.StatusBarManager;
import android.content.Intent;
import android.os.Handler;
import android.os.IVoIPCallbackInterface;
import android.os.IVoIPInterface;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import com.android.internal.telephony.ITelephonyRegistry;
import com.coolots.chaton.common.controller.ChatONStatusBarController;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.view.ConfigActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.coolotsinterface.VoipStateController;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ChatOnVoipStateController implements VoipStateController {
    private static final String CLASSNAME = "[ChatOnVoipStateController]";
    private static final int EVENT_SET_ACTIVE = 2;
    private static final int EVENT_SET_ALERTING = 1;
    public static final String VOIPACTION = "com.sds.coolots.broadcast.VOIPACTION";
    protected IVoIPInterface mIVoIPInterface;
    private boolean mIsFocused = false;
    private Handler mHandler = new Handler() { // from class: com.coolots.chaton.common.coolotsinterface.ChatOnVoipStateController.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 1) {
                if (msg.what == 2) {
                    ChatOnVoipStateController.this.setActive((Destination) msg.obj);
                }
            } else {
                ChatOnVoipStateController.this.setAlerting((Destination) msg.obj);
            }
            super.handleMessage(msg);
        }
    };
    private final IVoIPCallbackInterface.Stub callback_1 = new IVoIPCallbackInterface.Stub() { // from class: com.coolots.chaton.common.coolotsinterface.ChatOnVoipStateController.2
        private boolean mIsReceived = false;
        CallStatusData callInfo = null;

        public boolean resumeVoIPCall() throws RemoteException {
            ChatOnVoipStateController.this.logI("VOIP_INTERFACE IVoIPCallbackInterface resumeVoIPCall");
            refreshCallInfo();
            if (this.callInfo.getCallState() == 4) {
                this.callInfo.setCallState(2);
                MainApplication.mPhoneManager.getPhoneStateMachine().unHoldCall(this.callInfo.getDestination());
            }
            return true;
        }

        public boolean moveVoIPToTop() throws RemoteException {
            refreshCallInfo();
            ChatOnVoipStateController.this.logI("VOIP_INTERFACE IVoIPCallbackInterface moveVoIPToTop");
            CallIntentGenerator generator = new CallIntentGenerator();
            Intent callIntent = generator.getCallIntent(this.callInfo.isUseVideo(), this.callInfo.isLiveShare(), this.callInfo.getDestination().getDestinationType() == 3);
            callIntent.putExtra(EventCode.EVENT_IDENTIFIER, EventCode.EVENT_CALL_ACTION);
            callIntent.setAction(CallActivity.getStringForEvent(EventCode.EVENT_CALL_ACTION));
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                callIntent.setFlags(65536);
            }
            callIntent.addFlags(268435456);
            callIntent.addFlags(536870912);
            callIntent.addFlags(8388608);
            MainApplication.mContext.startActivity(callIntent);
            return true;
        }

        public boolean holdVoIPCall() throws RemoteException {
            ChatOnVoipStateController.this.logI("VOIP_INTERFACE IVoIPCallbackInterface holdVoIPCall");
            refreshCallInfo();
            if (this.callInfo.getCallState() != 4) {
                this.callInfo.setCallState(4);
                MainApplication.mPhoneManager.getPhoneStateMachine().holdCall(this.callInfo.getDestination());
            }
            return true;
        }

        public boolean hangupVoIPCall() throws RemoteException {
            ChatOnVoipStateController.this.logI("VOIP_INTERFACE IVoIPCallbackInterface hangupVoIPCall");
            refreshCallInfo();
            if (this.callInfo.isValidity()) {
                if (CallState.isNotConnected(this.callInfo.getCallState())) {
                    ChatOnVoipStateController.this.logI("VOIP_INTERFACE IVoIPCallbackInterface hangupVoIPCall HANGUP_REASON_DENY");
                    MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(this.callInfo.getDestination(), 100);
                    return true;
                }
                if (CallState.isConnected(this.callInfo.getCallState())) {
                    ChatOnVoipStateController.this.logI("VOIP_INTERFACE IVoIPCallbackInterface hangupVoIPCall HANGUP_REASON_NORMAL");
                    MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(this.callInfo.getDestination(), 10);
                    return true;
                }
                return true;
            }
            return true;
        }

        public boolean answerVoIPCall() throws RemoteException {
            ChatOnVoipStateController.this.logI("VOIP_INTERFACE IVoIPCallbackInterface answerVoIPCall");
            if (this.mIsReceived) {
                return true;
            }
            this.mIsReceived = true;
            refreshCallInfo();
            CallActivity callActivity = (CallActivity) MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity();
            if (callActivity == null) {
                ChatOnVoipStateController.this.logI("VOIP_INTERFACE We have no CallActivity");
                return false;
            }
            Message msg = new Message();
            msg.what = EventCode.EVENT_CALL_RECEIVE_FOR_CALLBACK;
            callActivity.sendHandlerMessage(msg, 0L);
            return true;
        }

        public boolean muteVoIPCall() throws RemoteException {
            ChatOnVoipStateController.this.logI("VOIP_INTERFACE IVoIPCallbackInterface  muteVoIPCall");
            refreshCallInfo();
            if (this.callInfo.getCallState() == 5) {
                MainApplication.mPhoneManager.getPhoneStateMachine().unMuteCall(this.callInfo.getDestination());
            } else {
                MainApplication.mPhoneManager.getPhoneStateMachine().muteCall(this.callInfo.getDestination());
            }
            ChatOnVoipStateController.this.logI("QuickPanel - MUTE&VOIP");
            MainApplication.mCallNotification.showCallButtonNotification();
            return false;
        }

        private void refreshCallInfo() {
            this.callInfo = new CallStatusData();
            MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(this.callInfo);
        }
    };

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
    }

    public ChatOnVoipStateController() {
        this.mIVoIPInterface = null;
        if (this.mIVoIPInterface == null) {
            this.mIVoIPInterface = IVoIPInterface.Stub.asInterface(ServiceManager.checkService("voip"));
        }
        logI("VOIP_INTERFACE IVoIPInterface IVoIPInterface.Stub.asInterface(ServiceManager.checkService(\"voip\"))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlerting(Destination dest) {
        try {
            logE("setAlerting()");
            this.mIVoIPInterface.setVoIPAlerting(MainApplication.mContext.getApplicationInfo().packageName, dest.getPhoneNo());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActive(Destination dest) {
        ITelephonyRegistry telephonyRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService("telephony.registry"));
        try {
            logE("setActive()");
            this.mIVoIPInterface.setVoIPActive(MainApplication.mContext.getApplicationInfo().packageName, dest.getPhoneNo());
            logI("VOIP_INTERFACE IVoIPInterface setVoIPActive");
            if (telephonyRegistry != null) {
                telephonyRegistry.notifyCallState(5, "");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.VoipStateController
    public boolean registVoipCallState(Destination destination) {
        boolean z = true;
        logI("registVoipCallState start!!");
        if (this.mIVoIPInterface == null) {
            logE("VOIP_INTERFACE IVoIPInterface is null registVoipCallState");
            return true;
        }
        try {
            String voipNo = this.mIVoIPInterface.getCurrentVoIPNumber();
            if (voipNo == null || voipNo.isEmpty()) {
                this.mIVoIPInterface.createCallSession(MainApplication.mContext.getApplicationInfo().packageName, "com.sds.coolots.broadcast.VOIPACTION", destination.getPhoneNo(), this.callback_1);
                this.mIVoIPInterface.setUseBTInVoIP(MainApplication.mContext.getApplicationInfo().packageName, true);
                this.mIVoIPInterface.setVoIPCallCount(MainApplication.mContext.getApplicationInfo().packageName, 1);
                this.mIVoIPInterface.setUseHoldInVoIP(MainApplication.mContext.getApplicationInfo().packageName, true);
                logI("VOIP_INTERFACE createCallSession [ChatONV] com.sds.coolots.broadcast.VOIPACTION");
                if (MainApplication.mConfig.isFixedLCDFrame() && MainApplication.mContext != null) {
                    logI("LCD_FRAME send Intent SSRM_STATUS_VALUE true");
                    Intent boostIntent = new Intent();
                    boostIntent.setAction("com.sec.android.intent.action.SSRM_REQUEST");
                    boostIntent.putExtra("SSRM_STATUS_NAME", "ChatOnV_vtCall");
                    boostIntent.putExtra("SSRM_STATUS_VALUE", true);
                    boostIntent.putExtra("PackageName", MainApplication.mContext.getApplicationInfo().packageName);
                    boostIntent.putExtra("PID", Process.myPid());
                    MainApplication.mContext.sendBroadcast(boostIntent);
                    SystemProperties.set("hw.enable.chatOn", "1");
                }
            } else if (!voipNo.equals(destination.getPhoneNo())) {
                if (this.mIVoIPInterface.isVoIPIdle()) {
                    this.mIVoIPInterface.setVoIPCallCount(MainApplication.mContext.getApplicationInfo().packageName, 0);
                    this.mIVoIPInterface.destroyCallSession(MainApplication.mContext.getApplicationInfo().packageName);
                    logI("VOIP_INTERFACE destroyCallSession [ChatONV] ");
                    this.mIVoIPInterface.createCallSession("ChatON", "com.sds.coolots.broadcast.VOIPACTION", destination.getPhoneNo(), this.callback_1);
                    this.mIVoIPInterface.setUseBTInVoIP("ChatON", true);
                    this.mIVoIPInterface.setVoIPCallCount("ChatON", 1);
                    this.mIVoIPInterface.setUseHoldInVoIP(MainApplication.mContext.getApplicationInfo().packageName, true);
                    logI("VOIP_INTERFACE createCallSession [ChatON] com.sds.coolots.broadcast.VOIPACTION");
                    if (MainApplication.mConfig.isFixedLCDFrame() && MainApplication.mContext != null) {
                        logI("LCD_FRAME send Intent SSRM_STATUS_VALUE true");
                        Intent boostIntent2 = new Intent();
                        boostIntent2.setAction("com.sec.android.intent.action.SSRM_REQUEST");
                        boostIntent2.putExtra("SSRM_STATUS_NAME", "ChatOnV_vtCall");
                        boostIntent2.putExtra("SSRM_STATUS_VALUE", true);
                        boostIntent2.putExtra("PackageName", MainApplication.mContext.getApplicationInfo().packageName);
                        boostIntent2.putExtra("PID", Process.myPid());
                        MainApplication.mContext.sendBroadcast(boostIntent2);
                        SystemProperties.set("hw.enable.chatOn", "1");
                    }
                } else {
                    z = false;
                }
            }
            return z;
        } catch (RemoteException e) {
            logE("registVoipCallState EXCEPTION!!");
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.VoipStateController
    public void unregistVoipCallState() {
        logI("unregistVoipCallState start!!");
        if (this.mIVoIPInterface == null) {
            logI("VOIP_INTERFACE IVoIPInterface is null unregistVoipCallState");
            return;
        }
        try {
            if (!this.mIVoIPInterface.isVoIPIdle()) {
                logI("VOIP_INTERFACE !mIVoIPInterface.isVoIPIdle()");
                String voipNo = this.mIVoIPInterface.getCurrentVoIPNumber();
                ITelephonyRegistry telephonyRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService("telephony.registry"));
                this.mIVoIPInterface.setVoIPDisconnected(MainApplication.mContext.getApplicationInfo().packageName, voipNo);
                logI("VOIP_INTERFACE IVoIPInterface setVoIPDisconnected");
                this.mIVoIPInterface.setVoIPIdle(MainApplication.mContext.getApplicationInfo().packageName);
                logI("VOIP_INTERFACE IVoIPInterface setVoIPIdle");
                if (telephonyRegistry != null) {
                    telephonyRegistry.notifyCallState(3, "");
                    TelephonyManager telephonyManager = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
                    if (telephonyManager.getCallState() == 0) {
                        telephonyRegistry.notifyCallState(0, "");
                    }
                }
            }
            this.mIVoIPInterface.setVoIPCallCount(MainApplication.mContext.getApplicationInfo().packageName, 0);
            this.mIVoIPInterface.destroyCallSession(MainApplication.mContext.getApplicationInfo().packageName);
            logI("VOIP_INTERFACE destroyCallSession [ChatONV] ");
            if (MainApplication.mConfig.isFixedLCDFrame() && MainApplication.mContext != null) {
                logI("LCD_FRAME send Intent SSRM_STATUS_VALUE false");
                Intent boostIntent = new Intent();
                boostIntent.setAction("com.sec.android.intent.action.SSRM_REQUEST");
                boostIntent.putExtra("SSRM_STATUS_NAME", "ChatOnV_vtCall");
                boostIntent.putExtra("SSRM_STATUS_VALUE", false);
                boostIntent.putExtra("PackageName", MainApplication.mContext.getApplicationInfo().packageName);
                boostIntent.putExtra("PID", Process.myPid());
                MainApplication.mContext.sendBroadcast(boostIntent);
                SystemProperties.set("hw.enable.chatOn", "0");
            }
        } catch (RemoteException e) {
            logE("unregistVoipCallState EXCEPTION!!");
            e.printStackTrace();
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.VoipStateController
    public void updateVoipCallState(boolean isOutGoingCall, Destination destination, CallState callState) {
        logI("updateVoipCallState start!!");
        if (this.mIVoIPInterface == null) {
            logI("VOIP_INTERFACE IVoIPInterface is null updateVoipCallState");
            return;
        }
        try {
            String voipNo = this.mIVoIPInterface.getCurrentVoIPNumber();
            logI("VOIP_INTERFACE updateVoipCallState start!!, state:" + CallState.getCallStateDescription(callState.getCallState()));
            if (voipNo == null || voipNo.equals(destination.getPhoneNo())) {
                ITelephonyRegistry telephonyRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService("telephony.registry"));
                switch (callState.getCallState()) {
                    case 0:
                        break;
                    case 1:
                        if (isOutGoingCall) {
                            this.mIVoIPInterface.setVoIPDialing(MainApplication.mContext.getApplicationInfo().packageName, destination.getPhoneNo());
                            logI("VOIP_INTERFACE IVoIPInterface setVoIPDialing");
                            Message msg = new Message();
                            msg.what = 1;
                            msg.obj = destination;
                            this.mHandler.sendMessageDelayed(msg, 50L);
                            logE("EVENT_SET_ALERTING!!");
                            break;
                        } else {
                            this.mIVoIPInterface.setVoIPIncoming(MainApplication.mContext.getApplicationInfo().packageName, ChatONStringConvert.getInstance().removeAfterAt(ConfigActivity.getProfileUserID()));
                            logI("VOIP_INTERFACE IVoIPInterface setVoIPRinging");
                            if (telephonyRegistry != null) {
                                telephonyRegistry.notifyCallState(4, "");
                                break;
                            }
                        }
                        break;
                    case 2:
                    case 5:
                        if (isOutGoingCall && (this.mIVoIPInterface.isVoIPDialing() || this.mIVoIPInterface.isVoIPAlerting())) {
                            Message msg2 = new Message();
                            msg2.what = 2;
                            msg2.obj = destination;
                            int delay = 100;
                            if (this.mIVoIPInterface.isVoIPAlerting()) {
                                delay = 50;
                            }
                            this.mHandler.sendMessageDelayed(msg2, delay);
                            logE("EVENT_SET_ACTIVE!!");
                            break;
                        } else {
                            this.mIVoIPInterface.setVoIPActive(MainApplication.mContext.getApplicationInfo().packageName, destination.getPhoneNo());
                            logI("VOIP_INTERFACE IVoIPInterface setVoIPActive");
                            if (telephonyRegistry != null) {
                                telephonyRegistry.notifyCallState(5, "");
                                break;
                            }
                        }
                        break;
                    case 3:
                    default:
                        this.mIVoIPInterface.setVoIPDisconnected(MainApplication.mContext.getApplicationInfo().packageName, destination.getPhoneNo());
                        logI("VOIP_INTERFACE IVoIPInterface setVoIPDisconnected");
                        this.mIVoIPInterface.setVoIPIdle(MainApplication.mContext.getApplicationInfo().packageName);
                        logI("VOIP_INTERFACE IVoIPInterface setVoIPIdle");
                        if (telephonyRegistry != null) {
                            telephonyRegistry.notifyCallState(3, "");
                            TelephonyManager telephonyManager = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
                            if (telephonyManager.getCallState() == 0) {
                                telephonyRegistry.notifyCallState(0, "");
                                break;
                            }
                        }
                        break;
                    case 4:
                        this.mIVoIPInterface.setVoIPHolding(MainApplication.mContext.getApplicationInfo().packageName, destination.getPhoneNo());
                        logI("VOIP_INTERFACE IVoIPInterface setVoIPHolding");
                        if (telephonyRegistry != null) {
                            telephonyRegistry.notifyCallState(5, "");
                            break;
                        }
                        break;
                }
                if (MainApplication.mCallNotification.showQuickPanel()) {
                    MainApplication.mCallNotification.showCallButtonNotification();
                }
            }
        } catch (RemoteException e) {
            logE("updateVoipCallState EXCEPTION!!");
            e.printStackTrace();
            unregistVoipCallState();
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.VoipStateController
    public void resetForRecovery() {
        IVoIPInterface mIVoIPInterface = IVoIPInterface.Stub.asInterface(ServiceManager.checkService("voip"));
        if (mIVoIPInterface != null) {
            try {
                try {
                    String voipNo = mIVoIPInterface.getCurrentVoIPNumber();
                    if (voipNo != null && !voipNo.isEmpty()) {
                        mIVoIPInterface.setVoIPIdle(MainApplication.mContext.getApplicationInfo().packageName);
                        mIVoIPInterface.destroyCallSession(MainApplication.mContext.getApplicationInfo().packageName);
                        mIVoIPInterface.setVoIPCallCount(MainApplication.mContext.getApplicationInfo().packageName, 0);
                        logI("VOIP_INTERFACE IVoIPCallbackInterface destroyCallSession [ChatONV]");
                        if (MainApplication.mConfig.isFixedLCDFrame() && MainApplication.mContext != null) {
                            logI("LCD_FRAME send Intent SSRM_STATUS_VALUE false");
                            Intent boostIntent = new Intent();
                            boostIntent.setAction("com.sec.android.intent.action.SSRM_REQUEST");
                            boostIntent.putExtra("SSRM_STATUS_NAME", "ChatOnV_vtCall");
                            boostIntent.putExtra("SSRM_STATUS_VALUE", false);
                            boostIntent.putExtra("PackageName", MainApplication.mContext.getApplicationInfo().packageName);
                            boostIntent.putExtra("PID", Process.myPid());
                            MainApplication.mContext.sendBroadcast(boostIntent);
                            SystemProperties.set("hw.enable.chatOn", "0");
                        }
                    }
                    try {
                        StatusBarManager mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
                        if (mStatusBarManager != null) {
                            mStatusBarManager.disable(ChatONStatusBarController.clearFlag());
                            mStatusBarManager.removeIcon("speakerphone");
                            mStatusBarManager.removeIcon("mute");
                        }
                    } catch (NoSuchMethodError e) {
                    } catch (SecurityException e2) {
                    }
                } catch (NoSuchMethodError e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
