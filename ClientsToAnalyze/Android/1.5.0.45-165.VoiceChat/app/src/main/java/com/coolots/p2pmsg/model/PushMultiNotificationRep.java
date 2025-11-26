package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class PushMultiNotificationRep extends MsgBody {

    @Size(max = 100, min = 1)
    private String PushKey;

    @NotNull
    @Valid
    private List<PushResult> PushResultList = new ArrayList();

    public List<PushResult> getPushResultList() {
        return this.PushResultList;
    }

    public void setPushResultList(List<PushResult> pushResultList) {
        this.PushResultList = pushResultList;
    }

    public String getPushKey() {
        return this.PushKey;
    }

    public void setPushKey(String pushKey) {
        this.PushKey = pushKey;
    }
}
