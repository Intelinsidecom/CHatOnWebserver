package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;

/* compiled from: PlaySoundTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.e */
/* loaded from: classes.dex */
class C1773e implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1772d f6557a;

    C1773e(AsyncTaskC1772d asyncTaskC1772d) {
        this.f6557a = asyncTaskC1772d;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        switch (i) {
            case -3:
            case -2:
            case -1:
                if (this.f6557a.f6552h != null) {
                    this.f6557a.f6554j = false;
                    break;
                }
                break;
        }
    }
}
