package com.coolots.chaton.common.view;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.chaton.common.util.ChatONDialogCheck;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.util.InformationActivityGenerator;
import com.coolots.chaton.common.util.InformationConstantData;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.data.ChatONSettingDataInterface;
import com.coolots.chaton.setting.update.ChatONVApkUpdate;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.coolotsinterface.IInformationActivityGenerator;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Date;

/* loaded from: classes.dex */
public class InformationActivity extends Activity implements InformationConstantData, DisposeInterface {
    private static final String CLASSNAME = "[InformationActivity]";
    public static final String CLASSNAME_INFORMATIONACTIVITY = "com.coolots.chaton.common.view.InformationActivity";
    private Dialog mDialog;
    private ProgressDialog mEntitlementProgressDialog;
    private ProgressDialog mLoginProgressDialog;
    private ChangeDialogReceiver mReceiver = null;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void registerChangeDialogReceiver() {
        unregisterChangeDialogReceiver();
        this.mReceiver = new ChangeDialogReceiver(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(InformationConstantData.BR_INFORMATION_CHANGE_DIALOG);
        registerReceiver(this.mReceiver, intentFilter);
    }

    private void unregisterChangeDialogReceiver() {
        if (this.mReceiver != null) {
            try {
                unregisterReceiver(this.mReceiver);
            } catch (IllegalArgumentException e) {
                logE("IllegalArgumentException \n e");
            }
            this.mReceiver = null;
        }
    }

    private class ChangeDialogReceiver extends BroadcastReceiver {
        private ChangeDialogReceiver() {
        }

        /* synthetic */ ChangeDialogReceiver(InformationActivity informationActivity, ChangeDialogReceiver changeDialogReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals(InformationConstantData.BR_INFORMATION_CHANGE_DIALOG)) {
                InformationActivity.this.logI("BR_INFORMATION_CHANGE_DIALOG");
                if (intent.getExtras().containsKey(InformationConstantData.INFORMATION_POPUP_FINISH_EXTRAS_KEY) && intent.getExtras().getBoolean(InformationConstantData.INFORMATION_POPUP_FINISH_EXTRAS_KEY)) {
                    InformationActivity.this.logI("INFORMATION_POPUP_FINISH_EXTRAS_KEY");
                    InformationActivity.this.dialogDismiss();
                    InformationActivity.this.finish();
                    return;
                }
                if (intent.getExtras().getInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY) == 15) {
                    if (InformationActivity.this.mLoginProgressDialog == null || !InformationActivity.this.mLoginProgressDialog.isShowing()) {
                        return;
                    }
                } else if (intent.getExtras().getInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY) == 23 && (InformationActivity.this.mEntitlementProgressDialog == null || !InformationActivity.this.mEntitlementProgressDialog.isShowing())) {
                    return;
                }
                InformationActivity.this.showAlert(intent);
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        logI("onCreate++");
        getWindow().setFlags(2, 2);
        setContentView(C0000R.layout.call_error_information);
        super.onCreate(savedInstanceState);
        logI("onCreate--");
    }

