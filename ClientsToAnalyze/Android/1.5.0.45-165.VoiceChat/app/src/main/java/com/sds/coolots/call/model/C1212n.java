package com.sds.coolots.call.model;

import android.graphics.Point;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.JoinConferenceRep;
import com.coolots.p2pmsg.model.MakeConferenceRep;
import com.coolots.p2pmsg.model.NotifyBoardDataAsk;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.NotifyFinishShareCameraAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.ReqAddConferenceMemberRep;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.p013a.C1138d;
import com.sds.coolots.call.p013a.C1139e;
import com.sds.coolots.call.p013a.C1142h;
import com.sds.coolots.call.p013a.C1143i;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.StrUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.model.n */
/* loaded from: classes.dex */
public class C1212n extends Call {

    /* renamed from: F */
    private HandlerC1213o f2736F;

    /* renamed from: G */
    private MakeConferenceRep f2737G;

    /* renamed from: H */
    private String f2738H;

    /* renamed from: I */
    private String f2739I;

    /* renamed from: J */
    private List f2740J;

    /* renamed from: K */
    private String f2741K;

    public C1212n(Destination destination, CallState callState, boolean z, CallInstanceInterface callInstanceInterface, int i) {
        super(destination, callState, z, callInstanceInterface);
        m2658f("callID: " + i);
        this.f2541j = i;
    }

    /* renamed from: a */
    private void m2650a(C1224z c1224z) {
        m2651a(c1224z.m2747a().getSimpleUserInfoList(), c1224z.m2751b());
    }

    /* renamed from: a */
    private void m2651a(List list, String str) {
        m2658f("onConferenceMember()");
        if (list == null) {
            if (this.f2537f.getCallingActivity() != null) {
                Message message = new Message();
                message.what = EventCode.EVENT_CALL_ACTION;
                this.f2537f.getCallingActivity().sendHandlerMessage(message, 0L);
                return;
            }
            return;
        }
        this.f2740J = (ArrayList) list;
        this.f2741K = str;
        if (this.f2736F == null) {
            this.f2736F = new HandlerC1213o(this, null);
        }
        new C1142h(this.f2738H, this.f2736F).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2652b(Message message) {
        m2658f("handleMakeConferenceAsk");
        if (message.arg1 == 10124) {
            m2658f("ERR_NEED_TO_CRITICAL_UPDATE");
            this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE, 0, 0, null);
            mo2290I();
            if (MainApplication.mInformationActivityGenerator != null) {
                MainApplication.mInformationActivityGenerator.showInformationActivityForCriticalUpdate();
            }
            new C1138d(((MakeConferenceRep) message.obj).getConferenceInfo().getConferenceNo(), m2366i(), this.f2736F).start();
            return;
        }
        if (message.arg1 != 0) {
            this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE, 0, 0, null);
            mo2290I();
            return;
        }
        this.f2737G = (MakeConferenceRep) message.obj;
        if (this.f2548q && this.f2737G.getConferenceInfo() != null) {
            new C1138d(this.f2737G.getConferenceInfo().getConferenceNo(), m2366i(), null).start();
            return;
        }
        m2658f("conference no: " + this.f2737G.getConferenceInfo().getConferenceNo() + ", p2pKey: " + this.f2737G.getP2PKey());
        m2658f("mCallID: " + this.f2541j);
        EngineInterface.getInstance().changeToConference(this.f2541j, this.f2737G.getConferenceInfo().getConferenceNo(), this.f2737G.getP2PKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2654c(Message message) {
        switch (message.arg1) {
            case -1:
            case ErrorCode.ERR_CENTER_DATA_NOT_FOUND /* 10016 */:
            case ErrorCode.ERR_CENTER_INVALID_CONFNO /* 10092 */:
            default:
                if (!this.f2548q) {
                    this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE, 0, 0, null);
                    mo2290I();
                    break;
                }
                break;
            case 0:
                m2650a((C1224z) message.obj);
                break;
        }
    }

