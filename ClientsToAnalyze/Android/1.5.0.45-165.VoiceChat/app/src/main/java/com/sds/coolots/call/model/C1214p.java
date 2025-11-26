package com.sds.coolots.call.model;

import android.graphics.Point;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.NotifyBoardDataAsk;
import com.coolots.p2pmsg.model.NotifyCloseCallAsk;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.NotifyFinishShareCameraAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.PushTargetInfo;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.p013a.C1138d;
import com.sds.coolots.call.p013a.C1139e;
import com.sds.coolots.call.p013a.C1147m;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.StrUtil;
import com.sec.spp.push.Config;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.model.p */
/* loaded from: classes.dex */
public class C1214p extends Call {

    /* renamed from: F */
    private static final String f2744F = "[ChangeToP2P]";

    /* renamed from: N */
    private static final int f2745N = 13;

    /* renamed from: O */
    private static final int f2746O = 14;

    /* renamed from: P */
    private static final int f2747P = 60000;

    /* renamed from: Q */
    private static final int f2748Q = 30000;

    /* renamed from: G */
    private int f2749G;

    /* renamed from: H */
    private String f2750H;

    /* renamed from: I */
    private String f2751I;

    /* renamed from: J */
    private String f2752J;

    /* renamed from: K */
    private boolean f2753K;

    /* renamed from: L */
    private String f2754L;

    /* renamed from: M */
    private Object[] f2755M;

    /* renamed from: R */
    private final HandlerC1216r f2756R;

    /* renamed from: S */
    private final HandlerC1215q f2757S;

    public C1214p(Destination destination, CallState callState, boolean z, CallInstanceInterface callInstanceInterface, int i) {
        super(destination, callState, z, callInstanceInterface);
        this.f2754L = "";
        this.f2755M = null;
        this.f2756R = new HandlerC1216r(this, null);
        this.f2757S = new HandlerC1215q(this, 0 == true ? 1 : 0);
        this.f2750H = destination.getPhoneNo();
        this.f2749G = i;
        if (i == -1) {
            this.f2749G = 0;
        }
        m2675e("YHT100!!!! new ChangeToP2P:" + i);
    }

