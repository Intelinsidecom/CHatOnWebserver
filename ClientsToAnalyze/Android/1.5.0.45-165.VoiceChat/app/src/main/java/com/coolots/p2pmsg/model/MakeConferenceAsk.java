package com.coolots.p2pmsg.model;

import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class MakeConferenceAsk extends MsgBody {
    public static final int NETWORK_TYPE_2G = 2;
    public static final int NETWORK_TYPE_3G = 3;
    public static final int NETWORK_TYPE_4G = 4;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 1;
    public static final String TYPE_AUDIO = "A";
    public static final String TYPE_SEMINAR = "S";
    public static final String TYPE_VIDEO = "V";

    @Size(max = 64, min = 1)
    private String AppId;
    private String AppVersion;

    @Min(0)
    private Short CellularNetwork;

    @Pattern(regexp = "[AVS]{1}")
    private String ConferenceType;
    private String EventID;
    private ByteString FeatureSet;

    @Size(max = 100, min = 1)
    private String P2PKey;

    @Valid
    @Size(max = 16, min = 1)
    private List<SimpleUserInfo> SimpleUserInfoList = new ArrayList();

    @Pattern(regexp = "[YN]{1}")
    private String VideoConference;

    public List<SimpleUserInfo> getSimpleUserInfoList() {
        return this.SimpleUserInfoList;
    }

    public void setSimpleUserInfoList(List<SimpleUserInfo> simpleUserInfoList) {
        this.SimpleUserInfoList = simpleUserInfoList;
    }

    public String getVideoConference() {
        return this.VideoConference;
    }

    public void setVideoConference(String videoConference) {
        this.VideoConference = videoConference;
    }

    public Short getCellularNetwork() {
        return this.CellularNetwork;
    }

    public void setCellularNetwork(Short cellularNetwork) {
        this.CellularNetwork = cellularNetwork;
    }

    public void setCellularNetwork(int cellularNetwork) {
        this.CellularNetwork = Short.valueOf((short) cellularNetwork);
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
    }

    public String getConferenceType() {
        return this.ConferenceType;
    }

    public void setConferenceType(String conferenceType) {
        this.ConferenceType = conferenceType;
    }

    public String getEventID() {
        return this.EventID;
    }

    public void setEventID(String eventID) {
        this.EventID = eventID;
    }

    public String getAppVersion() {
        return this.AppVersion;
    }

    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
    }

    public String getAppId() {
        return this.AppId;
    }

    public void setAppId(String AppId) {
        this.AppId = AppId;
    }

    public ByteString getFeatureSet() {
        return this.FeatureSet;
    }

    public void setFeatureSet(ByteString featureSet) {
        this.FeatureSet = featureSet;
    }
}
