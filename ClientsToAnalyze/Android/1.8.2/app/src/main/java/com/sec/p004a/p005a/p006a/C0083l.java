package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.l */
/* loaded from: classes.dex */
public final class C0083l extends GeneratedMessageLite implements InterfaceC0085n {

    /* renamed from: a */
    private static final C0083l f142a = new C0083l(true);

    /* renamed from: b */
    private int f143b;

    /* renamed from: c */
    private int f144c;

    /* renamed from: d */
    private Object f145d;

    /* renamed from: e */
    private byte f146e;

    /* renamed from: f */
    private int f147f;

    private C0083l(C0084m c0084m) {
        super(c0084m);
        this.f146e = (byte) -1;
        this.f147f = -1;
    }

    private C0083l(boolean z) {
        this.f146e = (byte) -1;
        this.f147f = -1;
    }

    /* renamed from: a */
    public static C0083l m397a() {
        return f142a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0083l getDefaultInstanceForType() {
        return f142a;
    }

    /* renamed from: c */
    public boolean m405c() {
        return (this.f143b & 1) == 1;
    }

    /* renamed from: d */
    public int m406d() {
        return this.f144c;
    }

    /* renamed from: e */
    public boolean m407e() {
        return (this.f143b & 2) == 2;
    }

    /* renamed from: f */
    public String m408f() {
        Object obj = this.f145d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f145d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m402i() {
        Object obj = this.f145d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f145d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: j */
    private void m403j() {
        this.f144c = 0;
        this.f145d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f146e;
        if (b != -1) {
            return b == 1;
        }
        this.f146e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f143b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f144c);
        }
        if ((this.f143b & 2) == 2) {
            codedOutputStream.writeBytes(2, m402i());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f147f;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f143b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f144c) : 0;
            if ((this.f143b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m402i());
            }
            this.f147f = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0083l m398a(byte[] bArr) {
        return ((C0084m) newBuilder().mergeFrom(bArr)).m415i();
    }

    public static C0084m newBuilder() {
        return C0084m.m414h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0084m newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0084m m399a(C0083l c0083l) {
        return newBuilder().mergeFrom(c0083l);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0084m toBuilder() {
        return m399a(this);
    }

    static {
        f142a.m403j();
    }
}
