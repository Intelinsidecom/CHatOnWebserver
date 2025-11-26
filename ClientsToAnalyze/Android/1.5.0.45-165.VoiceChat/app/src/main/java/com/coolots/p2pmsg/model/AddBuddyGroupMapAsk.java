package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class AddBuddyGroupMapAsk extends MsgBody {

    @NotNull
    @Valid
    private List<BuddyGroupMapInfo> MapList = new ArrayList();

    public List<BuddyGroupMapInfo> getMapList() {
        return this.MapList;
    }

    public void setMapList(List<BuddyGroupMapInfo> mapList) {
        this.MapList = mapList;
    }
}
