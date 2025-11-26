package com.nuance.nmsp.client.sdk.components.resource.internal.common;

import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.general.NMSPManager;
import com.nuance.nmsp.client.sdk.components.general.Parameter;
import com.nuance.nmsp.client.sdk.components.resource.common.Manager;
import com.nuance.nmsp.client.sdk.components.resource.common.ManagerListener;
import java.util.Vector;

/* loaded from: classes.dex */
public class ManagerImpl extends NMSPManager implements Manager {

    /* renamed from: a */
    private static final LogFactory.Log f119a = LogFactory.getLog(ManagerImpl.class);
    public String applicationId;

    /* renamed from: b */
    private NMSPSession f120b;

    /* renamed from: c */
    private Object f121c;

    public ManagerImpl(String str, short s, String str2, byte[] bArr, String str3, NMSPDefines.Codec codec, NMSPDefines.Codec codec2, Vector vector, ManagerListener managerListener) {
        Vector vector2;
        super(str, s, str3, codec, codec2);
        if (str2 == null) {
            throw new IllegalArgumentException(" application id is null.");
        }
        this.applicationId = str2;
        if (bArr == null) {
            throw new IllegalArgumentException(" application key is null");
        }
        if (vector != null && vector.size() != 0) {
            vector2 = new Vector(vector.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= vector.size()) {
                    break;
                }
                Parameter parameter = (Parameter) vector.elementAt(i2);
                if (parameter.getType() == Parameter.Type.SDK && parameter.getName().equals(NMSPDefines.DEVICE_CMD_LOG_TO_SERVER_ENABLED)) {
                    this.f121c = new Vector();
                }
                vector2.addElement(parameter);
                i = i2 + 1;
            }
        } else {
            vector2 = new Vector();
        }
        this.f120b = new NMSPSession(getGatewayIP(), getGatewayPort(), str2, bArr, str3, vector2, getMsgSys(), managerListener);
    }

    public void clearResourceLogs() {
        this.f121c = null;
    }

    public Object getResourceLogs() {
        return this.f121c;
    }

    public NMSPSession getSession() {
        return this.f120b;
    }

    @Override // com.nuance.nmsp.client.sdk.components.general.NMSPManager, com.nuance.nmsp.client.sdk.components.resource.common.Manager
    public void shutdown() {
        f119a.debug("shutdown");
        this.f120b.disconnectAndShutdown();
    }
}
