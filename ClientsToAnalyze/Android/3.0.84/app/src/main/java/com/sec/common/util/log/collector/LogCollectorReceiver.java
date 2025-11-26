package com.sec.common.util.log.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.common.C3330f;
import com.sec.spp.push.dlc.api.IDlcApi;

/* loaded from: classes.dex */
public class LogCollectorReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f12084a = LogCollectorReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (C3330f.f12033a.f11973c) {
            C3330f.f12033a.m11654b(f12084a, "onReceive()");
        }
        if (intent.getAction().equals(IDlcApi.ACTION_DLC_AVAILABLE)) {
            Intent intent2 = new Intent(context, (Class<?>) LogCollectorSender.class);
            intent2.putExtra("bFlush", true);
            context.startService(intent2);
            return;
        }
        if (!intent.getAction().equals(IDlcApi.ACTION_DLC_UNAVAILABLE) && intent.getAction().equals(context.getPackageName()) && (extras = intent.getExtras()) != null) {
            String string = extras.getString("EXTRA_STR_ACTION", "NULL");
            if (C3330f.f12033a.f11973c) {
                C3330f.f12033a.m11654b("recieve broadcast msg - extra : " + string, f12084a);
            }
            if (string.equals("ACTION_START_ULOG")) {
                if (C3330f.f12033a.f11973c) {
                    C3330f.f12033a.m11654b("intent extra : ACTION_START_URGENT_LOG", f12084a);
                }
                Intent intent3 = new Intent(context, (Class<?>) LogCollectorSender.class);
                intent3.putExtra("bUrgent", true);
                context.startService(intent3);
                return;
            }
            if (string.equals("ACTION_STOP_ULOG") && C3330f.f12033a.f11973c) {
                C3330f.f12033a.m11654b("intent extra : ACTION_STOP_URGENT_LOG", f12084a);
            }
        }
    }
}
