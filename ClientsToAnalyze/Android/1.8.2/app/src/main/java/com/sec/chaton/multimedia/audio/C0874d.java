package com.sec.chaton.multimedia.audio;

import android.media.MediaPlayer;
import android.widget.Button;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.d */
/* loaded from: classes.dex */
class C0874d implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ Button f3264a;

    /* renamed from: b */
    final /* synthetic */ PlayAudio f3265b;

    C0874d(PlayAudio playAudio, Button button) {
        this.f3265b = playAudio;
        this.f3264a = button;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f3264a.setEnabled(true);
        this.f3265b.m3550a();
    }
}
