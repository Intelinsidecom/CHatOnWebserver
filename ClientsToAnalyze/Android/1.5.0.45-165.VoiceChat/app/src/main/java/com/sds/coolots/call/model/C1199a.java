package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.model.ConferenceInfo;
import com.coolots.p2pmsg.model.JoinConferenceRep;
import com.coolots.p2pmsg.model.MakeConferenceRep;
import com.coolots.p2pmsg.model.Server;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.p013a.C1142h;
import com.sds.coolots.call.p013a.C1143i;
import com.sds.coolots.call.p013a.C1145k;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;

/* renamed from: com.sds.coolots.call.model.a */
/* loaded from: classes.dex */
public class C1199a extends C1217s {

    /* renamed from: H */
    private static final String f2648H = "[AudioChat]";

    /* renamed from: I */
    private Handler f2649I;

    public C1199a(Destination destination, ConferenceInfo conferenceInfo, String str, String str2, CallState callState, boolean z, CallInstanceInterface callInstanceInterface) {
        super(destination, conferenceInfo, str, str2, callState, z, callInstanceInterface);
        this.f2649I = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2441e(String str) {
        Log.m2958e(f2648H + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2442f(String str) {
        Log.m2963i(f2648H + str);
    }

    /* renamed from: g */
    private int m2443g(String str) {
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (MainApplication.mConfig.isHostInviteOnly() && !this.f2545n) {
            str = null;
        }
        int i = m2366i();
        if (MainApplication.mConfig.isHostInviteOnly() && this.f2545n) {
            i = 10007;
        }
        new C1145k(this.f2763G.getConferenceNo(), str, i, this.f2649I).start();
        return 0;
    }

    @Override // com.sds.coolots.call.model.C1217s, com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2298a(int i, String str) {
        m2442f("remoteHangupCall() hangupReason : " + i + " rejectMsg : " + str);
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3 || this.f2540i.getCallState() == -1) {
            m2441e("remoteHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            m2444a(EventCode.EVENT_CALL_HANGUP, (Object) null);
            return 0;
        }
        if (!this.f2545n && this.f2540i.getCallState() == 1) {
            this.f2535d = true;
        }
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().setEarPhoneScreenLockCallEnd();
        if (this.f2540i.setCallState(3)) {
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            this.f2537f.updateVoipCallState();
            return 0;
        }
        m2441e("remoteHangupCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
        m2716R();
        return PhoneStateMachine.ERROR_INVALID_STATE;
    }

    @Override // com.sds.coolots.call.model.C1217s, com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2305a(String str) {
        return m2443g(str);
    }

    @Override // com.sds.coolots.call.model.C1217s, com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2310a(boolean z, int i) {
        m2441e("localHangupCall " + z + " " + i);
        if (this.f2545n && i == 200 && MainApplication.mInformationActivityGenerator != null) {
            MainApplication.mInformationActivityGenerator.showInformationActivityForReceiverCallStateBusy();
        }
        if (this.f2541j == -1) {
            m2441e("localHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            m2444a(EventCode.EVENT_CALL_HANGUP, (Object) null);
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3) {
            m2441e("localHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            m2444a(EventCode.EVENT_CALL_HANGUP, (Object) null);
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(3)) {
            m2441e("connectCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2537f.updateVoipCallState();
        if (z) {
            m2441e("localHangupCall() : hangUpSIPCall()");
            int iHangUpSIPCall = EngineInterface.getInstance().hangUpSIPCall(this.f2541j);
            if (iHangUpSIPCall != 1) {
                m2441e("localHangupCall meet engine error!! code:" + iHangUpSIPCall);
                mo2290I();
                m2444a(EventCode.EVENT_CALL_HANGUP, (Object) null);
                return iHangUpSIPCall;
            }
        }
        mo2305a(MainApplication.mConfig.getProfileUserID());
        return 0;
    }

    @Override // com.sds.coolots.call.model.C1217s, com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2312a(boolean z, boolean z2, String str) {
        m2442f("<StartOutGoingCall> startOutGoingCall called!! useVideo:" + z);
        this.f2649I = new HandlerC1201c(this, null);
        this.f2537f.setUseVideo(z);
        this.f2537f.getCallOptionData().f2720u = z2;
        if (this.f2540i.getCallState() != 0) {
            m2441e("startOutGoingCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(1)) {
            m2441e("startOutGoingCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (this.f2542k.getPhoneNo() == null || this.f2542k.getPhoneNo().isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f2542k.getConferenceMember());
            SimpleUserInfo simpleUserInfo = new SimpleUserInfo();
            simpleUserInfo.setDeviceID(MainApplication.mConfig.getProfileDeviceID());
            simpleUserInfo.setUserID(MainApplication.mConfig.getProfileUserID());
            simpleUserInfo.setUserName(MainApplication.mConfig.getProfileUserName());
            simpleUserInfo.setUserType(SimpleUserInfo.TYPE_HOST);
            arrayList.add(0, simpleUserInfo);
            new C1143i(arrayList, this.f2537f.isUseVideo(), this.f2649I).start();
        } else {
            new C1142h(this.f2542k.getPhoneNo(), this.f2649I).start();
        }
        m2295N();
        m2444a(EventCode.EVENT_CALL_CALLING, (Object) null);
        return 0;
    }

    /* renamed from: a */
    protected void m2444a(int i, Object obj) {
        this.f2537f.setActivityStatus(i, obj);
        switch (i) {
            case EventCode.EVENT_CONF_MAKE_SUCCESS /* 7000 */:
            case EventCode.EVENT_CONF_ENTER_SUCCESS /* 7007 */:
            case EventCode.EVENT_CALL_CALLING /* 7100 */:
            case EventCode.EVENT_CALL_HANGUP /* 7102 */:
                Message message = new Message();
                message.what = i;
                message.obj = obj;
                if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
                    MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
                    break;
                }
                break;
        }
    }

    @Override // com.sds.coolots.call.model.C1217s
    /* renamed from: a */
    protected void mo2445a(Message message) {
        switch (message.arg1) {
            case -7:
            case -1:
            case 10001:
            case 10005:
            case 10009:
            case ErrorCode.ERR_CENTER_INVALID_VALUE /* 10015 */:
            case ErrorCode.ERR_CENTER_NO_REMAIND_PHONE_NO /* 10036 */:
            case ErrorCode.ERR_CENTER_MCU /* 10087 */:
            case ErrorCode.ERR_CENTER_MAKE_CONFERENCE /* 10090 */:
            case ErrorCode.ERR_CENTER_ADD_PARTICIPANT_FAIL /* 10091 */:
            case ErrorCode.ERR_CENTER_TOO_MANY_MEMBER /* 10094 */:
            case ErrorCode.ERR_CENTER_LACK_OF_MCU_RESOURCE /* 10123 */:
            case ErrorCode.ERR_NEED_TO_CRITICAL_UPDATE /* 10124 */:
                if (MainApplication.mInformationActivityGenerator != null) {
                    MainApplication.mInformationActivityGenerator.showInformationActivityForCallEnd();
                    break;
                }
                break;
            case 0:
                mo2447a((MakeConferenceRep) message.obj);
                return;
        }
        if (this.f2548q) {
            return;
        }
        if (message.arg2 == 7008 && MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.sendHandlerMessage(EventCode.EVENT_CONF_MAKE_FAILURE, 0);
        }
        mo2290I();
    }

    @Override // com.sds.coolots.call.model.C1217s
    /* renamed from: a */
    protected void mo2446a(JoinConferenceRep joinConferenceRep) {
        int port;
        if (this.f2548q) {
            return;
        }
        m2442f("<handleEnterConference> ");
        this.f2542k.setConferenceNo(joinConferenceRep.getConferenceInfo().getConferenceNo());
        this.f2763G = joinConferenceRep.getConferenceInfo();
        m2719c(joinConferenceRep.getServers());
        MainApplication.mConfig.setSipIdSendOnly(this.f2763G.getPhoneNo());
        if ("A".equals(joinConferenceRep.getConferenceInfo().getConferenceType())) {
            this.f2537f.setUseVideo(false);
        } else {
            this.f2537f.setUseVideo(true);
        }
        String ip = null;
        ArrayList arrayListServerInfo = MainApplication.mPhoneManager.getLoginManager().serverInfo();
        int i = 0;
        while (true) {
            if (i >= arrayListServerInfo.size()) {
                port = 0;
                break;
            }
            Server server = (Server) arrayListServerInfo.get(i);
            if (server.getServerType().equals("BS")) {
                ip = server.getIP();
                port = server.getPort();
                break;
            }
            i++;
        }
        if (ip == null) {
            ip = "121.253.18.97";
            port = 80;
        }
        C1189D c1189dA = m2717a(this.f2763G);
        if (c1189dA != null) {
            this.f2541j = EngineInterface.getInstance().startConference(c1189dA, this.f2763G.getDomainAddr(), this.f2763G.getPhoneNo(), this.f2763G.getPassword(), this.f2763G.getMCUPhoneNo(), this.f2537f.isUseVideo(), ip, port, -1, this.f2762F, false);
        }
        if (this.f2541j < 0) {
            m2441e("EnterConference failure!!! error code: " + this.f2541j);
            mo2290I();
        } else if (!this.f2540i.setCallState(2)) {
            m2441e("startOutGoingCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
        } else if (this.f2537f.registVoipCallState()) {
            m2444a(EventCode.EVENT_CONF_ENTER_SUCCESS, this.f2542k);
            this.f2537f.updateVoipCallState();
        } else {
            m2441e("startOutGoingCall registVoipCallState error!!!!");
            mo2290I();
        }
    }

    @Override // com.sds.coolots.call.model.C1217s
    /* renamed from: a */
    protected void mo2447a(MakeConferenceRep makeConferenceRep) {
        if (CallState.isDisconnected(this.f2540i.getCallState()) || this.f2548q) {
            this.f2763G = makeConferenceRep.getConferenceInfo();
            m2716R();
            return;
        }
        m2442f("<handleConferenceMakeSuccess> handleConferenceMakeSuccess called!!");
        this.f2542k.setConferenceNo(makeConferenceRep.getConferenceInfo().getConferenceNo());
        this.f2763G = makeConferenceRep.getConferenceInfo();
        m2719c(makeConferenceRep.getServers());
        MainApplication.mConfig.setSipIdSendOnly(this.f2763G.getPhoneNo());
        new Thread(new RunnableC1200b(this)).start();
    }

    @Override // com.sds.coolots.call.model.C1217s
    /* renamed from: a */
    protected void mo2448a(C1224z c1224z) {
    }

    @Override // com.sds.coolots.call.model.C1217s
    /* renamed from: b */
    protected void mo2449b(Message message) {
        m2441e("<<RDJ>> handleRemoveConferenceMemberAsk");
    }
}
