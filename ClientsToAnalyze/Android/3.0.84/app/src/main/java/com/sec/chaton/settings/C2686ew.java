package com.sec.chaton.settings;

import android.media.AudioManager;
import android.media.SoundPool;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.common.CommonApplication;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.ew */
/* loaded from: classes.dex */
class C2686ew implements SoundPool.OnLoadCompleteListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference2 f9979a;

    C2686ew(RingtonePreference2 ringtonePreference2) {
        this.f9979a = ringtonePreference2;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int i, int i2) {
        AudioManager audioManager = (AudioManager) CommonApplication.m11493l().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        int streamVolume = audioManager.getStreamVolume(5);
        if (streamVolume > 0) {
            int streamMaxVolume = audioManager.getStreamMaxVolume(5);
            soundPool.autoPause();
            soundPool.play(i, streamVolume / streamMaxVolume, streamVolume / streamMaxVolume, 0, 0, 1.0f);
        }
    }
}
