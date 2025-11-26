package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p094c.C3084e;
import com.sec.chaton.push.util.C3115g;

/* loaded from: classes.dex */
public class AutoRestartReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f11435a = AutoRestartReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C3115g.f11459b) {
            C3115g.m12704b(f11435a, String.format("AutoRestartReceiver.onReceive(). Action: %s.", intent.getAction()));
        }
        Context applicationContext = context.getApplicationContext();
        if (C3099k.m12648e((String) null) == null) {
            if (C3115g.f11459b) {
                C3115g.m12704b(f11435a, "Because a registered application doesn't exist in push module, don't start push service.");
            }
        } else {
            if (!PushClientApplication.m12499n().m12501o()) {
                if (C3115g.f11459b) {
                    C3115g.m12704b(f11435a, "PushModule hasn't been started. Probably process had been killed by system or user. Start push service.");
                }
                applicationContext.startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
                return;
            }
            C3084e.m12562a().m12575b().post(new RunnableC3107a(this, applicationContext));
        }
    }
}
