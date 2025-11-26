package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class AddBuddySuggestionAsk extends MsgBody {

    @NotNull
    @Valid
    private List<BuddyInfo> BuddyList = new ArrayList();

    public List<BuddyInfo> getBuddyList() {
        return this.BuddyList;
    }

    public void setBuddyList(List<BuddyInfo> buddyList) {
        this.BuddyList = buddyList;
    }
}
