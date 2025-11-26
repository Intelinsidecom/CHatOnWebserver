package com.samsung.android.sdk;

/* loaded from: classes.dex */
public class SsdkUnsupportedException extends Exception {
    public static final int DEVICE_NOT_SUPPORTED = 1;
    public static final int VENDOR_NOT_SUPPORTED = 0;
    private int mType;

    public SsdkUnsupportedException(String s, int type) {
        super(s);
        this.mType = type;
    }

    public int getType() {
        return this.mType;
    }
}
