package com.coolots.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.widget.Toast;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.chaton.join.ChatOnVJoinManager;
import com.coolots.chaton.join.ChatOnVJoinManagerInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.model.NationalCode;
import com.sec.chaton.clientapi.NotificationAPI;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class SABroadcastReceiver extends BroadcastReceiver {
    private static final String KEY_BG_RESULT = "bg_result";
    private static final String SAMSUNG_ACCOUNT_ACCOUNT_VIEW = "com.coolots.chaton.tab.MainTabActivity.sa_view";
    private static final String SAMSUNG_ACCOUNT_EMAIL_AUTH = "com.coolots.chaton.tab.MainTabActivity.sa_email";
    public static boolean mdeleteaccount = false;
    private List<NationalCode> mNationalCodeList;
    private TimerTask myTask = null;
    private Timer timer = null;

    private void logE(String message) {
        Log.m2958e("[SABroadcastReceiver]" + message);
    }

    private void logI(String message) {
        Log.m2963i("[SABroadcastReceiver]" + message);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("com.msc.action.samsungaccount.response.BackGroundSignin")) {
            int result = intent.getIntExtra(KEY_BG_RESULT, 0);
            String authcode = intent.getStringExtra("authcode");
            if (result == 1) {
                logE("<<SA>> !!!!!!!!! SamsungAccount result = 1 !!!!!!!!!");
                if (!mdeleteaccount) {
                    Toast.makeText(MainApplication.mContext, "Sign in to your Samsung account to use ChatON V", 0).show();
                    makeTimer();
                    runTimer();
                    mdeleteaccount = true;
                }
            } else if (result == 0) {
                Intent saintent = new Intent(SAMSUNG_ACCOUNT_ACCOUNT_VIEW);
                MainApplication.mContext.sendBroadcast(saintent);
            } else if (result == 13) {
                Intent saintent2 = new Intent(SAMSUNG_ACCOUNT_EMAIL_AUTH);
                MainApplication.mContext.sendBroadcast(saintent2);
            }
            if (authcode != null && !authcode.equals("")) {
                ConfigActivity.setSamsungAccountAuthCode(authcode);
                ((ChatOnVJoinManagerInterface) MainApplication.mPhoneManager.getJoinManager()).sendCreateAccessTokenAsk(authcode);
                return;
            }
            return;
        }
        if (intent.getAction().equals("android.intent.action.SAMSUNGACCOUNT_SIGNOUT_COMPLETED")) {
            logE("<<SA>> !!!!!!!!!!! SamsungAccount Sign-Out !!!!!!!!!!!");
            if (!MainApplication.mConfig.getProfileUserID().equals("") && MainApplication.mConfig.getProfileUserID() != null) {
                removeAllChatONVAccount();
                return;
            }
            return;
        }
        if (intent.getAction().equals("com.msc.action.ACCESSTOKEN_V02_RESPONSE")) {
            logE("<<SA>> !!!!!!!!!!! New SamsungAccount ACCESSTOKEN_V02_RESPONSE !!!!!!!!!!!");
            intent.getIntExtra(NotificationAPI.RESULT_CODE, 0);
            String accessToken = intent.getStringExtra("access_token");
            String userid = intent.getStringExtra("user_id");
            intent.getStringExtra("birthday");
            String email_id = intent.getStringExtra("email_id");
            intent.getStringExtra("mcc");
            if (email_id != null && !email_id.isEmpty() && accessToken != null && !accessToken.isEmpty() && userid != null && !userid.isEmpty()) {
                ConfigActivity.setSamsungAccountAccessToken(accessToken);
                ConfigActivity.setSamsungAccountGUID(userid);
                ConfigActivity.setSamsungAccountID(email_id);
                ((ChatOnVJoinManagerInterface) MainApplication.mPhoneManager.getJoinManager()).sendSAUserInfoAsk(userid, accessToken);
            }
        }
    }

    public static void removeAllChatONVAccount() {
        ConfigActivity.setSamsungAccountAccessToken("");
        ConfigActivity.setSamsungAccountAuthCode("");
        ConfigActivity.setSamsungAccountCountryCode("");
        ConfigActivity.setSamsungAccountGUID("");
        ConfigActivity.setSamsungAccountID("");
        ChatOnVJoinManager joinManager = (ChatOnVJoinManager) MainApplication.mPhoneManager.getJoinManager();
        if (joinManager.isExistChatONVAccount()) {
            joinManager.deleteChatONVAccount();
        } else {
            joinManager.deleteAccount();
        }
    }

    public void makeTimer() {
        if (this.myTask != null) {
            this.myTask.cancel();
            this.myTask = null;
        }
        this.myTask = new TimerTask() { // from class: com.coolots.chaton.SABroadcastReceiver.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SABroadcastReceiver.this.killTimer();
                Process.killProcess(Process.myPid());
            }
        };
    }

    public void runTimer() {
        this.timer = new Timer();
        this.timer.schedule(this.myTask, 3000L);
    }

    public void killTimer() {
        if (this.timer != null) {
            this.timer.cancel();
        }
        if (this.myTask != null) {
            this.myTask.cancel();
        }
        this.timer = null;
        this.myTask = null;
    }
}
