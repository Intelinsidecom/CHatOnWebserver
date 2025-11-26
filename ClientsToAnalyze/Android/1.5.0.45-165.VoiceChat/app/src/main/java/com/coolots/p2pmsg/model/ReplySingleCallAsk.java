package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class ReplySingleCallAsk extends MsgBody {

    @Size(max = 43, min = 18)
    private String CdrID;

    @Min(0)
    private Short CellularNetwork;

    @NotNull
    @Valid
    @Size(min = 0)
    private List<ToDeviceID> ReceiverDeviceIDList = new ArrayList();

    @NotNull
    @Size(max = 128, min = 1)
    private String ReceiverUserID;

    @Range(max = 32767, min = 1)
    private Short ReplyingDeviceID;

    public String getCdrID() {
        return this.CdrID;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
    }

    public String getReceiverUserID() {
        return this.ReceiverUserID;
    }

    public void setReceiverUserID(String receiverUserID) {
        this.ReceiverUserID = receiverUserID;
    }

    public List<ToDeviceID> getReceiverDeviceIDList() {
        return this.ReceiverDeviceIDList;
    }

    public void setReceiverDeviceIDList(List<ToDeviceID> receiverDeviceIDList) {
        this.ReceiverDeviceIDList = receiverDeviceIDList;
    }

    public Short getReplyingDeviceID() {
        return this.ReplyingDeviceID;
    }

    public void setReplyingDeviceID(Short replyingDeviceID) {
        this.ReplyingDeviceID = replyingDeviceID;
    }

    public void setReplyingDeviceID(int replyingDeviceID) {
        this.ReplyingDeviceID = Short.valueOf((short) replyingDeviceID);
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
