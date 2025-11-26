package com.coolots.chaton.common.framework;

import android.os.Build;
import com.sds.coolots.common.framework.BTAudioStreamSettingDataInterface;

/* loaded from: classes.dex */
public class ChatOnBTAudioStreamSettingData implements BTAudioStreamSettingDataInterface {
    @Override // com.sds.coolots.common.framework.BTAudioStreamSettingDataInterface
    public boolean isBTAudioStream() {
        if (Build.VERSION.SDK_INT >= 17) {
            return true;
        }
        return false;
    }
}
