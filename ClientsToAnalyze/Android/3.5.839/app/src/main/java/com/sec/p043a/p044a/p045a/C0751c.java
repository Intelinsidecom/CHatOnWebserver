package com.sec.p043a.p044a.p045a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.c */
/* loaded from: classes.dex */
public final class C0751c extends GeneratedMessageLite implements InterfaceC0753e {

    /* renamed from: a */
    private static final C0751c f1764a = new C0751c(true);

    /* renamed from: b */
    private int f1765b;

    /* renamed from: c */
    private int f1766c;

    /* renamed from: d */
    private int f1767d;

    /* renamed from: e */
    private Object f1768e;

    /* renamed from: f */
    private Object f1769f;

    /* renamed from: g */
    private byte f1770g;

    /* renamed from: h */
    private int f1771h;

    private C0751c(C0752d c0752d) {
        super(c0752d);
        this.f1770g = (byte) -1;
        this.f1771h = -1;
    }

    private C0751c(boolean z) {
        this.f1770g = (byte) -1;
        this.f1771h = -1;
    }

    /* renamed from: a */
    public static C0751c m2531a() {
        return f1764a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0751c getDefaultInstanceForType() {
        return f1764a;
    }

    /* renamed from: c */
    public boolean m2542c() {
        return (this.f1765b & 1) == 1;
    }

    /* renamed from: d */
    public int m2543d() {
        return this.f1766c;
    }

    /* renamed from: e */
    public boolean m2544e() {
        return (this.f1765b & 2) == 2;
    }

    /* renamed from: f */
    public int m2545f() {
        return this.f1767d;
    }

    /* renamed from: g */
    public boolean m2546g() {
        return (this.f1765b & 4) == 4;
    }

    /* renamed from: h */
    public String m2547h() {
        Object obj = this.f1768e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1768e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m2538m() {
        Object obj = this.f1768e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1768e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2548i() {
        return (this.f1765b & 8) == 8;
    }

    /* renamed from: j */
    public String m2549j() {
        Object obj = this.f1769f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1769f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m2539n() {
        Object obj = this.f1769f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1769f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    private void m2540o() {
        this.f1766c = 0;
        this.f1767d = 0;
        this.f1768e = "";
        this.f1769f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1770g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1770g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1765b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f1766c);
        }
        if ((this.f1765b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f1767d);
        }
        if ((this.f1765b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2538m());
        }
        if ((this.f1765b & 8) == 8) {
            codedOutputStream.writeBytes(4, m2539n());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f1771h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f1765b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f1766c) : 0;
            if ((this.f1765b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f1767d);
            }
            if ((this.f1765b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m2538m());
            }
            if ((this.f1765b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m2539n());
            }
            this.f1771h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0751c m2532a(byte[] bArr) {
        return ((C0752d) newBuilder().mergeFrom(bArr)).m2556i();
    }

    public static C0752d newBuilder() {
        return C0752d.m2555h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0752d newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0752d m2533a(C0751c c0751c) {
        return newBuilder().mergeFrom(c0751c);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0752d toBuilder() {
        return m2533a(this);
    }

    static {
        f1764a.m2540o();
    }
}
