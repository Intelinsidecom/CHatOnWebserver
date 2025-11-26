package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fw */
/* loaded from: classes.dex */
public final class C0950fw extends GeneratedMessageLite implements InterfaceC0952fy {

    /* renamed from: a */
    private static final C0950fw f3037a = new C0950fw(true);

    /* renamed from: b */
    private int f3038b;

    /* renamed from: c */
    private long f3039c;

    /* renamed from: d */
    private EnumC0908eh f3040d;

    /* renamed from: e */
    private Object f3041e;

    /* renamed from: f */
    private boolean f3042f;

    /* renamed from: g */
    private Object f3043g;

    /* renamed from: h */
    private byte f3044h;

    /* renamed from: i */
    private int f3045i;

    private C0950fw(C0951fx c0951fx) {
        super(c0951fx);
        this.f3044h = (byte) -1;
        this.f3045i = -1;
    }

    private C0950fw(boolean z) {
        this.f3044h = (byte) -1;
        this.f3045i = -1;
    }

    /* renamed from: a */
    public static C0950fw m5458a() {
        return f3037a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0950fw getDefaultInstanceForType() {
        return f3037a;
    }

    /* renamed from: c */
    public boolean m5467c() {
        return (this.f3038b & 1) == 1;
    }

    /* renamed from: d */
    public long m5468d() {
        return this.f3039c;
    }

    /* renamed from: e */
    public boolean m5469e() {
        return (this.f3038b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0908eh m5470f() {
        return this.f3040d;
    }

    /* renamed from: g */
    public boolean m5471g() {
        return (this.f3038b & 4) == 4;
    }

    /* renamed from: h */
    public String m5472h() {
        Object obj = this.f3041e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3041e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m5463o() {
        Object obj = this.f3041e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3041e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m5473i() {
        return (this.f3038b & 8) == 8;
    }

    /* renamed from: j */
    public boolean m5474j() {
        return this.f3042f;
    }

    /* renamed from: k */
    public boolean m5475k() {
        return (this.f3038b & 16) == 16;
    }

    /* renamed from: l */
    public String m5476l() {
        Object obj = this.f3043g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3043g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m5464p() {
        Object obj = this.f3043g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3043g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    private void m5465q() {
        this.f3039c = 0L;
        this.f3040d = EnumC0908eh.TEXT;
        this.f3041e = "";
        this.f3042f = false;
        this.f3043g = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3044h;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3044h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3038b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f3039c);
        }
        if ((this.f3038b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f3040d.getNumber());
        }
        if ((this.f3038b & 4) == 4) {
            codedOutputStream.writeBytes(3, m5463o());
        }
        if ((this.f3038b & 8) == 8) {
            codedOutputStream.writeBool(4, this.f3042f);
        }
        if ((this.f3038b & 16) == 16) {
            codedOutputStream.writeBytes(5, m5464p());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f3045i;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f3038b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3039c) : 0;
            if ((this.f3038b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f3040d.getNumber());
            }
            if ((this.f3038b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m5463o());
            }
            if ((this.f3038b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBoolSize(4, this.f3042f);
            }
            if ((this.f3038b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m5464p());
            }
            this.f3045i = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0951fx newBuilder() {
        return C0951fx.m5481h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0951fx newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0951fx m5459a(C0950fw c0950fw) {
        return newBuilder().mergeFrom(c0950fw);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0951fx toBuilder() {
        return m5459a(this);
    }

    static {
        f3037a.m5465q();
    }
}
