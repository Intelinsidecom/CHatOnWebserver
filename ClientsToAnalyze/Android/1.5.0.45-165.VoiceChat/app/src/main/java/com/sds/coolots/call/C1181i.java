package com.sds.coolots.call;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.coolots.common.CoolotsCode;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.ConferenceInfo;
import com.coolots.p2pmsg.model.ConferenceMember;
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
import com.coolots.p2pmsg.model.RejectMessageAsk;
import com.coolots.p2pmsg.model.ReqAddConferenceMemberAsk;
import com.coolots.p2pmsg.model.ReqAddConferenceMemberRep;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.C1131a;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.entitlement.EntitlementController;
import com.sds.coolots.call.entitlement.IEntitlementController;
import com.sds.coolots.call.entitlement.IEntitlementResultListener;
import com.sds.coolots.call.model.C1193H;
import com.sds.coolots.call.model.C1205g;
import com.sds.coolots.call.model.C1210l;
import com.sds.coolots.call.model.C1217s;
import com.sds.coolots.call.model.C1224z;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.HandlerC1191F;
import com.sds.coolots.call.model.HighPriorityHandlerInterface;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.call.model.ShareScreenCallback;
import com.sds.coolots.call.nego.NegoFeatureControllerInterface;
import com.sds.coolots.call.p013a.C1139e;
import com.sds.coolots.call.p013a.C1140f;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.controller.EngineCallBackInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.controller.translation.C1247a;
import com.sds.coolots.common.controller.translation.C1248b;
import com.sds.coolots.common.controller.translation.C1249c;
import com.sds.coolots.common.controller.translation.TranslationListManagerInterface;
import com.sds.coolots.common.controller.translation.TranslationManagerInterface;
import com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface;
import com.sds.coolots.common.controller.translation.data.C1250a;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.controller.translation.engine.ITTSController;
import com.sds.coolots.common.controller.translation.engine.RecognitionEngine;
import com.sds.coolots.common.controller.translation.engine.TranslatorEngine;
import com.sds.coolots.common.coolotsinterface.ISSOCallCallBack;
import com.sds.coolots.common.coolotsinterface.MobilePhoneStateInterface;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.StrUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.sds.coolots.call.i */
/* loaded from: classes.dex */
public class C1181i implements BlockCallHandler, PhoneStateMachine, ShareScreenInterface, EngineCallBackInterface {

    /* renamed from: A */
    private static final String f2440A = "[SimplePhoneStateMachine]";

    /* renamed from: D */
    private static final int f2441D = 10;

    /* renamed from: E */
    private static final int f2442E = 11;

    /* renamed from: F */
    private static final int f2443F = 12;

    /* renamed from: H */
    private static final int f2444H = 20000;

    /* renamed from: R */
    private static final int f2445R = 10002;

    /* renamed from: S */
    private static final int f2446S = 60000;

    /* renamed from: V */
    private static final int f2447V = 10003;

    /* renamed from: W */
    private static final int f2448W = 10004;

    /* renamed from: X */
    private static final int f2449X = 10005;

    /* renamed from: Y */
    private static final int f2450Y = 10000;

    /* renamed from: a */
    public static final int f2451a = 90001;

    /* renamed from: b */
    public static final int f2452b = 90002;

    /* renamed from: c */
    protected static final long f2453c = 7000;

    /* renamed from: e */
    public static final int f2454e = 13;

    /* renamed from: f */
    public static final int f2455f = 14;

    /* renamed from: g */
    public static final int f2456g = 15;

    /* renamed from: h */
    public static final String f2457h = "dormant_switch_onoff";

    /* renamed from: i */
    public static final String f2458i = "dormant_disable_incoming_calls";

    /* renamed from: j */
    public static final String f2459j = "dormant_disable_notifications";

    /* renamed from: k */
    public static final String f2460k = "dormant_disable_alarm_and_timer";

    /* renamed from: l */
    public static final String f2461l = "dormant_disable_led_indicator";

    /* renamed from: m */
    public static final String f2462m = "dormant_always";

    /* renamed from: n */
    public static final String f2463n = "dormant_start_hour";

    /* renamed from: o */
    public static final String f2464o = "dormant_start_min";

    /* renamed from: p */
    public static final String f2465p = "dormant_end_hour";

    /* renamed from: q */
    public static final String f2466q = "dormant_end_min";

    /* renamed from: r */
    public static final String f2467r = "dormant_allow_list";

    /* renamed from: t */
    public static final int f2468t = 0;

    /* renamed from: u */
    public static final int f2469u = 1;

    /* renamed from: v */
    public static final int f2470v = 2;

    /* renamed from: N */
    private String f2479N;

    /* renamed from: Z */
    private boolean f2485Z;

    /* renamed from: aa */
    private Destination f2486aa;

    /* renamed from: B */
    private boolean f2471B = false;

    /* renamed from: C */
    private boolean f2472C = true;

    /* renamed from: d */
    protected boolean f2495d = false;

    /* renamed from: G */
    private final C1210l f2473G = new C1210l();

    /* renamed from: I */
    private final HandlerC1225n f2474I = new HandlerC1225n(this, null);

    /* renamed from: J */
    private HighPriorityHandlerInterface f2475J = new C1185m(this, null);

    /* renamed from: K */
    private final HandlerC1191F f2476K = new HandlerC1191F(this.f2475J);

    /* renamed from: L */
    private String f2477L = "";

    /* renamed from: M */
    private String f2478M = "";

    /* renamed from: O */
    private final Object f2480O = new Object();

    /* renamed from: P */
    private C1205g f2481P = null;

    /* renamed from: Q */
    private C1205g f2482Q = null;

    /* renamed from: s */
    public TelephonyManager f2496s = null;

    /* renamed from: T */
    private ArrayList f2483T = null;

    /* renamed from: U */
    private final MobilePhoneStateInterface f2484U = MainApplication.mNativeInterfaceCreator.createMobilePhoneState();

    /* renamed from: ab */
    private int f2487ab = 10000;

    /* renamed from: ac */
    private int f2488ac = 10000;

    /* renamed from: ad */
    private boolean f2489ad = false;

    /* renamed from: ae */
    private ActivityManager f2490ae = null;

    /* renamed from: w */
    public String f2497w = null;

    /* renamed from: x */
    public TranslationManagerInterface f2498x = null;

    /* renamed from: y */
    public TranslationNotificationManagerInterface f2499y = null;

    /* renamed from: z */
    public TranslationListManagerInterface f2500z = null;

    /* renamed from: af */
    private boolean f2491af = false;

    /* renamed from: ag */
    private IEntitlementController f2492ag = null;

    /* renamed from: ah */
    private C1184l f2493ah = null;

    /* renamed from: ai */
    private C1183k f2494ai = null;

    public C1181i() {
        EngineInterface.getInstance().setEngineCallback(this);
    }

