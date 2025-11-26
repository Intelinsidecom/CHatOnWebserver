package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fq */
/* loaded from: classes.dex */
public final class C0944fq extends GeneratedMessageLite implements InterfaceC0946fs {

    /* renamed from: a */
    private static final C0944fq f2995a = new C0944fq(true);

    /* renamed from: b */
    private int f2996b;

    /* renamed from: c */
    private long f2997c;

    /* renamed from: d */
    private Object f2998d;

    /* renamed from: e */
    private List<C0953fz> f2999e;

    /* renamed from: f */
    private C0957gc f3000f;

    /* renamed from: g */
    private long f3001g;

    /* renamed from: h */
    private byte f3002h;

    /* renamed from: i */
    private int f3003i;

    private C0944fq(C0945fr c0945fr) {
        super(c0945fr);
        this.f3002h = (byte) -1;
        this.f3003i = -1;
    }

    private C0944fq(boolean z) {
        this.f3002h = (byte) -1;
        this.f3003i = -1;
    }

    /* renamed from: a */
    public static C0944fq m5340a() {
        return f2995a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0944fq getDefaultInstanceForType() {
        return f2995a;
    }

    /* renamed from: c */
    public boolean m5351c() {
        return (this.f2996b & 1) == 1;
    }

    /* renamed from: d */
    public long m5352d() {
        return this.f2997c;
    }

    /* renamed from: e */
    public boolean m5353e() {
        return (this.f2996b & 2) == 2;
    }

    /* renamed from: f */
    public String m5354f() {
        Object obj = this.f2998d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2998d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m5348n() {
        Object obj = this.f2998d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2998d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public List<C0953fz> m5355g() {
        return this.f2999e;
    }

    /* renamed from: h */
    public boolean m5356h() {
        return (this.f2996b & 4) == 4;
    }

    /* renamed from: i */
    public C0957gc m5357i() {
        return this.f3000f;
    }

    /* renamed from: j */
    public boolean m5358j() {
        return (this.f2996b & 8) == 8;
    }

    /* renamed from: k */
    public long m5359k() {
        return this.f3001g;
    }

    /* renamed from: o */
    private void m5349o() {
        this.f2997c = 0L;
        this.f2998d = "";
        this.f2999e = Collections.emptyList();
        this.f3000f = C0957gc.m5553a();
        this.f3001g = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3002h;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3002h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2996b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2997c);
        }
        if ((this.f2996b & 2) == 2) {
            codedOutputStream.writeBytes(2, m5348n());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2999e.size()) {
                break;
            }
            codedOutputStream.writeMessage(3, this.f2999e.get(i2));
            i = i2 + 1;
        }
        if ((this.f2996b & 4) == 4) {
            codedOutputStream.writeMessage(4, this.f3000f);
        }
        if ((this.f2996b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f3001g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeInt64Size = this.f3003i;
        if (iComputeInt64Size == -1) {
            int iComputeInt64Size2 = (this.f2996b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2997c) + 0 : 0;
            if ((this.f2996b & 2) == 2) {
                iComputeInt64Size2 += CodedOutputStream.computeBytesSize(2, m5348n());
            }
            while (true) {
                iComputeInt64Size = iComputeInt64Size2;
                if (i >= this.f2999e.size()) {
                    break;
                }
                iComputeInt64Size2 = CodedOutputStream.computeMessageSize(3, this.f2999e.get(i)) + iComputeInt64Size;
                i++;
            }
            if ((this.f2996b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(4, this.f3000f);
            }
            if ((this.f2996b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(5, this.f3001g);
            }
            this.f3003i = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0944fq m5341a(byte[] bArr) {
        return ((C0945fr) newBuilder().mergeFrom(bArr)).m5366k();
    }

    public static C0945fr newBuilder() {
        return C0945fr.m5365j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0945fr newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0945fr m5342a(C0944fq c0944fq) {
        return newBuilder().mergeFrom(c0944fq);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0945fr toBuilder() {
        return m5342a(this);
    }

    static {
        f2995a.m5349o();
    }
}
