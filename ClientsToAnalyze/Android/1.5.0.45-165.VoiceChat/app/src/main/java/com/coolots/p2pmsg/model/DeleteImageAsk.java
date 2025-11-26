package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class DeleteImageAsk extends MsgBody {
    public static final int GROUP_IMAGE = 2;
    public static final int PROFILE_IMAGE = 1;
    public static final int VIDEOCALL_IMAGE = 3;

    @Range(min = 0)
    private long BuddyGroupCode;

    @NotNull
    @Range(max = 3, min = 1)
    private int ImageType;

    public int getImageType() {
        return this.ImageType;
    }

    public void setImageType(int imageType) {
        this.ImageType = imageType;
    }

    public long getBuddyGroupCode() {
        return this.BuddyGroupCode;
    }

    public void setBuddyGroupCode(long buddyGroupCode) {
        this.BuddyGroupCode = buddyGroupCode;
    }
}
