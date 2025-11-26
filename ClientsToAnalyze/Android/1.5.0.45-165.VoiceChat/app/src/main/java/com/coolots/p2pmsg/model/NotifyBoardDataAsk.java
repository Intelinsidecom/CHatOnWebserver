package com.coolots.p2pmsg.model;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class NotifyBoardDataAsk extends MsgBody {
    private int BoardType;
    private int CallSessionID;
    private String ConferenceNo;
    private ByteString Contents;
    private String SrcUserID;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public int getCallSessionID() {
        return this.CallSessionID;
    }

    public void setCallSessionID(int callSessionID) {
        this.CallSessionID = callSessionID;
    }

    public String getSrcUserID() {
        return this.SrcUserID;
    }

    public void setSrcUserID(String srcUserID) {
        this.SrcUserID = srcUserID;
    }

    public int getBoardType() {
        return this.BoardType;
    }

    public void setBoardType(int boardType) {
        this.BoardType = boardType;
    }

    public ByteString getContents() {
        return this.Contents;
    }

    public void setContents(ByteString contents) {
        this.Contents = contents;
    }
}
