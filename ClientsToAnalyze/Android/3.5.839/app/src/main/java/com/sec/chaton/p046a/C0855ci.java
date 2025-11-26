package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ci */
/* loaded from: classes.dex */
public final class C0855ci extends GeneratedMessageLite implements InterfaceC0857ck {

    /* renamed from: a */
    private static final C0855ci f2504a = new C0855ci(true);

    /* renamed from: b */
    private int f2505b;

    /* renamed from: c */
    private Object f2506c;

    /* renamed from: d */
    private Object f2507d;

    /* renamed from: e */
    private Object f2508e;

    /* renamed from: f */
    private C0867cu f2509f;

    /* renamed from: g */
    private long f2510g;

    /* renamed from: h */
    private long f2511h;

    /* renamed from: i */
    private long f2512i;

    /* renamed from: j */
    private byte f2513j;

    /* renamed from: k */
    private int f2514k;

    private C0855ci(C0856cj c0856cj) {
        super(c0856cj);
        this.f2513j = (byte) -1;
        this.f2514k = -1;
    }

    private C0855ci(boolean z) {
        this.f2513j = (byte) -1;
        this.f2514k = -1;
    }

    /* renamed from: a */
    public static C0855ci m3965a() {
        return f2504a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0855ci getDefaultInstanceForType() {
        return f2504a;
    }

    /* renamed from: c */
    public boolean m3979c() {
        return (this.f2505b & 1) == 1;
    }

    /* renamed from: d */
    public String m3980d() {
        Object obj = this.f2506c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2506c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m3974s() {
        Object obj = this.f2506c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2506c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m3981e() {
        return (this.f2505b & 2) == 2;
    }

    /* renamed from: f */
    public String m3982f() {
        Object obj = this.f2507d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2507d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m3975t() {
        Object obj = this.f2507d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2507d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m3983g() {
        return (this.f2505b & 4) == 4;
    }

    /* renamed from: h */
    public String m3984h() {
        Object obj = this.f2508e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2508e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m3976u() {
        Object obj = this.f2508e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2508e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m3985i() {
        return (this.f2505b & 8) == 8;
    }

    /* renamed from: j */
    public C0867cu m3986j() {
        return this.f2509f;
    }

    /* renamed from: k */
    public boolean m3987k() {
        return (this.f2505b & 16) == 16;
    }

    /* renamed from: l */
    public long m3988l() {
        return this.f2510g;
    }

    /* renamed from: m */
    public boolean m3989m() {
        return (this.f2505b & 32) == 32;
    }

    /* renamed from: n */
    public long m3990n() {
        return this.f2511h;
    }

    /* renamed from: o */
    public boolean m3991o() {
        return (this.f2505b & 64) == 64;
    }

    /* renamed from: p */
    public long m3992p() {
        return this.f2512i;
    }

    /* renamed from: v */
    private void m3977v() {
        this.f2506c = "";
        this.f2507d = "";
        this.f2508e = "";
        this.f2509f = C0867cu.m4191a();
        this.f2510g = 0L;
        this.f2511h = 0L;
        this.f2512i = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2513j;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2513j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2505b & 1) == 1) {
            codedOutputStream.writeBytes(1, m3974s());
        }
        if ((this.f2505b & 2) == 2) {
            codedOutputStream.writeBytes(2, m3975t());
        }
        if ((this.f2505b & 4) == 4) {
            codedOutputStream.writeBytes(3, m3976u());
        }
        if ((this.f2505b & 8) == 8) {
            codedOutputStream.writeMessage(4, this.f2509f);
        }
        if ((this.f2505b & 16) == 16) {
            codedOutputStream.writeInt64(5, this.f2510g);
        }
        if ((this.f2505b & 32) == 32) {
            codedOutputStream.writeInt64(6, this.f2511h);
        }
        if ((this.f2505b & 64) == 64) {
            codedOutputStream.writeInt64(7, this.f2512i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f2514k;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f2505b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m3974s()) : 0;
            if ((this.f2505b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m3975t());
            }
            if ((this.f2505b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(3, m3976u());
            }
            if ((this.f2505b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeMessageSize(4, this.f2509f);
            }
            if ((this.f2505b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(5, this.f2510g);
            }
            if ((this.f2505b & 32) == 32) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(6, this.f2511h);
            }
            if ((this.f2505b & 64) == 64) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(7, this.f2512i);
            }
            this.f2514k = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0855ci m3966a(byte[] bArr) {
        return ((C0856cj) newBuilder().mergeFrom(bArr)).m3999k();
    }

    public static C0856cj newBuilder() {
        return C0856cj.m3998j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0856cj newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0856cj m3967a(C0855ci c0855ci) {
        return newBuilder().mergeFrom(c0855ci);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0856cj toBuilder() {
        return m3967a(this);
    }

    static {
        f2504a.m3977v();
    }
}
