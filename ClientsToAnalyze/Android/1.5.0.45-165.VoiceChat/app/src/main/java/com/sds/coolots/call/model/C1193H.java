package com.sds.coolots.call.model;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MakeConferenceRep;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.NotifyBoardDataAsk;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.NotifyFinishShareCameraAsk;
import com.coolots.p2pmsg.model.NotifyStartShareScreenAsk;
import com.coolots.p2pmsg.model.NotifyStopShareScreenAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.ReqAddConferenceMemberAsk;
import com.coolots.p2pmsg.model.ReqAddConferenceMemberRep;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.google.protobuf.ByteString;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.consent.handler.C1162e;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.consent.handler.HandlerC1165h;
import com.sds.coolots.call.consent.handler.HandlerC1166i;
import com.sds.coolots.call.p013a.C1138d;
import com.sds.coolots.call.p013a.C1143i;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.calllog.CallLogManagerInterface;
import com.sds.coolots.common.model.CoolotsWakeLockList;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.StrUtil;
import com.sds.coolots.contact.ContactManagerInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.model.H */
/* loaded from: classes.dex */
public class C1193H extends Call implements CallConsentHandler.CallConsentCallback {

    /* renamed from: F */
    private static final String f2623F = "[P2PCall]";

    /* renamed from: G */
    private String f2624G;

    /* renamed from: H */
    private HandlerC1195J f2625H;

    /* renamed from: I */
    private MakeConferenceRep f2626I;

    /* renamed from: J */
    private boolean f2627J;

    /* renamed from: K */
    private boolean f2628K;

    /* renamed from: L */
    private String f2629L;

    /* renamed from: M */
    private int f2630M;

    /* renamed from: N */
    private Handler f2631N;

    public C1193H(Destination destination, CallState callState, boolean z, CallInstanceInterface callInstanceInterface) {
        super(destination, callState, z, callInstanceInterface);
        this.f2624G = "";
        this.f2627J = false;
        this.f2628K = false;
        this.f2630M = 0;
        this.f2631N = new HandlerC1194I(this);
        this.f2538g = true;
    }

    public C1193H(Destination destination, CallState callState, boolean z, CallInstanceInterface callInstanceInterface, int i) {
        super(destination, callState, z, callInstanceInterface);
        this.f2624G = "";
        this.f2627J = false;
        this.f2628K = false;
        this.f2630M = 0;
        this.f2631N = new HandlerC1194I(this);
        this.f2538g = true;
        this.f2541j = i;
        this.f2627J = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public boolean m2406Q() {
        ComponentName componentName = ((ActivityManager) MainApplication.mContext.getSystemService("activity")).getRunningTasks(1).get(0).topActivity;
        m2424h("haeri=Top Activity" + componentName.getClassName());
        return !componentName.getClassName().equals("com.android.phone.InCallScreen");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2408a(Message message) {
        if (message.arg1 == 10124) {
            m2424h("ERR_NEED_TO_CRITICAL_UPDATE");
            this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE, 0, 0, null);
            mo2290I();
            if (MainApplication.mInformationActivityGenerator != null) {
                MainApplication.mInformationActivityGenerator.showInformationActivityForCriticalUpdate();
            }
            new C1138d(((MakeConferenceRep) message.obj).getConferenceInfo().getConferenceNo(), m2366i(), this.f2625H).start();
            return;
        }
        if (message.arg1 != 0) {
            this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE, 0, 0, null);
            mo2290I();
            return;
        }
        this.f2626I = (MakeConferenceRep) message.obj;
        if (!this.f2548q || this.f2626I.getConferenceInfo() == null) {
            EngineInterface.getInstance().changeToConference(this.f2541j, this.f2626I.getConferenceInfo().getConferenceNo(), this.f2626I.getP2PKey());
        } else {
            new C1138d(this.f2626I.getConferenceInfo().getConferenceNo(), m2366i(), null).start();
        }
    }

    /* renamed from: a */
    public static void m2409a(Destination destination, String str, boolean z, boolean z2, Date date, int i) {
        if (!z2 || z) {
            MainApplication.mPhoneManager.getCallLogManager().addCallLogP2P(i, z, StrUtil.convertDateToyyyyMMddHHmmss(date), 0, Integer.toString(destination.getCountryCode()), destination.getString(), m2418c(destination.getString(), str), destination.getPhoneNo(), 0, "", false, true);
        }
    }

