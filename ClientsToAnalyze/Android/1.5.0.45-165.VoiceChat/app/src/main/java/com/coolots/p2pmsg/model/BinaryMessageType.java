package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class BinaryMessageType {
    public static final int PROTOCOL_TYPE_FIXED_AES = 2;
    public static final int PROTOCOL_TYPE_NOMAL_AES = 0;
    public static final int PROTOCOL_TYPE_RSA = 1;
    private byte[] type;

    public BinaryMessageType() {
        this.type = new byte[4];
    }

    public BinaryMessageType(byte[] type) {
        this.type = type;
    }

    public BinaryMessageType(int length) {
        this.type = new byte[length];
    }

    public byte[] getType() {
        return this.type;
    }

    public void setType(byte[] type) {
        this.type = type;
    }

    public int getLength() {
        return this.type.length;
    }

    public int getProtocolType() {
        return this.type[0] & 3;
    }

    public void setProtocolType(int protocolType) {
        this.type[0] = (byte) (this.type[0] & 252);
        this.type[0] = (byte) (this.type[0] | protocolType);
    }
}
