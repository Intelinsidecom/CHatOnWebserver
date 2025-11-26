package com.sds.coolots.call.model;

import android.graphics.Point;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ConferenceInfo;
import com.coolots.p2pmsg.model.JoinConferenceRep;
import com.coolots.p2pmsg.model.MakeConferenceRep;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.NotifyBoardDataAsk;
import com.coolots.p2pmsg.model.NotifyCloseCallAsk;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.NotifyFinishShareCameraAsk;
import com.coolots.p2pmsg.model.NotifyStartShareScreenAsk;
import com.coolots.p2pmsg.model.NotifyStopShareScreenAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.PushTargetInfo;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.coolots.p2pmsg.model.Server;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.p2pmsg.model.SipProxyInfo;
import com.google.protobuf.ByteString;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.consent.handler.C1162e;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.consent.handler.HandlerC1158a;
import com.sds.coolots.call.consent.handler.HandlerC1159b;
import com.sds.coolots.call.consent.handler.HandlerC1160c;
import com.sds.coolots.call.consent.handler.HandlerC1161d;
import com.sds.coolots.call.model.ConferenceInviteHandler;
import com.sds.coolots.call.p013a.C1135a;
import com.sds.coolots.call.p013a.C1136b;
import com.sds.coolots.call.p013a.C1137c;
import com.sds.coolots.call.p013a.C1138d;
import com.sds.coolots.call.p013a.C1139e;
import com.sds.coolots.call.p013a.C1140f;
import com.sds.coolots.call.p013a.C1141g;
import com.sds.coolots.call.p013a.C1142h;
import com.sds.coolots.call.p013a.C1143i;
import com.sds.coolots.call.p013a.C1144j;
import com.sds.coolots.call.p013a.C1145k;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.calllog.model.ConfUser;
import com.sds.coolots.common.model.CoolotsWakeLockList;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.C1260a;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.StrUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.model.s */
/* loaded from: classes.dex */
public class C1217s extends Call implements CallConsentHandler.CallConsentCallback, ConferenceInviteHandler.OnConferenceInviteTimeoutHandler {

    /* renamed from: H */
    private static final String f2761H = "[ConferenceCall]";

    /* renamed from: F */
    protected String f2762F;

    /* renamed from: G */
    protected ConferenceInfo f2763G;

    /* renamed from: I */
    private int f2764I;

    /* renamed from: J */
    private ConferenceInviteHandler f2765J;

    /* renamed from: K */
    private HandlerC1220v f2766K;

    /* renamed from: L */
    private boolean f2767L;

    /* renamed from: M */
    private final C1221w f2768M;

    /* renamed from: N */
    private boolean f2769N;

    /* renamed from: O */
    private boolean f2770O;

    /* renamed from: P */
    private final C1222x f2771P;

    /* renamed from: Q */
    private final int f2772Q;

    /* renamed from: R */
    private String f2773R;

    /* renamed from: S */
    private boolean f2774S;

    /* renamed from: T */
    private boolean f2775T;

    /* renamed from: U */
    private final ArrayList f2776U;

    /* renamed from: V */
    private int f2777V;

    /* renamed from: W */
    private boolean f2778W;

    public C1217s(Destination destination, ConferenceInfo conferenceInfo, String str, String str2, CallState callState, boolean z, CallInstanceInterface callInstanceInterface) {
        super(destination, callState, z, callInstanceInterface);
        this.f2764I = 0;
        this.f2767L = false;
        this.f2769N = false;
        this.f2770O = false;
        this.f2772Q = 20;
        this.f2773R = null;
        this.f2774S = false;
        this.f2775T = false;
        this.f2776U = new ArrayList();
        this.f2777V = 1;
        this.f2778W = false;
        this.f2538g = false;
        this.f2763G = conferenceInfo;
        this.f2762F = str;
        this.f2771P = new C1222x();
        this.f2768M = new C1221w();
        this.f2768M.m2738a(destination.getConferenceMember());
        this.f2765J = new ConferenceInviteHandler();
        this.f2765J.m2392a(this);
        this.f2773R = str2;
    }

    /* renamed from: S */
    private int m2680S() {
        int port;
        String ip;
        m2706f("startConferenceFromP2P()");
        ArrayList arrayListServerInfo = MainApplication.mPhoneManager.getLoginManager().serverInfo();
        int i = 0;
        while (true) {
            if (i >= arrayListServerInfo.size()) {
                port = 0;
                ip = null;
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
        C1189D c1189dM2717a = m2717a(this.f2763G);
        m2706f("Engine startConference()");
        if (c1189dM2717a != null) {
            this.f2541j = EngineInterface.getInstance().startConference(c1189dM2717a, this.f2763G.getDomainAddr(), this.f2763G.getPhoneNo(), this.f2763G.getPassword(), this.f2763G.getMCUPhoneNo(), this.f2537f.isUseVideo(), ip, port, this.f2542k.getChargeType(), this.f2762F, this.f2774S);
            m2704e("YHT100!!!! set conference call id:" + this.f2541j);
            this.f2537f.setConferenceCallID(this.f2541j);
        }
        if (this.f2541j >= 0) {
            this.f2537f.updateVoipCallState();
            this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_CONFERENCE_FINISH, 0, 0, null);
            return 0;
        }
        m2704e("startOutGoingCall failure!!! error code: " + this.f2541j);
        mo2290I();
        this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE, 0, 0, null);
        return PhoneStateMachine.ERROR_UNKNOWN;
    }

