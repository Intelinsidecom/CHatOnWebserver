package com.sec.p013a.p014a.p015a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.aj */
/* loaded from: classes.dex */
public final class C0230aj extends GeneratedMessageLite implements InterfaceC0232al {

    /* renamed from: a */
    private static final C0230aj f500a = new C0230aj(true);

    /* renamed from: b */
    private int f501b;

    /* renamed from: c */
    private int f502c;

    /* renamed from: d */
    private int f503d;

    /* renamed from: e */
    private Object f504e;

    /* renamed from: f */
    private Object f505f;

    /* renamed from: g */
    private Object f506g;

    /* renamed from: h */
    private byte f507h;

    /* renamed from: i */
    private int f508i;

    private C0230aj(C0231ak c0231ak) {
        super(c0231ak);
        this.f507h = (byte) -1;
        this.f508i = -1;
    }

    private C0230aj(boolean z) {
        this.f507h = (byte) -1;
        this.f508i = -1;
    }

    /* renamed from: a */
    public static C0230aj m713a() {
        return f500a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0230aj getDefaultInstanceForType() {
        return f500a;
    }

    /* renamed from: c */
    public boolean m726c() {
        return (this.f501b & 1) == 1;
    }

    /* renamed from: d */
    public int m727d() {
        return this.f502c;
    }

    /* renamed from: e */
    public boolean m728e() {
        return (this.f501b & 2) == 2;
    }

    /* renamed from: f */
    public int m729f() {
        return this.f503d;
    }

    /* renamed from: g */
    public boolean m730g() {
        return (this.f501b & 4) == 4;
    }

    /* renamed from: h */
    public String m731h() {
        Object obj = this.f504e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f504e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m721o() {
        Object obj = this.f504e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f504e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m732i() {
        return (this.f501b & 8) == 8;
    }

    /* renamed from: j */
    public String m733j() {
        Object obj = this.f505f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f505f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m722p() {
        Object obj = this.f505f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f505f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m734k() {
        return (this.f501b & 16) == 16;
    }

    /* renamed from: l */
    public String m735l() {
        Object obj = this.f506g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f506g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m723q() {
        Object obj = this.f506g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f506g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: r */
    private void m724r() {
        this.f502c = 0;
        this.f503d = 0;
        this.f504e = "";
        this.f505f = "";
        this.f506g = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f507h;
        if (b != -1) {
            return b == 1;
        }
        this.f507h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f501b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f502c);
        }
        if ((this.f501b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f503d);
        }
        if ((this.f501b & 4) == 4) {
            codedOutputStream.writeBytes(3, m721o());
        }
        if ((this.f501b & 8) == 8) {
            codedOutputStream.writeBytes(4, m722p());
        }
        if ((this.f501b & 16) == 16) {
            codedOutputStream.writeBytes(5, m723q());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f508i;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f501b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f502c) : 0;
            if ((this.f501b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f503d);
            }
            if ((this.f501b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m721o());
            }
            if ((this.f501b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m722p());
            }
            if ((this.f501b & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(5, m723q());
            }
            this.f508i = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0230aj m714a(byte[] bArr) {
        return ((C0231ak) newBuilder().mergeFrom(bArr)).m742i();
    }

    public static C0231ak newBuilder() {
        return C0231ak.m741h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0231ak newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0231ak m715a(C0230aj c0230aj) {
        return newBuilder().mergeFrom(c0230aj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0231ak toBuilder() {
        return m715a(this);
    }

    static {
        f500a.m724r();
    }
}
