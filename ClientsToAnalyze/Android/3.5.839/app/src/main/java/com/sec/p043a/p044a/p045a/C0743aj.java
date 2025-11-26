package com.sec.p043a.p044a.p045a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.aj */
/* loaded from: classes.dex */
public final class C0743aj extends GeneratedMessageLite implements InterfaceC0745al {

    /* renamed from: a */
    private static final C0743aj f1736a = new C0743aj(true);

    /* renamed from: b */
    private int f1737b;

    /* renamed from: c */
    private int f1738c;

    /* renamed from: d */
    private int f1739d;

    /* renamed from: e */
    private Object f1740e;

    /* renamed from: f */
    private Object f1741f;

    /* renamed from: g */
    private Object f1742g;

    /* renamed from: h */
    private byte f1743h;

    /* renamed from: i */
    private int f1744i;

    private C0743aj(C0744ak c0744ak) {
        super(c0744ak);
        this.f1743h = (byte) -1;
        this.f1744i = -1;
    }

    private C0743aj(boolean z) {
        this.f1743h = (byte) -1;
        this.f1744i = -1;
    }

    /* renamed from: a */
    public static C0743aj m2445a() {
        return f1736a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0743aj getDefaultInstanceForType() {
        return f1736a;
    }

    /* renamed from: c */
    public boolean m2458c() {
        return (this.f1737b & 1) == 1;
    }

    /* renamed from: d */
    public int m2459d() {
        return this.f1738c;
    }

    /* renamed from: e */
    public boolean m2460e() {
        return (this.f1737b & 2) == 2;
    }

    /* renamed from: f */
    public int m2461f() {
        return this.f1739d;
    }

    /* renamed from: g */
    public boolean m2462g() {
        return (this.f1737b & 4) == 4;
    }

    /* renamed from: h */
    public String m2463h() {
        Object obj = this.f1740e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1740e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m2453o() {
        Object obj = this.f1740e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1740e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2464i() {
        return (this.f1737b & 8) == 8;
    }

    /* renamed from: j */
    public String m2465j() {
        Object obj = this.f1741f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1741f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m2454p() {
        Object obj = this.f1741f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1741f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m2466k() {
        return (this.f1737b & 16) == 16;
    }

    /* renamed from: l */
    public String m2467l() {
        Object obj = this.f1742g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1742g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m2455q() {
        Object obj = this.f1742g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1742g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: r */
    private void m2456r() {
        this.f1738c = 0;
        this.f1739d = 0;
        this.f1740e = "";
        this.f1741f = "";
        this.f1742g = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1743h;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1743h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1737b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f1738c);
        }
        if ((this.f1737b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f1739d);
        }
        if ((this.f1737b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2453o());
        }
        if ((this.f1737b & 8) == 8) {
            codedOutputStream.writeBytes(4, m2454p());
        }
        if ((this.f1737b & 16) == 16) {
            codedOutputStream.writeBytes(5, m2455q());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f1744i;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f1737b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f1738c) : 0;
            if ((this.f1737b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f1739d);
            }
            if ((this.f1737b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m2453o());
            }
            if ((this.f1737b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m2454p());
            }
            if ((this.f1737b & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(5, m2455q());
            }
            this.f1744i = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0743aj m2446a(byte[] bArr) {
        return ((C0744ak) newBuilder().mergeFrom(bArr)).m2474i();
    }

    public static C0744ak newBuilder() {
        return C0744ak.m2473h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0744ak newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0744ak m2447a(C0743aj c0743aj) {
        return newBuilder().mergeFrom(c0743aj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0744ak toBuilder() {
        return m2447a(this);
    }

    static {
        f1736a.m2456r();
    }
}
