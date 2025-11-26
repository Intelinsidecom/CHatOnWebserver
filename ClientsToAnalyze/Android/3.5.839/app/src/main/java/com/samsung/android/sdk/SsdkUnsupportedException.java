package com.samsung.android.sdk;

/* loaded from: classes.dex */
public class SsdkUnsupportedException extends Exception {
    public static final int DEVICE_NOT_SUPPORTED = 1;
    public static final int SDK_VERSION_MISMATCH = 2;
    public static final int VENDOR_NOT_SUPPORTED = 0;
    private String mPackageName;
    private int mType;
    private int mVersionCode;

    public SsdkUnsupportedException(String str, int i) {
        super(str);
        this.mType = 0;
        this.mVersionCode = 0;
        this.mPackageName = null;
        this.mType = i;
    }

    public SsdkUnsupportedException(String str, int i, String str2, int i2) {
        super(str);
        this.mType = 0;
        this.mVersionCode = 0;
        this.mPackageName = null;
        this.mType = i;
        this.mPackageName = str2;
        this.mVersionCode = i2;
    }

    public int getType() {
        return this.mType;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }
}
