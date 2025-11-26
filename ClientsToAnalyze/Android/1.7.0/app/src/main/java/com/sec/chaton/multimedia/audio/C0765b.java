package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import com.sec.chaton.R;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.b */
/* loaded from: classes.dex */
class C0765b implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2660a;

    C0765b(RecordAudio recordAudio) {
        this.f2660a = recordAudio;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        AudioManager audioManager = this.f2660a.f2628J;
        AudioManager unused = this.f2660a.f2628J;
        audioManager.setStreamMute(5, false);
        this.f2660a.f2631d.cancel();
        this.f2660a.f2621C.cancel();
        if (this.f2660a.f2644q) {
            this.f2660a.f2639l.setBackgroundResource(R.drawable.record_voice_bg_h);
        } else {
            this.f2660a.f2639l.setBackgroundResource(R.drawable.record_voice_bg);
        }
        this.f2660a.f2634g.setImageResource(R.drawable.recorder_player_play);
        this.f2660a.f2645r = false;
        this.f2660a.f2646s.setProgress(0);
        this.f2660a.f2646s.setPressed(false);
        this.f2660a.f2651x = 0;
        this.f2660a.f2622D = 0;
        this.f2660a.f2652y = this.f2660a.f2653z;
        this.f2660a.m3233b();
        this.f2660a.f2642o = false;
        this.f2660a.f2625G.setVisibility(4);
    }
}
