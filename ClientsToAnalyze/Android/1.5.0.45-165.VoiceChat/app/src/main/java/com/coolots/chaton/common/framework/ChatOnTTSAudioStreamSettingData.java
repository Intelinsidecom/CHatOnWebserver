package com.coolots.chaton.common.framework;

import android.os.Build;
import com.sds.coolots.common.framework.TTSAudioStreamSettingDataInterface;

/* loaded from: classes.dex */
public class ChatOnTTSAudioStreamSettingData implements TTSAudioStreamSettingDataInterface {
    @Override // com.sds.coolots.common.framework.TTSAudioStreamSettingDataInterface
    public boolean isTTSAudioStream() {
        if (Build.VERSION.SDK_INT >= 17) {
            return true;
        }
        return false;
    }
}
