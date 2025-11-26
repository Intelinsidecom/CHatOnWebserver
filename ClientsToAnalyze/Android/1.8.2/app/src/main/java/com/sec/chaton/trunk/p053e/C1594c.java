package com.sec.chaton.trunk.p053e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StorageStateMonitor.java */
/* renamed from: com.sec.chaton.trunk.e.c */
/* loaded from: classes.dex */
public class C1594c {

    /* renamed from: a */
    private static final String f5709a = C1594c.class.getSimpleName();

    /* renamed from: b */
    private static final List f5710b = new ArrayList();

    /* renamed from: c */
    private static final BroadcastReceiver f5711c = new C1595d();

    /* renamed from: d */
    private static boolean f5712d;

    /* renamed from: a */
    public static synchronized void m5500a(InterfaceC1596e interfaceC1596e) {
        if (!f5710b.contains(interfaceC1596e)) {
            f5710b.add(interfaceC1596e);
            if (f5710b.size() == 1) {
                C1786r.m6061b("Intialize StorageStateMonitor.", f5709a);
                f5712d = C1767bw.m6002a();
                C1786r.m6061b(String.format("Is external storage available? %s", Boolean.valueOf(f5712d)), f5709a);
                Context contextM3260b = GlobalApplication.m3260b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
                intentFilter.addDataScheme("file");
                contextM3260b.registerReceiver(f5711c, intentFilter);
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m5502b(InterfaceC1596e interfaceC1596e) {
        if (f5710b.contains(interfaceC1596e)) {
            f5710b.remove(interfaceC1596e);
            if (f5710b.size() == 0) {
                C1786r.m6061b("Destroy StorageStateMonitor.", f5709a);
                GlobalApplication.m3260b().unregisterReceiver(f5711c);
            }
        }
    }
}
