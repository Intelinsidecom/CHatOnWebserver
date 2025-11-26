package com.sec.p043a.p044a.p045a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ad */
/* loaded from: classes.dex */
public final class C0737ad extends GeneratedMessageLite implements InterfaceC0739af {

    /* renamed from: a */
    private static final C0737ad f1700a = new C0737ad(true);

    /* renamed from: b */
    private int f1701b;

    /* renamed from: c */
    private int f1702c;

    /* renamed from: d */
    private Object f1703d;

    /* renamed from: e */
    private Object f1704e;

    /* renamed from: f */
    private int f1705f;

    /* renamed from: g */
    private Object f1706g;

    /* renamed from: h */
    private int f1707h;

    /* renamed from: i */
    private int f1708i;

    /* renamed from: j */
    private Object f1709j;

    /* renamed from: k */
    private byte f1710k;

    /* renamed from: l */
    private int f1711l;

    private C0737ad(C0738ae c0738ae) {
        super(c0738ae);
        this.f1710k = (byte) -1;
        this.f1711l = -1;
    }

    private C0737ad(boolean z) {
        this.f1710k = (byte) -1;
        this.f1711l = -1;
    }

    /* renamed from: a */
    public static C0737ad m2344a() {
        return f1700a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0737ad getDefaultInstanceForType() {
        return f1700a;
    }

    /* renamed from: c */
    public boolean m2361c() {
        return (this.f1701b & 1) == 1;
    }

    /* renamed from: d */
    public int m2362d() {
        return this.f1702c;
    }

    /* renamed from: e */
    public boolean m2363e() {
        return (this.f1701b & 2) == 2;
    }

    /* renamed from: f */
    public String m2364f() {
        Object obj = this.f1703d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1703d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m2355u() {
        Object obj = this.f1703d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1703d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m2365g() {
        return (this.f1701b & 4) == 4;
    }

    /* renamed from: h */
    public String m2366h() {
        Object obj = this.f1704e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1704e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m2356v() {
        Object obj = this.f1704e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1704e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2367i() {
        return (this.f1701b & 8) == 8;
    }

    /* renamed from: j */
    public int m2368j() {
        return this.f1705f;
    }

    /* renamed from: k */
    public boolean m2369k() {
        return (this.f1701b & 16) == 16;
    }

    /* renamed from: l */
    public String m2370l() {
        Object obj = this.f1706g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1706g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m2357w() {
        Object obj = this.f1706g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1706g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m2371m() {
        return (this.f1701b & 32) == 32;
    }

    /* renamed from: n */
    public int m2372n() {
        return this.f1707h;
    }

    /* renamed from: o */
    public boolean m2373o() {
        return (this.f1701b & 64) == 64;
    }

    /* renamed from: p */
    public int m2374p() {
        return this.f1708i;
    }

    /* renamed from: q */
    public boolean m2375q() {
        return (this.f1701b & 128) == 128;
    }

    /* renamed from: r */
    public String m2376r() {
        Object obj = this.f1709j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1709j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m2358x() {
        Object obj = this.f1709j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1709j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: y */
    private void m2359y() {
        this.f1702c = 0;
        this.f1703d = "";
        this.f1704e = "";
        this.f1705f = 0;
        this.f1706g = "";
        this.f1707h = 0;
        this.f1708i = 0;
        this.f1709j = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1710k;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1710k = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1701b & 1) == 1) {
            codedOutputStream.writeInt32(2, this.f1702c);
        }
        if ((this.f1701b & 2) == 2) {
            codedOutputStream.writeBytes(3, m2355u());
        }
        if ((this.f1701b & 4) == 4) {
            codedOutputStream.writeBytes(4, m2356v());
        }
        if ((this.f1701b & 8) == 8) {
            codedOutputStream.writeInt32(5, this.f1705f);
        }
        if ((this.f1701b & 16) == 16) {
            codedOutputStream.writeBytes(6, m2357w());
        }
        if ((this.f1701b & 32) == 32) {
            codedOutputStream.writeInt32(7, this.f1707h);
        }
        if ((this.f1701b & 64) == 64) {
            codedOutputStream.writeInt32(8, this.f1708i);
        }
        if ((this.f1701b & 128) == 128) {
            codedOutputStream.writeBytes(9, m2358x());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f1711l;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f1701b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(2, this.f1702c) : 0;
            if ((this.f1701b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m2355u());
            }
            if ((this.f1701b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m2356v());
            }
            if ((this.f1701b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.f1705f);
            }
            if ((this.f1701b & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(6, m2357w());
            }
            if ((this.f1701b & 32) == 32) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.f1707h);
            }
            if ((this.f1701b & 64) == 64) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.f1708i);
            }
            if ((this.f1701b & 128) == 128) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(9, m2358x());
            }
            this.f1711l = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0737ad m2345a(byte[] bArr) {
        return ((C0738ae) newBuilder().mergeFrom(bArr)).m2383i();
    }

    public static C0738ae newBuilder() {
        return C0738ae.m2382h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C0738ae newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0738ae m2346a(C0737ad c0737ad) {
        return newBuilder().mergeFrom(c0737ad);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C0738ae toBuilder() {
        return m2346a(this);
    }

    static {
        f1700a.m2359y();
    }
}
