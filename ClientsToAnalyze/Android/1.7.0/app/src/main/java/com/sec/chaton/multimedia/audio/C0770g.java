package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;
import org.jboss.netty.util.internal.jzlib.JZlib;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.g */
/* loaded from: classes.dex */
class C0770g implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2665a;

    C0770g(RecordAudio recordAudio) {
        this.f2665a = recordAudio;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        switch (i) {
            case JZlib.Z_DATA_ERROR /* -3 */:
            case -2:
            case -1:
                if (this.f2665a.f2642o || this.f2665a.f2641n) {
                    this.f2665a.f2634g.performClick();
                    break;
                }
                break;
        }
    }
}
