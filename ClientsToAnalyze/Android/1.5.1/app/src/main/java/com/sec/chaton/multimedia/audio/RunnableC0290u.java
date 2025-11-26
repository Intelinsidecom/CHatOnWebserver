package com.sec.chaton.multimedia.audio;

/* renamed from: com.sec.chaton.multimedia.audio.u */
/* loaded from: classes.dex */
class RunnableC0290u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0282m f2102a;

    RunnableC0290u(C0282m c0282m) {
        this.f2102a = c0282m;
    }

    @Override // java.lang.Runnable
    public void run() {
        PlayAudio.m2460d(this.f2102a.f2091b.f2101b);
        int i = this.f2102a.f2091b.f2101b.f2048l / 60;
        String string = Integer.toString(i);
        if (string.length() == 1) {
            string = "0" + string;
        }
        String string2 = Integer.toString(this.f2102a.f2091b.f2101b.f2048l % 60);
        if (string2.length() == 1) {
            string2 = "0" + string2;
        }
        String string3 = Integer.toString(i / 60);
        if (string3.length() == 1) {
            string3 = "0" + string3;
        }
        this.f2102a.f2091b.f2101b.f2040d.setText(String.format("%s:%s:%s", string3, string, string2));
        if (this.f2102a.f2091b.f2101b.f2048l == 0) {
            this.f2102a.f2091b.f2101b.f2041e.cancel();
        }
    }
}
