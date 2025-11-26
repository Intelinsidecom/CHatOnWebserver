package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dp */
/* loaded from: classes.dex */
public final class C0889dp extends GeneratedMessageLite implements InterfaceC0891dr {

    /* renamed from: a */
    private static final C0889dp f2732a = new C0889dp(true);

    /* renamed from: b */
    private int f2733b;

    /* renamed from: c */
    private long f2734c;

    /* renamed from: d */
    private Object f2735d;

    /* renamed from: e */
    private Object f2736e;

    /* renamed from: f */
    private Object f2737f;

    /* renamed from: g */
    private Object f2738g;

    /* renamed from: h */
    private long f2739h;

    /* renamed from: i */
    private EnumC0822bc f2740i;

    /* renamed from: j */
    private Object f2741j;

    /* renamed from: k */
    private byte f2742k;

    /* renamed from: l */
    private int f2743l;

    private C0889dp(C0890dq c0890dq) {
        super(c0890dq);
        this.f2742k = (byte) -1;
        this.f2743l = -1;
    }

    private C0889dp(boolean z) {
        this.f2742k = (byte) -1;
        this.f2743l = -1;
    }

    /* renamed from: a */
    public static C0889dp m4604a() {
        return f2732a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0889dp getDefaultInstanceForType() {
        return f2732a;
    }

    /* renamed from: c */
    public boolean m4620c() {
        return (this.f2733b & 1) == 1;
    }

    /* renamed from: d */
    public long m4621d() {
        return this.f2734c;
    }

    /* renamed from: e */
    public boolean m4622e() {
        return (this.f2733b & 2) == 2;
    }

    /* renamed from: f */
    public String m4623f() {
        Object obj = this.f2735d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2735d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m4613u() {
        Object obj = this.f2735d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2735d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m4624g() {
        return (this.f2733b & 4) == 4;
    }

    /* renamed from: h */
    public String m4625h() {
        Object obj = this.f2736e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2736e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m4614v() {
        Object obj = this.f2736e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2736e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m4626i() {
        return (this.f2733b & 8) == 8;
    }

    /* renamed from: j */
    public String m4627j() {
        Object obj = this.f2737f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2737f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m4615w() {
        Object obj = this.f2737f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2737f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m4628k() {
        return (this.f2733b & 16) == 16;
    }

    /* renamed from: l */
    public String m4629l() {
        Object obj = this.f2738g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2738g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m4616x() {
        Object obj = this.f2738g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2738g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m4630m() {
        return (this.f2733b & 32) == 32;
    }

    /* renamed from: n */
    public long m4631n() {
        return this.f2739h;
    }

    /* renamed from: o */
    public boolean m4632o() {
        return (this.f2733b & 64) == 64;
    }

    /* renamed from: p */
    public EnumC0822bc m4633p() {
        return this.f2740i;
    }

    /* renamed from: q */
    public boolean m4634q() {
        return (this.f2733b & 128) == 128;
    }

    /* renamed from: r */
    public String m4635r() {
        Object obj = this.f2741j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2741j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m4617y() {
        Object obj = this.f2741j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2741j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: z */
    private void m4618z() {
        this.f2734c = 0L;
        this.f2735d = "";
        this.f2736e = "";
        this.f2737f = "";
        this.f2738g = "";
        this.f2739h = 0L;
        this.f2740i = EnumC0822bc.SINGLE;
        this.f2741j = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2742k;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2742k = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2733b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2734c);
        }
        if ((this.f2733b & 2) == 2) {
            codedOutputStream.writeBytes(2, m4613u());
        }
        if ((this.f2733b & 4) == 4) {
            codedOutputStream.writeBytes(3, m4614v());
        }
        if ((this.f2733b & 8) == 8) {
            codedOutputStream.writeBytes(4, m4615w());
        }
        if ((this.f2733b & 16) == 16) {
            codedOutputStream.writeBytes(5, m4616x());
        }
        if ((this.f2733b & 32) == 32) {
            codedOutputStream.writeInt64(6, this.f2739h);
        }
        if ((this.f2733b & 64) == 64) {
            codedOutputStream.writeEnum(7, this.f2740i.getNumber());
        }
        if ((this.f2733b & 128) == 128) {
            codedOutputStream.writeBytes(8, m4617y());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2743l;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2733b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2734c) : 0;
            if ((this.f2733b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m4613u());
            }
            if ((this.f2733b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m4614v());
            }
            if ((this.f2733b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m4615w());
            }
            if ((this.f2733b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m4616x());
            }
            if ((this.f2733b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(6, this.f2739h);
            }
            if ((this.f2733b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(7, this.f2740i.getNumber());
            }
            if ((this.f2733b & 128) == 128) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(8, m4617y());
            }
            this.f2743l = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0889dp m4605a(byte[] bArr) {
        return ((C0890dq) newBuilder().mergeFrom(bArr)).m4642i();
    }

    public static C0890dq newBuilder() {
        return C0890dq.m4641h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C0890dq newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0890dq m4606a(C0889dp c0889dp) {
        return newBuilder().mergeFrom(c0889dp);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C0890dq toBuilder() {
        return m4606a(this);
    }

    static {
        f2732a.m4618z();
    }
}
