package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cc */
/* loaded from: classes.dex */
public final class C0849cc extends GeneratedMessageLite implements InterfaceC0851ce {

    /* renamed from: a */
    private static final C0849cc f2464a = new C0849cc(true);

    /* renamed from: b */
    private int f2465b;

    /* renamed from: c */
    private long f2466c;

    /* renamed from: d */
    private EnumC0822bc f2467d;

    /* renamed from: e */
    private Object f2468e;

    /* renamed from: f */
    private Object f2469f;

    /* renamed from: g */
    private Object f2470g;

    /* renamed from: h */
    private LazyStringList f2471h;

    /* renamed from: i */
    private long f2472i;

    /* renamed from: j */
    private long f2473j;

    /* renamed from: k */
    private boolean f2474k;

    /* renamed from: l */
    private boolean f2475l;

    /* renamed from: m */
    private byte f2476m;

    /* renamed from: n */
    private int f2477n;

    private C0849cc(C0850cd c0850cd) {
        super(c0850cd);
        this.f2476m = (byte) -1;
        this.f2477n = -1;
    }

    private C0849cc(boolean z) {
        this.f2476m = (byte) -1;
        this.f2477n = -1;
    }

    /* renamed from: a */
    public static C0849cc m3854a() {
        return f2464a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0849cc getDefaultInstanceForType() {
        return f2464a;
    }

    /* renamed from: c */
    public boolean m3869c() {
        return (this.f2465b & 1) == 1;
    }

    /* renamed from: d */
    public long m3870d() {
        return this.f2466c;
    }

    /* renamed from: e */
    public boolean m3871e() {
        return (this.f2465b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0822bc m3872f() {
        return this.f2467d;
    }

    /* renamed from: g */
    public boolean m3873g() {
        return (this.f2465b & 4) == 4;
    }

    /* renamed from: h */
    public String m3874h() {
        Object obj = this.f2468e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2468e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m3865x() {
        Object obj = this.f2468e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2468e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m3875i() {
        return (this.f2465b & 8) == 8;
    }

    /* renamed from: j */
    public String m3876j() {
        Object obj = this.f2469f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2469f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m3866y() {
        Object obj = this.f2469f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2469f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m3877k() {
        return (this.f2465b & 16) == 16;
    }

    /* renamed from: l */
    public String m3878l() {
        Object obj = this.f2470g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2470g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m3867z() {
        Object obj = this.f2470g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2470g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public List<String> m3879m() {
        return this.f2471h;
    }

    /* renamed from: n */
    public boolean m3880n() {
        return (this.f2465b & 32) == 32;
    }

    /* renamed from: o */
    public long m3881o() {
        return this.f2472i;
    }

    /* renamed from: p */
    public boolean m3882p() {
        return (this.f2465b & 64) == 64;
    }

    /* renamed from: q */
    public long m3883q() {
        return this.f2473j;
    }

    /* renamed from: r */
    public boolean m3884r() {
        return (this.f2465b & 128) == 128;
    }

    /* renamed from: s */
    public boolean m3885s() {
        return this.f2474k;
    }

    /* renamed from: t */
    public boolean m3886t() {
        return (this.f2465b & 256) == 256;
    }

    /* renamed from: u */
    public boolean m3887u() {
        return this.f2475l;
    }

    /* renamed from: A */
    private void m3849A() {
        this.f2466c = 0L;
        this.f2467d = EnumC0822bc.SINGLE;
        this.f2468e = "";
        this.f2469f = "";
        this.f2470g = "";
        this.f2471h = LazyStringArrayList.EMPTY;
        this.f2472i = 0L;
        this.f2473j = 0L;
        this.f2474k = false;
        this.f2475l = false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2476m;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2476m = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2465b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2466c);
        }
        if ((this.f2465b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f2467d.getNumber());
        }
        if ((this.f2465b & 4) == 4) {
            codedOutputStream.writeBytes(3, m3865x());
        }
        if ((this.f2465b & 8) == 8) {
            codedOutputStream.writeBytes(4, m3866y());
        }
        if ((this.f2465b & 16) == 16) {
            codedOutputStream.writeBytes(5, m3867z());
        }
        for (int i = 0; i < this.f2471h.size(); i++) {
            codedOutputStream.writeBytes(6, this.f2471h.getByteString(i));
        }
        if ((this.f2465b & 32) == 32) {
            codedOutputStream.writeInt64(7, this.f2472i);
        }
        if ((this.f2465b & 64) == 64) {
            codedOutputStream.writeInt64(8, this.f2473j);
        }
        if ((this.f2465b & 128) == 128) {
            codedOutputStream.writeBool(9, this.f2474k);
        }
        if ((this.f2465b & 256) == 256) {
            codedOutputStream.writeBool(10, this.f2475l);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f2477n;
        if (size == -1) {
            int iComputeInt64Size = (this.f2465b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2466c) + 0 : 0;
            if ((this.f2465b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f2467d.getNumber());
            }
            if ((this.f2465b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m3865x());
            }
            if ((this.f2465b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m3866y());
            }
            if ((this.f2465b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m3867z());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f2471h.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2471h.getByteString(i));
            }
            size = iComputeInt64Size + iComputeBytesSizeNoTag + (m3879m().size() * 1);
            if ((this.f2465b & 32) == 32) {
                size += CodedOutputStream.computeInt64Size(7, this.f2472i);
            }
            if ((this.f2465b & 64) == 64) {
                size += CodedOutputStream.computeInt64Size(8, this.f2473j);
            }
            if ((this.f2465b & 128) == 128) {
                size += CodedOutputStream.computeBoolSize(9, this.f2474k);
            }
            if ((this.f2465b & 256) == 256) {
                size += CodedOutputStream.computeBoolSize(10, this.f2475l);
            }
            this.f2477n = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0849cc m3855a(byte[] bArr) {
        return ((C0850cd) newBuilder().mergeFrom(bArr)).m3894o();
    }

    public static C0850cd newBuilder() {
        return C0850cd.m3893n();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public C0850cd newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0850cd m3856a(C0849cc c0849cc) {
        return newBuilder().mergeFrom(c0849cc);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0850cd toBuilder() {
        return m3856a(this);
    }

    static {
        f2464a.m3849A();
    }
}
