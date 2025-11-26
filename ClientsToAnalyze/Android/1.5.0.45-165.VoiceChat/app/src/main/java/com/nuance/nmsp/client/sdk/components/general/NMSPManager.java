package com.nuance.nmsp.client.sdk.components.general;

import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem;
import com.nuance.nmsp.client.sdk.oem.MessageSystemOEM;

/* loaded from: classes.dex */
public abstract class NMSPManager {

    /* renamed from: a */
    private static final LogFactory.Log f99a = LogFactory.getLog(NMSPManager.class);
    protected String gatewayIP;
    protected short gatewayPort;
    protected NMSPDefines.Codec inputCodec;
    protected MessageSystem msgSys;
    protected NMSPDefines.Codec outputCodec;
    protected String uid;

    protected NMSPManager(String str, short s, String str2, NMSPDefines.Codec codec, NMSPDefines.Codec codec2) {
        if (f99a.isDebugEnabled()) {
            f99a.debug("in NMSPManager() gateway IP [" + str + "] Port [" + ((int) s) + "]");
        }
        String str3 = null;
        if (str == null) {
            str3 = " gatewayIP is null";
        } else if (str.length() == 0) {
            str3 = " gatewayIP is empty";
        }
        str3 = s <= 0 ? " gatewayPort should be greater than 0" : str3;
        if (str3 != null) {
            f99a.error("NMSPManager " + IllegalArgumentException.class.getName() + str3);
            throw new IllegalArgumentException(str3);
        }
        this.gatewayIP = str;
        this.gatewayPort = s;
        this.uid = str2;
        this.inputCodec = codec;
        this.outputCodec = codec2;
        this.msgSys = new MessageSystemOEM();
    }

    public static String discoverAPN(String str, short s) throws RuntimeException {
        throw new RuntimeException("Unsupported");
    }

    public static boolean verifyAPN(String str, String str2, short s) {
        return false;
    }

    public String getGatewayIP() {
        return this.gatewayIP;
    }

    public short getGatewayPort() {
        return this.gatewayPort;
    }

    public NMSPDefines.Codec getInputCodec() {
        return this.inputCodec;
    }

    public MessageSystem getMsgSys() {
        return this.msgSys;
    }

    public NMSPDefines.Codec getOutputCodec() {
        return this.outputCodec;
    }

    public String getUid() {
        return this.uid;
    }

    public void setInputCodec(NMSPDefines.Codec codec) {
        this.inputCodec = codec;
    }

    public void setOutputCodec(NMSPDefines.Codec codec) {
        this.outputCodec = codec;
    }

    public abstract void shutdown();
}
