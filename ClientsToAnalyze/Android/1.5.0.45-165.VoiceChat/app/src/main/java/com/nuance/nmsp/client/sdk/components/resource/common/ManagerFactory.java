package com.nuance.nmsp.client.sdk.components.resource.common;

import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.general.Parameter;
import com.nuance.nmsp.client.sdk.components.resource.internal.common.ManagerImpl;
import com.nuance.nmsp.client.sdk.oem.MessageSystemOEM;
import com.nuance.nmsp.client.sdk.oem.NetworkSystemOEM;
import com.nuance.nmsp.client.sdk.oem.TimerSystemOEM;
import java.util.Vector;

/* loaded from: classes.dex */
public class ManagerFactory {

    /* renamed from: a */
    private static final LogFactory.Log f118a = LogFactory.getLog(ManagerFactory.class);

    private ManagerFactory() {
    }

    public static Manager createManager(String str, short s, String str2, byte[] bArr, String str3, NMSPDefines.Codec codec, NMSPDefines.Codec codec2, Vector vector, ManagerListener managerListener) {
        Parameter parameter;
        if (f118a.isDebugEnabled()) {
            f118a.debug("createManager");
        }
        if (str == null || str.length() == 0) {
            f118a.error("NullPointerException gatewayIP is NULL. ");
            throw new NullPointerException("gatewayIP must be provided!");
        }
        if (s <= 0) {
            f118a.error("IllegalArgumentException gatewayPort is invalid. ");
            throw new IllegalArgumentException("gatewayPort invalid value!");
        }
        if (str2 == null) {
            f118a.error("NullPointerException applicationId is NULL. ");
            throw new NullPointerException("Application id can not be null!");
        }
        if (bArr == null) {
            f118a.error("NullPointerException appKey is NULL. ");
            throw new NullPointerException("Application key can not be null!");
        }
        if (str3 == null) {
            f118a.error("NullPointerException uid is NULL. ");
            throw new NullPointerException("uid can not be null!");
        }
        if (codec == null) {
            f118a.error("NullPointerException inputCodec is NULL. ");
            throw new NullPointerException("inputCodec can not be null!");
        }
        if (codec2 == null) {
            f118a.error("NullPointerException outputCodec is NULL. ");
            throw new NullPointerException("outputCodec can not be null!");
        }
        if (managerListener == null) {
            f118a.error("NullPointerException managerListener is NULL. ");
            throw new NullPointerException("managerListener can not be null!");
        }
        if (vector != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= vector.size()) {
                    break;
                }
                parameter = (Parameter) vector.elementAt(i2);
                if (parameter.getType() == Parameter.Type.SLOG || parameter.getType() == Parameter.Type.NSSLOG || parameter.getType() == Parameter.Type.GWLOG || parameter.getType() == Parameter.Type.SVSP || parameter.getType() == Parameter.Type.NSS || parameter.getType() == Parameter.Type.SIP || parameter.getType() == Parameter.Type.SDP) {
                    break;
                }
                i = i2 + 1;
            }
            f118a.error("IllegalArgumentException Parameter type: " + parameter.getType() + " not allowed. ");
            throw new IllegalArgumentException("Parameter type: " + parameter.getType() + " not allowed. ");
        }
        return new ManagerImpl(str, s, str2, bArr, str3, codec, codec2, vector, managerListener);
    }

    public static void terminate() {
        NetworkSystemOEM.terminate();
        TimerSystemOEM.terminate();
        MessageSystemOEM.terminate();
    }
}
