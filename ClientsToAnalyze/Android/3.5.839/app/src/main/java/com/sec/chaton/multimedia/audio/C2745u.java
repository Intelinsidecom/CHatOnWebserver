package com.sec.chaton.multimedia.audio;

import android.media.MediaPlayer;
import android.os.Message;

/* compiled from: VoiceListPlayer.java */
/* renamed from: com.sec.chaton.multimedia.audio.u */
/* loaded from: classes.dex */
class C2745u implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ C2743s f9850a;

    C2745u(C2743s c2743s) {
        this.f9850a = c2743s;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f9850a.f9842e != null) {
            Message.obtain(this.f9850a.f9842e, 3, Integer.valueOf(this.f9850a.f9840c.getDuration())).sendToTarget();
            Message.obtain(this.f9850a.f9842e, 2, this.f9850a.f9843f).sendToTarget();
            this.f9850a.m11504f();
        }
    }
}
