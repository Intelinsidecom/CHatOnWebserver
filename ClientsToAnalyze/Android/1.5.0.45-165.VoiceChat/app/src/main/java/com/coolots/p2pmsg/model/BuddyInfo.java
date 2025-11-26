package com.coolots.p2pmsg.model;

import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.common.util.DateTimeUtil;
import com.coolots.common.util.StringUtil;
import com.coolots.p2pmsg.validator.StringCase;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/* loaded from: classes.dex */
public class BuddyInfo {
    public static final String BUDDY_CODE_BUDDY = "2";
    public static final String BUDDY_CODE_SUGGESTION = "1";
    public static final String DATA_NO = "N";
    public static final String DATA_YES = "Y";

    @StringCase(caseArray = {"Y", "N"})
    private String Block;

    @StringCase(caseArray = {"Y", "N"})
    private String BuddyCode;

    @Size(max = 40, min = 0)
    private String Comment;

    @StringCase(caseArray = {"Y", "N"})
    private String Delete;

    @Size(max = 30, min = 0)
    private String EditedUserName;

    @Size(max = 256)
    @Email
    private String Email;

    @StringCase(caseArray = {"Y", "N"})
    private String ExcludeMe;

    @StringCase(caseArray = {"Y", "N"})
    private String Favorite;

    @StringCase(caseArray = {"Y", "N"})
    private String Hide;

    @Size(max = 64, min = 0)
    private String MainPhoneNo;
    private List<PhoneNoInfo> PhoneNoList = new ArrayList();
    private Date ProfileImgUpdateDate;

    @Size(max = ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO, min = 1)
    private String Region;
    private String SamsungAccountID;

    @StringCase(caseArray = {"Y", "N"})
    private String Status;
    private Date UpdateDate;

    @Size(max = 128, min = 1)
    private String UserID;

    @Size(max = 30, min = 0)
    private String UserName;

    @Min(0)
    private long UserNo;

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

    public String getComment() {
        return this.Comment;
    }

    public void setComment(String comment) {
        this.Comment = comment;
    }

    public String getEditedUserName() {
        return this.EditedUserName;
    }

    public void setEditedUserName(String editedUserName) {
        this.EditedUserName = editedUserName;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public List<PhoneNoInfo> getPhoneNoList() {
        return this.PhoneNoList;
    }

    public void setPhoneNoList(List<PhoneNoInfo> phoneNoList) {
        this.PhoneNoList = phoneNoList;
    }

    public String getMainPhoneNo() {
        return this.MainPhoneNo;
    }

    public void setMainPhoneNo(String mainPhoneNo) {
        this.MainPhoneNo = mainPhoneNo;
    }

    public String getBuddyCode() {
        return this.BuddyCode;
    }

    public void setBuddyCode(String buddyCode) {
        this.BuddyCode = buddyCode;
    }

    public String getFavorite() {
        return this.Favorite;
    }

    public void setFavorite(String favorite) {
        this.Favorite = favorite;
    }

    public String getBlock() {
        return this.Block;
    }

    public void setBlock(String block) {
        this.Block = block;
    }

    public String getHide() {
        return this.Hide;
    }

    public void setHide(String hide) {
        this.Hide = hide;
    }

    public String getDelete() {
        return this.Delete;
    }

    public void setDelete(String delete) {
        this.Delete = delete;
    }

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getRegion() {
        return this.Region;
    }

    public void setRegion(String region) {
        this.Region = region;
    }

    public Date getProfileImgUpdateDate() {
        return this.ProfileImgUpdateDate;
    }

    public void setProfileImgUpdateDate(Date profileImgUpdateDate) {
        if (profileImgUpdateDate instanceof Timestamp) {
            this.ProfileImgUpdateDate = new Date(profileImgUpdateDate.getTime());
        } else {
            this.ProfileImgUpdateDate = profileImgUpdateDate;
        }
    }

    public void setProfileImgUpdateDate(String profileImgUpdateDate) throws ParseException {
        setProfileImgUpdateDate(DateTimeUtil.changeFormat(profileImgUpdateDate, "yyyy-MM-dd HH:mm:ss"));
    }

    public Date getUpdateDate() {
        return this.UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        if (updateDate instanceof Timestamp) {
            this.UpdateDate = new Date(updateDate.getTime());
        } else {
            this.UpdateDate = updateDate;
        }
    }

    public void setUpdateDate(String updateDate) throws ParseException {
        setUpdateDate(DateTimeUtil.changeFormat(updateDate, "yyyy-MM-dd HH:mm:ss"));
    }

    public String getExcludeMe() {
        return this.ExcludeMe;
    }

    public void setExcludeMe(String excludeMe) {
        this.ExcludeMe = excludeMe;
    }

    public String getSamsungAccountID() {
        return this.SamsungAccountID;
    }

    public void setSamsungAccountID(String samsungAccountID) {
        this.SamsungAccountID = samsungAccountID;
    }

    public String toString() {
        return StringUtil.classToString(this);
    }
}
