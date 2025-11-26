package com.sec.chaton.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.sec.chaton.push.util.C1137e;
import com.sec.chaton.push.util.C1139g;
import com.sec.chaton.push.util.EnumC1138f;

/* loaded from: classes.dex */
public class SystemStateMoniter extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f4117a = SystemStateMoniter.class.getSimpleName();

    /* renamed from: b */
    private static EnumC1138f f4118b = EnumC1138f.NoActive;

    /* renamed from: c */
    private static InterfaceC1132c f4119c;

    /* renamed from: a */
    public static synchronized void m4273a(InterfaceC1132c interfaceC1132c) {
        f4119c = interfaceC1132c;
    }

    /* renamed from: a */
    public static synchronized void m4272a() {
        f4118b = C1137e.m4304a();
        if (f4118b == EnumC1138f.NoActive) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4117a, "There isn't active network.");
            }
        } else if (C1139g.f4142a) {
            if (f4118b == EnumC1138f.WIFI) {
                C1139g.m4308a(f4117a, "ConnectType is WIFI.");
            } else if (f4118b == EnumC1138f.Mobile) {
                C1139g.m4308a(f4117a, "ConnectType is 3G.");
            } else {
                C1139g.m4308a(f4117a, "ConnectType is is ETC.");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4117a, "SystemStateMoniter.onReceive().");
        }
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (C1139g.f4142a) {
                C1139g.m4308a(f4117a, String.format("NoConnectivity: %s, NetworkInfo: %s.", Boolean.valueOf(booleanExtra), networkInfo));
            }
            if (booleanExtra) {
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4117a, "No active internet.");
                }
                synchronized (SystemStateMoniter.class) {
                    f4118b = EnumC1138f.NoActive;
                    if (f4119c != null) {
                        f4119c.mo4122a(f4118b, EnumC1138f.NoActive);
                    }
                }
                return;
            }
            if (networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                if (C1139g.f4144c) {
                    C1139g.m4312c(f4117a, "This network state isn't connected. Ignore it.");
                    return;
                }
                return;
            }
            EnumC1138f enumC1138fM4306a = EnumC1138f.m4306a(networkInfo.getType());
            synchronized (SystemStateMoniter.class) {
                if (f4118b == EnumC1138f.Mobile) {
                    if (f4118b == enumC1138fM4306a && C1139g.f4142a) {
                        C1139g.m4308a(f4117a, String.format("CurrentConnectType(%s) == newConnectType(%s).", f4118b, enumC1138fM4306a));
                    }
                } else {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4117a, String.format("CurrentConnectType(%s) != newConnectType(%s).", f4118b, enumC1138fM4306a));
                    }
                    if (f4119c != null) {
                        f4119c.mo4122a(f4118b, enumC1138fM4306a);
                    }
                }
                f4118b = enumC1138fM4306a;
            }
        }
    }
}
