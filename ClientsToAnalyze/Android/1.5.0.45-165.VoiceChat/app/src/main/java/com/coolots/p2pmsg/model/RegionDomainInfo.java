package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.IpOrDomain;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class RegionDomainInfo {

    @IpOrDomain
    @NotNull
    private String ImgDomain;

    @NotNull
    @Size(max = 127)
    private short Region;

    public short getRegion() {
        return this.Region;
    }

    public void setRegion(short region) {
        this.Region = region;
    }

    public void setRegion(int region) {
        this.Region = (short) region;
    }

    public String getImgDomain() {
        return this.ImgDomain;
    }

    public void setImgDomain(String imgDomain) {
        this.ImgDomain = imgDomain;
    }
}
