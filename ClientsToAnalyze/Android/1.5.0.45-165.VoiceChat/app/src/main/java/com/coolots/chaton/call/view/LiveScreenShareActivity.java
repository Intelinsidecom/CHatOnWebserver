package com.coolots.chaton.call.view;

import android.os.Bundle;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.CallUserAddedInfo;
import com.coolots.chaton.call.view.layout.IncomingLiveSreenShareSlidingWidget;
import com.coolots.chaton.call.view.layout.voice.LiveScreenShareIncomingLayout;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.ConsentDisplayInfo;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.util.Log;
import java.util.Date;

/* loaded from: classes.dex */
public class LiveScreenShareActivity extends ChatOnCallActivity {
    private static final String CLASSNAME = "[LiveScreenShareActivity]";
    private LiveScreenShareIncomingLayout mCallIncomingLayout;
    private IncomingLiveSreenShareSlidingWidget mCallReceiveBtnLayout;
    public CallDisplayUserInfo mCalluserInfo;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws Throwable {
        super.onCreate(savedInstanceState);
        if (checkCallInstance() == 1) {
            finish();
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        if (!isShowActivity()) {
            finish();
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        setContentView(C0000R.layout.live_share_screen_call);
        initActivity();
    }

    public boolean isShowActivity() {
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(this.mCallStatusData);
        return this.mCallStatusData.isValidity() && !this.mCallStatusData.isOutGoingCall() && this.mCallStatusData.getCallState() == 1;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setOptionMenu(int menuId) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void hideNativeCallLayout() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void accpetNativeCall() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void makeHideMeImage() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void startRecordCallAfterConsent() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void rejectRecordCall() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setRecordStatement() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setRecordStatus(boolean isRecord) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void closeThemeShotEmotionalAnimation() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setMenuBtnEnable(boolean enable) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void initPinchZoomControllerSwitchCamera() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected int calculateDuration() {
        return 0;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void clickableHoldButton() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void denyCall() {
        MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(this.mDestination, this.mCallID, false, 100, MainApplication.mConfig.isSecureCommunication(), "");
        finish();
        if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void denyCallwithRejectMsg(int arg0, String arg1) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void disableBTButton() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void disableSpeakerButton() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void enableSpeakerButton() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void gotoBlueToothSettingPage() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleEarphonePlugged(boolean arg0) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handlePopupCloseForCallSwitch() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupCall() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupLowBattery() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void initActivity() throws Throwable {
        checkHookingHomeKey(true);
        this.mCalluserInfo = getCallOtherPartyUserInfo();
        this.mCallIncomingLayout = (LiveScreenShareIncomingLayout) findViewById(C0000R.id.voice_call_incoming);
        this.mCallIncomingLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
        setCallerImageHandler();
        this.mCallReceiveBtnLayout = (IncomingLiveSreenShareSlidingWidget) findViewById(C0000R.id.voice_call_receivebtn);
        this.mCallReceiveBtnLayout.initialize(this, this.mDestination, this.mCalluserInfo);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void notifyConsentAccept(int arg0, int arg1, ConsentDisplayInfo arg2) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void notifyConsentReject(int arg0, int arg1, ConsentDisplayInfo arg2) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void notifyConsentRequestAskReceive(int arg0, int arg1, String arg2) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void offBTButton() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void onBTButton() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void receiveCall() {
        MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(this.mDestination, this.mCallID, true, 10, MainApplication.mConfig.isSecureCommunication(), "");
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void setDisplayDialog(int arg0) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void setHideMe() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void setShowMe() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallEndAnimation() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallHoldOnStateToast() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallHoldRetrievedStateToast() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallIncomingAnimation() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showConnectDialog(int arg0) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showDialPad(boolean arg0) {
    }

    private void setCallerImageHandler() throws Throwable {
        this.mCallIncomingLayout.setCallerImage(this.mCalluserInfo.userNo);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showToastForShareView(int arg0, String arg1) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void startShareView(boolean arg0) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopRecord() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopRecordingForCallSwitching() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopShareView() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void toggleCamera() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void updateHoldState(boolean arg0) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void updateMuteState(boolean arg0) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void updateUIComponent() {
        if (CallState.isDisconnected(this.mCallState)) {
            checkHookingHomeKey(false);
            finish();
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                overridePendingTransition(0, 0);
            }
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleRecognitionStart(TranslationDisplayData data) {
        logI("handleRecognitionStart()");
        logI(data.toString());
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleRecognitionEnd(TranslationDisplayData data) {
        logI("handleRecognitionEnd() " + data.getRecognizedText());
        logI(data.toString());
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleRecognitionStop() {
        logI("handleRecognitionStop() ");
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTranslationStart(TranslationDisplayData data) {
        logI("handleTranslationStart()");
        logI(data.toString());
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTranslationEnd(TranslationDisplayData data) {
        logI("handleTranslationEnd() " + data.getRecognizedText() + ",  " + data.getTranslatedText());
        logI(data.toString());
        showToast(String.valueOf(data.getRecognizedText()) + " \n " + data.getTranslatedText());
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTTSStart(String id) {
        logI("handleTTSStart()");
        logI(id);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTTSEnd(String id) {
        logI("handleTTSEnd()");
        logI(id);
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity
    public void updateUserAddedInfo(Destination destination, String myDisplayName) {
        if (this.mUserAddedInfo == null) {
            this.mUserAddedInfo = new CallUserAddedInfo(isConference(), this.mDestination, this.mCallStatusData.getHostDisplayName());
        } else {
            this.mUserAddedInfo.update(isConference(), this.mDestination);
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void startFadeInAnimation() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void startFadeOutAnimation() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public boolean isRecordingVideo() {
        return false;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void airCallSweepRight() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void airCallHandShape() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setOptionMenuDialog(int menuId) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public boolean isCartoonView() {
        return false;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setClearCover() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setAlterImage() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void displayShareScreenAttention() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupEntitlement() {
        showToast(C0000R.string.information_str_msg_23);
        hangupCall();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupNetworkErrorEntitlement() {
        showToast(C0000R.string.information_str_msg_23);
        hangupCall();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public long getNowDateSetting() {
        Date d = MainApplication.mPhoneManager.getPhoneStateMachine().getCallConnectedTime();
        if (d == null) {
            return 0L;
        }
        Date dN = new Date();
        dNow = dN.getTime() - d.getTime();
        return dNow;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void setMuteStateForVideo(boolean muteOn) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setHangUpCallUI() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void removeRecordUI() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void errorForUI() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void startRecordTime() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopRecordFromEngine() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public boolean isShowingAnimationMenu() {
        return false;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void updateChangeCall() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void cancelSlectedThemeShot() {
    }
}
