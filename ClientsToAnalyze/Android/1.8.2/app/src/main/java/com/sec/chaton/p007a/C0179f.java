package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.f */
/* loaded from: classes.dex */
public final class C0179f extends GeneratedMessageLite implements InterfaceC0181h {

    /* renamed from: a */
    private static final C0179f f642a = new C0179f(true);

    /* renamed from: b */
    private int f643b;

    /* renamed from: c */
    private long f644c;

    /* renamed from: d */
    private EnumC0116ai f645d;

    /* renamed from: e */
    private Object f646e;

    /* renamed from: f */
    private Object f647f;

    /* renamed from: g */
    private Object f648g;

    /* renamed from: h */
    private Object f649h;

    /* renamed from: i */
    private Object f650i;

    /* renamed from: j */
    private byte f651j;

    /* renamed from: k */
    private int f652k;

    private C0179f(C0180g c0180g) {
        super(c0180g);
        this.f651j = (byte) -1;
        this.f652k = -1;
    }

    private C0179f(boolean z) {
        this.f651j = (byte) -1;
        this.f652k = -1;
    }

    /* renamed from: a */
    public static C0179f m1530a() {
        return f642a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0179f getDefaultInstanceForType() {
        return f642a;
    }

    /* renamed from: c */
    public boolean m1545c() {
        return (this.f643b & 1) == 1;
    }

    /* renamed from: d */
    public long m1546d() {
        return this.f644c;
    }

    /* renamed from: e */
    public boolean m1547e() {
        return (this.f643b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0116ai m1548f() {
        return this.f645d;
    }

    /* renamed from: g */
    public boolean m1549g() {
        return (this.f643b & 4) == 4;
    }

    /* renamed from: h */
    public String m1550h() {
        Object obj = this.f646e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f646e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m1538s() {
        Object obj = this.f646e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f646e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m1551i() {
        return (this.f643b & 8) == 8;
    }

    /* renamed from: j */
    public String m1552j() {
        Object obj = this.f647f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f647f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m1539t() {
        Object obj = this.f647f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f647f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1553k() {
        return (this.f643b & 16) == 16;
    }

    /* renamed from: l */
    public String m1554l() {
        Object obj = this.f648g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f648g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m1540u() {
        Object obj = this.f648g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f648g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m1555m() {
        return (this.f643b & 32) == 32;
    }

    /* renamed from: n */
    public String m1556n() {
        Object obj = this.f649h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f649h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m1541v() {
        Object obj = this.f649h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f649h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m1557o() {
        return (this.f643b & 64) == 64;
    }

    /* renamed from: p */
    public String m1558p() {
        Object obj = this.f650i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f650i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m1542w() {
        Object obj = this.f650i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f650i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: x */
    private void m1543x() {
        this.f644c = 0L;
        this.f645d = EnumC0116ai.SINGLE;
        this.f646e = "";
        this.f647f = "";
        this.f648g = "";
        this.f649h = "";
        this.f650i = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f651j;
        if (b != -1) {
            return b == 1;
        }
        this.f651j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f643b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f644c);
        }
        if ((this.f643b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f645d.getNumber());
        }
        if ((this.f643b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1538s());
        }
        if ((this.f643b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1539t());
        }
        if ((this.f643b & 16) == 16) {
            codedOutputStream.writeBytes(5, m1540u());
        }
        if ((this.f643b & 32) == 32) {
            codedOutputStream.writeBytes(6, m1541v());
        }
        if ((this.f643b & 64) == 64) {
            codedOutputStream.writeBytes(7, m1542w());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f652k;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f643b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f644c) : 0;
            if ((this.f643b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f645d.getNumber());
            }
            if ((this.f643b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m1538s());
            }
            if ((this.f643b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1539t());
            }
            if ((this.f643b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m1540u());
            }
            if ((this.f643b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(6, m1541v());
            }
            if ((this.f643b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(7, m1542w());
            }
            this.f652k = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0179f m1531a(byte[] bArr) {
        return ((C0180g) newBuilder().mergeFrom(bArr)).m1565n();
    }

    public static C0180g newBuilder() {
        return C0180g.m1564m();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0180g newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0180g m1532a(C0179f c0179f) {
        return newBuilder().mergeFrom(c0179f);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0180g toBuilder() {
        return m1532a(this);
    }

    static {
        f642a.m1543x();
    }
}
