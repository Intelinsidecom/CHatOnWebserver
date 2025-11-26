package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.n */
/* loaded from: classes.dex */
class C0777n extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f2672a;

    /* renamed from: b */
    final /* synthetic */ RecordAudio f2673b;

    C0777n(RecordAudio recordAudio, Handler handler) {
        this.f2673b = recordAudio;
        this.f2672a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f2672a.post(new RunnableC0787x(this));
    }
}
