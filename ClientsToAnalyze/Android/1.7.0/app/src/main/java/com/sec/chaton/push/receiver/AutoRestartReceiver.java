package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.p039c.p040a.C0888g;
import com.sec.chaton.push.util.C0921g;

/* loaded from: classes.dex */
public class AutoRestartReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f3093a = AutoRestartReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C0921g.f3117b) {
            C0921g.m3640b(f3093a, String.format("AutoRestartReceiver.onReceive(). Action: %s.", intent.getAction()));
        }
        Context applicationContext = context.getApplicationContext();
        if (C0904h.m3560e((String) null) == null) {
            if (C0921g.f3117b) {
                C0921g.m3640b(f3093a, "Because a registered application doesn't exist in push module, don't start push service.");
                return;
            }
            return;
        }
        if (!PushClientApplication.m3437b().m3439c()) {
            if (C0921g.f3117b) {
                C0921g.m3640b(f3093a, "PushModule hasn't been started. Probably process had been killed by system or user. Start push service.");
            }
            applicationContext.startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
        } else if (!C0888g.m3496a()) {
            if (C0921g.f3117b) {
                C0921g.m3640b(f3093a, "PushModule is started but isn't initialized yet. Execute initialize.");
            }
            try {
                C0896h.m3520a().m3527a(new C0888g(applicationContext));
            } catch (InterruptedException e) {
                if (C0921g.f3119d) {
                    C0921g.m3638a(f3093a, e.getMessage(), e);
                }
            }
        }
    }
}
