package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionDeleteDuplicatePhoneNoAsk extends MsgBody {
    private String GroupCode;
    private String PhoneNo;
    private Long UserNo;

    public Long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(Long userNo) {
        this.UserNo = userNo;
    }

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }
}
