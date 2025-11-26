package com.sec.chaton.multimedia.audio;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.aa */
/* loaded from: classes.dex */
class RunnableC0764aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0782s f2659a;

    RunnableC0764aa(C0782s c0782s) {
        this.f2659a = c0782s;
    }

    @Override // java.lang.Runnable
    public void run() {
        PlayAudio.m3215d(this.f2659a.f2679b.f2689b);
        int i = this.f2659a.f2679b.f2689b.f2616l / 60;
        String string = Integer.toString(i);
        if (string.length() == 1) {
            string = "0" + string;
        }
        String string2 = Integer.toString(this.f2659a.f2679b.f2689b.f2616l % 60);
        if (string2.length() == 1) {
            string2 = "0" + string2;
        }
        String string3 = Integer.toString(i / 60);
        if (string3.length() == 1) {
            string3 = "0" + string3;
        }
        this.f2659a.f2679b.f2689b.f2608d.setText(String.format("%s:%s:%s", string3, string, string2));
        if (this.f2659a.f2679b.f2689b.f2616l == 0) {
            this.f2659a.f2679b.f2689b.f2609e.cancel();
        }
    }
}
