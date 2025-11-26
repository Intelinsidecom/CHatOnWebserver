package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;
import com.sec.chaton.util.C3250y;

/* compiled from: PlayVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.j */
/* loaded from: classes.dex */
class C1778j implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1776h f6586a;

    C1778j(AsyncTaskC1776h asyncTaskC1776h) {
        this.f6586a = asyncTaskC1776h;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) throws IllegalStateException {
        try {
            switch (i) {
                case -3:
                case -2:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[AudioFocus] : AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK", AsyncTaskC1776h.f6568j);
                    }
                    if (this.f6586a.f6580m.isPlaying()) {
                        this.f6586a.f6580m.pause();
                        this.f6586a.f6583p = true;
                        if (this.f6586a.f6576h != null && this.f6586a.f6576h.isRunning()) {
                            this.f6586a.f6576h.stop();
                            break;
                        }
                    }
                    break;
                case -1:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[AudioFocus] : AUDIOFOCUS_LOSS", AsyncTaskC1776h.f6568j);
                    }
                    if (this.f6586a.f6580m != null) {
                        this.f6586a.f6582o = false;
                        break;
                    }
                    break;
                case 1:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[AudioFocus] : AUDIOFOCUS_GAIN", AsyncTaskC1776h.f6568j);
                    }
                    if (this.f6586a.f6583p) {
                        this.f6586a.f6580m.start();
                        if (this.f6586a.f6576h != null && !this.f6586a.f6576h.isRunning()) {
                            this.f6586a.f6576h.start();
                        }
                        this.f6586a.f6583p = false;
                        break;
                    }
                    break;
            }
        } catch (IllegalStateException e) {
            C3250y.m11443a(e, AsyncTaskC1776h.f6568j);
        }
    }
}
