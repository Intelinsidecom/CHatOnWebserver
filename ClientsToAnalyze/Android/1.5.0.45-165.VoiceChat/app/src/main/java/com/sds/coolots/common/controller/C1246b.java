package com.sds.coolots.common.controller;

import com.sds.coolots.call.CallFunctionControllerInterface;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.common.util.Log;

/* renamed from: com.sds.coolots.common.controller.b */
/* loaded from: classes.dex */
public class C1246b implements CallFunctionControllerInterface {

    /* renamed from: a */
    private static final String f2975a = "[CallFunctionController]";

    /* renamed from: b */
    private final CallConsentHandler f2976b;

    /* renamed from: c */
    private final CallState f2977c;

    /* renamed from: d */
    private boolean f2978d = false;

    /* renamed from: e */
    private boolean f2979e = false;

    /* renamed from: f */
    private int f2980f = 0;

    /* renamed from: g */
    private boolean f2981g = false;

    /* renamed from: h */
    private boolean f2982h = false;

    /* renamed from: i */
    private boolean f2983i = false;

    public C1246b(CallState callState, CallConsentHandler callConsentHandler) {
        this.f2977c = callState;
        this.f2976b = callConsentHandler;
    }

    /* renamed from: a */
    private void m2877a(String str) {
        Log.m2963i(f2975a + str);
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public int getCallSwitchingProcessing() {
        return this.f2980f;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public boolean isEnableConsentProcessing() {
        return (!CallState.isConnected(this.f2977c.getCallState()) || this.f2976b != null || this.f2980f != 0 || this.f2981g || this.f2982h || this.f2983i || this.f2978d) ? false : true;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public boolean isEnableInviteProcessing() {
        return (!CallState.isConnected(this.f2977c.getCallState()) || this.f2976b != null || this.f2980f != 0 || this.f2981g || this.f2982h || this.f2983i || this.f2978d) ? false : true;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public boolean isInviteProcessing() {
        return this.f2978d;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public boolean isPrepareChageToConf() {
        return this.f2979e;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public boolean isRecordingProcessing() {
        return this.f2983i;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public boolean isShareCameraProcessing() {
        return this.f2981g;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public boolean isShareScreenProcessing() {
        return this.f2982h;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public void setCallSwitchingProcessing(int i) {
        m2877a("setCallSwitchingProcessing : " + i);
        this.f2980f = i;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public void setInviteProcessing(boolean z) {
        m2877a("setInviteProcessing : " + z);
        this.f2978d = z;
        this.f2979e = false;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public void setPrepareChageToConf(boolean z) {
        m2877a("setPrepareChageToConf : " + z);
        this.f2979e = z;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public void setRecordingProcessing(boolean z) {
        m2877a("setRecordingProcessing : " + z);
        this.f2983i = z;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public void setShareCameraProcessing(boolean z) {
        m2877a("setShareCameraProcessing : " + z);
        this.f2981g = z;
    }

    @Override // com.sds.coolots.call.CallFunctionControllerInterface
    public void setShareScreenProcessing(boolean z) {
        m2877a("setShareScreenProcessing : " + z);
        this.f2982h = z;
    }
}
