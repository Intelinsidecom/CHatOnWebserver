package com.sec.chaton.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.sec.chaton.push.exception.ConnectionException;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.network.connection.ProvConnectionManager;
import com.sec.chaton.push.network.connection.PushConnectionManager;
import com.sec.chaton.push.util.PushLog;

/* loaded from: classes.dex */
public class SystemStateMoniter extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f2594a = SystemStateMoniter.class.getSimpleName();

    /* renamed from: b */
    private static final HandlerThread f2595b = new HandlerThread("SystemStateMonitorThread");

    /* renamed from: c */
    private static final Handler f2596c;

    static {
        f2595b.start();
        f2596c = new Handler(f2595b.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2862a(Context context, Intent intent) {
        String action = intent.getAction();
        ProvConnectionManager provConnectionManagerM2859c = ((PushClientApplication) context.getApplicationContext()).m2859c();
        PushConnectionManager pushConnectionManagerM2858b = ((PushClientApplication) context.getApplicationContext()).m2858b();
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            PushLog.m3025a(f2594a, "noConnectivity: " + booleanExtra);
            PushLog.m3025a(f2594a, "network: " + networkInfo);
            PushLog.m3025a(f2594a, "initialize ping interval.");
            HeartBeat.m2874b(context);
            if (booleanExtra) {
                PushLog.m3031d(f2594a, "No Active Internet");
                try {
                    provConnectionManagerM2859c.m2982b();
                } catch (ConnectionException e) {
                }
                try {
                    pushConnectionManagerM2858b.m2982b();
                } catch (ConnectionException e2) {
                }
            }
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                PushLog.m3031d(f2594a, "Connectivity type: " + EnumC0358f.m2864a(networkInfo.getType()));
                try {
                    PushLog.m3025a(f2594a, "Prov connection disconnect");
                    provConnectionManagerM2859c.m2982b();
                } catch (ConnectionException e3) {
                }
                try {
                    PushLog.m3025a(f2594a, "Push connection disconnect");
                    pushConnectionManagerM2858b.m2982b();
                } catch (ConnectionException e4) {
                }
                context.getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f2596c.post(new RunnableC0353a(this, context, intent));
    }
}
