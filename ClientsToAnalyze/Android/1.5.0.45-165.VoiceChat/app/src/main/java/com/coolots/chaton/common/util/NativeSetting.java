package com.coolots.chaton.common.util;

import android.media.AudioManager;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.NativeSettingInterface;

/* loaded from: classes.dex */
public class NativeSetting implements NativeSettingInterface {
    @Override // com.sds.coolots.common.controller.NativeSettingInterface
    public boolean isVibrateWhenRinging() {
        AudioManager audioManager = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        int ringerMode = audioManager.getRingerMode();
        return ringerMode == 2 && ChatONSettingData.getInstance().getVibrateWhenRinging();
    }

    @Override // com.sds.coolots.common.controller.NativeSettingInterface
    public int getBTStreamType() {
        if (MainApplication.mConfig.isBTAudioStream()) {
            return 6;
        }
        return 0;
    }

    @Override // com.sds.coolots.common.controller.NativeSettingInterface
    public int getBTTypeForConnectivityManager() {
        if (!MainApplication.mConfig.isBTConnectivity()) {
            return 1;
        }
        return 7;
    }

    @Override // com.sds.coolots.common.controller.NativeSettingInterface
    public int getAudioManagerStreamTTS() {
        if (MainApplication.mConfig.isTTSAudioStream()) {
            return 9;
        }
        return 0;
    }
}
