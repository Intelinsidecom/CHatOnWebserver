package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.r */
/* loaded from: classes.dex */
class C0888r implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3283a;

    C0888r(RecordAudio recordAudio) {
        this.f3283a = recordAudio;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        switch (i) {
            case -2:
            case -1:
                if (this.f3283a.f3245o || this.f3283a.f3244n) {
                    this.f3283a.f3237g.performClick();
                    break;
                }
                break;
        }
    }
}
