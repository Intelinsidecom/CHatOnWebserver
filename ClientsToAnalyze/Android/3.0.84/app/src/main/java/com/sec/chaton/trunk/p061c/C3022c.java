package com.sec.chaton.trunk.p061c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StorageStateMonitor.java */
/* renamed from: com.sec.chaton.trunk.c.c */
/* loaded from: classes.dex */
public class C3022c {

    /* renamed from: a */
    private static final String f10899a = C3022c.class.getSimpleName();

    /* renamed from: b */
    private static final List<InterfaceC3024e> f10900b = new ArrayList();

    /* renamed from: c */
    private static final BroadcastReceiver f10901c = new C3023d();

    /* renamed from: d */
    private static boolean f10902d;

    /* renamed from: a */
    public static synchronized void m10532a(InterfaceC3024e interfaceC3024e) {
        if (!f10900b.contains(interfaceC3024e)) {
            f10900b.add(interfaceC3024e);
            if (f10900b.size() == 1) {
                C3250y.m11450b("Intialize StorageStateMonitor.", f10899a);
                f10902d = C3223ck.m11327a();
                C3250y.m11450b(String.format("Is external storage available? %s", Boolean.valueOf(f10902d)), f10899a);
                Context contextM11493l = CommonApplication.m11493l();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
                intentFilter.addDataScheme("file");
                contextM11493l.registerReceiver(f10901c, intentFilter);
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m10534b(InterfaceC3024e interfaceC3024e) {
        if (f10900b.contains(interfaceC3024e)) {
            f10900b.remove(interfaceC3024e);
            if (f10900b.size() == 0) {
                C3250y.m11450b("Destroy StorageStateMonitor.", f10899a);
                CommonApplication.m11493l().unregisterReceiver(f10901c);
            }
        }
    }
}
