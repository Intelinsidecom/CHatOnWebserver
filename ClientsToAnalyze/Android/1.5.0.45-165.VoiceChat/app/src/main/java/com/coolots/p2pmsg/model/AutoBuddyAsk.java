package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class AutoBuddyAsk extends MsgBody {

    @NotNull
    @Valid
    private List<PhoneBookInfo> PhoneBookInfoList = new ArrayList();

    public List<PhoneBookInfo> getPhoneBookInfoList() {
        return this.PhoneBookInfoList;
    }

    public void setPhoneBookInfoList(List<PhoneBookInfo> phoneBookInfoList) {
        this.PhoneBookInfoList = phoneBookInfoList;
    }
}
