package com.coolots.sso;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BatteryInfo;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.join.ChatONJoinManagerInterface;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.CallStateCallBack;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.controller.EventHandlerInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.coolotsinterface.ISSOCallCallBack;
import com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sec.chaton.clientapi.GraphAPI;
import com.sec.chaton.clientapi.UtilityAPI;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class SSOManager implements EventHandlerInterface, CallStateCallBack, ISSOCallCallBack, IEntitlementUIController {
    public static final String CALL_DESTINATION = "call_destination";
    private static final int CHECK_ENVIRONMENT_ERROR_ACCOUNT_NONE = 1;
    private static final int CHECK_ENVIRONMENT_ERROR_AIRPLAINMODE = 3;
    private static final int CHECK_ENVIRONMENT_ERROR_BATTERY_LOW = 2;
    private static final int CHECK_ENVIRONMENT_ERROR_BUSY_3GCALL = 5;
    private static final int CHECK_ENVIRONMENT_ERROR_BUSY_CALL = 7;
    private static final int CHECK_ENVIRONMENT_ERROR_CHATON_ACCOUNT_NONE = 9;
    private static final int CHECK_ENVIRONMENT_ERROR_IN_LOGIN_PROCESS = 6;
    private static final int CHECK_ENVIRONMENT_ERROR_NETWORK_CONNECTION = 4;
    private static final int CHECK_ENVIRONMENT_ERROR_SUCCESS = 0;
    private static final int CHECK_ENVIRONMENT_ERROR_WIFI_ONLY_MODE = 8;
    public static final int ENTITLEMENT_TIMER_COUNT_MAX = 5000;
    public static final int FLAG_GROUP_VIDEO_CALL = 5;
    public static final int FLAG_GROUP_VOICE_CALL = 4;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_VIDEO_CALL = 3;
    public static final int FLAG_VOICE_CALL = 2;
    public static final int FLAG_VOICE_SIP_CALL = 1;
    public static final boolean ISCONNECT_REALCHATON = true;
    private static final int LOGIN_TIMER_COUNT_MAX = 5000;
    private static Toast mToast;
    private EntitlementUIController mEntitlementUIController;
    private InformationActivityGeneratorInterface mPopup;
    private int mLoginFlag = 0;
    private boolean mCallFlag = false;
    private final Handler mHandler = new Handler() { // from class: com.coolots.sso.SSOManager.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!SSOManager.this.processEtcEventMessage(msg)) {
                SSOManager.this.processCallEventMessage(msg);
            }
            super.handleMessage(msg);
        }
    };
    private List<Destination> mDestinations = null;
    private boolean mIsLiveShareCall = false;
    public TelephonyManager telephonyManager = null;
    private boolean mIsChangeToConference = false;
    private boolean mIsChangeToP2P = false;

    private void logE(String message) {
        Log.m2958e("[SSOManager]" + message);
    }

    private void logI(String message) {
        Log.m2963i("[SSOManager]" + message);
    }

    public SSOManager() {
        MainApplication.mPhoneManager.getLoginManager().setLoginActivity(this);
        MainApplication.mPhoneManager.getPhoneStateMachine().addCallBack(this);
        MainApplication.mPhoneManager.getJoinManager().setJoinActivity(this);
        MainApplication.mPhoneManager.getPhoneStateMachine().setSSOCallCallback(this);
        mToast = Toast.makeText(MainApplication.mContext, "null", 0);
        this.mPopup = MainApplication.mInformationActivityGenerator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processEtcEventMessage(Message msg) {
        logI("processEtcEventMessage() msg.what: " + msg.what);
        switch (msg.what) {
            case 1010:
            case 3004:
            case 3006:
            case EventCode.EVENT_LOGIN_NO_NUMBER /* 3099 */:
                break;
            case 1011:
            case EventCode.EVNET_JOIN_NETWORK_ERROR /* 1041 */:
            case EventCode.EVENT_JOIN_FAIL /* 1042 */:
                MainApplication.mChatONInterface.sendBroadcastCreateAccountResult(false, ((ChatOnResourceInterface) MainApplication.mResources).getJoinServerAccessErrorString());
                break;
            case EventCode.EVENT_JOIN_SUCCESS /* 1040 */:
                MainApplication.mChatONInterface.sendBroadcastCreateAccountResult(true);
                break;
            case 3001:
            case 3010:
                logI("EVENT_LOGIN_CANCEL || EVENT_LOGIN_FAIL");
                if (this.mDestinations != null) {
                    this.mDestinations.clear();
                }
                cancelLoginTimer();
                setLoginFlag(0);
                this.mPopup.changeDialogInformationActivity(15);
                break;
            case 3002:
                MainApplication.mPhoneManager.getLoginManager().setNonce("");
                if (!MainApplication.mPhoneManager.getLoginManager().isLogin() && !MainApplication.mPhoneManager.getLoginManager().isDuringLogin()) {
                    MainApplication.mPhoneManager.getLoginManager().login();
                    break;
                }
                break;
            case EventCode.EVENT_LOGIN_FINISH /* 3999 */:
                remainingProcessCheck();
                cancelLoginTimer();
                setLoginFlag(0);
                break;
            case EventCode.EVENT_START_LOGIN_TIMEOUT /* 40006 */:
                logI("EVENT_START_LOGIN_TIMEOUT");
                if (this.mDestinations != null) {
                    this.mDestinations.clear();
                }
                setLoginFlag(0);
                this.mPopup.changeDialogInformationActivity(15);
                break;
            default:
                return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCallEventMessage(Message msg) {
        Bundle bundle = (Bundle) msg.obj;
        if (bundle != null) {
            int callKind = msg.what;
            logI("processCallEventMessage() callKind: " + callKind);
            Destination destination = (Destination) bundle.getParcelable("call_destination");
            if (destination == null) {
                logE("Call Fail: destination is none!!");
                return;
            }
            int ret = checkEnvironment(callKind == 40003 || callKind == 40005);
            if (ret == 6 || ret == 1) {
                startLoginTimer();
                setLoginFlags(callKind);
                if (this.mDestinations == null) {
                    this.mDestinations = new ArrayList();
                }
                this.mDestinations.add(destination);
            } else if (ret == 0) {
                Bundle extras = new Bundle();
                extras.putParcelable("destination", destination);
                extras.putInt("call_kind", callKind);
                this.mEntitlementUIController = new EntitlementUIController();
                this.mEntitlementUIController.setBundle(extras);
                this.mEntitlementUIController.start(this, true, isVideoCallType(callKind), false);
            }
            setCallFlag(false);
        }
    }

    public int checkEnvironment(boolean isVideoCall) {
        int ret = 0;
        if (!checkChatONAccountValidity()) {
            logE("ChatON account does not exist");
            startChatONForCreateAccount();
            return 9;
        }
        if (!checkCooLotsAccountValidity()) {
            logE("Call Fail: Account is none!!");
            startChatONForCreateAccount();
            return 1;
        }
        if (!VAppPhoneManager.isCoolotsServiceRunning(MainApplication.mContext)) {
            logE("checkEnvironment- startCoolotsService!!");
            VAppPhoneManager.startCoolotsService(MainApplication.mContext, false);
        }
        BatteryInfo batteryInfo = new BatteryInfo();
        if (!batteryInfo.isCharging() && batteryInfo.isLowBattery() && isVideoCall) {
            logE("Call Fail: Battery Low");
            ret = 2;
            int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getStringLowBattery();
            String rscString = "";
            if (rscNumber > 0) {
                rscString = MainApplication.mContext.getString(rscNumber);
            }
            mToast.setText(rscString);
            mToast.show();
        } else if (checkAirPlainMode() && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
            logE("Call Fail: Airplain Mode");
            ret = 3;
            this.mPopup.viewInformationActivity(2);
        } else if (!PhoneManager.isNetworkConnected(MainApplication.mContext)) {
            logE("Call Fail: Network Disconnected");
            ret = 4;
            this.mPopup.viewInformationActivity(1);
        } else if (ChatONSettingData.getInstance().isUseWifiOnly() && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
            logE("Call Fail: Wifi only mode");
            ret = 8;
            this.mPopup.viewInformationActivity(1);
        } else if (!MainApplication.mPhoneManager.getLoginManager().isLogin()) {
            logE("Call Fail: Logout!!!!!");
            MainApplication.mPhoneManager.getLoginManager().login();
            ret = 6;
            this.mPopup.viewInformationActivity(7);
        }
        return ret;
    }

    public static boolean checkChatONAccountValidity() {
        try {
            boolean isAvailable = UtilityAPI.isChatONActivated(MainApplication.mContext);
            return isAvailable;
        } catch (NotAvailableClientAPIException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void startChatONForCreateAccount() {
        logI("startChatONForCreateAccount()");
        Intent intent = new Intent();
        intent.setAction("com.sec.chaton.action.CREATE_ACCOUNT_CHATONV");
        intent.setFlags(268435456);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        MainApplication.mContext.startActivity(intent);
    }

    public void startLoginTimer() {
        logE("Login Timer scheduling start");
        this.mHandler.removeMessages(EventCode.EVENT_START_LOGIN_TIMEOUT);
        sendHandlerMessage(EventCode.EVENT_START_LOGIN_TIMEOUT, Config.DISCONNECT_TIMEOUT);
    }

    public void cancelLoginTimer() {
        logE("Login Timer scheduling cancel (Login success!!!)");
        this.mHandler.removeMessages(EventCode.EVENT_START_LOGIN_TIMEOUT);
    }

    private boolean isWorking() {
        if (getLoginFlag() > 0) {
            logI("Call Fail: in login process: ignore");
            this.mPopup.viewInformationActivity(7);
            startLoginTimer();
            return true;
        }
        if (getCallFlag()) {
            logI("Call Fail: in call process: ignore");
            return true;
        }
        setCallFlag(true);
        return false;
    }

    public boolean checkCooLotsAccountValidity() {
        String userID = MainApplication.mConfig.getProfileUserID();
        String backupID = ((ChatOnConfigInterface) MainApplication.mConfig).getBackupJoinUserID();
        if (userID == null || userID.isEmpty()) {
            return (backupID == null || backupID.isEmpty()) ? false : true;
        }
        return true;
    }

    private void setLoginFlags(int callInfo) {
        logI("setLoginFlags(" + callInfo + ")");
        switch (callInfo) {
            case EventCode.EVENT_START_SIP_VOICE_CALL /* 40001 */:
                setLoginFlag(1);
                break;
            case EventCode.EVENT_START_P2P_VOICE_CALL /* 40002 */:
                setLoginFlag(2);
                break;
            case EventCode.EVENT_START_P2P_VIDEO_CALL /* 40003 */:
                setLoginFlag(3);
                break;
            case EventCode.EVENT_START_GROUP_VOICE_CALL /* 40004 */:
                setLoginFlag(4);
                break;
            case EventCode.EVENT_START_GROUP_VIDEO_CALL /* 40005 */:
                setLoginFlag(5);
                break;
            default:
                setLoginFlag(0);
                break;
        }
    }

    public void clearDataBeforeStartCall() {
        this.mIsChangeToConference = false;
        this.mIsChangeToP2P = false;
    }

    private boolean isVideoCallType(int callKind) {
        return callKind == 40003 || callKind == 40005;
    }

    private void sendCallRequest(int callKind, Destination destination) {
        logI("sendCallRequest() " + callKind);
        if (checkServicePolicyInfo(callKind)) {
            PhoneStateMachine instance = MainApplication.mPhoneManager.getPhoneStateMachine();
            int ret = 0;
            String myName = MainApplication.mConfig.getProfileUserName();
            logI("sendCallRequest() myName: " + myName);
            switch (callKind) {
                case EventCode.EVENT_START_SIP_VOICE_CALL /* 40001 */:
                    ret = instance.startOutGoingCall(destination, false, this.mIsLiveShareCall, myName);
                    break;
                case EventCode.EVENT_START_P2P_VOICE_CALL /* 40002 */:
                    ret = instance.startOutGoingCall(destination, false, this.mIsLiveShareCall, myName);
                    break;
                case EventCode.EVENT_START_P2P_VIDEO_CALL /* 40003 */:
                    ret = instance.startOutGoingCall(destination, true, this.mIsLiveShareCall, myName);
                    break;
                case EventCode.EVENT_START_GROUP_VOICE_CALL /* 40004 */:
                    if (checkGroupCallMemberValidity(destination, false)) {
                        ret = instance.startOutGoingCall(destination, false, this.mIsLiveShareCall, myName);
                        break;
                    }
                    break;
                case EventCode.EVENT_START_GROUP_VIDEO_CALL /* 40005 */:
                    if (checkGroupCallMemberValidity(destination, true)) {
                        ret = instance.startOutGoingCall(destination, true, this.mIsLiveShareCall, myName);
                        break;
                    }
                    break;
                default:
                    ret = PhoneStateMachine.ERROR_UNKNOWN;
                    break;
            }
            if (ret == -1011) {
                this.mPopup.viewInformationActivity(4);
            } else if (ret == -1012) {
                this.mPopup.viewInformationActivity(9);
            } else if (ret == -1020) {
                this.mPopup.viewInformationActivity(19);
            }
        }
    }

    private boolean checkServicePolicyInfo(int callKind) {
        if (callKind == 40002 || callKind == 40004) {
            if (!((ChatOnConfigInterface) MainApplication.mConfig).getServicePolicyInfoEnableVoice()) {
                this.mPopup.viewInformationActivity(17);
                return false;
            }
        } else if ((callKind == 40003 || callKind == 40005) && !((ChatOnConfigInterface) MainApplication.mConfig).getServicePolicyInfoEnableVideo()) {
            this.mPopup.viewInformationActivity(18);
            return false;
        }
        return true;
    }

    private boolean checkGroupCallMemberValidity(Destination dest, boolean isVideo) {
        logI("checkGroupCallMemberValidity()");
        if (dest.getDestinationType() == 4) {
            if (dest.getConferenceMember() == null || dest.getConferenceMember().isEmpty()) {
                this.mPopup.viewInformationActivity(5);
                return false;
            }
            if (dest.getConferenceMember().size() >= ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(isVideo)) {
                this.mPopup.viewInformationActivity(6, isVideo);
                return false;
            }
        } else if (dest.getDestinationType() == 5) {
            if (dest.getP2PConferenceMember() == null || dest.getP2PConferenceMember().isEmpty()) {
                this.mPopup.viewInformationActivity(5);
                return false;
            }
            if (dest.getP2PConferenceMember().size() >= ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(isVideo)) {
                this.mPopup.viewInformationActivity(6, isVideo);
                return false;
            }
        }
        return true;
    }

    private void remainingProcessCheck() {
        logI("remainingProcessCheck() LoginFlag: " + getLoginFlag());
        if (this.mDestinations == null || this.mDestinations.isEmpty()) {
            logI("Destinations are null or empty");
            this.mPopup.finishDialogInformationActivity();
        }
        Destination destination = this.mDestinations.get(0);
        this.mDestinations.remove(0);
        if (destination == null) {
            logI("Destination is null");
            this.mPopup.finishDialogInformationActivity();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("call_destination", destination);
        switch (getLoginFlag()) {
            case 0:
                logI("Call ignore!!!");
                break;
            case 1:
                sendHandlerMessage(EventCode.EVENT_START_SIP_VOICE_CALL, 0L, bundle);
                break;
            case 2:
                sendHandlerMessage(EventCode.EVENT_START_P2P_VOICE_CALL, 0L, bundle);
                break;
            case 3:
                sendHandlerMessage(EventCode.EVENT_START_P2P_VIDEO_CALL, 0L, bundle);
                break;
            case 4:
                sendHandlerMessage(EventCode.EVENT_START_GROUP_VOICE_CALL, 0L, bundle);
                break;
            case 5:
                sendHandlerMessage(EventCode.EVENT_START_GROUP_VIDEO_CALL, 0L, bundle);
                break;
        }
    }

    public boolean getCallFlag() {
        logI("getCallFlag()" + this.mCallFlag);
        return this.mCallFlag;
    }

    public void setCallFlag(boolean callFlag) {
        logI("setCallFlag()" + callFlag);
        this.mCallFlag = callFlag;
    }

    public int getLoginFlag() {
        logI("getLoginFlag()" + this.mLoginFlag);
        return this.mLoginFlag;
    }

    public void setLoginFlag(int loginFlag) {
        logI("setLoginFlag()" + this.mLoginFlag + " => " + loginFlag);
        this.mLoginFlag = loginFlag;
    }

    public boolean createAccount() {
        ChatONMyInfo myInfo = getChatONMyInfo();
        if (myInfo == null || myInfo.mMSISDN == null || myInfo.mMSISDN.length() == 0 || myInfo.mNationalCode == null || myInfo.mNationalCode.length() == 0) {
            logI("createAccount MSISDN or National code is null");
            return false;
        }
        logI("createAccount1 MSISDN: " + myInfo.mMSISDN + " , National code: " + myInfo.mNationalCode);
        if (MainApplication.mPhoneManager.getLoginManager().isLogin()) {
            MainApplication.mChatONInterface.sendBroadcastCreateAccountResult(true);
            return true;
        }
        startService(MainApplication.mContext, true);
        MainApplication.mPhoneManager.getJoinManager().setJoinMember(myInfo.mMSISDN, "", "", "", "", myInfo.mNationalCode);
        return true;
    }

    public boolean createAccount(String MSISDN, String nationalCode) {
        if (MSISDN == null || MSISDN.length() == 0 || nationalCode == null || nationalCode.length() == 0) {
            logI("createAccount MSISDN or National code is null");
            return false;
        }
        logI("createAccount2 MSISDN: " + MSISDN + " , National code: " + nationalCode);
        if (MainApplication.mPhoneManager.getLoginManager().isLogin()) {
            MainApplication.mChatONInterface.sendBroadcastCreateAccountResult(true);
            return true;
        }
        startService(MainApplication.mContext, true);
        MainApplication.mPhoneManager.getJoinManager().setJoinMember(MSISDN, "", "", "", "", nationalCode);
        return true;
    }

    public boolean createAccount(String MSISDN, String nationalCode, String callerName, String GUID, String chatONNO, String IMEI, String chatONUID, String birthday) {
        logI("createAccount7 National code: " + nationalCode + ", calllerName: " + callerName + ", GUID: " + GUID + ", chatONNO: " + chatONNO + ", chatONUID: " + chatONUID + ", birthday: " + birthday);
        if (MainApplication.mPhoneManager.getLoginManager().isLogin()) {
            MainApplication.mChatONInterface.sendBroadcastCreateAccountResult(true);
            return true;
        }
        startService(MainApplication.mContext, true);
        ((ChatONJoinManagerInterface) MainApplication.mPhoneManager.getJoinManager()).setJoinActivity(this);
        ((ChatONJoinManagerInterface) MainApplication.mPhoneManager.getJoinManager()).setChatONJoinMember(MSISDN, callerName, nationalCode, GUID, chatONNO, IMEI, chatONUID, birthday);
        return true;
    }

    public void deleteAccount() {
        logI("deleteAccount");
        if (!checkCooLotsAccountValidity()) {
            logI("deleteAccount() Account is already deleted.");
            MainApplication.mChatONInterface.sendBroadcastRemoveAccountResult(true);
        } else if (MainApplication.mPhoneManager.getLoginManager().isDuringLogin()) {
            logI("deleteAccount() during Login");
            MainApplication.mChatONInterface.sendBroadcastRemoveAccountResult(false);
        } else if (!PhoneManager.isNetworkConnected(MainApplication.mContext)) {
            logI("deleteAccount() Network Error");
            MainApplication.mChatONInterface.sendBroadcastRemoveAccountResult(false);
        } else {
            ((ChatONJoinManagerInterface) MainApplication.mPhoneManager.getJoinManager()).deleteAccount();
        }
    }

    public void sendBroadcastServicePolicyInfo() {
        boolean enableVoice = ((ChatOnConfigInterface) MainApplication.mConfig).getServicePolicyInfoEnableVoice();
        boolean enableVideo = ((ChatOnConfigInterface) MainApplication.mConfig).getServicePolicyInfoEnableVideo();
        MainApplication.mChatONInterface.sendBroadcastServicePolicyInfo(enableVoice, enableVideo);
    }

    public void sendHandlerMessage(int msg, long delay, Bundle bundle) {
        logI("sendHandlerMessage msg: " + msg);
        if (delay == 0) {
            Message msg2 = new Message();
            msg2.what = msg;
            msg2.obj = bundle;
            this.mHandler.sendMessage(msg2);
            return;
        }
        Message msg22 = new Message();
        msg22.what = msg;
        msg22.obj = bundle;
        this.mHandler.sendMessageDelayed(msg22, delay);
    }

    @Override // com.sds.coolots.common.controller.EventHandlerInterface
    public void sendHandlerMessage(int msg, long delay) {
        if (delay == 0) {
            this.mHandler.sendEmptyMessage(msg);
        } else {
            this.mHandler.sendEmptyMessageDelayed(msg, delay);
        }
    }

    public void removeHandlerMessage(int msg) {
        this.mHandler.removeMessages(msg);
    }

    @Override // com.sds.coolots.call.CallStateCallBack
    public void onCallUpdate(Message msg) {
        this.mHandler.sendMessage(msg);
    }

    public void startService(Context context, boolean force) {
        VAppPhoneManager.startCoolotsService(context, force);
    }

    public void stopService(Context context) {
        VAppPhoneManager.stopCoolotsService(context);
    }

    public boolean checkAirPlainMode() {
        if (Settings.System.getInt(MainApplication.mContext.getContentResolver(), "airplane_mode_on", 0) != 1) {
            return false;
        }
        logI("[checkCurrentNetworkConnection] airplain mode is on!");
        return true;
    }

    private class ChatONMyInfo {
        protected String mMSISDN;
        protected String mName;
        protected String mNationalCode;
        protected String mNationalNum;

        public ChatONMyInfo(String msisdn, String name, String nationalNum, String nationalCode) {
            this.mMSISDN = msisdn;
            this.mName = name;
            this.mNationalNum = nationalNum;
            this.mNationalCode = nationalCode;
        }
    }

    public ChatONMyInfo getChatONMyInfo() {
        Cursor c = null;
        ChatONMyInfo info = null;
        try {
            c = GraphAPI.getMyProfile(MainApplication.mContext);
        } catch (NotActivatedClientAPIException e1) {
            e1.printStackTrace();
        } catch (NotAvailableClientAPIException e12) {
            e12.printStackTrace();
        }
        if (c != null) {
            if (c.getCount() > 0) {
                c.moveToFirst();
                int columnID = c.getColumnIndex("id");
                int columnName = c.getColumnIndex(GraphAPI.ME_NAME);
                int columnCountryNum = c.getColumnIndex(GraphAPI.ME_COUNTRY_NUM);
                int columnCountryISOCode = c.getColumnIndex(GraphAPI.ME_COUNTRY_ISO_CODE);
                logI("id = " + c.getString(columnID) + " name = " + c.getString(columnName) + " countryNum = " + c.getString(columnCountryNum) + " countryISO = " + c.getString(columnCountryISOCode));
                info = new ChatONMyInfo("", c.getString(columnName), c.getString(columnCountryNum), c.getString(columnCountryISOCode));
            }
            c.close();
        }
        return info;
    }

    public boolean isExistChatONAccount() {
        ChatONMyInfo myInfo = getChatONMyInfo();
        return (myInfo == null || myInfo.mMSISDN == null || myInfo.mMSISDN.isEmpty()) ? false : true;
    }

    public void cancelResidualCall() {
        logI("cancelResidualCall()");
        if (this.mDestinations != null) {
            this.mDestinations.clear();
        }
        cancelLoginTimer();
        setLoginFlag(0);
    }

    public void cancelEntitlementResidualCall() {
        logI("cancelEntitlementResidualCall()");
        if (this.mDestinations != null) {
            this.mDestinations.clear();
        }
        if (this.mEntitlementUIController != null) {
            this.mEntitlementUIController.dispose();
            this.mEntitlementUIController = null;
        }
    }

    public boolean isInstalledChatON() throws PackageManager.NameNotFoundException {
        PackageManager pm = MainApplication.mContext.getPackageManager();
        try {
            pm.getApplicationInfo("com.sec.chaton", 128);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
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
        if (this.telephonyManager.getCallState() != 0) {
            logE("Call Fail: 3G call is busy");
            this.mPopup.viewInformationActivity(3);
        } else if (isCoolotsCalling()) {
            logE("Call Fail: Coolots call is busy");
            this.mPopup.viewInformationActivity(4);
        } else if (!isWorking()) {
            sendHandlerMessage(msg, 0L, bundle);
        }
    }

    private boolean isCoolotsCalling() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        return callInfo.isValidity() && !CallState.isDisconnected(callInfo.getCallState());
    }

    public boolean voiceDCallWithCaller(String MSISDN, String sessionID, String callerName, String roomNo, boolean isLiveShare) {
        if (MSISDN == null || MSISDN.length() == 0) {
            return false;
        }
        logI("voiceCallWithCaller() chatonID: " + MSISDN + " calllerName: " + callerName + " isLiveShare: " + isLiveShare);
        this.mIsLiveShareCall = isLiveShare;
        MainApplication.mConfig.setProfileUserName(callerName);
        Destination destination = new Destination(2, ChatONStringConvert.getInstance().toUserID(MSISDN));
        callProcessing(destination, EventCode.EVENT_START_P2P_VOICE_CALL);
        return true;
    }

    public boolean videoDCallWithCaller(String MSISDN, String sessionID, String callerName, String roomNo, boolean isLiveShare) {
        if (MSISDN == null || MSISDN.length() == 0) {
            return false;
        }
        logI("videoDCallWithCaller() chatonID: " + MSISDN + " calllerName: " + callerName + " isLiveShare: " + isLiveShare);
        this.mIsLiveShareCall = isLiveShare;
        MainApplication.mConfig.setProfileUserName(callerName);
        Destination destination = new Destination(2, ChatONStringConvert.getInstance().toUserID(MSISDN));
        callProcessing(destination, EventCode.EVENT_START_P2P_VIDEO_CALL);
        return true;
    }

    public boolean groupVoiceDCallWithCaller(List<String> MSISDNs, String sessionID, String callerName, String roomNo, boolean isLiveShare, String groupName) {
        int cnt = MSISDNs.size();
        if (cnt == 0) {
            return false;
        }
        logI("groupVoiceDCallWithCaller() chatonID: " + MSISDNs + " calllerName: " + callerName + " isLiveShare: " + isLiveShare + " groupName : " + groupName);
        this.mIsLiveShareCall = isLiveShare;
        MainApplication.mConfig.setProfileUserName(callerName);
        ArrayList<SimpleUserInfo> memberList = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getSimpleUserInfoFromMSISDN(MSISDNs);
        Destination destination = new Destination("", memberList, groupName);
        callProcessing(destination, EventCode.EVENT_START_GROUP_VOICE_CALL);
        return true;
    }

    public boolean groupVideoDCallWithCaller(List<String> MSISDNs, String sessionID, String callerName, String roomNo, boolean isLiveShare, String groupName) {
        int cnt = MSISDNs.size();
        if (cnt == 0) {
            return false;
        }
        logI("groupVideoDCallWithCaller() chatonID: " + MSISDNs + " calllerName: " + callerName + " isLiveShare: " + isLiveShare + " groupName : " + groupName);
        this.mIsLiveShareCall = isLiveShare;
        MainApplication.mConfig.setProfileUserName(callerName);
        ArrayList<SimpleUserInfo> memberList = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getSimpleUserInfoFromMSISDN(MSISDNs);
        Destination destination = new Destination("", memberList, groupName);
        callProcessing(destination, EventCode.EVENT_START_GROUP_VIDEO_CALL);
        return true;
    }

    @Override // com.sds.coolots.common.coolotsinterface.ISSOCallCallBack
    public void onCallState(int callState) {
        logI("onCallState(" + callState + ") mIsChangeToConference: " + this.mIsChangeToConference + ", mIsChangeToP2P: " + this.mIsChangeToP2P);
        switch (callState) {
            case -1:
            case 6:
                MainApplication.mChatONInterface.sendBroadcastCallStateChange(3);
                break;
            case 0:
                MainApplication.mChatONInterface.sendBroadcastCallStateChange(0);
                break;
            case 1:
                MainApplication.mChatONInterface.sendBroadcastCallStateChange(1);
                break;
            case 2:
                logI(">> STATE_CONNECTED");
                MainApplication.mChatONInterface.sendBroadcastCallStateChange(2);
                break;
            case 3:
                logI(">> STATE_DISCONNECTED");
                MainApplication.mChatONInterface.sendBroadcastCallStateChange(3);
                this.mIsChangeToConference = false;
                this.mIsChangeToP2P = false;
                break;
            case 4:
            case 5:
                MainApplication.mChatONInterface.sendBroadcastCallStateChange(2);
                break;
            case 100:
                this.mIsChangeToConference = false;
                this.mIsChangeToP2P = true;
                break;
            case 101:
                this.mIsChangeToConference = true;
                this.mIsChangeToP2P = false;
                break;
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.ISSOCallCallBack
    public void onCallMemberChanged() {
        logI("onCallMemberChanged()");
        MainApplication.mChatONInterface.sendBroadcastCallMemberChange();
    }

    public int translateCallState(int callState) {
        logI("translateCallState(" + callState + ") mIsChangeToConference: " + this.mIsChangeToConference + ", mIsChangeToP2P: " + this.mIsChangeToP2P);
        switch (callState) {
            case 2:
            case 4:
            case 5:
                if (!this.mIsChangeToConference) {
                    if (this.mIsChangeToP2P) {
                    }
                }
                break;
            case 3:
                if (!this.mIsChangeToConference) {
                    if (this.mIsChangeToP2P) {
                    }
                }
                break;
        }
        return 3;
    }

    @Override // com.coolots.sso.IEntitlementUIController
    public void onStartCall() {
        logI("Call Success!!!!!");
        Bundle extras = this.mEntitlementUIController.getExtras();
        Destination destination = (Destination) extras.getParcelable("destination");
        int callKind = extras.getInt("call_kind");
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
    }
}
