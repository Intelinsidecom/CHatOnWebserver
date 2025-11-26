package com.sec.chaton.multimedia.audio;

import android.media.MediaPlayer;

/* renamed from: com.sec.chaton.multimedia.audio.e */
/* loaded from: classes.dex */
class C0274e implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2081a;

    C0274e(RecordAudio recordAudio) {
        this.f2081a = recordAudio;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
        this.f2081a.f2071u.seekTo(this.f2081a.f2071u.getCurrentPosition());
    }
}
