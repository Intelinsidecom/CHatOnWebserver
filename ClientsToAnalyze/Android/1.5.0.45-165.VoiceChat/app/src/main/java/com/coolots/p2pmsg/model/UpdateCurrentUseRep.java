package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;

/* loaded from: classes.dex */
public class UpdateCurrentUseRep extends MsgBody {

    @Min(0)
    private int CurrentUse;

    public int getCurrentUse() {
        return this.CurrentUse;
    }

    public void setCurrentUse(int currentUse) {
        this.CurrentUse = currentUse;
    }
}
