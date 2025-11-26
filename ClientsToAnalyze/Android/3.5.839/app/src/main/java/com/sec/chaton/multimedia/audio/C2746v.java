package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;
import android.os.Message;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.dlc.api.IDlcApi;

/* compiled from: VoiceListPlayer.java */
/* renamed from: com.sec.chaton.multimedia.audio.v */
/* loaded from: classes.dex */
class C2746v implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ C2743s f9851a;

    C2746v(C2743s c2743s) {
        this.f9851a = c2743s;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) throws IllegalStateException {
        try {
            switch (i) {
                case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[AudioFocus] : AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK", C2743s.f9838b);
                    }
                    if (this.f9851a.f9840c.isPlaying()) {
                        this.f9851a.f9840c.pause();
                        this.f9851a.f9844g = true;
                        break;
                    }
                    break;
                case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                case -1:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[AudioFocus] : AUDIOFOCUS_LOSS", C2743s.f9838b);
                    }
                    if (this.f9851a.f9840c != null) {
                        this.f9851a.f9840c.stop();
                        if (this.f9851a.f9842e != null) {
                            Message.obtain(this.f9851a.f9842e, 2, this.f9851a.f9843f).sendToTarget();
                            break;
                        }
                    }
                    break;
                case 1:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[AudioFocus] : AUDIOFOCUS_GAIN", C2743s.f9838b);
                    }
                    if (this.f9851a.f9844g) {
                        this.f9851a.f9840c.start();
                        this.f9851a.f9844g = false;
                        break;
                    }
                    break;
            }
        } catch (IllegalStateException e) {
            C4904y.m18635a(e, C2743s.f9838b);
        }
    }
}
