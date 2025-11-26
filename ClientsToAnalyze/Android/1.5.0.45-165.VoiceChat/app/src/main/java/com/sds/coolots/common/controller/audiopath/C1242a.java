package com.sds.coolots.common.controller.audiopath;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.SoundManagerInterface;
import com.sds.coolots.common.util.Log;

/* renamed from: com.sds.coolots.common.controller.audiopath.a */
/* loaded from: classes.dex */
public class C1242a implements AudioPathControllerInterface {

    /* renamed from: a */
    private static final String f2944a = "[AudioPathController]";

    /* renamed from: k */
    private static final int f2945k = 0;

    /* renamed from: l */
    private static final int f2946l = 1;

    /* renamed from: m */
    private static final int f2947m = 2;

    /* renamed from: n */
    private static final int f2948n = 1000;

    /* renamed from: o */
    private static final int f2949o = 1000;

    /* renamed from: p */
    private static final int f2950p = 500;

    /* renamed from: q */
    private static final int f2951q = 1001;

    /* renamed from: r */
    private static final int f2952r = 2000;

    /* renamed from: s */
    private static final int f2953s = 3000;

    /* renamed from: t */
    private static final int f2954t = 3001;

    /* renamed from: v */
    private static final String f2955v = "android.intent.action.HEADSET_PLUG";

    /* renamed from: w */
    private static final String f2956w = "android.intent.action.DOCK_EVENT";

    /* renamed from: b */
    private boolean f2957b;

    /* renamed from: c */
    private boolean f2958c;

    /* renamed from: d */
    private BlueToothControllerInterface f2959d = null;

    /* renamed from: e */
    private DrivingModeControllerInterface f2960e = null;

    /* renamed from: f */
    private Handler f2961f;

    /* renamed from: g */
    private final SoundManagerInterface f2962g;

    /* renamed from: h */
    private final Context f2963h;

    /* renamed from: i */
    private AudioManager f2964i;

    /* renamed from: j */
    private UiModeManager f2965j;

    /* renamed from: u */
    private int f2966u;

    /* renamed from: x */
    private HandlerC1244c f2967x;

