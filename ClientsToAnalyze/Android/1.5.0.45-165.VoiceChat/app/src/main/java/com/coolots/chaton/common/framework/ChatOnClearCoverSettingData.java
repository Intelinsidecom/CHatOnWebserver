package com.coolots.chaton.common.framework;

import android.os.Build;
import com.sds.coolots.common.framework.ClearCoverSettingDataInterface;

/* loaded from: classes.dex */
public class ChatOnClearCoverSettingData implements ClearCoverSettingDataInterface {
    @Override // com.sds.coolots.common.framework.ClearCoverSettingDataInterface
    public boolean isClearCover() {
        if (Build.VERSION.SDK_INT >= 17) {
            return true;
        }
        return false;
    }
}
