package com.sec.chaton;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.r */
/* loaded from: classes.dex */
class C3129r extends Thread {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f11509a;

    C3129r(AdminMenu adminMenu) {
        this.f11509a = adminMenu;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.f11509a.f1885V.setMessage("Make Dummy ChatRoom " + (this.f11509a.f1896ag + 1));
            this.f11509a.m2857l();
        } catch (Exception e) {
        }
    }
}
