package com.sec.p043a.p044a.p045a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.l */
/* loaded from: classes.dex */
public final class C0760l extends GeneratedMessageLite implements InterfaceC0762n {

    /* renamed from: a */
    private static final C0760l f1801a = new C0760l(true);

    /* renamed from: b */
    private int f1802b;

    /* renamed from: c */
    private int f1803c;

    /* renamed from: d */
    private Object f1804d;

    /* renamed from: e */
    private byte f1805e;

    /* renamed from: f */
    private int f1806f;

    private C0760l(C0761m c0761m) {
        super(c0761m);
        this.f1805e = (byte) -1;
        this.f1806f = -1;
    }

    private C0760l(boolean z) {
        this.f1805e = (byte) -1;
        this.f1806f = -1;
    }

    /* renamed from: a */
    public static C0760l m2641a() {
        return f1801a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0760l getDefaultInstanceForType() {
        return f1801a;
    }

    /* renamed from: c */
    public boolean m2649c() {
        return (this.f1802b & 1) == 1;
    }

    /* renamed from: d */
    public int m2650d() {
        return this.f1803c;
    }

    /* renamed from: e */
    public boolean m2651e() {
        return (this.f1802b & 2) == 2;
    }

    /* renamed from: f */
    public String m2652f() {
        Object obj = this.f1804d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1804d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m2646i() {
        Object obj = this.f1804d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1804d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: j */
    private void m2647j() {
        this.f1803c = 0;
        this.f1804d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1805e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1805e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1802b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f1803c);
        }
        if ((this.f1802b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2646i());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f1806f;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f1802b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f1803c) : 0;
            if ((this.f1802b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m2646i());
            }
            this.f1806f = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0760l m2642a(byte[] bArr) {
        return ((C0761m) newBuilder().mergeFrom(bArr)).m2659i();
    }

    public static C0761m newBuilder() {
        return C0761m.m2658h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0761m newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0761m m2643a(C0760l c0760l) {
        return newBuilder().mergeFrom(c0760l);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0761m toBuilder() {
        return m2643a(this);
    }

    static {
        f1801a.m2647j();
    }
}
