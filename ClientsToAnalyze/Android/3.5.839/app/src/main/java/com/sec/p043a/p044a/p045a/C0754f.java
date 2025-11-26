package com.sec.p043a.p044a.p045a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.f */
/* loaded from: classes.dex */
public final class C0754f extends GeneratedMessageLite implements InterfaceC0756h {

    /* renamed from: a */
    private static final C0754f f1777a = new C0754f(true);

    /* renamed from: b */
    private int f1778b;

    /* renamed from: c */
    private int f1779c;

    /* renamed from: d */
    private Object f1780d;

    /* renamed from: e */
    private Object f1781e;

    /* renamed from: f */
    private Object f1782f;

    /* renamed from: g */
    private byte f1783g;

    /* renamed from: h */
    private int f1784h;

    private C0754f(C0755g c0755g) {
        super(c0755g);
        this.f1783g = (byte) -1;
        this.f1784h = -1;
    }

    private C0754f(boolean z) {
        this.f1783g = (byte) -1;
        this.f1784h = -1;
    }

    /* renamed from: a */
    public static C0754f m2569a() {
        return f1777a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0754f getDefaultInstanceForType() {
        return f1777a;
    }

    /* renamed from: c */
    public boolean m2581c() {
        return (this.f1778b & 1) == 1;
    }

    /* renamed from: d */
    public int m2582d() {
        return this.f1779c;
    }

    /* renamed from: e */
    public boolean m2583e() {
        return (this.f1778b & 2) == 2;
    }

    /* renamed from: f */
    public String m2584f() {
        Object obj = this.f1780d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1780d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m2576m() {
        Object obj = this.f1780d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1780d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m2585g() {
        return (this.f1778b & 4) == 4;
    }

    /* renamed from: h */
    public String m2586h() {
        Object obj = this.f1781e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1781e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m2577n() {
        Object obj = this.f1781e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1781e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2587i() {
        return (this.f1778b & 8) == 8;
    }

    /* renamed from: j */
    public String m2588j() {
        Object obj = this.f1782f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1782f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m2578o() {
        Object obj = this.f1782f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1782f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    private void m2579p() {
        this.f1779c = 0;
        this.f1780d = "";
        this.f1781e = "";
        this.f1782f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1783g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1783g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1778b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f1779c);
        }
        if ((this.f1778b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2576m());
        }
        if ((this.f1778b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2577n());
        }
        if ((this.f1778b & 8) == 8) {
            codedOutputStream.writeBytes(4, m2578o());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f1784h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f1778b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f1779c) : 0;
            if ((this.f1778b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m2576m());
            }
            if ((this.f1778b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m2577n());
            }
            if ((this.f1778b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m2578o());
            }
            this.f1784h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0754f m2570a(byte[] bArr) {
        return ((C0755g) newBuilder().mergeFrom(bArr)).m2595i();
    }

    public static C0755g newBuilder() {
        return C0755g.m2594h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0755g newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0755g m2571a(C0754f c0754f) {
        return newBuilder().mergeFrom(c0754f);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0755g toBuilder() {
        return m2571a(this);
    }

    static {
        f1777a.m2579p();
    }
}
