package com.coolots.chaton.setting.data;

import com.sds.coolots.call.RingtoneSettingDataInterface;

/* loaded from: classes.dex */
public class RingtoneSettingData implements RingtoneSettingDataInterface {
    @Override // com.sds.coolots.call.RingtoneSettingDataInterface
    public void setRingtoneToSettingData(int type, int index, String path) {
        ChatONSettingData.getInstance().setRingtoneData(type, index, path);
    }

    @Override // com.sds.coolots.call.RingtoneSettingDataInterface
    public String getRingtoneFromSettingData() {
        return ChatONSettingData.getInstance().getRingtoneData();
    }
}
