package com.sec.p013a.p014a.p015a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ad */
/* loaded from: classes.dex */
public final class C0224ad extends GeneratedMessageLite implements InterfaceC0226af {

    /* renamed from: a */
    private static final C0224ad f464a = new C0224ad(true);

    /* renamed from: b */
    private int f465b;

    /* renamed from: c */
    private int f466c;

    /* renamed from: d */
    private Object f467d;

    /* renamed from: e */
    private Object f468e;

    /* renamed from: f */
    private int f469f;

    /* renamed from: g */
    private Object f470g;

    /* renamed from: h */
    private int f471h;

    /* renamed from: i */
    private int f472i;

    /* renamed from: j */
    private Object f473j;

    /* renamed from: k */
    private byte f474k;

    /* renamed from: l */
    private int f475l;

    private C0224ad(C0225ae c0225ae) {
        super(c0225ae);
        this.f474k = (byte) -1;
        this.f475l = -1;
    }

    private C0224ad(boolean z) {
        this.f474k = (byte) -1;
        this.f475l = -1;
    }

    /* renamed from: a */
    public static C0224ad m612a() {
        return f464a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0224ad getDefaultInstanceForType() {
        return f464a;
    }

    /* renamed from: c */
    public boolean m629c() {
        return (this.f465b & 1) == 1;
    }

    /* renamed from: d */
    public int m630d() {
        return this.f466c;
    }

    /* renamed from: e */
    public boolean m631e() {
        return (this.f465b & 2) == 2;
    }

    /* renamed from: f */
    public String m632f() {
        Object obj = this.f467d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f467d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m623u() {
        Object obj = this.f467d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f467d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m633g() {
        return (this.f465b & 4) == 4;
    }

    /* renamed from: h */
    public String m634h() {
        Object obj = this.f468e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f468e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m624v() {
        Object obj = this.f468e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f468e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m635i() {
        return (this.f465b & 8) == 8;
    }

    /* renamed from: j */
    public int m636j() {
        return this.f469f;
    }

    /* renamed from: k */
    public boolean m637k() {
        return (this.f465b & 16) == 16;
    }

    /* renamed from: l */
    public String m638l() {
        Object obj = this.f470g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f470g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m625w() {
        Object obj = this.f470g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f470g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m639m() {
        return (this.f465b & 32) == 32;
    }

    /* renamed from: n */
    public int m640n() {
        return this.f471h;
    }

    /* renamed from: o */
    public boolean m641o() {
        return (this.f465b & 64) == 64;
    }

    /* renamed from: p */
    public int m642p() {
        return this.f472i;
    }

    /* renamed from: q */
    public boolean m643q() {
        return (this.f465b & 128) == 128;
    }

    /* renamed from: r */
    public String m644r() {
        Object obj = this.f473j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f473j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m626x() {
        Object obj = this.f473j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f473j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: y */
    private void m627y() {
        this.f466c = 0;
        this.f467d = "";
        this.f468e = "";
        this.f469f = 0;
        this.f470g = "";
        this.f471h = 0;
        this.f472i = 0;
        this.f473j = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f474k;
        if (b != -1) {
            return b == 1;
        }
        this.f474k = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f465b & 1) == 1) {
            codedOutputStream.writeInt32(2, this.f466c);
        }
        if ((this.f465b & 2) == 2) {
            codedOutputStream.writeBytes(3, m623u());
        }
        if ((this.f465b & 4) == 4) {
            codedOutputStream.writeBytes(4, m624v());
        }
        if ((this.f465b & 8) == 8) {
            codedOutputStream.writeInt32(5, this.f469f);
        }
        if ((this.f465b & 16) == 16) {
            codedOutputStream.writeBytes(6, m625w());
        }
        if ((this.f465b & 32) == 32) {
            codedOutputStream.writeInt32(7, this.f471h);
        }
        if ((this.f465b & 64) == 64) {
            codedOutputStream.writeInt32(8, this.f472i);
        }
        if ((this.f465b & 128) == 128) {
            codedOutputStream.writeBytes(9, m626x());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f475l;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f465b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(2, this.f466c) : 0;
            if ((this.f465b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m623u());
            }
            if ((this.f465b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m624v());
            }
            if ((this.f465b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.f469f);
            }
            if ((this.f465b & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(6, m625w());
            }
            if ((this.f465b & 32) == 32) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.f471h);
            }
            if ((this.f465b & 64) == 64) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.f472i);
            }
            if ((this.f465b & 128) == 128) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(9, m626x());
            }
            this.f475l = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0224ad m613a(byte[] bArr) {
        return ((C0225ae) newBuilder().mergeFrom(bArr)).m651i();
    }

    public static C0225ae newBuilder() {
        return C0225ae.m650h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C0225ae newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0225ae m614a(C0224ad c0224ad) {
        return newBuilder().mergeFrom(c0224ad);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C0225ae toBuilder() {
        return m614a(this);
    }

    static {
        f464a.m627y();
    }
}
