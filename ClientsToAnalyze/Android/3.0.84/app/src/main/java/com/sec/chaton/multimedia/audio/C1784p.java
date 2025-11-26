package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.p */
/* loaded from: classes.dex */
class C1784p implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1779k f6612a;

    C1784p(AsyncTaskC1779k asyncTaskC1779k) {
        this.f6612a = asyncTaskC1779k;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        switch (i) {
            case -2:
            case -1:
                this.f6612a.f6591e = true;
                break;
        }
    }
}
