package com.sec.chaton.receiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ScreenReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private String f11525a = ScreenReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            C4904y.m18644d("Screen Receiver ON");
            return;
        }
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            C4904y.m18644d("Screen Receiver OFF");
            try {
                m12763b(context);
            } catch (Exception e) {
                C4904y.m18635a(e, this.f11525a);
            }
        }
    }

    /* renamed from: b */
    private void m12763b(Context context) {
        String strM12764a = m12764a(context);
        if (Config.CHATON_PACKAGE_NAME.equals(strM12764a) || "com.sec.chatonforcanada".equals(strM12764a)) {
            C4892m.m18580d(true);
        } else {
            C4904y.m18641c("Lockstate: false, Do not display password lock screen", this.f11525a);
        }
    }

    /* renamed from: a */
    public String m12764a(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName();
    }
}
