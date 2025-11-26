package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.sec.chaton.push.util.C3113e;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.push.util.EnumC3114f;

/* loaded from: classes.dex */
public class SystemStateMoniter extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f11437a = SystemStateMoniter.class.getSimpleName();

    /* renamed from: b */
    private static EnumC3114f f11438b = EnumC3114f.NoActive;

    /* renamed from: c */
    private static InterfaceC3108b f11439c;

    /* renamed from: a */
    public static synchronized void m12668a(InterfaceC3108b interfaceC3108b) {
        f11439c = interfaceC3108b;
    }

    /* renamed from: a */
    public static synchronized void m12667a() {
        f11438b = C3113e.m12697a();
        if (f11438b == EnumC3114f.NoActive) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11437a, "There isn't active network.");
            }
        } else if (C3115g.f11458a) {
            if (f11438b == EnumC3114f.WIFI) {
                C3115g.m12701a(f11437a, "ConnectType is WIFI.");
            } else if (f11438b == EnumC3114f.Mobile) {
                C3115g.m12701a(f11437a, "ConnectType is 3G.");
            } else {
                C3115g.m12701a(f11437a, "ConnectType is is ETC.");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11437a, "SystemStateMoniter.onReceive().");
        }
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (C3115g.f11458a) {
                C3115g.m12701a(f11437a, String.format("NoConnectivity: %s, NetworkInfo: %s.", Boolean.valueOf(booleanExtra), networkInfo));
            }
            if (booleanExtra) {
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11437a, "No active internet.");
                }
                synchronized (SystemStateMoniter.class) {
                    f11438b = EnumC3114f.NoActive;
                    if (f11439c != null) {
                        f11439c.mo12509a(f11438b, EnumC3114f.NoActive);
                    }
                }
                return;
            }
            if (networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                if (C3115g.f11460c) {
                    C3115g.m12705c(f11437a, "This network state isn't connected. Ignore it.");
                    return;
                }
                return;
            }
            EnumC3114f enumC3114fM12699a = EnumC3114f.m12699a(networkInfo.getType());
            synchronized (SystemStateMoniter.class) {
                if (f11438b == EnumC3114f.Mobile) {
                    if (f11438b == enumC3114fM12699a && C3115g.f11458a) {
                        C3115g.m12701a(f11437a, String.format("CurrentConnectType(%s) == newConnectType(%s).", f11438b, enumC3114fM12699a));
                    }
                } else {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11437a, String.format("CurrentConnectType(%s) != newConnectType(%s).", f11438b, enumC3114fM12699a));
                    }
                    if (f11439c != null) {
                        f11439c.mo12509a(f11438b, enumC3114fM12699a);
                    }
                }
                f11438b = enumC3114fM12699a;
            }
        }
    }
}
