package com.sec.chaton.push.heartbeat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.InterfaceC2081b;
import com.sec.chaton.push.p054c.p055a.C2077e;
import com.sec.chaton.push.util.C2113e;
import com.sec.chaton.push.util.C2115g;
import com.sec.chaton.push.util.EnumC2114f;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class HeartBeat extends BroadcastReceiver {

    /* renamed from: c */
    private static boolean f8002c;

    /* renamed from: d */
    private static EnumC2114f f8003d;

    /* renamed from: e */
    private static int f8004e;

    /* renamed from: f */
    private static int f8005f;

    /* renamed from: g */
    private static int f8006g;

    /* renamed from: h */
    private static int f8007h;

    /* renamed from: i */
    private static int f8008i;

    /* renamed from: j */
    private static int f8009j;

    /* renamed from: k */
    private static int f8010k;

    /* renamed from: a */
    private static final String f8000a = HeartBeat.class.getSimpleName();

    /* renamed from: b */
    private static Context f8001b = CommonApplication.m11493l();

    /* renamed from: l */
    private static InterfaceC2081b f8011l = new C2096a();

    /* renamed from: a */
    public static int m8259a() {
        return f8005f;
    }

    /* renamed from: b */
    public static int m8263b() {
        return f8004e;
    }

    /* renamed from: c */
    public static synchronized boolean m8265c() {
        boolean z = false;
        synchronized (HeartBeat.class) {
            if (!f8002c) {
                f8002c = true;
                f8003d = C2113e.m8355a();
                if (f8003d == EnumC2114f.NoActive) {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f8000a, "No active internet. Couldn't start heartbeat.");
                    }
                } else if (f8003d == EnumC2114f.Mobile) {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f8000a, "HeartBeat is started with mobile. Load ping variables.");
                    }
                    m8277o();
                } else {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f8000a, "HeartBeat is started with not mobile. Initialize ping variables.");
                    }
                    m8275m();
                }
                m8278p();
                z = true;
            } else if (C2115g.f8050c) {
                C2115g.m8363c(f8000a, "HeartBeat already was started.");
            }
        }
        return z;
    }

    /* renamed from: d */
    public static synchronized boolean m8266d() {
        boolean z = false;
        synchronized (HeartBeat.class) {
            if (f8002c) {
                f8002c = false;
                f8003d = null;
                m8279q();
                z = true;
            } else if (C2115g.f8050c) {
                C2115g.m8363c(f8000a, "HeartBeat already was stopped.");
            }
        }
        return z;
    }

    /* renamed from: e */
    public static synchronized void m8267e() {
        if (f8002c) {
            m8278p();
        } else if (C2115g.f8050c) {
            C2115g.m8363c(f8000a, "HeartBeat already was stopped.");
        }
    }

    /* renamed from: m */
    private static synchronized void m8275m() {
        f8004e = 0;
        f8005f = 0;
        if (f8003d == EnumC2114f.Mobile) {
            f8009j = C2099k.m8301d(4);
            f8010k = C2099k.m8305e(4);
            f8008i = C2099k.m8308f(24);
            f8007h = C2099k.m8311g(4);
        } else {
            f8009j = 4;
            f8010k = 4;
            f8008i = 24;
            f8007h = 4;
        }
        f8005f = f8010k / f8007h;
        f8006g = (f8008i / f8007h) - 1;
    }

    /* renamed from: n */
    private static synchronized void m8276n() {
        if (f8003d != EnumC2114f.Mobile) {
            if (C2115g.f8050c) {
                C2115g.m8363c(f8000a, "Ping has been started with not mobile. don't save ping variables.");
            }
        } else {
            C2099k.m8286a(f8004e, f8005f);
        }
    }

    /* renamed from: o */
    private static synchronized void m8277o() {
        if (f8003d != EnumC2114f.Mobile) {
            if (C2115g.f8050c) {
                C2115g.m8363c(f8000a, "Ping has been started with not mobile. don't load ping variables.");
            }
        } else {
            f8009j = C2099k.m8301d(4);
            f8010k = C2099k.m8305e(4);
            f8008i = C2099k.m8308f(24);
            f8007h = C2099k.m8311g(4);
            f8004e = C2099k.m8314h(0);
            f8005f = C2099k.m8317i(-1);
            if (f8005f == -1) {
                f8005f = f8010k / f8007h;
            }
            f8006g = (f8008i / f8007h) - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static synchronized void m8278p() {
        if (C2115g.f8048a) {
            C2115g.m8359a(f8000a, "Rescheduling HeartBeat.");
        }
        long j = (f8005f + 1) * f8007h;
        if (f8005f == 0) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f8000a, "The HeartBeat is first time. Using mimimum interval value.");
            }
            j = f8009j;
        } else if (f8005f == 1 && j > f8007h) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f8000a, "The HeartBeat is second time. Using increment value.");
            }
            j = f8007h;
        }
        if (j > f8008i) {
            if (C2115g.f8050c) {
                C2115g.m8363c(f8000a, "The scheduled heart beat interval is bigger than max heart interval.");
            }
            j = f8008i;
        }
        long j2 = j * 60000;
        if (C2115g.f8048a) {
            C2115g.m8359a(f8000a, "Rescheduling... heartbeat interval: " + j2);
        }
        m8261a(j2);
    }

    /* renamed from: a */
    private static void m8261a(long j) {
        ((AlarmManager) f8001b.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, PendingIntent.getBroadcast(f8001b, 0, new Intent("com.sec.chaton.push.HEARTBEAT_ACTION"), 0));
    }

    /* renamed from: q */
    private static void m8279q() {
        ((AlarmManager) f8001b.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(f8001b, 0, new Intent("com.sec.chaton.push.HEARTBEAT_ACTION"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m8264b(boolean z) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f8000a, String.format("AdjustPingAlgorithm. isSuccess:%s.", Boolean.valueOf(z)));
        }
        if (C2115g.f8049b) {
            C2115g.m8362b(f8000a, String.format("Current mFailCount:%d, mTopBaseCount:%d.", Integer.valueOf(f8004e), Integer.valueOf(f8005f)));
        }
        if (z) {
            if (f8004e == 0) {
                if (f8005f < f8006g) {
                    f8005f++;
                }
            } else if (f8004e == 1 && C2115g.f8048a) {
                C2115g.m8359a(f8000a, "adjustPingAlgorithm - fixed heartbeat interval.");
            }
        } else if (f8004e == 0) {
            if (f8005f > 0) {
                f8005f--;
                f8004e++;
            }
        } else if (f8004e == 1) {
            m8275m();
        }
        if (C2115g.f8048a) {
            C2115g.m8359a(f8000a, String.format("New mFailCount: %d, mTopBaseCount: %d.", Integer.valueOf(f8004e), Integer.valueOf(f8005f)));
        }
        if (f8003d == EnumC2114f.Mobile) {
            m8276n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public static boolean m8280r() {
        String strM8312g = C2099k.m8312g((String) null);
        if (strM8312g == null || strM8312g.length() == 0) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f8000a, "The expire date is null, set expiredate.");
            }
            SharedPreferences.Editor editorM8284a = C2099k.m8284a();
            C2099k.m8304d(editorM8284a, m8281s());
            editorM8284a.commit();
            return false;
        }
        if (C2115g.f8048a) {
            C2115g.m8359a(f8000a, String.format("Expire date: %s. Today: %s.", strM8312g, m8281s()));
        }
        return !m8281s().equals(strM8312g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static String m8281s() {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C2099k.m8306e((String) null) == null) {
            if (C2115g.f8050c) {
                C2115g.m8363c(f8000a, "Because a registered application doesn't exist in push module, stop HeartBeat.");
            }
            m8266d();
            return;
        }
        if (!PushClientApplication.m8156h().m8158i()) {
            if (C2115g.f8049b) {
                C2115g.m8362b(f8000a, "PushModule hasn't been started. Probably process had been killed by system. Start service.");
            }
            m8266d();
            context.getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
            return;
        }
        if (C2115g.f8048a) {
            C2115g.m8359a(f8000a, "Send ping by heart beat.");
            C2115g.m8359a(f8000a, "[PushModule information]");
            C2115g.m8359a(f8000a, "======================");
            try {
                C2115g.m8359a(f8000a, "PushModule Version: 0.9.01.12");
                C2115g.m8359a(f8000a, "PushServer: " + C2099k.m8297c((String) null) + ":" + C2099k.m8283a(-1));
                C2115g.m8359a(f8000a, "Device token: " + C2099k.m8292b((String) null));
                C2115g.m8359a(f8000a, "Application id: " + C2099k.m8306e((String) null));
                C2115g.m8359a(f8000a, "Registration id: " + C2099k.m8309f((String) null));
                C2115g.m8359a(f8000a, "HeartBeat count: " + f8005f);
                C2115g.m8359a(f8000a, "HeartBeat max count: " + f8006g);
                C2115g.m8359a(f8000a, "HeartBeat fail count: " + f8004e);
                if (f8003d == EnumC2114f.Mobile) {
                    C2115g.m8359a(f8000a, "NetworkOperator: " + C2099k.m8315h((String) null));
                }
            } catch (Throwable th) {
            }
            C2115g.m8359a(f8000a, "======================");
        }
        C2077e c2077e = new C2077e(CommonApplication.m11493l());
        c2077e.m8207a(f8011l);
        try {
            C2088i.m8241a().m8248a(c2077e);
        } catch (InterruptedException e) {
            if (C2115g.f8051d) {
                C2115g.m8360a(f8000a, e.getMessage(), e);
            }
        }
    }
}
