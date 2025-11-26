package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.s */
/* loaded from: classes.dex */
class C0782s extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f2678a;

    /* renamed from: b */
    final /* synthetic */ ViewOnClickListenerC0789z f2679b;

    C0782s(ViewOnClickListenerC0789z viewOnClickListenerC0789z, Handler handler) {
        this.f2679b = viewOnClickListenerC0789z;
        this.f2678a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f2678a.post(new RunnableC0764aa(this));
    }
}
