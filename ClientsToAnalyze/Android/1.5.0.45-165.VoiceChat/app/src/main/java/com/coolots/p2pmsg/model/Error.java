package com.coolots.p2pmsg.model;

import com.google.android.gcm.GCMConstants;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(GCMConstants.EXTRA_ERROR)
/* loaded from: classes.dex */
public class Error extends MsgBody {
    private int ErrorCode;
    private String ErrorMsg;
    private int MsgCode;
    private Integer MsgKey;
    private String ResponseCode;
    private int SvcCode;

    public int getSvcCode() {
        return this.SvcCode;
    }

    public void setSvcCode(int svcCode) {
        this.SvcCode = svcCode;
    }

    public int getMsgCode() {
        return this.MsgCode;
    }

    public void setMsgCode(int msgCode) {
        this.MsgCode = msgCode;
    }

    public Integer getMsgKey() {
        return this.MsgKey;
    }

    public void setMsgKey(Integer msgKey) {
        this.MsgKey = msgKey;
    }

    public int getErrorCode() {
        return this.ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.ErrorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.ErrorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.ErrorMsg = errorMsg;
    }

    public String getResponseCode() {
        return this.ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        this.ResponseCode = responseCode;
    }
}
