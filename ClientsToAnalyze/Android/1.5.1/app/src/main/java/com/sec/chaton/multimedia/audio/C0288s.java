package com.sec.chaton.multimedia.audio;

import android.media.MediaPlayer;
import android.widget.Button;

/* renamed from: com.sec.chaton.multimedia.audio.s */
/* loaded from: classes.dex */
class C0288s implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ Button f2098a;

    /* renamed from: b */
    final /* synthetic */ PlayAudio f2099b;

    C0288s(PlayAudio playAudio, Button button) {
        this.f2099b = playAudio;
        this.f2098a = button;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f2098a.setEnabled(true);
        this.f2099b.m2455a();
    }
}
