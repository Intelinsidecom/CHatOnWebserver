package com.sds.coolots.call.model;

import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.NotifyBoardDataAsk;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.NotifyFinishShareCameraAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.ReqAddConferenceMemberRep;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.CallFunctionControllerInterface;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.nego.NegoFeatureControllerInterface;
import com.sds.coolots.call.nego.p015a.C1226a;
import com.sds.coolots.call.p013a.C1137c;
import com.sds.coolots.call.screenshare.ScreenShareProcInterface;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.controller.C1246b;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Call implements CallState.CallStateCallback {
    public static final int CONNECTED_CONNECTED = 16;
    public static final int CONNECTED_UNHOLD = 17;
    public static final int CONNECTED_UNMUTE = 18;
    public static final int DISCONNECTED_ERROR = 20;
    public static final int DISCONNECTED_HANGUP = 19;
    public static final int EANIMATION_NO1 = 0;
    public static final int EANIMATION_NO2 = 1;
    public static final int EANIMATION_NO3 = 2;
    public static final int EANIMATION_NO4 = 3;
    public static final int EANIMATION_NO5 = 4;
    public static final String EXTRAS_KEY_REJECT_MSG_NOTI_MSG = "reject_msg_noti_msg";
    public static final String EXTRAS_KEY_REJECT_MSG_NOTI_USERID = "reject_msg_noti_userID";

    /* renamed from: F */
    private static final String f2518F = "[Call]";
    public static final int HANGUP_REASON_BLOCKED = 301;
    public static final int HANGUP_REASON_CONFERENCE_LOCAL_FAIL = 1010;
    public static final int HANGUP_REASON_CONFERENCE_SERVER_FAIL = 1009;
    public static final int HANGUP_REASON_DENY = 100;
    public static final int HANGUP_REASON_DENY_BUSY = 200;
    public static final int HANGUP_REASON_ENGINE_DEFAULT = 10001;
    public static final int HANGUP_REASON_EVENT_ID_NOT_MATCH = 1012;
    public static final int HANGUP_REASON_FAIL_CHANGE_CONF_TO_P2P = 1011;
    public static final int HANGUP_REASON_INIT = -1;
    public static final int HANGUP_REASON_LOCAL_3G = 1004;
    public static final int HANGUP_REASON_LOCAL_ERROR = 1001;
    public static final int HANGUP_REASON_LOW_QUALITY = 1007;
    public static final int HANGUP_REASON_NETWORK = 300;
    public static final int HANGUP_REASON_NONE = 0;
    public static final int HANGUP_REASON_NOPHONENUMBER = 10006;
    public static final int HANGUP_REASON_NORMAL = 10;
    public static final int HANGUP_REASON_NOTAVAILABLEP2PSESSION = 1008;
    public static final int HANGUP_REASON_NOT_CONNECTED = 1000;
    public static final int HANGUP_REASON_NOT_SUPPORT_NETWORK = 1006;
    public static final int HANGUP_REASON_OTHER_DEVICE_ACCEPT = 201;
    public static final int HANGUP_REASON_OTHER_DEVICE_DENY = 202;
    public static final int HANGUP_REASON_REJECT_MESSAGE_TIMER = 1300;
    public static final int HANGUP_REASON_REMOTE_ERROR = 1002;
    public static final int HANGUP_REASON_REMOTE_NETWORK = 1005;
    public static final int HANGUP_REASON_REMOVE_BY_HOST = 10007;
    public static final int HANGUP_REASON_SIP_LOCAL_ERROR_CONNECTED = 1200;
    public static final int HANGUP_REASON_SIP_LOCAL_ERROR_NOT_CONNECTED = 1100;
    public static final int HANGUP_REASON_SIP_SERVER_ERROR_CONNECTED = 1201;
    public static final int HANGUP_REASON_SIP_SERVER_ERROR_NOT_CONNECTED = 1101;
    public static final int HANGUP_REASON_SYSTEM_1 = 101;
    public static final int HANGUP_REASON_SYSTEM_2 = 102;
    public static final int HANGUP_REASON_SYSTEM_3 = 103;
    public static final int HANGUP_REASON_SYSTEM_4 = 104;
    public static final int HANGUP_REASON_SYSTEM_5 = 105;
    public static final int HANGUP_REASON_SYSTEM_6 = 106;
    public static final int HANGUP_REASON_WAITING_TIMEOUT = 1003;
    public static final int HANGUP_RESAON_MEDIA_SEND = 10005;

    /* renamed from: J */
    private static final int f2519J = 12001;

    /* renamed from: K */
    private static final int f2520K = 2000;
    public static final int RECORDING_VIDEO = 2;
    public static final int RECORDING_VOICE = 1;
    public static final int SC_NON_TEXT_MODE = 0;
    public static final int SC_TEXT_MODE = 1;
    public static final int SHARE_SCREEN_END = 2;
    public static final int SHARE_SCREEN_PAUSE = 3;
    public static final int SHARE_SCREEN_START = 1;
    public static final int[] THEMESHOT_SHIFT_INDEX = {0, 3, 6, 9, 12};
    public static final int THEMESHOT_SHIFT_START_INDEX = 0;
    public static final int THEMESHOT_SUBTITLE_MNUM = 3;
    public static final int THEMESHOT_TITLE_MNUM = 5;
    public static final String VOIPACTION = "com.sds.coolots.broadcast.VOIPACTION";
    public static final int VT_MODE = 2;

    /* renamed from: u */
    protected static final String f2521u = "1";

    /* renamed from: E */
    protected CallConsentHandler f2526E;

    /* renamed from: a */
    protected CallFunctionControllerInterface f2532a;

    /* renamed from: b */
    protected NegoFeatureControllerInterface f2533b;

    /* renamed from: f */
    protected CallInstanceInterface f2537f;

    /* renamed from: g */
    protected boolean f2538g;

    /* renamed from: i */
    protected CallState f2540i;

    /* renamed from: k */
    protected Destination f2542k;

    /* renamed from: n */
    protected boolean f2545n;

    /* renamed from: r */
    protected ShareScreenCallback f2549r;

    /* renamed from: w */
    protected int f2553w;

    /* renamed from: x */
    protected int f2554x;

    /* renamed from: y */
    protected ScreenShareProcInterface f2555y;

    /* renamed from: c */
    protected boolean f2534c = false;

    /* renamed from: d */
    protected boolean f2535d = false;

    /* renamed from: e */
    protected boolean f2536e = false;

    /* renamed from: h */
    protected int f2539h = 0;

    /* renamed from: j */
    protected int f2541j = -1;

    /* renamed from: l */
    protected String f2543l = "";

    /* renamed from: m */
    protected String f2544m = "";

    /* renamed from: G */
    private int f2527G = 0;

    /* renamed from: H */
    private boolean f2528H = true;

    /* renamed from: o */
    protected boolean f2546o = false;

    /* renamed from: p */
    protected boolean f2547p = false;

    /* renamed from: q */
    protected boolean f2548q = false;

    /* renamed from: s */
    protected boolean f2550s = false;

    /* renamed from: t */
    protected int f2551t = -1;

    /* renamed from: v */
    protected int f2552v = 0;

    /* renamed from: z */
    protected int f2556z = -1;

    /* renamed from: I */
    private int f2529I = 0;

    /* renamed from: A */
    protected int[] f2522A = new int[10];

    /* renamed from: B */
    protected short f2523B = -1;

    /* renamed from: C */
    protected boolean f2524C = false;

    /* renamed from: L */
    private Handler f2530L = new HandlerC1203e(this);

    /* renamed from: D */
    public ArrayList f2525D = new ArrayList();

    /* renamed from: M */
    private final C1197L f2531M = new C1197L();

    public Call(Destination destination, CallState callState, boolean z, CallInstanceInterface callInstanceInterface) {
        this.f2537f = null;
        this.f2545n = true;
        this.f2537f = callInstanceInterface;
        this.f2545n = z;
        this.f2540i = callState;
        this.f2540i.setCallStateCallback(this);
        this.f2542k = destination;
        if (this.f2542k != null && this.f2542k.getCallInstanceID() == -1) {
            this.f2542k.setCallInstanceID(this.f2537f.getCallInstanceID());
        }
        for (int i = 0; i < 10; i++) {
            this.f2522A[i] = -1;
        }
        this.f2532a = new C1246b(this.f2540i, this.f2526E);
        this.f2533b = new C1226a(destination, this.f2541j);
    }

    /* renamed from: P */
    private boolean m2275P() {
        return this.f2537f.getCallOptionData().f2714o || this.f2537f.getCallOptionData().f2715p;
    }

    /* renamed from: Q */
    private void m2276Q() {
        if (this.f2537f.isUseVideo()) {
            this.f2537f.setUseVideo(false);
            this.f2537f.updateVoipCallState();
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().updateMobilePhoneState();
    }

    /* renamed from: R */
    private Intent m2277R() {
        m2281f("makeIntentForCallSwitching()");
        Intent callIntent = MainApplication.mCallIntentGenerator.getCallIntent(this.f2537f.isUseVideo(), this.f2537f.getCallOptionData().f2720u, this.f2537f.isSIPCall());
        if (callIntent != null) {
            callIntent.putExtra(EventCode.EVENT_IDENTIFIER, EventCode.EVENT_CALL_ACTION);
            callIntent.setAction(CallActivity.getStringForEvent(EventCode.EVENT_CALL_ACTION));
            callIntent.addFlags(268435456);
            callIntent.addFlags(536870912);
            callIntent.addFlags(8388608);
        }
        return callIntent;
    }

    /* renamed from: S */
    private void m2278S() {
        Message message = new Message();
        message.what = EventCode.EVENT_STACK_LAYOUT_UPDATE;
        m2318a(message, false);
    }

    /* renamed from: e */
    private void m2280e(String str) {
        Log.m2958e(f2518F + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2281f(String str) {
        Log.m2963i(f2518F + str);
    }

    /* renamed from: A */
    public int[] m2282A() {
        return this.f2522A;
    }

    /* renamed from: B */
    public short m2283B() {
        return this.f2523B;
    }

    /* renamed from: C */
    public void m2284C() {
        MainApplication.mCallNotification.deleteCallNotification();
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_HANGUP, 0, 0, null);
    }

    /* renamed from: D */
    protected abstract void mo2285D();

    /* renamed from: E */
    protected abstract void mo2286E();

    /* renamed from: F */
    public abstract int mo2287F();

    /* renamed from: G */
    protected void m2288G() {
        m2281f("sendIntent()");
        Intent callIntent = MainApplication.mCallIntentGenerator.getCallIntent(this.f2537f.isUseVideo(), this.f2537f.getCallOptionData().f2720u, this.f2537f.isSIPCall());
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

    /* renamed from: H */
    public abstract int mo2289H();

    /* renamed from: I */
    protected abstract void mo2290I();

    /* renamed from: J */
    public boolean m2291J() {
        return this.f2538g;
    }

    /* renamed from: K */
    public int m2292K() throws IOException {
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            m2280e("stopFileTransfer State Check Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (this.f2542k.getDestinationType() != 2) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        EngineInterface.getInstance().stopFileTransfer(this.f2541j);
        return 0;
    }

    /* renamed from: L */
    public ArrayList m2293L() {
        Log.m2954d("getRemoteInfoData");
        if (this.f2531M == null) {
            return null;
        }
        return this.f2531M.getMappingRemoteInfo();
    }

    /* renamed from: M */
    public boolean m2294M() {
        return this.f2526E != null;
    }

    /* renamed from: N */
    public void m2295N() {
        if (PhoneManager.is3GNetworkConnected(MainApplication.mContext)) {
            this.f2547p = true;
        } else {
            this.f2547p = false;
        }
    }

    /* renamed from: O */
    public abstract void mo2296O();

    /* renamed from: a */
    public int m2297a(int i, int i2, String str) {
        m2281f("<<YHT223>> startShareScreen!!!");
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        m2281f("<<YHT223>> startShareScreen!!! #1");
        MainApplication.mScreenShareProcGenerator.resetShareScreenSurface();
        this.f2537f.setActivityStatus(EventCode.EVENT_SHARE_SCREEN_START, 0, 0, null);
        this.f2532a.setShareScreenProcessing(true);
        this.f2551t = 1;
        this.f2550s = true;
        this.f2553w = i;
        this.f2554x = i2;
        mo2338b(i, i2, str);
        if (!this.f2537f.getCallOptionData().f2720u) {
            this.f2555y = MainApplication.mScreenShareProcGenerator.createScreenShareProc();
            this.f2555y.start(0);
        }
        this.f2537f.getCallOptionData().m2642a(false);
        EngineInterface.getInstance().startShareScreen(this.f2541j, i, i2, !this.f2550s);
        MainApplication.mChatONInterface.sendBroadcastShareViewInfo(1);
        m2281f("<<YHT223>> startShareScreen!!! #2");
        if (this.f2549r != null) {
            this.f2549r.onStartShareScreen(i, i2, str, this.f2537f.getCallOptionData().f2720u);
        }
        this.f2537f.chageAudioModeForScreenShare();
        m2276Q();
        return 0;
    }

    /* renamed from: a */
    public abstract int mo2298a(int i, String str);

    /* renamed from: a */
    public abstract int mo2299a(int i, Date date);

    /* renamed from: a */
    public abstract int mo2300a(int i, byte[] bArr);

    /* renamed from: a */
    public abstract int mo2301a(Point point, boolean z);

    /* renamed from: a */
    public int m2302a(Camera camera) {
        m2281f("stopVideoCall is called!!!!!!!");
        return 0;
    }

    /* renamed from: a */
    public int m2303a(Camera camera, int i, int i2) {
        m2281f("startVideoCall is called!!!!!!!");
        EngineInterface.getInstance().setCamera(camera);
        EngineInterface.getInstance().setVideoFormat(i, MainApplication.mConfig.getCallBandWidth(), i2);
        EngineInterface.getInstance().startCamera();
        return 0;
    }

    /* renamed from: a */
    public abstract int mo2304a(NotifyBoardDataAsk notifyBoardDataAsk);

    /* renamed from: a */
    public abstract int mo2305a(String str);

    /* renamed from: a */
    public abstract int mo2306a(String str, String str2, int i, String str3);

    /* renamed from: a */
    public int m2307a(ArrayList arrayList) throws IOException {
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (CallState.isDisconnected(this.f2540i.getCallState())) {
            m2280e("startFileTransfer State Check Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (this.f2542k.getDestinationType() != 2) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        EngineInterface.getInstance().startFileTransfer(this.f2541j, arrayList);
        return 0;
    }

    /* renamed from: a */
    public abstract int mo2308a(ArrayList arrayList, ArrayList arrayList2);

    /* renamed from: a */
    public abstract int mo2309a(short s, boolean z, int i, boolean z2, boolean z3, String str);

    /* renamed from: a */
    public abstract int mo2310a(boolean z, int i);

    /* renamed from: a */
    public abstract int mo2311a(boolean z, int i, boolean z2, String str);

    /* renamed from: a */
    public abstract int mo2312a(boolean z, boolean z2, String str);

    /* renamed from: a */
    public CallFunctionControllerInterface m2313a() {
        return this.f2532a;
    }

    /* renamed from: a */
    public void m2314a(int i) {
        this.f2539h = i;
    }

    /* renamed from: a */
    public void m2315a(int i, int i2) {
        if (MainApplication.mPhoneManager.isConfTest()) {
            m2281f("setRemoteRotationInfo() : rotation = " + i + ", surfID = " + i2);
            this.f2522A[i2] = i;
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_REMOTEROTATION_P2P_CONF, 0, 0, this.f2522A);
        } else {
            this.f2556z = i;
            this.f2529I = i2;
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_REMOTEROTATION, this.f2556z, this.f2529I, null);
        }
    }

    /* renamed from: a */
    public void m2316a(int i, int i2, int i3) throws IOException {
        if (i3 != 1) {
            Message message = new Message();
            message.what = EventCode.EVENT_CALL_SWITCH_PROCESS_CLOSE_POPUP;
            m2318a(message, false);
            return;
        }
        if (m2275P()) {
            MainApplication.mPhoneManager.getPhoneStateMachine().unHoldCall(this.f2542k);
        }
        this.f2532a.setCallSwitchingProcessing(i2);
        if (i2 == 1) {
            MainApplication.mPhoneManager.getPhoneStateMachine().stopDualCamera(this.f2542k);
            this.f2537f.setUseVideo(false);
            MainApplication.mPhoneManager.getPhoneStateMachine().updateMobilePhoneState();
            this.f2537f.getAudioPathController().initCallSwitching(false);
        } else if (i2 == 2) {
            this.f2537f.setUseVideo(true);
            MainApplication.mPhoneManager.getPhoneStateMachine().updateMobilePhoneState();
            this.f2537f.getAudioPathController().initCallSwitching(true);
        } else {
            m2281f("CALL_SWITCH runCallSwitchProcess InValid option!!!");
        }
        this.f2537f.getAudioPathController().initUIComponents(true);
        Message message2 = new Message();
        message2.what = EventCode.EVENT_CALL_SWITCH_PROCESS_ACTIVITY;
        message2.obj = m2277R();
        m2318a(message2, true);
        EngineInterface.getInstance().notifyCallSwitching(this.f2541j, i2, 1);
    }

    /* renamed from: a */
    public abstract void mo2317a(int i, boolean z, boolean z2);

    /* renamed from: a */
    public void m2318a(Message message, boolean z) {
        m2281f("sendEvent()! event type:" + message.what);
        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
            MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
        } else if (this.f2537f.getCallingActivity() != null) {
            this.f2537f.getCallingActivity().sendHandlerMessage(message, 0L);
        } else if (z) {
            m2288G();
        }
    }

    /* renamed from: a */
    public void m2319a(MsgHeader msgHeader, MsgBody msgBody) {
        m2281f("sendPushMessage!!");
        EngineInterface.getInstance().sendPushMessageByP2P(this.f2541j, msgHeader, msgBody);
    }

    /* renamed from: a */
    public abstract void mo2320a(NotifyConsentAsk notifyConsentAsk);

    /* renamed from: a */
    public abstract void mo2321a(NotifyFinishShareCameraAsk notifyFinishShareCameraAsk);

    /* renamed from: a */
    public abstract void mo2322a(ProposeConsentAsk proposeConsentAsk);

    /* renamed from: a */
    public abstract void mo2323a(ProposeConsentRep proposeConsentRep);

    /* renamed from: a */
    public void mo2324a(ReqAddConferenceMemberRep reqAddConferenceMemberRep) {
    }

    /* renamed from: a */
    public abstract void mo2325a(RequestConsentAsk requestConsentAsk);

    /* renamed from: a */
    public abstract void mo2326a(RequestConsentRep requestConsentRep);

    /* renamed from: a */
    public void m2327a(ShareScreenCallback shareScreenCallback) {
        this.f2549r = shareScreenCallback;
    }

    /* renamed from: a */
    public abstract void mo2328a(String str, String str2);

    /* renamed from: a */
    public void m2329a(String str, String str2, String str3) {
        m2281f("receiveConfLayoutUserInformation");
        if (this.f2531M.setMappingEngineData(str, str2, str3)) {
            m2278S();
        }
    }

    /* renamed from: a */
    public void mo2330a(List list) {
    }

    /* renamed from: a */
    public void m2331a(short s) {
        this.f2523B = s;
    }

    /* renamed from: a */
    public void m2332a(boolean z) {
        m2281f("<<YHT5>> setCallPushState is called!!! state:" + z);
        this.f2528H = z;
    }

    /* renamed from: a */
    public void m2333a(boolean z, int i, int i2) {
        m2281f("notifyProposeResult. Call.java result : " + z);
        if (this.f2537f.getCallingActivity() != null) {
            Message message = new Message();
            message.what = EventCode.EVENT_CALL_PROPOSE_REP_RECEIVED;
            message.arg1 = z ? 1 : 0;
            message.arg2 = i;
            m2318a(message, false);
        }
    }

    /* renamed from: b */
    public int m2334b(int i, int i2) {
        if (this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (CallState.isConnected(this.f2540i.getCallState())) {
            EngineInterface.getInstance().setRenderer(i, i2);
            return 0;
        }
        m2280e("setRender State Setting Error!!! current state:" + this.f2540i.getStateDescription());
        return PhoneStateMachine.ERROR_INVALID_STATE;
    }

    /* renamed from: b */
    public int m2335b(int i, String str) {
        m2281f("<<YHT223>> stopShareScreen!!!");
        this.f2537f.returnAudioModeForShareScreen();
        if (!this.f2532a.isShareScreenProcessing()) {
            return PhoneStateMachine.ERROR_INVALID_SHARE_SCREEN_STATE;
        }
        m2281f("<<YHT223>> stopShareScreen!!! #1");
        this.f2551t = 2;
        this.f2532a.setShareScreenProcessing(false);
        if (this.f2542k.getDestinationType() == 4) {
            m2339b(str);
        }
        mo2383x();
        if (this.f2555y != null) {
            this.f2555y.stop();
        }
        EngineInterface.getInstance().stopShareScreen(this.f2541j, !this.f2550s);
        if (this.f2549r != null) {
            this.f2549r.onStopShareScreen(i);
            this.f2549r = null;
        }
        m2281f("<<YHT223>> stopShareScreen!!! #2");
        m2276Q();
        MainApplication.mScreenShareProcGenerator.resetShareScreenSurface();
        MainApplication.mPhoneManager.getPhoneStateMachine().showCallActivity(this.f2537f.isUseVideo(), false, this.f2537f.isSIPCall());
        MainApplication.mChatONInterface.sendBroadcastShareViewInfo(2);
        this.f2537f.setActivityStatus(EventCode.EVENT_SHARE_SCREEN_END, 0, 0, null);
        m2281f("<<YHT223>> stopShareScreen!!! #3");
        return 0;
    }

    /* renamed from: b */
    public int mo2336b(ArrayList arrayList) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    /* renamed from: b */
    public NegoFeatureControllerInterface m2337b() {
        return this.f2533b;
    }

    /* renamed from: b */
    protected abstract void mo2338b(int i, int i2, String str);

    /* renamed from: b */
    public void m2339b(String str) {
        m2281f("kyj requesterID = " + str);
        if (str == null || str.isEmpty()) {
            new C1137c(this.f2542k.getPhoneNo(), "V", MainApplication.mConfig.getProfileUserID(), 0, this.f2530L).start();
        } else {
            new C1137c(this.f2542k.getPhoneNo(), "V", str, 0, this.f2530L).start();
        }
    }

    /* renamed from: b */
    public void m2340b(List list) {
        m2281f("<CIH> onReceiveFeatureInfo()");
        if (this.f2533b == null) {
            m2281f("<CIH> mNegoFeatureController should be not null.");
        } else {
            this.f2533b.setResult(list);
        }
    }

    /* renamed from: b */
    public void m2341b(boolean z) {
        m2281f("setIsCallTransforming is deprecated.");
    }

    /* renamed from: b */
    public abstract void mo2342b(boolean z, int i);

    /* renamed from: b */
    public boolean mo2343b(int i) {
        return this.f2541j == i;
    }

    /* renamed from: c */
    public int m2344c() {
        return this.f2539h;
    }

    /* renamed from: c */
    public abstract int mo2345c(int i, int i2);

    /* renamed from: c */
    public int mo2346c(ArrayList arrayList) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    /* renamed from: c */
    public abstract int mo2347c(boolean z);

    /* renamed from: c */
    public void m2348c(int i) {
        m2281f("setHangupCode: from " + this.f2527G + " to " + i);
        this.f2527G = i;
    }

    /* renamed from: c */
    public void m2349c(int i, int i2, String str) {
        m2281f("<<YHT223>> onNotifyStartShareScreenAsk!!");
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            m2280e("<<YHT223>> onNotifyStartShareScreenAsk!! not connected");
            return;
        }
        MainApplication.mScreenShareProcGenerator.resetShareScreenSurface();
        this.f2537f.setActivityStatus(EventCode.EVENT_SHARE_SCREEN_START, 0, 0, null);
        m2281f("<<YHT223>> onNotifyStartShareScreenAsk!! #1");
        this.f2551t = 1;
        this.f2532a.setShareScreenProcessing(true);
        this.f2550s = false;
        this.f2553w = i;
        this.f2554x = i2;
        this.f2537f.getCallOptionData().m2642a(false);
        this.f2555y = MainApplication.mScreenShareProcGenerator.createScreenShareProc();
        if (this.f2537f.getCallOptionData().f2720u) {
            this.f2555y.start(3);
        } else {
            this.f2555y.start(1);
        }
        EngineInterface.getInstance().startShareScreen(this.f2541j, this.f2553w, this.f2554x, this.f2550s ? false : true);
        m2281f("<<YHT223>> onNotifyStartShareScreenAsk!! #2");
        if (this.f2549r != null) {
            m2281f("<<YHT7>> onNotifyStartShareScreenAsk!!");
            this.f2549r.onStartShareScreen(i, i2, str, this.f2537f.getCallOptionData().f2720u);
        }
        MainApplication.mChatONInterface.sendBroadcastShareViewInfo(1);
        m2281f("<<YHT223>> onNotifyStartShareScreenAsk!! #3");
        this.f2537f.chageAudioModeForScreenShare();
        m2276Q();
    }

    /* renamed from: c */
    public abstract boolean mo2350c(String str);

    /* renamed from: d */
    public CallState m2351d() {
        return this.f2540i;
    }

    /* renamed from: d */
    public void m2352d(int i) {
        m2281f("broadcastToCallBack()");
        MainApplication.mPhoneManager.getPhoneStateMachine().broadcastToCallStateCallBack(i);
    }

    /* renamed from: d */
    protected void m2353d(String str) {
        m2281f("setMappingRemoteInfoForPush");
        if (this.f2531M.setMappingPushData(this.f2542k, str)) {
            m2278S();
        }
    }

    /* renamed from: d */
    protected void m2354d(boolean z) throws IOException {
        EngineInterface.getInstance().setMicMute(z, !this.f2538g, this.f2541j);
    }

    /* renamed from: e */
    public int m2355e() {
        m2281f("getCallID " + this.f2541j);
        return this.f2541j;
    }

    /* renamed from: e */
    public int m2356e(int i) {
        m2281f("haeri= SetModeChangeDuringShareScreen()");
        EngineInterface.getInstance().setModeChangeDuringShareScreen(this.f2541j, !this.f2550s, i);
        return 0;
    }

    /* renamed from: e */
    public int mo2357e(boolean z) throws IOException {
        m2281f("setMuteCall() : " + this.f2540i.getStateDescription());
        if (this.f2538g && this.f2541j == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2540i.getCallState())) {
            m2280e("setMuteCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2537f.getCallOptionData().m2643b(z);
        if (z) {
            if (!this.f2540i.setCallState(5)) {
                m2280e("setMuteCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            EngineInterface.getInstance().setMicMute(z, this.f2538g ? false : true, this.f2541j);
            this.f2537f.setActivityStatus(EventCode.EVENT_CALL_MUTE, 0, 0, null);
            return 0;
        }
        if (!this.f2540i.setCallState(2)) {
            m2280e("setMuteCall State Setting Error!!! current state:" + this.f2540i.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        EngineInterface.getInstance().setMicMute(z, this.f2538g ? false : true, this.f2541j);
        this.f2537f.setActivityStatus(EventCode.EVENT_CALL_UNMUTE, 0, 0, null);
        return 0;
    }

    /* renamed from: f */
    public abstract int mo2358f(int i);

    /* renamed from: f */
    public Destination m2359f() {
        return this.f2542k;
    }

    /* renamed from: f */
    public void m2360f(boolean z) {
        if (this.f2549r != null) {
            m2281f("<<YHT7>> setNotiShareScreenCaptureError");
            if (z) {
                this.f2549r.onSecureModeEndForShareScreen();
            } else {
                this.f2549r.onSecureErrorForShareScreen();
            }
        }
    }

    /* renamed from: g */
    public abstract int mo2361g(boolean z);

    /* renamed from: g */
    public String m2362g() {
        return this.f2543l;
    }

    /* renamed from: g */
    public abstract void mo2363g(int i);

    /* renamed from: h */
    public String m2364h() {
        return this.f2544m;
    }

    /* renamed from: h */
    public abstract void mo2365h(int i);

    /* renamed from: i */
    public int m2366i() {
        m2281f("getHangupCode: " + this.f2527G);
        return this.f2527G;
    }

    /* renamed from: i */
    public void mo2367i(int i) {
    }

    /* renamed from: j */
    public int mo2368j(int i) {
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    /* renamed from: j */
    public boolean m2369j() {
        if (this.f2545n) {
            return this.f2528H;
        }
        return true;
    }

    /* renamed from: k */
    public boolean mo2370k() {
        return this.f2545n;
    }

    /* renamed from: l */
    public boolean m2371l() {
        return this.f2547p;
    }

    /* renamed from: m */
    public abstract int mo2372m();

    /* renamed from: n */
    public abstract int mo2373n();

    /* renamed from: o */
    public abstract int mo2374o();

    @Override // com.sds.coolots.call.model.CallState.CallStateCallback
    public void onCallStateChanged(int i) {
        m2281f("onCallStateChanged " + i);
        if (this.f2549r != null) {
            this.f2549r.onCallState(i);
        }
        if (this.f2537f.getSSOCallCallback() != null) {
            this.f2537f.getSSOCallCallback().onCallState(i);
        }
    }

    /* renamed from: p */
    public abstract int mo2375p();

    /* renamed from: q */
    public abstract int mo2376q();

    /* renamed from: r */
    public void m2377r() {
        this.f2548q = true;
        m2382w();
    }

    /* renamed from: s */
    public ShareScreenCallback m2378s() {
        return this.f2549r;
    }

    /* renamed from: t */
    public abstract boolean mo2379t();

    /* renamed from: u */
    public int m2380u() {
        return this.f2551t;
    }

    /* renamed from: v */
    public void m2381v() {
        this.f2555y = MainApplication.mScreenShareProcGenerator.createScreenShareProc();
        this.f2555y.start(2);
    }

    /* renamed from: w */
    protected void m2382w() {
        m2281f("<<YHT223>> onFinishShareScreen!!!");
        this.f2537f.returnAudioModeForShareScreen();
        if (!this.f2537f.isUseVideo() && this.f2537f.getCallOptionData().f2720u) {
            m2281f("<<YHT223>> Quick Live Share!!!!! Don't Skip");
        } else if (!this.f2532a.isShareScreenProcessing()) {
            return;
        }
        m2281f("<<YHT223>> onFinishShareScreen!!! #1");
        this.f2551t = 2;
        this.f2532a.setShareScreenProcessing(false);
        EngineInterface.getInstance().stopShareScreen(this.f2541j, !this.f2550s);
        if (this.f2555y != null) {
            this.f2555y.stop();
        }
        if (this.f2549r != null) {
            m2281f("<<YHT223>> mShareScreenCallback.onStopShareScreen");
            this.f2549r.onStopShareScreen(1);
            this.f2549r = null;
        }
        m2281f("<<YHT223>> onFinishShareScreen!!! #2");
        m2276Q();
        MainApplication.mScreenShareProcGenerator.resetShareScreenSurface();
        MainApplication.mPhoneManager.getPhoneStateMachine().showCallActivity(this.f2537f.isUseVideo(), this.f2537f.getCallOptionData().f2720u, this.f2537f.isSIPCall());
        MainApplication.mChatONInterface.sendBroadcastShareViewInfo(2);
        this.f2537f.setActivityStatus(EventCode.EVENT_SHARE_SCREEN_END, 0, 0, null);
        m2281f("<<YHT223>> onFinishShareScreen!!! #3");
    }

    /* renamed from: x */
    protected abstract void mo2383x();

    /* renamed from: y */
    public void m2384y() {
        m2281f("<<YHT223>> onNotifyStopShareScreenAsk!!");
        this.f2537f.returnAudioModeForShareScreen();
        if (!this.f2532a.isShareScreenProcessing()) {
            m2280e("<<YHT223>> onNotifyStopShareScreenAsk!! invalid state");
            return;
        }
        m2281f("<<YHT223>> onNotifyStopShareScreenAsk!! #1");
        this.f2532a.setShareScreenProcessing(false);
        if (this.f2555y != null) {
            this.f2555y.stop();
        }
        EngineInterface.getInstance().stopShareScreen(this.f2541j, !this.f2550s);
        if (this.f2549r != null) {
            m2281f("<<YHT223>> onNotifyStopShareScreenAsk!!");
            this.f2549r.onStopShareScreen(0);
            this.f2549r = null;
        }
        m2281f("<<YHT223>> onNotifyStopShareScreenAsk!! #2");
        this.f2551t = 2;
        m2276Q();
        MainApplication.mChatONInterface.sendBroadcastShareViewInfo(2);
        MainApplication.mScreenShareProcGenerator.resetShareScreenSurface();
        MainApplication.mPhoneManager.getPhoneStateMachine().showCallActivity(this.f2537f.isUseVideo(), false, this.f2537f.isSIPCall());
        this.f2537f.setActivityStatus(EventCode.EVENT_SHARE_SCREEN_END, 0, 0, null);
        m2281f("<<YHT223>> onNotifyStopShareScreenAsk!! #3");
    }

    /* renamed from: z */
    public int m2385z() {
        return this.f2556z;
    }
}
