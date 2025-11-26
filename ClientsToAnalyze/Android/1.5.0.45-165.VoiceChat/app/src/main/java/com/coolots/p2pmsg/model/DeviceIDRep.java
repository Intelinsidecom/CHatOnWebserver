package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class DeviceIDRep extends MsgBody {

    @Deprecated
    private String AppVersion;
    private short DeviceID;
    private String Nonce;
    private Date NonceValidateTime;

    public short getDeviceID() {
        return this.DeviceID;
    }

    public void setDeviceID(short deviceID) {
        this.DeviceID = deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.DeviceID = (short) deviceID;
    }

    public String getNonce() {
        return this.Nonce;
    }

    public void setNonce(String nonce) {
        this.Nonce = nonce;
    }

    public Date getNonceValidateTime() {
        return this.NonceValidateTime;
    }

    public void setNonceValidateTime(Date nonceValidateTime) {
        this.NonceValidateTime = nonceValidateTime;
    }

    public void setNonceValidateTime(String nonceValidateTime) throws ParseException {
        setNonceValidateTime(DateTimeUtil.changeFormat(nonceValidateTime, "yyyy-MM-dd HH:mm:ss"));
    }

    @Deprecated
    public String getAppVersion() {
        return this.AppVersion;
    }

    @Deprecated
    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
    }
}
