package com.sec.chaton.push.heartbeat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.p044c.InterfaceC1108b;
import com.sec.chaton.push.p044c.p045a.C1104e;
import com.sec.chaton.push.receiver.C1130a;
import com.sec.chaton.push.receiver.InterfaceC1131b;
import com.sec.chaton.push.util.C1137e;
import com.sec.chaton.push.util.C1139g;
import com.sec.chaton.push.util.EnumC1138f;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class HeartBeat extends BroadcastReceiver {

    /* renamed from: c */
    private static boolean f4097c;

    /* renamed from: d */
    private static EnumC1138f f4098d;

    /* renamed from: e */
    private static String f4099e;

    /* renamed from: f */
    private static int f4100f;

    /* renamed from: g */
    private static int f4101g;

    /* renamed from: a */
    private static final String f4095a = HeartBeat.class.getSimpleName();

    /* renamed from: b */
    private static Context f4096b = PushClientApplication.m4111g();

    /* renamed from: h */
    private static InterfaceC1108b f4102h = new C1123a();

    /* renamed from: i */
    private static InterfaceC1131b f4103i = new C1124b();

    /* renamed from: a */
    public static synchronized boolean m4218a() {
        boolean z = false;
        synchronized (HeartBeat.class) {
            if (!f4097c) {
                f4097c = true;
                f4098d = C1137e.m4304a();
                f4099e = null;
                if (C1126j.m4261e(-1) > 5) {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4095a, String.format("The top base count of preference(%d) is greater than TOP_BASE_COUNT_MAX(%d). Chnage top base count.", Integer.valueOf(C1126j.m4261e(-1)), 5));
                    }
                    SharedPreferences.Editor editorM4240a = C1126j.m4240a();
                    C1126j.m4251b(editorM4240a, 5);
                    editorM4240a.commit();
                }
                if (f4098d == EnumC1138f.NoActive) {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4095a, "No active internet. Couldn't start heartbeat.");
                    }
                } else if (f4098d == EnumC1138f.Mobile) {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4095a, "HeartBeat is started with mobile. Load ping variables.");
                    }
                    f4099e = C1137e.m4305b();
                    m4233o();
                    C1130a.m4275a(f4103i);
                } else {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4095a, "HeartBeat is started with not mobile. Initialize ping variables.");
                    }
                    m4231m();
                }
                m4234p();
                z = true;
            } else if (C1139g.f4144c) {
                C1139g.m4312c(f4095a, "HeartBeat already was started.");
            }
        }
        return z;
    }

    /* renamed from: b */
    public static synchronized boolean m4220b() {
        boolean z = false;
        synchronized (HeartBeat.class) {
            if (f4097c) {
                f4097c = false;
                f4098d = null;
                f4099e = null;
                C1130a.m4274a();
                m4235q();
                z = true;
            } else if (C1139g.f4144c) {
                C1139g.m4312c(f4095a, "HeartBeat already was stopped.");
            }
        }
        return z;
    }

    /* renamed from: c */
    public static synchronized void m4221c() {
        if (f4097c) {
            m4234p();
        } else if (C1139g.f4144c) {
            C1139g.m4312c(f4095a, "HeartBeat already was stopped.");
        }
    }

    /* renamed from: m */
    private static synchronized void m4231m() {
        f4100f = 0;
        f4101g = 0;
    }

    /* renamed from: n */
    private static synchronized void m4232n() {
        if (f4098d != EnumC1138f.Mobile) {
            if (C1139g.f4144c) {
                C1139g.m4312c(f4095a, "Ping has been started with not mobile. don't save ping variables.");
            }
        } else if (f4099e == null) {
            if (C1139g.f4144c) {
                C1139g.m4312c(f4095a, "HeartBeat.SavePingVariables(). networkOperator is null.");
            }
        } else {
            C1126j.m4245a(f4099e, f4100f, f4101g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static synchronized void m4233o() {
        if (f4098d != EnumC1138f.Mobile) {
            if (C1139g.f4144c) {
                C1139g.m4312c(f4095a, "Ping has been started with not mobile. don't load ping variables.");
            }
        } else {
            String strM4268h = C1126j.m4268h((String) null);
            if (C1139g.f4142a) {
                C1139g.m4308a(f4095a, String.format("Saved network operator: %s. Current network operator: %s.", strM4268h, f4099e));
            }
            if (f4099e.equals(strM4268h)) {
                f4100f = C1126j.m4257d(0);
                f4101g = C1126j.m4261e(0);
            } else {
                m4231m();
                m4232n();
            }
            if (C1139g.f4142a) {
                C1139g.m4308a(f4095a, String.format("Loaded NetworkOperator: %s, mFailCount:%d, mTopBaseCount:%d", f4099e, Integer.valueOf(f4100f), Integer.valueOf(f4101g)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static synchronized void m4234p() {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4095a, "Rescheduling HeartBeat.");
        }
        long j = (f4101g + 1) * 4 * 60000;
        if (C1139g.f4142a) {
            C1139g.m4308a(f4095a, "Rescheduling... heartbeat interval: " + j);
        }
        m4216a(j);
    }

    /* renamed from: a */
    private static void m4216a(long j) {
        ((AlarmManager) f4096b.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, PendingIntent.getBroadcast(f4096b, 0, new Intent("com.sec.chaton.push.HEARTBEAT_ACTION"), 0));
    }

    /* renamed from: q */
    private static void m4235q() {
        ((AlarmManager) f4096b.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(f4096b, 0, new Intent("com.sec.chaton.push.HEARTBEAT_ACTION"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m4219b(boolean z) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4095a, String.format("AdjustPingAlgorithm. isSuccess:%s.", Boolean.valueOf(z)));
        }
        if (C1139g.f4143b) {
            C1139g.m4311b(f4095a, String.format("Current mFailCount:%d, mTopBaseCount:%d.", Integer.valueOf(f4100f), Integer.valueOf(f4101g)));
        }
        if (z) {
            if (f4100f == 0) {
                if (f4101g < 5) {
                    f4101g++;
                }
            } else if (f4100f == 1 && C1139g.f4142a) {
                C1139g.m4308a(f4095a, "adjustPingAlgorithm - fixed heartbeat interval.");
            }
        } else if (f4100f == 0) {
            if (f4101g > 0) {
                f4101g--;
                f4100f++;
            }
        } else if (f4100f == 1) {
            m4231m();
        }
        if (C1139g.f4142a) {
            C1139g.m4308a(f4095a, String.format("New mFailCount: %d, mTopBaseCount: %d.", Integer.valueOf(f4100f), Integer.valueOf(f4101g)));
        }
        if (f4098d == EnumC1138f.Mobile) {
            m4232n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public static boolean m4236r() {
        String strM4266g = C1126j.m4266g((String) null);
        if (strM4266g == null || strM4266g.length() == 0) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4095a, "The expire date is null, set expiredate.");
            }
            SharedPreferences.Editor editorM4240a = C1126j.m4240a();
            C1126j.m4260d(editorM4240a, m4237s());
            editorM4240a.commit();
            return false;
        }
        if (C1139g.f4142a) {
            C1139g.m4308a(f4095a, String.format("Expire date: %s. Today: %s.", strM4266g, m4237s()));
        }
        return !m4237s().equals(strM4266g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static String m4237s() {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C1126j.m4262e((String) null) == null) {
            if (C1139g.f4144c) {
                C1139g.m4312c(f4095a, "Because a registered application doesn't exist in push module, stop HeartBeat.");
            }
            m4220b();
            return;
        }
        if (!PushClientApplication.m4112h().m4114i()) {
            if (C1139g.f4143b) {
                C1139g.m4311b(f4095a, "PushModule hasn't been started. Probably process had been killed by system. Start service.");
            }
            m4220b();
            context.getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
            return;
        }
        if (C1139g.f4142a) {
            C1139g.m4308a(f4095a, "Send ping by heart beat.");
            C1139g.m4308a(f4095a, "[PushModule information]");
            C1139g.m4308a(f4095a, "======================");
            try {
                C1139g.m4308a(f4095a, "PushModule Version: 0.7.8.2");
                C1139g.m4308a(f4095a, "PushServer: " + C1126j.m4254c((String) null) + ":" + C1126j.m4239a(-1));
                C1139g.m4308a(f4095a, "Device token: " + C1126j.m4248b((String) null));
                C1139g.m4308a(f4095a, "Application id: " + C1126j.m4262e((String) null));
                C1139g.m4308a(f4095a, "Registration id: " + C1126j.m4264f((String) null));
                C1139g.m4308a(f4095a, "Base count: " + f4101g);
                if (f4098d == EnumC1138f.Mobile) {
                    C1139g.m4308a(f4095a, "NetworkOperator: " + C1126j.m4268h((String) null));
                }
            } catch (Throwable th) {
            }
            C1139g.m4308a(f4095a, "======================");
        }
        C1104e c1104e = new C1104e(PushClientApplication.m4111g());
        c1104e.m4162a(f4102h);
        try {
            C1115i.m4196a().m4203a(c1104e);
        } catch (InterruptedException e) {
            if (C1139g.f4145d) {
                C1139g.m4309a(f4095a, e.getMessage(), e);
            }
        }
    }
}
