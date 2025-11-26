package com.sds.coolots.call;

import android.media.MediaPlayer;

/* loaded from: classes.dex */
public interface ChangeRingtoneInterface {
    MediaPlayer setChatONVDefaultRingtone(MediaPlayer mediaPlayer);

    MediaPlayer setDeviceDefaultRingtone(MediaPlayer mediaPlayer);

    MediaPlayer setUserPersonalRingtone(String str, MediaPlayer mediaPlayer);

    MediaPlayer setUserSelectedRingtone(int i, MediaPlayer mediaPlayer);
}
