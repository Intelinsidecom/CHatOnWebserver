package com.samsung.android.sdk.look;

import android.content.Context;
import android.os.SystemProperties;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;

/* loaded from: classes.dex */
public final class Slook implements SsdkInterface {
    public static final int AIRBUTTON = 1;
    private static final int NOT_ASSIGN = -1;
    public static final int POINTERICON = 4;
    public static final int SMARTCLIP = 2;
    private static final String TAG = "Slook";
    public static final int WRITINGBUDDY = 3;
    private static int mVersionCode = -1;

    public class VERSION_CODES {

        /* renamed from: L1 */
        public static final int f450L1 = 1;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public int getVersionCode() {
        if (mVersionCode != -1) {
            return mVersionCode;
        }
        try {
            mVersionCode = SystemProperties.getInt("ro.slook.ver", 0);
        } catch (Exception e) {
            e.printStackTrace();
            mVersionCode = 0;
        }
        return mVersionCode;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public String getVersionName() {
        return null;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public void initialize(Context context) throws SsdkUnsupportedException {
        if (!SsdkVendorCheck.isSamsungDevice()) {
            throw new SsdkUnsupportedException("This device is not samsung product.", 0);
        }
        if (getVersionCode() < 1) {
            throw new SsdkUnsupportedException("This device is not supported.", 1);
        }
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public boolean isFeatureEnabled(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                return getVersionCode() >= 1;
            default:
                throw new IllegalArgumentException("The type(" + i + ") is not supported.");
        }
    }
}
