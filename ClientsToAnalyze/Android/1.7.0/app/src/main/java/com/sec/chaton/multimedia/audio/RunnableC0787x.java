package com.sec.chaton.multimedia.audio;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.x */
/* loaded from: classes.dex */
class RunnableC0787x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0777n f2685a;

    RunnableC0787x(C0777n c0777n) {
        this.f2685a = c0777n;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecordAudio.m3226a(this.f2685a.f2673b);
        if (this.f2685a.f2673b.f2651x >= this.f2685a.f2673b.f2653z) {
            this.f2685a.f2673b.f2651x = this.f2685a.f2673b.f2653z;
        }
        if (this.f2685a.f2673b.f2622D >= this.f2685a.f2673b.f2646s.getMax()) {
            this.f2685a.f2673b.f2631d.cancel();
            this.f2685a.f2673b.f2621C.cancel();
        }
        if (this.f2685a.f2673b.f2641n) {
            if (this.f2685a.f2673b.f2623E.isEnabled()) {
                this.f2685a.f2673b.f2623E.setEnabled(false);
                return;
            } else {
                this.f2685a.f2673b.f2623E.setEnabled(true);
                return;
            }
        }
        this.f2685a.f2673b.f2623E.setEnabled(false);
    }
}
