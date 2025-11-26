package com.sec.chaton.trunk.p045d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import java.util.Iterator;

/* compiled from: StorageStateMonitor.java */
/* renamed from: com.sec.chaton.trunk.d.e */
/* loaded from: classes.dex */
final class C1167e extends BroadcastReceiver {
    C1167e() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b(String.format("StorageStateMonitor.onReceive(). Action: %s", intent.getAction()), C1166d.f4012a);
        boolean zM4595a = C1327bw.m4595a();
        synchronized (C1166d.class) {
            C1341p.m4658b(String.format("External storage status is changed. old(%s) != new(%s).", Boolean.valueOf(C1166d.f4015d), Boolean.valueOf(zM4595a)), C1166d.f4012a);
            if (C1166d.f4015d != zM4595a) {
                Iterator it = C1166d.f4013b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC1164b) it.next()).mo4049a(zM4595a);
                }
            }
            boolean unused = C1166d.f4015d = zM4595a;
        }
    }
}