    public C1242a() {
        this.f2964i = null;
        this.f2965j = null;
        m2855b("Constructor is created ++");
        this.f2962g = MainApplication.mPhoneManager.getHardwareManager().getSoundManager();
        if (this.f2964i == null) {
            this.f2964i = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (this.f2965j == null) {
            this.f2965j = (UiModeManager) MainApplication.mContext.getSystemService("uimode");
        }
        this.f2963h = MainApplication.mContext;
        m2859d();
        this.f2966u = 0;
        this.f2967x = new HandlerC1244c(this);
        m2855b("Constructor is created --");
    }

    /* renamed from: a */
    private void m2852a(String str) {
        Log.m2958e(f2944a + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2855b(String str) {
        Log.m2963i(f2944a + str);
    }

    /* renamed from: c */
    private int m2856c(boolean z) {
        description("handleBTConnection(" + z + ")");
        return z ? 1 : 2;
    }

    /* renamed from: d */
    private int m2858d(boolean z) {
        description("handleBTAudioConnection(" + z + ")++");
        if (z) {
            m2855b("BT becomes connected just moment ago.");
            if (this.f2957b) {
                m2865g(this.f2957b);
                this.f2957b = false;
                m2872a(false);
                m2867h(this.f2957b);
                m2866h();
            }
        } else {
            m2855b("BT becomes disconnected just moment ago.");
            m2864g();
            m2867h(this.f2957b);
            m2866h();
        }
        m2868i(z);
        description("handleBTAudioConnection((" + z + ")--");
        return z ? 3 : 4;
    }

    /* renamed from: d */
    private void m2859d() {
        if (this.f2959d == null) {
            this.f2959d = MainApplication.mNativeInterfaceCreator.createBlueToothController();
        }
    }

    /* renamed from: e */
    private int m2860e(boolean z) {
        description("handleEarphone((" + z + ")++");
        if (!isBlueToothConnected() || !isBlueToothOn()) {
            if (z) {
                this.f2957b = false;
                m2872a(false);
            } else {
                m2864g();
            }
            m2867h(this.f2957b);
            m2866h();
        }
        m2869j(z);
        description("handleEarphone(" + z + ")--");
        return z ? 5 : 6;
    }

    /* renamed from: e */
    private void m2861e() {
        if (this.f2960e == null) {
            this.f2960e = MainApplication.mNativeInterfaceCreator.createDrivingModeController();
        }
    }

    /* renamed from: f */
    private int m2862f(boolean z) {
        description("handleCradle(" + z + ")++");
        if (!isEarPhonePlugged() && (!isBlueToothConnected() || !isBlueToothOn())) {
            if (z) {
                m2865g(this.f2957b);
                this.f2957b = z;
                m2872a(z);
            } else {
                m2864g();
            }
            m2867h(this.f2957b);
            m2866h();
        }
        description("handleCradle(" + z + ")--");
        return z ? 7 : 8;
    }

    /* renamed from: f */
    private boolean m2863f() {
        return this.f2962g.isSpeakerOn(this.f2963h);
    }

    /* renamed from: g */
    private void m2864g() {
        m2855b("restoreSpeakerMode() now: " + this.f2957b + " saved: " + this.f2958c);
        if (this.f2957b != this.f2958c) {
            this.f2957b = this.f2958c;
            m2872a(this.f2957b);
        }
    }

    /* renamed from: g */
    private void m2865g(boolean z) {
        m2855b("storeSpeakerMode() isOn: " + z);
        this.f2958c = z;
    }

    /* renamed from: h */
    private void m2866h() {
        m2855b("requestQuickPannelUIUpdate() speaker" + this.f2957b);
    }

    /* renamed from: h */
    private void m2867h(boolean z) {
        if (this.f2961f == null) {
            m2852a("Handler is null!!");
            return;
        }
        m2855b("mHandler: " + this.f2961f.toString());
        if (z) {
            this.f2961f.sendEmptyMessage(17);
        } else {
            this.f2961f.sendEmptyMessage(18);
        }
        m2855b("requestSpeakerButtonONOFF()" + z);
    }

    /* renamed from: i */
    private void m2868i(boolean z) {
        if (this.f2961f == null) {
            m2852a("Handler is null!!");
            return;
        }
        m2855b("mHandler: " + this.f2961f.toString());
        if (z) {
            this.f2961f.sendEmptyMessage(19);
        } else {
            this.f2961f.sendEmptyMessage(20);
        }
        m2855b("requestBTButtonONOFF()" + z);
    }

    /* renamed from: j */
    private void m2869j(boolean z) {
        if (this.f2961f == null) {
            m2852a("Handler is null!!");
            return;
        }
        m2855b("mHandler: " + this.f2961f.toString());
        if (z) {
            this.f2961f.sendEmptyMessage(25);
        } else {
            this.f2961f.sendEmptyMessage(26);
        }
        m2855b("notifyEarphonePluged()" + z);
    }

    /* renamed from: a */
    public void m2870a() {
        description("setSpeakerModeOnAfterBTSCOOFF()++");
        m2865g(this.f2957b);
        this.f2957b = true;
        m2872a(true);
        m2867h(this.f2957b);
        m2866h();
        description("setSpeakerModeOnAfterBTSCOOFF()--");
    }

    /* renamed from: a */
    public void m2871a(int i) {
        Message message = new Message();
        message.what = i;
        if (this.f2967x == null) {
            this.f2967x = new HandlerC1244c(this);
        }
        this.f2967x.sendMessageDelayed(message, 500L);
    }

    /* renamed from: a */
    public void m2872a(boolean z) {
        m2855b("requestSpeakerONOFF() isOn: " + z);
        if (this.f2962g.isSpeakerOn(this.f2963h) != z) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().setSpeakerPhone(z);
        }
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void addAction(IntentFilter intentFilter) {
        this.f2959d.addAction(intentFilter);
        intentFilter.addAction(f2955v);
        intentFilter.addAction(f2956w);
    }

    /* renamed from: b */
    public void m2873b(boolean z) {
        m2855b("requestSpeakerONOFFDelay() isOn: " + z);
        Message message = new Message();
        message.what = 1000;
        message.obj = Boolean.valueOf(z);
        if (this.f2967x == null) {
            this.f2967x = new HandlerC1244c(this);
        }
        this.f2967x.sendMessageDelayed(message, 1000L);
    }

    /* renamed from: b */
    public boolean m2874b() {
        m2861e();
        return this.f2960e.isDrivingModeUI();
    }

    /* renamed from: c */
    public boolean m2875c() {
        m2861e();
        return this.f2960e.isDrivingMode();
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public int checkBRAction(Intent intent) {
        String action = intent.getAction();
        m2852a("[BR] checkBRAction() " + action);
        int iCheckBRAction = this.f2959d.checkBRAction(intent);
        switch (iCheckBRAction) {
            case 1:
                return m2856c(true);
            case 2:
                return m2856c(false);
            case 3:
                return m2858d(true);
            case 4:
                return m2858d(false);
            default:
                if (action.equals(f2955v) && intent.hasExtra("state")) {
                    return m2860e(intent.getIntExtra("state", 0) == 1);
                }
                if (!action.equals(f2956w)) {
                    return iCheckBRAction;
                }
                int intExtra = intent.getIntExtra("android.intent.extra.DOCK_STATE", 0);
                return m2862f(intExtra == 1 || intExtra == 2 || intExtra == 1);
        }
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void description(String str) {
        m2855b("[" + str + " start]-----------------------------");
        m2855b("-SpeakerPhone(HW):    \t" + m2863f());
        m2855b("-SpeakerPhone(Saved):\t" + this.f2957b);
        m2855b("-PreSpeakerPhone:    \t" + this.f2958c);
        m2855b("-EarPhone:           \t" + isEarPhonePlugged());
        m2855b("-BlueTooth(Connected): " + isBlueToothConnected());
        m2855b("-BlueTooth(Use):  \t\t" + isBlueToothOn());
        m2855b("-CarCradle:             \t" + isCarCradleConnected());
        m2855b("-DeskCradle:             \t" + isDeskCradleConnected());
        m2855b("-DrivingMode:             \t" + m2875c());
        m2855b("[" + str + " end]-----------------------------");
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void dispose() {
        m2855b("dispose()");
        if (this.f2967x != null) {
            this.f2967x.dispose();
            this.f2967x.removeMessages(1000);
            this.f2967x = null;
        }
        this.f2961f = null;
        this.f2964i = null;
        this.f2965j = null;
        this.f2959d = null;
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public boolean getUIHandler() {
        m2855b("getUIHandler()" + (this.f2961f != null));
        return this.f2961f != null;
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void handleShareScreen(boolean z) {
        description("handleShareScreen(" + z + ")++");
        if (!isEarPhonePlugged() && (!isBlueToothConnected() || !isBlueToothOn())) {
            if (z) {
                m2865g(this.f2957b);
                this.f2957b = z;
                m2872a(z);
            } else {
                m2864g();
            }
            m2867h(this.f2957b);
            m2866h();
        }
        description("handleShareScreen(" + z + ")++");
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void initCallConnectedByBargeIn(boolean z) {
        boolean z2 = false;
        boolean zIsSpeakerON = isSpeakerON();
        if (!this.f2959d.isConnectBlueTooth() && !isEarPhonePlugged()) {
            z2 = (isCarCradleConnected() || isDeskCradleConnected()) ? true : true;
        }
        m2855b("nowSpeakerOn: " + zIsSpeakerON + ", speakerOn: " + z2);
        if (zIsSpeakerON != z2) {
            this.f2957b = z2;
            m2865g(this.f2957b);
            m2872a(this.f2957b);
            m2867h(this.f2957b);
            m2866h();
            description("initCallConnectedByBargeIn()");
        }
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void initCallConnectedForWatch(boolean z, boolean z2) {
        boolean z3 = true;
        boolean zIsSpeakerON = isSpeakerON();
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isCallReceiveFromWatch()) {
            if (!isCarCradleConnected() && !isDeskCradleConnected()) {
                z3 = false;
            }
            m2855b("WATCH_AUDIO initCallConnectedForWatch received from Watch - speakerOn " + z3);
        } else {
            if (!isCarCradleConnected() && !isDeskCradleConnected() && !m2874b() && !z2 && !z) {
                z3 = false;
            }
            m2855b("WATCH_AUDIO initCallConnectedForWatch received from Handset - speakerOn " + z3);
        }
        m2855b("nowSpeakerOn: " + zIsSpeakerON + ", speakerOn: " + z3);
        if (zIsSpeakerON != z3) {
            this.f2957b = z3;
            m2865g(this.f2957b);
            m2872a(this.f2957b);
            m2867h(this.f2957b);
            m2866h();
            description("initCallConnectedByBargeIn()");
        }
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void initCallSwitching(boolean z) {
        if (z) {
            this.f2966u = 1;
        } else {
            this.f2966u = 2;
        }
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void initUIComponents(boolean z) {
        if (z) {
            m2855b("initUIComponents(" + z + ")");
            if (this.f2966u == 1) {
                this.f2958c = true;
                this.f2957b = true;
            } else if (this.f2966u == 2) {
                this.f2958c = false;
                this.f2957b = false;
            } else {
                boolean zM2863f = m2863f();
                this.f2958c = zM2863f;
                this.f2957b = zM2863f;
            }
            this.f2966u = 0;
            m2859d();
            this.f2959d.findBlueToothState();
            if (this.f2959d.isConnectBlueTooth() || isEarPhonePlugged()) {
                this.f2957b = false;
            } else if (isCarCradleConnected() || isDeskCradleConnected() || m2874b()) {
                this.f2957b = true;
            }
            m2868i(this.f2959d.isUseBlueTooth());
            m2867h(this.f2957b);
            m2872a(this.f2957b);
            m2873b(this.f2957b);
            m2866h();
            description("initUIComponents-- ");
        }
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public boolean isBlueToothConnected() {
        m2859d();
        return this.f2959d.isConnectBlueTooth();
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public boolean isBlueToothOn() {
        m2859d();
        return this.f2959d.isUseBlueTooth();
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public boolean isCarCradleConnected() {
        if (this.f2965j == null) {
            this.f2965j = (UiModeManager) MainApplication.mContext.getSystemService("uimode");
        }
        return this.f2965j.getCurrentModeType() == 3;
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public boolean isDeskCradleConnected() {
        if (this.f2965j == null) {
            this.f2965j = (UiModeManager) MainApplication.mContext.getSystemService("uimode");
        }
        return this.f2965j.getCurrentModeType() == 2;
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public boolean isEarPhonePlugged() {
        if (this.f2964i == null) {
            this.f2964i = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        return this.f2964i.isWiredHeadsetOn();
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public boolean isInstalledWatchApp() {
        if (this.f2959d == null) {
            return false;
        }
        return this.f2959d.isInstalledWatchApp();
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public boolean isSpeakerON() {
        return this.f2957b;
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public boolean isWatch() {
        if (this.f2959d != null) {
            return this.f2959d.isWatch();
        }
        return false;
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public boolean onClickBlueToothButton() {
        boolean z = false;
        description("onClickBlueToothButton()++");
        if (isBlueToothConnected()) {
            m2855b("Bluetooth is connected now");
            if (isBlueToothOn()) {
                m2855b("Bluetooth is on now");
                this.f2959d.setBlueToothState(false);
                m2868i(false);
            } else {
                m2855b("Bluetooth is off now");
                this.f2959d.setBlueToothState(true);
                m2868i(true);
            }
        } else {
            m2855b("Goto blueTooth setting page");
            z = true;
        }
        description("onClickBlueToothButton()--");
        return z;
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void onClickSpeakerButton() {
        description("onClickSpeakerButton()++");
        this.f2957b = !this.f2957b;
        if (this.f2957b && isBlueToothConnected() && isBlueToothOn()) {
            m2855b("Speaker will become ON & Bluetooth is ON now  => BT will become OFF");
            this.f2959d.setBlueToothState(false);
            m2868i(false);
            m2871a(3000);
            return;
        }
        if (!this.f2957b && isBlueToothConnected() && !isBlueToothOn()) {
            m2855b("Speaker will become OFF & Bluetooth is CONNECTED now => BT will become ON");
            this.f2959d.setBlueToothState(true);
            m2868i(true);
        }
        m2865g(this.f2957b);
        m2872a(this.f2957b);
        m2867h(this.f2957b);
        m2866h();
        description("onClickSpeakerButton()--");
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void setUIHandler(Handler handler) {
        this.f2961f = handler;
        StringBuilder sb = new StringBuilder("setUIHandler()");
        String string = handler;
        if (handler != null) {
            string = handler.toString();
        }
        m2855b(sb.append((Object) string).toString());
    }

    @Override // com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface
    public void updateSpeakerMode() {
        description("updateSpeakerMode()++");
        if (this.f2957b && isBlueToothConnected() && isBlueToothOn()) {
            this.f2959d.setBlueToothState(false);
            m2868i(false);
        }
        m2865g(this.f2957b);
        m2872a(this.f2957b);
        m2867h(this.f2957b);
        m2866h();
        description("updateSpeakerMode()--");
    }
}
