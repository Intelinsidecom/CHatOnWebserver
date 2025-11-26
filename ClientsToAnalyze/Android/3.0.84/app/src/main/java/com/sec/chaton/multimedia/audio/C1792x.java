package com.sec.chaton.multimedia.audio;

import android.media.MediaPlayer;
import android.os.Message;

/* compiled from: VoiceListPlayer.java */
/* renamed from: com.sec.chaton.multimedia.audio.x */
/* loaded from: classes.dex */
class C1792x implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ C1791w f6638a;

    C1792x(C1791w c1791w) {
        this.f6638a = c1791w;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f6638a.f6634e != null) {
            Message.obtain(this.f6638a.f6634e, 2, this.f6638a.f6635f).sendToTarget();
        }
    }
}
