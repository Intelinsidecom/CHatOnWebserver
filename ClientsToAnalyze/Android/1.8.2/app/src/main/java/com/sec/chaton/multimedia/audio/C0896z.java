package com.sec.chaton.multimedia.audio;

import android.media.MediaPlayer;
import com.sec.chaton.R;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.z */
/* loaded from: classes.dex */
class C0896z implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3291a;

    C0896z(RecordAudio recordAudio) {
        this.f3291a = recordAudio;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f3291a.f3234d.cancel();
        this.f3291a.f3224C.cancel();
        if (this.f3291a.f3247q) {
            this.f3291a.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
        } else {
            this.f3291a.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
        }
        this.f3291a.f3237g.setImageResource(R.drawable.recorder_player_play);
        this.f3291a.f3248r = false;
        this.f3291a.f3249s.setProgress(0);
        this.f3291a.f3249s.setPressed(false);
        this.f3291a.f3254x = 0;
        this.f3291a.f3225D = 0;
        this.f3291a.f3255y = this.f3291a.f3256z;
        this.f3291a.m3575b();
        this.f3291a.f3245o = false;
        this.f3291a.f3228G.setVisibility(4);
    }
}
