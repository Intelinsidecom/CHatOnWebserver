package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.sec.chaton.push.util.C0920f;
import com.sec.chaton.push.util.C0921g;
import com.sec.chaton.push.util.EnumC0918d;

/* loaded from: classes.dex */
public class SystemStateMoniter extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f3095a = SystemStateMoniter.class.getSimpleName();

    /* renamed from: b */
    private static EnumC0918d f3096b = EnumC0918d.NoActive;

    /* renamed from: c */
    private static InterfaceC0913b f3097c;

    /* renamed from: a */
    public static synchronized void m3600a(InterfaceC0913b interfaceC0913b) {
        f3097c = interfaceC0913b;
    }

    /* renamed from: a */
    public static synchronized void m3599a() {
        f3096b = C0920f.m3634a();
        if (f3096b == EnumC0918d.NoActive) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3095a, "There isn't active network.");
            }
        } else if (C0921g.f3116a) {
            if (f3096b == EnumC0918d.WIFI) {
                C0921g.m3637a(f3095a, "ConnectType is WIFI.");
            } else if (f3096b == EnumC0918d.Mobile) {
                C0921g.m3637a(f3095a, "ConnectType is 3G.");
            } else {
                C0921g.m3637a(f3095a, "ConnectType is is ETC.");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3095a, "SystemStateMoniter.onReceive().");
        }
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (C0921g.f3116a) {
                C0921g.m3637a(f3095a, String.format("NoConnectivity: %s, NetworkInfo: %s.", Boolean.valueOf(booleanExtra), networkInfo));
            }
            if (booleanExtra) {
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3095a, "No active internet.");
                }
                synchronized (SystemStateMoniter.class) {
                    f3096b = EnumC0918d.NoActive;
                    if (f3097c != null) {
                        f3097c.mo3467a(f3096b, EnumC0918d.NoActive);
                    }
                }
                return;
            }
            if (networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                if (C0921g.f3118c) {
                    C0921g.m3641c(f3095a, "This network state isn't connected. Ignore it.");
                    return;
                }
                return;
            }
            EnumC0918d enumC0918dM3619a = EnumC0918d.m3619a(networkInfo.getType());
            synchronized (SystemStateMoniter.class) {
                if (f3096b == EnumC0918d.Mobile) {
                    if (f3096b == enumC0918dM3619a && C0921g.f3116a) {
                        C0921g.m3637a(f3095a, String.format("CurrentConnectType(%s) == newConnectType(%s).", f3096b, enumC0918dM3619a));
                    }
                } else {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3095a, String.format("CurrentConnectType(%s) != newConnectType(%s).", f3096b, enumC0918dM3619a));
                    }
                    if (f3097c != null) {
                        f3097c.mo3467a(f3096b, enumC0918dM3619a);
                    }
                }
                f3096b = enumC0918dM3619a;
            }
        }
    }
}
