package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.k */
/* loaded from: classes.dex */
class C0881k extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f3275a;

    /* renamed from: b */
    final /* synthetic */ RecordAudio f3276b;

    C0881k(RecordAudio recordAudio, Handler handler) {
        this.f3276b = recordAudio;
        this.f3275a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f3275a.post(new RunnableC0882l(this));
    }
}
