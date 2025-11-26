package com.sec.chaton.trunk.p061c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import java.util.Iterator;

/* compiled from: StorageStateMonitor.java */
/* renamed from: com.sec.chaton.trunk.c.d */
/* loaded from: classes.dex */
final class C3023d extends BroadcastReceiver {
    C3023d() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b(String.format("StorageStateMonitor.onReceive(). Action: %s", intent.getAction()), C3022c.f10899a);
        boolean zM11327a = C3223ck.m11327a();
        synchronized (C3022c.class) {
            C3250y.m11450b(String.format("External storage status is changed. old(%s) != new(%s).", Boolean.valueOf(C3022c.f10902d), Boolean.valueOf(zM11327a)), C3022c.f10899a);
            if (C3022c.f10902d != zM11327a) {
                Iterator it = C3022c.f10900b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC3024e) it.next()).mo10245a(zM11327a);
                }
            }
            boolean unused = C3022c.f10902d = zM11327a;
        }
    }
}
