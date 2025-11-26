package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class MakeSingleCallRep extends MsgBody {
    private Boolean Blocked;

    @NotNull
    @Size(max = 43, min = 18)
    private String CdrID;
    private String LatestVersion;

    @NotNull
    @Size(max = 100, min = 1)
    private String PushKey;
    private String Result;

    @NotNull
    private Date StartDate;

    @NotNull
    @Valid
    private List<ToDeviceID> ToDeviceIDList = new ArrayList();

    @Valid
    @Size(min = 1)
    private List<Server> Servers = new ArrayList();
    private List<URL> DownloadUrlList = new ArrayList();

    public String getPushKey() {
        return this.PushKey;
    }

    public void setPushKey(String pushKey) {
        this.PushKey = pushKey;
    }

    public String getCdrID() {
        return this.CdrID;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
    }

    public Date getStartDate() {
        return this.StartDate;
    }

    public void setStartDate(Date startDate) {
        if (startDate instanceof Timestamp) {
            this.StartDate = new Date(startDate.getTime());
        } else {
            this.StartDate = startDate;
        }
    }

    public void setStartDate(String startDate) throws ParseException {
        setStartDate(DateTimeUtil.changeFormat(startDate, "yyyy-MM-dd HH:mm:ss"));
    }

    public List<ToDeviceID> getToDeviceIDList() {
        return this.ToDeviceIDList;
    }

    public void setToDeviceIDList(List<ToDeviceID> toDeviceIDList) {
        this.ToDeviceIDList = toDeviceIDList;
    }

    public Boolean getBlocked() {
        return this.Blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.Blocked = blocked;
    }

    public List<Server> getServers() {
        return this.Servers;
    }

    public void setServers(List<Server> servers) {
        this.Servers = servers;
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
