package com.coolots.chaton.common.framework;

import android.os.Build;
import com.sds.coolots.common.framework.FixedLCDFrameSettingDataInterface;

/* loaded from: classes.dex */
public class ChatOnFixedLCDFrameSettingData implements FixedLCDFrameSettingDataInterface {
    @Override // com.sds.coolots.common.framework.FixedLCDFrameSettingDataInterface
    public boolean isFixedLCDFrame() {
        if (Build.VERSION.SDK_INT >= 17) {
            return true;
        }
        return false;
    }
}
