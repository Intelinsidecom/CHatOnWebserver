package com.sds.coolots.call.model;

import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.model.ConferenceInfo;
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
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.CallFunctionControllerInterface;
import com.sds.coolots.call.CallingInterface;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.model.watch.IWatchCallbackInterface;
import com.sds.coolots.call.nego.NegoFeatureControllerInterface;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.controller.EngineCallBackInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface;
import com.sds.coolots.common.controller.audiopath.C1242a;
import com.sds.coolots.common.coolotsinterface.ISSOCallCallBack;
import com.sds.coolots.common.coolotsinterface.VoipStateController;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.C1260a;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.sds.coolots.call.model.g */
/* loaded from: classes.dex */
public class C1205g implements CallInstanceInterface {

    /* renamed from: a */
    public static final int f2660a = -1;

    /* renamed from: r */
    private static final int f2661r = 12001;

    /* renamed from: s */
    private static final int f2662s = 2000;

    /* renamed from: g */
    protected boolean f2669g;

    /* renamed from: i */
    protected Date f2671i;

    /* renamed from: j */
    protected Date f2672j;

    /* renamed from: k */
    protected ISSOCallCallBack f2673k;

    /* renamed from: l */
    protected IWatchCallbackInterface f2674l;

    /* renamed from: p */
    private Call f2678p;

    /* renamed from: q */
    private final EngineCallBackInterface f2679q;

    /* renamed from: v */
    private C1202d f2682v;

    /* renamed from: e */
    protected final Object f2667e = new Object();

    /* renamed from: h */
    protected boolean f2670h = false;

    /* renamed from: t */
    private final Handler f2680t = new HandlerC1206h(this);

    /* renamed from: u */
    private CallingInterface f2681u = null;

    /* renamed from: m */
    protected String f2675m = "";

    /* renamed from: n */
    protected String f2676n = "";

    /* renamed from: w */
    private final C1192G f2683w = new C1192G();

    /* renamed from: x */
    private final C1209k f2684x = new C1209k();

    /* renamed from: y */
    private final C1208j f2685y = new C1208j();

    /* renamed from: o */
    protected boolean f2677o = false;

    /* renamed from: z */
    private AudioManager f2686z = null;

    /* renamed from: A */
    private final Object f2663A = new Object();

    /* renamed from: b */
    protected C1207i f2664b = new C1207i();

    /* renamed from: f */
    protected CallState f2668f = new CallState();

    /* renamed from: d */
    protected AudioPathControllerInterface f2666d = new C1242a();

    /* renamed from: c */
    protected VoipStateController f2665c = MainApplication.mNativeInterfaceCreator.createVoipStateController();

