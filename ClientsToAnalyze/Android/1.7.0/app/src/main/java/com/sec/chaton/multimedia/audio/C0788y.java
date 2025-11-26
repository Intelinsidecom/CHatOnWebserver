package com.sec.chaton.multimedia.audio;

import android.media.MediaPlayer;
import android.widget.Button;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.y */
/* loaded from: classes.dex */
class C0788y implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ Button f2686a;

    /* renamed from: b */
    final /* synthetic */ PlayAudio f2687b;

    C0788y(PlayAudio playAudio, Button button) {
        this.f2687b = playAudio;
        this.f2686a = button;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f2686a.setEnabled(true);
        this.f2687b.m3210a();
    }
}
