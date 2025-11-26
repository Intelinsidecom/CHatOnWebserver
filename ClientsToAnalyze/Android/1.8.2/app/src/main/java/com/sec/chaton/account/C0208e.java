package com.sec.chaton.account;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.util.C1763bs;
import com.sec.chaton.util.C1786r;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: ChatONSyncServiceAdapter.java */
/* renamed from: com.sec.chaton.account.e */
/* loaded from: classes.dex */
class C0208e extends AbstractThreadedSyncAdapter {
    public C0208e(Context context) {
        super(context, true);
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) throws RemoteException, OperationApplicationException {
        boolean z;
        boolean z2;
        int iM2851a = 0;
        C1786r.m6061b("OnPerformSync, Account Name : " + account.name + " Account Type : " + account.type + ", Authority : " + str, getClass().getSimpleName());
        if (bundle.containsKey("uploadAddress")) {
            z2 = bundle.getBoolean("uploadAddress");
            z = false;
        } else if (bundle.containsKey("getAllBuddies")) {
            z = bundle.getBoolean("getAllBuddies");
            z2 = false;
        } else {
            z = true;
            z2 = true;
        }
        C1763bs.m5971a(false);
        C0633e c0633e = new C0633e(null);
        C1786r.m6061b("ChatONSyncServiceAdapter performSync start in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
        if (z2) {
            iM2851a = c0633e.m2851a(RtspHeaders.Values.APPEND, true);
            C1786r.m6061b("ChatONSyncServiceAdapter performSync upload address " + iM2851a + " done in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
        }
        if (z || iM2851a > 0) {
            c0633e.m2865a(true);
            C1786r.m6061b("ChatONSyncServiceAdapter performSync getAllBuddies done in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
        }
        c0633e.m2882e(true);
        C1786r.m6061b("ChatONSyncServiceAdapter performSync setExtraInfoIfNeeded done in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
        C0660d.m3021a(GlobalApplication.m3260b());
    }
}
