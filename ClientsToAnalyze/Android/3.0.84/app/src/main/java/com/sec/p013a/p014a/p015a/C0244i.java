package com.sec.p013a.p014a.p015a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.i */
/* loaded from: classes.dex */
public final class C0244i extends GeneratedMessageLite implements InterfaceC0246k {

    /* renamed from: a */
    private static final C0244i f554a = new C0244i(true);

    /* renamed from: b */
    private int f555b;

    /* renamed from: c */
    private int f556c;

    /* renamed from: d */
    private int f557d;

    /* renamed from: e */
    private Object f558e;

    /* renamed from: f */
    private byte f559f;

    /* renamed from: g */
    private int f560g;

    private C0244i(C0245j c0245j) {
        super(c0245j);
        this.f559f = (byte) -1;
        this.f560g = -1;
    }

    private C0244i(boolean z) {
        this.f559f = (byte) -1;
        this.f560g = -1;
    }

    /* renamed from: a */
    public static C0244i m876a() {
        return f554a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0244i getDefaultInstanceForType() {
        return f554a;
    }

    /* renamed from: c */
    public boolean m885c() {
        return (this.f555b & 1) == 1;
    }

    /* renamed from: d */
    public int m886d() {
        return this.f556c;
    }

    /* renamed from: e */
    public boolean m887e() {
        return (this.f555b & 2) == 2;
    }

    /* renamed from: f */
    public int m888f() {
        return this.f557d;
    }

    /* renamed from: g */
    public boolean m889g() {
        return (this.f555b & 4) == 4;
    }

    /* renamed from: h */
    public String m890h() {
        Object obj = this.f558e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f558e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m882k() {
        Object obj = this.f558e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f558e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m883l() {
        this.f556c = 0;
        this.f557d = 0;
        this.f558e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f559f;
        if (b != -1) {
            return b == 1;
        }
        this.f559f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f555b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f556c);
        }
        if ((this.f555b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f557d);
        }
        if ((this.f555b & 4) == 4) {
            codedOutputStream.writeBytes(3, m882k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f560g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f555b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f556c) : 0;
            if ((this.f555b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f557d);
            }
            if ((this.f555b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m882k());
            }
            this.f560g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0244i m877a(byte[] bArr) {
        return ((C0245j) newBuilder().mergeFrom(bArr)).m897i();
    }

    public static C0245j newBuilder() {
        return C0245j.m896h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0245j newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0245j m878a(C0244i c0244i) {
        return newBuilder().mergeFrom(c0244i);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0245j toBuilder() {
        return m878a(this);
    }

    static {
        f554a.m883l();
    }
}
