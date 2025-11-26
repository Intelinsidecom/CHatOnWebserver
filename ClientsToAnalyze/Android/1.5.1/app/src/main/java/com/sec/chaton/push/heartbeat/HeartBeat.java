package com.sec.chaton.push.heartbeat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.message.processer.ICallback;
import com.sec.chaton.push.message.processer.MessageController;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.push.registration.RegistrationManager;
import com.sec.chaton.push.util.PushLog;

/* loaded from: classes.dex */
public class HeartBeat extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f2613a = HeartBeat.class.getSimpleName();

    /* renamed from: b */
    private static int f2614b = 1;

    /* renamed from: c */
    private static int f2615c = 0;

    /* renamed from: d */
    private static int f2616d = 6;

    /* renamed from: e */
    private static int f2617e = 3;

    /* renamed from: f */
    private static boolean f2618f = false;

    /* renamed from: a */
    public static synchronized boolean m2871a(Context context) {
        if (!f2618f) {
            f2618f = true;
            m2876c();
            m2877d(context);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m2873b(boolean z) {
        PushLog.m3025a(f2613a, String.format("Reestimate PingInterval. Success: %s, Base count: %d, Short base count: %d", Boolean.valueOf(z), Integer.valueOf(f2614b), Integer.valueOf(f2615c)));
        if (z) {
            if (f2615c != 0) {
                PushLog.m3025a(f2613a, "Short base count isn't 0, increase short base count");
                if (f2615c >= f2617e) {
                    PushLog.m3025a(f2613a, "Short base count is exceed limit. limit is " + f2617e);
                    return;
                } else {
                    f2615c++;
                    PushLog.m3025a(f2613a, "Increase short base count: " + f2615c);
                    return;
                }
            }
            PushLog.m3025a(f2613a, "Short base count is 0, increase base count");
            if (f2614b >= 6) {
                PushLog.m3025a(f2613a, "Ping interval is exceed limit");
                return;
            }
            f2614b++;
            PushLog.m3025a(f2613a, "Increase base count: " + f2614b);
            f2616d = f2614b;
            PushLog.m3030c(f2613a, "Re estimate base count max: " + f2616d);
            return;
        }
        if (f2615c != 0) {
            f2615c--;
            PushLog.m3030c(f2613a, "Base count isn't 0, decrease short base count: " + f2615c);
            f2617e = f2615c;
            PushLog.m3030c(f2613a, "Re estimate short base count max: " + f2617e);
            return;
        }
        if (f2614b == f2616d - 1) {
            PushLog.m3030c(f2613a, "Base count equals (estimated base count max - 1), initilaize ping variables.");
            PushLog.m3030c(f2613a, "Base count: " + f2614b + ", Estimated base count max: " + f2616d);
            m2876c();
            return;
        }
        f2614b--;
        f2615c++;
        PushLog.m3030c(f2613a, "Short base count is 0, decrease base count and increase short base count");
        PushLog.m3030c(f2613a, "Base count: " + f2614b + ", Short base count: " + f2615c);
        if (f2614b <= 0) {
            m2876c();
            PushLog.m3030c(f2613a, "Base count is 0, init ping interval");
        }
    }

    /* renamed from: b */
    public static synchronized boolean m2874b(Context context) {
        boolean z;
        m2878e(context);
        if (f2618f) {
            f2618f = false;
            m2876c();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    private static void m2876c() {
        f2614b = 1;
        f2615c = 0;
        f2616d = 6;
        f2617e = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static long m2877d(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("com.sec.chaton.push.HEARTBEAT_ACTION"), 0);
        long j = ((f2614b * 8) + (f2615c * 2)) * 60000;
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
        PushLog.m3025a(f2613a, "Rescheduling... heartbeat interval: " + j + ", next ping time: " + jElapsedRealtime);
        alarmManager.set(2, jElapsedRealtime, broadcast);
        return jElapsedRealtime;
    }

    /* renamed from: e */
    private static void m2878e(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent("com.sec.chaton.push.HEARTBEAT_ACTION"), 0));
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(Context context, Intent intent) {
        if (RegistrationManager.m3012b(context) == null) {
            PushLog.m3028b(f2613a, "Because a registered application doesn't exist in push module, stop HeartBeat.");
            m2874b(context);
        } else if (((PushClientApplication) context.getApplicationContext()).m2857a()) {
            PushLog.m3025a(f2613a, "Send ping by heart beat.");
            PushLog.m3025a(f2613a, "PushModule information");
            PushLog.m3025a(f2613a, "======================");
            try {
                PushLog.m3025a(f2613a, "PushModule Version: 0.5.2");
                PushLog.m3025a(f2613a, "PushServer: " + ProvisioningManager.m3003e(context) + ":" + ProvisioningManager.m3004f(context));
                PushLog.m3025a(f2613a, "Device token: " + ProvisioningManager.m3002d(context));
                PushLog.m3025a(f2613a, "Application id: " + RegistrationManager.m3012b(context));
                PushLog.m3025a(f2613a, "Registration id: " + RegistrationManager.m3015d(context));
                PushLog.m3025a(f2613a, "Base count: " + f2614b);
                PushLog.m3025a(f2613a, "Short base count: " + f2615c + ", Short base count max: " + f2617e);
            } catch (Throwable th) {
            }
            PushLog.m3025a(f2613a, "======================");
            MessageController.m2911p().m2922a(true, (ICallback) new C0361a(context));
        } else {
            PushLog.m3028b(f2613a, "PushModule hasn't been started. Probably process had been killed by system. Start service.");
            m2874b(context);
            context.getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
        }
    }
}
