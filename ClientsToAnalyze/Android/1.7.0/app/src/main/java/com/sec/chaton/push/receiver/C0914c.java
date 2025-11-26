package com.sec.chaton.push.receiver;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.util.C0921g;

/* compiled from: ServiceStateMonitor.java */
/* renamed from: com.sec.chaton.push.receiver.c */
/* loaded from: classes.dex */
public final class C0914c extends PhoneStateListener {

    /* renamed from: a */
    private static final String f3098a = C0914c.class.getSimpleName();

    /* renamed from: b */
    private static boolean f3099b = false;

    /* renamed from: c */
    private static Context f3100c = PushClientApplication.m3436a();

    /* renamed from: d */
    private static TelephonyManager f3101d = (TelephonyManager) f3100c.getSystemService("phone");

    /* renamed from: e */
    private static C0914c f3102e;

    /* renamed from: f */
    private static InterfaceC0912a f3103f;

    @Override // android.telephony.PhoneStateListener
    public void onServiceStateChanged(ServiceState serviceState) {
        synchronized (C0914c.class) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3098a, "ServiceStateMonitor.onServiceStateChanged().");
            }
            if (serviceState.getState() == 0) {
                String operatorNumeric = serviceState.getOperatorNumeric();
                if (operatorNumeric != null && operatorNumeric.length() != 0) {
                    if (f3103f != null) {
                        f3103f.mo3594a(operatorNumeric);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m3602a(InterfaceC0912a interfaceC0912a) {
        if (!f3099b) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3098a, "Registered The ServiceState Listener(LISTEN_SERVICE_STATE).");
            }
            f3099b = true;
            f3103f = interfaceC0912a;
            f3101d.listen(f3102e, 1);
        } else if (C0921g.f3116a) {
            C0921g.m3637a(f3098a, "Already registered The ServiceState Listener(LISTEN_SERVICE_STATE)");
        }
    }

    /* renamed from: a */
    public static synchronized void m3601a() {
        if (f3099b) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3098a, "UnRegistered The ServiceState Listener(LISTEN_SERVICE_STATE).");
            }
            f3103f = null;
            f3101d.listen(f3102e, 0);
            f3099b = false;
        } else if (C0921g.f3116a) {
            C0921g.m3637a(f3098a, "Already deregistered The ServiceState Listener(LISTEN_SERVICE_STATE)");
        }
    }
}
