package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.StringCase;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class PhoneNoInfo {
    public static final String DATA_NO = "N";
    public static final String DATA_YES = "Y";

    @Range(max = 32767, min = 1)
    private Short DeviceID;

    @NotNull
    @Size(max = 64, min = 0)
    private String PhoneNo;

    @StringCase(caseArray = {"Y", "N"})
    private String Privacy;

    @StringCase(caseArray = {"0", "9"})
    private String Status;

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

    public Short getDeviceID() {
        return this.DeviceID;
    }

    public void setDeviceID(Short deviceID) {
        this.DeviceID = deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.DeviceID = Short.valueOf((short) deviceID);
    }

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public boolean equals(Object obj) {
        if (this.PhoneNo == null) {
            return obj == null;
        }
        return this.PhoneNo.equals(((PhoneNoInfo) obj).getPhoneNo());
    }

    public int hashCode() {
        int result = (getPhoneNo() == null ? 0 : getPhoneNo().hashCode()) + 629;
        return result;
    }
}
