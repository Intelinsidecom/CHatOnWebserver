package com.sec.chaton.trunk.p045d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StorageStateMonitor.java */
/* renamed from: com.sec.chaton.trunk.d.d */
/* loaded from: classes.dex */
public class C1166d {

    /* renamed from: a */
    private static final String f4012a = C1166d.class.getSimpleName();

    /* renamed from: b */
    private static final List f4013b = new ArrayList();

    /* renamed from: c */
    private static final BroadcastReceiver f4014c = new C1167e();

    /* renamed from: d */
    private static boolean f4015d;

    /* renamed from: a */
    public static synchronized void m4209a(InterfaceC1164b interfaceC1164b) {
        if (!f4013b.contains(interfaceC1164b)) {
            f4013b.add(interfaceC1164b);
            if (f4013b.size() == 1) {
                C1341p.m4658b("Intialize StorageStateMonitor.", f4012a);
                f4015d = C1327bw.m4595a();
                C1341p.m4658b(String.format("Is external storage available? %s", Boolean.valueOf(f4015d)), f4012a);
                Context contextM3100a = GlobalApplication.m3100a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
                intentFilter.addDataScheme("file");
                contextM3100a.registerReceiver(f4014c, intentFilter);
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m4211b(InterfaceC1164b interfaceC1164b) {
        if (f4013b.contains(interfaceC1164b)) {
            f4013b.remove(interfaceC1164b);
            if (f4013b.size() == 0) {
                C1341p.m4658b("Destroy StorageStateMonitor.", f4012a);
                GlobalApplication.m3100a().unregisterReceiver(f4014c);
            }
        }
    }
}
