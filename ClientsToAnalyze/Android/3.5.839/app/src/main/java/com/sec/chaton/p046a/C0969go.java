package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.go */
/* loaded from: classes.dex */
public final class C0969go extends GeneratedMessageLite implements InterfaceC0971gq {

    /* renamed from: a */
    private static final C0969go f3122a = new C0969go(true);

    /* renamed from: b */
    private int f3123b;

    /* renamed from: c */
    private Object f3124c;

    /* renamed from: d */
    private Object f3125d;

    /* renamed from: e */
    private Object f3126e;

    /* renamed from: f */
    private Object f3127f;

    /* renamed from: g */
    private Object f3128g;

    /* renamed from: h */
    private long f3129h;

    /* renamed from: i */
    private long f3130i;

    /* renamed from: j */
    private byte f3131j;

    /* renamed from: k */
    private int f3132k;

    private C0969go(C0970gp c0970gp) {
        super(c0970gp);
        this.f3131j = (byte) -1;
        this.f3132k = -1;
    }

    private C0969go(boolean z) {
        this.f3131j = (byte) -1;
        this.f3132k = -1;
    }

    /* renamed from: a */
    public static C0969go m5688a() {
        return f3122a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0969go getDefaultInstanceForType() {
        return f3122a;
    }

    /* renamed from: c */
    public boolean m5704c() {
        return (this.f3123b & 1) == 1;
    }

    /* renamed from: d */
    public String m5705d() {
        Object obj = this.f3124c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3124c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m5697s() {
        Object obj = this.f3124c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3124c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m5706e() {
        return (this.f3123b & 2) == 2;
    }

    /* renamed from: f */
    public String m5707f() {
        Object obj = this.f3125d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3125d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m5698t() {
        Object obj = this.f3125d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3125d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m5708g() {
        return (this.f3123b & 4) == 4;
    }

    /* renamed from: h */
    public String m5709h() {
        Object obj = this.f3126e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3126e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m5699u() {
        Object obj = this.f3126e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3126e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m5710i() {
        return (this.f3123b & 8) == 8;
    }

    /* renamed from: j */
    public String m5711j() {
        Object obj = this.f3127f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3127f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m5700v() {
        Object obj = this.f3127f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3127f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m5712k() {
        return (this.f3123b & 16) == 16;
    }

    /* renamed from: l */
    public String m5713l() {
        Object obj = this.f3128g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3128g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m5701w() {
        Object obj = this.f3128g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3128g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m5714m() {
        return (this.f3123b & 32) == 32;
    }

    /* renamed from: n */
    public long m5715n() {
        return this.f3129h;
    }

    /* renamed from: o */
    public boolean m5716o() {
        return (this.f3123b & 64) == 64;
    }

    /* renamed from: p */
    public long m5717p() {
        return this.f3130i;
    }

    /* renamed from: x */
    private void m5702x() {
        this.f3124c = "";
        this.f3125d = "";
        this.f3126e = "";
        this.f3127f = "";
        this.f3128g = "";
        this.f3129h = 0L;
        this.f3130i = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3131j;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3131j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3123b & 1) == 1) {
            codedOutputStream.writeBytes(1, m5697s());
        }
        if ((this.f3123b & 2) == 2) {
            codedOutputStream.writeBytes(2, m5698t());
        }
        if ((this.f3123b & 4) == 4) {
            codedOutputStream.writeBytes(3, m5699u());
        }
        if ((this.f3123b & 8) == 8) {
            codedOutputStream.writeBytes(4, m5700v());
        }
        if ((this.f3123b & 16) == 16) {
            codedOutputStream.writeBytes(5, m5701w());
        }
        if ((this.f3123b & 32) == 32) {
            codedOutputStream.writeInt64(6, this.f3129h);
        }
        if ((this.f3123b & 64) == 64) {
            codedOutputStream.writeInt64(7, this.f3130i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f3132k;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f3123b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m5697s()) : 0;
            if ((this.f3123b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m5698t());
            }
            if ((this.f3123b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(3, m5699u());
            }
            if ((this.f3123b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(4, m5700v());
            }
            if ((this.f3123b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(5, m5701w());
            }
            if ((this.f3123b & 32) == 32) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(6, this.f3129h);
            }
            if ((this.f3123b & 64) == 64) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(7, this.f3130i);
            }
            this.f3132k = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0969go m5689a(byte[] bArr) {
        return ((C0970gp) newBuilder().mergeFrom(bArr)).m5724i();
    }

    public static C0970gp newBuilder() {
        return C0970gp.m5723h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0970gp newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0970gp m5690a(C0969go c0969go) {
        return newBuilder().mergeFrom(c0969go);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0970gp toBuilder() {
        return m5690a(this);
    }

    static {
        f3122a.m5702x();
    }
}
