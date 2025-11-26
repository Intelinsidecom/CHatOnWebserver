package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class RegionMakeConferenceAsk extends MsgBody {
    private String CdrId;
    private String ConfKey;
    private String ConfName;
    private String ConfType;
    private String ConferenceNo;
    private String GroupCode;
    private String InitConfType;
    private int McuId;
    private String McuSipId;
    private byte RegionCode;
    private String SenderEmail;
    private List<SimpleUserInfo> SimpleUserInfoList = new ArrayList();
    private Date StartTime;
    private String StatusYn;

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }

    public String getConfKey() {
        return this.ConfKey;
    }

    public void setConfKey(String confKey) {
        this.ConfKey = confKey;
    }

    public String getInitConfType() {
        return this.InitConfType;
    }

    public void setInitConfType(String initConfType) {
        this.InitConfType = initConfType;
    }

    public String getConfType() {
        return this.ConfType;
    }

    public void setConfType(String confType) {
        this.ConfType = confType;
    }

    public int getMcuId() {
        return this.McuId;
    }

    public void setMcuId(int mcuId) {
        this.McuId = mcuId;
    }

    public String getMcuSipId() {
        return this.McuSipId;
    }

    public void setMcuSipId(String mcuSipId) {
        this.McuSipId = mcuSipId;
    }

    public String getStatusYn() {
        return this.StatusYn;
    }

    public void setStatusYn(String statusYn) {
        this.StatusYn = statusYn;
    }

    public Date getStartTime() {
        return this.StartTime;
    }

    public void setStartTime(Date startTime) {
        if (startTime instanceof Timestamp) {
            this.StartTime = new Date(startTime.getTime());
        } else {
            this.StartTime = startTime;
        }
    }

    public void setStartTime(String startTime) throws ParseException {
        setStartTime(DateTimeUtil.changeFormat(startTime, "yyyy-MM-dd HH:mm:ss"));
    }

    public String getCdrId() {
        return this.CdrId;
    }

    public void setCdrId(String cdrId) {
        this.CdrId = cdrId;
    }

    public byte getRegionCode() {
        return this.RegionCode;
    }

    public void setRegionCode(byte regionCode) {
        this.RegionCode = regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.RegionCode = (byte) regionCode;
    }

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getConfName() {
        return this.ConfName;
    }

    public void setConfName(String confName) {
        this.ConfName = confName;
    }

    public List<SimpleUserInfo> getSimpleUserInfoList() {
        return this.SimpleUserInfoList;
    }

    public void setSimpleUserInfoList(List<SimpleUserInfo> simpleUserInfoList) {
        this.SimpleUserInfoList = simpleUserInfoList;
    }

    public String getSenderEmail() {
        return this.SenderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.SenderEmail = senderEmail;
    }
}
