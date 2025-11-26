package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p054c.C2084e;
import com.sec.chaton.push.util.C2115g;

/* loaded from: classes.dex */
public class AutoRestartReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f8025a = AutoRestartReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C2115g.f8049b) {
            C2115g.m8362b(f8025a, String.format("AutoRestartReceiver.onReceive(). Action: %s.", intent.getAction()));
        }
        Context applicationContext = context.getApplicationContext();
        if (C2099k.m8306e((String) null) == null) {
            if (C2115g.f8049b) {
                C2115g.m8362b(f8025a, "Because a registered application doesn't exist in push module, don't start push service.");
            }
        } else {
            if (!PushClientApplication.m8156h().m8158i()) {
                if (C2115g.f8049b) {
                    C2115g.m8362b(f8025a, "PushModule hasn't been started. Probably process had been killed by system or user. Start push service.");
                }
                applicationContext.startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
                return;
            }
            C2084e.m8219a().m8232b().post(new RunnableC2107a(this, applicationContext));
        }
    }
}
