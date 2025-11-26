package com.nuance.nmsp.client.sdk.components.resource.nmas;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.general.Parameter;
import com.nuance.nmsp.client.sdk.components.resource.common.Manager;
import com.nuance.nmsp.client.sdk.components.resource.internal.common.ManagerImpl;
import com.nuance.nmsp.client.sdk.components.resource.internal.nmas.NMASResourceImpl;
import com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXQueryResult;
import java.util.Vector;

/* loaded from: classes.dex */
public class NMASResourceFactory {

    /* renamed from: a */
    private static final LogFactory.Log f210a = LogFactory.getLog(NMASResourceFactory.class);

    private NMASResourceFactory() {
    }

    public static NMASResource createNMASResource(Manager manager, NMASResourceListener nMASResourceListener, Vector vector, String str) {
        com.nuance.nmsp.client.sdk.components.general.Parameter parameter;
        if (f210a.isDebugEnabled()) {
            f210a.debug("createNMASResource");
        }
        if (manager == null) {
            f210a.error("manager is null");
            throw new NullPointerException("manager can not be null!");
        }
        if (nMASResourceListener == null) {
            f210a.error("nmasListener is null");
            throw new NullPointerException("nmasListener can not be null!");
        }
        if (vector != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= vector.size()) {
                    break;
                }
                parameter = (com.nuance.nmsp.client.sdk.components.general.Parameter) vector.elementAt(i2);
                if (parameter.getType() == Parameter.Type.APP || parameter.getType() == Parameter.Type.NSS || parameter.getType() == Parameter.Type.SLOG || parameter.getType() == Parameter.Type.NSSLOG || parameter.getType() == Parameter.Type.GWLOG || parameter.getType() == Parameter.Type.SVSP || parameter.getType() == Parameter.Type.SIP || parameter.getType() == Parameter.Type.SDP) {
                    break;
                }
                i = i2 + 1;
            }
            f210a.error("IllegalArgumentException Parameter type: " + parameter.getType() + " not allowed. ");
            throw new IllegalArgumentException("Parameter type: " + parameter.getType() + " not allowed. ");
        }
        return new NMASResourceImpl((ManagerImpl) manager, nMASResourceListener, vector, str);
    }

    public static QueryResult createQueryResult(byte[] bArr) {
        return new PDXQueryResult(bArr);
    }
}
