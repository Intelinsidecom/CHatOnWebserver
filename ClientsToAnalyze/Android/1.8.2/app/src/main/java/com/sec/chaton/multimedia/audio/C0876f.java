package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.f */
/* loaded from: classes.dex */
class C0876f extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f3268a;

    /* renamed from: b */
    final /* synthetic */ ViewOnClickListenerC0875e f3269b;

    C0876f(ViewOnClickListenerC0875e viewOnClickListenerC0875e, Handler handler) {
        this.f3269b = viewOnClickListenerC0875e;
        this.f3268a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f3268a.post(new RunnableC0877g(this));
    }
}
