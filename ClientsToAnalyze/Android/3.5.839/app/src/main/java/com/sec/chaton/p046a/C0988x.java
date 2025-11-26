package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.x */
/* loaded from: classes.dex */
public final class C0988x extends GeneratedMessageLite implements InterfaceC0990z {

    /* renamed from: a */
    private static final C0988x f3234a = new C0988x(true);

    /* renamed from: b */
    private int f3235b;

    /* renamed from: c */
    private Object f3236c;

    /* renamed from: d */
    private long f3237d;

    /* renamed from: e */
    private long f3238e;

    /* renamed from: f */
    private byte f3239f;

    /* renamed from: g */
    private int f3240g;

    private C0988x(C0989y c0989y) {
        super(c0989y);
        this.f3239f = (byte) -1;
        this.f3240g = -1;
    }

    private C0988x(boolean z) {
        this.f3239f = (byte) -1;
        this.f3240g = -1;
    }

    /* renamed from: a */
    public static C0988x m6009a() {
        return f3234a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0988x getDefaultInstanceForType() {
        return f3234a;
    }

    /* renamed from: c */
    public boolean m6016c() {
        return (this.f3235b & 1) == 1;
    }

    /* renamed from: d */
    public String m6017d() {
        Object obj = this.f3236c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3236c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m6013k() {
        Object obj = this.f3236c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3236c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m6018e() {
        return (this.f3235b & 2) == 2;
    }

    /* renamed from: f */
    public long m6019f() {
        return this.f3237d;
    }

    /* renamed from: g */
    public boolean m6020g() {
        return (this.f3235b & 4) == 4;
    }

    /* renamed from: h */
    public long m6021h() {
        return this.f3238e;
    }

    /* renamed from: l */
    private void m6014l() {
        this.f3236c = "";
        this.f3237d = 0L;
        this.f3238e = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3239f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3239f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3235b & 1) == 1) {
            codedOutputStream.writeBytes(1, m6013k());
        }
        if ((this.f3235b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f3237d);
        }
        if ((this.f3235b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f3238e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f3240g;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f3235b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m6013k()) : 0;
            if ((this.f3235b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(2, this.f3237d);
            }
            if ((this.f3235b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3238e);
            }
            this.f3240g = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0989y newBuilder() {
        return C0989y.m6026h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0989y newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0989y m6010a(C0988x c0988x) {
        return newBuilder().mergeFrom(c0988x);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0989y toBuilder() {
        return m6010a(this);
    }

    static {
        f3234a.m6014l();
    }
}
