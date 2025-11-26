package com.sec.chaton.multimedia.audio;

import java.util.TimerTask;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.s */
/* loaded from: classes.dex */
class C0889s extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3284a;

    C0889s(RecordAudio recordAudio) {
        this.f3284a = recordAudio;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        RecordAudio.m3598l(this.f3284a);
    }
}
