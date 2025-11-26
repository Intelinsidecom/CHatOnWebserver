package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class StoreUserUsageAsk extends MsgBody {

    @NotNull
    private List<UsageInfo> UsageInfoList = new ArrayList();

    public List<UsageInfo> getUsageInfoList() {
        return this.UsageInfoList;
    }

    public void setUsageInfoList(List<UsageInfo> UsageInfoList) {
        this.UsageInfoList = UsageInfoList;
    }
}
