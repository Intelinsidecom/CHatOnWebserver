package com.sec.chaton.push.heartbeat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.InterfaceC3081b;
import com.sec.chaton.push.p094c.p095a.C3077e;
import com.sec.chaton.push.util.C3113e;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.push.util.EnumC3114f;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class HeartBeat extends BroadcastReceiver {

    /* renamed from: c */
    private static boolean f11412c;

    /* renamed from: d */
    private static EnumC3114f f11413d;

    /* renamed from: e */
    private static int f11414e;

    /* renamed from: f */
    private static int f11415f;

    /* renamed from: g */
    private static int f11416g;

    /* renamed from: h */
    private static int f11417h;

    /* renamed from: i */
    private static int f11418i;

    /* renamed from: j */
    private static int f11419j;

    /* renamed from: k */
    private static int f11420k;

    /* renamed from: a */
    private static final String f11410a = HeartBeat.class.getSimpleName();

    /* renamed from: b */
    private static Context f11411b = CommonApplication.m18732r();

    /* renamed from: l */
    private static InterfaceC3081b f11421l = new C3096a();

    /* renamed from: a */
    public static int m12602a() {
        return f11415f;
    }

    /* renamed from: b */
    public static int m12606b() {
        return f11414e;
    }

    /* renamed from: c */
    public static synchronized boolean m12608c() {
        boolean z = false;
        synchronized (HeartBeat.class) {
            if (!f11412c) {
                f11412c = true;
                f11413d = C3113e.m12697a();
                if (f11413d == EnumC3114f.NoActive) {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11410a, "No active internet. Couldn't start heartbeat.");
                    }
                } else if (f11413d == EnumC3114f.Mobile) {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11410a, "HeartBeat is started with mobile. Load ping variables.");
                    }
                    m12620o();
                } else {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11410a, "HeartBeat is started with not mobile. Initialize ping variables.");
                    }
                    m12618m();
                }
                m12621p();
                z = true;
            } else if (C3115g.f11460c) {
                C3115g.m12705c(f11410a, "HeartBeat already was started.");
            }
        }
        return z;
    }

    /* renamed from: d */
    public static synchronized boolean m12609d() {
        boolean z = false;
        synchronized (HeartBeat.class) {
            if (f11412c) {
                f11412c = false;
                f11413d = null;
                m12622q();
                z = true;
            } else if (C3115g.f11460c) {
                C3115g.m12705c(f11410a, "HeartBeat already was stopped.");
            }
        }
        return z;
    }

    /* renamed from: e */
    public static synchronized void m12610e() {
        if (f11412c) {
            m12621p();
        } else if (C3115g.f11460c) {
            C3115g.m12705c(f11410a, "HeartBeat already was stopped.");
        }
    }

    /* renamed from: m */
    private static synchronized void m12618m() {
        f11414e = 0;
        f11415f = 0;
        if (f11413d == EnumC3114f.Mobile) {
            f11419j = C3099k.m12644d(4);
            f11420k = C3099k.m12647e(4);
            f11418i = C3099k.m12650f(24);
            f11417h = C3099k.m12653g(4);
        } else {
            f11419j = 4;
            f11420k = 4;
            f11418i = 24;
            f11417h = 4;
        }
        f11415f = f11420k / f11417h;
        f11416g = (f11418i / f11417h) - 1;
    }

    /* renamed from: n */
    private static synchronized void m12619n() {
        if (f11413d != EnumC3114f.Mobile) {
            if (C3115g.f11460c) {
                C3115g.m12705c(f11410a, "Ping has been started with not mobile. don't save ping variables.");
            }
        } else {
            C3099k.m12629a(f11414e, f11415f);
        }
    }

    /* renamed from: o */
    private static synchronized void m12620o() {
        if (f11413d != EnumC3114f.Mobile) {
            if (C3115g.f11460c) {
                C3115g.m12705c(f11410a, "Ping has been started with not mobile. don't load ping variables.");
            }
        } else {
            f11419j = C3099k.m12644d(4);
            f11420k = C3099k.m12647e(4);
            f11418i = C3099k.m12650f(24);
            f11417h = C3099k.m12653g(4);
            f11414e = C3099k.m12656h(0);
            f11415f = C3099k.m12659i(-1);
            if (f11415f == -1) {
                f11415f = f11420k / f11417h;
            }
            f11416g = (f11418i / f11417h) - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static synchronized void m12621p() {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11410a, "Rescheduling HeartBeat.");
        }
        long j = (f11415f + 1) * f11417h;
        if (f11415f == 0) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11410a, "The HeartBeat is first time. Using mimimum interval value.");
            }
            j = f11419j;
        } else if (f11415f == 1 && j > f11417h) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11410a, "The HeartBeat is second time. Using increment value.");
            }
            j = f11417h;
        }
        if (j > f11418i) {
            if (C3115g.f11460c) {
                C3115g.m12705c(f11410a, "The scheduled heart beat interval is bigger than max heart interval.");
            }
            j = f11418i;
        }
        long j2 = j * 60000;
        if (C3115g.f11458a) {
            C3115g.m12701a(f11410a, "Rescheduling... heartbeat interval: " + j2);
        }
        m12604a(j2);
    }

    /* renamed from: a */
    private static void m12604a(long j) {
        ((AlarmManager) f11411b.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, PendingIntent.getBroadcast(f11411b, 0, new Intent("com.sec.chaton.push.HEARTBEAT_ACTION"), 0));
    }

    /* renamed from: q */
    private static void m12622q() {
        ((AlarmManager) f11411b.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(f11411b, 0, new Intent("com.sec.chaton.push.HEARTBEAT_ACTION"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m12607b(boolean z) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11410a, String.format("AdjustPingAlgorithm. isSuccess:%s.", Boolean.valueOf(z)));
        }
        if (C3115g.f11459b) {
            C3115g.m12704b(f11410a, String.format("Current mFailCount:%d, mTopBaseCount:%d.", Integer.valueOf(f11414e), Integer.valueOf(f11415f)));
        }
        if (z) {
            if (f11414e == 0) {
                if (f11415f < f11416g) {
                    f11415f++;
                }
            } else if (f11414e == 1 && C3115g.f11458a) {
                C3115g.m12701a(f11410a, "adjustPingAlgorithm - fixed heartbeat interval.");
            }
        } else if (f11414e == 0) {
            if (f11415f > 0) {
                f11415f--;
                f11414e++;
            }
        } else if (f11414e == 1) {
            m12618m();
        }
        if (C3115g.f11458a) {
            C3115g.m12701a(f11410a, String.format("New mFailCount: %d, mTopBaseCount: %d.", Integer.valueOf(f11414e), Integer.valueOf(f11415f)));
        }
        if (f11413d == EnumC3114f.Mobile) {
            m12619n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public static boolean m12623r() {
        String strM12654g = C3099k.m12654g((String) null);
        if (strM12654g == null || strM12654g.length() == 0) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11410a, "The expire date is null, set expiredate.");
            }
            SharedPreferences.Editor editorM12627a = C3099k.m12627a();
            C3099k.m12643c(editorM12627a, m12624s());
            editorM12627a.commit();
            return false;
        }
        if (C3115g.f11458a) {
            C3115g.m12701a(f11410a, String.format("Expire date: %s. Today: %s.", strM12654g, m12624s()));
        }
        return !m12624s().equals(strM12654g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static String m12624s() {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C3099k.m12648e((String) null) == null) {
            if (C3115g.f11460c) {
                C3115g.m12705c(f11410a, "Because a registered application doesn't exist in push module, stop HeartBeat.");
            }
            m12609d();
            return;
        }
        if (!PushClientApplication.m12499n().m12501o()) {
            if (C3115g.f11459b) {
                C3115g.m12704b(f11410a, "PushModule hasn't been started. Probably process had been killed by system. Start service.");
            }
            m12609d();
            context.getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
            return;
        }
        if (C3115g.f11458a) {
            C3115g.m12701a(f11410a, "Send ping by heart beat.");
            C3115g.m12701a(f11410a, "[PushModule information]");
            C3115g.m12701a(f11410a, "======================");
            try {
                C3115g.m12701a(f11410a, "PushModule Version: 0.9.01.12");
                C3115g.m12701a(f11410a, "PushServer: " + C3099k.m12640c((String) null) + ":" + C3099k.m12626a(-1));
                C3115g.m12701a(f11410a, "Device token: " + C3099k.m12635b((String) null));
                C3115g.m12701a(f11410a, "Application id: " + C3099k.m12648e((String) null));
                C3115g.m12701a(f11410a, "Registration id: " + C3099k.m12651f((String) null));
                C3115g.m12701a(f11410a, "HeartBeat count: " + f11415f);
                C3115g.m12701a(f11410a, "HeartBeat max count: " + f11416g);
                C3115g.m12701a(f11410a, "HeartBeat fail count: " + f11414e);
                if (f11413d == EnumC3114f.Mobile) {
                    C3115g.m12701a(f11410a, "NetworkOperator: " + C3099k.m12657h((String) null));
                }
            } catch (Throwable th) {
            }
            C3115g.m12701a(f11410a, "======================");
        }
        C3077e c3077e = new C3077e(CommonApplication.m18732r());
        c3077e.m12550a(f11421l);
        try {
            C3088i.m12584a().m12591a(c3077e);
        } catch (InterruptedException e) {
            if (C3115g.f11461d) {
                C3115g.m12702a(f11410a, e.getMessage(), e);
            }
        }
    }
}
