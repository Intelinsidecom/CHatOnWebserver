package com.sec.chaton.account;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.util.C1296as;
import com.sec.chaton.util.C1341p;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: ChatONSyncServiceAdapter.java */
/* renamed from: com.sec.chaton.account.f */
/* loaded from: classes.dex */
class C0237f extends AbstractThreadedSyncAdapter {
    public C0237f(Context context) {
        super(context, true);
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        boolean z;
        boolean z2;
        int iM755a = 0;
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
        C1341p.m4658b("OnPerformSync, Account Name : " + account.name + " Account Type : " + account.type + ", Authority : " + str + ", Mode : " + z2 + "," + z, getClass().getSimpleName());
        C1296as.m4519a(false);
        C0202ao c0202ao = new C0202ao(null);
        C1341p.m4658b("ChatONSyncServiceAdapter performSync start in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
        if (z2) {
            iM755a = c0202ao.m755a(RtspHeaders.Values.APPEND, true);
            C1341p.m4658b("ChatONSyncServiceAdapter performSync upload address " + iM755a + " done in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
        }
        if (z || iM755a > 0) {
            c0202ao.m762a(true);
            C1341p.m4658b("ChatONSyncServiceAdapter performSync getAllBuddies done in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
        }
        c0202ao.m768c(true);
        C1341p.m4658b("ChatONSyncServiceAdapter performSync setExtraInfoIfNeeded done in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
    }
}