    @Override // android.app.Activity
    protected void onResume() {
        logI("onResume++");
        super.onResume();
        registerChangeDialogReceiver();
        if (getIntent() == null || getIntent().getExtras() == null) {
            logI("intent is null or extras are null");
        } else {
            if (isWaitingFinishPopup(getIntent().getExtras().getInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY)) || !isShowBusyPopup(getIntent().getExtras().getInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY))) {
                finishActivity();
                return;
            }
            showAlert(getIntent());
        }
        logI("onResume--");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        logI("onNewIntent++");
        setIntent(intent);
        super.onNewIntent(intent);
        logI("onNewIntent--");
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        logI("onConfigurationChanged+++");
        super.onConfigurationChanged(newConfig);
        logI("onConfigurationChanged---");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        logI("finishActivity");
        finish();
        if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        logI("onPause++");
        unregisterChangeDialogReceiver();
        finishActivity();
        super.onPause();
        logI("onPause--");
    }

    @Override // android.app.Activity
    protected void onStop() {
        logI("onStop++");
        super.onStop();
        logI("onStop--");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        logI("onDestroy++");
        dispose();
        super.onDestroy();
        logI("onDestroy--");
    }

    private boolean isWaitingFinishPopup(int reason) {
        if (reason != 15 && reason != 23) {
            return false;
        }
        logI("isWaitingFinishPopup true");
        return true;
    }

    private boolean isShowBusyPopup(int reason) {
        if (reason != 13 || InformationActivityGenerator.getLastPopupStartDate() == null) {
            return true;
        }
        Date current = new Date();
        return current.getTime() - current.getTime() <= 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlert(Intent intent) {
        int memberCnt;
        Bundle extras = intent.getExtras();
        int reason = extras.getInt(InformationConstantData.INFORMATION_POPUP_EXTRAS_KEY);
        logI("showAlert() " + reason);
        switch (reason) {
            case 1:
                logE("INFORMATION_POPUP_NETWORK_FAIL");
                if (MainApplication.mConfig.isUseWifiOnly()) {
                    showAlertBuilder(reason, getString(C0000R.string.information_str_title_1), getString(C0000R.string.join_wifi_connection));
                    break;
                } else {
                    showAlertBuilder(reason, getString(C0000R.string.information_str_title_1), getString(C0000R.string.information_str_msg_1));
                    break;
                }
            case 2:
                logE("INFORMATION_POPUP_AIRPLAIN_MODE_ON");
                showAirPlanAlertBuilder(reason, getString(C0000R.string.information_str_title_2), getString(C0000R.string.information_str_msg_2));
                break;
            case 3:
                logE("INFORMATION_POPUP_3G_CALL_BUSY");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_3), getString(C0000R.string.information_str_msg_3));
                break;
            case 4:
                logE("INFORMATION_POPUP_COOLOTS_CALL_BUSY");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_4), getString(C0000R.string.information_str_msg_4));
                break;
            case 5:
                logE("INFORMATION_POPUP_COOLOTS_INVALID_MEMBER_CNT");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_5), getString(C0000R.string.information_str_msg_5));
                break;
            case 6:
                logE("INFORMATION_POPUP_COOLOTS_OVER_MEMBER_CNT");
                if (extras.getBoolean(InformationConstantData.INFORMATION_POPUP_EXTRAS_IS_VIDEO)) {
                    memberCnt = ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(true);
                } else {
                    memberCnt = ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(false);
                }
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_6), getString(C0000R.string.add_member_maximum, new Object[]{Integer.valueOf(memberCnt)}));
                break;
            case 7:
                logE("INFORMATION_POPUP_COOLOTS_LOGIN");
                showLoginProgressDialog(reason, getString(C0000R.string.information_str_msg_7));
                break;
            case 8:
                logE("INFORMATION_POPUP_COOLOTS_ACCOUNT_NONE");
                showLoginAlertBuilder(reason, getString(C0000R.string.information_str_title_8), getString(C0000R.string.information_str_msg_8));
                break;
            case 9:
                logE("INFORMATION_POPUP_COOLOTS_WRONG_DESTINATION");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_9), getString(C0000R.string.information_str_msg_9));
                break;
            case 10:
                logE("INFORMATION_POPUP_BATTERY_LOW");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_10), getString(C0000R.string.information_str_msg_10));
                break;
            case 11:
                logE("INFORMATION_POPUP_UNKNOWN_ERROR");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_11), getString(C0000R.string.information_str_msg_11));
                break;
            case 12:
                logE("INFORMATION_POPUP_ADD_BUDDY");
                break;
            case 13:
                logE("INFORMATION_POPUP_RECEIVER_CALL_STATE_BUSY");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_13), getString(C0000R.string.information_str_msg_13));
                break;
            case 14:
                logE("INFORMATION_POPUP_PHONENUMBER_TOO_SHORT");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_14), getString(C0000R.string.information_str_msg_14));
                break;
            case 15:
                logE("INFORMATION_POPUP_LOGIN_FAIL");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_7), getString(C0000R.string.information_str_msg_7_1));
                break;
            case 16:
                logE("INFORMATION_POPUP_CHATON_UNINSTALL");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_15), getString(C0000R.string.information_str_msg_15));
                break;
            case 17:
                logE("INFORMATION_POPUP_SERVICE_POLICY_NO_VOICE_CALL");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_16), getString(C0000R.string.information_str_msg_16));
                break;
            case 18:
                logE("INFORMATION_POPUP_SERVICE_POLICY_NO_VIDEO_CALL");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_17), getString(C0000R.string.information_str_msg_17));
                break;
            case 19:
                logE("INFORMATION_POPUP_COOLOTS_CALL_NOT_SUPPORTED_NETWORK");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_3), getString(C0000R.string.unable_make_call_wifi_only_on));
                break;
            case 20:
                logE("INFROMATION_POPUP_P2P_CONNECTION_FAIL");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_18), getString(C0000R.string.network_error_call_end));
                break;
            case 21:
                logE("INFROMATION_POPUP_CHANGE_CONF_TO_P2P_FAIL");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_18), getString(C0000R.string.call_switch_call_reject));
                break;
            case 22:
                logE("INFROMATION_POPUP_ENTITLEMENT_NO_CALL");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_3), getString(C0000R.string.information_str_msg_22, new Object[]{611}));
                break;
            case 23:
                logE("INFROMATION_POPUP_ENTITLEMENT_NETWORK_ERROR");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_3), getString(C0000R.string.information_str_msg_23));
                break;
            case 24:
                logE("INFROMATION_POPUP_NEED_CRITICAL_UPDATE");
                showCriticalUpdateDialog(reason, getString(C0000R.string.information_str_title_1), getString(C0000R.string.version_critical_update_msg));
                break;
            case 25:
                logE("INFROMATION_POPUP_ENTITLEMENT_NETWORK_ERROR");
                showEntitlementProgressDialog(reason, getString(C0000R.string.information_str_msg_24));
                break;
            case 26:
                logE("INFORMATION_POPUP_ENTITLEMENT_NO_CALL_WIFIONLYMODE");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_1), getString(C0000R.string.join_wifi_connection));
                break;
            case 27:
                logI("INFORMATION_POPUP_NO_SUCH_DOWNLOAD_PAGE");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_3), getString(C0000R.string.information_str_msg_25));
                break;
            case 28:
                logI("INFORMATION_POPUP_ENTITLEMENT_CHARGE_ALERT");
                showATNTEntitlementOutgoingAlert();
                break;
            case 29:
                logE("INFROMATION_POPUP_CALL_DISCONNECTED");
                showAlertBuilder(reason, getString(C0000R.string.information_str_title_18), getString(C0000R.string.information_str_msg_18));
                break;
            default:
                logE("Intent error");
                finishActivity();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dialogDismiss() {
        if (this.mDialog != null) {
            logI("mDialog != null");
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        if (this.mLoginProgressDialog != null) {
            logI("mLoginProgressDialog != null");
            this.mLoginProgressDialog.dismiss();
            this.mLoginProgressDialog = null;
        }
        if (this.mEntitlementProgressDialog != null) {
            logI("mEntitleProgressDialog != null");
            this.mEntitlementProgressDialog.dismiss();
            this.mEntitlementProgressDialog = null;
        }
    }

    private void showLoginProgressDialog(int reason, String msg) {
        logI("showLoginProgressDialog()");
        dialogDismiss();
        this.mLoginProgressDialog = new ProgressDialog(this, C0000R.style.ChatOnVProgress);
        this.mLoginProgressDialog.setMessage(msg);
        this.mLoginProgressDialog.setIndeterminate(true);
        this.mLoginProgressDialog.setCancelable(true);
        this.mLoginProgressDialog.setIndeterminateDrawable(getResources().getDrawable(C0000R.drawable.chaton_ani_progress));
        this.mLoginProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.common.view.InformationActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface arg0) {
                InformationActivity.this.logI("onCancel");
                ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().cancelResidualCall();
                arg0.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        this.mLoginProgressDialog.show();
    }

    private void showEntitlementProgressDialog(int reason, String msg) {
        logI("showEntitlementProgressDialog()");
        dialogDismiss();
        this.mEntitlementProgressDialog = ProgressDialog.show(this, null, null);
        this.mEntitlementProgressDialog.setCancelable(true);
        this.mEntitlementProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.common.view.InformationActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface arg0) {
                InformationActivity.this.logI("onCancel");
                ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().cancelEntitlementResidualCall();
                arg0.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        this.mEntitlementProgressDialog.setContentView(C0000R.layout.only_progress);
    }

    private void showAlertBuilder(int reason, String title, String msg) {
        logI("showAlertBuilder()");
        dialogDismiss();
        ChatONDialog.Builder bld = new ChatONDialog.Builder(this);
        bld.setTitle(title);
        bld.setMessage(msg);
        bld.setCancelable(true);
        bld.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.common.view.InformationActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                InformationActivity.this.logI("onClick - OK");
                dialog.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        bld.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.common.view.InformationActivity.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                InformationActivity.this.logI("onCancel");
                dialog.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        this.mDialog = bld.create();
        this.mDialog.show();
    }

    private void showLoginAlertBuilder(int reason, String title, String msg) {
        logI("showLoginAlertBuilder()");
        dialogDismiss();
        ChatONDialog.Builder bld = new ChatONDialog.Builder(this);
        bld.setTitle(title);
        bld.setMessage(msg);
        bld.setCancelable(true);
        bld.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.common.view.InformationActivity.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                InformationActivity.this.logI("onClick - OK");
                dialog.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        bld.setNegativeButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.common.view.InformationActivity.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface arg0, int arg1) {
                InformationActivity.this.logI("onClick - CANCEL");
                arg0.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        bld.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.common.view.InformationActivity.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                InformationActivity.this.logI("onCancel finish()");
                dialog.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        this.mDialog = bld.create();
        this.mDialog.show();
    }

    private void showAirPlanAlertBuilder(int reason, String title, String msg) {
        logI("showAirPlanAlertBuilder()");
        dialogDismiss();
        ChatONDialog.Builder bld = new ChatONDialog.Builder(this);
        bld.setTitle(title);
        bld.setMessage(msg);
        bld.setCancelable(true);
        bld.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.common.view.InformationActivity.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                InformationActivity.this.logI("onClick - OK(airplain mode)");
                InformationActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        bld.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.common.view.InformationActivity.9
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                InformationActivity.this.logI("onCancel finish()");
                dialog.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        this.mDialog = bld.create();
        this.mDialog.show();
    }

    private void showCriticalUpdateDialog(int reason, String title, String msg) {
        logI("showCriticalUpdateDialog");
        dialogDismiss();
        ChatONDialog.Builder bld = new ChatONDialog.Builder(this);
        bld.setTitle(title);
        bld.setMessage(msg);
        bld.setNegativeButton(getResources().getString(C0000R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.common.view.InformationActivity.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        bld.setPositiveButton(getResources().getString(C0000R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.common.view.InformationActivity.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
                ChatONVApkUpdate.getInstance().gotoUpdatePage();
                InformationActivity.this.finishActivity();
            }
        });
        bld.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.common.view.InformationActivity.12
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                InformationActivity.this.logI("onCancel finish()");
                dialog.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        this.mDialog = bld.create();
        this.mDialog.show();
    }

    private void showATNTEntitlementOutgoingAlert() {
        logI("showATNTEntitlementOutgoingAlert");
        dialogDismiss();
        ChatONDialogCheck.Builder checkBuilder = new ChatONDialogCheck.Builder(this);
        checkBuilder.setTitle(getResources().getString(C0000R.string.information_str_title_1));
        checkBuilder.setMessage(getResources().getString(C0000R.string.atnt_entitlement_outgoing_alert_msg));
        checkBuilder.setDoNotShowAgainPrefKey(ChatONSettingDataInterface.PREF_ATNT_POPUP_CHECK);
        checkBuilder.setNegativeButton(C0000R.string.confirm_no, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.common.view.InformationActivity.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                InformationActivity.this.logI("onClick(no)");
                ChatONSettingData.getInstance().setValue(ChatONSettingDataInterface.PREF_ATNT_POPUP_CHOICE, 2);
                IInformationActivityGenerator listener = MainApplication.mInformationActivityGenerator.getClickListener();
                if (listener != null) {
                    MainApplication.mInformationActivityGenerator.getClickListener().onClickCancel(28);
                }
                dialog.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        checkBuilder.setPositiveButton(C0000R.string.confirm_yes, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.common.view.InformationActivity.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                InformationActivity.this.logI("onClick(yes)");
                ChatONSettingData.getInstance().setValue(ChatONSettingDataInterface.PREF_ATNT_POPUP_CHOICE, 1);
                IInformationActivityGenerator listener = MainApplication.mInformationActivityGenerator.getClickListener();
                if (listener != null) {
                    MainApplication.mInformationActivityGenerator.getClickListener().onClickPossitive(28);
                }
                dialog.dismiss();
                InformationActivity.this.finishActivity();
            }
        });
        this.mDialog = checkBuilder.create();
        this.mDialog.show();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        logI("onBackPressed()");
        if (this.mEntitlementProgressDialog != null && this.mEntitlementProgressDialog.isShowing()) {
            ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().cancelEntitlementResidualCall();
        }
        if (this.mLoginProgressDialog != null && this.mLoginProgressDialog.isShowing()) {
            ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().cancelResidualCall();
        }
        finishActivity();
        super.onBackPressed();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        dialogDismiss();
        unregisterChangeDialogReceiver();
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        System.gc();
    }
}
