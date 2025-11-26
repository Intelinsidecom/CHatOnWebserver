package com.sec.chaton.push.receiver;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.util.C1139g;

/* compiled from: ServiceStateMonitor.java */
/* renamed from: com.sec.chaton.push.receiver.a */
/* loaded from: classes.dex */
public final class C1130a extends PhoneStateListener {

    /* renamed from: a */
    private static final String f4120a = C1130a.class.getSimpleName();

    /* renamed from: b */
    private static boolean f4121b = false;

    /* renamed from: c */
    private static Context f4122c = PushClientApplication.m4111g();

    /* renamed from: d */
    private static TelephonyManager f4123d = (TelephonyManager) f4122c.getSystemService("phone");

    /* renamed from: e */
    private static C1130a f4124e;

    /* renamed from: f */
    private static InterfaceC1131b f4125f;

    @Override // android.telephony.PhoneStateListener
    public void onServiceStateChanged(ServiceState serviceState) {
        synchronized (C1130a.class) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4120a, "ServiceStateMonitor.onServiceStateChanged().");
            }
            if (serviceState.getState() == 0) {
                String operatorNumeric = serviceState.getOperatorNumeric();
                if (operatorNumeric != null && operatorNumeric.length() != 0) {
                    if (f4125f != null) {
                        f4125f.mo4238a(operatorNumeric);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m4275a(InterfaceC1131b interfaceC1131b) {
        if (!f4121b) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4120a, "Registered The ServiceState Listener(LISTEN_SERVICE_STATE).");
            }
            f4121b = true;
            f4125f = interfaceC1131b;
            f4123d.listen(f4124e, 1);
        } else if (C1139g.f4142a) {
            C1139g.m4308a(f4120a, "Already registered The ServiceState Listener(LISTEN_SERVICE_STATE)");
        }
    }

    /* renamed from: a */
    public static synchronized void m4274a() {
        if (f4121b) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4120a, "UnRegistered The ServiceState Listener(LISTEN_SERVICE_STATE).");
            }
            f4125f = null;
            f4123d.listen(f4124e, 0);
            f4121b = false;
        } else if (C1139g.f4142a) {
            C1139g.m4308a(f4120a, "Already deregistered The ServiceState Listener(LISTEN_SERVICE_STATE)");
        }
    }
}
