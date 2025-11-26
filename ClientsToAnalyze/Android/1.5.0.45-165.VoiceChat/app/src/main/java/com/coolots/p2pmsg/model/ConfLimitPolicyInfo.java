package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ConfLimitPolicyInfo extends MsgBody {
    public static final String CONF_TYPE_AUDIO = "A";
    public static final String CONF_TYPE_SEMINAR = "S";
    public static final String CONF_TYPE_VIDEO = "V";
    public static final String PAID_TYPE_FREE = "F";
    public static final String PAID_TYPE_PAID = "P";
    private String ConfType;
    private String GroupCode;
    private short Limit;
    private String PaidType;

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }

    public String getPaidType() {
        return this.PaidType;
    }

    public void setPaidType(String paidType) {
        this.PaidType = paidType;
    }

    public String getConfType() {
        return this.ConfType;
    }

    public void setConfType(String confType) {
        this.ConfType = confType;
    }

    public short getLimit() {
        return this.Limit;
    }

    public void setLimit(short limit) {
        this.Limit = limit;
    }

    public void setLimit(int limit) {
        this.Limit = (short) limit;
    }
}
