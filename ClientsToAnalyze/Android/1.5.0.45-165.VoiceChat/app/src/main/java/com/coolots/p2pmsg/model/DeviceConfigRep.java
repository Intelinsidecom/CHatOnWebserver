package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

/* loaded from: classes.dex */
public class DeviceConfigRep extends MsgBody {

    @Valid
    private List<DeviceConfigInfo> DeviceConfigInfoList = new ArrayList();

    public List<DeviceConfigInfo> getDeviceConfigInfoList() {
        return this.DeviceConfigInfoList;
    }

    public void setDeviceConfigInfoList(List<DeviceConfigInfo> deviceConfigInfoList) {
        this.DeviceConfigInfoList = deviceConfigInfoList;
    }
}
