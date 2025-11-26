package com.sec.chaton;

import com.sec.chaton.p027e.C1404av;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.j */
/* loaded from: classes.dex */
class C1539j extends Thread {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f5659a;

    C1539j(AdminMenu adminMenu) {
        this.f5659a = adminMenu;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        try {
            AdminMenu.m1099b();
            C1404av.m6258b();
            AdminMenu.m1095a();
            this.f5659a.f645a.sendEmptyMessage(0);
        } catch (Exception e) {
        }
    }
}
