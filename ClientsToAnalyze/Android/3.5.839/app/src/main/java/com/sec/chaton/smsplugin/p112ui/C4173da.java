package com.sec.chaton.smsplugin.p112ui;

/* compiled from: MmsSlideView.java */
/* renamed from: com.sec.chaton.smsplugin.ui.da */
/* loaded from: classes.dex */
class C4173da extends Thread {

    /* renamed from: a */
    final /* synthetic */ C4171cz f15496a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4173da(C4171cz c4171cz, String str) {
        super(str);
        this.f15496a = c4171cz;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Runnable runnable;
        while (true) {
            synchronized (C4171cz.f15486d) {
                if (this.f15496a.f15488b.isEmpty()) {
                    try {
                        C4171cz.f15486d.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!this.f15496a.f15488b.isEmpty()) {
                    runnable = (Runnable) this.f15496a.f15488b.removeFirst();
                } else {
                    runnable = null;
                }
            }
            if (runnable != null) {
                runnable.run();
            }
            switch (this.f15496a.f15487a) {
                case 2:
                    synchronized (C4171cz.f15486d) {
                        try {
                            C4171cz.f15486d.wait();
                        } catch (InterruptedException e2) {
                        }
                    }
                    break;
                case 3:
                    return;
            }
        }
    }
}
