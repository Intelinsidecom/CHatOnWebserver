package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.aj */
/* loaded from: classes.dex */
public final class C0066aj extends GeneratedMessageLite implements InterfaceC0068al {

    /* renamed from: a */
    private static final C0066aj f77a = new C0066aj(true);

    /* renamed from: b */
    private int f78b;

    /* renamed from: c */
    private int f79c;

    /* renamed from: d */
    private int f80d;

    /* renamed from: e */
    private Object f81e;

    /* renamed from: f */
    private Object f82f;

    /* renamed from: g */
    private Object f83g;

    /* renamed from: h */
    private byte f84h;

    /* renamed from: i */
    private int f85i;

    private C0066aj(C0067ak c0067ak) {
        super(c0067ak);
        this.f84h = (byte) -1;
        this.f85i = -1;
    }

    private C0066aj(boolean z) {
        this.f84h = (byte) -1;
        this.f85i = -1;
    }

    /* renamed from: a */
    public static C0066aj m201a() {
        return f77a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0066aj getDefaultInstanceForType() {
        return f77a;
    }

    /* renamed from: c */
    public boolean m214c() {
        return (this.f78b & 1) == 1;
    }

    /* renamed from: d */
    public int m215d() {
        return this.f79c;
    }

    /* renamed from: e */
    public boolean m216e() {
        return (this.f78b & 2) == 2;
    }

    /* renamed from: f */
    public int m217f() {
        return this.f80d;
    }

    /* renamed from: g */
    public boolean m218g() {
        return (this.f78b & 4) == 4;
    }

    /* renamed from: h */
    public String m219h() {
        Object obj = this.f81e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f81e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m209o() {
        Object obj = this.f81e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f81e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m220i() {
        return (this.f78b & 8) == 8;
    }

    /* renamed from: j */
    public String m221j() {
        Object obj = this.f82f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f82f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m210p() {
        Object obj = this.f82f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f82f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m222k() {
        return (this.f78b & 16) == 16;
    }

    /* renamed from: l */
    public String m223l() {
        Object obj = this.f83g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f83g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m211q() {
        Object obj = this.f83g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f83g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: r */
    private void m212r() {
        this.f79c = 0;
        this.f80d = 0;
        this.f81e = "";
        this.f82f = "";
        this.f83g = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f84h;
        if (b != -1) {
            return b == 1;
        }
        this.f84h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f78b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f79c);
        }
        if ((this.f78b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f80d);
        }
        if ((this.f78b & 4) == 4) {
            codedOutputStream.writeBytes(3, m209o());
        }
        if ((this.f78b & 8) == 8) {
            codedOutputStream.writeBytes(4, m210p());
        }
        if ((this.f78b & 16) == 16) {
            codedOutputStream.writeBytes(5, m211q());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f85i;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f78b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f79c) : 0;
            if ((this.f78b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f80d);
            }
            if ((this.f78b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m209o());
            }
            if ((this.f78b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m210p());
            }
            if ((this.f78b & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(5, m211q());
            }
            this.f85i = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0066aj m202a(byte[] bArr) {
        return ((C0067ak) newBuilder().mergeFrom(bArr)).m230i();
    }

    public static C0067ak newBuilder() {
        return C0067ak.m229h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0067ak newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0067ak m203a(C0066aj c0066aj) {
        return newBuilder().mergeFrom(c0066aj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0067ak toBuilder() {
        return m203a(this);
    }

    static {
        f77a.m212r();
    }
}
