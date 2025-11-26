package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dj */
/* loaded from: classes.dex */
public final class C0883dj extends GeneratedMessageLite implements InterfaceC0885dl {

    /* renamed from: a */
    private static final C0883dj f2704a = new C0883dj(true);

    /* renamed from: b */
    private int f2705b;

    /* renamed from: c */
    private EnumC0822bc f2706c;

    /* renamed from: d */
    private Object f2707d;

    /* renamed from: e */
    private Object f2708e;

    /* renamed from: f */
    private Object f2709f;

    /* renamed from: g */
    private EnumC0824be f2710g;

    /* renamed from: h */
    private int f2711h;

    /* renamed from: i */
    private long f2712i;

    /* renamed from: j */
    private byte f2713j;

    /* renamed from: k */
    private int f2714k;

    private C0883dj(C0884dk c0884dk) {
        super(c0884dk);
        this.f2713j = (byte) -1;
        this.f2714k = -1;
    }

    private C0883dj(boolean z) {
        this.f2713j = (byte) -1;
        this.f2714k = -1;
    }

    /* renamed from: a */
    public static C0883dj m4517a() {
        return f2704a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0883dj getDefaultInstanceForType() {
        return f2704a;
    }

    /* renamed from: c */
    public boolean m4529c() {
        return (this.f2705b & 1) == 1;
    }

    /* renamed from: d */
    public EnumC0822bc m4530d() {
        return this.f2706c;
    }

    /* renamed from: e */
    public boolean m4531e() {
        return (this.f2705b & 2) == 2;
    }

    /* renamed from: f */
    public String m4532f() {
        Object obj = this.f2707d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2707d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m4524s() {
        Object obj = this.f2707d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2707d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m4533g() {
        return (this.f2705b & 4) == 4;
    }

    /* renamed from: h */
    public String m4534h() {
        Object obj = this.f2708e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2708e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m4525t() {
        Object obj = this.f2708e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2708e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m4535i() {
        return (this.f2705b & 8) == 8;
    }

    /* renamed from: j */
    public String m4536j() {
        Object obj = this.f2709f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2709f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m4526u() {
        Object obj = this.f2709f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2709f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m4537k() {
        return (this.f2705b & 16) == 16;
    }

    /* renamed from: l */
    public EnumC0824be m4538l() {
        return this.f2710g;
    }

    /* renamed from: m */
    public boolean m4539m() {
        return (this.f2705b & 32) == 32;
    }

    /* renamed from: n */
    public int m4540n() {
        return this.f2711h;
    }

    /* renamed from: o */
    public boolean m4541o() {
        return (this.f2705b & 64) == 64;
    }

    /* renamed from: p */
    public long m4542p() {
        return this.f2712i;
    }

    /* renamed from: v */
    private void m4527v() {
        this.f2706c = EnumC0822bc.SINGLE;
        this.f2707d = "";
        this.f2708e = "";
        this.f2709f = "";
        this.f2710g = EnumC0824be.CONTENT_TEXT;
        this.f2711h = 0;
        this.f2712i = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2713j;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2713j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2705b & 1) == 1) {
            codedOutputStream.writeEnum(1, this.f2706c.getNumber());
        }
        if ((this.f2705b & 2) == 2) {
            codedOutputStream.writeBytes(2, m4524s());
        }
        if ((this.f2705b & 4) == 4) {
            codedOutputStream.writeBytes(3, m4525t());
        }
        if ((this.f2705b & 8) == 8) {
            codedOutputStream.writeBytes(4, m4526u());
        }
        if ((this.f2705b & 16) == 16) {
            codedOutputStream.writeEnum(5, this.f2710g.getNumber());
        }
        if ((this.f2705b & 32) == 32) {
            codedOutputStream.writeInt32(6, this.f2711h);
        }
        if ((this.f2705b & 64) == 64) {
            codedOutputStream.writeInt64(7, this.f2712i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeEnumSize = this.f2714k;
        if (iComputeEnumSize == -1) {
            iComputeEnumSize = (this.f2705b & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f2706c.getNumber()) : 0;
            if ((this.f2705b & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(2, m4524s());
            }
            if ((this.f2705b & 4) == 4) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(3, m4525t());
            }
            if ((this.f2705b & 8) == 8) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(4, m4526u());
            }
            if ((this.f2705b & 16) == 16) {
                iComputeEnumSize += CodedOutputStream.computeEnumSize(5, this.f2710g.getNumber());
            }
            if ((this.f2705b & 32) == 32) {
                iComputeEnumSize += CodedOutputStream.computeInt32Size(6, this.f2711h);
            }
            if ((this.f2705b & 64) == 64) {
                iComputeEnumSize += CodedOutputStream.computeInt64Size(7, this.f2712i);
            }
            this.f2714k = iComputeEnumSize;
        }
        return iComputeEnumSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0883dj m4518a(byte[] bArr) {
        return ((C0884dk) newBuilder().mergeFrom(bArr)).m4549o();
    }

    public static C0884dk newBuilder() {
        return C0884dk.m4548n();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0884dk newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0884dk m4519a(C0883dj c0883dj) {
        return newBuilder().mergeFrom(c0883dj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0884dk toBuilder() {
        return m4519a(this);
    }

    static {
        f2704a.m4527v();
    }
}
