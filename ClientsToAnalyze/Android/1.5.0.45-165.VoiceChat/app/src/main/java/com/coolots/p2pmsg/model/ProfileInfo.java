package com.coolots.p2pmsg.model;

import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.common.util.DateTimeUtil;
import com.coolots.common.util.StringUtil;
import com.coolots.p2pmsg.validator.Email;
import com.coolots.p2pmsg.validator.StringCase;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ProfileInfo {

    @StringCase(caseArray = {"Y", "N"})
    private String BuddySuggestion;

    @Size(max = 40, min = 0)
    private String Comment;

    @Email
    private String Email;

    @StringCase(caseArray = {"Y", "N"})
    private String ExcludeMe;

    @Valid
    private List<PhoneNoInfo> PhoneNoList = new ArrayList();
    private Date ProfileImgUpdateDate;
    private Date ProfileUpdateDate;

    @Size(max = ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO, min = 1)
    private String Region;

    @StringCase(caseArray = {"Y", "N"})
    private String ShowCamOnRecv;

    @Size(max = 128, min = 1)
    private String UserID;

    @Size(max = 30, min = 0)
    private String UserName;

    @Min(0)
    private long UserNo;
    private Date VideoCallImgUpdateDate;

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
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

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getComment() {
        return this.Comment;
    }

    public void setComment(String comment) {
        this.Comment = comment;
    }

    public List<PhoneNoInfo> getPhoneNoList() {
        return this.PhoneNoList;
    }

    public void setPhoneNoList(List<PhoneNoInfo> phoneNoList) {
        this.PhoneNoList = phoneNoList;
    }

    public String getRegion() {
        return this.Region;
    }

    public void setRegion(String region) {
        this.Region = region;
    }

    public Date getProfileUpdateDate() {
        return this.ProfileUpdateDate;
    }

    public void setProfileUpdateDate(Date profileUpdateDate) {
        if (profileUpdateDate instanceof Timestamp) {
            this.ProfileUpdateDate = new Date(profileUpdateDate.getTime());
        } else {
            this.ProfileUpdateDate = profileUpdateDate;
        }
    }

    public void setProfileUpdateDate(String profileUpdateDate) throws ParseException {
        setProfileUpdateDate(DateTimeUtil.changeFormat(profileUpdateDate, "yyyy-MM-dd HH:mm:ss"));
    }

    public Date getProfileImgUpdateDate() {
        return this.ProfileImgUpdateDate;
    }

    public void setProfileImgUpdateDate(Date profileImgUpdateDate) {
        this.ProfileImgUpdateDate = profileImgUpdateDate;
    }

    public void setProfileImgUpdateDate(String profileUpdateDate) throws ParseException {
        setProfileImgUpdateDate(DateTimeUtil.changeFormat(profileUpdateDate, "yyyy-MM-dd HH:mm:ss"));
    }

    public Date getVideoCallImgUpdateDate() {
        return this.VideoCallImgUpdateDate;
    }

    public void setVideoCallImgUpdateDate(Date videoCallImgUpdateDate) {
        this.VideoCallImgUpdateDate = videoCallImgUpdateDate;
    }

    public void setVideoCallImgUpdateDate(String videoCallUpdateDate) throws ParseException {
        setVideoCallImgUpdateDate(DateTimeUtil.changeFormat(videoCallUpdateDate, "yyyy-MM-dd HH:mm:ss"));
    }

    public String getExcludeMe() {
        return this.ExcludeMe;
    }

    public void setExcludeMe(String excludeMe) {
        this.ExcludeMe = excludeMe;
    }

    public String getBuddySuggestion() {
        return this.BuddySuggestion;
    }

    public void setBuddySuggestion(String buddySuggestion) {
        this.BuddySuggestion = buddySuggestion;
    }

    public String getShowCamOnRecv() {
        return this.ShowCamOnRecv;
    }

    public void setShowCamOnRecv(String showCamOnRecv) {
        this.ShowCamOnRecv = showCamOnRecv;
    }

    public String toString() {
        return StringUtil.classToString(this);
    }
}
