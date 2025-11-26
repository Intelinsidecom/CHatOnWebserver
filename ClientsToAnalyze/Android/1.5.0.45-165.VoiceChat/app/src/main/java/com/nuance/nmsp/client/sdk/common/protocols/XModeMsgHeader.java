package com.nuance.nmsp.client.sdk.common.protocols;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.util.ByteConversion;

/* loaded from: classes.dex */
public class XModeMsgHeader {

    /* renamed from: a */
    private static final LogFactory.Log f66a = LogFactory.getLog(XModeMsgHeader.class);
    public short cmd;
    public int len;
    public byte protocol;
    public byte version;

    public XModeMsgHeader(byte b, byte b2, short s, int i) {
        if (f66a.isDebugEnabled()) {
            f66a.debug("Constructing XModeMsgHeader(protocol=" + ((int) b) + ", version=" + ((int) b2) + ", cmd=" + ((int) s) + ", len=" + i + ")");
        }
        this.protocol = b;
        this.version = b2;
        this.cmd = s;
        this.len = i;
    }

    public XModeMsgHeader(byte[] bArr) {
        if (f66a.isDebugEnabled()) {
            f66a.debug("Constructing XModeMsgHeader(byte[])");
            f66a.traceBuffer(bArr);
        }
        this.protocol = bArr[0];
        this.version = bArr[1];
        this.cmd = ByteConversion.bytesToShort(bArr, 2);
        this.len = ByteConversion.bytesToInt(bArr, 4);
    }

    public byte[] getBytes() {
        if (f66a.isDebugEnabled()) {
            f66a.debug("XModeMsgHeader.getBytes()");
        }
        byte[] bArr = new byte[8];
        bArr[0] = this.protocol;
        bArr[1] = this.version;
        ByteConversion.shortToBytes(this.cmd, bArr, 2);
        ByteConversion.intToBytes(this.len, bArr, 4);
        if (f66a.isDebugEnabled()) {
            f66a.trace("Generated: ");
            f66a.traceBuffer(bArr);
        }
        return bArr;
    }
}
