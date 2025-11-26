package com.coolots.chaton.common.framework;

import android.os.Build;
import com.sds.coolots.common.framework.CPUBoostSettingDataInterface;

/* loaded from: classes.dex */
public class ChatOnCPUBoostSettingData implements CPUBoostSettingDataInterface {
    @Override // com.sds.coolots.common.framework.CPUBoostSettingDataInterface
    public boolean isCPUBoost() {
        if (Build.VERSION.SDK_INT >= 17) {
            return true;
        }
        return false;
    }
}
