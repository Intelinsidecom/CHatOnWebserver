package com.coolots.chaton.common.framework;

import android.os.Build;
import com.sds.coolots.common.framework.ScreenShareSettingDataInterface;

/* loaded from: classes.dex */
public class ChatOnScreenShareSettingData implements ScreenShareSettingDataInterface {
    @Override // com.sds.coolots.common.framework.ScreenShareSettingDataInterface
    public boolean isScreenShare() {
        if (Build.VERSION.SDK_INT >= 15) {
            return true;
        }
        return false;
    }
}
