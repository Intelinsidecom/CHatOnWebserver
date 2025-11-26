package com.sec.chaton.multimedia.audio;

import android.media.MediaPlayer;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.f */
/* loaded from: classes.dex */
class C0769f implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2664a;

    C0769f(RecordAudio recordAudio) {
        this.f2664a = recordAudio;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
        this.f2664a.f2648u.seekTo(this.f2664a.f2648u.getCurrentPosition());
    }
}
