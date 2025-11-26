package com.sec.chaton.settings;

import android.media.AudioManager;
import android.media.SoundPool;
import com.sec.common.CommonApplication;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.fu */
/* loaded from: classes.dex */
class C3638fu implements SoundPool.OnLoadCompleteListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference2 f13199a;

    C3638fu(RingtonePreference2 ringtonePreference2) {
        this.f13199a = ringtonePreference2;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int i, int i2) {
        AudioManager audioManager = (AudioManager) CommonApplication.m18732r().getSystemService("audio");
        int streamVolume = audioManager.getStreamVolume(5);
        if (streamVolume > 0) {
            int streamMaxVolume = audioManager.getStreamMaxVolume(5);
            soundPool.autoPause();
            soundPool.play(i, streamVolume / streamMaxVolume, streamVolume / streamMaxVolume, 0, 0, 1.0f);
        }
    }
}
