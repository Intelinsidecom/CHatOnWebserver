package com.sec.chaton.trunk.p121c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import java.util.Iterator;

/* compiled from: StorageStateMonitor.java */
/* renamed from: com.sec.chaton.trunk.c.d */
/* loaded from: classes.dex */
final class C4639d extends BroadcastReceiver {
    C4639d() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b(String.format("StorageStateMonitor.onReceive(). Action: %s", intent.getAction()), C4638c.f16816a);
        boolean zM18500a = C4873ck.m18500a();
        synchronized (C4638c.class) {
            C4904y.m18639b(String.format("External storage status is changed. old(%s) != new(%s).", Boolean.valueOf(C4638c.f16819d), Boolean.valueOf(zM18500a)), C4638c.f16816a);
            if (C4638c.f16819d != zM18500a) {
                Iterator it = C4638c.f16817b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC4640e) it.next()).mo17343a(zM18500a);
                }
            }
            boolean unused = C4638c.f16819d = zM18500a;
        }
    }
}
