package com.sec.chaton.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.push.util.PushLog;
import com.sec.chaton.push.util.ServiceUtil;

/* loaded from: classes.dex */
public class PublicPushClientMoniter extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f2587a = PublicPushClientMoniter.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Uri data = intent.getData();
        PushLog.m3025a(f2587a, "CommonPushMoniter.onReceive()\nAction = " + action + ", Data = " + data);
        if (data.toString().split(":")[1].equals("com.sec.spp.push")) {
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                PushLog.m3025a(f2587a, "Common push is installed. disable services and receivers");
                ServiceUtil.m3039a(context, true);
            } else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                PushLog.m3025a(f2587a, "Common push is uninstalled. enable services and receivers");
                ServiceUtil.m3041b(context, true);
            }
        }
    }
}
