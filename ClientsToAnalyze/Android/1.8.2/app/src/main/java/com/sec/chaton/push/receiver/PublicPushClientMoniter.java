package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.util.C1139g;
import com.sec.chaton.push.util.C1141i;

/* loaded from: classes.dex */
public class PublicPushClientMoniter extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f4116a = PublicPushClientMoniter.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Uri data = intent.getData();
        if (C1139g.f4142a) {
            C1139g.m4308a(f4116a, "PublicPushClientMoniter.onReceive()");
            C1139g.m4308a(f4116a, String.format("Action = %s, Data = %s.", action, data));
        }
        if (data.toString().split(":")[1].equals("com.sec.spp.push")) {
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4116a, "Public push client is installed. disable services and receivers.");
                }
                if (mo4270a() == null) {
                    C1141i.m4317a(PushClientApplication.m4111g(), true);
                    return;
                } else {
                    C1141i.m4318a(PushClientApplication.m4111g(), true, mo4270a(), mo4271b());
                    return;
                }
            }
            if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4116a, "Public push client is uninstalled. enable services and receivers.");
                }
                if (mo4270a() == null) {
                    C1141i.m4320b(PushClientApplication.m4111g(), true);
                } else {
                    C1141i.m4321b(PushClientApplication.m4111g(), true, mo4270a(), mo4271b());
                }
            }
        }
    }

    /* renamed from: a */
    protected Intent mo4270a() {
        return null;
    }

    /* renamed from: b */
    protected int mo4271b() {
        return -1;
    }
}