    /* renamed from: b */
    private void m2414b(MsgHeader msgHeader, MsgBody msgBody) {
        m2424h("sendShareViewMessage!!");
        EngineInterface.getInstance().sendShareViewMessageByP2P(this.f2541j, msgHeader, msgBody);
    }

    /* renamed from: b */
    private void m2415b(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        this.f2624G = str2;
        this.f2537f.notiRejectMsg(str, str2);
    }

    /* renamed from: c */
    private static String m2418c(String str, String str2) {
        String userNameByUserID;
        ContactManagerInterface contactManager = MainApplication.mPhoneManager.getContactManager();
        return (!contactManager.isFriend(str) || (userNameByUserID = contactManager.getUserNameByUserID(str)) == null || userNameByUserID.isEmpty()) ? str2 : userNameByUserID;
    }

    /* renamed from: d */
    private C1162e m2419d(int i, int i2) {
        C1162e c1162e = new C1162e();
        c1162e.f2383a = i;
        c1162e.f2384b = i2;
        if (i == 1) {
            if (this.f2537f.isUseVideo()) {
                c1162e.f2384b = 2;
            } else {
                c1162e.f2384b = 1;
            }
        }
        return c1162e;
    }

    /* renamed from: d */
    private void m2420d(int i, int i2, String str) {
        m2424h("notifyConsentRequestAsk()");
        MainApplication.mPhoneManager.getPhoneStateMachine().showCallActivity(this.f2537f.isUseVideo(), this.f2537f.getCallOptionData().f2720u, this.f2537f.isSIPCall());
        MainApplication.mPhoneManager.getHardwareManager().getSoundManager().simpleVibrate();
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireTimeoutLockForConsentDialog(CoolotsWakeLockList.WAKELOCK_TAG_CONSENT_DIALOG);
        Message message = new Message();
        message.what = EventCode.EVENT_REQUEST_CONSENT_ASK_RECEIVE;
        message.arg1 = i;
        message.arg2 = i2;
        message.obj = str;
        m2318a(message, false);
    }

    /* renamed from: e */
    private C1162e m2421e(int i, int i2) {
        C1162e c1162e = new C1162e();
        c1162e.f2383a = i;
        c1162e.f2384b = i2;
        return c1162e;
    }

