package com.sec.chaton.push.heartbeat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.p039c.InterfaceC0898j;
import com.sec.chaton.push.p039c.p040a.C0889h;
import com.sec.chaton.push.receiver.C0914c;
import com.sec.chaton.push.receiver.InterfaceC0912a;
import com.sec.chaton.push.util.C0920f;
import com.sec.chaton.push.util.C0921g;
import com.sec.chaton.push.util.EnumC0918d;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class HeartBeat extends BroadcastReceiver {

    /* renamed from: c */
    private static boolean f3081c;

    /* renamed from: d */
    private static EnumC0918d f3082d;

    /* renamed from: e */
    private static String f3083e;

    /* renamed from: f */
    private static int f3084f;

    /* renamed from: g */
    private static int f3085g;

    /* renamed from: a */
    private static final String f3079a = HeartBeat.class.getSimpleName();

    /* renamed from: b */
    private static Context f3080b = PushClientApplication.m3436a();

    /* renamed from: h */
    private static InterfaceC0898j f3086h = new C0906b();

    /* renamed from: i */
    private static InterfaceC0912a f3087i = new C0905a();

    /* renamed from: a */
    public static int m3568a() {
        return f3085g;
    }

    /* renamed from: b */
    public static int m3573b() {
        return f3084f;
    }

    /* renamed from: c */
    public static synchronized boolean m3575c() {
        boolean z = false;
        synchronized (HeartBeat.class) {
            if (!f3081c) {
                f3081c = true;
                f3082d = C0920f.m3634a();
                f3083e = null;
                if (C0904h.m3559e(-1) > 5) {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3079a, String.format("The top base count of preference(%d) is greater than TOP_BASE_COUNT_MAX(%d). Chnage top base count.", Integer.valueOf(C0904h.m3559e(-1)), 5));
                    }
                    SharedPreferences.Editor editorM3538a = C0904h.m3538a();
                    C0904h.m3549b(editorM3538a, 5);
                    editorM3538a.commit();
                }
                if (f3082d == EnumC0918d.NoActive) {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3079a, "No active internet. Couldn't start heartbeat.");
                    }
                } else if (f3082d == EnumC0918d.Mobile) {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3079a, "HeartBeat is started with mobile. Load ping variables.");
                    }
                    f3083e = C0920f.m3635b();
                    m3589q();
                    C0914c.m3602a(f3087i);
                } else {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3079a, "HeartBeat is started with not mobile. Initialize ping variables.");
                    }
                    m3587o();
                }
                m3590r();
                z = true;
            } else if (C0921g.f3118c) {
                C0921g.m3641c(f3079a, "HeartBeat already was started.");
            }
        }
        return z;
    }

    /* renamed from: d */
    public static synchronized boolean m3576d() {
        boolean z = false;
        synchronized (HeartBeat.class) {
            if (f3081c) {
                f3081c = false;
                f3082d = null;
                f3083e = null;
                C0914c.m3601a();
                m3591s();
                z = true;
            } else if (C0921g.f3118c) {
                C0921g.m3641c(f3079a, "HeartBeat already was stopped.");
            }
        }
        return z;
    }

    /* renamed from: e */
    public static synchronized void m3577e() {
        if (f3081c) {
            m3590r();
        } else if (C0921g.f3118c) {
            C0921g.m3641c(f3079a, "HeartBeat already was stopped.");
        }
    }

    /* renamed from: o */
    private static synchronized void m3587o() {
        f3084f = 0;
        f3085g = 0;
    }

    /* renamed from: p */
    private static synchronized void m3588p() {
        if (f3082d != EnumC0918d.Mobile) {
            if (C0921g.f3118c) {
                C0921g.m3641c(f3079a, "Ping has been started with not mobile. don't save ping variables.");
            }
        } else if (f3083e == null) {
            if (C0921g.f3118c) {
                C0921g.m3641c(f3079a, "HeartBeat.SavePingVariables(). networkOperator is null.");
            }
        } else {
            C0904h.m3543a(f3083e, f3084f, f3085g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public static synchronized void m3589q() {
        if (f3082d != EnumC0918d.Mobile) {
            if (C0921g.f3118c) {
                C0921g.m3641c(f3079a, "Ping has been started with not mobile. don't load ping variables.");
            }
        } else {
            String strM3566h = C0904h.m3566h((String) null);
            if (C0921g.f3116a) {
                C0921g.m3637a(f3079a, String.format("Saved network operator: %s. Current network operator: %s.", strM3566h, f3083e));
            }
            if (f3083e.equals(strM3566h)) {
                f3084f = C0904h.m3555d(0);
                f3085g = C0904h.m3559e(0);
            } else {
                m3587o();
                m3588p();
            }
            if (C0921g.f3116a) {
                C0921g.m3637a(f3079a, String.format("Loaded NetworkOperator: %s, mFailCount:%d, mTopBaseCount:%d", f3083e, Integer.valueOf(f3084f), Integer.valueOf(f3085g)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public static synchronized void m3590r() {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3079a, "Rescheduling HeartBeat.");
        }
        long j = (f3085g + 1) * 4 * 60000;
        if (C0921g.f3116a) {
            C0921g.m3637a(f3079a, "Rescheduling... heartbeat interval: " + j);
        }
        m3571a(j);
    }

    /* renamed from: a */
    private static void m3571a(long j) {
        ((AlarmManager) f3080b.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, PendingIntent.getBroadcast(f3080b, 0, new Intent("com.sec.chaton.push.HEARTBEAT_ACTION"), 0));
    }

    /* renamed from: s */
    private static void m3591s() {
        ((AlarmManager) f3080b.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(f3080b, 0, new Intent("com.sec.chaton.push.HEARTBEAT_ACTION"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m3574b(boolean z) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3079a, String.format("AdjustPingAlgorithm. isSuccess:%s.", Boolean.valueOf(z)));
        }
        if (C0921g.f3117b) {
            C0921g.m3640b(f3079a, String.format("Current mFailCount:%d, mTopBaseCount:%d.", Integer.valueOf(f3084f), Integer.valueOf(f3085g)));
        }
        if (z) {
            if (f3084f == 0) {
                if (f3085g < 5) {
                    f3085g++;
                }
            } else if (f3084f == 1 && C0921g.f3116a) {
                C0921g.m3637a(f3079a, "adjustPingAlgorithm - fixed heartbeat interval.");
            }
        } else if (f3084f == 0) {
            if (f3085g > 0) {
                f3085g--;
                f3084f++;
            }
        } else if (f3084f == 1) {
            m3587o();
        }
        if (C0921g.f3116a) {
            C0921g.m3637a(f3079a, String.format("New mFailCount: %d, mTopBaseCount: %d.", Integer.valueOf(f3084f), Integer.valueOf(f3085g)));
        }
        if (f3082d == EnumC0918d.Mobile) {
            m3588p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public static boolean m3592t() {
        String strM3564g = C0904h.m3564g((String) null);
        if (strM3564g == null || strM3564g.length() == 0) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3079a, "The expire date is null, set expiredate.");
            }
            SharedPreferences.Editor editorM3538a = C0904h.m3538a();
            C0904h.m3558d(editorM3538a, m3593u());
            editorM3538a.commit();
            return false;
        }
        if (C0921g.f3116a) {
            C0921g.m3637a(f3079a, String.format("Expire date: %s. Today: %s.", strM3564g, m3593u()));
        }
        return !m3593u().equals(strM3564g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public static String m3593u() {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C0904h.m3560e((String) null) == null) {
            if (C0921g.f3118c) {
                C0921g.m3641c(f3079a, "Because a registered application doesn't exist in push module, stop HeartBeat.");
            }
            m3576d();
            return;
        }
        if (!PushClientApplication.m3437b().m3439c()) {
            if (C0921g.f3117b) {
                C0921g.m3640b(f3079a, "PushModule hasn't been started. Probably process had been killed by system. Start service.");
            }
            m3576d();
            context.getApplicationContext().startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
            return;
        }
        if (C0921g.f3116a) {
            C0921g.m3637a(f3079a, "Send ping by heart beat.");
            C0921g.m3637a(f3079a, "[PushModule information]");
            C0921g.m3637a(f3079a, "======================");
            try {
                C0921g.m3637a(f3079a, "PushModule Version: 0.7.8.5");
                C0921g.m3637a(f3079a, "PushServer: " + C0904h.m3552c((String) null) + ":" + C0904h.m3537a(-1));
                C0921g.m3637a(f3079a, "Device token: " + C0904h.m3546b((String) null));
                C0921g.m3637a(f3079a, "Application id: " + C0904h.m3560e((String) null));
                C0921g.m3637a(f3079a, "Registration id: " + C0904h.m3562f((String) null));
                C0921g.m3637a(f3079a, "Base count: " + f3085g);
                if (f3082d == EnumC0918d.Mobile) {
                    C0921g.m3637a(f3079a, "NetworkOperator: " + C0904h.m3566h((String) null));
                }
            } catch (Throwable th) {
            }
            C0921g.m3637a(f3079a, "======================");
        }
        C0889h c0889h = new C0889h(PushClientApplication.m3436a());
        c0889h.m3499a(f3086h);
        try {
            C0896h.m3520a().m3527a(c0889h);
        } catch (InterruptedException e) {
            if (C0921g.f3119d) {
                C0921g.m3638a(f3079a, e.getMessage(), e);
            }
        }
    }
}
