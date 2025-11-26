package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.aw */
/* loaded from: classes.dex */
public final class C0283aw extends GeneratedMessageLite implements InterfaceC0302bo {

    /* renamed from: a */
    private static final C0283aw f743a = new C0283aw(true);

    /* renamed from: b */
    private int f744b;

    /* renamed from: c */
    private long f745c;

    /* renamed from: d */
    private Object f746d;

    /* renamed from: e */
    private C0308bu f747e;

    /* renamed from: f */
    private long f748f;

    /* renamed from: g */
    private C0313bz f749g;

    /* renamed from: h */
    private byte f750h;

    /* renamed from: i */
    private int f751i;

    private C0283aw(C0347u c0347u) {
        super(c0347u);
        this.f750h = (byte) -1;
        this.f751i = -1;
    }

    private C0283aw(boolean z) {
        this.f750h = (byte) -1;
        this.f751i = -1;
    }

    /* renamed from: a */
    public static C0283aw m1240a() {
        return f743a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0283aw getDefaultInstanceForType() {
        return f743a;
    }

    /* renamed from: c */
    public boolean m1250c() {
        return (this.f744b & 1) == 1;
    }

    /* renamed from: d */
    public long m1251d() {
        return this.f745c;
    }

    /* renamed from: e */
    public boolean m1252e() {
        return (this.f744b & 2) == 2;
    }

    /* renamed from: f */
    public String m1253f() {
        Object obj = this.f746d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f746d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m1247o() {
        Object obj = this.f746d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f746d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m1254g() {
        return (this.f744b & 4) == 4;
    }

    /* renamed from: h */
    public C0308bu m1255h() {
        return this.f747e;
    }

    /* renamed from: i */
    public boolean m1256i() {
        return (this.f744b & 8) == 8;
    }

    /* renamed from: j */
    public long m1257j() {
        return this.f748f;
    }

    /* renamed from: k */
    public boolean m1258k() {
        return (this.f744b & 16) == 16;
    }

    /* renamed from: l */
    public C0313bz m1259l() {
        return this.f749g;
    }

    /* renamed from: p */
    private void m1248p() {
        this.f745c = 0L;
        this.f746d = "";
        this.f747e = C0308bu.m1552a();
        this.f748f = 0L;
        this.f749g = C0313bz.m1619a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f750h;
        if (b != -1) {
            return b == 1;
        }
        this.f750h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f744b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f745c);
        }
        if ((this.f744b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1247o());
        }
        if ((this.f744b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f747e);
        }
        if ((this.f744b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f748f);
        }
        if ((this.f744b & 16) == 16) {
            codedOutputStream.writeMessage(5, this.f749g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f751i;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f744b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f745c) : 0;
            if ((this.f744b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m1247o());
            }
            if ((this.f744b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f747e);
            }
            if ((this.f744b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(4, this.f748f);
            }
            if ((this.f744b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(5, this.f749g);
            }
            this.f751i = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0283aw m1241a(byte[] bArr) {
        return ((C0347u) newBuilder().mergeFrom(bArr)).m1977m();
    }

    public static C0347u newBuilder() {
        return C0347u.m1976l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0347u newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0347u m1244a(C0283aw c0283aw) {
        return newBuilder().mergeFrom(c0283aw);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0347u toBuilder() {
        return m1244a(this);
    }

    static {
        f743a.m1248p();
    }
}
