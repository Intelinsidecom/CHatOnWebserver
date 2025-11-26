package com.coolots.chaton.account;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.sds.coolots.MainApplication;

/* loaded from: classes.dex */
public class Authenticator extends AbstractAccountAuthenticator {
    private static final String CLASS_NAME = "[Authenticator]";
    private static final int EVENT_SUICIDE = 1024;
    private DisposeHandler disposeHandler;

    private static class DisposeHandler extends Handler {
        private DisposeHandler() {
        }

        /* synthetic */ DisposeHandler(DisposeHandler disposeHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 1024) {
                Log.e(Authenticator.CLASS_NAME, "<CIH> killProcess");
                Process.killProcess(Process.myPid());
            }
        }
    }

    public Authenticator(Context context) {
        super(context);
        this.disposeHandler = new DisposeHandler(null);
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType, String[] requiredFeatures, Bundle options) throws NetworkErrorException {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(new ComponentName("com.coolots.chaton", "com.coolots.chaton.tab.MainTabActivity"));
        intent.setFlags(268435456);
        MainApplication.mContext.startActivity(intent);
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle confirmCredentials(AccountAuthenticatorResponse response, Account account, Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle editProperties(AccountAuthenticatorResponse response, String accountType) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public String getAuthTokenLabel(String authTokenType) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle hasFeatures(AccountAuthenticatorResponse response, Account account, String[] features) throws NetworkErrorException {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse response, Account account) throws NetworkErrorException {
        Log.e(CLASS_NAME, "<CIH> remove account!");
        Bundle result = new Bundle();
        result.putBoolean("booleanResult", true);
        MainApplication.mPhoneManager.getJoinManager().deleteAccount();
        VAppPhoneManager.stopCoolotsService(MainApplication.mContext);
        this.disposeHandler.sendEmptyMessageDelayed(1024, 1000L);
        return result;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle updateCredentials(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        return null;
    }
}
