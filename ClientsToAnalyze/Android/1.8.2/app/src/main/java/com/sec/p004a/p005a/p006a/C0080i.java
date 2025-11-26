package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.i */
/* loaded from: classes.dex */
public final class C0080i extends GeneratedMessageLite implements InterfaceC0082k {

    /* renamed from: a */
    private static final C0080i f131a = new C0080i(true);

    /* renamed from: b */
    private int f132b;

    /* renamed from: c */
    private int f133c;

    /* renamed from: d */
    private int f134d;

    /* renamed from: e */
    private Object f135e;

    /* renamed from: f */
    private byte f136f;

    /* renamed from: g */
    private int f137g;

    private C0080i(C0081j c0081j) {
        super(c0081j);
        this.f136f = (byte) -1;
        this.f137g = -1;
    }

    private C0080i(boolean z) {
        this.f136f = (byte) -1;
        this.f137g = -1;
    }

    /* renamed from: a */
    public static C0080i m364a() {
        return f131a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0080i getDefaultInstanceForType() {
        return f131a;
    }

    /* renamed from: c */
    public boolean m373c() {
        return (this.f132b & 1) == 1;
    }

    /* renamed from: d */
    public int m374d() {
        return this.f133c;
    }

    /* renamed from: e */
    public boolean m375e() {
        return (this.f132b & 2) == 2;
    }

    /* renamed from: f */
    public int m376f() {
        return this.f134d;
    }

    /* renamed from: g */
    public boolean m377g() {
        return (this.f132b & 4) == 4;
    }

    /* renamed from: h */
    public String m378h() {
        Object obj = this.f135e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f135e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m370k() {
        Object obj = this.f135e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f135e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m371l() {
        this.f133c = 0;
        this.f134d = 0;
        this.f135e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f136f;
        if (b != -1) {
            return b == 1;
        }
        this.f136f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f132b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f133c);
        }
        if ((this.f132b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f134d);
        }
        if ((this.f132b & 4) == 4) {
            codedOutputStream.writeBytes(3, m370k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f137g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f132b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f133c) : 0;
            if ((this.f132b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f134d);
            }
            if ((this.f132b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m370k());
            }
            this.f137g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0080i m365a(byte[] bArr) {
        return ((C0081j) newBuilder().mergeFrom(bArr)).m385i();
    }

    public static C0081j newBuilder() {
        return C0081j.m384h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0081j newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0081j m366a(C0080i c0080i) {
        return newBuilder().mergeFrom(c0080i);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0081j toBuilder() {
        return m366a(this);
    }

    static {
        f131a.m371l();
    }
}