    /* renamed from: e */
    private void m2422e(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ConferenceMember conferenceMember = (ConferenceMember) it.next();
            com.coolots.p2pmsg.model.ConferenceMember conferenceMember2 = new com.coolots.p2pmsg.model.ConferenceMember();
            conferenceMember2.setUserID(conferenceMember.userID);
            conferenceMember2.setUserName(conferenceMember.userName);
            arrayList.add(conferenceMember2);
        }
        ReqAddConferenceMemberRep reqAddConferenceMemberRep = new ReqAddConferenceMemberRep();
        reqAddConferenceMemberRep.setCallSessionID(this.f2541j);
        reqAddConferenceMemberRep.setConferenceMemberList(arrayList);
        reqAddConferenceMemberRep.setResult("0");
        m2319a(C1149a.m2140a(MessageInfo.ReqAddConferenceMemberRep.getServiceCode(), MessageInfo.ReqAddConferenceMemberRep.getMessageCode()), reqAddConferenceMemberRep);
    }

    /* renamed from: g */
    private void m2423g(String str) {
        Log.m2958e(f2623F + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m2424h(String str) {
        Log.m2963i(f2623F + str);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: D */
    protected void mo2285D() {
        int i = m2366i();
        String strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(this.f2537f.getCallConnectedTime());
        if (strConvertDateToyyyyMMddHHmmss == null || strConvertDateToyyyyMMddHHmmss.isEmpty() || strConvertDateToyyyyMMddHHmmss.equals("0")) {
            strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(new Date());
        }
        int time = this.f2537f.getCallConnectedTime() != null ? (int) ((new Date().getTime() - this.f2537f.getCallConnectedTime().getTime()) / 1000) : 0;
        m2424h("p2p connected time:" + strConvertDateToyyyyMMddHHmmss + " totalDuration : " + time);
        if (this.f2524C) {
            return;
        }
        this.f2524C = true;
        int i2 = this.f2545n ? 1 : 0;
        if (this.f2535d) {
            i2 = 2;
        }
        if (this.f2534c) {
            i2 = 3;
        }
        int i3 = this.f2546o ? 4 : i2;
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            CallLogManagerInterface callLogManager = MainApplication.mPhoneManager.getCallLogManager();
            if (!this.f2624G.isEmpty()) {
                i3 = 0;
            }
            callLogManager.addCallLogP2P(i3, this.f2537f.getInitiateCallType() == 2, strConvertDateToyyyyMMddHHmmss, time, Integer.toString(this.f2542k.getCountryCode()), this.f2542k.getString(), m2418c(this.f2542k.getString(), m2362g()), this.f2542k.getPhoneNo(), i, this.f2624G, this.f2627J, CallState.isDisconnected(this.f2540i.getCallState()));
            return;
        }
        if (this.f2627J) {
            mo2286E();
            return;
        }
        if (!this.f2537f.getCallOptionData().f2720u || this.f2537f.isUseVideo()) {
            CallLogManagerInterface callLogManager2 = MainApplication.mPhoneManager.getCallLogManager();
            if (!this.f2624G.isEmpty()) {
                i3 = 0;
            }
            callLogManager2.addCallLogP2P(i3, this.f2539h != 1, strConvertDateToyyyyMMddHHmmss, this.f2537f.getCallDuration(), Integer.toString(this.f2542k.getCountryCode()), this.f2542k.getString(), m2418c(this.f2542k.getString(), m2362g()), this.f2542k.getPhoneNo(), i, this.f2624G, this.f2627J, CallState.isDisconnected(this.f2540i.getCallState()));
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: E */
    protected void mo2286E() {
        String strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(this.f2537f.getCallConnectedTime());
        m2424h("first connected time: " + strConvertDateToyyyyMMddHHmmss);
        MainApplication.mPhoneManager.getCallLogManager().updateCallLog(this.f2542k.getString(), strConvertDateToyyyyMMddHHmmss, this.f2537f.getCallDuration());
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: F */
    public int mo2287F() {
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: H */
    public int mo2289H() {
        this.f2541j = mo2426a(this.f2628K, this.f2629L);
        if (this.f2541j >= 0) {
            return 0;
        }
        if (this.f2541j == -1) {
            return -1001;
        }
        return this.f2541j;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: I */
    protected void mo2290I() {
        if (this.f2541j != -1) {
            EngineInterface.getInstance().hangUpCall(this.f2541j, 1001, "");
        }
        this.f2540i.setCallState(-1);
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_ERROR, 0, 0, null);
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: O */
    public void mo2296O() {
    }

    /* renamed from: P */
    public C1211m m2425P() {
        C1211m c1211m = new C1211m();
        if (this.f2626I != null) {
            c1211m.f2722a = this.f2626I.getConferenceInfo().getConferenceNo();
            c1211m.f2723b = this.f2626I.getConferenceInfo();
            c1211m.f2724c = this.f2626I.getSimpleUserInfoList();
            c1211m.f2732k = this.f2626I.getP2PKey();
        }
        return c1211m;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2298a(int i, String str) {
        m2348c(i);
        this.f2537f.removeRejectMsgHandlerMessage();
        m2415b(this.f2542k.getString(), str);
        m2382w();
        if (this.f2541j == -1) {
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3) {
            m2423g("remoteHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            if (MainApplication.mMainActivity == null) {
                return 0;
            }
            MainApplication.mMainActivity.hideCallProgressDialog();
            return 0;
        }
        if (!this.f2545n && this.f2540i.getCallState() == 1) {
            this.f2535d = true;
        }
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().setEarPhoneScreenLockCallEnd();
        if (!this.f2540i.setCallState(3)) {
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            if (MainApplication.mMainActivity != null) {
                MainApplication.mMainActivity.hideCallProgressDialog();
            }
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
        this.f2537f.updateVoipCallState();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2299a(int i, Date date) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2300a(int i, byte[] bArr) {
        m2424h("<<YHT7>> sendBoardData!! in p2p call");
        if (!this.f2532a.isShareScreenProcessing() || this.f2549r == null) {
            return PhoneStateMachine.ERROR_INVALID_SHARE_SCREEN_STATE;
        }
        m2424h("<<YHT7>> sendBoardData!! in p2p call pass check routine");
        NotifyBoardDataAsk notifyBoardDataAsk = new NotifyBoardDataAsk();
        notifyBoardDataAsk.setCallSessionID(this.f2541j);
        notifyBoardDataAsk.setSrcUserID(MainApplication.mConfig.getProfileUserID());
        notifyBoardDataAsk.setBoardType(i);
        notifyBoardDataAsk.setContents(ByteString.copyFrom(bArr));
        m2414b(C1149a.m2140a(MessageInfo.NotifyBoardDataAsk.getServiceCode(), MessageInfo.NotifyBoardDataAsk.getMessageCode()), notifyBoardDataAsk);
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2301a(Point point, boolean z) {
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2532a.isShareScreenProcessing()) {
            return PhoneStateMachine.ERROR_INVALID_SHARE_SCREEN_STATE;
        }
        this.f2551t = 1;
        this.f2532a.setShareScreenProcessing(true);
        EngineInterface.getInstance().startShareScreen(this.f2541j, this.f2553w, this.f2554x, this.f2550s ? false : true);
        this.f2537f.setActivityStatus(EventCode.EVENT_SHARE_SCREEN_RESTART, 0, 0, null);
        MainApplication.mChatONInterface.sendBroadcastShareViewInfo(4);
        if (this.f2549r == null) {
            return 0;
        }
        this.f2549r.onResumeShareScreen(point, z);
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2304a(NotifyBoardDataAsk notifyBoardDataAsk) {
        if (this.f2532a.isShareScreenProcessing() && this.f2549r != null && notifyBoardDataAsk.getContents() != null && !notifyBoardDataAsk.getContents().isEmpty()) {
            byte[] bArr = new byte[notifyBoardDataAsk.getContents().size()];
            notifyBoardDataAsk.getContents().copyTo(bArr, 0);
            this.f2549r.onReceiveBoardData(notifyBoardDataAsk.getSrcUserID(), notifyBoardDataAsk.getBoardType(), bArr);
        }
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2305a(String str) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2306a(String str, String str2, int i, String str3) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2308a(ArrayList arrayList, ArrayList arrayList2) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2309a(short s, boolean z, int i, boolean z2, boolean z3, String str) {
        m2424h("startIncomingCall : isLiveShare : " + z3 + "  UseVideo : " + z);
        this.f2537f.getCallOptionData().f2713n = z2;
        if (this.f2541j != -1) {
            EngineInterface.getInstance().hangUpCall(i, 1001, "");
            return PhoneStateMachine.ERROR_BUSY;
        }
        this.f2523B = s;
        this.f2543l = str;
        this.f2541j = i;
        this.f2545n = false;
        this.f2537f.setUseVideo(z);
        this.f2537f.getCallOptionData().f2720u = z3;
        if (this.f2540i.getCallState() != 0) {
            m2423g("startIncomingCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(1)) {
            m2423g("startIncomingCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.registVoipCallState()) {
            m2423g("startOutGoingCall registVoipCallState error!!!!");
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        m2295N();
        this.f2537f.updateVoipCallState();
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_CALLING, 0, 0, null);
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2310a(boolean z, int i) {
        int iHangUpCall;
        m2423g("localHangupCall: engineHangUp: " + z + ", hangupReason: " + i);
        m2348c(i);
        m2382w();
        if (i == 300 && MainApplication.mInformationActivityGenerator != null) {
            MainApplication.mInformationActivityGenerator.showInformationActivityForNetworkError();
        }
        if (this.f2541j == -1) {
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3) {
            m2423g("localHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(3)) {
            m2423g("localHangupCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2537f.updateVoipCallState();
        if (!z || (iHangUpCall = EngineInterface.getInstance().hangUpCall(this.f2541j, i, "")) == 1) {
            return 0;
        }
        m2423g("Local Hangup Call meet engine error!! code:" + iHangUpCall);
        mo2290I();
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
        return iHangUpCall;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2311a(boolean z, int i, boolean z2, String str) {
        m2424h("connectCall() " + i + " getHangupCode: " + m2366i());
        this.f2537f.getCallOptionData().f2713n = z2;
        if (this.f2541j == -1) {
            m2348c(1001);
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (this.f2540i.getCallState() != 1) {
            m2348c(1001);
            m2423g("connectCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!z) {
            if (!this.f2540i.setCallState(3)) {
                m2348c(1001);
                m2423g("connectCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                mo2290I();
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            m2348c(i);
            if (!this.f2545n) {
                this.f2534c = true;
                EngineInterface.getInstance().hangUpCall(this.f2541j, i, str);
            }
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            this.f2537f.updateVoipCallState();
            return 0;
        }
        if (!this.f2540i.setCallState(2)) {
            m2348c(1001);
            m2423g("connectCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2545n && EngineInterface.getInstance().receiveCall(this.f2541j, this.f2537f.isUseVideo(), MainApplication.mConfig.isSecureCommunication()) != 1) {
            m2348c(1001);
            return -1001;
        }
        if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
            MainApplication.mPhoneManager.getDataUsageManager().notifyStartCall(this.f2539h);
        }
        this.f2537f.setCallConnectedTime(new Date());
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_CONNECTED, 0, 0, null);
        this.f2537f.updateVoipCallState();
        if (!this.f2537f.isUseVideo() && this.f2545n && this.f2537f.getCallOptionData().f2720u) {
            notifyConsentResult(true, 3, 0, true, false, MainApplication.mConfig.getProfileUserID());
        }
        if (!this.f2537f.getCallOptionData().f2720u || this.f2537f.isUseVideo()) {
            return 0;
        }
        this.f2537f.turnOnSpeaker();
        return 0;
    }

    /* renamed from: a */
    protected int mo2426a(boolean z, String str) {
        return EngineInterface.getInstance().placeCall(this.f2542k.getString(), this.f2537f.isUseVideo(), MainApplication.mConfig.isSecureCommunication(), z, str);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2312a(boolean z, boolean z2, String str) {
        m2424h("startOutGoingCall : isLiveShare : " + z2 + "  mUseVideo : " + this.f2537f.isUseVideo());
        this.f2545n = true;
        this.f2537f.setUseVideo(z);
        this.f2537f.getCallOptionData().f2720u = z2;
        if (this.f2540i.getCallState() != 0) {
            m2423g("startOutGoingCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(1)) {
            m2423g("startOutGoingCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.registVoipCallState()) {
            m2423g("startOutGoingCall registVoipCallState error!!!!");
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (MainApplication.mPhoneManager.getClientType() == 2) {
            this.f2541j = mo2426a(z2, str);
            if (this.f2541j < 0) {
                if (this.f2541j == -1) {
                    return -1001;
                }
                return this.f2541j;
            }
        } else {
            this.f2628K = z2;
            this.f2629L = str;
        }
        if (!this.f2537f.isUseVideo() && this.f2537f.getCallOptionData().f2720u) {
            m2381v();
        }
        m2295N();
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_CALLING, 0, 0, null);
        this.f2537f.updateVoipCallState();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2317a(int i, boolean z, boolean z2) {
        if (this.f2541j == -1) {
            return;
        }
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            m2423g("setRender State Setting Error!!! current state:" + this.f2540i.getStateDescription());
        } else {
            EngineInterface.getInstance().sendRotationInfo(this.f2541j, i, z, z2);
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2320a(NotifyConsentAsk notifyConsentAsk) {
        m2423g("<<YHT122>> handleNotifyConsentAsk");
        if (this.f2541j != notifyConsentAsk.getCallSessionID()) {
            return;
        }
        if (this.f2526E == null) {
            C1162e c1162eM2419d = m2419d(notifyConsentAsk.getConsentType(), notifyConsentAsk.getOption());
            this.f2526E = new HandlerC1165h(this.f2542k, this.f2541j, this, m2421e(notifyConsentAsk.getConsentType(), notifyConsentAsk.getOption()), c1162eM2419d);
        }
        this.f2526E.handleNotifyConsentAsk(notifyConsentAsk);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2321a(NotifyFinishShareCameraAsk notifyFinishShareCameraAsk) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2322a(ProposeConsentAsk proposeConsentAsk) {
        m2423g("handleProposeConsentAsk!!! invalid state");
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2323a(ProposeConsentRep proposeConsentRep) {
        m2423g("handleProposeConsentRep!!! invalid state");
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2324a(ReqAddConferenceMemberRep reqAddConferenceMemberRep) {
        "0".equals(reqAddConferenceMemberRep.getResult());
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2325a(RequestConsentAsk requestConsentAsk) {
        if (this.f2541j != requestConsentAsk.getCallSessionID()) {
            m2423g("<CIH> handleRequestConsentAsk() step1");
            return;
        }
        if (this.f2526E == null) {
            C1162e c1162eM2419d = m2419d(requestConsentAsk.getConsentType(), requestConsentAsk.getOption());
            this.f2526E = new HandlerC1165h(this.f2542k, this.f2541j, this, m2421e(requestConsentAsk.getConsentType(), requestConsentAsk.getOption()), c1162eM2419d);
            m2423g("<CIH> handleRequestConsentAsk() step2");
        }
        m2423g("<CIH> handleRequestConsentAsk!!!! receive message!!");
        this.f2526E.handleRequestConsentAsk(requestConsentAsk);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2326a(RequestConsentRep requestConsentRep) {
        if (this.f2541j == requestConsentRep.getCallSessionID() && this.f2526E != null) {
            this.f2526E.handleRequestConsentRep(requestConsentRep);
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2328a(String str, String str2) {
        m2424h("notiCloseCall");
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: b */
    protected void mo2338b(int i, int i2, String str) {
        NotifyStartShareScreenAsk notifyStartShareScreenAsk = new NotifyStartShareScreenAsk();
        notifyStartShareScreenAsk.setCallSessionID(this.f2541j);
        notifyStartShareScreenAsk.setWidth(i);
        notifyStartShareScreenAsk.setHeight(i2);
        notifyStartShareScreenAsk.setVersion(str);
        m2414b(C1149a.m2140a(MessageInfo.NotifyStartShareScreenAsk.getServiceCode(), MessageInfo.NotifyStartShareScreenAsk.getMessageCode()), notifyStartShareScreenAsk);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: b */
    public void mo2342b(boolean z, int i) {
        this.f2546o = true;
        this.f2537f.setUseVideo(z);
        this.f2541j = i;
        this.f2540i.setCallState(-1);
        mo2285D();
        EngineInterface.getInstance().hangUpCall(i, 301, "");
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public int mo2345c(int i, int i2) {
        if (this.f2526E != null) {
            m2424h("<CIH> requestCallConsent step 1");
            if (!this.f2526E.requestConsent()) {
                return PhoneStateMachine.ERROR_UNKNOWN;
            }
            m2424h("<CIH> requestCallConsent step 2");
            Message message = new Message();
            message.what = EventCode.EVENT_DISMISS_CONSENT_USER_ACTION_DIALOG;
            this.f2537f.getCallingActivity().sendHandlerMessage(message, 0L);
            return 0;
        }
        C1162e c1162eM2419d = m2419d(i, i2);
        this.f2526E = new HandlerC1166i(this.f2542k, this.f2541j, this, m2421e(i, i2), c1162eM2419d);
        if (this.f2526E.requestConsent()) {
            m2424h("<CIH> requestCallConsent step 3");
            return 0;
        }
        m2424h("<CIH> requestCallConsent step 4");
        return PhoneStateMachine.ERROR_UNKNOWN;
    }

    /* renamed from: c */
    public int m2427c(List list) {
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (this.f2537f.getCallOptionData().f2718s || this.f2540i.getCallState() == 4) {
            return PhoneStateMachine.ERROR_INVITE_BUDDY_HOLD;
        }
        if (!this.f2545n) {
            return m2428d(list);
        }
        if (this.f2625H != null) {
            m2422e(list);
            return PhoneStateMachine.ERROR_INVALID_CHANGE_TO_CONFERENCE_STATE;
        }
        ArrayList arrayList = new ArrayList();
        SimpleUserInfo simpleUserInfo = new SimpleUserInfo(MainApplication.mConfig.getProfileUserID(), MainApplication.mConfig.getProfileUserName());
        simpleUserInfo.setUserType(SimpleUserInfo.TYPE_HOST);
        arrayList.add(simpleUserInfo);
        SimpleUserInfo simpleUserInfo2 = new SimpleUserInfo(this.f2542k.getPhoneNo(), MainApplication.mPhoneManager.getContactManager().getUserNameByUserID(this.f2542k.getPhoneNo()));
        simpleUserInfo2.setPushDisableYn("Y");
        arrayList.add(simpleUserInfo2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ConferenceMember conferenceMember = (ConferenceMember) it.next();
            SimpleUserInfo simpleUserInfo3 = new SimpleUserInfo(conferenceMember.userID, conferenceMember.userName);
            simpleUserInfo3.setInviteUserID(conferenceMember.inviteUserID);
            arrayList.add(simpleUserInfo3);
        }
        this.f2625H = new HandlerC1195J(this, null);
        new C1143i(arrayList, this.f2537f.isUseVideo(), this.f2625H).start();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public int mo2347c(boolean z) {
        m2423g("setHoldCall() :" + this.f2540i.getStateDescription());
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            m2423g("setHoldCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (z) {
            if (!this.f2540i.setCallState(4)) {
                m2423g("setHoldCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            this.f2537f.getCallOptionData().f2714o = true;
            if (MainApplication.mPhoneManager.getClientType() == 2) {
                this.f2537f.getCallOptionData().f2716q = true;
                EngineInterface.getInstance().holdVideoCall(this.f2541j, z);
            } else {
                EngineInterface.getInstance().holdCall(this.f2541j, z);
            }
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HOLD, 0, 0, null);
        } else {
            if (!this.f2540i.setCallState(2)) {
                m2423g("setHoldCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            this.f2537f.getCallOptionData().f2714o = false;
            if (MainApplication.mPhoneManager.getClientType() == 2) {
                this.f2537f.getCallOptionData().f2716q = true;
                EngineInterface.getInstance().holdVideoCall(this.f2541j, z);
            } else {
                EngineInterface.getInstance().holdCall(this.f2541j, z);
            }
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_UNHOLD, 0, 0, null);
        }
        Log.m2954d("<<KEONLEE>>");
        if (!z) {
            if (this.f2631N == null) {
                this.f2631N = new HandlerC1194I(this);
            }
            this.f2631N.sendEmptyMessage(0);
        } else if (this.f2549r != null) {
            this.f2549r.onCallHoldState(z);
        }
        this.f2537f.updateVoipCallState();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public boolean mo2350c(String str) {
        return this.f2545n;
    }

    /* renamed from: d */
    public int m2428d(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ConferenceMember conferenceMember = (ConferenceMember) it.next();
            com.coolots.p2pmsg.model.ConferenceMember conferenceMember2 = new com.coolots.p2pmsg.model.ConferenceMember();
            conferenceMember2.setUserID(conferenceMember.userID);
            conferenceMember2.setUserName(conferenceMember.userName);
            arrayList.add(conferenceMember2);
        }
        ReqAddConferenceMemberAsk reqAddConferenceMemberAsk = new ReqAddConferenceMemberAsk();
        reqAddConferenceMemberAsk.setCallSessionID(this.f2541j);
        reqAddConferenceMemberAsk.setConferenceMemberList(arrayList);
        reqAddConferenceMemberAsk.setRequestID(MainApplication.mConfig.getProfileUserID());
        m2319a(C1149a.m2140a(MessageInfo.ReqAddConferenceMemberAsk.getServiceCode(), MessageInfo.ReqAddConferenceMemberAsk.getMessageCode()), reqAddConferenceMemberAsk);
        return 0;
    }

    /* renamed from: e */
    public void m2429e(String str) {
        this.f2543l = str;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: f */
    public int mo2358f(int i) {
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2532a.isShareScreenProcessing()) {
            return PhoneStateMachine.ERROR_INVALID_SHARE_SCREEN_STATE;
        }
        this.f2551t = 3;
        this.f2532a.setShareScreenProcessing(true);
        EngineInterface.getInstance().stopShareScreen(this.f2541j, this.f2550s ? false : true);
        this.f2537f.setActivityStatus(EventCode.EVENT_SHARE_SCREEN_PAUSE, 0, 0, null);
        MainApplication.mChatONInterface.sendBroadcastShareViewInfo(3);
        if (this.f2549r == null) {
            return 0;
        }
        this.f2549r.onPauseShareScreen(i);
        return 0;
    }

    /* renamed from: f */
    public void m2430f(String str) {
        this.f2544m = str;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: g */
    public int mo2361g(boolean z) {
        if (this.f2526E == null) {
            return PhoneStateMachine.ERROR_UNKNOWN;
        }
        if (z ? this.f2526E.acceptConsent() : this.f2526E.rejectConsent(0)) {
            return 0;
        }
        return PhoneStateMachine.ERROR_UNKNOWN;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: g */
    public void mo2363g(int i) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: h */
    public void mo2365h(int i) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: m */
    public int mo2372m() {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        this.f2537f.getCallOptionData().f2711l = true;
        m2423g("<<YHT67>> startAvatar!!!");
        return EngineInterface.getInstance().startAvatar(false, this.f2541j);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: n */
    public int mo2373n() {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        this.f2537f.getCallOptionData().f2711l = false;
        m2423g("<<YHT67>> stopAvatar!!!");
        return EngineInterface.getInstance().stopAvatar(false, this.f2541j);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void notifyClearConsent() {
        if (this.f2526E != null) {
            this.f2526E = null;
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void notifyConsentRequest(int i, int i2, String str) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                m2420d(i, i2, str);
                break;
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void notifyConsentResult(boolean z, int i, int i2, boolean z2, boolean z3, String str) {
        m2424h("<CIH> notifyConsentResult(), result = " + z + ", type = " + i + ", option = " + i2 + ", isRequester = " + z2 + ", isTimeCancel = " + z3 + ", userID = " + str);
        this.f2526E = null;
        Message message = new Message();
        ConsentDisplayInfo consentDisplayInfo = new ConsentDisplayInfo();
        consentDisplayInfo.isAccept = z;
        consentDisplayInfo.rejecterID = str;
        consentDisplayInfo.isSender = z2;
        consentDisplayInfo.isTimeout = z3;
        if (z) {
            message.what = EventCode.EVENT_CONSENT_ACCEPT;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = consentDisplayInfo;
        } else {
            message.what = EventCode.EVENT_CONSENT_REJECT;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = consentDisplayInfo;
        }
        m2318a(message, false);
        if (i == 1) {
            m2423g("<<YHT10>> runCallSwitchProcess!! result is " + z);
            m2316a(this.f2541j, i2, z ? 1 : 0);
        } else if (i == 3 && z2 && z) {
            MainApplication.mPhoneManager.getShareScreenManager().startShareScreen(this.f2542k, MainApplication.mContext.getResources().getDisplayMetrics().widthPixels, MainApplication.mContext.getResources().getDisplayMetrics().heightPixels, "1");
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void notifyProposeResult(boolean z, int i, int i2, boolean z2, boolean z3, String str) {
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void notifySendPush() {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: o */
    public int mo2374o() {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!this.f2537f.getCallOptionData().f2711l) {
            return PhoneStateMachine.ERROR_NOT_AVATAR_MODE;
        }
        m2423g("<<YHT67>> createCustomAvatar!!!");
        return EngineInterface.getInstance().createCustomAvatar(false, this.f2541j);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: p */
    public int mo2375p() {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!this.f2537f.getCallOptionData().f2711l) {
            return PhoneStateMachine.ERROR_NOT_AVATAR_MODE;
        }
        m2423g("<<YHT67>> changeAvatarHair!!!");
        return EngineInterface.getInstance().changeAvatarHair(false, this.f2541j);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void processCallConsentTimeOut() {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: q */
    public int mo2376q() {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2537f.isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!this.f2537f.getCallOptionData().f2711l) {
            return PhoneStateMachine.ERROR_NOT_AVATAR_MODE;
        }
        m2423g("<<YHT67>> changeAvatarGlasses!!!");
        return EngineInterface.getInstance().changeAvatarGlasses(false, this.f2541j);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: t */
    public boolean mo2379t() {
        return false;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: x */
    protected void mo2383x() {
        NotifyStopShareScreenAsk notifyStopShareScreenAsk = new NotifyStopShareScreenAsk();
        notifyStopShareScreenAsk.setCallSessionID(this.f2541j);
        m2414b(C1149a.m2140a(MessageInfo.NotifyStopShareScreenAsk.getServiceCode(), MessageInfo.NotifyStopShareScreenAsk.getMessageCode()), notifyStopShareScreenAsk);
    }
}
