package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import java.util.TimerTask;

/* renamed from: com.sec.chaton.multimedia.audio.m */
/* loaded from: classes.dex */
class C0282m extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f2090a;

    /* renamed from: b */
    final /* synthetic */ ViewOnClickListenerC0289t f2091b;

    C0282m(ViewOnClickListenerC0289t viewOnClickListenerC0289t, Handler handler) {
        this.f2091b = viewOnClickListenerC0289t;
        this.f2090a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f2090a.post(new RunnableC0290u(this));
    }
}