    /* renamed from: T */
    private void m2681T() {
        if (this.f2775T || !this.f2774S) {
            return;
        }
        m2706f("postChangeToConference!!! mIsConferenceFromP2P:" + this.f2774S + ", isMute():" + this.f2537f.getCallOptionData().f2719t);
        if (this.f2537f.getCallOptionData().f2719t) {
            m2354d(this.f2537f.getCallOptionData().f2719t);
        }
        this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_CONFERENCE_DONE, 0, 0, null);
        this.f2775T = true;
    }

    /* renamed from: U */
    private void m2682U() {
        if (this.f2776U.isEmpty()) {
            return;
        }
        C1187B c1187b = (C1187B) this.f2776U.get(0);
        if (c1187b.f2514c == 1) {
            m2720d(c1187b.f2515d);
            this.f2776U.remove(0);
        } else {
            mo2305a(c1187b.f2516e);
            this.f2776U.remove(0);
        }
    }

    /* renamed from: V */
    private boolean m2683V() {
        return m2685X() == 1 && m2684W() == 0;
    }

    /* renamed from: W */
    private int m2684W() {
        int i;
        String profileUserID = MainApplication.mConfig.getProfileUserID();
        if (this.f2542k.getDestinationType() == 5) {
            Iterator it = this.f2542k.getP2PConferenceMember().iterator();
            i = 0;
            while (it.hasNext()) {
                P2PUserInfo p2PUserInfo = (P2PUserInfo) it.next();
                if (!profileUserID.equals(p2PUserInfo.userID) && p2PUserInfo.userState == 0) {
                    i++;
                }
            }
        } else {
            Iterator it2 = this.f2542k.getConferenceMember().iterator();
            i = 0;
            while (it2.hasNext()) {
                SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it2.next();
                if (!profileUserID.equals(simpleUserInfo.getUserID()) && "0".equals(simpleUserInfo.getStatus())) {
                    i++;
                }
            }
        }
        m2706f("getConferenceWaitCount(): " + i);
        return i;
    }

    /* renamed from: X */
    private int m2685X() {
        int i;
        String profileUserID = MainApplication.mConfig.getProfileUserID();
        if (this.f2542k.getDestinationType() == 5) {
            Iterator it = this.f2542k.getP2PConferenceMember().iterator();
            i = 0;
            while (it.hasNext()) {
                P2PUserInfo p2PUserInfo = (P2PUserInfo) it.next();
                if (!profileUserID.equals(p2PUserInfo.userID) && 1 == p2PUserInfo.userState) {
                    i++;
                }
            }
        } else {
            Iterator it2 = this.f2542k.getConferenceMember().iterator();
            i = 0;
            while (it2.hasNext()) {
                SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it2.next();
                if (!profileUserID.equals(simpleUserInfo.getUserID()) && ("1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus()))) {
                    i++;
                }
            }
        }
        m2706f("getConferenceConnectCount(): " + i);
        return i;
    }

    /* renamed from: Y */
    private int m2686Y() {
        Iterator it = this.f2542k.getConferenceMember().iterator();
        int i = 0;
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (!MainApplication.mConfig.getProfileUserID().equals(simpleUserInfo.getUserID()) && "1".equals(simpleUserInfo.getStatus())) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: Z */
    private void m2687Z() {
        m2706f("<handleDenyConference> handleDenyConference called!!");
        if (this.f2537f.getEngineInterface() != null) {
            this.f2537f.getEngineInterface().onHangUpCall(this.f2541j, -1, "");
        }
    }

    /* renamed from: a */
    private int m2688a(String str, boolean z) {
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        String str2 = (!MainApplication.mConfig.isHostInviteOnly() || this.f2545n) ? str : null;
        if (z) {
            this.f2765J.m2393a(str);
        }
        int i = m2366i();
        if (MainApplication.mConfig.isHostInviteOnly() && this.f2545n) {
            i = 10007;
        }
        new C1145k(this.f2763G.getConferenceNo(), str2, i, this.f2766K).start();
        return 0;
    }

    /* renamed from: a */
    private SimpleUserInfo m2689a(List list, List list2) throws NumberFormatException {
        m2706f("checkRemovedMember()");
        int i = Integer.parseInt(SimpleUserInfo.STATE_DENY);
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            m2706f("newMember " + simpleUserInfo.getUserID() + ": " + simpleUserInfo.getStatus());
            int i2 = Integer.parseInt(simpleUserInfo.getStatus());
            if (simpleUserInfo.getStatus().equals("2") || simpleUserInfo.getStatus().equals("3") || i2 >= i) {
                Iterator it2 = list.iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    SimpleUserInfo simpleUserInfo2 = (SimpleUserInfo) it2.next();
                    m2706f("oldMember " + simpleUserInfo2.getUserID() + ": " + simpleUserInfo2.getStatus());
                    int i3 = Integer.parseInt(simpleUserInfo2.getStatus());
                    if (simpleUserInfo2.getUserID().equals(simpleUserInfo.getUserID())) {
                        z = true;
                        if (!simpleUserInfo2.getStatus().equals("2") && !simpleUserInfo2.getStatus().equals("3") && i3 < i) {
                            m2706f(String.valueOf(simpleUserInfo2.getUserID()) + " : " + simpleUserInfo2.getStatus() + " >> " + simpleUserInfo.getStatus());
                            arrayList.add(simpleUserInfo);
                        }
                    }
                }
                if (!z) {
                    m2706f(String.valueOf(simpleUserInfo.getUserID()) + " : " + simpleUserInfo.getStatus());
                    arrayList.add(simpleUserInfo);
                }
            }
        }
        if (arrayList.size() > 0) {
            return (SimpleUserInfo) arrayList.get(0);
        }
        return null;
    }

    /* renamed from: a */
    public static void m2690a(Destination destination, boolean z, Date date, int i) {
        MainApplication.mPhoneManager.getCallLogManager().addCallLogCONFERENCE(i, z, StrUtil.convertDateToyyyyMMddHHmmss(date), 0, new ConfUser(C1221w.m2729a(destination, i)), 0, destination.getGroupID(), false, true, 0);
    }

    /* renamed from: a */
    private void m2693a(ArrayList arrayList, SimpleUserInfo simpleUserInfo) {
        int i = 0;
        Iterator it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                arrayList.add(simpleUserInfo);
                return;
            } else {
                if (((SimpleUserInfo) it.next()).getUserID().equals(simpleUserInfo.getUserID())) {
                    arrayList.remove(i2);
                    arrayList.add(simpleUserInfo);
                    return;
                }
                i = i2 + 1;
            }
        }
    }

    /* renamed from: aa */
    private List m2695aa() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2542k.getConferenceMember().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (SimpleUserInfo.TYPE_HOST.equals(simpleUserInfo.getUserType())) {
                PushTargetInfo pushTargetInfo = new PushTargetInfo();
                pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
                pushTargetInfo.setReceiverUserNo(simpleUserInfo.getUserNo());
                pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
                arrayList.add(pushTargetInfo);
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private int m2696b(ArrayList arrayList, ArrayList arrayList2) {
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                this.f2776U.add(new C1187B((String) it.next()));
            }
        }
        this.f2776U.add(new C1187B(arrayList));
        m2682U();
        return 0;
    }

    /* renamed from: b */
    private void m2697b(ProposeConsentAsk proposeConsentAsk) {
        m2706f("<CIH> sendProposeConsentRep()");
        ProposeConsentRep proposeConsentRep = new ProposeConsentRep();
        proposeConsentRep.setConferenceNo(proposeConsentAsk.getConferenceNo());
        proposeConsentRep.setConsentType(proposeConsentAsk.getConsentType());
        proposeConsentRep.setOption(proposeConsentAsk.getOption());
        proposeConsentRep.setRequestResult(false);
        C1149a.m2141a(C1149a.m2140a(MessageInfo.ProposeConsentRep.getServiceCode(), MessageInfo.ProposeConsentRep.getMessageCode()), proposeConsentRep, m2710i(proposeConsentAsk.getRequesterID()));
    }

    /* renamed from: b */
    private void m2698b(RequestConsentAsk requestConsentAsk) {
        m2706f("<CIH> sendRequestConsentRep()");
        RequestConsentRep requestConsentRep = new RequestConsentRep();
        requestConsentRep.setAccept(false);
        requestConsentRep.setCanceledByTimer(false);
        requestConsentRep.setConferenceNo(requestConsentAsk.getConferenceNo());
        requestConsentRep.setConsentType(requestConsentAsk.getConsentType());
        requestConsentRep.setOption(requestConsentAsk.getOption());
        requestConsentRep.setRequesterID(requestConsentAsk.getRequesterID());
        requestConsentRep.setRequestKey(requestConsentAsk.getRequestKey());
        C1149a.m2141a(C1149a.m2140a(MessageInfo.RequestConsentRep.getServiceCode(), MessageInfo.RequestConsentRep.getMessageCode()), requestConsentRep, m2695aa());
    }

    /* renamed from: d */
    private C1162e m2700d(int i, int i2) {
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
    private void m2701d(int i, int i2, String str) {
        m2706f("notifyConsentRequestAsk()");
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

    /* renamed from: d */
    private void m2702d(List list) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (simpleUserInfo.getStatus().equals("2") || simpleUserInfo.getStatus().equals("3") || simpleUserInfo.getStatus().equals(SimpleUserInfo.STATE_DENY)) {
                hashSet.add(simpleUserInfo.getUserID());
                m2706f("disconnectedMember: " + simpleUserInfo.getUserID());
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            SimpleUserInfo simpleUserInfo2 = (SimpleUserInfo) it2.next();
            if (simpleUserInfo2.getStatus().equals("0")) {
                m2706f("wait member: " + simpleUserInfo2.getUserID() + " inviteID: " + simpleUserInfo2.getInviteUserID());
                if (hashSet.contains(simpleUserInfo2.getInviteUserID())) {
                    mo2305a(simpleUserInfo2.getUserID());
                }
            }
        }
    }

    /* renamed from: e */
    private C1162e m2703e(int i, int i2) {
        C1162e c1162e = new C1162e();
        c1162e.f2383a = i;
        c1162e.f2384b = i2;
        return c1162e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2704e(String str) {
        Log.m2958e(f2761H + str);
    }

    /* renamed from: e */
    private void m2705e(ArrayList arrayList) {
        ArrayList arrayListM2987a = C1260a.m2987a(arrayList);
        if (this.f2533b == null) {
            m2706f("<CIH> mNegoFeatureController should be not null.");
        } else {
            this.f2533b.setResult(arrayListM2987a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2706f(String str) {
        Log.m2963i(f2761H + str);
    }

    /* renamed from: f */
    private void m2707f(ArrayList arrayList) {
        m2706f("<handleAddMember> handleAddMember received!!!!! memberList:" + arrayList.size());
        ArrayList conferenceMember = this.f2542k.getConferenceMember();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m2693a(conferenceMember, (SimpleUserInfo) it.next());
        }
        this.f2542k.setConferenceMember(conferenceMember);
        this.f2768M.m2738a(conferenceMember);
        this.f2537f.setActivityStatus(EventCode.EVENT_CONF_UPDATE_MEMBER, 0, 0, null);
    }

    /* renamed from: g */
    private void m2708g(String str) {
        if (m2683V()) {
            if ((MainApplication.mConfig.isChangeToP2PCall() || MainApplication.mConfig.getCallHangupType() == 3) && this.f2537f != null) {
                m2706f(" checkPreCodition result: " + this.f2537f.onChangeToP2P(str, this.f2763G.getConferenceNo(), this.f2762F, this.f2542k.getConferenceMember()));
                mo2285D();
            }
        }
    }

    /* renamed from: h */
    private void m2709h(String str) {
        ArrayList conferenceMember = this.f2542k.getConferenceMember();
        Iterator it = conferenceMember.iterator();
        int i = 0;
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (simpleUserInfo.getUserID().equals(str)) {
                simpleUserInfo.setStatus("3");
            }
            if ("1".equals(simpleUserInfo.getStatus()) || "0".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                i++;
            }
            m2706f("userID: " + simpleUserInfo.getUserID() + " status: " + simpleUserInfo.getStatus());
        }
        this.f2542k.setConferenceMember(conferenceMember);
        this.f2537f.setActivityStatus(EventCode.EVENT_CONF_UPDATE_MEMBER, 0, 0, null);
        this.f2768M.m2740b(str);
        m2708g(str);
        if (i == 0 && this.f2776U.isEmpty()) {
            m2706f("activeMemberCount == 0 => localHangupCall");
            if (this.f2545n) {
                mo2310a(true, 10);
            }
        }
    }

    /* renamed from: i */
    private List m2710i(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2542k.getConferenceMember().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (simpleUserInfo.getUserID().equals(str)) {
                PushTargetInfo pushTargetInfo = new PushTargetInfo();
                pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
                pushTargetInfo.setReceiverUserNo(simpleUserInfo.getUserNo());
                pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
                arrayList.add(pushTargetInfo);
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    private void m2711k(int i) {
        m2706f("<handleConferenceLayoutChange> handleConferenceLayoutChange called!!");
        this.f2537f.setActivityStatus(EventCode.EVENT_CONF_CHANGE_LAYOUT, i);
    }

    /* renamed from: l */
    private void m2712l(int i) {
        this.f2537f.showToastForShareView(i);
        this.f2537f.stopShareView();
        m2713m(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m2713m(int i) {
        NotifyFinishShareCameraAsk notifyFinishShareCameraAsk = new NotifyFinishShareCameraAsk();
        notifyFinishShareCameraAsk.setConferenceNo(this.f2542k.getPhoneNo());
        notifyFinishShareCameraAsk.setEndReason(i);
        MsgHeader msgHeaderM2140a = C1149a.m2140a(MessageInfo.NotifyFinishShareCameraAsk.getServiceCode(), MessageInfo.NotifyFinishShareCameraAsk.getMessageCode());
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
        C1149a.m2141a(msgHeaderM2140a, notifyFinishShareCameraAsk, arrayList);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: D */
    protected void mo2285D() {
        int i = m2366i();
        if (this.f2524C) {
            return;
        }
        this.f2524C = true;
        String strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(this.f2537f.getCallConnectedTime());
        if (strConvertDateToyyyyMMddHHmmss == null || strConvertDateToyyyyMMddHHmmss.isEmpty() || strConvertDateToyyyyMMddHHmmss.equals("0")) {
            strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(new Date());
        }
        int time = this.f2537f.getCallConnectedTime() != null ? (int) ((new Date().getTime() - this.f2537f.getCallConnectedTime().getTime()) / 1000) : 0;
        m2706f("conferenceCall connected time:" + strConvertDateToyyyyMMddHHmmss + " totalDuration : " + time);
        int i2 = this.f2545n ? 1 : 0;
        if (this.f2535d) {
            i2 = 2;
        }
        if (this.f2534c) {
            i2 = this.f2770O ? 2 : 3;
        }
        int i3 = this.f2546o ? 4 : i2;
        this.f2768M.m2736a();
        ConfUser confUser = new ConfUser(this.f2768M.m2735a(this.f2542k, i3, this.f2773R));
        C1208j callLogData = this.f2537f.getCallLogData();
        callLogData.m2640a(MainApplication.mPhoneManager.getCallLogManager().addCallLogCONFERENCE(i3, this.f2537f.getInitiateCallType() == 2, strConvertDateToyyyyMMddHHmmss, time, confUser, i, this.f2542k.getGroupID(), this.f2774S, CallState.isDisconnected(this.f2540i.getCallState()), callLogData.f2692c));
        this.f2770O = false;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: E */
    protected void mo2286E() {
        String strConvertDateToyyyyMMddHHmmss = StrUtil.convertDateToyyyyMMddHHmmss(this.f2537f.getCallConnectedTime());
        m2706f("first connected time: " + strConvertDateToyyyyMMddHHmmss);
        MainApplication.mPhoneManager.getCallLogManager().updateCallLog(null, strConvertDateToyyyyMMddHHmmss, this.f2537f.getCallDuration());
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: F */
    public int mo2287F() {
        m2706f("updateConferenceMember()");
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            m2706f("call state is DISCONNECTED");
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (this.f2545n) {
            this.f2537f.setCallConnectedTime(new Date());
        }
        new C1139e(this.f2763G.getConferenceNo(), false, this.f2766K, false).start();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: H */
    public int mo2289H() {
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: I */
    protected void mo2290I() {
        m2706f("<handleCallError> handleCallError!!!!");
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
        if (this.f2763G != null) {
            m2716R();
        }
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: O */
    public void mo2296O() {
        new C1137c(this.f2763G.getConferenceNo(), "S", MainApplication.mConfig.getProfileUserID(), 0, new HandlerC1219u(this)).start();
    }

    /* renamed from: P */
    public int m2714P() {
        m2706f("changeToConference");
        this.f2766K = new HandlerC1220v(this, null);
        this.f2774S = true;
        Iterator it = this.f2542k.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("0".equals(simpleUserInfo.getStatus())) {
                if (this.f2545n) {
                    this.f2765J.m2391a(new C1186A(this.f2764I, simpleUserInfo.getUserID()));
                    this.f2764I++;
                }
                this.f2768M.m2737a(simpleUserInfo.getUserID());
            }
        }
        return m2680S();
    }

    /* renamed from: Q */
    public void m2715Q() {
        NotifyCloseCallAsk notifyCloseCallAsk = new NotifyCloseCallAsk();
        notifyCloseCallAsk.setConferenceNo(this.f2763G.getConferenceNo());
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
    protected void m2716R() {
        m2704e("terminateConference()");
        if (this.f2767L || this.f2763G == null) {
            return;
        }
        MainApplication.mPhoneManager.getConfigManager().requestReturnPhoneNoAsk();
        this.f2767L = true;
        if (this.f2763G == null || this.f2763G.getConferenceNo() == null) {
            return;
        }
        if (MainApplication.mConfig.getCallHangupType() == 1) {
            if (this.f2545n) {
                m2704e("CloseConferenceAdaptor run()");
                new C1138d(this.f2763G.getConferenceNo(), m2366i(), this.f2766K).start();
                return;
            }
            return;
        }
        if (MainApplication.mConfig.getCallHangupType() == 2) {
            if (!this.f2545n || m2686Y() > 1) {
                return;
            }
            m2704e("CloseConferenceAdaptor run()");
            new C1138d(this.f2763G.getConferenceNo(), m2366i(), this.f2766K).start();
            return;
        }
        if (MainApplication.mConfig.getCallHangupType() == 3 && this.f2545n && m2686Y() == 0) {
            m2704e("CloseConferenceAdaptor run()");
            new C1138d(this.f2763G.getConferenceNo(), m2366i(), this.f2766K).start();
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2298a(int i, String str) {
        if (i == 1011) {
            if (MainApplication.mInformationActivityGenerator != null && CallState.isConnected(this.f2540i.getCallState())) {
                MainApplication.mInformationActivityGenerator.showInformationActivity(20);
            }
            m2715Q();
        }
        this.f2765J.m2390a();
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3 || this.f2540i.getCallState() == -1) {
            m2704e("remoteHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            m2716R();
            return 0;
        }
        if (!this.f2545n && this.f2540i.getCallState() == 1) {
            this.f2535d = true;
        }
        if (!this.f2545n && !this.f2769N) {
            mo2305a(MainApplication.mConfig.getProfileUserID());
        }
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().setEarPhoneScreenLockCallEnd();
        if (!this.f2540i.setCallState(3)) {
            m2704e("remoteHangupCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            m2716R();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (i == 1011) {
            this.f2537f.setActivityStatus(EventCode.EVENT_CHANGE_TO_P2P_FAILURE, 0, 0, null);
        } else {
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
        }
        this.f2537f.updateVoipCallState();
        m2716R();
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
        m2706f("<<YHT7>> sendBoardData!! in conference call");
        if (!this.f2532a.isShareScreenProcessing() || this.f2549r == null) {
            return PhoneStateMachine.ERROR_INVALID_SHARE_SCREEN_STATE;
        }
        m2706f("<<YHT7>> sendBoardData!! in conference call pass check routine");
        NotifyBoardDataAsk notifyBoardDataAsk = new NotifyBoardDataAsk();
        notifyBoardDataAsk.setConferenceNo(this.f2542k.getPhoneNo());
        notifyBoardDataAsk.setSrcUserID(MainApplication.mConfig.getProfileUserID());
        notifyBoardDataAsk.setBoardType(i);
        notifyBoardDataAsk.setContents(ByteString.copyFrom(bArr));
        MsgHeader msgHeaderM2140a = C1149a.m2140a(MessageInfo.NotifyBoardDataAsk.getServiceCode(), MessageInfo.NotifyBoardDataAsk.getMessageCode());
        m2706f("myID : " + MainApplication.mConfig.getProfileUserID() + " requesterID : " + MainApplication.mPhoneManager.getShareScreenManager().getRequesterID());
        ArrayList arrayList = new ArrayList();
        if (!MainApplication.mConfig.getProfileUserID().equals(MainApplication.mPhoneManager.getShareScreenManager().getRequesterID())) {
            Iterator it = this.f2542k.getConferenceMember().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
                if (simpleUserInfo.getUserID().equals(MainApplication.mPhoneManager.getShareScreenManager().getRequesterID())) {
                    PushTargetInfo pushTargetInfo = new PushTargetInfo();
                    pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
                    pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
                    arrayList.add(pushTargetInfo);
                    break;
                }
            }
        } else {
            Iterator it2 = this.f2542k.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo simpleUserInfo2 = (SimpleUserInfo) it2.next();
                PushTargetInfo pushTargetInfo2 = new PushTargetInfo();
                pushTargetInfo2.setReceiverUserID(simpleUserInfo2.getUserID());
                pushTargetInfo2.setReceiverDeviceID(simpleUserInfo2.getDeviceID());
                arrayList.add(pushTargetInfo2);
            }
        }
        C1149a.m2141a(msgHeaderM2140a, notifyBoardDataAsk, arrayList);
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2301a(Point point, boolean z) throws IOException {
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2532a.isShareScreenProcessing()) {
            return PhoneStateMachine.ERROR_INVALID_SHARE_SCREEN_STATE;
        }
        this.f2551t = 1;
        this.f2532a.setShareScreenProcessing(true);
        if (this.f2555y.getShareMode() == 1) {
            EngineInterface.getInstance().startShareScreen(this.f2541j, this.f2553w, this.f2554x, this.f2550s ? false : true);
        } else {
            EngineInterface.getInstance().resumeShareScreen(this.f2541j, false);
        }
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
        return m2688a(str, true);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2306a(String str, String str2, int i, String str3) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2308a(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ConferenceMember conferenceMember = (ConferenceMember) it.next();
            arrayList3.add(new SimpleUserInfo(conferenceMember.userID, conferenceMember.userName));
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((ConferenceMember) it2.next()).userID);
            }
        }
        int iM2696b = m2696b(arrayList3, arrayList4);
        if (iM2696b != 0) {
            m2704e("addConferenceMember Handling Error!!! Error Code:" + iM2696b);
        }
        return iM2696b;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2309a(short s, boolean z, int i, boolean z2, boolean z3, String str) {
        this.f2537f.getCallOptionData().f2713n = z2;
        m2706f("<StartIncomingCall> startIncomingCall!! useVideo:" + z);
        if (this.f2541j != -1) {
            return PhoneStateMachine.ERROR_BUSY;
        }
        this.f2766K = new HandlerC1220v(this, null);
        this.f2537f.setUseVideo(z);
        if (this.f2540i.getCallState() != 0) {
            m2704e("startIncomingCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(1)) {
            m2704e("startIncomingCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2545n = false;
        this.f2537f.getCallOptionData().f2720u = z3;
        if (!this.f2537f.registVoipCallState()) {
            m2704e("startOutGoingCall registVoipCallState error!!!!");
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
        m2704e("localHangupCall " + z + " " + i);
        if (this.f2545n && i == 200 && MainApplication.mInformationActivityGenerator != null) {
            MainApplication.mInformationActivityGenerator.showInformationActivityForReceiverCallStateBusy();
        }
        if (i == 300 && MainApplication.mInformationActivityGenerator != null) {
            MainApplication.mInformationActivityGenerator.showInformationActivityForNetworkError();
        }
        if (this.f2541j == -1) {
            m2704e("localHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        this.f2765J.m2390a();
        if (this.f2540i.getCallState() == 0 || this.f2540i.getCallState() == 3) {
            m2704e("localHangupCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2540i.setCallState(3)) {
            m2704e("connectCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2537f.updateVoipCallState();
        if (z) {
            m2704e("localHangupCall() : hangUpSIPCall()");
            int iHangUpSIPCall = EngineInterface.getInstance().hangUpSIPCall(this.f2541j);
            if (iHangUpSIPCall != 1) {
                m2704e("localHangupCall meet engine error!! code:" + iHangUpSIPCall);
                mo2290I();
                this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
                return iHangUpSIPCall;
            }
        }
        this.f2769N = true;
        if (MainApplication.mConfig.getCallHangupType() == 1) {
            if (!this.f2545n) {
                mo2305a(MainApplication.mConfig.getProfileUserID());
            }
        } else if (MainApplication.mConfig.getCallHangupType() == 2) {
            if (!this.f2545n || m2686Y() > 1) {
                mo2305a(MainApplication.mConfig.getProfileUserID());
            }
        } else if (MainApplication.mConfig.getCallHangupType() == 3) {
            mo2305a(MainApplication.mConfig.getProfileUserID());
        }
        m2716R();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2311a(boolean z, int i, boolean z2, String str) throws IOException {
        this.f2537f.getCallOptionData().f2713n = z2;
        m2706f("<connectCall> ConnectCall!! ReceiveCall:" + z + "hangupCode: " + i);
        if (CallState.isConnected(this.f2540i.getCallState()) && this.f2774S && !this.f2775T) {
            m2681T();
            return 0;
        }
        if (i == 1003) {
            m2706f("<<RDJ>> conference call is disconnected! hangupReason " + i);
            this.f2770O = true;
        }
        if (this.f2545n && this.f2541j == -1) {
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (CallState.isConnected(this.f2540i.getCallState()) && z) {
            if (5 != this.f2540i.getCallState()) {
                return 0;
            }
            m2706f("syncronizing a mute state between UI and Engine");
            EngineInterface.getInstance().setMicMute(true, !this.f2538g, this.f2541j);
            return 0;
        }
        if (this.f2540i.getCallState() != 1) {
            m2704e("connectCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            if (CallState.isConnected(this.f2540i.getCallState())) {
                return 0;
            }
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (this.f2545n) {
            return 0;
        }
        if (!z) {
            new C1140f(this.f2763G.getConferenceNo(), i, str, this.f2766K).start();
            if (!this.f2540i.setCallState(3)) {
                mo2290I();
                m2704e("disConnectCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            this.f2534c = true;
            m2348c(i);
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
            this.f2537f.updateVoipCallState();
            return 0;
        }
        Date date = new Date();
        this.f2537f.setCallConnectedTime(date);
        this.f2768M.m2739a(this.f2542k.getConferenceMember(), date);
        new C1142h(this.f2763G.getConferenceNo(), this.f2766K).start();
        if (!this.f2540i.setCallState(2)) {
            mo2290I();
            m2704e("connectCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
            MainApplication.mPhoneManager.getDataUsageManager().notifyStartCall(this.f2539h);
        }
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_CONNECTED, 0, 0, null);
        this.f2537f.updateVoipCallState();
        return 0;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public int mo2312a(boolean z, boolean z2, String str) {
        m2706f("<StartOutGoingCall> startOutGoingCall called!! useVideo:" + z);
        this.f2766K = new HandlerC1220v(this, null);
        this.f2537f.setUseVideo(z);
        this.f2537f.getCallOptionData().f2720u = z2;
        if (this.f2540i.getCallState() != 0) {
            m2704e("startOutGoingCall State Check Error!!! current state:" + this.f2540i.getStateDescription());
            mo2290I();
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        Iterator it = this.f2542k.getConferenceMember().iterator();
        while (it.hasNext()) {
            this.f2765J.m2391a(new C1186A(this.f2764I, ((SimpleUserInfo) it.next()).getUserID()));
            this.f2764I++;
        }
        ArrayList arrayList = new ArrayList(this.f2542k.getConferenceMember());
        SimpleUserInfo simpleUserInfo = new SimpleUserInfo();
        simpleUserInfo.setDeviceID(MainApplication.mConfig.getProfileDeviceID());
        simpleUserInfo.setUserID(MainApplication.mConfig.getProfileUserID());
        simpleUserInfo.setUserName(MainApplication.mConfig.getProfileUserName());
        simpleUserInfo.setUserType(SimpleUserInfo.TYPE_HOST);
        arrayList.add(0, simpleUserInfo);
        new C1143i(arrayList, this.f2537f.isUseVideo(), this.f2766K).start();
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.showCallProgressDialog();
            m2704e("[[[LHH]]] Show showCallProgressDialog in startOutGoingCall ProgressBar!!!!!!!!!!!!!!!!!!!!!");
        }
        m2295N();
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_CALLING, 0, 0, null);
        return 0;
    }

    /* renamed from: a */
    protected C1189D m2717a(ConferenceInfo conferenceInfo) {
        if (conferenceInfo == null) {
            return null;
        }
        C1189D c1189d = new C1189D();
        List<SipProxyInfo> sipProxyInfoList = conferenceInfo.getSipProxyInfoList();
        if (sipProxyInfoList == null || sipProxyInfoList.isEmpty()) {
            if (conferenceInfo.getProxyAddr() != null && !conferenceInfo.getProxyAddr().isEmpty()) {
                c1189d.f2598a = conferenceInfo.getProxyAddr();
                c1189d.f2599b = 5060;
            }
            return c1189d;
        }
        c1189d.f2598a = sipProxyInfoList.get(0).getProxyAddr();
        c1189d.f2599b = sipProxyInfoList.get(0).getProxyPort();
        if (sipProxyInfoList.size() > 1) {
            c1189d.f2600c = sipProxyInfoList.get(1).getProxyAddr();
            c1189d.f2601d = sipProxyInfoList.get(1).getProxyPort();
        }
        return c1189d;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2317a(int i, boolean z, boolean z2) throws IOException {
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            m2704e("setRender State Setting Error!!! current state:" + this.f2540i.getStateDescription());
        } else {
            EngineInterface.getInstance().sendRotationInfoForConferenceCall(this.f2541j, i, z, z2);
        }
    }

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
                if (MainApplication.mInformationActivityGenerator != null) {
                    MainApplication.mInformationActivityGenerator.showInformationActivityForCallEnd();
                    break;
                }
                break;
            case 0:
                mo2447a((MakeConferenceRep) message.obj);
                return;
            case ErrorCode.ERR_NEED_TO_CRITICAL_UPDATE /* 10124 */:
                m2704e("ERR_NEED_TO_CRITICAL_UPDATE");
                if (MainApplication.mInformationActivityGenerator != null) {
                    MainApplication.mInformationActivityGenerator.showInformationActivityForCriticalUpdate();
                }
                new C1138d(((MakeConferenceRep) message.obj).getConferenceInfo().getConferenceNo(), m2366i(), this.f2766K).start();
                break;
        }
        if (this.f2548q) {
            return;
        }
        if (message.arg2 == 7008 && MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.sendHandlerMessage(EventCode.EVENT_CONF_MAKE_FAILURE, 0);
        }
        mo2290I();
    }

    /* renamed from: a */
    protected void mo2446a(JoinConferenceRep joinConferenceRep) throws IOException {
        int port;
        String ip = null;
        if (this.f2548q) {
            if (this.f2763G != null) {
                new C1140f(this.f2763G.getConferenceNo(), 1001, "", null).start();
                return;
            } else {
                new C1140f(joinConferenceRep.getConferenceInfo().getConferenceNo(), 1001, "", null).start();
                return;
            }
        }
        m2706f("<handleEnterConference> ");
        this.f2542k.setConferenceNo(joinConferenceRep.getConferenceInfo().getConferenceNo());
        this.f2763G = joinConferenceRep.getConferenceInfo();
        m2719c(joinConferenceRep.getServers());
        MainApplication.mConfig.setSipIdSendOnly(this.f2763G.getPhoneNo());
        if ("A".equals(joinConferenceRep.getConferenceInfo().getConferenceType())) {
            this.f2537f.setUseVideo(false);
        } else {
            this.f2537f.setUseVideo(true);
        }
        if (this.f2774S) {
            m2680S();
            return;
        }
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
        C1189D c1189dM2717a = m2717a(this.f2763G);
        if (c1189dM2717a != null) {
            this.f2541j = EngineInterface.getInstance().startConference(c1189dM2717a, this.f2763G.getDomainAddr(), this.f2763G.getPhoneNo(), this.f2763G.getPassword(), this.f2763G.getMCUPhoneNo(), this.f2537f.isUseVideo(), ip, port, -1, this.f2762F, this.f2774S);
            m2704e("YHT100!!!! set conference call id:" + this.f2541j);
            this.f2537f.setConferenceCallID(this.f2541j);
        }
        if (this.f2541j >= 0) {
            mo2287F();
        } else {
            m2704e("EnterConference failure!!! error code: " + this.f2541j);
            mo2290I();
        }
    }

    /* renamed from: a */
    protected void mo2447a(MakeConferenceRep makeConferenceRep) throws IOException {
        if (CallState.isDisconnected(this.f2540i.getCallState()) || this.f2548q) {
            this.f2763G = makeConferenceRep.getConferenceInfo();
            m2716R();
            return;
        }
        m2706f("<handleConferenceMakeSuccess> handleConferenceMakeSuccess called!!");
        this.f2542k.setConferenceNo(makeConferenceRep.getConferenceInfo().getConferenceNo());
        this.f2542k.setConferenceMember(makeConferenceRep.getSimpleUserInfoList());
        this.f2542k.setCallLogDestForConfHost(makeConferenceRep.getSimpleUserInfoList());
        this.f2768M.m2738a(this.f2542k.getConferenceMember());
        this.f2763G = makeConferenceRep.getConferenceInfo();
        m2719c(makeConferenceRep.getServers());
        MainApplication.mConfig.setSipIdSendOnly(this.f2763G.getPhoneNo());
        this.f2762F = makeConferenceRep.getP2PKey();
        new Thread(new RunnableC1218t(this)).start();
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2320a(NotifyConsentAsk notifyConsentAsk) {
        m2704e("<<YHT122>> handleNotifyConsentAsk");
        if (this.f2763G.getConferenceNo().equals(notifyConsentAsk.getConferenceNo()) && !this.f2545n) {
            if (this.f2526E == null) {
                C1162e c1162eM2700d = m2700d(notifyConsentAsk.getConsentType(), notifyConsentAsk.getOption());
                this.f2526E = new HandlerC1160c(this.f2542k, this, m2703e(notifyConsentAsk.getConsentType(), notifyConsentAsk.getOption()), c1162eM2700d, this.f2777V);
            }
            this.f2526E.handleNotifyConsentAsk(notifyConsentAsk);
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2321a(NotifyFinishShareCameraAsk notifyFinishShareCameraAsk) {
        if (notifyFinishShareCameraAsk.getEndReason() == 1000) {
            EngineInterface.getInstance().startConferenceShareCameraParticipant(this.f2541j);
            this.f2537f.startShareView(false);
            this.f2778W = true;
        } else {
            EngineInterface.getInstance().stopConferenceShareCameraParticipant(this.f2541j);
            this.f2537f.stopShareView();
            this.f2537f.showToastForShareView(2);
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2322a(ProposeConsentAsk proposeConsentAsk) {
        m2706f("<CIH> handleProposeConsentAsk()");
        if (this.f2763G.getConferenceNo().equals(proposeConsentAsk.getConferenceNo()) && this.f2545n) {
            if (this.f2526E == null) {
                C1162e c1162eM2700d = m2700d(proposeConsentAsk.getConsentType(), proposeConsentAsk.getOption());
                this.f2526E = new HandlerC1158a(this.f2542k, this, m2703e(proposeConsentAsk.getConsentType(), proposeConsentAsk.getOption()), c1162eM2700d, this.f2777V);
            }
            if (this.f2526E.getConsentType() != proposeConsentAsk.getConsentType()) {
                m2697b(proposeConsentAsk);
            } else {
                this.f2526E.handleProposeConsentAsk(proposeConsentAsk);
            }
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2323a(ProposeConsentRep proposeConsentRep) {
        m2706f("<CIH> handleProposeConsentRep()");
        if (this.f2763G.getConferenceNo().equals(proposeConsentRep.getConferenceNo()) && !this.f2545n && proposeConsentRep.getConsentType() == this.f2526E.getConsentType() && (this.f2526E instanceof HandlerC1161d)) {
            this.f2526E.handleProposeConsentRep(proposeConsentRep);
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2325a(RequestConsentAsk requestConsentAsk) {
        m2706f("<CIH> handleRequestConsentAsk()");
        if (this.f2763G.getConferenceNo().equals(requestConsentAsk.getConferenceNo())) {
            if (this.f2545n) {
                m2698b(requestConsentAsk);
                return;
            }
            if (this.f2526E == null) {
                C1162e c1162eM2700d = m2700d(requestConsentAsk.getConsentType(), requestConsentAsk.getOption());
                this.f2526E = new HandlerC1160c(this.f2542k, this, m2703e(requestConsentAsk.getConsentType(), requestConsentAsk.getOption()), c1162eM2700d, this.f2777V);
            }
            if (!(this.f2526E instanceof HandlerC1160c)) {
                m2704e("<CIH> handleRequestConsentAsk() step 1");
            } else if (requestConsentAsk.getConsentType() != this.f2526E.getConsentType()) {
                m2704e("<CIH> handleRequestConsentAsk() step 2");
                m2698b(requestConsentAsk);
            } else {
                m2704e("<<YHT10>> handleRequestConsentAsk!!!! receive message!!");
                this.f2526E.handleRequestConsentAsk(requestConsentAsk);
            }
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2326a(RequestConsentRep requestConsentRep) {
        m2706f("<CIH> handleRequestConsentRep()");
        if (this.f2763G.getConferenceNo().equals(requestConsentRep.getConferenceNo()) && this.f2545n && this.f2526E != null && requestConsentRep.getConsentType() == this.f2526E.getConsentType()) {
            this.f2526E.handleRequestConsentRep(requestConsentRep);
        }
    }

    /* renamed from: a */
    protected void mo2448a(C1224z c1224z) throws NumberFormatException, IOException {
        SimpleUserInfo simpleUserInfoM2689a = m2689a(this.f2542k.getConferenceMember(), c1224z.m2747a().getSimpleUserInfoList());
        this.f2542k.setConferenceMember(c1224z.m2747a().getSimpleUserInfoList());
        m2353d(this.f2763G.getPhoneNo());
        this.f2768M.m2738a(c1224z.m2747a().getSimpleUserInfoList());
        this.f2765J.m2394a(c1224z.m2747a().getSimpleUserInfoList());
        this.f2773R = c1224z.m2751b();
        if (c1224z.m2752c() != null) {
            this.f2537f.setMyStartTime(c1224z.m2752c().f2621a, c1224z.m2752c().f2622b);
        }
        if (this.f2545n && this.f2540i.getCallState() == 1) {
            Iterator it = this.f2542k.getConferenceMember().iterator();
            int i = 0;
            while (it.hasNext()) {
                SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
                if (simpleUserInfo.getStatus() != null && ("1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus()))) {
                    i++;
                }
            }
            if (i > 0) {
                if (!this.f2540i.setCallState(2)) {
                    m2704e("connectCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                }
                EngineInterface.getInstance().startConferenceBilling(this.f2541j);
                MainApplication.mPhoneManager.getHardwareManager().setModeConnected(this.f2537f.isUseVideo());
                if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
                    MainApplication.mPhoneManager.getDataUsageManager().notifyStartCall(this.f2539h);
                }
                this.f2537f.setActivityStatus(EventCode.EVENT_CALL_CONNECTED, 0, 0, null);
                this.f2537f.updateVoipCallState();
            }
        }
        int iM2684W = m2684W();
        int i2 = 0;
        for (SimpleUserInfo simpleUserInfo2 : c1224z.m2747a().getSimpleUserInfoList()) {
            if ("1".equals(simpleUserInfo2.getStatus())) {
                this.f2768M.m2739a(this.f2542k.getConferenceMember(), new Date());
            }
            if ("1".equals(simpleUserInfo2.getStatus()) || "0".equals(simpleUserInfo2.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo2.getStatus())) {
                i2++;
            }
        }
        if (iM2684W == 0 && MainApplication.mConfig.isPlayRingBackTone()) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopRingBackTone();
        }
        if (i2 == 0) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
            boolean z = this.f2537f.getCallingActivity() != null;
            if (!this.f2545n) {
                mo2298a(10, "");
            } else if (simpleUserInfoM2689a == null || 200 != Integer.parseInt(simpleUserInfoM2689a.getStatus())) {
                mo2310a(true, 10);
            } else {
                m2706f("haeri=hangup reason deny!!!  + member name?" + simpleUserInfoM2689a.getUserName());
                mo2310a(true, 200);
            }
            MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(z);
        } else {
            if (MainApplication.mConfig.getCallHangupType() == 2 || MainApplication.mConfig.getCallHangupType() == 3) {
                m2702d(c1224z.m2747a().getSimpleUserInfoList());
            }
            C1223y c1223yM2746b = this.f2771P.m2746b(c1224z.m2747a().getSimpleUserInfoList());
            if (!c1223yM2746b.f2788a.isEmpty()) {
                this.f2537f.setActivityStatus(EventCode.EVENT_CONF_CHANGE_HOLD, c1223yM2746b.f2788a);
                this.f2537f.setPlayHoldTone(true);
            }
            if (!c1223yM2746b.f2789b.isEmpty()) {
                this.f2537f.setActivityStatus(EventCode.EVENT_CONF_CHANGE_UNHOLD, c1223yM2746b.f2789b);
                this.f2537f.setPlayHoldTone(false);
            }
            if (this.f2537f.getSSOCallCallback() != null && this.f2540i.getCallState() != 3) {
                this.f2537f.getSSOCallCallback().onCallMemberChanged();
            }
            this.f2537f.setActivityStatus(EventCode.EVENT_CONF_UPDATE_MEMBER, 0, 0, simpleUserInfoM2689a == null ? null : simpleUserInfoM2689a.getUserID());
            m2708g(simpleUserInfoM2689a != null ? simpleUserInfoM2689a.getUserID() : null);
            m2705e((ArrayList) c1224z.m2747a().getSimpleUserInfoList());
            if (this.f2549r != null && this.f2532a.isShareScreenProcessing()) {
                ArrayList arrayList = new ArrayList();
                for (SimpleUserInfo simpleUserInfo3 : c1224z.m2747a().getSimpleUserInfoList()) {
                    ConferenceMember conferenceMember = new ConferenceMember();
                    conferenceMember.userID = simpleUserInfo3.getUserID();
                    conferenceMember.userName = simpleUserInfo3.getUserName();
                    arrayList.add(conferenceMember);
                }
                this.f2549r.onConferenceMemberUpdate(arrayList);
            }
        }
        if (this.f2526E != null) {
            if (c1224z.m2747a().getConferenceType().equals("S")) {
                if (this.f2532a.isShareCameraProcessing()) {
                    this.f2526E.processTimeoutResult(false, false, -1, this.f2541j);
                    return;
                } else {
                    this.f2526E.processTimeoutResult(true, false, -1, this.f2541j);
                    return;
                }
            }
            if (c1224z.m2747a().getConferenceType().equals("V")) {
                if (this.f2537f.isUseVideo()) {
                    this.f2526E.processTimeoutResult(false, false, -1, this.f2541j);
                    return;
                } else {
                    this.f2526E.processTimeoutResult(true, true, 2, this.f2541j);
                    return;
                }
            }
            if (c1224z.m2747a().getConferenceType().equals("A")) {
                if (this.f2537f.isUseVideo()) {
                    this.f2526E.processTimeoutResult(true, true, 1, this.f2541j);
                } else {
                    this.f2526E.processTimeoutResult(false, false, -1, this.f2541j);
                }
            }
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: a */
    public void mo2328a(String str, String str2) {
        m2706f("notiCloseCall :conferenceNo : " + str + "  mConfInfo.getConferenceNo(): " + this.f2763G.getConferenceNo());
        if (this.f2763G.getConferenceNo().equals(str)) {
            mo2310a(true, 1011);
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: b */
    protected void mo2338b(int i, int i2, String str) {
        NotifyStartShareScreenAsk notifyStartShareScreenAsk = new NotifyStartShareScreenAsk();
        notifyStartShareScreenAsk.setConferenceNo(this.f2763G.getConferenceNo());
        notifyStartShareScreenAsk.setWidth(i);
        notifyStartShareScreenAsk.setHeight(i2);
        notifyStartShareScreenAsk.setVersion(str);
        MsgHeader msgHeaderM2140a = C1149a.m2140a(MessageInfo.NotifyStartShareScreenAsk.getServiceCode(), MessageInfo.NotifyStartShareScreenAsk.getMessageCode());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2542k.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            PushTargetInfo pushTargetInfo = new PushTargetInfo();
            pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
            pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
            arrayList.add(pushTargetInfo);
        }
        C1149a.m2141a(msgHeaderM2140a, notifyStartShareScreenAsk, arrayList);
    }

    /* renamed from: b */
    protected void mo2449b(Message message) {
        switch (message.arg1) {
            case 0:
                m2709h((String) message.obj);
                m2682U();
                break;
            case 10009:
            case ErrorCode.ERR_CENTER_MCU /* 10087 */:
            case ErrorCode.ERR_CENTER_INVALID_CONFNO /* 10092 */:
                this.f2776U.clear();
                this.f2765J.m2390a();
                break;
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: b */
    public void mo2342b(boolean z, int i) {
        this.f2546o = true;
        this.f2537f.setUseVideo(z);
        this.f2541j = i;
        this.f2540i.setCallState(-1);
        mo2285D();
        new C1140f(this.f2763G.getConferenceNo(), 301, "", this.f2766K).start();
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public int mo2345c(int i, int i2) {
        m2706f("<CIH> requestCallConsent()");
        if (!this.f2532a.isEnableConsentProcessing()) {
            m2706f("<CIH> requestCallConsent() step 1");
            return PhoneStateMachine.ERROR_INVALID_CONSENT_STATE;
        }
        C1162e c1162eM2700d = m2700d(i, i2);
        C1162e c1162eM2703e = m2703e(i, i2);
        if (this.f2545n) {
            m2706f("<CIH> requestCallConsent() step 2");
            this.f2526E = new HandlerC1159b(this.f2542k, this, c1162eM2703e, c1162eM2700d, this.f2777V);
        } else {
            m2706f("<CIH> requestCallConsent() step 3");
            this.f2526E = new HandlerC1161d(this.f2542k, this, c1162eM2703e, c1162eM2700d, this.f2777V);
        }
        if (this.f2526E.requestConsent()) {
            m2706f("<CIH> requestCallConsent() step 4");
            return 0;
        }
        m2706f("<CIH> requestCallConsent() step 5");
        return PhoneStateMachine.ERROR_UNKNOWN;
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public int mo2347c(boolean z) throws IOException {
        m2704e("setHoldCall() :" + this.f2540i.getStateDescription());
        if (this.f2541j == -1 || this.f2763G == null) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            m2704e("setHoldCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (z) {
            if (!this.f2540i.setCallState(4)) {
                m2704e("setHoldCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            new C1141g(this.f2763G.getConferenceNo(), true, null).start();
            this.f2537f.getCallOptionData().f2714o = true;
            EngineInterface.getInstance().holdSIPCall(this.f2541j, z);
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HOLD, 0, 0, null);
        } else {
            if (!this.f2540i.setCallState(2)) {
                m2704e("setHoldCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            new C1141g(this.f2763G.getConferenceNo(), false, null).start();
            this.f2537f.getCallOptionData().f2714o = false;
            EngineInterface.getInstance().holdSIPCall(this.f2541j, z);
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_UNHOLD, 0, 0, null);
        }
        if (this.f2549r != null) {
            this.f2549r.onCallHoldState(z);
        }
        this.f2537f.updateVoipCallState();
        return 0;
    }

    /* renamed from: c */
    protected void m2718c(Message message) {
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
                    mo2290I();
                    break;
                }
                break;
            case 0:
                mo2446a((JoinConferenceRep) message.obj);
                break;
        }
    }

    /* renamed from: c */
    protected void m2719c(List list) throws IOException {
        m2706f("serServerInfo()");
        if (list == null || list.isEmpty()) {
            m2704e("Servers information is invalid!!!");
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((Server) it.next()).getServerType().equals("CN")) {
                i++;
            }
        }
        Iterator it2 = list.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            Server server = (Server) it2.next();
            if (server.getServerType().equals("CN")) {
                int iIntValue = EngineInterface.CONNECTION_SERVER_DEFAULT_SUB_PORT;
                if (server.getSubPort() != null) {
                    iIntValue = server.getSubPort().intValue();
                }
                EngineInterface.getInstance().reqSetConnServerInfo(i, i2, server.getIP(), server.getPort(), server.getPriority(), iIntValue, server.getCipherKey());
                i2++;
            }
        }
        Iterator it3 = list.iterator();
        int i3 = 0;
        while (it3.hasNext()) {
            Server server2 = (Server) it3.next();
            if (server2.getServerType().equals("UR") || server2.getServerType().equals("TR")) {
                i3++;
            }
        }
        Iterator it4 = list.iterator();
        int i4 = 0;
        while (it4.hasNext()) {
            Server server3 = (Server) it4.next();
            if (server3.getServerType().equals("UR") || server3.getServerType().equals("TR")) {
                EngineInterface.getInstance().reqSetRelayInfo(i3, i4, server3.getServerType(), server3.getIP(), server3.getPort(), server3.getPriority(), server3.getCipherKey());
                i4++;
            }
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: c */
    public boolean mo2350c(String str) {
        return this.f2542k.getPhoneNo().equals(str);
    }

    /* renamed from: d */
    public int m2720d(ArrayList arrayList) {
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f2765J.m2391a(new C1186A(this.f2764I, ((SimpleUserInfo) it.next()).getUserID()));
            this.f2764I++;
        }
        new C1135a(this.f2763G.getConferenceNo(), this.f2537f.isUseVideo(), arrayList, this.f2762F, this.f2766K).start();
        return 0;
    }

    /* renamed from: d */
    protected void m2721d(Message message) {
        m2687Z();
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: e */
    public int mo2357e(boolean z) throws IOException {
        m2706f("setMuteCall(isMute: " + z + ") : " + this.f2540i.getStateDescription());
        if (this.f2538g && this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            m2704e("setMuteCall State Checking Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2537f.getCallOptionData().f2719t = z;
        if (z) {
            if (!this.f2540i.setCallState(5)) {
                m2704e("setMuteCall State Setting Error(1)!!! current state:" + this.f2540i.getStateDescription());
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            if (MainApplication.mPhoneManager.isUseMuteNotification()) {
                new C1144j(this.f2763G.getConferenceNo(), true, false, null).start();
            }
            EngineInterface.getInstance().setMicMute(z, this.f2538g ? false : true, this.f2541j);
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_MUTE, 0, 0, null);
            return 0;
        }
        if (!this.f2540i.setCallState(2)) {
            m2704e("setMuteCall State Setting Error(2)!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (MainApplication.mPhoneManager.isUseMuteNotification()) {
            new C1144j(this.f2763G.getConferenceNo(), false, false, null).start();
        }
        EngineInterface.getInstance().setMicMute(z, this.f2538g ? false : true, this.f2541j);
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_UNMUTE, 0, 0, null);
        return 0;
    }

    /* renamed from: e */
    protected void m2722e(Message message) {
        switch (message.arg1) {
            case 0:
                mo2448a((C1224z) message.obj);
                break;
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: f */
    public int mo2358f(int i) throws IOException {
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2532a.isShareScreenProcessing()) {
            return PhoneStateMachine.ERROR_INVALID_SHARE_SCREEN_STATE;
        }
        m2706f("pauseShareScreen() reson : " + i + " shareMode : " + this.f2555y.getShareMode());
        if (this.f2555y.getShareMode() == 1) {
            EngineInterface.getInstance().stopShareScreen(this.f2541j, !this.f2550s);
        } else {
            EngineInterface.getInstance().pauseShareScreen(this.f2541j, false);
        }
        this.f2551t = 3;
        this.f2532a.setShareScreenProcessing(true);
        this.f2537f.setActivityStatus(EventCode.EVENT_SHARE_SCREEN_PAUSE, 0, 0, null);
        MainApplication.mChatONInterface.sendBroadcastShareViewInfo(3);
        if (this.f2549r == null) {
            return 0;
        }
        this.f2549r.onPauseShareScreen(i);
        return 0;
    }

    /* renamed from: f */
    protected void m2723f(Message message) {
        switch (message.arg1) {
            case 0:
                m2707f((ArrayList) message.obj);
                m2682U();
                break;
            case ErrorCode.ERR_CENTER_INVALID_CONFNO /* 10092 */:
            case ErrorCode.ERR_CENTER_NOT_HOST /* 10093 */:
                this.f2776U.clear();
                this.f2765J.m2390a();
                break;
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: g */
    public int mo2361g(boolean z) {
        m2706f("<CIH> acceptCallConsent()");
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
        new C1137c(this.f2763G.getConferenceNo(), "V", MainApplication.mConfig.getProfileUserID(), i, this.f2766K).start();
    }

    /* renamed from: g */
    protected void m2724g(Message message) {
        m2704e("<<YHT5>> handleChangeConferenceLayoutAsk!!! result:" + message.arg1);
        if (message.arg1 == 0) {
            m2711k(message.arg2);
        }
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: h */
    public void mo2365h(int i) {
        if (this.f2541j != -1 && CallState.isConnected(this.f2540i.getCallState())) {
            new C1136b(this.f2542k.getPhoneNo(), i, this.f2766K).start();
        }
    }

    /* renamed from: h */
    protected void m2725h(Message message) {
        if (message.arg1 != 0) {
            new Message().what = EventCode.EVENT_SHARE_VIEW_END_FAIL;
            m2318a(message, false);
        } else {
            if (this.f2778W) {
                EngineInterface.getInstance().stopConferenceShareCameraParticipant(this.f2541j);
                this.f2778W = false;
            }
            m2712l(message.arg2);
        }
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
        return EngineInterface.getInstance().startAvatar(true, this.f2541j);
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
        return EngineInterface.getInstance().stopAvatar(true, this.f2541j);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void notifyClearConsent() {
        if (this.f2526E != null) {
            this.f2526E = null;
            if (this.f2545n) {
                this.f2777V++;
            }
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void notifyConsentRequest(int i, int i2, String str) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                m2701d(i, i2, str);
                break;
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void notifyConsentResult(boolean z, int i, int i2, boolean z2, boolean z3, String str) {
        m2706f("<CIH> notifyConsentResult(), result = " + z + ", type = " + i + ", option = " + i2 + ", isRequester = " + z2 + ", isTimeCancel = " + z3 + ", userID = " + str);
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
        switch (i) {
            case 1:
                if (z) {
                    m2704e("<<YHT10>> runCallSwitchProcess!! result is " + z);
                    m2316a(this.f2541j, i2, z ? 1 : 0);
                    break;
                }
                break;
            case 2:
                if (!z) {
                    this.f2537f.stopShareView();
                    break;
                } else if (!z2) {
                    EngineInterface.getInstance().startConferenceShareCameraParticipant(this.f2541j);
                    break;
                }
                break;
            case 3:
                MainApplication.mPhoneManager.getShareScreenManager().setRequesterID(str);
                if (z2 && z) {
                    MainApplication.mPhoneManager.getShareScreenManager().startShareScreen(this.f2542k, MainApplication.mContext.getResources().getDisplayMetrics().widthPixels, MainApplication.mContext.getResources().getDisplayMetrics().heightPixels, "1");
                    break;
                }
                break;
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void notifyProposeResult(boolean z, int i, int i2, boolean z2, boolean z3, String str) {
        if (z) {
            return;
        }
        this.f2526E = null;
        m2333a(z, i, i2);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void notifySendPush() {
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: o */
    public int mo2374o() {
        return CallState.isDisconnected(this.f2540i.getCallState()) ? PhoneStateMachine.ERROR_INVALID_STATE : !this.f2537f.isUseVideo() ? PhoneStateMachine.ERROR_INVALID_CALL_TYPE : !this.f2537f.getCallOptionData().f2711l ? PhoneStateMachine.ERROR_NOT_AVATAR_MODE : EngineInterface.getInstance().createCustomAvatar(true, this.f2541j);
    }

    @Override // com.sds.coolots.call.model.ConferenceInviteHandler.OnConferenceInviteTimeoutHandler
    public void onConferenceInviteTimeout(String str) {
        m2688a(str, false);
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: p */
    public int mo2375p() {
        return CallState.isDisconnected(this.f2540i.getCallState()) ? PhoneStateMachine.ERROR_INVALID_STATE : !this.f2537f.isUseVideo() ? PhoneStateMachine.ERROR_INVALID_CALL_TYPE : !this.f2537f.getCallOptionData().f2711l ? PhoneStateMachine.ERROR_NOT_AVATAR_MODE : EngineInterface.getInstance().changeAvatarHair(true, this.f2541j);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler.CallConsentCallback
    public void processCallConsentTimeOut() {
        new C1139e(this.f2763G.getConferenceNo(), false, this.f2766K, false).start();
    }

    @Override // com.sds.coolots.call.model.Call
    /* renamed from: q */
    public int mo2376q() {
        return CallState.isDisconnected(this.f2540i.getCallState()) ? PhoneStateMachine.ERROR_INVALID_STATE : !this.f2537f.isUseVideo() ? PhoneStateMachine.ERROR_INVALID_CALL_TYPE : !this.f2537f.getCallOptionData().f2711l ? PhoneStateMachine.ERROR_NOT_AVATAR_MODE : EngineInterface.getInstance().changeAvatarGlasses(true, this.f2541j);
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
        notifyStopShareScreenAsk.setConferenceNo(this.f2763G.getConferenceNo());
        MsgHeader msgHeaderM2140a = C1149a.m2140a(MessageInfo.NotifyStopShareScreenAsk.getServiceCode(), MessageInfo.NotifyStopShareScreenAsk.getMessageCode());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2542k.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            PushTargetInfo pushTargetInfo = new PushTargetInfo();
            pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
            pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
            arrayList.add(pushTargetInfo);
        }
        C1149a.m2141a(msgHeaderM2140a, notifyStopShareScreenAsk, arrayList);
    }
}
