package com.sec.chaton.multimedia.audio;

import android.media.MediaPlayer;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.multimedia.audio.d */
/* loaded from: classes.dex */
class C0273d implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2080a;

    C0273d(RecordAudio recordAudio) {
        this.f2080a = recordAudio;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f2080a.f2053c.cancel();
        if (this.f2080a.f2067q) {
            this.f2080a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg_h);
        } else {
            this.f2080a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg);
        }
        this.f2080a.f2056f.setBackgroundResource(C0062R.drawable.recorder_player_play);
        this.f2080a.f2062l.setVisibility(8);
        this.f2080a.f2068r = false;
        this.f2080a.f2069s.setProgress(0);
        this.f2080a.f2074x = 0;
        this.f2080a.f2075y = this.f2080a.f2076z;
        this.f2080a.m2472b();
        this.f2080a.f2065o = false;
    }
}
