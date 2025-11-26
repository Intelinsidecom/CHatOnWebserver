package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bm */
/* loaded from: classes.dex */
public final class C0147bm extends GeneratedMessageLite implements InterfaceC0149bo {

    /* renamed from: a */
    private static final C0147bm f513a = new C0147bm(true);

    /* renamed from: b */
    private int f514b;

    /* renamed from: c */
    private long f515c;

    /* renamed from: d */
    private Object f516d;

    /* renamed from: e */
    private long f517e;

    /* renamed from: f */
    private C0174cm f518f;

    /* renamed from: g */
    private C0171cj f519g;

    /* renamed from: h */
    private byte f520h;

    /* renamed from: i */
    private int f521i;

    private C0147bm(C0148bn c0148bn) {
        super(c0148bn);
        this.f520h = (byte) -1;
        this.f521i = -1;
    }

    private C0147bm(boolean z) {
        this.f520h = (byte) -1;
        this.f521i = -1;
    }

    /* renamed from: a */
    public static C0147bm m1146a() {
        return f513a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0147bm getDefaultInstanceForType() {
        return f513a;
    }

    /* renamed from: c */
    public boolean m1156c() {
        return (this.f514b & 1) == 1;
    }

    /* renamed from: d */
    public long m1157d() {
        return this.f515c;
    }

    /* renamed from: e */
    public boolean m1158e() {
        return (this.f514b & 2) == 2;
    }

    /* renamed from: f */
    public String m1159f() {
        Object obj = this.f516d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f516d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m1153o() {
        Object obj = this.f516d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f516d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m1160g() {
        return (this.f514b & 4) == 4;
    }

    /* renamed from: h */
    public long m1161h() {
        return this.f517e;
    }

    /* renamed from: i */
    public boolean m1162i() {
        return (this.f514b & 8) == 8;
    }

    /* renamed from: j */
    public C0174cm m1163j() {
        return this.f518f;
    }

    /* renamed from: k */
    public boolean m1164k() {
        return (this.f514b & 16) == 16;
    }

    /* renamed from: l */
    public C0171cj m1165l() {
        return this.f519g;
    }

    /* renamed from: p */
    private void m1154p() {
        this.f515c = 0L;
        this.f516d = "";
        this.f517e = 0L;
        this.f518f = C0174cm.m1485a();
        this.f519g = C0171cj.m1459a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f520h;
        if (b != -1) {
            return b == 1;
        }
        this.f520h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f514b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f515c);
        }
        if ((this.f514b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1153o());
        }
        if ((this.f514b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f517e);
        }
        if ((this.f514b & 8) == 8) {
            codedOutputStream.writeMessage(4, this.f518f);
        }
        if ((this.f514b & 16) == 16) {
            codedOutputStream.writeMessage(5, this.f519g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f521i;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f514b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f515c) : 0;
            if ((this.f514b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m1153o());
            }
            if ((this.f514b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f517e);
            }
            if ((this.f514b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(4, this.f518f);
            }
            if ((this.f514b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(5, this.f519g);
            }
            this.f521i = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0147bm m1147a(byte[] bArr) {
        return ((C0148bn) newBuilder().mergeFrom(bArr)).m1172m();
    }

    public static C0148bn newBuilder() {
        return C0148bn.m1171l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0148bn newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0148bn m1148a(C0147bm c0147bm) {
        return newBuilder().mergeFrom(c0147bm);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0148bn toBuilder() {
        return m1148a(this);
    }

    static {
        f513a.m1154p();
    }
}
