package com.sec.chaton.global;

import android.app.ActivityManager;
import android.content.Intent;
import com.sec.chaton.C1058ba;
import com.sec.chaton.C1062bb;
import com.sec.chaton.TabActivity;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.p130e.InterfaceC4995d;
import java.util.List;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.e */
/* loaded from: classes.dex */
class C2353e {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f8385a;

    private C2353e(GlobalApplication globalApplication) {
        this.f8385a = globalApplication;
    }

    /* synthetic */ C2353e(GlobalApplication globalApplication, ServiceConnectionC2350b serviceConnectionC2350b) {
        this(globalApplication);
    }

    @InterfaceC4995d
    public void onClearActivities(C1058ba c1058ba) throws SecurityException, ClassNotFoundException {
        if (C4904y.f17872b) {
            C4904y.m18639b("LocalEventBusReciever, onClearActivities", GlobalApplication.f8364k.getClass().getSimpleName());
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) GlobalApplication.f8364k.getSystemService("activity")).getRunningTasks(1);
        int i = runningTasks.get(0).numActivities;
        String className = runningTasks.get(0).baseActivity.getClassName();
        if (C4904y.f17872b) {
            C4904y.m18639b("[localEvenBusReciever] #activites : " + i + " baseClass : " + className, getClass().getSimpleName());
        }
        try {
            if (className.contains("com.android.settings")) {
                className = "com.sec.chaton.TabActivity";
            }
            if (C4859bx.m18401d(className)) {
                GlobalApplication.f8364k.startActivity(C4859bx.m18372a(GlobalApplication.f8364k, Class.forName(className)));
            }
        } catch (ClassNotFoundException e) {
            if (C4904y.f17875e) {
                C4904y.m18634a(e.toString(), getClass().getSimpleName());
            }
        }
    }

    @InterfaceC4995d
    public void onStartWithClearActivites(C1062bb c1062bb) {
        if (C4904y.f17872b) {
            C4904y.m18639b("LocalEventBusReciever, onStartWithClearActivites", GlobalApplication.f8364k.getClass().getSimpleName());
        }
        Intent intentM3014a = TabActivity.m3014a(GlobalApplication.f8364k);
        intentM3014a.putExtra("callRestart", true);
        intentM3014a.addFlags(268435456);
        GlobalApplication.f8364k.startActivity(intentM3014a);
    }
}
