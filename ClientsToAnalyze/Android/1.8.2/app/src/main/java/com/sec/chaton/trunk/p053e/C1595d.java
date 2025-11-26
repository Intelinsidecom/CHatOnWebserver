package com.sec.chaton.trunk.p053e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1786r;
import java.util.Iterator;

/* compiled from: StorageStateMonitor.java */
/* renamed from: com.sec.chaton.trunk.e.d */
/* loaded from: classes.dex */
final class C1595d extends BroadcastReceiver {
    C1595d() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1786r.m6061b(String.format("StorageStateMonitor.onReceive(). Action: %s", intent.getAction()), C1594c.f5709a);
        boolean zM6002a = C1767bw.m6002a();
        synchronized (C1594c.class) {
            C1786r.m6061b(String.format("External storage status is changed. old(%s) != new(%s).", Boolean.valueOf(C1594c.f5712d), Boolean.valueOf(zM6002a)), C1594c.f5709a);
            if (C1594c.f5712d != zM6002a) {
                Iterator it = C1594c.f5710b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC1596e) it.next()).mo5313a(zM6002a);
                }
            }
            boolean unused = C1594c.f5712d = zM6002a;
        }
    }
}
