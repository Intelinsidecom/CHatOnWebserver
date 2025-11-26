package com.sec.chaton;

import com.sec.chaton.p057e.C2268bn;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.s */
/* loaded from: classes.dex */
class C3320s extends Thread {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f12107a;

    C3320s(AdminMenu adminMenu) {
        this.f12107a = adminMenu;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        try {
            AdminMenu.m2847g();
            C2268bn.m10131b();
            AdminMenu.m2845f();
            this.f12107a.f1904n.sendEmptyMessage(0);
        } catch (Exception e) {
        }
    }
}
