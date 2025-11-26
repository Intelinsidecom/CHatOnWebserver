package com.sec.chaton.multimedia.audio;

import android.media.MediaPlayer;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.m */
/* loaded from: classes.dex */
class C0883m implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3278a;

    C0883m(RecordAudio recordAudio) {
        this.f3278a = recordAudio;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
        this.f3278a.f3251u.seekTo(this.f3278a.f3251u.getCurrentPosition());
    }
}
