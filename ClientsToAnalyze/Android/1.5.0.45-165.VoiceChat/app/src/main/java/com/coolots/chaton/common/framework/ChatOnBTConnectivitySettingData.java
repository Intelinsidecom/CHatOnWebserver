package com.coolots.chaton.common.framework;

import android.os.Build;
import com.sds.coolots.common.framework.BTConnectivitySettingDataInterface;

/* loaded from: classes.dex */
public class ChatOnBTConnectivitySettingData implements BTConnectivitySettingDataInterface {
    @Override // com.sds.coolots.common.framework.BTConnectivitySettingDataInterface
    public boolean isBTConnectivity() {
        if (Build.VERSION.SDK_INT >= 13) {
            return true;
        }
        return false;
    }
}
