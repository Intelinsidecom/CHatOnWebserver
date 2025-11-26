package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ee */
/* loaded from: classes.dex */
public final class C0905ee extends GeneratedMessageLite implements InterfaceC0907eg {

    /* renamed from: a */
    private static final C0905ee f2821a = new C0905ee(true);

    /* renamed from: b */
    private int f2822b;

    /* renamed from: c */
    private Object f2823c;

    /* renamed from: d */
    private Object f2824d;

    /* renamed from: e */
    private C0935fh f2825e;

    /* renamed from: f */
    private long f2826f;

    /* renamed from: g */
    private byte f2827g;

    /* renamed from: h */
    private int f2828h;

    private C0905ee(C0906ef c0906ef) {
        super(c0906ef);
        this.f2827g = (byte) -1;
        this.f2828h = -1;
    }

    private C0905ee(boolean z) {
        this.f2827g = (byte) -1;
        this.f2828h = -1;
    }

    /* renamed from: a */
    public static C0905ee m4848a() {
        return f2821a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0905ee getDefaultInstanceForType() {
        return f2821a;
    }

    /* renamed from: c */
    public boolean m4858c() {
        return (this.f2822b & 1) == 1;
    }

    /* renamed from: d */
    public String m4859d() {
        Object obj = this.f2823c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2823c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m4854m() {
        Object obj = this.f2823c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2823c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m4860e() {
        return (this.f2822b & 2) == 2;
    }

    /* renamed from: f */
    public String m4861f() {
        Object obj = this.f2824d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2824d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m4855n() {
        Object obj = this.f2824d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2824d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m4862g() {
        return (this.f2822b & 4) == 4;
    }

    /* renamed from: h */
    public C0935fh m4863h() {
        return this.f2825e;
    }

    /* renamed from: i */
    public boolean m4864i() {
        return (this.f2822b & 8) == 8;
    }

    /* renamed from: j */
    public long m4865j() {
        return this.f2826f;
    }

    /* renamed from: o */
    private void m4856o() {
        this.f2823c = "";
        this.f2824d = "";
        this.f2825e = C0935fh.m5211a();
        this.f2826f = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2827g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2827g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2822b & 1) == 1) {
            codedOutputStream.writeBytes(1, m4854m());
        }
        if ((this.f2822b & 2) == 2) {
            codedOutputStream.writeBytes(2, m4855n());
        }
        if ((this.f2822b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f2825e);
        }
        if ((this.f2822b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f2826f);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f2828h;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f2822b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m4854m()) : 0;
            if ((this.f2822b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m4855n());
            }
            if ((this.f2822b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeMessageSize(3, this.f2825e);
            }
            if ((this.f2822b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(4, this.f2826f);
            }
            this.f2828h = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0905ee m4849a(byte[] bArr) {
        return ((C0906ef) newBuilder().mergeFrom(bArr)).m4872k();
    }

    public static C0906ef newBuilder() {
        return C0906ef.m4871j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0906ef newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0906ef m4850a(C0905ee c0905ee) {
        return newBuilder().mergeFrom(c0905ee);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0906ef toBuilder() {
        return m4850a(this);
    }

    static {
        f2821a.m4856o();
    }
}
