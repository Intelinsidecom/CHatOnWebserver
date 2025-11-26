package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.dlc.api.IDlcApi;

/* compiled from: PlayVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.f */
/* loaded from: classes.dex */
class C2730f implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC2728d f9793a;

    C2730f(AsyncTaskC2728d asyncTaskC2728d) {
        this.f9793a = asyncTaskC2728d;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) throws IllegalStateException {
        try {
            switch (i) {
                case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[AudioFocus] : AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK", AsyncTaskC2728d.f9774j);
                    }
                    if (this.f9793a.f9786m.isPlaying()) {
                        this.f9793a.f9786m.pause();
                        this.f9793a.f9789p = true;
                        if (this.f9793a.f9782h != null && this.f9793a.f9782h.isRunning()) {
                            this.f9793a.f9782h.stop();
                            break;
                        }
                    }
                    break;
                case -1:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[AudioFocus] : AUDIOFOCUS_LOSS", AsyncTaskC2728d.f9774j);
                    }
                    if (this.f9793a.f9786m != null) {
                        this.f9793a.f9788o = false;
                        break;
                    }
                    break;
                case 1:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[AudioFocus] : AUDIOFOCUS_GAIN", AsyncTaskC2728d.f9774j);
                    }
                    if (this.f9793a.f9789p) {
                        this.f9793a.f9786m.start();
                        if (this.f9793a.f9782h != null && !this.f9793a.f9782h.isRunning()) {
                            this.f9793a.f9782h.start();
                        }
                        this.f9793a.f9789p = false;
                        break;
                    }
                    break;
            }
        } catch (IllegalStateException e) {
            C4904y.m18635a(e, AsyncTaskC2728d.f9774j);
        }
    }
}