    /* renamed from: a */
    private int m2233a(Destination destination) {
        if (this.f2481P == null) {
            m2246a("call instance is null");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (destination == null) {
            m2246a("destination is null");
            return 0;
        }
        if (this.f2481P.getCallInstanceID() == destination.getCallInstanceID()) {
            return 0;
        }
        m2246a("callValidityCheck : destination info is not match!! " + this.f2481P.getCallInstanceID() + " : " + destination.getCallInstanceID());
        this.f2481P.m2572b(true, 1001);
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2234a(Message message) {
        if (this.f2478M == null || this.f2478M.isEmpty()) {
            return;
        }
        switch (message.arg1) {
            case 0:
                if (message.arg2 != 7020) {
                    m2245a((C1224z) message.obj);
                    return;
                }
                return;
            case ErrorCode.ERR_NEED_TO_CRITICAL_UPDATE /* 10124 */:
                m2246a("ERR_NEED_TO_CRITICAL_UPDATE");
                break;
        }
        if (this.f2478M == null || this.f2478M.isEmpty()) {
            return;
        }
        denyConference(this.f2478M, 1001);
    }

    /* renamed from: a */
    private void m2235a(ReqAddConferenceMemberAsk reqAddConferenceMemberAsk) {
        ReqAddConferenceMemberRep reqAddConferenceMemberRep = new ReqAddConferenceMemberRep();
        reqAddConferenceMemberRep.setCallSessionID(reqAddConferenceMemberAsk.getCallSessionID());
        reqAddConferenceMemberRep.setConferenceMemberList(reqAddConferenceMemberAsk.getConferenceMemberList());
        reqAddConferenceMemberRep.setResult("0");
        EngineInterface.getInstance().sendPushMessageByP2P(reqAddConferenceMemberAsk.getCallSessionID(), C1149a.m2140a(MessageInfo.ReqAddConferenceMemberRep.getServiceCode(), MessageInfo.ReqAddConferenceMemberRep.getMessageCode()), reqAddConferenceMemberRep);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2242a(C1182j c1182j) {
        int iConnectCall = connectCall(new Destination(2, c1182j.f2502b), c1182j.f2501a, true, 10, false, "");
        if (iConnectCall != 0) {
            m2246a("connectCall Error!!!!! ErrCode:" + iConnectCall);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2243a(CallStatusData callStatusData, boolean z) {
        Log.m2963i("Multiple_Call CoolotsCallStateEventReceiver  handleMoveToTop");
        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
            Message message = new Message();
            message.what = EventCode.EVENT_CALL_MOVE_TO_TOP;
            message.obj = Boolean.valueOf(z);
            MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
            return;
        }
        Intent callIntent = MainApplication.mCallIntentGenerator.getCallIntent(callStatusData.isUseVideo(), callStatusData.isLiveShare(), callStatusData.getDestination().getDestinationType() == 3);
        if (callIntent != null) {
            callIntent.putExtra(EventCode.EVENT_IDENTIFIER, EventCode.EVENT_CALL_ACTION);
            callIntent.putExtra("SPEAKERMODE_BEFORE_3GCALL", z);
            callIntent.putExtra("IS_BEFORE_3GCALL", true);
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

    /* renamed from: a */
    private void m2244a(C1205g c1205g) {
        m2258e();
        Message message = new Message();
        message.what = 11;
        message.arg2 = 10002;
        message.obj = c1205g;
        this.f2474I.sendMessageDelayed(message, 60000L);
    }

    /* renamed from: a */
    private void m2245a(C1224z c1224z) {
        if (MainApplication.mPhoneManager.getVersion() == 1) {
            denyConference(c1224z.m2747a().getConferenceNo(), 1001);
            return;
        }
        if (MainApplication.mConfig.isUseWifiOnly() && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
            denyConference(c1224z.m2747a().getConferenceNo(), 1006);
            return;
        }
        Destination destination = new Destination(c1224z.m2747a().getConferenceNo(), c1224z.m2747a().getSimpleUserInfoList(), 0L);
        ConferenceInfo conferenceInfo = new ConferenceInfo();
        conferenceInfo.setVideoConference(c1224z.m2747a().getVideoConference());
        conferenceInfo.setConferenceNo(c1224z.m2747a().getConferenceNo());
        conferenceInfo.setConferenceType(c1224z.m2747a().getConferenceType());
        String userID = "";
        for (SimpleUserInfo simpleUserInfo : c1224z.m2747a().getSimpleUserInfoList()) {
            if (SimpleUserInfo.TYPE_HOST.equals(simpleUserInfo.getUserType())) {
                userID = simpleUserInfo.getUserID();
            }
        }
        MainApplication.mPhoneManager.getContactManager().isBlockUserForConf(userID, destination, conferenceInfo, c1224z.m2747a().getStartTime(), this.f2479N, this, c1224z.m2751b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2246a(String str) {
        Log.m2958e(f2440A + str);
    }

    /* renamed from: a */
    private boolean m2247a(IEntitlementResultListener iEntitlementResultListener) {
        if (iEntitlementResultListener == null) {
            m2246a("checkEntitlement uiListener is null");
            return false;
        }
        m2266l();
        this.f2492ag = new EntitlementController();
        this.f2493ah = new C1184l(this, iEntitlementResultListener);
        this.f2494ai = new C1183k(this, null);
        return true;
    }

    /* renamed from: a */
    private boolean m2248a(boolean z, boolean z2, boolean z3) throws SecurityException {
        try {
            if (this.f2490ae == null) {
                this.f2490ae = (ActivityManager) MainApplication.mContext.getSystemService("activity");
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = this.f2490ae.getRunningTasks(1);
            if (runningTasks != null) {
                ComponentName componentName = runningTasks.get(0).topActivity;
                String callClassName = MainApplication.mCallIntentGenerator.getCallClassName(z, z2, z3);
                m2252b("checkForegroundActivity callClassname:  " + callClassName + ", class name:" + componentName.getClassName());
                if (componentName.getClassName().equals(callClassName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            m2246a("checkForegroundActivity exception :" + e);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2251b(C1205g c1205g) {
        if (this.f2481P != null && this.f2481P.m2582c().equals(c1205g.m2582c())) {
            m2252b("handleIncomingCallWaitingTimerEvent");
            if (this.f2481P.m2589d()) {
                localHangupCall(this.f2481P.m2582c(), 1003);
            } else {
                connectCall(this.f2481P.m2582c(), this.f2481P.m2487T(), false, 1003, false, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2252b(String str) {
        Log.m2963i(f2440A + str);
    }

    /* renamed from: b */
    private synchronized void m2253b(boolean z) {
        m2246a("clearCallInstance is called");
        if (this.f2481P != null) {
            if (MainApplication.mPhoneManager.getDataUsageManager() != null && z) {
                MainApplication.mPhoneManager.getDataUsageManager().notifyEndCall(this.f2481P.m2589d(), this.f2481P.isUseVideo(), this.f2481P.m2560at());
            }
            this.f2481P.m2564ax();
            synchronized (this.f2480O) {
                this.f2482Q = this.f2481P;
                this.f2482Q.m2541aa();
                if (CallState.isDisconnected(this.f2481P.m2573b().getCallState())) {
                    this.f2481P.m2478K();
                    this.f2481P.unregistVoipCallState();
                    MainApplication.mConfig.setCallState(false);
                    if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
                        MainApplication.mPhoneManager.getCoolotsEventListener().onCallState(false);
                    }
                } else {
                    this.f2481P.m2573b().setCallState(3);
                }
                this.f2476K.sendEmptyMessage(HandlerC1191F.f2618c);
            }
            if (this.f2481P.getAudioPathController() != null) {
                this.f2481P.getAudioPathController().dispose();
            }
        }
    }

    /* renamed from: b */
    private boolean m2254b(Destination destination) {
        if (this.f2481P == null) {
            return false;
        }
        return destination == null || this.f2481P.getCallInstanceID() == destination.getCallInstanceID();
    }

    /* renamed from: e */
    private void m2258e() {
        this.f2474I.removeMessages(11);
    }

    /* renamed from: f */
    private boolean m2260f() {
        m2252b("haeri=forceTurnOnScreenForCallEnd");
        return (this.f2481P == null || this.f2481P.getCallingActivity() == null || this.f2481P.m2573b().getCallState() == 1) ? false : true;
    }

    /* renamed from: g */
    private void m2261g() {
        m2246a("forceLocalHangup!!");
        if (this.f2481P == null) {
            return;
        }
        if (this.f2481P.m2487T() < 0) {
            m2253b(true);
        } else if (this.f2481P.m2559as()) {
            EngineInterface.getInstance().hangUpCall(this.f2481P.m2487T(), 1001, "");
        } else {
            EngineInterface.getInstance().hangUpSIPCall(this.f2481P.m2487T());
        }
    }

    /* renamed from: h */
    private boolean m2262h() {
        return MainApplication.mNativeInterfaceCreator.createNativeCallInterface().isCurrentCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m2263i() {
        m2246a("<<TEST>> handleTestFinishPlaceCall");
        MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(this.f2486aa, 10);
        Message message = new Message();
        message.what = 10;
        message.arg2 = 10003;
        this.f2474I.sendMessageDelayed(message, this.f2488ac);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m2264j() {
        startOutGoingCall(this.f2486aa, this.f2485Z, false, "");
        Message message = new Message();
        message.what = 10;
        message.arg2 = 10004;
        this.f2474I.sendMessageDelayed(message, this.f2487ab);
    }

    /* renamed from: k */
    private void m2265k() {
        Message message = new Message();
        message.what = 20000;
        message.arg1 = 0;
        message.obj = null;
        this.f2474I.sendMessageDelayed(message, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m2266l() {
        m2252b("disposeEntitlement()");
        if (this.f2492ag != null) {
            this.f2492ag.dispose();
            this.f2492ag = null;
        }
        if (this.f2493ah != null) {
            this.f2493ah.m2274a();
            this.f2493ah = null;
        }
        if (this.f2494ai != null) {
            this.f2494ai.m2273a();
            this.f2494ai = null;
        }
    }

    /* renamed from: m */
    private boolean m2267m() {
        m2252b("isDormantOn()");
        try {
            Context context = MainApplication.mContext;
            int i = Settings.System.getInt(context.getContentResolver(), f2457h, 0);
            int i2 = Settings.System.getInt(context.getContentResolver(), f2458i, 0);
            if (i == 0 || i2 == 0) {
                m2252b("dormant disable ");
                return false;
            }
            if (Settings.System.getInt(context.getContentResolver(), f2462m, 0) == 0) {
                Calendar calendar = Calendar.getInstance();
                int i3 = calendar.get(12) + (calendar.get(11) * 60);
                int i4 = (Settings.System.getInt(context.getContentResolver(), f2463n, 0) * 60) + Settings.System.getInt(context.getContentResolver(), f2464o, 0);
                int i5 = Settings.System.getInt(context.getContentResolver(), f2466q, 0) + (Settings.System.getInt(context.getContentResolver(), f2465p, 0) * 60);
                m2252b("curTime " + i3);
                m2252b("startTime " + i4);
                m2252b("endTime " + i5);
                if (i4 == i5) {
                    m2252b("Dormant Time set as Always");
                } else if (i4 < i5) {
                    if (i3 < i4 || i3 >= i5) {
                        return false;
                    }
                } else if (i3 >= i5 && i3 < i4) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public int m2268a() {
        if (this.f2496s == null) {
            this.f2496s = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
        }
        return this.f2496s.getCallState();
    }

    /* renamed from: a */
    public void m2269a(boolean z) {
        m2252b("setIsActiveSTTTranslationTTS " + this.f2491af + " >> " + z);
        this.f2491af = z;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int acceptConsent(Destination destination, boolean z) {
        return !m2254b(destination) ? PhoneStateMachine.ERROR_CANT_FIND_DESTINATION : !CallState.isConnected(this.f2481P.m2573b().getCallState()) ? PhoneStateMachine.ERROR_INVALID_STATE : this.f2481P.m2609j(z);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void addCallBack(CallStateCallBack callStateCallBack) {
        m2252b("addCallBack()");
        if (callStateCallBack != null) {
            if (this.f2483T == null) {
                this.f2483T = new ArrayList();
            }
            if (this.f2483T.contains(callStateCallBack)) {
                return;
            }
            this.f2483T.add(callStateCallBack);
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void addCallTypeChangeCallback(CallTypeChangeCallback callTypeChangeCallback) {
        this.f2473G.m2646a(callTypeChangeCallback);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int addConferenceMember(Destination destination, ArrayList arrayList, ArrayList arrayList2) {
        if (m2233a(destination) != 0) {
            return PhoneStateMachine.ERROR_CANT_FIND_CALL_INSTANCE;
        }
        if (!CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (this.f2481P.getCallOptionData().f2718s || this.f2481P.m2573b().getCallState() == 4) {
            return PhoneStateMachine.ERROR_INVITE_BUDDY_HOLD;
        }
        if (this.f2481P.m2589d()) {
            return (arrayList2 == null || arrayList2.isEmpty()) ? this.f2481P.m2509a(arrayList, arrayList2) : PhoneStateMachine.ERROR_INVITE_BUDDY_HOLD;
        }
        return this.f2481P.m2510a((List) arrayList);
    }

    /* renamed from: b */
    public void m2270b() {
        MainApplication.mNativeInterfaceCreator.createNativeCallInterface().hangUpCurrent3gCall();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void backupCallStateBeforNative(boolean z, boolean z2, boolean z3) {
        if (this.f2481P == null) {
            return;
        }
        this.f2481P.m2537a(z, z2, z3);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void broadcastToCallStateCallBack(int i) {
        m2252b("broadcastToCallBack()" + i);
        if (this.f2483T != null) {
            Iterator it = this.f2483T.iterator();
            while (it.hasNext()) {
                CallStateCallBack callStateCallBack = (CallStateCallBack) it.next();
                if (callStateCallBack != null) {
                    Message message = new Message();
                    message.what = i;
                    callStateCallBack.onCallUpdate(message);
                }
            }
        }
    }

    /* renamed from: c */
    public boolean m2271c() {
        return m2268a() == 0;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int captureImage(Destination destination, String str) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2507a(str)) != 0) {
            m2246a("captureImage Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int captureMyImage(Destination destination, String str) {
        m2252b("captureMyImage()---------file name?" + str);
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2580c(str)) != 0) {
            m2246a("captureMyImage Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public int captureShareScreenImage(Destination destination, String str) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2570b(str)) != 0) {
            m2246a("captureShareScreenImage Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public int captureShareScreenOtherIamge(Destination destination, String str) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2507a(str)) != 0) {
            m2246a("captureImage Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int changeAvatarGlasses(Destination destination) {
        int iM2233a = m2233a(destination);
        return iM2233a != 0 ? iM2233a : this.f2481P.m2493Z();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int changeAvatarHair(Destination destination) {
        int iM2233a = m2233a(destination);
        return iM2233a != 0 ? iM2233a : this.f2481P.m2492Y();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void changeConferenceLayout(Destination destination, int i) {
        if (m2233a(destination) != 0) {
            return;
        }
        this.f2481P.m2624p(i);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean checkCellPhoneNumber(String str) {
        return (this.f2477L == null || this.f2477L.length() == 0 || !this.f2477L.equals(str)) ? false : true;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void checkEntitlement(IEntitlementResultListener iEntitlementResultListener) {
        m2252b("checkEntitlement()");
        if (m2247a(iEntitlementResultListener)) {
            int iCheckEntitlementDirect = this.f2492ag.checkEntitlementDirect();
            m2252b("resultType: " + iCheckEntitlementDirect);
            switch (iCheckEntitlementDirect) {
                case 0:
                    m2266l();
                    iEntitlementResultListener.onReceiveEntitlementResult(1);
                    return;
                case 1:
                    this.f2492ag.startTimer(this.f2494ai);
                    iEntitlementResultListener.onReceiveEntitlementResult(1);
                    return;
                case 2:
                    m2266l();
                    iEntitlementResultListener.onReceiveEntitlementResult(2);
                    return;
                case 3:
                    m2266l();
                    iEntitlementResultListener.onReceiveEntitlementResult(5);
                    return;
                case 4:
                    iEntitlementResultListener.onReceiveEntitlementResult(4);
                    break;
            }
            this.f2492ag.checkEntitlement(this.f2493ah);
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void closeSTTTranslationTTS(boolean z) {
        if (this.f2481P == null) {
            return;
        }
        if ((CallState.isConnected(this.f2481P.m2573b().getCallState()) || CallState.isDisconnected(this.f2481P.m2573b().getCallState())) && this.f2481P.m2582c().getDestinationType() == 2) {
            m2252b("closeSTTTranslationTTS(" + z + ")");
            m2269a(false);
            if (this.f2498x != null) {
                this.f2498x.stopRecognition();
                this.f2498x.stopTranslation();
                this.f2498x.dispose();
                this.f2498x = null;
            }
            if (this.f2499y != null) {
                if (z) {
                    this.f2499y.sendToOtherpartyRecognitionStop();
                }
                this.f2499y.dispose();
                this.f2499y = null;
            }
            if (this.f2500z != null) {
                this.f2500z.dispose();
                this.f2500z = null;
            }
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int connectCall(Destination destination, int i, boolean z, int i2, boolean z2, String str) {
        if (destination == null) {
            m2252b("connectCall() : Callee received call!! callID : " + i + " receiveCall : " + z + " hangupReason: " + i2);
        } else {
            m2252b("connectCall() : Caller(Me) Receives Call!!  callID : " + i + " receiveCall : " + z + " hangupReason: " + i2);
        }
        int iM2233a = m2233a(destination);
        if (iM2233a != 0) {
            m2246a("connectCall : Call ID is not valid!!");
            return iM2233a;
        }
        if (!this.f2481P.m2611j(i)) {
            m2246a("connectCall : Call ID is not match!!");
            this.f2481P.m2572b(true, 1001);
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (CallState.isDisconnected(this.f2481P.m2573b().getCallState())) {
            return 0;
        }
        if (z) {
            if (!this.f2481P.m2589d() || !this.f2481P.m2560at()) {
                MainApplication.mPhoneManager.getHardwareManager().setModeConnected(this.f2481P.isUseVideo());
            }
            MainApplication.mPhoneManager.getKeyGuardManager().updateKeyguardLock(true);
        }
        int iM2233a2 = m2233a(destination);
        if (iM2233a2 != 0) {
            m2246a("connectCall : Call ID is not valid!!");
            return iM2233a2;
        }
        int iM2512a = this.f2481P.m2512a(z, i2, z2, "");
        if (!z) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
            MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
        }
        m2258e();
        if (iM2512a != 0) {
            m2246a("connectCall Handling Error!!! Error Code:" + iM2512a);
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
            m2261g();
            MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
            return iM2512a;
        }
        m2252b("connectCall Handling Success!!!");
        if (!z) {
            return iM2512a;
        }
        m2246a("HANGUP CURRENT 3GCALL");
        m2272d();
        return iM2512a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int createCustomAvatar(Destination destination) {
        int iM2233a = m2233a(destination);
        return iM2233a != 0 ? iM2233a : this.f2481P.m2491X();
    }

    /* renamed from: d */
    public void m2272d() {
        MainApplication.mNativeInterfaceCreator.createNativeCallInterface().hangUpIncomingCall();
    }

    @Override // com.sds.coolots.call.BlockCallHandler
    public void denyConference(String str, int i) {
        new C1140f(str, i, "", this.f2474I).start();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void finishShareView(Destination destination, int i) throws IOException {
        if (m2254b(destination) && CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            if (destination.getDestinationType() == 2 || destination.getDestinationType() == 5) {
                sendShareViewNotifyEnd(i);
            } else {
                this.f2481P.m2620n(i);
            }
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public Date getCallConnectedTime() {
        if (this.f2481P == null) {
            return null;
        }
        return this.f2481P.getCallConnectedTime();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public Date getCallFirstStartTime() {
        if (this.f2481P == null) {
            return null;
        }
        return this.f2481P.m2593e();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int getCallType() {
        if (this.f2481P == null) {
            return 0;
        }
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            return this.f2481P.getInitiateCallType() != 2 ? 1 : 2;
        }
        m2252b("getCallType() isVideo = " + this.f2481P.isUseVideo());
        return !this.f2481P.isUseVideo() ? 1 : 2;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public CallingInterface getCallingActivity() {
        if (this.f2481P == null) {
            return null;
        }
        return this.f2481P.getCallingActivity();
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public Destination getCurrentCallDestination() {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            return null;
        }
        return this.f2481P.m2582c();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int getCurrentCoolotsPhoneState() {
        return this.f2484U.getCoolotsState();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int getCurrentMobileCallType() {
        return this.f2484U.getTelephonyCallType();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int getCurrentMobilePhoneState() {
        return this.f2484U.getTelephonyState();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int getDualCameraONCnt() {
        return this.f2481P.m2469B();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public Date getDualCameraStartedTime() {
        if (this.f2481P == null) {
            return null;
        }
        return this.f2481P.m2474G();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int getHangupCode() {
        if (this.f2481P != null) {
            return this.f2481P.m2475H();
        }
        return 0;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean getHideState() {
        if (this.f2481P == null) {
            return false;
        }
        return this.f2481P.m2629t();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public NegoFeatureControllerInterface getNegoFeatureController() {
        return this.f2481P.m2557aq();
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public String getOtherPartyName(Destination destination) {
        return m2233a(destination) == 0 ? this.f2481P.m2600g() : "";
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public Set getRecognitionSupportedVoiceLanguage() {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState()) || this.f2481P.m2582c().getDestinationType() != 2) {
            return null;
        }
        m2252b("getRecognitionSupportedVoiceLanguage()");
        if (this.f2498x != null) {
            return this.f2498x.getSupportedVoiceLanguage();
        }
        return null;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public ArrayList getRemoteInfoData(Destination destination) {
        if (m2233a(destination) != 0) {
            return null;
        }
        return this.f2481P.m2563aw();
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public String getRequesterID() {
        return this.f2497w;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public C1250a getTranslationList() {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState()) || this.f2481P.m2582c().getDestinationType() != 2) {
            return null;
        }
        m2252b("getTranslationList()");
        if (this.f2500z != null) {
            return this.f2500z.getList();
        }
        return null;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public TranslationListManagerInterface getTranslationListManager() {
        return this.f2500z;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public TranslationManagerInterface getTranslationManager() {
        return this.f2498x;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public TranslationNotificationManagerInterface getTranslationNotificationManager() {
        return this.f2499y;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public Set getTranslationSupportedOutLanguage(int i) {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState()) || this.f2481P.m2582c().getDestinationType() != 2) {
            return null;
        }
        m2252b("getTranslationSupportedOutLanguage()");
        if (this.f2498x != null) {
            return this.f2498x.getSupportedTranslationLanguage(i);
        }
        return null;
    }

    @Override // com.sds.coolots.call.BlockCallHandler
    public void handleBlockedCall(Destination destination, int i, boolean z, boolean z2, boolean z3, String str, Date date) {
        if (!z2) {
            m2246a("handleBlockedCall!! ERROR!! SIP CALL CAN'T BLOCK!!");
            return;
        }
        m2252b("blocked calldate:" + StrUtil.convertDateToyyyyMMddHHmmss(date));
        C1193H.m2409a(destination, str, z, z3, new Date(), 4);
        EngineInterface.getInstance().hangUpCall(i, 301, "");
    }

    @Override // com.sds.coolots.call.BlockCallHandler
    public void handleBlockedConference(Destination destination, ConferenceInfo conferenceInfo, Date date) {
        C1217s.m2690a(destination, "A".equals(conferenceInfo.getConferenceType()) ? false : true, new Date(), 4);
        denyConference(conferenceInfo.getConferenceNo(), 301);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void hangUpCurrentCoolotsCall(int i) {
        if (this.f2481P != null) {
            localHangupCall(this.f2481P.m2582c(), i);
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int holdCall(Destination destination) {
        if (destination == null) {
            m2246a("holdCall : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        if (iM2233a != 0) {
            return iM2233a;
        }
        int iM2607i = this.f2481P.m2607i(true);
        if (iM2607i == 0) {
            stopRecognition();
            m2246a("holdCall Handling Success!!! Success Code:" + iM2607i);
            return iM2607i;
        }
        m2246a("holdCall Handling Error!!! Error Code:" + iM2607i);
        m2261g();
        return iM2607i;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int initSTTTranslationTTS(RecognitionEngine recognitionEngine, TranslatorEngine translatorEngine, ITTSController iTTSController, Handler handler, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState()) || this.f2481P.m2582c().getDestinationType() != 2) {
            return 1;
        }
        m2252b("initSTTTranslationTTS");
        int iInit = 0;
        if (this.f2498x == null) {
            this.f2498x = new C1248b();
            iInit = this.f2498x.init(recognitionEngine, translatorEngine, iTTSController);
            if (iInit != 0) {
                this.f2498x = null;
                return iInit;
            }
        }
        int i8 = iInit;
        if (this.f2499y == null) {
            this.f2499y = new C1249c();
            this.f2499y.init(handler, i, i2, i3, i4, i5, i6, i7, this.f2481P.m2487T());
        }
        if (this.f2500z == null) {
            this.f2500z = new C1247a();
        }
        return i8;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int initSTTTranslationTTSLanguage(int i, int i2) {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState()) || this.f2481P.m2582c().getDestinationType() != 2) {
            return 1;
        }
        m2252b("initSTTTranslationTTSLanguage(" + i + ", " + i2 + ")");
        if (this.f2498x == null) {
            return 1;
        }
        m2269a(true);
        return this.f2498x.setLanguage(i, i2);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isActiveSTTTranslationTTS() {
        m2252b("isActiveSTTTranslationTTS " + this.f2491af);
        return this.f2491af;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int isActiveShareScreen() {
        if (this.f2481P == null) {
            return 2;
        }
        return this.f2481P.m2542ab();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isCallReceiveFromWatch() {
        return this.f2481P.m2540aB();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isClearCoverOpen() {
        m2252b("isClearCoverOpen()?" + this.f2472C);
        return this.f2472C;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isCurrentCallOccupied() {
        return (this.f2481P == null || CallState.isDisconnected(this.f2481P.m2573b().getCallState())) ? false : true;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isCurrentMobileCall() {
        return getCurrentMobilePhoneState() != 0;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isEarPhone() {
        Log.m2954d("isEarPhone()");
        return this.f2471B;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isEntitlementWifiOnlyMode() {
        EntitlementController entitlementController = new EntitlementController();
        boolean zIsWifiOnlyMode = entitlementController.isWifiOnlyMode();
        entitlementController.dispose();
        m2252b("isEntitlementWifiOnlyMode() resultType: " + zIsWifiOnlyMode);
        return zIsWifiOnlyMode;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isHidemeBeforeNative() {
        if (this.f2481P == null) {
            return false;
        }
        return this.f2481P.m2614k();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isHoldBeforeNative() {
        if (this.f2481P == null) {
            return false;
        }
        return this.f2481P.m2610j();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isLiveShareCall() {
        if (this.f2481P == null || CallState.isDisconnected(this.f2481P.m2573b().getCallState())) {
            return false;
        }
        return this.f2481P.m2471D();
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public boolean isMuteCall(int i) {
        if (this.f2481P == null) {
            m2246a("isMuteCall() : mCall is NULL");
            return false;
        }
        if (!this.f2481P.m2611j(i)) {
            m2246a("isMuteCall() : ERROR_CANT_FIND_DESTINATION");
            m2261g();
            return false;
        }
        if (CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            return this.f2481P.m2470C();
        }
        m2246a("isMuteCall : mCall.getCallState() : it not disconnected.");
        return false;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isOutGoingCall() {
        if (this.f2481P == null || CallState.isDisconnected(this.f2481P.m2573b().getCallState())) {
            return false;
        }
        return this.f2481P.m2589d();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isPlayHoldTone() {
        Log.m2954d("isPlayHoldTone()");
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            return false;
        }
        return this.f2481P.m2617l();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isRecording() {
        Log.m2954d("isRecording()");
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            return false;
        }
        return this.f2481P.m2556ap().isRecordingProcessing();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isThemeShotActive(int i, int i2) {
        return this.f2481P.m2538a(i, i2);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean isUseSpeakerBeforeNative() {
        if (this.f2481P == null) {
            return false;
        }
        return this.f2481P.m2608i();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int localHangupCall(Destination destination, int i) {
        m2252b("localHangupCall() : destination : " + destination.getPhoneNo() + ", hangupReason: " + i);
        int iM2233a = m2233a(destination);
        if (iM2233a != 0) {
            m2246a("localHangupCall : Call ID is not valid!!");
            return iM2233a;
        }
        if (CallState.isDisconnected(this.f2481P.m2573b().getCallState())) {
            m2246a("localHangupCall : Call is already disconnected");
            return PhoneStateMachine.ERROR_INVALID_CALL_SATATE_FOR_END_CALL;
        }
        EngineInterface.getInstance().noticeVoipDisconnecting();
        m2266l();
        if (i == 10) {
            this.f2481P.m2613k(false);
        }
        int iM2572b = this.f2481P.m2572b(true, i);
        m2258e();
        if (iM2572b == 0) {
            m2252b("localHangupCall Handling Success!!!");
            return iM2572b;
        }
        m2246a("localHangupCall Handling Error!!! Error Code:" + iM2572b);
        switch (iM2572b) {
            case PhoneStateMachine.ERROR_INVALID_CALLID /* -1014 */:
            case EngineInterface.SMPUI_ERROR_INVALIDCALLID /* -30 */:
                m2253b(true);
                return iM2572b;
            case PhoneStateMachine.ERROR_INVALID_STATE /* -1013 */:
                m2261g();
                return iM2572b;
            default:
                m2261g();
                return iM2572b;
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void logout() {
        m2253b(true);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void moveToTopForDelayAfter3G(CallStatusData callStatusData, boolean z) {
        if (isActiveShareScreen() == 1 || isActiveShareScreen() == 3) {
            m2252b("not moveToTopForDelayAfter3G => not display call activity");
            MainApplication.mCallNotification.showCallButtonNotification();
            return;
        }
        Message message = new Message();
        message.what = 13;
        message.obj = callStatusData;
        message.arg1 = z ? 1 : 0;
        this.f2474I.sendMessageDelayed(message, 1000L);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int muteCall(Destination destination) {
        if (destination == null) {
            m2246a("muteCall() : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        if (iM2233a != 0) {
            return iM2233a;
        }
        int iM2587d = this.f2481P.m2587d(true);
        if (iM2587d == 0) {
            m2246a("muteCall Handling Success!!! Success Code:" + iM2587d);
            return iM2587d;
        }
        m2246a("muteCall Handling Error!!! Error Code:" + iM2587d);
        m2261g();
        return iM2587d;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void notiToUserDisconnect() {
        if (this.f2481P == null) {
            return;
        }
        Message message = new Message();
        message.what = 10006;
        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
            MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
        } else if (this.f2481P.getCallingActivity() != null) {
            this.f2481P.getCallingActivity().sendHandlerMessage(message, 0L);
        }
        this.f2481P.m2516a(10006);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void notifyChangeCallType(boolean z) {
        this.f2481P.m2616l(z);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void notifyStopRingtone() {
        this.f2481P.m2539aA();
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onCallNotifyNetworkWeakReceive(int i) {
        Log.m2954d("onNotifyNetworkWeakReceive()");
        if (this.f2481P == null) {
            return;
        }
        this.f2481P.m2604h(i);
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onCameraError(int i) {
        if (this.f2481P == null) {
            m2246a("onCameraError() : ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (this.f2481P.m2611j(i)) {
            this.f2481P.m2484Q();
            return 0;
        }
        m2246a("onCameraError : invalid call id");
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onCameraStartErrorReceived() {
        m2252b("onCameraStartErrorReceived()");
        if (this.f2481P == null) {
            m2246a("onCameraStartErrorReceived() : ERROR_CANT_FIND_DESTINATION");
        } else {
            this.f2481P.m2565ay();
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onConferenceCloseAsk(String str) {
        m2252b("onConferenceCloseAsk: " + str);
        if (this.f2481P == null) {
            if (this.f2478M != null && str.equals(str)) {
                this.f2478M = null;
                this.f2479N = null;
            }
            m2252b("onConferenceCloseAsk error: ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (!this.f2481P.m2556ap().isPrepareChageToConf()) {
            if (!this.f2481P.m2560at()) {
                m2252b("onConferenceCloseAsk error: ERROR_INVALID_STATE");
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            if (!this.f2481P.m2582c().getPhoneNo().equals(str)) {
                m2252b("onConferenceCloseAsk error: ERROR_CANT_FIND_DESTINATION");
                return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
            }
        }
        MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
        this.f2481P.m2568b(10, "");
        MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
        m2258e();
        m2253b(true);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onConferenceDenyEvent(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        Log.m2958e("SSE onConferenceDeny conferenceNo : " + str);
        if (this.f2481P != null) {
            return;
        }
        denyConference(str, 10);
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onConferenceEnterAsk(String str, String str2) {
        this.f2478M = str;
        this.f2479N = str2;
        new C1139e(str, true, this.f2474I, true).start();
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onConferenceStatusAsk(String str) {
        m2252b("onConferenceStatusAsk");
        if (this.f2481P == null) {
            m2252b("onConferenceStatusAsk error: ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (!this.f2481P.m2594e(str)) {
            m2252b("onConferenceStatusAsk error: ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2550aj = this.f2481P.m2550aj();
        if (iM2550aj != 0) {
            m2246a("onConferenceStatusAsk Handling Error!!! Error Code:" + iM2550aj);
        }
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onEngineDebugMsg(String str) {
        if (this.f2481P == null) {
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2586d = this.f2481P.m2586d(str);
        if (iM2586d != 0) {
            m2246a("notifyDebugMsg Handling Error!!! Error Code:" + iM2586d);
        }
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onError(int i, int i2) throws IOException {
        m2252b("onError : callID : " + i + " errorType : " + i2);
        startPreventUMTSAlarm();
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
        if (i == -10000) {
            m2258e();
            if (this.f2481P == null) {
                EngineInterface.getInstance().clearAllPeerChannel();
                return PhoneStateMachine.ERROR_INVALID_CALLID;
            }
            if (CallState.isDisconnected(this.f2481P.m2573b().getCallState())) {
                MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
                MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
                m2246a("onHangUpCall : mCall.getCallState() : already disconnected.");
                m2253b(true);
                EngineInterface.getInstance().clearAllPeerChannel();
                return PhoneStateMachine.ERROR_INVALID_STATE;
            }
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
            boolean zM2260f = m2260f();
            this.f2481P.m2568b(1001, "");
            MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(zM2260f);
            m2253b(true);
            EngineInterface.getInstance().clearAllPeerChannel();
            return 0;
        }
        switch (i2) {
            case 0:
                if (this.f2481P == null) {
                    m2246a("mCall is null!!");
                    return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
                }
                if (!this.f2481P.m2611j(i)) {
                    m2246a("CallID misMatch!!");
                    return PhoneStateMachine.ERROR_INVALID_CALLID;
                }
                m2246a("callID Match!!");
                m2258e();
                boolean zIsConnected = CallState.isConnected(this.f2481P.m2573b().getCallState());
                if (CallState.isDisconnected(this.f2481P.m2573b().getCallState())) {
                    MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
                    MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
                    m2246a("onHangUpCall : mCall.getCallState() : already disconnected.");
                    m2253b(true);
                    return PhoneStateMachine.ERROR_INVALID_STATE;
                }
                MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
                boolean zM2260f2 = m2260f();
                if (zIsConnected) {
                    this.f2481P.m2568b(1005, "");
                } else {
                    this.f2481P.m2568b(1001, "");
                }
                MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(zM2260f2);
                m2253b(true);
                if (zIsConnected) {
                    return PhoneStateMachine.ERROR_UNKNOWN;
                }
                return 0;
            case 1:
                if (this.f2481P != null) {
                    try {
                        if (!this.f2481P.m2611j(i) && !this.f2481P.m2562av()) {
                            return PhoneStateMachine.ERROR_INVALID_CALLID;
                        }
                        m2258e();
                        if (!CallState.isDisconnected(this.f2481P.m2573b().getCallState())) {
                            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
                            boolean zM2260f3 = m2260f();
                            this.f2481P.m2568b(1005, "");
                            MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(zM2260f3);
                            m2253b(true);
                            break;
                        } else {
                            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
                            MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
                            m2246a("onHangUpCall : mCall.getCallState() : already disconnected.");
                            m2253b(true);
                            return PhoneStateMachine.ERROR_INVALID_STATE;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
                        MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
                        m2253b(true);
                        break;
                    }
                } else {
                    return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
                }
                break;
            case 4:
                try {
                    if (this.f2481P != null && this.f2481P.m2556ap().isRecordingProcessing()) {
                        Message message = new Message();
                        message.what = 10002;
                        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
                            MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
                        } else {
                            if (this.f2481P.getCallingActivity() == null) {
                                return PhoneStateMachine.ERROR_UNKNOWN;
                            }
                            this.f2481P.getCallingActivity().sendHandlerMessage(message, 0L);
                        }
                    }
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    break;
                }
                break;
            case 5:
                try {
                    if (this.f2481P != null && this.f2481P.m2556ap().isRecordingProcessing()) {
                        Message message2 = new Message();
                        message2.what = 10003;
                        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
                            MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message2);
                        } else {
                            if (this.f2481P.getCallingActivity() == null) {
                                return PhoneStateMachine.ERROR_UNKNOWN;
                            }
                            this.f2481P.getCallingActivity().sendHandlerMessage(message2, 0L);
                        }
                    }
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    break;
                }
                break;
            case 6:
                try {
                    if (this.f2481P != null && this.f2481P.m2556ap().isRecordingProcessing()) {
                        Message message3 = new Message();
                        message3.what = 10004;
                        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
                            MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message3);
                        } else {
                            if (this.f2481P.getCallingActivity() == null) {
                                return PhoneStateMachine.ERROR_UNKNOWN;
                            }
                            this.f2481P.getCallingActivity().sendHandlerMessage(message3, 0L);
                        }
                    }
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    break;
                }
                break;
        }
        return PhoneStateMachine.ERROR_UNKNOWN;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onError(String str) {
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
        m2246a("onError!!!! MSG:" + str);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onHangUpCall(int i, int i2, String str) {
        m2246a("onHangUpCall : callID : " + i + " hangupReason: " + i2);
        startPreventUMTSAlarm();
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
        if (this.f2481P == null) {
            m2246a("onHangUpCall : ERROR_mcall_IS_NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2475H = i2 == -1 ? this.f2481P.m2475H() : i2;
        if (!this.f2481P.m2611j(i) && !this.f2481P.m2561au()) {
            m2246a("onHangUpCall : ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (i2 == 301) {
            m2246a("onHangUpCall : call is blocked!!");
            return 0;
        }
        MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
        boolean zM2260f = m2260f();
        int iM2568b = this.f2481P.m2568b(iM2475H, str);
        MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(zM2260f);
        m2258e();
        if (iM2568b == 0) {
            m2246a("onHangUpCall Handling Success!!! Success Code:" + iM2568b);
        } else {
            m2246a("onHangUpCall Handling Error!!! Error Code:" + iM2568b);
        }
        m2253b(true);
        if (!MainApplication.mConfig.isCPUBoost()) {
            return iM2568b;
        }
        MainApplication.mPhoneManager.releaseDVFSHelper();
        return iM2568b;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onIncomingCall(int i, String str, short s, boolean z, boolean z2, boolean z3, boolean z4, String str2, Date date) {
        Destination destination;
        m2246a("isLiveShare : " + z4);
        m2246a("[[[[LHH]]]] incoming CameraState.getInstance().getCameraState() : " + C1131a.m2099a().m2101b());
        if (C1131a.m2099a().m2101b() != 0 && C1131a.m2099a().m2101b() != 7) {
            m2246a("[[[[LHH]]]] incoming Call Kicked because Camera State is Busy!!!!!!");
            EngineInterface.getInstance().hangUpCall(i, 1001, "");
            return PhoneStateMachine.ERROR_BUSY;
        }
        if (!z2) {
            destination = new Destination(3, str);
        } else if (MainApplication.mPhoneManager.isConfTest()) {
            ArrayList arrayList = new ArrayList();
            P2PUserInfo p2PUserInfo = new P2PUserInfo();
            p2PUserInfo.userID = str;
            p2PUserInfo.userName = MainApplication.mPhoneManager.getContactManager().getUserNameByUserID(str);
            arrayList.add(p2PUserInfo);
            destination = new Destination(-1, arrayList, 0L);
        } else {
            destination = new Destination(2, str);
        }
        MainApplication.mPhoneManager.getContactManager().isBlockUserForCall(str, s, destination, i, z, z2, z3, z4, str2, date, this);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onIncomingP2PConfCall(int i, boolean z, boolean z2, ArrayList arrayList, ArrayList arrayList2, Date date) {
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList.size()) {
                startIncomingCall(new Destination(i, arrayList3, 0L), (short) -1, i, z, true, z2, false, (String) arrayList2.get(0), date);
                return 0;
            }
            P2PUserInfo p2PUserInfo = new P2PUserInfo((String) arrayList.get(i3), (String) arrayList2.get(i3), 1, 0, -1);
            if (i3 == 0) {
                p2PUserInfo.userType = 0;
                p2PUserInfo.userState = 1;
            }
            arrayList3.add(p2PUserInfo);
            i2 = i3 + 1;
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onNotifyBoardDataAsk(NotifyBoardDataAsk notifyBoardDataAsk) {
        m2252b("<<YHT7>> onNotifyBoardDataAsk!!");
        if (this.f2481P == null) {
            return;
        }
        if (this.f2481P.m2582c().getDestinationType() != 2 || this.f2481P.m2611j(notifyBoardDataAsk.getCallSessionID())) {
            if (this.f2481P.m2582c().getDestinationType() == 4 && (notifyBoardDataAsk.getConferenceNo() == null || notifyBoardDataAsk.getConferenceNo().isEmpty() || !notifyBoardDataAsk.getConferenceNo().equals(this.f2481P.m2582c().getPhoneNo()))) {
                return;
            }
            this.f2481P.m2506a(notifyBoardDataAsk);
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onNotifyCloseCallAsk(NotifyCloseCallAsk notifyCloseCallAsk) {
        m2252b("onNotifyCloseCallAsk()");
        this.f2481P.m2529a(notifyCloseCallAsk.getConferenceNo(), notifyCloseCallAsk.getSenderID());
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onNotifyConfLayoutUserInformation(int i, int i2, int i3, String str, String str2, String str3) {
        Log.m2954d("onNotifyConfLayoutUserInformation()");
        if (this.f2481P == null) {
            return;
        }
        if (i == -1) {
            str = "";
        }
        if (i2 == -1) {
            str2 = "";
        }
        if (i3 == -1) {
            str3 = "";
        }
        this.f2481P.m2531a(str, str2, str3);
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onNotifyConsentAsk(NotifyConsentAsk notifyConsentAsk) {
        if (this.f2481P != null && CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            if (this.f2481P.m2582c().getDestinationType() != 2 || this.f2481P.m2611j(notifyConsentAsk.getCallSessionID())) {
                if (this.f2481P.m2582c().getDestinationType() == 4 && (notifyConsentAsk.getConferenceNo() == null || notifyConsentAsk.getConferenceNo().isEmpty() || !notifyConsentAsk.getConferenceNo().equals(this.f2481P.m2582c().getPhoneNo()))) {
                    return;
                }
                this.f2481P.m2520a(notifyConsentAsk);
            }
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onNotifyFinishShareCameraAsk(NotifyFinishShareCameraAsk notifyFinishShareCameraAsk) {
        if (this.f2481P != null && CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            if (this.f2481P.m2582c().getDestinationType() != 2 || this.f2481P.m2611j(notifyFinishShareCameraAsk.getCallSessionID())) {
                if (this.f2481P.m2582c().getDestinationType() == 4 && (notifyFinishShareCameraAsk.getConferenceNo() == null || notifyFinishShareCameraAsk.getConferenceNo().isEmpty() || !notifyFinishShareCameraAsk.getConferenceNo().equals(this.f2481P.m2582c().getPhoneNo()))) {
                    return;
                }
                this.f2481P.m2521a(notifyFinishShareCameraAsk);
            }
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onNotifyMuteReceive(int i, int i2, int i3) {
        Log.m2954d("onNotifyConfLayoutUserInformation()");
        if (this.f2481P == null) {
            return;
        }
        this.f2481P.m2575b(i2, i3);
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onNotifyStartShareScreenAsk(NotifyStartShareScreenAsk notifyStartShareScreenAsk) {
        m2252b("<<YHT7>> onNotifyStartShareScreenAsk!!");
        if (this.f2481P == null) {
            return;
        }
        if (this.f2481P.m2582c().getDestinationType() != 2 || this.f2481P.m2611j(notifyStartShareScreenAsk.getCallSessionID())) {
            if (this.f2481P.m2582c().getDestinationType() == 4 && (notifyStartShareScreenAsk.getConferenceNo() == null || notifyStartShareScreenAsk.getConferenceNo().isEmpty() || !notifyStartShareScreenAsk.getConferenceNo().equals(this.f2481P.m2582c().getPhoneNo()))) {
                return;
            }
            this.f2481P.m2576b(notifyStartShareScreenAsk.getWidth(), notifyStartShareScreenAsk.getHeight(), notifyStartShareScreenAsk.getVersion());
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onNotifyStopShareScreenAsk(NotifyStopShareScreenAsk notifyStopShareScreenAsk) {
        m2252b("<<YHT7>> onNotifyStopShareScreenAsk!!");
        if (this.f2481P == null) {
            return;
        }
        if (this.f2481P.m2582c().getDestinationType() != 2 || this.f2481P.m2611j(notifyStopShareScreenAsk.getCallSessionID())) {
            if (this.f2481P.m2582c().getDestinationType() == 4 && (notifyStopShareScreenAsk.getConferenceNo() == null || notifyStopShareScreenAsk.getConferenceNo().isEmpty() || !notifyStopShareScreenAsk.getConferenceNo().equals(this.f2481P.m2582c().getPhoneNo()))) {
                return;
            }
            this.f2481P.m2545ae();
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onP2PConferenceStatus(int i, ArrayList arrayList) {
        if (this.f2481P == null || !this.f2481P.m2611j(i)) {
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2581c = this.f2481P.m2581c(arrayList);
        if (iM2581c != 0) {
            m2246a("onP2PConferenceStatus Handling Error!!! Error Code:" + iM2581c);
        }
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onP2PConferenceVoiceActivity(int i, int i2) {
        if (this.f2481P == null || !this.f2481P.m2611j(i)) {
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2623o = this.f2481P.m2623o(i2);
        if (iM2623o != 0) {
            m2246a("onP2PConferenceStatus Handling Error!!! Error Code:" + iM2623o);
        }
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onP2pHoldReceived(int i, boolean z) {
        if (this.f2481P == null) {
            m2246a("onP2pHoldReceived() : mCall is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (!this.f2481P.m2611j(i)) {
            m2246a("onP2pHoldReceived() : ERROR_CANT_FIND_DESTINATION");
            m2261g();
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (!CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            m2246a("onP2pHoldReceived : mCall.getCallState() : it not disconnected.");
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        Message message = new Message();
        if (z) {
            MainApplication.mPhoneManager.getHardwareManager().setModeStartHold();
            this.f2481P.setPlayHoldTone(true);
            message.what = EventCode.EVENT_CALL_ON_HOLD;
            if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
                MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
            } else if (getCallingActivity() != null) {
                getCallingActivity().sendHandlerMessage(message, 0L);
            }
        } else {
            MainApplication.mPhoneManager.getHardwareManager().setModeStopHold(this.f2481P.isUseVideo());
            this.f2481P.setPlayHoldTone(false);
            message.what = EventCode.EVENT_CALL_RETRIEVED;
            if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
                MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
            } else if (getCallingActivity() != null) {
                getCallingActivity().sendHandlerMessage(message, 0L);
            }
        }
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onPreviewCaptureError(int i, boolean z) {
        m2252b("onPreviewCaptureError()");
        if (this.f2481P == null) {
            m2246a("onPreviewCaptureError() : ERROR_CANT_FIND_DESTINATION");
        } else if (!this.f2481P.m2611j(i)) {
            m2246a("onPreviewCaptureError() : invalid call id");
        } else {
            updateCallInfo(new CallStatusData());
            this.f2481P.m2598f(z);
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onPreviewCaptureImage(int i, boolean z) {
        m2252b("onPreviewCaptureImage()");
        if (this.f2481P == null) {
            m2246a("onPreviewCaptureImage() : ERROR_CANT_FIND_DESTINATION");
        } else if (!this.f2481P.m2611j(i)) {
            m2246a("onPreviewCaptureImage() : invalid call id");
        } else {
            updateCallInfo(new CallStatusData());
            this.f2481P.m2598f(z);
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onProposeConsentAsk(ProposeConsentAsk proposeConsentAsk) {
        if (this.f2481P != null && CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            if (this.f2481P.m2582c().getDestinationType() != 2 || this.f2481P.m2611j(proposeConsentAsk.getCallSessionID())) {
                if (this.f2481P.m2582c().getDestinationType() == 4 && (proposeConsentAsk.getConferenceNo() == null || proposeConsentAsk.getConferenceNo().isEmpty() || !proposeConsentAsk.getConferenceNo().equals(this.f2481P.m2582c().getPhoneNo()))) {
                    return;
                }
                this.f2481P.m2522a(proposeConsentAsk);
            }
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onProposeConsentRep(ProposeConsentRep proposeConsentRep) {
        if (this.f2481P != null && CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            if (this.f2481P.m2582c().getDestinationType() != 2 || this.f2481P.m2611j(proposeConsentRep.getCallSessionID())) {
                if (this.f2481P.m2582c().getDestinationType() == 4 && (proposeConsentRep.getConferenceNo() == null || proposeConsentRep.getConferenceNo().isEmpty() || !proposeConsentRep.getConferenceNo().equals(this.f2481P.m2582c().getPhoneNo()))) {
                    return;
                }
                this.f2481P.m2523a(proposeConsentRep);
            }
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onReceiveCall(int i, short s, boolean z, boolean z2) {
        int iConnectCall = PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        m2252b("onReceiveCall : callID : " + i);
        if (this.f2481P == null) {
            m2246a("onReceiveCall() : ERROR_CANT_FIND_DESTINATION");
        } else {
            m2252b("onReceiveCall : mCallInstance.getCallID() : " + this.f2481P.m2487T());
            if (this.f2481P.m2611j(i)) {
                this.f2481P.m2534a(s);
                iConnectCall = connectCall(null, i, true, 10, z2, "");
                if (iConnectCall == 0) {
                    m2252b("onReceiveCall Handling Success!!! Success Code:" + iConnectCall);
                } else {
                    m2246a("onReceiveCall Handling Error!!! Error Code:" + iConnectCall);
                    m2261g();
                }
            } else {
                m2246a("onReceiveCall() : invalid call id");
                if (i != 0) {
                    m2261g();
                    if (i == 0) {
                        EngineInterface.getInstance().hangUpSIPCall(i);
                    } else {
                        EngineInterface.getInstance().hangUpCall(i, 1001, "");
                    }
                }
            }
        }
        return iConnectCall;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onReceiveCallTime(int i, Date date) {
        if (this.f2481P == null) {
            m2246a("onReceiveCallTime() : ERROR_CANT_FIND_DESTINATION");
            return;
        }
        if (!this.f2481P.m2559as()) {
            m2246a("onReceiveCallTime : invalid call type");
            return;
        }
        if (!CallState.isNotConnected(this.f2481P.m2573b().getCallState())) {
            m2246a("onReceiveCallTime : invalid call state");
            return;
        }
        if (this.f2481P.m2589d() && this.f2481P.m2559as()) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().playRingBackTone();
        }
        this.f2481P.m2605h(false);
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onReceiveChangeToConference(int i, String str, String str2) {
        m2246a("onReceiveChangeToConference() callID:" + i + ", conferenceNo:" + str);
        if (this.f2481P == null || !this.f2481P.m2611j(i)) {
            m2246a("onReceiveChangeToConference() invalid callID");
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        this.f2473G.m2645a();
        return this.f2481P.m2500a(i, str, str2);
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onReceiveFeatureInfo(List list) {
        if (this.f2481P != null) {
            this.f2481P.onReceiveFeatureInfo(list);
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onReceiveMuteState(int i) {
        m2252b("onReceiveMuteState() : callID : " + i);
        if (this.f2481P == null) {
            m2246a("onReceiveMuteState() : ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (this.f2481P.m2611j(i)) {
            return this.f2481P.m2470C() ? 1 : 0;
        }
        m2246a("onReceiveMuteState() : invalid call id");
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onReceiveP2PHandshaking(int i, boolean z) {
        m2252b("onReceiveP2PHandshaking() : callID : " + i);
        if (this.f2481P == null) {
            m2246a("onReceiveP2PHandshaking() : ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (!this.f2481P.m2611j(i)) {
            m2246a("onReceiveP2PHandshaking : invalid call id");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (!z) {
            return PhoneStateMachine.ERROR_UNKNOWN;
        }
        if (MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity() == null || !this.f2481P.m2589d() || this.f2481P.m2573b().getCallState() != 1 || !this.f2481P.m2558ar()) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!isCurrentMobileCall()) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().playRingBackTone();
        }
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onReceiveSipRingToneType(int i, int i2) {
        m2252b("onReceiveSipRingToneType() : " + i2);
        if (this.f2481P == null) {
            m2246a("onReceiveSipRingToneType() : mCall is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (!this.f2481P.m2611j(i)) {
            m2246a("onReceiveSipRingToneType() : ERROR_CANT_FIND_DESTINATION");
            EngineInterface.getInstance().hangUpSIPCall(i);
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (i2 == 180) {
            m2252b("onReceiveSipRingToneType() : SIP_RINGTONE_NONE");
            if (this.f2481P.m2589d() && this.f2481P.m2573b().getCallState() == 1 && !isCurrentMobileCall()) {
                MainApplication.mPhoneManager.getHardwareManager().getSoundManager().playRingBackTone();
            }
        } else {
            m2252b("onReceiveSipRingToneType() : SIP_RINGTONE_AVAILABLE");
            if (!isCurrentMobileCall()) {
                MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopRingBackTone();
            }
        }
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onRecvFileDone(int i, ArrayList arrayList) {
        if (this.f2481P == null) {
            m2246a("onRecvFileDone() : ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (this.f2481P.m2611j(i)) {
            this.f2481P.m2532a(arrayList);
            return 0;
        }
        m2246a("onRecvFileDone : invalid call id");
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onRecvFileStart(int i, int i2) {
        if (this.f2481P == null) {
            m2246a("onRecvFileStart() : ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (this.f2481P.m2611j(i)) {
            this.f2481P.m2618m(i2);
            return 0;
        }
        m2246a("onRecvFileStart : invalid call id");
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onRejectMessage(RejectMessageAsk rejectMessageAsk) {
        this.f2481P.notiRejectMsg(rejectMessageAsk.getUserID(), rejectMessageAsk.getRejectMessage());
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onRemoteRotationInfo(int i, int i2, int i3) {
        if (this.f2481P == null) {
            m2246a("onRemoteRotationInfo() : ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        updateCallInfo(new CallStatusData());
        m2252b("onRemoteRotationInfo() : rotation = " + i2 + ", surfID = " + i3);
        this.f2481P.m2588d(i2, i3);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onRemoteVideoCaptureImage(int i) {
        if (this.f2481P == null) {
            m2246a("onRemoteVideoCaptureImage() : ERROR_CANT_FIND_DESTINATION");
        } else if (!this.f2481P.m2611j(i)) {
            m2246a("onRemoteVideoCaptureImage() : invalid call id");
        } else {
            updateCallInfo(new CallStatusData());
            this.f2481P.m2483P();
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onRemoteVideoRecrodInfo(int i, boolean z) {
        if (this.f2481P == null) {
            m2246a("onRemoteVideoRecrodInfo() : ERROR_CANT_FIND_DESTINATION");
        } else if (!this.f2481P.m2611j(i)) {
            m2246a("onRemoteVideoRecrodInfo : invalid call id");
        } else {
            updateCallInfo(new CallStatusData());
            this.f2481P.m2584c(z);
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onReqAddConferenceMemberAsk(ReqAddConferenceMemberAsk reqAddConferenceMemberAsk) {
        if (this.f2481P == null) {
            m2235a(reqAddConferenceMemberAsk);
            return;
        }
        if (this.f2481P.m2582c().getDestinationType() != 2) {
            m2235a(reqAddConferenceMemberAsk);
            return;
        }
        if (!this.f2481P.m2611j(reqAddConferenceMemberAsk.getCallSessionID())) {
            m2235a(reqAddConferenceMemberAsk);
            return;
        }
        this.f2473G.m2645a();
        ArrayList arrayList = new ArrayList();
        for (ConferenceMember conferenceMember : reqAddConferenceMemberAsk.getConferenceMemberList()) {
            com.sds.coolots.call.model.ConferenceMember conferenceMember2 = new com.sds.coolots.call.model.ConferenceMember();
            conferenceMember2.userID = conferenceMember.getUserID();
            conferenceMember2.userName = conferenceMember.getUserName();
            conferenceMember2.inviteUserID = reqAddConferenceMemberAsk.getRequestID();
            arrayList.add(conferenceMember2);
        }
        addConferenceMember(this.f2481P.m2582c(), arrayList, null);
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onReqAddConferenceMemberRep(ReqAddConferenceMemberRep reqAddConferenceMemberRep) {
        if (this.f2481P != null && this.f2481P.m2582c().getDestinationType() == 2 && this.f2481P.m2611j(reqAddConferenceMemberRep.getCallSessionID())) {
            this.f2481P.m2524a(reqAddConferenceMemberRep);
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onRequestConsentAsk(RequestConsentAsk requestConsentAsk) {
        m2246a("[CONSENT] onReceiveRequestConsentAsk Simplephonestatemachine");
        if (this.f2481P != null && CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            this.f2495d = true;
            if (this.f2481P.m2582c().getDestinationType() == 2 && !this.f2481P.m2611j(requestConsentAsk.getCallSessionID())) {
                m2246a("<CIH> onRequestConsentAsk() step1");
                return;
            }
            if (this.f2481P.m2582c().getDestinationType() == 4 && (requestConsentAsk.getConferenceNo() == null || requestConsentAsk.getConferenceNo().isEmpty() || !requestConsentAsk.getConferenceNo().equals(this.f2481P.m2582c().getPhoneNo()))) {
                m2246a("<CIH> onRequestConsentAsk() step2");
            } else {
                m2246a("<CIH> onRequestConsentAsk() step3");
                this.f2481P.m2525a(requestConsentAsk);
            }
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onRequestConsentRep(RequestConsentRep requestConsentRep) {
        if (this.f2481P == null) {
            m2246a("[CONSENT] receive onReceiveRequestConsentRep Simplephonestatemachine step1");
            return;
        }
        if (!CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            m2246a("[CONSENT] receive onReceiveRequestConsentRep Simplephonestatemachine step2");
            return;
        }
        if (this.f2481P.m2582c().getDestinationType() != 2 || this.f2481P.m2611j(requestConsentRep.getCallSessionID())) {
            if (this.f2481P.m2582c().getDestinationType() == 4 && (requestConsentRep.getConferenceNo() == null || requestConsentRep.getConferenceNo().isEmpty() || !requestConsentRep.getConferenceNo().equals(this.f2481P.m2582c().getPhoneNo()))) {
                return;
            }
            this.f2481P.m2526a(requestConsentRep);
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onRequestHipri(ArrayList arrayList) {
        if (PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
            m2246a("This is wifi connection. there is no need to hipri funcion.");
            return;
        }
        m2246a("onRequestHipri!!!!!");
        Message message = new Message();
        message.what = 10010;
        message.obj = arrayList;
        this.f2476K.sendMessage(message);
        this.f2476K.removeMessages(HandlerC1191F.f2618c);
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onSendChangeToConference(int i, boolean z) {
        m2252b("onSendChangeToConference() callID: " + i + " result: " + z);
        if (this.f2481P == null) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (this.f2481P != null && CallState.isNotConnected(this.f2481P.m2573b().getCallState())) {
            m2252b("onSendChangeToP2P() not connected  ");
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        int iM2569b = this.f2481P.m2569b(i, z);
        if (iM2569b != 0) {
            return iM2569b;
        }
        this.f2476K.sendEmptyMessage(HandlerC1191F.f2618c);
        return iM2569b;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onSendChangeToP2P(int i, int i2, Date date) {
        m2252b("onSendChangeToP2P : callID:  " + i + " result: " + i2);
        if (this.f2481P != null && CallState.isNotConnected(this.f2481P.m2573b().getCallState())) {
            m2252b("onSendChangeToP2P() not connected  ");
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        switch (i2) {
            case -2:
            case -1:
                m2246a("onSendChangeToP2P() ERROR_INVALID_CHANGE_TO_P2P_ENGINE_FAIL result????" + i2);
                MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
                this.f2481P.m2613k(false);
                boolean zM2260f = m2260f();
                this.f2481P.m2568b(1011, "");
                MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(zM2260f);
                m2253b(true);
                return PhoneStateMachine.ERROR_INVALID_CHANGE_TO_P2P_ENGINE_A_FAIL;
            case 0:
            case 1:
            default:
                if (this.f2481P.m2497a(i, i2, date) == 0) {
                    this.f2473G.m2645a();
                    if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
                        MainApplication.mPhoneManager.getDataUsageManager().notifyStartCall(this.f2481P.getInitiateCallType());
                    }
                    this.f2481P.m2566az();
                    return 0;
                }
                MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
                MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
                m2246a("startOutGoingCall Handling Error!!! Error Code:" + i2);
                m2253b(true);
                return 0;
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onSendFileDone(int i) {
        if (this.f2481P == null) {
            m2246a("onSendFileDone() : ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (this.f2481P.m2611j(i)) {
            this.f2481P.m2552al();
            return 0;
        }
        m2246a("onSendFileDone : invalid call id");
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onSendFileStart(int i) {
        if (this.f2481P == null) {
            m2246a("onSendFileStart() : ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (this.f2481P.m2611j(i)) {
            this.f2481P.m2551ak();
            return 0;
        }
        m2246a("onSendFileStart : invalid call id");
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    @Override // com.sds.coolots.call.ShareScreenInterface, com.sds.coolots.common.controller.EngineCallBackInterface
    public void onShareScreenCaptureError(int i, boolean z) {
        m2252b(" onShareScreenCaptureError()");
        if (this.f2481P == null) {
            m2246a("onShareScreenCaptureError() : ERROR_CANT_FIND_DESTINATION");
        } else if (!this.f2481P.m2611j(i)) {
            m2246a("onShareScreenCaptureError() : invalid call id");
        } else {
            updateCallInfo(new CallStatusData());
            this.f2481P.m2602g(z);
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onShareViewEndNotifyReceive(int i) {
        if (this.f2481P != null && this.f2481P.m2559as() && CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            m2252b("onShareViewEndNotifyReceive()");
            this.f2481P.showToastForShareView(2);
            this.f2481P.stopShareView();
        }
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public int onTranslateDataReceive(int i, String str, String str2, int i2) {
        if (this.f2481P == null) {
            m2246a("onTranslateDataReceive() : ERROR_CANT_FIND_DESTINATION");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (!this.f2481P.m2611j(i)) {
            m2246a("onTranslateDataReceive : invalid call id");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        updateCallInfo(new CallStatusData());
        this.f2481P.m2530a(str, str2, i2);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.EngineCallBackInterface
    public void onTryCallPush(int i) {
        if (this.f2481P == null) {
            m2246a("onTryCallPush() : ERROR_CANT_FIND_DESTINATION");
            return;
        }
        if (!this.f2481P.m2611j(i)) {
            EngineInterface.getInstance().hangUpCall(i, 1001, "");
            m2246a("onTryCallPush : invalid call id");
        } else if (this.f2481P.m2559as()) {
            this.f2481P.m2605h(true);
        } else {
            m2246a("onTryCallPush : invalid call type");
            EngineInterface.getInstance().hangUpCall(i, 1001, "");
        }
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public int pauseShareScreen(Destination destination, int i) {
        m2252b("<<YHT7>> pauseShareScreen!!");
        return !m2254b(destination) ? PhoneStateMachine.ERROR_CANT_FIND_DESTINATION : !CallState.isConnected(this.f2481P.m2573b().getCallState()) ? PhoneStateMachine.ERROR_INVALID_STATE : this.f2481P.m2615l(i);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void playTTS(TranslationDisplayData translationDisplayData) {
        if (this.f2481P != null && CallState.isConnected(this.f2481P.m2573b().getCallState()) && this.f2481P.m2582c().getDestinationType() == 2) {
            m2252b("playTTS");
            if (this.f2498x != null) {
                this.f2498x.playTTS(translationDisplayData);
            }
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void registCallOutNumber(String str) {
        this.f2477L = str;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void removeCallBack(CallStateCallBack callStateCallBack) {
        m2252b("removeCallBack()");
        if (callStateCallBack == null || this.f2483T == null) {
            return;
        }
        this.f2483T.remove(callStateCallBack);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void removeCallTypeChangeCallback(CallTypeChangeCallback callTypeChangeCallback) {
        this.f2473G.m2648b(callTypeChangeCallback);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int removeConferenceMember(Destination destination, String str) {
        if (m2233a(destination) != 0) {
            return PhoneStateMachine.ERROR_CANT_FIND_CALL_INSTANCE;
        }
        int iM2599g = this.f2481P.m2599g(str);
        if (iM2599g == 0) {
            return iM2599g;
        }
        m2246a("removeConferenceMember Handling Error!!! Error Code:" + iM2599g);
        return iM2599g;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void removeEveryCallBack() {
        m2252b("removeEveryCallBack()");
        if (this.f2483T != null) {
            Iterator it = this.f2483T.iterator();
            while (it.hasNext()) {
                CallStateCallBack callStateCallBack = (CallStateCallBack) it.next();
                if (callStateCallBack != null) {
                    this.f2483T.remove(callStateCallBack);
                }
            }
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int requestConsent(Destination destination, int i, int i2) {
        if (!m2254b(destination)) {
            m2252b("<CIH> requestConsent step 1");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            m2252b("<CIH> requestConsent step 3");
            return this.f2481P.m2578c(i, i2);
        }
        m2252b("<CIH> requestConsent step 2");
        return PhoneStateMachine.ERROR_INVALID_STATE;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void resetBackupCallState() {
        if (this.f2481P == null) {
            return;
        }
        this.f2481P.m2603h();
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public int resumeShareScreen(Destination destination, Point point, boolean z) {
        m2252b("<<YHT7>> resumeShareScreen!!");
        return !m2254b(destination) ? PhoneStateMachine.ERROR_CANT_FIND_DESTINATION : !CallState.isConnected(this.f2481P.m2573b().getCallState()) ? PhoneStateMachine.ERROR_INVALID_STATE : this.f2481P.m2503a(point, z);
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public int sendBoardData(Destination destination, int i, byte[] bArr) {
        m2252b("<<YHT7>> sendBoardData!!");
        if (!m2254b(destination)) {
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        if (!CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        m2252b("<<YHT7>> sendBoardData!! pass check routine");
        return this.f2481P.m2502a(i, bArr);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void sendCameraZoomInfo(int i) {
        if (this.f2481P == null) {
            return;
        }
        this.f2481P.m2601g(i);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void sendDtmfTone(int i) throws IOException {
        if (this.f2481P.m2559as()) {
            EngineInterface.getInstance().sendDtmfTone(i, 0, this.f2481P.m2487T());
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void sendNotifyStartVideoRecord() {
        if (this.f2481P == null) {
            return;
        }
        EngineInterface.getInstance().reqNotifyStartVideoRecord(this.f2481P.m2487T());
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void sendRejectMessage(String str, short s, String str2, String str3) {
        m2252b("sendRejectMessage() userID = " + str + " deviceID = " + ((int) s) + " rejectMsg = " + str2 + " userName = " + str3);
        RejectMessageAsk rejectMessageAsk = new RejectMessageAsk();
        rejectMessageAsk.setUserID(MainApplication.mConfig.getProfileUserID());
        rejectMessageAsk.setDeviceID(Short.valueOf(s));
        rejectMessageAsk.setRejectMessage(str2);
        MsgHeader msgHeaderM2140a = C1149a.m2140a(MessageInfo.RejectMessageAsk.getServiceCode(), MessageInfo.RejectMessageAsk.getMessageCode());
        ArrayList arrayList = new ArrayList();
        PushTargetInfo pushTargetInfo = new PushTargetInfo();
        pushTargetInfo.setReceiverUserID(str);
        pushTargetInfo.setReceiverDeviceID(Short.valueOf(s));
        arrayList.add(pushTargetInfo);
        C1149a.m2141a(msgHeaderM2140a, rejectMessageAsk, arrayList);
        MainApplication.mPhoneManager.getCallLogManager().addRejectMessage(str, str2, true, str3);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void sendRotationInfo(Destination destination, int i, boolean z, boolean z2) {
        if (this.f2481P.m2560at() || m2233a(destination) == 0) {
            this.f2481P.m2517a(i, z, z2);
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void sendShareViewNotifyEnd(int i) throws IOException {
        m2252b("sendShareViewNotifyEnd");
        EngineInterface.getInstance().notifyEndShareView(this.f2481P.m2487T());
        this.f2481P.showToastForShareView(i);
        this.f2481P.stopShareView();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void sendTranslateData(String str, String str2, int i) {
        if (this.f2481P == null) {
            return;
        }
        EngineInterface.getInstance().reqSendTranslateData(this.f2481P.m2487T(), str, str2, i);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void setAudioPathInfo(Intent intent) {
        if (this.f2481P == null || CallState.isDisconnected(this.f2481P.m2573b().getCallState()) || this.f2481P.getAudioPathController() == null) {
            return;
        }
        this.f2481P.getAudioPathController().checkBRAction(intent);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void setCallingActivity(CallingInterface callingInterface) {
        if (this.f2481P == null) {
            m2246a("setCallingActivity() : mCallInstance is NULL. Cannot set activity instance here.");
        } else {
            this.f2481P.setCallingActivity(callingInterface);
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setCameraZoomAction(Destination destination, int i) {
        if (destination == null) {
            m2246a("setCameraZoomAction : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        return iM2233a == 0 ? this.f2481P.m2590e(i) : iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setCartoonView(Destination destination, int i) {
        if (destination == null) {
            m2246a("setCartoonView : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        return iM2233a == 0 ? this.f2481P.m2585d(i) : iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void setClearCoverScreenLock(boolean z) {
        m2252b("setClearCover() clear cover open?" + z);
        this.f2472C = z;
        if (!z || ((!isOutGoingCall() || CallState.isDisconnected(this.f2481P.m2573b().getCallState())) && (isOutGoingCall() || !CallState.isConnected(this.f2481P.m2573b().getCallState())))) {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(true);
        } else {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireLockForProximity();
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void setDualCameraStartedTime(Date date) {
        if (this.f2481P == null) {
            return;
        }
        this.f2481P.m2533a(date);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setDualPosition(Destination destination, int i, int i2, int i3, int i4) {
        if (destination != null) {
            return this.f2481P.m2579c(i, i2, i3, i4);
        }
        m2246a("setDualPosition : destination is NULL");
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void setEarPhone(boolean z) {
        Log.m2954d("setEarPhone()");
        this.f2471B = z;
        if (this.f2481P == null || CallState.isDisconnected(this.f2481P.m2573b().getCallState()) || MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity() == null) {
            return;
        }
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().setEarPhoneScreenLock();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setEmotionalAnimation(Destination destination, int i, boolean z) {
        if (destination == null) {
            m2246a("setEmotionalAnimation : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        return iM2233a == 0 ? this.f2481P.m2501a(i, z) : iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setEmotionalEyeContact(boolean z) {
        return EngineInterface.getInstance().setEmotionalEyeContact(z);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setEnablePreview(Destination destination, int i) {
        if (destination == null) {
            m2246a("setEnablePreview : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        return iM2233a == 0 ? this.f2481P.m2606i(i) : iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setFaceEmotion(Destination destination, int i) {
        if (destination == null) {
            m2246a("setFaceEmotion : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        return iM2233a == 0 ? this.f2481P.m2595f(i) : iM2233a;
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public int setModeChangeDuringShareScreen(Destination destination, int i) {
        m2252b("haeri= SetModeChangeDuringShareScreen!!");
        return !m2254b(destination) ? PhoneStateMachine.ERROR_CANT_FIND_DESTINATION : !CallState.isConnected(this.f2481P.m2573b().getCallState()) ? PhoneStateMachine.ERROR_INVALID_STATE : this.f2481P.m2612k(i);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setOtherPartyName(Destination destination, String str) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && this.f2481P.m2559as()) {
            this.f2481P.m2597f(str);
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void setP2PTestInfo(String str, int i, int i2, boolean z) {
        this.f2485Z = z;
        this.f2487ab = i;
        this.f2488ac = i2;
        this.f2486aa = new Destination(2, str);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setPreviewOutLineStatus(Destination destination, int i, int i2, int i3) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2494a(i, i2, i3)) != 0) {
            m2246a("setPreviewGuideLineStatus Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setRecognitionVoiceLanguage(int i) {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState()) || this.f2481P.m2582c().getDestinationType() != 2) {
            return 1;
        }
        m2252b("setRecognitionVoiceLanguage(" + i + ")");
        if (this.f2498x != null) {
            return this.f2498x.setVoiceLanguage(i);
        }
        return 1;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setRender(Destination destination, int i, int i2) {
        int iM2233a = m2233a(destination);
        return iM2233a != 0 ? iM2233a : this.f2481P.m2591e(i, i2);
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public void setRequesterID(String str) {
        this.f2497w = str;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean setSSOCallCallback(ISSOCallCallBack iSSOCallCallBack) {
        m2252b("setSSOCallCallback!! mCallInstance: " + this.f2481P + " callback: " + iSSOCallCallBack);
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            return false;
        }
        this.f2481P.m2528a(iSSOCallCallBack);
        return true;
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public int setShareScreenCallback(Destination destination, ShareScreenCallback shareScreenCallback) {
        m2252b("<<YHT7>> setShareScreenCallback!!");
        if (!m2254b(destination)) {
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        this.f2481P.m2527a(shareScreenCallback);
        return 0;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void setShowCallActivity(boolean z) {
        m2252b("setShowCallActivity : " + z);
        this.f2489ad = z;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setThemeShot(Destination destination, int i, int i2, boolean z) {
        if (destination == null) {
            m2246a("setThemeShot : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        return iM2233a == 0 ? this.f2481P.m2498a(i, i2, z) : iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void setUnHoldFor3GIdle(Destination destination, int i) {
        Message message = new Message();
        message.what = 12;
        message.arg1 = i;
        message.obj = destination;
        this.f2474I.sendMessageDelayed(message, 500L);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int setUseNoiseReduction(Destination destination, boolean z) {
        if (destination == null) {
            m2246a("setUseNoiseReduction : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        return iM2233a == 0 ? this.f2481P.m2592e(z) : iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void showCallActivity(boolean z, boolean z2, boolean z3) {
        m2252b("showCallActivity(" + z + "): " + this.f2489ad);
        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
            Message message = new Message();
            message.what = EventCode.EVENT_CALL_ACTION;
            MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
            return;
        }
        Intent callIntent = MainApplication.mCallIntentGenerator.getCallIntent(z, z2, z3);
        if (callIntent != null) {
            if (this.f2489ad) {
                m2252b("haeri=showcallactivity()-------not show call activity!!!!!!");
                this.f2489ad = false;
                return;
            }
            if (m2248a(z, z2, z3) || isCurrentMobileCall()) {
                return;
            }
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

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int startAvatar(Destination destination) {
        int iM2233a = m2233a(destination);
        return iM2233a != 0 ? iM2233a : this.f2481P.m2489V();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int startDualCamera(Destination destination, int i, int i2, int i3, int i4) {
        if (destination == null) {
            m2246a("startDualCamera : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        return iM2233a == 0 ? this.f2481P.m2495a(i, i2, i3, i4) : iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int startFileTransfer(Destination destination, ArrayList arrayList) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2571b(arrayList)) != 0) {
            m2246a("startFileTransfer Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int startHideMeVideoCall(Destination destination, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2508a(byteBuffer, i, i2, i3, i4, z, z2)) != 0) {
            m2246a("startHideMeVideoCall Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.BlockCallHandler
    public int startIncomingCall(Destination destination, short s, int i, boolean z, boolean z2, boolean z3, boolean z4, String str, Date date) {
        m2252b("startIncomingCall() : CallID : " + i + " UseVideo : " + z + " isP2P : " + z2);
        if (MainApplication.mConfig.isCPUBoost() && MainApplication.mPhoneManager.acquireDVFSHelper()) {
            m2265k();
        }
        if (this.f2481P != null) {
            CallStatusData callStatusData = new CallStatusData();
            updateCallInfo(callStatusData);
            if (!CallState.isDisconnected(callStatusData.getCallState())) {
                this.f2481P.m2564ax();
                if (z2) {
                    EngineInterface.getInstance().hangUpCall(i, 200, "");
                } else {
                    EngineInterface.getInstance().hangUpSIPCall(i);
                }
                m2246a("startIncomingCall : ERROR_BUSY!!");
                return PhoneStateMachine.ERROR_BUSY;
            }
            m2253b(true);
        }
        if (m2262h()) {
            EngineInterface.getInstance().hangUpCall(i, 200, "");
            Log.m2958e("LHH Incoming VOIP Call during 3G Call callID : " + i);
            return PhoneStateMachine.ERROR_BUSY;
        }
        if (m2267m()) {
            m2252b("startIncomingConferenceCall() : Blocking ON! -> Hangup");
            C1193H.m2409a(destination, str, z, z4, new Date(), 2);
            EngineInterface.getInstance().hangUpCall(i, 10, "");
            return PhoneStateMachine.ERROR_BUSY;
        }
        if (Settings.System.getInt(MainApplication.mContext.getContentResolver(), "access_control_enabled", 0) == 1) {
            m2252b("startIncomingCall() : Interaction Control ON! -> Hangup");
            C1193H.m2409a(destination, str, z, z4, new Date(), 2);
            EngineInterface.getInstance().hangUpCall(i, 10, "");
            return PhoneStateMachine.ERROR_BUSY;
        }
        MainApplication.mPhoneManager.clearSSODataBeforeCallStart();
        this.f2481P = new C1205g(destination, null, this, null, null, z, MainApplication.mPhoneManager.getISSOCallCallBack(), MainApplication.mPhoneManager.getIWatchManagerCallBack(), false);
        m2252b("call instance is created!!!!");
        this.f2481P.m2564ax();
        MainApplication.mNativeInterfaceCreator.createNativeWindowController().closeSystemDialogs();
        MainApplication.mConfig.setCallState(true);
        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
            MainApplication.mPhoneManager.getCoolotsEventListener().onCallState(false);
        }
        MainApplication.mPhoneManager.getHardwareManager().setModeCalling(false, z);
        int iM2511a = this.f2481P.m2511a(s, z, i, z3, z4, str);
        if (iM2511a == 0) {
            m2252b("startIncomingCall Handling Success!!!");
            if (this.f2481P.getAudioPathController() != null) {
                this.f2481P.getAudioPathController().initCallSwitching(z);
                this.f2481P.getAudioPathController().initUIComponents(true);
            }
            m2244a(this.f2481P);
            return iM2511a;
        }
        m2246a("startIncomingCall Handling Error!!! Error Code:" + iM2511a);
        if (z2) {
            EngineInterface.getInstance().hangUpCall(i, 1001, "");
            return iM2511a;
        }
        EngineInterface.getInstance().hangUpSIPCall(i);
        return iM2511a;
    }

    @Override // com.sds.coolots.call.BlockCallHandler
    public int startIncomingConference(Destination destination, ConferenceInfo conferenceInfo, Date date, String str, String str2) {
        m2252b("startIncomingConference : ConferenceNo : " + conferenceInfo.getConferenceNo() + " UseVideo : " + conferenceInfo.getConferenceType() + " inviteUserID : " + str2);
        if (MainApplication.mConfig.isCPUBoost() && MainApplication.mPhoneManager.acquireDVFSHelper()) {
            m2265k();
        }
        switch (m2268a()) {
            case 0:
            default:
                if (this.f2481P != null) {
                    CallStatusData callStatusData = new CallStatusData();
                    updateCallInfo(callStatusData);
                    if (!CallState.isDisconnected(callStatusData.getCallState())) {
                        denyConference(conferenceInfo.getConferenceNo(), 200);
                        this.f2481P.m2564ax();
                        break;
                    } else {
                        m2253b(true);
                    }
                }
                if (!m2262h()) {
                    if (!m2267m()) {
                        if (Settings.System.getInt(MainApplication.mContext.getContentResolver(), "access_control_enabled", 0) != 1) {
                            boolean z = "A".equals(conferenceInfo.getConferenceType()) ? false : true;
                            MainApplication.mPhoneManager.clearSSODataBeforeCallStart();
                            this.f2481P = new C1205g(destination, conferenceInfo, this, str, str2, z, MainApplication.mPhoneManager.getISSOCallCallBack(), MainApplication.mPhoneManager.getIWatchManagerCallBack(), false);
                            MainApplication.mNativeInterfaceCreator.createNativeWindowController().closeSystemDialogs();
                            this.f2481P.m2564ax();
                            MainApplication.mConfig.setCallState(true);
                            if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
                                MainApplication.mPhoneManager.getCoolotsEventListener().onCallState(false);
                            }
                            MainApplication.mPhoneManager.getHardwareManager().setModeCalling(false, z);
                            int iM2511a = this.f2481P.m2511a((short) -1, z, 0, false, false, "");
                            if (iM2511a != 0) {
                                m2246a("startIncomingCall Handling Error!!! Error Code:" + iM2511a);
                                m2253b(true);
                                break;
                            } else {
                                m2246a("startIncomingCall Handling Success!!! Success Code:" + iM2511a);
                                m2244a(this.f2481P);
                                if (this.f2481P.getAudioPathController() != null) {
                                    this.f2481P.getAudioPathController().initCallSwitching(z);
                                    this.f2481P.getAudioPathController().initUIComponents(true);
                                    break;
                                }
                            }
                        } else {
                            m2252b("startIncomingConferenceCall() : Interaction Control ON! -> Hangup");
                            C1217s.m2690a(destination, "V".equals(conferenceInfo.getConferenceType()), new Date(), 2);
                            denyConference(conferenceInfo.getConferenceNo(), 10);
                            break;
                        }
                    } else {
                        m2252b("startIncomingConferenceCall() : Blocking ON! -> Hangup");
                        C1217s.m2690a(destination, "V".equals(conferenceInfo.getConferenceType()), new Date(), 2);
                        denyConference(conferenceInfo.getConferenceNo(), 10);
                        break;
                    }
                } else {
                    denyConference(conferenceInfo.getConferenceNo(), 1004);
                    break;
                }
                break;
            case 1:
            case 2:
                denyConference(conferenceInfo.getConferenceNo(), 1004);
                break;
        }
        return PhoneStateMachine.ERROR_BUSY;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int startOutGoingCall(Destination destination, boolean z, boolean z2, String str) {
        m2252b("startOutGoingCall() :  UseVideo : " + z);
        m2252b("!!![scamera] (isLiveShare) : " + z2);
        if (MainApplication.mConfig.isUseWifiOnly() && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
            return PhoneStateMachine.ERROR_NOT_SUPPORTED_NETWORK;
        }
        if (MainApplication.mConfig.isCPUBoost() && MainApplication.mPhoneManager.acquireDVFSHelper()) {
            m2265k();
        }
        if (this.f2481P != null) {
            CallStatusData callStatusData = new CallStatusData();
            updateCallInfo(callStatusData);
            m2252b("startOutGoingCall : mCall != null, state: " + callStatusData.getCallState());
            if (!CallState.isDisconnected(callStatusData.getCallState())) {
                this.f2481P.m2564ax();
                m2246a("startOutGoingCall : ERROR_BUSY");
                return PhoneStateMachine.ERROR_BUSY;
            }
            m2246a("startOutGoingCall : disconnected call, retry new call");
            m2253b(true);
        }
        if (m2262h()) {
            m2252b("Multiple_Call Outgoing call(VOIP/VT) during 3G Show Popup");
            m2246a("startOutGoingCall : ERROR_BUSY (native call)");
            return PhoneStateMachine.ERROR_BUSY;
        }
        MainApplication.mPhoneManager.clearSSODataBeforeCallStart();
        this.f2481P = new C1205g(destination, null, this, null, null, z, MainApplication.mPhoneManager.getISSOCallCallBack(), MainApplication.mPhoneManager.getIWatchManagerCallBack(), true);
        if (this.f2481P == null) {
            m2246a("startOutGoingCall : wrong destination type: " + destination.getDestinationType());
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        m2252b("call instance is created!!!!");
        this.f2481P.m2564ax();
        MainApplication.mConfig.setCallState(true);
        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
            MainApplication.mPhoneManager.getCoolotsEventListener().onCallState(false);
        }
        MainApplication.mPhoneManager.getHardwareManager().setModeCalling(true, z);
        int iM2514a = this.f2481P.m2514a(z, z2, str);
        if (iM2514a != 0) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
            MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
            m2246a("startOutGoingCall Handling Error!!! Error Code:" + iM2514a);
            m2253b(true);
            return iM2514a;
        }
        if (MainApplication.mPhoneManager.getClientType() != 2 && destination.getDestinationType() != 4) {
            m2244a(this.f2481P);
        }
        m2252b("startOutGoingCall Handling Success!!!");
        if (this.f2481P.getAudioPathController() == null) {
            return iM2514a;
        }
        this.f2481P.getAudioPathController().initCallSwitching(z);
        this.f2481P.getAudioPathController().initUIComponents(true);
        return iM2514a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void startOutgoingCallForEngine() {
        int iM2555ao = this.f2481P.m2555ao();
        if (iM2555ao != 0) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
            MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
            m2246a("startOutgoingCallForEngine Handling Error!!! Error Code:" + iM2555ao);
            m2253b(true);
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void startPhoneStressTest(String str) {
        if (str.length() <= 4 || !str.startsWith("sip:")) {
            this.f2486aa = new Destination(2, String.valueOf(str) + CoolotsCode.ID_DOMAIN_COOLOTS);
        } else {
            this.f2486aa = new Destination(3, str.substring(4));
        }
        Message message = new Message();
        message.what = 10;
        message.arg2 = 10003;
        this.f2474I.sendMessageDelayed(message, 10000L);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void startPreventUMTSAlarm() {
        if (MainApplication.mPhoneManager.getPreventUMTSManager() != null) {
            MainApplication.mPhoneManager.getPreventUMTSManager().startPreventUMTSAlarm();
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int startRecognition() {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState()) || this.f2481P.m2582c().getDestinationType() != 2) {
            return 1;
        }
        m2252b("startRecognition");
        if (this.f2498x == null || this.f2499y == null || this.f2500z == null) {
            return 1;
        }
        this.f2498x.startRecognition();
        return 0;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int startRecordCall(Destination destination, boolean z, String str) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2513a(z, str)) != 0) {
            m2246a("startRecordCall Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public int startShareScreen(Destination destination, int i, int i2, String str) {
        m2252b("<<YHT7>> startShareScreen!!");
        return !m2254b(destination) ? PhoneStateMachine.ERROR_CANT_FIND_DESTINATION : !CallState.isConnected(this.f2481P.m2573b().getCallState()) ? PhoneStateMachine.ERROR_INVALID_STATE : this.f2481P.m2496a(i, i2, str);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void startShareView(Destination destination) {
        if (m2254b(destination) && CallState.isConnected(this.f2481P.m2573b().getCallState())) {
            this.f2481P.m2554an();
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void startStressTest() {
        Message message = new Message();
        message.what = 10;
        message.arg2 = 10003;
        this.f2474I.sendMessageDelayed(message, this.f2488ac);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean startTTSMode() {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState()) || this.f2481P.m2582c().getDestinationType() != 2) {
            return false;
        }
        m2252b("startTTSMode");
        EngineInterface.getInstance().sendRXMute(this.f2481P.m2487T(), true, false);
        return true;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int startTranslation(TranslationDisplayData translationDisplayData) {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState()) || this.f2481P.m2582c().getDestinationType() != 2) {
            return 1;
        }
        m2252b("startTranslation()");
        if (this.f2498x != null) {
            return this.f2498x.startTranslation(translationDisplayData);
        }
        return 1;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int startVideoCall(Destination destination, Camera camera, int i, int i2) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2505a(camera, i, i2)) != 0) {
            m2246a("startVideoCall Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int stopAvatar(Destination destination) {
        int iM2233a = m2233a(destination);
        return iM2233a != 0 ? iM2233a : this.f2481P.m2490W();
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int stopDualCamera(Destination destination) {
        if (destination != null) {
            return this.f2481P.m2481N();
        }
        m2246a("stopDualCamera : destination is NULL");
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int stopFileTransfer(Destination destination) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2553am()) != 0) {
            m2246a("stopFileTransfer Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int stopHideMeVideoCall(Destination destination) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2482O()) != 0) {
            m2246a("stopHideMeVideoCall Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void stopPhoneStressTest() {
        this.f2474I.removeMessages(10003);
        this.f2474I.removeMessages(10004);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int stopRecognition() {
        if (this.f2481P == null) {
            return 1;
        }
        if ((!CallState.isConnected(this.f2481P.m2573b().getCallState()) && !CallState.isDisconnected(this.f2481P.m2573b().getCallState())) || this.f2481P.m2582c().getDestinationType() != 2) {
            return 1;
        }
        m2252b("stopRecognition");
        if (this.f2498x == null || this.f2499y == null || this.f2500z == null) {
            return 1;
        }
        this.f2498x.stopRecognition();
        return 0;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int stopRecordCall(Destination destination) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2480M()) != 0) {
            m2246a("stopRecordCall Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.ShareScreenInterface
    public int stopShareScreen(Destination destination) {
        m2252b("<<YHT7>> stopShareScreen!!");
        return !m2254b(destination) ? PhoneStateMachine.ERROR_CANT_FIND_DESTINATION : !CallState.isConnected(this.f2481P.m2573b().getCallState()) ? PhoneStateMachine.ERROR_INVALID_STATE : this.f2481P.m2499a(0, this.f2497w);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void stopStressTest() {
        this.f2474I.removeMessages(10003);
        this.f2474I.removeMessages(10004);
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public boolean stopTTSMode() {
        if (this.f2481P == null || !CallState.isConnected(this.f2481P.m2573b().getCallState()) || this.f2481P.m2582c().getDestinationType() != 2) {
            return false;
        }
        m2252b("stopTTSMode");
        EngineInterface.getInstance().sendRXMute(this.f2481P.m2487T(), false, false);
        return true;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int stopVideoCall(Destination destination, Camera camera) {
        int iM2233a = m2233a(destination);
        if (iM2233a == 0 && (iM2233a = this.f2481P.m2504a(camera)) != 0) {
            m2246a("stopVideoCall Handling Error!!! Error Code:" + iM2233a);
            m2261g();
        }
        return iM2233a;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int switchDualCameraMode(Destination destination, int i, int i2, int i3, int i4) {
        if (destination != null) {
            return this.f2481P.m2567b(i, i2, i3, i4);
        }
        m2246a("switchDualCameraMode : destination is NULL");
        return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int unHoldCall(Destination destination) {
        if (destination == null) {
            m2246a("unHoldCall : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        if (iM2233a != 0) {
            return iM2233a;
        }
        int iM2607i = this.f2481P.m2607i(false);
        if (iM2607i == 0) {
            startRecognition();
            m2246a("unHoldCall Handling Success!!! Success Code:" + iM2607i);
            return iM2607i;
        }
        m2246a("unHoldCall Handling Error!!! Error Code:" + iM2607i);
        m2261g();
        return iM2607i;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public int unMuteCall(Destination destination) {
        if (destination == null) {
            m2246a("unMuteCall : destination is NULL");
            return PhoneStateMachine.ERROR_CANT_FIND_DESTINATION;
        }
        int iM2233a = m2233a(destination);
        if (iM2233a != 0) {
            return iM2233a;
        }
        int iM2587d = this.f2481P.m2587d(false);
        if (iM2587d == 0) {
            m2246a("unMuteCall Handling Success!!! Success Code:" + iM2587d);
            return iM2587d;
        }
        m2246a("unMuteCall Handling Error!!! Error Code:" + iM2587d);
        m2261g();
        return iM2587d;
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void unregistCallOutNumber(String str) {
        this.f2477L = "";
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void updateCallInfo(CallStatusData callStatusData) {
        synchronized (this.f2480O) {
            if (this.f2481P != null) {
                callStatusData.setValidity(true);
                callStatusData.setCallID(this.f2481P.m2487T());
                callStatusData.setCallState(this.f2481P.m2573b().getCallState());
                callStatusData.setIsCallAccept(this.f2481P.m2573b().isCallAccept());
                callStatusData.setIsOutGoingCall(this.f2481P.m2589d());
                callStatusData.setUseVideo(this.f2481P.isUseVideo());
                callStatusData.setDestination(this.f2481P.m2582c());
                callStatusData.setRemoteRotation(this.f2481P.m2546af());
                callStatusData.setRemoteRotations(this.f2481P.m2547ag());
                callStatusData.setPlayHoldTone(this.f2481P.m2617l());
                callStatusData.setPushSuccess(this.f2481P.m2488U());
                callStatusData.setSecureCommunication(this.f2481P.m2619m());
                callStatusData.setNoiseReduction(this.f2481P.m2621n());
                callStatusData.setEmotionalAnimationType(this.f2481P.m2622o());
                callStatusData.setAlwaysEmotioanl(this.f2481P.m2625p());
                callStatusData.setThemeShotType(this.f2481P.m2626q());
                callStatusData.setHostDisplayName(this.f2481P.m2596f());
                callStatusData.setAudioPathController(this.f2481P.getAudioPathController());
                callStatusData.setCallFunctionController(this.f2481P.m2556ap());
                callStatusData.setNegoFeatureController(this.f2481P.m2557aq());
                callStatusData.setDefaultHideMeImage(this.f2481P.m2630u());
                callStatusData.setHangupReason(this.f2481P.m2475H());
                callStatusData.setIsLiveShare(this.f2481P.m2471D());
                callStatusData.setDestDeviceID(this.f2481P.m2548ah());
                callStatusData.setUseDualCamera(this.f2481P.m2472E());
                callStatusData.setIs3GConnectType(this.f2481P.m2476I());
                callStatusData.setUseAvatar(this.f2481P.m2473F());
                callStatusData.setActiveShareScreen(this.f2481P.m2542ab());
                callStatusData.setIsCallTransforming(this.f2481P.m2562av());
            } else if (this.f2482Q == null) {
                callStatusData.setValidity(false);
            } else {
                callStatusData.setValidity(true);
                callStatusData.setCallID(this.f2482Q.m2487T());
                callStatusData.setCallState(3);
                callStatusData.setIsCallAccept(false);
                callStatusData.setIsOutGoingCall(this.f2482Q.m2589d());
                callStatusData.setUseVideo(this.f2482Q.isUseVideo());
                callStatusData.setDestination(this.f2482Q.m2582c());
                callStatusData.setRemoteRotation(this.f2482Q.m2546af());
                callStatusData.setRemoteRotations(this.f2482Q.m2547ag());
                callStatusData.setPlayHoldTone(this.f2482Q.m2617l());
                callStatusData.setPushSuccess(this.f2482Q.m2488U());
                callStatusData.setSecureCommunication(this.f2482Q.m2619m());
                callStatusData.setNoiseReduction(this.f2482Q.m2621n());
                callStatusData.setEmotionalAnimationType(this.f2482Q.m2622o());
                callStatusData.setAlwaysEmotioanl(this.f2482Q.m2625p());
                callStatusData.setThemeShotType(this.f2482Q.m2626q());
                callStatusData.setHostDisplayName(this.f2482Q.m2596f());
                callStatusData.setAudioPathController(this.f2482Q.getAudioPathController());
                callStatusData.setCallFunctionController(this.f2482Q.m2556ap());
                callStatusData.setNegoFeatureController(this.f2482Q.m2557aq());
                callStatusData.setDefaultHideMeImage(this.f2482Q.m2630u());
                callStatusData.setHangupReason(this.f2482Q.m2475H());
                callStatusData.setIsLiveShare(this.f2482Q.m2471D());
                callStatusData.setDestDeviceID(this.f2482Q.m2548ah());
                callStatusData.setUseDualCamera(this.f2482Q.m2472E());
                callStatusData.setIs3GConnectType(this.f2482Q.m2476I());
                callStatusData.setUseAvatar(this.f2482Q.m2473F());
                callStatusData.setActiveShareScreen(this.f2482Q.m2542ab());
                callStatusData.setIsCallTransforming(this.f2482Q.m2562av());
            }
        }
    }

    @Override // com.sds.coolots.call.PhoneStateMachine
    public void updateMobilePhoneState() {
        this.f2484U.updateMobilePhoneState();
    }
}
