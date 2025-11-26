package com.sec.chaton.account;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3216cd;
import com.sec.chaton.util.C3250y;
import java.io.UnsupportedEncodingException;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: ChatONSyncServiceAdapter.java */
/* renamed from: com.sec.chaton.account.g */
/* loaded from: classes.dex */
class C0421g extends AbstractThreadedSyncAdapter {
    public C0421g(Context context) {
        super(context, true);
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        int iM5711a = 0;
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
        C3250y.m11450b("OnPerformSync, Account Name : " + account.name + " Account Type : " + account.type + ", Authority : " + str + ", Mode : " + z2 + "," + z, getClass().getSimpleName());
        C3216cd.m11280a(false);
        C1330h c1330h = new C1330h(null);
        C3250y.m11450b("ChatONSyncServiceAdapter performSync start in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
        if (z2) {
            iM5711a = c1330h.m5711a(RtspHeaders.Values.APPEND, true);
            C3250y.m11450b("ChatONSyncServiceAdapter performSync upload address " + iM5711a + " done in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
        }
        if (z || iM5711a > 0) {
            if (z && z2) {
                c1330h.m5728a(true, 201);
            } else {
                c1330h.m5727a(true);
            }
            C3250y.m11450b("ChatONSyncServiceAdapter performSync getAllBuddies done in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
        }
        if (Long.valueOf(C3159aa.m10962a().m10979a("Setting Sync TimeInMillis", "0")).longValue() == 0) {
            C0423i.m3050b(true);
        }
        C3159aa.m10962a().m10986b("Setting Sync TimeInMillis", String.valueOf(System.currentTimeMillis()));
    }
}
