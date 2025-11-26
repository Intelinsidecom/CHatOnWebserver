package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;
import android.os.Message;
import com.sec.chaton.util.C3250y;

/* compiled from: VoiceListPlayer.java */
/* renamed from: com.sec.chaton.multimedia.audio.y */
/* loaded from: classes.dex */
class C1793y implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ C1791w f6639a;

    C1793y(C1791w c1791w) {
        this.f6639a = c1791w;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) throws IllegalStateException {
        try {
            switch (i) {
                case -3:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[AudioFocus] : AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK", C1791w.f6630b);
                    }
                    if (this.f6639a.f6632c.isPlaying()) {
                        this.f6639a.f6632c.pause();
                        this.f6639a.f6636g = true;
                        break;
                    }
                    break;
                case -2:
                case -1:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[AudioFocus] : AUDIOFOCUS_LOSS", C1791w.f6630b);
                    }
                    if (this.f6639a.f6632c != null) {
                        this.f6639a.f6632c.stop();
                        if (this.f6639a.f6634e != null) {
                            Message.obtain(this.f6639a.f6634e, 2, this.f6639a.f6635f).sendToTarget();
                            break;
                        }
                    }
                    break;
                case 1:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[AudioFocus] : AUDIOFOCUS_GAIN", C1791w.f6630b);
                    }
                    if (this.f6639a.f6636g) {
                        this.f6639a.f6632c.start();
                        this.f6639a.f6636g = false;
                        break;
                    }
                    break;
            }
        } catch (IllegalStateException e) {
            C3250y.m11443a(e, C1791w.f6630b);
        }
    }
}
