package com.sds.coolots.call.model;

import java.util.ArrayList;

/* loaded from: classes.dex */
public interface RemoteManagerInterface {
    ArrayList getMappingRemoteInfo();

    void resetRemoteInfoData();

    boolean setMappingEngineData(String str, String str2, String str3);

    boolean setMappingPushData(Destination destination, String str);
}
