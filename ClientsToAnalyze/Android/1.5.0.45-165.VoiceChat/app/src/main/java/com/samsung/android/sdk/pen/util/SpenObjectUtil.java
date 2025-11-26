package com.samsung.android.sdk.pen.util;

import com.samsung.android.sdk.pen.document.SpenInvalidPasswordException;
import com.samsung.android.sdk.pen.document.SpenObjectBase;

/* loaded from: classes.dex */
public class SpenObjectUtil {
    private static native byte[] ObjectUtil_getObjectExtraAllData(SpenObjectBase spenObjectBase, String str);

    private static native boolean ObjectUtil_setObjectExtraAllData(SpenObjectBase spenObjectBase, String str, byte[] bArr, int i);

    public static void setObjectExtraAllData(SpenObjectBase object, String masterKey, byte[] data) throws SpenInvalidPasswordException {
        if (object == null || masterKey == null || data == null) {
            throw new IllegalArgumentException();
        }
        boolean rnt = ObjectUtil_setObjectExtraAllData(object, masterKey, data, data.length);
        if (!rnt) {
            if (SpenError.getError() == 17) {
                throw new SpenInvalidPasswordException(String.valueOf(masterKey) + "is not correct");
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public static byte[] getObjectExtraAllData(SpenObjectBase object, String masterKey) throws SpenInvalidPasswordException {
        if (object == null || masterKey == null) {
            throw new IllegalArgumentException();
        }
        byte[] rnt = ObjectUtil_getObjectExtraAllData(object, masterKey);
        if (rnt == null) {
            if (SpenError.getError() == 17) {
                throw new SpenInvalidPasswordException(String.valueOf(masterKey) + "is not correct");
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return rnt;
    }
}
