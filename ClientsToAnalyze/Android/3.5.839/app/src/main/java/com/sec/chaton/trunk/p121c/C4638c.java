package com.sec.chaton.trunk.p121c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StorageStateMonitor.java */
/* renamed from: com.sec.chaton.trunk.c.c */
/* loaded from: classes.dex */
public class C4638c {

    /* renamed from: a */
    private static final String f16816a = C4638c.class.getSimpleName();

    /* renamed from: b */
    private static final List<InterfaceC4640e> f16817b = new ArrayList();

    /* renamed from: c */
    private static final BroadcastReceiver f16818c = new C4639d();

    /* renamed from: d */
    private static boolean f16819d;

    /* renamed from: a */
    public static synchronized void m17609a(InterfaceC4640e interfaceC4640e) {
        if (!f16817b.contains(interfaceC4640e)) {
            f16817b.add(interfaceC4640e);
            if (f16817b.size() == 1) {
                C4904y.m18639b("Intialize StorageStateMonitor.", f16816a);
                f16819d = C4873ck.m18500a();
                C4904y.m18639b(String.format("Is external storage available? %s", Boolean.valueOf(f16819d)), f16816a);
                Context contextM18732r = CommonApplication.m18732r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
                intentFilter.addDataScheme("file");
                contextM18732r.registerReceiver(f16818c, intentFilter);
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m17611b(InterfaceC4640e interfaceC4640e) {
        if (f16817b.contains(interfaceC4640e)) {
            f16817b.remove(interfaceC4640e);
            if (f16817b.size() == 0) {
                C4904y.m18639b("Destroy StorageStateMonitor.", f16816a);
                CommonApplication.m18732r().unregisterReceiver(f16818c);
            }
        }
    }
}
