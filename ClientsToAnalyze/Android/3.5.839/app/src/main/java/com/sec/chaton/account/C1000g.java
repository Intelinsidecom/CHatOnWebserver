package com.sec.chaton.account;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4904y;
import java.io.UnsupportedEncodingException;

/* compiled from: ChatONSyncServiceAdapter.java */
/* renamed from: com.sec.chaton.account.g */
/* loaded from: classes.dex */
class C1000g extends AbstractThreadedSyncAdapter {
    public C1000g(Context context) {
        super(context, true);
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) throws UnsupportedEncodingException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C4904y.m18639b("OnPerformSync run " + Boolean.toString(jCurrentTimeMillis - C4809aa.m18104a().m18118a("Setting Performsync Time", 0L) > 604800000), getClass().getSimpleName());
        if (C4809aa.m18104a().m18119a("buddy_request_sync_in_chaton", (Boolean) false).booleanValue() || jCurrentTimeMillis - C4809aa.m18104a().m18118a("Setting Performsync Time", 0L) > 604800000) {
            boolean z = false;
            boolean z2 = false;
            if (bundle.containsKey("uploadAddress")) {
                z = bundle.getBoolean("uploadAddress");
            } else if (bundle.containsKey("getAllBuddies")) {
                z2 = bundle.getBoolean("getAllBuddies");
            } else {
                z = true;
                z2 = true;
            }
            C4904y.m18639b("OnPerformSync, Account Name : " + account.name + " Account Type : " + account.type + ", Authority : " + str + ", Mode : " + z + "," + z2, getClass().getSimpleName());
            C4865cc.m18447a(false);
            C2128i c2128i = new C2128i(null);
            C4904y.m18639b("ChatONSyncServiceAdapter performSync start in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
            int iM9484a = 0;
            if (z) {
                iM9484a = c2128i.m9484a("append", true);
                C4904y.m18639b("ChatONSyncServiceAdapter performSync upload address " + iM9484a + " done in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
            }
            if (z2 || iM9484a > 0) {
                if (z2 && z) {
                    c2128i.m9505a(false, 201);
                } else {
                    c2128i.m9504a(false);
                }
                C4904y.m18639b("ChatONSyncServiceAdapter performSync getAllBuddies done in thread " + Thread.currentThread().getName(), getClass().getSimpleName());
            }
            if (Long.valueOf(C4809aa.m18104a().m18121a("Setting Sync TimeInMillis", Spam.ACTIVITY_CANCEL)).longValue() == 0) {
                C1002i.m6069b(true);
            }
            if (!C4809aa.m18104a().m18119a("buddy_request_sync_in_chaton", (Boolean) false).booleanValue()) {
                C4809aa.m18104a().m18124a("Setting Performsync Time", Long.valueOf(jCurrentTimeMillis));
            }
            C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) false);
        }
        C4809aa.m18104a().m18128b("Setting Sync TimeInMillis", String.valueOf(System.currentTimeMillis()));
    }
}
