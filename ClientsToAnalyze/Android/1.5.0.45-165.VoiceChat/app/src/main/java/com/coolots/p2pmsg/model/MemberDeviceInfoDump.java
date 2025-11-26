package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class MemberDeviceInfoDump {
    private String AppVersion;

    @NotNull
    private short DeviceId;
    private String DeviceModel;

    @NotNull
    private String DeviceType;

    @NotNull
    private Date InsertDate;
    private Date LastFailDate;
    private String OsName;
    private String OsVersion;
    private String Passwd;
    private String PhoneNo;
    private String Privacy;

    @NotNull
    private String SerialNo;

    @NotNull
    private long UserNo;

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public short getDeviceId() {
        return this.DeviceId;
    }

    public void setDeviceId(short deviceId) {
        this.DeviceId = deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.DeviceId = (short) deviceId;
    }

    public String getPasswd() {
        return this.Passwd;
    }

    public void setPasswd(String passwd) {
        this.Passwd = passwd;
    }

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    public String getPrivacy() {
        return this.Privacy;
    }

    public void setPrivacy(String privacy) {
        this.Privacy = privacy;
    }

    public String getDeviceType() {
        return this.DeviceType;
    }

    public void setDeviceType(String deviceType) {
        this.DeviceType = deviceType;
    }

    public String getSerialNo() {
        return this.SerialNo;
    }

    public void setSerialNo(String serialNo) {
        this.SerialNo = serialNo;
    }

    public Date getLastFailDate() {
        return this.LastFailDate;
    }

    public void setLastFailDate(Date lastFailDate) {
        if (lastFailDate instanceof Timestamp) {
            this.LastFailDate = new Date(lastFailDate.getTime());
        } else {
            this.LastFailDate = lastFailDate;
        }
    }

    public void setLastFailDate(String lastFailDate) throws ParseException {
        setLastFailDate(DateTimeUtil.changeFormat(lastFailDate, "yyyy-MM-dd HH:mm:ss"));
    }

    public String getOsName() {
        return this.OsName;
    }

    public void setOsName(String osName) {
        this.OsName = osName;
    }

    public String getOsVersion() {
        return this.OsVersion;
    }

    public void setOsVersion(String osVersion) {
        this.OsVersion = osVersion;
    }

    public String getDeviceModel() {
        return this.DeviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.DeviceModel = deviceModel;
    }

    public String getAppVersion() {
        return this.AppVersion;
    }

    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
    }

    public Date getInsertDate() {
        return this.InsertDate;
    }

    public void setInsertDate(Date insertDate) {
        if (insertDate instanceof Timestamp) {
            this.InsertDate = new Date(insertDate.getTime());
        } else {
            this.InsertDate = insertDate;
        }
    }

    public void setInsertDate(String insertDate) throws ParseException {
        setInsertDate(DateTimeUtil.changeFormat(insertDate, "yyyy-MM-dd HH:mm:ss"));
    }
}
