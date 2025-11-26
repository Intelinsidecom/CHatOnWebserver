package com.coolots.watch;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.setting.data.ChatONRejectMsgData;
import com.coolots.chaton.setting.data.ChatONRejectMsgList;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.sso.EntitlementUIController;
import com.coolots.sso.IEntitlementUIController;
import com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.watch.IWatchCallbackInterface;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sec.chaton.clientapi.UtilityAPI;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WatchManager implements IWatchCallbackInterface, IEntitlementUIController {
    public static final String CALL_DESTINATION = "call_destination";
    private static final int REJECTMSG_MAX_CNT = 6;
    private ChatONRejectMsgData mChatONRejectMsgData;
    IChatonVoIPManagerService mChatonVoIPManagerService;
    private EntitlementUIController mEntitlementUIController;
    public static int ERROR_CHATON_ACCOUNT_NOTEXIST = ErrorCode.ERROR_LOGIN_NO_NUMBER;
    public static int ERROR_CHATONV_ACCOUNT_NOTEXIST = -102;
    public static int ERROR_AIRPLAIN_MODE = -103;
    public static int ERROR_NETWORK_DISCOMNNECTED = -104;
    public static int ERROR_WIFI_ONLY_MODE = -105;
    public static int ERROR_LOGOUT_STATE = -106;
    private TelephonyManager telephonyManager = null;
    private final int RESERVEACTION_NONE = -1;
    private final int RESERVEACTION_CALL_DISCONNECTED = 0;
    private final int RESERVEACTION_CALL_CONNECTED = 1;
    private final int RESERVEACTION_CALL_P2PRINGING = 2;
    private final int RESERVEACTION_CALL_CONFRINGING = 3;
    private final int RESERVEACTION_START_CALL_RESULT = 4;
    private final int RESERVEACTION_START_P2PCALL = 5;
    private final int RESERVEACTION_START_CONFCALL = 6;
    private final int RESERVEACTION_NOTI_HOLD_STATE = 7;
    private final int RESERVEACTION_NOTI_MUTE_STATE = 8;
    private final int RESERVEACTION_NOTI_CHANGE_CALL_TYPE = 9;
    private final int RESERVEACTION_NOTI_CHANGE_TO_P2P = 10;
    private final int RESERVEACTION_NOTI_CHANGE_TO_CONF = 11;
    private final int RESERVEACTION_NOTI_STOP_RINGTONE = 12;
    private final int RESERVEACTION_NOTI_UPDATE_CONF_MEMBER = 13;
    private short isExistReservedAction = -1;
    private Destination backupDestination = null;
    private boolean backupIsVideoCall = false;
    private boolean backupHoldState = false;
    private boolean backupMuteState = false;
    private int backupHangupReason = 10;
    private boolean backupIsStartCall = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.coolots.watch.WatchManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            WatchManager.this.logI("ChatonVoIPManagerService onServiceConnected!!!");
            if (WatchManager.this.mChatonVoIPManagerService == null) {
                WatchManager.this.mChatonVoIPManagerService = IChatonVoIPManagerService.Stub.asInterface(service);
            }
            if (WatchManager.this.mChatonVoIPManagerService == null) {
                WatchManager.this.backupDestination = null;
                WatchManager.this.isExistReservedAction = (short) -1;
                return;
            }
            if (WatchManager.this.backupDestination != null) {
                switch (WatchManager.this.isExistReservedAction) {
                    case 0:
                        WatchManager.this.doNotifyCallDisconnected(WatchManager.this.backupDestination, WatchManager.this.backupHangupReason);
                        break;
                    case 1:
                        WatchManager.this.doNotifyCallConnected(WatchManager.this.backupDestination);
                        break;
                    case 2:
                        WatchManager.this.doNotifyP2PCallRinging(WatchManager.this.backupDestination, WatchManager.this.backupIsVideoCall);
                        break;
                    case 3:
                        WatchManager.this.doNotifyConferenceCallRinging(WatchManager.this.backupDestination, WatchManager.this.backupIsVideoCall);
                        break;
                    case 4:
                        WatchManager.this.doNotifyStartCallResult(WatchManager.this.backupDestination, WatchManager.this.backupIsStartCall);
                        break;
                    case 5:
                        WatchManager.this.doNotifyStartOutGoingP2PCall(WatchManager.this.backupDestination, WatchManager.this.backupIsVideoCall);
                        break;
                    case 6:
                        WatchManager.this.doNotifyStartOutGoingConferenceCall(WatchManager.this.backupDestination, WatchManager.this.backupIsVideoCall);
                        break;
                    case 7:
                        WatchManager.this.doNotifyHoldStateToWatch(WatchManager.this.backupDestination, WatchManager.this.backupHoldState);
                        break;
                    case 8:
                        WatchManager.this.doNotifyMuteStateToWatch(WatchManager.this.backupDestination, WatchManager.this.backupMuteState);
                        break;
                    case 9:
                        WatchManager.this.doNotifyChangeCallType(WatchManager.this.backupIsVideoCall);
                        break;
                    case 10:
                        WatchManager.this.doNotifyChangeConfToP2PCall(WatchManager.this.backupDestination, WatchManager.this.backupIsVideoCall);
                        break;
                    case 11:
                        WatchManager.this.doNotifyChangeP2PToConfCall(WatchManager.this.backupDestination, WatchManager.this.backupIsVideoCall);
                        break;
                    case 12:
                        WatchManager.this.doNotifyStopRingtone(WatchManager.this.backupDestination);
                        break;
                    case 13:
                        WatchManager.this.doNotifyUpdateConferenceMember(WatchManager.this.backupDestination, WatchManager.this.backupIsVideoCall);
                        break;
                }
            }
            WatchManager.this.backupDestination = null;
            WatchManager.this.isExistReservedAction = (short) -1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName arg0) {
            WatchManager.this.logI("ChatonVoIPManagerService onServiceDisconnected!!!");
            WatchManager.this.mChatonVoIPManagerService = null;
        }
    };
    private final Handler mHandler = new Handler() { // from class: com.coolots.watch.WatchManager.2
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            WatchManager.this.processCallEventMessage(msg);
            super.handleMessage(msg);
        }
    };
    private boolean isCallReceiveFromWatch = false;

    private void logE(String message) {
        Log.m2958e("[SWatch] - WatchManager  " + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i("[SWatch] - WatchManager  " + message);
    }

    public WatchManager() {
        logI("WatchManager created!!!!");
    }

    private void bindSAPProviderService() {
        MainApplication.mContext.bindService(new Intent("com.samsung.appcessory.chatonvoipmanagerservice"), this.mServiceConnection, 1);
    }

    public int p2pCallOutFromWatch(String buddy) {
        if (buddy == null || buddy.isEmpty()) {
            return -1;
        }
        Destination destination = new Destination(2, ChatONStringConvert.getInstance().toUserID(buddy));
        int retEnvironment = checkEnvironment();
        if (retEnvironment == -100) {
            callProcessing(destination, EventCode.EVENT_START_P2P_VOICE_CALL);
            int retVal = destination.getCallInstanceID();
            return retVal;
        }
        return retEnvironment;
    }

    private boolean checkChatONAccountValidity() {
        try {
            boolean isAvailable = UtilityAPI.isChatONActivated(MainApplication.mContext);
            return isAvailable;
        } catch (NotAvailableClientAPIException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkCooLotsAccountValidity() {
        String userID = MainApplication.mConfig.getProfileUserID();
        String backupID = ((ChatOnConfigInterface) MainApplication.mConfig).getBackupJoinUserID();
        if (userID == null || userID.isEmpty()) {
            return (backupID == null || backupID.isEmpty()) ? false : true;
        }
        return true;
    }

    public boolean checkAirPlainMode() {
        if (Settings.System.getInt(MainApplication.mContext.getContentResolver(), "airplane_mode_on", 0) != 1) {
            return false;
        }
        logI("[checkCurrentNetworkConnection] airplain mode is on!");
        return true;
    }

    public int checkEnvironment() {
        if (!checkChatONAccountValidity()) {
            logE("ChatON account does not exist");
            int ret = ERROR_CHATON_ACCOUNT_NOTEXIST;
            return ret;
        }
        if (!checkCooLotsAccountValidity()) {
            logE("Call Fail: Account is none!!");
            int ret2 = ERROR_CHATONV_ACCOUNT_NOTEXIST;
            return ret2;
        }
        if (!VAppPhoneManager.isCoolotsServiceRunning(MainApplication.mContext)) {
            logE("checkEnvironment- startCoolotsService!!");
            VAppPhoneManager.startCoolotsService(MainApplication.mContext, false);
            return -100;
        }
        if (checkAirPlainMode() && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
            logE("Call Fail: Airplain Mode");
            int ret3 = ERROR_AIRPLAIN_MODE;
            return ret3;
        }
        if (!PhoneManager.isNetworkConnected(MainApplication.mContext)) {
            logE("Call Fail: Network Disconnected");
            int ret4 = ERROR_NETWORK_DISCOMNNECTED;
            return ret4;
        }
        if (ChatONSettingData.getInstance().isUseWifiOnly() && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
            logE("Call Fail: Wifi only mode");
            int ret5 = ERROR_WIFI_ONLY_MODE;
            return ret5;
        }
        if (MainApplication.mPhoneManager.getLoginManager().isLogin()) {
            return -100;
        }
        logE("Call Fail: Logout!!!!!");
        MainApplication.mPhoneManager.getLoginManager().login();
        int ret6 = ERROR_LOGOUT_STATE;
        return ret6;
    }

    public int conferenceCallOutFromWatch(List<String> participants, String groupName) {
        if (participants == null) {
            return -1;
        }
        ArrayList<SimpleUserInfo> memberList = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getSimpleUserInfoFromMSISDN(participants);
        Destination destination = new Destination("", memberList, groupName);
        int retEnvironment = checkEnvironment();
        if (retEnvironment == -100) {
            callProcessing(destination, EventCode.EVENT_START_GROUP_VOICE_CALL);
        }
        int retVal = destination.getCallInstanceID();
        return retVal;
    }

    public List<String> getRejectWithMessageList() {
        List<String> rejectMsgs = new ArrayList<>();
        rejectMsgs.add(MainApplication.mContext.getString(((ChatOnResourceInterface) MainApplication.mResources).get_reject_msg_default1()));
        rejectMsgs.add(MainApplication.mContext.getString(((ChatOnResourceInterface) MainApplication.mResources).get_reject_msg_default2()));
        rejectMsgs.add(MainApplication.mContext.getString(((ChatOnResourceInterface) MainApplication.mResources).get_reject_msg_default3()));
        rejectMsgs.add(MainApplication.mContext.getString(((ChatOnResourceInterface) MainApplication.mResources).get_reject_msg_default4()));
        rejectMsgs.add(MainApplication.mContext.getString(((ChatOnResourceInterface) MainApplication.mResources).get_reject_msg_default5()));
        this.mChatONRejectMsgData = ChatONRejectMsgList.loadData(rejectMsgs, 6);
        List<String> defaultString = ((ChatOnResourceInterface) MainApplication.mResources).getDefaultRejectMsg();
        ArrayList<String> retList = new ArrayList<>();
        for (int index = 0; index < this.mChatONRejectMsgData.getCount(); index++) {
            if (this.mChatONRejectMsgData.getType(index) == 0) {
                retList.add(this.mChatONRejectMsgData.getMessage(index));
            } else {
                retList.add(defaultString.get(this.mChatONRejectMsgData.getType(index) - 1));
            }
        }
        return retList;
    }

    public boolean hangupCallFromWatch(int callID) {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        if (callInfo.isValidity()) {
            if (CallState.isNotConnected(callInfo.getCallState())) {
                logI("hangupCallFromWatch - HANGUP_REASON_DENY CallInstanceID : " + callID);
                MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(callInfo.getDestination(), 100);
            } else if (CallState.isConnected(callInfo.getCallState())) {
                logI("hangupCallFromWatch - HANGUP_REASON_NORMAL CallInstanceID : " + callID);
                MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(callInfo.getDestination(), 10);
            }
            return true;
        }
        logI("hangupCallFromWatch callInfo InValid ");
        return false;
    }

    public boolean receiveCallFromWatch(int callID) {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        logI("receiveCallFromWatch CallInstanceID : " + callID);
        this.isCallReceiveFromWatch = true;
        logI("WATCH_AUDIO isCallReceiveFromWatch" + this.isCallReceiveFromWatch);
        MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(callInfo.getDestination(), callInfo.getCallID(), true, 10, MainApplication.mConfig.isSecureCommunication(), "");
        return true;
    }

    public boolean setMuteCallStateFromWatch(int callID, boolean muteCall) {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        if (muteCall) {
            logI("setMuteCallStateFromWatch - muteCall CallInstanceID : " + callID);
            MainApplication.mPhoneManager.getPhoneStateMachine().muteCall(callInfo.getDestination());
        } else {
            logI("setMuteCallStateFromWatch - unMuteCall CallInstanceID : " + callID);
            MainApplication.mPhoneManager.getPhoneStateMachine().unMuteCall(callInfo.getDestination());
        }
        CallActivity callActivity = (CallActivity) MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity();
        callActivity.setMuteState(muteCall);
        Message msg = new Message();
        msg.what = EventCode.EVENT_CALL_ACTION;
        callActivity.sendHandlerMessage(msg, 0L);
        return true;
    }

    public void callProcessing(Destination destination, int msg) {
        logI("callProcessing " + msg);
        Bundle bundle = new Bundle();
        if (destination == null) {
            logI("destination is null. ignored.");
            return;
        }
        bundle.putParcelable("call_destination", destination);
        if (this.telephonyManager == null) {
            this.telephonyManager = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
        }
        if (this.telephonyManager.getCallState() == 0 && !isCoolotsCalling()) {
            sendHandlerMessage(msg, bundle);
        }
    }

    private boolean isCoolotsCalling() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        return callInfo.isValidity() && !CallState.isDisconnected(callInfo.getCallState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCallEventMessage(Message msg) {
        int kindOfCall = msg.what;
        logI("processCallEventMessage() kindOfCall: " + kindOfCall);
        Bundle bundle = (Bundle) msg.obj;
        if (bundle == null) {
            logE("Call Fail: bundle is null");
            return;
        }
        Destination destination = (Destination) bundle.getParcelable("call_destination");
        if (destination == null) {
            logE("Call Fail: destination is null!!");
            return;
        }
        Bundle extras = new Bundle();
        extras.putParcelable("destination", destination);
        extras.putInt("kindOfCall", kindOfCall);
        this.mEntitlementUIController = new EntitlementUIController();
        this.mEntitlementUIController.setBundle(extras);
        this.mEntitlementUIController.start(this, true, isVideoCallType(kindOfCall), false);
    }

    private boolean isVideoCallType(int callKind) {
        return callKind == 40003 || callKind == 40005;
    }

    private void sendCallRequest(int kindOfCall, Destination destination) {
        logI("sendCallRequest() " + kindOfCall);
        if (checkServicePolicyInfo(kindOfCall)) {
            PhoneStateMachine instance = MainApplication.mPhoneManager.getPhoneStateMachine();
            int ret = 0;
            String callerName = MainApplication.mConfig.getProfileUserName();
            switch (kindOfCall) {
                case EventCode.EVENT_START_P2P_VOICE_CALL /* 40002 */:
                    ret = instance.startOutGoingCall(destination, false, false, callerName);
                    break;
                case EventCode.EVENT_START_P2P_VIDEO_CALL /* 40003 */:
                default:
                    ret = PhoneStateMachine.ERROR_UNKNOWN;
                    break;
                case EventCode.EVENT_START_GROUP_VOICE_CALL /* 40004 */:
                    if (checkGroupCallMemberValidity(destination, false)) {
                        ret = instance.startOutGoingCall(destination, false, false, callerName);
                        break;
                    }
                    break;
            }
            logI("sendCallRequest() result " + ret);
        }
    }

    private boolean checkGroupCallMemberValidity(Destination destination, boolean isVideo) {
        logI("checkGroupCallMemberValidity()");
        if (destination.getDestinationType() == 4) {
            if (destination.getConferenceMember() == null || destination.getConferenceMember().isEmpty()) {
                return false;
            }
            if (destination.getConferenceMember().size() > ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(isVideo)) {
                return false;
            }
        } else if (destination.getDestinationType() == 5) {
            if (destination.getP2PConferenceMember() == null || destination.getP2PConferenceMember().isEmpty()) {
                return false;
            }
            if (destination.getP2PConferenceMember().size() > ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(isVideo)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkServicePolicyInfo(int kindOfCall) {
        return !(kindOfCall == 40002 || kindOfCall == 40004) || ((ChatOnConfigInterface) MainApplication.mConfig).getServicePolicyInfoEnableVoice();
    }

    public void sendHandlerMessage(int msg, Bundle bundle) {
        logI("sendHandlerMessage msg: " + msg);
        Message msg2 = new Message();
        msg2.what = msg;
        msg2.obj = bundle;
        this.mHandler.sendMessage(msg2);
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void NotifyCallDisconnected(Destination destination, int HangupReason) {
        if (this.mChatonVoIPManagerService != null) {
            logI("notifyCallDisconnected");
            this.isExistReservedAction = (short) -1;
            doNotifyCallDisconnected(destination, HangupReason);
            return;
        }
        logI("notifyCallDisconnected - mChatonVoIPManagerService is NULL - try to Bind");
        this.isExistReservedAction = (short) 0;
        if (destination.getDestinationType() == 2) {
            this.backupDestination = new Destination(2, destination.getPhoneNo());
        } else {
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
        }
        this.backupDestination.copyDestination(destination);
        this.backupHangupReason = HangupReason;
        bindSAPProviderService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotifyCallDisconnected(Destination destination, int hangupReason) {
        try {
            logI("doNotifyCallDisconnected CallInstanceID : " + destination.getCallInstanceID());
            this.mChatonVoIPManagerService.notifyCallDisconnected(destination.getCallInstanceID(), hangupReason);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void NotifyCallConnected(Destination destination) {
        if (this.mChatonVoIPManagerService != null) {
            logI("notifyCallConnected");
            this.isExistReservedAction = (short) -1;
            doNotifyCallConnected(destination);
            return;
        }
        logI("notifyCallConnected - mChatonVoIPManagerService is NULL - try to Bind");
        this.isExistReservedAction = (short) 1;
        if (destination.getDestinationType() == 2) {
            this.backupDestination = new Destination(2, destination.getPhoneNo());
        } else {
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
        }
        this.backupDestination.copyDestination(destination);
        bindSAPProviderService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotifyCallConnected(Destination destination) {
        try {
            logI("doNotifyCallConnected CallInstanceID : " + destination.getCallInstanceID());
            this.mChatonVoIPManagerService.notifyCallConnected(destination.getCallInstanceID());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void NotifyP2PCallRinging(Destination destination, boolean isVideoCall) {
        this.isCallReceiveFromWatch = false;
        if (this.mChatonVoIPManagerService != null) {
            logI("notifyP2PCallRinging");
            this.isExistReservedAction = (short) -1;
            doNotifyP2PCallRinging(destination, isVideoCall);
        } else {
            logI("notifyP2PCallRinging - mChatonVoIPManagerService is NULL - try to Bind");
            this.isExistReservedAction = (short) 2;
            this.backupDestination = new Destination(2, destination.getPhoneNo());
            this.backupDestination.copyDestination(destination);
            this.backupIsVideoCall = isVideoCall;
            bindSAPProviderService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotifyP2PCallRinging(Destination destination, boolean isVideoCall) {
        ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
        try {
            logI("doNotifyP2PCallRinging CallInstanceID : " + destination.getCallInstanceID());
            String userName = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getDisplayNameByUserID(destination.getPhoneNo());
            boolean isKnownBuddy = false;
            if (chatonservice.isChatOnBuddy(destination.getPhoneNo()) == 4) {
                isKnownBuddy = true;
            }
            this.mChatonVoIPManagerService.notifyP2PCallRinging(destination.getCallInstanceID(), destination.getPhoneNo(), userName, isVideoCall, isKnownBuddy);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void NotifyConferenceCallRinging(Destination destination, boolean isVideoCall) {
        this.isCallReceiveFromWatch = false;
        if (this.mChatonVoIPManagerService != null) {
            logI("notifyConferenceCallRinging");
            this.isExistReservedAction = (short) -1;
            doNotifyConferenceCallRinging(destination, isVideoCall);
        } else {
            logI("notifyConferenceCallRinging - mChatonVoIPManagerService is NULL - try to Bind");
            this.isExistReservedAction = (short) 3;
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
            this.backupDestination.copyDestination(destination);
            this.backupIsVideoCall = isVideoCall;
            bindSAPProviderService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotifyConferenceCallRinging(Destination destination, boolean isVideoCall) {
        ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
        try {
            logI("doNotifyConferenceCallRinging CallInstanceID : " + destination.getCallInstanceID());
            String parti1Id = ((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserID();
            String parti2Id = ((SimpleUserInfo) destination.getConferenceMember().get(1)).getUserID();
            String parti1Name = ((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserName();
            String parti2Name = ((SimpleUserInfo) destination.getConferenceMember().get(1)).getUserName();
            List<String> participants = new ArrayList<>();
            List<String> participantsNames = new ArrayList<>();
            boolean isKnownBuddy = false;
            if (SimpleUserInfo.TYPE_HOST.equals(((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserType())) {
                if (chatonservice.isChatOnBuddy(parti1Id) == 4) {
                    isKnownBuddy = true;
                }
                participants.add(parti1Id);
                participants.add(parti2Id);
                participantsNames.add(parti1Name);
                participantsNames.add(parti2Name);
            } else {
                if (chatonservice.isChatOnBuddy(parti1Id) == 4) {
                    isKnownBuddy = true;
                }
                participants.add(parti2Id);
                participants.add(parti1Id);
                participantsNames.add(parti2Name);
                participantsNames.add(parti1Name);
            }
            this.mChatonVoIPManagerService.notifyConferenceCallRinging(destination.getCallInstanceID(), participants, participantsNames, null, isVideoCall, isKnownBuddy);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.coolots.sso.IEntitlementUIController
    public void onStartCall() {
        logI("Call Success!!!!!");
        Bundle extras = this.mEntitlementUIController.getExtras();
        Destination destination = (Destination) extras.getParcelable("destination");
        int callKind = extras.getInt("kindOfCall");
        notifyStartCallResult(destination, true);
        sendCallRequest(callKind, destination);
    }

    @Override // com.coolots.sso.IEntitlementUIController
    public void onEndProcess() {
        if (this.mEntitlementUIController != null) {
            this.mEntitlementUIController.dispose();
            this.mEntitlementUIController = null;
        }
    }

    @Override // com.coolots.sso.IEntitlementUIController
    public void onFailToStartCall() {
        logI("Call Fail!!!!!");
        Bundle extras = this.mEntitlementUIController.getExtras();
        Destination destination = (Destination) extras.getParcelable("destination");
        notifyStartCallResult(destination, false);
    }

    private void notifyStartCallResult(Destination destination, boolean isStartCall) {
        if (this.mChatonVoIPManagerService != null) {
            logI("notifyStartCallResult");
            this.isExistReservedAction = (short) -1;
            doNotifyStartCallResult(destination, isStartCall);
            return;
        }
        logI("notifyStartCallResult  - mChatonVoIPManagerService is NULL - try to Bind result?" + isStartCall);
        this.isExistReservedAction = (short) 4;
        if (destination.getDestinationType() == 2) {
            this.backupDestination = new Destination(2, destination.getPhoneNo());
        } else {
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
        }
        this.backupDestination.copyDestination(destination);
        this.backupIsStartCall = isStartCall;
        bindSAPProviderService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotifyStartCallResult(Destination destination, boolean isStartCall) {
        try {
            logI("doNotifyStartCallResult CallInstanceID : " + destination.getCallInstanceID());
            this.mChatonVoIPManagerService.notifyStartCallResult(destination.getCallInstanceID(), isStartCall);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void NotifyP2PCallOutFromPhone(Destination destination, boolean isVideoCall) {
        this.isCallReceiveFromWatch = false;
        if (this.mChatonVoIPManagerService != null) {
            logI("NotifyP2PCallOutFromPhone");
            this.isExistReservedAction = (short) -1;
            doNotifyStartOutGoingP2PCall(destination, isVideoCall);
        } else {
            logI("NotifyP2PCallOutFromPhone - mChatonVoIPManagerService is NULL - try to Bind");
            this.isExistReservedAction = (short) 5;
            this.backupDestination = new Destination(2, destination.getPhoneNo());
            this.backupDestination.copyDestination(destination);
            this.backupIsVideoCall = isVideoCall;
            bindSAPProviderService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotifyStartOutGoingP2PCall(Destination destination, boolean isVideoCall) {
        try {
            logI("doNotifyStartOutGoingP2PCall CallInstanceID : " + destination.getCallInstanceID());
            String userName = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getDisplayNameByUserID(destination.getPhoneNo());
            this.mChatonVoIPManagerService.notifyP2PCallOutFromPhone(destination.getCallInstanceID(), destination.getPhoneNo(), userName, isVideoCall);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void NotifyConfCallOutFromPhone(Destination destination, boolean isVideoCall) {
        this.isCallReceiveFromWatch = false;
        if (this.mChatonVoIPManagerService != null) {
            logI("NotifyConfCallOutFromPhone");
            this.isExistReservedAction = (short) -1;
            doNotifyStartOutGoingConferenceCall(destination, isVideoCall);
        } else {
            logI("NotifyConfCallOutFromPhone - mChatonVoIPManagerService is NULL - try to Bind");
            this.isExistReservedAction = (short) 6;
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
            this.backupDestination.copyDestination(destination);
            this.backupIsVideoCall = isVideoCall;
            bindSAPProviderService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotifyStartOutGoingConferenceCall(Destination destination, boolean isVideoCall) {
        try {
            logI("doNotifyConferenceCallRinging CallInstanceID : " + destination.getCallInstanceID());
            String parti1Id = ((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserID();
            String parti2Id = ((SimpleUserInfo) destination.getConferenceMember().get(1)).getUserID();
            String parti1Name = ((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserName();
            String parti2Name = ((SimpleUserInfo) destination.getConferenceMember().get(1)).getUserName();
            List<String> participants = new ArrayList<>();
            participants.add(parti1Id);
            participants.add(parti2Id);
            List<String> participantsNames = new ArrayList<>();
            participantsNames.add(parti1Name);
            participantsNames.add(parti2Name);
            this.mChatonVoIPManagerService.notifyConfCallOutFromPhone(destination.getCallInstanceID(), participants, participantsNames, null, isVideoCall);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void NotifyHoldStateToWatch(Destination destination, boolean holdState) {
        if (this.mChatonVoIPManagerService != null) {
            logI("NotifyHoldStateToWatch");
            this.isExistReservedAction = (short) -1;
            doNotifyHoldStateToWatch(destination, holdState);
            return;
        }
        logI("NotifyHoldStateToWatch - mChatonVoIPManagerService is NULL - try to Bind");
        this.isExistReservedAction = (short) 7;
        if (destination.getDestinationType() == 2) {
            this.backupDestination = new Destination(2, destination.getPhoneNo());
        } else {
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
        }
        this.backupDestination.copyDestination(destination);
        this.backupHoldState = holdState;
        bindSAPProviderService();
    }

    public void doNotifyHoldStateToWatch(Destination destination, boolean holdState) {
        try {
            logI("doNotifyHoldStateToWatch CallInstanceID : " + destination.getCallInstanceID());
            this.mChatonVoIPManagerService.notifyHoldState(destination.getCallInstanceID(), holdState);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void NotifyMuteStateToWatch(Destination destination, boolean muteState) {
        if (this.mChatonVoIPManagerService != null) {
            logI("NotifyMuteStateToWatch");
            this.isExistReservedAction = (short) -1;
            doNotifyMuteStateToWatch(destination, muteState);
            return;
        }
        logI("NotifyMuteStateToWatch - mChatonVoIPManagerService is NULL - try to Bind");
        this.isExistReservedAction = (short) 8;
        if (destination.getDestinationType() == 2) {
            this.backupDestination = new Destination(2, destination.getPhoneNo());
        } else {
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
        }
        this.backupDestination.copyDestination(destination);
        this.backupMuteState = muteState;
        bindSAPProviderService();
    }

    public void doNotifyMuteStateToWatch(Destination destination, boolean muteState) {
        try {
            logI("doNotifyMuteStateToWatch CallInstanceID : " + destination.getCallInstanceID());
            this.mChatonVoIPManagerService.notifyMuteState(destination.getCallInstanceID(), muteState);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void notifyChangeConfToP2PCall(Destination destination, boolean isVideoCall) {
        if (this.mChatonVoIPManagerService != null) {
            logI("notifyChangeConfToP2PCall");
            this.isExistReservedAction = (short) -1;
            doNotifyChangeConfToP2PCall(destination, isVideoCall);
        } else {
            logI("notifyChangeConfToP2PCall - mChatonVoIPManagerService is NULL - try to Bind");
            this.isExistReservedAction = (short) 10;
            this.backupDestination = new Destination(2, destination.getPhoneNo());
            this.backupDestination.copyDestination(destination);
            this.backupIsVideoCall = isVideoCall;
            bindSAPProviderService();
        }
    }

    public void doNotifyChangeConfToP2PCall(Destination destination, boolean isVideoCall) {
        try {
            logI("doNotifyChangeConfToP2PCall CallInstanceID : " + destination.getCallInstanceID());
            String userName = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getDisplayNameByUserID(destination.getPhoneNo());
            this.mChatonVoIPManagerService.notifyChangeConfToP2PCall(destination.getCallInstanceID(), destination.getPhoneNo(), userName, isVideoCall);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void notifyChangeP2PToConfCall(Destination destination, boolean isVideoCall) {
        if (this.mChatonVoIPManagerService != null) {
            logI("notifyChangeP2PToConfCall");
            this.isExistReservedAction = (short) -1;
            doNotifyChangeP2PToConfCall(destination, isVideoCall);
        } else {
            logI("notifyChangeP2PToConfCall - mChatonVoIPManagerService is NULL - try to Bind");
            this.isExistReservedAction = (short) 11;
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
            this.backupDestination.copyDestination(destination);
            this.backupIsVideoCall = isVideoCall;
            bindSAPProviderService();
        }
    }

    public void doNotifyChangeP2PToConfCall(Destination destination, boolean isVideoCall) {
        try {
            logI("doNotifyChangeP2PToConfCall CallInstanceID : " + destination.getCallInstanceID());
            String parti1Id = ((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserID();
            String parti2Id = ((SimpleUserInfo) destination.getConferenceMember().get(1)).getUserID();
            String parti1Name = ((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserName();
            String parti2Name = ((SimpleUserInfo) destination.getConferenceMember().get(1)).getUserName();
            List<String> participants = new ArrayList<>();
            List<String> participantsNames = new ArrayList<>();
            if (SimpleUserInfo.TYPE_HOST.equals(((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserType())) {
                participants.add(parti1Id);
                participants.add(parti2Id);
                participantsNames.add(parti1Name);
                participantsNames.add(parti2Name);
            } else {
                participants.add(parti2Id);
                participants.add(parti1Id);
                participantsNames.add(parti2Name);
                participantsNames.add(parti1Name);
            }
            this.mChatonVoIPManagerService.notifyChangeP2PToConfCall(destination.getCallInstanceID(), participants, participantsNames, null, isVideoCall);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void notifyChangeCallType(Destination destination, boolean isVideoCall) {
        if (this.mChatonVoIPManagerService != null) {
            logI("notifyChangeCallType");
            this.isExistReservedAction = (short) -1;
            doNotifyChangeCallType(isVideoCall);
            return;
        }
        logI("notifyChangeCallType - mChatonVoIPManagerService is NULL - try to Bind");
        this.isExistReservedAction = (short) 9;
        if (destination.getDestinationType() == 2) {
            this.backupDestination = new Destination(2, destination.getPhoneNo());
        } else {
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
        }
        this.backupDestination.copyDestination(destination);
        this.backupIsVideoCall = isVideoCall;
        bindSAPProviderService();
    }

    public void doNotifyChangeCallType(boolean isVideoCall) {
        try {
            logI("doNotifyChangeCallType isVideoCall : " + isVideoCall);
            this.mChatonVoIPManagerService.notifyChangeCallType(isVideoCall);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void notifyStopRingtone(Destination destination) {
        if (this.mChatonVoIPManagerService != null) {
            logI("notifyStopRingtone");
            this.isExistReservedAction = (short) -1;
            doNotifyStopRingtone(destination);
            return;
        }
        logI("notifyStopRingtone - mChatonVoIPManagerService is NULL - try to Bind");
        this.isExistReservedAction = (short) 12;
        if (destination.getDestinationType() == 2) {
            this.backupDestination = new Destination(2, destination.getPhoneNo());
        } else {
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
        }
        this.backupDestination.copyDestination(destination);
        bindSAPProviderService();
    }

    public void doNotifyStopRingtone(Destination destination) {
        try {
            logI("doNotifyStopRingtone ");
            this.mChatonVoIPManagerService.notifyStopRingtone(destination.getCallInstanceID());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void notifyUpdateConferenceMember(Destination destination, boolean isVideoCall) {
        if (this.mChatonVoIPManagerService != null) {
            logI("notifyUpdateConferenceMember");
            this.isExistReservedAction = (short) -1;
            doNotifyUpdateConferenceMember(destination, isVideoCall);
        } else {
            logI("notifyUpdateConferenceMember - mChatonVoIPManagerService is NULL - try to Bind");
            this.isExistReservedAction = (short) 13;
            this.backupDestination = new Destination("", destination.getConferenceMember(), destination.getGroupName());
            this.backupDestination.copyDestination(destination);
            this.backupIsVideoCall = isVideoCall;
            bindSAPProviderService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotifyUpdateConferenceMember(Destination destination, boolean isVideoCall) {
        try {
            logI("doNotifyUpdateConferenceMember CallInstanceID : " + destination.getCallInstanceID() + "/ Video?" + isVideoCall);
            if (destination.getConferenceMember() == null || destination.getConferenceMember().isEmpty()) {
                logI("doNotifyUpdateConferenceMember - getConferenceMember is NULL");
                return;
            }
            String parti1Id = ((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserID();
            String parti2Id = ((SimpleUserInfo) destination.getConferenceMember().get(1)).getUserID();
            String parti1Name = ((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserName();
            String parti2Name = ((SimpleUserInfo) destination.getConferenceMember().get(1)).getUserName();
            String parti1Status = ((SimpleUserInfo) destination.getConferenceMember().get(0)).getStatus();
            String parti2Status = ((SimpleUserInfo) destination.getConferenceMember().get(1)).getStatus();
            List<String> participants = new ArrayList<>();
            List<String> participantsNames = new ArrayList<>();
            List<String> participantsStatus = new ArrayList<>();
            if (SimpleUserInfo.TYPE_HOST.equals(((SimpleUserInfo) destination.getConferenceMember().get(0)).getUserType())) {
                participants.add(parti1Id);
                participants.add(parti2Id);
                participantsNames.add(parti1Name);
                participantsNames.add(parti2Name);
                participantsStatus.add(parti1Status);
                participantsStatus.add(parti2Status);
            } else {
                participants.add(parti2Id);
                participants.add(parti1Id);
                participantsNames.add(parti2Name);
                participantsNames.add(parti1Name);
                participantsStatus.add(parti2Status);
                participantsStatus.add(parti1Status);
            }
            this.mChatonVoIPManagerService.notifyUpdateConferenceMember(destination.getCallInstanceID(), participants, participantsNames, participantsStatus, null, isVideoCall);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public boolean isCallReceiveFromWatch() {
        return this.isCallReceiveFromWatch;
    }

    @Override // com.sds.coolots.call.model.watch.IWatchCallbackInterface
    public void setCallReceiveFromWatch(boolean callReceiveFromWatch) {
        this.isCallReceiveFromWatch = callReceiveFromWatch;
    }
}
