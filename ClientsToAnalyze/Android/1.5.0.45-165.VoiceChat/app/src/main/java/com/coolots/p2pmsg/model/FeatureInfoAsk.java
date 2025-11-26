package com.coolots.p2pmsg.model;

import com.coolots.common.util.StringUtil;

/* loaded from: classes.dex */
public class FeatureInfoAsk extends MsgBody {
    private String appVersion;
    private String deviceModelName;
    private boolean p2pVoiceCall = true;
    private boolean p2pVideoCall = true;
    private boolean p2pVoiceToVideoCallSwitching = false;
    private boolean p2pVideoToVoiceCallSwitching = false;
    private boolean p2pShareScreen = false;
    private boolean p2pShareCamera = false;
    private boolean p2pHandwritingInShareScreen = false;
    private boolean p2pHandwritingInDocView = false;
    private boolean p2pShareRemoteControl = false;
    private boolean p2pShareDocView = false;
    private boolean p2pTranslation = false;
    private boolean confVoiceCall = true;
    private boolean confVideoCall = true;
    private boolean confVoiceToVideoCallSwitching = false;
    private boolean confVideoToVoiceCallSwitching = false;
    private boolean confShareScreen = false;
    private boolean confShareCamera = false;
    private boolean confHandwritingInShareScreen = false;
    private boolean confHandwritingInDocView = false;
    private boolean confShareRemoteControl = false;
    private boolean confShareDocView = false;
    private boolean confTranslation = false;

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceModelName() {
        return this.deviceModelName;
    }

    public void setDeviceModelName(String deviceModelName) {
        this.deviceModelName = deviceModelName;
    }

    public boolean isP2pVoiceCall() {
        return this.p2pVoiceCall;
    }

    public void setP2pVoiceCall(boolean p2pVoiceCall) {
        this.p2pVoiceCall = p2pVoiceCall;
    }

    public boolean isP2pVideoCall() {
        return this.p2pVideoCall;
    }

    public void setP2pVideoCall(boolean p2pVideoCall) {
        this.p2pVideoCall = p2pVideoCall;
    }

    public boolean isP2pVoiceToVideoCallSwitching() {
        return this.p2pVoiceToVideoCallSwitching;
    }

    public void setP2pVoiceToVideoCallSwitching(boolean p2pVoiceToVideoCallSwitching) {
        this.p2pVoiceToVideoCallSwitching = p2pVoiceToVideoCallSwitching;
    }

    public boolean isP2pVideoToVoiceCallSwitching() {
        return this.p2pVideoToVoiceCallSwitching;
    }

    public void setP2pVideoToVoiceCallSwitching(boolean p2pVideoToVoiceCallSwitching) {
        this.p2pVideoToVoiceCallSwitching = p2pVideoToVoiceCallSwitching;
    }

    public boolean isP2pShareScreen() {
        return this.p2pShareScreen;
    }

    public void setP2pShareScreen(boolean p2pShareScreen) {
        this.p2pShareScreen = p2pShareScreen;
    }

    public boolean isP2pShareCamera() {
        return this.p2pShareCamera;
    }

    public void setP2pShareCamera(boolean p2pShareCamera) {
        this.p2pShareCamera = p2pShareCamera;
    }

    public boolean isP2pHandwritingInShareScreen() {
        return this.p2pHandwritingInShareScreen;
    }

    public void setP2pHandwritingInShareScreen(boolean p2pHandwritingInShareScreen) {
        this.p2pHandwritingInShareScreen = p2pHandwritingInShareScreen;
    }

    public boolean isP2pHandwritingInDocView() {
        return this.p2pHandwritingInDocView;
    }

    public void setP2pHandwritingInDocView(boolean p2pHandwritingInDocView) {
        this.p2pHandwritingInDocView = p2pHandwritingInDocView;
    }

    public boolean isP2pShareRemoteControl() {
        return this.p2pShareRemoteControl;
    }

    public void setP2pShareRemoteControl(boolean p2pShareRemoteControl) {
        this.p2pShareRemoteControl = p2pShareRemoteControl;
    }

    public boolean isP2pShareDocView() {
        return this.p2pShareDocView;
    }

    public void setP2pShareDocView(boolean p2pShareDocView) {
        this.p2pShareDocView = p2pShareDocView;
    }

    public boolean isP2pTranslation() {
        return this.p2pTranslation;
    }

    public void setP2pTranslation(boolean p2pTranslation) {
        this.p2pTranslation = p2pTranslation;
    }

    public boolean isConfVoiceCall() {
        return this.confVoiceCall;
    }

    public void setConfVoiceCall(boolean confVoiceCall) {
        this.confVoiceCall = confVoiceCall;
    }

    public boolean isConfVideoCall() {
        return this.confVideoCall;
    }

    public void setConfVideoCall(boolean confVideoCall) {
        this.confVideoCall = confVideoCall;
    }

    public boolean isConfVoiceToVideoCallSwitching() {
        return this.confVoiceToVideoCallSwitching;
    }

    public void setConfVoiceToVideoCallSwitching(boolean confVoiceToVideoCallSwitching) {
        this.confVoiceToVideoCallSwitching = confVoiceToVideoCallSwitching;
    }

    public boolean isConfVideoToVoiceCallSwitching() {
        return this.confVideoToVoiceCallSwitching;
    }

    public void setConfVideoToVoiceCallSwitching(boolean confVideoToVoiceCallSwitching) {
        this.confVideoToVoiceCallSwitching = confVideoToVoiceCallSwitching;
    }

    public boolean isConfShareScreen() {
        return this.confShareScreen;
    }

    public void setConfShareScreen(boolean confShareScreen) {
        this.confShareScreen = confShareScreen;
    }

    public boolean isConfShareCamera() {
        return this.confShareCamera;
    }

    public void setConfShareCamera(boolean confShareCamera) {
        this.confShareCamera = confShareCamera;
    }

    public boolean isConfHandwritingInShareScreen() {
        return this.confHandwritingInShareScreen;
    }

    public void setConfHandwritingInShareScreen(boolean confHandwritingInShareScreen) {
        this.confHandwritingInShareScreen = confHandwritingInShareScreen;
    }

    public boolean isConfHandwritingInDocView() {
        return this.confHandwritingInDocView;
    }

    public void setConfHandwritingInDocView(boolean confHandwritingInDocView) {
        this.confHandwritingInDocView = confHandwritingInDocView;
    }

    public boolean isConfShareRemoteControl() {
        return this.confShareRemoteControl;
    }

    public void setConfShareRemoteControl(boolean confShareRemoteControl) {
        this.confShareRemoteControl = confShareRemoteControl;
    }

    public boolean isConfShareDocView() {
        return this.confShareDocView;
    }

    public void setConfShareDocView(boolean confShareDocView) {
        this.confShareDocView = confShareDocView;
    }

    public boolean isConfTranslation() {
        return this.confTranslation;
    }

    public void setConfTranslation(boolean confTranslation) {
        this.confTranslation = confTranslation;
    }

    @Override // com.coolots.p2pmsg.model.MsgBody
    public String toString() {
        return StringUtil.classToString(this);
    }
}
