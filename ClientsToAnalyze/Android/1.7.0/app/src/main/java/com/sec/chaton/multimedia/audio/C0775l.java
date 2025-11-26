package com.sec.chaton.multimedia.audio;

import java.util.TimerTask;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.l */
/* loaded from: classes.dex */
class C0775l extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2670a;

    C0775l(RecordAudio recordAudio) {
        this.f2670a = recordAudio;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        RecordAudio.m3250i(this.f2670a);
    }
}
