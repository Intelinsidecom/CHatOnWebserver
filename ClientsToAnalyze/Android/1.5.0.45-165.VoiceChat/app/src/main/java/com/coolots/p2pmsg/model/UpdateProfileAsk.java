package com.coolots.p2pmsg.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class UpdateProfileAsk extends MsgBody {

    @NotNull
    @Valid
    private ProfileInfo ProfileInfo;

    public ProfileInfo getProfileInfo() {
        return this.ProfileInfo;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.ProfileInfo = profileInfo;
    }
}
