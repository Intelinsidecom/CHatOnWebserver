package com.sds.coolots.call.model;

import com.sds.coolots.MainApplication;
import com.sds.coolots.call.CallFunctionControllerInterface;
import com.sds.coolots.call.nego.NegoFeatureControllerInterface;
import com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface;

/* loaded from: classes.dex */
public class CallStatusData {

    /* renamed from: A */
    private AudioPathControllerInterface f2560A;

    /* renamed from: B */
    private CallFunctionControllerInterface f2561B;

    /* renamed from: C */
    private NegoFeatureControllerInterface f2562C;

    /* renamed from: a */
    private Destination f2563a;

    /* renamed from: b */
    private boolean f2564b;

    /* renamed from: c */
    private boolean f2565c;

    /* renamed from: d */
    private int f2566d;

    /* renamed from: e */
    private int f2567e;

    /* renamed from: f */
    private boolean f2568f;

    /* renamed from: g */
    private boolean f2569g;

    /* renamed from: h */
    private int f2570h;

    /* renamed from: i */
    private int[] f2571i;

    /* renamed from: j */
    private boolean f2572j;

    /* renamed from: k */
    private boolean f2573k;

    /* renamed from: l */
    private boolean f2574l;

    /* renamed from: m */
    private boolean f2575m;

    /* renamed from: n */
    private int f2576n;

    /* renamed from: o */
    private boolean f2577o;

    /* renamed from: p */
    private int f2578p;

    /* renamed from: q */
    private String f2579q;

    /* renamed from: r */
    private int f2580r;

    /* renamed from: s */
    private boolean f2581s;

    /* renamed from: t */
    private short f2582t;

    /* renamed from: u */
    private boolean f2583u;

    /* renamed from: v */
    private boolean f2584v;

    /* renamed from: w */
    private boolean f2585w;

    /* renamed from: x */
    private int f2586x;

    /* renamed from: y */
    private boolean f2587y;

    /* renamed from: z */
    private boolean f2588z = false;

    public AudioPathControllerInterface getAudioPathController() {
        return this.f2560A;
    }

    public CallFunctionControllerInterface getCallFunctionController() {
        return this.f2561B;
    }

    public int getCallID() {
        return this.f2566d;
    }

    public int getCallState() {
        return this.f2567e;
    }

    public short getDestDeviceID() {
        return this.f2582t;
    }

    public Destination getDestination() {
        return this.f2563a;
    }

    public int getEmotionalAnimationType() {
        return this.f2576n;
    }

    public String getHostDisplayName() {
        return this.f2579q;
    }

    public NegoFeatureControllerInterface getNegoFeatureController() {
        return this.f2562C;
    }

    public int getRemoteRotation() {
        return this.f2570h;
    }

    public int[] getRemoteRotations() {
        return this.f2571i;
    }

    public int getThemeShotType() {
        return this.f2578p;
    }

    public int gethangupReason() {
        return this.f2580r;
    }

    public boolean is3GConnectType() {
        return this.f2587y;
    }

    public int isActiveShareScreen() {
        return this.f2586x;
    }

    public boolean isAlwaysEmotional() {
        return this.f2577o;
    }

    public boolean isCallAccept() {
        return this.f2568f;
    }

    public boolean isCallTransforming() {
        return this.f2588z;
    }

    public boolean isDefaultHideMeImage() {
        return this.f2581s;
    }

    public boolean isLiveShare() {
        return this.f2584v;
    }

    public boolean isNoiseReduction() {
        return this.f2575m;
    }

    public boolean isOutGoingCall() {
        return this.f2564b;
    }

    public boolean isP2PFreeCall() {
        return this.f2563a.getDestinationType() == 2 || this.f2563a.getDestinationType() == 5;
    }

    public boolean isPlayHoldTone() {
        return this.f2572j;
    }

    public boolean isPushSuccess() {
        return this.f2573k;
    }

    public boolean isSecureCommunication() {
        return this.f2574l;
    }

    public boolean isUseAvatar() {
        return this.f2585w;
    }

    public boolean isUseDualCamera() {
        return this.f2583u;
    }

    public boolean isUseVideo() {
        return this.f2565c;
    }

    public boolean isValidity() {
        return this.f2569g;
    }

    public void setActiveShareScreen(int i) {
        this.f2586x = i;
    }

    public void setAlwaysEmotioanl(boolean z) {
        this.f2577o = z;
    }

    public void setAudioPathController(AudioPathControllerInterface audioPathControllerInterface) {
        this.f2560A = audioPathControllerInterface;
    }

    public void setCallFunctionController(CallFunctionControllerInterface callFunctionControllerInterface) {
        this.f2561B = callFunctionControllerInterface;
    }

    public void setCallID(int i) {
        this.f2566d = i;
    }

    public void setCallState(int i) {
        this.f2567e = i;
    }

    public void setDefaultHideMeImage(boolean z) {
        this.f2581s = z;
    }

    public void setDestDeviceID(short s) {
        this.f2582t = s;
    }

    public void setDestination(Destination destination) {
        this.f2563a = new Destination(2, MainApplication.mConfig.getProfileUserID());
        this.f2563a.copyDestination(destination);
    }

    public void setEmotionalAnimationType(int i) {
        this.f2576n = i;
    }

    public void setHangupReason(int i) {
        this.f2580r = i;
    }

    public void setHostDisplayName(String str) {
        this.f2579q = str;
    }

    public void setIs3GConnectType(boolean z) {
        this.f2587y = z;
    }

    public void setIsCallAccept(boolean z) {
        this.f2568f = z;
    }

    public void setIsCallTransforming(boolean z) {
        this.f2588z = z;
    }

    public void setIsLiveShare(boolean z) {
        this.f2584v = z;
    }

    public void setIsOutGoingCall(boolean z) {
        this.f2564b = z;
    }

    public void setNegoFeatureController(NegoFeatureControllerInterface negoFeatureControllerInterface) {
        this.f2562C = negoFeatureControllerInterface;
    }

    public void setNoiseReduction(boolean z) {
        this.f2575m = z;
    }

    public void setPlayHoldTone(boolean z) {
        this.f2572j = z;
    }

    public void setPushSuccess(boolean z) {
        this.f2573k = z;
    }

    public void setRemoteRotation(int i) {
        this.f2570h = i;
    }

    public void setRemoteRotations(int[] iArr) {
        this.f2571i = iArr;
    }

    public void setSecureCommunication(boolean z) {
        this.f2574l = z;
    }

    public void setThemeShotType(int i) {
        this.f2578p = i;
    }

    public void setUseAvatar(boolean z) {
        this.f2585w = z;
    }

    public void setUseDualCamera(boolean z) {
        this.f2583u = z;
    }

    public void setUseVideo(boolean z) {
        this.f2565c = z;
    }

    public void setValidity(boolean z) {
        this.f2569g = z;
    }

    public void updateCallState() {
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(this);
    }
}
