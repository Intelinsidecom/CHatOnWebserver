package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.i */
/* loaded from: classes.dex */
public final class C0090i extends GeneratedMessageLite implements InterfaceC0102u {

    /* renamed from: a */
    private static final C0090i f134a = new C0090i(true);

    /* renamed from: b */
    private int f135b;

    /* renamed from: c */
    private int f136c;

    /* renamed from: d */
    private int f137d;

    /* renamed from: e */
    private Object f138e;

    /* renamed from: f */
    private Object f139f;

    /* renamed from: g */
    private byte f140g;

    /* renamed from: h */
    private int f141h;

    private C0090i(C0106y c0106y) {
        super(c0106y);
        this.f140g = (byte) -1;
        this.f141h = -1;
    }

    private C0090i(boolean z) {
        this.f140g = (byte) -1;
        this.f141h = -1;
    }

    /* renamed from: a */
    public static C0090i m373a() {
        return f134a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0090i getDefaultInstanceForType() {
        return f134a;
    }

    /* renamed from: c */
    public boolean m384c() {
        return (this.f135b & 1) == 1;
    }

    /* renamed from: d */
    public int m385d() {
        return this.f136c;
    }

    /* renamed from: e */
    public boolean m386e() {
        return (this.f135b & 2) == 2;
    }

    /* renamed from: f */
    public int m387f() {
        return this.f137d;
    }

    /* renamed from: g */
    public boolean m388g() {
        return (this.f135b & 4) == 4;
    }

    /* renamed from: h */
    public String m389h() {
        Object obj = this.f138e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f138e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m380m() {
        Object obj = this.f138e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f138e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m390i() {
        return (this.f135b & 8) == 8;
    }

    /* renamed from: j */
    public String m391j() {
        Object obj = this.f139f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f139f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m381n() {
        Object obj = this.f139f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f139f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    private void m382o() {
        this.f136c = 0;
        this.f137d = 0;
        this.f138e = "";
        this.f139f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f140g;
        if (b != -1) {
            return b == 1;
        }
        this.f140g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f135b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f136c);
        }
        if ((this.f135b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f137d);
        }
        if ((this.f135b & 4) == 4) {
            codedOutputStream.writeBytes(3, m380m());
        }
        if ((this.f135b & 8) == 8) {
            codedOutputStream.writeBytes(4, m381n());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f141h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f135b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f136c) : 0;
            if ((this.f135b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f137d);
            }
            if ((this.f135b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m380m());
            }
            if ((this.f135b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m381n());
            }
            this.f141h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0090i m374a(byte[] bArr) {
        return ((C0106y) newBuilder().mergeFrom(bArr)).m566i();
    }

    public static C0106y newBuilder() {
        return C0106y.m565h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0106y newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0106y m375a(C0090i c0090i) {
        return newBuilder().mergeFrom(c0090i);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0106y toBuilder() {
        return m375a(this);
    }

    static {
        f134a.m382o();
    }
}
