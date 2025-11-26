package com.sds.coolots.common.httpAdaptor;

import com.coolots.p2pmsg.model.BinaryMessage;
import com.coolots.p2pmsg.model.BinaryMessageType;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.util.EncodingUtil;
import com.sds.coolots.common.util.Log;
import java.nio.ByteBuffer;
import java.security.PrivateKey;

/* renamed from: com.sds.coolots.common.httpAdaptor.f */
/* loaded from: classes.dex */
public class C1256f {

    /* renamed from: a */
    protected String f3043a = "[CenterMessage]";

    /* renamed from: b */
    private P2PMsg f3044b;

    /* renamed from: c */
    private final int f3045c;

    /* renamed from: d */
    private final byte[] f3046d;

    /* renamed from: e */
    private String f3047e;

    /* renamed from: f */
    private String f3048f;

    /* renamed from: g */
    private String f3049g;

    /* renamed from: h */
    private byte[] f3050h;

    /* renamed from: i */
    private byte[] f3051i;

    public C1256f(P2PMsg p2PMsg, int i, byte[] bArr) {
        this.f3044b = p2PMsg;
        this.f3045c = i;
        this.f3046d = bArr;
    }

    /* renamed from: a */
    private String m2930a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return EncodingUtil.encodeBase64(bArr);
        } catch (Exception e) {
            m2936a("<Error>" + e.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    private void m2931a(byte[][] bArr) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr[0].length + 8 + bArr[1].length);
        byteBufferAllocate.putInt(bArr[0].length);
        byteBufferAllocate.putInt(bArr[1].length);
        byteBufferAllocate.put(bArr[0]);
        byteBufferAllocate.put(bArr[1]);
        BinaryMessageType binaryMessageType = new BinaryMessageType();
        if (this.f3046d == null || this.f3046d.length == 0) {
            binaryMessageType.setProtocolType(1);
        } else {
            binaryMessageType.setProtocolType(0);
        }
        byte[] bArrM2932a = m2932a(byteBufferAllocate.array(), this.f3046d);
        if (bArrM2932a != null) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(binaryMessageType.getType().length + 1 + bArrM2932a.length);
            byteBufferAllocate2.put((byte) binaryMessageType.getType().length);
            byteBufferAllocate2.put(binaryMessageType.getType());
            byteBufferAllocate2.put(bArrM2932a);
            this.f3049g = m2930a(byteBufferAllocate2.array());
        }
        System.gc();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x000f A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:9:0x000c, B:13:0x0015, B:11:0x000f), top: B:17:0x000c }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] m2932a(byte[] r5, byte[] r6) {
        /*
            r4 = this;
            r1 = 0
            if (r5 == 0) goto L6
            int r0 = r5.length
            if (r0 != 0) goto L7
        L6:
            return r1
        L7:
            r0 = r1
            byte[] r0 = (byte[]) r0
            if (r6 == 0) goto Lf
            int r0 = r6.length     // Catch: java.lang.Exception -> L20
            if (r0 != 0) goto L15
        Lf:
            byte[] r0 = com.sds.coolots.common.util.EncodingUtil.encodeAES2(r5)     // Catch: java.lang.Exception -> L20
        L13:
            r1 = r0
            goto L6
        L15:
            com.sds.coolots.common.controller.ConfigInterface r0 = com.sds.coolots.MainApplication.mConfig     // Catch: java.lang.Exception -> L20
            byte[] r0 = r0.getDecodedCipherKey()     // Catch: java.lang.Exception -> L20
            byte[] r0 = com.sds.coolots.common.util.EncodingUtil.encodeAES2(r5, r0)     // Catch: java.lang.Exception -> L20
            goto L13
        L20:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "<Error>"
            r2.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r4.m2936a(r0)
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sds.coolots.common.httpAdaptor.C1256f.m2932a(byte[], byte[]):byte[]");
    }

    /* renamed from: b */
    private void m2933b(byte[][] bArr) {
        this.f3047e = m2930a(bArr[0]);
        this.f3048f = m2930a(bArr[1]);
        System.gc();
    }

    /* renamed from: a */
    public int m2934a() {
        int i = 0;
        try {
            byte[][] bArrM2947a = C1258h.m2947a(this.f3044b);
            if (bArrM2947a == null || bArrM2947a.length != 2 || bArrM2947a[0] == null || bArrM2947a[1] == null) {
                i = -15;
            } else if (this.f3045c == 1) {
                m2933b(bArrM2947a);
            } else {
                m2931a(bArrM2947a);
            }
            return i;
        } catch (OutOfMemoryError e) {
            return -7;
        }
    }

    /* renamed from: a */
    public int m2935a(byte[] bArr, byte[] bArr2, PrivateKey privateKey) {
        byte[] bArrDecodeAES;
        try {
            BinaryMessageType type = BinaryMessage.getType(bArr);
            if (type == null) {
                m2938b("DECODE TYPE IS NULL!!!!");
                throw new Exception("Type is null! Ask administrator.");
            }
            if (type.getProtocolType() == 0) {
                m2938b("DECODE PROTOCOL_TYPE_NOMAL_AES!!!!");
                bArrDecodeAES = EncodingUtil.decodeAES(BinaryMessage.getMessageBytes(bArr), bArr2);
            } else if (type.getProtocolType() == 1) {
                m2938b("DECODE PROTOCOL_TYPE_RSA!!!!");
                bArrDecodeAES = EncodingUtil.decodeRSA(BinaryMessage.getMessageBytes(bArr), privateKey);
            } else {
                m2938b("DECODE default key!!!!");
                bArrDecodeAES = EncodingUtil.decodeAES(BinaryMessage.getMessageBytes(bArr));
            }
            BinaryMessage binaryMessage = new BinaryMessage(type, bArrDecodeAES);
            this.f3050h = binaryMessage.getHeader();
            this.f3051i = binaryMessage.getBody();
            if (this.f3050h != null && this.f3051i != null && this.f3050h.length != 0) {
                return 0;
            }
            m2936a("handleHttpRep DECODE ERROR!!!! #2");
            return -13;
        } catch (Exception e) {
            m2936a("handleHttpRep DECODE ERROR!!!! #1");
            return -13;
        }
    }

    /* renamed from: a */
    public void m2936a(String str) {
        Log.m2958e(String.valueOf(this.f3043a) + str);
    }

    /* renamed from: b */
    public String m2937b() {
        return this.f3047e;
    }

    /* renamed from: b */
    public void m2938b(String str) {
        Log.m2954d(String.valueOf(this.f3043a) + str);
    }

    /* renamed from: c */
    public int m2939c(String str) {
        String[] strArr;
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null) {
            m2938b("<RECV DATA> is null!!");
            return -5;
        }
        if (strArrSplit.length == 1) {
            strArr = new String[]{str, ""};
        } else {
            if (strArrSplit.length != 2) {
                return -5;
            }
            strArr = strArrSplit;
        }
        try {
            this.f3050h = EncodingUtil.decodeBase64ToBytes(strArr[0]);
            this.f3051i = EncodingUtil.decodeBase64ToBytes(strArr[1]);
            return 0;
        } catch (Exception e) {
            return -13;
        }
    }

    /* renamed from: c */
    public String m2940c() {
        return this.f3048f;
    }

    /* renamed from: d */
    public String m2941d() {
        return this.f3049g;
    }

    /* renamed from: e */
    public void m2942e() {
        this.f3044b = null;
        this.f3047e = "";
        this.f3048f = "";
        this.f3049g = "";
        System.gc();
    }

    /* renamed from: f */
    public byte[] m2943f() {
        return this.f3050h;
    }

    /* renamed from: g */
    public byte[] m2944g() {
        return this.f3051i;
    }
}
