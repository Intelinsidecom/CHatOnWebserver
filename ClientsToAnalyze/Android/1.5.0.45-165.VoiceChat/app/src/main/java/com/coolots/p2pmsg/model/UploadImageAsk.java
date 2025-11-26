package com.coolots.p2pmsg.model;

import com.google.protobuf.ByteString;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class UploadImageAsk extends MsgBody {
    public static final int GROUP_IMAGE = 2;
    public static final int PROFILE_IMAGE = 1;
    public static final int VIDEOCALL_IMAGE = 3;

    @Range(min = 0)
    private long BuddyGroupCode;

    @NotNull
    private ByteString ImageByteString;

    @NotNull
    @Range(max = 3, min = 1)
    private int ImageType;
    private ByteString ThumbnailImageByteString;

    public int getImageType() {
        return this.ImageType;
    }

    public void setImageType(int imageType) {
        this.ImageType = imageType;
    }

    public ByteString getImageByteString() {
        return this.ImageByteString;
    }

    public void setImageByteString(ByteString imageByteString) {
        this.ImageByteString = imageByteString;
    }

    public ByteString getThumbnailImageByteString() {
        return this.ThumbnailImageByteString;
    }

    public void setThumbnailImageByteString(ByteString thumbnailImageByteString) {
        this.ThumbnailImageByteString = thumbnailImageByteString;
    }

    public long getBuddyGroupCode() {
        return this.BuddyGroupCode;
    }

    public void setBuddyGroupCode(long buddyGroupCode) {
        this.BuddyGroupCode = buddyGroupCode;
    }
}