    public C1205g(Destination destination, ConferenceInfo conferenceInfo, EngineCallBackInterface engineCallBackInterface, String str, String str2, boolean z, ISSOCallCallBack iSSOCallCallBack, IWatchCallbackInterface iWatchCallbackInterface, boolean z2) {
        this.f2669g = true;
        this.f2671i = null;
        this.f2672j = null;
        this.f2671i = new Date();
        this.f2669g = z2;
        this.f2679q = engineCallBackInterface;
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            switch (destination.getDestinationType()) {
                case 2:
                    this.f2678p = new C1193H(destination, this.f2668f, z2, this);
                    break;
                case 3:
                    this.f2678p = new C1198M(destination, this.f2668f, z2, this);
                    break;
                case 4:
                    this.f2678p = new C1217s(destination, conferenceInfo, str, str2, this.f2668f, z2, this);
                    break;
                default:
                    this.f2678p = new C1196K(destination, this.f2668f, z2, this);
                    break;
            }
        } else {
            this.f2678p = new C1199a(destination, conferenceInfo, str, str2, this.f2668f, z2, this);
        }
        if (z) {
            this.f2685y.f2694e = C1208j.f2691b;
        } else {
            this.f2685y.f2694e = C1208j.f2690a;
        }
        this.f2673k = iSSOCallCallBack;
        this.f2674l = iWatchCallbackInterface;
        this.f2672j = null;
    }

    /* renamed from: a */
    private int m2457a(String str, List list, ConferenceInfo conferenceInfo, String str2, String str3) {
        m2467i("createConferenceCallInstance() " + str);
        Destination destination = new Destination(str, list, (String) null);
        this.f2678p = new C1217s(destination, conferenceInfo, str2, str3, m2573b(), m2589d(), this);
        m2467i("call instance is created!!!!");
        m2564ax();
        MainApplication.mPhoneManager.getHardwareManager().setModeStopHold(isUseVideo());
        int iM2714P = ((C1217s) this.f2678p).m2714P();
        if (iM2714P == 0) {
            m2467i("startChangedConferenceCall Handling Success!!!");
            if (this.f2674l != null) {
                this.f2674l.notifyChangeP2PToConfCall(destination, isUseVideo());
            }
        } else {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopAllStream();
            MainApplication.mPhoneManager.getHardwareManager().setModeDisconnected(false);
            m2466h("startOutGoingCall Handling Error!!! Error Code:" + iM2714P);
            m2462aE();
            m2463aF();
        }
        return 0;
    }

    /* renamed from: aC */
    private void m2460aC() {
        this.f2684x.f2706g++;
        m2467i("increaseDualCameraCnt >> " + this.f2684x.f2706g);
    }

    /* renamed from: aD */
    private void m2461aD() {
        m2467i("updateProximity()");
        if (this.f2686z == null) {
            this.f2686z = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if ((!MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().isProximitySensorActive() || this.f2686z.isSpeakerphoneOn() || !m2589d() || CallState.isDisconnected(this.f2668f.getCallState())) && (m2589d() || !CallState.isConnected(this.f2668f.getCallState()))) {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
        } else {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireLockForProximity();
        }
    }

    /* renamed from: aE */
    private void m2462aE() {
        if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
            MainApplication.mPhoneManager.getDataUsageManager().notifyEndCall(m2589d(), isUseVideo(), m2560at());
        }
    }

    /* renamed from: aF */
    private synchronized void m2463aF() {
        m2467i("clearCallInstance()");
        m2564ax();
        synchronized (this.f2663A) {
            if (CallState.isDisconnected(m2573b().getCallState())) {
                m2478K();
                unregistVoipCallState();
                MainApplication.mConfig.setCallState(false);
                if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
                    MainApplication.mPhoneManager.getCoolotsEventListener().onCallState(false);
                }
            } else {
                m2573b().setCallState(3);
            }
            if (this.f2674l != null) {
                this.f2674l.setCallReceiveFromWatch(false);
            }
        }
    }

    /* renamed from: d */
    private void m2464d(ArrayList arrayList) {
        ArrayList arrayListM2987a = C1260a.m2987a(arrayList);
        if (this.f2678p.m2337b() == null) {
            m2467i("<CIH> mNegoFeatureController should be not null.");
        } else {
            this.f2678p.m2337b().setResult(arrayListM2987a);
        }
    }

    /* renamed from: f */
    private int m2465f(int i, int i2) {
        return 1 << (Call.THEMESHOT_SHIFT_INDEX[i] + i2);
    }

    /* renamed from: h */
    private void m2466h(String str) {
        Log.m2958e("[CallInstance]" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m2467i(String str) {
        Log.m2963i("[CallInstance]" + str);
    }

    /* renamed from: A */
    public boolean m2468A() {
        return this.f2684x.f2715p;
    }

    /* renamed from: B */
    public int m2469B() {
        m2467i("getDualCameraCnt: " + this.f2684x.f2706g);
        return this.f2684x.f2706g;
    }

    /* renamed from: C */
    public boolean m2470C() {
        return this.f2684x.f2719t;
    }

    /* renamed from: D */
    public boolean m2471D() {
        return this.f2684x.f2720u;
    }

    /* renamed from: E */
    public boolean m2472E() {
        return this.f2684x.f2705f;
    }

    /* renamed from: F */
    public boolean m2473F() {
        return this.f2684x.f2711l;
    }

    /* renamed from: G */
    public Date m2474G() {
        return this.f2684x.f2707h;
    }

    /* renamed from: H */
    public int m2475H() {
        m2467i("getHangupCode() " + this.f2678p.m2366i());
        return this.f2678p.m2366i();
    }

    /* renamed from: I */
    public boolean m2476I() {
        return this.f2685y.f2697h;
    }

    /* renamed from: J */
    public void m2477J() {
        if (PhoneManager.is3GNetworkConnected(MainApplication.mContext)) {
            this.f2685y.f2697h = true;
        } else {
            this.f2685y.f2697h = false;
        }
    }

    /* renamed from: K */
    public void m2478K() {
        MainApplication.mCallNotification.deleteCallNotification();
        m2583c(EventCode.EVENT_CALL_HANGUP);
    }

    /* renamed from: L */
    protected void m2479L() {
        m2467i("sendIntent()");
        Intent callIntent = MainApplication.mCallIntentGenerator.getCallIntent(isUseVideo(), this.f2684x.f2720u, isSIPCall());
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

    /* renamed from: M */
    public int m2480M() throws IOException {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2466h("stopRecordCall State Check Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2678p.m2313a().isRecordingProcessing()) {
            return PhoneStateMachine.ERROR_NOT_RECORDING;
        }
        EngineInterface.getInstance().stopRecordCall(this.f2678p.m2355e(), (this.f2678p.m2359f().getDestinationType() == 5 || this.f2678p.m2359f().getDestinationType() == 2) ? false : true);
        this.f2678p.m2313a().setRecordingProcessing(false);
        return 0;
    }

    /* renamed from: N */
    public int m2481N() {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2466h("stopDualCamera State Setting Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2684x.f2705f = false;
        m2467i("stopDualCamera(" + this.f2684x.f2705f + ")");
        if (EngineInterface.getInstance().stopDualCamera(this.f2678p.m2355e()) == 1) {
            m2583c(EventCode.EVENT_DUAL_CAMERA_STOP);
            return 0;
        }
        m2466h("startDualCamera() Fail to stop dual camera!!!!");
        return 0;
    }

    /* renamed from: O */
    public int m2482O() {
        boolean z = this.f2678p.m2359f().getDestinationType() != 2;
        if (!z && this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (CallState.isDisconnected(this.f2668f.getCallState())) {
            m2466h("stopHideMeVideoCall State Check Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        EngineInterface.getInstance().stopHideMeVideoCall(this.f2678p.m2355e(), z);
        this.f2684x.f2709j = false;
        this.f2684x.f2708i = false;
        m2467i("stopHideMeVideoCall: " + this.f2684x.f2708i);
        return 0;
    }

    /* renamed from: P */
    public void m2483P() {
        m2583c(EventCode.EVENT_CALL_CAPTURE_IMAGE);
    }

    /* renamed from: Q */
    public void m2484Q() {
        m2466h("notiCameraError() Camera 경통 error");
        if (getCallingActivity() != null) {
            Message message = new Message();
            message.what = EventCode.EVENT_CAMERA_ZOOM_ERROR;
            m2519a(message, false);
        }
    }

    /* renamed from: R */
    public void m2485R() {
        m2467i("receiveHangupCallEntitlement()");
        Message message = new Message();
        message.what = 27;
        m2519a(message, false);
    }

    /* renamed from: S */
    public void m2486S() {
        m2467i("receiveNetworkErrorHangupCallEntitlement");
        Message message = new Message();
        message.what = 28;
        m2519a(message, false);
    }

    /* renamed from: T */
    public int m2487T() {
        return this.f2678p.m2355e();
    }

    /* renamed from: U */
    public boolean m2488U() {
        return this.f2678p.m2369j();
    }

    /* renamed from: V */
    public int m2489V() {
        return this.f2678p.mo2372m();
    }

    /* renamed from: W */
    public int m2490W() {
        return this.f2678p.mo2373n();
    }

    /* renamed from: X */
    public int m2491X() {
        return this.f2678p.mo2374o();
    }

    /* renamed from: Y */
    public int m2492Y() {
        return this.f2678p.mo2375p();
    }

    /* renamed from: Z */
    public int m2493Z() {
        return this.f2678p.mo2376q();
    }

    /* renamed from: a */
    public int m2494a(int i, int i2, int i3) throws IOException {
        if (i2 == -1) {
            i2 = 1;
        }
        switch (i) {
            case 0:
                break;
            case 1:
            default:
                i3 |= -256;
                break;
            case 2:
                i3 |= -1474816;
                break;
        }
        EngineInterface.getInstance().setPreviewOutLineStatus(this.f2678p.m2355e(), i, i3, i2);
        return 0;
    }

    /* renamed from: a */
    public int m2495a(int i, int i2, int i3, int i4) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2466h("startDualCamera State Setting Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2684x.f2705f = true;
        m2460aC();
        m2467i("startDualCamera(" + this.f2684x.f2705f + ")");
        if (EngineInterface.getInstance().startDualCamera(this.f2678p.m2355e(), i, i2, i3, i4) == 1) {
            m2583c(EventCode.EVENT_DUAL_CAMERA_START);
        } else {
            m2466h("startDualCamera() Fail to start dual camera!!!!");
        }
        return 0;
    }

    /* renamed from: a */
    public int m2496a(int i, int i2, String str) {
        return this.f2678p.m2297a(i, i2, str);
    }

    /* renamed from: a */
    public int m2497a(int i, int i2, Date date) throws IOException {
        if (!(this.f2678p instanceof C1217s) && !(this.f2678p instanceof C1214p)) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (MainApplication.mConfig.isPlayRingBackTone()) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopRingBackTone();
        }
        if (this.f2678p instanceof C1217s) {
            m2549ai();
            this.f2678p = new C1214p(this.f2678p.m2359f(), this.f2668f, this.f2678p.mo2370k(), this, this.f2678p.m2355e());
        }
        if (getSSOCallCallback() != null) {
            getSSOCallCallback().onCallState(100);
        }
        m2467i("changeToP2P");
        ArrayList conferenceMember = this.f2678p.m2359f().getConferenceMember();
        if (this.f2678p instanceof C1214p) {
            m2467i("changeToP2P call type is ChangeToP2P");
            int iMo2299a = this.f2678p.mo2299a(i, date);
            if (iMo2299a != 0) {
                return iMo2299a;
            }
            this.f2675m = C1214p.m2671b(this.f2678p.m2359f());
            this.f2678p = new C1193H(new Destination(2, C1214p.m2667a(this.f2678p.m2359f())), this.f2668f, this.f2678p.mo2370k(), this, i);
            if (this.f2670h) {
                this.f2678p.m2314a(2);
            } else {
                this.f2678p.m2314a(1);
            }
            m2464d(conferenceMember);
            MainApplication.mPhoneManager.getHardwareManager().setModeStopHold(this.f2670h);
            if (m2470C()) {
                this.f2678p.m2354d(m2470C());
            }
        }
        return 0;
    }

    /* renamed from: a */
    public int m2498a(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2466h("setThemeShot State Setting Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        m2467i("setThemeShot(" + i + ", " + i2 + ")");
        if (i == -1) {
            this.f2684x.f2703d = 0;
            z2 = false;
            i4 = 0;
            i3 = -1;
        } else {
            int i5 = Call.THEMESHOT_SHIFT_INDEX[i] + 0 + i2;
            if (z) {
                int iM2465f = m2465f(i, i2);
                if ((this.f2684x.f2703d & iM2465f) == 0) {
                    this.f2684x.f2703d |= iM2465f;
                    i3 = i5;
                    i4 = iM2465f;
                    z2 = true;
                } else {
                    this.f2684x.f2703d &= iM2465f ^ (-1);
                    i3 = i5;
                    i4 = iM2465f;
                    z2 = false;
                }
            } else {
                z2 = false;
                i3 = i5;
                i4 = 0;
            }
        }
        m2467i("themeCode: " + i3 + ", mask: " + i4 + ", mThemeShotType: " + this.f2684x.f2703d + ", isTurnOn: " + z2 + " mHideMeModeType: " + this.f2684x.f2708i);
        if (EngineInterface.getInstance().setThemeShot(this.f2678p.m2355e(), this.f2678p.m2291J() ? false : true, i3, z2) == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        return 0;
    }

    /* renamed from: a */
    public int m2499a(int i, String str) {
        return this.f2678p.m2335b(i, str);
    }

    /* renamed from: a */
    public int m2500a(int i, String str, String str2) {
        if (!(this.f2678p instanceof C1193H)) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (getSSOCallCallback() != null) {
            getSSOCallCallback().onCallState(101);
        }
        m2556ap().setPrepareChageToConf(true);
        m2549ai();
        m2583c(EventCode.EVENT_CHANGE_TO_CONFERENCE_START);
        this.f2678p = new C1212n(m2582c(), this.f2668f, m2589d(), this, m2487T());
        ((C1212n) this.f2678p).m2661b(str, str2);
        if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
            MainApplication.mPhoneManager.getDataUsageManager().notifyStartCall(getInitiateCallType());
        }
        return 0;
    }

    /* renamed from: a */
    public int m2501a(int i, boolean z) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2467i("setEmotionalAnimation State Setting Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2684x.f2700a = z;
        if (z || i == -1) {
            this.f2684x.f2701b = i;
        }
        m2467i("setEmotionalAnimation mHideMeModeType: " + this.f2684x.f2708i + " mEmotionalAnimationType: " + this.f2684x.f2701b + " nType: " + i);
        if (this.f2684x.f2708i) {
            return 0;
        }
        if (EngineInterface.getInstance().setEmotionalAnimation(this.f2678p.m2355e(), !this.f2678p.m2291J(), i, z) == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        return 0;
    }

    /* renamed from: a */
    public int m2502a(int i, byte[] bArr) {
        return this.f2678p.mo2300a(i, bArr);
    }

    /* renamed from: a */
    public int m2503a(Point point, boolean z) {
        return this.f2678p.mo2301a(point, z);
    }

    /* renamed from: a */
    public int m2504a(Camera camera) {
        return this.f2678p.m2302a(camera);
    }

    /* renamed from: a */
    public int m2505a(Camera camera, int i, int i2) {
        return this.f2678p.m2303a(camera, i, i2);
    }

    /* renamed from: a */
    public int m2506a(NotifyBoardDataAsk notifyBoardDataAsk) {
        return this.f2678p.mo2304a(notifyBoardDataAsk);
    }

    /* renamed from: a */
    public int m2507a(String str) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isDisconnected(this.f2668f.getCallState())) {
            return (this.f2678p.m2378s() == null || EngineInterface.getInstance().captureImage(this.f2678p.m2355e(), this.f2678p.m2359f().getDestinationType() != 2, str) >= 0) ? 0 : -1;
        }
        m2467i("startHideMeVideoCall State Check Error!!! current state:" + this.f2668f.getStateDescription());
        return PhoneStateMachine.ERROR_INVALID_STATE;
    }

    /* renamed from: a */
    public int m2508a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (this.f2678p.m2355e() == -1 && this.f2678p.m2359f().getDestinationType() != 4) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (CallState.isDisconnected(this.f2668f.getCallState())) {
            m2466h("startHideMeVideoCall State Check Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2684x.f2708i = true;
        m2467i("startHideMeVideoCall : " + this.f2684x.f2708i);
        if (this.f2684x.f2703d != 0) {
            m2498a(-1, -1, true);
        }
        EngineInterface.getInstance().setEmotionalAnimation(this.f2678p.m2355e(), !this.f2678p.m2291J(), -1, false);
        if (this.f2684x.f2704e == 0) {
            EngineInterface.getInstance().setCartoonView(this.f2678p.m2355e(), !this.f2678p.m2291J(), -1);
        }
        this.f2684x.f2710k = z;
        EngineInterface.getInstance().startHideMeVideoCall(this.f2678p.m2355e(), byteBuffer, i, i2, (this.f2678p.m2359f().getDestinationType() == 2 || this.f2678p.m2359f().getDestinationType() == 5) ? false : true, i3, i4, z2);
        this.f2684x.f2709j = true;
        return 0;
    }

    /* renamed from: a */
    public int m2509a(ArrayList arrayList, ArrayList arrayList2) {
        m2467i("changeMember");
        if (this.f2678p instanceof C1212n) {
            m2467i("ChangeToConference instance");
            return PhoneStateMachine.ERROR_INVITE_BUDDY_CALL_SWITCHING;
        }
        if (this.f2678p instanceof C1193H) {
            m2467i("P2PCall instance");
            m2549ai();
            this.f2678p = new C1212n(m2582c(), this.f2668f, m2589d(), this, m2487T());
            return this.f2678p.mo2346c(arrayList);
        }
        if ((this.f2678p instanceof C1217s) || (this.f2678p instanceof C1196K)) {
            m2467i("ConferenceCall or P2PConferenceCall instance");
            return this.f2678p.mo2308a(arrayList, arrayList2);
        }
        m2466h("Call instance is wrong");
        return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    /* renamed from: a */
    public int m2510a(List list) {
        return ((C1193H) this.f2678p).m2428d(list);
    }

    /* renamed from: a */
    public int m2511a(short s, boolean z, int i, boolean z2, boolean z3, String str) {
        if (this.f2674l == null) {
            m2467i("[SWatch] - WatchManagerCall is Null");
        } else if (this.f2678p.m2359f().getDestinationType() == 2) {
            this.f2674l.NotifyP2PCallRinging(this.f2678p.m2359f(), z);
        } else if (this.f2678p.m2359f().getDestinationType() == 4) {
            this.f2674l.NotifyConferenceCallRinging(this.f2678p.m2359f(), z);
        }
        this.f2675m = str;
        return this.f2678p.mo2309a(s, z, i, z2, z3, str);
    }

    /* renamed from: a */
    public int m2512a(boolean z, int i, boolean z2, String str) {
        m2467i("haeri=connectCall");
        if (this.f2674l == null) {
            m2467i("[SWatch] - WatchManagerCall is Null");
        } else if (this.f2678p.mo2370k()) {
            if (z) {
                this.f2674l.NotifyCallConnected(this.f2678p.m2359f());
            } else {
                this.f2674l.NotifyCallDisconnected(this.f2678p.m2359f(), i);
            }
        } else if (z) {
            this.f2674l.NotifyCallConnected(this.f2678p.m2359f());
        } else {
            this.f2674l.NotifyCallDisconnected(this.f2678p.m2359f(), i);
        }
        return this.f2678p.mo2311a(z, i, z2, str);
    }

    /* renamed from: a */
    public int m2513a(boolean z, String str) throws IOException {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2466h("startRecordCall State Check Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (this.f2678p.m2313a().isRecordingProcessing()) {
            return PhoneStateMachine.ERROR_ALREADY_RECORDING;
        }
        EngineInterface.getInstance().startRecordCall(this.f2678p.m2355e(), (this.f2678p.m2359f().getDestinationType() == 5 || this.f2678p.m2359f().getDestinationType() == 2) ? false : true, z, str);
        this.f2678p.m2313a().setRecordingProcessing(true);
        return 0;
    }

    /* renamed from: a */
    public int m2514a(boolean z, boolean z2, String str) {
        if (this.f2674l == null) {
            m2467i("[SWatch] - WatchManagerCall is Null");
        } else if (this.f2678p.m2359f().getDestinationType() == 2) {
            this.f2674l.NotifyP2PCallOutFromPhone(this.f2678p.m2359f(), z);
        } else if (this.f2678p.m2359f().getDestinationType() == 4) {
            this.f2674l.NotifyConfCallOutFromPhone(this.f2678p.m2359f(), z);
        }
        return this.f2678p.mo2312a(z, z2, str);
    }

    /* renamed from: a */
    public VoipStateController m2515a() {
        return this.f2665c;
    }

    /* renamed from: a */
    public void m2516a(int i) {
        m2467i("broadcastToCallBack()");
        MainApplication.mPhoneManager.getPhoneStateMachine().broadcastToCallStateCallBack(i);
    }

    /* renamed from: a */
    public void m2517a(int i, boolean z, boolean z2) {
        this.f2678p.mo2317a(i, z, z2);
    }

    /* renamed from: a */
    public void m2518a(int i, boolean z, boolean z2, String str) {
        Message message = new Message();
        ConsentDisplayInfo consentDisplayInfo = new ConsentDisplayInfo();
        if (i == 1) {
            consentDisplayInfo.isAccept = true;
            consentDisplayInfo.requesterID = str;
        } else {
            consentDisplayInfo.isAccept = false;
            consentDisplayInfo.rejecterID = str;
        }
        consentDisplayInfo.isSender = z2;
        consentDisplayInfo.isTimeout = z;
        message.obj = consentDisplayInfo;
        m2519a(message, false);
    }

    /* renamed from: a */
    public void m2519a(Message message, boolean z) {
        m2467i("sendEvent()! event type:" + message.what);
        if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
            MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
        } else if (getCallingActivity() != null) {
            getCallingActivity().sendHandlerMessage(message, 0L);
        } else if (z) {
            m2479L();
        }
    }

    /* renamed from: a */
    public void m2520a(NotifyConsentAsk notifyConsentAsk) {
        this.f2678p.mo2320a(notifyConsentAsk);
    }

    /* renamed from: a */
    public void m2521a(NotifyFinishShareCameraAsk notifyFinishShareCameraAsk) {
        this.f2678p.mo2321a(notifyFinishShareCameraAsk);
    }

    /* renamed from: a */
    public void m2522a(ProposeConsentAsk proposeConsentAsk) {
        this.f2678p.mo2322a(proposeConsentAsk);
    }

    /* renamed from: a */
    public void m2523a(ProposeConsentRep proposeConsentRep) {
        this.f2678p.mo2323a(proposeConsentRep);
    }

    /* renamed from: a */
    public void m2524a(ReqAddConferenceMemberRep reqAddConferenceMemberRep) {
        ((C1193H) this.f2678p).mo2324a(reqAddConferenceMemberRep);
    }

    /* renamed from: a */
    public void m2525a(RequestConsentAsk requestConsentAsk) {
        this.f2678p.mo2325a(requestConsentAsk);
    }

    /* renamed from: a */
    public void m2526a(RequestConsentRep requestConsentRep) {
        this.f2678p.mo2326a(requestConsentRep);
    }

    /* renamed from: a */
    public void m2527a(ShareScreenCallback shareScreenCallback) {
        this.f2678p.m2327a(shareScreenCallback);
    }

    /* renamed from: a */
    public void m2528a(ISSOCallCallBack iSSOCallCallBack) {
        this.f2673k = iSSOCallCallBack;
    }

    /* renamed from: a */
    public void m2529a(String str, String str2) {
        this.f2678p.mo2328a(str, str2);
    }

    /* renamed from: a */
    public void m2530a(String str, String str2, int i) {
        Message message = new Message();
        message.what = EventCode.EVENT_TRANSLATE_DATA_RECEIVE;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        message.arg1 = i;
        message.obj = arrayList;
        synchronized (this.f2667e) {
            if (getCallingActivity() != null) {
                m2467i("notiTranslateDataReceive!!!!! msg.whar:" + message.what);
                getCallingActivity().sendHandlerMessage(message, 0L);
            }
        }
    }

    /* renamed from: a */
    public void m2531a(String str, String str2, String str3) {
        this.f2678p.m2329a(str, str2, str3);
    }

    /* renamed from: a */
    public void m2532a(ArrayList arrayList) {
        Message message = new Message();
        message.what = EventCode.EVENT_FILE_RECV_DONE;
        message.obj = arrayList;
        synchronized (this.f2667e) {
            if (getCallingActivity() != null) {
                m2467i("notiRecvFileDone!!!!! msg.whar:" + message.what);
                getCallingActivity().sendHandlerMessage(message, 0L);
            }
        }
    }

    /* renamed from: a */
    public void m2533a(Date date) {
        this.f2684x.f2707h = date;
    }

    /* renamed from: a */
    public void m2534a(short s) {
        this.f2678p.m2331a(s);
    }

    /* renamed from: a */
    public void m2535a(boolean z) {
        this.f2684x.f2719t = z;
    }

    /* renamed from: a */
    public void m2536a(boolean z, int i) {
        this.f2678p.mo2342b(z, i);
    }

    /* renamed from: a */
    public void m2537a(boolean z, boolean z2, boolean z3) {
        if (this.f2682v != null) {
            return;
        }
        this.f2682v = new C1202d();
        this.f2682v.f2652a = z;
        this.f2682v.f2653b = z3;
        this.f2682v.f2654c = z2;
    }

    /* renamed from: a */
    public boolean m2538a(int i, int i2) {
        return (this.f2684x.f2703d & m2465f(i, i2)) != 0;
    }

    /* renamed from: aA */
    public void m2539aA() {
        if (this.f2674l != null) {
            this.f2674l.notifyStopRingtone(this.f2678p.m2359f());
        }
    }

    /* renamed from: aB */
    public boolean m2540aB() {
        if (this.f2674l != null) {
            return this.f2674l.isCallReceiveFromWatch();
        }
        return false;
    }

    /* renamed from: aa */
    public void m2541aa() {
        this.f2678p.m2377r();
    }

    /* renamed from: ab */
    public int m2542ab() {
        return this.f2678p.m2380u();
    }

    /* renamed from: ac */
    public void m2543ac() {
        this.f2678p.m2381v();
    }

    /* renamed from: ad */
    protected void m2544ad() {
        this.f2678p.m2382w();
    }

    /* renamed from: ae */
    public void m2545ae() {
        this.f2678p.m2384y();
    }

    /* renamed from: af */
    public int m2546af() {
        return this.f2678p.m2385z();
    }

    /* renamed from: ag */
    public int[] m2547ag() {
        return this.f2678p.m2282A();
    }

    /* renamed from: ah */
    public short m2548ah() {
        return this.f2678p.m2283B();
    }

    /* renamed from: ai */
    protected void m2549ai() {
        this.f2678p.mo2285D();
    }

    /* renamed from: aj */
    public int m2550aj() {
        return this.f2678p.mo2287F();
    }

    /* renamed from: ak */
    public void m2551ak() {
        Message message = new Message();
        message.what = EventCode.EVENT_FILE_SEND_START;
        synchronized (this.f2667e) {
            if (getCallingActivity() != null) {
                m2467i("notiSendFileStart!!!!! msg.whar:" + message.what);
                getCallingActivity().sendHandlerMessage(message, 0L);
            }
        }
    }

    /* renamed from: al */
    public void m2552al() {
        Message message = new Message();
        message.what = EventCode.EVENT_FILE_SEND_DONE;
        synchronized (this.f2667e) {
            if (getCallingActivity() != null) {
                m2467i("notiSendFileDone!!!!! msg.whar:" + message.what);
                getCallingActivity().sendHandlerMessage(message, 0L);
            }
        }
    }

    /* renamed from: am */
    public int m2553am() {
        return this.f2678p.m2292K();
    }

    /* renamed from: an */
    public void m2554an() {
        this.f2678p.mo2296O();
    }

    /* renamed from: ao */
    public int m2555ao() {
        return this.f2678p.mo2289H();
    }

    /* renamed from: ap */
    public CallFunctionControllerInterface m2556ap() {
        return this.f2678p.m2313a();
    }

    /* renamed from: aq */
    public NegoFeatureControllerInterface m2557aq() {
        return this.f2678p.m2337b();
    }

    /* renamed from: ar */
    public boolean m2558ar() {
        return this.f2678p.m2291J();
    }

    /* renamed from: as */
    public boolean m2559as() {
        return this.f2678p instanceof C1193H;
    }

    /* renamed from: at */
    public boolean m2560at() {
        return this.f2678p instanceof C1217s;
    }

    /* renamed from: au */
    public boolean m2561au() {
        return this.f2678p instanceof C1214p;
    }

    /* renamed from: av */
    public boolean m2562av() {
        return this.f2678p.mo2379t();
    }

    /* renamed from: aw */
    public ArrayList m2563aw() {
        return this.f2678p.m2293L();
    }

    /* renamed from: ax */
    public void m2564ax() {
        synchronized (this.f2663A) {
            m2467i("---------------------------------");
            m2467i("CURRENT CALL INFO");
            m2467i("callID:" + m2487T());
            m2467i("destination type:" + m2582c().getDestinationTypeString());
            m2467i("call state:" + CallState.getCallStateDescription(m2573b().getCallState()));
            m2467i("---------------------------------");
        }
    }

    /* renamed from: ay */
    public void m2565ay() {
        m2467i("receiveCameraStartError()");
        m2583c(EventCode.EVENT_CAMERA_START_ERROR);
    }

    /* renamed from: az */
    public void m2566az() {
        if (this.f2674l != null) {
            this.f2674l.notifyChangeConfToP2PCall(this.f2678p.m2359f(), isUseVideo());
        }
    }

    /* renamed from: b */
    public int m2567b(int i, int i2, int i3, int i4) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2466h("switchDualCamera State Setting Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2684x.f2705f) {
            m2466h("switchDualCamera() : It is not dual camera mode!!!");
            return PhoneStateMachine.ERROR_NOT_DUAL_CAMERA_MODE;
        }
        m2467i("switchDualCamera(" + this.f2684x.f2705f + ")");
        EngineInterface.getInstance().switchDualCamera(this.f2678p.m2355e(), i, i2, i3, i4);
        return 0;
    }

    /* renamed from: b */
    public int m2568b(int i, String str) {
        if (this.f2674l != null) {
            this.f2674l.NotifyCallDisconnected(this.f2678p.m2359f(), i);
        } else {
            m2467i("[SWatch] - WatchManagerCall is Null");
        }
        return this.f2678p.mo2298a(i, str);
    }

    /* renamed from: b */
    public int m2569b(int i, boolean z) {
        m2466h("changeToConference()");
        MainApplication.mPhoneManager.getHardwareManager().getSoundManager().playRingBackTone();
        if (!(this.f2678p instanceof C1212n)) {
            m2466h("changeToConference() invalid call type");
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (getSSOCallCallback() != null) {
            getSSOCallCallback().onCallState(101);
        }
        if (m2487T() != i) {
            m2466h("changeToConference() getCallID() != callID " + m2487T() + ", " + i);
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!z) {
            m2583c(EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE);
            this.f2678p.mo2290I();
            return PhoneStateMachine.ERROR_INVALID_CHANGE_TO_CONFERENCE_ENGINE_RESPONSE;
        }
        MakeConferenceRep makeConferenceRepM2659P = ((C1212n) this.f2678p).m2659P();
        m2457a(makeConferenceRepM2659P.getConferenceInfo().getConferenceNo(), makeConferenceRepM2659P.getSimpleUserInfoList(), makeConferenceRepM2659P.getConferenceInfo(), makeConferenceRepM2659P.getP2PKey(), MainApplication.mConfig.getProfileUserID());
        if (MainApplication.mPhoneManager.getDataUsageManager() != null) {
            MainApplication.mPhoneManager.getDataUsageManager().notifyStartCall(getInitiateCallType());
        }
        return 0;
    }

    /* renamed from: b */
    public int m2570b(String str) throws IOException {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (CallState.isDisconnected(this.f2668f.getCallState())) {
            m2467i("startHideMeVideoCall State Check Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        EngineInterface.getInstance().captureShareScreenImage(this.f2678p.m2355e(), this.f2678p.m2359f().getDestinationType() != 2, str);
        return 0;
    }

    /* renamed from: b */
    public int m2571b(ArrayList arrayList) {
        return this.f2678p.m2307a(arrayList);
    }

    /* renamed from: b */
    public int m2572b(boolean z, int i) {
        return this.f2678p.mo2310a(z, i);
    }

    /* renamed from: b */
    public CallState m2573b() {
        return this.f2668f;
    }

    /* renamed from: b */
    public void m2574b(int i) {
        this.f2685y.f2694e = i;
    }

    /* renamed from: b */
    public void m2575b(int i, int i2) {
        m2467i("receiveRemoteMuteState");
        if (MainApplication.mPhoneManager.isUseMuteNotification()) {
            m2583c(i == 0 ? i2 == 0 ? EventCode.EVENT_REMOTE_CALL_UNMUTE : EventCode.EVENT_REMOTE_VIDEO_CALL_UNMUTE : i2 == 0 ? EventCode.EVENT_REMOTE_CALL_MUTE : EventCode.EVENT_REMOTE_VIDEO_CALL_MUTE);
        }
    }

    /* renamed from: b */
    public void m2576b(int i, int i2, String str) {
        this.f2678p.m2349c(i, i2, str);
    }

    /* renamed from: b */
    public void m2577b(boolean z) {
        this.f2684x.f2720u = z;
    }

    /* renamed from: c */
    public int m2578c(int i, int i2) {
        return this.f2678p.mo2345c(i, i2);
    }

    /* renamed from: c */
    public int m2579c(int i, int i2, int i3, int i4) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2466h("setDualPosition State Setting Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        if (!this.f2684x.f2705f) {
            m2466h("setDualPosition() : It is not dual camera mode!!!");
            return PhoneStateMachine.ERROR_NOT_DUAL_CAMERA_MODE;
        }
        m2467i("setDualPosition(" + this.f2684x.f2705f + ")");
        EngineInterface.getInstance().setDualPosition(this.f2678p.m2355e(), i, i2, i3, i4);
        return 0;
    }

    /* renamed from: c */
    public int m2580c(String str) throws IOException {
        m2467i("captureMyImage()");
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (CallState.isDisconnected(this.f2668f.getCallState())) {
            m2467i("captureMyImage State Check Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        EngineInterface.getInstance().captureMyImage(this.f2678p.m2355e(), this.f2678p.m2359f().getDestinationType() != 2, str);
        return 0;
    }

    /* renamed from: c */
    public int m2581c(ArrayList arrayList) {
        return this.f2678p.mo2336b(arrayList);
    }

    /* renamed from: c */
    public Destination m2582c() {
        return this.f2678p.m2359f();
    }

    /* renamed from: c */
    protected void m2583c(int i) {
        setActivityStatus(i, 0, 0, null);
    }

    /* renamed from: c */
    public void m2584c(boolean z) {
        if (z) {
            m2583c(EventCode.EVENT_CALL_VIDEO_RECORD_START);
        } else {
            m2583c(EventCode.EVENT_CALL_VIDEO_RECORD_END);
        }
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void chageAudioModeForScreenShare() {
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
        if (this.f2666d != null) {
            this.f2666d.handleShareScreen(true);
        }
    }

    /* renamed from: d */
    public int m2585d(int i) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2467i("setCartoonView State Setting Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2684x.f2704e = i;
        if (this.f2684x.f2708i) {
            return 0;
        }
        if (EngineInterface.getInstance().setCartoonView(this.f2678p.m2355e(), !this.f2678p.m2291J(), i) == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        return 0;
    }

    /* renamed from: d */
    public int m2586d(String str) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        Message message = new Message();
        message.what = EventCode.EVENT_DEBUG_MSG;
        message.obj = str;
        synchronized (this.f2667e) {
            if (getCallingActivity() != null) {
                m2467i("notifyDebugMsg!!!!! msg.whar:" + message.what);
                if (MainApplication.mPhoneManager.getCoolotsEventListener() == null) {
                    getCallingActivity().sendHandlerMessage(message, 0L);
                } else {
                    MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
                }
            }
        }
        return 0;
    }

    /* renamed from: d */
    public int m2587d(boolean z) {
        if (this.f2674l != null) {
            this.f2674l.NotifyMuteStateToWatch(this.f2678p.m2359f(), z);
        }
        return this.f2678p.mo2357e(z);
    }

    /* renamed from: d */
    public void m2588d(int i, int i2) {
        this.f2678p.m2315a(i, i2);
    }

    /* renamed from: d */
    public boolean m2589d() {
        return this.f2678p.mo2370k();
    }

    /* renamed from: e */
    public int m2590e(int i) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (EngineInterface.getInstance().setCameraZoomAction(this.f2678p.m2355e(), i) != -1) {
            return 0;
        }
        return PhoneStateMachine.ERROR_INVALID_CALLID;
    }

    /* renamed from: e */
    public int m2591e(int i, int i2) {
        return this.f2678p.m2334b(i, i2);
    }

    /* renamed from: e */
    public int m2592e(boolean z) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2466h("setNoiseReduction State Setting Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2684x.f2712m = z;
        if (EngineInterface.getInstance().setNoiseReduction(this.f2678p.m2355e(), !this.f2678p.m2291J(), z) == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        return 0;
    }

    /* renamed from: e */
    public Date m2593e() {
        return this.f2671i;
    }

    /* renamed from: e */
    public boolean m2594e(String str) {
        return this.f2678p.mo2350c(str);
    }

    /* renamed from: f */
    public int m2595f(int i) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2467i("setFaceEmotion State Setting Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        this.f2684x.f2702c = i;
        if (EngineInterface.getInstance().setFaceEmotion(this.f2678p.m2355e(), !this.f2678p.m2291J(), i) == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        return 0;
    }

    /* renamed from: f */
    public String m2596f() {
        return this.f2675m;
    }

    /* renamed from: f */
    public void m2597f(String str) {
        this.f2676n = str;
    }

    /* renamed from: f */
    public void m2598f(boolean z) {
        if (z) {
            if (this.f2678p.m2378s() == null) {
                m2583c(EventCode.EVENT_CALL_CAPTURE_MY_IMAGE_SUCCESS);
                return;
            } else {
                m2467i("<<YHT7>> setNotiCaptureImage - success!!");
                this.f2678p.m2378s().onResultCaptureImage(EventCode.EVENT_CALL_CAPTURE_MY_IMAGE_SUCCESS);
                return;
            }
        }
        if (this.f2678p.m2378s() == null) {
            m2583c(EventCode.EVENT_CALL_CAPTURE_MY_IMAGE_FAILURE);
        } else {
            m2467i("<<YHT7>> setNotiCaptureImage - fail!!");
            this.f2678p.m2378s().onResultCaptureImage(EventCode.EVENT_CALL_CAPTURE_MY_IMAGE_FAILURE);
        }
    }

    /* renamed from: g */
    public int m2599g(String str) {
        return this.f2678p.mo2305a(str);
    }

    /* renamed from: g */
    public String m2600g() {
        return this.f2676n;
    }

    /* renamed from: g */
    public void m2601g(int i) {
        if (this.f2678p.m2355e() != -1 && CallState.isConnected(this.f2668f.getCallState())) {
            EngineInterface.getInstance().sendCameraZoomInfo(this.f2678p.m2355e(), i);
        }
    }

    /* renamed from: g */
    public void m2602g(boolean z) {
        this.f2678p.m2360f(z);
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public AudioPathControllerInterface getAudioPathController() {
        return this.f2666d;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public Object getCallActivityMutex() {
        return this.f2667e;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public Date getCallConnectedTime() {
        if (this.f2672j == null) {
            m2466h("getCallConnectedTime() mCallConnectedTime is null");
            return null;
        }
        m2467i("getCallConnectedTime: " + this.f2672j.toString());
        return this.f2672j;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public int getCallDuration() {
        if (this.f2672j == null) {
            m2467i("getCallDuration(): mCallConnectedTime is null ");
            return 0;
        }
        int time = (int) ((new Date().getTime() - this.f2672j.getTime()) / 1000);
        m2467i("getCallDuration() mCallConnectedTime: " + this.f2672j.toString());
        m2467i("getCallDuration(): return " + time);
        return time;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public int getCallInstanceID() {
        return this.f2664b.m2639a();
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public C1208j getCallLogData() {
        return this.f2685y;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public C1209k getCallOptionData() {
        return this.f2684x;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public CallingInterface getCallingActivity() {
        return this.f2681u;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public EngineCallBackInterface getEngineInterface() {
        return this.f2679q;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public int getInitiateCallType() {
        return this.f2685y.f2694e;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public C1192G getMyConnectionInfo() {
        return this.f2683w;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public ISSOCallCallBack getSSOCallCallback() {
        return this.f2673k;
    }

    /* renamed from: h */
    public void m2603h() {
        this.f2682v = null;
    }

    /* renamed from: h */
    public void m2604h(int i) {
        m2467i("receiveCallNetworkWeak()");
        if (this.f2678p.m2378s() != null) {
            this.f2678p.m2378s().onCallNotifyNetworkWeakReceive(i);
            return;
        }
        Message message = new Message();
        message.what = EventCode.EVENT_CALL_NETWORK_WEAK_DURING_VIDEO_CALL;
        message.arg1 = i;
        m2519a(message, false);
    }

    /* renamed from: h */
    public void m2605h(boolean z) {
        this.f2678p.m2332a(z);
    }

    /* renamed from: i */
    public int m2606i(int i) {
        if (this.f2678p.m2355e() == -1) {
            return PhoneStateMachine.ERROR_INVALID_CALLID;
        }
        if (!isUseVideo()) {
            return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
        }
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            m2466h("setEnablePreview State Setting Error!!! current state:" + this.f2668f.getStateDescription());
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        m2467i("setEnablePreview(" + i + ")");
        EngineInterface.getInstance().setEnablePreview(i);
        return 0;
    }

    /* renamed from: i */
    public int m2607i(boolean z) {
        if (this.f2674l != null) {
            this.f2674l.NotifyHoldStateToWatch(this.f2678p.m2359f(), z);
        }
        return this.f2678p.mo2347c(z);
    }

    /* renamed from: i */
    public boolean m2608i() {
        if (this.f2682v == null) {
            return false;
        }
        return this.f2682v.f2652a;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public boolean isOutGoingCallInit() {
        return this.f2669g;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public boolean isSIPCall() {
        return this.f2678p instanceof C1198M;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public boolean isUseVideo() {
        return this.f2670h;
    }

    /* renamed from: j */
    public int m2609j(boolean z) {
        return this.f2678p.mo2361g(z);
    }

    /* renamed from: j */
    public boolean m2610j() {
        if (this.f2682v == null) {
            return false;
        }
        return this.f2682v.f2654c;
    }

    /* renamed from: j */
    public boolean m2611j(int i) {
        return this.f2678p.mo2343b(i);
    }

    /* renamed from: k */
    public int m2612k(int i) {
        return this.f2678p.m2356e(i);
    }

    /* renamed from: k */
    public void m2613k(boolean z) {
        this.f2678p.m2341b(z);
    }

    /* renamed from: k */
    public boolean m2614k() {
        if (this.f2682v == null) {
            return false;
        }
        return this.f2682v.f2653b;
    }

    /* renamed from: l */
    public int m2615l(int i) {
        return this.f2678p.mo2358f(i);
    }

    /* renamed from: l */
    public void m2616l(boolean z) {
        if (this.f2674l != null) {
            this.f2674l.notifyChangeCallType(this.f2678p.m2359f(), z);
        }
    }

    /* renamed from: l */
    public boolean m2617l() {
        return this.f2684x.f2718s;
    }

    /* renamed from: m */
    public void m2618m(int i) {
        Message message = new Message();
        message.what = EventCode.EVENT_FILE_RECV_START;
        message.arg1 = i;
        synchronized (this.f2667e) {
            if (getCallingActivity() != null) {
                m2467i("notiRecvFileStart!!!!! msg.whar:" + message.what);
                getCallingActivity().sendHandlerMessage(message, 0L);
            }
        }
    }

    /* renamed from: m */
    public boolean m2619m() {
        return this.f2684x.f2713n;
    }

    /* renamed from: n */
    public void m2620n(int i) {
        this.f2678p.mo2363g(i);
    }

    /* renamed from: n */
    public boolean m2621n() {
        return this.f2684x.f2712m;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void notiRejectMsg(String str, String str2) {
        m2467i("notiRejectMsg userID: " + str + " rejectMsg: " + str2);
        if (this.f2678p.m2359f() != null && this.f2678p.m2359f().getDestinationType() == 2) {
            this.f2680t.sendEmptyMessageDelayed(f2661r, 2000L);
        }
        MainApplication.mPhoneManager.getCallLogManager().addRejectMessage(str, str2, false, null);
    }

    /* renamed from: o */
    public int m2622o() {
        return this.f2684x.f2701b;
    }

    /* renamed from: o */
    public int m2623o(int i) {
        return this.f2678p.mo2368j(i);
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public int onChangeToP2P(String str, String str2, String str3, List list) {
        if (!CallState.isConnected(this.f2668f.getCallState())) {
            return PhoneStateMachine.ERROR_INVALID_STATE;
        }
        int iM2366i = this.f2678p.m2366i();
        m2544ad();
        if (this.f2678p instanceof C1214p) {
            this.f2678p.mo2330a(list);
        } else {
            if (!(this.f2678p instanceof C1217s)) {
                return PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
            }
            m2467i("conference changeToP2P ");
            this.f2678p = new C1214p(this.f2678p.m2359f(), this.f2668f, this.f2678p.mo2370k(), this, this.f2678p.m2355e());
        }
        return this.f2678p.mo2306a(str2, str, iM2366i, str3);
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void onFinishChangeToConference(JoinConferenceRep joinConferenceRep, List list, String str, String str2) {
        m2457a(joinConferenceRep.getConferenceInfo().getConferenceNo(), list, joinConferenceRep.getConferenceInfo(), str, str2);
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void onReceiveFeatureInfo(List list) {
        if (this.f2678p != null) {
            this.f2678p.m2340b(list);
        }
    }

    /* renamed from: p */
    public void m2624p(int i) {
        this.f2678p.mo2365h(i);
    }

    /* renamed from: p */
    public boolean m2625p() {
        return this.f2684x.f2700a;
    }

    /* renamed from: q */
    public int m2626q() {
        return this.f2684x.f2703d;
    }

    /* renamed from: r */
    public int m2627r() {
        return this.f2684x.f2704e;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public boolean registVoipCallState() {
        m2467i("registVoipCallState start!!");
        if (this.f2665c != null) {
            return this.f2665c.registVoipCallState(this.f2678p.m2359f());
        }
        m2467i("VOIP_INTERFACE mVoipStateController is null registVoipCallState");
        return true;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void removeRejectMsgHandlerMessage() {
        m2467i("removeRejectMsgHandlerMessage");
        this.f2680t.removeMessages(f2661r);
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void returnAudioModeForShareScreen() {
        m2461aD();
        if (this.f2666d != null) {
            this.f2666d.handleShareScreen(false);
        }
    }

    /* renamed from: s */
    public int m2628s() {
        return this.f2684x.f2702c;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void setActivityStatus(int i, int i2) {
        if (i == 7017) {
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            if (MainApplication.mPhoneManager.getCoolotsEventListener() == null) {
                m2519a(message, false);
            } else {
                MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
            }
        }
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void setActivityStatus(int i, int i2, int i3, Object obj) {
        m2467i("setActivityStatus() : " + CallActivity.getStringForEvent(i));
        if (i == 7102 || i == 7107) {
            m2549ai();
        }
        Message message = new Message();
        if (i == 7100) {
            if (i == 7100) {
                if (MainApplication.mPhoneManager.getCoolotsEventListener() == null) {
                    m2479L();
                    return;
                } else {
                    message.what = EventCode.EVENT_CALL_ACTION;
                    MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
                    return;
                }
            }
            return;
        }
        message.what = EventCode.EVENT_CALL_ACTION;
        switch (i) {
            case EventCode.EVENT_CONF_UPDATE_MEMBER /* 7004 */:
                message.what = i;
                message.obj = this.f2678p.m2359f();
                if (this.f2674l != null) {
                    this.f2674l.notifyUpdateConferenceMember(this.f2678p.m2359f(), isUseVideo());
                    break;
                }
                break;
            case EventCode.EVENT_CALL_CONNECTED /* 7101 */:
                message.arg2 = 16;
                break;
            case EventCode.EVENT_CALL_HANGUP /* 7102 */:
                message.arg2 = 19;
                message.arg1 = this.f2678p.m2366i();
                break;
            case EventCode.EVENT_CALL_HOLD /* 7103 */:
            case EventCode.EVENT_CALL_MUTE /* 7105 */:
            case EventCode.EVENT_CALL_BUSY /* 7108 */:
            case EventCode.EVENT_REMOTE_CALL_MUTE /* 7119 */:
            case EventCode.EVENT_REMOTE_CALL_UNMUTE /* 7120 */:
            case EventCode.EVENT_REMOTE_VIDEO_CALL_MUTE /* 7121 */:
            case EventCode.EVENT_REMOTE_VIDEO_CALL_UNMUTE /* 7122 */:
                message.what = i;
                message.obj = this.f2678p.m2359f();
                break;
            case EventCode.EVENT_CALL_UNHOLD /* 7104 */:
                message.arg2 = 17;
                break;
            case EventCode.EVENT_CALL_UNMUTE /* 7106 */:
                message.arg2 = 18;
                break;
            case EventCode.EVENT_CALL_ERROR /* 7107 */:
                message.arg2 = 20;
                break;
            case EventCode.EVENT_CALL_CAPTURE_IMAGE /* 7230 */:
                message.what = EventCode.EVENT_CALL_CAPTURE_IMAGE;
                break;
            case EventCode.EVENT_CALL_CAPTURE_MY_IMAGE_SUCCESS /* 7231 */:
            case EventCode.EVENT_CALL_CAPTURE_MY_IMAGE_FAILURE /* 7232 */:
                message.what = i;
                break;
            case EventCode.EVENT_CHANGE_TO_CONFERENCE_START /* 7602 */:
            case EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE /* 7603 */:
            case EventCode.EVENT_CHANGE_TO_CONFERENCE_FINISH /* 7604 */:
            case EventCode.EVENT_CHANGE_TO_CONFERENCE_DONE /* 7605 */:
                message.what = i;
                break;
            case EventCode.EVENT_CHANGE_TO_P2P_START /* 7610 */:
            case EventCode.EVENT_CHANGE_TO_P2P_FAILURE /* 7611 */:
            case EventCode.EVENT_CHANGE_TO_P2P_FAIL_TIMER /* 7613 */:
                message.what = i;
                message.obj = this.f2678p.m2359f();
                break;
            case EventCode.EVENT_CHANGE_TO_P2P_NOTI_MSG /* 7612 */:
                message.what = i;
                message.obj = obj;
                break;
            case EventCode.EVENT_CALL_REMOTEROTATION /* 7700 */:
                message.what = EventCode.EVENT_CALL_REMOTEROTATION;
                message.arg1 = i2;
                message.arg2 = i3;
                break;
            case EventCode.EVENT_CALL_REMOTEROTATION_P2P_CONF /* 7701 */:
                message.what = EventCode.EVENT_CALL_REMOTEROTATION_P2P_CONF;
                message.obj = obj;
                break;
            case EventCode.EVENT_CALL_VIDEO_RECORD_START /* 7900 */:
                message.what = EventCode.EVENT_CALL_VIDEO_RECORD_START;
                break;
            case EventCode.EVENT_CALL_VIDEO_RECORD_END /* 7901 */:
                message.what = EventCode.EVENT_CALL_VIDEO_RECORD_END;
                break;
            case EventCode.EVENT_SHARE_SCREEN_START /* 8112 */:
                message.what = i;
                break;
            case EventCode.EVENT_SHARE_SCREEN_END /* 8113 */:
                message.what = i;
                break;
            case EventCode.EVENT_SHARE_SCREEN_PAUSE /* 8114 */:
                message.what = i;
                break;
            case EventCode.EVENT_SHARE_SCREEN_RESTART /* 8115 */:
                message.what = i;
                break;
            case EventCode.EVENT_CAMERA_START_ERROR /* 8205 */:
                message.what = i;
                break;
            case EventCode.EVENT_DUAL_CAMERA_START /* 95015 */:
            case EventCode.EVENT_DUAL_CAMERA_STOP /* 95016 */:
                message.what = i;
                break;
        }
        m2516a(i);
        synchronized (this.f2667e) {
            if (MainApplication.mPhoneManager.getCoolotsEventListener() == null) {
                if (getCallingActivity() != null) {
                    m2467i("SEND HANDLER MESSAGE!!!!! msg.whar:" + message.what);
                    getCallingActivity().sendHandlerMessage(message, 0L);
                    if (i == 7102 || i == 7107) {
                        setCallingActivity(null);
                    }
                } else if (i != 7102 && i != 7107 && i != 7700 && i != 7701 && !CallState.isDisconnected(this.f2668f.getCallState())) {
                    m2479L();
                }
            } else if (!this.f2677o) {
                if (i == 7102 || i == 7107) {
                    this.f2677o = true;
                }
                MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
            }
        }
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void setActivityStatus(int i, Object obj) {
        if (i == 7018 || i == 7019) {
            Message message = new Message();
            message.what = i;
            message.obj = obj;
            if (MainApplication.mPhoneManager.getCoolotsEventListener() == null) {
                m2519a(message, false);
            } else {
                MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
            }
        }
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void setCallConnectedTime(Date date) {
        if (this.f2672j != null) {
            m2467i("setCallConnectedTime() Already call connected time is saved " + this.f2672j.toString());
        } else {
            m2467i("setCallConnectedTime: " + date.toString());
            this.f2672j = date;
        }
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void setCallingActivity(CallingInterface callingInterface) {
        synchronized (this.f2667e) {
            m2467i("setCallingActivity()");
            this.f2681u = callingInterface;
        }
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void setConferenceCallID(int i) {
        this.f2678p.mo2367i(i);
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void setMyStartTime(Date date, boolean z) {
        this.f2683w.f2622b = z;
        this.f2683w.f2621a = date;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void setPlayHoldTone(boolean z) {
        this.f2684x.f2718s = z;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void setUseVideo(boolean z) {
        this.f2670h = z;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void showToastForShareView(int i) {
        m2467i("showToastForShareView()");
        Message message = new Message();
        message.what = EventCode.EVENT_SHARE_VIEW_SHOW_TOAST;
        message.arg1 = i;
        m2519a(message, false);
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void startShareView(boolean z) {
        m2467i("startShareView(" + z + ")");
        Message message = new Message();
        message.what = EventCode.EVENT_SHARE_VIEW_START;
        message.arg1 = z ? 1 : 0;
        m2519a(message, false);
        this.f2678p.m2313a().setShareCameraProcessing(true);
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void stopShareView() {
        m2467i("endShareView()");
        Message message = new Message();
        message.what = EventCode.EVENT_SHARE_VIEW_END;
        m2519a(message, false);
        this.f2678p.m2313a().setShareCameraProcessing(false);
    }

    /* renamed from: t */
    public boolean m2629t() {
        return this.f2684x.f2709j;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void turnOnSpeaker() {
        if (this.f2666d.isSpeakerON()) {
            return;
        }
        this.f2666d.onClickSpeakerButton();
    }

    /* renamed from: u */
    public boolean m2630u() {
        return this.f2684x.f2710k;
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void unregistVoipCallState() {
        m2467i("unregistVoipCallState start!!");
        if (this.f2665c == null) {
            m2466h("VOIP_INTERFACE mVoipStateController is null unregistVoipCallState");
        } else {
            this.f2665c.unregistVoipCallState();
        }
    }

    @Override // com.sds.coolots.call.model.CallInstanceInterface
    public void updateVoipCallState() {
        m2467i("updateVoipCallState start!!");
        if (this.f2665c == null) {
            m2466h("VOIP_INTERFACE mVoipStateController is null updateVoipCallState");
        } else {
            this.f2665c.updateVoipCallState(m2589d(), this.f2678p.m2359f(), this.f2668f);
        }
    }

    /* renamed from: v */
    public boolean m2631v() {
        return m2632w() || m2633x();
    }

    /* renamed from: w */
    public boolean m2632w() {
        return this.f2684x.f2714o;
    }

    /* renamed from: x */
    public boolean m2633x() {
        return this.f2684x.f2715p;
    }

    /* renamed from: y */
    public boolean m2634y() {
        return m2635z() || m2468A();
    }

    /* renamed from: z */
    public boolean m2635z() {
        return this.f2684x.f2714o;
    }
}
