package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.gf */
/* loaded from: classes.dex */
public final class C0960gf extends GeneratedMessageLite implements InterfaceC0962gh {

    /* renamed from: a */
    private static final C0960gf f3083a = new C0960gf(true);

    /* renamed from: b */
    private int f3084b;

    /* renamed from: c */
    private EnumC0813au f3085c;

    /* renamed from: d */
    private long f3086d;

    /* renamed from: e */
    private Object f3087e;

    /* renamed from: f */
    private byte f3088f;

    /* renamed from: g */
    private int f3089g;

    private C0960gf(C0961gg c0961gg) {
        super(c0961gg);
        this.f3088f = (byte) -1;
        this.f3089g = -1;
    }

    private C0960gf(boolean z) {
        this.f3088f = (byte) -1;
        this.f3089g = -1;
    }

    /* renamed from: a */
    public static C0960gf m5581a() {
        return f3083a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0960gf getDefaultInstanceForType() {
        return f3083a;
    }

    /* renamed from: c */
    public boolean m5587c() {
        return (this.f3084b & 1) == 1;
    }

    /* renamed from: d */
    public EnumC0813au m5588d() {
        return this.f3085c;
    }

    /* renamed from: e */
    public boolean m5589e() {
        return (this.f3084b & 2) == 2;
    }

    /* renamed from: f */
    public long m5590f() {
        return this.f3086d;
    }

    /* renamed from: g */
    public boolean m5591g() {
        return (this.f3084b & 4) == 4;
    }

    /* renamed from: h */
    public String m5592h() {
        Object obj = this.f3087e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3087e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m5584k() {
        Object obj = this.f3087e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3087e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m5585l() {
        this.f3085c = EnumC0813au.ENTER;
        this.f3086d = 0L;
        this.f3087e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3088f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3088f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3084b & 1) == 1) {
            codedOutputStream.writeEnum(1, this.f3085c.getNumber());
        }
        if ((this.f3084b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f3086d);
        }
        if ((this.f3084b & 4) == 4) {
            codedOutputStream.writeBytes(3, m5584k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeEnumSize = this.f3089g;
        if (iComputeEnumSize == -1) {
            iComputeEnumSize = (this.f3084b & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3085c.getNumber()) : 0;
            if ((this.f3084b & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeInt64Size(2, this.f3086d);
            }
            if ((this.f3084b & 4) == 4) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(3, m5584k());
            }
            this.f3089g = iComputeEnumSize;
        }
        return iComputeEnumSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0961gg newBuilder() {
        return C0961gg.m5597h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0961gg newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0961gg m5582a(C0960gf c0960gf) {
        return newBuilder().mergeFrom(c0960gf);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0961gg toBuilder() {
        return m5582a(this);
    }

    static {
        f3083a.m5585l();
    }
}