    /* renamed from: P */
    private void m2662P() {
        new C1138d(this.f2750H, m2366i(), null).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public void m2663Q() {
        NotifyCloseCallAsk notifyCloseCallAsk = new NotifyCloseCallAsk();
        notifyCloseCallAsk.setConferenceNo(this.f2750H);
        notifyCloseCallAsk.setSenderID(MainApplication.mConfig.getProfileUserID());
        MsgHeader msgHeaderM2140a = C1149a.m2140a(MessageInfo.NotifyCloseCallAsk.getServiceCode(), MessageInfo.NotifyCloseCallAsk.getMessageCode());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2542k.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                PushTargetInfo pushTargetInfo = new PushTargetInfo();
                pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
                pushTargetInfo.setReceiverUserNo(simpleUserInfo.getUserNo());
                pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
                arrayList.add(pushTargetInfo);
            }
        }
        C1149a.m2141a(msgHeaderM2140a, notifyCloseCallAsk, arrayList);
    }

    /* renamed from: R */
    private boolean m2664R() {
        return (MainApplication.mConfig.getCallHangupType() == 2 || MainApplication.mConfig.getCallHangupType() == 3) && m2665S();
    }

    /* renamed from: S */
    private boolean m2665S() {
        m2676f("isAssignNewHost ");
        String profileUserID = MainApplication.mConfig.getProfileUserID();
        Iterator it = this.f2542k.getConferenceMember().iterator();
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (!profileUserID.equals(simpleUserInfo.getUserID())) {
                if ("0".equals(simpleUserInfo.getStatus())) {
                    i++;
                }
                if ("1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                    m2676f("==host type?" + simpleUserInfo.getUserType() + "/host name?" + simpleUserInfo.getUserName());
                    i2++;
                    z = simpleUserInfo.getUserType().equals(SimpleUserInfo.TYPE_HOST) ? true : z;
                }
            }
        }
        m2676f("isAssignNewHost : " + z + " mConnectCount: " + i2 + " mWaitCount: " + i);
        if (z) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssms");
            String str = "";
            C1192G myConnectionInfo = this.f2537f.getMyConnectionInfo();
            if (myConnectionInfo.f2621a != null) {
                str = simpleDateFormat.format(myConnectionInfo.f2621a);
                m2676f("my start time: " + str + " mMyStartTime: " + myConnectionInfo.f2621a);
                arrayList.add(str);
            }
            String str2 = str;
            Iterator it2 = this.f2542k.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo simpleUserInfo2 = (SimpleUserInfo) it2.next();
                if (!profileUserID.equals(simpleUserInfo2.getUserID()) && ("1".equals(simpleUserInfo2.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo2.getStatus()))) {
                    arrayList.add(simpleDateFormat.format(simpleUserInfo2.getStartTime()));
                    m2676f("buddy start time: " + simpleDateFormat.format(simpleUserInfo2.getStartTime()) + "real time: " + simpleUserInfo2.getStartTime());
                    arrayList2.add(simpleUserInfo2);
                }
            }
            String[] strArr = new String[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                strArr[i3] = (String) arrayList.get(i3);
            }
            Arrays.sort(strArr);
            for (int i4 = 0; i4 < strArr.length; i4++) {
                m2676f("sort [" + i4 + "]: " + strArr[i4]);
            }
            if (strArr.length <= 0) {
                return true;
            }
            if (str2.isEmpty() || !str2.equals(strArr[0])) {
                return false;
            }
            int i5 = 0;
            for (int i6 = 1; i6 < strArr.length; i6++) {
                if (str2.equals(strArr[i6])) {
                    i5++;
                }
            }
            if (i5 == 0) {
                m2676f("selectedNewHostForConferenceRoom : I am Host ");
                return true;
            }
            String[] strArr2 = new String[arrayList2.size() + 1];
            strArr2[0] = MainApplication.mConfig.getProfileUserID();
            int i7 = 0;
            int i8 = 0;
            while (i7 < arrayList2.size()) {
                Iterator it3 = arrayList2.iterator();
                int i9 = i8;
                while (it3.hasNext()) {
                    SimpleUserInfo simpleUserInfo3 = (SimpleUserInfo) it3.next();
                    i9++;
                    strArr2[i9] = simpleUserInfo3.getUserID();
                    m2676f(" buddy user id: " + simpleUserInfo3.getUserID() + " dcount: " + i9);
                }
                i7++;
                i8 = i9;
            }
            Arrays.sort(strArr2);
            for (int i10 = 0; i10 < strArr2.length; i10++) {
                m2676f("alphabat [" + i10 + "]: " + strArr2[i10]);
            }
            if (!profileUserID.equals(strArr2[0])) {
                return false;
            }
            m2676f("selectedNewHostForConferenceRoom : I am Host !!!  ");
            return true;
        } catch (Exception e) {
            m2675e("Sort Exception : " + e);
            return false;
        }
    }

    /* renamed from: T */
    private Object[] m2666T() {
        Object[] objArr = new Object[10];
        ArrayList conferenceMember = this.f2542k.getConferenceMember();
        if (conferenceMember != null && conferenceMember.isEmpty()) {
            m2675e("<makeP2PConnectInfo> memberInfos is empty!!");
            return null;
        }
        Iterator it = conferenceMember.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                objArr[0] = simpleUserInfo.getUserID();
                objArr[1] = String.valueOf(simpleUserInfo.getUserNo());
                objArr[2] = String.valueOf(simpleUserInfo.getDeviceID());
                if (simpleUserInfo.getP2PUserInfo() == null) {
                    m2675e("<makeP2PConnectInfo> member.getP2PUserInfo() returns null!!");
                    return null;
                }
                objArr[3] = String.valueOf(simpleUserInfo.getP2PUserInfo().getNetworkType());
                objArr[4] = simpleUserInfo.getP2PUserInfo().getPublicIP();
                objArr[5] = String.valueOf(simpleUserInfo.getP2PUserInfo().getPublicPort());
                objArr[6] = simpleUserInfo.getP2PUserInfo().getPrivateIP();
                objArr[7] = String.valueOf(simpleUserInfo.getP2PUserInfo().getPrivatePort());
                objArr[8] = simpleUserInfo.getP2PUserInfo().getRelayServerIP();
                objArr[9] = String.valueOf(simpleUserInfo.getP2PUserInfo().getRelayServerPort());
                this.f2754L = simpleUserInfo.getUserName();
                m2676f("=============== P2P Info =======START====name: " + this.f2754L);
                m2676f(" user id: " + objArr[0]);
                m2676f(" user no: " + objArr[1]);
                m2676f(" device id : " + objArr[2]);
                m2676f(" network type: " + objArr[3]);
                m2676f(" public ip: " + objArr[4]);
                m2676f(" public port: " + objArr[5]);
                m2676f(" private ip: " + objArr[6]);
                m2676f(" private port: " + objArr[7]);
                m2676f(" relayserver ip: " + objArr[8]);
                m2676f(" relayserver port: " + objArr[9]);
                m2676f("=============== P2P Info =======END ==============================");
                return objArr;
            }
        }
        m2675e("<makeP2PConnectInfo> failed to find connected member!!!");
        return null;
    }

    /* renamed from: a */
    public static String m2667a(Destination destination) {
        if (destination.getConferenceMember() == null || destination.getConferenceMember().isEmpty()) {
            return "";
        }
        Iterator it = destination.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                return simpleUserInfo.getUserID();
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m2671b(Destination destination) {
        if (destination.getConferenceMember() == null || destination.getConferenceMember().isEmpty()) {
            return "";
        }
        Iterator it = destination.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                return simpleUserInfo.getUserName();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2672b(Message message) {
        switch (message.arg1) {
            case 0:
                m2679a((C1224z) message.obj);
                break;
        }
    }

    /* renamed from: e */
    private void m2675e(String str) {
        Log.m2958e(f2744F + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2676f(String str) {
        Log.m2963i(f2744F + str);
    }

    /* renamed from: g */
    private void m2677g(String str) {
        this.f2753K = this.f2545n;
        if (!this.f2545n) {
            this.f2753K = m2664R();
        }
        this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_P2P_NOTI_MSG, 0, 0, str);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: D */
    protected void mo2285D() {
        m2676f("saveCallLog() : Error was occured when Conference call changed to P2P call");
        String strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(this.f2537f.getCallConnectedTime());
        if (strConvertDateToyyyyMMddHHmmss == null || strConvertDateToyyyyMMddHHmmss.isEmpty() || strConvertDateToyyyyMMddHHmmss.equals("0")) {
            strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(new Date());
        }
        int time = this.f2537f.getCallConnectedTime() != null ? (int) ((new Date().getTime() - this.f2537f.getCallConnectedTime().getTime()) / 1000) : 0;
        m2676f("saveCallLog() connected time:" + strConvertDateToyyyyMMddHHmmss + " totalDuration : " + time);
        MainApplication.mPhoneManager.getCallLogManager().sendCallLogData(true, time);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: E */
    protected void mo2286E() {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: F */
    public int mo2287F() {
        m2676f("updateConferenceMember()");
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            m2676f("call state is DISCONNECTED");
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        new C1139e(this.f2750H, false, this.f2757S, false).start();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: H */
    public int mo2289H() {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: I */
    protected void mo2290I() {
        m2676f("<handleCallError> handleCallError!!!!");
        if (this.f2541j != -1) {
            EngineInterface.getInstance().hangUpSIPCall(this.f2541j);
            this.f2540i.setCallState(-1);
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_ERROR, 0, 0, null);
        } else {
            this.f2540i.setCallState(-1);
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_ERROR, 0, 0, null);
            if (this.f2537f.getEngineInterface() != null) {
                this.f2537f.getEngineInterface().onHangUpCall(this.f2541j, 1001, "");
            }
        }
        if (this.f2545n) {
            m2662P();
        }
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: O */
    public void mo2296O() {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2298a(int i, String str) {
        if (i == 1011) {
            if (MainApplication.mInformationActivityGenerator != null && CallState.isConnected(this.f2540i.getCallState())) {
                MainApplication.mInformationActivityGenerator.showInformationActivityForChangeToP2P();
            }
            m2663Q();
        }
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3 || this.f2540i.getCallState() == -1) {
            m2675e("remoteHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            m2662P();
            return 0;
        }
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().setEarPhoneScreenLockCallEnd();
        if (!this.f2540i.setCallState(3)) {
            m2675e("remoteHangupCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            m2662P();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (i == 1011) {
            this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_P2P_FAILURE, 0, 0, null);
        } else {
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
        }
        this.f2537f.updateVoipCallState();
        m2662P();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2299a(int i, Date date) {
        if (m2667a(this.f2542k).isEmpty()) {
            return PhoneStateMachine.ERROR_INVALID_CHANGE_TO_P2P_UNKNOWN;
        }
        new C1138d(this.f2750H, m2366i(), null).start();
        this.f2756R.removeMessages(13);
        this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_P2P_START, 0, 0, null);
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2300a(int i, byte[] bArr) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2301a(Point point, boolean z) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2304a(NotifyBoardDataAsk notifyBoardDataAsk) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2305a(String str) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2306a(String str, String str2, int i, String str3) {
        m2676f("<changeToP2P> started!!!");
        this.f2750H = str;
        this.f2751I = str2;
        this.f2752J = str3;
        m2677g(str2);
        this.f2754L = "";
        this.f2755M = m2666T();
        if (this.f2755M == null) {
            m2676f("<changeToP2P> change to p2p mP2pInfos: null");
            if (this.f2753K || this.f2545n) {
                this.f2756R.sendEmptyMessageDelayed(14, Config.CONNECTION_TIMEOUT);
            }
            m2676f("<changeToP2P> return ERROR_INVALID_CHANGE_TO_P2P");
            return PhoneStateMachine.ERROR_INVALID_CHANGE_TO_P2P;
        }
        if (!this.f2753K && !this.f2545n && !this.f2537f.getMyConnectionInfo().f2622b) {
            m2676f("<changeToP2P> mMyP2PInfo is false!!!! return ERROR_INVALID_P2PUSERINFO");
            return PhoneStateMachine.ERROR_INVALID_P2PUSERINFO;
        }
        this.f2756R.removeMessages(14);
        new C1147m(str, m2366i(), this.f2757S).start();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2308a(ArrayList arrayList, ArrayList arrayList2) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2309a(short s, boolean z, int i, boolean z2, boolean z3, String str) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2310a(boolean z, int i) {
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3) {
            m2675e("localHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(3)) {
            m2675e("connectCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2537f.updateVoipCallState();
        if (z) {
            m2675e("localHangupCall() : hangUpSIPCall()");
            int iHangUpSIPCall = EngineInterface.getInstance().hangUpSIPCall(this.f2749G);
            if (iHangUpSIPCall != 1) {
                m2675e("localHangupCall meet engine error!! code:" + iHangUpSIPCall);
                mo2290I();
                this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
                return iHangUpSIPCall;
            }
        }
        m2662P();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2311a(boolean z, int i, boolean z2, String str) {
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2312a(boolean z, boolean z2, String str) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2317a(int i, boolean z, boolean z2) {
    }

    /* renamed from: a */
    protected void m2678a(Message message) {
        if (message.arg1 == -10) {
            m2676f("handleSwitchToSingleCallAsk - HTTP_ERR_TIMEOUT");
            this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_P2P_FAIL_TIMER, 0, 0, null);
            return;
        }
        this.f2754L = "";
        if (this.f2755M != null) {
            int i = (this.f2753K || this.f2545n) ? 1 : 0;
            this.f2756R.sendEmptyMessageDelayed(13, 60000L);
            EngineInterface.getInstance().changeToP2P(this.f2541j, this.f2750H, i, this.f2754L, this.f2755M);
        } else {
            m2676f(" handleSwitchToSingleCallAsk req to engine - ERROR_INVALID_CHANGE_TO_P2P_NOT_CONDITION ");
            if (this.f2753K || this.f2545n) {
                m2663Q();
            }
            this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_P2P_FAILURE, 0, 0, null);
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2320a(NotifyConsentAsk notifyConsentAsk) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2321a(NotifyFinishShareCameraAsk notifyFinishShareCameraAsk) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2322a(ProposeConsentAsk proposeConsentAsk) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2323a(ProposeConsentRep proposeConsentRep) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2325a(RequestConsentAsk requestConsentAsk) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2326a(RequestConsentRep requestConsentRep) {
    }

    /* renamed from: a */
    protected void m2679a(C1224z c1224z) {
        if (c1224z.m2752c() != null) {
            this.f2537f.setMyStartTime(c1224z.m2752c().f2621a, c1224z.m2752c().f2622b);
        }
        int i = 0;
        for (SimpleUserInfo simpleUserInfo : c1224z.m2747a().getSimpleUserInfoList()) {
            if (simpleUserInfo.getStatus().equals("1") || simpleUserInfo.getStatus().equals(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
                i++;
            }
        }
        if (i != 0) {
            this.f2542k.setConferenceMember(c1224z.m2747a().getSimpleUserInfoList());
            mo2306a(this.f2750H, this.f2751I, m2366i(), this.f2752J);
            return;
        }
        boolean z = this.f2537f.getCallingActivity() != null;
        if (this.f2545n) {
            mo2310a(true, 10);
        } else {
            mo2298a(10, "");
        }
        MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(z);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2328a(String str, String str2) {
        m2676f("notiCloseCall :conferenceNo : " + str + "  mConferenceNo: " + this.f2750H);
        if (this.f2750H.equals(str)) {
            this.f2756R.removeMessages(13);
            mo2310a(true, 1011);
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2330a(List list) {
        this.f2542k.setConferenceMember(list);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: b */
    protected void mo2338b(int i, int i2, String str) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: b */
    public void mo2342b(boolean z, int i) {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: b */
    public boolean mo2343b(int i) {
        return this.f2541j == i || this.f2749G == i;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public int mo2345c(int i, int i2) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public int mo2347c(boolean z) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public boolean mo2350c(String str) {
        return (str == null || str.isEmpty() || !str.equals(this.f2750H)) ? false : true;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: f */
    public int mo2358f(int i) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: g */
    public int mo2361g(boolean z) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
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
    /* renamed from: i */
    public void mo2367i(int i) {
        this.f2749G = i;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: k */
    public boolean mo2370k() {
        return this.f2545n ? this.f2545n : this.f2753K;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: m */
    public int mo2372m() {
        return -1;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: n */
    public int mo2373n() {
        return -1;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: o */
    public int mo2374o() {
        return -1;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: p */
    public int mo2375p() {
        return -1;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: q */
    public int mo2376q() {
        return -1;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: t */
    public boolean mo2379t() {
        return true;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: x */
    protected void mo2383x() {
    }
}
