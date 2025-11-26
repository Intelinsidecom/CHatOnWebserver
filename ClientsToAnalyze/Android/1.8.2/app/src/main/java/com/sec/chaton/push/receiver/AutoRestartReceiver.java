package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.p044c.p045a.C1101b;
import com.sec.chaton.push.util.C1139g;

/* loaded from: classes.dex */
public class AutoRestartReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f4115a = AutoRestartReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C1139g.f4143b) {
            C1139g.m4311b(f4115a, String.format("AutoRestartReceiver.onReceive(). Action: %s.", intent.getAction()));
        }
        Context applicationContext = context.getApplicationContext();
        if (C1126j.m4262e((String) null) == null) {
            if (C1139g.f4143b) {
                C1139g.m4311b(f4115a, "Because a registered application doesn't exist in push module, don't start push service.");
                return;
            }
            return;
        }
        if (!PushClientApplication.m4112h().m4114i()) {
            if (C1139g.f4143b) {
                C1139g.m4311b(f4115a, "PushModule hasn't been started. Probably process had been killed by system or user. Start push service.");
            }
            applicationContext.startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
        } else if (!C1101b.m4155d()) {
            if (C1139g.f4143b) {
                C1139g.m4311b(f4115a, "PushModule is started but isn't initialized yet. Execute initialize.");
            }
            try {
                C1115i.m4196a().m4203a(new C1101b(applicationContext));
            } catch (InterruptedException e) {
                if (C1139g.f4145d) {
                    C1139g.m4309a(f4115a, e.getMessage(), e);
                }
            }
        }
    }
}
