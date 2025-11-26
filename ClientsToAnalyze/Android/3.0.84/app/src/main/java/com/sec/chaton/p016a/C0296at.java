package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.at */
/* loaded from: classes.dex */
public final class C0296at extends GeneratedMessageLite implements InterfaceC0298av {

    /* renamed from: a */
    private static final C0296at f950a = new C0296at(true);

    /* renamed from: b */
    private int f951b;

    /* renamed from: c */
    private long f952c;

    /* renamed from: d */
    private Object f953d;

    /* renamed from: e */
    private C0385ea f954e;

    /* renamed from: f */
    private long f955f;

    /* renamed from: g */
    private C0369dl f956g;

    /* renamed from: h */
    private byte f957h;

    /* renamed from: i */
    private int f958i;

    private C0296at(C0297au c0297au) {
        super(c0297au);
        this.f957h = (byte) -1;
        this.f958i = -1;
    }

    private C0296at(boolean z) {
        this.f957h = (byte) -1;
        this.f958i = -1;
    }

    /* renamed from: a */
    public static C0296at m1587a() {
        return f950a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0296at getDefaultInstanceForType() {
        return f950a;
    }

    /* renamed from: c */
    public boolean m1597c() {
        return (this.f951b & 1) == 1;
    }

    /* renamed from: d */
    public long m1598d() {
        return this.f952c;
    }

    /* renamed from: e */
    public boolean m1599e() {
        return (this.f951b & 2) == 2;
    }

    /* renamed from: f */
    public String m1600f() {
        Object obj = this.f953d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f953d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m1594o() {
        Object obj = this.f953d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f953d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m1601g() {
        return (this.f951b & 4) == 4;
    }

    /* renamed from: h */
    public C0385ea m1602h() {
        return this.f954e;
    }

    /* renamed from: i */
    public boolean m1603i() {
        return (this.f951b & 8) == 8;
    }

    /* renamed from: j */
    public long m1604j() {
        return this.f955f;
    }

    /* renamed from: k */
    public boolean m1605k() {
        return (this.f951b & 16) == 16;
    }

    /* renamed from: l */
    public C0369dl m1606l() {
        return this.f956g;
    }

    /* renamed from: p */
    private void m1595p() {
        this.f952c = 0L;
        this.f953d = "";
        this.f954e = C0385ea.m2690a();
        this.f955f = 0L;
        this.f956g = C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f957h;
        if (b != -1) {
            return b == 1;
        }
        this.f957h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f951b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f952c);
        }
        if ((this.f951b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1594o());
        }
        if ((this.f951b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f954e);
        }
        if ((this.f951b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f955f);
        }
        if ((this.f951b & 16) == 16) {
            codedOutputStream.writeMessage(5, this.f956g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f958i;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f951b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f952c) : 0;
            if ((this.f951b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m1594o());
            }
            if ((this.f951b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f954e);
            }
            if ((this.f951b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(4, this.f955f);
            }
            if ((this.f951b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(5, this.f956g);
            }
            this.f958i = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0296at m1588a(byte[] bArr) {
        return ((C0297au) newBuilder().mergeFrom(bArr)).m1613m();
    }

    public static C0297au newBuilder() {
        return C0297au.m1612l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0297au newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0297au m1589a(C0296at c0296at) {
        return newBuilder().mergeFrom(c0296at);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0297au toBuilder() {
        return m1589a(this);
    }

    static {
        f950a.m1595p();
    }
}
