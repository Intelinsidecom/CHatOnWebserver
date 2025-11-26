package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.sec.chaton.smsplugin.C3847e;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SmsReceiver extends BroadcastReceiver {

    /* renamed from: b */
    static PowerManager.WakeLock f14575b;

    /* renamed from: d */
    private static volatile SmsReceiver f14577d;

    /* renamed from: a */
    static final Object f14574a = new Object();

    /* renamed from: c */
    private static final String f14576c = SmsReceiver.class.getSimpleName();

    /* renamed from: a */
    public static SmsReceiver m15542a() {
        if (f14577d == null) {
            synchronized (SmsReceiver.class) {
                if (f14577d == null) {
                    f14577d = new SmsReceiver();
                }
            }
        }
        return f14577d;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && intent.getAction() != null) {
            m15545a(context, intent, false, true, false);
        }
    }

    /* renamed from: a */
    protected void m15545a(Context context, Intent intent, boolean z, boolean z2, boolean z3) {
        String action = intent.getAction();
        if (z || (!action.equals("android.provider.Telephony.SMS_RECEIVED") && !action.equals("android.provider.Telephony.SMS_DELIVER"))) {
            intent.putExtra("result", getResultCode());
            intent.putExtra("extra_is_spam", z3);
            if (!C3847e.m14686ar() && z && !z2 && !z3) {
                intent.setClass(context, SmsRetrieveService.class);
                m15544a(context, intent);
            } else {
                if (z) {
                    abortBroadcast();
                }
                intent.setClass(context, SmsReceiverService.class);
                m15544a(context, intent);
            }
        }
    }

    /* renamed from: a */
    public static void m15544a(Context context, Intent intent) {
        synchronized (f14574a) {
            if (f14575b == null) {
                f14575b = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "StartingAlertService");
                f14575b.setReferenceCounted(false);
            }
            f14575b.acquire();
            context.startService(intent);
        }
    }

    /* renamed from: a */
    public static void m15543a(Service service, int i) {
        synchronized (f14574a) {
            if (f14575b != null && service.stopSelfResult(i)) {
                f14575b.release();
            }
        }
    }
}
