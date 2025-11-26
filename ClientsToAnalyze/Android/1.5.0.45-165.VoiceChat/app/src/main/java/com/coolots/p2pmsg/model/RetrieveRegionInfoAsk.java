package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class RetrieveRegionInfoAsk extends MsgBody {

    @NotNull
    @Valid
    @Size(min = 1)
    private List<ToID> IDList = new ArrayList();

    public List<ToID> getIDList() {
        return this.IDList;
    }

    public void setIDList(List<ToID> iDList) {
        this.IDList = iDList;
    }
}
