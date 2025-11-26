package com.coolots.p2pmsg.model;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class PushMsgAsk extends MsgBody {
    public static final int PUSH_TYPE_ACCUMULATE = 1;
    public static final int PUSH_TYPE_OVERWRITE = 2;
    public static final int PUSH_TYPE_UNRELIABLE = 0;
    private String PushKey;
    private int PushType;
    private Short ToDeviceID;
    private String ToID;
    private ByteString nestedMsgBody;
    private ByteString nestedMsgHeader;

    public String getToID() {
        return this.ToID;
    }

    public void setToID(String toID) {
        this.ToID = toID;
    }

    public Short getToDeviceID() {
        return this.ToDeviceID;
    }

    public void setToDeviceID(Short toDeviceID) {
        this.ToDeviceID = toDeviceID;
    }

    public void setToDeviceID(int toDeviceID) {
        this.ToDeviceID = Short.valueOf((short) toDeviceID);
    }

    public ByteString getNestedMsgHeader() {
        return this.nestedMsgHeader;
    }

    public void setNestedMsgHeader(ByteString nestedMsgHeader) {
        this.nestedMsgHeader = nestedMsgHeader;
    }

    public ByteString getNestedMsgBody() {
        return this.nestedMsgBody;
    }

    public void setNestedMsgBody(ByteString nestedMsgBody) {
        this.nestedMsgBody = nestedMsgBody;
    }

    public String getPushKey() {
        return this.PushKey;
    }

    public void setPushKey(String pushKey) {
        this.PushKey = pushKey;
    }

    public int getPushType() {
        return this.PushType;
    }

    public void setPushType(int pushType) {
        this.PushType = pushType;
    }

    @Override // com.coolots.p2pmsg.model.MsgBody
    public String toString() {
        StringBuffer sbRet = new StringBuffer(512);
        sbRet.append("ToID[").append(this.ToID);
        sbRet.append("] ToDeviceID[").append(this.ToDeviceID);
        sbRet.append("] nestedMsgHeader[").append(this.nestedMsgHeader.toStringUtf8());
        sbRet.append("] mestedMsgBody[").append(this.nestedMsgBody.toStringUtf8());
        sbRet.append(']');
        return sbRet.toString();
    }
}
