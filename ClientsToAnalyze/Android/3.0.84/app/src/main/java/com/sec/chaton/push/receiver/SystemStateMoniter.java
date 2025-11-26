package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.sec.chaton.push.util.C2113e;
import com.sec.chaton.push.util.C2115g;
import com.sec.chaton.push.util.EnumC2114f;

/* loaded from: classes.dex */
public class SystemStateMoniter extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f8027a = SystemStateMoniter.class.getSimpleName();

    /* renamed from: b */
    private static EnumC2114f f8028b = EnumC2114f.NoActive;

    /* renamed from: c */
    private static InterfaceC2108b f8029c;

    /* renamed from: a */
    public static synchronized void m8326a(InterfaceC2108b interfaceC2108b) {
        f8029c = interfaceC2108b;
    }

    /* renamed from: a */
    public static synchronized void m8325a() {
        f8028b = C2113e.m8355a();
        if (f8028b == EnumC2114f.NoActive) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f8027a, "There isn't active network.");
            }
        } else if (C2115g.f8048a) {
            if (f8028b == EnumC2114f.WIFI) {
                C2115g.m8359a(f8027a, "ConnectType is WIFI.");
            } else if (f8028b == EnumC2114f.Mobile) {
                C2115g.m8359a(f8027a, "ConnectType is 3G.");
            } else {
                C2115g.m8359a(f8027a, "ConnectType is is ETC.");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f8027a, "SystemStateMoniter.onReceive().");
        }
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (C2115g.f8048a) {
                C2115g.m8359a(f8027a, String.format("NoConnectivity: %s, NetworkInfo: %s.", Boolean.valueOf(booleanExtra), networkInfo));
            }
            if (booleanExtra) {
                if (C2115g.f8048a) {
                    C2115g.m8359a(f8027a, "No active internet.");
                }
                synchronized (SystemStateMoniter.class) {
                    f8028b = EnumC2114f.NoActive;
                    if (f8029c != null) {
                        f8029c.mo8166a(f8028b, EnumC2114f.NoActive);
                    }
                }
                return;
            }
            if (networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                if (C2115g.f8050c) {
                    C2115g.m8363c(f8027a, "This network state isn't connected. Ignore it.");
                    return;
                }
                return;
            }
            EnumC2114f enumC2114fM8357a = EnumC2114f.m8357a(networkInfo.getType());
            synchronized (SystemStateMoniter.class) {
                if (f8028b == EnumC2114f.Mobile) {
                    if (f8028b == enumC2114fM8357a && C2115g.f8048a) {
                        C2115g.m8359a(f8027a, String.format("CurrentConnectType(%s) == newConnectType(%s).", f8028b, enumC2114fM8357a));
                    }
                } else {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f8027a, String.format("CurrentConnectType(%s) != newConnectType(%s).", f8028b, enumC2114fM8357a));
                    }
                    if (f8029c != null) {
                        f8029c.mo8166a(f8028b, enumC2114fM8357a);
                    }
                }
                f8028b = enumC2114fM8357a;
            }
        }
    }
}
