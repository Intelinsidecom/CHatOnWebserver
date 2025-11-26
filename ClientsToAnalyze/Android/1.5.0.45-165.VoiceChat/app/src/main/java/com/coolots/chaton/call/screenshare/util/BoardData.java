package com.coolots.chaton.call.screenshare.util;

/* loaded from: classes.dex */
public class BoardData {
    private byte[] mData;
    private int mType;

    public BoardData(int type, byte[] data) {
        this.mType = type;
        this.mData = data;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public byte[] getData() {
        return this.mData;
    }

    public void setData(byte[] data) {
        this.mData = data;
    }

    public int getType() {
        return this.mType;
    }
}
