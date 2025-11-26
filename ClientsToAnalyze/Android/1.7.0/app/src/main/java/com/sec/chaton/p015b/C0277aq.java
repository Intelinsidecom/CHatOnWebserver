package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.aq */
/* loaded from: classes.dex */
public final class C0277aq extends GeneratedMessageLite implements InterfaceC0318cd {

    /* renamed from: a */
    private static final C0277aq f725a = new C0277aq(true);

    /* renamed from: b */
    private int f726b;

    /* renamed from: c */
    private long f727c;

    /* renamed from: d */
    private Object f728d;

    /* renamed from: e */
    private long f729e;

    /* renamed from: f */
    private C0308bu f730f;

    /* renamed from: g */
    private C0313bz f731g;

    /* renamed from: h */
    private byte f732h;

    /* renamed from: i */
    private int f733i;

    private C0277aq(C0265ae c0265ae) {
        super(c0265ae);
        this.f732h = (byte) -1;
        this.f733i = -1;
    }

    private C0277aq(boolean z) {
        this.f732h = (byte) -1;
        this.f733i = -1;
    }

    /* renamed from: a */
    public static C0277aq m1191a() {
        return f725a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0277aq getDefaultInstanceForType() {
        return f725a;
    }

    /* renamed from: c */
    public boolean m1200c() {
        return (this.f726b & 1) == 1;
    }

    /* renamed from: d */
    public long m1201d() {
        return this.f727c;
    }

    /* renamed from: e */
    public boolean m1202e() {
        return (this.f726b & 2) == 2;
    }

    /* renamed from: f */
    public String m1203f() {
        Object obj = this.f728d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f728d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m1197o() {
        Object obj = this.f728d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f728d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m1204g() {
        return (this.f726b & 4) == 4;
    }

    /* renamed from: h */
    public long m1205h() {
        return this.f729e;
    }

    /* renamed from: i */
    public boolean m1206i() {
        return (this.f726b & 8) == 8;
    }

    /* renamed from: j */
    public C0308bu m1207j() {
        return this.f730f;
    }

    /* renamed from: k */
    public boolean m1208k() {
        return (this.f726b & 16) == 16;
    }

    /* renamed from: l */
    public C0313bz m1209l() {
        return this.f731g;
    }

    /* renamed from: p */
    private void m1198p() {
        this.f727c = 0L;
        this.f728d = "";
        this.f729e = 0L;
        this.f730f = C0308bu.m1552a();
        this.f731g = C0313bz.m1619a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f732h;
        if (b != -1) {
            return b == 1;
        }
        this.f732h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f726b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f727c);
        }
        if ((this.f726b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1197o());
        }
        if ((this.f726b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f729e);
        }
        if ((this.f726b & 8) == 8) {
            codedOutputStream.writeMessage(4, this.f730f);
        }
        if ((this.f726b & 16) == 16) {
            codedOutputStream.writeMessage(5, this.f731g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f733i;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f726b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f727c) : 0;
            if ((this.f726b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m1197o());
            }
            if ((this.f726b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f729e);
            }
            if ((this.f726b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(4, this.f730f);
            }
            if ((this.f726b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(5, this.f731g);
            }
            this.f733i = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0277aq m1192a(byte[] bArr) {
        return ((C0265ae) newBuilder().mergeFrom(bArr)).m1016m();
    }

    public static C0265ae newBuilder() {
        return C0265ae.m1015l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0265ae newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0265ae m1190a(C0277aq c0277aq) {
        return newBuilder().mergeFrom(c0277aq);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0265ae toBuilder() {
        return m1190a(this);
    }

    static {
        f725a.m1198p();
    }
}
