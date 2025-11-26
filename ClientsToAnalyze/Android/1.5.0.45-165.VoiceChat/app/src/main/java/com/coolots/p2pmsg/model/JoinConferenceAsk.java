package com.coolots.p2pmsg.model;

import com.google.protobuf.ByteString;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/* loaded from: classes.dex */
public class JoinConferenceAsk extends MsgBody {
    public static final int NETWORK_TYPE_MOBILE = 0;
    public static final int NETWORK_TYPE_WIFI = 1;

    @Min(0)
    private Short CellularNetwork;

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;
    private ByteString FeatureSet;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
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

    public ByteString getFeatureSet() {
        return this.FeatureSet;
    }

    public void setFeatureSet(ByteString featureSet) {
        this.FeatureSet = featureSet;
    }
}
