package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cx */
/* loaded from: classes.dex */
public final class C0870cx extends GeneratedMessageLite implements InterfaceC0872cz {

    /* renamed from: a */
    private static final C0870cx f2605a = new C0870cx(true);

    /* renamed from: b */
    private int f2606b;

    /* renamed from: c */
    private long f2607c;

    /* renamed from: d */
    private Object f2608d;

    /* renamed from: e */
    private long f2609e;

    /* renamed from: f */
    private C0957gc f2610f;

    /* renamed from: g */
    private C0935fh f2611g;

    /* renamed from: h */
    private long f2612h;

    /* renamed from: i */
    private byte f2613i;

    /* renamed from: j */
    private int f2614j;

    private C0870cx(C0871cy c0871cy) {
        super(c0871cy);
        this.f2613i = (byte) -1;
        this.f2614j = -1;
    }

    private C0870cx(boolean z) {
        this.f2613i = (byte) -1;
        this.f2614j = -1;
    }

    /* renamed from: a */
    public static C0870cx m4238a() {
        return f2605a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0870cx getDefaultInstanceForType() {
        return f2605a;
    }

    /* renamed from: c */
    public boolean m4249c() {
        return (this.f2606b & 1) == 1;
    }

    /* renamed from: d */
    public long m4250d() {
        return this.f2607c;
    }

    /* renamed from: e */
    public boolean m4251e() {
        return (this.f2606b & 2) == 2;
    }

    /* renamed from: f */
    public String m4252f() {
        Object obj = this.f2608d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2608d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m4246q() {
        Object obj = this.f2608d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2608d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m4253g() {
        return (this.f2606b & 4) == 4;
    }

    /* renamed from: h */
    public long m4254h() {
        return this.f2609e;
    }

    /* renamed from: i */
    public boolean m4255i() {
        return (this.f2606b & 8) == 8;
    }

    /* renamed from: j */
    public C0957gc m4256j() {
        return this.f2610f;
    }

    /* renamed from: k */
    public boolean m4257k() {
        return (this.f2606b & 16) == 16;
    }

    /* renamed from: l */
    public C0935fh m4258l() {
        return this.f2611g;
    }

    /* renamed from: m */
    public boolean m4259m() {
        return (this.f2606b & 32) == 32;
    }

    /* renamed from: n */
    public long m4260n() {
        return this.f2612h;
    }

    /* renamed from: r */
    private void m4247r() {
        this.f2607c = 0L;
        this.f2608d = "";
        this.f2609e = 0L;
        this.f2610f = C0957gc.m5553a();
        this.f2611g = C0935fh.m5211a();
        this.f2612h = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2613i;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2613i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2606b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2607c);
        }
        if ((this.f2606b & 2) == 2) {
            codedOutputStream.writeBytes(2, m4246q());
        }
        if ((this.f2606b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f2609e);
        }
        if ((this.f2606b & 8) == 8) {
            codedOutputStream.writeMessage(4, this.f2610f);
        }
        if ((this.f2606b & 16) == 16) {
            codedOutputStream.writeMessage(5, this.f2611g);
        }
        if ((this.f2606b & 32) == 32) {
            codedOutputStream.writeInt64(6, this.f2612h);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2614j;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2606b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2607c) : 0;
            if ((this.f2606b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m4246q());
            }
            if ((this.f2606b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f2609e);
            }
            if ((this.f2606b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(4, this.f2610f);
            }
            if ((this.f2606b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(5, this.f2611g);
            }
            if ((this.f2606b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(6, this.f2612h);
            }
            this.f2614j = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0870cx m4239a(byte[] bArr) {
        return ((C0871cy) newBuilder().mergeFrom(bArr)).m4267m();
    }

    public static C0871cy newBuilder() {
        return C0871cy.m4266l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0871cy newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0871cy m4240a(C0870cx c0870cx) {
        return newBuilder().mergeFrom(c0870cx);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0871cy toBuilder() {
        return m4240a(this);
    }

    static {
        f2605a.m4247r();
    }
}
