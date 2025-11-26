package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class DenyConferenceAsk extends MsgBody {

    @Min(0)
    private Short CellularNetwork;

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;

    @Size(max = 128)
    private String RejectedMessage;

    @NotNull
    @Min(10)
    private int StatusCode;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public int getStatusCode() {
        return this.StatusCode;
    }

    public void setStatusCode(int statusCode) {
        this.StatusCode = statusCode;
    }

    public String getRejectedMessage() {
        return this.RejectedMessage;
    }

    public void setRejectedMessage(String rejectedMessage) {
        this.RejectedMessage = rejectedMessage;
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
}
