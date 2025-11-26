package com.sec.chaton.multimedia.audio;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.g */
/* loaded from: classes.dex */
class RunnableC0877g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0876f f3270a;

    RunnableC0877g(C0876f c0876f) {
        this.f3270a = c0876f;
    }

    @Override // java.lang.Runnable
    public void run() {
        PlayAudio.m3555d(this.f3270a.f3269b.f3267b);
        int i = this.f3270a.f3269b.f3267b.f3219l / 60;
        String string = Integer.toString(i);
        if (string.length() == 1) {
            string = "0" + string;
        }
        String string2 = Integer.toString(this.f3270a.f3269b.f3267b.f3219l % 60);
        if (string2.length() == 1) {
            string2 = "0" + string2;
        }
        String string3 = Integer.toString(i / 60);
        if (string3.length() == 1) {
            string3 = "0" + string3;
        }
        this.f3270a.f3269b.f3267b.f3211d.setText(String.format("%s:%s:%s", string3, string, string2));
        if (this.f3270a.f3269b.f3267b.f3219l == 0) {
            this.f3270a.f3269b.f3267b.f3212e.cancel();
        }
    }
}
