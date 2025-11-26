package com.sec.chaton.multimedia.audio;

/* renamed from: com.sec.chaton.multimedia.audio.r */
/* loaded from: classes.dex */
class RunnableC0287r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0277h f2097a;

    RunnableC0287r(C0277h c0277h) {
        this.f2097a = c0277h;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecordAudio.m2464a(this.f2097a.f2085b);
        String string = Integer.toString(this.f2097a.f2085b.f2074x / 60);
        String string2 = Integer.toString(this.f2097a.f2085b.f2074x % 60);
        if (string2.length() == 1) {
            string2 = "0" + string2;
        }
        RecordAudio.m2474c(this.f2097a.f2085b);
        String string3 = Integer.toString(this.f2097a.f2085b.f2075y / 60);
        String string4 = Integer.toString(this.f2097a.f2085b.f2075y % 60);
        if (string4.length() == 1) {
            string4 = "0" + string4;
        }
        if (this.f2097a.f2085b.f2074x == this.f2097a.f2085b.f2076z) {
            this.f2097a.f2085b.f2053c.cancel();
        }
        this.f2097a.f2085b.f2059i.setText(String.format("%s:%s", string, string2));
        this.f2097a.f2085b.f2060j.setText(String.format("-%s:%s", string3, string4));
    }
}
