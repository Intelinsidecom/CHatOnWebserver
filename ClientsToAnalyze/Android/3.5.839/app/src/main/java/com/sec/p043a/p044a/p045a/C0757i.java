package com.sec.p043a.p044a.p045a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.i */
/* loaded from: classes.dex */
public final class C0757i extends GeneratedMessageLite implements InterfaceC0759k {

    /* renamed from: a */
    private static final C0757i f1790a = new C0757i(true);

    /* renamed from: b */
    private int f1791b;

    /* renamed from: c */
    private int f1792c;

    /* renamed from: d */
    private int f1793d;

    /* renamed from: e */
    private Object f1794e;

    /* renamed from: f */
    private byte f1795f;

    /* renamed from: g */
    private int f1796g;

    private C0757i(C0758j c0758j) {
        super(c0758j);
        this.f1795f = (byte) -1;
        this.f1796g = -1;
    }

    private C0757i(boolean z) {
        this.f1795f = (byte) -1;
        this.f1796g = -1;
    }

    /* renamed from: a */
    public static C0757i m2608a() {
        return f1790a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0757i getDefaultInstanceForType() {
        return f1790a;
    }

    /* renamed from: c */
    public boolean m2617c() {
        return (this.f1791b & 1) == 1;
    }

    /* renamed from: d */
    public int m2618d() {
        return this.f1792c;
    }

    /* renamed from: e */
    public boolean m2619e() {
        return (this.f1791b & 2) == 2;
    }

    /* renamed from: f */
    public int m2620f() {
        return this.f1793d;
    }

    /* renamed from: g */
    public boolean m2621g() {
        return (this.f1791b & 4) == 4;
    }

    /* renamed from: h */
    public String m2622h() {
        Object obj = this.f1794e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1794e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m2614k() {
        Object obj = this.f1794e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1794e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m2615l() {
        this.f1792c = 0;
        this.f1793d = 0;
        this.f1794e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1795f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1795f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1791b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f1792c);
        }
        if ((this.f1791b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f1793d);
        }
        if ((this.f1791b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2614k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f1796g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f1791b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f1792c) : 0;
            if ((this.f1791b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f1793d);
            }
            if ((this.f1791b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m2614k());
            }
            this.f1796g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0757i m2609a(byte[] bArr) {
        return ((C0758j) newBuilder().mergeFrom(bArr)).m2629i();
    }

    public static C0758j newBuilder() {
        return C0758j.m2628h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0758j newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0758j m2610a(C0757i c0757i) {
        return newBuilder().mergeFrom(c0757i);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0758j toBuilder() {
        return m2610a(this);
    }

    static {
        f1790a.m2615l();
    }
}