    /* renamed from: c */
    private void m2655c(List list) {
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

    /* renamed from: d */
    private ArrayList m2656d(ArrayList arrayList) {
        m2658f("getMemberList");
        ArrayList arrayList2 = new ArrayList();
        SimpleUserInfo simpleUserInfo = new SimpleUserInfo(MainApplication.mConfig.getProfileUserID(), MainApplication.mConfig.getProfileUserName());
        simpleUserInfo.setUserType(SimpleUserInfo.TYPE_HOST);
        arrayList2.add(simpleUserInfo);
        SimpleUserInfo simpleUserInfo2 = new SimpleUserInfo(this.f2542k.getPhoneNo(), MainApplication.mPhoneManager.getContactManager().getUserNameByUserID(this.f2542k.getPhoneNo()));
        simpleUserInfo2.setPushDisableYn("Y");
        arrayList2.add(simpleUserInfo2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ConferenceMember conferenceMember = (ConferenceMember) it.next();
            SimpleUserInfo simpleUserInfo3 = new SimpleUserInfo(conferenceMember.userID, conferenceMember.userName);
            simpleUserInfo3.setInviteUserID(conferenceMember.inviteUserID);
            arrayList2.add(simpleUserInfo3);
            m2658f("newMember's userID:" + conferenceMember.userID);
        }
        return arrayList2;
    }

    /* renamed from: e */
    private void m2657e(String str) {
        Log.m2958e("[ChangeToConference]" + str);
    }

    /* renamed from: f */
    private void m2658f(String str) {
        Log.m2963i("[ChangeToConference]" + str);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: D */
    protected void mo2285D() {
        m2658f("saveCallLog() : Error was occured when P2P call changed to Conference call");
        String strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(this.f2537f.getCallConnectedTime());
        if (strConvertDateToyyyyMMddHHmmss == null || strConvertDateToyyyyMMddHHmmss.isEmpty() || strConvertDateToyyyyMMddHHmmss.equals("0")) {
            strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(new Date());
        }
        int time = this.f2537f.getCallConnectedTime() != null ? (int) ((new Date().getTime() - this.f2537f.getCallConnectedTime().getTime()) / 1000) : 0;
        m2658f("saveCallLog() connected time:" + strConvertDateToyyyyMMddHHmmss + " totalDuration : " + time);
        MainApplication.mPhoneManager.getCallLogManager().sendCallLogData(false, time);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: E */
    protected void mo2286E() {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: F */
    public int mo2287F() {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: H */
    public int mo2289H() {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
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
    public MakeConferenceRep m2659P() {
        return this.f2737G;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2298a(int i, String str) {
        m2348c(i);
        this.f2537f.removeRejectMsgHandlerMessage();
        m2382w();
        if (this.f2541j == -1) {
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3) {
            m2657e("remoteHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
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
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2310a(boolean z, int i) {
        int iHangUpCall;
        m2657e("localHangupCall: engineHangUp: " + z + ", hangupReason: " + i);
        m2348c(i);
        m2382w();
        if (this.f2541j == -1) {
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3) {
            m2657e("localHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(3)) {
            m2657e("localHangupCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2537f.updateVoipCallState();
        if (!z || (iHangUpCall = EngineInterface.getInstance().hangUpCall(this.f2541j, i, "")) == 1) {
            return 0;
        }
        m2657e("Local Hangup Call meet engine error!! code:" + iHangUpCall);
        mo2290I();
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
        return iHangUpCall;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2311a(boolean z, int i, boolean z2, String str) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
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
    protected void m2660a(Message message) {
        m2658f("handleJoinConferenceAsk()");
        switch (message.arg1) {
            case -1:
            case 10009:
            case ErrorCode.ERR_CENTER_MCU /* 10087 */:
            case ErrorCode.ERR_CENTER_NOT_PARTICIPANT /* 10088 */:
            case ErrorCode.ERR_CENTER_ALREADY_PARTICIPANT /* 10089 */:
            case ErrorCode.ERR_CENTER_ADD_PARTICIPANT_FAIL /* 10091 */:
            case ErrorCode.ERR_CENTER_INVALID_CONFNO /* 10092 */:
            default:
                if (!this.f2548q) {
                    this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE, 0, 0, null);
                    mo2290I();
                    break;
                }
                break;
            case 0:
                this.f2537f.onFinishChangeToConference((JoinConferenceRep) message.obj, this.f2740J, this.f2739I, this.f2741K);
                break;
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

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2328a(String str, String str2) {
    }

    /* renamed from: b */
    public int m2661b(String str, String str2) {
        m2658f("startChangeToConference() conferenceNo: " + str + ", p2pKey: " + str2);
        this.f2738H = str;
        this.f2739I = str2;
        if (this.f2736F == null) {
            this.f2736F = new HandlerC1213o(this, null);
        }
        new C1139e(this.f2738H, false, this.f2736F, false).start();
        return 0;
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
    /* renamed from: c */
    public int mo2345c(int i, int i2) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public int mo2346c(ArrayList arrayList) {
        if (this.f2736F != null) {
            m2655c((List) arrayList);
            return PhoneStateMachine.ERROR_INVALID_CHANGE_TO_CONFERENCE_STATE;
        }
        ArrayList arrayListM2656d = m2656d(arrayList);
        if (this.f2736F == null) {
            this.f2736F = new HandlerC1213o(this, null);
        }
        new C1143i(arrayListM2656d, this.f2537f.isUseVideo(), this.f2736F).start();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public int mo2347c(boolean z) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public boolean mo2350c(String str) {
        return (this.f2738H == null || this.f2738H.isEmpty() || !this.f2738H.equals(str)) ? false : true;
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
    /* renamed from: m */
    public int mo2372m() {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: n */
    public int mo2373n() {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: o */
    public int mo2374o() {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: p */
    public int mo2375p() {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: q */
    public int mo2376q() {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
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
