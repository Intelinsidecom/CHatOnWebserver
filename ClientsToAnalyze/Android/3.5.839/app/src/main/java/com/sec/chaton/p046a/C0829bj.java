package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bj */
/* loaded from: classes.dex */
public final class C0829bj extends GeneratedMessageLite implements InterfaceC0834bo {

    /* renamed from: a */
    private static final C0829bj f2385a = new C0829bj(true);

    /* renamed from: b */
    private int f2386b;

    /* renamed from: c */
    private Object f2387c;

    /* renamed from: d */
    private List<C0831bl> f2388d;

    /* renamed from: e */
    private C0935fh f2389e;

    /* renamed from: f */
    private int f2390f;

    /* renamed from: g */
    private long f2391g;

    /* renamed from: h */
    private Object f2392h;

    /* renamed from: i */
    private byte f2393i;

    /* renamed from: j */
    private int f2394j;

    private C0829bj(C0830bk c0830bk) {
        super(c0830bk);
        this.f2393i = (byte) -1;
        this.f2394j = -1;
    }

    private C0829bj(boolean z) {
        this.f2393i = (byte) -1;
        this.f2394j = -1;
    }

    /* renamed from: a */
    public static C0829bj m3636a() {
        return f2385a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0829bj getDefaultInstanceForType() {
        return f2385a;
    }

    /* renamed from: c */
    public boolean m3650c() {
        return (this.f2386b & 1) == 1;
    }

    /* renamed from: d */
    public String m3651d() {
        Object obj = this.f2387c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2387c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m3645q() {
        Object obj = this.f2387c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2387c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List<C0831bl> m3652e() {
        return this.f2388d;
    }

    /* renamed from: f */
    public int m3653f() {
        return this.f2388d.size();
    }

    /* renamed from: a */
    public C0831bl m3648a(int i) {
        return this.f2388d.get(i);
    }

    /* renamed from: g */
    public boolean m3654g() {
        return (this.f2386b & 2) == 2;
    }

    /* renamed from: h */
    public C0935fh m3655h() {
        return this.f2389e;
    }

    /* renamed from: i */
    public boolean m3656i() {
        return (this.f2386b & 4) == 4;
    }

    /* renamed from: j */
    public int m3657j() {
        return this.f2390f;
    }

    /* renamed from: k */
    public boolean m3658k() {
        return (this.f2386b & 8) == 8;
    }

    /* renamed from: l */
    public long m3659l() {
        return this.f2391g;
    }

    /* renamed from: m */
    public boolean m3660m() {
        return (this.f2386b & 16) == 16;
    }

    /* renamed from: n */
    public String m3661n() {
        Object obj = this.f2392h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2392h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m3646r() {
        Object obj = this.f2392h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2392h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: s */
    private void m3647s() {
        this.f2387c = "";
        this.f2388d = Collections.emptyList();
        this.f2389e = C0935fh.m5211a();
        this.f2390f = 0;
        this.f2391g = 0L;
        this.f2392h = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2393i;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2393i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2386b & 1) == 1) {
            codedOutputStream.writeBytes(1, m3645q());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2388d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, this.f2388d.get(i2));
            i = i2 + 1;
        }
        if ((this.f2386b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f2389e);
        }
        if ((this.f2386b & 4) == 4) {
            codedOutputStream.writeInt32(4, this.f2390f);
        }
        if ((this.f2386b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f2391g);
        }
        if ((this.f2386b & 16) == 16) {
            codedOutputStream.writeBytes(6, m3646r());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeBytesSize = this.f2394j;
        if (iComputeBytesSize == -1) {
            int iComputeBytesSize2 = (this.f2386b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m3645q()) + 0 : 0;
            while (true) {
                iComputeBytesSize = iComputeBytesSize2;
                if (i >= this.f2388d.size()) {
                    break;
                }
                iComputeBytesSize2 = CodedOutputStream.computeMessageSize(2, this.f2388d.get(i)) + iComputeBytesSize;
                i++;
            }
            if ((this.f2386b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeMessageSize(3, this.f2389e);
            }
            if ((this.f2386b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(4, this.f2390f);
            }
            if ((this.f2386b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(5, this.f2391g);
            }
            if ((this.f2386b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m3646r());
            }
            this.f2394j = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0829bj m3637a(byte[] bArr) {
        return ((C0830bk) newBuilder().mergeFrom(bArr)).m3668n();
    }

    public static C0830bk newBuilder() {
        return C0830bk.m3667m();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0830bk newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0830bk m3638a(C0829bj c0829bj) {
        return newBuilder().mergeFrom(c0829bj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0830bk toBuilder() {
        return m3638a(this);
    }

    static {
        f2385a.m3647s();
    }
}
