package com.coolots.sso;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.data.ChatONSettingDataInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.entitlement.EntitlementController;
import com.sds.coolots.call.entitlement.IEntitlementResultListener;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.coolotsinterface.IInformationActivityGenerator;
import com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class EntitlementUIController implements IInformationActivityGenerator, DisposeInterface {
    private static final int ENTITLEMENT_TIMER_COUNT_MAX = 5000;
    private IEntitlementUIController mCallInterface;
    private EntitlementHandler mEntitlementHandler;
    private EntitlementResultUIListener mEntitlementResultUIListener = null;
    private Bundle mExtras;
    private boolean mIsOutgoingCall;
    private boolean mIsRetryCall;
    private boolean mIsVideoCall;
    private InformationActivityGeneratorInterface mPopup;

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i("[EntitlementUIController]" + message);
    }

    private void logE(String message) {
        Log.m2963i("[EntitlementUIController]" + message);
    }

    public void start(IEntitlementUIController callInterface, boolean isOutgoingCall, boolean isVideoCall, boolean isRetryCall) {
        logI("start()");
        this.mIsOutgoingCall = isOutgoingCall;
        this.mIsVideoCall = isVideoCall;
        this.mIsRetryCall = isRetryCall;
        this.mCallInterface = callInterface;
        this.mPopup = MainApplication.mInformationActivityGenerator;
        clearEntitlementListener();
        this.mEntitlementResultUIListener = new EntitlementResultUIListener(this, null);
        MainApplication.mPhoneManager.getPhoneStateMachine().checkEntitlement(this.mEntitlementResultUIListener);
    }

    public void startEntitlementTimer() {
        logE("Entitlement Timer scheduling start");
        cancelEntitlementTimer();
        this.mEntitlementHandler = new EntitlementHandler(this, null);
        this.mEntitlementHandler.sendEmptyMessageDelayed(0, Config.DISCONNECT_TIMEOUT);
    }

    public void cancelEntitlementTimer() {
        logE("Entitlement Timer scheduling cancel");
        if (this.mEntitlementHandler != null) {
            this.mEntitlementHandler.removeMessages(0);
            this.mEntitlementHandler.dispose();
            this.mEntitlementHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEntitlementListener() {
        logI("clearEntitlementListener()");
        if (this.mEntitlementResultUIListener != null) {
            this.mEntitlementResultUIListener.dispose();
            this.mEntitlementResultUIListener = null;
        }
    }

    private class EntitlementHandler extends Handler implements DisposeInterface {
        private boolean mDispose;

        private EntitlementHandler() {
            this.mDispose = false;
        }

        /* synthetic */ EntitlementHandler(EntitlementUIController entitlementUIController, EntitlementHandler entitlementHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.mDispose) {
                EntitlementUIController.this.logI("EntitlementHandler TIMEOUT");
                EntitlementUIController.this.clearEntitlementListener();
                if (EntitlementUIController.this.mIsOutgoingCall) {
                    EntitlementUIController.this.mPopup.changeDialogInformationActivity(23);
                }
                EntitlementUIController.this.mCallInterface.onFailToStartCall();
                EntitlementUIController.this.mCallInterface.onEndProcess();
                super.handleMessage(msg);
            }
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            EntitlementUIController.this.logI("dispose()");
            this.mDispose = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void call() {
        this.mCallInterface.onStartCall();
        cancelEntitlementTimer();
        if (this.mIsOutgoingCall) {
            this.mPopup.finishDialogInformationActivity();
        }
        this.mCallInterface.onEndProcess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean userCallConfirmPopup() {
        if (!this.mIsOutgoingCall || !EntitlementController.isATNTDevice() || PhoneManager.isWifiNetworkConnected(MainApplication.mContext) || this.mIsRetryCall) {
            return false;
        }
        logI("userCallConfirmPopup()");
        if (ChatONSettingData.getInstance().isChecked(ChatONSettingDataInterface.PREF_ATNT_POPUP_CHECK)) {
            logI("do not show again is checked");
            int value = ChatONSettingData.getInstance().getValue(ChatONSettingDataInterface.PREF_ATNT_POPUP_CHOICE, 1);
            if (value == 1) {
                logI("yes");
                call();
                return true;
            }
        }
        this.mPopup.setClickListener(this);
        this.mPopup.changeDialogInformationActivity(28);
        return true;
    }

    private class EntitlementResultUIListener implements IEntitlementResultListener, DisposeInterface {
        private boolean mDispose;

        private EntitlementResultUIListener() {
            this.mDispose = false;
        }

        /* synthetic */ EntitlementResultUIListener(EntitlementUIController entitlementUIController, EntitlementResultUIListener entitlementResultUIListener) {
            this();
        }

        @Override // com.sds.coolots.call.entitlement.IEntitlementResultListener
        public void onReceiveEntitlementResult(int resultType) {
            if (!this.mDispose) {
                EntitlementUIController.this.logI("onReceiveEntitlementResult(" + resultType + ")");
                if (resultType == 1) {
                    EntitlementUIController.this.cancelEntitlementTimer();
                    if (!EntitlementUIController.this.userCallConfirmPopup()) {
                        EntitlementUIController.this.call();
                        return;
                    }
                    return;
                }
                if (resultType == 2) {
                    EntitlementUIController.this.cancelEntitlementTimer();
                    if (EntitlementUIController.this.mIsOutgoingCall) {
                        EntitlementUIController.this.mPopup.changeDialogInformationActivity(22);
                    }
                    EntitlementUIController.this.mCallInterface.onFailToStartCall();
                    EntitlementUIController.this.mCallInterface.onEndProcess();
                    return;
                }
                if (resultType == 5) {
                    EntitlementUIController.this.cancelEntitlementTimer();
                    if (EntitlementUIController.this.mIsOutgoingCall) {
                        EntitlementUIController.this.mPopup.changeDialogInformationActivity(26);
                    }
                    EntitlementUIController.this.mCallInterface.onFailToStartCall();
                    EntitlementUIController.this.mCallInterface.onEndProcess();
                    return;
                }
                if (resultType == 3) {
                    EntitlementUIController.this.cancelEntitlementTimer();
                    if (EntitlementUIController.this.mIsOutgoingCall) {
                        EntitlementUIController.this.mPopup.changeDialogInformationActivity(23);
                    }
                    EntitlementUIController.this.mCallInterface.onFailToStartCall();
                    EntitlementUIController.this.mCallInterface.onEndProcess();
                    return;
                }
                if (resultType == 4) {
                    if (EntitlementUIController.this.mIsOutgoingCall) {
                        EntitlementUIController.this.mPopup.changeDialogInformationActivity(25);
                    }
                    EntitlementUIController.this.startEntitlementTimer();
                }
            }
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            EntitlementUIController.this.logI("EntitlementResultUIListener dispose()");
            this.mDispose = true;
        }
    }

    public void setBundle(Bundle extras) {
        logI("setBundle()");
        this.mExtras = extras;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("dispose()");
        cancelEntitlementTimer();
        clearEntitlementListener();
        this.mCallInterface = null;
        this.mPopup = null;
        this.mExtras = null;
    }

    @Override // com.sds.coolots.common.coolotsinterface.IInformationActivityGenerator
    public void onClickPossitive(int action) {
        logI("onClickPossitive " + action);
        this.mPopup.setClickListener(null);
        call();
    }

    @Override // com.sds.coolots.common.coolotsinterface.IInformationActivityGenerator
    public void onClickCancel(int action) {
        logI("onClickCancel " + action);
        this.mPopup.setClickListener(null);
        if (this.mIsOutgoingCall) {
            this.mPopup.finishDialogInformationActivity();
        }
        this.mCallInterface.onEndProcess();
    }
}
