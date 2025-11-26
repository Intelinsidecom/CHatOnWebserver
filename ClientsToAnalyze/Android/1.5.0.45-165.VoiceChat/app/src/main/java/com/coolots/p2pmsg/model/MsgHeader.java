package com.coolots.p2pmsg.model;

import com.coolots.common.util.StringUtil;

/* loaded from: classes.dex */
public class MsgHeader {
    public static final String VERSION = "0.90";
    private String DUKey;
    private Short FromDeviceID;
    private String FromID;
    private int MsgCode;
    private Integer MsgKey;
    private String Passwd;
    private Integer RCID;
    private Integer RSID;
    private Integer SCID;
    private String SLC;
    private Integer SSID;
    private String Sender;
    private int SvcCode;
    private String ToID;
    private Long UserNo;
    private String Version = "0.90";

    public String getVersion() {
        return this.Version;
    }

    public void setVersion(String version) {
        this.Version = version;
    }

    public String getSender() {
        return this.Sender;
    }

    public void setSender(String sender) {
        this.Sender = sender;
    }

    public int getSvcCode() {
        return this.SvcCode;
    }

    public void setSvcCode(int svcCode) {
        this.SvcCode = svcCode;
    }

    public int getMsgCode() {
        return this.MsgCode;
    }

    public void setMsgCode(int msgCode) {
        this.MsgCode = msgCode;
    }

    public Integer getMsgKey() {
        return this.MsgKey;
    }

    public void setMsgKey(Integer msgKey) {
        this.MsgKey = msgKey;
    }

    public String getFromID() {
        return this.FromID;
    }

    public void setFromID(String fromID) {
        this.FromID = fromID;
    }

    public String getToID() {
        return this.ToID;
    }

    public void setToID(String toID) {
        this.ToID = toID;
    }

    public Short getFromDeviceID() {
        return this.FromDeviceID;
    }

    public void setFromDeviceID(Short fromDeviceID) {
        this.FromDeviceID = fromDeviceID;
    }

    public void setFromDeviceID(int fromDeviceID) {
        this.FromDeviceID = Short.valueOf((short) fromDeviceID);
    }

    public String getPasswd() {
        return this.Passwd;
    }

    public void setPasswd(String passwd) {
        this.Passwd = passwd;
    }

    public Integer getSSID() {
        return this.SSID;
    }

    public void setSSID(Integer ssid) {
        this.SSID = ssid;
    }

    public Integer getSCID() {
        return this.SCID;
    }

    public void setSCID(Integer scid) {
        this.SCID = scid;
    }

    public Integer getRSID() {
        return this.RSID;
    }

    public void setRSID(Integer rsid) {
        this.RSID = rsid;
    }

    public Integer getRCID() {
        return this.RCID;
    }

    public void setRCID(Integer rcid) {
        this.RCID = rcid;
    }

    public String getSLC() {
        return this.SLC;
    }

    public void setSLC(String slc) {
        this.SLC = slc;
    }

    public Long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(Long userNo) {
        this.UserNo = userNo;
    }

    public String getDUKey() {
        return this.DUKey;
    }

    public void setDUKey(String duKey) {
        this.DUKey = duKey;
    }

    public String toString() {
        return StringUtil.classToString(this);
    }
}
