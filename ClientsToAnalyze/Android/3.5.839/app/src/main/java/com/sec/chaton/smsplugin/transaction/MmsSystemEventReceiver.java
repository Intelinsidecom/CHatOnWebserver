package com.sec.chaton.smsplugin.transaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.p136b.C5108d;

/* loaded from: classes.dex */
public class MmsSystemEventReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static MmsSystemEventReceiver f14573a;

    /* renamed from: c */
    private static void m15534c(Context context) {
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a("MmsSystemEventReceiver", "wakeUpService: start transaction service ...");
        }
        context.startService(new Intent(context, (Class<?>) TransactionService.class));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a("MmsSystemEventReceiver", "Intent received: " + intent);
        }
        if (context != null && intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.CONTENT_CHANGED")) {
                Uri uri = (Uri) intent.getParcelableExtra("deleted_contents");
                if (uri != null) {
                    C5108d.m19487b().mo19484b(uri);
                    return;
                }
                return;
            }
            if (action.equals("android.intent.action.ANY_DATA_STATE")) {
                String stringExtra = intent.getStringExtra("state");
                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                    C3890m.m14994a("MmsSystemEventReceiver", "ANY_DATA_STATE event received: " + stringExtra);
                }
                if (stringExtra.equals("CONNECTED")) {
                    m15534c(context);
                    return;
                }
                return;
            }
            if (action.equals("android.intent.action.BOOT_COMPLETED")) {
            }
        }
    }

    /* renamed from: a */
    public static void m15532a(Context context) {
        m15533b(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ANY_DATA_STATE");
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a("MmsSystemEventReceiver", "registerForConnectionStateChanges");
        }
        if (f14573a == null) {
            f14573a = new MmsSystemEventReceiver();
        }
        context.registerReceiver(f14573a, intentFilter);
    }

    /* renamed from: b */
    public static void m15533b(Context context) {
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a("MmsSystemEventReceiver", "unRegisterForConnectionStateChanges");
        }
        if (f14573a != null) {
            try {
                context.unregisterReceiver(f14573a);
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
