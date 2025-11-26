package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class MemberDump {
    private Integer AutoChargeProductId;

    @NotNull
    private String AutoChargeYn;
    private String CloseReason;
    private String Comment;

    @NotNull
    private String Email;

    @NotNull
    private String GroupCode;

    @NotNull
    private Date InsertDate;

    @NotNull
    private String MailReceiveYn;

    @NotNull
    private String NationalCode;
    private Long Parent;

    @NotNull
    private String ReasonCd;

    @NotNull
    private String RefundYn;
    private String SamsungAccountID;

    @NotNull
    private String SearchableYn;

    @NotNull
    private String SvcStatus;

    @NotNull
    private String UserID;

    @NotNull
    private String UserName;

    @NotNull
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

    public void setUserID(String userId) {
        this.UserID = userId;
    }

    public String getSamsungAccountID() {
        return this.SamsungAccountID;
    }

    public void setSamsungAccountID(String samsungAccountID) {
        this.SamsungAccountID = samsungAccountID;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
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

    public String getNationalCode() {
        return this.NationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.NationalCode = nationalCode;
    }

    public String getSearchableYn() {
        return this.SearchableYn;
    }

    public void setSearchableYn(String searchableYn) {
        this.SearchableYn = searchableYn;
    }

    public String getSvcStatus() {
        return this.SvcStatus;
    }

    public void setSvcStatus(String svcStatus) {
        this.SvcStatus = svcStatus;
    }

    public String getReasonCd() {
        return this.ReasonCd;
    }

    public void setReasonCd(String reasonCd) {
        this.ReasonCd = reasonCd;
    }

    public String getAutoChargeYn() {
        return this.AutoChargeYn;
    }

    public void setAutoChargeYn(String autoChargeYn) {
        this.AutoChargeYn = autoChargeYn;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }

    public Integer getAutoChargeProductId() {
        return this.AutoChargeProductId;
    }

    public void setAutoChargeProductId(Integer autoChargeProductId) {
        this.AutoChargeProductId = autoChargeProductId;
    }

    public String getRefundYn() {
        return this.RefundYn;
    }

    public void setRefundYn(String refundYn) {
        this.RefundYn = refundYn;
    }

    public String getMailReceiveYn() {
        return this.MailReceiveYn;
    }

    public void setMailReceiveYn(String mailReceiveYn) {
        this.MailReceiveYn = mailReceiveYn;
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

    public String getCloseReason() {
        return this.CloseReason;
    }

    public void setCloseReason(String closeReason) {
        this.CloseReason = closeReason;
    }

    public Long getParent() {
        return this.Parent;
    }

    public void setParent(Long parent) {
        this.Parent = parent;
    }
}
