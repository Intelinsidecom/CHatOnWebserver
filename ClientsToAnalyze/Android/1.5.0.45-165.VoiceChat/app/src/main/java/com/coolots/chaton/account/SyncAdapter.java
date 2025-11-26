package com.coolots.chaton.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.view.ConfigActivity;
import com.sds.coolots.MainApplication;

/* loaded from: classes.dex */
public class SyncAdapter extends AbstractThreadedSyncAdapter {
    private static final String CLASS_NAME = "[SyncAdapter]";
    private final AccountManager mAccountManager;
    private final Context mContext;

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        this.mContext = context;
        this.mAccountManager = AccountManager.get(context);
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        Log.e(CLASS_NAME, "<CIH> onPerformSync()");
        ConfigActivity.setNativeContactChanged(true);
        ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().updateDatabaseForBuddySync();
    }
}
