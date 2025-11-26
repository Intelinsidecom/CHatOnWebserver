package com.sec.chaton;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.i */
/* loaded from: classes.dex */
class C1531i extends Thread {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f5619a;

    C1531i(AdminMenu adminMenu) {
        this.f5619a = adminMenu;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.f5619a.f631D.setMessage("Make Dummy ChatRoom " + (this.f5619a.f641N + 1));
            this.f5619a.m1110g();
        } catch (Exception e) {
        }
    }
}
