package com.sec.chaton.multimedia.audio;

import android.os.Message;
import java.util.TimerTask;

/* compiled from: VoiceListPlayer.java */
/* renamed from: com.sec.chaton.multimedia.audio.t */
/* loaded from: classes.dex */
class C2744t extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C2743s f9849a;

    C2744t(C2743s c2743s) {
        this.f9849a = c2743s;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f9849a.f9842e != null && this.f9849a.f9840c != null && !this.f9849a.f9847j) {
            Message.obtain(this.f9849a.f9842e, 3, Integer.valueOf(this.f9849a.f9840c.getCurrentPosition())).sendToTarget();
        }
    }
}
