package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import com.coolots.common.util.StringUtil;
import com.coolots.p2pmsg.validator.SIPNo;
import com.coolots.p2pmsg.validator.StringCase;
import com.google.protobuf.ByteString;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class SimpleUserInfo {
    public static final String HOLD_YN_N = "N";
    public static final String HOLD_YN_Y = "Y";
    public static final String PUSH_DISABLE_YN_N = "N";
    public static final String PUSH_DISABLE_YN_Y = "Y";
    public static final String STATE_CONNECTED = "1";
    public static final String STATE_DELETED = "3";
    public static final String STATE_DENY = "10";
    public static final String STATE_DISCONNECTED = "2";
    public static final String STATE_MOVETO_CONFERENCE = "4";
    public static final String STATE_WAIT = "0";
    public static final String TYPE_HOST = "H";
    public static final String TYPE_PARTICIPANT = "P";

    @Range(max = 32767, min = 1)
    private Short DeviceID;
    private ByteString FeatureSet;

    @Pattern(regexp = "[YN]{1}")
    private String HoldYn;

    @Size(max = 128, min = 1)
    private String InviteUserID;

    @Pattern(regexp = "[YN]{1}")
    private String MuteAudioYn;

    @Pattern(regexp = "[YN]{1}")
    private String MuteVideoYn;
    private P2PUserInfo P2PUserInfo;

    @SIPNo
    private String PhoneNo;

    @Pattern(regexp = "[YN]{1}")
    private String PushDisableYn;

    @Min(0)
    private Byte RegionCode;

    @Size(max = 128)
    private String RejectedMessage;
    private Date StartTime;

    @Pattern(regexp = "[0-9]{1,9}")
    private String Status;

    @Valid
    private List<ToDeviceID> ToDeviceIDList = new ArrayList();

    @NotNull
    @Size(max = 128, min = 1)
    private String UserID;

    @Size(max = 30)
    private String UserName;

    @Min(1)
    private Long UserNo;

    @StringCase(caseArray = {TYPE_HOST, "P"})
    private String UserType;

    public SimpleUserInfo() {
    }

    public SimpleUserInfo(String userID, String userName) {
        this.UserID = userID;
        this.UserName = userName;
    }

    public SimpleUserInfo(String userID, String userName, String status) {
        this.UserID = userID;
        this.UserName = userName;
        this.Status = status;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getUserType() {
        return this.UserType;
    }

    public void setUserType(String userType) {
        this.UserType = userType;
    }

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public Long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(Long userNo) {
        this.UserNo = userNo;
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

    public String getRejectedMessage() {
        return this.RejectedMessage;
    }

    public void setRejectedMessage(String rejectedMessage) {
        this.RejectedMessage = rejectedMessage;
    }

    public List<ToDeviceID> getToDeviceIDList() {
        return this.ToDeviceIDList;
    }

    public void setToDeviceIDList(List<ToDeviceID> toDeviceIDList) {
        this.ToDeviceIDList = toDeviceIDList;
    }

    public String getPushDisableYn() {
        return this.PushDisableYn;
    }

    public void setPushDisableYn(String pushDisableYn) {
        this.PushDisableYn = pushDisableYn;
    }

    public String getHoldYn() {
        return this.HoldYn;
    }

    public void setHoldYn(String holdYn) {
        this.HoldYn = holdYn;
    }

    public Byte getRegionCode() {
        return this.RegionCode;
    }

    public void setRegionCode(Byte regionCode) {
        this.RegionCode = regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.RegionCode = Byte.valueOf((byte) regionCode);
    }

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    public P2PUserInfo getP2PUserInfo() {
        return this.P2PUserInfo;
    }

    public void setP2PUserInfo(P2PUserInfo p2pUserInfo) {
        this.P2PUserInfo = p2pUserInfo;
    }

    public String getInviteUserID() {
        return this.InviteUserID;
    }

    public void setInviteUserID(String inviteUserID) {
        this.InviteUserID = inviteUserID;
    }

    public String getMuteVideoYn() {
        return this.MuteVideoYn;
    }

    public void setMuteVideoYn(String muteVideoYn) {
        this.MuteVideoYn = muteVideoYn;
    }

    public String getMuteAudioYn() {
        return this.MuteAudioYn;
    }

    public void setMuteAudioYn(String muteAudioYn) {
        this.MuteAudioYn = muteAudioYn;
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
        this.StartTime = DateTimeUtil.changeFormat(startTime, "yyyy-MM-dd HH:mm:ss");
    }

    public ByteString getFeatureSet() {
        return this.FeatureSet;
    }

    public void setFeatureSet(ByteString featureSet) {
        this.FeatureSet = featureSet;
    }

    public String toString() {
        return StringUtil.classToString(this);
    }
}
