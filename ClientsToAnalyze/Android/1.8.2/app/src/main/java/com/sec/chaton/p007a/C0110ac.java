package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ac */
/* loaded from: classes.dex */
public final class C0110ac extends GeneratedMessageLite implements InterfaceC0112ae {

    /* renamed from: a */
    private static final C0110ac f351a = new C0110ac(true);

    /* renamed from: b */
    private int f352b;

    /* renamed from: c */
    private long f353c;

    /* renamed from: d */
    private Object f354d;

    /* renamed from: e */
    private C0174cm f355e;

    /* renamed from: f */
    private long f356f;

    /* renamed from: g */
    private C0171cj f357g;

    /* renamed from: h */
    private byte f358h;

    /* renamed from: i */
    private int f359i;

    private C0110ac(C0111ad c0111ad) {
        super(c0111ad);
        this.f358h = (byte) -1;
        this.f359i = -1;
    }

    private C0110ac(boolean z) {
        this.f358h = (byte) -1;
        this.f359i = -1;
    }

    /* renamed from: a */
    public static C0110ac m694a() {
        return f351a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0110ac getDefaultInstanceForType() {
        return f351a;
    }

    /* renamed from: c */
    public boolean m704c() {
        return (this.f352b & 1) == 1;
    }

    /* renamed from: d */
    public long m705d() {
        return this.f353c;
    }

    /* renamed from: e */
    public boolean m706e() {
        return (this.f352b & 2) == 2;
    }

    /* renamed from: f */
    public String m707f() {
        Object obj = this.f354d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f354d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m701o() {
        Object obj = this.f354d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f354d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m708g() {
        return (this.f352b & 4) == 4;
    }

    /* renamed from: h */
    public C0174cm m709h() {
        return this.f355e;
    }

    /* renamed from: i */
    public boolean m710i() {
        return (this.f352b & 8) == 8;
    }

    /* renamed from: j */
    public long m711j() {
        return this.f356f;
    }

    /* renamed from: k */
    public boolean m712k() {
        return (this.f352b & 16) == 16;
    }

    /* renamed from: l */
    public C0171cj m713l() {
        return this.f357g;
    }

    /* renamed from: p */
    private void m702p() {
        this.f353c = 0L;
        this.f354d = "";
        this.f355e = C0174cm.m1485a();
        this.f356f = 0L;
        this.f357g = C0171cj.m1459a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f358h;
        if (b != -1) {
            return b == 1;
        }
        this.f358h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f352b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f353c);
        }
        if ((this.f352b & 2) == 2) {
            codedOutputStream.writeBytes(2, m701o());
        }
        if ((this.f352b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f355e);
        }
        if ((this.f352b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f356f);
        }
        if ((this.f352b & 16) == 16) {
            codedOutputStream.writeMessage(5, this.f357g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f359i;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f352b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f353c) : 0;
            if ((this.f352b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m701o());
            }
            if ((this.f352b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f355e);
            }
            if ((this.f352b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(4, this.f356f);
            }
            if ((this.f352b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(5, this.f357g);
            }
            this.f359i = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0110ac m695a(byte[] bArr) {
        return ((C0111ad) newBuilder().mergeFrom(bArr)).m720m();
    }

    public static C0111ad newBuilder() {
        return C0111ad.m719l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0111ad newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0111ad m696a(C0110ac c0110ac) {
        return newBuilder().mergeFrom(c0110ac);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0111ad toBuilder() {
        return m696a(this);
    }

    static {
        f351a.m702p();
    }
}
