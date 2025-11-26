package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.push.util.C3117i;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class PublicPushClientMoniter extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f11436a = PublicPushClientMoniter.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Uri data = intent.getData();
        if (C3115g.f11458a) {
            C3115g.m12701a(f11436a, "PublicPushClientMoniter.onReceive()");
            C3115g.m12701a(f11436a, String.format("Action = %s, Data = %s.", action, data));
        }
        if (data.toString().split(":")[1].equals("com.sec.spp.push")) {
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11436a, "Public push client is installed. disable services and receivers.");
                }
                if (mo12665a() == null) {
                    C3117i.m12710a(CommonApplication.m18732r(), true);
                    return;
                } else {
                    C3117i.m12711a(CommonApplication.m18732r(), true, mo12665a(), mo12666b());
                    return;
                }
            }
            if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11436a, "Public push client is uninstalled. enable services and receivers.");
                }
                if (mo12665a() == null) {
                    C3117i.m12713b(CommonApplication.m18732r(), true);
                } else {
                    C3117i.m12714b(CommonApplication.m18732r(), true, mo12665a(), mo12666b());
                }
            }
        }
    }

    /* renamed from: a */
    protected Intent mo12665a() {
        return null;
    }

    /* renamed from: b */
    protected int mo12666b() {
        return -1;
    }
}
