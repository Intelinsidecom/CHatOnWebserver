package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import java.util.TimerTask;

/* renamed from: com.sec.chaton.multimedia.audio.h */
/* loaded from: classes.dex */
class C0277h extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f2084a;

    /* renamed from: b */
    final /* synthetic */ RecordAudio f2085b;

    C0277h(RecordAudio recordAudio, Handler handler) {
        this.f2085b = recordAudio;
        this.f2084a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f2084a.post(new RunnableC0287r(this));
    }
}
