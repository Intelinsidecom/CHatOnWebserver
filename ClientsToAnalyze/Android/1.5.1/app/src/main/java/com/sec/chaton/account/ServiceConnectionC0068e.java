package com.sec.chaton.account;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.account.e */
/* loaded from: classes.dex */
class ServiceConnectionC0068e extends AbstractThreadedSyncAdapter implements ServiceConnection {

    /* renamed from: a */
    private Context f338a;

    public ServiceConnectionC0068e(Context context) {
        super(context, true);
        this.f338a = context;
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        ChatONLogWriter.m3506b("OnPerformSync, Account Name : " + account.name + " Account Type : " + account.type + ", Authority : " + str, getClass().getSimpleName());
        ChatONSyncServiceAdapter.m401a(this.f338a, account, bundle, str, contentProviderClient, syncResult);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
