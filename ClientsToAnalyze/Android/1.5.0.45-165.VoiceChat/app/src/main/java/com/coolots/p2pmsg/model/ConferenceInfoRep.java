package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ConferenceInfoRep extends MsgBody {

    @NotNull
    @Pattern(regexp = "[0-9]{16}")
    private String ConferenceNo;

    @NotNull
    @Pattern(regexp = "[AVS]{1}")
    private String ConferenceType;
    private String LatestVersion;

    @Size(max = 128, min = 1)
    private String PresenterUserID;
    private String Result;

    @NotNull
    private Date StartTime;

    @Pattern(regexp = "[YN]{1}")
    private String VideoConference;

    @NotNull
    @Valid
    @Size(max = 16, min = 1)
    private List<SimpleUserInfo> SimpleUserInfoList = new ArrayList();
    private List<URL> DownloadUrlList = new ArrayList();

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getVideoConference() {
        return this.VideoConference;
    }

    public void setVideoConference(String videoConference) {
        this.VideoConference = videoConference;
    }

    public List<SimpleUserInfo> getSimpleUserInfoList() {
        return this.SimpleUserInfoList;
    }

    public void setSimpleUserInfoList(List<SimpleUserInfo> simpleUserInfoList) {
        this.SimpleUserInfoList = simpleUserInfoList;
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

    public String getConferenceType() {
        return this.ConferenceType;
    }

    public void setConferenceType(String conferenceType) {
        this.ConferenceType = conferenceType;
    }

    public String getPresenterUserID() {
        return this.PresenterUserID;
    }

    public void setPresenterUserID(String presenterUserID) {
        this.PresenterUserID = presenterUserID;
    }

    public String getResult() {
        return this.Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }

    public String getLatestVersion() {
        return this.LatestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.LatestVersion = latestVersion;
    }

    public List<URL> getDownloadUrlList() {
        return this.DownloadUrlList;
    }

    public void setDownloadUrlList(List<URL> downloadUrlList) {
        this.DownloadUrlList = downloadUrlList;
    }
}
