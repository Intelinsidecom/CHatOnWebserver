package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.util.C0915a;
import com.sec.chaton.push.util.C0921g;

/* loaded from: classes.dex */
public class PublicPushClientMoniter extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f3094a = PublicPushClientMoniter.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Uri data = intent.getData();
        if (C0921g.f3116a) {
            C0921g.m3637a(f3094a, "PublicPushClientMoniter.onReceive()");
            C0921g.m3637a(f3094a, String.format("Action = %s, Data = %s.", action, data));
        }
        if (data.toString().split(":")[1].equals("com.sec.spp.push")) {
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3094a, "Public push client is installed. disable services and receivers.");
                }
                if (mo3597a() == null) {
                    C0915a.m3607a(PushClientApplication.m3436a(), true);
                    return;
                } else {
                    C0915a.m3608a(PushClientApplication.m3436a(), true, mo3597a(), mo3598b());
                    return;
                }
            }
            if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3094a, "Public push client is uninstalled. enable services and receivers.");
                }
                if (mo3597a() == null) {
                    C0915a.m3610b(PushClientApplication.m3436a(), true);
                } else {
                    C0915a.m3611b(PushClientApplication.m3436a(), true, mo3597a(), mo3598b());
                }
            }
        }
    }

    /* renamed from: a */
    protected Intent mo3597a() {
        return null;
    }

    /* renamed from: b */
    protected int mo3598b() {
        return -1;
    }
}
