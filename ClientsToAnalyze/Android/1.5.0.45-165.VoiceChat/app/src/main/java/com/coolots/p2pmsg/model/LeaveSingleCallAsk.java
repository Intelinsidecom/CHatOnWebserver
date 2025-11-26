package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.StringCase;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class LeaveSingleCallAsk extends MsgBody {
    public static final String RELAY_DO_NOT_USE = "N";
    public static final String RELAY_USE = "Y";

    @Range(max = 32767, min = 1)
    private Short CalleeDeviceID;

    @NotNull
    private boolean Caller;

    @Size(max = 43, min = 18)
    private String CdrID;

    @StringCase(caseArray = {MakeSingleCallAsk.CALL_TYPE_SINGLE_AUDIO, MakeSingleCallAsk.CALL_TYPE_SINGLE_VIDEO})
    private String ConnectionType;

    @NotNull
    @Min(0)
    private int PDD;

    @NotNull
    @Pattern(regexp = "[YN]{1}")
    private String RelayYn;
    private int StatusCode;

    public String getCdrID() {
        return this.CdrID;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
    }

    public boolean isCaller() {
        return this.Caller;
    }

    public boolean getCaller() {
        return this.Caller;
    }

    public void setCaller(boolean caller) {
        this.Caller = caller;
    }

    public String getRelayYn() {
        return this.RelayYn;
    }

    public void setRelayYn(String relayYn) {
        this.RelayYn = relayYn;
    }

    public int getStatusCode() {
        return this.StatusCode;
    }

    public void setStatusCode(int statusCode) {
        this.StatusCode = statusCode;
    }

    public int getPDD() {
        return this.PDD;
    }

    public void setPDD(int pDD) {
        this.PDD = pDD;
    }

    public Short getCalleeDeviceID() {
        return this.CalleeDeviceID;
    }

    public void setCalleeDeviceID(Short calleeDeviceID) {
        this.CalleeDeviceID = calleeDeviceID;
    }

    public void setCalleeDeviceID(int calleeDeviceID) {
        this.CalleeDeviceID = Short.valueOf((short) calleeDeviceID);
    }

    public String getConnectionType() {
        return this.ConnectionType;
    }

    public void setConnectionType(String connectionType) {
        this.ConnectionType = connectionType;
    }
}
