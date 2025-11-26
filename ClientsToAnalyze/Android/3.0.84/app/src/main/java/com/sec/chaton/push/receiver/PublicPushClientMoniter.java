package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.push.util.C2115g;
import com.sec.chaton.push.util.C2117i;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class PublicPushClientMoniter extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f8026a = PublicPushClientMoniter.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Uri data = intent.getData();
        if (C2115g.f8048a) {
            C2115g.m8359a(f8026a, "PublicPushClientMoniter.onReceive()");
            C2115g.m8359a(f8026a, String.format("Action = %s, Data = %s.", action, data));
        }
        if (data.toString().split(":")[1].equals("com.sec.spp.push")) {
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                if (C2115g.f8048a) {
                    C2115g.m8359a(f8026a, "Public push client is installed. disable services and receivers.");
                }
                if (mo8323a() == null) {
                    C2117i.m8368a(CommonApplication.m11493l(), true);
                    return;
                } else {
                    C2117i.m8369a(CommonApplication.m11493l(), true, mo8323a(), mo8324b());
                    return;
                }
            }
            if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                if (C2115g.f8048a) {
                    C2115g.m8359a(f8026a, "Public push client is uninstalled. enable services and receivers.");
                }
                if (mo8323a() == null) {
                    C2117i.m8371b(CommonApplication.m11493l(), true);
                } else {
                    C2117i.m8372b(CommonApplication.m11493l(), true, mo8323a(), mo8324b());
                }
            }
        }
    }

    /* renamed from: a */
    protected Intent mo8323a() {
        return null;
    }

    /* renamed from: b */
    protected int mo8324b() {
        return -1;
    }
}
